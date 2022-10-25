package org.mozilla.javascript.regexp;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.RegExpProxy;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Undefined;

/* loaded from: classes5.dex */
public class RegExpImpl implements RegExpProxy {
    protected String input;
    protected SubString lastMatch;
    protected SubString lastParen;
    protected SubString leftContext;
    protected boolean multiline;
    protected SubString[] parens;
    protected SubString rightContext;

    @Override // org.mozilla.javascript.RegExpProxy
    public boolean isRegExp(Scriptable scriptable) {
        return scriptable instanceof NativeRegExp;
    }

    @Override // org.mozilla.javascript.RegExpProxy
    public Object compileRegExp(Context context, String str, String str2) {
        return NativeRegExp.compileRE(context, str, str2, false);
    }

    @Override // org.mozilla.javascript.RegExpProxy
    public Scriptable wrapRegExp(Context context, Scriptable scriptable, Object obj) {
        return new NativeRegExp(scriptable, (RECompiled) obj);
    }

    @Override // org.mozilla.javascript.RegExpProxy
    public Object action(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, int i) {
        String scriptRuntime;
        Function function;
        GlobData globData = new GlobData();
        globData.mode = i;
        if (i == 1) {
            globData.optarg = 1;
            return globData.arrayobj == null ? matchOrReplace(context, scriptable, scriptable2, objArr, this, globData, false) : globData.arrayobj;
        } else if (i != 2) {
            if (i == 3) {
                globData.optarg = 1;
                return matchOrReplace(context, scriptable, scriptable2, objArr, this, globData, false);
            }
            throw Kit.codeBug();
        } else {
            Object obj = objArr.length < 2 ? Undefined.instance : objArr[1];
            if (obj instanceof Function) {
                function = (Function) obj;
                scriptRuntime = null;
            } else {
                scriptRuntime = ScriptRuntime.toString(obj);
                function = null;
            }
            globData.optarg = 2;
            globData.lambda = function;
            globData.repstr = scriptRuntime;
            globData.dollar = scriptRuntime == null ? -1 : scriptRuntime.indexOf(36);
            globData.charBuf = null;
            globData.leftIndex = 0;
            Object matchOrReplace = matchOrReplace(context, scriptable, scriptable2, objArr, this, globData, true);
            if (globData.charBuf == null) {
                if (globData.global || matchOrReplace == null || !matchOrReplace.equals(Boolean.TRUE)) {
                    return globData.str;
                }
                SubString subString = this.leftContext;
                replace_glob(globData, context, scriptable, this, subString.index, subString.length);
            }
            SubString subString2 = this.rightContext;
            globData.charBuf.append((CharSequence) subString2.str, subString2.index, subString2.index + subString2.length);
            return globData.charBuf.toString();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Object matchOrReplace(org.mozilla.javascript.Context r17, org.mozilla.javascript.Scriptable r18, org.mozilla.javascript.Scriptable r19, java.lang.Object[] r20, org.mozilla.javascript.regexp.RegExpImpl r21, org.mozilla.javascript.regexp.GlobData r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.RegExpImpl.matchOrReplace(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, java.lang.Object[], org.mozilla.javascript.regexp.RegExpImpl, org.mozilla.javascript.regexp.GlobData, boolean):java.lang.Object");
    }

    @Override // org.mozilla.javascript.RegExpProxy
    public int find_split(Context context, Scriptable scriptable, String str, String str2, Scriptable scriptable2, int[] iArr, int[] iArr2, boolean[] zArr, String[][] strArr) {
        int i;
        int i2 = iArr[0];
        int length = str.length();
        int languageVersion = context.getLanguageVersion();
        NativeRegExp nativeRegExp = (NativeRegExp) scriptable2;
        while (true) {
            int i3 = iArr[0];
            iArr[0] = i2;
            if (nativeRegExp.executeRegExp(context, scriptable, this, str, iArr, 0) != Boolean.TRUE) {
                iArr[0] = i3;
                iArr2[0] = 1;
                zArr[0] = false;
                return length;
            }
            i = iArr[0];
            iArr[0] = i3;
            zArr[0] = true;
            iArr2[0] = this.lastMatch.length;
            if (iArr2[0] != 0 || i != iArr[0]) {
                break;
            } else if (i != length) {
                i2 = i + 1;
            } else if (languageVersion == 120) {
                iArr2[0] = 1;
            } else {
                i = -1;
            }
        }
        i -= iArr2[0];
        SubString[] subStringArr = this.parens;
        int length2 = subStringArr == null ? 0 : subStringArr.length;
        strArr[0] = new String[length2];
        for (int i4 = 0; i4 < length2; i4++) {
            strArr[0][i4] = getParenSubString(i4).toString();
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SubString getParenSubString(int i) {
        SubString subString;
        SubString[] subStringArr = this.parens;
        return (subStringArr == null || i >= subStringArr.length || (subString = subStringArr[i]) == null) ? SubString.emptySubString : subString;
    }

    private static void match_glob(GlobData globData, Context context, Scriptable scriptable, int i, RegExpImpl regExpImpl) {
        if (globData.arrayobj == null) {
            globData.arrayobj = context.newArray(scriptable, 0);
        }
        globData.arrayobj.put(i, globData.arrayobj, regExpImpl.lastMatch.toString());
    }

    private static void replace_glob(GlobData globData, Context context, Scriptable scriptable, RegExpImpl regExpImpl, int i, int i2) {
        String str;
        int length;
        int i3;
        if (globData.lambda != null) {
            SubString[] subStringArr = regExpImpl.parens;
            int length2 = subStringArr == null ? 0 : subStringArr.length;
            Object[] objArr = new Object[length2 + 3];
            objArr[0] = regExpImpl.lastMatch.toString();
            for (int i4 = 0; i4 < length2; i4++) {
                SubString subString = subStringArr[i4];
                if (subString != null) {
                    objArr[i4 + 1] = subString.toString();
                } else {
                    objArr[i4 + 1] = Undefined.instance;
                }
            }
            objArr[length2 + 1] = Integer.valueOf(regExpImpl.leftContext.length);
            objArr[length2 + 2] = globData.str;
            if (regExpImpl != ScriptRuntime.getRegExpProxy(context)) {
                Kit.codeBug();
            }
            RegExpImpl regExpImpl2 = new RegExpImpl();
            regExpImpl2.multiline = regExpImpl.multiline;
            regExpImpl2.input = regExpImpl.input;
            ScriptRuntime.setRegExpProxy(context, regExpImpl2);
            try {
                Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
                str = ScriptRuntime.toString(globData.lambda.call(context, topLevelScope, topLevelScope, objArr));
                ScriptRuntime.setRegExpProxy(context, regExpImpl);
                length = str.length();
            } catch (Throwable th) {
                ScriptRuntime.setRegExpProxy(context, regExpImpl);
                throw th;
            }
        } else {
            str = null;
            length = globData.repstr.length();
            if (globData.dollar >= 0) {
                int[] iArr = new int[1];
                int i5 = globData.dollar;
                do {
                    SubString interpretDollar = interpretDollar(context, regExpImpl, globData.repstr, i5, iArr);
                    if (interpretDollar != null) {
                        length += interpretDollar.length - iArr[0];
                        i3 = i5 + iArr[0];
                    } else {
                        i3 = i5 + 1;
                    }
                    i5 = globData.repstr.indexOf(36, i3);
                } while (i5 >= 0);
            }
        }
        int i6 = length + i2 + regExpImpl.rightContext.length;
        StringBuilder sb = globData.charBuf;
        if (sb == null) {
            sb = new StringBuilder(i6);
            globData.charBuf = sb;
        } else {
            sb.ensureCapacity(globData.charBuf.length() + i6);
        }
        sb.append((CharSequence) regExpImpl.leftContext.str, i, i2 + i);
        if (globData.lambda != null) {
            sb.append(str);
        } else {
            do_replace(globData, context, regExpImpl);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0082 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static org.mozilla.javascript.regexp.SubString interpretDollar(org.mozilla.javascript.Context r7, org.mozilla.javascript.regexp.RegExpImpl r8, java.lang.String r9, int r10, int[] r11) {
        /*
            Method dump skipped, instructions count: 199
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.RegExpImpl.interpretDollar(org.mozilla.javascript.Context, org.mozilla.javascript.regexp.RegExpImpl, java.lang.String, int, int[]):org.mozilla.javascript.regexp.SubString");
    }

    private static void do_replace(GlobData globData, Context context, RegExpImpl regExpImpl) {
        int i;
        StringBuilder sb = globData.charBuf;
        String str = globData.repstr;
        int i2 = globData.dollar;
        int i3 = 0;
        if (i2 != -1) {
            int[] iArr = new int[1];
            int i4 = 0;
            do {
                sb.append(str.substring(i4, i2));
                SubString interpretDollar = interpretDollar(context, regExpImpl, str, i2, iArr);
                if (interpretDollar != null) {
                    int i5 = interpretDollar.length;
                    if (i5 > 0) {
                        sb.append((CharSequence) interpretDollar.str, interpretDollar.index, interpretDollar.index + i5);
                    }
                    i4 = iArr[0] + i2;
                    i = i2 + iArr[0];
                } else {
                    i4 = i2;
                    i = i2 + 1;
                }
                i2 = str.indexOf(36, i);
            } while (i2 >= 0);
            i3 = i4;
        }
        int length = str.length();
        if (length > i3) {
            sb.append(str.substring(i3, length));
        }
    }

    @Override // org.mozilla.javascript.RegExpProxy
    public Object js_split(Context context, Scriptable scriptable, String str, Object[] objArr) {
        RegExpProxy regExpProxy;
        Scriptable scriptable2;
        String str2;
        boolean z;
        String substring;
        Scriptable newArray = context.newArray(scriptable, 0);
        if (objArr.length < 1) {
            newArray.put(0, newArray, str);
            return newArray;
        }
        boolean z2 = objArr.length > 1 && objArr[1] != Undefined.instance;
        long j = 0;
        if (z2) {
            j = ScriptRuntime.toUint32(objArr[1]);
            if (j > str.length()) {
                j = str.length() + 1;
            }
        }
        long j2 = j;
        int[] iArr = new int[1];
        if (objArr[0] instanceof Scriptable) {
            RegExpProxy regExpProxy2 = ScriptRuntime.getRegExpProxy(context);
            if (regExpProxy2 != null) {
                Scriptable scriptable3 = (Scriptable) objArr[0];
                if (regExpProxy2.isRegExp(scriptable3)) {
                    regExpProxy = regExpProxy2;
                    scriptable2 = scriptable3;
                }
            }
            regExpProxy = regExpProxy2;
            scriptable2 = null;
        } else {
            regExpProxy = null;
            scriptable2 = null;
        }
        if (scriptable2 == null) {
            String scriptRuntime = ScriptRuntime.toString(objArr[0]);
            iArr[0] = scriptRuntime.length();
            str2 = scriptRuntime;
        } else {
            str2 = null;
        }
        int[] iArr2 = {0};
        boolean[] zArr = {false};
        String[][] strArr = {null};
        int languageVersion = context.getLanguageVersion();
        int i = 0;
        while (true) {
            int i2 = i;
            int i3 = languageVersion;
            String[][] strArr2 = strArr;
            boolean[] zArr2 = zArr;
            int[] iArr3 = iArr2;
            int[] iArr4 = iArr;
            int find_split = find_split(context, scriptable, str, str2, languageVersion, regExpProxy, scriptable2, iArr2, iArr, zArr2, strArr2);
            if (find_split < 0 || ((z2 && i2 >= j2) || find_split > str.length())) {
                break;
            }
            if (str.length() == 0) {
                substring = str;
                z = false;
            } else {
                z = false;
                substring = str.substring(iArr3[0], find_split);
            }
            newArray.put(i2, newArray, substring);
            i = i2 + 1;
            if (scriptable2 != null && zArr2[z ? 1 : 0]) {
                int length = strArr2[z ? 1 : 0].length;
                for (int i4 = 0; i4 < length && (!z2 || i < j2); i4++) {
                    newArray.put(i, newArray, strArr2[z ? 1 : 0][i4]);
                    i++;
                }
                zArr2[z ? 1 : 0] = z;
            }
            iArr3[z ? 1 : 0] = find_split + iArr4[z ? 1 : 0];
            if (i3 < 130 && i3 != 0 && !z2 && iArr3[z ? 1 : 0] == str.length()) {
                break;
            }
            languageVersion = i3;
            strArr = strArr2;
            zArr = zArr2;
            iArr2 = iArr3;
            iArr = iArr4;
        }
        return newArray;
    }

    private static int find_split(Context context, Scriptable scriptable, String str, String str2, int i, RegExpProxy regExpProxy, Scriptable scriptable2, int[] iArr, int[] iArr2, boolean[] zArr, String[][] strArr) {
        int indexOf;
        int i2 = iArr[0];
        int length = str.length();
        if (i == 120 && scriptable2 == null && str2.length() == 1 && str2.charAt(0) == ' ') {
            if (i2 == 0) {
                while (i2 < length && Character.isWhitespace(str.charAt(i2))) {
                    i2++;
                }
                iArr[0] = i2;
            }
            if (i2 == length) {
                return -1;
            }
            while (i2 < length && !Character.isWhitespace(str.charAt(i2))) {
                i2++;
            }
            int i3 = i2;
            while (i3 < length && Character.isWhitespace(str.charAt(i3))) {
                i3++;
            }
            iArr2[0] = i3 - i2;
            return i2;
        } else if (i2 > length) {
            return -1;
        } else {
            if (scriptable2 != null) {
                return regExpProxy.find_split(context, scriptable, str, str2, scriptable2, iArr, iArr2, zArr, strArr);
            }
            if (i == 0 || i >= 130 || length != 0) {
                if (str2.length() != 0) {
                    return (iArr[0] < length && (indexOf = str.indexOf(str2, iArr[0])) != -1) ? indexOf : length;
                } else if (i != 120) {
                    if (i2 == length) {
                        return -1;
                    }
                    return i2 + 1;
                } else if (i2 == length) {
                    iArr2[0] = 1;
                    return i2;
                } else {
                    return i2 + 1;
                }
            }
            return -1;
        }
    }
}
