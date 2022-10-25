package com.lagradost.cloudstream3.p041ui.result;

import android.content.ClipData;
import android.content.ClipboardManager;
import androidx.fragment.app.FragmentActivity;
import com.bongngotv2.R;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ResultFragmentTV.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "link", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$onViewCreated$handleAction$1$4$1 */
/* loaded from: classes4.dex */
final class ResultFragmentTV$onViewCreated$handleAction$1$4$1 extends Lambda implements Function1<ExtractorLink, Unit> {
    final /* synthetic */ FragmentActivity $act;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultFragmentTV$onViewCreated$handleAction$1$4$1(FragmentActivity fragmentActivity) {
        super(1);
        this.$act = fragmentActivity;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ExtractorLink extractorLink) {
        invoke2(extractorLink);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ExtractorLink link) {
        Intrinsics.checkNotNullParameter(link, "link");
        ClipboardManager clipboardManager = (ClipboardManager) this.$act.getSystemService("clipboard");
        if (clipboardManager == null) {
            return;
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText(link.getName(), link.getUrl()));
        CommonActivity.INSTANCE.showToast(this.$act, R.string.copy_link_toast, 0);
    }
}
