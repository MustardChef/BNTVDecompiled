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
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.internal.p038firebaseauthapi.zzth;
import com.google.android.gms.internal.p038firebaseauthapi.zztj;
import com.google.android.gms.internal.p038firebaseauthapi.zzud;
import com.google.android.gms.internal.p038firebaseauthapi.zzvh;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public class RecaptchaActivity extends FragmentActivity implements zztj {
    private static final String zzb = "RecaptchaActivity";
    private static final ExecutorService zzc = com.google.android.gms.internal.p038firebaseauthapi.zzh.zza().zza(2);
    private static long zzd = 0;
    private static final zzbm zzf = zzbm.zza();
    private boolean zze = false;

    private final void zzg() {
        zzd = 0L;
        this.zze = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        zzf.zzh(this);
        finish();
    }

    private final void zzh(Status status) {
        zzd = 0L;
        this.zze = false;
        Intent intent = new Intent();
        zzbl.zza(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        zzf.zzh(this);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if ("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA".equals(action) || "android.intent.action.VIEW".equals(action)) {
            long currentTimeMillis = DefaultClock.getInstance().currentTimeMillis();
            if (currentTimeMillis - zzd < 30000) {
                Log.e(zzb, "Could not start operation - already in progress");
                return;
            }
            zzd = currentTimeMillis;
            if (bundle != null) {
                this.zze = bundle.getBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW");
                return;
            }
            return;
        }
        String str = zzb;
        String valueOf = String.valueOf(action);
        Log.e(str, valueOf.length() != 0 ? "Could not do operation - unknown action: ".concat(valueOf) : new String("Could not do operation - unknown action: "));
        zzg();
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
            if (!this.zze) {
                String packageName = getPackageName();
                try {
                    new zzth(packageName, Hex.bytesToStringUppercase(AndroidUtilsLight.getPackageCertificateHashBytes(this, packageName)).toLowerCase(Locale.US), getIntent(), this).executeOnExecutor(zzc, new Void[0]);
                } catch (PackageManager.NameNotFoundException e) {
                    String str = zzb;
                    String valueOf = String.valueOf(e);
                    StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 34 + String.valueOf(valueOf).length());
                    sb.append("Could not get package signature: ");
                    sb.append(packageName);
                    sb.append(" ");
                    sb.append(valueOf);
                    Log.e(str, sb.toString());
                    zze(packageName, null);
                }
                this.zze = true;
                return;
            }
            zzg();
            return;
        }
        Intent intent = getIntent();
        if (intent.hasExtra("firebaseError")) {
            zzh(zzbl.zzd(intent.getStringExtra("firebaseError")));
        } else if (!intent.hasExtra("link") || !intent.hasExtra("eventId")) {
            zzg();
        } else {
            String stringExtra = intent.getStringExtra("link");
            String zze = zzj.zza().zze(getApplicationContext(), getPackageName(), intent.getStringExtra("eventId"));
            if (TextUtils.isEmpty(zze)) {
                Log.e(zzb, "Failed to find registration for this event - failing to prevent session injection.");
                zzh(zzai.zza("Failed to find registration for this reCAPTCHA event"));
            }
            if (intent.getBooleanExtra("encryptionEnabled", true)) {
                stringExtra = zzk.zza(getApplicationContext(), FirebaseApp.getInstance(zze).getPersistenceKey()).zzc(stringExtra);
            }
            String queryParameter = Uri.parse(stringExtra).getQueryParameter("recaptchaToken");
            zzd = 0L;
            this.zze = false;
            Intent intent2 = new Intent();
            intent2.putExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN", queryParameter);
            intent2.putExtra("com.google.firebase.auth.internal.OPERATION", "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
            intent2.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
            if (!LocalBroadcastManager.getInstance(this).sendBroadcast(intent2)) {
                SharedPreferences.Editor edit = getApplicationContext().getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
                edit.putString("recaptchaToken", queryParameter);
                edit.putString("operation", "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
                edit.putLong("timestamp", DefaultClock.getInstance().currentTimeMillis());
                edit.commit();
            } else {
                zzf.zzh(this);
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW", this.zze);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztj
    public final void zza(Uri uri, String str) {
        if (getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW"), 0) == null) {
            Log.e(zzb, "Device cannot resolve intent for: android.intent.action.VIEW");
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
            zza.m343e("Error generating connection", new Object[0]);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztj
    public final String zzc(String str) {
        return zzvh.zze(str);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztj
    public final Uri.Builder zzd(Intent intent, String str, String str2) {
        String zza;
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        String uuid = UUID.randomUUID().toString();
        String stringExtra2 = intent.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        String stringExtra3 = intent.getStringExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME");
        FirebaseApp firebaseApp = FirebaseApp.getInstance(stringExtra3);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(firebaseApp);
        zzj.zza().zzc(getApplicationContext(), str, uuid, "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA", stringExtra3);
        String zzb2 = zzk.zza(getApplicationContext(), firebaseApp.getPersistenceKey()).zzb();
        if (TextUtils.isEmpty(zzb2)) {
            Log.e(zzb, "Could not generate an encryption key for reCAPTCHA - cancelling flow.");
            zzh(zzai.zza("Failed to generate/retrieve public encryption key for reCAPTCHA flow."));
            return null;
        }
        if (!TextUtils.isEmpty(firebaseAuth.getLanguageCode())) {
            zza = firebaseAuth.getLanguageCode();
        } else {
            zza = zzud.zza();
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").appendPath("__").appendPath("auth").appendPath("handler").appendQueryParameter("apiKey", stringExtra).appendQueryParameter("authType", "verifyApp").appendQueryParameter("apn", str).appendQueryParameter("hl", zza).appendQueryParameter("eventId", uuid);
        String valueOf = String.valueOf(stringExtra2);
        return appendQueryParameter.appendQueryParameter("v", valueOf.length() != 0 ? "X".concat(valueOf) : new String("X")).appendQueryParameter("eid", TtmlNode.TAG_P).appendQueryParameter("appName", stringExtra3).appendQueryParameter("sha1Cert", str2).appendQueryParameter("publicKey", zzb2);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztj
    public final void zze(String str, Status status) {
        if (status == null) {
            zzg();
        } else {
            zzh(status);
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztj
    public final Context zzf() {
        return getApplicationContext();
    }
}
