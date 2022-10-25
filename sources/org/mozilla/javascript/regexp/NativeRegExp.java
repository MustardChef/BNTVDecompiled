package org.mozilla.javascript.regexp;

import androidx.tvprovider.media.p009tv.TvContractCompat;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.TopLevel;
import org.mozilla.javascript.Undefined;

/* loaded from: classes5.dex */
public class NativeRegExp extends IdScriptableObject implements Function {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ANCHOR_BOL = -2;
    private static final int INDEX_LEN = 2;
    private static final int Id_compile = 1;
    private static final int Id_exec = 4;
    private static final int Id_global = 3;
    private static final int Id_ignoreCase = 4;
    private static final int Id_lastIndex = 1;
    private static final int Id_multiline = 5;
    private static final int Id_prefix = 6;
    private static final int Id_source = 2;
    private static final int Id_test = 5;
    private static final int Id_toSource = 3;
    private static final int Id_toString = 2;
    public static final int JSREG_FOLD = 2;
    public static final int JSREG_GLOB = 1;
    public static final int JSREG_MULTILINE = 4;
    public static final int MATCH = 1;
    private static final int MAX_INSTANCE_ID = 5;
    private static final int MAX_PROTOTYPE_ID = 6;
    public static final int PREFIX = 2;
    private static final Object REGEXP_TAG = new Object();
    private static final byte REOP_ALNUM = 9;
    private static final byte REOP_ALT = 31;
    private static final byte REOP_ALTPREREQ = 53;
    private static final byte REOP_ALTPREREQ2 = 55;
    private static final byte REOP_ALTPREREQi = 54;
    private static final byte REOP_ASSERT = 41;
    private static final byte REOP_ASSERTNOTTEST = 44;
    private static final byte REOP_ASSERTTEST = 43;
    private static final byte REOP_ASSERT_NOT = 42;
    private static final byte REOP_BACKREF = 13;
    private static final byte REOP_BOL = 2;
    private static final byte REOP_CLASS = 22;
    private static final byte REOP_DIGIT = 7;
    private static final byte REOP_DOT = 6;
    private static final byte REOP_EMPTY = 1;
    private static final byte REOP_END = 57;
    private static final byte REOP_ENDCHILD = 49;
    private static final byte REOP_EOL = 3;
    private static final byte REOP_FLAT = 14;
    private static final byte REOP_FLAT1 = 15;
    private static final byte REOP_FLAT1i = 17;
    private static final byte REOP_FLATi = 16;
    private static final byte REOP_JUMP = 32;
    private static final byte REOP_LPAREN = 29;
    private static final byte REOP_MINIMALOPT = 47;
    private static final byte REOP_MINIMALPLUS = 46;
    private static final byte REOP_MINIMALQUANT = 48;
    private static final byte REOP_MINIMALREPEAT = 52;
    private static final byte REOP_MINIMALSTAR = 45;
    private static final byte REOP_NCLASS = 23;
    private static final byte REOP_NONALNUM = 10;
    private static final byte REOP_NONDIGIT = 8;
    private static final byte REOP_NONSPACE = 12;
    private static final byte REOP_OPT = 28;
    private static final byte REOP_PLUS = 27;
    private static final byte REOP_QUANT = 25;
    private static final byte REOP_REPEAT = 51;
    private static final byte REOP_RPAREN = 30;
    private static final byte REOP_SIMPLE_END = 23;
    private static final byte REOP_SIMPLE_START = 1;
    private static final byte REOP_SPACE = 11;
    private static final byte REOP_STAR = 26;
    private static final byte REOP_UCFLAT1 = 18;
    private static final byte REOP_UCFLAT1i = 19;
    private static final byte REOP_WBDRY = 4;
    private static final byte REOP_WNONBDRY = 5;
    public static final int TEST = 0;
    private static final boolean debug = false;
    static final long serialVersionUID = 4965263491464903264L;
    double lastIndex;

    /* renamed from: re */
    private RECompiled f10776re;

    private static boolean isControlLetter(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    private static boolean reopIsSimple(int i) {
        return i >= 1 && i <= 23;
    }

    private static int toASCIIHexDigit(int i) {
        if (i < 48) {
            return -1;
        }
        if (i <= 57) {
            return i - 48;
        }
        int i2 = i | 32;
        if (97 > i2 || i2 > 102) {
            return -1;
        }
        return (i2 - 97) + 10;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "RegExp";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int getMaxInstanceId() {
        return 5;
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public String getTypeOf() {
        return "object";
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        NativeRegExp nativeRegExp = new NativeRegExp();
        nativeRegExp.f10776re = compileRE(context, "", null, false);
        nativeRegExp.activatePrototypeMap(6);
        nativeRegExp.setParentScope(scriptable);
        nativeRegExp.setPrototype(getObjectPrototype(scriptable));
        NativeRegExpCtor nativeRegExpCtor = new NativeRegExpCtor();
        nativeRegExp.defineProperty("constructor", nativeRegExpCtor, 2);
        ScriptRuntime.setFunctionProtoAndParent(nativeRegExpCtor, scriptable);
        nativeRegExpCtor.setImmunePrototypeProperty(nativeRegExp);
        if (z) {
            nativeRegExp.sealObject();
            nativeRegExpCtor.sealObject();
        }
        defineProperty(scriptable, "RegExp", nativeRegExpCtor, 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeRegExp(Scriptable scriptable, RECompiled rECompiled) {
        this.f10776re = rECompiled;
        this.lastIndex = 0.0d;
        ScriptRuntime.setBuiltinProtoAndParent(this, scriptable, TopLevel.Builtins.RegExp);
    }

    @Override // org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return execSub(context, scriptable, objArr, 1);
    }

    @Override // org.mozilla.javascript.Function
    public Scriptable construct(Context context, Scriptable scriptable, Object[] objArr) {
        return (Scriptable) execSub(context, scriptable, objArr, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Scriptable compile(Context context, Scriptable scriptable, Object[] objArr) {
        if (objArr.length > 0 && (objArr[0] instanceof NativeRegExp)) {
            if (objArr.length > 1 && objArr[1] != Undefined.instance) {
                throw ScriptRuntime.typeError0("msg.bad.regexp.compile");
            }
            NativeRegExp nativeRegExp = (NativeRegExp) objArr[0];
            this.f10776re = nativeRegExp.f10776re;
            this.lastIndex = nativeRegExp.lastIndex;
            return this;
        }
        this.f10776re = compileRE(context, objArr.length == 0 ? "" : escapeRegExp(objArr[0]), (objArr.length <= 1 || objArr[1] == Undefined.instance) ? null : ScriptRuntime.toString(objArr[1]), false);
        this.lastIndex = 0.0d;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(JsonPointer.SEPARATOR);
        if (this.f10776re.source.length != 0) {
            sb.append(this.f10776re.source);
        } else {
            sb.append("(?:)");
        }
        sb.append(JsonPointer.SEPARATOR);
        if ((this.f10776re.flags & 1) != 0) {
            sb.append('g');
        }
        if ((this.f10776re.flags & 2) != 0) {
            sb.append('i');
        }
        if ((this.f10776re.flags & 4) != 0) {
            sb.append('m');
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeRegExp() {
    }

    private static RegExpImpl getImpl(Context context) {
        return (RegExpImpl) ScriptRuntime.getRegExpProxy(context);
    }

    private static String escapeRegExp(Object obj) {
        String scriptRuntime = ScriptRuntime.toString(obj);
        StringBuilder sb = null;
        int i = 0;
        for (int indexOf = scriptRuntime.indexOf(47); indexOf > -1; indexOf = scriptRuntime.indexOf(47, indexOf + 1)) {
            if (indexOf == i || scriptRuntime.charAt(indexOf - 1) != '\\') {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append((CharSequence) scriptRuntime, i, indexOf);
                sb.append("\\/");
                i = indexOf + 1;
            }
        }
        if (sb != null) {
            sb.append((CharSequence) scriptRuntime, i, scriptRuntime.length());
            return sb.toString();
        }
        return scriptRuntime;
    }

    private Object execSub(Context context, Scriptable scriptable, Object[] objArr, int i) {
        String scriptRuntime;
        RegExpImpl impl = getImpl(context);
        if (objArr.length == 0) {
            scriptRuntime = impl.input;
            if (scriptRuntime == null) {
                reportError("msg.no.re.input.for", toString());
            }
        } else {
            scriptRuntime = ScriptRuntime.toString(objArr[0]);
        }
        String str = scriptRuntime;
        double d = 0.0d;
        double d2 = (this.f10776re.flags & 1) != 0 ? this.lastIndex : 0.0d;
        if (d2 < 0.0d || str.length() < d2) {
            this.lastIndex = 0.0d;
            return null;
        }
        int[] iArr = {(int) d2};
        Object executeRegExp = executeRegExp(context, scriptable, impl, str, iArr, i);
        if ((this.f10776re.flags & 1) != 0) {
            if (executeRegExp != null && executeRegExp != Undefined.instance) {
                d = iArr[0];
            }
            this.lastIndex = d;
            return executeRegExp;
        }
        return executeRegExp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RECompiled compileRE(Context context, String str, String str2, boolean z) {
        int i;
        RECompiled rECompiled = new RECompiled(str);
        int length = str.length();
        if (str2 != null) {
            i = 0;
            for (int i2 = 0; i2 < str2.length(); i2++) {
                char charAt = str2.charAt(i2);
                if (charAt == 'g') {
                    i |= 1;
                } else if (charAt == 'i') {
                    i |= 2;
                } else if (charAt == 'm') {
                    i |= 4;
                } else {
                    reportError("msg.invalid.re.flag", String.valueOf(charAt));
                }
            }
        } else {
            i = 0;
        }
        rECompiled.flags = i;
        CompilerState compilerState = new CompilerState(context, rECompiled.source, length, i);
        if (z && length > 0) {
            compilerState.result = new RENode((byte) 14);
            compilerState.result.chr = compilerState.cpbegin[0];
            compilerState.result.length = length;
            compilerState.result.flatIndex = 0;
            compilerState.progLength += 5;
        } else if (!parseDisjunction(compilerState)) {
            return null;
        }
        rECompiled.program = new byte[compilerState.progLength + 1];
        if (compilerState.classCount != 0) {
            rECompiled.classList = new RECharSet[compilerState.classCount];
            rECompiled.classCount = compilerState.classCount;
        }
        rECompiled.program[emitREBytecode(compilerState, rECompiled, 0, compilerState.result)] = REOP_END;
        rECompiled.parenCount = compilerState.parenCount;
        byte b = rECompiled.program[0];
        if (b == 2) {
            rECompiled.anchorCh = -2;
        } else if (b != 31) {
            switch (b) {
                case 14:
                case 16:
                    rECompiled.anchorCh = rECompiled.source[getIndex(rECompiled.program, 1)];
                    break;
                case 15:
                case 17:
                    rECompiled.anchorCh = (char) (rECompiled.program[1] & 255);
                    break;
                case 18:
                case 19:
                    rECompiled.anchorCh = (char) getIndex(rECompiled.program, 1);
                    break;
            }
        } else {
            RENode rENode = compilerState.result;
            if (rENode.kid.f10781op == 2 && rENode.kid2.f10781op == 2) {
                rECompiled.anchorCh = -2;
            }
        }
        return rECompiled;
    }

    private static boolean isWord(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || isDigit(c) || c == '_';
    }

    private static boolean isLineTerm(char c) {
        return ScriptRuntime.isJSLineTerminator(c);
    }

    private static boolean isREWhiteSpace(int i) {
        return ScriptRuntime.isJSWhitespaceOrLineTerminator(i);
    }

    private static char upcase(char c) {
        if (c < 128) {
            return ('a' > c || c > 'z') ? c : (char) (c - ' ');
        }
        char upperCase = Character.toUpperCase(c);
        return upperCase < 128 ? c : upperCase;
    }

    private static char downcase(char c) {
        if (c < 128) {
            return ('A' > c || c > 'Z') ? c : (char) (c + ' ');
        }
        char lowerCase = Character.toLowerCase(c);
        return lowerCase < 128 ? c : lowerCase;
    }

    private static boolean parseDisjunction(CompilerState compilerState) {
        if (parseAlternative(compilerState)) {
            char[] cArr = compilerState.cpbegin;
            int i = compilerState.f10774cp;
            if (i != cArr.length && cArr[i] == '|') {
                compilerState.f10774cp++;
                RENode rENode = new RENode((byte) 31);
                rENode.kid = compilerState.result;
                if (!parseDisjunction(compilerState)) {
                    return false;
                }
                rENode.kid2 = compilerState.result;
                compilerState.result = rENode;
                if (rENode.kid.f10781op == 14 && rENode.kid2.f10781op == 14) {
                    rENode.f10781op = (compilerState.flags & 2) == 0 ? REOP_ALTPREREQ : REOP_ALTPREREQi;
                    rENode.chr = rENode.kid.chr;
                    rENode.index = rENode.kid2.chr;
                    compilerState.progLength += 13;
                } else if (rENode.kid.f10781op == 22 && rENode.kid.index < 256 && rENode.kid2.f10781op == 14 && (compilerState.flags & 2) == 0) {
                    rENode.f10781op = REOP_ALTPREREQ2;
                    rENode.chr = rENode.kid2.chr;
                    rENode.index = rENode.kid.index;
                    compilerState.progLength += 13;
                } else if (rENode.kid.f10781op == 14 && rENode.kid2.f10781op == 22 && rENode.kid2.index < 256 && (compilerState.flags & 2) == 0) {
                    rENode.f10781op = REOP_ALTPREREQ2;
                    rENode.chr = rENode.kid.chr;
                    rENode.index = rENode.kid2.index;
                    compilerState.progLength += 13;
                } else {
                    compilerState.progLength += 9;
                }
            }
            return true;
        }
        return false;
    }

    private static boolean parseAlternative(CompilerState compilerState) {
        char[] cArr = compilerState.cpbegin;
        RENode rENode = null;
        RENode rENode2 = null;
        while (compilerState.f10774cp != compilerState.cpend && cArr[compilerState.f10774cp] != '|' && (compilerState.parenNesting == 0 || cArr[compilerState.f10774cp] != ')')) {
            if (!parseTerm(compilerState)) {
                return false;
            }
            if (rENode == null) {
                rENode = compilerState.result;
                rENode2 = rENode;
            } else {
                rENode2.next = compilerState.result;
            }
            while (rENode2.next != null) {
                rENode2 = rENode2.next;
            }
        }
        if (rENode == null) {
            compilerState.result = new RENode((byte) 1);
        } else {
            compilerState.result = rENode;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x0102, code lost:
        reportError("msg.bad.range", "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0105, code lost:
        return false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x001c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x006b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0070 A[LOOP:1: B:32:0x005d->B:37:0x0070, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00fd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00ce A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [int] */
    /* JADX WARN: Type inference failed for: r14v3, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean calculateBitmapSize(org.mozilla.javascript.regexp.CompilerState r16, org.mozilla.javascript.regexp.RENode r17, char[] r18, int r19, int r20) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.NativeRegExp.calculateBitmapSize(org.mozilla.javascript.regexp.CompilerState, org.mozilla.javascript.regexp.RENode, char[], int, int):boolean");
    }

    private static void doFlat(CompilerState compilerState, char c) {
        compilerState.result = new RENode((byte) 14);
        compilerState.result.chr = c;
        compilerState.result.length = 1;
        compilerState.result.flatIndex = -1;
        compilerState.progLength += 3;
    }

    private static int getDecimalValue(char c, CompilerState compilerState, int i, String str) {
        int i2 = compilerState.f10774cp;
        char[] cArr = compilerState.cpbegin;
        int i3 = c - 48;
        boolean z = false;
        while (compilerState.f10774cp != compilerState.cpend) {
            char c2 = cArr[compilerState.f10774cp];
            if (!isDigit(c2)) {
                break;
            }
            if (!z) {
                int i4 = c2 - '0';
                if (i3 < (i - i4) / 10) {
                    i3 = (i3 * 10) + i4;
                } else {
                    i3 = i;
                    z = true;
                }
            }
            compilerState.f10774cp++;
        }
        if (z) {
            reportError(str, String.valueOf(cArr, i2, compilerState.f10774cp - i2));
        }
        return i3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x041a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x016d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x017c A[LOOP:0: B:70:0x0157->B:76:0x017c, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean parseTerm(org.mozilla.javascript.regexp.CompilerState r16) {
        /*
            Method dump skipped, instructions count: 1178
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.NativeRegExp.parseTerm(org.mozilla.javascript.regexp.CompilerState):boolean");
    }

    private static void resolveForwardJump(byte[] bArr, int i, int i2) {
        if (i > i2) {
            throw Kit.codeBug();
        }
        addIndex(bArr, i, i2 - i);
    }

    private static int getOffset(byte[] bArr, int i) {
        return getIndex(bArr, i);
    }

    private static int addIndex(byte[] bArr, int i, int i2) {
        if (i2 >= 0) {
            if (i2 > 65535) {
                throw Context.reportRuntimeError("Too complex regexp");
            }
            bArr[i] = (byte) (i2 >> 8);
            bArr[i + 1] = (byte) i2;
            return i + 2;
        }
        throw Kit.codeBug();
    }

    private static int getIndex(byte[] bArr, int i) {
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    private static int emitREBytecode(CompilerState compilerState, RECompiled rECompiled, int i, RENode rENode) {
        int i2;
        byte[] bArr = rECompiled.program;
        while (rENode != null) {
            int i3 = i + 1;
            bArr[i] = rENode.f10781op;
            byte b = rENode.f10781op;
            if (b != 1) {
                if (b != 22) {
                    if (b == 25) {
                        if (rENode.min == 0 && rENode.max == -1) {
                            bArr[i3 - 1] = rENode.greedy ? (byte) 26 : REOP_MINIMALSTAR;
                        } else if (rENode.min == 0 && rENode.max == 1) {
                            bArr[i3 - 1] = rENode.greedy ? (byte) 28 : REOP_MINIMALOPT;
                        } else if (rENode.min == 1 && rENode.max == -1) {
                            bArr[i3 - 1] = rENode.greedy ? (byte) 27 : REOP_MINIMALPLUS;
                        } else {
                            if (!rENode.greedy) {
                                bArr[i3 - 1] = REOP_MINIMALQUANT;
                            }
                            i3 = addIndex(bArr, addIndex(bArr, i3, rENode.min), rENode.max + 1);
                        }
                        int addIndex = addIndex(bArr, addIndex(bArr, i3, rENode.parenCount), rENode.parenIndex);
                        int emitREBytecode = emitREBytecode(compilerState, rECompiled, addIndex + 2, rENode.kid);
                        i2 = emitREBytecode + 1;
                        bArr[emitREBytecode] = REOP_ENDCHILD;
                        resolveForwardJump(bArr, addIndex, i2);
                    } else if (b != 29) {
                        if (b != 31) {
                            if (b == 13) {
                                i = addIndex(bArr, i3, rENode.parenIndex);
                            } else if (b == 14) {
                                if (rENode.flatIndex != -1) {
                                    while (rENode.next != null && rENode.next.f10781op == 14 && rENode.flatIndex + rENode.length == rENode.next.flatIndex) {
                                        rENode.length += rENode.next.length;
                                        rENode.next = rENode.next.next;
                                    }
                                }
                                if (rENode.flatIndex != -1 && rENode.length > 1) {
                                    if ((compilerState.flags & 2) != 0) {
                                        bArr[i3 - 1] = 16;
                                    } else {
                                        bArr[i3 - 1] = 14;
                                    }
                                    i = addIndex(bArr, addIndex(bArr, i3, rENode.flatIndex), rENode.length);
                                } else if (rENode.chr < 256) {
                                    if ((compilerState.flags & 2) != 0) {
                                        bArr[i3 - 1] = 17;
                                    } else {
                                        bArr[i3 - 1] = 15;
                                    }
                                    i = i3 + 1;
                                    bArr[i3] = (byte) rENode.chr;
                                } else {
                                    if ((compilerState.flags & 2) != 0) {
                                        bArr[i3 - 1] = 19;
                                    } else {
                                        bArr[i3 - 1] = 18;
                                    }
                                    i = addIndex(bArr, i3, rENode.chr);
                                }
                            } else if (b == 41) {
                                int emitREBytecode2 = emitREBytecode(compilerState, rECompiled, i3 + 2, rENode.kid);
                                i2 = emitREBytecode2 + 1;
                                bArr[emitREBytecode2] = REOP_ASSERTTEST;
                                resolveForwardJump(bArr, i3, i2);
                            } else if (b != 42) {
                                switch (b) {
                                    case 53:
                                    case 54:
                                    case 55:
                                        boolean z = rENode.f10781op == 54;
                                        char c = rENode.chr;
                                        if (z) {
                                            c = upcase(c);
                                        }
                                        addIndex(bArr, i3, c);
                                        int i4 = i3 + 2;
                                        int i5 = rENode.index;
                                        if (z) {
                                            i5 = upcase((char) i5);
                                        }
                                        addIndex(bArr, i4, i5);
                                        i3 = i4 + 2;
                                        break;
                                }
                            } else {
                                int emitREBytecode3 = emitREBytecode(compilerState, rECompiled, i3 + 2, rENode.kid);
                                i2 = emitREBytecode3 + 1;
                                bArr[emitREBytecode3] = REOP_ASSERTNOTTEST;
                                resolveForwardJump(bArr, i3, i2);
                            }
                        }
                        RENode rENode2 = rENode.kid2;
                        int emitREBytecode4 = emitREBytecode(compilerState, rECompiled, i3 + 2, rENode.kid);
                        int i6 = emitREBytecode4 + 1;
                        bArr[emitREBytecode4] = 32;
                        int i7 = i6 + 2;
                        resolveForwardJump(bArr, i3, i7);
                        int emitREBytecode5 = emitREBytecode(compilerState, rECompiled, i7, rENode2);
                        int i8 = emitREBytecode5 + 1;
                        bArr[emitREBytecode5] = 32;
                        i = i8 + 2;
                        resolveForwardJump(bArr, i6, i);
                        resolveForwardJump(bArr, i8, i);
                    } else {
                        int emitREBytecode6 = emitREBytecode(compilerState, rECompiled, addIndex(bArr, i3, rENode.parenIndex), rENode.kid);
                        bArr[emitREBytecode6] = 30;
                        i = addIndex(bArr, emitREBytecode6 + 1, rENode.parenIndex);
                    }
                    i = i2;
                } else {
                    if (!rENode.sense) {
                        bArr[i3 - 1] = Ascii.ETB;
                    }
                    i = addIndex(bArr, i3, rENode.index);
                    rECompiled.classList[rENode.index] = new RECharSet(rENode.bmsize, rENode.startIndex, rENode.kidlen, rENode.sense);
                }
                rENode = rENode.next;
            } else {
                i3--;
            }
            i = i3;
            rENode = rENode.next;
        }
        return i;
    }

    private static void pushProgState(REGlobalData rEGlobalData, int i, int i2, int i3, REBackTrackData rEBackTrackData, int i4, int i5) {
        rEGlobalData.stateStackTop = new REProgState(rEGlobalData.stateStackTop, i, i2, i3, rEBackTrackData, i4, i5);
    }

    private static REProgState popProgState(REGlobalData rEGlobalData) {
        REProgState rEProgState = rEGlobalData.stateStackTop;
        rEGlobalData.stateStackTop = rEProgState.previous;
        return rEProgState;
    }

    private static void pushBackTrackState(REGlobalData rEGlobalData, byte b, int i) {
        REProgState rEProgState = rEGlobalData.stateStackTop;
        rEGlobalData.backTrackStackTop = new REBackTrackData(rEGlobalData, b, i, rEGlobalData.f10780cp, rEProgState.continuationOp, rEProgState.continuationPc);
    }

    private static void pushBackTrackState(REGlobalData rEGlobalData, byte b, int i, int i2, int i3, int i4) {
        rEGlobalData.backTrackStackTop = new REBackTrackData(rEGlobalData, b, i, i2, i3, i4);
    }

    private static boolean flatNMatcher(REGlobalData rEGlobalData, int i, int i2, String str, int i3) {
        if (rEGlobalData.f10780cp + i2 > i3) {
            return false;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            if (rEGlobalData.regexp.source[i + i4] != str.charAt(rEGlobalData.f10780cp + i4)) {
                return false;
            }
        }
        rEGlobalData.f10780cp += i2;
        return true;
    }

    private static boolean flatNIMatcher(REGlobalData rEGlobalData, int i, int i2, String str, int i3) {
        if (rEGlobalData.f10780cp + i2 > i3) {
            return false;
        }
        char[] cArr = rEGlobalData.regexp.source;
        for (int i4 = 0; i4 < i2; i4++) {
            char c = cArr[i + i4];
            char charAt = str.charAt(rEGlobalData.f10780cp + i4);
            if (c != charAt && upcase(c) != upcase(charAt)) {
                return false;
            }
        }
        rEGlobalData.f10780cp += i2;
        return true;
    }

    private static boolean backrefMatcher(REGlobalData rEGlobalData, int i, String str, int i2) {
        if (rEGlobalData.parens == null || i >= rEGlobalData.parens.length) {
            return false;
        }
        int parensIndex = rEGlobalData.parensIndex(i);
        if (parensIndex == -1) {
            return true;
        }
        int parensLength = rEGlobalData.parensLength(i);
        if (rEGlobalData.f10780cp + parensLength > i2) {
            return false;
        }
        if ((rEGlobalData.regexp.flags & 2) != 0) {
            for (int i3 = 0; i3 < parensLength; i3++) {
                char charAt = str.charAt(parensIndex + i3);
                char charAt2 = str.charAt(rEGlobalData.f10780cp + i3);
                if (charAt != charAt2 && upcase(charAt) != upcase(charAt2)) {
                    return false;
                }
            }
        } else if (!str.regionMatches(parensIndex, str, rEGlobalData.f10780cp, parensLength)) {
            return false;
        }
        rEGlobalData.f10780cp += parensLength;
        return true;
    }

    private static void addCharacterToCharSet(RECharSet rECharSet, char c) {
        int i = c / '\b';
        if (c >= rECharSet.length) {
            throw ScriptRuntime.constructError("SyntaxError", "invalid range in character class");
        }
        byte[] bArr = rECharSet.bits;
        bArr[i] = (byte) ((1 << (c & 7)) | bArr[i]);
    }

    private static void addCharacterRangeToCharSet(RECharSet rECharSet, char c, char c2) {
        int i = c / '\b';
        int i2 = c2 / '\b';
        if (c2 >= rECharSet.length || c > c2) {
            throw ScriptRuntime.constructError("SyntaxError", "invalid range in character class");
        }
        char c3 = (char) (c & 7);
        char c4 = (char) (c2 & 7);
        if (i == i2) {
            byte[] bArr = rECharSet.bits;
            bArr[i] = (byte) (((255 >> (7 - (c4 - c3))) << c3) | bArr[i]);
            return;
        }
        byte[] bArr2 = rECharSet.bits;
        bArr2[i] = (byte) ((255 << c3) | bArr2[i]);
        while (true) {
            i++;
            if (i < i2) {
                rECharSet.bits[i] = -1;
            } else {
                byte[] bArr3 = rECharSet.bits;
                bArr3[i2] = (byte) (bArr3[i2] | (255 >> (7 - c4)));
                return;
            }
        }
    }

    private static void processCharSet(REGlobalData rEGlobalData, RECharSet rECharSet) {
        synchronized (rECharSet) {
            if (!rECharSet.converted) {
                processCharSetImpl(rEGlobalData, rECharSet);
                rECharSet.converted = true;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x009c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a1 A[LOOP:4: B:39:0x008a->B:44:0x00a1, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void processCharSetImpl(org.mozilla.javascript.regexp.REGlobalData r17, org.mozilla.javascript.regexp.RECharSet r18) {
        /*
            Method dump skipped, instructions count: 484
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.NativeRegExp.processCharSetImpl(org.mozilla.javascript.regexp.REGlobalData, org.mozilla.javascript.regexp.RECharSet):void");
    }

    private static boolean classMatcher(REGlobalData rEGlobalData, RECharSet rECharSet, char c) {
        if (!rECharSet.converted) {
            processCharSet(rEGlobalData, rECharSet);
        }
        int i = c >> 3;
        boolean z = true;
        if (rECharSet.length != 0 && c < rECharSet.length && (rECharSet.bits[i] & (1 << (c & 7))) != 0) {
            z = false;
        }
        return rECharSet.sense ^ z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01e0, code lost:
        if (isLineTerm(r4.charAt(r3.f10780cp)) == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01f6, code lost:
        if (isLineTerm(r4.charAt(r3.f10780cp - 1)) == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01a3, code lost:
        if (isWord(r4.charAt(r3.f10780cp)) != false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01c9, code lost:
        if (isWord(r4.charAt(r3.f10780cp)) != false) goto L90;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int simpleMatch(org.mozilla.javascript.regexp.REGlobalData r3, java.lang.String r4, int r5, byte[] r6, int r7, int r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.NativeRegExp.simpleMatch(org.mozilla.javascript.regexp.REGlobalData, java.lang.String, int, byte[], int, int, boolean):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:155:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x041d  */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r0v97, types: [int] */
    /* JADX WARN: Type inference failed for: r1v23, types: [int] */
    /* JADX WARN: Type inference failed for: r1v26, types: [int] */
    /* JADX WARN: Type inference failed for: r1v37, types: [int] */
    /* JADX WARN: Type inference failed for: r1v45, types: [int] */
    /* JADX WARN: Type inference failed for: r1v52, types: [int] */
    /* JADX WARN: Type inference failed for: r1v55, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v41, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean executeREBytecode(org.mozilla.javascript.regexp.REGlobalData r23, java.lang.String r24, int r25) {
        /*
            Method dump skipped, instructions count: 1174
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.NativeRegExp.executeREBytecode(org.mozilla.javascript.regexp.REGlobalData, java.lang.String, int):boolean");
    }

    private static boolean matchRegExp(REGlobalData rEGlobalData, RECompiled rECompiled, String str, int i, int i2, boolean z) {
        if (rECompiled.parenCount != 0) {
            rEGlobalData.parens = new long[rECompiled.parenCount];
        } else {
            rEGlobalData.parens = null;
        }
        rEGlobalData.backTrackStackTop = null;
        rEGlobalData.stateStackTop = null;
        rEGlobalData.multiline = z || (rECompiled.flags & 4) != 0;
        rEGlobalData.regexp = rECompiled;
        int i3 = rEGlobalData.regexp.anchorCh;
        int i4 = i;
        while (i4 <= i2) {
            if (i3 >= 0) {
                while (i4 != i2) {
                    char charAt = str.charAt(i4);
                    if (charAt != i3 && ((rEGlobalData.regexp.flags & 2) == 0 || upcase(charAt) != upcase((char) i3))) {
                        i4++;
                    }
                }
                return false;
            }
            rEGlobalData.f10780cp = i4;
            rEGlobalData.skipped = i4 - i;
            for (int i5 = 0; i5 < rECompiled.parenCount; i5++) {
                rEGlobalData.parens[i5] = -1;
            }
            boolean executeREBytecode = executeREBytecode(rEGlobalData, str, i2);
            rEGlobalData.backTrackStackTop = null;
            rEGlobalData.stateStackTop = null;
            if (executeREBytecode) {
                return true;
            }
            if (i3 == -2 && !rEGlobalData.multiline) {
                rEGlobalData.skipped = i2;
                return false;
            }
            i4 = rEGlobalData.skipped + i + 1;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object executeRegExp(Context context, Scriptable scriptable, RegExpImpl regExpImpl, String str, int[] iArr, int i) {
        Object newArray;
        Scriptable scriptable2;
        NativeRegExp nativeRegExp = this;
        REGlobalData rEGlobalData = new REGlobalData();
        int i2 = iArr[0];
        int length = str.length();
        int i3 = i2 > length ? length : i2;
        SubString subString = null;
        if (!matchRegExp(rEGlobalData, nativeRegExp.f10776re, str, i3, length, regExpImpl.multiline)) {
            if (i != 2) {
                return null;
            }
            return Undefined.instance;
        }
        int i4 = rEGlobalData.f10780cp;
        iArr[0] = i4;
        int i5 = i4 - (rEGlobalData.skipped + i3);
        int i6 = i4 - i5;
        if (i == 0) {
            scriptable2 = null;
            newArray = Boolean.TRUE;
        } else {
            newArray = context.newArray(scriptable, 0);
            scriptable2 = (Scriptable) newArray;
            scriptable2.put(0, scriptable2, str.substring(i6, i6 + i5));
        }
        if (nativeRegExp.f10776re.parenCount == 0) {
            regExpImpl.parens = null;
            regExpImpl.lastParen = SubString.emptySubString;
        } else {
            regExpImpl.parens = new SubString[nativeRegExp.f10776re.parenCount];
            int i7 = 0;
            while (i7 < nativeRegExp.f10776re.parenCount) {
                int parensIndex = rEGlobalData.parensIndex(i7);
                if (parensIndex != -1) {
                    subString = new SubString(str, parensIndex, rEGlobalData.parensLength(i7));
                    regExpImpl.parens[i7] = subString;
                    if (i != 0) {
                        scriptable2.put(i7 + 1, scriptable2, subString.toString());
                    }
                } else if (i != 0) {
                    scriptable2.put(i7 + 1, scriptable2, Undefined.instance);
                }
                i7++;
                nativeRegExp = this;
            }
            regExpImpl.lastParen = subString;
        }
        if (i != 0) {
            scriptable2.put(FirebaseAnalytics.Param.INDEX, scriptable2, Integer.valueOf(rEGlobalData.skipped + i3));
            scriptable2.put(TvContractCompat.PARAM_INPUT, scriptable2, str);
        }
        if (regExpImpl.lastMatch == null) {
            regExpImpl.lastMatch = new SubString();
            regExpImpl.leftContext = new SubString();
            regExpImpl.rightContext = new SubString();
        }
        regExpImpl.lastMatch.str = str;
        regExpImpl.lastMatch.index = i6;
        regExpImpl.lastMatch.length = i5;
        regExpImpl.leftContext.str = str;
        if (context.getLanguageVersion() == 120) {
            regExpImpl.leftContext.index = i3;
            regExpImpl.leftContext.length = rEGlobalData.skipped;
        } else {
            regExpImpl.leftContext.index = 0;
            regExpImpl.leftContext.length = i3 + rEGlobalData.skipped;
        }
        regExpImpl.rightContext.str = str;
        regExpImpl.rightContext.index = i4;
        regExpImpl.rightContext.length = length - i4;
        return newArray;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getFlags() {
        return this.f10776re.flags;
    }

    private static void reportWarning(Context context, String str, String str2) {
        if (context.hasFeature(11)) {
            Context.reportWarning(ScriptRuntime.getMessage1(str, str2));
        }
    }

    private static void reportError(String str, String str2) {
        throw ScriptRuntime.constructError("SyntaxError", ScriptRuntime.getMessage1(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int findInstanceIdInfo(String str) {
        String str2;
        int i;
        int length = str.length();
        int i2 = 6;
        int i3 = 0;
        if (length == 6) {
            char charAt = str.charAt(0);
            if (charAt == 'g') {
                str2 = "global";
                i = 3;
            } else {
                if (charAt == 's') {
                    str2 = "source";
                    i = 2;
                }
                str2 = null;
                i = 0;
            }
        } else if (length == 9) {
            char charAt2 = str.charAt(0);
            if (charAt2 == 'l') {
                str2 = "lastIndex";
                i = 1;
            } else {
                if (charAt2 == 'm') {
                    str2 = "multiline";
                    i = 5;
                }
                str2 = null;
                i = 0;
            }
        } else {
            if (length == 10) {
                str2 = "ignoreCase";
                i = 4;
            }
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            i3 = i;
        }
        if (i3 == 0) {
            return super.findInstanceIdInfo(str);
        }
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3 && i3 != 4 && i3 != 5) {
                throw new IllegalStateException();
            }
            i2 = 7;
        }
        return instanceIdInfo(i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public String getInstanceIdName(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? super.getInstanceIdName(i) : "multiline" : "ignoreCase" : "global" : "source" : "lastIndex";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public Object getInstanceIdValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return ScriptRuntime.wrapBoolean((this.f10776re.flags & 1) != 0);
                } else if (i == 4) {
                    return ScriptRuntime.wrapBoolean((this.f10776re.flags & 2) != 0);
                } else if (i != 5) {
                    return super.getInstanceIdValue(i);
                } else {
                    return ScriptRuntime.wrapBoolean((this.f10776re.flags & 4) != 0);
                }
            }
            return new String(this.f10776re.source);
        }
        return ScriptRuntime.wrapNumber(this.lastIndex);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public void setInstanceIdValue(int i, Object obj) {
        if (i == 1) {
            this.lastIndex = ScriptRuntime.toNumber(obj);
        } else if (i == 2 || i == 3 || i == 4 || i == 5) {
        } else {
            super.setInstanceIdValue(i, obj);
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 1;
        switch (i) {
            case 1:
                str = "compile";
                break;
            case 2:
                str2 = "toString";
                str = str2;
                i2 = 0;
                break;
            case 3:
                str2 = "toSource";
                str = str2;
                i2 = 0;
                break;
            case 4:
                str = "exec";
                break;
            case 5:
                str = "test";
                break;
            case 6:
                str = "prefix";
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(REGEXP_TAG, i, str, i2);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(REGEXP_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        switch (methodId) {
            case 1:
                return realThis(scriptable2, idFunctionObject).compile(context, scriptable, objArr);
            case 2:
            case 3:
                return realThis(scriptable2, idFunctionObject).toString();
            case 4:
                return realThis(scriptable2, idFunctionObject).execSub(context, scriptable, objArr, 1);
            case 5:
                return Boolean.TRUE.equals(realThis(scriptable2, idFunctionObject).execSub(context, scriptable, objArr, 0)) ? Boolean.TRUE : Boolean.FALSE;
            case 6:
                return realThis(scriptable2, idFunctionObject).execSub(context, scriptable, objArr, 2);
            default:
                throw new IllegalArgumentException(String.valueOf(methodId));
        }
    }

    private static NativeRegExp realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (!(scriptable instanceof NativeRegExp)) {
            throw incompatibleCallError(idFunctionObject);
        }
        return (NativeRegExp) scriptable;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 3;
        if (length == 4) {
            char charAt = str.charAt(0);
            if (charAt == 'e') {
                str2 = "exec";
                i = 4;
            } else {
                if (charAt == 't') {
                    i = 5;
                    str2 = "test";
                }
                str2 = null;
                i = 0;
            }
        } else if (length == 6) {
            str2 = "prefix";
            i = 6;
        } else if (length != 7) {
            if (length == 8) {
                char charAt2 = str.charAt(3);
                if (charAt2 == 'o') {
                    str2 = "toSource";
                } else if (charAt2 == 't') {
                    i = 2;
                    str2 = "toString";
                }
            }
            str2 = null;
            i = 0;
        } else {
            i = 1;
            str2 = "compile";
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }
}
