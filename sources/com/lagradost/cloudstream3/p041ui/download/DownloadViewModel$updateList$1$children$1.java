package com.lagradost.cloudstream3.p041ui.download;

import android.content.Context;
import com.lagradost.cloudstream3.utils.DataStore;
import com.lagradost.cloudstream3.utils.DataStoreKt;
import com.lagradost.cloudstream3.utils.VideoDownloadHelper;
import java.util.ArrayList;
import java.util.HashSet;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DownloadViewModel.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/VideoDownloadHelper$DownloadEpisodeCached;", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.download.DownloadViewModel$updateList$1$children$1", m98f = "DownloadViewModel.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.download.DownloadViewModel$updateList$1$children$1 */
/* loaded from: classes3.dex */
final class DownloadViewModel$updateList$1$children$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends VideoDownloadHelper.DownloadEpisodeCached>>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadViewModel$updateList$1$children$1(Context context, Continuation<? super DownloadViewModel$updateList$1$children$1> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadViewModel$updateList$1$children$1(this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends VideoDownloadHelper.DownloadEpisodeCached>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<VideoDownloadHelper.DownloadEpisodeCached>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<VideoDownloadHelper.DownloadEpisodeCached>> continuation) {
        return ((DownloadViewModel$updateList$1$children$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Context context = this.$context;
        ArrayList arrayList = new ArrayList();
        for (String str : DataStore.INSTANCE.getKeys(this.$context, DataStoreKt.DOWNLOAD_EPISODE_CACHE)) {
            DataStore dataStore = DataStore.INSTANCE;
            Object obj2 = null;
            try {
                String string = dataStore.getSharedPrefs(context).getString(str, null);
                if (string != null) {
                    Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                    Object readValue = dataStore.getMapper().readValue(string, VideoDownloadHelper.DownloadEpisodeCached.class);
                    Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                    obj2 = readValue;
                }
            } catch (Exception unused) {
            }
            VideoDownloadHelper.DownloadEpisodeCached downloadEpisodeCached = (VideoDownloadHelper.DownloadEpisodeCached) obj2;
            if (downloadEpisodeCached != null) {
                arrayList.add(downloadEpisodeCached);
            }
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : arrayList) {
            if (hashSet.add(boxing.boxInt(((VideoDownloadHelper.DownloadEpisodeCached) obj3).getId()))) {
                arrayList2.add(obj3);
            }
        }
        return arrayList2;
    }
}
