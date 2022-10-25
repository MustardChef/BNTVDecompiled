package com.lagradost.cloudstream3.extractors;

import kotlin.Metadata;

/* compiled from: Hxfile.kt */
@Metadata(m108d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/Neonime7n;", "Lcom/lagradost/cloudstream3/extractors/Hxfile;", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "name", "getName", "redirect", "", "getRedirect", "()Z", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class Neonime7n extends Hxfile {
    private final boolean redirect;
    private final String name = "Neonime7n";
    private final String mainUrl = "https://7njctn.neonime.watch";

    @Override // com.lagradost.cloudstream3.extractors.Hxfile, com.lagradost.cloudstream3.utils.ExtractorApi
    public String getName() {
        return this.name;
    }

    @Override // com.lagradost.cloudstream3.extractors.Hxfile, com.lagradost.cloudstream3.utils.ExtractorApi
    public String getMainUrl() {
        return this.mainUrl;
    }

    @Override // com.lagradost.cloudstream3.extractors.Hxfile
    public boolean getRedirect() {
        return this.redirect;
    }
}
