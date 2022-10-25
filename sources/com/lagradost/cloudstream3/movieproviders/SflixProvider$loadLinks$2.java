package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.movieproviders.SflixProvider;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.utils.Extensions;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
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
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SflixProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "url", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.SflixProvider$loadLinks$2", m98f = "SflixProvider.kt", m97i = {}, m96l = {329}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class SflixProvider$loadLinks$2 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SflixProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SflixProvider$loadLinks$2(SflixProvider sflixProvider, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super SflixProvider$loadLinks$2> continuation) {
        super(2, continuation);
        this.this$0 = sflixProvider;
        this.$subtitleCallback = function1;
        this.$callback = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SflixProvider$loadLinks$2 sflixProvider$loadLinks$2 = new SflixProvider$loadLinks$2(this.this$0, this.$subtitleCallback, this.$callback, continuation);
        sflixProvider$loadLinks$2.L$0 = obj;
        return sflixProvider$loadLinks$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((SflixProvider$loadLinks$2) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SflixProvider.kt */
    @Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.SflixProvider$loadLinks$2$1", m98f = "SflixProvider.kt", m97i = {}, m96l = {340, 348, 350}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.lagradost.cloudstream3.movieproviders.SflixProvider$loadLinks$2$1 */
    /* loaded from: classes3.dex */
    public static final class C48231 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        final /* synthetic */ String $url;
        int label;
        final /* synthetic */ SflixProvider this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SflixProvider.kt */
        @Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "it", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
        /* renamed from: com.lagradost.cloudstream3.movieproviders.SflixProvider$loadLinks$2$1$1 */
        /* loaded from: classes3.dex */
        public static final class C48241 extends Lambda implements Function1<String, String> {
            public static final C48241 INSTANCE = new C48241();

            C48241() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C48231(String str, SflixProvider sflixProvider, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super C48231> continuation) {
            super(1, continuation);
            this.$url = str;
            this.this$0 = sflixProvider;
            this.$subtitleCallback = function1;
            this.$callback = function12;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C48231(this.$url, this.this$0, this.$subtitleCallback, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C48231) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object extractRabbitStream;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String substringAfterLast$default = StringsKt.substringAfterLast$default(this.$url, ".", (String) null, 2, (Object) null);
                Extensions.RequestCustom app = MainActivityKt.getApp();
                this.label = 1;
                obj2 = Requests.get$default(app, this.this$0.getMainUrl() + "/ajax/get_link/" + substringAfterLast$default, null, null, null, null, false, 0, null, 0L, null, false, this, 2046, null);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                if (i == 2 || i == 3) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
                obj2 = obj;
            }
            String link = ((SflixProvider.IframeJson) Requests.Companion.getMapper().readValue(((NiceResponse) obj2).getText(), new TypeReference<SflixProvider.IframeJson>() { // from class: com.lagradost.cloudstream3.movieproviders.SflixProvider$loadLinks$2$1$invokeSuspend$$inlined$parsed$1
            })).getLink();
            if (link == null) {
                return Unit.INSTANCE;
            }
            if (StringsKt.contains((CharSequence) link, (CharSequence) "streamlare", true)) {
                this.label = 2;
                if (ExtractorApiKt.loadExtractor(link, null, this.$subtitleCallback, this.$callback, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.label = 3;
                extractRabbitStream = SflixProvider.Companion.extractRabbitStream(this.this$0, link, this.$subtitleCallback, this.$callback, false, (r19 & 16) != 0 ? null : null, C48241.INSTANCE, this);
                if (extractRabbitStream == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ArchComponentExt.suspendSafeApiCall(new C48231((String) this.L$0, this.this$0, this.$subtitleCallback, this.$callback, null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
