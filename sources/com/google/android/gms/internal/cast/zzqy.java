package com.google.android.gms.internal.cast;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzqy {
    private static final zzqy zza = new zzqy(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;

    private zzqy() {
        this(0, new int[8], new Object[8], true);
    }

    private zzqy(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = 0;
        this.zzc = iArr;
        this.zzd = objArr;
    }

    public static zzqy zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzqy zzb(zzqy zzqyVar, zzqy zzqyVar2) {
        int i = zzqyVar.zzb;
        int i2 = zzqyVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzqyVar.zzc, 0);
        int[] iArr = zzqyVar2.zzc;
        int i3 = zzqyVar.zzb;
        int i4 = zzqyVar2.zzb;
        System.arraycopy(iArr, 0, copyOf, 0, 0);
        Object[] copyOf2 = Arrays.copyOf(zzqyVar.zzd, 0);
        Object[] objArr = zzqyVar2.zzd;
        int i5 = zzqyVar.zzb;
        int i6 = zzqyVar2.zzb;
        System.arraycopy(objArr, 0, copyOf2, 0, 0);
        return new zzqy(0, copyOf, copyOf2, true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof zzqy)) {
            zzqy zzqyVar = (zzqy) obj;
            int[] iArr = zzqyVar.zzc;
            Object[] objArr = zzqyVar.zzd;
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return 506991;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zze(StringBuilder sb, int i) {
    }

    public final int zzc() {
        int i = this.zze;
        if (i == -1) {
            this.zze = 0;
            return 0;
        }
        return i;
    }

    public final int zzd() {
        int i = this.zze;
        if (i == -1) {
            this.zze = 0;
            return 0;
        }
        return i;
    }
}
