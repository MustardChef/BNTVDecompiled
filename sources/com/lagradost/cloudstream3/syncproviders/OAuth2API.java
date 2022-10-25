package com.lagradost.cloudstream3.syncproviders;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: OAuth2API.kt */
@Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH&J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/OAuth2API;", "Lcom/lagradost/cloudstream3/syncproviders/AuthAPI;", SDKConstants.PARAM_KEY, "", "getKey", "()Ljava/lang/String;", "redirectUrl", "getRedirectUrl", "authenticate", "", "handleRedirect", "", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public interface OAuth2API extends AuthAPI {
    void authenticate();

    String getKey();

    String getRedirectUrl();

    Object handleRedirect(String str, Continuation<? super Boolean> continuation);
}
