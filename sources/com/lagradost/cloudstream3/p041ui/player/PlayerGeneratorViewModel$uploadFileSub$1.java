package com.lagradost.cloudstream3.p041ui.player;

import android.util.Log;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PlayerGeneratorViewModel.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "subtitleFile", "Lcom/lagradost/cloudstream3/SubtitleFile;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.PlayerGeneratorViewModel$uploadFileSub$1 */
/* loaded from: classes3.dex */
public final class PlayerGeneratorViewModel$uploadFileSub$1 extends Lambda implements Function1<SubtitleFile, Unit> {
    final /* synthetic */ Function1<SubtitleData, Unit> $callback;
    final /* synthetic */ PlayerGeneratorViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PlayerGeneratorViewModel$uploadFileSub$1(PlayerGeneratorViewModel playerGeneratorViewModel, Function1<? super SubtitleData, Unit> function1) {
        super(1);
        this.this$0 = playerGeneratorViewModel;
        this.$callback = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SubtitleFile subtitleFile) {
        invoke2(subtitleFile);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SubtitleFile subtitleFile) {
        IGenerator iGenerator;
        LoadResponse loadResponse;
        if (subtitleFile != null) {
            PlayerGeneratorViewModel playerGeneratorViewModel = this.this$0;
            Function1<SubtitleData, Unit> function1 = this.$callback;
            StringBuilder sb = new StringBuilder();
            sb.append("Vietsub ");
            iGenerator = playerGeneratorViewModel.generator;
            sb.append((iGenerator == null || (loadResponse = iGenerator.getLoadResponse()) == null) ? null : loadResponse.getName());
            sb.append(' ');
            sb.append(System.currentTimeMillis());
            SubtitleData subtitleData = new SubtitleData(sb.toString(), subtitleFile.getUrl(), SubtitleOrigin.URL, PlayerSubtitleHelper.Companion.toSubtitleMimeType(subtitleFile.getUrl()), false);
            Log.d("BLUE", "auto choose " + subtitleData);
            function1.invoke(subtitleData);
        }
    }
}
