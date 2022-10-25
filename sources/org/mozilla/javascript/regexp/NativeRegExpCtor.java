package org.mozilla.javascript.regexp;

import androidx.tvprovider.media.p009tv.TvContractCompat;
import kotlin.text.Typography;
import org.mozilla.javascript.BaseFunction;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.TopLevel;
import org.mozilla.javascript.Undefined;

/* loaded from: classes5.dex */
class NativeRegExpCtor extends BaseFunction {
    private static final int DOLLAR_ID_BASE = 12;
    private static final int Id_AMPERSAND = 6;
    private static final int Id_BACK_QUOTE = 10;
    private static final int Id_DOLLAR_1 = 13;
    private static final int Id_DOLLAR_2 = 14;
    private static final int Id_DOLLAR_3 = 15;
    private static final int Id_DOLLAR_4 = 16;
    private static final int Id_DOLLAR_5 = 17;
    private static final int Id_DOLLAR_6 = 18;
    private static final int Id_DOLLAR_7 = 19;
    private static final int Id_DOLLAR_8 = 20;
    private static final int Id_DOLLAR_9 = 21;
    private static final int Id_PLUS = 8;
    private static final int Id_QUOTE = 12;
    private static final int Id_STAR = 2;
    private static final int Id_UNDERSCORE = 4;
    private static final int Id_input = 3;
    private static final int Id_lastMatch = 5;
    private static final int Id_lastParen = 7;
    private static final int Id_leftContext = 9;
    private static final int Id_multiline = 1;
    private static final int Id_rightContext = 11;
    private static final int MAX_INSTANCE_ID = 21;
    static final long serialVersionUID = -5733330028285400526L;

    @Override // org.mozilla.javascript.BaseFunction
    public String getFunctionName() {
        return "RegExp";
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (objArr.length > 0 && (objArr[0] instanceof NativeRegExp) && (objArr.length == 1 || objArr[1] == Undefined.instance)) {
            return objArr[0];
        }
        return construct(context, scriptable, objArr);
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function
    public Scriptable construct(Context context, Scriptable scriptable, Object[] objArr) {
        NativeRegExp nativeRegExp = new NativeRegExp();
        nativeRegExp.compile(context, scriptable, objArr);
        ScriptRuntime.setBuiltinProtoAndParent(nativeRegExp, scriptable, TopLevel.Builtins.RegExp);
        return nativeRegExp;
    }

    private static RegExpImpl getImpl() {
        return (RegExpImpl) ScriptRuntime.getRegExpProxy(Context.getCurrentContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    public int getMaxInstanceId() {
        return super.getMaxInstanceId() + 21;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00ed, code lost:
        if (r11.charAt(0) == '$') goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00fc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010c  */
    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int findInstanceIdInfo(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.NativeRegExpCtor.findInstanceIdInfo(java.lang.String):int");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    public String getInstanceIdName(int i) {
        int maxInstanceId = i - super.getMaxInstanceId();
        if (1 <= maxInstanceId && maxInstanceId <= 21) {
            switch (maxInstanceId) {
                case 1:
                    return "multiline";
                case 2:
                    return "$*";
                case 3:
                    return TvContractCompat.PARAM_INPUT;
                case 4:
                    return "$_";
                case 5:
                    return "lastMatch";
                case 6:
                    return "$&";
                case 7:
                    return "lastParen";
                case 8:
                    return "$+";
                case 9:
                    return "leftContext";
                case 10:
                    return "$`";
                case 11:
                    return "rightContext";
                case 12:
                    return "$'";
                default:
                    return new String(new char[]{Typography.dollar, (char) (((maxInstanceId - 12) - 1) + 49)});
            }
        }
        return super.getInstanceIdName(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    public Object getInstanceIdValue(int i) {
        Object obj;
        int maxInstanceId = i - super.getMaxInstanceId();
        if (1 <= maxInstanceId && maxInstanceId <= 21) {
            RegExpImpl impl = getImpl();
            switch (maxInstanceId) {
                case 1:
                case 2:
                    return ScriptRuntime.wrapBoolean(impl.multiline);
                case 3:
                case 4:
                    obj = impl.input;
                    break;
                case 5:
                case 6:
                    obj = impl.lastMatch;
                    break;
                case 7:
                case 8:
                    obj = impl.lastParen;
                    break;
                case 9:
                case 10:
                    obj = impl.leftContext;
                    break;
                case 11:
                case 12:
                    obj = impl.rightContext;
                    break;
                default:
                    obj = impl.getParenSubString((maxInstanceId - 12) - 1);
                    break;
            }
            return obj == null ? "" : obj.toString();
        }
        return super.getInstanceIdValue(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    public void setInstanceIdValue(int i, Object obj) {
        int maxInstanceId = i - super.getMaxInstanceId();
        switch (maxInstanceId) {
            case 1:
            case 2:
                getImpl().multiline = ScriptRuntime.toBoolean(obj);
                return;
            case 3:
            case 4:
                getImpl().input = ScriptRuntime.toString(obj);
                return;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                return;
            default:
                int i2 = (maxInstanceId - 12) - 1;
                if (i2 < 0 || i2 > 8) {
                    super.setInstanceIdValue(i, obj);
                    return;
                }
                return;
        }
    }
}
