package com.lagradost.cloudstream3.metaproviders;

import com.google.ads.interactivemedia.p034v3.internal.bqk;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.uwetrottmann.tmdb2.Tmdb;
import com.uwetrottmann.tmdb2.entities.BaseTvShow;
import com.uwetrottmann.tmdb2.entities.TvShowResultsPage;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import retrofit2.Call;
import retrofit2.KotlinExtensions;
import retrofit2.Response;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TmdbProvider.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.metaproviders.TmdbProvider$getMainPage$3", m98f = "TmdbProvider.kt", m97i = {}, m96l = {bqk.f6559bS}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class TmdbProvider$getMainPage$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<List<TvSeriesSearchResponse>> $discoverSeries;
    Object L$0;
    int label;
    final /* synthetic */ TmdbProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TmdbProvider$getMainPage$3(Ref.ObjectRef<List<TvSeriesSearchResponse>> objectRef, TmdbProvider tmdbProvider, Continuation<? super TmdbProvider$getMainPage$3> continuation) {
        super(1, continuation);
        this.$discoverSeries = objectRef;
        this.this$0 = tmdbProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TmdbProvider$getMainPage$3(this.$discoverSeries, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TmdbProvider$getMainPage$3) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Tmdb tmdb;
        Ref.ObjectRef<List<TvSeriesSearchResponse>> objectRef;
        T t;
        Iterable iterable;
        TvSeriesSearchResponse searchResponse;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef<List<TvSeriesSearchResponse>> objectRef2 = this.$discoverSeries;
            tmdb = this.this$0.tmdb;
            Call<TvShowResultsPage> build = tmdb.discoverTv().build();
            Intrinsics.checkNotNullExpressionValue(build, "tmdb.discoverTv().build()");
            this.L$0 = objectRef2;
            this.label = 1;
            Object awaitResponse = KotlinExtensions.awaitResponse(build, this);
            if (awaitResponse == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
            obj = awaitResponse;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            objectRef = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        TvShowResultsPage tvShowResultsPage = (TvShowResultsPage) ((Response) obj).body();
        if (tvShowResultsPage == null || (iterable = tvShowResultsPage.results) == null) {
            t = CollectionsKt.emptyList();
        } else {
            Iterable<BaseTvShow> iterable2 = iterable;
            TmdbProvider tmdbProvider = this.this$0;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
            for (BaseTvShow it : iterable2) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                searchResponse = tmdbProvider.toSearchResponse(it);
                arrayList.add(searchResponse);
            }
            t = arrayList;
        }
        objectRef.element = t;
        return Unit.INSTANCE;
    }
}
