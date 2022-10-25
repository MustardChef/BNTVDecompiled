package com.lagradost.cloudstream3.extractors;

import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SBPlay.kt */
@Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/SBPlay;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "url", "referer", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public class SBPlay extends ExtractorApi {
    private String mainUrl = "https://sbplay.one";
    private String name = "SBPlay";
    private final boolean requiresReferer;

    @Override // com.lagradost.cloudstream3.utils.ExtractorApi
    public Object getUrl(String str, String str2, Continuation<? super List<? extends ExtractorLink>> continuation) {
        return getUrl$suspendImpl(this, str, str2, (Continuation) continuation);
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
    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    @Override // com.lagradost.cloudstream3.utils.ExtractorApi
    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(12:71|(1:72)|73|74|75|76|(8:78|79|80|81|82|83|84|(1:86)(7:87|16|17|(0)(0)|42|43|(1:44)))(7:97|98|99|100|42|43|(1:44))|92|93|42|43|(1:44)) */
    /* JADX WARN: Can't wrap try/catch for region: R(14:50|51|52|53|54|55|56|57|58|59|60|61|62|(1:64)(4:66|67|68|(1:70)(12:71|72|73|74|75|76|(8:78|79|80|81|82|83|84|(1:86)(7:87|16|17|(0)(0)|42|43|(1:44)))(7:97|98|99|100|42|43|(1:44))|92|93|42|43|(1:44)))) */
    /* JADX WARN: Can't wrap try/catch for region: R(5:34|35|36|37|(1:39)) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:78|79|80|81|82|83|84|(1:86)(7:87|16|17|(0)(0)|42|43|(1:44))) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0318, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x032a, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x032b, code lost:
        r12 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x032e, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x032f, code lost:
        r12 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0371, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0372, code lost:
        r12 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x038d, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x038e, code lost:
        r12 = r25;
        r10 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0396, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0397, code lost:
        r12 = r25;
        r10 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x039c, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x039d, code lost:
        r12 = r25;
        r10 = r26;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x024a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x025f A[Catch: Exception -> 0x0371, TRY_LEAVE, TryCatch #9 {Exception -> 0x0371, blocks: (B:60:0x0259, B:62:0x025f), top: B:157:0x0259 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0280 A[Catch: Exception -> 0x0323, TRY_LEAVE, TryCatch #13 {Exception -> 0x0323, blocks: (B:70:0x027c, B:72:0x0280), top: B:165:0x027c }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02aa A[Catch: Exception -> 0x031b, TryCatch #11 {Exception -> 0x031b, blocks: (B:75:0x028e, B:77:0x0297, B:79:0x029e, B:85:0x02aa, B:87:0x02b0), top: B:161:0x028e }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02f0 A[Catch: Exception -> 0x0318, TRY_LEAVE, TryCatch #5 {Exception -> 0x0318, blocks: (B:92:0x02bc, B:97:0x02c8, B:98:0x02f0), top: B:149:0x02bc }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:114:0x036b -> B:137:0x03b1). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:136:0x03ac -> B:137:0x03b1). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0276 -> B:165:0x027c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.lagradost.cloudstream3.extractors.SBPlay r48, java.lang.String r49, java.lang.String r50, kotlin.coroutines.Continuation r51) {
        /*
            Method dump skipped, instructions count: 952
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.extractors.SBPlay.getUrl$suspendImpl(com.lagradost.cloudstream3.extractors.SBPlay, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
