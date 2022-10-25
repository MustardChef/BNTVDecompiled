package com.lagradost.cloudstream3.p041ui.download;

import android.content.Context;
import com.lagradost.cloudstream3.utils.DataStore;
import com.lagradost.cloudstream3.utils.VideoDownloadHelper;
import com.lagradost.cloudstream3.utils.VideoDownloadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadChildFragment.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/ui/download/VisualDownloadChildCached;", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.download.DownloadChildFragment$updateList$1$1$eps$1", m98f = "DownloadChildFragment.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.download.DownloadChildFragment$updateList$1$1$eps$1 */
/* loaded from: classes3.dex */
public final class DownloadChildFragment$updateList$1$1$eps$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends VisualDownloadChildCached>>, Object> {
    final /* synthetic */ Context $ctx;
    final /* synthetic */ List<String> $data;
    int label;
    final /* synthetic */ DownloadChildFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadChildFragment$updateList$1$1$eps$1(List<String> list, DownloadChildFragment downloadChildFragment, Context context, Continuation<? super DownloadChildFragment$updateList$1$1$eps$1> continuation) {
        super(2, continuation);
        this.$data = list;
        this.this$0 = downloadChildFragment;
        this.$ctx = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadChildFragment$updateList$1$1$eps$1(this.$data, this.this$0, this.$ctx, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends VisualDownloadChildCached>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<VisualDownloadChildCached>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<VisualDownloadChildCached>> continuation) {
        return ((DownloadChildFragment$updateList$1$1$eps$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        DownloadChildFragment downloadChildFragment = this.this$0;
        ArrayList<VideoDownloadHelper.DownloadEpisodeCached> arrayList = new ArrayList();
        Iterator<T> it = this.$data.iterator();
        while (true) {
            VideoDownloadHelper.DownloadEpisodeCached downloadEpisodeCached = null;
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            Context context = downloadChildFragment.getContext();
            if (context != null) {
                DataStore dataStore = DataStore.INSTANCE;
                try {
                    String string = dataStore.getSharedPrefs(context).getString(str, null);
                    if (string != null) {
                        Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                        Object readValue = dataStore.getMapper().readValue(string, VideoDownloadHelper.DownloadEpisodeCached.class);
                        Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                        downloadEpisodeCached = readValue;
                    }
                } catch (Exception unused) {
                }
                downloadEpisodeCached = downloadEpisodeCached;
            }
            if (downloadEpisodeCached != null) {
                arrayList.add(downloadEpisodeCached);
            }
        }
        Context ctx = this.$ctx;
        ArrayList arrayList2 = new ArrayList();
        for (VideoDownloadHelper.DownloadEpisodeCached downloadEpisodeCached2 : arrayList) {
            VideoDownloadManager videoDownloadManager = VideoDownloadManager.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(ctx, "ctx");
            VideoDownloadManager.DownloadedFileInfoResult downloadFileInfoAndUpdateSettings = videoDownloadManager.getDownloadFileInfoAndUpdateSettings(ctx, downloadEpisodeCached2.getId());
            VisualDownloadChildCached visualDownloadChildCached = downloadFileInfoAndUpdateSettings == null ? null : new VisualDownloadChildCached(downloadFileInfoAndUpdateSettings.getFileLength(), downloadFileInfoAndUpdateSettings.getTotalBytes(), downloadEpisodeCached2);
            if (visualDownloadChildCached != null) {
                arrayList2.add(visualDownloadChildCached);
            }
        }
        return arrayList2;
    }
}
