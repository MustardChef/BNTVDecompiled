package com.lagradost.cloudstream3.p041ui;

import com.lagradost.cloudstream3.p041ui.player.SubtitleData;
import com.lagradost.cloudstream3.p041ui.result.ResultEpisode;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ControllerActivity.kt */
@Metadata(m108d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b¢\u0006\u0002\u0010\u0011J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bHÆ\u0003Jo\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bHÆ\u0001J\u0013\u0010&\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\tHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u001aR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013¨\u0006*"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/MetadataHolder;", "", "apiName", "", "isMovie", "", "title", "poster", "currentEpisodeIndex", "", "episodes", "", "Lcom/lagradost/cloudstream3/ui/result/ResultEpisode;", "currentLinks", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "currentSubtitles", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/util/List;)V", "getApiName", "()Ljava/lang/String;", "getCurrentEpisodeIndex", "()I", "getCurrentLinks", "()Ljava/util/List;", "getCurrentSubtitles", "getEpisodes", "()Z", "getPoster", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.MetadataHolder */
/* loaded from: classes.dex */
public final class MetadataHolder {
    private final String apiName;
    private final int currentEpisodeIndex;
    private final List<ExtractorLink> currentLinks;
    private final List<SubtitleData> currentSubtitles;
    private final List<ResultEpisode> episodes;
    private final boolean isMovie;
    private final String poster;
    private final String title;

    public final String component1() {
        return this.apiName;
    }

    public final boolean component2() {
        return this.isMovie;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.poster;
    }

    public final int component5() {
        return this.currentEpisodeIndex;
    }

    public final List<ResultEpisode> component6() {
        return this.episodes;
    }

    public final List<ExtractorLink> component7() {
        return this.currentLinks;
    }

    public final List<SubtitleData> component8() {
        return this.currentSubtitles;
    }

    public final MetadataHolder copy(String apiName, boolean z, String str, String str2, int i, List<ResultEpisode> episodes, List<? extends ExtractorLink> currentLinks, List<SubtitleData> currentSubtitles) {
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Intrinsics.checkNotNullParameter(episodes, "episodes");
        Intrinsics.checkNotNullParameter(currentLinks, "currentLinks");
        Intrinsics.checkNotNullParameter(currentSubtitles, "currentSubtitles");
        return new MetadataHolder(apiName, z, str, str2, i, episodes, currentLinks, currentSubtitles);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MetadataHolder) {
            MetadataHolder metadataHolder = (MetadataHolder) obj;
            return Intrinsics.areEqual(this.apiName, metadataHolder.apiName) && this.isMovie == metadataHolder.isMovie && Intrinsics.areEqual(this.title, metadataHolder.title) && Intrinsics.areEqual(this.poster, metadataHolder.poster) && this.currentEpisodeIndex == metadataHolder.currentEpisodeIndex && Intrinsics.areEqual(this.episodes, metadataHolder.episodes) && Intrinsics.areEqual(this.currentLinks, metadataHolder.currentLinks) && Intrinsics.areEqual(this.currentSubtitles, metadataHolder.currentSubtitles);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.apiName.hashCode() * 31;
        boolean z = this.isMovie;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        String str = this.title;
        int hashCode2 = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.poster;
        return ((((((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.currentEpisodeIndex) * 31) + this.episodes.hashCode()) * 31) + this.currentLinks.hashCode()) * 31) + this.currentSubtitles.hashCode();
    }

    public String toString() {
        return "MetadataHolder(apiName=" + this.apiName + ", isMovie=" + this.isMovie + ", title=" + this.title + ", poster=" + this.poster + ", currentEpisodeIndex=" + this.currentEpisodeIndex + ", episodes=" + this.episodes + ", currentLinks=" + this.currentLinks + ", currentSubtitles=" + this.currentSubtitles + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MetadataHolder(String apiName, boolean z, String str, String str2, int i, List<ResultEpisode> episodes, List<? extends ExtractorLink> currentLinks, List<SubtitleData> currentSubtitles) {
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Intrinsics.checkNotNullParameter(episodes, "episodes");
        Intrinsics.checkNotNullParameter(currentLinks, "currentLinks");
        Intrinsics.checkNotNullParameter(currentSubtitles, "currentSubtitles");
        this.apiName = apiName;
        this.isMovie = z;
        this.title = str;
        this.poster = str2;
        this.currentEpisodeIndex = i;
        this.episodes = episodes;
        this.currentLinks = currentLinks;
        this.currentSubtitles = currentSubtitles;
    }

    public final String getApiName() {
        return this.apiName;
    }

    public final boolean isMovie() {
        return this.isMovie;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getPoster() {
        return this.poster;
    }

    public final int getCurrentEpisodeIndex() {
        return this.currentEpisodeIndex;
    }

    public final List<ResultEpisode> getEpisodes() {
        return this.episodes;
    }

    public final List<ExtractorLink> getCurrentLinks() {
        return this.currentLinks;
    }

    public final List<SubtitleData> getCurrentSubtitles() {
        return this.currentSubtitles;
    }
}
