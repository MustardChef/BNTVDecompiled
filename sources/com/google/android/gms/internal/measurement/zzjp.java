package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
final class zzjp<T> implements zzkb<T> {
    private final zzjj zza;
    private final zzkt<?, ?> zzb;
    private final boolean zzc;
    private final zzhn<?> zzd;

    private zzjp(zzkt<?, ?> zzktVar, zzhn<?> zzhnVar, zzjj zzjjVar) {
        this.zzb = zzktVar;
        this.zzc = zzhnVar.zza(zzjjVar);
        this.zzd = zzhnVar;
        this.zza = zzjjVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> zzjp<T> zza(zzkt<?, ?> zzktVar, zzhn<?> zzhnVar, zzjj zzjjVar) {
        return new zzjp<>(zzktVar, zzhnVar, zzjjVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final T zza() {
        return (T) this.zza.zzbu().zzx();
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final boolean zza(T t, T t2) {
        if (this.zzb.zzb(t).equals(this.zzb.zzb(t2))) {
            if (this.zzc) {
                return this.zzd.zza(t).equals(this.zzd.zza(t2));
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final int zza(T t) {
        int hashCode = this.zzb.zzb(t).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final void zzb(T t, T t2) {
        zzkd.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzkd.zza(this.zzd, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final void zza(T t, zzlm zzlmVar) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd = this.zzd.zza(t).zzd();
        while (zzd.hasNext()) {
            Map.Entry<?, Object> next = zzd.next();
            zzht zzhtVar = (zzht) next.getKey();
            if (zzhtVar.zzc() != zzln.MESSAGE || zzhtVar.zzd() || zzhtVar.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (next instanceof zzim) {
                zzlmVar.zza(zzhtVar.zza(), (Object) ((zzim) next).zza().zzc());
            } else {
                zzlmVar.zza(zzhtVar.zza(), next.getValue());
            }
        }
        zzkt<?, ?> zzktVar = this.zzb;
        zzktVar.zzb((zzkt<?, ?>) zzktVar.zzb(t), zzlmVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0099 A[EDGE_INSN: B:57:0x0099->B:34:0x0099 ?: BREAK  , SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzkb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.measurement.zzgo r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.measurement.zzhy r0 = (com.google.android.gms.internal.measurement.zzhy) r0
            com.google.android.gms.internal.measurement.zzks r1 = r0.zzb
            com.google.android.gms.internal.measurement.zzks r2 = com.google.android.gms.internal.measurement.zzks.zza()
            if (r1 != r2) goto L11
            com.google.android.gms.internal.measurement.zzks r1 = com.google.android.gms.internal.measurement.zzks.zzb()
            r0.zzb = r1
        L11:
            com.google.android.gms.internal.measurement.zzhy$zzd r10 = (com.google.android.gms.internal.measurement.zzhy.zzd) r10
            r10.zza()
            r10 = 0
            r0 = r10
        L18:
            if (r12 >= r13) goto La4
            int r4 = com.google.android.gms.internal.measurement.zzgl.zza(r11, r12, r14)
            int r2 = r14.zza
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L51
            r12 = r2 & 7
            if (r12 != r3) goto L4c
            com.google.android.gms.internal.measurement.zzhn<?> r12 = r9.zzd
            com.google.android.gms.internal.measurement.zzhl r0 = r14.zzd
            com.google.android.gms.internal.measurement.zzjj r3 = r9.zza
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.zza(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.measurement.zzhy$zzf r0 = (com.google.android.gms.internal.measurement.zzhy.zzf) r0
            if (r0 != 0) goto L43
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.measurement.zzgl.zza(r2, r3, r4, r5, r6, r7)
            goto L18
        L43:
            com.google.android.gms.internal.measurement.zzjx.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L4c:
            int r12 = com.google.android.gms.internal.measurement.zzgl.zza(r2, r11, r4, r13, r14)
            goto L18
        L51:
            r12 = 0
            r2 = r10
        L53:
            if (r4 >= r13) goto L99
            int r4 = com.google.android.gms.internal.measurement.zzgl.zza(r11, r4, r14)
            int r5 = r14.zza
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L7b
            r8 = 3
            if (r6 == r8) goto L65
            goto L90
        L65:
            if (r0 != 0) goto L72
            if (r7 != r3) goto L90
            int r4 = com.google.android.gms.internal.measurement.zzgl.zze(r11, r4, r14)
            java.lang.Object r2 = r14.zzc
            com.google.android.gms.internal.measurement.zzgp r2 = (com.google.android.gms.internal.measurement.zzgp) r2
            goto L53
        L72:
            com.google.android.gms.internal.measurement.zzjx.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L7b:
            if (r7 != 0) goto L90
            int r4 = com.google.android.gms.internal.measurement.zzgl.zza(r11, r4, r14)
            int r12 = r14.zza
            com.google.android.gms.internal.measurement.zzhn<?> r0 = r9.zzd
            com.google.android.gms.internal.measurement.zzhl r5 = r14.zzd
            com.google.android.gms.internal.measurement.zzjj r6 = r9.zza
            java.lang.Object r0 = r0.zza(r5, r6, r12)
            com.google.android.gms.internal.measurement.zzhy$zzf r0 = (com.google.android.gms.internal.measurement.zzhy.zzf) r0
            goto L53
        L90:
            r6 = 12
            if (r5 == r6) goto L99
            int r4 = com.google.android.gms.internal.measurement.zzgl.zza(r5, r11, r4, r13, r14)
            goto L53
        L99:
            if (r2 == 0) goto La1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zza(r12, r2)
        La1:
            r12 = r4
            goto L18
        La4:
            if (r12 != r13) goto La7
            return
        La7:
            com.google.android.gms.internal.measurement.zzij r10 = com.google.android.gms.internal.measurement.zzij.zzg()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjp.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzgo):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final void zza(T t, zzjy zzjyVar, zzhl zzhlVar) throws IOException {
        boolean z;
        zzkt<?, ?> zzktVar = this.zzb;
        zzhn<?> zzhnVar = this.zzd;
        Object zzc = zzktVar.zzc(t);
        zzhr<?> zzb = zzhnVar.zzb(t);
        do {
            try {
                if (zzjyVar.zza() == Integer.MAX_VALUE) {
                    return;
                }
                int zzb2 = zzjyVar.zzb();
                if (zzb2 == 11) {
                    int i = 0;
                    Object obj = null;
                    zzgp zzgpVar = null;
                    while (zzjyVar.zza() != Integer.MAX_VALUE) {
                        int zzb3 = zzjyVar.zzb();
                        if (zzb3 == 16) {
                            i = zzjyVar.zzo();
                            obj = zzhnVar.zza(zzhlVar, this.zza, i);
                        } else if (zzb3 == 26) {
                            if (obj != null) {
                                zzhnVar.zza(zzjyVar, obj, zzhlVar, zzb);
                            } else {
                                zzgpVar = zzjyVar.zzn();
                            }
                        } else if (!zzjyVar.zzc()) {
                            break;
                        }
                    }
                    if (zzjyVar.zzb() != 12) {
                        throw zzij.zze();
                    } else if (zzgpVar != null) {
                        if (obj != null) {
                            zzhnVar.zza(zzgpVar, obj, zzhlVar, zzb);
                        } else {
                            zzktVar.zza((zzkt<?, ?>) zzc, i, zzgpVar);
                        }
                    }
                } else if ((zzb2 & 7) == 2) {
                    Object zza = zzhnVar.zza(zzhlVar, this.zza, zzb2 >>> 3);
                    if (zza != null) {
                        zzhnVar.zza(zzjyVar, zza, zzhlVar, zzb);
                    } else {
                        z = zzktVar.zza((zzkt<?, ?>) zzc, zzjyVar);
                        continue;
                    }
                } else {
                    z = zzjyVar.zzc();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzktVar.zzb((Object) t, (T) zzc);
            }
        } while (z);
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final void zzc(T t) {
        this.zzb.zzd(t);
        this.zzd.zzc(t);
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final boolean zzd(T t) {
        return this.zzd.zza(t).zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final int zzb(T t) {
        zzkt<?, ?> zzktVar = this.zzb;
        int zze = zzktVar.zze(zzktVar.zzb(t)) + 0;
        return this.zzc ? zze + this.zzd.zza(t).zzg() : zze;
    }
}
