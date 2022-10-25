package com.lagradost.cloudstream3.movieproviders;

import androidx.mediarouter.media.MediaRouterJellybean;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.ads.interactivemedia.p034v3.internal.bqk;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.movieproviders.TheFlixToProvider;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jsoup.nodes.Element;

/* compiled from: TheFlixToProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "url", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.TheFlixToProvider$search$2", m98f = "TheFlixToProvider.kt", m97i = {}, m96l = {bqk.f6597cd}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
final class TheFlixToProvider$search$2 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayList<SearchResponse> $search;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TheFlixToProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TheFlixToProvider$search$2(TheFlixToProvider theFlixToProvider, ArrayList<SearchResponse> arrayList, Continuation<? super TheFlixToProvider$search$2> continuation) {
        super(2, continuation);
        this.this$0 = theFlixToProvider;
        this.$search = arrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TheFlixToProvider$search$2 theFlixToProvider$search$2 = new TheFlixToProvider$search$2(this.this$0, this.$search, continuation);
        theFlixToProvider$search$2.L$0 = obj;
        return theFlixToProvider$search$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((TheFlixToProvider$search$2) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        String cleanTitle;
        String sb;
        boolean add;
        String cleanTitle2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.L$0;
            this.label = 1;
            obj2 = Requests.get$default(MainActivityKt.getApp(), str, null, null, null, null, false, 0, null, 0L, null, false, this, 2046, null);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        }
        Element selectFirst = ((NiceResponse) obj2).getDocument().selectFirst("script[type=application/json]");
        Intrinsics.checkNotNull(selectFirst);
        String scriptText = selectFirst.data();
        Intrinsics.checkNotNullExpressionValue(scriptText, "scriptText");
        boolean z2 = false;
        if (StringsKt.contains$default((CharSequence) scriptText, (CharSequence) "pageProps", false, 2, (Object) null)) {
            AppUtils appUtils = AppUtils.INSTANCE;
            TheFlixToProvider.SearchMainList mainList = ((TheFlixToProvider.SearchJson) MainAPIKt.getMapper().readValue(scriptText, new TypeReference<TheFlixToProvider.SearchJson>() { // from class: com.lagradost.cloudstream3.movieproviders.TheFlixToProvider$search$2$invokeSuspend$$inlined$parseJson$1
            })).getProps().getPageProps().getMainList();
            List<Tuples> listOf = CollectionsKt.listOf(new Tuples(mainList.getDocs(), mainList.getType()));
            TheFlixToProvider theFlixToProvider = this.this$0;
            ArrayList<SearchResponse> arrayList = this.$search;
            int i2 = 10;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf, 10));
            for (Tuples tuples : listOf) {
                String str2 = (String) tuples.component2();
                ArrayList<TheFlixToProvider.Docs> arrayList3 = (ArrayList) tuples.component1();
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, i2));
                for (TheFlixToProvider.Docs docs : arrayList3) {
                    String name = docs.getName();
                    String posterUrl = docs.getPosterUrl();
                    TvType tvType = str2 != null && StringsKt.contains$default(str2, "TV", z2, 2, (Object) null) == z ? TvType.TvSeries : TvType.Movie;
                    if (tvType == TvType.Movie) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(theFlixToProvider.getMainUrl());
                        sb2.append("/movie/");
                        sb2.append(docs.getId());
                        sb2.append('-');
                        cleanTitle2 = theFlixToProvider.cleanTitle(name);
                        sb2.append(cleanTitle2);
                        sb = sb2.toString();
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(theFlixToProvider.getMainUrl());
                        sb3.append("/tv-show/");
                        sb3.append(docs.getId());
                        sb3.append('-');
                        cleanTitle = theFlixToProvider.cleanTitle(name);
                        sb3.append(cleanTitle);
                        sb3.append("/season-1/episode-1");
                        sb = sb3.toString();
                    }
                    String str3 = sb;
                    if (tvType == TvType.Movie) {
                        add = arrayList.add(new MovieSearchResponse(name, str3, theFlixToProvider.getName(), TvType.Movie, posterUrl, null, null, null, null, 448, null));
                    } else {
                        add = arrayList.add(new TvSeriesSearchResponse(name, str3, theFlixToProvider.getName(), TvType.TvSeries, posterUrl, null, null, null, null, null, MediaRouterJellybean.DEVICE_OUT_BLUETOOTH, null));
                    }
                    arrayList4.add(boxing.boxBoolean(add));
                    z = true;
                    z2 = false;
                }
                arrayList2.add(arrayList4);
                z = true;
                z2 = false;
                i2 = 10;
            }
        }
        return Unit.INSTANCE;
    }
}
