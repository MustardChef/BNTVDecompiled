package com.lagradost.cloudstream3.p041ui.download;

import android.content.Context;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.utils.DataStore;
import com.lagradost.cloudstream3.utils.DataStoreKt;
import com.lagradost.cloudstream3.utils.VideoDownloadHelper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DownloadViewModel.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/ui/download/VisualDownloadHeaderCached;", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.download.DownloadViewModel$updateList$1$visual$1", m98f = "DownloadViewModel.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.download.DownloadViewModel$updateList$1$visual$1 */
/* loaded from: classes3.dex */
final class DownloadViewModel$updateList$1$visual$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends VisualDownloadHeaderCached>>, Object> {
    final /* synthetic */ List<VideoDownloadHelper.DownloadHeaderCached> $cached;
    final /* synthetic */ Context $context;
    final /* synthetic */ HashMap<Integer, Long> $currentBytesUsedByChild;
    final /* synthetic */ HashMap<Integer, Long> $totalBytesUsedByChild;
    final /* synthetic */ HashMap<Integer, Integer> $totalDownloads;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadViewModel$updateList$1$visual$1(List<VideoDownloadHelper.DownloadHeaderCached> list, HashMap<Integer, Integer> hashMap, HashMap<Integer, Long> hashMap2, HashMap<Integer, Long> hashMap3, Context context, Continuation<? super DownloadViewModel$updateList$1$visual$1> continuation) {
        super(2, continuation);
        this.$cached = list;
        this.$totalDownloads = hashMap;
        this.$totalBytesUsedByChild = hashMap2;
        this.$currentBytesUsedByChild = hashMap3;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadViewModel$updateList$1$visual$1(this.$cached, this.$totalDownloads, this.$totalBytesUsedByChild, this.$currentBytesUsedByChild, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends VisualDownloadHeaderCached>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<VisualDownloadHeaderCached>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<VisualDownloadHeaderCached>> continuation) {
        return ((DownloadViewModel$updateList$1$visual$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        VisualDownloadHeaderCached visualDownloadHeaderCached;
        VideoDownloadHelper.DownloadEpisodeCached downloadEpisodeCached;
        Object obj2;
        VideoDownloadHelper.DownloadEpisodeCached downloadEpisodeCached2;
        String string;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        HashMap<Integer, Integer> hashMap = this.$totalDownloads;
        HashMap<Integer, Long> hashMap2 = this.$totalBytesUsedByChild;
        HashMap<Integer, Long> hashMap3 = this.$currentBytesUsedByChild;
        Context context = this.$context;
        ArrayList arrayList = new ArrayList();
        for (VideoDownloadHelper.DownloadHeaderCached downloadHeaderCached : this.$cached) {
            Integer num = hashMap.get(boxing.boxInt(downloadHeaderCached.getId()));
            if (num == null) {
                num = boxing.boxInt(0);
            }
            Intrinsics.checkNotNullExpressionValue(num, "totalDownloads[it.id] ?: 0");
            int intValue = num.intValue();
            Long l = hashMap2.get(boxing.boxInt(downloadHeaderCached.getId()));
            if (l == null) {
                l = boxing.boxLong(0L);
            }
            Intrinsics.checkNotNullExpressionValue(l, "totalBytesUsedByChild[it.id] ?: 0");
            long longValue = l.longValue();
            Long l2 = hashMap3.get(boxing.boxInt(downloadHeaderCached.getId()));
            if (l2 == null) {
                l2 = boxing.boxLong(0L);
            }
            Intrinsics.checkNotNullExpressionValue(l2, "currentBytesUsedByChild[it.id] ?: 0");
            long longValue2 = l2.longValue();
            if (longValue <= 0 || intValue <= 0) {
                visualDownloadHeaderCached = null;
            } else {
                if (MainAPIKt.isMovieType(downloadHeaderCached.getType())) {
                    DataStore dataStore = DataStore.INSTANCE;
                    try {
                        downloadEpisodeCached = null;
                        try {
                            string = dataStore.getSharedPrefs(context).getString(dataStore.getFolderName(DataStoreKt.DOWNLOAD_EPISODE_CACHE, DataStore.INSTANCE.getFolderName(String.valueOf(downloadHeaderCached.getId()), String.valueOf(downloadHeaderCached.getId()))), null);
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        downloadEpisodeCached = null;
                    }
                    if (string == null) {
                        obj2 = downloadEpisodeCached;
                        downloadEpisodeCached2 = (VideoDownloadHelper.DownloadEpisodeCached) obj2;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                        Object readValue = dataStore.getMapper().readValue(string, VideoDownloadHelper.DownloadEpisodeCached.class);
                        Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                        obj2 = readValue;
                        downloadEpisodeCached2 = (VideoDownloadHelper.DownloadEpisodeCached) obj2;
                    }
                } else {
                    downloadEpisodeCached2 = null;
                }
                visualDownloadHeaderCached = new VisualDownloadHeaderCached(0, intValue, longValue, longValue2, downloadHeaderCached, downloadEpisodeCached2);
            }
            if (visualDownloadHeaderCached != null) {
                arrayList.add(visualDownloadHeaderCached);
            }
        }
        return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.lagradost.cloudstream3.ui.download.DownloadViewModel$updateList$1$visual$1$invokeSuspend$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Integer season;
                Integer season2;
                VisualDownloadHeaderCached visualDownloadHeaderCached2 = (VisualDownloadHeaderCached) t;
                VideoDownloadHelper.DownloadEpisodeCached child = visualDownloadHeaderCached2.getChild();
                int i = 0;
                int episode = child != null ? child.getEpisode() : 0;
                VideoDownloadHelper.DownloadEpisodeCached child2 = visualDownloadHeaderCached2.getChild();
                Integer valueOf = Integer.valueOf(episode + ((child2 == null || (season2 = child2.getSeason()) == null) ? 0 : season2.intValue() * 10000));
                VisualDownloadHeaderCached visualDownloadHeaderCached3 = (VisualDownloadHeaderCached) t2;
                VideoDownloadHelper.DownloadEpisodeCached child3 = visualDownloadHeaderCached3.getChild();
                int episode2 = child3 != null ? child3.getEpisode() : 0;
                VideoDownloadHelper.DownloadEpisodeCached child4 = visualDownloadHeaderCached3.getChild();
                if (child4 != null && (season = child4.getSeason()) != null) {
                    i = season.intValue() * 10000;
                }
                return ComparisonsKt.compareValues(valueOf, Integer.valueOf(episode2 + i));
            }
        });
    }
}
