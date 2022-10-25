package com.lagradost.cloudstream3.p041ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bongngotv2.R;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.p041ui.search.SearchClickCallback;
import com.lagradost.cloudstream3.p041ui.search.SearchResponseDiffCallback;
import com.lagradost.cloudstream3.p041ui.search.SearchResultBuilder;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HomeChildItemAdapter.kt */
@Metadata(m108d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fBK\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0010\u000eJ\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0014\u0010\u001c\u001a\u00020\r2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001eR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006 "}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/home/HomeChildItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "cardList", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "overrideLayout", "", "nextFocusUp", "nextFocusDown", "clickCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/ui/search/SearchClickCallback;", "", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "getCardList", "()Ljava/util/List;", "Ljava/lang/Integer;", "getItemCount", "getItemId", "", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateList", "newList", "", "CardViewHolder", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.home.HomeChildItemAdapter */
/* loaded from: classes3.dex */
public final class HomeChildItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<SearchResponse> cardList;
    private final Function1<SearchClickCallback, Unit> clickCallback;
    private final Integer nextFocusDown;
    private final Integer nextFocusUp;
    private final Integer overrideLayout;

    public /* synthetic */ HomeChildItemAdapter(List list, Integer num, Integer num2, Integer num3, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3, function1);
    }

    public final List<SearchResponse> getCardList() {
        return this.cardList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HomeChildItemAdapter(List<SearchResponse> cardList, Integer num, Integer num2, Integer num3, Function1<? super SearchClickCallback, Unit> clickCallback) {
        Intrinsics.checkNotNullParameter(cardList, "cardList");
        Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
        this.cardList = cardList;
        this.overrideLayout = num;
        this.nextFocusUp = num2;
        this.nextFocusDown = num3;
        this.clickCallback = clickCallback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Integer num = this.overrideLayout;
        View inflate = LayoutInflater.from(parent.getContext()).inflate(num != null ? num.intValue() : UIHelper.INSTANCE.IsBottomLayout(parent.getContext()) ? R.layout.home_result_grid_expanded : R.layout.home_result_grid, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…te(layout, parent, false)");
        return new CardViewHolder(inflate, this.clickCallback, getItemCount(), this.nextFocusUp, this.nextFocusDown);
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
        return this.cardList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        Integer id = this.cardList.get(i).getId();
        if (id != null) {
            i = id.intValue();
        }
        return i;
    }

    public final void updateList(List<? extends SearchResponse> newList) {
        Intrinsics.checkNotNullParameter(newList, "newList");
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new SearchResponseDiffCallback(this.cardList, newList));
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "calculateDiff(\n         …dList, newList)\n        )");
        this.cardList.clear();
        this.cardList.addAll(newList);
        calculateDiff.dispatchUpdatesTo(this);
    }

    /* compiled from: HomeChildItemAdapter.kt */
    @Metadata(m108d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\fJ\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/home/HomeChildItemAdapter$CardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/ui/search/SearchClickCallback;", "", "itemCount", "", "nextFocusUp", "nextFocusDown", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;ILjava/lang/Integer;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "bind", "card", "Lcom/lagradost/cloudstream3/SearchResponse;", "position", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.home.HomeChildItemAdapter$CardViewHolder */
    /* loaded from: classes3.dex */
    public static final class CardViewHolder extends RecyclerView.ViewHolder {
        private final Function1<SearchClickCallback, Unit> clickCallback;
        private final int itemCount;
        private final Integer nextFocusDown;
        private final Integer nextFocusUp;

        public /* synthetic */ CardViewHolder(View view, Function1 function1, int i, Integer num, Integer num2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(view, function1, i, (i2 & 8) != 0 ? null : num, (i2 & 16) != 0 ? null : num2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public CardViewHolder(View itemView, Function1<? super SearchClickCallback, Unit> clickCallback, int i, Integer num, Integer num2) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
            this.clickCallback = clickCallback;
            this.itemCount = i;
            this.nextFocusUp = num;
            this.nextFocusDown = num2;
        }

        public final void bind(SearchResponse card, int i) {
            Boolean bool;
            CardView cardView;
            Intrinsics.checkNotNullParameter(card, "card");
            if (i == 0) {
                bool = true;
            } else {
                bool = i == this.itemCount - 1 ? false : null;
            }
            Boolean bool2 = bool;
            SearchResultBuilder searchResultBuilder = SearchResultBuilder.INSTANCE;
            Function1<SearchClickCallback, Unit> function1 = this.clickCallback;
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            searchResultBuilder.bind(function1, card, i, itemView, bool2, this.nextFocusUp, this.nextFocusDown);
            this.itemView.setTag(Integer.valueOf(i));
            if (i != 0 || (cardView = (CardView) this.itemView.findViewById(C4761R.C4764id.backgroundCard)) == null) {
                return;
            }
            cardView.setNextFocusLeftId(R.id.nav_rail_view);
        }
    }
}
