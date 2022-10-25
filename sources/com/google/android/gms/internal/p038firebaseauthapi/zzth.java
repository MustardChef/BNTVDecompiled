package com.google.android.gms.internal.p038firebaseauthapi;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.auth.internal.zzai;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzth */
/* loaded from: classes3.dex */
public final class zzth extends AsyncTask<Void, Void, zztg> {
    private static final Logger zza = new Logger("FirebaseAuth", "GetAuthDomainTask");
    private final String zzb;
    private final String zzc;
    private final WeakReference<zztj> zzd;
    private final Uri.Builder zze;
    private final String zzf;

    public zzth(String str, String str2, Intent intent, zztj zztjVar) {
        this.zzb = Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(intent);
        String checkNotEmpty = Preconditions.checkNotEmpty(intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY"));
        Uri.Builder buildUpon = Uri.parse(zztjVar.zzc(checkNotEmpty)).buildUpon();
        buildUpon.appendPath("getProjectConfig").appendQueryParameter(SDKConstants.PARAM_KEY, checkNotEmpty).appendQueryParameter("androidPackageName", str).appendQueryParameter("sha1Cert", (String) Preconditions.checkNotNull(str2));
        this.zzc = buildUpon.build().toString();
        this.zzd = new WeakReference<>(zztjVar);
        this.zze = zztjVar.zzd(intent, str, str2);
        this.zzf = intent.getStringExtra("com.google.firebase.auth.KEY_CUSTOM_AUTH_DOMAIN");
    }

    private static byte[] zza(InputStream inputStream, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[128];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } finally {
            byteArrayOutputStream.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: zzb */
    public final void onPostExecute(zztg zztgVar) {
        String str;
        Uri.Builder builder;
        zztj zztjVar = this.zzd.get();
        String str2 = null;
        if (zztgVar != null) {
            str2 = zztgVar.zza();
            str = zztgVar.zzb();
        } else {
            str = null;
        }
        if (zztjVar == null) {
            zza.m343e("An error has occurred: the handler reference has returned null.", new Object[0]);
        } else if (TextUtils.isEmpty(str2) || (builder = this.zze) == null) {
            zztjVar.zze(this.zzb, zzai.zza(str));
        } else {
            builder.authority(str2);
            zztjVar.zza(this.zze.build(), this.zzb);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d4 A[Catch: zzpp -> 0x00ef, NullPointerException -> 0x0117, IOException -> 0x013f, TryCatch #1 {IOException -> 0x013f, blocks: (B:6:0x0014, B:19:0x0092, B:20:0x00b1, B:21:0x00ce, B:23:0x00d4, B:25:0x00e2, B:27:0x00ea, B:18:0x006b), top: B:38:0x0014 }] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final /* bridge */ /* synthetic */ com.google.android.gms.internal.p038firebaseauthapi.zztg doInBackground(java.lang.Void[] r7) {
        /*
            Method dump skipped, instructions count: 359
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p038firebaseauthapi.zzth.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onCancelled(zztg zztgVar) {
        onPostExecute(null);
    }
}
