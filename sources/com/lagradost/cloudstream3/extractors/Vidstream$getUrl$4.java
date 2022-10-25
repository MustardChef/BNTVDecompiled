package com.lagradost.cloudstream3.extractors;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.ParCollections;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import java.util.ArrayList;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* compiled from: Vidstream.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.extractors.Vidstream$getUrl$4", m98f = "Vidstream.kt", m97i = {}, m96l = {79}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
final class Vidstream$getUrl$4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ String $extractorUrl;
    final /* synthetic */ boolean $isCasting;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Vidstream$getUrl$4(String str, boolean z, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super Vidstream$getUrl$4> continuation) {
        super(1, continuation);
        this.$extractorUrl = str;
        this.$isCasting = z;
        this.$subtitleCallback = function1;
        this.$callback = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new Vidstream$getUrl$4(this.$extractorUrl, this.$isCasting, this.$subtitleCallback, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((Vidstream$getUrl$4) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj2 = Requests.get$default(MainActivityKt.getApp(), this.$extractorUrl, null, null, null, null, false, 0, null, 0L, null, false, this, 2046, null);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        }
        boolean z = this.$isCasting;
        String str = this.$extractorUrl;
        Function1<SubtitleFile, Unit> function1 = this.$subtitleCallback;
        Function1<ExtractorLink, Unit> function12 = this.$callback;
        Elements primaryLinks = Jsoup.parse(((NiceResponse) obj2).getText()).select("ul.list-server-items > li.linkserver");
        Intrinsics.checkNotNullExpressionValue(primaryLinks, "primaryLinks");
        HashSet hashSet = new HashSet();
        ArrayList<Element> arrayList = new ArrayList();
        for (Element element : primaryLinks) {
            if (hashSet.add(element.attr("data-video"))) {
                arrayList.add(element);
            }
        }
        for (Element element2 : arrayList) {
            String attr = element2.attr("data-video");
            ExtractorApi[] extractorApis = ExtractorApiKt.getExtractorApis();
            ArrayList arrayList2 = new ArrayList();
            for (ExtractorApi extractorApi : extractorApis) {
                if ((extractorApi.getRequiresReferer() && z) ? false : true) {
                    arrayList2.add(extractorApi);
                }
            }
            ParCollections.apmap(arrayList2, new Vidstream$getUrl$4$1$2$2(attr, str, function1, function12, null));
        }
        return Unit.INSTANCE;
    }
}
