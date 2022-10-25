package com.lagradost.cloudstream3.p041ui.download;

import android.view.View;
import android.widget.TextView;
import com.bongngotv2.R;
import com.lagradost.cloudstream3.C4761R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: DownloadFragment.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.download.DownloadFragment$onCreateView$3 */
/* loaded from: classes3.dex */
final class DownloadFragment$onCreateView$3 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ DownloadFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadFragment$onCreateView$3(DownloadFragment downloadFragment) {
        super(1);
        this.this$0 = downloadFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j) {
        String bytesAsText;
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.download_free_txt);
        if (textView != null) {
            String string = this.this$0.getString(R.string.storage_size_format);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.storage_size_format)");
            bytesAsText = this.this$0.getBytesAsText(j);
            String format = String.format(string, Arrays.copyOf(new Object[]{this.this$0.getString(R.string.free_storage), bytesAsText}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            textView.setText(format);
        }
        View _$_findCachedViewById = this.this$0._$_findCachedViewById(C4761R.C4764id.download_free);
        if (_$_findCachedViewById != null) {
            this.this$0.setLayoutWidth(_$_findCachedViewById, j);
        }
    }
}
