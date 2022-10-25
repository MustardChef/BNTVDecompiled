package com.lagradost.cloudstream3.movieproviders;

import com.google.gson.Gson;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.Page;
import com.lagradost.cloudstream3.movieproviders.LokLokProvider;
import com.lagradost.cloudstream3.utils.Extensions;
import com.lagradost.nicehttp.NiceResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LokLokProvider.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.LokLokProvider$getMainPage$8", m98f = "LokLokProvider.kt", m97i = {}, m96l = {177}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class LokLokProvider$getMainPage$8 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayList<Page> $listMenuMovies;
    final /* synthetic */ ArrayList<Page> $listMenuTvShow;
    final /* synthetic */ Ref.ObjectRef<String> $menuTitleMovie;
    final /* synthetic */ Ref.ObjectRef<String> $menuTitleTvShow;
    Object L$0;
    int label;
    final /* synthetic */ LokLokProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LokLokProvider$getMainPage$8(ArrayList<Page> arrayList, LokLokProvider lokLokProvider, ArrayList<Page> arrayList2, Ref.ObjectRef<String> objectRef, Ref.ObjectRef<String> objectRef2, Continuation<? super LokLokProvider$getMainPage$8> continuation) {
        super(1, continuation);
        this.$listMenuTvShow = arrayList;
        this.this$0 = lokLokProvider;
        this.$listMenuMovies = arrayList2;
        this.$menuTitleTvShow = objectRef;
        this.$menuTitleMovie = objectRef2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new LokLokProvider$getMainPage$8(this.$listMenuTvShow, this.this$0, this.$listMenuMovies, this.$menuTitleTvShow, this.$menuTitleMovie, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((LokLokProvider$getMainPage$8) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object withCustomCache;
        Gson gson;
        Object obj2;
        Object obj3;
        boolean z;
        boolean z2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Gson gson2 = new Gson();
            Extensions.RequestCustom app = MainActivityKt.getApp();
            Map<String, String> header_default = LokLokProvider.Companion.getHEADER_DEFAULT();
            TimeUnit timeUnit = TimeUnit.HOURS;
            this.L$0 = gson2;
            this.label = 1;
            withCustomCache = app.getWithCustomCache(LokLokProvider.URL_GET_CATEGORY, (r30 & 2) != 0 ? MapsKt.emptyMap() : header_default, (r30 & 4) != 0 ? null : null, (r30 & 8) != 0 ? MapsKt.emptyMap() : null, (r30 & 16) != 0 ? MapsKt.emptyMap() : null, (r30 & 32) != 0, (r30 & 64) != 0 ? app.getDefaultCacheTime() : 4, (r30 & 128) != 0 ? app.getDefaultCacheTimeUnit() : timeUnit, (r30 & 256) != 0 ? app.getDefaultTimeOut() : 0L, (r30 & 512) != 0 ? null : null, (r30 & 1024) != 0, this);
            if (withCustomCache == coroutine_suspended) {
                return coroutine_suspended;
            }
            gson = gson2;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            gson = (Gson) this.L$0;
            ResultKt.throwOnFailure(obj);
            withCustomCache = obj;
        }
        LokLokProvider.HomeCategoryResponse homeCategoryResponse = (LokLokProvider.HomeCategoryResponse) gson.fromJson(((NiceResponse) withCustomCache).getText(), (Class<Object>) LokLokProvider.HomeCategoryResponse.class);
        ArrayList<Page> arrayList = this.$listMenuTvShow;
        LokLokProvider lokLokProvider = this.this$0;
        Intrinsics.checkNotNullExpressionValue(homeCategoryResponse, "homeCategoryResponse");
        arrayList.addAll(lokLokProvider.toListTvShowPage(homeCategoryResponse, this.this$0.getName()));
        ArrayList<Page> arrayList2 = this.$listMenuMovies;
        LokLokProvider lokLokProvider2 = this.this$0;
        arrayList2.addAll(lokLokProvider2.toListMoviesPage(homeCategoryResponse, lokLokProvider2.getName()));
        Ref.ObjectRef<String> objectRef = this.$menuTitleTvShow;
        Iterator<T> it = homeCategoryResponse.getData().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (((LokLokProvider.DataCategory) obj2).getId() == 2) {
                z2 = true;
                continue;
            } else {
                z2 = false;
                continue;
            }
            if (z2) {
                break;
            }
        }
        LokLokProvider.DataCategory dataCategory = (LokLokProvider.DataCategory) obj2;
        objectRef.element = dataCategory != null ? dataCategory.getName() : 0;
        Ref.ObjectRef<String> objectRef2 = this.$menuTitleMovie;
        Iterator<T> it2 = homeCategoryResponse.getData().iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj3 = null;
                break;
            }
            obj3 = it2.next();
            if (((LokLokProvider.DataCategory) obj3).getId() == 1) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        LokLokProvider.DataCategory dataCategory2 = (LokLokProvider.DataCategory) obj3;
        objectRef2.element = dataCategory2 != null ? dataCategory2.getName() : 0;
        return Unit.INSTANCE;
    }
}
