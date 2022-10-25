package com.lagradost.cloudstream3.p041ui.home;

import androidx.recyclerview.widget.RecyclerView;
import com.lagradost.cloudstream3.C4761R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeFragment.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "dx", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.home.HomeFragment$onViewCreated$4$2$1$1 */
/* loaded from: classes3.dex */
public final class HomeFragment$onViewCreated$4$2$1$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeFragment$onViewCreated$4$2$1$1(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final int i) {
        RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C4761R.C4764id.home_main_poster_recyclerview);
        if (recyclerView != null) {
            final HomeFragment homeFragment = this.this$0;
            recyclerView.post(new Runnable() { // from class: com.lagradost.cloudstream3.ui.home.-$$Lambda$HomeFragment$onViewCreated$4$2$1$1$XcfOiagyOxri80t7Jgt6ZcJCjnM
                @Override // java.lang.Runnable
                public final void run() {
                    HomeFragment$onViewCreated$4$2$1$1.m8655invoke$lambda0(HomeFragment.this, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m8655invoke$lambda0(HomeFragment this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = (RecyclerView) this$0._$_findCachedViewById(C4761R.C4764id.home_main_poster_recyclerview);
        if (recyclerView != null) {
            recyclerView.smoothScrollBy(i, 0);
        }
    }
}
