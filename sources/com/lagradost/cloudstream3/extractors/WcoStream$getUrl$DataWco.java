package com.lagradost.cloudstream3.extractors;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WcoStream.kt */
@Metadata(m108d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0002\u0000\u0003\b\u008a\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, m107d2 = {"com/lagradost/cloudstream3/extractors/WcoStream$getUrl$DataWco", "", "media", "com/lagradost/cloudstream3/extractors/WcoStream$getUrl$MediaWco", "(Lcom/lagradost/cloudstream3/extractors/WcoStream$getUrl$MediaWco;)V", "getMedia", "()Lcom/lagradost/cloudstream3/extractors/WcoStream$getUrl$MediaWco;", "Lcom/lagradost/cloudstream3/extractors/WcoStream$getUrl$MediaWco;", "component1", "copy", "(Lcom/lagradost/cloudstream3/extractors/WcoStream$getUrl$MediaWco;)Lcom/lagradost/cloudstream3/extractors/WcoStream$getUrl$DataWco;", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class WcoStream$getUrl$DataWco {
    private final WcoStream$getUrl$MediaWco media;

    public static /* synthetic */ WcoStream$getUrl$DataWco copy$default(WcoStream$getUrl$DataWco wcoStream$getUrl$DataWco, WcoStream$getUrl$MediaWco wcoStream$getUrl$MediaWco, int i, Object obj) {
        if ((i & 1) != 0) {
            wcoStream$getUrl$MediaWco = wcoStream$getUrl$DataWco.media;
        }
        return wcoStream$getUrl$DataWco.copy(wcoStream$getUrl$MediaWco);
    }

    public final WcoStream$getUrl$MediaWco component1() {
        return this.media;
    }

    public final WcoStream$getUrl$DataWco copy(@JsonProperty("media") WcoStream$getUrl$MediaWco wcoStream$getUrl$MediaWco) {
        return new WcoStream$getUrl$DataWco(wcoStream$getUrl$MediaWco);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WcoStream$getUrl$DataWco) && Intrinsics.areEqual(this.media, ((WcoStream$getUrl$DataWco) obj).media);
    }

    public int hashCode() {
        WcoStream$getUrl$MediaWco wcoStream$getUrl$MediaWco = this.media;
        if (wcoStream$getUrl$MediaWco == null) {
            return 0;
        }
        return wcoStream$getUrl$MediaWco.hashCode();
    }

    public String toString() {
        return "DataWco(media=" + this.media + ')';
    }

    public WcoStream$getUrl$DataWco(@JsonProperty("media") WcoStream$getUrl$MediaWco wcoStream$getUrl$MediaWco) {
        this.media = wcoStream$getUrl$MediaWco;
    }

    public /* synthetic */ WcoStream$getUrl$DataWco(WcoStream$getUrl$MediaWco wcoStream$getUrl$MediaWco, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new WcoStream$getUrl$MediaWco(null, 1, null) : wcoStream$getUrl$MediaWco);
    }

    public final WcoStream$getUrl$MediaWco getMedia() {
        return this.media;
    }
}
