package com.lagradost.cloudstream3.movieproviders;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.ads.interactivemedia.p034v3.internal.bqk;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.ParCollections;
import com.lagradost.cloudstream3.movieproviders.MyCimaProvider;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MyCimaProvider.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "surl", "", "kotlin.jvm.PlatformType"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.MyCimaProvider$load$5", m98f = "MyCimaProvider.kt", m97i = {}, m96l = {bqk.f6552bL}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class MyCimaProvider$load$5 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayList<Episode> $episodes;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MyCimaProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyCimaProvider$load$5(MyCimaProvider myCimaProvider, ArrayList<Episode> arrayList, Continuation<? super MyCimaProvider$load$5> continuation) {
        super(2, continuation);
        this.this$0 = myCimaProvider;
        this.$episodes = arrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MyCimaProvider$load$5 myCimaProvider$load$5 = new MyCimaProvider$load$5(this.this$0, this.$episodes, continuation);
        myCimaProvider$load$5.L$0 = obj;
        return myCimaProvider$load$5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((MyCimaProvider$load$5) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Integer intFromText;
        Integer intFromText2;
        Integer intFromText3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String surl = (String) this.L$0;
            Intrinsics.checkNotNullExpressionValue(surl, "surl");
            if (StringsKt.contains$default((CharSequence) surl, (CharSequence) "%d9%85%d8%af%d8%a8%d9%84%d8%ac", false, 2, (Object) null)) {
                return Unit.INSTANCE;
            }
            this.label = 1;
            obj2 = Requests.get$default(MainActivityKt.getApp(), surl, null, null, null, null, false, 0, null, 0L, null, false, this, 2046, null);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        }
        Document document = ((NiceResponse) obj2).getDocument();
        Elements fmoreButton = document.select("div.MoreEpisodes--Button");
        MyCimaProvider myCimaProvider = this.this$0;
        String text = document.select("div.List--Seasons--Episodes a.selected").text();
        Intrinsics.checkNotNullExpressionValue(text, "seasonsite.select(\"div.L…sodes a.selected\").text()");
        intFromText = myCimaProvider.getIntFromText(text);
        int intValue = intFromText != null ? intFromText.intValue() : 1;
        Elements select = document.select("div.Seasons--Episodes div.Episodes--Seasons--Episodes a");
        Intrinsics.checkNotNullExpressionValue(select, "seasonsite.select(\"div.S…es--Seasons--Episodes a\")");
        Elements elements = select;
        ArrayList<Episode> arrayList = this.$episodes;
        MyCimaProvider myCimaProvider2 = this.this$0;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(elements, 10));
        for (Element element : elements) {
            String attr = element.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
            Intrinsics.checkNotNullExpressionValue(attr, "it.attr(\"href\")");
            String text2 = element.text();
            Integer boxInt = boxing.boxInt(intValue);
            String text3 = element.text();
            Intrinsics.checkNotNullExpressionValue(text3, "it.text()");
            intFromText3 = myCimaProvider2.getIntFromText(text3);
            arrayList2.add(boxing.boxBoolean(arrayList.add(new Episode(attr, text2, boxInt, intFromText3, null, null, null, null, 240, null))));
        }
        Intrinsics.checkNotNullExpressionValue(fmoreButton, "fmoreButton");
        if (!fmoreButton.isEmpty()) {
            int size = document.select("div.Seasons--Episodes div.Episodes--Seasons--Episodes a").size();
            MyCimaProvider myCimaProvider3 = this.this$0;
            Element first = document.select("div.Episodes--Seasons--Episodes a").first();
            Intrinsics.checkNotNull(first);
            String text4 = first.text();
            Intrinsics.checkNotNullExpressionValue(text4, "seasonsite.select(\"div.E…odes a\").first()!!.text()");
            intFromText2 = myCimaProvider3.getIntFromText(text4);
            ParCollections.apmap(CollectionsKt.arrayListOf(boxing.boxInt(size), boxing.boxInt(size + 40), boxing.boxInt(size + 80), boxing.boxInt(size + 120), boxing.boxInt(size + 160), boxing.boxInt(size + 200), boxing.boxInt(size + 240), boxing.boxInt(size + 280), boxing.boxInt(size + 320), boxing.boxInt(size + 360), boxing.boxInt(size + 400), boxing.boxInt(size + 440), boxing.boxInt(size + 480), boxing.boxInt(size + 520), boxing.boxInt(size + 660), boxing.boxInt(size + TypedValues.TransitionType.TYPE_DURATION), boxing.boxInt(size + 740), boxing.boxInt(size + 780), boxing.boxInt(size + 820), boxing.boxInt(size + 860), boxing.boxInt(size + 900), boxing.boxInt(size + 940), boxing.boxInt(size + 980), boxing.boxInt(size + 1020), boxing.boxInt(size + 1060), boxing.boxInt(size + 1100), boxing.boxInt(size + 1140), boxing.boxInt(size + 1180), boxing.boxInt(size + 1220), intFromText2), new C48122(intFromText2, this.this$0, fmoreButton, this.$episodes, intValue, null));
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyCimaProvider.kt */
    @Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "it", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.MyCimaProvider$load$5$2", m98f = "MyCimaProvider.kt", m97i = {}, m96l = {bqk.f6531ar}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.lagradost.cloudstream3.movieproviders.MyCimaProvider$load$5$2 */
    /* loaded from: classes3.dex */
    public static final class C48122 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<Episode> $episodes;
        final /* synthetic */ Elements $fmoreButton;
        final /* synthetic */ int $fseason;
        final /* synthetic */ Integer $totals;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MyCimaProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C48122(Integer num, MyCimaProvider myCimaProvider, Elements elements, ArrayList<Episode> arrayList, int i, Continuation<? super C48122> continuation) {
            super(2, continuation);
            this.$totals = num;
            this.this$0 = myCimaProvider;
            this.$fmoreButton = elements;
            this.$episodes = arrayList;
            this.$fseason = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C48122 c48122 = new C48122(this.$totals, this.this$0, this.$fmoreButton, this.$episodes, this.$fseason, continuation);
            c48122.L$0 = obj;
            return c48122;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Integer num, Continuation<? super Unit> continuation) {
            return ((C48122) create(num, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Integer intFromText;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Integer num = (Integer) this.L$0;
                if (num != null) {
                    int intValue = num.intValue();
                    Integer num2 = this.$totals;
                    Intrinsics.checkNotNull(num2);
                    if (intValue > num2.intValue()) {
                        return Unit.INSTANCE;
                    }
                    this.label = 1;
                    obj2 = Requests.get$default(MainActivityKt.getApp(), this.this$0.getMainUrl() + "/AjaxCenter/MoreEpisodes/" + this.$fmoreButton.attr("data-term") + JsonPointer.SEPARATOR + num, null, null, null, null, false, 0, null, 0L, null, false, this, 2046, null);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
                obj2 = obj;
            }
            AppUtils appUtils = AppUtils.INSTANCE;
            String output = ((MyCimaProvider.MoreEPS) MainAPIKt.getMapper().readValue(((NiceResponse) obj2).getText(), new TypeReference<MyCimaProvider.MoreEPS>() { // from class: com.lagradost.cloudstream3.movieproviders.MyCimaProvider$load$5$2$invokeSuspend$$inlined$parseJson$1
            })).getOutput();
            Elements select = Jsoup.parse(output != null ? StringsKt.replace$default(output, "\\", "", false, 4, (Object) null) : null).select("a");
            Intrinsics.checkNotNullExpressionValue(select, "document.select(\"a\")");
            Elements elements = select;
            ArrayList<Episode> arrayList = this.$episodes;
            int i2 = this.$fseason;
            MyCimaProvider myCimaProvider = this.this$0;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(elements, 10));
            for (Element element : elements) {
                String attr = element.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
                Intrinsics.checkNotNullExpressionValue(attr, "it.attr(\"href\")");
                String text = element.text();
                Integer boxInt = boxing.boxInt(i2);
                String text2 = element.text();
                Intrinsics.checkNotNullExpressionValue(text2, "it.text()");
                intFromText = myCimaProvider.getIntFromText(text2);
                arrayList2.add(boxing.boxBoolean(arrayList.add(new Episode(attr, text, boxInt, intFromText, null, null, null, null, 240, null))));
            }
            return Unit.INSTANCE;
        }
    }
}
