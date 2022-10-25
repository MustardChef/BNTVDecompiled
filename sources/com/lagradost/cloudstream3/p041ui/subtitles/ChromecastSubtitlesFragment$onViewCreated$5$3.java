package com.lagradost.cloudstream3.p041ui.subtitles;

import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChromecastSubtitlesFragment.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", FirebaseAnalytics.Param.INDEX, "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.subtitles.ChromecastSubtitlesFragment$onViewCreated$5$3 */
/* loaded from: classes4.dex */
public final class ChromecastSubtitlesFragment$onViewCreated$5$3 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ List<Tuples<Float, String>> $fontSizes;
    final /* synthetic */ ChromecastSubtitlesFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChromecastSubtitlesFragment$onViewCreated$5$3(ChromecastSubtitlesFragment chromecastSubtitlesFragment, List<Tuples<Float, String>> list) {
        super(1);
        this.this$0 = chromecastSubtitlesFragment;
        this.$fontSizes = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        SaveChromeCaptionStyle saveChromeCaptionStyle;
        saveChromeCaptionStyle = this.this$0.state;
        if (saveChromeCaptionStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            saveChromeCaptionStyle = null;
        }
        List<Tuples<Float, String>> list = this.$fontSizes;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(((Number) ((Tuples) it.next()).getFirst()).floatValue()));
        }
        saveChromeCaptionStyle.setFontScale(((Number) arrayList.get(i)).floatValue());
    }
}
