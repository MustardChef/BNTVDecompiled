package com.lagradost.cloudstream3.extractors;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WcoStream.kt */
@Metadata(m108d1 = {"\u0000#\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0018\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"com/lagradost/cloudstream3/extractors/WcoStream$getUrl$SourcesWco", "", "file", "", "(Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "component1", "copy", "(Ljava/lang/String;)Lcom/lagradost/cloudstream3/extractors/WcoStream$getUrl$SourcesWco;", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class WcoStream$getUrl$SourcesWco {
    private final String file;

    public static /* synthetic */ WcoStream$getUrl$SourcesWco copy$default(WcoStream$getUrl$SourcesWco wcoStream$getUrl$SourcesWco, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = wcoStream$getUrl$SourcesWco.file;
        }
        return wcoStream$getUrl$SourcesWco.copy(str);
    }

    public final String component1() {
        return this.file;
    }

    public final WcoStream$getUrl$SourcesWco copy(@JsonProperty("file") String file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return new WcoStream$getUrl$SourcesWco(file);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WcoStream$getUrl$SourcesWco) && Intrinsics.areEqual(this.file, ((WcoStream$getUrl$SourcesWco) obj).file);
    }

    public int hashCode() {
        return this.file.hashCode();
    }

    public String toString() {
        return "SourcesWco(file=" + this.file + ')';
    }

    public WcoStream$getUrl$SourcesWco(@JsonProperty("file") String file) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.file = file;
    }

    public final String getFile() {
        return this.file;
    }
}
