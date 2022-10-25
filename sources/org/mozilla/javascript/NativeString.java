package org.mozilla.javascript;

import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.text.Collator;
import kotlin.text.Typography;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class NativeString extends IdScriptableObject {
    private static final int ConstructorId_charAt = -5;
    private static final int ConstructorId_charCodeAt = -6;
    private static final int ConstructorId_concat = -14;
    private static final int ConstructorId_equalsIgnoreCase = -30;
    private static final int ConstructorId_fromCharCode = -1;
    private static final int ConstructorId_indexOf = -7;
    private static final int ConstructorId_lastIndexOf = -8;
    private static final int ConstructorId_localeCompare = -34;
    private static final int ConstructorId_match = -31;
    private static final int ConstructorId_replace = -33;
    private static final int ConstructorId_search = -32;
    private static final int ConstructorId_slice = -15;
    private static final int ConstructorId_split = -9;
    private static final int ConstructorId_substr = -13;
    private static final int ConstructorId_substring = -10;
    private static final int ConstructorId_toLocaleLowerCase = -35;
    private static final int ConstructorId_toLowerCase = -11;
    private static final int ConstructorId_toUpperCase = -12;
    private static final int Id_anchor = 28;
    private static final int Id_big = 21;
    private static final int Id_blink = 22;
    private static final int Id_bold = 16;
    private static final int Id_charAt = 5;
    private static final int Id_charCodeAt = 6;
    private static final int Id_concat = 14;
    private static final int Id_constructor = 1;
    private static final int Id_equals = 29;
    private static final int Id_equalsIgnoreCase = 30;
    private static final int Id_fixed = 18;
    private static final int Id_fontcolor = 26;
    private static final int Id_fontsize = 25;
    private static final int Id_indexOf = 7;
    private static final int Id_italics = 17;
    private static final int Id_lastIndexOf = 8;
    private static final int Id_length = 1;
    private static final int Id_link = 27;
    private static final int Id_localeCompare = 34;
    private static final int Id_match = 31;
    private static final int Id_replace = 33;
    private static final int Id_search = 32;
    private static final int Id_slice = 15;
    private static final int Id_small = 20;
    private static final int Id_split = 9;
    private static final int Id_strike = 19;
    private static final int Id_sub = 24;
    private static final int Id_substr = 13;
    private static final int Id_substring = 10;
    private static final int Id_sup = 23;
    private static final int Id_toLocaleLowerCase = 35;
    private static final int Id_toLocaleUpperCase = 36;
    private static final int Id_toLowerCase = 11;
    private static final int Id_toSource = 3;
    private static final int Id_toString = 2;
    private static final int Id_toUpperCase = 12;
    private static final int Id_trim = 37;
    private static final int Id_valueOf = 4;
    private static final int MAX_INSTANCE_ID = 1;
    private static final int MAX_PROTOTYPE_ID = 37;
    private static final Object STRING_TAG = "String";
    static final long serialVersionUID = 920268368584188687L;
    private CharSequence string;

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "String";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int getMaxInstanceId() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init(Scriptable scriptable, boolean z) {
        new NativeString("").exportAsJSClass(37, scriptable, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeString(CharSequence charSequence) {
        this.string = charSequence;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int findInstanceIdInfo(String str) {
        if (str.equals(SessionDescription.ATTR_LENGTH)) {
            return instanceIdInfo(7, 1);
        }
        return super.findInstanceIdInfo(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public String getInstanceIdName(int i) {
        return i == 1 ? SessionDescription.ATTR_LENGTH : super.getInstanceIdName(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public Object getInstanceIdValue(int i) {
        if (i == 1) {
            return ScriptRuntime.wrapInt(this.string.length());
        }
        return super.getInstanceIdValue(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        Object obj = STRING_TAG;
        addIdFunctionProperty(idFunctionObject, obj, -1, "fromCharCode", 1);
        addIdFunctionProperty(idFunctionObject, obj, -5, "charAt", 2);
        addIdFunctionProperty(idFunctionObject, obj, -6, "charCodeAt", 2);
        addIdFunctionProperty(idFunctionObject, obj, -7, "indexOf", 2);
        addIdFunctionProperty(idFunctionObject, obj, -8, "lastIndexOf", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_split, "split", 3);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_substring, "substring", 3);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_toLowerCase, "toLowerCase", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_toUpperCase, "toUpperCase", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_substr, "substr", 3);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_concat, "concat", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_slice, "slice", 3);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_equalsIgnoreCase, "equalsIgnoreCase", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_match, "match", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_search, "search", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_replace, "replace", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_localeCompare, "localeCompare", 2);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_toLocaleLowerCase, "toLocaleLowerCase", 1);
        super.fillConstructorProperties(idFunctionObject);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 0;
        switch (i) {
            case 1:
                str = "constructor";
                i2 = 1;
                break;
            case 2:
                str = "toString";
                break;
            case 3:
                str = "toSource";
                break;
            case 4:
                str = "valueOf";
                break;
            case 5:
                str = "charAt";
                i2 = 1;
                break;
            case 6:
                str = "charCodeAt";
                i2 = 1;
                break;
            case 7:
                str = "indexOf";
                i2 = 1;
                break;
            case 8:
                str = "lastIndexOf";
                i2 = 1;
                break;
            case 9:
                str2 = "split";
                str = str2;
                i2 = 2;
                break;
            case 10:
                str2 = "substring";
                str = str2;
                i2 = 2;
                break;
            case 11:
                str = "toLowerCase";
                break;
            case 12:
                str = "toUpperCase";
                break;
            case 13:
                str2 = "substr";
                str = str2;
                i2 = 2;
                break;
            case 14:
                str = "concat";
                i2 = 1;
                break;
            case 15:
                str2 = "slice";
                str = str2;
                i2 = 2;
                break;
            case 16:
                str = TtmlNode.BOLD;
                break;
            case 17:
                str = "italics";
                break;
            case 18:
                str = "fixed";
                break;
            case 19:
                str = "strike";
                break;
            case 20:
                str = "small";
                break;
            case 21:
                str = "big";
                break;
            case 22:
                str = "blink";
                break;
            case 23:
                str = "sup";
                break;
            case 24:
                str = "sub";
                break;
            case 25:
                str = "fontsize";
                break;
            case 26:
                str = "fontcolor";
                break;
            case 27:
                str = "link";
                break;
            case 28:
                str = "anchor";
                break;
            case 29:
                str = "equals";
                i2 = 1;
                break;
            case 30:
                str = "equalsIgnoreCase";
                i2 = 1;
                break;
            case 31:
                str = "match";
                i2 = 1;
                break;
            case 32:
                str = "search";
                i2 = 1;
                break;
            case 33:
                str = "replace";
                i2 = 1;
                break;
            case 34:
                str = "localeCompare";
                i2 = 1;
                break;
            case 35:
                str = "toLocaleLowerCase";
                break;
            case 36:
                str = "toLocaleUpperCase";
                break;
            case 37:
                str = "trim";
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(STRING_TAG, i, str, i2);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(STRING_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        Scriptable scriptable3 = scriptable2;
        Object[] objArr2 = objArr;
        while (true) {
            int i = 0;
            if (methodId == -1) {
                int length = objArr2.length;
                if (length < 1) {
                    return "";
                }
                StringBuffer stringBuffer = new StringBuffer(length);
                while (i != length) {
                    stringBuffer.append(ScriptRuntime.toUint16(objArr2[i]));
                    i++;
                }
                return stringBuffer.toString();
            }
            switch (methodId) {
                case ConstructorId_toLocaleLowerCase /* -35 */:
                case ConstructorId_localeCompare /* -34 */:
                case ConstructorId_replace /* -33 */:
                case ConstructorId_search /* -32 */:
                case ConstructorId_match /* -31 */:
                case ConstructorId_equalsIgnoreCase /* -30 */:
                    break;
                default:
                    switch (methodId) {
                        case ConstructorId_slice /* -15 */:
                        case ConstructorId_concat /* -14 */:
                        case ConstructorId_substr /* -13 */:
                        case ConstructorId_toUpperCase /* -12 */:
                        case ConstructorId_toLowerCase /* -11 */:
                        case ConstructorId_substring /* -10 */:
                        case ConstructorId_split /* -9 */:
                        case -8:
                        case -7:
                        case -6:
                        case -5:
                            break;
                        default:
                            switch (methodId) {
                                case 1:
                                    String charSequence = objArr2.length >= 1 ? ScriptRuntime.toCharSequence(objArr2[0]) : "";
                                    if (scriptable3 == null) {
                                        return new NativeString(charSequence);
                                    }
                                    return charSequence instanceof String ? charSequence : charSequence.toString();
                                case 2:
                                case 4:
                                    CharSequence charSequence2 = realThis(scriptable3, idFunctionObject).string;
                                    return charSequence2 instanceof String ? charSequence2 : charSequence2.toString();
                                case 3:
                                    CharSequence charSequence3 = realThis(scriptable3, idFunctionObject).string;
                                    return "(new String(\"" + ScriptRuntime.escapeString(charSequence3.toString()) + "\"))";
                                case 5:
                                case 6:
                                    CharSequence charSequence4 = ScriptRuntime.toCharSequence(scriptable3);
                                    double integer = ScriptRuntime.toInteger(objArr2, 0);
                                    if (integer < 0.0d || integer >= charSequence4.length()) {
                                        return methodId == 5 ? "" : ScriptRuntime.NaNobj;
                                    }
                                    char charAt = charSequence4.charAt((int) integer);
                                    if (methodId == 5) {
                                        return String.valueOf(charAt);
                                    }
                                    return ScriptRuntime.wrapInt(charAt);
                                case 7:
                                    return ScriptRuntime.wrapInt(js_indexOf(ScriptRuntime.toString(scriptable3), objArr2));
                                case 8:
                                    return ScriptRuntime.wrapInt(js_lastIndexOf(ScriptRuntime.toString(scriptable3), objArr2));
                                case 9:
                                    return ScriptRuntime.checkRegExpProxy(context).js_split(context, scriptable, ScriptRuntime.toString(scriptable3), objArr2);
                                case 10:
                                    return js_substring(context, ScriptRuntime.toCharSequence(scriptable3), objArr2);
                                case 11:
                                    return ScriptRuntime.toString(scriptable3).toLowerCase(ScriptRuntime.ROOT_LOCALE);
                                case 12:
                                    return ScriptRuntime.toString(scriptable3).toUpperCase(ScriptRuntime.ROOT_LOCALE);
                                case 13:
                                    return js_substr(ScriptRuntime.toCharSequence(scriptable3), objArr2);
                                case 14:
                                    return js_concat(ScriptRuntime.toString(scriptable3), objArr2);
                                case 15:
                                    return js_slice(ScriptRuntime.toCharSequence(scriptable3), objArr2);
                                case 16:
                                    return tagify(scriptable3, "b", null, null);
                                case 17:
                                    return tagify(scriptable3, "i", null, null);
                                case 18:
                                    return tagify(scriptable3, TtmlNode.TAG_TT, null, null);
                                case 19:
                                    return tagify(scriptable3, "strike", null, null);
                                case 20:
                                    return tagify(scriptable3, "small", null, null);
                                case 21:
                                    return tagify(scriptable3, "big", null, null);
                                case 22:
                                    return tagify(scriptable3, "blink", null, null);
                                case 23:
                                    return tagify(scriptable3, "sup", null, null);
                                case 24:
                                    return tagify(scriptable3, "sub", null, null);
                                case 25:
                                    return tagify(scriptable3, "font", "size", objArr2);
                                case 26:
                                    return tagify(scriptable3, "font", "color", objArr2);
                                case 27:
                                    return tagify(scriptable3, "a", ShareConstants.WEB_DIALOG_PARAM_HREF, objArr2);
                                case 28:
                                    return tagify(scriptable3, "a", "name", objArr2);
                                case 29:
                                case 30:
                                    String scriptRuntime = ScriptRuntime.toString(scriptable3);
                                    String scriptRuntime2 = ScriptRuntime.toString(objArr2, 0);
                                    return ScriptRuntime.wrapBoolean(methodId == 29 ? scriptRuntime.equals(scriptRuntime2) : scriptRuntime.equalsIgnoreCase(scriptRuntime2));
                                case 31:
                                case 32:
                                case 33:
                                    return ScriptRuntime.checkRegExpProxy(context).action(context, scriptable, scriptable3, objArr2, methodId == 31 ? 1 : methodId == 32 ? 3 : 2);
                                case 34:
                                    Collator collator = Collator.getInstance(context.getLocale());
                                    collator.setStrength(3);
                                    collator.setDecomposition(1);
                                    return ScriptRuntime.wrapNumber(collator.compare(ScriptRuntime.toString(scriptable3), ScriptRuntime.toString(objArr2, 0)));
                                case 35:
                                    return ScriptRuntime.toString(scriptable3).toLowerCase(context.getLocale());
                                case 36:
                                    return ScriptRuntime.toString(scriptable3).toUpperCase(context.getLocale());
                                case 37:
                                    String scriptRuntime3 = ScriptRuntime.toString(scriptable3);
                                    char[] charArray = scriptRuntime3.toCharArray();
                                    while (i < charArray.length && ScriptRuntime.isJSWhitespaceOrLineTerminator(charArray[i])) {
                                        i++;
                                    }
                                    int length2 = charArray.length;
                                    while (length2 > i && ScriptRuntime.isJSWhitespaceOrLineTerminator(charArray[length2 - 1])) {
                                        length2--;
                                    }
                                    return scriptRuntime3.substring(i, length2);
                                default:
                                    throw new IllegalArgumentException(String.valueOf(methodId));
                            }
                    }
            }
            if (objArr2.length > 0) {
                Scriptable object = ScriptRuntime.toObject(scriptable, ScriptRuntime.toCharSequence(objArr2[0]));
                int length3 = objArr2.length - 1;
                Object[] objArr3 = new Object[length3];
                while (i < length3) {
                    int i2 = i + 1;
                    objArr3[i] = objArr2[i2];
                    i = i2;
                }
                scriptable3 = object;
                objArr2 = objArr3;
            } else {
                scriptable3 = ScriptRuntime.toObject(scriptable, ScriptRuntime.toCharSequence(scriptable3));
            }
            methodId = -methodId;
        }
    }

    private static NativeString realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (!(scriptable instanceof NativeString)) {
            throw incompatibleCallError(idFunctionObject);
        }
        return (NativeString) scriptable;
    }

    private static String tagify(Object obj, String str, String str2, Object[] objArr) {
        String scriptRuntime = ScriptRuntime.toString(obj);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Typography.less);
        stringBuffer.append(str);
        if (str2 != null) {
            stringBuffer.append(' ');
            stringBuffer.append(str2);
            stringBuffer.append("=\"");
            stringBuffer.append(ScriptRuntime.toString(objArr, 0));
            stringBuffer.append('\"');
        }
        stringBuffer.append(Typography.greater);
        stringBuffer.append(scriptRuntime);
        stringBuffer.append("</");
        stringBuffer.append(str);
        stringBuffer.append(Typography.greater);
        return stringBuffer.toString();
    }

    public CharSequence toCharSequence() {
        return this.string;
    }

    public String toString() {
        CharSequence charSequence = this.string;
        return charSequence instanceof String ? (String) charSequence : charSequence.toString();
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        if (i >= 0 && i < this.string.length()) {
            return String.valueOf(this.string.charAt(i));
        }
        return super.get(i, scriptable);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        if (i < 0 || i >= this.string.length()) {
            super.put(i, scriptable, obj);
        }
    }

    private static int js_indexOf(String str, Object[] objArr) {
        String scriptRuntime = ScriptRuntime.toString(objArr, 0);
        double integer = ScriptRuntime.toInteger(objArr, 1);
        if (integer > str.length()) {
            return -1;
        }
        if (integer < 0.0d) {
            integer = 0.0d;
        }
        return str.indexOf(scriptRuntime, (int) integer);
    }

    private static int js_lastIndexOf(String str, Object[] objArr) {
        String scriptRuntime = ScriptRuntime.toString(objArr, 0);
        double number = ScriptRuntime.toNumber(objArr, 1);
        if (number != number || number > str.length()) {
            number = str.length();
        } else if (number < 0.0d) {
            number = 0.0d;
        }
        return str.lastIndexOf(scriptRuntime, (int) number);
    }

    private static CharSequence js_substring(Context context, CharSequence charSequence, Object[] objArr) {
        int length = charSequence.length();
        double integer = ScriptRuntime.toInteger(objArr, 0);
        double d = 0.0d;
        if (integer < 0.0d) {
            integer = 0.0d;
        } else {
            double d2 = length;
            if (integer > d2) {
                integer = d2;
            }
        }
        if (objArr.length <= 1 || objArr[1] == Undefined.instance) {
            d = length;
        } else {
            double integer2 = ScriptRuntime.toInteger(objArr[1]);
            if (integer2 >= 0.0d) {
                d = length;
                if (integer2 <= d) {
                    d = integer2;
                }
            }
            if (d < integer) {
                if (context.getLanguageVersion() != 120) {
                    double d3 = integer;
                    integer = d;
                    d = d3;
                } else {
                    d = integer;
                }
            }
        }
        return charSequence.subSequence((int) integer, (int) d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getLength() {
        return this.string.length();
    }

    private static CharSequence js_substr(CharSequence charSequence, Object[] objArr) {
        double d;
        if (objArr.length < 1) {
            return charSequence;
        }
        double integer = ScriptRuntime.toInteger(objArr[0]);
        int length = charSequence.length();
        if (integer < 0.0d) {
            integer += length;
            if (integer < 0.0d) {
                integer = 0.0d;
            }
        } else {
            double d2 = length;
            if (integer > d2) {
                integer = d2;
            }
        }
        if (objArr.length == 1) {
            d = length;
        } else {
            double integer2 = ScriptRuntime.toInteger(objArr[1]);
            double d3 = (integer2 >= 0.0d ? integer2 : 0.0d) + integer;
            d = length;
            if (d3 <= d) {
                d = d3;
            }
        }
        return charSequence.subSequence((int) integer, (int) d);
    }

    private static String js_concat(String str, Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            return str;
        }
        if (length == 1) {
            return str.concat(ScriptRuntime.toString(objArr[0]));
        }
        int length2 = str.length();
        String[] strArr = new String[length];
        for (int i = 0; i != length; i++) {
            String scriptRuntime = ScriptRuntime.toString(objArr[i]);
            strArr[i] = scriptRuntime;
            length2 += scriptRuntime.length();
        }
        StringBuffer stringBuffer = new StringBuffer(length2);
        stringBuffer.append(str);
        for (int i2 = 0; i2 != length; i2++) {
            stringBuffer.append(strArr[i2]);
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0036, code lost:
        if (r5 < 0.0d) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
        if (r5 > r3) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
        r3 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0042, code lost:
        if (r3 >= r0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0044, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0046, code lost:
        r2 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.CharSequence js_slice(java.lang.CharSequence r9, java.lang.Object[] r10) {
        /*
            int r0 = r10.length
            if (r0 == 0) goto L4d
            r0 = 0
            r0 = r10[r0]
            double r0 = org.mozilla.javascript.ScriptRuntime.toInteger(r0)
            int r2 = r9.length()
            r3 = 0
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 >= 0) goto L1c
            double r5 = (double) r2
            double r0 = r0 + r5
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 >= 0) goto L22
            r0 = r3
            goto L22
        L1c:
            double r5 = (double) r2
            int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r7 <= 0) goto L22
            r0 = r5
        L22:
            int r5 = r10.length
            r6 = 1
            if (r5 != r6) goto L28
            double r2 = (double) r2
            goto L47
        L28:
            r10 = r10[r6]
            double r5 = org.mozilla.javascript.ScriptRuntime.toInteger(r10)
            int r10 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r10 >= 0) goto L39
            double r7 = (double) r2
            double r5 = r5 + r7
            int r10 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r10 >= 0) goto L3f
            goto L40
        L39:
            double r3 = (double) r2
            int r10 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r10 <= 0) goto L3f
            goto L40
        L3f:
            r3 = r5
        L40:
            int r10 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r10 >= 0) goto L46
            r2 = r0
            goto L47
        L46:
            r2 = r3
        L47:
            int r10 = (int) r0
            int r0 = (int) r2
            java.lang.CharSequence r9 = r9.subSequence(r10, r0)
        L4d:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeString.js_slice(java.lang.CharSequence, java.lang.Object[]):java.lang.CharSequence");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // org.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int i = 8;
        switch (str.length()) {
            case 3:
                char charAt = str.charAt(2);
                if (charAt == 'b') {
                    if (str.charAt(0) == 's' && str.charAt(1) == 'u') {
                        return 24;
                    }
                } else if (charAt == 'g') {
                    if (str.charAt(0) == 'b' && str.charAt(1) == 'i') {
                        return 21;
                    }
                } else if (charAt == 'p' && str.charAt(0) == 's' && str.charAt(1) == 'u') {
                    return 23;
                }
                str2 = null;
                i = 0;
                break;
            case 4:
                char charAt2 = str.charAt(0);
                if (charAt2 != 'b') {
                    if (charAt2 != 'l') {
                        if (charAt2 == 't') {
                            i = 37;
                            str2 = "trim";
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        i = 27;
                        str2 = "link";
                        break;
                    }
                } else {
                    i = 16;
                    str2 = TtmlNode.BOLD;
                    break;
                }
            case 5:
                char charAt3 = str.charAt(4);
                if (charAt3 == 'd') {
                    i = 18;
                    str2 = "fixed";
                    break;
                } else if (charAt3 == 'e') {
                    i = 15;
                    str2 = "slice";
                    break;
                } else if (charAt3 == 'h') {
                    i = 31;
                    str2 = "match";
                    break;
                } else if (charAt3 == 't') {
                    i = 9;
                    str2 = "split";
                    break;
                } else if (charAt3 == 'k') {
                    i = 22;
                    str2 = "blink";
                    break;
                } else {
                    if (charAt3 == 'l') {
                        i = 20;
                        str2 = "small";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
            case 6:
                char charAt4 = str.charAt(1);
                if (charAt4 == 'e') {
                    i = 32;
                    str2 = "search";
                    break;
                } else if (charAt4 == 'h') {
                    i = 5;
                    str2 = "charAt";
                    break;
                } else if (charAt4 == 'q') {
                    i = 29;
                    str2 = "equals";
                    break;
                } else if (charAt4 == 'n') {
                    i = 28;
                    str2 = "anchor";
                    break;
                } else if (charAt4 == 'o') {
                    i = 14;
                    str2 = "concat";
                    break;
                } else if (charAt4 == 't') {
                    i = 19;
                    str2 = "strike";
                    break;
                } else {
                    if (charAt4 == 'u') {
                        i = 13;
                        str2 = "substr";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
            case 7:
                char charAt5 = str.charAt(1);
                if (charAt5 == 'a') {
                    str2 = "valueOf";
                    i = 4;
                    break;
                } else if (charAt5 == 'e') {
                    i = 33;
                    str2 = "replace";
                    break;
                } else if (charAt5 == 'n') {
                    i = 7;
                    str2 = "indexOf";
                    break;
                } else {
                    if (charAt5 == 't') {
                        i = 17;
                        str2 = "italics";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
            case 8:
                char charAt6 = str.charAt(4);
                if (charAt6 != 'r') {
                    if (charAt6 != 's') {
                        if (charAt6 == 'u') {
                            i = 3;
                            str2 = "toSource";
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        i = 25;
                        str2 = "fontsize";
                        break;
                    }
                } else {
                    str2 = "toString";
                    i = 2;
                    break;
                }
            case 9:
                char charAt7 = str.charAt(0);
                if (charAt7 != 'f') {
                    if (charAt7 == 's') {
                        i = 10;
                        str2 = "substring";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                } else {
                    i = 26;
                    str2 = "fontcolor";
                    break;
                }
            case 10:
                i = 6;
                str2 = "charCodeAt";
                break;
            case 11:
                char charAt8 = str.charAt(2);
                if (charAt8 == 'L') {
                    i = 11;
                    str2 = "toLowerCase";
                    break;
                } else if (charAt8 == 'U') {
                    i = 12;
                    str2 = "toUpperCase";
                    break;
                } else if (charAt8 == 'n') {
                    str2 = "constructor";
                    i = 1;
                    break;
                } else {
                    if (charAt8 == 's') {
                        str2 = "lastIndexOf";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
            case 12:
            case 14:
            case 15:
            default:
                str2 = null;
                i = 0;
                break;
            case 13:
                i = 34;
                str2 = "localeCompare";
                break;
            case 16:
                i = 30;
                str2 = "equalsIgnoreCase";
                break;
            case 17:
                char charAt9 = str.charAt(8);
                if (charAt9 != 'L') {
                    if (charAt9 == 'U') {
                        i = 36;
                        str2 = "toLocaleUpperCase";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                } else {
                    i = 35;
                    str2 = "toLocaleLowerCase";
                    break;
                }
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }
}
