package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TrailersTwoProvider.kt */
@Metadata(m108d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b'\b\u0086\b\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0001\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u0010\b\u0001\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r\u0012\u0010\b\u0001\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r\u0012\u0010\b\u0001\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rHÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u00102\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\u0011\u00103\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rHÆ\u0003J¶\u0001\u00104\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0010\b\u0003\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0010\b\u0003\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r2\u0010\b\u0003\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r2\u0010\b\u0003\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u00020\u00132\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0003HÖ\u0001J\t\u00109\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b'\u0010\u001f¨\u0006:"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/TrailersSubtitleFile;", "", "SubtitleID", "", "ItemID", "ContentText", "", "ContentHash", "LanguageCode", "MetaInfo", "Lcom/lagradost/cloudstream3/movieproviders/MetaInfo;", "EntryDate", "ItemSubtitleAdaptations", "", "Lcom/lagradost/cloudstream3/movieproviders/ItemSubtitleAdaptations;", "ReleaseNames", "SubFileNames", "Framerates", "IsRelevant", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/movieproviders/MetaInfo;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;)V", "getContentHash", "()Ljava/lang/String;", "getContentText", "getEntryDate", "getFramerates", "()Ljava/util/List;", "getIsRelevant", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getItemID", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getItemSubtitleAdaptations", "getLanguageCode", "getMetaInfo", "()Lcom/lagradost/cloudstream3/movieproviders/MetaInfo;", "getReleaseNames", "getSubFileNames", "getSubtitleID", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/movieproviders/MetaInfo;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;)Lcom/lagradost/cloudstream3/movieproviders/TrailersSubtitleFile;", "equals", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class TrailersSubtitleFile {
    private final String ContentHash;
    private final String ContentText;
    private final String EntryDate;
    private final List<Integer> Framerates;
    private final Boolean IsRelevant;
    private final Integer ItemID;
    private final List<ItemSubtitleAdaptations> ItemSubtitleAdaptations;
    private final String LanguageCode;
    private final MetaInfo MetaInfo;
    private final List<String> ReleaseNames;
    private final List<String> SubFileNames;
    private final Integer SubtitleID;

    public final Integer component1() {
        return this.SubtitleID;
    }

    public final List<String> component10() {
        return this.SubFileNames;
    }

    public final List<Integer> component11() {
        return this.Framerates;
    }

    public final Boolean component12() {
        return this.IsRelevant;
    }

    public final Integer component2() {
        return this.ItemID;
    }

    public final String component3() {
        return this.ContentText;
    }

    public final String component4() {
        return this.ContentHash;
    }

    public final String component5() {
        return this.LanguageCode;
    }

    public final MetaInfo component6() {
        return this.MetaInfo;
    }

    public final String component7() {
        return this.EntryDate;
    }

    public final List<ItemSubtitleAdaptations> component8() {
        return this.ItemSubtitleAdaptations;
    }

    public final List<String> component9() {
        return this.ReleaseNames;
    }

    public final TrailersSubtitleFile copy(@JsonProperty("SubtitleID") Integer num, @JsonProperty("ItemID") Integer num2, @JsonProperty("ContentText") String str, @JsonProperty("ContentHash") String str2, @JsonProperty("LanguageCode") String str3, @JsonProperty("MetaInfo") MetaInfo metaInfo, @JsonProperty("EntryDate") String str4, @JsonProperty("ItemSubtitleAdaptations") List<ItemSubtitleAdaptations> list, @JsonProperty("ReleaseNames") List<String> list2, @JsonProperty("SubFileNames") List<String> list3, @JsonProperty("Framerates") List<Integer> list4, @JsonProperty("IsRelevant") Boolean bool) {
        return new TrailersSubtitleFile(num, num2, str, str2, str3, metaInfo, str4, list, list2, list3, list4, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TrailersSubtitleFile) {
            TrailersSubtitleFile trailersSubtitleFile = (TrailersSubtitleFile) obj;
            return Intrinsics.areEqual(this.SubtitleID, trailersSubtitleFile.SubtitleID) && Intrinsics.areEqual(this.ItemID, trailersSubtitleFile.ItemID) && Intrinsics.areEqual(this.ContentText, trailersSubtitleFile.ContentText) && Intrinsics.areEqual(this.ContentHash, trailersSubtitleFile.ContentHash) && Intrinsics.areEqual(this.LanguageCode, trailersSubtitleFile.LanguageCode) && Intrinsics.areEqual(this.MetaInfo, trailersSubtitleFile.MetaInfo) && Intrinsics.areEqual(this.EntryDate, trailersSubtitleFile.EntryDate) && Intrinsics.areEqual(this.ItemSubtitleAdaptations, trailersSubtitleFile.ItemSubtitleAdaptations) && Intrinsics.areEqual(this.ReleaseNames, trailersSubtitleFile.ReleaseNames) && Intrinsics.areEqual(this.SubFileNames, trailersSubtitleFile.SubFileNames) && Intrinsics.areEqual(this.Framerates, trailersSubtitleFile.Framerates) && Intrinsics.areEqual(this.IsRelevant, trailersSubtitleFile.IsRelevant);
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.SubtitleID;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.ItemID;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.ContentText;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.ContentHash;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.LanguageCode;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        MetaInfo metaInfo = this.MetaInfo;
        int hashCode6 = (hashCode5 + (metaInfo == null ? 0 : metaInfo.hashCode())) * 31;
        String str4 = this.EntryDate;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<ItemSubtitleAdaptations> list = this.ItemSubtitleAdaptations;
        int hashCode8 = (hashCode7 + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.ReleaseNames;
        int hashCode9 = (hashCode8 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<String> list3 = this.SubFileNames;
        int hashCode10 = (hashCode9 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<Integer> list4 = this.Framerates;
        int hashCode11 = (hashCode10 + (list4 == null ? 0 : list4.hashCode())) * 31;
        Boolean bool = this.IsRelevant;
        return hashCode11 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "TrailersSubtitleFile(SubtitleID=" + this.SubtitleID + ", ItemID=" + this.ItemID + ", ContentText=" + this.ContentText + ", ContentHash=" + this.ContentHash + ", LanguageCode=" + this.LanguageCode + ", MetaInfo=" + this.MetaInfo + ", EntryDate=" + this.EntryDate + ", ItemSubtitleAdaptations=" + this.ItemSubtitleAdaptations + ", ReleaseNames=" + this.ReleaseNames + ", SubFileNames=" + this.SubFileNames + ", Framerates=" + this.Framerates + ", IsRelevant=" + this.IsRelevant + ')';
    }

    public TrailersSubtitleFile(@JsonProperty("SubtitleID") Integer num, @JsonProperty("ItemID") Integer num2, @JsonProperty("ContentText") String str, @JsonProperty("ContentHash") String str2, @JsonProperty("LanguageCode") String str3, @JsonProperty("MetaInfo") MetaInfo metaInfo, @JsonProperty("EntryDate") String str4, @JsonProperty("ItemSubtitleAdaptations") List<ItemSubtitleAdaptations> list, @JsonProperty("ReleaseNames") List<String> list2, @JsonProperty("SubFileNames") List<String> list3, @JsonProperty("Framerates") List<Integer> list4, @JsonProperty("IsRelevant") Boolean bool) {
        this.SubtitleID = num;
        this.ItemID = num2;
        this.ContentText = str;
        this.ContentHash = str2;
        this.LanguageCode = str3;
        this.MetaInfo = metaInfo;
        this.EntryDate = str4;
        this.ItemSubtitleAdaptations = list;
        this.ReleaseNames = list2;
        this.SubFileNames = list3;
        this.Framerates = list4;
        this.IsRelevant = bool;
    }

    public final Integer getSubtitleID() {
        return this.SubtitleID;
    }

    public final Integer getItemID() {
        return this.ItemID;
    }

    public final String getContentText() {
        return this.ContentText;
    }

    public final String getContentHash() {
        return this.ContentHash;
    }

    public final String getLanguageCode() {
        return this.LanguageCode;
    }

    public final MetaInfo getMetaInfo() {
        return this.MetaInfo;
    }

    public final String getEntryDate() {
        return this.EntryDate;
    }

    public final List<ItemSubtitleAdaptations> getItemSubtitleAdaptations() {
        return this.ItemSubtitleAdaptations;
    }

    public final List<String> getReleaseNames() {
        return this.ReleaseNames;
    }

    public final List<String> getSubFileNames() {
        return this.SubFileNames;
    }

    public final List<Integer> getFramerates() {
        return this.Framerates;
    }

    public final Boolean getIsRelevant() {
        return this.IsRelevant;
    }
}
