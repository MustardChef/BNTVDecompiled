package com.lagradost.cloudstream3.extractors;

import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchSB.kt */
@Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/WatchSB;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "url", "referer", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public class WatchSB extends ExtractorApi {
    private final boolean requiresReferer;
    private String name = "WatchSB";
    private String mainUrl = "https://watchsb.com";

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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.lagradost.cloudstream3.extractors.WatchSB r20, java.lang.String r21, java.lang.String r22, kotlin.coroutines.Continuation r23) {
        /*
            r0 = r20
            r1 = r23
            boolean r2 = r1 instanceof com.lagradost.cloudstream3.extractors.WatchSB$getUrl$1
            if (r2 == 0) goto L18
            r2 = r1
            com.lagradost.cloudstream3.extractors.WatchSB$getUrl$1 r2 = (com.lagradost.cloudstream3.extractors.WatchSB$getUrl$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L1d
        L18:
            com.lagradost.cloudstream3.extractors.WatchSB$getUrl$1 r2 = new com.lagradost.cloudstream3.extractors.WatchSB$getUrl$1
            r2.<init>(r0, r1)
        L1d:
            java.lang.Object r1 = r2.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.label
            r4 = 1
            if (r3 == 0) goto L40
            if (r3 != r4) goto L38
            java.lang.Object r0 = r2.L$1
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r2 = r2.L$0
            com.lagradost.cloudstream3.extractors.WatchSB r2 = (com.lagradost.cloudstream3.extractors.WatchSB) r2
            kotlin.ResultKt.throwOnFailure(r1)
            r4 = r0
            r0 = r2
            goto L83
        L38:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L40:
            kotlin.ResultKt.throwOnFailure(r1)
            com.lagradost.cloudstream3.utils.Extensions$RequestCustom r1 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            r3 = r1
            com.lagradost.nicehttp.Requests r3 = (com.lagradost.nicehttp.Requests) r3
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            com.lagradost.cloudstream3.network.WebViewResolver r1 = new com.lagradost.cloudstream3.network.WebViewResolver
            kotlin.text.Regex r14 = new kotlin.text.Regex
            java.lang.String r12 = "master\\.m3u8"
            r14.<init>(r12)
            r12 = 2
            r13 = 0
            r1.<init>(r14, r13, r12, r13)
            r14 = r1
            okhttp3.Interceptor r14 = (okhttp3.Interceptor) r14
            r1 = 0
            r17 = 1534(0x5fe, float:2.15E-42)
            r18 = 0
            r2.L$0 = r0
            r12 = r21
            r2.L$1 = r12
            r2.label = r4
            r4 = r21
            r12 = 0
            r19 = r15
            r15 = r1
            r16 = r2
            java.lang.Object r1 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18)
            r2 = r19
            if (r1 != r2) goto L81
            return r2
        L81:
            r4 = r21
        L83:
            com.lagradost.nicehttp.NiceResponse r1 = (com.lagradost.nicehttp.NiceResponse) r1
            com.lagradost.cloudstream3.utils.M3u8Helper$Companion r2 = com.lagradost.cloudstream3.utils.M3u8Helper.Companion
            java.lang.String r0 = r0.getName()
            java.lang.String r3 = r1.getUrl()
            r5 = 0
            okhttp3.Headers r1 = r1.getHeaders()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Map r6 = kotlin.collections.MapsKt.toMap(r1)
            r7 = 0
            r8 = 40
            r9 = 0
            r1 = r2
            r2 = r0
            java.util.List r0 = com.lagradost.cloudstream3.utils.M3u8Helper.Companion.generateM3u8$default(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.extractors.WatchSB.getUrl$suspendImpl(com.lagradost.cloudstream3.extractors.WatchSB, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
