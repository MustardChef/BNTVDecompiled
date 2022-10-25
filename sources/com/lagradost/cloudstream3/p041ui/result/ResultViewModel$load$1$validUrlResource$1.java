package com.lagradost.cloudstream3.p041ui.result;

import com.google.android.gms.cast.MediaError;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.animeproviders.NineAnimeProvider;
import com.lagradost.cloudstream3.metaproviders.AnilistRedirector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* compiled from: ResultViewModel.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.result.ResultViewModel$load$1$validUrlResource$1", m98f = "ResultViewModel.kt", m97i = {}, m96l = {MediaError.DetailedErrorCode.SMOOTH_NETWORK}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultViewModel$load$1$validUrlResource$1 */
/* loaded from: classes4.dex */
final class ResultViewModel$load$1$validUrlResource$1 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    final /* synthetic */ MainAPI $api;
    final /* synthetic */ String $url;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultViewModel$load$1$validUrlResource$1(String str, MainAPI mainAPI, Continuation<? super ResultViewModel$load$1$validUrlResource$1> continuation) {
        super(1, continuation);
        this.$url = str;
        this.$api = mainAPI;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ResultViewModel$load$1$validUrlResource$1(this.$url, this.$api, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super String> continuation) {
        return ((ResultViewModel$load$1$validUrlResource$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = AnilistRedirector.INSTANCE.redirect(this.$url, StringsKt.replace$default(this.$api.getMainUrl(), new NineAnimeProvider().getMainUrl(), "9anime", false, 4, (Object) null), this);
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
