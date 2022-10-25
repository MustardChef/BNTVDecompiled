package com.lagradost.cloudstream3.movieproviders;

import com.facebook.share.internal.ShareConstants;
import com.google.ads.interactivemedia.p034v3.internal.bqk;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.ParCollections;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
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
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CinecalidadProvider.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "kotlin.jvm.PlatformType"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.CinecalidadProvider$loadLinks$4", m98f = "CinecalidadProvider.kt", m97i = {}, m96l = {bqk.f6541bA}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class CinecalidadProvider$loadLinks$4 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $data;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CinecalidadProvider$loadLinks$4(String str, Function1<? super SubtitleFile, Unit> function1, Continuation<? super CinecalidadProvider$loadLinks$4> continuation) {
        super(2, continuation);
        this.$data = str;
        this.$subtitleCallback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CinecalidadProvider$loadLinks$4 cinecalidadProvider$loadLinks$4 = new CinecalidadProvider$loadLinks$4(this.$data, this.$subtitleCallback, continuation);
        cinecalidadProvider$loadLinks$4.L$0 = obj;
        return cinecalidadProvider$loadLinks$4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Element element, Continuation<? super Unit> continuation) {
        return ((CinecalidadProvider$loadLinks$4) create(element, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        Object obj2;
        MatchResult.Destructured destructured;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Element element = (Element) this.L$0;
            if (StringsKt.contains$default((CharSequence) this.$data, (CharSequence) "serie", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this.$data, (CharSequence) "episodio", false, 2, (Object) null)) {
                str = this.$data + element.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
            } else {
                str = element.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
            }
            String link = str;
            Intrinsics.checkNotNullExpressionValue(link, "link");
            this.label = 1;
            obj2 = Requests.get$default(MainActivityKt.getApp(), link, null, null, null, null, false, 0, null, 0L, null, false, this, 2046, null);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        }
        NiceResponse niceResponse = (NiceResponse) obj2;
        Document document = niceResponse.getDocument();
        String text = niceResponse.getText();
        if (StringsKt.contains$default((CharSequence) text, (CharSequence) "Subtítulo", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) text, (CharSequence) "Forzados", false, 2, (Object) null)) {
            Regex regex = new Regex("(Subtítulo.*$|Forzados.*$)");
            Element selectFirst = document.selectFirst("div.titulo h3");
            Intrinsics.checkNotNull(selectFirst);
            String langdoc = selectFirst.text();
            Intrinsics.checkNotNullExpressionValue(langdoc, "langdoc");
            MatchResult find$default = Regex.find$default(regex, langdoc, 0, 2, null);
            String str2 = (find$default == null || (destructured = find$default.getDestructured()) == null) ? null : destructured.getMatch().getGroupValues().get(1);
            Elements select = document.select("a.link");
            Intrinsics.checkNotNullExpressionValue(select, "linksub.select(\"a.link\")");
            ParCollections.apmap(select, new C47821(this.$data, this.$subtitleCallback, str2, null));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CinecalidadProvider.kt */
    @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "kotlin.jvm.PlatformType"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.CinecalidadProvider$loadLinks$4$1", m98f = "CinecalidadProvider.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.lagradost.cloudstream3.movieproviders.CinecalidadProvider$loadLinks$4$1 */
    /* loaded from: classes3.dex */
    public static final class C47821 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $data;
        final /* synthetic */ String $reallang;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C47821(String str, Function1<? super SubtitleFile, Unit> function1, String str2, Continuation<? super C47821> continuation) {
            super(2, continuation);
            this.$data = str;
            this.$subtitleCallback = function1;
            this.$reallang = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C47821 c47821 = new C47821(this.$data, this.$subtitleCallback, this.$reallang, continuation);
            c47821.L$0 = obj;
            return c47821;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Element element, Continuation<? super Unit> continuation) {
            return ((C47821) create(element, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Element element = (Element) this.L$0;
                if (StringsKt.contains$default((CharSequence) this.$data, (CharSequence) "serie", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) this.$data, (CharSequence) "episodio", false, 2, (Object) null)) {
                    str = this.$data + element.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
                } else {
                    str = element.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
                }
                String sublink = str;
                Function1<SubtitleFile, Unit> function1 = this.$subtitleCallback;
                String str2 = this.$reallang;
                Intrinsics.checkNotNull(str2);
                Intrinsics.checkNotNullExpressionValue(sublink, "sublink");
                function1.invoke(new SubtitleFile(str2, sublink, null, 4, null));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
