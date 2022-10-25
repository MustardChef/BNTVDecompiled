package com.lagradost.cloudstream3.p041ui.download;

import android.widget.ImageView;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EasyDownloadButton.kt */
@Metadata(m108d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, m107d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.download.EasyDownloadButton$setUpMoreButton$1 */
/* loaded from: classes3.dex */
public final class EasyDownloadButton$setUpMoreButton$1 extends Lambda implements Function1<Tuples<? extends Integer, ? extends String>, Unit> {
    final /* synthetic */ ImageView $downloadImage;
    final /* synthetic */ TextView $textView;
    final /* synthetic */ TextView $textViewProgress;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EasyDownloadButton$setUpMoreButton$1(ImageView imageView, TextView textView, TextView textView2) {
        super(1);
        this.$downloadImage = imageView;
        this.$textViewProgress = textView;
        this.$textView = textView2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Tuples<? extends Integer, ? extends String> tuples) {
        invoke2((Tuples<Integer, String>) tuples);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Tuples<Integer, String> tuples) {
        Intrinsics.checkNotNullParameter(tuples, "<name for destructuring parameter 0>");
        int intValue = tuples.component1().intValue();
        String component2 = tuples.component2();
        ImageView imageView = this.$downloadImage;
        TextView textView = this.$textViewProgress;
        boolean z = true;
        if (textView != null && textView.getVisibility() != 8) {
            z = false;
        }
        imageView.setVisibility(z ? 0 : 8);
        this.$downloadImage.setImageResource(intValue);
        TextView textView2 = this.$textView;
        if (textView2 == null) {
            return;
        }
        textView2.setText(component2);
    }
}
