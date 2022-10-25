package com.google.firebase.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p038firebaseauthapi.zzua;
import com.google.android.gms.internal.p038firebaseauthapi.zzvh;
import com.google.firebase.auth.internal.GenericIdpActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public class OAuthProvider extends FederatedAuthProvider {
    private final Bundle zza;

    /* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
    /* loaded from: classes3.dex */
    public static class Builder {
        final Bundle zza;
        private final FirebaseAuth zzb;
        private final Bundle zzc;

        /* synthetic */ Builder(String str, FirebaseAuth firebaseAuth, zzab zzabVar) {
            Bundle bundle = new Bundle();
            this.zza = bundle;
            Bundle bundle2 = new Bundle();
            this.zzc = bundle2;
            this.zzb = firebaseAuth;
            bundle.putString("com.google.firebase.auth.KEY_API_KEY", firebaseAuth.zze().getOptions().getApiKey());
            bundle.putString("com.google.firebase.auth.KEY_PROVIDER_ID", str);
            bundle.putBundle("com.google.firebase.auth.KEY_PROVIDER_CUSTOM_PARAMS", bundle2);
            bundle.putString("com.google.firebase.auth.internal.CLIENT_VERSION", zzua.zzb().zza());
            bundle.putString("com.google.firebase.auth.KEY_TENANT_ID", firebaseAuth.getTenantId());
            bundle.putString("com.google.firebase.auth.KEY_FIREBASE_APP_NAME", firebaseAuth.zze().getName());
        }

        public Builder addCustomParameter(String str, String str2) {
            this.zzc.putString(str, str2);
            return this;
        }

        public Builder addCustomParameters(Map<String, String> map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.zzc.putString(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public OAuthProvider build() {
            return new OAuthProvider(this.zza, null);
        }

        public List<String> getScopes() {
            ArrayList<String> stringArrayList = this.zza.getStringArrayList("com.google.firebase.auth.KEY_PROVIDER_SCOPES");
            return stringArrayList != null ? stringArrayList : Collections.emptyList();
        }

        public Builder setScopes(List<String> list) {
            this.zza.putStringArrayList("com.google.firebase.auth.KEY_PROVIDER_SCOPES", new ArrayList<>(list));
            return this;
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
    /* loaded from: classes3.dex */
    public static class CredentialBuilder {
        private final String zza;
        private String zzb;
        private String zzc;
        private String zzd;

        /* synthetic */ CredentialBuilder(String str, zzab zzabVar) {
            this.zza = str;
        }

        public AuthCredential build() {
            String str = this.zza;
            String str2 = this.zzb;
            String str3 = this.zzc;
            String str4 = this.zzd;
            Parcelable.Creator<zze> creator = zze.CREATOR;
            Preconditions.checkNotEmpty(str, "Must specify a non-empty providerId");
            if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
                return new zze(str, str2, str3, null, null, null, str4);
            }
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }

        public String getAccessToken() {
            return this.zzc;
        }

        public String getIdToken() {
            return this.zzb;
        }

        public CredentialBuilder setAccessToken(String str) {
            this.zzc = str;
            return this;
        }

        public CredentialBuilder setIdToken(String str) {
            this.zzb = str;
            return this;
        }

        public CredentialBuilder setIdTokenWithRawNonce(String str, String str2) {
            this.zzb = str;
            this.zzd = str2;
            return this;
        }
    }

    /* synthetic */ OAuthProvider(Bundle bundle, zzab zzabVar) {
        this.zza = bundle;
    }

    @Deprecated
    public static AuthCredential getCredential(String str, String str2, String str3) {
        return zze.zzb(str, str2, str3, null, null);
    }

    public static Builder newBuilder(String str) {
        return newBuilder(str, FirebaseAuth.getInstance());
    }

    public static CredentialBuilder newCredentialBuilder(String str) {
        return new CredentialBuilder(Preconditions.checkNotEmpty(str), null);
    }

    public String getProviderId() {
        return this.zza.getString("com.google.firebase.auth.KEY_PROVIDER_ID", null);
    }

    @Override // com.google.firebase.auth.FederatedAuthProvider
    public final void zza(Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN");
        intent.setClass(activity, GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.zza);
        activity.startActivity(intent);
    }

    @Override // com.google.firebase.auth.FederatedAuthProvider
    public final void zzb(Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_LINK");
        intent.setClass(activity, GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.zza);
        activity.startActivity(intent);
    }

    @Override // com.google.firebase.auth.FederatedAuthProvider
    public final void zzc(Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE");
        intent.setClass(activity, GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.zza);
        activity.startActivity(intent);
    }

    public static Builder newBuilder(String str, FirebaseAuth firebaseAuth) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseAuth);
        if (!"facebook.com".equals(str) || zzvh.zzb(firebaseAuth.zze())) {
            return new Builder(str, firebaseAuth, null);
        }
        throw new IllegalArgumentException("Sign in with Facebook is not supported via this method; the Facebook TOS dictate that you must use the Facebook Android SDK for Facebook login.");
    }
}
