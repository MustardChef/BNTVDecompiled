package com.lagradost.cloudstream3.extractors;

import androidx.tvprovider.media.p009tv.TvContractCompat;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.EvaluatorException;
import org.mozilla.javascript.ScriptableObject;

/* compiled from: Userload.kt */
@Metadata(m108d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J+\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u001b\u001a\u00020\u0004H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/Userload;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "requiresReferer", "", "getRequiresReferer", "()Z", "decodeVideoJs", "", "text", "evaluateMath", "mathExpression", "getUrl", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "url", "referer", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "splitInput", TvContractCompat.PARAM_INPUT, "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public class Userload extends ExtractorApi {
    private final boolean requiresReferer;
    private String name = "Userload";
    private String mainUrl = "https://userload.co";

    @Override // com.lagradost.cloudstream3.utils.ExtractorApi
    public Object getUrl(String str, String str2, Continuation<? super List<? extends ExtractorLink>> continuation) {
        return getUrl$suspendImpl(this, str, str2, (Continuation) continuation);
    }

    @Override // com.lagradost.cloudstream3.utils.ExtractorApi
    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    @Override // com.lagradost.cloudstream3.utils.ExtractorApi
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mainUrl = str;
    }

    @Override // com.lagradost.cloudstream3.utils.ExtractorApi
    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    private final List<String> splitInput(String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        String str2 = "";
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '(') {
                i++;
            } else if (charAt == ')') {
                i--;
            }
            str2 = str2 + charAt;
            if (i == 0) {
                if ((!StringsKt.isBlank(str2)) && !Intrinsics.areEqual(str2, "+")) {
                    arrayList.add(str2);
                }
                str2 = "";
            }
        }
        return arrayList;
    }

    private final String evaluateMath(String str) {
        Context enter = Context.enter();
        enter.initStandardObjects();
        enter.setOptimizationLevel(-1);
        ScriptableObject initStandardObjects = enter.initStandardObjects();
        Intrinsics.checkNotNullExpressionValue(initStandardObjects, "rhino.initStandardObjects()");
        ScriptableObject scriptableObject = initStandardObjects;
        try {
            return enter.evaluateString(scriptableObject, "eval(" + str + ')', "JavaScript", 1, null).toString();
        } catch (EvaluatorException unused) {
            return "";
        }
    }

    private final List<String> decodeVideoJs(String str) {
        MatchGroupCollection groups;
        MatchGroup matchGroup;
        String str2 = str;
        String str3 = "";
        new Regex("\\s+|/\\*.*?\\*/").replace(str2, "");
        List<String> drop = CollectionsKt.drop(StringsKt.split$default((CharSequence) ((String) StringsKt.split$default((CharSequence) str2, new String[]{"+(ﾟДﾟ)[ﾟoﾟ]"}, false, 0, 6, (Object) null).get(1)), new String[]{"+ (ﾟДﾟ)[ﾟεﾟ]+"}, false, 0, 6, (Object) null), 1);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(drop, 10));
        for (String str4 : drop) {
            arrayList.add(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(str4, "(oﾟｰﾟo)", "u", false, 4, (Object) null), "c", "0", false, 4, (Object) null), "(ﾟДﾟ)['0']", "c", false, 4, (Object) null), "ﾟΘﾟ", "1", false, 4, (Object) null), "!+[]", "1", false, 4, (Object) null), "-~", "1+", false, 4, (Object) null), "o", "3", false, 4, (Object) null), "_", "3", false, 4, (Object) null), "ﾟｰﾟ", "4", false, 4, (Object) null), "(+", "(", false, 4, (Object) null));
        }
        ArrayList<String> arrayList2 = new ArrayList();
        Iterator it = CollectionsKt.dropLast(arrayList, 1).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            List<String> splitInput = splitInput((String) it.next());
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(splitInput, 10));
            for (String str5 : splitInput) {
                arrayList3.add(StringsKt.substringBefore$default(evaluateMath(str5), ".", (String) null, 2, (Object) null));
            }
            String obj = arrayList3.toString();
            StringBuilder sb = new StringBuilder();
            int length = obj.length();
            for (int i = 0; i < length; i++) {
                char charAt = obj.charAt(i);
                if (Character.isDigit(charAt)) {
                    sb.append(charAt);
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
            arrayList2.add(sb2);
        }
        for (String str6 : arrayList2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str3);
            int parseInt = Integer.parseInt(str6, CharsKt.checkRadix(8));
            if (parseInt < 0 || parseInt > 65535) {
                throw new IllegalArgumentException("Invalid Char code: " + parseInt);
            }
            sb3.append((char) parseInt);
            str3 = sb3.toString();
        }
        MatchResult find$default = Regex.find$default(new Regex("\"morocco=\"((.|\\\\n)*?)\"&mycountry=\""), str3, 0, 2, null);
        return CollectionsKt.listOf((Object[]) new String[]{StringsKt.dropLast(StringsKt.drop(String.valueOf((find$default == null || (groups = find$default.getGroups()) == null || (matchGroup = groups.get(1)) == null) ? null : matchGroup.getValue()), 1), 1), StringsKt.substringBefore$default(StringsKt.substringAfter$default(str3, "&mycountry=\"+", (String) null, 2, (Object) null), ")", (String) null, 2, (Object) null)});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x016e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x02c7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0308 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0309  */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v23, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v42, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.lagradost.cloudstream3.extractors.Userload r31, java.lang.String r32, java.lang.String r33, kotlin.coroutines.Continuation r34) {
        /*
            Method dump skipped, instructions count: 837
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.extractors.Userload.getUrl$suspendImpl(com.lagradost.cloudstream3.extractors.Userload, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
