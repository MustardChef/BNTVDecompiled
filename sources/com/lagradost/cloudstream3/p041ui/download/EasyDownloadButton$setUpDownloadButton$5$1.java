package com.lagradost.cloudstream3.p041ui.download;

import android.view.MenuItem;
import com.lagradost.cloudstream3.p041ui.download.EasyDownloadButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EasyDownloadButton.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Landroid/view/MenuItem;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.download.EasyDownloadButton$setUpDownloadButton$5$1 */
/* loaded from: classes3.dex */
public final class EasyDownloadButton$setUpDownloadButton$5$1 extends Lambda implements Function1<MenuItem, Unit> {
    final /* synthetic */ Function1<DownloadClickEvent, Unit> $clickCallback;
    final /* synthetic */ EasyDownloadButton.IMinimumData $data;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EasyDownloadButton$setUpDownloadButton$5$1(Function1<? super DownloadClickEvent, Unit> function1, EasyDownloadButton.IMinimumData iMinimumData) {
        super(1);
        this.$clickCallback = function1;
        this.$data = iMinimumData;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MenuItem menuItem) {
        invoke2(menuItem);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(MenuItem popupMenuNoIcons) {
        Intrinsics.checkNotNullParameter(popupMenuNoIcons, "$this$popupMenuNoIcons");
        this.$clickCallback.invoke(new DownloadClickEvent(popupMenuNoIcons.getItemId(), this.$data));
    }
}
