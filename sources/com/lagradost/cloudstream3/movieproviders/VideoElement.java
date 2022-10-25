package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StreamingcommunityProvider.kt */
@Metadata(m108d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\u000e\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/VideoElement;", "", "id", "", "slug", "", "images", "", "Lcom/lagradost/cloudstream3/movieproviders/Image;", "(JLjava/lang/String;Ljava/util/List;)V", "getId", "()J", "getImages", "()Ljava/util/List;", "getSlug", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class VideoElement {

    /* renamed from: id */
    private final long f9989id;
    private final List<Image> images;
    private final String slug;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VideoElement copy$default(VideoElement videoElement, long j, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j = videoElement.f9989id;
        }
        if ((i & 2) != 0) {
            str = videoElement.slug;
        }
        if ((i & 4) != 0) {
            list = videoElement.images;
        }
        return videoElement.copy(j, str, list);
    }

    public final long component1() {
        return this.f9989id;
    }

    public final String component2() {
        return this.slug;
    }

    public final List<Image> component3() {
        return this.images;
    }

    public final VideoElement copy(@JsonProperty("id") long j, @JsonProperty("slug") String slug, @JsonProperty("images") List<Image> images) {
        Intrinsics.checkNotNullParameter(slug, "slug");
        Intrinsics.checkNotNullParameter(images, "images");
        return new VideoElement(j, slug, images);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VideoElement) {
            VideoElement videoElement = (VideoElement) obj;
            return this.f9989id == videoElement.f9989id && Intrinsics.areEqual(this.slug, videoElement.slug) && Intrinsics.areEqual(this.images, videoElement.images);
        }
        return false;
    }

    public int hashCode() {
        return (((C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f9989id) * 31) + this.slug.hashCode()) * 31) + this.images.hashCode();
    }

    public String toString() {
        return "VideoElement(id=" + this.f9989id + ", slug=" + this.slug + ", images=" + this.images + ')';
    }

    public VideoElement(@JsonProperty("id") long j, @JsonProperty("slug") String slug, @JsonProperty("images") List<Image> images) {
        Intrinsics.checkNotNullParameter(slug, "slug");
        Intrinsics.checkNotNullParameter(images, "images");
        this.f9989id = j;
        this.slug = slug;
        this.images = images;
    }

    public final long getId() {
        return this.f9989id;
    }

    public final String getSlug() {
        return this.slug;
    }

    public final List<Image> getImages() {
        return this.images;
    }
}
