package com.lagradost.cloudstream3.p041ui.result;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bongngotv2.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.p041ui.WatchType;
import com.lagradost.cloudstream3.utils.SingleSelectionHelper;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ResultFragmentPhimHD.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "watchType", "Lcom/lagradost/cloudstream3/ui/WatchType;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD$onViewCreated$9 */
/* loaded from: classes4.dex */
final class ResultFragmentPhimHD$onViewCreated$9 extends Lambda implements Function1<WatchType, Unit> {
    final /* synthetic */ ResultFragmentPhimHD this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultFragmentPhimHD$onViewCreated$9(ResultFragmentPhimHD resultFragmentPhimHD) {
        super(1);
        this.this$0 = resultFragmentPhimHD;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WatchType watchType) {
        invoke2(watchType);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(final WatchType watchType) {
        Context context;
        Context context2;
        Intrinsics.checkNotNullParameter(watchType, "watchType");
        MaterialButton materialButton = (MaterialButton) this.this$0._$_findCachedViewById(C4761R.C4764id.result_bookmark_button);
        if (materialButton != null) {
            materialButton.setText(this.this$0.getString(watchType.getStringRes()));
        }
        ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) this.this$0._$_findCachedViewById(C4761R.C4764id.result_bookmark_fab);
        if (extendedFloatingActionButton != null) {
            extendedFloatingActionButton.setText(this.this$0.getString(watchType.getStringRes()));
        }
        Integer num = null;
        if (watchType == WatchType.NONE) {
            ExtendedFloatingActionButton extendedFloatingActionButton2 = (ExtendedFloatingActionButton) this.this$0._$_findCachedViewById(C4761R.C4764id.result_bookmark_fab);
            if (extendedFloatingActionButton2 != null && (context2 = extendedFloatingActionButton2.getContext()) != null) {
                num = Integer.valueOf(UIHelper.INSTANCE.colorFromAttribute(context2, R.attr.white));
            }
        } else {
            ExtendedFloatingActionButton extendedFloatingActionButton3 = (ExtendedFloatingActionButton) this.this$0._$_findCachedViewById(C4761R.C4764id.result_bookmark_fab);
            if (extendedFloatingActionButton3 != null && (context = extendedFloatingActionButton3.getContext()) != null) {
                num = Integer.valueOf(UIHelper.INSTANCE.colorFromAttribute(context, R.attr.colorPrimary));
            }
        }
        if (num != null) {
            ResultFragmentPhimHD resultFragmentPhimHD = this.this$0;
            ColorStateList valueOf = ColorStateList.valueOf(num.intValue());
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(it)");
            ExtendedFloatingActionButton extendedFloatingActionButton4 = (ExtendedFloatingActionButton) resultFragmentPhimHD._$_findCachedViewById(C4761R.C4764id.result_bookmark_fab);
            if (extendedFloatingActionButton4 != null) {
                extendedFloatingActionButton4.setIconTint(valueOf);
            }
            ExtendedFloatingActionButton extendedFloatingActionButton5 = (ExtendedFloatingActionButton) resultFragmentPhimHD._$_findCachedViewById(C4761R.C4764id.result_bookmark_fab);
            if (extendedFloatingActionButton5 != null) {
                extendedFloatingActionButton5.setTextColor(valueOf);
            }
        }
        ExtendedFloatingActionButton extendedFloatingActionButton6 = (ExtendedFloatingActionButton) this.this$0._$_findCachedViewById(C4761R.C4764id.result_bookmark_fab);
        if (extendedFloatingActionButton6 != null) {
            final ResultFragmentPhimHD resultFragmentPhimHD2 = this.this$0;
            extendedFloatingActionButton6.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$ResultFragmentPhimHD$onViewCreated$9$vIjwo0bcdhkx8yPjFy_EHKMD4KE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResultFragmentPhimHD$onViewCreated$9.m8803invoke$lambda2(ResultFragmentPhimHD.this, watchType, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final void m8803invoke$lambda2(ResultFragmentPhimHD this$0, WatchType watchType, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(watchType, "$watchType");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            SingleSelectionHelper singleSelectionHelper = SingleSelectionHelper.INSTANCE;
            FragmentActivity fragmentActivity = activity;
            WatchType[] values = WatchType.values();
            ArrayList arrayList = new ArrayList(values.length);
            for (WatchType watchType2 : values) {
                arrayList.add(view.getContext().getString(watchType2.getStringRes()));
            }
            List<String> list = CollectionsKt.toList(arrayList);
            int ordinal = watchType.ordinal();
            String string = view.getContext().getString(R.string.action_add_to_bookmarks);
            Intrinsics.checkNotNullExpressionValue(string, "fab.context.getString(R.….action_add_to_bookmarks)");
            singleSelectionHelper.showBottomDialog(fragmentActivity, list, ordinal, string, false, ResultFragmentPhimHD$onViewCreated$9$2$2.INSTANCE, new ResultFragmentPhimHD$onViewCreated$9$2$3(this$0));
        }
    }
}
