package org.mozilla.classfile;

import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import com.google.ads.interactivemedia.p034v3.internal.bqk;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.AgentOptions;
import org.mozilla.javascript.ObjArray;
import org.mozilla.javascript.UintMap;

/* loaded from: classes5.dex */
public class ClassFileWriter {
    public static final short ACC_ABSTRACT = 1024;
    public static final short ACC_FINAL = 16;
    public static final short ACC_NATIVE = 256;
    public static final short ACC_PRIVATE = 2;
    public static final short ACC_PROTECTED = 4;
    public static final short ACC_PUBLIC = 1;
    public static final short ACC_STATIC = 8;
    public static final short ACC_SUPER = 32;
    public static final short ACC_SYNCHRONIZED = 32;
    public static final short ACC_TRANSIENT = 128;
    public static final short ACC_VOLATILE = 64;
    private static final boolean DEBUGCODE = false;
    private static final boolean DEBUGLABELS = false;
    private static final boolean DEBUGSTACK = false;
    private static final int ExceptionTableSize = 4;
    private static final int FileHeaderConstant = -889275714;
    private static final boolean GenerateStackMap;
    private static final int LineNumberTableSize = 16;
    private static final int MIN_FIXUP_TABLE_SIZE = 40;
    private static final int MIN_LABEL_TABLE_SIZE = 32;
    private static final int MajorVersion;
    private static final int MinorVersion;
    private static final int SuperBlockStartsSize = 4;
    private String generatedClassName;
    private int itsCodeBufferTop;
    private ConstantPool itsConstantPool;
    private ClassFileMethod itsCurrentMethod;
    private ExceptionTableEntry[] itsExceptionTable;
    private int itsExceptionTableTop;
    private long[] itsFixupTable;
    private int itsFixupTableTop;
    private short itsFlags;
    private int[] itsLabelTable;
    private int itsLabelTableTop;
    private int[] itsLineNumberTable;
    private int itsLineNumberTableTop;
    private short itsMaxLocals;
    private short itsMaxStack;
    private short itsSourceFileNameIndex;
    private short itsStackTop;
    private short itsSuperClassIndex;
    private short itsThisClassIndex;
    private ObjArray itsVarDescriptors;
    private int[] itsSuperBlockStarts = null;
    private int itsSuperBlockStartsTop = 0;
    private UintMap itsJumpFroms = null;
    private byte[] itsCodeBuffer = new byte[256];
    private ObjArray itsMethods = new ObjArray();
    private ObjArray itsFields = new ObjArray();
    private ObjArray itsInterfaces = new ObjArray();
    private char[] tmpCharBuffer = new char[64];

    private static String bytecodeStr(int i) {
        return "";
    }

    static /* synthetic */ int access$410(ClassFileWriter classFileWriter) {
        int i = classFileWriter.itsExceptionTableTop;
        classFileWriter.itsExceptionTableTop = i - 1;
        return i;
    }

    /* loaded from: classes5.dex */
    public static class ClassFileFormatException extends RuntimeException {
        private static final long serialVersionUID = 1263998431033790599L;

        ClassFileFormatException(String str) {
            super(str);
        }
    }

    public ClassFileWriter(String str, String str2, String str3) {
        this.generatedClassName = str;
        ConstantPool constantPool = new ConstantPool(this);
        this.itsConstantPool = constantPool;
        this.itsThisClassIndex = constantPool.addClass(str);
        this.itsSuperClassIndex = this.itsConstantPool.addClass(str2);
        if (str3 != null) {
            this.itsSourceFileNameIndex = this.itsConstantPool.addUtf8(str3);
        }
        this.itsFlags = (short) 33;
    }

    public final String getClassName() {
        return this.generatedClassName;
    }

    public void addInterface(String str) {
        this.itsInterfaces.add(Short.valueOf(this.itsConstantPool.addClass(str)));
    }

    public void setFlags(short s) {
        this.itsFlags = s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getSlashedForm(String str) {
        return str.replace('.', JsonPointer.SEPARATOR);
    }

    public static String classNameToSignature(String str) {
        int length = str.length();
        int i = length + 1;
        int i2 = i + 1;
        char[] cArr = new char[i2];
        cArr[0] = 'L';
        cArr[i] = ';';
        str.getChars(0, length, cArr, 1);
        for (int i3 = 1; i3 != i; i3++) {
            if (cArr[i3] == '.') {
                cArr[i3] = JsonPointer.SEPARATOR;
            }
        }
        return new String(cArr, 0, i2);
    }

    public void addField(String str, String str2, short s) {
        this.itsFields.add(new ClassFileField(this.itsConstantPool.addUtf8(str), this.itsConstantPool.addUtf8(str2), s));
    }

    public void addField(String str, String str2, short s, int i) {
        ClassFileField classFileField = new ClassFileField(this.itsConstantPool.addUtf8(str), this.itsConstantPool.addUtf8(str2), s);
        classFileField.setAttributes(this.itsConstantPool.addUtf8("ConstantValue"), (short) 0, (short) 0, this.itsConstantPool.addConstant(i));
        this.itsFields.add(classFileField);
    }

    public void addField(String str, String str2, short s, long j) {
        ClassFileField classFileField = new ClassFileField(this.itsConstantPool.addUtf8(str), this.itsConstantPool.addUtf8(str2), s);
        classFileField.setAttributes(this.itsConstantPool.addUtf8("ConstantValue"), (short) 0, (short) 2, this.itsConstantPool.addConstant(j));
        this.itsFields.add(classFileField);
    }

    public void addField(String str, String str2, short s, double d) {
        ClassFileField classFileField = new ClassFileField(this.itsConstantPool.addUtf8(str), this.itsConstantPool.addUtf8(str2), s);
        classFileField.setAttributes(this.itsConstantPool.addUtf8("ConstantValue"), (short) 0, (short) 2, this.itsConstantPool.addConstant(d));
        this.itsFields.add(classFileField);
    }

    public void addVariableDescriptor(String str, String str2, int i, int i2) {
        int[] iArr = {this.itsConstantPool.addUtf8(str), this.itsConstantPool.addUtf8(str2), i, i2};
        if (this.itsVarDescriptors == null) {
            this.itsVarDescriptors = new ObjArray();
        }
        this.itsVarDescriptors.add(iArr);
    }

    public void startMethod(String str, String str2, short s) {
        this.itsCurrentMethod = new ClassFileMethod(str, this.itsConstantPool.addUtf8(str), str2, this.itsConstantPool.addUtf8(str2), s);
        this.itsJumpFroms = new UintMap();
        this.itsMethods.add(this.itsCurrentMethod);
        addSuperBlockStart(0);
    }

    public void stopMethod(short s) {
        StackMapTable stackMapTable;
        int putInt16;
        int computeWriteSize;
        if (this.itsCurrentMethod == null) {
            throw new IllegalStateException("No method to stop");
        }
        fixLabelGotos();
        this.itsMaxLocals = s;
        if (GenerateStackMap) {
            finalizeSuperBlockStarts();
            stackMapTable = new StackMapTable();
            stackMapTable.generate();
        } else {
            stackMapTable = null;
        }
        int i = this.itsLineNumberTable != null ? (this.itsLineNumberTableTop * 4) + 8 : 0;
        ObjArray objArray = this.itsVarDescriptors;
        int size = objArray != null ? (objArray.size() * 10) + 8 : 0;
        int i2 = (stackMapTable == null || (computeWriteSize = stackMapTable.computeWriteSize()) <= 0) ? 0 : computeWriteSize + 6;
        int i3 = this.itsCodeBufferTop + 14 + 2 + (this.itsExceptionTableTop * 8) + 2 + i + size + i2;
        if (i3 > 65536) {
            throw new ClassFileFormatException("generated bytecode for method exceeds 64K limit.");
        }
        byte[] bArr = new byte[i3];
        int putInt32 = putInt32(this.itsCodeBufferTop, bArr, putInt16(this.itsMaxLocals, bArr, putInt16(this.itsMaxStack, bArr, putInt32(i3 - 6, bArr, putInt16(this.itsConstantPool.addUtf8("Code"), bArr, 0)))));
        System.arraycopy(this.itsCodeBuffer, 0, bArr, putInt32, this.itsCodeBufferTop);
        int i4 = putInt32 + this.itsCodeBufferTop;
        int i5 = this.itsExceptionTableTop;
        if (i5 > 0) {
            putInt16 = putInt16(i5, bArr, i4);
            for (int i6 = 0; i6 < this.itsExceptionTableTop; i6++) {
                ExceptionTableEntry exceptionTableEntry = this.itsExceptionTable[i6];
                short labelPC = (short) getLabelPC(exceptionTableEntry.itsStartLabel);
                short labelPC2 = (short) getLabelPC(exceptionTableEntry.itsEndLabel);
                short labelPC3 = (short) getLabelPC(exceptionTableEntry.itsHandlerLabel);
                short s2 = exceptionTableEntry.itsCatchType;
                if (labelPC == -1) {
                    throw new IllegalStateException("start label not defined");
                }
                if (labelPC2 == -1) {
                    throw new IllegalStateException("end label not defined");
                }
                if (labelPC3 == -1) {
                    throw new IllegalStateException("handler label not defined");
                }
                putInt16 = putInt16(s2, bArr, putInt16(labelPC3, bArr, putInt16(labelPC2, bArr, putInt16(labelPC, bArr, putInt16))));
            }
        } else {
            putInt16 = putInt16(0, bArr, i4);
        }
        int i7 = this.itsLineNumberTable != null ? 1 : 0;
        if (this.itsVarDescriptors != null) {
            i7++;
        }
        if (i2 > 0) {
            i7++;
        }
        int putInt162 = putInt16(i7, bArr, putInt16);
        if (this.itsLineNumberTable != null) {
            putInt162 = putInt16(this.itsLineNumberTableTop, bArr, putInt32((this.itsLineNumberTableTop * 4) + 2, bArr, putInt16(this.itsConstantPool.addUtf8("LineNumberTable"), bArr, putInt162)));
            for (int i8 = 0; i8 < this.itsLineNumberTableTop; i8++) {
                putInt162 = putInt32(this.itsLineNumberTable[i8], bArr, putInt162);
            }
        }
        if (this.itsVarDescriptors != null) {
            int putInt163 = putInt16(this.itsConstantPool.addUtf8("LocalVariableTable"), bArr, putInt162);
            int size2 = this.itsVarDescriptors.size();
            putInt162 = putInt16(size2, bArr, putInt32((size2 * 10) + 2, bArr, putInt163));
            for (int i9 = 0; i9 < size2; i9++) {
                int[] iArr = (int[]) this.itsVarDescriptors.get(i9);
                int i10 = iArr[0];
                int i11 = iArr[1];
                int i12 = iArr[2];
                putInt162 = putInt16(iArr[3], bArr, putInt16(i11, bArr, putInt16(i10, bArr, putInt16(this.itsCodeBufferTop - i12, bArr, putInt16(i12, bArr, putInt162)))));
            }
        }
        if (i2 > 0) {
            stackMapTable.write(bArr, putInt16(this.itsConstantPool.addUtf8("StackMapTable"), bArr, putInt162));
        }
        this.itsCurrentMethod.setCodeAttribute(bArr);
        this.itsExceptionTable = null;
        this.itsExceptionTableTop = 0;
        this.itsLineNumberTableTop = 0;
        this.itsCodeBufferTop = 0;
        this.itsCurrentMethod = null;
        this.itsMaxStack = (short) 0;
        this.itsStackTop = (short) 0;
        this.itsLabelTableTop = 0;
        this.itsFixupTableTop = 0;
        this.itsVarDescriptors = null;
        this.itsSuperBlockStarts = null;
        this.itsSuperBlockStartsTop = 0;
        this.itsJumpFroms = null;
    }

    public void add(int i) {
        if (opcodeCount(i) != 0) {
            throw new IllegalArgumentException("Unexpected operands");
        }
        int stackChange = this.itsStackTop + stackChange(i);
        if (stackChange < 0 || 32767 < stackChange) {
            badStack(stackChange);
        }
        addToCodeBuffer(i);
        short s = (short) stackChange;
        this.itsStackTop = s;
        if (stackChange > this.itsMaxStack) {
            this.itsMaxStack = s;
        }
        if (i == 191) {
            addSuperBlockStart(this.itsCodeBufferTop);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void add(int r6, int r7) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.classfile.ClassFileWriter.add(int, int):void");
    }

    public void addLoadConstant(int i) {
        if (i == 0) {
            add(3);
        } else if (i == 1) {
            add(4);
        } else if (i == 2) {
            add(5);
        } else if (i == 3) {
            add(6);
        } else if (i == 4) {
            add(7);
        } else if (i == 5) {
            add(8);
        } else {
            add(18, this.itsConstantPool.addConstant(i));
        }
    }

    public void addLoadConstant(long j) {
        add(20, this.itsConstantPool.addConstant(j));
    }

    public void addLoadConstant(float f) {
        add(18, this.itsConstantPool.addConstant(f));
    }

    public void addLoadConstant(double d) {
        add(20, this.itsConstantPool.addConstant(d));
    }

    public void addLoadConstant(String str) {
        add(18, this.itsConstantPool.addConstant(str));
    }

    public void add(int i, int i2, int i3) {
        int stackChange = this.itsStackTop + stackChange(i);
        if (stackChange < 0 || 32767 < stackChange) {
            badStack(stackChange);
        }
        if (i == 132) {
            if (i2 < 0 || i2 >= 65536) {
                throw new ClassFileFormatException("out of range variable");
            }
            if (i3 < 0 || i3 >= 65536) {
                throw new ClassFileFormatException("out of range increment");
            }
            if (i2 > 255 || i3 < -128 || i3 > 127) {
                addToCodeBuffer(196);
                addToCodeBuffer(132);
                addToCodeInt16(i2);
                addToCodeInt16(i3);
            } else {
                addToCodeBuffer(132);
                addToCodeBuffer(i2);
                addToCodeBuffer(i3);
            }
        } else if (i != 197) {
            throw new IllegalArgumentException("Unexpected opcode for 2 operands");
        } else {
            if (i2 < 0 || i2 >= 65536) {
                throw new IllegalArgumentException("out of range index");
            }
            if (i3 < 0 || i3 >= 256) {
                throw new IllegalArgumentException("out of range dimensions");
            }
            addToCodeBuffer(197);
            addToCodeInt16(i2);
            addToCodeBuffer(i3);
        }
        short s = (short) stackChange;
        this.itsStackTop = s;
        if (stackChange > this.itsMaxStack) {
            this.itsMaxStack = s;
        }
    }

    public void add(int i, String str) {
        int stackChange = this.itsStackTop + stackChange(i);
        if (stackChange < 0 || 32767 < stackChange) {
            badStack(stackChange);
        }
        if (i == 187 || i == 189 || i == 192 || i == 193) {
            short addClass = this.itsConstantPool.addClass(str);
            addToCodeBuffer(i);
            addToCodeInt16(addClass);
            short s = (short) stackChange;
            this.itsStackTop = s;
            if (stackChange > this.itsMaxStack) {
                this.itsMaxStack = s;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("bad opcode for class reference");
    }

    public void add(int i, String str, String str2, String str3) {
        int i2;
        int stackChange = this.itsStackTop + stackChange(i);
        char charAt = str3.charAt(0);
        int i3 = (charAt == 'J' || charAt == 'D') ? 2 : 1;
        switch (i) {
            case 178:
            case 180:
                i2 = stackChange + i3;
                break;
            case 179:
            case 181:
                i2 = stackChange - i3;
                break;
            default:
                throw new IllegalArgumentException("bad opcode for field reference");
        }
        if (i2 < 0 || 32767 < i2) {
            badStack(i2);
        }
        short addFieldRef = this.itsConstantPool.addFieldRef(str, str2, str3);
        addToCodeBuffer(i);
        addToCodeInt16(addFieldRef);
        short s = (short) i2;
        this.itsStackTop = s;
        if (i2 > this.itsMaxStack) {
            this.itsMaxStack = s;
        }
    }

    public void addInvoke(int i, String str, String str2, String str3) {
        int sizeOfParameters = sizeOfParameters(str3);
        int i2 = sizeOfParameters >>> 16;
        int stackChange = this.itsStackTop + ((short) sizeOfParameters) + stackChange(i);
        if (stackChange < 0 || 32767 < stackChange) {
            badStack(stackChange);
        }
        switch (i) {
            case 182:
            case 183:
            case 184:
            case 185:
                addToCodeBuffer(i);
                if (i == 185) {
                    addToCodeInt16(this.itsConstantPool.addInterfaceMethodRef(str, str2, str3));
                    addToCodeBuffer(i2 + 1);
                    addToCodeBuffer(0);
                } else {
                    addToCodeInt16(this.itsConstantPool.addMethodRef(str, str2, str3));
                }
                short s = (short) stackChange;
                this.itsStackTop = s;
                if (stackChange > this.itsMaxStack) {
                    this.itsMaxStack = s;
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException("bad opcode for method reference");
        }
    }

    public void addPush(int i) {
        byte b = (byte) i;
        if (b != i) {
            short s = (short) i;
            if (s == i) {
                add(17, s);
            } else {
                addLoadConstant(i);
            }
        } else if (i == -1) {
            add(2);
        } else if (i >= 0 && i <= 5) {
            add((byte) (i + 3));
        } else {
            add(16, b);
        }
    }

    public void addPush(boolean z) {
        add(z ? 4 : 3);
    }

    public void addPush(long j) {
        int i = (int) j;
        if (i == j) {
            addPush(i);
            add(133);
            return;
        }
        addLoadConstant(j);
    }

    public void addPush(double d) {
        if (d == 0.0d) {
            add(14);
            if (1.0d / d < 0.0d) {
                add(119);
            }
        } else if (d == 1.0d || d == -1.0d) {
            add(15);
            if (d < 0.0d) {
                add(119);
            }
        } else {
            addLoadConstant(d);
        }
    }

    public void addPush(String str) {
        int length = str.length();
        int i = 0;
        int utfEncodingLimit = this.itsConstantPool.getUtfEncodingLimit(str, 0, length);
        if (utfEncodingLimit == length) {
            addLoadConstant(str);
            return;
        }
        add(187, "java/lang/StringBuffer");
        add(89);
        addPush(length);
        addInvoke(183, "java/lang/StringBuffer", "<init>", "(I)V");
        while (true) {
            add(89);
            addLoadConstant(str.substring(i, utfEncodingLimit));
            addInvoke(182, "java/lang/StringBuffer", AgentOptions.APPEND, "(Ljava/lang/String;)Ljava/lang/StringBuffer;");
            add(87);
            if (utfEncodingLimit != length) {
                i = utfEncodingLimit;
                utfEncodingLimit = this.itsConstantPool.getUtfEncodingLimit(str, utfEncodingLimit, length);
            } else {
                addInvoke(182, "java/lang/StringBuffer", "toString", "()Ljava/lang/String;");
                return;
            }
        }
    }

    public boolean isUnderStringSizeLimit(String str) {
        return this.itsConstantPool.isUnderUtfEncodingLimit(str);
    }

    public void addIStore(int i) {
        xop(59, 54, i);
    }

    public void addLStore(int i) {
        xop(63, 55, i);
    }

    public void addFStore(int i) {
        xop(67, 56, i);
    }

    public void addDStore(int i) {
        xop(71, 57, i);
    }

    public void addAStore(int i) {
        xop(75, 58, i);
    }

    public void addILoad(int i) {
        xop(26, 21, i);
    }

    public void addLLoad(int i) {
        xop(30, 22, i);
    }

    public void addFLoad(int i) {
        xop(34, 23, i);
    }

    public void addDLoad(int i) {
        xop(38, 24, i);
    }

    public void addALoad(int i) {
        xop(42, 25, i);
    }

    public void addLoadThis() {
        add(42);
    }

    private void xop(int i, int i2, int i3) {
        if (i3 == 0) {
            add(i);
        } else if (i3 == 1) {
            add(i + 1);
        } else if (i3 == 2) {
            add(i + 2);
        } else if (i3 == 3) {
            add(i + 3);
        } else {
            add(i2, i3);
        }
    }

    public int addTableSwitch(int i, int i2) {
        if (i > i2) {
            throw new ClassFileFormatException("Bad bounds: " + i + ' ' + i2);
        }
        int stackChange = this.itsStackTop + stackChange(170);
        if (stackChange < 0 || 32767 < stackChange) {
            badStack(stackChange);
        }
        int i3 = (~this.itsCodeBufferTop) & 3;
        int addReservedCodeSpace = addReservedCodeSpace(i3 + 1 + (((i2 - i) + 1 + 3) * 4));
        int i4 = addReservedCodeSpace + 1;
        this.itsCodeBuffer[addReservedCodeSpace] = -86;
        while (i3 != 0) {
            this.itsCodeBuffer[i4] = 0;
            i3--;
            i4++;
        }
        putInt32(i2, this.itsCodeBuffer, putInt32(i, this.itsCodeBuffer, i4 + 4));
        short s = (short) stackChange;
        this.itsStackTop = s;
        if (stackChange > this.itsMaxStack) {
            this.itsMaxStack = s;
        }
        return addReservedCodeSpace;
    }

    public final void markTableSwitchDefault(int i) {
        addSuperBlockStart(this.itsCodeBufferTop);
        this.itsJumpFroms.put(this.itsCodeBufferTop, i);
        setTableSwitchJump(i, -1, this.itsCodeBufferTop);
    }

    public final void markTableSwitchCase(int i, int i2) {
        addSuperBlockStart(this.itsCodeBufferTop);
        this.itsJumpFroms.put(this.itsCodeBufferTop, i);
        setTableSwitchJump(i, i2, this.itsCodeBufferTop);
    }

    public final void markTableSwitchCase(int i, int i2, int i3) {
        if (i3 < 0 || i3 > this.itsMaxStack) {
            throw new IllegalArgumentException("Bad stack index: " + i3);
        }
        this.itsStackTop = (short) i3;
        addSuperBlockStart(this.itsCodeBufferTop);
        this.itsJumpFroms.put(this.itsCodeBufferTop, i);
        setTableSwitchJump(i, i2, this.itsCodeBufferTop);
    }

    public void setTableSwitchJump(int i, int i2, int i3) {
        int i4;
        if (i3 < 0 || i3 > (i4 = this.itsCodeBufferTop)) {
            throw new IllegalArgumentException("Bad jump target: " + i3);
        } else if (i2 < -1) {
            throw new IllegalArgumentException("Bad case index: " + i2);
        } else {
            int i5 = (~i) & 3;
            int i6 = i2 < 0 ? i + 1 + i5 : i + 1 + i5 + ((i2 + 3) * 4);
            if (i < 0 || i > ((i4 - 16) - i5) - 1) {
                throw new IllegalArgumentException(i + " is outside a possible range of tableswitch in already generated code");
            }
            byte[] bArr = this.itsCodeBuffer;
            if ((bArr[i] & 255) != 170) {
                throw new IllegalArgumentException(i + " is not offset of tableswitch statement");
            } else if (i6 < 0 || i6 + 4 > i4) {
                throw new ClassFileFormatException("Too big case index: " + i2);
            } else {
                putInt32(i3 - i, bArr, i6);
            }
        }
    }

    public int acquireLabel() {
        int i = this.itsLabelTableTop;
        int[] iArr = this.itsLabelTable;
        if (iArr == null || i == iArr.length) {
            if (iArr == null) {
                this.itsLabelTable = new int[32];
            } else {
                int[] iArr2 = new int[iArr.length * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                this.itsLabelTable = iArr2;
            }
        }
        this.itsLabelTableTop = i + 1;
        this.itsLabelTable[i] = -1;
        return i | Integer.MIN_VALUE;
    }

    public void markLabel(int i) {
        if (i >= 0) {
            throw new IllegalArgumentException("Bad label, no biscuit");
        }
        int i2 = i & Integer.MAX_VALUE;
        if (i2 > this.itsLabelTableTop) {
            throw new IllegalArgumentException("Bad label");
        }
        int[] iArr = this.itsLabelTable;
        if (iArr[i2] != -1) {
            throw new IllegalStateException("Can only mark label once");
        }
        iArr[i2] = this.itsCodeBufferTop;
    }

    public void markLabel(int i, short s) {
        markLabel(i);
        this.itsStackTop = s;
    }

    public void markHandler(int i) {
        this.itsStackTop = (short) 1;
        markLabel(i);
    }

    public int getLabelPC(int i) {
        if (i >= 0) {
            throw new IllegalArgumentException("Bad label, no biscuit");
        }
        int i2 = i & Integer.MAX_VALUE;
        if (i2 >= this.itsLabelTableTop) {
            throw new IllegalArgumentException("Bad label");
        }
        return this.itsLabelTable[i2];
    }

    private void addLabelFixup(int i, int i2) {
        if (i >= 0) {
            throw new IllegalArgumentException("Bad label, no biscuit");
        }
        int i3 = i & Integer.MAX_VALUE;
        if (i3 >= this.itsLabelTableTop) {
            throw new IllegalArgumentException("Bad label");
        }
        int i4 = this.itsFixupTableTop;
        long[] jArr = this.itsFixupTable;
        if (jArr == null || i4 == jArr.length) {
            if (jArr == null) {
                this.itsFixupTable = new long[40];
            } else {
                long[] jArr2 = new long[jArr.length * 2];
                System.arraycopy(jArr, 0, jArr2, 0, i4);
                this.itsFixupTable = jArr2;
            }
        }
        this.itsFixupTableTop = i4 + 1;
        this.itsFixupTable[i4] = i2 | (i3 << 32);
    }

    private void fixLabelGotos() {
        byte[] bArr = this.itsCodeBuffer;
        for (int i = 0; i < this.itsFixupTableTop; i++) {
            long j = this.itsFixupTable[i];
            int i2 = (int) j;
            int i3 = this.itsLabelTable[(int) (j >> 32)];
            if (i3 == -1) {
                throw new RuntimeException();
            }
            addSuperBlockStart(i3);
            int i4 = i2 - 1;
            this.itsJumpFroms.put(i3, i4);
            int i5 = i3 - i4;
            if (((short) i5) != i5) {
                throw new ClassFileFormatException("Program too complex: too big jump offset");
            }
            bArr[i2] = (byte) (i5 >> 8);
            bArr[i2 + 1] = (byte) i5;
        }
        this.itsFixupTableTop = 0;
    }

    public int getCurrentCodeOffset() {
        return this.itsCodeBufferTop;
    }

    public short getStackTop() {
        return this.itsStackTop;
    }

    public void setStackTop(short s) {
        this.itsStackTop = s;
    }

    public void adjustStackTop(int i) {
        int i2 = this.itsStackTop + i;
        if (i2 < 0 || 32767 < i2) {
            badStack(i2);
        }
        short s = (short) i2;
        this.itsStackTop = s;
        if (i2 > this.itsMaxStack) {
            this.itsMaxStack = s;
        }
    }

    private void addToCodeBuffer(int i) {
        this.itsCodeBuffer[addReservedCodeSpace(1)] = (byte) i;
    }

    private void addToCodeInt16(int i) {
        putInt16(i, this.itsCodeBuffer, addReservedCodeSpace(2));
    }

    private int addReservedCodeSpace(int i) {
        if (this.itsCurrentMethod == null) {
            throw new IllegalArgumentException("No method to add to");
        }
        int i2 = this.itsCodeBufferTop;
        int i3 = i + i2;
        byte[] bArr = this.itsCodeBuffer;
        if (i3 > bArr.length) {
            int length = bArr.length * 2;
            if (i3 > length) {
                length = i3;
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            this.itsCodeBuffer = bArr2;
        }
        this.itsCodeBufferTop = i3;
        return i2;
    }

    public void addExceptionHandler(int i, int i2, int i3, String str) {
        if ((i & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Bad startLabel");
        }
        if ((i2 & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Bad endLabel");
        }
        if ((i3 & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Bad handlerLabel");
        }
        ExceptionTableEntry exceptionTableEntry = new ExceptionTableEntry(i, i2, i3, str == null ? (short) 0 : this.itsConstantPool.addClass(str));
        int i4 = this.itsExceptionTableTop;
        if (i4 == 0) {
            this.itsExceptionTable = new ExceptionTableEntry[4];
        } else {
            ExceptionTableEntry[] exceptionTableEntryArr = this.itsExceptionTable;
            if (i4 == exceptionTableEntryArr.length) {
                ExceptionTableEntry[] exceptionTableEntryArr2 = new ExceptionTableEntry[i4 * 2];
                System.arraycopy(exceptionTableEntryArr, 0, exceptionTableEntryArr2, 0, i4);
                this.itsExceptionTable = exceptionTableEntryArr2;
            }
        }
        this.itsExceptionTable[i4] = exceptionTableEntry;
        this.itsExceptionTableTop = i4 + 1;
    }

    public void addLineNumberEntry(short s) {
        if (this.itsCurrentMethod == null) {
            throw new IllegalArgumentException("No method to stop");
        }
        int i = this.itsLineNumberTableTop;
        if (i == 0) {
            this.itsLineNumberTable = new int[16];
        } else {
            int[] iArr = this.itsLineNumberTable;
            if (i == iArr.length) {
                int[] iArr2 = new int[i * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                this.itsLineNumberTable = iArr2;
            }
        }
        this.itsLineNumberTable[i] = (this.itsCodeBufferTop << 16) + s;
        this.itsLineNumberTableTop = i + 1;
    }

    /* loaded from: classes5.dex */
    final class StackMapTable {
        static final boolean DEBUGSTACKMAP = false;
        private SuperBlock[] superBlockDeps;
        private SuperBlock[] superBlocks = null;
        private int[] stack = null;
        private int[] locals = null;
        private SuperBlock[] workList = null;
        private byte[] rawStackMap = null;
        private int localsTop = 0;
        private int stackTop = 0;
        private int workListTop = 0;
        private int rawStackMapTop = 0;
        private boolean wide = false;

        private boolean isBranch(int i) {
            switch (i) {
                case 153:
                case 154:
                case 155:
                case 156:
                case 157:
                case 158:
                case 159:
                case 160:
                case 161:
                case 162:
                case 163:
                case 164:
                case 165:
                case 166:
                case 167:
                    return true;
                default:
                    switch (i) {
                        case 198:
                        case 199:
                        case 200:
                            return true;
                        default:
                            return false;
                    }
            }
        }

        private boolean isSuperBlockEnd(int i) {
            if (i == 167 || i == 191 || i == 200 || i == 176 || i == 177) {
                return true;
            }
            switch (i) {
                case 170:
                case 171:
                case 172:
                case 173:
                case 174:
                    return true;
                default:
                    return false;
            }
        }

        StackMapTable() {
        }

        void generate() {
            this.superBlocks = new SuperBlock[ClassFileWriter.this.itsSuperBlockStartsTop];
            int[] createInitialLocals = ClassFileWriter.this.createInitialLocals();
            int i = 0;
            while (i < ClassFileWriter.this.itsSuperBlockStartsTop) {
                this.superBlocks[i] = new SuperBlock(i, ClassFileWriter.this.itsSuperBlockStarts[i], i == ClassFileWriter.this.itsSuperBlockStartsTop + (-1) ? ClassFileWriter.this.itsCodeBufferTop : ClassFileWriter.this.itsSuperBlockStarts[i + 1], createInitialLocals);
                i++;
            }
            this.superBlockDeps = getSuperBlockDependencies();
            verify();
        }

        private SuperBlock getSuperBlockFromOffset(int i) {
            SuperBlock superBlock;
            int i2 = 0;
            while (true) {
                SuperBlock[] superBlockArr = this.superBlocks;
                if (i2 >= superBlockArr.length || (superBlock = superBlockArr[i2]) == null) {
                    break;
                } else if (i >= superBlock.getStart() && i < superBlock.getEnd()) {
                    return superBlock;
                } else {
                    i2++;
                }
            }
            throw new IllegalArgumentException("bad offset: " + i);
        }

        private SuperBlock[] getSuperBlockDependencies() {
            int[] keys;
            SuperBlock[] superBlockArr = new SuperBlock[this.superBlocks.length];
            for (int i = 0; i < ClassFileWriter.this.itsExceptionTableTop; i++) {
                ExceptionTableEntry exceptionTableEntry = ClassFileWriter.this.itsExceptionTable[i];
                superBlockArr[getSuperBlockFromOffset((short) ClassFileWriter.this.getLabelPC(exceptionTableEntry.itsHandlerLabel)).getIndex()] = getSuperBlockFromOffset((short) ClassFileWriter.this.getLabelPC(exceptionTableEntry.itsStartLabel));
            }
            for (int i2 : ClassFileWriter.this.itsJumpFroms.getKeys()) {
                superBlockArr[getSuperBlockFromOffset(i2).getIndex()] = getSuperBlockFromOffset(ClassFileWriter.this.itsJumpFroms.getInt(i2, -1));
            }
            return superBlockArr;
        }

        private SuperBlock getBranchTarget(int i) {
            int operand;
            if ((ClassFileWriter.this.itsCodeBuffer[i] & 255) == 200) {
                operand = getOperand(i + 1, 4);
            } else {
                operand = (short) getOperand(i + 1, 2);
            }
            return getSuperBlockFromOffset(i + operand);
        }

        private int getOperand(int i) {
            return getOperand(i, 1);
        }

        private int getOperand(int i, int i2) {
            if (i2 <= 4) {
                int i3 = 0;
                for (int i4 = 0; i4 < i2; i4++) {
                    i3 = (i3 << 8) | (ClassFileWriter.this.itsCodeBuffer[i + i4] & 255);
                }
                return i3;
            }
            throw new IllegalArgumentException("bad operand size");
        }

        private void verify() {
            int[] createInitialLocals = ClassFileWriter.this.createInitialLocals();
            int i = 0;
            this.superBlocks[0].merge(createInitialLocals, createInitialLocals.length, new int[0], 0, ClassFileWriter.this.itsConstantPool);
            this.workList = new SuperBlock[]{this.superBlocks[0]};
            this.workListTop = 1;
            executeWorkList();
            while (true) {
                SuperBlock[] superBlockArr = this.superBlocks;
                if (i < superBlockArr.length) {
                    SuperBlock superBlock = superBlockArr[i];
                    if (!superBlock.isInitialized()) {
                        killSuperBlock(superBlock);
                    }
                    i++;
                } else {
                    executeWorkList();
                    return;
                }
            }
        }

        private void killSuperBlock(SuperBlock superBlock) {
            int[] iArr = new int[0];
            int[] iArr2 = {TypeInfo.OBJECT("java/lang/Throwable", ClassFileWriter.this.itsConstantPool)};
            for (int i = 0; i < ClassFileWriter.this.itsExceptionTableTop; i++) {
                ExceptionTableEntry exceptionTableEntry = ClassFileWriter.this.itsExceptionTable[i];
                int labelPC = ClassFileWriter.this.getLabelPC(exceptionTableEntry.itsStartLabel);
                int labelPC2 = ClassFileWriter.this.getLabelPC(exceptionTableEntry.itsEndLabel);
                SuperBlock superBlockFromOffset = getSuperBlockFromOffset(ClassFileWriter.this.getLabelPC(exceptionTableEntry.itsHandlerLabel));
                if ((superBlock.getStart() > labelPC && superBlock.getStart() < labelPC2) || (labelPC > superBlock.getStart() && labelPC < superBlock.getEnd() && superBlockFromOffset.isInitialized())) {
                    iArr = superBlockFromOffset.getLocals();
                    break;
                }
            }
            int[] iArr3 = iArr;
            int i2 = 0;
            while (i2 < ClassFileWriter.this.itsExceptionTableTop) {
                if (ClassFileWriter.this.getLabelPC(ClassFileWriter.this.itsExceptionTable[i2].itsStartLabel) == superBlock.getStart()) {
                    for (int i3 = i2 + 1; i3 < ClassFileWriter.this.itsExceptionTableTop; i3++) {
                        ClassFileWriter.this.itsExceptionTable[i3 - 1] = ClassFileWriter.this.itsExceptionTable[i3];
                    }
                    ClassFileWriter.access$410(ClassFileWriter.this);
                    i2--;
                }
                i2++;
            }
            superBlock.merge(iArr3, iArr3.length, iArr2, 1, ClassFileWriter.this.itsConstantPool);
            int end = superBlock.getEnd() - 1;
            ClassFileWriter.this.itsCodeBuffer[end] = ByteSourceJsonBootstrapper.UTF8_BOM_3;
            for (int start = superBlock.getStart(); start < end; start++) {
                ClassFileWriter.this.itsCodeBuffer[start] = 0;
            }
        }

        private void executeWorkList() {
            while (true) {
                int i = this.workListTop;
                if (i <= 0) {
                    return;
                }
                SuperBlock[] superBlockArr = this.workList;
                int i2 = i - 1;
                this.workListTop = i2;
                SuperBlock superBlock = superBlockArr[i2];
                superBlock.setInQueue(false);
                this.locals = superBlock.getLocals();
                int[] stack = superBlock.getStack();
                this.stack = stack;
                this.localsTop = this.locals.length;
                this.stackTop = stack.length;
                executeBlock(superBlock);
            }
        }

        private void executeBlock(SuperBlock superBlock) {
            int OBJECT;
            int start = superBlock.getStart();
            int i = 0;
            while (start < superBlock.getEnd()) {
                i = ClassFileWriter.this.itsCodeBuffer[start] & 255;
                int execute = execute(start);
                if (isBranch(i)) {
                    flowInto(getBranchTarget(start));
                } else if (i == 170) {
                    int i2 = start + 1 + ((~start) & 3);
                    flowInto(getSuperBlockFromOffset(getOperand(i2, 4) + start));
                    int operand = (getOperand(i2 + 8, 4) - getOperand(i2 + 4, 4)) + 1;
                    int i3 = i2 + 12;
                    for (int i4 = 0; i4 < operand; i4++) {
                        flowInto(getSuperBlockFromOffset(getOperand((i4 * 4) + i3, 4) + start));
                    }
                }
                for (int i5 = 0; i5 < ClassFileWriter.this.itsExceptionTableTop; i5++) {
                    ExceptionTableEntry exceptionTableEntry = ClassFileWriter.this.itsExceptionTable[i5];
                    short labelPC = (short) ClassFileWriter.this.getLabelPC(exceptionTableEntry.itsStartLabel);
                    short labelPC2 = (short) ClassFileWriter.this.getLabelPC(exceptionTableEntry.itsEndLabel);
                    if (start >= labelPC && start < labelPC2) {
                        SuperBlock superBlockFromOffset = getSuperBlockFromOffset((short) ClassFileWriter.this.getLabelPC(exceptionTableEntry.itsHandlerLabel));
                        if (exceptionTableEntry.itsCatchType == 0) {
                            OBJECT = TypeInfo.OBJECT(ClassFileWriter.this.itsConstantPool.addClass("java/lang/Throwable"));
                        } else {
                            OBJECT = TypeInfo.OBJECT(exceptionTableEntry.itsCatchType);
                        }
                        superBlockFromOffset.merge(this.locals, this.localsTop, new int[]{OBJECT}, 1, ClassFileWriter.this.itsConstantPool);
                        addToWorkList(superBlockFromOffset);
                    }
                }
                start += execute;
            }
            if (isSuperBlockEnd(i)) {
                return;
            }
            int index = superBlock.getIndex() + 1;
            SuperBlock[] superBlockArr = this.superBlocks;
            if (index < superBlockArr.length) {
                flowInto(superBlockArr[index]);
            }
        }

        private void flowInto(SuperBlock superBlock) {
            if (superBlock.merge(this.locals, this.localsTop, this.stack, this.stackTop, ClassFileWriter.this.itsConstantPool)) {
                addToWorkList(superBlock);
            }
        }

        private void addToWorkList(SuperBlock superBlock) {
            if (superBlock.isInQueue()) {
                return;
            }
            superBlock.setInQueue(true);
            superBlock.setInitialized(true);
            int i = this.workListTop;
            SuperBlock[] superBlockArr = this.workList;
            if (i == superBlockArr.length) {
                SuperBlock[] superBlockArr2 = new SuperBlock[i * 2];
                System.arraycopy(superBlockArr, 0, superBlockArr2, 0, i);
                this.workList = superBlockArr2;
            }
            SuperBlock[] superBlockArr3 = this.workList;
            int i2 = this.workListTop;
            this.workListTop = i2 + 1;
            superBlockArr3[i2] = superBlock;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private int execute(int i) {
            int i2;
            int operand;
            int pop;
            int tag;
            int i3 = ClassFileWriter.this.itsCodeBuffer[i] & 255;
            switch (i3) {
                case 0:
                case 132:
                case 167:
                case 200:
                    i2 = 0;
                    break;
                case 1:
                    push(5);
                    i2 = 0;
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 16:
                case 17:
                case 21:
                case 26:
                case 27:
                case 28:
                case 29:
                    push(1);
                    i2 = 0;
                    break;
                case 9:
                case 10:
                case 22:
                case 30:
                case 31:
                case 32:
                case 33:
                    push(4);
                    i2 = 0;
                    break;
                case 11:
                case 12:
                case 13:
                case 23:
                case 34:
                case 35:
                case 36:
                case 37:
                    push(2);
                    i2 = 0;
                    break;
                case 14:
                case 15:
                case 24:
                case 38:
                case 39:
                case 40:
                case 41:
                    push(3);
                    i2 = 0;
                    break;
                case 18:
                case 19:
                case 20:
                    if (i3 == 18) {
                        operand = getOperand(i + 1);
                    } else {
                        operand = getOperand(i + 1, 2);
                    }
                    byte constantType = ClassFileWriter.this.itsConstantPool.getConstantType(operand);
                    if (constantType == 3) {
                        push(1);
                    } else if (constantType == 4) {
                        push(2);
                    } else if (constantType == 5) {
                        push(4);
                    } else if (constantType == 6) {
                        push(3);
                    } else if (constantType == 8) {
                        push(TypeInfo.OBJECT("java/lang/String", ClassFileWriter.this.itsConstantPool));
                    } else {
                        throw new IllegalArgumentException("bad const type " + ((int) constantType));
                    }
                    i2 = 0;
                    break;
                case 25:
                    executeALoad(getOperand(i + 1, this.wide ? 2 : 1));
                    i2 = 0;
                    break;
                case 42:
                case 43:
                case 44:
                case 45:
                    executeALoad(i3 - 42);
                    i2 = 0;
                    break;
                case 46:
                case 51:
                case 52:
                case 53:
                case 96:
                case 100:
                case 104:
                case 108:
                case 112:
                case 120:
                case 122:
                case 124:
                case 126:
                case 128:
                case 130:
                case 148:
                case 149:
                case 150:
                case 151:
                case 152:
                    pop();
                    pop();
                    push(1);
                    i2 = 0;
                    break;
                case 47:
                case 97:
                case 101:
                case 105:
                case 109:
                case 113:
                case 121:
                case 123:
                case 125:
                case 127:
                case 129:
                case 131:
                    pop();
                    pop();
                    push(4);
                    i2 = 0;
                    break;
                case 48:
                case 98:
                case 102:
                case 106:
                case 110:
                case 114:
                    pop();
                    pop();
                    push(2);
                    i2 = 0;
                    break;
                case 49:
                case 99:
                case 103:
                case 107:
                case 111:
                case 115:
                    pop();
                    pop();
                    push(3);
                    i2 = 0;
                    break;
                case 50:
                    pop();
                    String str = (String) ClassFileWriter.this.itsConstantPool.getConstantData(pop() >>> 8);
                    if (str.charAt(0) != '[') {
                        throw new IllegalStateException("bad array type");
                    }
                    push(TypeInfo.OBJECT(ClassFileWriter.this.itsConstantPool.addClass(ClassFileWriter.descriptorToInternalName(str.substring(1)))));
                    i2 = 0;
                    break;
                case 54:
                    executeStore(getOperand(i + 1, this.wide ? 2 : 1), 1);
                    i2 = 0;
                    break;
                case 55:
                    executeStore(getOperand(i + 1, this.wide ? 2 : 1), 4);
                    i2 = 0;
                    break;
                case 56:
                    executeStore(getOperand(i + 1, this.wide ? 2 : 1), 2);
                    i2 = 0;
                    break;
                case 57:
                    executeStore(getOperand(i + 1, this.wide ? 2 : 1), 3);
                    i2 = 0;
                    break;
                case 58:
                    executeAStore(getOperand(i + 1, this.wide ? 2 : 1));
                    i2 = 0;
                    break;
                case 59:
                case 60:
                case 61:
                case 62:
                    executeStore(i3 - 59, 1);
                    i2 = 0;
                    break;
                case 63:
                case 64:
                case 65:
                case 66:
                    executeStore(i3 - 63, 4);
                    i2 = 0;
                    break;
                case 67:
                case 68:
                case 69:
                case 70:
                    executeStore(i3 - 67, 2);
                    i2 = 0;
                    break;
                case 71:
                case 72:
                case 73:
                case 74:
                    executeStore(i3 - 71, 3);
                    i2 = 0;
                    break;
                case 75:
                case 76:
                case 77:
                case 78:
                    executeAStore(i3 - 75);
                    i2 = 0;
                    break;
                case 79:
                case 80:
                case 81:
                case 82:
                case 83:
                case 84:
                case 85:
                case 86:
                    pop();
                    pop();
                    pop();
                    i2 = 0;
                    break;
                case 87:
                case 153:
                case 154:
                case 155:
                case 156:
                case 157:
                case 158:
                case 179:
                case 194:
                case 195:
                case 198:
                case 199:
                    pop();
                    i2 = 0;
                    break;
                case 88:
                    pop2();
                    i2 = 0;
                    break;
                case 89:
                    int pop2 = pop();
                    push(pop2);
                    push(pop2);
                    i2 = 0;
                    break;
                case 90:
                    int pop3 = pop();
                    int pop4 = pop();
                    push(pop3);
                    push(pop4);
                    push(pop3);
                    i2 = 0;
                    break;
                case 91:
                    int pop5 = pop();
                    long pop22 = pop2();
                    push(pop5);
                    push2(pop22);
                    push(pop5);
                    i2 = 0;
                    break;
                case 92:
                    long pop23 = pop2();
                    push2(pop23);
                    push2(pop23);
                    i2 = 0;
                    break;
                case 93:
                    long pop24 = pop2();
                    int pop6 = pop();
                    push2(pop24);
                    push(pop6);
                    push2(pop24);
                    i2 = 0;
                    break;
                case 94:
                    long pop25 = pop2();
                    long pop26 = pop2();
                    push2(pop25);
                    push2(pop26);
                    push2(pop25);
                    i2 = 0;
                    break;
                case 95:
                    int pop7 = pop();
                    int pop8 = pop();
                    push(pop7);
                    push(pop8);
                    i2 = 0;
                    break;
                case 116:
                case 136:
                case 139:
                case 142:
                case 145:
                case 146:
                case 147:
                case 190:
                case 193:
                    pop();
                    push(1);
                    i2 = 0;
                    break;
                case 117:
                case 133:
                case 140:
                case 143:
                    pop();
                    push(4);
                    i2 = 0;
                    break;
                case 118:
                case 134:
                case 137:
                case 144:
                    pop();
                    push(2);
                    i2 = 0;
                    break;
                case 119:
                case 135:
                case 138:
                case 141:
                    pop();
                    push(3);
                    i2 = 0;
                    break;
                case 159:
                case 160:
                case 161:
                case 162:
                case 163:
                case 164:
                case 165:
                case 166:
                case 181:
                    pop();
                    pop();
                    i2 = 0;
                    break;
                case 168:
                case 169:
                case 171:
                case 186:
                case 197:
                default:
                    throw new IllegalArgumentException("bad opcode: " + i3);
                case 170:
                    int i4 = i + 1 + ((~i) & 3);
                    i2 = ((((getOperand(i4 + 8, 4) - getOperand(i4 + 4, 4)) + 4) * 4) + i4) - i;
                    pop();
                    break;
                case 172:
                case 173:
                case 174:
                case 175:
                case 176:
                case 177:
                    clearStack();
                    i2 = 0;
                    break;
                case 178:
                    push(TypeInfo.fromType(ClassFileWriter.descriptorToInternalName(((FieldOrMethodRef) ClassFileWriter.this.itsConstantPool.getConstantData(getOperand(i + 1, 2))).getType()), ClassFileWriter.this.itsConstantPool));
                    i2 = 0;
                    break;
                case 180:
                    pop();
                    push(TypeInfo.fromType(ClassFileWriter.descriptorToInternalName(((FieldOrMethodRef) ClassFileWriter.this.itsConstantPool.getConstantData(getOperand(i + 1, 2))).getType()), ClassFileWriter.this.itsConstantPool));
                    i2 = 0;
                    break;
                case 182:
                case 183:
                case 184:
                case 185:
                    FieldOrMethodRef fieldOrMethodRef = (FieldOrMethodRef) ClassFileWriter.this.itsConstantPool.getConstantData(getOperand(i + 1, 2));
                    String type = fieldOrMethodRef.getType();
                    String name = fieldOrMethodRef.getName();
                    int sizeOfParameters = ClassFileWriter.sizeOfParameters(type) >>> 16;
                    for (int i5 = 0; i5 < sizeOfParameters; i5++) {
                        pop();
                    }
                    if (i3 != 184 && ((tag = TypeInfo.getTag((pop = pop()))) == TypeInfo.UNINITIALIZED_VARIABLE(0) || tag == 6)) {
                        if ("<init>".equals(name)) {
                            initializeTypeInfo(pop, TypeInfo.OBJECT(ClassFileWriter.this.itsThisClassIndex));
                        } else {
                            throw new IllegalStateException("bad instance");
                        }
                    }
                    String descriptorToInternalName = ClassFileWriter.descriptorToInternalName(type.substring(type.indexOf(41) + 1));
                    if (!descriptorToInternalName.equals(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
                        push(TypeInfo.fromType(descriptorToInternalName, ClassFileWriter.this.itsConstantPool));
                    }
                    i2 = 0;
                    break;
                case 187:
                    push(TypeInfo.UNINITIALIZED_VARIABLE(i));
                    i2 = 0;
                    break;
                case 188:
                    pop();
                    char arrayTypeToName = ClassFileWriter.arrayTypeToName(ClassFileWriter.this.itsCodeBuffer[i + 1]);
                    ConstantPool constantPool = ClassFileWriter.this.itsConstantPool;
                    push(TypeInfo.OBJECT(constantPool.addClass("[" + arrayTypeToName)));
                    i2 = 0;
                    break;
                case 189:
                    int operand2 = getOperand(i + 1, 2);
                    pop();
                    push(TypeInfo.OBJECT("[L" + ((String) ClassFileWriter.this.itsConstantPool.getConstantData(operand2)) + ';', ClassFileWriter.this.itsConstantPool));
                    i2 = 0;
                    break;
                case 191:
                    int pop9 = pop();
                    clearStack();
                    push(pop9);
                    i2 = 0;
                    break;
                case 192:
                    pop();
                    push(TypeInfo.OBJECT(getOperand(i + 1, 2)));
                    i2 = 0;
                    break;
                case 196:
                    this.wide = true;
                    i2 = 0;
                    break;
            }
            if (i2 == 0) {
                i2 = ClassFileWriter.opcodeLength(i3, this.wide);
            }
            if (this.wide && i3 != 196) {
                this.wide = false;
            }
            return i2;
        }

        private void executeALoad(int i) {
            int local = getLocal(i);
            int tag = TypeInfo.getTag(local);
            if (tag == 7 || tag == 6 || tag == 8 || tag == 5) {
                push(local);
                return;
            }
            throw new IllegalStateException("bad local variable type: " + local + " at index: " + i);
        }

        private void executeAStore(int i) {
            setLocal(i, pop());
        }

        private void executeStore(int i, int i2) {
            pop();
            setLocal(i, i2);
        }

        private void initializeTypeInfo(int i, int i2) {
            initializeTypeInfo(i, i2, this.locals, this.localsTop);
            initializeTypeInfo(i, i2, this.stack, this.stackTop);
        }

        private void initializeTypeInfo(int i, int i2, int[] iArr, int i3) {
            for (int i4 = 0; i4 < i3; i4++) {
                if (iArr[i4] == i) {
                    iArr[i4] = i2;
                }
            }
        }

        private int getLocal(int i) {
            if (i < this.localsTop) {
                return this.locals[i];
            }
            return 0;
        }

        private void setLocal(int i, int i2) {
            int i3 = this.localsTop;
            if (i >= i3) {
                int i4 = i + 1;
                int[] iArr = new int[i4];
                System.arraycopy(this.locals, 0, iArr, 0, i3);
                this.locals = iArr;
                this.localsTop = i4;
            }
            this.locals[i] = i2;
        }

        private void push(int i) {
            int i2 = this.stackTop;
            if (i2 == this.stack.length) {
                int[] iArr = new int[Math.max(i2 * 2, 4)];
                System.arraycopy(this.stack, 0, iArr, 0, this.stackTop);
                this.stack = iArr;
            }
            int[] iArr2 = this.stack;
            int i3 = this.stackTop;
            this.stackTop = i3 + 1;
            iArr2[i3] = i;
        }

        private int pop() {
            int[] iArr = this.stack;
            int i = this.stackTop - 1;
            this.stackTop = i;
            return iArr[i];
        }

        private void push2(long j) {
            push((int) (j & 16777215));
            long j2 = j >>> 32;
            if (j2 != 0) {
                push((int) (j2 & 16777215));
            }
        }

        private long pop2() {
            long pop = pop();
            return TypeInfo.isTwoWords((int) pop) ? pop : (pop << 32) | (pop() & ViewCompat.MEASURED_SIZE_MASK);
        }

        private void clearStack() {
            this.stackTop = 0;
        }

        int computeWriteSize() {
            this.rawStackMap = new byte[getWorstCaseWriteSize()];
            computeRawStackMap();
            return this.rawStackMapTop + 2;
        }

        int write(byte[] bArr, int i) {
            int putInt16 = ClassFileWriter.putInt16(this.superBlocks.length - 1, bArr, ClassFileWriter.putInt32(this.rawStackMapTop + 2, bArr, i));
            System.arraycopy(this.rawStackMap, 0, bArr, putInt16, this.rawStackMapTop);
            return putInt16 + this.rawStackMapTop;
        }

        private void computeRawStackMap() {
            int[] trimmedLocals = this.superBlocks[0].getTrimmedLocals();
            int i = -1;
            int i2 = 1;
            while (true) {
                SuperBlock[] superBlockArr = this.superBlocks;
                if (i2 >= superBlockArr.length) {
                    return;
                }
                SuperBlock superBlock = superBlockArr[i2];
                int[] trimmedLocals2 = superBlock.getTrimmedLocals();
                int[] stack = superBlock.getStack();
                int start = (superBlock.getStart() - i) - 1;
                if (stack.length == 0) {
                    int length = trimmedLocals.length > trimmedLocals2.length ? trimmedLocals2.length : trimmedLocals.length;
                    int abs = Math.abs(trimmedLocals.length - trimmedLocals2.length);
                    int i3 = 0;
                    while (i3 < length && trimmedLocals[i3] == trimmedLocals2[i3]) {
                        i3++;
                    }
                    if (i3 == trimmedLocals2.length && abs == 0) {
                        writeSameFrame(trimmedLocals2, start);
                    } else if (i3 == trimmedLocals2.length && abs <= 3) {
                        writeChopFrame(abs, start);
                    } else if (i3 == trimmedLocals.length && abs <= 3) {
                        writeAppendFrame(trimmedLocals2, abs, start);
                    } else {
                        writeFullFrame(trimmedLocals2, stack, start);
                    }
                } else if (stack.length == 1) {
                    if (Arrays.equals(trimmedLocals, trimmedLocals2)) {
                        writeSameLocalsOneStackItemFrame(trimmedLocals2, stack, start);
                    } else {
                        writeFullFrame(trimmedLocals2, stack, start);
                    }
                } else {
                    writeFullFrame(trimmedLocals2, stack, start);
                }
                i = superBlock.getStart();
                i2++;
                trimmedLocals = trimmedLocals2;
            }
        }

        private int getWorstCaseWriteSize() {
            return (this.superBlocks.length - 1) * ((ClassFileWriter.this.itsMaxLocals * 3) + 7 + (ClassFileWriter.this.itsMaxStack * 3));
        }

        private void writeSameFrame(int[] iArr, int i) {
            if (i <= 63) {
                byte[] bArr = this.rawStackMap;
                int i2 = this.rawStackMapTop;
                this.rawStackMapTop = i2 + 1;
                bArr[i2] = (byte) i;
                return;
            }
            byte[] bArr2 = this.rawStackMap;
            int i3 = this.rawStackMapTop;
            int i4 = i3 + 1;
            this.rawStackMapTop = i4;
            bArr2[i3] = -5;
            this.rawStackMapTop = ClassFileWriter.putInt16(i, bArr2, i4);
        }

        private void writeSameLocalsOneStackItemFrame(int[] iArr, int[] iArr2, int i) {
            if (i <= 63) {
                byte[] bArr = this.rawStackMap;
                int i2 = this.rawStackMapTop;
                this.rawStackMapTop = i2 + 1;
                bArr[i2] = (byte) (i + 64);
            } else {
                byte[] bArr2 = this.rawStackMap;
                int i3 = this.rawStackMapTop;
                int i4 = i3 + 1;
                this.rawStackMapTop = i4;
                bArr2[i3] = -9;
                this.rawStackMapTop = ClassFileWriter.putInt16(i, bArr2, i4);
            }
            writeType(iArr2[0]);
        }

        private void writeFullFrame(int[] iArr, int[] iArr2, int i) {
            byte[] bArr = this.rawStackMap;
            int i2 = this.rawStackMapTop;
            int i3 = i2 + 1;
            this.rawStackMapTop = i3;
            bArr[i2] = -1;
            int putInt16 = ClassFileWriter.putInt16(i, bArr, i3);
            this.rawStackMapTop = putInt16;
            this.rawStackMapTop = ClassFileWriter.putInt16(iArr.length, this.rawStackMap, putInt16);
            int writeTypes = writeTypes(iArr);
            this.rawStackMapTop = writeTypes;
            this.rawStackMapTop = ClassFileWriter.putInt16(iArr2.length, this.rawStackMap, writeTypes);
            this.rawStackMapTop = writeTypes(iArr2);
        }

        private void writeAppendFrame(int[] iArr, int i, int i2) {
            int length = iArr.length - i;
            byte[] bArr = this.rawStackMap;
            int i3 = this.rawStackMapTop;
            int i4 = i3 + 1;
            this.rawStackMapTop = i4;
            bArr[i3] = (byte) (i + bqk.f6602ci);
            this.rawStackMapTop = ClassFileWriter.putInt16(i2, bArr, i4);
            this.rawStackMapTop = writeTypes(iArr, length);
        }

        private void writeChopFrame(int i, int i2) {
            byte[] bArr = this.rawStackMap;
            int i3 = this.rawStackMapTop;
            int i4 = i3 + 1;
            this.rawStackMapTop = i4;
            bArr[i3] = (byte) (251 - i);
            this.rawStackMapTop = ClassFileWriter.putInt16(i2, bArr, i4);
        }

        private int writeTypes(int[] iArr) {
            return writeTypes(iArr, 0);
        }

        private int writeTypes(int[] iArr, int i) {
            while (i < iArr.length) {
                this.rawStackMapTop = writeType(iArr[i]);
                i++;
            }
            return this.rawStackMapTop;
        }

        private int writeType(int i) {
            int i2 = i & 255;
            byte[] bArr = this.rawStackMap;
            int i3 = this.rawStackMapTop;
            int i4 = i3 + 1;
            this.rawStackMapTop = i4;
            bArr[i3] = (byte) i2;
            if (i2 == 7 || i2 == 8) {
                this.rawStackMapTop = ClassFileWriter.putInt16(i >>> 8, bArr, i4);
            }
            return this.rawStackMapTop;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static char arrayTypeToName(int i) {
        switch (i) {
            case 4:
                return 'Z';
            case 5:
                return 'C';
            case 6:
                return 'F';
            case 7:
                return 'D';
            case 8:
                return 'B';
            case 9:
                return 'S';
            case 10:
                return 'I';
            case 11:
                return 'J';
            default:
                throw new IllegalArgumentException("bad operand");
        }
    }

    private static String classDescriptorToInternalName(String str) {
        return str.substring(1, str.length() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String descriptorToInternalName(String str) {
        char charAt = str.charAt(0);
        if (charAt != 'F') {
            if (charAt != 'L') {
                if (charAt == 'S' || charAt == 'V' || charAt == 'I' || charAt == 'J' || charAt == 'Z' || charAt == '[') {
                    return str;
                }
                switch (charAt) {
                    case 'B':
                    case 'C':
                    case 'D':
                        return str;
                    default:
                        throw new IllegalArgumentException("bad descriptor:" + str);
                }
            }
            return classDescriptorToInternalName(str);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int[] createInitialLocals() {
        /*
            r10 = this;
            short r0 = r10.itsMaxLocals
            int[] r0 = new int[r0]
            org.mozilla.classfile.ClassFileMethod r1 = r10.itsCurrentMethod
            short r1 = r1.getFlags()
            r1 = r1 & 8
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L2c
            org.mozilla.classfile.ClassFileMethod r1 = r10.itsCurrentMethod
            java.lang.String r1 = r1.getName()
            java.lang.String r4 = "<init>"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L22
            r1 = 6
            r0[r2] = r1
            goto L2a
        L22:
            short r1 = r10.itsThisClassIndex
            int r1 = org.mozilla.classfile.TypeInfo.OBJECT(r1)
            r0[r2] = r1
        L2a:
            r1 = 1
            goto L2d
        L2c:
            r1 = 0
        L2d:
            org.mozilla.classfile.ClassFileMethod r4 = r10.itsCurrentMethod
            java.lang.String r4 = r4.getType()
            r5 = 40
            int r5 = r4.indexOf(r5)
            r6 = 41
            int r6 = r4.indexOf(r6)
            if (r5 != 0) goto Lae
            if (r6 < 0) goto Lae
            int r5 = r5 + r3
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
        L49:
            if (r5 >= r6) goto Lad
            char r8 = r4.charAt(r5)
            r9 = 70
            if (r8 == r9) goto L85
            r9 = 76
            if (r8 == r9) goto L75
            r9 = 83
            if (r8 == r9) goto L85
            r9 = 73
            if (r8 == r9) goto L85
            r9 = 74
            if (r8 == r9) goto L85
            r9 = 90
            if (r8 == r9) goto L85
            r9 = 91
            if (r8 == r9) goto L6f
            switch(r8) {
                case 66: goto L85;
                case 67: goto L85;
                case 68: goto L85;
                default: goto L6e;
            }
        L6e:
            goto L8e
        L6f:
            r7.append(r9)
            int r5 = r5 + 1
            goto L49
        L75:
            r8 = 59
            int r8 = r4.indexOf(r8, r5)
            int r8 = r8 + r3
            java.lang.String r5 = r4.substring(r5, r8)
            r7.append(r5)
            r5 = r8
            goto L8e
        L85:
            char r8 = r4.charAt(r5)
            r7.append(r8)
            int r5 = r5 + 1
        L8e:
            java.lang.String r8 = r7.toString()
            java.lang.String r8 = descriptorToInternalName(r8)
            org.mozilla.classfile.ConstantPool r9 = r10.itsConstantPool
            int r8 = org.mozilla.classfile.TypeInfo.fromType(r8, r9)
            int r9 = r1 + 1
            r0[r1] = r8
            boolean r1 = org.mozilla.classfile.TypeInfo.isTwoWords(r8)
            if (r1 == 0) goto La8
            int r9 = r9 + 1
        La8:
            r1 = r9
            r7.setLength(r2)
            goto L49
        Lad:
            return r0
        Lae:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "bad method type"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.classfile.ClassFileWriter.createInitialLocals():int[]");
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write(toByteArray());
    }

    private int getWriteSize() {
        if (this.itsSourceFileNameIndex != 0) {
            this.itsConstantPool.addUtf8("SourceFile");
        }
        int writeSize = 8 + this.itsConstantPool.getWriteSize() + 2 + 2 + 2 + 2 + (this.itsInterfaces.size() * 2) + 2;
        for (int i = 0; i < this.itsFields.size(); i++) {
            writeSize += ((ClassFileField) this.itsFields.get(i)).getWriteSize();
        }
        int i2 = writeSize + 2;
        for (int i3 = 0; i3 < this.itsMethods.size(); i3++) {
            i2 += ((ClassFileMethod) this.itsMethods.get(i3)).getWriteSize();
        }
        if (this.itsSourceFileNameIndex != 0) {
            i2 = i2 + 2 + 2 + 4;
        }
        return i2 + 2;
    }

    public byte[] toByteArray() {
        int putInt16;
        int writeSize = getWriteSize();
        byte[] bArr = new byte[writeSize];
        short addUtf8 = this.itsSourceFileNameIndex != 0 ? this.itsConstantPool.addUtf8("SourceFile") : (short) 0;
        int putInt162 = putInt16(this.itsInterfaces.size(), bArr, putInt16(this.itsSuperClassIndex, bArr, putInt16(this.itsThisClassIndex, bArr, putInt16(this.itsFlags, bArr, this.itsConstantPool.write(bArr, putInt16(MajorVersion, bArr, putInt16(MinorVersion, bArr, putInt32(-889275714, bArr, 0))))))));
        for (int i = 0; i < this.itsInterfaces.size(); i++) {
            putInt162 = putInt16(((Short) this.itsInterfaces.get(i)).shortValue(), bArr, putInt162);
        }
        int putInt163 = putInt16(this.itsFields.size(), bArr, putInt162);
        for (int i2 = 0; i2 < this.itsFields.size(); i2++) {
            putInt163 = ((ClassFileField) this.itsFields.get(i2)).write(bArr, putInt163);
        }
        int putInt164 = putInt16(this.itsMethods.size(), bArr, putInt163);
        for (int i3 = 0; i3 < this.itsMethods.size(); i3++) {
            putInt164 = ((ClassFileMethod) this.itsMethods.get(i3)).write(bArr, putInt164);
        }
        if (this.itsSourceFileNameIndex != 0) {
            putInt16 = putInt16(this.itsSourceFileNameIndex, bArr, putInt32(2, bArr, putInt16(addUtf8, bArr, putInt16(1, bArr, putInt164))));
        } else {
            putInt16 = putInt16(0, bArr, putInt164);
        }
        if (putInt16 == writeSize) {
            return bArr;
        }
        throw new RuntimeException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int putInt64(long j, byte[] bArr, int i) {
        return putInt32((int) j, bArr, putInt32((int) (j >>> 32), bArr, i));
    }

    private static void badStack(int i) {
        String str;
        if (i < 0) {
            str = "Stack underflow: " + i;
        } else {
            str = "Too big stack: " + i;
        }
        throw new IllegalStateException(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int sizeOfParameters(java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.classfile.ClassFileWriter.sizeOfParameters(java.lang.String):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int putInt16(int i, byte[] bArr, int i2) {
        bArr[i2 + 0] = (byte) (i >>> 8);
        bArr[i2 + 1] = (byte) i;
        return i2 + 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int putInt32(int i, byte[] bArr, int i2) {
        bArr[i2 + 0] = (byte) (i >>> 24);
        bArr[i2 + 1] = (byte) (i >>> 16);
        bArr[i2 + 2] = (byte) (i >>> 8);
        bArr[i2 + 3] = (byte) i;
        return i2 + 4;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0037 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0038 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int opcodeLength(int r3, boolean r4) {
        /*
            r0 = 254(0xfe, float:3.56E-43)
            if (r3 == r0) goto L39
            r0 = 255(0xff, float:3.57E-43)
            if (r3 == r0) goto L39
            r0 = 5
            r1 = 2
            r2 = 3
            switch(r3) {
                case 0: goto L39;
                case 1: goto L39;
                case 2: goto L39;
                case 3: goto L39;
                case 4: goto L39;
                case 5: goto L39;
                case 6: goto L39;
                case 7: goto L39;
                case 8: goto L39;
                case 9: goto L39;
                case 10: goto L39;
                case 11: goto L39;
                case 12: goto L39;
                case 13: goto L39;
                case 14: goto L39;
                case 15: goto L39;
                case 16: goto L38;
                case 17: goto L37;
                case 18: goto L38;
                case 19: goto L37;
                case 20: goto L37;
                case 21: goto L33;
                case 22: goto L33;
                case 23: goto L33;
                case 24: goto L33;
                case 25: goto L33;
                case 26: goto L39;
                case 27: goto L39;
                case 28: goto L39;
                case 29: goto L39;
                case 30: goto L39;
                case 31: goto L39;
                case 32: goto L39;
                case 33: goto L39;
                case 34: goto L39;
                case 35: goto L39;
                case 36: goto L39;
                case 37: goto L39;
                case 38: goto L39;
                case 39: goto L39;
                case 40: goto L39;
                case 41: goto L39;
                case 42: goto L39;
                case 43: goto L39;
                case 44: goto L39;
                case 45: goto L39;
                case 46: goto L39;
                case 47: goto L39;
                case 48: goto L39;
                case 49: goto L39;
                case 50: goto L39;
                case 51: goto L39;
                case 52: goto L39;
                case 53: goto L39;
                case 54: goto L33;
                case 55: goto L33;
                case 56: goto L33;
                case 57: goto L33;
                case 58: goto L33;
                case 59: goto L39;
                case 60: goto L39;
                case 61: goto L39;
                case 62: goto L39;
                case 63: goto L39;
                case 64: goto L39;
                case 65: goto L39;
                case 66: goto L39;
                case 67: goto L39;
                case 68: goto L39;
                case 69: goto L39;
                case 70: goto L39;
                case 71: goto L39;
                case 72: goto L39;
                case 73: goto L39;
                case 74: goto L39;
                case 75: goto L39;
                case 76: goto L39;
                case 77: goto L39;
                case 78: goto L39;
                case 79: goto L39;
                case 80: goto L39;
                case 81: goto L39;
                case 82: goto L39;
                case 83: goto L39;
                case 84: goto L39;
                case 85: goto L39;
                case 86: goto L39;
                case 87: goto L39;
                case 88: goto L39;
                case 89: goto L39;
                case 90: goto L39;
                case 91: goto L39;
                case 92: goto L39;
                case 93: goto L39;
                case 94: goto L39;
                case 95: goto L39;
                case 96: goto L39;
                case 97: goto L39;
                case 98: goto L39;
                case 99: goto L39;
                case 100: goto L39;
                case 101: goto L39;
                case 102: goto L39;
                case 103: goto L39;
                case 104: goto L39;
                case 105: goto L39;
                case 106: goto L39;
                case 107: goto L39;
                case 108: goto L39;
                case 109: goto L39;
                case 110: goto L39;
                case 111: goto L39;
                case 112: goto L39;
                case 113: goto L39;
                case 114: goto L39;
                case 115: goto L39;
                case 116: goto L39;
                case 117: goto L39;
                case 118: goto L39;
                case 119: goto L39;
                case 120: goto L39;
                case 121: goto L39;
                case 122: goto L39;
                case 123: goto L39;
                case 124: goto L39;
                case 125: goto L39;
                case 126: goto L39;
                case 127: goto L39;
                case 128: goto L39;
                case 129: goto L39;
                case 130: goto L39;
                case 131: goto L39;
                case 132: goto L2e;
                case 133: goto L39;
                case 134: goto L39;
                case 135: goto L39;
                case 136: goto L39;
                case 137: goto L39;
                case 138: goto L39;
                case 139: goto L39;
                case 140: goto L39;
                case 141: goto L39;
                case 142: goto L39;
                case 143: goto L39;
                case 144: goto L39;
                case 145: goto L39;
                case 146: goto L39;
                case 147: goto L39;
                case 148: goto L39;
                case 149: goto L39;
                case 150: goto L39;
                case 151: goto L39;
                case 152: goto L39;
                case 153: goto L37;
                case 154: goto L37;
                case 155: goto L37;
                case 156: goto L37;
                case 157: goto L37;
                case 158: goto L37;
                case 159: goto L37;
                case 160: goto L37;
                case 161: goto L37;
                case 162: goto L37;
                case 163: goto L37;
                case 164: goto L37;
                case 165: goto L37;
                case 166: goto L37;
                case 167: goto L37;
                case 168: goto L37;
                case 169: goto L33;
                default: goto Le;
            }
        Le:
            switch(r3) {
                case 172: goto L39;
                case 173: goto L39;
                case 174: goto L39;
                case 175: goto L39;
                case 176: goto L39;
                case 177: goto L39;
                case 178: goto L37;
                case 179: goto L37;
                case 180: goto L37;
                case 181: goto L37;
                case 182: goto L37;
                case 183: goto L37;
                case 184: goto L37;
                case 185: goto L2d;
                default: goto L11;
            }
        L11:
            switch(r3) {
                case 187: goto L37;
                case 188: goto L38;
                case 189: goto L37;
                case 190: goto L39;
                case 191: goto L39;
                case 192: goto L37;
                case 193: goto L37;
                case 194: goto L39;
                case 195: goto L39;
                case 196: goto L39;
                case 197: goto L2b;
                case 198: goto L37;
                case 199: goto L37;
                case 200: goto L2d;
                case 201: goto L2d;
                case 202: goto L39;
                default: goto L14;
            }
        L14:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Bad opcode: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r4.<init>(r3)
            throw r4
        L2b:
            r3 = 4
            return r3
        L2d:
            return r0
        L2e:
            if (r4 == 0) goto L31
            goto L32
        L31:
            r0 = 3
        L32:
            return r0
        L33:
            if (r4 == 0) goto L36
            r1 = 3
        L36:
            return r1
        L37:
            return r2
        L38:
            return r1
        L39:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.classfile.ClassFileWriter.opcodeLength(int, boolean):int");
    }

    static int opcodeCount(int i) {
        if (i == 254 || i == 255) {
            return 0;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case 172:
            case 173:
            case 174:
            case 175:
            case 176:
            case 177:
                return 0;
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 167:
            case 168:
            case 169:
            case 178:
            case 179:
            case 180:
            case 181:
            case 182:
            case 183:
            case 184:
            case 185:
                return 1;
            case 132:
                return 2;
            case 170:
            case 171:
                return -1;
            default:
                switch (i) {
                    case 187:
                    case 188:
                    case 189:
                    case 192:
                    case 193:
                    case 198:
                    case 199:
                    case 200:
                    case 201:
                        return 1;
                    case 190:
                    case 191:
                    case 194:
                    case 195:
                    case 196:
                    case 202:
                        return 0;
                    case 197:
                        return 2;
                    default:
                        throw new IllegalArgumentException("Bad opcode: " + i);
                }
        }
    }

    static int stackChange(int i) {
        if (i == 254 || i == 255) {
            return 0;
        }
        switch (i) {
            case 0:
            case 47:
            case 49:
            case 95:
            case 116:
            case 117:
            case 118:
            case 119:
            case 132:
            case 134:
            case 138:
            case 139:
            case 143:
            case 145:
            case 146:
            case 147:
            case 167:
            case 169:
            case 177:
            case 178:
            case 179:
            case 184:
                return 0;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 12:
            case 13:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 23:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 34:
            case 35:
            case 36:
            case 37:
            case 42:
            case 43:
            case 44:
            case 45:
            case 89:
            case 90:
            case 91:
            case 133:
            case 135:
            case 140:
            case 141:
            case 168:
                return 1;
            case 9:
            case 10:
            case 14:
            case 15:
            case 20:
            case 22:
            case 24:
            case 30:
            case 31:
            case 32:
            case 33:
            case 38:
            case 39:
            case 40:
            case 41:
            case 92:
            case 93:
            case 94:
                return 2;
            case 46:
            case 48:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 56:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 67:
            case 68:
            case 69:
            case 70:
            case 75:
            case 76:
            case 77:
            case 78:
            case 87:
            case 96:
            case 98:
            case 100:
            case 102:
            case 104:
            case 106:
            case 108:
            case 110:
            case 112:
            case 114:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 128:
            case 130:
            case 136:
            case 137:
            case 142:
            case 144:
            case 149:
            case 150:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 170:
            case 171:
            case 172:
            case 174:
            case 176:
            case 180:
            case 181:
            case 182:
            case 183:
            case 185:
                return -1;
            case 55:
            case 57:
            case 63:
            case 64:
            case 65:
            case 66:
            case 71:
            case 72:
            case 73:
            case 74:
            case 88:
            case 97:
            case 99:
            case 101:
            case 103:
            case 105:
            case 107:
            case 109:
            case 111:
            case 113:
            case 115:
            case 127:
            case 129:
            case 131:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 173:
            case 175:
                return -2;
            case 79:
            case 81:
            case 83:
            case 84:
            case 85:
            case 86:
            case 148:
            case 151:
            case 152:
                return -3;
            case 80:
            case 82:
                return -4;
            default:
                switch (i) {
                    case 187:
                    case 197:
                    case 201:
                        return 1;
                    case 188:
                    case 189:
                    case 190:
                    case 192:
                    case 193:
                    case 196:
                    case 200:
                    case 202:
                        return 0;
                    case 191:
                    case 194:
                    case 195:
                    case 198:
                    case 199:
                        return -1;
                    default:
                        throw new IllegalArgumentException("Bad opcode: " + i);
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final char[] getCharBuffer(int i) {
        char[] cArr = this.tmpCharBuffer;
        if (i > cArr.length) {
            int length = cArr.length * 2;
            if (i <= length) {
                i = length;
            }
            this.tmpCharBuffer = new char[i];
        }
        return this.tmpCharBuffer;
    }

    private void addSuperBlockStart(int i) {
        if (GenerateStackMap) {
            int[] iArr = this.itsSuperBlockStarts;
            if (iArr == null) {
                this.itsSuperBlockStarts = new int[4];
            } else {
                int length = iArr.length;
                int i2 = this.itsSuperBlockStartsTop;
                if (length == i2) {
                    int[] iArr2 = new int[i2 * 2];
                    System.arraycopy(iArr, 0, iArr2, 0, i2);
                    this.itsSuperBlockStarts = iArr2;
                }
            }
            int[] iArr3 = this.itsSuperBlockStarts;
            int i3 = this.itsSuperBlockStartsTop;
            this.itsSuperBlockStartsTop = i3 + 1;
            iArr3[i3] = i;
        }
    }

    private void finalizeSuperBlockStarts() {
        if (GenerateStackMap) {
            for (int i = 0; i < this.itsExceptionTableTop; i++) {
                addSuperBlockStart((short) getLabelPC(this.itsExceptionTable[i].itsHandlerLabel));
            }
            Arrays.sort(this.itsSuperBlockStarts, 0, this.itsSuperBlockStartsTop);
            int i2 = this.itsSuperBlockStarts[0];
            int i3 = 1;
            for (int i4 = 1; i4 < this.itsSuperBlockStartsTop; i4++) {
                int[] iArr = this.itsSuperBlockStarts;
                int i5 = iArr[i4];
                if (i2 != i5) {
                    if (i3 != i4) {
                        iArr[i3] = i5;
                    }
                    i3++;
                    i2 = i5;
                }
            }
            this.itsSuperBlockStartsTop = i3;
            if (this.itsSuperBlockStarts[i3 - 1] == this.itsCodeBufferTop) {
                this.itsSuperBlockStartsTop = i3 - 1;
            }
        }
    }

    static {
        int i;
        byte[] bArr;
        InputStream inputStream = null;
        try {
            inputStream = ClassFileWriter.class.getResourceAsStream("ClassFileWriter.class");
            if (inputStream == null) {
                inputStream = ClassLoader.getSystemResourceAsStream("org/mozilla/classfile/ClassFileWriter.class");
            }
            bArr = new byte[8];
            int i2 = 0;
            while (i2 < 8) {
                int read = inputStream.read(bArr, i2, 8 - i2);
                if (read < 0) {
                    throw new IOException();
                }
                i2 += read;
            }
            i = (bArr[4] << 8) | (bArr[5] & 255);
        } catch (Exception unused) {
            i = 0;
        } catch (Throwable th) {
            th = th;
            i = 0;
        }
        try {
            int i3 = (bArr[7] & 255) | (bArr[6] << 8);
            MinorVersion = i;
            MajorVersion = i3;
            GenerateStackMap = i3 >= 50;
            if (inputStream == null) {
                return;
            }
        } catch (Exception unused2) {
            MinorVersion = i;
            MajorVersion = 48;
            GenerateStackMap = false;
            if (inputStream == null) {
                return;
            }
            inputStream.close();
        } catch (Throwable th2) {
            th = th2;
            MinorVersion = i;
            MajorVersion = 48;
            GenerateStackMap = false;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
        try {
            inputStream.close();
        } catch (IOException unused4) {
        }
    }
}
