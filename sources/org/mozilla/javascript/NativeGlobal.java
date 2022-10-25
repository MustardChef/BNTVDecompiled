package org.mozilla.javascript;

import com.fasterxml.jackson.core.base.GeneratorBase;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import java.io.Serializable;
import kotlin.jvm.internal.CharCompanionObject;
import okio.Utf8;
import org.mozilla.javascript.xml.XMLLib;

/* loaded from: classes5.dex */
public class NativeGlobal implements Serializable, IdFunctionCall {
    private static final Object FTAG = "Global";
    private static final int INVALID_UTF8 = Integer.MAX_VALUE;
    private static final int Id_decodeURI = 1;
    private static final int Id_decodeURIComponent = 2;
    private static final int Id_encodeURI = 3;
    private static final int Id_encodeURIComponent = 4;
    private static final int Id_escape = 5;
    private static final int Id_eval = 6;
    private static final int Id_isFinite = 7;
    private static final int Id_isNaN = 8;
    private static final int Id_isXMLName = 9;
    private static final int Id_new_CommonError = 14;
    private static final int Id_parseFloat = 10;
    private static final int Id_parseInt = 11;
    private static final int Id_unescape = 12;
    private static final int Id_uneval = 13;
    private static final int LAST_SCOPE_FUNCTION_ID = 13;
    private static final String URI_DECODE_RESERVED = ";/?:@&=+$,#";
    static final long serialVersionUID = 6080442165748707530L;

    private static int unHex(char c) {
        char c2 = 'A';
        if ('A' > c || c > 'F') {
            c2 = 'a';
            if ('a' > c || c > 'f') {
                if ('0' > c || c > '9') {
                    return -1;
                }
                return c - '0';
            }
        }
        return (c - c2) + 10;
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        String str;
        String str2;
        int i;
        NativeGlobal nativeGlobal = new NativeGlobal();
        for (int i2 = 1; i2 <= 13; i2++) {
            switch (i2) {
                case 1:
                    str = "decodeURI";
                    str2 = str;
                    i = 1;
                    break;
                case 2:
                    str = "decodeURIComponent";
                    str2 = str;
                    i = 1;
                    break;
                case 3:
                    str = "encodeURI";
                    str2 = str;
                    i = 1;
                    break;
                case 4:
                    str = "encodeURIComponent";
                    str2 = str;
                    i = 1;
                    break;
                case 5:
                    str = "escape";
                    str2 = str;
                    i = 1;
                    break;
                case 6:
                    str = "eval";
                    str2 = str;
                    i = 1;
                    break;
                case 7:
                    str = "isFinite";
                    str2 = str;
                    i = 1;
                    break;
                case 8:
                    str = "isNaN";
                    str2 = str;
                    i = 1;
                    break;
                case 9:
                    str = "isXMLName";
                    str2 = str;
                    i = 1;
                    break;
                case 10:
                    str = "parseFloat";
                    str2 = str;
                    i = 1;
                    break;
                case 11:
                    str2 = "parseInt";
                    i = 2;
                    break;
                case 12:
                    str = "unescape";
                    str2 = str;
                    i = 1;
                    break;
                case 13:
                    str = "uneval";
                    str2 = str;
                    i = 1;
                    break;
                default:
                    throw Kit.codeBug();
            }
            IdFunctionObject idFunctionObject = new IdFunctionObject(nativeGlobal, FTAG, i2, str2, i, scriptable);
            if (z) {
                idFunctionObject.sealObject();
            }
            idFunctionObject.exportAsScopeProperty();
        }
        ScriptableObject.defineProperty(scriptable, "NaN", ScriptRuntime.NaNobj, 7);
        ScriptableObject.defineProperty(scriptable, "Infinity", ScriptRuntime.wrapNumber(Double.POSITIVE_INFINITY), 7);
        ScriptableObject.defineProperty(scriptable, "undefined", Undefined.instance, 7);
        String[] strArr = {"ConversionError", "EvalError", "RangeError", "ReferenceError", "SyntaxError", "TypeError", "URIError", "InternalError", "JavaException"};
        for (int i3 = 0; i3 < 9; i3++) {
            String str3 = strArr[i3];
            ScriptableObject scriptableObject = (ScriptableObject) ScriptRuntime.newObject(context, scriptable, "Error", ScriptRuntime.emptyArgs);
            scriptableObject.put("name", scriptableObject, str3);
            scriptableObject.put("message", scriptableObject, "");
            IdFunctionObject idFunctionObject2 = new IdFunctionObject(nativeGlobal, FTAG, 14, str3, 1, scriptable);
            idFunctionObject2.markAsConstructor(scriptableObject);
            scriptableObject.put("constructor", scriptableObject, idFunctionObject2);
            scriptableObject.setAttributes("constructor", 2);
            if (z) {
                scriptableObject.sealObject();
                idFunctionObject2.sealObject();
            }
            idFunctionObject2.exportAsScopeProperty();
        }
    }

    @Override // org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (idFunctionObject.hasTag(FTAG)) {
            int methodId = idFunctionObject.methodId();
            boolean z = false;
            switch (methodId) {
                case 1:
                case 2:
                    return decode(ScriptRuntime.toString(objArr, 0), methodId == 1);
                case 3:
                case 4:
                    return encode(ScriptRuntime.toString(objArr, 0), methodId == 3);
                case 5:
                    return js_escape(objArr);
                case 6:
                    return js_eval(context, scriptable, objArr);
                case 7:
                    if (objArr.length >= 1) {
                        double number = ScriptRuntime.toNumber(objArr[0]);
                        z = (number != number || number == Double.POSITIVE_INFINITY || number == Double.NEGATIVE_INFINITY) ? false : false;
                    }
                    return ScriptRuntime.wrapBoolean(z);
                case 8:
                    if (objArr.length >= 1) {
                        double number2 = ScriptRuntime.toNumber(objArr[0]);
                        if (number2 == number2) {
                            r0 = false;
                        }
                    }
                    return ScriptRuntime.wrapBoolean(r0);
                case 9:
                    return ScriptRuntime.wrapBoolean(XMLLib.extractFromScope(scriptable).isXMLName(context, objArr.length == 0 ? Undefined.instance : objArr[0]));
                case 10:
                    return js_parseFloat(objArr);
                case 11:
                    return js_parseInt(objArr);
                case 12:
                    return js_unescape(objArr);
                case 13:
                    return ScriptRuntime.uneval(context, scriptable, objArr.length != 0 ? objArr[0] : Undefined.instance);
                case 14:
                    return NativeError.make(context, scriptable, idFunctionObject, objArr);
            }
        }
        throw idFunctionObject.unknown();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
        if (r0 != false) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Object js_parseInt(java.lang.Object[] r12) {
        /*
            r11 = this;
            r0 = 0
            java.lang.String r1 = org.mozilla.javascript.ScriptRuntime.toString(r12, r0)
            r2 = 1
            int r12 = org.mozilla.javascript.ScriptRuntime.toInt32(r12, r2)
            int r3 = r1.length()
            if (r3 != 0) goto L13
            java.lang.Double r12 = org.mozilla.javascript.ScriptRuntime.NaNobj
            return r12
        L13:
            r4 = 0
        L14:
            char r5 = r1.charAt(r4)
            boolean r6 = org.mozilla.javascript.ScriptRuntime.isStrWhiteSpaceChar(r5)
            if (r6 != 0) goto L1f
            goto L23
        L1f:
            int r4 = r4 + 1
            if (r4 < r3) goto L14
        L23:
            r6 = 43
            if (r5 == r6) goto L2e
            r6 = 45
            if (r5 != r6) goto L2c
            r0 = 1
        L2c:
            if (r0 == 0) goto L30
        L2e:
            int r4 = r4 + 1
        L30:
            r5 = 88
            r6 = 120(0x78, float:1.68E-43)
            r7 = 16
            r8 = -1
            r9 = 48
            if (r12 != 0) goto L3d
            r12 = -1
            goto L5d
        L3d:
            r10 = 2
            if (r12 < r10) goto L92
            r10 = 36
            if (r12 <= r10) goto L45
            goto L92
        L45:
            if (r12 != r7) goto L5d
            int r10 = r3 - r4
            if (r10 <= r2) goto L5d
            char r10 = r1.charAt(r4)
            if (r10 != r9) goto L5d
            int r10 = r4 + 1
            char r10 = r1.charAt(r10)
            if (r10 == r6) goto L5b
            if (r10 != r5) goto L5d
        L5b:
            int r4 = r4 + 2
        L5d:
            if (r12 != r8) goto L85
            r12 = 10
            int r3 = r3 - r4
            if (r3 <= r2) goto L82
            char r2 = r1.charAt(r4)
            if (r2 != r9) goto L82
            int r2 = r4 + 1
            char r3 = r1.charAt(r2)
            if (r3 == r6) goto L7f
            if (r3 != r5) goto L75
            goto L7f
        L75:
            if (r9 > r3) goto L82
            r5 = 57
            if (r3 > r5) goto L82
            r7 = 8
            r4 = r2
            goto L86
        L7f:
            int r4 = r4 + 2
            goto L86
        L82:
            r7 = 10
            goto L86
        L85:
            r7 = r12
        L86:
            double r1 = org.mozilla.javascript.ScriptRuntime.stringToNumber(r1, r4, r7)
            if (r0 == 0) goto L8d
            double r1 = -r1
        L8d:
            java.lang.Number r12 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r1)
            return r12
        L92:
            java.lang.Double r12 = org.mozilla.javascript.ScriptRuntime.NaNobj
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeGlobal.js_parseInt(java.lang.Object[]):java.lang.Object");
    }

    private Object js_parseFloat(Object[] objArr) {
        int i;
        if (objArr.length < 1) {
            return ScriptRuntime.NaNobj;
        }
        boolean z = false;
        String scriptRuntime = ScriptRuntime.toString(objArr[0]);
        int length = scriptRuntime.length();
        for (int i2 = 0; i2 != length; i2++) {
            char charAt = scriptRuntime.charAt(i2);
            if (!ScriptRuntime.isStrWhiteSpaceChar(charAt)) {
                if (charAt == '+' || charAt == '-') {
                    int i3 = i2 + 1;
                    if (i3 == length) {
                        return ScriptRuntime.NaNobj;
                    }
                    i = i3;
                    charAt = scriptRuntime.charAt(i3);
                } else {
                    i = i2;
                }
                if (charAt == 'I') {
                    if (i + 8 <= length && scriptRuntime.regionMatches(i, "Infinity", 0, 8)) {
                        return ScriptRuntime.wrapNumber(scriptRuntime.charAt(i2) == '-' ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
                    }
                    return ScriptRuntime.NaNobj;
                }
                int i4 = -1;
                int i5 = -1;
                while (true) {
                    if (i < length) {
                        char charAt2 = scriptRuntime.charAt(i);
                        if (charAt2 != '+') {
                            if (charAt2 == 'E' || charAt2 == 'e') {
                                if (i4 == -1 && i != length - 1) {
                                    i4 = i;
                                    i++;
                                }
                            } else if (charAt2 != '-') {
                                if (charAt2 != '.') {
                                    switch (charAt2) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            if (i4 != -1) {
                                                z = true;
                                            }
                                            i++;
                                    }
                                } else if (i5 == -1) {
                                    i5 = i;
                                    i++;
                                }
                            }
                        }
                        if (i4 == i - 1) {
                            if (i == length - 1) {
                                i--;
                            } else {
                                i++;
                            }
                        }
                    }
                }
                if (i4 == -1 || z) {
                    i4 = i;
                }
                try {
                    return Double.valueOf(scriptRuntime.substring(i2, i4));
                } catch (NumberFormatException unused) {
                    return ScriptRuntime.NaNobj;
                }
            }
        }
        return ScriptRuntime.NaNobj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
        if ((r12 & (-8)) == 0) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Object js_escape(java.lang.Object[] r12) {
        /*
            r11 = this;
            r0 = 0
            java.lang.String r1 = org.mozilla.javascript.ScriptRuntime.toString(r12, r0)
            int r2 = r12.length
            r3 = 1
            if (r2 <= r3) goto L25
            r12 = r12[r3]
            double r4 = org.mozilla.javascript.ScriptRuntime.toNumber(r12)
            int r12 = (r4 > r4 ? 1 : (r4 == r4 ? 0 : -1))
            if (r12 != 0) goto L1e
            int r12 = (int) r4
            double r6 = (double) r12
            int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r2 != 0) goto L1e
            r2 = r12 & (-8)
            if (r2 != 0) goto L1e
            goto L26
        L1e:
            java.lang.String r12 = "msg.bad.esc.mask"
            org.mozilla.javascript.EvaluatorException r12 = org.mozilla.javascript.Context.reportRuntimeError0(r12)
            throw r12
        L25:
            r12 = 7
        L26:
            r2 = 0
            int r4 = r1.length()
        L2b:
            if (r0 == r4) goto Lbd
            char r5 = r1.charAt(r0)
            r6 = 43
            if (r12 == 0) goto L72
            r7 = 48
            if (r5 < r7) goto L3d
            r7 = 57
            if (r5 <= r7) goto L6b
        L3d:
            r7 = 65
            if (r5 < r7) goto L45
            r7 = 90
            if (r5 <= r7) goto L6b
        L45:
            r7 = 97
            if (r5 < r7) goto L4d
            r7 = 122(0x7a, float:1.71E-43)
            if (r5 <= r7) goto L6b
        L4d:
            r7 = 64
            if (r5 == r7) goto L6b
            r7 = 42
            if (r5 == r7) goto L6b
            r7 = 95
            if (r5 == r7) goto L6b
            r7 = 45
            if (r5 == r7) goto L6b
            r7 = 46
            if (r5 == r7) goto L6b
            r7 = r12 & 4
            if (r7 == 0) goto L72
            r7 = 47
            if (r5 == r7) goto L6b
            if (r5 != r6) goto L72
        L6b:
            if (r2 == 0) goto Lb9
            char r5 = (char) r5
            r2.append(r5)
            goto Lb9
        L72:
            if (r2 != 0) goto L81
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            int r7 = r4 + 3
            r2.<init>(r7)
            r2.append(r1)
            r2.setLength(r0)
        L81:
            r7 = 256(0x100, float:3.59E-43)
            r8 = 2
            r9 = 37
            r10 = 4
            if (r5 >= r7) goto L97
            r7 = 32
            if (r5 != r7) goto L93
            if (r12 != r8) goto L93
            r2.append(r6)
            goto Lb9
        L93:
            r2.append(r9)
            goto La0
        L97:
            r2.append(r9)
            r6 = 117(0x75, float:1.64E-43)
            r2.append(r6)
            r8 = 4
        La0:
            int r8 = r8 - r3
            int r8 = r8 * 4
        La3:
            if (r8 < 0) goto Lb9
            int r6 = r5 >> r8
            r6 = r6 & 15
            r7 = 10
            if (r6 >= r7) goto Lb0
            int r6 = r6 + 48
            goto Lb2
        Lb0:
            int r6 = r6 + 55
        Lb2:
            char r6 = (char) r6
            r2.append(r6)
            int r8 = r8 + (-4)
            goto La3
        Lb9:
            int r0 = r0 + 1
            goto L2b
        Lbd:
            if (r2 != 0) goto Lc0
            goto Lc4
        Lc0:
            java.lang.String r1 = r2.toString()
        Lc4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeGlobal.js_escape(java.lang.Object[]):java.lang.Object");
    }

    private Object js_unescape(Object[] objArr) {
        int i;
        int i2;
        String scriptRuntime = ScriptRuntime.toString(objArr, 0);
        int indexOf = scriptRuntime.indexOf(37);
        if (indexOf >= 0) {
            int length = scriptRuntime.length();
            char[] charArray = scriptRuntime.toCharArray();
            int i3 = indexOf;
            while (indexOf != length) {
                char c = charArray[indexOf];
                indexOf++;
                if (c == '%' && indexOf != length) {
                    if (charArray[indexOf] == 'u') {
                        i2 = indexOf + 1;
                        i = indexOf + 5;
                    } else {
                        i = indexOf + 2;
                        i2 = indexOf;
                    }
                    if (i <= length) {
                        int i4 = 0;
                        while (i2 != i) {
                            i4 = Kit.xDigitToInt(charArray[i2], i4);
                            i2++;
                        }
                        if (i4 >= 0) {
                            c = (char) i4;
                            indexOf = i;
                        }
                    }
                }
                charArray[i3] = c;
                i3++;
            }
            return new String(charArray, 0, i3);
        }
        return scriptRuntime;
    }

    private Object js_eval(Context context, Scriptable scriptable, Object[] objArr) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        return ScriptRuntime.evalSpecial(context, topLevelScope, topLevelScope, objArr, "eval code", 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isEvalFunction(Object obj) {
        if (obj instanceof IdFunctionObject) {
            IdFunctionObject idFunctionObject = (IdFunctionObject) obj;
            return idFunctionObject.hasTag(FTAG) && idFunctionObject.methodId() == 6;
        }
        return false;
    }

    public static EcmaError constructError(Context context, String str, String str2, Scriptable scriptable) {
        return ScriptRuntime.constructError(str, str2);
    }

    public static EcmaError constructError(Context context, String str, String str2, Scriptable scriptable, String str3, int i, int i2, String str4) {
        return ScriptRuntime.constructError(str, str2, str3, i, str4, i2);
    }

    private static String encode(String str, boolean z) {
        int length = str.length();
        StringBuffer stringBuffer = null;
        byte[] bArr = null;
        int i = 0;
        while (i != length) {
            char charAt = str.charAt(i);
            stringBuffer = stringBuffer;
            if (!encodeUnescaped(charAt, z)) {
                if (stringBuffer == null) {
                    StringBuffer stringBuffer2 = new StringBuffer(length + 3);
                    stringBuffer2.append(str);
                    stringBuffer2.setLength(i);
                    bArr = new byte[6];
                    stringBuffer = stringBuffer2;
                }
                if (56320 <= charAt && charAt <= 57343) {
                    throw uriError();
                }
                char c = charAt;
                if (charAt >= 55296) {
                    c = charAt;
                    if (56319 >= charAt) {
                        i++;
                        if (i == length) {
                            throw uriError();
                        }
                        char charAt2 = str.charAt(i);
                        if (56320 > charAt2 || charAt2 > 57343) {
                            throw uriError();
                        }
                        c = ((charAt - GeneratorBase.SURR1_FIRST) << 10) + (charAt2 - CharCompanionObject.MIN_LOW_SURROGATE) + 65536;
                    }
                }
                int oneUcs4ToUtf8Char = oneUcs4ToUtf8Char(bArr, c);
                for (int i2 = 0; i2 < oneUcs4ToUtf8Char; i2++) {
                    int i3 = bArr[i2] & 255;
                    stringBuffer.append('%');
                    stringBuffer.append(toHexChar(i3 >>> 4));
                    stringBuffer.append(toHexChar(i3 & 15));
                }
            } else if (stringBuffer != null) {
                stringBuffer.append(charAt);
            }
            i++;
            stringBuffer = stringBuffer;
        }
        return stringBuffer == null ? str : stringBuffer.toString();
    }

    private static char toHexChar(int i) {
        if ((i >> 4) != 0) {
            Kit.codeBug();
        }
        return (char) (i < 10 ? i + 48 : (i - 10) + 65);
    }

    private static int unHex(char c, char c2) {
        int unHex = unHex(c);
        int unHex2 = unHex(c2);
        if (unHex < 0 || unHex2 < 0) {
            return -1;
        }
        return (unHex << 4) | unHex2;
    }

    private static String decode(String str, boolean z) {
        int i;
        int i2;
        char c;
        int length = str.length();
        char[] cArr = null;
        int i3 = 0;
        int i4 = 0;
        while (i3 != length) {
            char charAt = str.charAt(i3);
            if (charAt != '%') {
                if (cArr != null) {
                    cArr[i4] = charAt;
                    i4++;
                }
                i3++;
            } else {
                if (cArr == null) {
                    cArr = new char[length];
                    str.getChars(0, i3, cArr, 0);
                    i4 = i3;
                }
                int i5 = i3 + 3;
                if (i5 > length) {
                    throw uriError();
                }
                int unHex = unHex(str.charAt(i3 + 1), str.charAt(i3 + 2));
                if (unHex < 0) {
                    throw uriError();
                }
                if ((unHex & 128) != 0) {
                    if ((unHex & 192) == 128) {
                        throw uriError();
                    }
                    if ((unHex & 32) == 0) {
                        unHex &= 31;
                        i = 1;
                        i2 = 128;
                    } else if ((unHex & 16) == 0) {
                        unHex &= 15;
                        i = 2;
                        i2 = 2048;
                    } else if ((unHex & 8) == 0) {
                        unHex &= 7;
                        i = 3;
                        i2 = 65536;
                    } else if ((unHex & 4) == 0) {
                        unHex &= 3;
                        i = 4;
                        i2 = 2097152;
                    } else if ((unHex & 2) != 0) {
                        throw uriError();
                    } else {
                        i = 5;
                        unHex &= 1;
                        i2 = 67108864;
                    }
                    if ((i * 3) + i5 > length) {
                        throw uriError();
                    }
                    for (int i6 = 0; i6 != i; i6++) {
                        if (str.charAt(i5) != '%') {
                            throw uriError();
                        }
                        int unHex2 = unHex(str.charAt(i5 + 1), str.charAt(i5 + 2));
                        if (unHex2 < 0 || (unHex2 & 192) != 128) {
                            throw uriError();
                        }
                        unHex = (unHex << 6) | (unHex2 & 63);
                        i5 += 3;
                    }
                    if (unHex < i2 || (unHex >= 55296 && unHex <= 57343)) {
                        unHex = Integer.MAX_VALUE;
                    } else if (unHex == 65534 || unHex == 65535) {
                        unHex = Utf8.REPLACEMENT_CODE_POINT;
                    }
                    if (unHex >= 65536) {
                        int i7 = unHex - 65536;
                        if (i7 > 1048575) {
                            throw uriError();
                        }
                        cArr[i4] = (char) ((i7 >>> 10) + GeneratorBase.SURR1_FIRST);
                        c = (char) ((i7 & AnalyticsListener.EVENT_DROPPED_VIDEO_FRAMES) + 56320);
                        i4++;
                        if (z || URI_DECODE_RESERVED.indexOf(c) < 0) {
                            cArr[i4] = c;
                            i4++;
                        } else {
                            while (i3 != i5) {
                                cArr[i4] = str.charAt(i3);
                                i3++;
                                i4++;
                            }
                        }
                        i3 = i5;
                    }
                }
                c = (char) unHex;
                if (z) {
                }
                cArr[i4] = c;
                i4++;
                i3 = i5;
            }
        }
        return cArr == null ? str : new String(cArr, 0, i4);
    }

    private static boolean encodeUnescaped(char c, boolean z) {
        if (('A' > c || c > 'Z') && (('a' > c || c > 'z') && (('0' > c || c > '9') && "-_.!~*'()".indexOf(c) < 0))) {
            return z && URI_DECODE_RESERVED.indexOf(c) >= 0;
        }
        return true;
    }

    private static EcmaError uriError() {
        return ScriptRuntime.constructError("URIError", ScriptRuntime.getMessage0("msg.bad.uri"));
    }

    private static int oneUcs4ToUtf8Char(byte[] bArr, int i) {
        if ((i & (-128)) == 0) {
            bArr[0] = (byte) i;
            return 1;
        }
        int i2 = i >>> 11;
        int i3 = 2;
        while (i2 != 0) {
            i2 >>>= 5;
            i3++;
        }
        int i4 = i3;
        while (true) {
            i4--;
            if (i4 > 0) {
                bArr[i4] = (byte) ((i & 63) | 128);
                i >>>= 6;
            } else {
                bArr[0] = (byte) ((256 - (1 << (8 - i3))) + i);
                return i3;
            }
        }
    }
}
