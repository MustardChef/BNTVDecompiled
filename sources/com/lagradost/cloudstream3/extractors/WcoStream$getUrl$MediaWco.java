package com.lagradost.cloudstream3.extractors;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WcoStream.kt */
@Metadata(m108d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0002\u0000\u0004\b\u008a\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J(\u0010\n\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, m107d2 = {"com/lagradost/cloudstream3/extractors/WcoStream$getUrl$MediaWco", "", "sources", "Ljava/util/ArrayList;", "com/lagradost/cloudstream3/extractors/WcoStream$getUrl$SourcesWco", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getSources", "()Ljava/util/ArrayList;", "component1", "copy", "(Ljava/util/ArrayList;)Lcom/lagradost/cloudstream3/extractors/WcoStream$getUrl$MediaWco;", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class WcoStream$getUrl$MediaWco {
    private final ArrayList<WcoStream$getUrl$SourcesWco> sources;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WcoStream$getUrl$MediaWco copy$default(WcoStream$getUrl$MediaWco wcoStream$getUrl$MediaWco, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = wcoStream$getUrl$MediaWco.sources;
        }
        return wcoStream$getUrl$MediaWco.copy(arrayList);
    }

    public final ArrayList<WcoStream$getUrl$SourcesWco> component1() {
        return this.sources;
    }

    public final WcoStream$getUrl$MediaWco copy(@JsonProperty("sources") ArrayList<WcoStream$getUrl$SourcesWco> sources) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        return new WcoStream$getUrl$MediaWco(sources);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WcoStream$getUrl$MediaWco) && Intrinsics.areEqual(this.sources, ((WcoStream$getUrl$MediaWco) obj).sources);
    }

    public int hashCode() {
        return this.sources.hashCode();
    }

    public String toString() {
        return "MediaWco(sources=" + this.sources + ')';
    }

    public WcoStream$getUrl$MediaWco(@JsonProperty("sources") ArrayList<WcoStream$getUrl$SourcesWco> sources) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        this.sources = sources;
    }

    public /* synthetic */ WcoStream$getUrl$MediaWco(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList);
    }

    public final ArrayList<WcoStream$getUrl$SourcesWco> getSources() {
        return this.sources;
    }
}
