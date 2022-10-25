package com.lagradost.cloudstream3.p041ui.result;

import androidx.fragment.app.FragmentActivity;
import com.lagradost.cloudstream3.MainActivity;
import com.lagradost.cloudstream3.p041ui.download.DownloadButtonSetup;
import com.lagradost.cloudstream3.p041ui.download.DownloadClickEvent;
import com.phimhd.AppController;
import com.phimhd.Key;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ResultFragmentPhimHD.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "downloadClickEvent", "Lcom/lagradost/cloudstream3/ui/download/DownloadClickEvent;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD$onViewCreated$adapter$2 */
/* loaded from: classes4.dex */
final class ResultFragmentPhimHD$onViewCreated$adapter$2 extends Lambda implements Function1<DownloadClickEvent, Unit> {
    final /* synthetic */ ResultFragmentPhimHD this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultFragmentPhimHD$onViewCreated$adapter$2(ResultFragmentPhimHD resultFragmentPhimHD) {
        super(1);
        this.this$0 = resultFragmentPhimHD;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DownloadClickEvent downloadClickEvent) {
        invoke2(downloadClickEvent);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(DownloadClickEvent downloadClickEvent) {
        Key key;
        String str;
        Intrinsics.checkNotNullParameter(downloadClickEvent, "downloadClickEvent");
        AppController companion = AppController.Companion.getInstance();
        if ((companion != null ? companion.getKey() : null) != null) {
            AppController companion2 = AppController.Companion.getInstance();
            if (companion2 == null || (key = companion2.getKey()) == null) {
                return;
            }
            ResultFragmentPhimHD resultFragmentPhimHD = this.this$0;
            if (!key.isExpired()) {
                str = resultFragmentPhimHD.currentHeaderName;
                DownloadButtonSetup.INSTANCE.handleDownloadClick(resultFragmentPhimHD.getActivity(), str, downloadClickEvent);
                return;
            }
            FragmentActivity activity = resultFragmentPhimHD.getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.lagradost.cloudstream3.MainActivity");
            ((MainActivity) activity).showDialogUpgrade();
            return;
        }
        FragmentActivity activity2 = this.this$0.getActivity();
        Objects.requireNonNull(activity2, "null cannot be cast to non-null type com.lagradost.cloudstream3.MainActivity");
        ((MainActivity) activity2).showDialogUpgrade();
    }
}
