package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FilmanProvider.kt */
@Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/LinkElement;", "", "src", "", "(Ljava/lang/String;)V", "getSrc", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class LinkElement {
    private final String src;

    public static /* synthetic */ LinkElement copy$default(LinkElement linkElement, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = linkElement.src;
        }
        return linkElement.copy(str);
    }

    public final String component1() {
        return this.src;
    }

    public final LinkElement copy(@JsonProperty("src") String src) {
        Intrinsics.checkNotNullParameter(src, "src");
        return new LinkElement(src);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LinkElement) && Intrinsics.areEqual(this.src, ((LinkElement) obj).src);
    }

    public int hashCode() {
        return this.src.hashCode();
    }

    public String toString() {
        return "LinkElement(src=" + this.src + ')';
    }

    public LinkElement(@JsonProperty("src") String src) {
        Intrinsics.checkNotNullParameter(src, "src");
        this.src = src;
    }

    public final String getSrc() {
        return this.src;
    }
}
