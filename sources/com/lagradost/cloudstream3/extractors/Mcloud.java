package com.lagradost.cloudstream3.extractors;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.common.net.HttpHeaders;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Mcloud.kt */
@Metadata(m108d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001aR\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u0012X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/Mcloud;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "()V", "headers", "", "", "getHeaders", "()Ljava/util/Map;", SDKConstants.PARAM_KEY, "mainUrl", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "url", "referer", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public class Mcloud extends ExtractorApi {
    private String name = "Mcloud";
    private String mainUrl = "https://mcloud.to";
    private final boolean requiresReferer = true;
    private final Map<String, String> headers = MapsKt.mapOf(TuplesKt.m100to(HttpHeaders.HOST, "mcloud.to"), TuplesKt.m100to("User-Agent", MainAPIKt.USER_AGENT), TuplesKt.m100to("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8"), TuplesKt.m100to(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0.5"), TuplesKt.m100to(HttpHeaders.DNT, "1"), TuplesKt.m100to("Connection", "keep-alive"), TuplesKt.m100to("Upgrade-Insecure-Requests", "1"), TuplesKt.m100to(HttpHeaders.SEC_FETCH_DEST, "iframe"), TuplesKt.m100to(HttpHeaders.SEC_FETCH_MODE, "navigate"), TuplesKt.m100to(HttpHeaders.SEC_FETCH_SITE, "cross-site"), TuplesKt.m100to(HttpHeaders.REFERER, "https://animekisa.in/"), TuplesKt.m100to(HttpHeaders.PRAGMA, "no-cache"), TuplesKt.m100to("Cache-Control", "no-cache"));
    private final String key = "LCbu3iYC7ln24K7P";

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

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.lagradost.cloudstream3.extractors.Mcloud r23, java.lang.String r24, java.lang.String r25, kotlin.coroutines.Continuation r26) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.extractors.Mcloud.getUrl$suspendImpl(com.lagradost.cloudstream3.extractors.Mcloud, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
