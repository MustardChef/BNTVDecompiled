package com.lagradost.cloudstream3.p041ui.subtitles;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.utils.UIHelper;
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
/* compiled from: SubtitlesFragment.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", FirebaseAnalytics.Param.INDEX, "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.subtitles.SubtitlesFragment$onViewCreated$3$3 */
/* loaded from: classes4.dex */
public final class SubtitlesFragment$onViewCreated$3$3 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ List<Tuples<Integer, String>> $elevationTypes;
    final /* synthetic */ View $textView;
    final /* synthetic */ SubtitlesFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubtitlesFragment$onViewCreated$3$3(SubtitlesFragment subtitlesFragment, List<Tuples<Integer, String>> list, View view) {
        super(1);
        this.this$0 = subtitlesFragment;
        this.$elevationTypes = list;
        this.$textView = view;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        SaveCaptionStyle saveCaptionStyle;
        boolean z;
        FragmentActivity activity;
        saveCaptionStyle = this.this$0.state;
        if (saveCaptionStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            saveCaptionStyle = null;
        }
        List<Tuples<Integer, String>> list = this.$elevationTypes;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((Number) ((Tuples) it.next()).getFirst()).intValue()));
        }
        saveCaptionStyle.setElevation(((Number) arrayList.get(i)).intValue());
        SubtitlesFragment subtitlesFragment = this.this$0;
        Context context = ((TextView) this.$textView).getContext();
        Intrinsics.checkNotNullExpressionValue(context, "textView.context");
        subtitlesFragment.updateState(context);
        z = this.this$0.hide;
        if (!z || (activity = this.this$0.getActivity()) == null) {
            return;
        }
        UIHelper.INSTANCE.hideSystemUI(activity);
    }
}
