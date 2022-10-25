package com.lagradost.cloudstream3.p041ui.search;

import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.lagradost.cloudstream3.SearchResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SearchAdaptor.kt */
@Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/search/SearchClickCallback;", "", "action", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "position", "card", "Lcom/lagradost/cloudstream3/SearchResponse;", "(ILandroid/view/View;ILcom/lagradost/cloudstream3/SearchResponse;)V", "getAction", "()I", "getCard", "()Lcom/lagradost/cloudstream3/SearchResponse;", "getPosition", "getView", "()Landroid/view/View;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.search.SearchClickCallback */
/* loaded from: classes4.dex */
public final class SearchClickCallback {
    private final int action;
    private final SearchResponse card;
    private final int position;
    private final View view;

    public SearchClickCallback(int i, View view, int i2, SearchResponse card) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(card, "card");
        this.action = i;
        this.view = view;
        this.position = i2;
        this.card = card;
    }

    public final int getAction() {
        return this.action;
    }

    public final SearchResponse getCard() {
        return this.card;
    }

    public final int getPosition() {
        return this.position;
    }

    public final View getView() {
        return this.view;
    }
}
