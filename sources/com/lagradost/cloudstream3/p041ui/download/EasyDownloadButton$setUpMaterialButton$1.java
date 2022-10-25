package com.lagradost.cloudstream3.p041ui.download;

import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: EasyDownloadButton.kt */
@Metadata(m108d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, m107d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.download.EasyDownloadButton$setUpMaterialButton$1 */
/* loaded from: classes3.dex */
final class EasyDownloadButton$setUpMaterialButton$1 extends Lambda implements Function1<Tuples<? extends Integer, ? extends String>, Unit> {
    final /* synthetic */ MaterialButton $downloadButton;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EasyDownloadButton$setUpMaterialButton$1(MaterialButton materialButton) {
        super(1);
        this.$downloadButton = materialButton;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Tuples<? extends Integer, ? extends String> tuples) {
        invoke2((Tuples<Integer, String>) tuples);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Tuples<Integer, String> it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this.$downloadButton.setIconResource(it.getFirst().intValue());
        this.$downloadButton.setText(it.getSecond());
    }
}
