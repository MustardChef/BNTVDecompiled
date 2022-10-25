package com.lagradost.cloudstream3.syncproviders;

import com.lagradost.cloudstream3.syncproviders.AuthAPI;
import com.lagradost.cloudstream3.syncproviders.InAppAuthAPI;
import kotlin.Metadata;
import kotlin.Standard;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: InAppAuthAPI.kt */
@Metadata(m108d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0011\u0010 \u001a\u00020!H\u0097@ø\u0001\u0000¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020!H\u0016J\u0019\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u001fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010&J\n\u0010'\u001a\u0004\u0018\u00010(H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/InAppAuthAPIManager;", "Lcom/lagradost/cloudstream3/syncproviders/AccountManager;", "Lcom/lagradost/cloudstream3/syncproviders/InAppAuthAPI;", "defIndex", "", "(I)V", "icon", "getIcon", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "idPrefix", "", "getIdPrefix", "()Ljava/lang/String;", "name", "getName", "requiresEmail", "", "getRequiresEmail", "()Z", "requiresLogin", "getRequiresLogin", "requiresPassword", "getRequiresPassword", "requiresServer", "getRequiresServer", "requiresUsername", "getRequiresUsername", "storesPasswordInPlainText", "getStoresPasswordInPlainText", "getLatestLoginData", "Lcom/lagradost/cloudstream3/syncproviders/InAppAuthAPI$LoginData;", "initialize", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logOut", "login", "data", "(Lcom/lagradost/cloudstream3/syncproviders/InAppAuthAPI$LoginData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginInfo", "Lcom/lagradost/cloudstream3/syncproviders/AuthAPI$LoginInfo;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public abstract class InAppAuthAPIManager extends AccountManager implements InAppAuthAPI {
    private final Integer icon;
    private final boolean requiresEmail;
    private final boolean requiresLogin;
    private final boolean requiresPassword;
    private final boolean requiresServer;
    private final boolean requiresUsername;
    private final boolean storesPasswordInPlainText;

    public Object initialize(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPI
    public Object login(InAppAuthAPI.LoginData loginData, Continuation<? super Boolean> continuation) {
        return login$suspendImpl(this, loginData, continuation);
    }

    public InAppAuthAPIManager(int i) {
        super(i);
        this.storesPasswordInPlainText = true;
        this.requiresLogin = true;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPI
    public boolean getRequiresPassword() {
        return this.requiresPassword;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPI
    public boolean getRequiresUsername() {
        return this.requiresUsername;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPI
    public boolean getRequiresEmail() {
        return this.requiresEmail;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPI
    public boolean getRequiresServer() {
        return this.requiresServer;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPI
    public boolean getStoresPasswordInPlainText() {
        return this.storesPasswordInPlainText;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.AuthAPI
    public boolean getRequiresLogin() {
        return this.requiresLogin;
    }

    @Override // com.lagradost.cloudstream3.syncproviders.AuthAPI
    public void logOut() {
        throw new Standard(null, 1, null);
    }

    @Override // com.lagradost.cloudstream3.syncproviders.AuthAPI
    public String getIdPrefix() {
        throw new Standard(null, 1, null);
    }

    @Override // com.lagradost.cloudstream3.syncproviders.AuthAPI
    public String getName() {
        throw new Standard(null, 1, null);
    }

    @Override // com.lagradost.cloudstream3.syncproviders.AuthAPI
    public Integer getIcon() {
        return this.icon;
    }

    static /* synthetic */ Object login$suspendImpl(InAppAuthAPIManager inAppAuthAPIManager, InAppAuthAPI.LoginData loginData, Continuation continuation) {
        throw new Standard(null, 1, null);
    }

    @Override // com.lagradost.cloudstream3.syncproviders.InAppAuthAPI
    public InAppAuthAPI.LoginData getLatestLoginData() {
        throw new Standard(null, 1, null);
    }

    @Override // com.lagradost.cloudstream3.syncproviders.AuthAPI
    public AuthAPI.LoginInfo loginInfo() {
        throw new Standard(null, 1, null);
    }
}
