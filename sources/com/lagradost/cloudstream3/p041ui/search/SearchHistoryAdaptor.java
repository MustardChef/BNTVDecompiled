package com.lagradost.cloudstream3.p041ui.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bongngotv2.R;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.p041ui.search.SearchHistoryAdaptor;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SearchHistoryAdaptor.kt */
@Metadata(m108d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0014\u0010\u0014\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/search/SearchHistoryAdaptor;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "cardList", "", "Lcom/lagradost/cloudstream3/ui/search/SearchHistoryItem;", "clickCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/ui/search/SearchHistoryCallback;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateList", "newList", "", "CardViewHolder", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.search.SearchHistoryAdaptor */
/* loaded from: classes4.dex */
public final class SearchHistoryAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<SearchHistoryItem> cardList;
    private final Function1<SearchHistoryCallback, Unit> clickCallback;

    /* JADX WARN: Multi-variable type inference failed */
    public SearchHistoryAdaptor(List<SearchHistoryItem> cardList, Function1<? super SearchHistoryCallback, Unit> clickCallback) {
        Intrinsics.checkNotNullParameter(cardList, "cardList");
        Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
        this.cardList = cardList;
        this.clickCallback = clickCallback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_history_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   …tory_item, parent, false)");
        return new CardViewHolder(inflate, this.clickCallback);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof CardViewHolder) {
            ((CardViewHolder) holder).bind(this.cardList.get(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cardList.size();
    }

    public final void updateList(List<SearchHistoryItem> newList) {
        Intrinsics.checkNotNullParameter(newList, "newList");
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new SearchHistoryDiffCallback(this.cardList, newList));
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "calculateDiff(\n         …dList, newList)\n        )");
        this.cardList.clear();
        this.cardList.addAll(newList);
        calculateDiff.dispatchUpdatesTo(this);
    }

    /* compiled from: SearchHistoryAdaptor.kt */
    @Metadata(m108d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/search/SearchHistoryAdaptor$CardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/ui/search/SearchHistoryCallback;", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "openButton", "removeButton", "Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "bind", "card", "Lcom/lagradost/cloudstream3/ui/search/SearchHistoryItem;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.search.SearchHistoryAdaptor$CardViewHolder */
    /* loaded from: classes4.dex */
    public static final class CardViewHolder extends RecyclerView.ViewHolder {
        private final Function1<SearchHistoryCallback, Unit> clickCallback;
        private final View openButton;
        private final ImageView removeButton;
        private final TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public CardViewHolder(View itemView, Function1<? super SearchHistoryCallback, Unit> clickCallback) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
            this.clickCallback = clickCallback;
            ImageView imageView = (ImageView) itemView.findViewById(C4761R.C4764id.home_history_remove);
            Intrinsics.checkNotNullExpressionValue(imageView, "itemView.home_history_remove");
            this.removeButton = imageView;
            ConstraintLayout constraintLayout = (ConstraintLayout) itemView.findViewById(C4761R.C4764id.home_history_tab);
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "itemView.home_history_tab");
            this.openButton = constraintLayout;
            TextView textView = (TextView) itemView.findViewById(C4761R.C4764id.home_history_title);
            Intrinsics.checkNotNullExpressionValue(textView, "itemView.home_history_title");
            this.title = textView;
        }

        public final void bind(final SearchHistoryItem card) {
            Intrinsics.checkNotNullParameter(card, "card");
            this.title.setText(card.getSearchText());
            this.removeButton.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.search.-$$Lambda$SearchHistoryAdaptor$CardViewHolder$zFLdOz9rzEl2nmhZVNZHBcmW0tE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchHistoryAdaptor.CardViewHolder.m8883bind$lambda0(SearchHistoryAdaptor.CardViewHolder.this, card, view);
                }
            });
            this.openButton.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.search.-$$Lambda$SearchHistoryAdaptor$CardViewHolder$HECp3_9NeojQa2OmMek2yljRAuI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchHistoryAdaptor.CardViewHolder.m8884bind$lambda1(SearchHistoryAdaptor.CardViewHolder.this, card, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: bind$lambda-0  reason: not valid java name */
        public static final void m8883bind$lambda0(CardViewHolder this$0, SearchHistoryItem card, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(card, "$card");
            this$0.clickCallback.invoke(new SearchHistoryCallback(card, 1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: bind$lambda-1  reason: not valid java name */
        public static final void m8884bind$lambda1(CardViewHolder this$0, SearchHistoryItem card, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(card, "$card");
            this$0.clickCallback.invoke(new SearchHistoryCallback(card, 0));
        }
    }
}
