package com.lagradost.cloudstream3.p041ui.download;

import androidx.recyclerview.widget.RecyclerView;
import com.lagradost.cloudstream3.C4761R;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadFragment.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.download.DownloadFragment$setList$1", m98f = "DownloadFragment.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.download.DownloadFragment$setList$1 */
/* loaded from: classes3.dex */
public final class DownloadFragment$setList$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ List<VisualDownloadHeaderCached> $list;
    int label;
    final /* synthetic */ DownloadFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadFragment$setList$1(DownloadFragment downloadFragment, List<VisualDownloadHeaderCached> list, Continuation<? super DownloadFragment$setList$1> continuation) {
        super(1, continuation);
        this.this$0 = downloadFragment;
        this.$list = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new DownloadFragment$setList$1(this.this$0, this.$list, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((DownloadFragment$setList$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        RecyclerView.Adapter adapter;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C4761R.C4764id.download_list);
            DownloadHeaderAdapter downloadHeaderAdapter = (DownloadHeaderAdapter) (recyclerView != null ? recyclerView.getAdapter() : null);
            if (downloadHeaderAdapter != null) {
                downloadHeaderAdapter.setCardList(this.$list);
            }
            RecyclerView recyclerView2 = (RecyclerView) this.this$0._$_findCachedViewById(C4761R.C4764id.download_list);
            if (recyclerView2 != null && (adapter = recyclerView2.getAdapter()) != null) {
                adapter.notifyDataSetChanged();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
