package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsService;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.internal.p038firebaseauthapi.zzth;
import com.google.android.gms.internal.p038firebaseauthapi.zzti;
import com.google.android.gms.internal.p038firebaseauthapi.zztj;
import com.google.android.gms.internal.p038firebaseauthapi.zzvh;
import com.google.android.gms.internal.p038firebaseauthapi.zzxg;
import com.google.firebase.FirebaseApp;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public class GenericIdpActivity extends FragmentActivity implements zztj {
    private static long zzc;
    private static final zzbm zze = zzbm.zza();
    private final Executor zzb = com.google.android.gms.internal.p038firebaseauthapi.zzh.zza().zza(1);
    private boolean zzd = false;

    private final void zzh() {
        zzc = 0L;
        this.zzd = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!LocalBroadcastManager.getInstance(this).sendBroadcast(intent)) {
            zze.zzg(this, zzai.zza("WEB_CONTEXT_CANCELED"));
        } else {
            zze.zzh(this);
        }
        finish();
    }

    private final void zzi(Status status) {
        zzc = 0L;
        this.zzd = false;
        Intent intent = new Intent();
        zzbl.zza(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!LocalBroadcastManager.getInstance(this).sendBroadcast(intent)) {
            zze.zzg(getApplicationContext(), status);
        } else {
            zze.zzh(this);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if ("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(action) || "com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(action) || "com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(action) || "android.intent.action.VIEW".equals(action)) {
            long currentTimeMillis = DefaultClock.getInstance().currentTimeMillis();
            if (currentTimeMillis - zzc < 30000) {
                Log.e("GenericIdpActivity", "Could not start operation - already in progress");
                return;
            }
            zzc = currentTimeMillis;
            if (bundle != null) {
                this.zzd = bundle.getBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN");
                return;
            }
            return;
        }
        String valueOf = String.valueOf(action);
        Log.e("GenericIdpActivity", valueOf.length() != 0 ? "Could not do operation - unknown action: ".concat(valueOf) : new String("Could not do operation - unknown action: "));
        zzh();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (!"android.intent.action.VIEW".equals(getIntent().getAction())) {
            if (!this.zzd) {
                String packageName = getPackageName();
                try {
                    String lowerCase = Hex.bytesToStringUppercase(AndroidUtilsLight.getPackageCertificateHashBytes(this, packageName)).toLowerCase(Locale.US);
                    FirebaseApp firebaseApp = FirebaseApp.getInstance(getIntent().getStringExtra("com.google.firebase.auth.KEY_FIREBASE_APP_NAME"));
                    if (!zzvh.zzb(firebaseApp)) {
                        new zzth(packageName, lowerCase, getIntent(), this).executeOnExecutor(this.zzb, new Void[0]);
                    } else {
                        zza(zzg(Uri.parse(zzvh.zzg(firebaseApp.getOptions().getApiKey())).buildUpon(), getIntent(), packageName, lowerCase).build(), packageName);
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    String valueOf = String.valueOf(e);
                    StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 34 + String.valueOf(valueOf).length());
                    sb.append("Could not get package signature: ");
                    sb.append(packageName);
                    sb.append(" ");
                    sb.append(valueOf);
                    Log.e("GenericIdpActivity", sb.toString());
                    zze(packageName, null);
                }
                this.zzd = true;
                return;
            }
            zzh();
            return;
        }
        Intent intent = getIntent();
        if (intent.hasExtra("firebaseError")) {
            zzi(zzbl.zzd(intent.getStringExtra("firebaseError")));
        } else if (!intent.hasExtra("link") || !intent.hasExtra("eventId")) {
            zzh();
        } else {
            String stringExtra = intent.getStringExtra("link");
            String stringExtra2 = intent.getStringExtra("eventId");
            String packageName2 = getPackageName();
            boolean booleanExtra = intent.getBooleanExtra("encryptionEnabled", true);
            zzi zzd = zzj.zza().zzd(this, packageName2, stringExtra2);
            if (zzd == null) {
                zzh();
            }
            if (booleanExtra) {
                stringExtra = zzk.zza(getApplicationContext(), FirebaseApp.getInstance(zzd.zze()).getPersistenceKey()).zzc(stringExtra);
            }
            zzxg zzxgVar = new zzxg(zzd, stringExtra);
            String zzd2 = zzd.zzd();
            String zzb = zzd.zzb();
            zzxgVar.zzd(zzd2);
            if ("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(zzb) || "com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(zzb) || "com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(zzb)) {
                zzc = 0L;
                this.zzd = false;
                Intent intent2 = new Intent();
                SafeParcelableSerializer.serializeToIntentExtra(zzxgVar, intent2, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST");
                intent2.putExtra("com.google.firebase.auth.internal.OPERATION", zzb);
                intent2.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
                if (!LocalBroadcastManager.getInstance(this).sendBroadcast(intent2)) {
                    SharedPreferences.Editor edit = getApplicationContext().getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
                    edit.putString("verifyAssertionRequest", SafeParcelableSerializer.serializeToString(zzxgVar));
                    edit.putString("operation", zzb);
                    edit.putString("tenantId", zzd2);
                    edit.putLong("timestamp", DefaultClock.getInstance().currentTimeMillis());
                    edit.commit();
                } else {
                    zze.zzh(this);
                }
                finish();
                return;
            }
            Log.e("GenericIdpActivity", zzb.length() != 0 ? "unsupported operation: ".concat(zzb) : new String("unsupported operation: "));
            zzh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN", this.zzd);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztj
    public final void zza(Uri uri, String str) {
        if (getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW"), 0) == null) {
            Log.e("GenericIdpActivity", "Device cannot resolve intent for: android.intent.action.VIEW");
            zze(str, null);
            return;
        }
        List<ResolveInfo> queryIntentServices = getPackageManager().queryIntentServices(new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION), 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            intent.putExtra("com.android.browser.application_id", str);
            intent.addFlags(1073741824);
            intent.addFlags(268435456);
            startActivity(intent);
            return;
        }
        CustomTabsIntent build = new CustomTabsIntent.Builder().build();
        build.intent.addFlags(1073741824);
        build.intent.addFlags(268435456);
        build.launchUrl(this, uri);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztj
    public final HttpURLConnection zzb(URL url) {
        try {
            return (HttpURLConnection) url.openConnection();
        } catch (IOException unused) {
            Log.e("GenericIdpActivity", "Error generating URL connection");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztj
    public final String zzc(String str) {
        return zzvh.zze(str);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztj
    public final Uri.Builder zzd(Intent intent, String str, String str2) {
        return zzg(new Uri.Builder().scheme("https").appendPath("__").appendPath("auth").appendPath("handler"), intent, str, str2);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztj
    public final void zze(String str, Status status) {
        if (status == null) {
            zzh();
        } else {
            zzi(status);
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztj
    public final Context zzf() {
        return getApplicationContext();
    }

    public final Uri.Builder zzg(Uri.Builder builder, Intent intent, String str, String str2) {
        String jSONObject;
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        String stringExtra2 = intent.getStringExtra("com.google.firebase.auth.KEY_PROVIDER_ID");
        String stringExtra3 = intent.getStringExtra("com.google.firebase.auth.KEY_TENANT_ID");
        String stringExtra4 = intent.getStringExtra("com.google.firebase.auth.KEY_FIREBASE_APP_NAME");
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("com.google.firebase.auth.KEY_PROVIDER_SCOPES");
        String join = (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) ? null : TextUtils.join(",", stringArrayListExtra);
        Bundle bundleExtra = intent.getBundleExtra("com.google.firebase.auth.KEY_PROVIDER_CUSTOM_PARAMS");
        if (bundleExtra == null) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                for (String str3 : bundleExtra.keySet()) {
                    String string = bundleExtra.getString(str3);
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject2.put(str3, string);
                    }
                }
            } catch (JSONException unused) {
                Log.e("GenericIdpActivity", "Unexpected JSON exception when serializing developer specified custom params");
            }
            jSONObject = jSONObject2.toString();
        }
        String uuid = UUID.randomUUID().toString();
        String zza = zzti.zza(this, UUID.randomUUID().toString());
        String action = intent.getAction();
        String stringExtra5 = intent.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        String str4 = jSONObject;
        String str5 = join;
        zzj.zza().zzb(getApplicationContext(), str, uuid, zza, action, stringExtra2, stringExtra3, stringExtra4);
        String zzb = zzk.zza(getApplicationContext(), FirebaseApp.getInstance(stringExtra4).getPersistenceKey()).zzb();
        if (TextUtils.isEmpty(zzb)) {
            Log.e("GenericIdpActivity", "Could not generate an encryption key for Generic IDP - cancelling flow.");
            zzi(zzai.zza("Failed to generate/retrieve public encryption key for Generic IDP flow."));
            return null;
        } else if (zza == null) {
            return null;
        } else {
            Uri.Builder appendQueryParameter = builder.appendQueryParameter("eid", TtmlNode.TAG_P);
            String valueOf = String.valueOf(stringExtra5);
            appendQueryParameter.appendQueryParameter("v", valueOf.length() != 0 ? "X".concat(valueOf) : new String("X")).appendQueryParameter("authType", "signInWithRedirect").appendQueryParameter("apiKey", stringExtra).appendQueryParameter("providerId", stringExtra2).appendQueryParameter("sessionId", zza).appendQueryParameter("eventId", uuid).appendQueryParameter("apn", str).appendQueryParameter("sha1Cert", str2).appendQueryParameter("publicKey", zzb);
            if (!TextUtils.isEmpty(str5)) {
                builder.appendQueryParameter("scopes", str5);
            }
            if (!TextUtils.isEmpty(str4)) {
                builder.appendQueryParameter("customParameters", str4);
            }
            if (!TextUtils.isEmpty(stringExtra3)) {
                builder.appendQueryParameter("tid", stringExtra3);
            }
            return builder;
        }
    }
}
