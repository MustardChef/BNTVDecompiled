package com.lagradost.cloudstream3.extractors;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XStreamCdn.kt */
@Metadata(m108d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/FeHD;", "Lcom/lagradost/cloudstream3/extractors/XStreamCdn;", "()V", "domainUrl", "", "getDomainUrl", "()Ljava/lang/String;", "setDomainUrl", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "name", "getName", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class FeHD extends XStreamCdn {
    private final String name = "FeHD";
    private final String mainUrl = "https://fembed-hd.com";
    private String domainUrl = "fembed-hd.com";

    @Override // com.lagradost.cloudstream3.extractors.XStreamCdn, com.lagradost.cloudstream3.utils.ExtractorApi
    public String getName() {
        return this.name;
    }

    @Override // com.lagradost.cloudstream3.extractors.XStreamCdn, com.lagradost.cloudstream3.utils.ExtractorApi
    public String getMainUrl() {
        return this.mainUrl;
    }

    @Override // com.lagradost.cloudstream3.extractors.XStreamCdn
    public String getDomainUrl() {
        return this.domainUrl;
    }

    @Override // com.lagradost.cloudstream3.extractors.XStreamCdn
    public void setDomainUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.domainUrl = str;
    }
}
