package com.lagradost.cloudstream3.p041ui.player;

import android.app.Dialog;
import androidx.appcompat.widget.SearchView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.C4761R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GeneratorPlayer.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", FirebaseAnalytics.Param.INDEX, "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.GeneratorPlayer$openOnlineSubPicker$4$3 */
/* loaded from: classes3.dex */
public final class GeneratorPlayer$openOnlineSubPicker$4$3 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ Ref.ObjectRef<String> $currentLanguageTwoLetters;
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ List<String> $lang639_1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GeneratorPlayer$openOnlineSubPicker$4$3(Ref.ObjectRef<String> objectRef, List<String> list, Dialog dialog) {
        super(1);
        this.$currentLanguageTwoLetters = objectRef;
        this.$lang639_1 = list;
        this.$dialog = dialog;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Object] */
    public final void invoke(int i) {
        this.$currentLanguageTwoLetters.element = this.$lang639_1.get(i);
        ((SearchView) this.$dialog.findViewById(C4761R.C4764id.subtitles_search)).setQuery(((SearchView) this.$dialog.findViewById(C4761R.C4764id.subtitles_search)).getQuery(), true);
    }
}
