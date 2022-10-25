package com.lagradost.cloudstream3.p041ui.result;

import android.view.MenuItem;
import com.lagradost.cloudstream3.p041ui.WatchType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResultFragmentPhimHD.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Landroid/view/MenuItem;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD$onViewCreated$8$2 */
/* loaded from: classes4.dex */
public final class ResultFragmentPhimHD$onViewCreated$8$2 extends Lambda implements Function1<MenuItem, Unit> {
    final /* synthetic */ ResultFragmentPhimHD this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultFragmentPhimHD$onViewCreated$8$2(ResultFragmentPhimHD resultFragmentPhimHD) {
        super(1);
        this.this$0 = resultFragmentPhimHD;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MenuItem menuItem) {
        invoke2(menuItem);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(MenuItem popupMenuNoIcons) {
        ResultViewModel resultViewModel;
        Intrinsics.checkNotNullParameter(popupMenuNoIcons, "$this$popupMenuNoIcons");
        resultViewModel = this.this$0.viewModel;
        if (resultViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            resultViewModel = null;
        }
        resultViewModel.updateWatchStatus(WatchType.Companion.fromInternalId(Integer.valueOf(popupMenuNoIcons.getItemId())));
    }
}
