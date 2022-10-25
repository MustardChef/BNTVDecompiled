package com.lagradost.cloudstream3.p041ui.result;

import android.widget.TextView;
import com.bongngotv2.R;
import com.lagradost.cloudstream3.C4761R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: ResultFragmentTV.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "count", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$onViewCreated$27 */
/* loaded from: classes4.dex */
final class ResultFragmentTV$onViewCreated$27 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ ResultFragmentTV this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultFragmentTV$onViewCreated$27(ResultFragmentTV resultFragmentTV) {
        super(1);
        this.this$0 = resultFragmentTV;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ResultFragmentTV resultFragmentTV;
        int i2;
        if (i < 0) {
            TextView textView = (TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_episodes_text);
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_episodes_text);
        if (textView2 == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(' ');
        if (i == 1) {
            resultFragmentTV = this.this$0;
            i2 = R.string.episode;
        } else {
            resultFragmentTV = this.this$0;
            i2 = R.string.episodes;
        }
        sb.append(resultFragmentTV.getString(i2));
        textView2.setText(sb.toString());
    }
}
