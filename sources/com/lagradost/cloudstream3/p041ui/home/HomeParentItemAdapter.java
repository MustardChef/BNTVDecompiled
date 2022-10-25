package com.lagradost.cloudstream3.p041ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bongngotv2.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.p041ui.home.HomeParentItemAdapter;
import com.lagradost.cloudstream3.p041ui.search.SearchClickCallback;
import com.lagradost.cloudstream3.p041ui.settings.SettingsFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m108d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB;\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u0016J\u0014\u0010\u0019\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/home/ParentItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", FirebaseAnalytics.Param.ITEMS, "", "Lcom/lagradost/cloudstream3/HomePageList;", "clickCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/ui/search/SearchClickCallback;", "", "moreInfoClickCallback", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "Lcom/lagradost/cloudstream3/ui/home/ParentItemAdapter$ParentViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "updateList", "newList", "", "CardType", "ParentViewHolder", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.home.ParentItemAdapter */
/* loaded from: classes3.dex */
public final class HomeParentItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Function1<SearchClickCallback, Unit> clickCallback;
    private List<HomePageList> items;
    private final Function1<HomePageList, Unit> moreInfoClickCallback;

    /* compiled from: HomeParentItemAdapter.kt */
    @Metadata(m108d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/home/ParentItemAdapter$CardType;", "", "(Ljava/lang/String;I)V", "BIG_CARD", "NORMAL_CARD", "CIRCLE_CARD", "LONG_WIDTH_CARD", "FULL_WIDTH_CARD", "TOP_CARD", "TV_CARD", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.home.ParentItemAdapter$CardType */
    /* loaded from: classes3.dex */
    public enum CardType {
        BIG_CARD,
        NORMAL_CARD,
        CIRCLE_CARD,
        LONG_WIDTH_CARD,
        FULL_WIDTH_CARD,
        TOP_CARD,
        TV_CARD
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HomeParentItemAdapter(List<HomePageList> items, Function1<? super SearchClickCallback, Unit> clickCallback, Function1<? super HomePageList, Unit> moreInfoClickCallback) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
        Intrinsics.checkNotNullParameter(moreInfoClickCallback, "moreInfoClickCallback");
        this.items = items;
        this.clickCallback = clickCallback;
        this.moreInfoClickCallback = moreInfoClickCallback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        SettingsFragment.Companion companion = SettingsFragment.Companion;
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        int i2 = companion.isTvSettings(context) ? R.layout.homepage_parent_tv : R.layout.homepage_parent;
        if (i == CardType.BIG_CARD.ordinal()) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(i2, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…te(layout, parent, false)");
            return new ParentViewHolder(inflate, this.clickCallback, this.moreInfoClickCallback, CardType.BIG_CARD);
        } else if (i == CardType.CIRCLE_CARD.ordinal()) {
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(i2, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context).inf…te(layout, parent, false)");
            return new ParentViewHolder(inflate2, this.clickCallback, this.moreInfoClickCallback, CardType.CIRCLE_CARD);
        } else if (i == CardType.LONG_WIDTH_CARD.ordinal()) {
            View inflate3 = LayoutInflater.from(parent.getContext()).inflate(i2, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…te(layout, parent, false)");
            return new ParentViewHolder(inflate3, this.clickCallback, this.moreInfoClickCallback, CardType.LONG_WIDTH_CARD);
        } else if (i == CardType.FULL_WIDTH_CARD.ordinal()) {
            View inflate4 = LayoutInflater.from(parent.getContext()).inflate(i2, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate4, "from(parent.context).inf…te(layout, parent, false)");
            return new ParentViewHolder(inflate4, this.clickCallback, this.moreInfoClickCallback, CardType.FULL_WIDTH_CARD);
        } else if (i == CardType.TOP_CARD.ordinal()) {
            View inflate5 = LayoutInflater.from(parent.getContext()).inflate(i2, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate5, "from(parent.context).inf…te(layout, parent, false)");
            return new ParentViewHolder(inflate5, this.clickCallback, this.moreInfoClickCallback, CardType.TOP_CARD);
        } else if (i == CardType.TV_CARD.ordinal()) {
            View inflate6 = LayoutInflater.from(parent.getContext()).inflate(i2, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate6, "from(parent.context).inf…te(layout, parent, false)");
            return new ParentViewHolder(inflate6, this.clickCallback, this.moreInfoClickCallback, CardType.TV_CARD);
        } else {
            View inflate7 = LayoutInflater.from(parent.getContext()).inflate(i2, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate7, "from(parent.context).inf…te(layout, parent, false)");
            return new ParentViewHolder(inflate7, this.clickCallback, this.moreInfoClickCallback, null, 8, null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof ParentViewHolder) {
            ((ParentViewHolder) holder).bind(this.items.get(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.items.get(i).getCardType().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return this.items.get(i).getName().hashCode();
    }

    public final void updateList(List<HomePageList> newList) {
        Intrinsics.checkNotNullParameter(newList, "newList");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (HomePageList homePageList : newList) {
            if (homePageList.getList().isEmpty()) {
                arrayList.add(homePageList);
            } else {
                arrayList2.add(homePageList);
            }
        }
        arrayList2.addAll(arrayList);
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new SearchDiffCallback(this.items, arrayList2));
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "calculateDiff(\n         …ewFilteredList)\n        )");
        this.items.clear();
        this.items.addAll(arrayList2);
        calculateDiff.dispatchUpdatesTo(this);
    }

    /* compiled from: HomeParentItemAdapter.kt */
    @Metadata(m108d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\tR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/home/ParentItemAdapter$ParentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/ui/search/SearchClickCallback;", "", "moreInfoClickCallback", "Lcom/lagradost/cloudstream3/HomePageList;", "type", "Lcom/lagradost/cloudstream3/ui/home/ParentItemAdapter$CardType;", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcom/lagradost/cloudstream3/ui/home/ParentItemAdapter$CardType;)V", "moreInfo", "Landroid/widget/LinearLayout;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "tvMore", "getTvMore", "()Landroid/view/View;", "getType", "()Lcom/lagradost/cloudstream3/ui/home/ParentItemAdapter$CardType;", "bind", "info", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.home.ParentItemAdapter$ParentViewHolder */
    /* loaded from: classes3.dex */
    public static final class ParentViewHolder extends RecyclerView.ViewHolder {
        private final Function1<SearchClickCallback, Unit> clickCallback;
        private final LinearLayout moreInfo;
        private final Function1<HomePageList, Unit> moreInfoClickCallback;
        private final RecyclerView recyclerView;
        private final TextView title;
        private final View tvMore;
        private final CardType type;

        /* compiled from: HomeParentItemAdapter.kt */
        @Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
        /* renamed from: com.lagradost.cloudstream3.ui.home.ParentItemAdapter$ParentViewHolder$WhenMappings */
        /* loaded from: classes3.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CardType.values().length];
                iArr[CardType.BIG_CARD.ordinal()] = 1;
                iArr[CardType.CIRCLE_CARD.ordinal()] = 2;
                iArr[CardType.LONG_WIDTH_CARD.ordinal()] = 3;
                iArr[CardType.FULL_WIDTH_CARD.ordinal()] = 4;
                iArr[CardType.TOP_CARD.ordinal()] = 5;
                iArr[CardType.TV_CARD.ordinal()] = 6;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ ParentViewHolder(View view, Function1 function1, Function1 function12, CardType cardType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(view, function1, function12, (i & 8) != 0 ? CardType.NORMAL_CARD : cardType);
        }

        public final CardType getType() {
            return this.type;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ParentViewHolder(View itemView, Function1<? super SearchClickCallback, Unit> clickCallback, Function1<? super HomePageList, Unit> moreInfoClickCallback, CardType type) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
            Intrinsics.checkNotNullParameter(moreInfoClickCallback, "moreInfoClickCallback");
            Intrinsics.checkNotNullParameter(type, "type");
            this.clickCallback = clickCallback;
            this.moreInfoClickCallback = moreInfoClickCallback;
            this.type = type;
            TextView textView = (TextView) itemView.findViewById(C4761R.C4764id.home_parent_item_title);
            Intrinsics.checkNotNullExpressionValue(textView, "itemView.home_parent_item_title");
            this.title = textView;
            TextView textView2 = (TextView) itemView.findViewById(C4761R.C4764id.tvMore);
            this.tvMore = textView2;
            RecyclerView recyclerView = (RecyclerView) itemView.findViewById(C4761R.C4764id.home_child_recyclerview);
            Intrinsics.checkNotNullExpressionValue(recyclerView, "itemView.home_child_recyclerview");
            this.recyclerView = recyclerView;
            LinearLayout linearLayout = (LinearLayout) itemView.findViewById(C4761R.C4764id.home_child_more_info);
            this.moreInfo = linearLayout;
            if (type == CardType.FULL_WIDTH_CARD) {
                new LinearSnapHelper().attachToRecyclerView(recyclerView);
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
            }
            if (type == CardType.TOP_CARD) {
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                new LinearSnapHelper().attachToRecyclerView(recyclerView);
            }
        }

        public final TextView getTitle() {
            return this.title;
        }

        public final View getTvMore() {
            return this.tvMore;
        }

        public final RecyclerView getRecyclerView() {
            return this.recyclerView;
        }

        public final void bind(final HomePageList info) {
            int i;
            Intrinsics.checkNotNullParameter(info, "info");
            this.title.setText(info.getName());
            RecyclerView recyclerView = this.recyclerView;
            List mutableList = CollectionsKt.toMutableList((Collection) info.getList());
            Function1<SearchClickCallback, Unit> function1 = this.clickCallback;
            int nextFocusUpId = this.recyclerView.getNextFocusUpId();
            int nextFocusDownId = this.recyclerView.getNextFocusDownId();
            switch (WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()]) {
                case 1:
                    i = R.layout.home_result_big_grid;
                    break;
                case 2:
                    i = R.layout.home_result_circle_grid;
                    break;
                case 3:
                    i = R.layout.home_result_long_width_grid;
                    break;
                case 4:
                    i = R.layout.home_result_full_width_grid;
                    break;
                case 5:
                    i = R.layout.home_result_top_grid;
                    break;
                case 6:
                    i = R.layout.home_result_tv_long_width_grid;
                    break;
                default:
                    i = R.layout.home_result_grid;
                    break;
            }
            recyclerView.setAdapter(new HomeChildItemAdapter(mutableList, Integer.valueOf(i), Integer.valueOf(nextFocusUpId), Integer.valueOf(nextFocusDownId), function1));
            LinearLayout linearLayout = this.moreInfo;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.home.-$$Lambda$ParentItemAdapter$ParentViewHolder$wOCaFabcenQ9jgzxGy4v2GVxVzk
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HomeParentItemAdapter.ParentViewHolder.m8660bind$lambda0(HomeParentItemAdapter.ParentViewHolder.this, info, view);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: bind$lambda-0  reason: not valid java name */
        public static final void m8660bind$lambda0(ParentViewHolder this$0, HomePageList info, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(info, "$info");
            this$0.moreInfoClickCallback.invoke(info);
        }
    }
}
