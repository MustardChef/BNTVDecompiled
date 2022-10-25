package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzct implements zzcx {
    private static final Map<Uri, zzct> zza = new ArrayMap();
    private static final String[] zzh = {SDKConstants.PARAM_KEY, "value"};
    private final ContentResolver zzb;
    private final Uri zzc;
    private final ContentObserver zzd;
    private final Object zze;
    private volatile Map<String, String> zzf;
    private final List<zzcu> zzg;

    private zzct(ContentResolver contentResolver, Uri uri) {
        zzcv zzcvVar = new zzcv(this, null);
        this.zzd = zzcvVar;
        this.zze = new Object();
        this.zzg = new ArrayList();
        zzeb.zza(contentResolver);
        zzeb.zza(uri);
        this.zzb = contentResolver;
        this.zzc = uri;
        contentResolver.registerContentObserver(uri, false, zzcvVar);
    }

    public static zzct zza(ContentResolver contentResolver, Uri uri) {
        zzct zzctVar;
        synchronized (zzct.class) {
            Map<Uri, zzct> map = zza;
            zzctVar = map.get(uri);
            if (zzctVar == null) {
                try {
                    zzct zzctVar2 = new zzct(contentResolver, uri);
                    try {
                        map.put(uri, zzctVar2);
                    } catch (SecurityException unused) {
                    }
                    zzctVar = zzctVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzctVar;
    }

    public final Map<String, String> zza() {
        Map<String, String> map = this.zzf;
        if (map == null) {
            synchronized (this.zze) {
                map = this.zzf;
                if (map == null) {
                    map = zze();
                    this.zzf = map;
                }
            }
        }
        return map != null ? map : Collections.emptyMap();
    }

    public final void zzb() {
        synchronized (this.zze) {
            this.zzf = null;
            zzdh.zza();
        }
        synchronized (this) {
            for (zzcu zzcuVar : this.zzg) {
                zzcuVar.zza();
            }
        }
    }

    private final Map<String, String> zze() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                return (Map) zzcw.zza(new zzcz(this) { // from class: com.google.android.gms.internal.measurement.zzcs
                    private final zzct zza;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zza = this;
                    }

                    @Override // com.google.android.gms.internal.measurement.zzcz
                    public final Object zza() {
                        return this.zza.zzd();
                    }
                });
            } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return null;
            }
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void zzc() {
        synchronized (zzct.class) {
            for (zzct zzctVar : zza.values()) {
                zzctVar.zzb.unregisterContentObserver(zzctVar.zzd);
            }
            zza.clear();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcx
    public final /* synthetic */ Object zza(String str) {
        return zza().get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Map zzd() {
        Map hashMap;
        Cursor query = this.zzb.query(this.zzc, zzh, null, null, null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            if (count <= 256) {
                hashMap = new ArrayMap(count);
            } else {
                hashMap = new HashMap(count, 1.0f);
            }
            while (query.moveToNext()) {
                hashMap.put(query.getString(0), query.getString(1));
            }
            return hashMap;
        } finally {
            query.close();
        }
    }
}
