package com.lagradost.cloudstream3.extractors;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Mcloud.kt */
@Metadata(m108d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0002\u0000\u0003\b\u008a\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, m107d2 = {"com/lagradost/cloudstream3/extractors/Mcloud$getUrl$DataMcloud", "", "media", "com/lagradost/cloudstream3/extractors/Mcloud$getUrl$MediaMcloud", "(Lcom/lagradost/cloudstream3/extractors/Mcloud$getUrl$MediaMcloud;)V", "getMedia", "()Lcom/lagradost/cloudstream3/extractors/Mcloud$getUrl$MediaMcloud;", "Lcom/lagradost/cloudstream3/extractors/Mcloud$getUrl$MediaMcloud;", "component1", "copy", "(Lcom/lagradost/cloudstream3/extractors/Mcloud$getUrl$MediaMcloud;)Lcom/lagradost/cloudstream3/extractors/Mcloud$getUrl$DataMcloud;", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class Mcloud$getUrl$DataMcloud {
    private final Mcloud$getUrl$MediaMcloud media;

    public static /* synthetic */ Mcloud$getUrl$DataMcloud copy$default(Mcloud$getUrl$DataMcloud mcloud$getUrl$DataMcloud, Mcloud$getUrl$MediaMcloud mcloud$getUrl$MediaMcloud, int i, Object obj) {
        if ((i & 1) != 0) {
            mcloud$getUrl$MediaMcloud = mcloud$getUrl$DataMcloud.media;
        }
        return mcloud$getUrl$DataMcloud.copy(mcloud$getUrl$MediaMcloud);
    }

    public final Mcloud$getUrl$MediaMcloud component1() {
        return this.media;
    }

    public final Mcloud$getUrl$DataMcloud copy(@JsonProperty("media") Mcloud$getUrl$MediaMcloud mcloud$getUrl$MediaMcloud) {
        return new Mcloud$getUrl$DataMcloud(mcloud$getUrl$MediaMcloud);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Mcloud$getUrl$DataMcloud) && Intrinsics.areEqual(this.media, ((Mcloud$getUrl$DataMcloud) obj).media);
    }

    public int hashCode() {
        Mcloud$getUrl$MediaMcloud mcloud$getUrl$MediaMcloud = this.media;
        if (mcloud$getUrl$MediaMcloud == null) {
            return 0;
        }
        return mcloud$getUrl$MediaMcloud.hashCode();
    }

    public String toString() {
        return "DataMcloud(media=" + this.media + ')';
    }

    public Mcloud$getUrl$DataMcloud(@JsonProperty("media") Mcloud$getUrl$MediaMcloud mcloud$getUrl$MediaMcloud) {
        this.media = mcloud$getUrl$MediaMcloud;
    }

    public /* synthetic */ Mcloud$getUrl$DataMcloud(Mcloud$getUrl$MediaMcloud mcloud$getUrl$MediaMcloud, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Mcloud$getUrl$MediaMcloud(null, 1, null) : mcloud$getUrl$MediaMcloud);
    }

    public final Mcloud$getUrl$MediaMcloud getMedia() {
        return this.media;
    }
}
