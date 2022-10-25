package com.lagradost.cloudstream3.p041ui.home;

import androidx.fragment.app.FragmentActivity;
import com.lagradost.cloudstream3.HomePageList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: HomeFragment.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "item", "Lcom/lagradost/cloudstream3/HomePageList;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.home.HomeFragment$onViewCreated$adapter$2 */
/* loaded from: classes3.dex */
final class HomeFragment$onViewCreated$adapter$2 extends Lambda implements Function1<HomePageList, Unit> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeFragment$onViewCreated$adapter$2(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HomePageList homePageList) {
        invoke2(homePageList);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(HomePageList item) {
        Intrinsics.checkNotNullParameter(item, "item");
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            HomeFragment.Companion.loadHomepageList(activity, item);
        }
    }
}
