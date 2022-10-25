package com.lagradost.cloudstream3.syncproviders;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AuthAPI.kt */
@Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0016J\b\u0010\u0012\u001a\u00020\u0013H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/AuthAPI;", "", "createAccountUrl", "", "getCreateAccountUrl", "()Ljava/lang/String;", "icon", "", "getIcon", "()Ljava/lang/Integer;", "idPrefix", "getIdPrefix", "name", "getName", "requiresLogin", "", "getRequiresLogin", "()Z", "logOut", "", "loginInfo", "Lcom/lagradost/cloudstream3/syncproviders/AuthAPI$LoginInfo;", "LoginInfo", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public interface AuthAPI {
    String getCreateAccountUrl();

    Integer getIcon();

    String getIdPrefix();

    String getName();

    boolean getRequiresLogin();

    void logOut();

    LoginInfo loginInfo();

    /* compiled from: AuthAPI.kt */
    @Metadata(m108d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, m107d2 = {"Lcom/lagradost/cloudstream3/syncproviders/AuthAPI$LoginInfo;", "", "profilePicture", "", "name", "accountIndex", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getAccountIndex", "()I", "getName", "()Ljava/lang/String;", "getProfilePicture", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class LoginInfo {
        private final int accountIndex;
        private final String name;
        private final String profilePicture;

        public LoginInfo(String str, String str2, int i) {
            this.profilePicture = str;
            this.name = str2;
            this.accountIndex = i;
        }

        public /* synthetic */ LoginInfo(String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : str, str2, i);
        }

        public final String getProfilePicture() {
            return this.profilePicture;
        }

        public final String getName() {
            return this.name;
        }

        public final int getAccountIndex() {
            return this.accountIndex;
        }
    }
}
