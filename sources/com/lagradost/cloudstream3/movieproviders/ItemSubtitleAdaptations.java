package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TrailersTwoProvider.kt */
@Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\u001a\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000f¨\u0006!"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/ItemSubtitleAdaptations;", "", "ContentHash", "", "OffsetMs", "", "Framerate", "Views", "EntryDate", "Subtitle", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getContentHash", "()Ljava/lang/String;", "getEntryDate", "getFramerate", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOffsetMs", "getSubtitle", "getViews", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/lagradost/cloudstream3/movieproviders/ItemSubtitleAdaptations;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class ItemSubtitleAdaptations {
    private final String ContentHash;
    private final String EntryDate;
    private final Integer Framerate;
    private final Integer OffsetMs;
    private final String Subtitle;
    private final Integer Views;

    public static /* synthetic */ ItemSubtitleAdaptations copy$default(ItemSubtitleAdaptations itemSubtitleAdaptations, String str, Integer num, Integer num2, Integer num3, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = itemSubtitleAdaptations.ContentHash;
        }
        if ((i & 2) != 0) {
            num = itemSubtitleAdaptations.OffsetMs;
        }
        Integer num4 = num;
        if ((i & 4) != 0) {
            num2 = itemSubtitleAdaptations.Framerate;
        }
        Integer num5 = num2;
        if ((i & 8) != 0) {
            num3 = itemSubtitleAdaptations.Views;
        }
        Integer num6 = num3;
        if ((i & 16) != 0) {
            str2 = itemSubtitleAdaptations.EntryDate;
        }
        String str4 = str2;
        if ((i & 32) != 0) {
            str3 = itemSubtitleAdaptations.Subtitle;
        }
        return itemSubtitleAdaptations.copy(str, num4, num5, num6, str4, str3);
    }

    public final String component1() {
        return this.ContentHash;
    }

    public final Integer component2() {
        return this.OffsetMs;
    }

    public final Integer component3() {
        return this.Framerate;
    }

    public final Integer component4() {
        return this.Views;
    }

    public final String component5() {
        return this.EntryDate;
    }

    public final String component6() {
        return this.Subtitle;
    }

    public final ItemSubtitleAdaptations copy(@JsonProperty("ContentHash") String str, @JsonProperty("OffsetMs") Integer num, @JsonProperty("Framerate") Integer num2, @JsonProperty("Views") Integer num3, @JsonProperty("EntryDate") String str2, @JsonProperty("Subtitle") String str3) {
        return new ItemSubtitleAdaptations(str, num, num2, num3, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ItemSubtitleAdaptations) {
            ItemSubtitleAdaptations itemSubtitleAdaptations = (ItemSubtitleAdaptations) obj;
            return Intrinsics.areEqual(this.ContentHash, itemSubtitleAdaptations.ContentHash) && Intrinsics.areEqual(this.OffsetMs, itemSubtitleAdaptations.OffsetMs) && Intrinsics.areEqual(this.Framerate, itemSubtitleAdaptations.Framerate) && Intrinsics.areEqual(this.Views, itemSubtitleAdaptations.Views) && Intrinsics.areEqual(this.EntryDate, itemSubtitleAdaptations.EntryDate) && Intrinsics.areEqual(this.Subtitle, itemSubtitleAdaptations.Subtitle);
        }
        return false;
    }

    public int hashCode() {
        String str = this.ContentHash;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.OffsetMs;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.Framerate;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.Views;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str2 = this.EntryDate;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.Subtitle;
        return hashCode5 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ItemSubtitleAdaptations(ContentHash=" + this.ContentHash + ", OffsetMs=" + this.OffsetMs + ", Framerate=" + this.Framerate + ", Views=" + this.Views + ", EntryDate=" + this.EntryDate + ", Subtitle=" + this.Subtitle + ')';
    }

    public ItemSubtitleAdaptations(@JsonProperty("ContentHash") String str, @JsonProperty("OffsetMs") Integer num, @JsonProperty("Framerate") Integer num2, @JsonProperty("Views") Integer num3, @JsonProperty("EntryDate") String str2, @JsonProperty("Subtitle") String str3) {
        this.ContentHash = str;
        this.OffsetMs = num;
        this.Framerate = num2;
        this.Views = num3;
        this.EntryDate = str2;
        this.Subtitle = str3;
    }

    public final String getContentHash() {
        return this.ContentHash;
    }

    public final Integer getOffsetMs() {
        return this.OffsetMs;
    }

    public final Integer getFramerate() {
        return this.Framerate;
    }

    public final Integer getViews() {
        return this.Views;
    }

    public final String getEntryDate() {
        return this.EntryDate;
    }

    public final String getSubtitle() {
        return this.Subtitle;
    }
}
