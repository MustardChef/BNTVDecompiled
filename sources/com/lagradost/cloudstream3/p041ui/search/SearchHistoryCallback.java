package com.lagradost.cloudstream3.p041ui.search;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SearchHistoryAdaptor.kt */
@Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/search/SearchHistoryCallback;", "", "item", "Lcom/lagradost/cloudstream3/ui/search/SearchHistoryItem;", "clickAction", "", "(Lcom/lagradost/cloudstream3/ui/search/SearchHistoryItem;I)V", "getClickAction", "()I", "getItem", "()Lcom/lagradost/cloudstream3/ui/search/SearchHistoryItem;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.search.SearchHistoryCallback */
/* loaded from: classes4.dex */
public final class SearchHistoryCallback {
    private final int clickAction;
    private final SearchHistoryItem item;

    public static /* synthetic */ SearchHistoryCallback copy$default(SearchHistoryCallback searchHistoryCallback, SearchHistoryItem searchHistoryItem, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            searchHistoryItem = searchHistoryCallback.item;
        }
        if ((i2 & 2) != 0) {
            i = searchHistoryCallback.clickAction;
        }
        return searchHistoryCallback.copy(searchHistoryItem, i);
    }

    public final SearchHistoryItem component1() {
        return this.item;
    }

    public final int component2() {
        return this.clickAction;
    }

    public final SearchHistoryCallback copy(SearchHistoryItem item, int i) {
        Intrinsics.checkNotNullParameter(item, "item");
        return new SearchHistoryCallback(item, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SearchHistoryCallback) {
            SearchHistoryCallback searchHistoryCallback = (SearchHistoryCallback) obj;
            return Intrinsics.areEqual(this.item, searchHistoryCallback.item) && this.clickAction == searchHistoryCallback.clickAction;
        }
        return false;
    }

    public int hashCode() {
        return (this.item.hashCode() * 31) + this.clickAction;
    }

    public String toString() {
        return "SearchHistoryCallback(item=" + this.item + ", clickAction=" + this.clickAction + ')';
    }

    public SearchHistoryCallback(SearchHistoryItem item, int i) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.item = item;
        this.clickAction = i;
    }

    public final SearchHistoryItem getItem() {
        return this.item;
    }

    public final int getClickAction() {
        return this.clickAction;
    }
}
