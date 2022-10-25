package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.movieproviders.TheFlixToProvider;
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
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TheFlixToProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "id", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.TheFlixToProvider$loadLinks$3$1$1", m98f = "TheFlixToProvider.kt", m97i = {}, m96l = {582}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class TheFlixToProvider$loadLinks$3$1$1 extends SuspendLambda implements Function2<String, Continuation<? super Object>, Object> {
    final /* synthetic */ String $authhost;
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ Regex $qualityReg;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TheFlixToProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TheFlixToProvider$loadLinks$3$1$1(String str, Regex regex, Function1<? super ExtractorLink, Unit> function1, TheFlixToProvider theFlixToProvider, Continuation<? super TheFlixToProvider$loadLinks$3$1$1> continuation) {
        super(2, continuation);
        this.$authhost = str;
        this.$qualityReg = regex;
        this.$callback = function1;
        this.this$0 = theFlixToProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TheFlixToProvider$loadLinks$3$1$1 theFlixToProvider$loadLinks$3$1$1 = new TheFlixToProvider$loadLinks$3$1$1(this.$authhost, this.$qualityReg, this.$callback, this.this$0, continuation);
        theFlixToProvider$loadLinks$3$1$1.L$0 = obj;
        return theFlixToProvider$loadLinks$3$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(String str, Continuation<? super Object> continuation) {
        return invoke2(str, (Continuation<Object>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(String str, Continuation<Object> continuation) {
        return ((TheFlixToProvider$loadLinks$3$1$1) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object obj3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Extensions.RequestCustom app = MainActivityKt.getApp();
            this.label = 1;
            obj2 = Requests.get$default(app, this.$authhost + "/tv/videos/" + ((String) this.L$0) + "/request-access?contentUsageType=Viewing", TheFlixToProvider.Companion.getLatestCookies(), null, null, null, false, 0, null, 0L, null, false, this, 2044, null);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        }
        try {
            obj3 = Requests.Companion.getMapper().readValue(((NiceResponse) obj2).getText(), new TypeReference<TheFlixToProvider.VideoData>() { // from class: com.lagradost.cloudstream3.movieproviders.TheFlixToProvider$loadLinks$3$1$1$invokeSuspend$$inlined$parsedSafe$1
            });
        } catch (Exception e) {
            e.printStackTrace();
            obj3 = null;
        }
        TheFlixToProvider.VideoData videoData = (TheFlixToProvider.VideoData) obj3;
        if (videoData == null) {
            return boxing.boxBoolean(false);
        }
        String url = videoData.getUrl();
        String str = url;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            return null;
        }
        MatchResult find$default = Regex.find$default(this.$qualityReg, str, 0, 2, null);
        this.$callback.invoke(new ExtractorLink(this.this$0.getName(), this.this$0.getName(), url, "", ExtractorApiKt.getQualityFromName((find$default == null || (r0 = find$default.getValue()) == null) ? "" : ""), false, null, null, 192, null));
        return Unit.INSTANCE;
    }
}
