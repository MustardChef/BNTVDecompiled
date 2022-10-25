package com.lagradost.cloudstream3.p041ui.download;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: DownloadChildFragment.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.download.DownloadChildFragment$updateList$1", m98f = "DownloadChildFragment.kt", m97i = {0}, m96l = {48, 49}, m95m = "invokeSuspend", m94n = {"ctx"}, m93s = {"L$1"})
/* renamed from: com.lagradost.cloudstream3.ui.download.DownloadChildFragment$updateList$1 */
/* loaded from: classes3.dex */
final class DownloadChildFragment$updateList$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $folder;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DownloadChildFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadChildFragment$updateList$1(DownloadChildFragment downloadChildFragment, String str, Continuation<? super DownloadChildFragment$updateList$1> continuation) {
        super(1, continuation);
        this.this$0 = downloadChildFragment;
        this.$folder = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new DownloadChildFragment$updateList$1(this.this$0, this.$folder, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((DownloadChildFragment$updateList$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0093  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L2b
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r0 = r9.L$0
            com.lagradost.cloudstream3.ui.download.DownloadChildFragment r0 = (com.lagradost.cloudstream3.p041ui.download.DownloadChildFragment) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L74
        L17:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L1f:
            java.lang.Object r1 = r9.L$1
            android.content.Context r1 = (android.content.Context) r1
            java.lang.Object r3 = r9.L$0
            com.lagradost.cloudstream3.ui.download.DownloadChildFragment r3 = (com.lagradost.cloudstream3.p041ui.download.DownloadChildFragment) r3
            kotlin.ResultKt.throwOnFailure(r10)
            goto L57
        L2b:
            kotlin.ResultKt.throwOnFailure(r10)
            com.lagradost.cloudstream3.ui.download.DownloadChildFragment r10 = r9.this$0
            android.content.Context r1 = r10.getContext()
            if (r1 == 0) goto Lbe
            com.lagradost.cloudstream3.ui.download.DownloadChildFragment r10 = r9.this$0
            java.lang.String r5 = r9.$folder
            kotlinx.coroutines.CoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6
            com.lagradost.cloudstream3.ui.download.DownloadChildFragment$updateList$1$1$data$1 r7 = new com.lagradost.cloudstream3.ui.download.DownloadChildFragment$updateList$1$1$data$1
            r7.<init>(r1, r5, r4)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r9.L$0 = r10
            r9.L$1 = r1
            r9.label = r3
            java.lang.Object r3 = kotlinx.coroutines.BuildersKt.withContext(r6, r7, r9)
            if (r3 != r0) goto L54
            return r0
        L54:
            r8 = r3
            r3 = r10
            r10 = r8
        L57:
            java.util.List r10 = (java.util.List) r10
            kotlinx.coroutines.CoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5
            com.lagradost.cloudstream3.ui.download.DownloadChildFragment$updateList$1$1$eps$1 r6 = new com.lagradost.cloudstream3.ui.download.DownloadChildFragment$updateList$1$1$eps$1
            r6.<init>(r10, r3, r1, r4)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r9.L$0 = r3
            r9.L$1 = r4
            r9.label = r2
            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r5, r6, r9)
            if (r10 != r0) goto L73
            return r0
        L73:
            r0 = r3
        L74:
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            com.lagradost.cloudstream3.ui.download.DownloadChildFragment$updateList$1$invokeSuspend$lambda-1$$inlined$sortedBy$1 r1 = new com.lagradost.cloudstream3.ui.download.DownloadChildFragment$updateList$1$invokeSuspend$lambda-1$$inlined$sortedBy$1
            r1.<init>()
            java.util.Comparator r1 = (java.util.Comparator) r1
            java.util.List r10 = kotlin.collections.CollectionsKt.sortedWith(r10, r1)
            boolean r1 = r10.isEmpty()
            if (r1 == 0) goto L93
            androidx.fragment.app.FragmentActivity r10 = r0.getActivity()
            if (r10 == 0) goto L90
            r10.onBackPressed()
        L90:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L93:
            int r1 = com.lagradost.cloudstream3.C4761R.C4764id.download_child_list
            android.view.View r1 = r0._$_findCachedViewById(r1)
            androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
            if (r1 == 0) goto La1
            androidx.recyclerview.widget.RecyclerView$Adapter r4 = r1.getAdapter()
        La1:
            com.lagradost.cloudstream3.ui.download.DownloadChildAdapter r4 = (com.lagradost.cloudstream3.p041ui.download.DownloadChildAdapter) r4
            if (r4 != 0) goto La8
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        La8:
            r4.setCardList(r10)
            int r10 = com.lagradost.cloudstream3.C4761R.C4764id.download_child_list
            android.view.View r10 = r0._$_findCachedViewById(r10)
            androidx.recyclerview.widget.RecyclerView r10 = (androidx.recyclerview.widget.RecyclerView) r10
            if (r10 == 0) goto Lbe
            androidx.recyclerview.widget.RecyclerView$Adapter r10 = r10.getAdapter()
            if (r10 == 0) goto Lbe
            r10.notifyDataSetChanged()
        Lbe:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.download.DownloadChildFragment$updateList$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
