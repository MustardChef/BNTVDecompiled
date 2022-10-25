package com.lagradost.cloudstream3.p041ui.home;

import androidx.fragment.app.FragmentActivity;
import com.bongngotv2.R;
import com.lagradost.cloudstream3.p041ui.WatchType;
import com.lagradost.cloudstream3.p041ui.search.SearchClickCallback;
import com.lagradost.cloudstream3.p041ui.search.SearchHelper;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.DataStoreHelper;
import com.lagradost.cloudstream3.utils.SingleSelectionHelper;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: HomeFragment.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "callback", "Lcom/lagradost/cloudstream3/ui/search/SearchClickCallback;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.home.HomeFragment$onViewCreated$12 */
/* loaded from: classes3.dex */
final class HomeFragment$onViewCreated$12 extends Lambda implements Function1<SearchClickCallback, Unit> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeFragment$onViewCreated$12(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SearchClickCallback searchClickCallback) {
        invoke2(searchClickCallback);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeFragment.kt */
    @Metadata(m108d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, m107d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.home.HomeFragment$onViewCreated$12$1 */
    /* loaded from: classes3.dex */
    public static final class C48591 extends Lambda implements Function1<Tuples<? extends Boolean, ? extends Integer>, Unit> {
        final /* synthetic */ SearchClickCallback $callback;
        final /* synthetic */ HomeFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C48591(HomeFragment homeFragment, SearchClickCallback searchClickCallback) {
            super(1);
            this.this$0 = homeFragment;
            this.$callback = searchClickCallback;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples<? extends Boolean, ? extends Integer> tuples) {
            invoke2((Tuples<Boolean, Integer>) tuples);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples<Boolean, Integer> tuples) {
            Intrinsics.checkNotNullParameter(tuples, "<name for destructuring parameter 0>");
            boolean booleanValue = tuples.component1().booleanValue();
            int intValue = tuples.component2().intValue();
            if (!booleanValue) {
                if (intValue == 0) {
                    invoke$info(this.this$0, this.$callback);
                } else if (intValue != 1) {
                } else {
                    invoke$remove(this.$callback, this.this$0);
                }
            } else if (intValue == 0) {
                invoke$play(this.this$0, this.$callback);
            } else if (intValue == 1) {
                invoke$info(this.this$0, this.$callback);
            } else if (intValue != 2) {
            } else {
                invoke$remove(this.$callback, this.this$0);
            }
        }

        private static final void invoke$play(HomeFragment homeFragment, SearchClickCallback searchClickCallback) {
            AppUtils.loadSearchResult$default(AppUtils.INSTANCE, homeFragment.getActivity(), searchClickCallback.getCard(), 1, null, 4, null);
            homeFragment.reloadStored();
        }

        private static final void invoke$remove(SearchClickCallback searchClickCallback, HomeFragment homeFragment) {
            DataStoreHelper.INSTANCE.setResultWatchState(searchClickCallback.getCard().getId(), WatchType.NONE.getInternalId());
            homeFragment.reloadStored();
        }

        private static final void invoke$info(HomeFragment homeFragment, SearchClickCallback searchClickCallback) {
            SearchHelper.INSTANCE.handleSearchClickCallback(homeFragment.getActivity(), new SearchClickCallback(0, searchClickCallback.getView(), -1, searchClickCallback.getCard()));
            homeFragment.reloadStored();
        }
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SearchClickCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (callback.getAction() != 1) {
            this.this$0.homeHandleSearch(callback);
            return;
        }
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            SingleSelectionHelper.INSTANCE.showOptionSelectStringRes(activity, callback.getView(), callback.getCard().getPosterUrl(), CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf((int) R.string.action_open_watching), Integer.valueOf((int) R.string.action_remove_from_bookmarks)}), CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf((int) R.string.action_open_play), Integer.valueOf((int) R.string.action_open_watching), Integer.valueOf((int) R.string.action_remove_from_bookmarks)}), new C48591(this.this$0, callback));
        }
    }
}
