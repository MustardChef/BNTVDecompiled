package com.lagradost.cloudstream3.p041ui.subtitles;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubtitlesFragment.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", FirebaseAnalytics.Param.INDEX, "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.subtitles.SubtitlesFragment$onViewCreated$11$3 */
/* loaded from: classes4.dex */
public final class SubtitlesFragment$onViewCreated$11$3 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ List<Tuples<Integer, String>> $fontTypes;
    final /* synthetic */ List<File> $savedFontTypes;
    final /* synthetic */ View $textView;
    final /* synthetic */ SubtitlesFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SubtitlesFragment$onViewCreated$11$3(List<Tuples<Integer, String>> list, SubtitlesFragment subtitlesFragment, List<? extends File> list2, View view) {
        super(1);
        this.$fontTypes = list;
        this.this$0 = subtitlesFragment;
        this.$savedFontTypes = list2;
        this.$textView = view;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        SaveCaptionStyle saveCaptionStyle;
        SaveCaptionStyle saveCaptionStyle2;
        SaveCaptionStyle saveCaptionStyle3;
        SaveCaptionStyle saveCaptionStyle4;
        if (i < this.$fontTypes.size()) {
            saveCaptionStyle3 = this.this$0.state;
            if (saveCaptionStyle3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
                saveCaptionStyle3 = null;
            }
            saveCaptionStyle3.setTypeface(this.$fontTypes.get(i).getFirst());
            saveCaptionStyle4 = this.this$0.state;
            if (saveCaptionStyle4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
                saveCaptionStyle4 = null;
            }
            saveCaptionStyle4.setTypefaceFilePath(null);
        } else {
            saveCaptionStyle = this.this$0.state;
            if (saveCaptionStyle == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
                saveCaptionStyle = null;
            }
            saveCaptionStyle.setTypefaceFilePath(this.$savedFontTypes.get(i - this.$fontTypes.size()).getAbsolutePath());
            saveCaptionStyle2 = this.this$0.state;
            if (saveCaptionStyle2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
                saveCaptionStyle2 = null;
            }
            saveCaptionStyle2.setTypeface(null);
        }
        SubtitlesFragment subtitlesFragment = this.this$0;
        Context context = ((TextView) this.$textView).getContext();
        Intrinsics.checkNotNullExpressionValue(context, "textView.context");
        subtitlesFragment.updateState(context);
    }
}
