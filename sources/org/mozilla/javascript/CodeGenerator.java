package org.mozilla.javascript;

import androidx.core.view.InputDeviceCompat;
import org.mozilla.javascript.ObjToIntMap;
import org.mozilla.javascript.ast.AstRoot;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.ScriptNode;

/* loaded from: classes5.dex */
class CodeGenerator extends Icode {
    private static final int ECF_TAIL = 1;
    private static final int MIN_FIXUP_TABLE_SIZE = 40;
    private static final int MIN_LABEL_TABLE_SIZE = 32;
    private CompilerEnvirons compilerEnv;
    private int doubleTableTop;
    private int exceptionTableTop;
    private long[] fixupTable;
    private int fixupTableTop;
    private int iCodeTop;
    private InterpreterData itsData;
    private boolean itsInFunctionFlag;
    private boolean itsInTryFlag;
    private int[] labelTable;
    private int labelTableTop;
    private int lineNumber;
    private int localTop;
    private ScriptNode scriptOrFn;
    private int stackDepth;
    private ObjToIntMap strings = new ObjToIntMap(20);
    private ObjArray literalIds = new ObjArray();

    public InterpreterData compile(CompilerEnvirons compilerEnvirons, ScriptNode scriptNode, String str, boolean z) {
        this.compilerEnv = compilerEnvirons;
        new NodeTransformer().transform(scriptNode);
        if (z) {
            this.scriptOrFn = scriptNode.getFunctionNode(0);
        } else {
            this.scriptOrFn = scriptNode;
        }
        InterpreterData interpreterData = new InterpreterData(compilerEnvirons.getLanguageVersion(), this.scriptOrFn.getSourceName(), str, ((AstRoot) scriptNode).isInStrictMode());
        this.itsData = interpreterData;
        interpreterData.topLevel = true;
        if (z) {
            generateFunctionICode();
        } else {
            generateICodeFromTree(this.scriptOrFn);
        }
        return this.itsData;
    }

    private void generateFunctionICode() {
        this.itsInFunctionFlag = true;
        FunctionNode functionNode = (FunctionNode) this.scriptOrFn;
        this.itsData.itsFunctionType = functionNode.getFunctionType();
        this.itsData.itsNeedsActivation = functionNode.requiresActivation();
        if (functionNode.getFunctionName() != null) {
            this.itsData.itsName = functionNode.getName();
        }
        if (functionNode.isGenerator()) {
            addIcode(-62);
            addUint16(functionNode.getBaseLineno() & 65535);
        }
        generateICodeFromTree(functionNode.getLastChild());
    }

    private void generateICodeFromTree(Node node) {
        generateNestedFunctions();
        generateRegExpLiterals();
        visitStatement(node, 0);
        fixLabelGotos();
        if (this.itsData.itsFunctionType == 0) {
            addToken(64);
        }
        int length = this.itsData.itsICode.length;
        int i = this.iCodeTop;
        if (length != i) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.itsData.itsICode, 0, bArr, 0, this.iCodeTop);
            this.itsData.itsICode = bArr;
        }
        if (this.strings.size() == 0) {
            this.itsData.itsStringTable = null;
        } else {
            this.itsData.itsStringTable = new String[this.strings.size()];
            ObjToIntMap.Iterator newIterator = this.strings.newIterator();
            newIterator.start();
            while (!newIterator.done()) {
                String str = (String) newIterator.getKey();
                int value = newIterator.getValue();
                if (this.itsData.itsStringTable[value] != null) {
                    Kit.codeBug();
                }
                this.itsData.itsStringTable[value] = str;
                newIterator.next();
            }
        }
        if (this.doubleTableTop == 0) {
            this.itsData.itsDoubleTable = null;
        } else {
            int length2 = this.itsData.itsDoubleTable.length;
            int i2 = this.doubleTableTop;
            if (length2 != i2) {
                double[] dArr = new double[i2];
                System.arraycopy(this.itsData.itsDoubleTable, 0, dArr, 0, this.doubleTableTop);
                this.itsData.itsDoubleTable = dArr;
            }
        }
        if (this.exceptionTableTop != 0) {
            int length3 = this.itsData.itsExceptionTable.length;
            int i3 = this.exceptionTableTop;
            if (length3 != i3) {
                int[] iArr = new int[i3];
                System.arraycopy(this.itsData.itsExceptionTable, 0, iArr, 0, this.exceptionTableTop);
                this.itsData.itsExceptionTable = iArr;
            }
        }
        this.itsData.itsMaxVars = this.scriptOrFn.getParamAndVarCount();
        InterpreterData interpreterData = this.itsData;
        interpreterData.itsMaxFrameArray = interpreterData.itsMaxVars + this.itsData.itsMaxLocals + this.itsData.itsMaxStack;
        this.itsData.argNames = this.scriptOrFn.getParamAndVarNames();
        this.itsData.argIsConst = this.scriptOrFn.getParamAndVarConst();
        this.itsData.argCount = this.scriptOrFn.getParamCount();
        this.itsData.encodedSourceStart = this.scriptOrFn.getEncodedSourceStart();
        this.itsData.encodedSourceEnd = this.scriptOrFn.getEncodedSourceEnd();
        if (this.literalIds.size() != 0) {
            this.itsData.literalIds = this.literalIds.toArray();
        }
    }

    private void generateNestedFunctions() {
        int functionCount = this.scriptOrFn.getFunctionCount();
        if (functionCount == 0) {
            return;
        }
        InterpreterData[] interpreterDataArr = new InterpreterData[functionCount];
        for (int i = 0; i != functionCount; i++) {
            FunctionNode functionNode = this.scriptOrFn.getFunctionNode(i);
            CodeGenerator codeGenerator = new CodeGenerator();
            codeGenerator.compilerEnv = this.compilerEnv;
            codeGenerator.scriptOrFn = functionNode;
            codeGenerator.itsData = new InterpreterData(this.itsData);
            codeGenerator.generateFunctionICode();
            interpreterDataArr[i] = codeGenerator.itsData;
        }
        this.itsData.itsNestedFunctions = interpreterDataArr;
    }

    private void generateRegExpLiterals() {
        int regexpCount = this.scriptOrFn.getRegexpCount();
        if (regexpCount == 0) {
            return;
        }
        Context context = Context.getContext();
        RegExpProxy checkRegExpProxy = ScriptRuntime.checkRegExpProxy(context);
        Object[] objArr = new Object[regexpCount];
        for (int i = 0; i != regexpCount; i++) {
            objArr[i] = checkRegExpProxy.compileRegExp(context, this.scriptOrFn.getRegexpString(i), this.scriptOrFn.getRegexpFlags(i));
        }
        this.itsData.itsRegExpLiterals = objArr;
    }

    private void updateLineNumber(Node node) {
        int lineno = node.getLineno();
        if (lineno == this.lineNumber || lineno < 0) {
            return;
        }
        if (this.itsData.firstLinePC < 0) {
            this.itsData.firstLinePC = lineno;
        }
        this.lineNumber = lineno;
        addIcode(-26);
        addUint16(lineno & 65535);
    }

    private RuntimeException badTree(Node node) {
        throw new RuntimeException(node.toString());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0169 A[LOOP:0: B:63:0x0167->B:64:0x0169, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void visitStatement(org.mozilla.javascript.Node r14, int r15) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.CodeGenerator.visitStatement(org.mozilla.javascript.Node, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0238  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void visitExpression(org.mozilla.javascript.Node r14, int r15) {
        /*
            Method dump skipped, instructions count: 1216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.CodeGenerator.visitExpression(org.mozilla.javascript.Node, int):void");
    }

    private void generateCallFunAndThis(Node node) {
        int type = node.getType();
        if (type != 33 && type != 36) {
            if (type == 39) {
                addStringOp(-15, node.getString());
                stackChange(2);
                return;
            }
            visitExpression(node, 0);
            addIcode(-18);
            stackChange(1);
            return;
        }
        Node firstChild = node.getFirstChild();
        visitExpression(firstChild, 0);
        Node next = firstChild.getNext();
        if (type == 33) {
            addStringOp(-16, next.getString());
            stackChange(1);
            return;
        }
        visitExpression(next, 0);
        addIcode(-17);
    }

    private void visitIncDec(Node node, Node node2) {
        int existingIntProp = node.getExistingIntProp(13);
        int type = node2.getType();
        if (type == 33) {
            Node firstChild = node2.getFirstChild();
            visitExpression(firstChild, 0);
            addStringOp(-9, firstChild.getNext().getString());
            addUint8(existingIntProp);
        } else if (type == 36) {
            Node firstChild2 = node2.getFirstChild();
            visitExpression(firstChild2, 0);
            visitExpression(firstChild2.getNext(), 0);
            addIcode(-10);
            addUint8(existingIntProp);
            stackChange(-1);
        } else if (type == 39) {
            addStringOp(-8, node2.getString());
            addUint8(existingIntProp);
            stackChange(1);
        } else if (type != 55) {
            if (type == 67) {
                visitExpression(node2.getFirstChild(), 0);
                addIcode(-11);
                addUint8(existingIntProp);
                return;
            }
            throw badTree(node);
        } else {
            if (this.itsData.itsNeedsActivation) {
                Kit.codeBug();
            }
            addVarOp(-7, this.scriptOrFn.getIndexForNameNode(node2));
            addUint8(existingIntProp);
            stackChange(1);
        }
    }

    private void visitLiteral(Node node, Node node2) {
        Object[] objArr;
        int length;
        int type = node.getType();
        if (type == 65) {
            length = 0;
            for (Node node3 = node2; node3 != null; node3 = node3.getNext()) {
                length++;
            }
            objArr = null;
        } else if (type == 66) {
            objArr = (Object[]) node.getProp(12);
            length = objArr.length;
        } else {
            throw badTree(node);
        }
        addIndexOp(-29, length);
        stackChange(2);
        while (node2 != null) {
            int type2 = node2.getType();
            if (type2 == 151) {
                visitExpression(node2.getFirstChild(), 0);
                addIcode(-57);
            } else if (type2 == 152) {
                visitExpression(node2.getFirstChild(), 0);
                addIcode(-58);
            } else {
                visitExpression(node2, 0);
                addIcode(-30);
            }
            stackChange(-1);
            node2 = node2.getNext();
        }
        if (type == 65) {
            int[] iArr = (int[]) node.getProp(11);
            if (iArr == null) {
                addToken(65);
            } else {
                int size = this.literalIds.size();
                this.literalIds.add(iArr);
                addIndexOp(-31, size);
            }
        } else {
            int size2 = this.literalIds.size();
            this.literalIds.add(objArr);
            addIndexOp(66, size2);
        }
        stackChange(-1);
    }

    private void visitArrayComprehension(Node node, Node node2, Node node3) {
        visitStatement(node2, this.stackDepth);
        visitExpression(node3, 0);
    }

    private int getLocalBlockRef(Node node) {
        return ((Node) node.getProp(3)).getExistingIntProp(2);
    }

    private int getTargetLabel(Node node) {
        int labelId = node.labelId();
        if (labelId != -1) {
            return labelId;
        }
        int i = this.labelTableTop;
        int[] iArr = this.labelTable;
        if (iArr == null || i == iArr.length) {
            if (iArr == null) {
                this.labelTable = new int[32];
            } else {
                int[] iArr2 = new int[iArr.length * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                this.labelTable = iArr2;
            }
        }
        this.labelTableTop = i + 1;
        this.labelTable[i] = -1;
        node.labelId(i);
        return i;
    }

    private void markTargetLabel(Node node) {
        int targetLabel = getTargetLabel(node);
        if (this.labelTable[targetLabel] != -1) {
            Kit.codeBug();
        }
        this.labelTable[targetLabel] = this.iCodeTop;
    }

    private void addGoto(Node node, int i) {
        int targetLabel = getTargetLabel(node);
        if (targetLabel >= this.labelTableTop) {
            Kit.codeBug();
        }
        int i2 = this.labelTable[targetLabel];
        if (i2 != -1) {
            addBackwardGoto(i, i2);
            return;
        }
        int i3 = this.iCodeTop;
        addGotoOp(i);
        int i4 = this.fixupTableTop;
        long[] jArr = this.fixupTable;
        if (jArr == null || i4 == jArr.length) {
            if (jArr == null) {
                this.fixupTable = new long[40];
            } else {
                long[] jArr2 = new long[jArr.length * 2];
                System.arraycopy(jArr, 0, jArr2, 0, i4);
                this.fixupTable = jArr2;
            }
        }
        this.fixupTableTop = i4 + 1;
        this.fixupTable[i4] = (targetLabel << 32) | i3;
    }

    private void fixLabelGotos() {
        for (int i = 0; i < this.fixupTableTop; i++) {
            long j = this.fixupTable[i];
            int i2 = (int) j;
            int i3 = this.labelTable[(int) (j >> 32)];
            if (i3 == -1) {
                throw Kit.codeBug();
            }
            resolveGoto(i2, i3);
        }
        this.fixupTableTop = 0;
    }

    private void addBackwardGoto(int i, int i2) {
        int i3 = this.iCodeTop;
        if (i3 <= i2) {
            throw Kit.codeBug();
        }
        addGotoOp(i);
        resolveGoto(i3, i2);
    }

    private void resolveForwardGoto(int i) {
        int i2 = this.iCodeTop;
        if (i2 < i + 3) {
            throw Kit.codeBug();
        }
        resolveGoto(i, i2);
    }

    private void resolveGoto(int i, int i2) {
        int i3 = i2 - i;
        if (i3 >= 0 && i3 <= 2) {
            throw Kit.codeBug();
        }
        int i4 = i + 1;
        if (i3 != ((short) i3)) {
            if (this.itsData.longJumps == null) {
                this.itsData.longJumps = new UintMap();
            }
            this.itsData.longJumps.put(i4, i2);
            i3 = 0;
        }
        byte[] bArr = this.itsData.itsICode;
        bArr[i4] = (byte) (i3 >> 8);
        bArr[i4 + 1] = (byte) i3;
    }

    private void addToken(int i) {
        if (!Icode.validTokenCode(i)) {
            throw Kit.codeBug();
        }
        addUint8(i);
    }

    private void addIcode(int i) {
        if (!Icode.validIcode(i)) {
            throw Kit.codeBug();
        }
        addUint8(i & 255);
    }

    private void addUint8(int i) {
        if ((i & InputDeviceCompat.SOURCE_ANY) != 0) {
            throw Kit.codeBug();
        }
        byte[] bArr = this.itsData.itsICode;
        int i2 = this.iCodeTop;
        if (i2 == bArr.length) {
            bArr = increaseICodeCapacity(1);
        }
        bArr[i2] = (byte) i;
        this.iCodeTop = i2 + 1;
    }

    private void addUint16(int i) {
        if (((-65536) & i) != 0) {
            throw Kit.codeBug();
        }
        byte[] bArr = this.itsData.itsICode;
        int i2 = this.iCodeTop;
        int i3 = i2 + 2;
        if (i3 > bArr.length) {
            bArr = increaseICodeCapacity(2);
        }
        bArr[i2] = (byte) (i >>> 8);
        bArr[i2 + 1] = (byte) i;
        this.iCodeTop = i3;
    }

    private void addInt(int i) {
        byte[] bArr = this.itsData.itsICode;
        int i2 = this.iCodeTop;
        int i3 = i2 + 4;
        if (i3 > bArr.length) {
            bArr = increaseICodeCapacity(4);
        }
        bArr[i2] = (byte) (i >>> 24);
        bArr[i2 + 1] = (byte) (i >>> 16);
        bArr[i2 + 2] = (byte) (i >>> 8);
        bArr[i2 + 3] = (byte) i;
        this.iCodeTop = i3;
    }

    private int getDoubleIndex(double d) {
        int i = this.doubleTableTop;
        if (i == 0) {
            this.itsData.itsDoubleTable = new double[64];
        } else if (this.itsData.itsDoubleTable.length == i) {
            double[] dArr = new double[i * 2];
            System.arraycopy(this.itsData.itsDoubleTable, 0, dArr, 0, i);
            this.itsData.itsDoubleTable = dArr;
        }
        this.itsData.itsDoubleTable[i] = d;
        this.doubleTableTop = i + 1;
        return i;
    }

    private void addGotoOp(int i) {
        byte[] bArr = this.itsData.itsICode;
        int i2 = this.iCodeTop;
        if (i2 + 3 > bArr.length) {
            bArr = increaseICodeCapacity(3);
        }
        bArr[i2] = (byte) i;
        this.iCodeTop = i2 + 1 + 2;
    }

    private void addVarOp(int i, int i2) {
        if (i != -7) {
            if (i == 156) {
                if (i2 < 128) {
                    addIcode(-61);
                    addUint8(i2);
                    return;
                }
                addIndexOp(-60, i2);
                return;
            } else if (i != 55 && i != 56) {
                throw Kit.codeBug();
            } else {
                if (i2 < 128) {
                    addIcode(i == 55 ? -48 : -49);
                    addUint8(i2);
                    return;
                }
            }
        }
        addIndexOp(i, i2);
    }

    private void addStringOp(int i, String str) {
        addStringPrefix(str);
        if (Icode.validIcode(i)) {
            addIcode(i);
        } else {
            addToken(i);
        }
    }

    private void addIndexOp(int i, int i2) {
        addIndexPrefix(i2);
        if (Icode.validIcode(i)) {
            addIcode(i);
        } else {
            addToken(i);
        }
    }

    private void addStringPrefix(String str) {
        int i = this.strings.get(str, -1);
        if (i == -1) {
            i = this.strings.size();
            this.strings.put(str, i);
        }
        if (i < 4) {
            addIcode((-41) - i);
        } else if (i <= 255) {
            addIcode(-45);
            addUint8(i);
        } else if (i <= 65535) {
            addIcode(-46);
            addUint16(i);
        } else {
            addIcode(-47);
            addInt(i);
        }
    }

    private void addIndexPrefix(int i) {
        if (i < 0) {
            Kit.codeBug();
        }
        if (i < 6) {
            addIcode((-32) - i);
        } else if (i <= 255) {
            addIcode(-38);
            addUint8(i);
        } else if (i <= 65535) {
            addIcode(-39);
            addUint16(i);
        } else {
            addIcode(-40);
            addInt(i);
        }
    }

    private void addExceptionHandler(int i, int i2, int i3, boolean z, int i4, int i5) {
        int i6 = this.exceptionTableTop;
        int[] iArr = this.itsData.itsExceptionTable;
        if (iArr == null) {
            if (i6 != 0) {
                Kit.codeBug();
            }
            iArr = new int[12];
            this.itsData.itsExceptionTable = iArr;
        } else if (iArr.length == i6) {
            iArr = new int[iArr.length * 2];
            System.arraycopy(this.itsData.itsExceptionTable, 0, iArr, 0, i6);
            this.itsData.itsExceptionTable = iArr;
        }
        iArr[i6 + 0] = i;
        iArr[i6 + 1] = i2;
        iArr[i6 + 2] = i3;
        iArr[i6 + 3] = z ? 1 : 0;
        iArr[i6 + 4] = i4;
        iArr[i6 + 5] = i5;
        this.exceptionTableTop = i6 + 6;
    }

    private byte[] increaseICodeCapacity(int i) {
        int length = this.itsData.itsICode.length;
        int i2 = this.iCodeTop;
        int i3 = i + i2;
        if (i3 <= length) {
            throw Kit.codeBug();
        }
        int i4 = length * 2;
        if (i3 <= i4) {
            i3 = i4;
        }
        byte[] bArr = new byte[i3];
        System.arraycopy(this.itsData.itsICode, 0, bArr, 0, i2);
        this.itsData.itsICode = bArr;
        return bArr;
    }

    private void stackChange(int i) {
        if (i <= 0) {
            this.stackDepth += i;
            return;
        }
        int i2 = this.stackDepth + i;
        if (i2 > this.itsData.itsMaxStack) {
            this.itsData.itsMaxStack = i2;
        }
        this.stackDepth = i2;
    }

    private int allocLocal() {
        int i = this.localTop;
        int i2 = i + 1;
        this.localTop = i2;
        if (i2 > this.itsData.itsMaxLocals) {
            this.itsData.itsMaxLocals = this.localTop;
        }
        return i;
    }

    private void releaseLocal(int i) {
        int i2 = this.localTop - 1;
        this.localTop = i2;
        if (i != i2) {
            Kit.codeBug();
        }
    }
}
