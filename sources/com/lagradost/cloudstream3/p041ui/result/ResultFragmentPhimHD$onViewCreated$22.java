package com.lagradost.cloudstream3.p041ui.result;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.lagradost.cloudstream3.DubStatus;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: ResultFragmentPhimHD.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", SessionDescription.ATTR_RANGE, "", "Lcom/lagradost/cloudstream3/DubStatus;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD$onViewCreated$22 */
/* loaded from: classes4.dex */
final class ResultFragmentPhimHD$onViewCreated$22 extends Lambda implements Function1<Set<? extends DubStatus>, Unit> {
    final /* synthetic */ ResultFragmentPhimHD this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultFragmentPhimHD$onViewCreated$22(ResultFragmentPhimHD resultFragmentPhimHD) {
        super(1);
        this.this$0 = resultFragmentPhimHD;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Set<? extends DubStatus> set) {
        invoke2(set);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void invoke2(java.util.Set<? extends com.lagradost.cloudstream3.DubStatus> r4) {
        /*
            r3 = this;
            java.lang.String r0 = "range"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD r0 = r3.this$0
            com.lagradost.cloudstream3.p041ui.result.ResultFragmentPhimHD.access$setDubRange$p(r0, r4)
            com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD r0 = r3.this$0
            int r1 = com.lagradost.cloudstream3.C4761R.C4764id.result_dub_select
            android.view.View r0 = r0._$_findCachedViewById(r1)
            com.google.android.material.button.MaterialButton r0 = (com.google.android.material.button.MaterialButton) r0
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L19
            goto L26
        L19:
            int r4 = r4.size()
            if (r4 > r2) goto L22
            r4 = 8
            goto L23
        L22:
            r4 = 0
        L23:
            r0.setVisibility(r4)
        L26:
            com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD r4 = r3.this$0
            int r0 = com.lagradost.cloudstream3.C4761R.C4764id.result_season_button
            android.view.View r4 = r4._$_findCachedViewById(r0)
            com.google.android.material.button.MaterialButton r4 = (com.google.android.material.button.MaterialButton) r4
            if (r4 == 0) goto L41
            android.view.View r4 = (android.view.View) r4
            int r4 = r4.getVisibility()
            if (r4 != 0) goto L3c
            r4 = 1
            goto L3d
        L3c:
            r4 = 0
        L3d:
            if (r4 != r2) goto L41
            r4 = 1
            goto L42
        L41:
            r4 = 0
        L42:
            if (r4 != 0) goto Lb5
            com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD r4 = r3.this$0
            int r0 = com.lagradost.cloudstream3.C4761R.C4764id.result_episode_select
            android.view.View r4 = r4._$_findCachedViewById(r0)
            com.google.android.material.button.MaterialButton r4 = (com.google.android.material.button.MaterialButton) r4
            if (r4 == 0) goto L5f
            android.view.View r4 = (android.view.View) r4
            int r4 = r4.getVisibility()
            if (r4 != 0) goto L5a
            r4 = 1
            goto L5b
        L5a:
            r4 = 0
        L5b:
            if (r4 != r2) goto L5f
            r4 = 1
            goto L60
        L5f:
            r4 = 0
        L60:
            if (r4 != 0) goto Lb5
            com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD r4 = r3.this$0
            int r0 = com.lagradost.cloudstream3.C4761R.C4764id.result_series_parent
            android.view.View r4 = r4._$_findCachedViewById(r0)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            if (r4 == 0) goto L7c
            android.view.View r4 = (android.view.View) r4
            int r4 = r4.getVisibility()
            if (r4 != 0) goto L78
            r4 = 1
            goto L79
        L78:
            r4 = 0
        L79:
            if (r4 != r2) goto L7c
            r1 = 1
        L7c:
            if (r1 == 0) goto L9a
            com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD r4 = r3.this$0
            int r0 = com.lagradost.cloudstream3.C4761R.C4764id.result_resume_series_button
            android.view.View r4 = r4._$_findCachedViewById(r0)
            com.google.android.material.button.MaterialButton r4 = (com.google.android.material.button.MaterialButton) r4
            android.view.View r4 = (android.view.View) r4
            com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD r0 = r3.this$0
            int r1 = com.lagradost.cloudstream3.C4761R.C4764id.result_dub_select
            android.view.View r0 = r0._$_findCachedViewById(r1)
            com.google.android.material.button.MaterialButton r0 = (com.google.android.material.button.MaterialButton) r0
            android.view.View r0 = (android.view.View) r0
            com.lagradost.cloudstream3.p041ui.result.ResultFragmentPhimHD.access$onViewCreated$setFocusUpAndDown(r4, r0)
            goto Lb5
        L9a:
            com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD r4 = r3.this$0
            int r0 = com.lagradost.cloudstream3.C4761R.C4764id.result_bookmark_button
            android.view.View r4 = r4._$_findCachedViewById(r0)
            com.google.android.material.button.MaterialButton r4 = (com.google.android.material.button.MaterialButton) r4
            android.view.View r4 = (android.view.View) r4
            com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD r0 = r3.this$0
            int r1 = com.lagradost.cloudstream3.C4761R.C4764id.result_dub_select
            android.view.View r0 = r0._$_findCachedViewById(r1)
            com.google.android.material.button.MaterialButton r0 = (com.google.android.material.button.MaterialButton) r0
            android.view.View r0 = (android.view.View) r0
            com.lagradost.cloudstream3.p041ui.result.ResultFragmentPhimHD.access$onViewCreated$setFocusUpAndDown(r4, r0)
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.result.ResultFragmentPhimHD$onViewCreated$22.invoke2(java.util.Set):void");
    }
}
