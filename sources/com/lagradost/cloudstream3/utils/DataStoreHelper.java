package com.lagradost.cloudstream3.utils;

import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.gson.Gson;
import com.lagradost.cloudstream3.AcraApplication;
import com.lagradost.cloudstream3.DubStatus;
import com.lagradost.cloudstream3.SearchQuality;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.p041ui.WatchType;
import com.lagradost.cloudstream3.utils.VideoDownloadHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DataStoreHelper.kt */
@Metadata(m108d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004ABCDB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\fJ\u0010\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\fH\u0002J\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\fJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0011J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\bJ\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0019J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u00182\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\bJ$\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\f2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\fJ\u0017\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\"J\u0006\u0010#\u001a\u00020\u0006J\u0015\u0010$\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010&J\u0017\u0010'\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010&J\u001d\u0010(\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010)\u001a\u00020\u0010¢\u0006\u0002\u0010*J\u0016\u0010+\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0004J\u0016\u0010-\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u0016JI\u0010/\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\b2\b\u00100\u001a\u0004\u0018\u00010\b2\b\u00101\u001a\u0004\u0018\u00010\b2\b\u00102\u001a\u0004\u0018\u00010\b2\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u00106J\u001d\u00107\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u00108\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u00109J\u001d\u0010:\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010.\u001a\u00020\b¢\u0006\u0002\u0010;J%\u0010<\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010=\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\u0014¢\u0006\u0002\u0010?J\n\u0010@\u001a\u00020!*\u00020!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/DataStoreHelper;", "", "()V", "currentAccount", "", "addSync", "", "id", "", "idPrefix", "url", "getAllResumeStateIds", "", "getAllResumeStateIdsOld", "getAllWatchStateIds", "getBookmarkedData", "Lcom/lagradost/cloudstream3/utils/DataStoreHelper$BookmarkedData;", "(Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/utils/DataStoreHelper$BookmarkedData;", "getCache", "cacheTime", "", "getDub", "Lcom/lagradost/cloudstream3/DubStatus;", "getLastWatched", "Lcom/lagradost/cloudstream3/utils/VideoDownloadHelper$ResumeWatching;", "(Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/utils/VideoDownloadHelper$ResumeWatching;", "getLastWatchedOld", "getResultSeason", "getResultWatchState", "Lcom/lagradost/cloudstream3/ui/WatchType;", "getSync", "idPrefixes", "getViewPos", "Lcom/lagradost/cloudstream3/utils/DataStoreHelper$PosDur;", "(Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/utils/DataStoreHelper$PosDur;", "migrateResumeWatching", "removeLastWatched", "parentId", "(Ljava/lang/Integer;)V", "removeLastWatchedOld", "setBookmarkedData", "data", "(Ljava/lang/Integer;Lcom/lagradost/cloudstream3/utils/DataStoreHelper$BookmarkedData;)V", "setCache", "response", "setDub", "status", "setLastWatched", "episodeId", "episode", "season", "isFromDownload", "", "updateTime", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Long;)V", "setResultSeason", "value", "(ILjava/lang/Integer;)V", "setResultWatchState", "(Ljava/lang/Integer;I)V", "setViewPos", "pos", "dur", "(Ljava/lang/Integer;JJ)V", "fixVisual", "BookmarkedData", "Cache", "PosDur", "ResumeWatchingResult", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class DataStoreHelper {
    public static final DataStoreHelper INSTANCE = new DataStoreHelper();
    private static String currentAccount = "0";

    /* compiled from: DataStoreHelper.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/DataStoreHelper$PosDur;", "", "position", "", TypedValues.TransitionType.S_DURATION, "(JJ)V", "getDuration", "()J", "getPosition", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class PosDur {
        private final long duration;
        private final long position;

        public static /* synthetic */ PosDur copy$default(PosDur posDur, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = posDur.position;
            }
            if ((i & 2) != 0) {
                j2 = posDur.duration;
            }
            return posDur.copy(j, j2);
        }

        public final long component1() {
            return this.position;
        }

        public final long component2() {
            return this.duration;
        }

        public final PosDur copy(@JsonProperty("position") long j, @JsonProperty("duration") long j2) {
            return new PosDur(j, j2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PosDur) {
                PosDur posDur = (PosDur) obj;
                return this.position == posDur.position && this.duration == posDur.duration;
            }
            return false;
        }

        public int hashCode() {
            return (C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.position) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.duration);
        }

        public String toString() {
            return "PosDur(position=" + this.position + ", duration=" + this.duration + ')';
        }

        public PosDur(@JsonProperty("position") long j, @JsonProperty("duration") long j2) {
            this.position = j;
            this.duration = j2;
        }

        public final long getPosition() {
            return this.position;
        }

        public final long getDuration() {
            return this.duration;
        }
    }

    private DataStoreHelper() {
    }

    public final PosDur fixVisual(PosDur posDur) {
        Intrinsics.checkNotNullParameter(posDur, "<this>");
        if (posDur.getDuration() <= 0) {
            return new PosDur(0L, posDur.getDuration());
        }
        long j = 100;
        long position = (posDur.getPosition() * j) / posDur.getDuration();
        if (position <= 1) {
            return new PosDur(0L, posDur.getDuration());
        }
        if (position <= 5) {
            return new PosDur((5 * posDur.getDuration()) / j, posDur.getDuration());
        }
        return position >= 95 ? new PosDur(posDur.getDuration(), posDur.getDuration()) : posDur;
    }

    /* compiled from: DataStoreHelper.kt */
    @Metadata(m108d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b+\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\b\u0012\b\b\u0001\u0010\n\u001a\u00020\b\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0016\b\u0003\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u00101\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0017\u00102\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\bHÆ\u0003J\t\u00106\u001a\u00020\bHÆ\u0003J\t\u00107\u001a\u00020\bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0094\u0001\u0010;\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\b2\b\b\u0003\u0010\n\u001a\u00020\b2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0016\b\u0003\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u0010<J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@HÖ\u0003J\t\u0010A\u001a\u00020\u0003HÖ\u0001J\t\u0010B\u001a\u00020\bHÖ\u0001R\u0014\u0010\n\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010%R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0014\u0010\t\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0015R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b/\u0010\u0019¨\u0006C"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/DataStoreHelper$BookmarkedData;", "Lcom/lagradost/cloudstream3/SearchResponse;", "id", "", "bookmarkedTime", "", "latestUpdatedTime", "name", "", "url", "apiName", "type", "Lcom/lagradost/cloudstream3/TvType;", "posterUrl", "year", "quality", "Lcom/lagradost/cloudstream3/SearchQuality;", "posterHeaders", "", "(Ljava/lang/Integer;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/String;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/SearchQuality;Ljava/util/Map;)V", "getApiName", "()Ljava/lang/String;", "getBookmarkedTime", "()J", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLatestUpdatedTime", "getName", "getPosterHeaders", "()Ljava/util/Map;", "setPosterHeaders", "(Ljava/util/Map;)V", "getPosterUrl", "setPosterUrl", "(Ljava/lang/String;)V", "getQuality", "()Lcom/lagradost/cloudstream3/SearchQuality;", "setQuality", "(Lcom/lagradost/cloudstream3/SearchQuality;)V", "getType", "()Lcom/lagradost/cloudstream3/TvType;", "setType", "(Lcom/lagradost/cloudstream3/TvType;)V", "getUrl", "getYear", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/String;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/SearchQuality;Ljava/util/Map;)Lcom/lagradost/cloudstream3/utils/DataStoreHelper$BookmarkedData;", "equals", "", "other", "", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class BookmarkedData implements SearchResponse {
        private final String apiName;
        private final long bookmarkedTime;

        /* renamed from: id */
        private Integer f10024id;
        private final long latestUpdatedTime;
        private final String name;
        private Map<String, String> posterHeaders;
        private String posterUrl;
        private SearchQuality quality;
        private TvType type;
        private final String url;
        private final Integer year;

        public final Integer component1() {
            return getId();
        }

        public final SearchQuality component10() {
            return getQuality();
        }

        public final Map<String, String> component11() {
            return getPosterHeaders();
        }

        public final long component2() {
            return this.bookmarkedTime;
        }

        public final long component3() {
            return this.latestUpdatedTime;
        }

        public final String component4() {
            return getName();
        }

        public final String component5() {
            return getUrl();
        }

        public final String component6() {
            return getApiName();
        }

        public final TvType component7() {
            return getType();
        }

        public final String component8() {
            return getPosterUrl();
        }

        public final Integer component9() {
            return this.year;
        }

        public final BookmarkedData copy(@JsonProperty("id") Integer num, @JsonProperty("bookmarkedTime") long j, @JsonProperty("latestUpdatedTime") long j2, @JsonProperty("name") String name, @JsonProperty("url") String url, @JsonProperty("apiName") String apiName, @JsonProperty("type") TvType tvType, @JsonProperty("posterUrl") String str, @JsonProperty("year") Integer num2, @JsonProperty("quality") SearchQuality searchQuality, @JsonProperty("posterHeaders") Map<String, String> map) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(apiName, "apiName");
            return new BookmarkedData(num, j, j2, name, url, apiName, tvType, str, num2, searchQuality, map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BookmarkedData) {
                BookmarkedData bookmarkedData = (BookmarkedData) obj;
                return Intrinsics.areEqual(getId(), bookmarkedData.getId()) && this.bookmarkedTime == bookmarkedData.bookmarkedTime && this.latestUpdatedTime == bookmarkedData.latestUpdatedTime && Intrinsics.areEqual(getName(), bookmarkedData.getName()) && Intrinsics.areEqual(getUrl(), bookmarkedData.getUrl()) && Intrinsics.areEqual(getApiName(), bookmarkedData.getApiName()) && getType() == bookmarkedData.getType() && Intrinsics.areEqual(getPosterUrl(), bookmarkedData.getPosterUrl()) && Intrinsics.areEqual(this.year, bookmarkedData.year) && getQuality() == bookmarkedData.getQuality() && Intrinsics.areEqual(getPosterHeaders(), bookmarkedData.getPosterHeaders());
            }
            return false;
        }

        public int hashCode() {
            int hashCode = (((((((((((((((getId() == null ? 0 : getId().hashCode()) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.bookmarkedTime)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.latestUpdatedTime)) * 31) + getName().hashCode()) * 31) + getUrl().hashCode()) * 31) + getApiName().hashCode()) * 31) + (getType() == null ? 0 : getType().hashCode())) * 31) + (getPosterUrl() == null ? 0 : getPosterUrl().hashCode())) * 31;
            Integer num = this.year;
            return ((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + (getQuality() == null ? 0 : getQuality().hashCode())) * 31) + (getPosterHeaders() != null ? getPosterHeaders().hashCode() : 0);
        }

        public String toString() {
            return "BookmarkedData(id=" + getId() + ", bookmarkedTime=" + this.bookmarkedTime + ", latestUpdatedTime=" + this.latestUpdatedTime + ", name=" + getName() + ", url=" + getUrl() + ", apiName=" + getApiName() + ", type=" + getType() + ", posterUrl=" + getPosterUrl() + ", year=" + this.year + ", quality=" + getQuality() + ", posterHeaders=" + getPosterHeaders() + ')';
        }

        public BookmarkedData(@JsonProperty("id") Integer num, @JsonProperty("bookmarkedTime") long j, @JsonProperty("latestUpdatedTime") long j2, @JsonProperty("name") String name, @JsonProperty("url") String url, @JsonProperty("apiName") String apiName, @JsonProperty("type") TvType tvType, @JsonProperty("posterUrl") String str, @JsonProperty("year") Integer num2, @JsonProperty("quality") SearchQuality searchQuality, @JsonProperty("posterHeaders") Map<String, String> map) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(apiName, "apiName");
            this.f10024id = num;
            this.bookmarkedTime = j;
            this.latestUpdatedTime = j2;
            this.name = name;
            this.url = url;
            this.apiName = apiName;
            this.type = tvType;
            this.posterUrl = str;
            this.year = num2;
            this.quality = searchQuality;
            this.posterHeaders = map;
        }

        public /* synthetic */ BookmarkedData(Integer num, long j, long j2, String str, String str2, String str3, TvType tvType, String str4, Integer num2, SearchQuality searchQuality, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(num, j, j2, str, str2, str3, (i & 64) != 0 ? null : tvType, str4, num2, (i & 512) != 0 ? null : searchQuality, (i & 1024) != 0 ? null : map);
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public Integer getId() {
            return this.f10024id;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public void setId(Integer num) {
            this.f10024id = num;
        }

        public final long getBookmarkedTime() {
            return this.bookmarkedTime;
        }

        public final long getLatestUpdatedTime() {
            return this.latestUpdatedTime;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public String getName() {
            return this.name;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public String getUrl() {
            return this.url;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public String getApiName() {
            return this.apiName;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public TvType getType() {
            return this.type;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public void setType(TvType tvType) {
            this.type = tvType;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public String getPosterUrl() {
            return this.posterUrl;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public void setPosterUrl(String str) {
            this.posterUrl = str;
        }

        public final Integer getYear() {
            return this.year;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public SearchQuality getQuality() {
            return this.quality;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public void setQuality(SearchQuality searchQuality) {
            this.quality = searchQuality;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public Map<String, String> getPosterHeaders() {
            return this.posterHeaders;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public void setPosterHeaders(Map<String, String> map) {
            this.posterHeaders = map;
        }
    }

    /* compiled from: DataStoreHelper.kt */
    @Metadata(m108d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b0\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0016\b\u0003\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001aJ\t\u00107\u001a\u00020\u0011HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0017\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010@\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010A\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001aJ®\u0001\u0010B\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\b\u0003\u0010\u0010\u001a\u00020\u00112\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0016\b\u0003\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015HÆ\u0001¢\u0006\u0002\u0010CJ\u0013\u0010D\u001a\u00020\u00112\b\u0010E\u001a\u0004\u0018\u00010FHÖ\u0003J\t\u0010G\u001a\u00020\fHÖ\u0001J\t\u0010H\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001a\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0015\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b!\u0010\u001aR(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0018\"\u0004\b'\u0010(R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b-\u0010\u001aR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b3\u00104¨\u0006I"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/DataStoreHelper$ResumeWatchingResult;", "Lcom/lagradost/cloudstream3/SearchResponse;", "name", "", "url", "apiName", "type", "Lcom/lagradost/cloudstream3/TvType;", "posterUrl", "watchPos", "Lcom/lagradost/cloudstream3/utils/DataStoreHelper$PosDur;", "id", "", "parentId", "episode", "season", "isFromDownload", "", "quality", "Lcom/lagradost/cloudstream3/SearchQuality;", "posterHeaders", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/String;Lcom/lagradost/cloudstream3/utils/DataStoreHelper$PosDur;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLcom/lagradost/cloudstream3/SearchQuality;Ljava/util/Map;)V", "getApiName", "()Ljava/lang/String;", "getEpisode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "setId", "(Ljava/lang/Integer;)V", "()Z", "getName", "getParentId", "getPosterHeaders", "()Ljava/util/Map;", "setPosterHeaders", "(Ljava/util/Map;)V", "getPosterUrl", "setPosterUrl", "(Ljava/lang/String;)V", "getQuality", "()Lcom/lagradost/cloudstream3/SearchQuality;", "setQuality", "(Lcom/lagradost/cloudstream3/SearchQuality;)V", "getSeason", "getType", "()Lcom/lagradost/cloudstream3/TvType;", "setType", "(Lcom/lagradost/cloudstream3/TvType;)V", "getUrl", "getWatchPos", "()Lcom/lagradost/cloudstream3/utils/DataStoreHelper$PosDur;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/String;Lcom/lagradost/cloudstream3/utils/DataStoreHelper$PosDur;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLcom/lagradost/cloudstream3/SearchQuality;Ljava/util/Map;)Lcom/lagradost/cloudstream3/utils/DataStoreHelper$ResumeWatchingResult;", "equals", "other", "", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class ResumeWatchingResult implements SearchResponse {
        private final String apiName;
        private final Integer episode;

        /* renamed from: id */
        private Integer f10025id;
        private final boolean isFromDownload;
        private final String name;
        private final Integer parentId;
        private Map<String, String> posterHeaders;
        private String posterUrl;
        private SearchQuality quality;
        private final Integer season;
        private TvType type;
        private final String url;
        private final PosDur watchPos;

        public final String component1() {
            return getName();
        }

        public final Integer component10() {
            return this.season;
        }

        public final boolean component11() {
            return this.isFromDownload;
        }

        public final SearchQuality component12() {
            return getQuality();
        }

        public final Map<String, String> component13() {
            return getPosterHeaders();
        }

        public final String component2() {
            return getUrl();
        }

        public final String component3() {
            return getApiName();
        }

        public final TvType component4() {
            return getType();
        }

        public final String component5() {
            return getPosterUrl();
        }

        public final PosDur component6() {
            return this.watchPos;
        }

        public final Integer component7() {
            return getId();
        }

        public final Integer component8() {
            return this.parentId;
        }

        public final Integer component9() {
            return this.episode;
        }

        public final ResumeWatchingResult copy(@JsonProperty("name") String name, @JsonProperty("url") String url, @JsonProperty("apiName") String apiName, @JsonProperty("type") TvType tvType, @JsonProperty("posterUrl") String str, @JsonProperty("watchPos") PosDur posDur, @JsonProperty("id") Integer num, @JsonProperty("parentId") Integer num2, @JsonProperty("episode") Integer num3, @JsonProperty("season") Integer num4, @JsonProperty("isFromDownload") boolean z, @JsonProperty("quality") SearchQuality searchQuality, @JsonProperty("posterHeaders") Map<String, String> map) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(apiName, "apiName");
            return new ResumeWatchingResult(name, url, apiName, tvType, str, posDur, num, num2, num3, num4, z, searchQuality, map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ResumeWatchingResult) {
                ResumeWatchingResult resumeWatchingResult = (ResumeWatchingResult) obj;
                return Intrinsics.areEqual(getName(), resumeWatchingResult.getName()) && Intrinsics.areEqual(getUrl(), resumeWatchingResult.getUrl()) && Intrinsics.areEqual(getApiName(), resumeWatchingResult.getApiName()) && getType() == resumeWatchingResult.getType() && Intrinsics.areEqual(getPosterUrl(), resumeWatchingResult.getPosterUrl()) && Intrinsics.areEqual(this.watchPos, resumeWatchingResult.watchPos) && Intrinsics.areEqual(getId(), resumeWatchingResult.getId()) && Intrinsics.areEqual(this.parentId, resumeWatchingResult.parentId) && Intrinsics.areEqual(this.episode, resumeWatchingResult.episode) && Intrinsics.areEqual(this.season, resumeWatchingResult.season) && this.isFromDownload == resumeWatchingResult.isFromDownload && getQuality() == resumeWatchingResult.getQuality() && Intrinsics.areEqual(getPosterHeaders(), resumeWatchingResult.getPosterHeaders());
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((((((getName().hashCode() * 31) + getUrl().hashCode()) * 31) + getApiName().hashCode()) * 31) + (getType() == null ? 0 : getType().hashCode())) * 31) + (getPosterUrl() == null ? 0 : getPosterUrl().hashCode())) * 31;
            PosDur posDur = this.watchPos;
            int hashCode2 = (((hashCode + (posDur == null ? 0 : posDur.hashCode())) * 31) + (getId() == null ? 0 : getId().hashCode())) * 31;
            Integer num = this.parentId;
            int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.episode;
            int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.season;
            int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
            boolean z = this.isFromDownload;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return ((((hashCode5 + i) * 31) + (getQuality() == null ? 0 : getQuality().hashCode())) * 31) + (getPosterHeaders() != null ? getPosterHeaders().hashCode() : 0);
        }

        public String toString() {
            return "ResumeWatchingResult(name=" + getName() + ", url=" + getUrl() + ", apiName=" + getApiName() + ", type=" + getType() + ", posterUrl=" + getPosterUrl() + ", watchPos=" + this.watchPos + ", id=" + getId() + ", parentId=" + this.parentId + ", episode=" + this.episode + ", season=" + this.season + ", isFromDownload=" + this.isFromDownload + ", quality=" + getQuality() + ", posterHeaders=" + getPosterHeaders() + ')';
        }

        public ResumeWatchingResult(@JsonProperty("name") String name, @JsonProperty("url") String url, @JsonProperty("apiName") String apiName, @JsonProperty("type") TvType tvType, @JsonProperty("posterUrl") String str, @JsonProperty("watchPos") PosDur posDur, @JsonProperty("id") Integer num, @JsonProperty("parentId") Integer num2, @JsonProperty("episode") Integer num3, @JsonProperty("season") Integer num4, @JsonProperty("isFromDownload") boolean z, @JsonProperty("quality") SearchQuality searchQuality, @JsonProperty("posterHeaders") Map<String, String> map) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(apiName, "apiName");
            this.name = name;
            this.url = url;
            this.apiName = apiName;
            this.type = tvType;
            this.posterUrl = str;
            this.watchPos = posDur;
            this.f10025id = num;
            this.parentId = num2;
            this.episode = num3;
            this.season = num4;
            this.isFromDownload = z;
            this.quality = searchQuality;
            this.posterHeaders = map;
        }

        public /* synthetic */ ResumeWatchingResult(String str, String str2, String str3, TvType tvType, String str4, PosDur posDur, Integer num, Integer num2, Integer num3, Integer num4, boolean z, SearchQuality searchQuality, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, (i & 8) != 0 ? null : tvType, str4, posDur, num, num2, num3, num4, z, (i & 2048) != 0 ? null : searchQuality, (i & 4096) != 0 ? null : map);
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public String getName() {
            return this.name;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public String getUrl() {
            return this.url;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public String getApiName() {
            return this.apiName;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public TvType getType() {
            return this.type;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public void setType(TvType tvType) {
            this.type = tvType;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public String getPosterUrl() {
            return this.posterUrl;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public void setPosterUrl(String str) {
            this.posterUrl = str;
        }

        public final PosDur getWatchPos() {
            return this.watchPos;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public Integer getId() {
            return this.f10025id;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public void setId(Integer num) {
            this.f10025id = num;
        }

        public final Integer getParentId() {
            return this.parentId;
        }

        public final Integer getEpisode() {
            return this.episode;
        }

        public final Integer getSeason() {
            return this.season;
        }

        public final boolean isFromDownload() {
            return this.isFromDownload;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public SearchQuality getQuality() {
            return this.quality;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public void setQuality(SearchQuality searchQuality) {
            this.quality = searchQuality;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public Map<String, String> getPosterHeaders() {
            return this.posterHeaders;
        }

        @Override // com.lagradost.cloudstream3.SearchResponse
        public void setPosterHeaders(Map<String, String> map) {
            this.posterHeaders = map;
        }
    }

    public final List<Integer> getAllWatchStateIds() {
        String str = currentAccount + "/result_watch_state";
        List<String> keys = AcraApplication.Companion.getKeys(str);
        if (keys != null) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : keys) {
                Integer intOrNull = StringsKt.toIntOrNull(StringsKt.removePrefix(str2, (CharSequence) (str + JsonPointer.SEPARATOR)));
                if (intOrNull != null) {
                    arrayList.add(intOrNull);
                }
            }
            return arrayList;
        }
        return null;
    }

    public final List<Integer> getAllResumeStateIds() {
        String str = currentAccount + "/result_resume_watching_2";
        List<String> keys = AcraApplication.Companion.getKeys(str);
        if (keys != null) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : keys) {
                Integer intOrNull = StringsKt.toIntOrNull(StringsKt.removePrefix(str2, (CharSequence) (str + JsonPointer.SEPARATOR)));
                if (intOrNull != null) {
                    arrayList.add(intOrNull);
                }
            }
            return arrayList;
        }
        return null;
    }

    private final List<Integer> getAllResumeStateIdsOld() {
        String str = currentAccount + "/result_resume_watching";
        List<String> keys = AcraApplication.Companion.getKeys(str);
        if (keys != null) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : keys) {
                Integer intOrNull = StringsKt.toIntOrNull(StringsKt.removePrefix(str2, (CharSequence) (str + JsonPointer.SEPARATOR)));
                if (intOrNull != null) {
                    arrayList.add(intOrNull);
                }
            }
            return arrayList;
        }
        return null;
    }

    public final void migrateResumeWatching() {
        AcraApplication.Companion.setKey(DataStoreHelperKt.RESULT_RESUME_WATCHING_HAS_MIGRATED, true);
        List<Integer> allResumeStateIdsOld = getAllResumeStateIdsOld();
        if (allResumeStateIdsOld != null) {
            for (Number number : allResumeStateIdsOld) {
                int intValue = number.intValue();
                DataStoreHelper dataStoreHelper = INSTANCE;
                VideoDownloadHelper.ResumeWatching lastWatchedOld = dataStoreHelper.getLastWatchedOld(Integer.valueOf(intValue));
                if (lastWatchedOld != null) {
                    dataStoreHelper.setLastWatched(Integer.valueOf(lastWatchedOld.getParentId()), null, lastWatchedOld.getEpisode(), lastWatchedOld.getSeason(), lastWatchedOld.isFromDownload(), Long.valueOf(lastWatchedOld.getUpdateTime()));
                    dataStoreHelper.removeLastWatchedOld(Integer.valueOf(lastWatchedOld.getParentId()));
                }
            }
        }
    }

    public static /* synthetic */ void setLastWatched$default(DataStoreHelper dataStoreHelper, Integer num, Integer num2, Integer num3, Integer num4, boolean z, Long l, int i, Object obj) {
        boolean z2 = (i & 16) != 0 ? false : z;
        if ((i & 32) != 0) {
            l = null;
        }
        dataStoreHelper.setLastWatched(num, num2, num3, num4, z2, l);
    }

    public final void setLastWatched(Integer num, Integer num2, Integer num3, Integer num4, boolean z, Long l) {
        if (num == null) {
            return;
        }
        AcraApplication.Companion companion = AcraApplication.Companion;
        companion.setKey(currentAccount + "/result_resume_watching_2", num.toString(), new VideoDownloadHelper.ResumeWatching(num.intValue(), num2, num3, num4, l != null ? l.longValue() : System.currentTimeMillis(), z));
    }

    private final void removeLastWatchedOld(Integer num) {
        if (num == null) {
            return;
        }
        AcraApplication.Companion companion = AcraApplication.Companion;
        companion.removeKey(currentAccount + "/result_resume_watching", num.toString());
    }

    public final void removeLastWatched(Integer num) {
        if (num == null) {
            return;
        }
        AcraApplication.Companion companion = AcraApplication.Companion;
        companion.removeKey(currentAccount + "/result_resume_watching_2", num.toString());
    }

    public final VideoDownloadHelper.ResumeWatching getLastWatched(Integer num) {
        Object obj = null;
        if (num == null) {
            return null;
        }
        AcraApplication.Companion companion = AcraApplication.Companion;
        String str = currentAccount + "/result_resume_watching_2";
        String num2 = num.toString();
        Context context = companion.getContext();
        if (context != null) {
            DataStore dataStore = DataStore.INSTANCE;
            try {
                String string = dataStore.getSharedPrefs(context).getString(dataStore.getFolderName(str, num2), null);
                if (string != null) {
                    Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                    Object readValue = dataStore.getMapper().readValue(string, VideoDownloadHelper.ResumeWatching.class);
                    Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                    obj = readValue;
                }
            } catch (Exception unused) {
            }
        }
        return (VideoDownloadHelper.ResumeWatching) obj;
    }

    public final VideoDownloadHelper.ResumeWatching getLastWatchedOld(Integer num) {
        Object obj = null;
        if (num == null) {
            return null;
        }
        AcraApplication.Companion companion = AcraApplication.Companion;
        String str = currentAccount + "/result_resume_watching";
        String num2 = num.toString();
        Context context = companion.getContext();
        if (context != null) {
            DataStore dataStore = DataStore.INSTANCE;
            try {
                String string = dataStore.getSharedPrefs(context).getString(dataStore.getFolderName(str, num2), null);
                if (string != null) {
                    Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                    Object readValue = dataStore.getMapper().readValue(string, VideoDownloadHelper.ResumeWatching.class);
                    Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                    obj = readValue;
                }
            } catch (Exception unused) {
            }
        }
        return (VideoDownloadHelper.ResumeWatching) obj;
    }

    public final void setBookmarkedData(Integer num, BookmarkedData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (num == null) {
            return;
        }
        AcraApplication.Companion companion = AcraApplication.Companion;
        companion.setKey(currentAccount + "/result_watch_state_data", num.toString(), data);
    }

    public final BookmarkedData getBookmarkedData(Integer num) {
        Object obj = null;
        if (num == null) {
            return null;
        }
        AcraApplication.Companion companion = AcraApplication.Companion;
        String str = currentAccount + "/result_watch_state_data";
        String num2 = num.toString();
        Context context = companion.getContext();
        if (context != null) {
            DataStore dataStore = DataStore.INSTANCE;
            try {
                String string = dataStore.getSharedPrefs(context).getString(dataStore.getFolderName(str, num2), null);
                if (string != null) {
                    Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                    Object readValue = dataStore.getMapper().readValue(string, BookmarkedData.class);
                    Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                    obj = readValue;
                }
            } catch (Exception unused) {
            }
        }
        return (BookmarkedData) obj;
    }

    public final void setViewPos(Integer num, long j, long j2) {
        if (num != null && j2 >= 30000) {
            AcraApplication.Companion companion = AcraApplication.Companion;
            companion.setKey(currentAccount + "/video_pos_dur", num.toString(), new PosDur(j, j2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.lagradost.cloudstream3.utils.DataStoreHelper.PosDur getViewPos(java.lang.Integer r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L4
            return r0
        L4:
            com.lagradost.cloudstream3.AcraApplication$Companion r1 = com.lagradost.cloudstream3.AcraApplication.Companion
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = com.lagradost.cloudstream3.utils.DataStoreHelper.currentAccount
            r2.append(r3)
            java.lang.String r3 = "/video_pos_dur"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r5 = r5.toString()
            android.content.Context r1 = r1.getContext()
            if (r1 == 0) goto L4e
            com.lagradost.cloudstream3.utils.DataStore r3 = com.lagradost.cloudstream3.utils.DataStore.INSTANCE
            java.lang.String r5 = r3.getFolderName(r2, r5)
            android.content.SharedPreferences r1 = r3.getSharedPrefs(r1)     // Catch: java.lang.Exception -> L49
            java.lang.String r5 = r1.getString(r5, r0)     // Catch: java.lang.Exception -> L49
            if (r5 != 0) goto L34
            goto L49
        L34:
            java.lang.String r1 = "getSharedPrefs().getStri…h, null) ?: return defVal"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)     // Catch: java.lang.Exception -> L49
            com.fasterxml.jackson.databind.json.JsonMapper r1 = r3.getMapper()     // Catch: java.lang.Exception -> L49
            java.lang.Class<com.lagradost.cloudstream3.utils.DataStoreHelper$PosDur> r2 = com.lagradost.cloudstream3.utils.DataStoreHelper.PosDur.class
            java.lang.Object r5 = r1.readValue(r5, r2)     // Catch: java.lang.Exception -> L49
            java.lang.String r1 = "mapper.readValue(this, T::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)     // Catch: java.lang.Exception -> L49
            goto L4a
        L49:
            r5 = r0
        L4a:
            if (r5 != 0) goto L4d
            goto L4e
        L4d:
            r0 = r5
        L4e:
            com.lagradost.cloudstream3.utils.DataStoreHelper$PosDur r0 = (com.lagradost.cloudstream3.utils.DataStoreHelper.PosDur) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.DataStoreHelper.getViewPos(java.lang.Integer):com.lagradost.cloudstream3.utils.DataStoreHelper$PosDur");
    }

    public final DubStatus getDub(int i) {
        DubStatus[] values = DubStatus.values();
        AcraApplication.Companion companion = AcraApplication.Companion;
        String str = currentAccount + "/result_dub";
        String valueOf = String.valueOf(i);
        Context context = companion.getContext();
        Object obj = null;
        if (context != null) {
            DataStore dataStore = DataStore.INSTANCE;
            try {
                String string = dataStore.getSharedPrefs(context).getString(dataStore.getFolderName(str, valueOf), null);
                if (string != null) {
                    Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                    Object readValue = dataStore.getMapper().readValue(string, Integer.class);
                    Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                    obj = readValue;
                }
            } catch (Exception unused) {
            }
        }
        Integer num = (Integer) obj;
        return values[num != null ? num.intValue() : 0];
    }

    public final void setDub(int i, DubStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        AcraApplication.Companion companion = AcraApplication.Companion;
        companion.setKey(currentAccount + "/result_dub", String.valueOf(i), Integer.valueOf(status.ordinal()));
    }

    /* compiled from: DataStoreHelper.kt */
    @Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/DataStoreHelper$Cache;", "", "time", "", "value", "", "(JLjava/lang/String;)V", "getTime", "()J", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Cache {
        private final long time;
        private final String value;

        public static /* synthetic */ Cache copy$default(Cache cache, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = cache.time;
            }
            if ((i & 2) != 0) {
                str = cache.value;
            }
            return cache.copy(j, str);
        }

        public final long component1() {
            return this.time;
        }

        public final String component2() {
            return this.value;
        }

        public final Cache copy(@JsonProperty("time") long j, @JsonProperty("value") String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Cache(j, value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Cache) {
                Cache cache = (Cache) obj;
                return this.time == cache.time && Intrinsics.areEqual(this.value, cache.value);
            }
            return false;
        }

        public int hashCode() {
            return (C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.time) * 31) + this.value.hashCode();
        }

        public String toString() {
            return "Cache(time=" + this.time + ", value=" + this.value + ')';
        }

        public Cache(@JsonProperty("time") long j, @JsonProperty("value") String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.time = j;
            this.value = value;
        }

        public final long getTime() {
            return this.time;
        }

        public final String getValue() {
            return this.value;
        }
    }

    public final void setCache(String url, String response) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(response, "response");
        Log.d("BLUE", "insert cache to " + url + ' ');
        AcraApplication.Companion.setKey("cache/api", url, new Gson().toJson(new Cache(System.currentTimeMillis(), response)));
    }

    public static /* synthetic */ String getCache$default(DataStoreHelper dataStoreHelper, String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 14400000;
        }
        return dataStoreHelper.getCache(str, j);
    }

    public final String getCache(String url, long j) {
        Object obj;
        String str;
        Cache cache;
        String string;
        Intrinsics.checkNotNullParameter(url, "url");
        Context context = AcraApplication.Companion.getContext();
        if (context != null) {
            DataStore dataStore = DataStore.INSTANCE;
            try {
                string = dataStore.getSharedPrefs(context).getString(dataStore.getFolderName("cache/api", url), null);
            } catch (Exception unused) {
            }
            if (string != null) {
                Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                obj = dataStore.getMapper().readValue(string, String.class);
                Intrinsics.checkNotNullExpressionValue(obj, "mapper.readValue(this, T::class.java)");
                str = (String) obj;
                if (str == null && (cache = (Cache) new Gson().fromJson(str, (Class<Object>) Cache.class)) != null && System.currentTimeMillis() <= cache.getTime() + j) {
                    return cache.getValue();
                }
                return null;
            }
        }
        obj = null;
        str = (String) obj;
        if (str == null) {
            return null;
        }
        return cache.getValue();
    }

    public final void setResultWatchState(Integer num, int i) {
        if (num == null) {
            return;
        }
        String str = currentAccount + "/result_watch_state";
        if (i == WatchType.NONE.getInternalId()) {
            AcraApplication.Companion.removeKey(str, num.toString());
            AcraApplication.Companion.removeKey(currentAccount + "/result_watch_state_data", num.toString());
            return;
        }
        AcraApplication.Companion.setKey(str, num.toString(), Integer.valueOf(i));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.lagradost.cloudstream3.p041ui.WatchType getResultWatchState(int r6) {
        /*
            r5 = this;
            com.lagradost.cloudstream3.ui.WatchType$Companion r0 = com.lagradost.cloudstream3.p041ui.WatchType.Companion
            com.lagradost.cloudstream3.AcraApplication$Companion r1 = com.lagradost.cloudstream3.AcraApplication.Companion
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = com.lagradost.cloudstream3.utils.DataStoreHelper.currentAccount
            r2.append(r3)
            java.lang.String r3 = "/result_watch_state"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            android.content.Context r1 = r1.getContext()
            r3 = 0
            if (r1 == 0) goto L4d
            com.lagradost.cloudstream3.utils.DataStore r4 = com.lagradost.cloudstream3.utils.DataStore.INSTANCE
            java.lang.String r6 = r4.getFolderName(r2, r6)
            android.content.SharedPreferences r1 = r4.getSharedPrefs(r1)     // Catch: java.lang.Exception -> L48
            java.lang.String r6 = r1.getString(r6, r3)     // Catch: java.lang.Exception -> L48
            if (r6 != 0) goto L33
            goto L48
        L33:
            java.lang.String r1 = "getSharedPrefs().getStri…h, null) ?: return defVal"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)     // Catch: java.lang.Exception -> L48
            com.fasterxml.jackson.databind.json.JsonMapper r1 = r4.getMapper()     // Catch: java.lang.Exception -> L48
            java.lang.Class<java.lang.Integer> r2 = java.lang.Integer.class
            java.lang.Object r6 = r1.readValue(r6, r2)     // Catch: java.lang.Exception -> L48
            java.lang.String r1 = "mapper.readValue(this, T::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)     // Catch: java.lang.Exception -> L48
            goto L49
        L48:
            r6 = r3
        L49:
            if (r6 != 0) goto L4c
            goto L4d
        L4c:
            r3 = r6
        L4d:
            java.lang.Integer r3 = (java.lang.Integer) r3
            com.lagradost.cloudstream3.ui.WatchType r6 = r0.fromInternalId(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.DataStoreHelper.getResultWatchState(int):com.lagradost.cloudstream3.ui.WatchType");
    }

    public final int getResultSeason(int i) {
        AcraApplication.Companion companion = AcraApplication.Companion;
        String str = currentAccount + "/result_season";
        String valueOf = String.valueOf(i);
        Context context = companion.getContext();
        Object obj = null;
        if (context != null) {
            DataStore dataStore = DataStore.INSTANCE;
            try {
                String string = dataStore.getSharedPrefs(context).getString(dataStore.getFolderName(str, valueOf), null);
                if (string != null) {
                    Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                    Object readValue = dataStore.getMapper().readValue(string, Integer.class);
                    Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                    obj = readValue;
                }
            } catch (Exception unused) {
            }
        }
        Integer num = (Integer) obj;
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public final void setResultSeason(int i, Integer num) {
        AcraApplication.Companion companion = AcraApplication.Companion;
        companion.setKey(currentAccount + "/result_season", String.valueOf(i), num);
    }

    public final void addSync(int i, String idPrefix, String url) {
        Intrinsics.checkNotNullParameter(idPrefix, "idPrefix");
        Intrinsics.checkNotNullParameter(url, "url");
        AcraApplication.Companion companion = AcraApplication.Companion;
        companion.setKey(idPrefix + "_sync", String.valueOf(i), url);
    }

    public final List<String> getSync(int i, List<String> idPrefixes) {
        Intrinsics.checkNotNullParameter(idPrefixes, "idPrefixes");
        List<String> list = idPrefixes;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            AcraApplication.Companion companion = AcraApplication.Companion;
            String str = ((String) it.next()) + "_sync";
            String valueOf = String.valueOf(i);
            Context context = companion.getContext();
            Object obj = null;
            if (context != null) {
                DataStore dataStore = DataStore.INSTANCE;
                try {
                    String string = dataStore.getSharedPrefs(context).getString(dataStore.getFolderName(str, valueOf), null);
                    if (string != null) {
                        Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                        Object readValue = dataStore.getMapper().readValue(string, String.class);
                        Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                        obj = readValue;
                    }
                } catch (Exception unused) {
                }
            }
            arrayList.add((String) obj);
        }
        return arrayList;
    }
}
