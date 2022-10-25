package com.lagradost.cloudstream3.p041ui.result;

import com.discord.panels.OverlappingPanelsLayout;
import com.lagradost.cloudstream3.C4761R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: ResultFragmentTV.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "action", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$onViewCreated$imgAdapter$1 */
/* loaded from: classes4.dex */
final class ResultFragmentTV$onViewCreated$imgAdapter$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ ResultFragmentTV this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultFragmentTV$onViewCreated$imgAdapter$1(ResultFragmentTV resultFragmentTV) {
        super(1);
        this.this$0 = resultFragmentTV;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        OverlappingPanelsLayout.Panel selectedPanel;
        boolean z = true;
        if (i == 0 || i == 1) {
            OverlappingPanelsLayout overlappingPanelsLayout = (OverlappingPanelsLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.result_overlapping_panels);
            if ((overlappingPanelsLayout == null || (selectedPanel = overlappingPanelsLayout.getSelectedPanel()) == null || selectedPanel.ordinal() != 1) ? false : false) {
                OverlappingPanelsLayout overlappingPanelsLayout2 = (OverlappingPanelsLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.result_overlapping_panels);
                if (overlappingPanelsLayout2 != null) {
                    overlappingPanelsLayout2.openStartPanel();
                    return;
                }
                return;
            }
            OverlappingPanelsLayout overlappingPanelsLayout3 = (OverlappingPanelsLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.result_overlapping_panels);
            if (overlappingPanelsLayout3 != null) {
                overlappingPanelsLayout3.closePanels();
            }
        }
    }
}
