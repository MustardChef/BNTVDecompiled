package com.lagradost.cloudstream3.movieproviders;

import com.google.gson.Gson;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.movieproviders.LokLokProvider;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LokLokProvider.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.LokLokProvider$getMainPage$4", m98f = "LokLokProvider.kt", m97i = {}, m96l = {135}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class LokLokProvider$getMainPage$4 extends SuspendLambda implements Function1<Continuation<? super Object>, Object> {
    final /* synthetic */ Ref.ObjectRef<ArrayList<HomePageList>> $responseFirstPage;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ LokLokProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LokLokProvider$getMainPage$4(Ref.ObjectRef<ArrayList<HomePageList>> objectRef, LokLokProvider lokLokProvider, Continuation<? super LokLokProvider$getMainPage$4> continuation) {
        super(1, continuation);
        this.$responseFirstPage = objectRef;
        this.this$0 = lokLokProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new LokLokProvider$getMainPage$4(this.$responseFirstPage, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Object> continuation) {
        return invoke2((Continuation<Object>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<Object> continuation) {
        return ((LokLokProvider$getMainPage$4) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Gson gson;
        ArrayList<HomePageList> arrayList;
        LokLokProvider lokLokProvider;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList<HomePageList> arrayList2 = this.$responseFirstPage.element;
            LokLokProvider lokLokProvider2 = this.this$0;
            Gson gson2 = new Gson();
            this.L$0 = arrayList2;
            this.L$1 = lokLokProvider2;
            this.L$2 = gson2;
            this.label = 1;
            obj2 = Requests.get$default(MainActivityKt.getApp(), "https://ga-mobile-api.loklok.tv/cms/app/homePage/getHome?page=2", LokLokProvider.Companion.getHEADER_DEFAULT(), null, null, null, false, 4, TimeUnit.HOURS, 0L, null, false, this, 1852, null);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            gson = gson2;
            arrayList = arrayList2;
            lokLokProvider = lokLokProvider2;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            gson = (Gson) this.L$2;
            lokLokProvider = (LokLokProvider) this.L$1;
            ResultKt.throwOnFailure(obj);
            arrayList = (ArrayList) this.L$0;
            obj2 = obj;
        }
        Object fromJson = gson.fromJson(((NiceResponse) obj2).getText(), (Class<Object>) LokLokProvider.HomeResponse.class);
        Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson<HomeResp…ava\n                    )");
        return boxing.boxBoolean(arrayList.addAll(lokLokProvider.toHomePageList((LokLokProvider.HomeResponse) fromJson)));
    }
}
