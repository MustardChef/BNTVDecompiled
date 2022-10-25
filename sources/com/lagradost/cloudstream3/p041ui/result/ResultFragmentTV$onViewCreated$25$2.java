package com.lagradost.cloudstream3.p041ui.result;

import android.view.MenuItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResultFragmentTV.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Landroid/view/MenuItem;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$onViewCreated$25$2 */
/* loaded from: classes4.dex */
public final class ResultFragmentTV$onViewCreated$25$2 extends Lambda implements Function1<MenuItem, Unit> {
    final /* synthetic */ ResultFragmentTV this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultFragmentTV$onViewCreated$25$2(ResultFragmentTV resultFragmentTV) {
        super(1);
        this.this$0 = resultFragmentTV;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MenuItem menuItem) {
        invoke2(menuItem);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(MenuItem popupMenuNoIconsAndNoStringRes) {
        ResultViewModel resultViewModel;
        Intrinsics.checkNotNullParameter(popupMenuNoIconsAndNoStringRes, "$this$popupMenuNoIconsAndNoStringRes");
        resultViewModel = this.this$0.viewModel;
        if (resultViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            resultViewModel = null;
        }
        resultViewModel.changeRange(Integer.valueOf(popupMenuNoIconsAndNoStringRes.getItemId()));
    }
}
