package com.lagradost.cloudstream3.p041ui.download;

import android.content.Context;
import com.lagradost.cloudstream3.utils.DataStore;
import com.lagradost.cloudstream3.utils.DataStoreKt;
import com.lagradost.cloudstream3.utils.VideoDownloadHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

/* compiled from: DownloadViewModel.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/VideoDownloadHelper$DownloadHeaderCached;", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.download.DownloadViewModel$updateList$1$cached$1", m98f = "DownloadViewModel.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.download.DownloadViewModel$updateList$1$cached$1 */
/* loaded from: classes3.dex */
final class DownloadViewModel$updateList$1$cached$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends VideoDownloadHelper.DownloadHeaderCached>>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ HashMap<Integer, Integer> $totalDownloads;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadViewModel$updateList$1$cached$1(HashMap<Integer, Integer> hashMap, Context context, Continuation<? super DownloadViewModel$updateList$1$cached$1> continuation) {
        super(2, continuation);
        this.$totalDownloads = hashMap;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadViewModel$updateList$1$cached$1(this.$totalDownloads, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends VideoDownloadHelper.DownloadHeaderCached>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<VideoDownloadHelper.DownloadHeaderCached>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<VideoDownloadHelper.DownloadHeaderCached>> continuation) {
        return ((DownloadViewModel$updateList$1$cached$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Set<Map.Entry<Integer, Integer>> entrySet = this.$totalDownloads.entrySet();
            Intrinsics.checkNotNullExpressionValue(entrySet, "totalDownloads.entries");
            ArrayList<Map.Entry> arrayList = new ArrayList();
            for (Object obj2 : entrySet) {
                Object value = ((Map.Entry) obj2).getValue();
                Intrinsics.checkNotNullExpressionValue(value, "it.value");
                if (((Number) value).intValue() > 0) {
                    arrayList.add(obj2);
                }
            }
            Context context = this.$context;
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry entry : arrayList) {
                DataStore dataStore = DataStore.INSTANCE;
                Object obj3 = null;
                try {
                    String string = dataStore.getSharedPrefs(context).getString(dataStore.getFolderName(DataStoreKt.DOWNLOAD_HEADER_CACHE, String.valueOf(((Number) entry.getKey()).intValue())), null);
                    if (string != null) {
                        Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                        Object readValue = dataStore.getMapper().readValue(string, VideoDownloadHelper.DownloadHeaderCached.class);
                        Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                        obj3 = readValue;
                    }
                } catch (Exception unused) {
                }
                VideoDownloadHelper.DownloadHeaderCached downloadHeaderCached = (VideoDownloadHelper.DownloadHeaderCached) obj3;
                if (downloadHeaderCached != null) {
                    arrayList2.add(downloadHeaderCached);
                }
            }
            return arrayList2;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
