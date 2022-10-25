package com.lagradost.cloudstream3.p041ui.result;

import android.view.View;
import com.google.android.material.button.MaterialButton;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ResultFragmentPhimHD.kt */
@Metadata(m108d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001e\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004 \u0005*\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, m107d2 = {"<anonymous>", "", "seasonList", "", "", "kotlin.jvm.PlatformType", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD$onViewCreated$11 */
/* loaded from: classes4.dex */
final class ResultFragmentPhimHD$onViewCreated$11 extends Lambda implements Function1<List<? extends Integer>, Unit> {
    final /* synthetic */ ResultFragmentPhimHD this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultFragmentPhimHD$onViewCreated$11(ResultFragmentPhimHD resultFragmentPhimHD) {
        super(1);
        this.this$0 = resultFragmentPhimHD;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Integer> list) {
        invoke2((List<Integer>) list);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:
        if ((r4.getVisibility() == 0) == true) goto L13;
     */
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void invoke2(final java.util.List<java.lang.Integer> r7) {
        /*
            r6 = this;
            com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD r0 = r6.this$0
            int r1 = com.lagradost.cloudstream3.C4761R.C4764id.result_season_button
            android.view.View r0 = r0._$_findCachedViewById(r1)
            com.google.android.material.button.MaterialButton r0 = (com.google.android.material.button.MaterialButton) r0
            if (r0 != 0) goto Ld
            goto L6c
        Ld:
            int r1 = r7.size()
            r2 = 0
            r3 = 1
            if (r1 > r3) goto L18
            r2 = 8
            goto L69
        L18:
            com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD r1 = r6.this$0
            int r4 = com.lagradost.cloudstream3.C4761R.C4764id.result_series_parent
            android.view.View r4 = r1._$_findCachedViewById(r4)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            if (r4 == 0) goto L37
            java.lang.String r5 = "result_series_parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            android.view.View r4 = (android.view.View) r4
            int r4 = r4.getVisibility()
            if (r4 != 0) goto L33
            r4 = 1
            goto L34
        L33:
            r4 = 0
        L34:
            if (r4 != r3) goto L37
            goto L38
        L37:
            r3 = 0
        L38:
            if (r3 == 0) goto L52
            int r3 = com.lagradost.cloudstream3.C4761R.C4764id.result_resume_series_button
            android.view.View r3 = r1._$_findCachedViewById(r3)
            com.google.android.material.button.MaterialButton r3 = (com.google.android.material.button.MaterialButton) r3
            android.view.View r3 = (android.view.View) r3
            int r4 = com.lagradost.cloudstream3.C4761R.C4764id.result_season_button
            android.view.View r1 = r1._$_findCachedViewById(r4)
            com.google.android.material.button.MaterialButton r1 = (com.google.android.material.button.MaterialButton) r1
            android.view.View r1 = (android.view.View) r1
            com.lagradost.cloudstream3.p041ui.result.ResultFragmentPhimHD.access$onViewCreated$setFocusUpAndDown(r3, r1)
            goto L69
        L52:
            int r3 = com.lagradost.cloudstream3.C4761R.C4764id.result_bookmark_button
            android.view.View r3 = r1._$_findCachedViewById(r3)
            com.google.android.material.button.MaterialButton r3 = (com.google.android.material.button.MaterialButton) r3
            android.view.View r3 = (android.view.View) r3
            int r4 = com.lagradost.cloudstream3.C4761R.C4764id.result_season_button
            android.view.View r1 = r1._$_findCachedViewById(r4)
            com.google.android.material.button.MaterialButton r1 = (com.google.android.material.button.MaterialButton) r1
            android.view.View r1 = (android.view.View) r1
            com.lagradost.cloudstream3.p041ui.result.ResultFragmentPhimHD.access$onViewCreated$setFocusUpAndDown(r3, r1)
        L69:
            r0.setVisibility(r2)
        L6c:
            com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD r0 = r6.this$0
            int r1 = com.lagradost.cloudstream3.C4761R.C4764id.result_season_button
            android.view.View r0 = r0._$_findCachedViewById(r1)
            com.google.android.material.button.MaterialButton r0 = (com.google.android.material.button.MaterialButton) r0
            if (r0 == 0) goto L82
            com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD r1 = r6.this$0
            com.lagradost.cloudstream3.ui.result.-$$Lambda$ResultFragmentPhimHD$onViewCreated$11$8wUhpuxGdEzc-jEBk3Prj_pT0kQ r2 = new com.lagradost.cloudstream3.ui.result.-$$Lambda$ResultFragmentPhimHD$onViewCreated$11$8wUhpuxGdEzc-jEBk3Prj_pT0kQ
            r2.<init>()
            r0.setOnClickListener(r2)
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.result.ResultFragmentPhimHD$onViewCreated$11.invoke2(java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final void m8783invoke$lambda2(ResultFragmentPhimHD this$0, List seasonList, View view) {
        String fromIndexToSeasonText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MaterialButton materialButton = (MaterialButton) this$0._$_findCachedViewById(C4761R.C4764id.result_season_button);
        if (materialButton != null) {
            UIHelper uIHelper = UIHelper.INSTANCE;
            MaterialButton materialButton2 = materialButton;
            Intrinsics.checkNotNullExpressionValue(seasonList, "seasonList");
            List<Integer> list = seasonList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Integer num : list) {
                Integer valueOf = Integer.valueOf(num != null ? num.intValue() : -2);
                fromIndexToSeasonText = this$0.fromIndexToSeasonText(num);
                arrayList.add(new Tuples(valueOf, fromIndexToSeasonText));
            }
            uIHelper.popupMenuNoIconsAndNoStringRes(materialButton2, arrayList, new ResultFragmentPhimHD$onViewCreated$11$2$2(this$0));
        }
    }
}
