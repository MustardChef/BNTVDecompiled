package com.lagradost.cloudstream3;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.ads.interactivemedia.p034v3.internal.bqk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainAPI.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.APIHolder", m98f = "MainAPI.kt", m97i = {0, 0, 1, 1, 1}, m96l = {bqk.f6557bQ, bqk.f6562bV, bqk.f6526am}, m95m = "getCaptchaToken", m94n = {SDKConstants.PARAM_KEY, "domain", SDKConstants.PARAM_KEY, "domain", "vToken"}, m93s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
/* loaded from: classes3.dex */
public final class APIHolder$getCaptchaToken$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ APIHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public APIHolder$getCaptchaToken$1(APIHolder aPIHolder, Continuation<? super APIHolder$getCaptchaToken$1> continuation) {
        super(continuation);
        this.this$0 = aPIHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getCaptchaToken(null, null, null, this);
    }
}
