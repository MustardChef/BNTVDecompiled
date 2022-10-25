package com.lagradost.cloudstream3.p041ui;

import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.p041ui.player.RepoLinkGenerator;
import com.lagradost.cloudstream3.p041ui.player.SubtitleData;
import com.lagradost.cloudstream3.p041ui.result.ResultEpisode;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.CastHelper;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ControllerActivity.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.SelectSourceController$onMediaStatusUpdated$1", m98f = "ControllerActivity.kt", m97i = {0, 0}, m96l = {296}, m95m = "invokeSuspend", m94n = {"currentLinks", "currentSubs"}, m93s = {"L$0", "L$1"})
/* renamed from: com.lagradost.cloudstream3.ui.SelectSourceController$onMediaStatusUpdated$1 */
/* loaded from: classes.dex */
final class SelectSourceController$onMediaStatusUpdated$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ ResultEpisode $epData;
    final /* synthetic */ int $index;
    final /* synthetic */ MetadataHolder $meta;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SelectSourceController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectSourceController$onMediaStatusUpdated$1(ResultEpisode resultEpisode, MetadataHolder metadataHolder, int i, SelectSourceController selectSourceController, Continuation<? super SelectSourceController$onMediaStatusUpdated$1> continuation) {
        super(1, continuation);
        this.$epData = resultEpisode;
        this.$meta = metadataHolder;
        this.$index = i;
        this.this$0 = selectSourceController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new SelectSourceController$onMediaStatusUpdated$1(this.$epData, this.$meta, this.$index, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((SelectSourceController$onMediaStatusUpdated$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LinkedHashSet linkedHashSet;
        Set set;
        MetadataHolder copy;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            linkedHashSet = new LinkedHashSet();
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            this.L$0 = linkedHashSet;
            this.L$1 = linkedHashSet2;
            this.label = 1;
            Object safeApiCall = ArchComponentExt.safeApiCall(new SelectSourceController$onMediaStatusUpdated$1$isSuccessful$1(new RepoLinkGenerator(CollectionsKt.listOf(this.$epData), 0, null, 6, null), linkedHashSet, linkedHashSet2, null), this);
            if (safeApiCall == coroutine_suspended) {
                return coroutine_suspended;
            }
            set = linkedHashSet2;
            obj = safeApiCall;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            set = (Set) this.L$1;
            linkedHashSet = (Set) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        List<ExtractorLink> sortUrls = MainAPIKt.sortUrls(linkedHashSet);
        List<SubtitleData> sortSubs = MainAPIKt.sortSubs(set);
        if (Intrinsics.areEqual((Resource) obj, new Resource.Success(boxing.boxBoolean(true))) && (!linkedHashSet.isEmpty())) {
            copy = r3.copy((r18 & 1) != 0 ? r3.apiName : null, (r18 & 2) != 0 ? r3.isMovie : false, (r18 & 4) != 0 ? r3.title : null, (r18 & 8) != 0 ? r3.poster : null, (r18 & 16) != 0 ? r3.currentEpisodeIndex : this.$index, (r18 & 32) != 0 ? r3.episodes : null, (r18 & 64) != 0 ? r3.currentLinks : sortUrls, (r18 & 128) != 0 ? this.$meta.currentSubtitles : sortSubs);
            final MediaInfo mediaInfo = CastHelper.INSTANCE.getMediaInfo(this.$epData, copy, 0, new JSONObject(AppUtils.INSTANCE.toJson(copy)), sortSubs);
            ControllerActivity activity = this.this$0.getActivity();
            final SelectSourceController selectSourceController = this.this$0;
            activity.runOnUiThread(new Runnable() { // from class: com.lagradost.cloudstream3.ui.-$$Lambda$SelectSourceController$onMediaStatusUpdated$1$xCQo0Er5qQdTyBAY4mEqeXXvy6k
                @Override // java.lang.Runnable
                public final void run() {
                    SelectSourceController$onMediaStatusUpdated$1.m8611invokeSuspend$lambda0(SelectSourceController.this, mediaInfo);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final void m8611invokeSuspend$lambda0(SelectSourceController selectSourceController, MediaInfo mediaInfo) {
        RemoteMediaClient remoteMediaClient;
        CastHelper castHelper = CastHelper.INSTANCE;
        remoteMediaClient = selectSourceController.getRemoteMediaClient();
        castHelper.awaitLinks(remoteMediaClient != null ? remoteMediaClient.queueAppendItem(new MediaQueueItem.Builder(mediaInfo).build(), new JSONObject()) : null, SelectSourceController$onMediaStatusUpdated$1$1$1.INSTANCE);
        selectSourceController.setLoadingMore(false);
    }
}
