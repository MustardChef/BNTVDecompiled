package com.lagradost.cloudstream3.movieproviders;

import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.core.JsonPointer;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.metaproviders.TmdbLink;
import com.lagradost.cloudstream3.utils.Extensions;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: TrailersTwoProvider.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.TrailersTwoProvider$loadLinks$3", m98f = "TrailersTwoProvider.kt", m97i = {1}, m96l = {183, 188}, m95m = "invokeSuspend", m94n = {"movieId"}, m93s = {"L$2"})
/* loaded from: classes3.dex */
final class TrailersTwoProvider$loadLinks$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ boolean $isMovie;
    final /* synthetic */ TmdbLink $mappedData;
    final /* synthetic */ String $videoUrl;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ TrailersTwoProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TrailersTwoProvider$loadLinks$3(TmdbLink tmdbLink, boolean z, String str, Function1<? super ExtractorLink, Unit> function1, TrailersTwoProvider trailersTwoProvider, Continuation<? super TrailersTwoProvider$loadLinks$3> continuation) {
        super(1, continuation);
        this.$mappedData = tmdbLink;
        this.$isMovie = z;
        this.$videoUrl = str;
        this.$callback = function1;
        this.this$0 = trailersTwoProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TrailersTwoProvider$loadLinks$3(this.$mappedData, this.$isMovie, this.$videoUrl, this.$callback, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TrailersTwoProvider$loadLinks$3) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        TrailersTwoProvider trailersTwoProvider;
        Object obj3;
        Function1<ExtractorLink, Unit> function1;
        String str;
        List<String> groupValues;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String movieName = this.$mappedData.getMovieName();
            if (movieName != null && this.$isMovie) {
                Extensions.RequestCustom app = MainActivityKt.getApp();
                this.label = 1;
                obj2 = Requests.get$default(app, "https://trailers.to/en/quick-search?q=" + movieName, null, null, null, null, false, 0, null, 0L, null, false, this, 2046, null);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        } else {
            if (i == 2) {
                function1 = (Function1) this.L$0;
                ResultKt.throwOnFailure(obj);
                trailersTwoProvider = (TrailersTwoProvider) this.L$1;
                str = (String) this.L$2;
                obj3 = obj;
                String url = ((NiceResponse) obj3).getUrl();
                function1.invoke(new ExtractorLink(trailersTwoProvider.getName(), trailersTwoProvider.getName() + " Backup", StringsKt.replace$default(url, JsonPointer.SEPARATOR + trailersTwoProvider.getUser() + "/0/", JsonPointer.SEPARATOR + trailersTwoProvider.getUser() + JsonPointer.SEPARATOR + str + JsonPointer.SEPARATOR, false, 4, (Object) null), "https://trailers.to", Qualities.Unknown.getValue(), false, null, null, 192, null));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Elements select = ((NiceResponse) obj2).getDocument().select("a.post-minimal");
        Intrinsics.checkNotNullExpressionValue(select, "app.get(\"https://trailer….select(\"a.post-minimal\")");
        ArrayList arrayList = new ArrayList();
        Iterator<Element> it = select.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Element next = it.next();
            String attr = next != null ? next.attr(ShareConstants.WEB_DIALOG_PARAM_HREF) : null;
            if (attr != null) {
                arrayList.add(attr);
            }
        }
        ArrayList<String> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (String str2 : arrayList2) {
            MatchResult find$default = Regex.find$default(new Regex("/movie/(\\d+)/"), str2, 0, 2, null);
            arrayList3.add((find$default == null || (groupValues = find$default.getGroupValues()) == null) ? null : (String) CollectionsKt.getOrNull(groupValues, 1));
        }
        String str3 = (String) CollectionsKt.firstOrNull((List<? extends Object>) arrayList3);
        if (str3 != null) {
            String str4 = this.$videoUrl;
            Function1<ExtractorLink, Unit> function12 = this.$callback;
            TrailersTwoProvider trailersTwoProvider2 = this.this$0;
            this.L$0 = function12;
            this.L$1 = trailersTwoProvider2;
            this.L$2 = str3;
            this.label = 2;
            trailersTwoProvider = trailersTwoProvider2;
            obj3 = Requests.get$default(MainActivityKt.getApp(), str4, null, null, null, null, false, 0, null, 0L, null, false, this, 2046, null);
            if (obj3 == coroutine_suspended) {
                return coroutine_suspended;
            }
            function1 = function12;
            str = str3;
            String url2 = ((NiceResponse) obj3).getUrl();
            function1.invoke(new ExtractorLink(trailersTwoProvider.getName(), trailersTwoProvider.getName() + " Backup", StringsKt.replace$default(url2, JsonPointer.SEPARATOR + trailersTwoProvider.getUser() + "/0/", JsonPointer.SEPARATOR + trailersTwoProvider.getUser() + JsonPointer.SEPARATOR + str + JsonPointer.SEPARATOR, false, 4, (Object) null), "https://trailers.to", Qualities.Unknown.getValue(), false, null, null, 192, null));
        }
        return Unit.INSTANCE;
    }
}
