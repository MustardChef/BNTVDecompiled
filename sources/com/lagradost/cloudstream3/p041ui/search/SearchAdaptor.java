package com.lagradost.cloudstream3.p041ui.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bongngotv2.R;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.LiveTvSearchResponse;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.p041ui.AutofitRecyclerView;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(m108d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003!\"#B;\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0010\u000eJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0015H\u0016J\u0014\u0010\u001e\u001a\u00020\r2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050 R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/search/SearchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "cardList", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "resView", "Lcom/lagradost/cloudstream3/ui/AutofitRecyclerView;", "enableLoadmore", "", "clickCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/ui/search/SearchClickCallback;", "", "(Ljava/util/List;Lcom/lagradost/cloudstream3/ui/AutofitRecyclerView;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;)V", "getEnableLoadmore", "()Ljava/lang/Boolean;", "setEnableLoadmore", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateList", "newList", "", "CardViewHolder", "Companion", "FooterViewHolder", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.search.SearchAdapter */
/* loaded from: classes4.dex */
public final class SearchAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion(null);
    public static final int TYPE_DATA = 1;
    public static final int TYPE_FOOTER = 2;
    private final List<SearchResponse> cardList;
    private final Function1<SearchClickCallback, Unit> clickCallback;
    private Boolean enableLoadmore;
    private final AutofitRecyclerView resView;

    public /* synthetic */ SearchAdaptor(List list, AutofitRecyclerView autofitRecyclerView, Boolean bool, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, autofitRecyclerView, (i & 4) != 0 ? false : bool, function1);
    }

    public final Boolean getEnableLoadmore() {
        return this.enableLoadmore;
    }

    public final void setEnableLoadmore(Boolean bool) {
        this.enableLoadmore = bool;
    }

    /* compiled from: SearchAdaptor.kt */
    @Metadata(m108d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/search/SearchAdapter$Companion;", "", "()V", "TYPE_DATA", "", "TYPE_FOOTER", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.search.SearchAdapter$Companion */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchAdaptor(List<SearchResponse> cardList, AutofitRecyclerView resView, Boolean bool, Function1<? super SearchClickCallback, Unit> clickCallback) {
        Intrinsics.checkNotNullParameter(cardList, "cardList");
        Intrinsics.checkNotNullParameter(resView, "resView");
        Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
        this.cardList = cardList;
        this.resView = resView;
        this.enableLoadmore = bool;
        this.clickCallback = clickCallback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (i == getItemCount() - 1 && Intrinsics.areEqual((Object) this.enableLoadmore, (Object) true)) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (i == 1) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(UIHelper.INSTANCE.IsBottomLayout(parent.getContext()) ? R.layout.search_result_grid_expanded : R.layout.search_result_grid, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…te(layout, parent, false)");
            return new CardViewHolder(inflate, this.clickCallback, this.resView);
        } else if (i == 2) {
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.loadmore, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context).inf…ut.loadmore,parent,false)");
            return new FooterViewHolder(inflate2);
        } else {
            View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.loadmore, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…ut.loadmore,parent,false)");
            return new FooterViewHolder(inflate3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof CardViewHolder) {
            ((CardViewHolder) holder).bind(this.cardList.get(i), i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (Intrinsics.areEqual((Object) this.enableLoadmore, (Object) true)) {
            return this.cardList.size() + 1;
        }
        return this.cardList.size();
    }

    public final void updateList(List<? extends SearchResponse> newList) {
        Intrinsics.checkNotNullParameter(newList, "newList");
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new SearchResponseDiffCallback(this.cardList, newList));
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "calculateDiff(\n         …dList, newList)\n        )");
        this.cardList.clear();
        this.cardList.addAll(newList);
        calculateDiff.dispatchUpdatesTo(this);
    }

    /* compiled from: SearchAdaptor.kt */
    @Metadata(m108d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/search/SearchAdapter$CardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/ui/search/SearchClickCallback;", "", "resView", "Lcom/lagradost/cloudstream3/ui/AutofitRecyclerView;", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lcom/lagradost/cloudstream3/ui/AutofitRecyclerView;)V", "cardView", "Landroid/widget/ImageView;", "getCardView", "()Landroid/widget/ImageView;", "compactView", "", "coverHeight", "", "bind", "card", "Lcom/lagradost/cloudstream3/SearchResponse;", "position", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.search.SearchAdapter$CardViewHolder */
    /* loaded from: classes4.dex */
    public static final class CardViewHolder extends RecyclerView.ViewHolder {
        private final ImageView cardView;
        private final Function1<SearchClickCallback, Unit> clickCallback;
        private final boolean compactView;
        private final int coverHeight;
        private final AutofitRecyclerView resView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public CardViewHolder(View itemView, Function1<? super SearchClickCallback, Unit> clickCallback, AutofitRecyclerView resView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
            Intrinsics.checkNotNullParameter(resView, "resView");
            this.clickCallback = clickCallback;
            this.resView = resView;
            ImageView imageView = (ImageView) itemView.findViewById(C4761R.C4764id.imageView);
            Intrinsics.checkNotNullExpressionValue(imageView, "itemView.imageView");
            this.cardView = imageView;
            this.coverHeight = this.compactView ? UIHelper.INSTANCE.getToPx(80) : MathKt.roundToInt(resView.getItemWidth() / 0.68d);
        }

        public final ImageView getCardView() {
            return this.cardView;
        }

        public final void bind(SearchResponse card, int i) {
            Intrinsics.checkNotNullParameter(card, "card");
            if (!this.compactView) {
                this.cardView.setLayoutParams(new FrameLayout.LayoutParams(-1, card instanceof LiveTvSearchResponse ? MathKt.roundToInt(this.resView.getItemWidth() / 1.7d) : this.coverHeight));
            }
            SearchResultBuilder searchResultBuilder = SearchResultBuilder.INSTANCE;
            Function1<SearchClickCallback, Unit> function1 = this.clickCallback;
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            searchResultBuilder.bind(function1, card, i, itemView, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : null);
        }
    }

    /* compiled from: SearchAdaptor.kt */
    @Metadata(m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/search/SearchAdapter$FooterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.search.SearchAdapter$FooterViewHolder */
    /* loaded from: classes4.dex */
    public static final class FooterViewHolder extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FooterViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }
    }
}
