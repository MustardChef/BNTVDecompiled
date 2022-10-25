package com.lagradost.cloudstream3;

import com.lagradost.cloudstream3.p041ui.home.HomeParentItemAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainAPI.kt */
@Metadata(m108d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0016"}, m107d2 = {"Lcom/lagradost/cloudstream3/HomePageList;", "", "name", "", "list", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "urlMore", "nameApi", "cardType", "Lcom/lagradost/cloudstream3/ui/home/ParentItemAdapter$CardType;", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/ui/home/ParentItemAdapter$CardType;)V", "getCardType", "()Lcom/lagradost/cloudstream3/ui/home/ParentItemAdapter$CardType;", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getNameApi", "getUrlMore", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class HomePageList {
    private final HomeParentItemAdapter.CardType cardType;
    private List<? extends SearchResponse> list;
    private final String name;
    private final String nameApi;
    private final String urlMore;

    public HomePageList(String name, List<? extends SearchResponse> list, String str, String str2, HomeParentItemAdapter.CardType cardType) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        this.name = name;
        this.list = list;
        this.urlMore = str;
        this.nameApi = str2;
        this.cardType = cardType;
    }

    public final String getName() {
        return this.name;
    }

    public final List<SearchResponse> getList() {
        return this.list;
    }

    public final void setList(List<? extends SearchResponse> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.list = list;
    }

    public final String getUrlMore() {
        return this.urlMore;
    }

    public final String getNameApi() {
        return this.nameApi;
    }

    public /* synthetic */ HomePageList(String str, List list, String str2, String str3, HomeParentItemAdapter.CardType cardType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? HomeParentItemAdapter.CardType.NORMAL_CARD : cardType);
    }

    public final HomeParentItemAdapter.CardType getCardType() {
        return this.cardType;
    }
}
