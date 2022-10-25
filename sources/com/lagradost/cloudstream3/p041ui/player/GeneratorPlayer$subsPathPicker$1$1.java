package com.lagradost.cloudstream3.p041ui.player;

import android.content.Context;
import android.net.Uri;
import com.hippo.unifile.UniFile;
import com.lagradost.cloudstream3.AcraApplication;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GeneratorPlayer.kt */
@Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.GeneratorPlayer$subsPathPicker$1$1 */
/* loaded from: classes3.dex */
public final class GeneratorPlayer$subsPathPicker$1$1 extends Lambda implements Functions<Unit> {
    final /* synthetic */ Uri $uri;
    final /* synthetic */ GeneratorPlayer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GeneratorPlayer$subsPathPicker$1$1(Uri uri, GeneratorPlayer generatorPlayer) {
        super(0);
        this.$uri = uri;
        this.this$0 = generatorPlayer;
    }

    @Override // kotlin.jvm.functions.Functions
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Functions
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$uri == null) {
            return;
        }
        Context context = this.this$0.getContext();
        if (context == null && (context = AcraApplication.Companion.getContext()) == null) {
            return;
        }
        context.getContentResolver().takePersistableUriPermission(this.$uri, 3);
        UniFile fromUri = UniFile.fromUri(context, this.$uri);
        System.out.println((Object) ("Loaded subtitle file. Selected URI path: " + this.$uri + " - Name: " + fromUri.getName()));
        String name = fromUri.getName();
        if (name == null) {
            name = this.$uri.toString();
        }
        String str = name;
        Intrinsics.checkNotNullExpressionValue(str, "file.name ?: uri.toString()");
        String uri = this.$uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "uri.toString()");
        this.this$0.addAndSelectSubtitles(new SubtitleData(str, uri, SubtitleOrigin.DOWNLOADED_FILE, PlayerSubtitleHelper.Companion.toSubtitleMimeType(str), null, 16, null));
    }
}
