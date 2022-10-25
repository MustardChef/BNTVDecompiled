package com.lagradost.cloudstream3.extractors;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/DataOptionsJson;", "", "flashvars", "Lcom/lagradost/cloudstream3/extractors/Flashvars;", "(Lcom/lagradost/cloudstream3/extractors/Flashvars;)V", "getFlashvars", "()Lcom/lagradost/cloudstream3/extractors/Flashvars;", "setFlashvars", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.extractors.DataOptionsJson */
/* loaded from: classes3.dex */
public final class OkRuExtractor {
    private Flashvars flashvars;

    public OkRuExtractor() {
        this(null, 1, null);
    }

    public static /* synthetic */ OkRuExtractor copy$default(OkRuExtractor okRuExtractor, Flashvars flashvars, int i, Object obj) {
        if ((i & 1) != 0) {
            flashvars = okRuExtractor.flashvars;
        }
        return okRuExtractor.copy(flashvars);
    }

    public final Flashvars component1() {
        return this.flashvars;
    }

    public final OkRuExtractor copy(@JsonProperty("flashvars") Flashvars flashvars) {
        return new OkRuExtractor(flashvars);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OkRuExtractor) && Intrinsics.areEqual(this.flashvars, ((OkRuExtractor) obj).flashvars);
    }

    public int hashCode() {
        Flashvars flashvars = this.flashvars;
        if (flashvars == null) {
            return 0;
        }
        return flashvars.hashCode();
    }

    public String toString() {
        return "DataOptionsJson(flashvars=" + this.flashvars + ')';
    }

    public OkRuExtractor(@JsonProperty("flashvars") Flashvars flashvars) {
        this.flashvars = flashvars;
    }

    public /* synthetic */ OkRuExtractor(Flashvars flashvars, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Flashvars(null, null, 3, null) : flashvars);
    }

    public final Flashvars getFlashvars() {
        return this.flashvars;
    }

    public final void setFlashvars(Flashvars flashvars) {
        this.flashvars = flashvars;
    }
}
