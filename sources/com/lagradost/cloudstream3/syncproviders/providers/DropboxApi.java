package com.lagradost.cloudstream3.syncproviders.providers;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.lagradost.cloudstream3.syncproviders.AuthAPI;
import com.lagradost.cloudstream3.syncproviders.OAuth2API;
import kotlin.Metadata;
import kotlin.Standard;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m108d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0019\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001aH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/providers/Dropbox;", "Lcom/lagradost/cloudstream3/syncproviders/OAuth2API;", "()V", "createAccountUrl", "", "getCreateAccountUrl", "()Ljava/lang/String;", "icon", "", "getIcon", "()Ljava/lang/Integer;", "idPrefix", "getIdPrefix", SDKConstants.PARAM_KEY, "getKey", "name", "getName", "setName", "(Ljava/lang/String;)V", "redirectUrl", "getRedirectUrl", "requiresLogin", "", "getRequiresLogin", "()Z", "authenticate", "", "handleRedirect", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logOut", "loginInfo", "Lcom/lagradost/cloudstream3/syncproviders/AuthAPI$LoginInfo;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.syncproviders.providers.Dropbox */
/* loaded from: classes3.dex */
public final class DropboxApi implements OAuth2API {
    private final String createAccountUrl;
    private final String idPrefix = "dropbox";
    private String name = "Dropbox";
    private final String key = "zlqsamadlwydvb2";
    private final String redirectUrl = "dropboxlogin";
    private final boolean requiresLogin = true;

    @Override // com.lagradost.cloudstream3.syncproviders.AuthAPI
    public String getIdPrefix() {
        return this.idPrefix;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.AuthAPI
    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.OAuth2API
    public String getKey() {
        return this.key;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.OAuth2API
    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.AuthAPI
    public boolean getRequiresLogin() {
        return this.requiresLogin;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.AuthAPI
    public String getCreateAccountUrl() {
        return this.createAccountUrl;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.AuthAPI
    public Integer getIcon() {
        throw new Standard("An operation is not implemented: Not yet implemented");
    }

    @Override // com.lagradost.cloudstream3.syncproviders.OAuth2API
    public void authenticate() {
        throw new Standard("An operation is not implemented: Not yet implemented");
    }

    @Override // com.lagradost.cloudstream3.syncproviders.OAuth2API
    public Object handleRedirect(String str, Continuation<? super Boolean> continuation) {
        throw new Standard("An operation is not implemented: Not yet implemented");
    }

    @Override // com.lagradost.cloudstream3.syncproviders.AuthAPI
    public void logOut() {
        throw new Standard("An operation is not implemented: Not yet implemented");
    }

    @Override // com.lagradost.cloudstream3.syncproviders.AuthAPI
    public AuthAPI.LoginInfo loginInfo() {
        throw new Standard("An operation is not implemented: Not yet implemented");
    }
}
