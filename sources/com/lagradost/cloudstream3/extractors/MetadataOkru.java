package com.lagradost.cloudstream3.extractors;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OkRuExtractor.kt */
@Metadata(m108d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/MetadataOkru;", "", "videos", "Ljava/util/ArrayList;", "Lcom/lagradost/cloudstream3/extractors/Videos;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getVideos", "()Ljava/util/ArrayList;", "setVideos", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class MetadataOkru {
    private ArrayList<Videos> videos;

    public MetadataOkru() {
        this(null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MetadataOkru copy$default(MetadataOkru metadataOkru, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = metadataOkru.videos;
        }
        return metadataOkru.copy(arrayList);
    }

    public final ArrayList<Videos> component1() {
        return this.videos;
    }

    public final MetadataOkru copy(@JsonProperty("videos") ArrayList<Videos> videos) {
        Intrinsics.checkNotNullParameter(videos, "videos");
        return new MetadataOkru(videos);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MetadataOkru) && Intrinsics.areEqual(this.videos, ((MetadataOkru) obj).videos);
    }

    public int hashCode() {
        return this.videos.hashCode();
    }

    public String toString() {
        return "MetadataOkru(videos=" + this.videos + ')';
    }

    public MetadataOkru(@JsonProperty("videos") ArrayList<Videos> videos) {
        Intrinsics.checkNotNullParameter(videos, "videos");
        this.videos = videos;
    }

    public /* synthetic */ MetadataOkru(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList);
    }

    public final ArrayList<Videos> getVideos() {
        return this.videos;
    }

    public final void setVideos(ArrayList<Videos> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.videos = arrayList;
    }
}
