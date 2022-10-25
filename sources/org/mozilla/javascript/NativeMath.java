package org.mozilla.javascript;

import androidx.exifinterface.media.ExifInterface;
import com.applovin.sdk.AppLovinMediationProvider;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class NativeMath extends IdScriptableObject {
    private static final int Id_E = 20;
    private static final int Id_LN10 = 22;
    private static final int Id_LN2 = 23;
    private static final int Id_LOG10E = 25;
    private static final int Id_LOG2E = 24;
    private static final int Id_PI = 21;
    private static final int Id_SQRT1_2 = 26;
    private static final int Id_SQRT2 = 27;
    private static final int Id_abs = 2;
    private static final int Id_acos = 3;
    private static final int Id_asin = 4;
    private static final int Id_atan = 5;
    private static final int Id_atan2 = 6;
    private static final int Id_ceil = 7;
    private static final int Id_cos = 8;
    private static final int Id_exp = 9;
    private static final int Id_floor = 10;
    private static final int Id_log = 11;
    private static final int Id_max = 12;
    private static final int Id_min = 13;
    private static final int Id_pow = 14;
    private static final int Id_random = 15;
    private static final int Id_round = 16;
    private static final int Id_sin = 17;
    private static final int Id_sqrt = 18;
    private static final int Id_tan = 19;
    private static final int Id_toSource = 1;
    private static final int LAST_METHOD_ID = 19;
    private static final Object MATH_TAG = "Math";
    private static final int MAX_ID = 27;
    static final long serialVersionUID = -8838847185801131569L;

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Math";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init(Scriptable scriptable, boolean z) {
        NativeMath nativeMath = new NativeMath();
        nativeMath.activatePrototypeMap(27);
        nativeMath.setPrototype(getObjectPrototype(scriptable));
        nativeMath.setParentScope(scriptable);
        if (z) {
            nativeMath.sealObject();
        }
        ScriptableObject.defineProperty(scriptable, "Math", nativeMath, 2);
    }

    private NativeMath() {
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        double d;
        String str;
        String str2;
        String str3;
        if (i <= 19) {
            int i2 = 1;
            switch (i) {
                case 1:
                    str2 = "toSource";
                    str3 = str2;
                    i2 = 0;
                    break;
                case 2:
                    str3 = "abs";
                    break;
                case 3:
                    str3 = "acos";
                    break;
                case 4:
                    str3 = "asin";
                    break;
                case 5:
                    str3 = "atan";
                    break;
                case 6:
                    str3 = "atan2";
                    i2 = 2;
                    break;
                case 7:
                    str3 = "ceil";
                    break;
                case 8:
                    str3 = "cos";
                    break;
                case 9:
                    str3 = "exp";
                    break;
                case 10:
                    str3 = "floor";
                    break;
                case 11:
                    str3 = "log";
                    break;
                case 12:
                    str3 = AppLovinMediationProvider.MAX;
                    i2 = 2;
                    break;
                case 13:
                    str3 = "min";
                    i2 = 2;
                    break;
                case 14:
                    str3 = "pow";
                    i2 = 2;
                    break;
                case 15:
                    str2 = "random";
                    str3 = str2;
                    i2 = 0;
                    break;
                case 16:
                    str3 = "round";
                    break;
                case 17:
                    str3 = "sin";
                    break;
                case 18:
                    str3 = "sqrt";
                    break;
                case 19:
                    str3 = "tan";
                    break;
                default:
                    throw new IllegalStateException(String.valueOf(i));
            }
            initPrototypeMethod(MATH_TAG, i, str3, i2);
            return;
        }
        switch (i) {
            case 20:
                d = 2.718281828459045d;
                str = ExifInterface.LONGITUDE_EAST;
                break;
            case 21:
                d = 3.141592653589793d;
                str = "PI";
                break;
            case 22:
                d = 2.302585092994046d;
                str = "LN10";
                break;
            case 23:
                d = 0.6931471805599453d;
                str = "LN2";
                break;
            case 24:
                d = 1.4426950408889634d;
                str = "LOG2E";
                break;
            case 25:
                d = 0.4342944819032518d;
                str = "LOG10E";
                break;
            case 26:
                d = 0.7071067811865476d;
                str = "SQRT1_2";
                break;
            case 27:
                d = 1.4142135623730951d;
                str = "SQRT2";
                break;
            default:
                throw new IllegalStateException(String.valueOf(i));
        }
        initPrototypeValue(i, str, ScriptRuntime.wrapNumber(d), 7);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
        if (r10 != 0.0d) goto L34;
     */
    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execIdCall(org.mozilla.javascript.IdFunctionObject r8, org.mozilla.javascript.Context r9, org.mozilla.javascript.Scriptable r10, org.mozilla.javascript.Scriptable r11, java.lang.Object[] r12) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeMath.execIdCall(org.mozilla.javascript.IdFunctionObject, org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, java.lang.Object[]):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0062, code lost:
        if (r23 < 1.0d) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x007b, code lost:
        if (r23 < 1.0d) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0085, code lost:
        if (r8 > 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x009f, code lost:
        if (r8 > 0) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private double js_pow(double r23, double r25) {
        /*
            r22 = this;
            r0 = r25
            r2 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r4 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            r6 = 0
            int r8 = (r0 > r0 ? 1 : (r0 == r0 ? 0 : -1))
            if (r8 == 0) goto L10
            r17 = r0
            goto La4
        L10:
            int r8 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r8 != 0) goto L18
            r17 = r2
            goto La4
        L18:
            r9 = -9223372036854775808
            r11 = 0
            r13 = 1
            r15 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            int r17 = (r23 > r6 ? 1 : (r23 == r6 ? 0 : -1))
            if (r17 != 0) goto L45
            double r2 = r2 / r23
            int r17 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r17 <= 0) goto L2e
            if (r8 <= 0) goto L65
            r4 = r6
            goto L65
        L2e:
            long r2 = (long) r0
            double r6 = (double) r2
            int r19 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r19 != 0) goto L40
            long r0 = r2 & r13
            int r2 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r2 == 0) goto L40
            if (r8 <= 0) goto L3d
            goto L3e
        L3d:
            r9 = r15
        L3e:
            r4 = r9
            goto L65
        L40:
            if (r8 <= 0) goto L65
            r4 = 0
            goto L65
        L45:
            double r6 = java.lang.Math.pow(r23, r25)
            int r19 = (r6 > r6 ? 1 : (r6 == r6 ? 0 : -1))
            if (r19 == 0) goto La2
            r19 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            int r21 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r21 != 0) goto L68
            int r0 = (r23 > r19 ? 1 : (r23 == r19 ? 0 : -1))
            if (r0 < 0) goto L65
            int r0 = (r2 > r23 ? 1 : (r2 == r23 ? 0 : -1))
            if (r0 >= 0) goto L5c
            goto L65
        L5c:
            int r0 = (r19 > r23 ? 1 : (r19 == r23 ? 0 : -1))
            if (r0 >= 0) goto La2
            int r0 = (r23 > r2 ? 1 : (r23 == r2 ? 0 : -1))
            if (r0 >= 0) goto La2
            goto L7e
        L65:
            r17 = r4
            goto La4
        L68:
            int r21 = (r0 > r15 ? 1 : (r0 == r15 ? 0 : -1))
            if (r21 != 0) goto L81
            int r0 = (r23 > r19 ? 1 : (r23 == r19 ? 0 : -1))
            if (r0 < 0) goto L7e
            int r0 = (r2 > r23 ? 1 : (r2 == r23 ? 0 : -1))
            if (r0 >= 0) goto L75
            goto L7e
        L75:
            int r0 = (r19 > r23 ? 1 : (r19 == r23 ? 0 : -1))
            if (r0 >= 0) goto La2
            int r0 = (r23 > r2 ? 1 : (r23 == r2 ? 0 : -1))
            if (r0 >= 0) goto La2
            goto L65
        L7e:
            r17 = 0
            goto La4
        L81:
            int r2 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r2 != 0) goto L88
            if (r8 <= 0) goto L7e
            goto L65
        L88:
            int r2 = (r23 > r15 ? 1 : (r23 == r15 ? 0 : -1))
            if (r2 != 0) goto La2
            long r2 = (long) r0
            double r6 = (double) r2
            int r19 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r19 != 0) goto L9f
            long r0 = r2 & r13
            int r2 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r2 == 0) goto L9f
            if (r8 <= 0) goto L9b
            goto L9c
        L9b:
            r15 = r9
        L9c:
            r17 = r15
            goto La4
        L9f:
            if (r8 <= 0) goto L7e
            goto L65
        La2:
            r17 = r6
        La4:
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeMath.js_pow(double, double):double");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // org.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int i = 1;
        switch (str.length()) {
            case 1:
                if (str.charAt(0) == 'E') {
                    return 20;
                }
                str2 = null;
                i = 0;
                break;
            case 2:
                if (str.charAt(0) == 'P' && str.charAt(1) == 'I') {
                    return 21;
                }
                str2 = null;
                i = 0;
                break;
            case 3:
                char charAt = str.charAt(0);
                if (charAt != 'L') {
                    if (charAt != 'a') {
                        if (charAt != 'c') {
                            if (charAt != 'e') {
                                if (charAt != 'p') {
                                    if (charAt != 'l') {
                                        if (charAt == 'm') {
                                            char charAt2 = str.charAt(2);
                                            if (charAt2 == 'n') {
                                                if (str.charAt(1) == 'i') {
                                                    return 13;
                                                }
                                            } else if (charAt2 == 'x' && str.charAt(1) == 'a') {
                                                return 12;
                                            }
                                        } else if (charAt == 's') {
                                            if (str.charAt(2) == 'n' && str.charAt(1) == 'i') {
                                                return 17;
                                            }
                                        } else if (charAt == 't' && str.charAt(2) == 'n' && str.charAt(1) == 'a') {
                                            return 19;
                                        }
                                    } else if (str.charAt(2) == 'g' && str.charAt(1) == 'o') {
                                        return 11;
                                    }
                                } else if (str.charAt(2) == 'w' && str.charAt(1) == 'o') {
                                    return 14;
                                }
                            } else if (str.charAt(2) == 'p' && str.charAt(1) == 'x') {
                                return 9;
                            }
                        } else if (str.charAt(2) == 's' && str.charAt(1) == 'o') {
                            return 8;
                        }
                    } else if (str.charAt(2) == 's' && str.charAt(1) == 'b') {
                        return 2;
                    }
                } else if (str.charAt(2) == '2' && str.charAt(1) == 'N') {
                    return 23;
                }
                str2 = null;
                i = 0;
                break;
            case 4:
                char charAt3 = str.charAt(1);
                if (charAt3 == 'N') {
                    i = 22;
                    str2 = "LN10";
                    break;
                } else if (charAt3 == 'c') {
                    i = 3;
                    str2 = "acos";
                    break;
                } else if (charAt3 == 'e') {
                    i = 7;
                    str2 = "ceil";
                    break;
                } else if (charAt3 == 'q') {
                    i = 18;
                    str2 = "sqrt";
                    break;
                } else if (charAt3 == 's') {
                    i = 4;
                    str2 = "asin";
                    break;
                } else {
                    if (charAt3 == 't') {
                        i = 5;
                        str2 = "atan";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
            case 5:
                char charAt4 = str.charAt(0);
                if (charAt4 == 'L') {
                    i = 24;
                    str2 = "LOG2E";
                    break;
                } else if (charAt4 == 'S') {
                    i = 27;
                    str2 = "SQRT2";
                    break;
                } else if (charAt4 == 'a') {
                    i = 6;
                    str2 = "atan2";
                    break;
                } else if (charAt4 == 'f') {
                    i = 10;
                    str2 = "floor";
                    break;
                } else {
                    if (charAt4 == 'r') {
                        i = 16;
                        str2 = "round";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
            case 6:
                char charAt5 = str.charAt(0);
                if (charAt5 != 'L') {
                    if (charAt5 == 'r') {
                        i = 15;
                        str2 = "random";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                } else {
                    i = 25;
                    str2 = "LOG10E";
                    break;
                }
            case 7:
                i = 26;
                str2 = "SQRT1_2";
                break;
            case 8:
                str2 = "toSource";
                break;
            default:
                str2 = null;
                i = 0;
                break;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }
}
