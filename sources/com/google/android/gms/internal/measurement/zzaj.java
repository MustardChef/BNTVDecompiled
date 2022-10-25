package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzaj extends zzag.zzb {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ Context zze;
    private final /* synthetic */ Bundle zzf;
    private final /* synthetic */ zzag zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaj(zzag zzagVar, String str, String str2, Context context, Bundle bundle) {
        super(zzagVar);
        this.zzg = zzagVar;
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0048 A[Catch: Exception -> 0x0095, TryCatch #0 {Exception -> 0x0095, blocks: (B:3:0x0002, B:5:0x000f, B:7:0x0020, B:13:0x0035, B:15:0x0048, B:17:0x0054, B:19:0x0062, B:30:0x0077), top: B:35:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0054 A[Catch: Exception -> 0x0095, TryCatch #0 {Exception -> 0x0095, blocks: (B:3:0x0002, B:5:0x000f, B:7:0x0020, B:13:0x0035, B:15:0x0048, B:17:0x0054, B:19:0x0062, B:30:0x0077), top: B:35:0x0002 }] */
    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza() {
        /*
            r14 = this;
            r0 = 0
            r1 = 1
            com.google.android.gms.internal.measurement.zzag r2 = r14.zzg     // Catch: java.lang.Exception -> L95
            java.lang.String r3 = r14.zzc     // Catch: java.lang.Exception -> L95
            java.lang.String r4 = r14.zzd     // Catch: java.lang.Exception -> L95
            boolean r2 = com.google.android.gms.internal.measurement.zzag.zza(r2, r3, r4)     // Catch: java.lang.Exception -> L95
            r3 = 0
            if (r2 == 0) goto L1d
            java.lang.String r3 = r14.zzd     // Catch: java.lang.Exception -> L95
            java.lang.String r2 = r14.zzc     // Catch: java.lang.Exception -> L95
            com.google.android.gms.internal.measurement.zzag r4 = r14.zzg     // Catch: java.lang.Exception -> L95
            java.lang.String r4 = com.google.android.gms.internal.measurement.zzag.zzb(r4)     // Catch: java.lang.Exception -> L95
            r10 = r2
            r11 = r3
            r9 = r4
            goto L20
        L1d:
            r9 = r3
            r10 = r9
            r11 = r10
        L20:
            android.content.Context r2 = r14.zze     // Catch: java.lang.Exception -> L95
            com.google.android.gms.internal.measurement.zzag.zzb(r2)     // Catch: java.lang.Exception -> L95
            java.lang.Boolean r2 = com.google.android.gms.internal.measurement.zzag.zzj()     // Catch: java.lang.Exception -> L95
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Exception -> L95
            if (r2 != 0) goto L34
            if (r10 == 0) goto L32
            goto L34
        L32:
            r2 = 0
            goto L35
        L34:
            r2 = 1
        L35:
            com.google.android.gms.internal.measurement.zzag r3 = r14.zzg     // Catch: java.lang.Exception -> L95
            android.content.Context r4 = r14.zze     // Catch: java.lang.Exception -> L95
            com.google.android.gms.internal.measurement.zzv r4 = r3.zza(r4, r2)     // Catch: java.lang.Exception -> L95
            com.google.android.gms.internal.measurement.zzag.zza(r3, r4)     // Catch: java.lang.Exception -> L95
            com.google.android.gms.internal.measurement.zzag r3 = r14.zzg     // Catch: java.lang.Exception -> L95
            com.google.android.gms.internal.measurement.zzv r3 = com.google.android.gms.internal.measurement.zzag.zzc(r3)     // Catch: java.lang.Exception -> L95
            if (r3 != 0) goto L54
            com.google.android.gms.internal.measurement.zzag r2 = r14.zzg     // Catch: java.lang.Exception -> L95
            java.lang.String r2 = com.google.android.gms.internal.measurement.zzag.zzb(r2)     // Catch: java.lang.Exception -> L95
            java.lang.String r3 = "Failed to connect to measurement client."
            android.util.Log.w(r2, r3)     // Catch: java.lang.Exception -> L95
            return
        L54:
            android.content.Context r3 = r14.zze     // Catch: java.lang.Exception -> L95
            int r3 = com.google.android.gms.internal.measurement.zzag.zzc(r3)     // Catch: java.lang.Exception -> L95
            android.content.Context r4 = r14.zze     // Catch: java.lang.Exception -> L95
            int r4 = com.google.android.gms.internal.measurement.zzag.zzd(r4)     // Catch: java.lang.Exception -> L95
            if (r2 == 0) goto L6d
            int r2 = java.lang.Math.max(r3, r4)     // Catch: java.lang.Exception -> L95
            if (r4 >= r3) goto L6a
            r3 = 1
            goto L6b
        L6a:
            r3 = 0
        L6b:
            r8 = r3
            goto L77
        L6d:
            if (r3 <= 0) goto L70
            r4 = r3
        L70:
            if (r3 <= 0) goto L74
            r2 = 1
            goto L75
        L74:
            r2 = 0
        L75:
            r8 = r2
            r2 = r4
        L77:
            com.google.android.gms.internal.measurement.zzae r13 = new com.google.android.gms.internal.measurement.zzae     // Catch: java.lang.Exception -> L95
            r4 = 33025(0x8101, double:1.63165E-319)
            long r6 = (long) r2     // Catch: java.lang.Exception -> L95
            android.os.Bundle r12 = r14.zzf     // Catch: java.lang.Exception -> L95
            r3 = r13
            r3.<init>(r4, r6, r8, r9, r10, r11, r12)     // Catch: java.lang.Exception -> L95
            com.google.android.gms.internal.measurement.zzag r2 = r14.zzg     // Catch: java.lang.Exception -> L95
            com.google.android.gms.internal.measurement.zzv r2 = com.google.android.gms.internal.measurement.zzag.zzc(r2)     // Catch: java.lang.Exception -> L95
            android.content.Context r3 = r14.zze     // Catch: java.lang.Exception -> L95
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r3)     // Catch: java.lang.Exception -> L95
            long r4 = r14.zza     // Catch: java.lang.Exception -> L95
            r2.initialize(r3, r13, r4)     // Catch: java.lang.Exception -> L95
            return
        L95:
            r2 = move-exception
            com.google.android.gms.internal.measurement.zzag r3 = r14.zzg
            com.google.android.gms.internal.measurement.zzag.zza(r3, r2, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaj.zza():void");
    }
}
