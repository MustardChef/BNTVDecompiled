package com.lagradost.cloudstream3.p041ui.download;

import android.content.Context;
import com.lagradost.cloudstream3.utils.VideoDownloadHelper;
import com.lagradost.cloudstream3.utils.VideoDownloadManager;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadViewModel.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.download.DownloadViewModel$updateList$1", m98f = "DownloadViewModel.kt", m97i = {1, 1, 1, 2, 2, 2}, m96l = {41, 56, 70, 79}, m95m = "invokeSuspend", m94n = {"totalBytesUsedByChild", "currentBytesUsedByChild", "totalDownloads", "totalBytesUsedByChild", "currentBytesUsedByChild", "totalDownloads"}, m93s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* renamed from: com.lagradost.cloudstream3.ui.download.DownloadViewModel$updateList$1 */
/* loaded from: classes3.dex */
public final class DownloadViewModel$updateList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ DownloadViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadViewModel$updateList$1(DownloadViewModel downloadViewModel, Context context, Continuation<? super DownloadViewModel$updateList$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadViewModel;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadViewModel$updateList$1(this.this$0, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloadViewModel$updateList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x012a A[LOOP:0: B:29:0x0124->B:31:0x012a, LOOP_END] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 363
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.download.DownloadViewModel$updateList$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadViewModel.kt */
    @Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.download.DownloadViewModel$updateList$1$1", m98f = "DownloadViewModel.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.lagradost.cloudstream3.ui.download.DownloadViewModel$updateList$1$1 */
    /* loaded from: classes3.dex */
    public static final class C48471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<VideoDownloadHelper.DownloadEpisodeCached> $children;
        final /* synthetic */ Context $context;
        final /* synthetic */ HashMap<Integer, Long> $currentBytesUsedByChild;
        final /* synthetic */ HashMap<Integer, Long> $totalBytesUsedByChild;
        final /* synthetic */ HashMap<Integer, Integer> $totalDownloads;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C48471(List<VideoDownloadHelper.DownloadEpisodeCached> list, Context context, HashMap<Integer, Long> hashMap, HashMap<Integer, Long> hashMap2, HashMap<Integer, Integer> hashMap3, Continuation<? super C48471> continuation) {
            super(2, continuation);
            this.$children = list;
            this.$context = context;
            this.$totalBytesUsedByChild = hashMap;
            this.$currentBytesUsedByChild = hashMap2;
            this.$totalDownloads = hashMap3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C48471(this.$children, this.$context, this.$totalBytesUsedByChild, this.$currentBytesUsedByChild, this.$totalDownloads, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C48471) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                for (VideoDownloadHelper.DownloadEpisodeCached downloadEpisodeCached : this.$children) {
                    VideoDownloadManager.DownloadedFileInfoResult downloadFileInfoAndUpdateSettings = VideoDownloadManager.INSTANCE.getDownloadFileInfoAndUpdateSettings(this.$context, downloadEpisodeCached.getId());
                    if (downloadFileInfoAndUpdateSettings != null && downloadFileInfoAndUpdateSettings.getFileLength() > 1) {
                        long totalBytes = downloadFileInfoAndUpdateSettings.getTotalBytes();
                        long fileLength = downloadFileInfoAndUpdateSettings.getFileLength();
                        HashMap<Integer, Long> hashMap = this.$totalBytesUsedByChild;
                        Integer boxInt = boxing.boxInt(downloadEpisodeCached.getParentId());
                        Long l = this.$totalBytesUsedByChild.get(boxing.boxInt(downloadEpisodeCached.getParentId()));
                        if (l != null) {
                            totalBytes += l.longValue();
                        }
                        hashMap.put(boxInt, boxing.boxLong(totalBytes));
                        HashMap<Integer, Long> hashMap2 = this.$currentBytesUsedByChild;
                        Integer boxInt2 = boxing.boxInt(downloadEpisodeCached.getParentId());
                        Long l2 = this.$currentBytesUsedByChild.get(boxing.boxInt(downloadEpisodeCached.getParentId()));
                        if (l2 != null) {
                            fileLength += l2.longValue();
                        }
                        hashMap2.put(boxInt2, boxing.boxLong(fileLength));
                        HashMap<Integer, Integer> hashMap3 = this.$totalDownloads;
                        Integer boxInt3 = boxing.boxInt(downloadEpisodeCached.getParentId());
                        Integer num = this.$totalDownloads.get(boxing.boxInt(downloadEpisodeCached.getParentId()));
                        hashMap3.put(boxInt3, boxing.boxInt(num != null ? 1 + num.intValue() : 1));
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
