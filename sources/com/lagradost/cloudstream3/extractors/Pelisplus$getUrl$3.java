package com.lagradost.cloudstream3.extractors;

import com.facebook.share.internal.ShareConstants;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.ParCollections;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Pelisplus.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001H\u008a@"}, m107d2 = {"<anonymous>", "", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.extractors.Pelisplus$getUrl$3", m98f = "Pelisplus.kt", m97i = {0}, m96l = {48}, m95m = "invokeSuspend", m94n = {"link"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class Pelisplus$getUrl$3 extends SuspendLambda implements Function1<Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ String $extractorUrl;
    final /* synthetic */ String $id;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    Object L$0;
    int label;
    final /* synthetic */ Pelisplus this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Pelisplus$getUrl$3(Pelisplus pelisplus, String str, String str2, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super Pelisplus$getUrl$3> continuation) {
        super(1, continuation);
        this.this$0 = pelisplus;
        this.$id = str;
        this.$extractorUrl = str2;
        this.$subtitleCallback = function1;
        this.$callback = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new Pelisplus$getUrl$3(this.this$0, this.$id, this.$extractorUrl, this.$subtitleCallback, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super List<? extends Unit>> continuation) {
        return invoke2((Continuation<? super List<Unit>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super List<Unit>> continuation) {
        return ((Pelisplus$getUrl$3) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String downloadUrl;
        Object obj2;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            downloadUrl = this.this$0.getDownloadUrl(this.$id);
            System.out.println((Object) ("Generated vidstream download link: " + downloadUrl));
            this.L$0 = downloadUrl;
            this.label = 1;
            obj2 = Requests.get$default(MainActivityKt.getApp(), downloadUrl, null, this.$extractorUrl, null, null, false, 0, null, 0L, null, false, this, 2042, null);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = downloadUrl;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
            str = (String) this.L$0;
        }
        NiceResponse niceResponse = (NiceResponse) obj2;
        Document parse = Jsoup.parse(niceResponse.getText());
        Regex regex = new Regex("(\\d+)P");
        Elements select = parse.select(".dowload > a");
        if (select != null) {
            return ParCollections.apmap(select, new C47731(regex, str, this.$subtitleCallback, this.$callback, this.this$0, niceResponse, null));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Pelisplus.kt */
    @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "element", "Lorg/jsoup/nodes/Element;", "kotlin.jvm.PlatformType"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.extractors.Pelisplus$getUrl$3$1", m98f = "Pelisplus.kt", m97i = {0, 0, 0}, m96l = {61}, m95m = "invokeSuspend", m94n = {"element", ShareConstants.WEB_DIALOG_PARAM_HREF, "qual"}, m93s = {"L$0", "L$1", "L$2"})
    /* renamed from: com.lagradost.cloudstream3.extractors.Pelisplus$getUrl$3$1 */
    /* loaded from: classes3.dex */
    public static final class C47731 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $link;
        final /* synthetic */ NiceResponse $page;
        final /* synthetic */ Regex $qualityRegex;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ Pelisplus this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C47731(Regex regex, String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Pelisplus pelisplus, NiceResponse niceResponse, Continuation<? super C47731> continuation) {
            super(2, continuation);
            this.$qualityRegex = regex;
            this.$link = str;
            this.$subtitleCallback = function1;
            this.$callback = function12;
            this.this$0 = pelisplus;
            this.$page = niceResponse;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C47731 c47731 = new C47731(this.$qualityRegex, this.$link, this.$subtitleCallback, this.$callback, this.this$0, this.$page, continuation);
            c47731.L$0 = obj;
            return c47731;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Element element, Continuation<? super Unit> continuation) {
            return ((C47731) create(element, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Element element;
            String valueOf;
            MatchResult.Destructured destructured;
            Object loadExtractor;
            String str;
            String str2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                element = (Element) this.L$0;
                String attr = element.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
                if (attr == null) {
                    return Unit.INSTANCE;
                }
                String text = element.text();
                Intrinsics.checkNotNullExpressionValue(text, "element.text()");
                if (StringsKt.contains$default((CharSequence) text, (CharSequence) "HDP", false, 2, (Object) null)) {
                    valueOf = "1080";
                } else {
                    Regex regex = this.$qualityRegex;
                    String text2 = element.text();
                    Intrinsics.checkNotNullExpressionValue(text2, "element.text()");
                    MatchResult find$default = Regex.find$default(regex, text2, 0, 2, null);
                    valueOf = String.valueOf((find$default == null || (destructured = find$default.getDestructured()) == null) ? null : destructured.getMatch().getGroupValues().get(1));
                }
                this.L$0 = element;
                this.L$1 = attr;
                this.L$2 = valueOf;
                this.label = 1;
                loadExtractor = ExtractorApiKt.loadExtractor(attr, this.$link, this.$subtitleCallback, this.$callback, this);
                if (loadExtractor == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = attr;
                str2 = valueOf;
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                str2 = (String) this.L$2;
                ResultKt.throwOnFailure(obj);
                str = (String) this.L$1;
                element = (Element) this.L$0;
                loadExtractor = obj;
            }
            if (!((Boolean) loadExtractor).booleanValue()) {
                Function1<ExtractorLink, Unit> function1 = this.$callback;
                String name = this.this$0.getName();
                String name2 = this.this$0.getName();
                String url = this.$page.getUrl();
                int qualityFromName = ExtractorApiKt.getQualityFromName(str2);
                String attr2 = element.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
                Intrinsics.checkNotNullExpressionValue(attr2, "element.attr(\"href\")");
                function1.invoke(new ExtractorLink(name, name2, str, url, qualityFromName, StringsKt.contains$default((CharSequence) attr2, (CharSequence) ".m3u8", false, 2, (Object) null), null, null, 192, null));
            }
            return Unit.INSTANCE;
        }
    }
}
