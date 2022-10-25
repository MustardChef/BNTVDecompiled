package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzif implements Runnable {
    private final URL zza;
    private final byte[] zzb;
    private final zzic zzc;
    private final String zzd;
    private final Map<String, String> zze;
    private final /* synthetic */ zzid zzf;

    public zzif(zzid zzidVar, String str, URL url, byte[] bArr, Map<String, String> map, zzic zzicVar) {
        this.zzf = zzidVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzicVar);
        this.zza = url;
        this.zzb = null;
        this.zzc = zzicVar;
        this.zzd = str;
        this.zze = null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpURLConnection httpURLConnection;
        Map<String, List<String>> map;
        byte[] zza;
        this.zzf.zzb();
        int i = 0;
        try {
            httpURLConnection = this.zzf.zza(this.zza);
            try {
                i = httpURLConnection.getResponseCode();
                map = httpURLConnection.getHeaderFields();
            } catch (IOException e) {
                e = e;
                map = null;
            } catch (Throwable th) {
                th = th;
                map = null;
            }
            try {
                zzid zzidVar = this.zzf;
                zza = zzid.zza(httpURLConnection);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                zzb(i, null, zza, map);
            } catch (IOException e2) {
                e = e2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                zzb(i, e, null, map);
            } catch (Throwable th2) {
                th = th2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                zzb(i, null, null, map);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            httpURLConnection = null;
            map = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            map = null;
        }
    }

    private final void zzb(final int i, final Exception exc, final byte[] bArr, final Map<String, List<String>> map) {
        this.zzf.zzp().zza(new Runnable(this, i, exc, bArr, map) { // from class: com.google.android.gms.measurement.internal.zzie
            private final zzif zza;
            private final int zzb;
            private final Exception zzc;
            private final byte[] zzd;
            private final Map zze;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = i;
                this.zzc = exc;
                this.zzd = bArr;
                this.zze = map;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(this.zzb, this.zzc, this.zzd, this.zze);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(int i, Exception exc, byte[] bArr, Map map) {
        this.zzc.zza(this.zzd, i, exc, bArr, map);
    }
}
