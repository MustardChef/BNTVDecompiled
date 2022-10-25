package com.lagradost.cloudstream3.p041ui.search;

import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.mvvm.Resource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SearchViewModel.kt */
@Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/search/OnGoingSearch;", "", "apiName", "", "data", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "(Ljava/lang/String;Lcom/lagradost/cloudstream3/mvvm/Resource;)V", "getApiName", "()Ljava/lang/String;", "getData", "()Lcom/lagradost/cloudstream3/mvvm/Resource;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.search.OnGoingSearch */
/* loaded from: classes4.dex */
public final class OnGoingSearch {
    private final String apiName;
    private final Resource<List<SearchResponse>> data;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OnGoingSearch copy$default(OnGoingSearch onGoingSearch, String str, Resource resource, int i, Object obj) {
        if ((i & 1) != 0) {
            str = onGoingSearch.apiName;
        }
        if ((i & 2) != 0) {
            resource = onGoingSearch.data;
        }
        return onGoingSearch.copy(str, resource);
    }

    public final String component1() {
        return this.apiName;
    }

    public final Resource<List<SearchResponse>> component2() {
        return this.data;
    }

    public final OnGoingSearch copy(String apiName, Resource<? extends List<? extends SearchResponse>> data) {
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Intrinsics.checkNotNullParameter(data, "data");
        return new OnGoingSearch(apiName, data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OnGoingSearch) {
            OnGoingSearch onGoingSearch = (OnGoingSearch) obj;
            return Intrinsics.areEqual(this.apiName, onGoingSearch.apiName) && Intrinsics.areEqual(this.data, onGoingSearch.data);
        }
        return false;
    }

    public int hashCode() {
        return (this.apiName.hashCode() * 31) + this.data.hashCode();
    }

    public String toString() {
        return "OnGoingSearch(apiName=" + this.apiName + ", data=" + this.data + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OnGoingSearch(String apiName, Resource<? extends List<? extends SearchResponse>> data) {
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Intrinsics.checkNotNullParameter(data, "data");
        this.apiName = apiName;
        this.data = data;
    }

    public final String getApiName() {
        return this.apiName;
    }

    public final Resource<List<SearchResponse>> getData() {
        return this.data;
    }
}
