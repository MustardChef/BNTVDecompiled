package com.lagradost.cloudstream3.p041ui.result;

import com.google.android.material.button.MaterialButton;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.DubStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ResultFragmentTV.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "status", "Lcom/lagradost/cloudstream3/DubStatus;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$onViewCreated$21 */
/* loaded from: classes4.dex */
final class ResultFragmentTV$onViewCreated$21 extends Lambda implements Function1<DubStatus, Unit> {
    final /* synthetic */ ResultFragmentTV this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultFragmentTV$onViewCreated$21(ResultFragmentTV resultFragmentTV) {
        super(1);
        this.this$0 = resultFragmentTV;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DubStatus dubStatus) {
        invoke2(dubStatus);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(DubStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        MaterialButton materialButton = (MaterialButton) this.this$0._$_findCachedViewById(C4761R.C4764id.result_dub_select);
        if (materialButton == null) {
            return;
        }
        materialButton.setText(status.toString());
    }
}
