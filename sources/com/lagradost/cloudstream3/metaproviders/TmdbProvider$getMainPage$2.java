package com.lagradost.cloudstream3.metaproviders;

import com.google.ads.interactivemedia.p034v3.internal.bqk;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.uwetrottmann.tmdb2.Tmdb;
import com.uwetrottmann.tmdb2.entities.BaseMovie;
import com.uwetrottmann.tmdb2.entities.MovieResultsPage;
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
@DebugMetadata(m99c = "com.lagradost.cloudstream3.metaproviders.TmdbProvider$getMainPage$2", m98f = "TmdbProvider.kt", m97i = {}, m96l = {bqk.f6556bP}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class TmdbProvider$getMainPage$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<List<MovieSearchResponse>> $discoverMovies;
    Object L$0;
    int label;
    final /* synthetic */ TmdbProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TmdbProvider$getMainPage$2(Ref.ObjectRef<List<MovieSearchResponse>> objectRef, TmdbProvider tmdbProvider, Continuation<? super TmdbProvider$getMainPage$2> continuation) {
        super(1, continuation);
        this.$discoverMovies = objectRef;
        this.this$0 = tmdbProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TmdbProvider$getMainPage$2(this.$discoverMovies, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TmdbProvider$getMainPage$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Tmdb tmdb;
        Ref.ObjectRef<List<MovieSearchResponse>> objectRef;
        T t;
        Iterable iterable;
        MovieSearchResponse searchResponse;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef<List<MovieSearchResponse>> objectRef2 = this.$discoverMovies;
            tmdb = this.this$0.tmdb;
            Call<MovieResultsPage> build = tmdb.discoverMovie().build();
            Intrinsics.checkNotNullExpressionValue(build, "tmdb.discoverMovie().build()");
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
        MovieResultsPage movieResultsPage = (MovieResultsPage) ((Response) obj).body();
        if (movieResultsPage == null || (iterable = movieResultsPage.results) == null) {
            t = CollectionsKt.emptyList();
        } else {
            Iterable<BaseMovie> iterable2 = iterable;
            TmdbProvider tmdbProvider = this.this$0;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
            for (BaseMovie it : iterable2) {
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
