package com.lagradost.cloudstream3.p041ui.result;

import com.lagradost.cloudstream3.p041ui.download.DownloadButtonSetup;
import com.lagradost.cloudstream3.p041ui.download.DownloadClickEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ResultFragmentTV.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "downloadClickEvent", "Lcom/lagradost/cloudstream3/ui/download/DownloadClickEvent;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$onViewCreated$adapter$2 */
/* loaded from: classes4.dex */
final class ResultFragmentTV$onViewCreated$adapter$2 extends Lambda implements Function1<DownloadClickEvent, Unit> {
    final /* synthetic */ ResultFragmentTV this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultFragmentTV$onViewCreated$adapter$2(ResultFragmentTV resultFragmentTV) {
        super(1);
        this.this$0 = resultFragmentTV;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DownloadClickEvent downloadClickEvent) {
        invoke2(downloadClickEvent);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(DownloadClickEvent downloadClickEvent) {
        String str;
        Intrinsics.checkNotNullParameter(downloadClickEvent, "downloadClickEvent");
        str = this.this$0.currentHeaderName;
        DownloadButtonSetup.INSTANCE.handleDownloadClick(this.this$0.getActivity(), str, downloadClickEvent);
    }
}
