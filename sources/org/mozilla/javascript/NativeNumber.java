package org.mozilla.javascript;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class NativeNumber extends IdScriptableObject {
    private static final int Id_constructor = 1;
    private static final int Id_toExponential = 7;
    private static final int Id_toFixed = 6;
    private static final int Id_toLocaleString = 3;
    private static final int Id_toPrecision = 8;
    private static final int Id_toSource = 4;
    private static final int Id_toString = 2;
    private static final int Id_valueOf = 5;
    private static final int MAX_PRECISION = 100;
    private static final int MAX_PROTOTYPE_ID = 8;
    private static final Object NUMBER_TAG = "Number";
    static final long serialVersionUID = 3504516769741512101L;
    private double doubleValue;

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Number";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init(Scriptable scriptable, boolean z) {
        new NativeNumber(0.0d).exportAsJSClass(8, scriptable, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeNumber(double d) {
        this.doubleValue = d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        idFunctionObject.defineProperty("NaN", ScriptRuntime.NaNobj, 7);
        idFunctionObject.defineProperty("POSITIVE_INFINITY", ScriptRuntime.wrapNumber(Double.POSITIVE_INFINITY), 7);
        idFunctionObject.defineProperty("NEGATIVE_INFINITY", ScriptRuntime.wrapNumber(Double.NEGATIVE_INFINITY), 7);
        idFunctionObject.defineProperty("MAX_VALUE", ScriptRuntime.wrapNumber(Double.MAX_VALUE), 7);
        idFunctionObject.defineProperty("MIN_VALUE", ScriptRuntime.wrapNumber(Double.MIN_VALUE), 7);
        super.fillConstructorProperties(idFunctionObject);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 1;
        switch (i) {
            case 1:
                str = "constructor";
                break;
            case 2:
                str = "toString";
                break;
            case 3:
                str = "toLocaleString";
                break;
            case 4:
                str2 = "toSource";
                str = str2;
                i2 = 0;
                break;
            case 5:
                str2 = "valueOf";
                str = str2;
                i2 = 0;
                break;
            case 6:
                str = "toFixed";
                break;
            case 7:
                str = "toExponential";
                break;
            case 8:
                str = "toPrecision";
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(NUMBER_TAG, i, str, i2);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(NUMBER_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        if (methodId == 1) {
            double number = objArr.length >= 1 ? ScriptRuntime.toNumber(objArr[0]) : 0.0d;
            if (scriptable2 == null) {
                return new NativeNumber(number);
            }
            return ScriptRuntime.wrapNumber(number);
        } else if (!(scriptable2 instanceof NativeNumber)) {
            throw incompatibleCallError(idFunctionObject);
        } else {
            double d = ((NativeNumber) scriptable2).doubleValue;
            int i = 10;
            switch (methodId) {
                case 2:
                case 3:
                    if (objArr.length != 0 && objArr[0] != Undefined.instance) {
                        i = ScriptRuntime.toInt32(objArr[0]);
                    }
                    return ScriptRuntime.numberToString(d, i);
                case 4:
                    return "(new Number(" + ScriptRuntime.toString(d) + "))";
                case 5:
                    return ScriptRuntime.wrapNumber(d);
                case 6:
                    return num_to(d, objArr, 2, 2, -20, 0);
                case 7:
                    if (Double.isNaN(d)) {
                        return "NaN";
                    }
                    if (Double.isInfinite(d)) {
                        return d >= 0.0d ? "Infinity" : "-Infinity";
                    }
                    return num_to(d, objArr, 1, 3, 0, 1);
                case 8:
                    if (objArr.length == 0 || objArr[0] == Undefined.instance) {
                        return ScriptRuntime.numberToString(d, 10);
                    }
                    if (Double.isNaN(d)) {
                        return "NaN";
                    }
                    if (Double.isInfinite(d)) {
                        return d >= 0.0d ? "Infinity" : "-Infinity";
                    }
                    return num_to(d, objArr, 0, 4, 1, 0);
                default:
                    throw new IllegalArgumentException(String.valueOf(methodId));
            }
        }
    }

    public String toString() {
        return ScriptRuntime.numberToString(this.doubleValue, 10);
    }

    private static String num_to(double d, Object[] objArr, int i, int i2, int i3, int i4) {
        int i5 = 0;
        if (objArr.length != 0) {
            int int32 = ScriptRuntime.toInt32(objArr[0]);
            if (int32 < i3 || int32 > 100) {
                throw ScriptRuntime.constructError("RangeError", ScriptRuntime.getMessage1("msg.bad.precision", ScriptRuntime.toString(objArr[0])));
            }
            i5 = int32;
            i = i2;
        }
        StringBuilder sb = new StringBuilder();
        DToA.JS_dtostr(sb, i, i5 + i4, d);
        return sb.toString();
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 3;
        if (length == 7) {
            char charAt = str.charAt(0);
            if (charAt == 't') {
                i = 6;
                str2 = "toFixed";
            } else {
                if (charAt == 'v') {
                    i = 5;
                    str2 = "valueOf";
                }
                str2 = null;
                i = 0;
            }
        } else if (length == 8) {
            char charAt2 = str.charAt(3);
            if (charAt2 == 'o') {
                i = 4;
                str2 = "toSource";
            } else {
                if (charAt2 == 't') {
                    i = 2;
                    str2 = "toString";
                }
                str2 = null;
                i = 0;
            }
        } else if (length == 11) {
            char charAt3 = str.charAt(0);
            if (charAt3 == 'c') {
                i = 1;
                str2 = "constructor";
            } else {
                if (charAt3 == 't') {
                    str2 = "toPrecision";
                    i = 8;
                }
                str2 = null;
                i = 0;
            }
        } else if (length != 13) {
            if (length == 14) {
                str2 = "toLocaleString";
            }
            str2 = null;
            i = 0;
        } else {
            str2 = "toExponential";
            i = 7;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }
}
