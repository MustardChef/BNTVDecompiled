package com.lagradost.cloudstream3.p041ui.result;

import android.content.Context;
import android.widget.TextView;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResultFragmentTV.kt */
@Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$setFormatText$1 */
/* loaded from: classes4.dex */
public final class ResultFragmentTV$setFormatText$1 extends Lambda implements Functions<Unit> {
    final /* synthetic */ Object $arg;
    final /* synthetic */ int $format;
    final /* synthetic */ TextView $textView;
    final /* synthetic */ ResultFragmentTV this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultFragmentTV$setFormatText$1(Object obj, TextView textView, ResultFragmentTV resultFragmentTV, int i) {
        super(0);
        this.$arg = obj;
        this.$textView = textView;
        this.this$0 = resultFragmentTV;
        this.$format = i;
    }

    @Override // kotlin.jvm.functions.Functions
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Functions
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        String str;
        String string;
        if (this.$arg == null) {
            TextView textView = this.$textView;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            return;
        }
        Context context = this.this$0.getContext();
        if (context == null || (string = context.getString(this.$format)) == null) {
            str = null;
        } else {
            str = String.format(string, Arrays.copyOf(new Object[]{this.$arg}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
        }
        if (str == null) {
            TextView textView2 = this.$textView;
            if (textView2 == null) {
                return;
            }
            textView2.setVisibility(8);
            return;
        }
        TextView textView3 = this.$textView;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        TextView textView4 = this.$textView;
        if (textView4 == null) {
            return;
        }
        textView4.setText(str);
    }
}
