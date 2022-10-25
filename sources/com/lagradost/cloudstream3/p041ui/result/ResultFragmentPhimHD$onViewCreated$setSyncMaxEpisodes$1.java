package com.lagradost.cloudstream3.p041ui.result;

import android.content.Context;
import android.widget.TextView;
import com.bongngotv2.R;
import com.lagradost.cloudstream3.C4761R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResultFragmentPhimHD.kt */
@Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD$onViewCreated$setSyncMaxEpisodes$1 */
/* loaded from: classes4.dex */
public final class ResultFragmentPhimHD$onViewCreated$setSyncMaxEpisodes$1 extends Lambda implements Functions<Unit> {
    final /* synthetic */ Integer $totalEpisodes;
    final /* synthetic */ ResultFragmentPhimHD this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultFragmentPhimHD$onViewCreated$setSyncMaxEpisodes$1(ResultFragmentPhimHD resultFragmentPhimHD, Integer num) {
        super(0);
        this.this$0 = resultFragmentPhimHD;
        this.$totalEpisodes = num;
    }

    @Override // kotlin.jvm.functions.Functions
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Functions
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        String string;
        String str;
        String string2;
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_sync_max_episodes);
        Context context = textView != null ? textView.getContext() : null;
        TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_sync_max_episodes);
        if (textView2 == null) {
            return;
        }
        Integer num = this.$totalEpisodes;
        if (num != null) {
            int intValue = num.intValue();
            if (context == null || (string2 = context.getString(R.string.sync_total_episodes_some)) == null) {
                str = null;
            } else {
                str = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(intValue)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
            }
            if (str != null) {
                string = str;
                textView2.setText(string);
            }
        }
        string = context != null ? context.getString(R.string.sync_total_episodes_none) : null;
        textView2.setText(string);
    }
}
