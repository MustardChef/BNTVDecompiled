package com.lagradost.cloudstream3.syncproviders;

import com.applovin.sdk.AppLovinEventParameters;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InAppAuthAPI.kt */
@Metadata(m108d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0013J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0019\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000fH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/InAppAuthAPI;", "Lcom/lagradost/cloudstream3/syncproviders/AuthAPI;", "requiresEmail", "", "getRequiresEmail", "()Z", "requiresPassword", "getRequiresPassword", "requiresServer", "getRequiresServer", "requiresUsername", "getRequiresUsername", "storesPasswordInPlainText", "getStoresPasswordInPlainText", "getLatestLoginData", "Lcom/lagradost/cloudstream3/syncproviders/InAppAuthAPI$LoginData;", "login", "data", "(Lcom/lagradost/cloudstream3/syncproviders/InAppAuthAPI$LoginData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LoginData", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public interface InAppAuthAPI extends AuthAPI {
    LoginData getLatestLoginData();

    boolean getRequiresEmail();

    boolean getRequiresPassword();

    boolean getRequiresServer();

    boolean getRequiresUsername();

    boolean getStoresPasswordInPlainText();

    Object login(LoginData loginData, Continuation<? super Boolean> continuation);

    /* compiled from: InAppAuthAPI.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/InAppAuthAPI$LoginData;", "", AppLovinEventParameters.USER_ACCOUNT_IDENTIFIER, "", "password", "server", "email", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getPassword", "getServer", "getUsername", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class LoginData {
        private final String email;
        private final String password;
        private final String server;
        private final String username;

        public LoginData() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ LoginData copy$default(LoginData loginData, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loginData.username;
            }
            if ((i & 2) != 0) {
                str2 = loginData.password;
            }
            if ((i & 4) != 0) {
                str3 = loginData.server;
            }
            if ((i & 8) != 0) {
                str4 = loginData.email;
            }
            return loginData.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return this.username;
        }

        public final String component2() {
            return this.password;
        }

        public final String component3() {
            return this.server;
        }

        public final String component4() {
            return this.email;
        }

        public final LoginData copy(String str, String str2, String str3, String str4) {
            return new LoginData(str, str2, str3, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LoginData) {
                LoginData loginData = (LoginData) obj;
                return Intrinsics.areEqual(this.username, loginData.username) && Intrinsics.areEqual(this.password, loginData.password) && Intrinsics.areEqual(this.server, loginData.server) && Intrinsics.areEqual(this.email, loginData.email);
            }
            return false;
        }

        public int hashCode() {
            String str = this.username;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.password;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.server;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.email;
            return hashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "LoginData(username=" + this.username + ", password=" + this.password + ", server=" + this.server + ", email=" + this.email + ')';
        }

        public LoginData(String str, String str2, String str3, String str4) {
            this.username = str;
            this.password = str2;
            this.server = str3;
            this.email = str4;
        }

        public /* synthetic */ LoginData(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
        }

        public final String getUsername() {
            return this.username;
        }

        public final String getPassword() {
            return this.password;
        }

        public final String getServer() {
            return this.server;
        }

        public final String getEmail() {
            return this.email;
        }
    }
}
