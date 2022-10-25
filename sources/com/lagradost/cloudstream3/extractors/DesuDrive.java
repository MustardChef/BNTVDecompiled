package com.lagradost.cloudstream3.extractors;

import kotlin.Metadata;

/* compiled from: JWPlayer.kt */
@Metadata(m108d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/DesuDrive;", "Lcom/lagradost/cloudstream3/extractors/JWPlayer;", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "name", "getName", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class DesuDrive extends JWPlayer {
    private final String name = "DesuDrive";
    private final String mainUrl = "https://desustream.me/desudrive/";

    @Override // com.lagradost.cloudstream3.extractors.JWPlayer, com.lagradost.cloudstream3.utils.ExtractorApi
    public String getName() {
        return this.name;
    }

    @Override // com.lagradost.cloudstream3.extractors.JWPlayer, com.lagradost.cloudstream3.utils.ExtractorApi
    public String getMainUrl() {
        return this.mainUrl;
    }
}
