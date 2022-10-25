package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.android.gms.internal.p038firebaseauthapi.zzzf;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzg */
/* loaded from: classes3.dex */
final class zzzg<T extends zzzf<T>> {
    private static final zzzg zzd = new zzzg(true);
    final zzabn<T, Object> zza = new zzabg(16);
    private boolean zzb;
    private boolean zzc;

    private zzzg() {
    }

    public static <T extends zzzf<T>> zzzg<T> zza() {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void zzd(com.google.android.gms.internal.p038firebaseauthapi.zzacj r1, java.lang.Object r2) {
        /*
            com.google.android.gms.internal.p038firebaseauthapi.zzzu.zza(r2)
            com.google.android.gms.internal.firebase-auth-api.zzacj r0 = com.google.android.gms.internal.p038firebaseauthapi.zzacj.DOUBLE
            com.google.android.gms.internal.firebase-auth-api.zzack r0 = com.google.android.gms.internal.p038firebaseauthapi.zzack.INT
            com.google.android.gms.internal.firebase-auth-api.zzack r1 = r1.zza()
            int r1 = r1.ordinal()
            switch(r1) {
                case 0: goto L3d;
                case 1: goto L3a;
                case 2: goto L37;
                case 3: goto L34;
                case 4: goto L31;
                case 5: goto L2e;
                case 6: goto L25;
                case 7: goto L1c;
                case 8: goto L13;
                default: goto L12;
            }
        L12:
            goto L42
        L13:
            boolean r1 = r2 instanceof com.google.android.gms.internal.p038firebaseauthapi.zzaar
            if (r1 != 0) goto L41
            boolean r1 = r2 instanceof com.google.android.gms.internal.p038firebaseauthapi.zzzy
            if (r1 == 0) goto L42
            goto L41
        L1c:
            boolean r1 = r2 instanceof java.lang.Integer
            if (r1 != 0) goto L41
            boolean r1 = r2 instanceof com.google.android.gms.internal.p038firebaseauthapi.zzzq
            if (r1 == 0) goto L42
            goto L41
        L25:
            boolean r1 = r2 instanceof com.google.android.gms.internal.p038firebaseauthapi.zzym
            if (r1 != 0) goto L41
            boolean r1 = r2 instanceof byte[]
            if (r1 == 0) goto L42
            goto L41
        L2e:
            boolean r1 = r2 instanceof java.lang.String
            goto L3f
        L31:
            boolean r1 = r2 instanceof java.lang.Boolean
            goto L3f
        L34:
            boolean r1 = r2 instanceof java.lang.Double
            goto L3f
        L37:
            boolean r1 = r2 instanceof java.lang.Float
            goto L3f
        L3a:
            boolean r1 = r2 instanceof java.lang.Long
            goto L3f
        L3d:
            boolean r1 = r2 instanceof java.lang.Integer
        L3f:
            if (r1 == 0) goto L42
        L41:
            return
        L42:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Wrong object type used with protocol message reflection."
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p038firebaseauthapi.zzzg.zzd(com.google.android.gms.internal.firebase-auth-api.zzacj, java.lang.Object):void");
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzzg zzzgVar = new zzzg();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<T, Object> zzd2 = this.zza.zzd(i);
            zzzgVar.zzc(zzd2.getKey(), zzd2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zza.zze()) {
            zzzgVar.zzc(entry.getKey(), entry.getValue());
        }
        zzzgVar.zzc = this.zzc;
        return zzzgVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzzg) {
            return this.zza.equals(((zzzg) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        this.zza.zza();
        this.zzb = true;
    }

    public final void zzc(T t, Object obj) {
        if (t.zzb()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzd(t.zza(), arrayList.get(i));
            }
            obj = arrayList;
        } else {
            zzd(t.zza(), obj);
        }
        if (obj instanceof zzzy) {
            this.zzc = true;
        }
        this.zza.put(t, obj);
    }

    private zzzg(boolean z) {
        zzb();
        zzb();
    }
}
