package com.google.android.gms.internal.p038firebaseauthapi;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabr */
/* loaded from: classes3.dex */
abstract class zzabr<T, B> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zza(zzabc zzabcVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(B b, int i, long j);

    abstract void zzc(B b, int i, int i2);

    abstract void zzd(B b, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zze(B b, int i, zzym zzymVar);

    abstract void zzf(B b, int i, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B zzg();

    abstract T zzh(B b);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzi(Object obj, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T zzj(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B zzk(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzl(Object obj, B b);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzm(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean zzn(B b, zzabc zzabcVar) throws IOException {
        int zzc = zzabcVar.zzc();
        int i = zzc >>> 3;
        int i2 = zzc & 7;
        if (i2 == 0) {
            zzb(b, i, zzabcVar.zzh());
            return true;
        } else if (i2 == 1) {
            zzd(b, i, zzabcVar.zzj());
            return true;
        } else if (i2 == 2) {
            zze(b, i, zzabcVar.zzq());
            return true;
        } else if (i2 != 3) {
            if (i2 != 4) {
                if (i2 == 5) {
                    zzc(b, i, zzabcVar.zzk());
                    return true;
                }
                throw zzzw.zzg();
            }
            return false;
        } else {
            Object zzg = zzg();
            int i3 = 4 | (i << 3);
            while (zzabcVar.zzb() != Integer.MAX_VALUE && zzn(zzg, zzabcVar)) {
            }
            if (i3 != zzabcVar.zzc()) {
                throw zzzw.zzf();
            }
            zzh(zzg);
            zzf(b, i, zzg);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T zzo(T t, T t2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzp(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzq(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzr(T t, zzyx zzyxVar) throws IOException;
}
