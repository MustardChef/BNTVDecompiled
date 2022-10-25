package com.lagradost.cloudstream3.utils;

import android.content.Context;
import androidx.tvprovider.media.p009tv.PreviewChannelHelper;
import androidx.tvprovider.media.p009tv.WatchNextProgram;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.utils.DataStoreHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: AppUtils.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.utils.AppUtils$addProgramsToContinueWatching$1", m98f = "AppUtils.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes4.dex */
final class AppUtils$addProgramsToContinueWatching$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ List<DataStoreHelper.ResumeWatchingResult> $data;
    final /* synthetic */ Context $this_addProgramsToContinueWatching;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppUtils$addProgramsToContinueWatching$1(List<DataStoreHelper.ResumeWatchingResult> list, Context context, Continuation<? super AppUtils$addProgramsToContinueWatching$1> continuation) {
        super(1, continuation);
        this.$data = list;
        this.$this_addProgramsToContinueWatching = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new AppUtils$addProgramsToContinueWatching$1(this.$data, this.$this_addProgramsToContinueWatching, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((AppUtils$addProgramsToContinueWatching$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Tuples watchNextProgramByVideoId;
        WatchNextProgram buildWatchNextProgramUri;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Context context = this.$this_addProgramsToContinueWatching;
            for (DataStoreHelper.ResumeWatchingResult resumeWatchingResult : this.$data) {
                try {
                    watchNextProgramByVideoId = AppUtils.INSTANCE.getWatchNextProgramByVideoId(resumeWatchingResult.getUrl(), context);
                    WatchNextProgram watchNextProgram = (WatchNextProgram) watchNextProgramByVideoId.component1();
                    Long l = (Long) watchNextProgramByVideoId.component2();
                    buildWatchNextProgramUri = AppUtils.INSTANCE.buildWatchNextProgramUri(context, resumeWatchingResult);
                    if (watchNextProgram != null && l != null) {
                        new PreviewChannelHelper(context).updateWatchNextProgram(buildWatchNextProgramUri, l.longValue());
                    } else {
                        new PreviewChannelHelper(context).publishWatchNextProgram(buildWatchNextProgramUri);
                    }
                } catch (Exception e) {
                    ArchComponentExt.logError(e);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
