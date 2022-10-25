package com.lagradost.cloudstream3.p041ui.player;

import android.content.Context;
import android.content.SharedPreferences;
import com.bongngotv2.R;
import com.lagradost.cloudstream3.p041ui.player.CustomDecoder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GeneratorPlayer.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.GeneratorPlayer$showMirrorsDialogue$1$11$2 */
/* loaded from: classes3.dex */
public final class GeneratorPlayer$showMirrorsDialogue$1$11$2 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ Context $ctx;
    final /* synthetic */ boolean $isPlaying;
    final /* synthetic */ String[] $prefValues;
    final /* synthetic */ SharedPreferences $settingsManager;
    final /* synthetic */ GeneratorPlayer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GeneratorPlayer$showMirrorsDialogue$1$11$2(SharedPreferences sharedPreferences, Context context, String[] strArr, GeneratorPlayer generatorPlayer, boolean z) {
        super(1);
        this.$settingsManager = sharedPreferences;
        this.$ctx = context;
        this.$prefValues = strArr;
        this.this$0 = generatorPlayer;
        this.$isPlaying = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        this.$settingsManager.edit().putString(this.$ctx.getString(R.string.subtitles_encoding_key), this.$prefValues[i]).apply();
        CustomDecoder.Companion companion = CustomDecoder.Companion;
        Context ctx = this.$ctx;
        Intrinsics.checkNotNullExpressionValue(ctx, "ctx");
        companion.updateForcedEncoding(ctx);
        GeneratorPlayer.m8725showMirrorsDialogue$lambda30$dismiss(this.$isPlaying, this.this$0);
        this.this$0.getPlayer().seekTime(-1L);
    }
}
