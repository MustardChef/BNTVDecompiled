package com.lagradost.cloudstream3.p041ui.search;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.TvType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SearchHistoryAdaptor.kt */
@Metadata(m108d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0001\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\u000e\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0003\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/search/SearchHistoryItem;", "", "searchedAt", "", "searchText", "", "type", "", "Lcom/lagradost/cloudstream3/TvType;", SDKConstants.PARAM_KEY, "(JLjava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getSearchText", "getSearchedAt", "()J", "getType", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.search.SearchHistoryItem */
/* loaded from: classes4.dex */
public final class SearchHistoryItem {
    private final String key;
    private final String searchText;
    private final long searchedAt;
    private final List<TvType> type;

    public static /* synthetic */ SearchHistoryItem copy$default(SearchHistoryItem searchHistoryItem, long j, String str, List list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = searchHistoryItem.searchedAt;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = searchHistoryItem.searchText;
        }
        String str3 = str;
        List<TvType> list2 = list;
        if ((i & 4) != 0) {
            list2 = searchHistoryItem.type;
        }
        List list3 = list2;
        if ((i & 8) != 0) {
            str2 = searchHistoryItem.key;
        }
        return searchHistoryItem.copy(j2, str3, list3, str2);
    }

    public final long component1() {
        return this.searchedAt;
    }

    public final String component2() {
        return this.searchText;
    }

    public final List<TvType> component3() {
        return this.type;
    }

    public final String component4() {
        return this.key;
    }

    public final SearchHistoryItem copy(@JsonProperty("searchedAt") long j, @JsonProperty("searchText") String searchText, @JsonProperty("type") List<? extends TvType> type, @JsonProperty("key") String key) {
        Intrinsics.checkNotNullParameter(searchText, "searchText");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(key, "key");
        return new SearchHistoryItem(j, searchText, type, key);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SearchHistoryItem) {
            SearchHistoryItem searchHistoryItem = (SearchHistoryItem) obj;
            return this.searchedAt == searchHistoryItem.searchedAt && Intrinsics.areEqual(this.searchText, searchHistoryItem.searchText) && Intrinsics.areEqual(this.type, searchHistoryItem.type) && Intrinsics.areEqual(this.key, searchHistoryItem.key);
        }
        return false;
    }

    public int hashCode() {
        return (((((C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.searchedAt) * 31) + this.searchText.hashCode()) * 31) + this.type.hashCode()) * 31) + this.key.hashCode();
    }

    public String toString() {
        return "SearchHistoryItem(searchedAt=" + this.searchedAt + ", searchText=" + this.searchText + ", type=" + this.type + ", key=" + this.key + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchHistoryItem(@JsonProperty("searchedAt") long j, @JsonProperty("searchText") String searchText, @JsonProperty("type") List<? extends TvType> type, @JsonProperty("key") String key) {
        Intrinsics.checkNotNullParameter(searchText, "searchText");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(key, "key");
        this.searchedAt = j;
        this.searchText = searchText;
        this.type = type;
        this.key = key;
    }

    public final long getSearchedAt() {
        return this.searchedAt;
    }

    public final String getSearchText() {
        return this.searchText;
    }

    public final List<TvType> getType() {
        return this.type;
    }

    public final String getKey() {
        return this.key;
    }
}
