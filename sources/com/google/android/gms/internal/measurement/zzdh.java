package com.google.android.gms.internal.measurement;

import android.content.Context;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public abstract class zzdh<T> {
    @Nullable
    private static volatile zzdp zzb = null;
    private static volatile boolean zzc = false;
    private final zzdm zzf;
    private final String zzg;
    private final T zzh;
    private volatile int zzj;
    private volatile T zzk;
    private final boolean zzl;
    private static final Object zza = new Object();
    private static final AtomicReference<Collection<zzdh<?>>> zzd = new AtomicReference<>();
    private static zzdq zze = new zzdq(zzdj.zza);
    private static final AtomicInteger zzi = new AtomicInteger();

    @Deprecated
    public static void zza(final Context context) {
        synchronized (zza) {
            zzdp zzdpVar = zzb;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzdpVar == null || zzdpVar.zza() != context) {
                zzct.zzc();
                zzdo.zza();
                zzcy.zza();
                zzb = new zzcq(context, zzef.zza(new zzec(context) { // from class: com.google.android.gms.internal.measurement.zzdg
                    private final Context zza;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zza = context;
                    }

                    @Override // com.google.android.gms.internal.measurement.zzec
                    public final Object zza() {
                        return zzdh.zzb(this.zza);
                    }
                }));
                zzi.incrementAndGet();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ boolean zzd() {
        return true;
    }

    abstract T zza(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza() {
        zzi.incrementAndGet();
    }

    private zzdh(zzdm zzdmVar, String str, T t, boolean z) {
        this.zzj = -1;
        if (zzdmVar.zza == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.zzf = zzdmVar;
        this.zzg = str;
        this.zzh = t;
        this.zzl = z;
    }

    private final String zza(String str) {
        if (str == null || !str.isEmpty()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf(this.zzg);
            return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        return this.zzg;
    }

    public final String zzb() {
        return zza(this.zzf.zzc);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00be A[Catch: all -> 0x0112, TryCatch #0 {, blocks: (B:8:0x001c, B:10:0x0020, B:14:0x0029, B:16:0x0040, B:22:0x0051, B:24:0x0057, B:26:0x0065, B:30:0x0082, B:32:0x008c, B:50:0x00df, B:52:0x00ef, B:54:0x0105, B:55:0x0108, B:56:0x010c, B:43:0x00be, B:45:0x00d4, B:49:0x00dd, B:28:0x0078, B:33:0x0091, B:35:0x009a, B:37:0x00ac, B:39:0x00b7, B:38:0x00b1, B:57:0x0110), top: B:64:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ef A[Catch: all -> 0x0112, TryCatch #0 {, blocks: (B:8:0x001c, B:10:0x0020, B:14:0x0029, B:16:0x0040, B:22:0x0051, B:24:0x0057, B:26:0x0065, B:30:0x0082, B:32:0x008c, B:50:0x00df, B:52:0x00ef, B:54:0x0105, B:55:0x0108, B:56:0x010c, B:43:0x00be, B:45:0x00d4, B:49:0x00dd, B:28:0x0078, B:33:0x0091, B:35:0x009a, B:37:0x00ac, B:39:0x00b7, B:38:0x00b1, B:57:0x0110), top: B:64:0x001c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final T zzc() {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzdh.zzc():java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzdh<Long> zzb(zzdm zzdmVar, String str, long j, boolean z) {
        return new zzdi(zzdmVar, str, Long.valueOf(j), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzdh<Boolean> zzb(zzdm zzdmVar, String str, boolean z, boolean z2) {
        return new zzdl(zzdmVar, str, Boolean.valueOf(z), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzdh<Double> zzb(zzdm zzdmVar, String str, double d, boolean z) {
        return new zzdk(zzdmVar, str, Double.valueOf(-3.0d), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzdh<String> zzb(zzdm zzdmVar, String str, String str2, boolean z) {
        return new zzdn(zzdmVar, str, str2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ zzdy zzb(Context context) {
        new zzdc();
        return zzdc.zza(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdh(zzdm zzdmVar, String str, Object obj, boolean z, zzdi zzdiVar) {
        this(zzdmVar, str, obj, z);
    }
}
