package org.mozilla.javascript;

import com.applovin.sdk.AppLovinErrorCodes;
import com.google.common.base.Ascii;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.ast.ScriptNode;
import org.mozilla.javascript.debug.DebugFrame;

/* loaded from: classes5.dex */
public final class Interpreter extends Icode implements Evaluator {
    static final int EXCEPTION_HANDLER_SLOT = 2;
    static final int EXCEPTION_LOCAL_SLOT = 4;
    static final int EXCEPTION_SCOPE_SLOT = 5;
    static final int EXCEPTION_SLOT_SIZE = 6;
    static final int EXCEPTION_TRY_END_SLOT = 1;
    static final int EXCEPTION_TRY_START_SLOT = 0;
    static final int EXCEPTION_TYPE_SLOT = 3;
    InterpreterData itsData;

    static void dumpICode(InterpreterData interpreterData) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class CallFrame implements Cloneable, Serializable {
        static final long serialVersionUID = -2843792508994958978L;
        DebugFrame debuggerFrame;
        int emptyStackTop;
        InterpretedFunction fnOrScript;
        int frameIndex;
        boolean frozen;
        InterpreterData idata;
        boolean isContinuationsTopFrame;
        int localShift;
        CallFrame parentFrame;

        /* renamed from: pc */
        int f10719pc;
        int pcPrevBranch;
        int pcSourceLineStart;
        Object result;
        double resultDbl;
        double[] sDbl;
        int savedCallOp;
        int savedStackTop;
        Scriptable scope;
        Object[] stack;
        int[] stackAttributes;
        Scriptable thisObj;
        Object throwable;
        boolean useActivation;
        CallFrame varSource;

        private CallFrame() {
        }

        CallFrame cloneFrozen() {
            if (!this.frozen) {
                Kit.codeBug();
            }
            try {
                CallFrame callFrame = (CallFrame) clone();
                callFrame.stack = (Object[]) this.stack.clone();
                callFrame.stackAttributes = (int[]) this.stackAttributes.clone();
                callFrame.sDbl = (double[]) this.sDbl.clone();
                callFrame.frozen = false;
                return callFrame;
            } catch (CloneNotSupportedException unused) {
                throw new IllegalStateException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class ContinuationJump implements Serializable {
        static final long serialVersionUID = 7687739156004308247L;
        CallFrame branchFrame;
        CallFrame capturedFrame;
        Object result;
        double resultDbl;

        ContinuationJump(NativeContinuation nativeContinuation, CallFrame callFrame) {
            CallFrame callFrame2;
            CallFrame callFrame3 = (CallFrame) nativeContinuation.getImplementation();
            this.capturedFrame = callFrame3;
            if (callFrame3 == null || callFrame == null) {
                this.branchFrame = null;
                return;
            }
            int i = callFrame3.frameIndex - callFrame.frameIndex;
            if (i != 0) {
                if (i < 0) {
                    callFrame2 = this.capturedFrame;
                    i = -i;
                } else {
                    callFrame = callFrame3;
                    callFrame2 = callFrame;
                }
                do {
                    callFrame = callFrame.parentFrame;
                    i--;
                } while (i != 0);
                if (callFrame.frameIndex != callFrame2.frameIndex) {
                    Kit.codeBug();
                }
                callFrame = callFrame2;
                callFrame3 = callFrame;
            }
            while (callFrame3 != callFrame && callFrame3 != null) {
                callFrame3 = callFrame3.parentFrame;
                callFrame = callFrame.parentFrame;
            }
            this.branchFrame = callFrame3;
            if (callFrame3 == null || callFrame3.frozen) {
                return;
            }
            Kit.codeBug();
        }
    }

    private static CallFrame captureFrameForGenerator(CallFrame callFrame) {
        callFrame.frozen = true;
        CallFrame cloneFrozen = callFrame.cloneFrozen();
        callFrame.frozen = false;
        cloneFrozen.parentFrame = null;
        cloneFrozen.frameIndex = 0;
        return cloneFrozen;
    }

    @Override // org.mozilla.javascript.Evaluator
    public Object compile(CompilerEnvirons compilerEnvirons, ScriptNode scriptNode, String str, boolean z) {
        InterpreterData compile = new CodeGenerator().compile(compilerEnvirons, scriptNode, str, z);
        this.itsData = compile;
        return compile;
    }

    @Override // org.mozilla.javascript.Evaluator
    public Script createScriptObject(Object obj, Object obj2) {
        if (obj != this.itsData) {
            Kit.codeBug();
        }
        return InterpretedFunction.createScript(this.itsData, obj2);
    }

    @Override // org.mozilla.javascript.Evaluator
    public void setEvalScriptFlag(Script script) {
        ((InterpretedFunction) script).idata.evalScriptFlag = true;
    }

    @Override // org.mozilla.javascript.Evaluator
    public Function createFunctionObject(Context context, Scriptable scriptable, Object obj, Object obj2) {
        if (obj != this.itsData) {
            Kit.codeBug();
        }
        return InterpretedFunction.createFunction(context, scriptable, this.itsData, obj2);
    }

    private static int getShort(byte[] bArr, int i) {
        return (bArr[i + 1] & 255) | (bArr[i] << 8);
    }

    private static int getIndex(byte[] bArr, int i) {
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    private static int getInt(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | (bArr[i] << Ascii.CAN) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    private static int getExceptionHandler(CallFrame callFrame, boolean z) {
        int[] iArr = callFrame.idata.itsExceptionTable;
        int i = -1;
        if (iArr == null) {
            return -1;
        }
        int i2 = callFrame.f10719pc - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 != iArr.length; i5 += 6) {
            int i6 = iArr[i5 + 0];
            int i7 = iArr[i5 + 1];
            if (i6 <= i2 && i2 < i7 && (!z || iArr[i5 + 3] == 1)) {
                if (i >= 0) {
                    if (i3 >= i7) {
                        if (i4 > i6) {
                            Kit.codeBug();
                        }
                        if (i3 == i7) {
                            Kit.codeBug();
                        }
                    }
                }
                i = i5;
                i4 = i6;
                i3 = i7;
            }
        }
        return i;
    }

    private static int bytecodeSpan(int i) {
        if (i != -54 && i != -23) {
            if (i != -21) {
                if (i != 50) {
                    if (i != 57) {
                        if (i != 72 && i != 5 && i != 6 && i != 7) {
                            switch (i) {
                                case -63:
                                case -62:
                                    break;
                                case -61:
                                    break;
                                default:
                                    switch (i) {
                                        case -49:
                                        case -48:
                                            break;
                                        case -47:
                                            return 5;
                                        case -46:
                                            return 3;
                                        case -45:
                                            return 2;
                                        default:
                                            switch (i) {
                                                case -40:
                                                    return 5;
                                                case -39:
                                                    return 3;
                                                case -38:
                                                    return 2;
                                                default:
                                                    switch (i) {
                                                        case -28:
                                                            return 5;
                                                        case -27:
                                                        case -26:
                                                            return 3;
                                                        default:
                                                            switch (i) {
                                                                case -11:
                                                                case -10:
                                                                case -9:
                                                                case AppLovinErrorCodes.INVALID_AD_TOKEN /* -8 */:
                                                                case AppLovinErrorCodes.INVALID_ZONE /* -7 */:
                                                                    return 2;
                                                                case AppLovinErrorCodes.UNABLE_TO_RENDER_AD /* -6 */:
                                                                    break;
                                                                default:
                                                                    if (validBytecode(i)) {
                                                                        return 1;
                                                                    }
                                                                    throw Kit.codeBug();
                                                            }
                                                    }
                                            }
                                    }
                            }
                        }
                    }
                    return 2;
                }
                return 3;
            }
            return 5;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] getLineNumbers(InterpreterData interpreterData) {
        UintMap uintMap = new UintMap();
        byte[] bArr = interpreterData.itsICode;
        int length = bArr.length;
        int i = 0;
        while (i != length) {
            byte b = bArr[i];
            int bytecodeSpan = bytecodeSpan(b);
            if (b == -26) {
                if (bytecodeSpan != 3) {
                    Kit.codeBug();
                }
                uintMap.put(getIndex(bArr, i + 1), 0);
            }
            i += bytecodeSpan;
        }
        return uintMap.getKeys();
    }

    @Override // org.mozilla.javascript.Evaluator
    public void captureStackInfo(RhinoException rhinoException) {
        CallFrame[] callFrameArr;
        Context currentContext = Context.getCurrentContext();
        if (currentContext == null || currentContext.lastInterpreterFrame == null) {
            rhinoException.interpreterStackInfo = null;
            rhinoException.interpreterLineData = null;
            return;
        }
        if (currentContext.previousInterpreterInvocations == null || currentContext.previousInterpreterInvocations.size() == 0) {
            callFrameArr = new CallFrame[1];
        } else {
            int size = currentContext.previousInterpreterInvocations.size();
            if (currentContext.previousInterpreterInvocations.peek() == currentContext.lastInterpreterFrame) {
                size--;
            }
            callFrameArr = new CallFrame[size + 1];
            currentContext.previousInterpreterInvocations.toArray(callFrameArr);
        }
        callFrameArr[callFrameArr.length - 1] = (CallFrame) currentContext.lastInterpreterFrame;
        int i = 0;
        for (int i2 = 0; i2 != callFrameArr.length; i2++) {
            i += callFrameArr[i2].frameIndex + 1;
        }
        int[] iArr = new int[i];
        int length = callFrameArr.length;
        while (length != 0) {
            length--;
            for (CallFrame callFrame = callFrameArr[length]; callFrame != null; callFrame = callFrame.parentFrame) {
                i--;
                iArr[i] = callFrame.pcSourceLineStart;
            }
        }
        if (i != 0) {
            Kit.codeBug();
        }
        rhinoException.interpreterStackInfo = callFrameArr;
        rhinoException.interpreterLineData = iArr;
    }

    @Override // org.mozilla.javascript.Evaluator
    public String getSourcePositionFromStack(Context context, int[] iArr) {
        CallFrame callFrame = (CallFrame) context.lastInterpreterFrame;
        InterpreterData interpreterData = callFrame.idata;
        if (callFrame.pcSourceLineStart >= 0) {
            iArr[0] = getIndex(interpreterData.itsICode, callFrame.pcSourceLineStart);
        } else {
            iArr[0] = 0;
        }
        return interpreterData.itsSourceFile;
    }

    @Override // org.mozilla.javascript.Evaluator
    public String getPatchedStack(RhinoException rhinoException, String str) {
        char charAt;
        StringBuffer stringBuffer = new StringBuffer(str.length() + 1000);
        String systemProperty = SecurityUtilities.getSystemProperty("line.separator");
        CallFrame[] callFrameArr = (CallFrame[]) rhinoException.interpreterStackInfo;
        int[] iArr = rhinoException.interpreterLineData;
        int length = callFrameArr.length;
        int length2 = iArr.length;
        int i = 0;
        while (length != 0) {
            length--;
            int indexOf = str.indexOf("org.mozilla.javascript.Interpreter.interpretLoop", i);
            if (indexOf < 0) {
                break;
            }
            int i2 = indexOf + 48;
            while (i2 != str.length() && (charAt = str.charAt(i2)) != '\n' && charAt != '\r') {
                i2++;
            }
            stringBuffer.append(str.substring(i, i2));
            for (CallFrame callFrame = callFrameArr[length]; callFrame != null; callFrame = callFrame.parentFrame) {
                if (length2 == 0) {
                    Kit.codeBug();
                }
                length2--;
                InterpreterData interpreterData = callFrame.idata;
                stringBuffer.append(systemProperty);
                stringBuffer.append("\tat script");
                if (interpreterData.itsName != null && interpreterData.itsName.length() != 0) {
                    stringBuffer.append('.');
                    stringBuffer.append(interpreterData.itsName);
                }
                stringBuffer.append('(');
                stringBuffer.append(interpreterData.itsSourceFile);
                int i3 = iArr[length2];
                if (i3 >= 0) {
                    stringBuffer.append(':');
                    stringBuffer.append(getIndex(interpreterData.itsICode, i3));
                }
                stringBuffer.append(')');
            }
            i = i2;
        }
        stringBuffer.append(str.substring(i));
        return stringBuffer.toString();
    }

    @Override // org.mozilla.javascript.Evaluator
    public List<String> getScriptStack(RhinoException rhinoException) {
        ScriptStackElement[][] scriptStackElements = getScriptStackElements(rhinoException);
        ArrayList arrayList = new ArrayList(scriptStackElements.length);
        String systemProperty = SecurityUtilities.getSystemProperty("line.separator");
        for (ScriptStackElement[] scriptStackElementArr : scriptStackElements) {
            StringBuilder sb = new StringBuilder();
            for (ScriptStackElement scriptStackElement : scriptStackElementArr) {
                scriptStackElement.renderJavaStyle(sb);
                sb.append(systemProperty);
            }
            arrayList.add(sb.toString());
        }
        return arrayList;
    }

    public ScriptStackElement[][] getScriptStackElements(RhinoException rhinoException) {
        if (rhinoException.interpreterStackInfo == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        CallFrame[] callFrameArr = (CallFrame[]) rhinoException.interpreterStackInfo;
        int[] iArr = rhinoException.interpreterLineData;
        int length = callFrameArr.length;
        int length2 = iArr.length;
        while (length != 0) {
            length--;
            CallFrame callFrame = callFrameArr[length];
            ArrayList arrayList2 = new ArrayList();
            while (callFrame != null) {
                if (length2 == 0) {
                    Kit.codeBug();
                }
                length2--;
                InterpreterData interpreterData = callFrame.idata;
                String str = interpreterData.itsSourceFile;
                int i = iArr[length2];
                int index = i >= 0 ? getIndex(interpreterData.itsICode, i) : -1;
                String str2 = (interpreterData.itsName == null || interpreterData.itsName.length() == 0) ? null : interpreterData.itsName;
                callFrame = callFrame.parentFrame;
                arrayList2.add(new ScriptStackElement(str, str2, index));
            }
            arrayList.add(arrayList2.toArray(new ScriptStackElement[arrayList2.size()]));
        }
        return (ScriptStackElement[][]) arrayList.toArray(new ScriptStackElement[arrayList.size()]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getEncodedSource(InterpreterData interpreterData) {
        if (interpreterData.encodedSource == null) {
            return null;
        }
        return interpreterData.encodedSource.substring(interpreterData.encodedSourceStart, interpreterData.encodedSourceEnd);
    }

    private static void initFunction(Context context, Scriptable scriptable, InterpretedFunction interpretedFunction, int i) {
        InterpretedFunction createFunction = InterpretedFunction.createFunction(context, scriptable, interpretedFunction, i);
        ScriptRuntime.initFunction(context, scriptable, createFunction, createFunction.idata.itsFunctionType, interpretedFunction.idata.evalScriptFlag);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object interpret(InterpretedFunction interpretedFunction, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!ScriptRuntime.hasTopCall(context)) {
            Kit.codeBug();
        }
        if (context.interpreterSecurityDomain != interpretedFunction.securityDomain) {
            Object obj = context.interpreterSecurityDomain;
            context.interpreterSecurityDomain = interpretedFunction.securityDomain;
            try {
                return interpretedFunction.securityController.callWithDomain(interpretedFunction.securityDomain, context, interpretedFunction, scriptable, scriptable2, objArr);
            } finally {
                context.interpreterSecurityDomain = obj;
            }
        }
        CallFrame callFrame = new CallFrame();
        initFrame(context, scriptable, scriptable2, objArr, null, 0, objArr.length, interpretedFunction, null, callFrame);
        callFrame.isContinuationsTopFrame = context.isContinuationsTopCall;
        context.isContinuationsTopCall = false;
        return interpretLoop(context, callFrame, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class GeneratorState {
        int operation;
        RuntimeException returnedException;
        Object value;

        GeneratorState(int i, Object obj) {
            this.operation = i;
            this.value = obj;
        }
    }

    public static Object resumeGenerator(Context context, Scriptable scriptable, int i, Object obj, Object obj2) {
        CallFrame callFrame = (CallFrame) obj;
        GeneratorState generatorState = new GeneratorState(i, obj2);
        if (i == 2) {
            try {
                return interpretLoop(context, callFrame, generatorState);
            } catch (RuntimeException e) {
                if (e != obj2) {
                    throw e;
                }
                return Undefined.instance;
            }
        }
        Object interpretLoop = interpretLoop(context, callFrame, generatorState);
        if (generatorState.returnedException == null) {
            return interpretLoop;
        }
        throw generatorState.returnedException;
    }

    public static Object restartContinuation(NativeContinuation nativeContinuation, Context context, Scriptable scriptable, Object[] objArr) {
        Object obj;
        if (!ScriptRuntime.hasTopCall(context)) {
            return ScriptRuntime.doTopCall(nativeContinuation, context, scriptable, null, objArr);
        }
        if (objArr.length == 0) {
            obj = Undefined.instance;
        } else {
            obj = objArr[0];
        }
        if (((CallFrame) nativeContinuation.getImplementation()) == null) {
            return obj;
        }
        ContinuationJump continuationJump = new ContinuationJump(nativeContinuation, null);
        continuationJump.result = obj;
        return interpretLoop(context, null, continuationJump);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:27|28|29|30|31|32|(1:34)(2:1006|1007)|991|992|993|381|210|211|212) */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x041d, code lost:
        r1 = r8;
        r42 = r10;
        r3 = r12;
        r5 = r13;
        r14 = r15;
        r31 = r40;
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0425, code lost:
        r2 = null;
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x0e59, code lost:
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:561:0x15cb, code lost:
        r2 = r13;
        r9 = r14;
        r12 = r15;
        r1 = r22;
        r14 = r31;
        r4 = r37;
        r13 = r40;
        r8 = r41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:633:0x17f1, code lost:
        exitFrame(r3, r12, r2);
        r4 = r12.result;
     */
    /* JADX WARN: Code restructure failed: missing block: B:634:0x17f6, code lost:
        r9 = r12.resultDbl;
     */
    /* JADX WARN: Code restructure failed: missing block: B:636:0x17fa, code lost:
        if (r12.parentFrame == null) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:637:0x17fc, code lost:
        r6 = r12.parentFrame;
     */
    /* JADX WARN: Code restructure failed: missing block: B:639:0x1800, code lost:
        if (r6.frozen == false) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:640:0x1802, code lost:
        r6 = r6.cloneFrozen();
     */
    /* JADX WARN: Code restructure failed: missing block: B:641:0x1806, code lost:
        setCallResult(r6, r4, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:642:0x1809, code lost:
        r8 = r1;
        r19 = r2;
        r12 = r3;
        r3 = r6;
        r4 = r7;
        r20 = r9;
        r1 = r22;
        r14 = r31;
        r10 = r42;
        r9 = r19;
        r2 = r13;
        r13 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:643:0x181e, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:644:0x181f, code lost:
        r19 = r4;
        r11 = r6;
        r14 = r7;
        r20 = r9;
        r0 = r0;
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:645:0x1827, code lost:
        r20 = r9;
        r9 = r22;
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:646:0x182d, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:647:0x182e, code lost:
        r19 = r4;
        r14 = r7;
        r20 = r9;
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:648:0x1835, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:649:0x1836, code lost:
        r19 = r4;
        r14 = r7;
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:661:0x18b6, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:698:0x191b, code lost:
        if (r3.hasFeature(13) != false) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:700:0x191f, code lost:
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:712:0x193d, code lost:
        if (r3.hasFeature(13) != false) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:738:0x197c, code lost:
        r10 = r42;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:1045:0x1987 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x1010 A[Catch: all -> 0x1273, TryCatch #39 {all -> 0x1273, blocks: (B:375:0x0ffe, B:377:0x1010, B:383:0x1037, B:380:0x1025, B:382:0x1031, B:434:0x12a0, B:425:0x1252, B:458:0x13d0, B:464:0x13ea, B:448:0x1389, B:450:0x138f, B:452:0x1397, B:455:0x13ad, B:453:0x139f, B:392:0x10bd, B:393:0x10e0, B:394:0x1103, B:396:0x1129, B:397:0x1145, B:398:0x1160, B:399:0x117b, B:414:0x11f5, B:418:0x121d, B:424:0x1249, B:433:0x127f, B:435:0x12b5, B:437:0x12d4, B:438:0x12f4, B:439:0x1316, B:441:0x1333, B:442:0x1339, B:443:0x1344, B:445:0x1369, B:446:0x1383), top: B:848:0x0ffe }] */
    /* JADX WARN: Removed duplicated region for block: B:378:0x1021  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:448:0x1389 A[Catch: all -> 0x1273, TryCatch #39 {all -> 0x1273, blocks: (B:375:0x0ffe, B:377:0x1010, B:383:0x1037, B:380:0x1025, B:382:0x1031, B:434:0x12a0, B:425:0x1252, B:458:0x13d0, B:464:0x13ea, B:448:0x1389, B:450:0x138f, B:452:0x1397, B:455:0x13ad, B:453:0x139f, B:392:0x10bd, B:393:0x10e0, B:394:0x1103, B:396:0x1129, B:397:0x1145, B:398:0x1160, B:399:0x117b, B:414:0x11f5, B:418:0x121d, B:424:0x1249, B:433:0x127f, B:435:0x12b5, B:437:0x12d4, B:438:0x12f4, B:439:0x1316, B:441:0x1333, B:442:0x1339, B:443:0x1344, B:445:0x1369, B:446:0x1383), top: B:848:0x0ffe }] */
    /* JADX WARN: Removed duplicated region for block: B:449:0x138e  */
    /* JADX WARN: Removed duplicated region for block: B:452:0x1397 A[Catch: all -> 0x1273, TryCatch #39 {all -> 0x1273, blocks: (B:375:0x0ffe, B:377:0x1010, B:383:0x1037, B:380:0x1025, B:382:0x1031, B:434:0x12a0, B:425:0x1252, B:458:0x13d0, B:464:0x13ea, B:448:0x1389, B:450:0x138f, B:452:0x1397, B:455:0x13ad, B:453:0x139f, B:392:0x10bd, B:393:0x10e0, B:394:0x1103, B:396:0x1129, B:397:0x1145, B:398:0x1160, B:399:0x117b, B:414:0x11f5, B:418:0x121d, B:424:0x1249, B:433:0x127f, B:435:0x12b5, B:437:0x12d4, B:438:0x12f4, B:439:0x1316, B:441:0x1333, B:442:0x1339, B:443:0x1344, B:445:0x1369, B:446:0x1383), top: B:848:0x0ffe }] */
    /* JADX WARN: Removed duplicated region for block: B:453:0x139f A[Catch: all -> 0x1273, TryCatch #39 {all -> 0x1273, blocks: (B:375:0x0ffe, B:377:0x1010, B:383:0x1037, B:380:0x1025, B:382:0x1031, B:434:0x12a0, B:425:0x1252, B:458:0x13d0, B:464:0x13ea, B:448:0x1389, B:450:0x138f, B:452:0x1397, B:455:0x13ad, B:453:0x139f, B:392:0x10bd, B:393:0x10e0, B:394:0x1103, B:396:0x1129, B:397:0x1145, B:398:0x1160, B:399:0x117b, B:414:0x11f5, B:418:0x121d, B:424:0x1249, B:433:0x127f, B:435:0x12b5, B:437:0x12d4, B:438:0x12f4, B:439:0x1316, B:441:0x1333, B:442:0x1339, B:443:0x1344, B:445:0x1369, B:446:0x1383), top: B:848:0x0ffe }] */
    /* JADX WARN: Removed duplicated region for block: B:455:0x13ad A[Catch: all -> 0x1273, TryCatch #39 {all -> 0x1273, blocks: (B:375:0x0ffe, B:377:0x1010, B:383:0x1037, B:380:0x1025, B:382:0x1031, B:434:0x12a0, B:425:0x1252, B:458:0x13d0, B:464:0x13ea, B:448:0x1389, B:450:0x138f, B:452:0x1397, B:455:0x13ad, B:453:0x139f, B:392:0x10bd, B:393:0x10e0, B:394:0x1103, B:396:0x1129, B:397:0x1145, B:398:0x1160, B:399:0x117b, B:414:0x11f5, B:418:0x121d, B:424:0x1249, B:433:0x127f, B:435:0x12b5, B:437:0x12d4, B:438:0x12f4, B:439:0x1316, B:441:0x1333, B:442:0x1339, B:443:0x1344, B:445:0x1369, B:446:0x1383), top: B:848:0x0ffe }] */
    /* JADX WARN: Removed duplicated region for block: B:458:0x13d0 A[Catch: all -> 0x1273, TRY_LEAVE, TryCatch #39 {all -> 0x1273, blocks: (B:375:0x0ffe, B:377:0x1010, B:383:0x1037, B:380:0x1025, B:382:0x1031, B:434:0x12a0, B:425:0x1252, B:458:0x13d0, B:464:0x13ea, B:448:0x1389, B:450:0x138f, B:452:0x1397, B:455:0x13ad, B:453:0x139f, B:392:0x10bd, B:393:0x10e0, B:394:0x1103, B:396:0x1129, B:397:0x1145, B:398:0x1160, B:399:0x117b, B:414:0x11f5, B:418:0x121d, B:424:0x1249, B:433:0x127f, B:435:0x12b5, B:437:0x12d4, B:438:0x12f4, B:439:0x1316, B:441:0x1333, B:442:0x1339, B:443:0x1344, B:445:0x1369, B:446:0x1383), top: B:848:0x0ffe }] */
    /* JADX WARN: Removed duplicated region for block: B:463:0x13e8  */
    /* JADX WARN: Removed duplicated region for block: B:466:0x1401 A[Catch: all -> 0x1629, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x1629, blocks: (B:460:0x13da, B:466:0x1401), top: B:784:0x13da }] */
    /* JADX WARN: Removed duplicated region for block: B:677:0x18ee  */
    /* JADX WARN: Removed duplicated region for block: B:679:0x18f3  */
    /* JADX WARN: Removed duplicated region for block: B:685:0x18ff  */
    /* JADX WARN: Removed duplicated region for block: B:689:0x1907  */
    /* JADX WARN: Removed duplicated region for block: B:697:0x1915  */
    /* JADX WARN: Removed duplicated region for block: B:702:0x1922  */
    /* JADX WARN: Removed duplicated region for block: B:715:0x1942  */
    /* JADX WARN: Removed duplicated region for block: B:724:0x1954  */
    /* JADX WARN: Removed duplicated region for block: B:732:0x1967  */
    /* JADX WARN: Removed duplicated region for block: B:757:0x19bb  */
    /* JADX WARN: Removed duplicated region for block: B:763:0x19c5  */
    /* JADX WARN: Removed duplicated region for block: B:767:0x19cd  */
    /* JADX WARN: Removed duplicated region for block: B:808:0x17b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:828:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:883:0x19e2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:898:0x17ac A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:909:0x1872 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v134 */
    /* JADX WARN: Type inference failed for: r11v183 */
    /* JADX WARN: Type inference failed for: r11v197 */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r1v51 */
    /* JADX WARN: Type inference failed for: r1v54, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r29v0, types: [int[]] */
    /* JADX WARN: Type inference failed for: r29v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r2v143, types: [org.mozilla.javascript.Interpreter$ContinuationJump] */
    /* JADX WARN: Type inference failed for: r2v280 */
    /* JADX WARN: Type inference failed for: r2v281 */
    /* JADX WARN: Type inference failed for: r2v282 */
    /* JADX WARN: Type inference failed for: r2v6, types: [org.mozilla.javascript.ObjArray, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v240 */
    /* JADX WARN: Type inference failed for: r7v36 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16, types: [org.mozilla.javascript.Interpreter$ContinuationJump] */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Object interpretLoop(org.mozilla.javascript.Context r46, org.mozilla.javascript.Interpreter.CallFrame r47, java.lang.Object r48) {
        /*
            Method dump skipped, instructions count: 6936
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Interpreter.interpretLoop(org.mozilla.javascript.Context, org.mozilla.javascript.Interpreter$CallFrame, java.lang.Object):java.lang.Object");
    }

    private static int doInOrInstanceof(Context context, int i, Object[] objArr, double[] dArr, int i2) {
        boolean instanceOf;
        Object obj = objArr[i2];
        if (obj == UniqueTag.DOUBLE_MARK) {
            obj = ScriptRuntime.wrapNumber(dArr[i2]);
        }
        int i3 = i2 - 1;
        Object obj2 = objArr[i3];
        if (obj2 == UniqueTag.DOUBLE_MARK) {
            obj2 = ScriptRuntime.wrapNumber(dArr[i3]);
        }
        if (i == 52) {
            instanceOf = ScriptRuntime.m47in(obj2, obj, context);
        } else {
            instanceOf = ScriptRuntime.instanceOf(obj2, obj, context);
        }
        objArr[i3] = ScriptRuntime.wrapBoolean(instanceOf);
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
        if (r2 >= r0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        if (r2 > r0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
        if (r2 <= r0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
        if (r2 < r0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int doCompare(org.mozilla.javascript.Interpreter.CallFrame r4, int r5, java.lang.Object[] r6, double[] r7, int r8) {
        /*
            int r8 = r8 + (-1)
            int r0 = r8 + 1
            r1 = r6[r0]
            r2 = r6[r8]
            org.mozilla.javascript.UniqueTag r3 = org.mozilla.javascript.UniqueTag.DOUBLE_MARK
            if (r1 != r3) goto L13
            r0 = r7[r0]
            double r2 = stack_double(r4, r8)
            goto L1d
        L13:
            org.mozilla.javascript.UniqueTag r4 = org.mozilla.javascript.UniqueTag.DOUBLE_MARK
            if (r2 != r4) goto L3c
            double r0 = org.mozilla.javascript.ScriptRuntime.toNumber(r1)
            r2 = r7[r8]
        L1d:
            r4 = 0
            r7 = 1
            switch(r5) {
                case 14: goto L37;
                case 15: goto L32;
                case 16: goto L2d;
                case 17: goto L27;
                default: goto L22;
            }
        L22:
            java.lang.RuntimeException r4 = org.mozilla.javascript.Kit.codeBug()
            throw r4
        L27:
            int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r5 < 0) goto L57
        L2b:
            r4 = 1
            goto L57
        L2d:
            int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r5 <= 0) goto L57
            goto L2b
        L32:
            int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r5 > 0) goto L57
            goto L2b
        L37:
            int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r5 >= 0) goto L57
            goto L2b
        L3c:
            switch(r5) {
                case 14: goto L53;
                case 15: goto L4e;
                case 16: goto L49;
                case 17: goto L44;
                default: goto L3f;
            }
        L3f:
            java.lang.RuntimeException r4 = org.mozilla.javascript.Kit.codeBug()
            throw r4
        L44:
            boolean r4 = org.mozilla.javascript.ScriptRuntime.cmp_LE(r1, r2)
            goto L57
        L49:
            boolean r4 = org.mozilla.javascript.ScriptRuntime.cmp_LT(r1, r2)
            goto L57
        L4e:
            boolean r4 = org.mozilla.javascript.ScriptRuntime.cmp_LE(r2, r1)
            goto L57
        L53:
            boolean r4 = org.mozilla.javascript.ScriptRuntime.cmp_LT(r2, r1)
        L57:
            java.lang.Boolean r4 = org.mozilla.javascript.ScriptRuntime.wrapBoolean(r4)
            r6[r8] = r4
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Interpreter.doCompare(org.mozilla.javascript.Interpreter$CallFrame, int, java.lang.Object[], double[], int):int");
    }

    private static int doBitOp(CallFrame callFrame, int i, Object[] objArr, double[] dArr, int i2) {
        int stack_int32 = stack_int32(callFrame, i2 - 1);
        int stack_int322 = stack_int32(callFrame, i2);
        int i3 = i2 - 1;
        objArr[i3] = UniqueTag.DOUBLE_MARK;
        if (i == 18) {
            stack_int32 <<= stack_int322;
        } else if (i != 19) {
            switch (i) {
                case 9:
                    stack_int32 |= stack_int322;
                    break;
                case 10:
                    stack_int32 ^= stack_int322;
                    break;
                case 11:
                    stack_int32 &= stack_int322;
                    break;
            }
        } else {
            stack_int32 >>= stack_int322;
        }
        dArr[i3] = stack_int32;
        return i3;
    }

    private static int doDelName(Context context, int i, Object[] objArr, double[] dArr, int i2) {
        Object obj = objArr[i2];
        if (obj == UniqueTag.DOUBLE_MARK) {
            obj = ScriptRuntime.wrapNumber(dArr[i2]);
        }
        int i3 = i2 - 1;
        Object obj2 = objArr[i3];
        if (obj2 == UniqueTag.DOUBLE_MARK) {
            obj2 = ScriptRuntime.wrapNumber(dArr[i3]);
        }
        objArr[i3] = ScriptRuntime.delete(obj2, obj, context, i == 0);
        return i3;
    }

    private static int doGetElem(Context context, CallFrame callFrame, Object[] objArr, double[] dArr, int i) {
        Object objectIndex;
        int i2 = i - 1;
        Object obj = objArr[i2];
        if (obj == UniqueTag.DOUBLE_MARK) {
            obj = ScriptRuntime.wrapNumber(dArr[i2]);
        }
        int i3 = i2 + 1;
        Object obj2 = objArr[i3];
        if (obj2 != UniqueTag.DOUBLE_MARK) {
            objectIndex = ScriptRuntime.getObjectElem(obj, obj2, context, callFrame.scope);
        } else {
            objectIndex = ScriptRuntime.getObjectIndex(obj, dArr[i3], context);
        }
        objArr[i2] = objectIndex;
        return i2;
    }

    private static int doSetElem(Context context, Object[] objArr, double[] dArr, int i) {
        Object objectIndex;
        int i2 = i - 2;
        int i3 = i2 + 2;
        Object obj = objArr[i3];
        if (obj == UniqueTag.DOUBLE_MARK) {
            obj = ScriptRuntime.wrapNumber(dArr[i3]);
        }
        Object obj2 = objArr[i2];
        if (obj2 == UniqueTag.DOUBLE_MARK) {
            obj2 = ScriptRuntime.wrapNumber(dArr[i2]);
        }
        int i4 = i2 + 1;
        Object obj3 = objArr[i4];
        if (obj3 != UniqueTag.DOUBLE_MARK) {
            objectIndex = ScriptRuntime.setObjectElem(obj2, obj3, obj, context);
        } else {
            objectIndex = ScriptRuntime.setObjectIndex(obj2, dArr[i4], obj, context);
        }
        objArr[i2] = objectIndex;
        return i2;
    }

    private static int doElemIncDec(Context context, CallFrame callFrame, byte[] bArr, Object[] objArr, double[] dArr, int i) {
        Object obj = objArr[i];
        if (obj == UniqueTag.DOUBLE_MARK) {
            obj = ScriptRuntime.wrapNumber(dArr[i]);
        }
        int i2 = i - 1;
        Object obj2 = objArr[i2];
        if (obj2 == UniqueTag.DOUBLE_MARK) {
            obj2 = ScriptRuntime.wrapNumber(dArr[i2]);
        }
        objArr[i2] = ScriptRuntime.elemIncrDecr(obj2, obj, context, bArr[callFrame.f10719pc]);
        callFrame.f10719pc++;
        return i2;
    }

    private static int doCallSpecial(Context context, CallFrame callFrame, Object[] objArr, double[] dArr, int i, byte[] bArr, int i2) {
        int i3;
        int i4 = bArr[callFrame.f10719pc] & 255;
        boolean z = bArr[callFrame.f10719pc + 1] != 0;
        int index = getIndex(bArr, callFrame.f10719pc + 2);
        if (z) {
            i3 = i - i2;
            Object obj = objArr[i3];
            if (obj == UniqueTag.DOUBLE_MARK) {
                obj = ScriptRuntime.wrapNumber(dArr[i3]);
            }
            objArr[i3] = ScriptRuntime.newSpecial(context, obj, getArgsArray(objArr, dArr, i3 + 1, i2), callFrame.scope, i4);
        } else {
            i3 = i - (i2 + 1);
            objArr[i3] = ScriptRuntime.callSpecial(context, (Callable) objArr[i3], (Scriptable) objArr[i3 + 1], getArgsArray(objArr, dArr, i3 + 2, i2), callFrame.scope, callFrame.thisObj, i4, callFrame.idata.itsSourceFile, index);
        }
        callFrame.f10719pc += 4;
        return i3;
    }

    private static int doSetConstVar(CallFrame callFrame, Object[] objArr, double[] dArr, int i, Object[] objArr2, double[] dArr2, int[] iArr, int i2) {
        if (!callFrame.useActivation) {
            if ((iArr[i2] & 1) == 0) {
                throw Context.reportRuntimeError1("msg.var.redecl", callFrame.idata.argNames[i2]);
            }
            if ((iArr[i2] & 8) != 0) {
                objArr2[i2] = objArr[i];
                iArr[i2] = iArr[i2] & (-9);
                dArr2[i2] = dArr[i];
            }
        } else {
            Object obj = objArr[i];
            if (obj == UniqueTag.DOUBLE_MARK) {
                obj = ScriptRuntime.wrapNumber(dArr[i]);
            }
            String str = callFrame.idata.argNames[i2];
            if (callFrame.scope instanceof ConstProperties) {
                ((ConstProperties) callFrame.scope).putConst(str, callFrame.scope, obj);
            } else {
                throw Kit.codeBug();
            }
        }
        return i;
    }

    private static int doSetVar(CallFrame callFrame, Object[] objArr, double[] dArr, int i, Object[] objArr2, double[] dArr2, int[] iArr, int i2) {
        if (!callFrame.useActivation) {
            if ((iArr[i2] & 1) == 0) {
                objArr2[i2] = objArr[i];
                dArr2[i2] = dArr[i];
            }
        } else {
            Object obj = objArr[i];
            if (obj == UniqueTag.DOUBLE_MARK) {
                obj = ScriptRuntime.wrapNumber(dArr[i]);
            }
            callFrame.scope.put(callFrame.idata.argNames[i2], callFrame.scope, obj);
        }
        return i;
    }

    private static int doGetVar(CallFrame callFrame, Object[] objArr, double[] dArr, int i, Object[] objArr2, double[] dArr2, int i2) {
        int i3 = i + 1;
        if (!callFrame.useActivation) {
            objArr[i3] = objArr2[i2];
            dArr[i3] = dArr2[i2];
        } else {
            objArr[i3] = callFrame.scope.get(callFrame.idata.argNames[i2], callFrame.scope);
        }
        return i3;
    }

    private static int doVarIncDec(Context context, CallFrame callFrame, Object[] objArr, double[] dArr, int i, Object[] objArr2, double[] dArr2, int i2) {
        double number;
        int i3 = i + 1;
        byte b = callFrame.idata.itsICode[callFrame.f10719pc];
        if (!callFrame.useActivation) {
            objArr[i3] = UniqueTag.DOUBLE_MARK;
            Object obj = objArr2[i2];
            if (obj == UniqueTag.DOUBLE_MARK) {
                number = dArr2[i2];
            } else {
                number = ScriptRuntime.toNumber(obj);
                objArr2[i2] = UniqueTag.DOUBLE_MARK;
            }
            double d = (b & 1) == 0 ? 1.0d + number : number - 1.0d;
            dArr2[i2] = d;
            if ((b & 2) == 0) {
                number = d;
            }
            dArr[i3] = number;
        } else {
            objArr[i3] = ScriptRuntime.nameIncrDecr(callFrame.scope, callFrame.idata.argNames[i2], context, b);
        }
        callFrame.f10719pc++;
        return i3;
    }

    private static int doRefMember(Context context, Object[] objArr, double[] dArr, int i, int i2) {
        Object obj = objArr[i];
        if (obj == UniqueTag.DOUBLE_MARK) {
            obj = ScriptRuntime.wrapNumber(dArr[i]);
        }
        int i3 = i - 1;
        Object obj2 = objArr[i3];
        if (obj2 == UniqueTag.DOUBLE_MARK) {
            obj2 = ScriptRuntime.wrapNumber(dArr[i3]);
        }
        objArr[i3] = ScriptRuntime.memberRef(obj2, obj, context, i2);
        return i3;
    }

    private static int doRefNsMember(Context context, Object[] objArr, double[] dArr, int i, int i2) {
        Object obj = objArr[i];
        if (obj == UniqueTag.DOUBLE_MARK) {
            obj = ScriptRuntime.wrapNumber(dArr[i]);
        }
        int i3 = i - 1;
        Object obj2 = objArr[i3];
        if (obj2 == UniqueTag.DOUBLE_MARK) {
            obj2 = ScriptRuntime.wrapNumber(dArr[i3]);
        }
        int i4 = i3 - 1;
        Object obj3 = objArr[i4];
        if (obj3 == UniqueTag.DOUBLE_MARK) {
            obj3 = ScriptRuntime.wrapNumber(dArr[i4]);
        }
        objArr[i4] = ScriptRuntime.memberRef(obj3, obj2, obj, context, i2);
        return i4;
    }

    private static int doRefNsName(Context context, CallFrame callFrame, Object[] objArr, double[] dArr, int i, int i2) {
        Object obj = objArr[i];
        if (obj == UniqueTag.DOUBLE_MARK) {
            obj = ScriptRuntime.wrapNumber(dArr[i]);
        }
        int i3 = i - 1;
        Object obj2 = objArr[i3];
        if (obj2 == UniqueTag.DOUBLE_MARK) {
            obj2 = ScriptRuntime.wrapNumber(dArr[i3]);
        }
        objArr[i3] = ScriptRuntime.nameRef(obj2, obj, context, callFrame.scope, i2);
        return i3;
    }

    private static CallFrame initFrameForNoSuchMethod(Context context, CallFrame callFrame, int i, Object[] objArr, double[] dArr, int i2, int i3, Scriptable scriptable, Scriptable scriptable2, ScriptRuntime.NoSuchMethodShim noSuchMethodShim, InterpretedFunction interpretedFunction) {
        CallFrame callFrame2;
        int i4 = i2 + 2;
        Object[] objArr2 = new Object[i];
        int i5 = 0;
        while (i5 < i) {
            Object obj = objArr[i4];
            if (obj == UniqueTag.DOUBLE_MARK) {
                obj = ScriptRuntime.wrapNumber(dArr[i4]);
            }
            objArr2[i5] = obj;
            i5++;
            i4++;
        }
        Object[] objArr3 = {noSuchMethodShim.methodName, context.newArray(scriptable2, objArr2)};
        CallFrame callFrame3 = new CallFrame();
        if (i3 == -55) {
            CallFrame callFrame4 = callFrame.parentFrame;
            exitFrame(context, callFrame, null);
            callFrame2 = callFrame4;
        } else {
            callFrame2 = callFrame;
        }
        initFrame(context, scriptable2, scriptable, objArr3, null, 0, 2, interpretedFunction, callFrame2, callFrame3);
        if (i3 != -55) {
            callFrame.savedStackTop = i2;
            callFrame.savedCallOp = i3;
        }
        return callFrame3;
    }

    private static boolean doEquals(Object[] objArr, double[] dArr, int i) {
        int i2 = i + 1;
        Object obj = objArr[i2];
        Object obj2 = objArr[i];
        if (obj == UniqueTag.DOUBLE_MARK) {
            if (obj2 == UniqueTag.DOUBLE_MARK) {
                return dArr[i] == dArr[i2];
            }
            return ScriptRuntime.eqNumber(dArr[i2], obj2);
        } else if (obj2 == UniqueTag.DOUBLE_MARK) {
            return ScriptRuntime.eqNumber(dArr[i], obj);
        } else {
            return ScriptRuntime.m48eq(obj2, obj);
        }
    }

    private static boolean doShallowEquals(Object[] objArr, double[] dArr, int i) {
        double d;
        double doubleValue;
        int i2 = i + 1;
        Object obj = objArr[i2];
        Object obj2 = objArr[i];
        UniqueTag uniqueTag = UniqueTag.DOUBLE_MARK;
        if (obj == uniqueTag) {
            doubleValue = dArr[i2];
            if (obj2 == uniqueTag) {
                d = dArr[i];
            } else if (!(obj2 instanceof Number)) {
                return false;
            } else {
                d = ((Number) obj2).doubleValue();
            }
        } else if (obj2 == uniqueTag) {
            d = dArr[i];
            if (!(obj instanceof Number)) {
                return false;
            }
            doubleValue = ((Number) obj).doubleValue();
        } else {
            return ScriptRuntime.shallowEq(obj2, obj);
        }
        return d == doubleValue;
    }

    private static CallFrame processThrowable(Context context, Object obj, CallFrame callFrame, int i, boolean z) {
        if (i >= 0) {
            if (callFrame.frozen) {
                callFrame = callFrame.cloneFrozen();
            }
            int[] iArr = callFrame.idata.itsExceptionTable;
            callFrame.f10719pc = iArr[i + 2];
            if (z) {
                callFrame.pcPrevBranch = callFrame.f10719pc;
            }
            callFrame.savedStackTop = callFrame.emptyStackTop;
            int i2 = callFrame.localShift + iArr[i + 5];
            int i3 = callFrame.localShift + iArr[i + 4];
            callFrame.scope = (Scriptable) callFrame.stack[i2];
            callFrame.stack[i3] = obj;
        } else {
            ContinuationJump continuationJump = (ContinuationJump) obj;
            if (continuationJump.branchFrame != callFrame) {
                Kit.codeBug();
            }
            if (continuationJump.capturedFrame == null) {
                Kit.codeBug();
            }
            int i4 = continuationJump.capturedFrame.frameIndex + 1;
            if (continuationJump.branchFrame != null) {
                i4 -= continuationJump.branchFrame.frameIndex;
            }
            CallFrame callFrame2 = continuationJump.capturedFrame;
            CallFrame[] callFrameArr = null;
            int i5 = 0;
            for (int i6 = 0; i6 != i4; i6++) {
                if (!callFrame2.frozen) {
                    Kit.codeBug();
                }
                if (isFrameEnterExitRequired(callFrame2)) {
                    if (callFrameArr == null) {
                        callFrameArr = new CallFrame[i4 - i6];
                    }
                    callFrameArr[i5] = callFrame2;
                    i5++;
                }
                callFrame2 = callFrame2.parentFrame;
            }
            while (i5 != 0) {
                i5--;
                enterFrame(context, callFrameArr[i5], ScriptRuntime.emptyArgs, true);
            }
            callFrame = continuationJump.capturedFrame.cloneFrozen();
            setCallResult(callFrame, continuationJump.result, continuationJump.resultDbl);
        }
        callFrame.throwable = null;
        return callFrame;
    }

    private static Object freezeGenerator(Context context, CallFrame callFrame, int i, GeneratorState generatorState) {
        if (generatorState.operation == 2) {
            throw ScriptRuntime.typeError0("msg.yield.closing");
        }
        callFrame.frozen = true;
        callFrame.result = callFrame.stack[i];
        callFrame.resultDbl = callFrame.sDbl[i];
        callFrame.savedStackTop = i;
        callFrame.f10719pc--;
        ScriptRuntime.exitActivationFunction(context);
        return callFrame.result != UniqueTag.DOUBLE_MARK ? callFrame.result : ScriptRuntime.wrapNumber(callFrame.resultDbl);
    }

    private static Object thawGenerator(CallFrame callFrame, int i, GeneratorState generatorState, int i2) {
        callFrame.frozen = false;
        int index = getIndex(callFrame.idata.itsICode, callFrame.f10719pc);
        callFrame.f10719pc += 2;
        if (generatorState.operation == 1) {
            return new JavaScriptException(generatorState.value, callFrame.idata.itsSourceFile, index);
        }
        if (generatorState.operation == 2) {
            return generatorState.value;
        }
        if (generatorState.operation != 0) {
            throw Kit.codeBug();
        }
        if (i2 == 72) {
            callFrame.stack[i] = generatorState.value;
        }
        return Scriptable.NOT_FOUND;
    }

    private static CallFrame initFrameForApplyOrCall(Context context, CallFrame callFrame, int i, Object[] objArr, double[] dArr, int i2, int i3, Scriptable scriptable, IdFunctionObject idFunctionObject, InterpretedFunction interpretedFunction) {
        Scriptable scriptable2;
        CallFrame callFrame2 = callFrame;
        if (i != 0) {
            int i4 = i2 + 2;
            Object obj = objArr[i4];
            if (obj == UniqueTag.DOUBLE_MARK) {
                obj = ScriptRuntime.wrapNumber(dArr[i4]);
            }
            scriptable2 = ScriptRuntime.toObjectOrNull(context, obj);
        } else {
            scriptable2 = null;
        }
        if (scriptable2 == null) {
            scriptable2 = ScriptRuntime.getTopCallScope(context);
        }
        if (i3 == -55) {
            exitFrame(context, callFrame, null);
            callFrame2 = callFrame2.parentFrame;
        } else {
            callFrame2.savedStackTop = i2;
            callFrame2.savedCallOp = i3;
        }
        CallFrame callFrame3 = callFrame2;
        CallFrame callFrame4 = new CallFrame();
        if (BaseFunction.isApply(idFunctionObject)) {
            Object[] applyArguments = i < 2 ? ScriptRuntime.emptyArgs : ScriptRuntime.getApplyArguments(context, objArr[i2 + 3]);
            initFrame(context, scriptable, scriptable2, applyArguments, null, 0, applyArguments.length, interpretedFunction, callFrame3, callFrame4);
        } else {
            for (int i5 = 1; i5 < i; i5++) {
                int i6 = i2 + 1 + i5;
                int i7 = i2 + 2 + i5;
                objArr[i6] = objArr[i7];
                dArr[i6] = dArr[i7];
            }
            initFrame(context, scriptable, scriptable2, objArr, dArr, i2 + 2, i < 2 ? 0 : i - 1, interpretedFunction, callFrame3, callFrame4);
        }
        return callFrame4;
    }

    private static void initFrame(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, double[] dArr, int i, int i2, InterpretedFunction interpretedFunction, CallFrame callFrame, CallFrame callFrame2) {
        DebugFrame debugFrame;
        Object[] objArr2;
        double[] dArr2;
        int i3;
        Scriptable scriptable3;
        Object[] objArr3;
        boolean z;
        int[] iArr;
        double[] dArr3;
        InterpreterData interpreterData = interpretedFunction.idata;
        boolean z2 = interpreterData.itsNeedsActivation;
        if (context.debugger != null) {
            debugFrame = context.debugger.getFrame(context, interpreterData);
            if (debugFrame != null) {
                z2 = true;
            }
        } else {
            debugFrame = null;
        }
        if (z2) {
            objArr2 = dArr != null ? getArgsArray(objArr, dArr, i, i2) : objArr;
            dArr2 = null;
            i3 = 0;
        } else {
            objArr2 = objArr;
            dArr2 = dArr;
            i3 = i;
        }
        if (interpreterData.itsFunctionType != 0) {
            scriptable3 = interpretedFunction.getParentScope();
            if (z2) {
                scriptable3 = ScriptRuntime.createFunctionActivation(interpretedFunction, scriptable3, objArr2);
            }
        } else {
            ScriptRuntime.initScript(interpretedFunction, scriptable2, context, scriptable, interpretedFunction.idata.evalScriptFlag);
            scriptable3 = scriptable;
        }
        if (interpreterData.itsNestedFunctions != null) {
            if (interpreterData.itsFunctionType != 0 && !interpreterData.itsNeedsActivation) {
                Kit.codeBug();
            }
            for (int i4 = 0; i4 < interpreterData.itsNestedFunctions.length; i4++) {
                if (interpreterData.itsNestedFunctions[i4].itsFunctionType == 1) {
                    initFunction(context, scriptable3, interpretedFunction, i4);
                }
            }
        }
        int i5 = (interpreterData.itsMaxVars + interpreterData.itsMaxLocals) - 1;
        int i6 = interpreterData.itsMaxFrameArray;
        if (i6 != interpreterData.itsMaxStack + i5 + 1) {
            Kit.codeBug();
        }
        if (callFrame2.stack != null && i6 <= callFrame2.stack.length) {
            objArr3 = callFrame2.stack;
            iArr = callFrame2.stackAttributes;
            dArr3 = callFrame2.sDbl;
            z = true;
        } else {
            objArr3 = new Object[i6];
            int[] iArr2 = new int[i6];
            double[] dArr4 = new double[i6];
            z = false;
            iArr = iArr2;
            dArr3 = dArr4;
        }
        int paramAndVarCount = interpreterData.getParamAndVarCount();
        double[] dArr5 = dArr2;
        for (int i7 = 0; i7 < paramAndVarCount; i7++) {
            if (interpreterData.getParamOrVarConst(i7)) {
                iArr[i7] = 13;
            }
        }
        int i8 = interpreterData.argCount;
        int i9 = i2;
        if (i8 <= i9) {
            i9 = i8;
        }
        callFrame2.parentFrame = callFrame;
        callFrame2.frameIndex = callFrame == null ? 0 : callFrame.frameIndex + 1;
        if (callFrame2.frameIndex > context.getMaximumInterpreterStackDepth()) {
            throw Context.reportRuntimeError("Exceeded maximum stack depth");
        }
        callFrame2.frozen = false;
        callFrame2.fnOrScript = interpretedFunction;
        callFrame2.idata = interpreterData;
        callFrame2.stack = objArr3;
        callFrame2.stackAttributes = iArr;
        callFrame2.sDbl = dArr3;
        callFrame2.varSource = callFrame2;
        callFrame2.localShift = interpreterData.itsMaxVars;
        callFrame2.emptyStackTop = i5;
        callFrame2.debuggerFrame = debugFrame;
        callFrame2.useActivation = z2;
        callFrame2.thisObj = scriptable2;
        callFrame2.result = Undefined.instance;
        callFrame2.f10719pc = 0;
        callFrame2.pcPrevBranch = 0;
        callFrame2.pcSourceLineStart = interpreterData.firstLinePC;
        callFrame2.scope = scriptable3;
        callFrame2.savedStackTop = i5;
        callFrame2.savedCallOp = 0;
        System.arraycopy(objArr2, i3, objArr3, 0, i9);
        if (dArr5 != null) {
            System.arraycopy(dArr5, i3, dArr3, 0, i9);
        }
        while (i9 != interpreterData.itsMaxVars) {
            objArr3[i9] = Undefined.instance;
            i9++;
        }
        if (z) {
            for (int i10 = i5 + 1; i10 != objArr3.length; i10++) {
                objArr3[i10] = null;
            }
        }
        enterFrame(context, callFrame2, objArr2, false);
    }

    private static boolean isFrameEnterExitRequired(CallFrame callFrame) {
        return callFrame.debuggerFrame != null || callFrame.idata.itsNeedsActivation;
    }

    private static void enterFrame(Context context, CallFrame callFrame, Object[] objArr, boolean z) {
        boolean z2 = callFrame.idata.itsNeedsActivation;
        boolean z3 = callFrame.debuggerFrame != null;
        if (z2 || z3) {
            Scriptable scriptable = callFrame.scope;
            if (scriptable == null) {
                Kit.codeBug();
            } else if (z) {
                while (scriptable instanceof NativeWith) {
                    scriptable = scriptable.getParentScope();
                    if (scriptable == null || (callFrame.parentFrame != null && callFrame.parentFrame.scope == scriptable)) {
                        Kit.codeBug();
                        break;
                    }
                }
            }
            if (z3) {
                callFrame.debuggerFrame.onEnter(context, scriptable, callFrame.thisObj, objArr);
            }
            if (z2) {
                ScriptRuntime.enterActivationFunction(context, scriptable);
            }
        }
    }

    private static void exitFrame(Context context, CallFrame callFrame, Object obj) {
        Object obj2;
        double d;
        if (callFrame.idata.itsNeedsActivation) {
            ScriptRuntime.exitActivationFunction(context);
        }
        if (callFrame.debuggerFrame != null) {
            try {
                if (obj instanceof Throwable) {
                    callFrame.debuggerFrame.onExit(context, true, obj);
                    return;
                }
                ContinuationJump continuationJump = (ContinuationJump) obj;
                if (continuationJump == null) {
                    obj2 = callFrame.result;
                } else {
                    obj2 = continuationJump.result;
                }
                if (obj2 == UniqueTag.DOUBLE_MARK) {
                    if (continuationJump == null) {
                        d = callFrame.resultDbl;
                    } else {
                        d = continuationJump.resultDbl;
                    }
                    obj2 = ScriptRuntime.wrapNumber(d);
                }
                callFrame.debuggerFrame.onExit(context, false, obj2);
            } catch (Throwable th) {
                System.err.println("RHINO USAGE WARNING: onExit terminated with exception");
                th.printStackTrace(System.err);
            }
        }
    }

    private static void setCallResult(CallFrame callFrame, Object obj, double d) {
        if (callFrame.savedCallOp == 38) {
            callFrame.stack[callFrame.savedStackTop] = obj;
            callFrame.sDbl[callFrame.savedStackTop] = d;
        } else if (callFrame.savedCallOp == 30) {
            if (obj instanceof Scriptable) {
                callFrame.stack[callFrame.savedStackTop] = obj;
            }
        } else {
            Kit.codeBug();
        }
        callFrame.savedCallOp = 0;
    }

    public static NativeContinuation captureContinuation(Context context) {
        if (context.lastInterpreterFrame == null || !(context.lastInterpreterFrame instanceof CallFrame)) {
            throw new IllegalStateException("Interpreter frames not found");
        }
        return captureContinuation(context, (CallFrame) context.lastInterpreterFrame, true);
    }

    private static NativeContinuation captureContinuation(Context context, CallFrame callFrame, boolean z) {
        NativeContinuation nativeContinuation = new NativeContinuation();
        ScriptRuntime.setObjectProtoAndParent(nativeContinuation, ScriptRuntime.getTopCallScope(context));
        CallFrame callFrame2 = callFrame;
        CallFrame callFrame3 = callFrame2;
        while (callFrame2 != null && !callFrame2.frozen) {
            callFrame2.frozen = true;
            for (int i = callFrame2.savedStackTop + 1; i != callFrame2.stack.length; i++) {
                callFrame2.stack[i] = null;
                callFrame2.stackAttributes[i] = 0;
            }
            if (callFrame2.savedCallOp == 38) {
                callFrame2.stack[callFrame2.savedStackTop] = null;
            } else if (callFrame2.savedCallOp != 30) {
                Kit.codeBug();
            }
            callFrame3 = callFrame2;
            callFrame2 = callFrame2.parentFrame;
        }
        if (z) {
            while (callFrame3.parentFrame != null) {
                callFrame3 = callFrame3.parentFrame;
            }
            if (!callFrame3.isContinuationsTopFrame) {
                throw new IllegalStateException("Cannot capture continuation from JavaScript code not called directly by executeScriptWithContinuations or callFunctionWithContinuations");
            }
        }
        nativeContinuation.initImplementation(callFrame);
        return nativeContinuation;
    }

    private static int stack_int32(CallFrame callFrame, int i) {
        Object obj = callFrame.stack[i];
        if (obj == UniqueTag.DOUBLE_MARK) {
            return ScriptRuntime.toInt32(callFrame.sDbl[i]);
        }
        return ScriptRuntime.toInt32(obj);
    }

    private static double stack_double(CallFrame callFrame, int i) {
        Object obj = callFrame.stack[i];
        if (obj != UniqueTag.DOUBLE_MARK) {
            return ScriptRuntime.toNumber(obj);
        }
        return callFrame.sDbl[i];
    }

    private static boolean stack_boolean(CallFrame callFrame, int i) {
        Object obj = callFrame.stack[i];
        if (obj == Boolean.TRUE) {
            return true;
        }
        if (obj == Boolean.FALSE) {
            return false;
        }
        if (obj == UniqueTag.DOUBLE_MARK) {
            double d = callFrame.sDbl[i];
            return d == d && d != 0.0d;
        } else if (obj == null || obj == Undefined.instance) {
            return false;
        } else {
            if (obj instanceof Number) {
                double doubleValue = ((Number) obj).doubleValue();
                return doubleValue == doubleValue && doubleValue != 0.0d;
            } else if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            } else {
                return ScriptRuntime.toBoolean(obj);
            }
        }
    }

    private static void doAdd(Object[] objArr, double[] dArr, int i, Context context) {
        double d;
        boolean z;
        int i2 = i + 1;
        Object obj = objArr[i2];
        Object obj2 = objArr[i];
        if (obj == UniqueTag.DOUBLE_MARK) {
            d = dArr[i2];
            if (obj2 == UniqueTag.DOUBLE_MARK) {
                dArr[i] = dArr[i] + d;
                return;
            }
            z = true;
        } else if (obj2 == UniqueTag.DOUBLE_MARK) {
            obj2 = obj;
            d = dArr[i];
            z = false;
        } else if ((obj2 instanceof Scriptable) || (obj instanceof Scriptable)) {
            objArr[i] = ScriptRuntime.add(obj2, obj, context);
            return;
        } else if ((obj2 instanceof CharSequence) || (obj instanceof CharSequence)) {
            objArr[i] = new ConsString(ScriptRuntime.toCharSequence(obj2), ScriptRuntime.toCharSequence(obj));
            return;
        } else {
            double doubleValue = obj2 instanceof Number ? ((Number) obj2).doubleValue() : ScriptRuntime.toNumber(obj2);
            double doubleValue2 = obj instanceof Number ? ((Number) obj).doubleValue() : ScriptRuntime.toNumber(obj);
            objArr[i] = UniqueTag.DOUBLE_MARK;
            dArr[i] = doubleValue + doubleValue2;
            return;
        }
        if (obj2 instanceof Scriptable) {
            Object wrapNumber = ScriptRuntime.wrapNumber(d);
            if (!z) {
                Object obj3 = obj2;
                obj2 = wrapNumber;
                wrapNumber = obj3;
            }
            objArr[i] = ScriptRuntime.add(obj2, wrapNumber, context);
        } else if (obj2 instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj2;
            CharSequence charSequence2 = ScriptRuntime.toCharSequence(Double.valueOf(d));
            if (z) {
                objArr[i] = new ConsString(charSequence, charSequence2);
            } else {
                objArr[i] = new ConsString(charSequence2, charSequence);
            }
        } else {
            double doubleValue3 = obj2 instanceof Number ? ((Number) obj2).doubleValue() : ScriptRuntime.toNumber(obj2);
            objArr[i] = UniqueTag.DOUBLE_MARK;
            dArr[i] = doubleValue3 + d;
        }
    }

    private static int doArithmetic(CallFrame callFrame, int i, Object[] objArr, double[] dArr, int i2) {
        double stack_double = stack_double(callFrame, i2);
        int i3 = i2 - 1;
        double stack_double2 = stack_double(callFrame, i3);
        objArr[i3] = UniqueTag.DOUBLE_MARK;
        switch (i) {
            case 22:
                stack_double2 -= stack_double;
                break;
            case 23:
                stack_double2 *= stack_double;
                break;
            case 24:
                stack_double2 /= stack_double;
                break;
            case 25:
                stack_double2 %= stack_double;
                break;
        }
        dArr[i3] = stack_double2;
        return i3;
    }

    private static Object[] getArgsArray(Object[] objArr, double[] dArr, int i, int i2) {
        if (i2 == 0) {
            return ScriptRuntime.emptyArgs;
        }
        Object[] objArr2 = new Object[i2];
        int i3 = 0;
        while (i3 != i2) {
            Object obj = objArr[i];
            if (obj == UniqueTag.DOUBLE_MARK) {
                obj = ScriptRuntime.wrapNumber(dArr[i]);
            }
            objArr2[i3] = obj;
            i3++;
            i++;
        }
        return objArr2;
    }

    private static void addInstructionCount(Context context, CallFrame callFrame, int i) {
        context.instructionCount += (callFrame.f10719pc - callFrame.pcPrevBranch) + i;
        if (context.instructionCount > context.instructionThreshold) {
            context.observeInstructionCount(context.instructionCount);
            context.instructionCount = 0;
        }
    }
}
