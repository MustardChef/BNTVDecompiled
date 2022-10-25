package com.google.android.gms.internal.p038firebaseauthapi;

import androidx.tvprovider.media.p009tv.TvContractCompat;
import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyq */
/* loaded from: classes3.dex */
public final class zzyq implements zzabc {
    private final zzyp zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzyq(zzyp zzypVar) {
        zzzu.zzb(zzypVar, TvContractCompat.PARAM_INPUT);
        this.zza = zzypVar;
        zzypVar.zzb = this;
    }

    private final void zzP(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw zzzw.zzg();
        }
    }

    private final <T> T zzQ(zzabd<T> zzabdVar, zzzb zzzbVar) throws IOException {
        zzyp zzypVar;
        int zzh = ((zzyo) this.zza).zzh();
        zzyp zzypVar2 = this.zza;
        if (zzypVar2.zza >= 100) {
            throw new zzzw("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int zzm = zzypVar2.zzm(zzh);
        T zza = zzabdVar.zza();
        this.zza.zza++;
        zzabdVar.zzf(zza, this, zzzbVar);
        zzabdVar.zzj(zza);
        this.zza.zzb(0);
        zzypVar.zza--;
        this.zza.zzn(zzm);
        return zza;
    }

    private final <T> T zzR(zzabd<T> zzabdVar, zzzb zzzbVar) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            T zza = zzabdVar.zza();
            zzabdVar.zzf(zza, this, zzzbVar);
            zzabdVar.zzj(zza);
            if (this.zzb == this.zzc) {
                return zza;
            }
            throw zzzw.zzh();
        } finally {
            this.zzc = i;
        }
    }

    private final void zzS(int i) throws IOException {
        if (this.zza.zzp() != i) {
            throw zzzw.zzb();
        }
    }

    private static final void zzT(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzzw.zzh();
        }
    }

    private static final void zzU(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzzw.zzh();
        }
    }

    public static zzyq zza(zzyp zzypVar) {
        zzyq zzyqVar = zzypVar.zzb;
        return zzyqVar != null ? zzyqVar : new zzyq(zzypVar);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final void zzA(List<Long> list) throws IOException {
        int zza;
        int zza2;
        if (list instanceof zzaag) {
            zzaag zzaagVar = (zzaag) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaagVar.zzf(((zzyo) this.zza).zzi());
                    if (this.zza.zzo()) {
                        return;
                    }
                    zza2 = this.zza.zza();
                } while (zza2 == this.zzb);
                this.zzd = zza2;
                return;
            } else if (i == 2) {
                int zzp = this.zza.zzp() + ((zzyo) this.zza).zzh();
                do {
                    zzaagVar.zzf(((zzyo) this.zza).zzi());
                } while (this.zza.zzp() < zzp);
                zzS(zzp);
                return;
            } else {
                throw zzzw.zzg();
            }
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(((zzyo) this.zza).zzi()));
                if (this.zza.zzo()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
        } else if (i2 == 2) {
            int zzp2 = this.zza.zzp() + ((zzyo) this.zza).zzh();
            do {
                list.add(Long.valueOf(((zzyo) this.zza).zzi()));
            } while (this.zza.zzp() < zzp2);
            zzS(zzp2);
        } else {
            throw zzzw.zzg();
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final void zzB(List<Integer> list) throws IOException {
        int zza;
        int zza2;
        if (list instanceof zzzp) {
            zzzp zzzpVar = (zzzp) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzzpVar.zzf(((zzyo) this.zza).zzh());
                    if (this.zza.zzo()) {
                        return;
                    }
                    zza2 = this.zza.zza();
                } while (zza2 == this.zzb);
                this.zzd = zza2;
                return;
            } else if (i == 2) {
                int zzp = this.zza.zzp() + ((zzyo) this.zza).zzh();
                do {
                    zzzpVar.zzf(((zzyo) this.zza).zzh());
                } while (this.zza.zzp() < zzp);
                zzS(zzp);
                return;
            } else {
                throw zzzw.zzg();
            }
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(((zzyo) this.zza).zzh()));
                if (this.zza.zzo()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
        } else if (i2 == 2) {
            int zzp2 = this.zza.zzp() + ((zzyo) this.zza).zzh();
            do {
                list.add(Integer.valueOf(((zzyo) this.zza).zzh()));
            } while (this.zza.zzp() < zzp2);
            zzS(zzp2);
        } else {
            throw zzzw.zzg();
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final void zzC(List<Long> list) throws IOException {
        int zza;
        int zza2;
        if (list instanceof zzaag) {
            zzaag zzaagVar = (zzaag) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzaagVar.zzf(((zzyo) this.zza).zzl());
                    if (this.zza.zzo()) {
                        return;
                    }
                    zza2 = this.zza.zza();
                } while (zza2 == this.zzb);
                this.zzd = zza2;
                return;
            } else if (i == 2) {
                int zzh = ((zzyo) this.zza).zzh();
                zzU(zzh);
                int zzp = this.zza.zzp() + zzh;
                do {
                    zzaagVar.zzf(((zzyo) this.zza).zzl());
                } while (this.zza.zzp() < zzp);
                return;
            } else {
                throw zzzw.zzg();
            }
        }
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                list.add(Long.valueOf(((zzyo) this.zza).zzl()));
                if (this.zza.zzo()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
        } else if (i2 == 2) {
            int zzh2 = ((zzyo) this.zza).zzh();
            zzU(zzh2);
            int zzp2 = this.zza.zzp() + zzh2;
            do {
                list.add(Long.valueOf(((zzyo) this.zza).zzl()));
            } while (this.zza.zzp() < zzp2);
        } else {
            throw zzzw.zzg();
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final void zzD(List<Integer> list) throws IOException {
        int zza;
        int zza2;
        if (!(list instanceof zzzp)) {
            int i = this.zzb & 7;
            if (i == 2) {
                int zzh = ((zzyo) this.zza).zzh();
                zzT(zzh);
                int zzp = this.zza.zzp() + zzh;
                do {
                    list.add(Integer.valueOf(((zzyo) this.zza).zzk()));
                } while (this.zza.zzp() < zzp);
                return;
            } else if (i != 5) {
                throw zzzw.zzg();
            } else {
                do {
                    list.add(Integer.valueOf(((zzyo) this.zza).zzk()));
                    if (this.zza.zzo()) {
                        return;
                    }
                    zza = this.zza.zza();
                } while (zza == this.zzb);
                this.zzd = zza;
                return;
            }
        }
        zzzp zzzpVar = (zzzp) list;
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int zzh2 = ((zzyo) this.zza).zzh();
            zzT(zzh2);
            int zzp2 = this.zza.zzp() + zzh2;
            do {
                zzzpVar.zzf(((zzyo) this.zza).zzk());
            } while (this.zza.zzp() < zzp2);
        } else if (i2 != 5) {
            throw zzzw.zzg();
        } else {
            do {
                zzzpVar.zzf(((zzyo) this.zza).zzk());
                if (this.zza.zzo()) {
                    return;
                }
                zza2 = this.zza.zza();
            } while (zza2 == this.zzb);
            this.zzd = zza2;
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final void zzE(List<Boolean> list) throws IOException {
        int zza;
        int zza2;
        if (list instanceof zzxz) {
            zzxz zzxzVar = (zzxz) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzxzVar.zzd(this.zza.zzd());
                    if (this.zza.zzo()) {
                        return;
                    }
                    zza2 = this.zza.zza();
                } while (zza2 == this.zzb);
                this.zzd = zza2;
                return;
            } else if (i == 2) {
                int zzp = this.zza.zzp() + ((zzyo) this.zza).zzh();
                do {
                    zzxzVar.zzd(this.zza.zzd());
                } while (this.zza.zzp() < zzp);
                zzS(zzp);
                return;
            } else {
                throw zzzw.zzg();
            }
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Boolean.valueOf(this.zza.zzd()));
                if (this.zza.zzo()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
        } else if (i2 == 2) {
            int zzp2 = this.zza.zzp() + ((zzyo) this.zza).zzh();
            do {
                list.add(Boolean.valueOf(this.zza.zzd()));
            } while (this.zza.zzp() < zzp2);
            zzS(zzp2);
        } else {
            throw zzzw.zzg();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final <T> void zzG(List<T> list, zzabd<T> zzabdVar, zzzb zzzbVar) throws IOException {
        int zza;
        int i = this.zzb;
        if ((i & 7) != 2) {
            throw zzzw.zzg();
        }
        do {
            list.add(zzQ(zzabdVar, zzzbVar));
            if (this.zza.zzo() || this.zzd != 0) {
                return;
            }
            zza = this.zza.zza();
        } while (zza == i);
        this.zzd = zza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final <T> void zzH(List<T> list, zzabd<T> zzabdVar, zzzb zzzbVar) throws IOException {
        int zza;
        int i = this.zzb;
        if ((i & 7) != 3) {
            throw zzzw.zzg();
        }
        do {
            list.add(zzR(zzabdVar, zzzbVar));
            if (this.zza.zzo() || this.zzd != 0) {
                return;
            }
            zza = this.zza.zza();
        } while (zza == i);
        this.zzd = zza;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final void zzI(List<zzym> list) throws IOException {
        int zza;
        if ((this.zzb & 7) != 2) {
            throw zzzw.zzg();
        }
        do {
            list.add(zzq());
            if (this.zza.zzo()) {
                return;
            }
            zza = this.zza.zza();
        } while (zza == this.zzb);
        this.zzd = zza;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final void zzJ(List<Integer> list) throws IOException {
        int zza;
        int zza2;
        if (list instanceof zzzp) {
            zzzp zzzpVar = (zzzp) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzzpVar.zzf(((zzyo) this.zza).zzh());
                    if (this.zza.zzo()) {
                        return;
                    }
                    zza2 = this.zza.zza();
                } while (zza2 == this.zzb);
                this.zzd = zza2;
                return;
            } else if (i == 2) {
                int zzp = this.zza.zzp() + ((zzyo) this.zza).zzh();
                do {
                    zzzpVar.zzf(((zzyo) this.zza).zzh());
                } while (this.zza.zzp() < zzp);
                zzS(zzp);
                return;
            } else {
                throw zzzw.zzg();
            }
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(((zzyo) this.zza).zzh()));
                if (this.zza.zzo()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
        } else if (i2 == 2) {
            int zzp2 = this.zza.zzp() + ((zzyo) this.zza).zzh();
            do {
                list.add(Integer.valueOf(((zzyo) this.zza).zzh()));
            } while (this.zza.zzp() < zzp2);
            zzS(zzp2);
        } else {
            throw zzzw.zzg();
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final void zzK(List<Integer> list) throws IOException {
        int zza;
        int zza2;
        if (list instanceof zzzp) {
            zzzp zzzpVar = (zzzp) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzzpVar.zzf(((zzyo) this.zza).zzh());
                    if (this.zza.zzo()) {
                        return;
                    }
                    zza2 = this.zza.zza();
                } while (zza2 == this.zzb);
                this.zzd = zza2;
                return;
            } else if (i == 2) {
                int zzp = this.zza.zzp() + ((zzyo) this.zza).zzh();
                do {
                    zzzpVar.zzf(((zzyo) this.zza).zzh());
                } while (this.zza.zzp() < zzp);
                zzS(zzp);
                return;
            } else {
                throw zzzw.zzg();
            }
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(((zzyo) this.zza).zzh()));
                if (this.zza.zzo()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
        } else if (i2 == 2) {
            int zzp2 = this.zza.zzp() + ((zzyo) this.zza).zzh();
            do {
                list.add(Integer.valueOf(((zzyo) this.zza).zzh()));
            } while (this.zza.zzp() < zzp2);
            zzS(zzp2);
        } else {
            throw zzzw.zzg();
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final void zzL(List<Integer> list) throws IOException {
        int zza;
        int zza2;
        if (!(list instanceof zzzp)) {
            int i = this.zzb & 7;
            if (i == 2) {
                int zzh = ((zzyo) this.zza).zzh();
                zzT(zzh);
                int zzp = this.zza.zzp() + zzh;
                do {
                    list.add(Integer.valueOf(((zzyo) this.zza).zzk()));
                } while (this.zza.zzp() < zzp);
                return;
            } else if (i != 5) {
                throw zzzw.zzg();
            } else {
                do {
                    list.add(Integer.valueOf(((zzyo) this.zza).zzk()));
                    if (this.zza.zzo()) {
                        return;
                    }
                    zza = this.zza.zza();
                } while (zza == this.zzb);
                this.zzd = zza;
                return;
            }
        }
        zzzp zzzpVar = (zzzp) list;
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int zzh2 = ((zzyo) this.zza).zzh();
            zzT(zzh2);
            int zzp2 = this.zza.zzp() + zzh2;
            do {
                zzzpVar.zzf(((zzyo) this.zza).zzk());
            } while (this.zza.zzp() < zzp2);
        } else if (i2 != 5) {
            throw zzzw.zzg();
        } else {
            do {
                zzzpVar.zzf(((zzyo) this.zza).zzk());
                if (this.zza.zzo()) {
                    return;
                }
                zza2 = this.zza.zza();
            } while (zza2 == this.zzb);
            this.zzd = zza2;
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final void zzM(List<Long> list) throws IOException {
        int zza;
        int zza2;
        if (list instanceof zzaag) {
            zzaag zzaagVar = (zzaag) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzaagVar.zzf(((zzyo) this.zza).zzl());
                    if (this.zza.zzo()) {
                        return;
                    }
                    zza2 = this.zza.zza();
                } while (zza2 == this.zzb);
                this.zzd = zza2;
                return;
            } else if (i == 2) {
                int zzh = ((zzyo) this.zza).zzh();
                zzU(zzh);
                int zzp = this.zza.zzp() + zzh;
                do {
                    zzaagVar.zzf(((zzyo) this.zza).zzl());
                } while (this.zza.zzp() < zzp);
                return;
            } else {
                throw zzzw.zzg();
            }
        }
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                list.add(Long.valueOf(((zzyo) this.zza).zzl()));
                if (this.zza.zzo()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
        } else if (i2 == 2) {
            int zzh2 = ((zzyo) this.zza).zzh();
            zzU(zzh2);
            int zzp2 = this.zza.zzp() + zzh2;
            do {
                list.add(Long.valueOf(((zzyo) this.zza).zzl()));
            } while (this.zza.zzp() < zzp2);
        } else {
            throw zzzw.zzg();
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final void zzN(List<Integer> list) throws IOException {
        int zza;
        int zza2;
        if (list instanceof zzzp) {
            zzzp zzzpVar = (zzzp) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzzpVar.zzf(zzyo.zzt(((zzyo) this.zza).zzh()));
                    if (this.zza.zzo()) {
                        return;
                    }
                    zza2 = this.zza.zza();
                } while (zza2 == this.zzb);
                this.zzd = zza2;
                return;
            } else if (i == 2) {
                int zzp = this.zza.zzp() + ((zzyo) this.zza).zzh();
                do {
                    zzzpVar.zzf(zzyo.zzt(((zzyo) this.zza).zzh()));
                } while (this.zza.zzp() < zzp);
                zzS(zzp);
                return;
            } else {
                throw zzzw.zzg();
            }
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(zzyo.zzt(((zzyo) this.zza).zzh())));
                if (this.zza.zzo()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
        } else if (i2 == 2) {
            int zzp2 = this.zza.zzp() + ((zzyo) this.zza).zzh();
            do {
                list.add(Integer.valueOf(zzyo.zzt(((zzyo) this.zza).zzh())));
            } while (this.zza.zzp() < zzp2);
            zzS(zzp2);
        } else {
            throw zzzw.zzg();
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final void zzO(List<Long> list) throws IOException {
        int zza;
        int zza2;
        if (list instanceof zzaag) {
            zzaag zzaagVar = (zzaag) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaagVar.zzf(zzyo.zzu(((zzyo) this.zza).zzi()));
                    if (this.zza.zzo()) {
                        return;
                    }
                    zza2 = this.zza.zza();
                } while (zza2 == this.zzb);
                this.zzd = zza2;
                return;
            } else if (i == 2) {
                int zzp = this.zza.zzp() + ((zzyo) this.zza).zzh();
                do {
                    zzaagVar.zzf(zzyo.zzu(((zzyo) this.zza).zzi()));
                } while (this.zza.zzp() < zzp);
                zzS(zzp);
                return;
            } else {
                throw zzzw.zzg();
            }
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(zzyo.zzu(((zzyo) this.zza).zzi())));
                if (this.zza.zzo()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
        } else if (i2 == 2) {
            int zzp2 = this.zza.zzp() + ((zzyo) this.zza).zzh();
            do {
                list.add(Long.valueOf(zzyo.zzu(((zzyo) this.zza).zzi())));
            } while (this.zza.zzp() < zzp2);
            zzS(zzp2);
        } else {
            throw zzzw.zzg();
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final int zzb() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            i = this.zza.zza();
            this.zzb = i;
        }
        if (i == 0 || i == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i >>> 3;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final int zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final boolean zzd() throws IOException {
        int i;
        if (this.zza.zzo() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzc(i);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final double zze() throws IOException {
        zzP(1);
        return Double.longBitsToDouble(((zzyo) this.zza).zzl());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final float zzf() throws IOException {
        zzP(5);
        return Float.intBitsToFloat(((zzyo) this.zza).zzk());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final long zzg() throws IOException {
        zzP(0);
        return ((zzyo) this.zza).zzi();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final long zzh() throws IOException {
        zzP(0);
        return ((zzyo) this.zza).zzi();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final int zzi() throws IOException {
        zzP(0);
        return ((zzyo) this.zza).zzh();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final long zzj() throws IOException {
        zzP(1);
        return ((zzyo) this.zza).zzl();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final int zzk() throws IOException {
        zzP(5);
        return ((zzyo) this.zza).zzk();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final boolean zzl() throws IOException {
        zzP(0);
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final String zzm() throws IOException {
        zzP(2);
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final String zzn() throws IOException {
        zzP(2);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final <T> T zzo(zzabd<T> zzabdVar, zzzb zzzbVar) throws IOException {
        zzP(2);
        return (T) zzQ(zzabdVar, zzzbVar);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final <T> T zzp(zzabd<T> zzabdVar, zzzb zzzbVar) throws IOException {
        zzP(3);
        return (T) zzR(zzabdVar, zzzbVar);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final zzym zzq() throws IOException {
        zzP(2);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final int zzr() throws IOException {
        zzP(0);
        return ((zzyo) this.zza).zzh();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final int zzs() throws IOException {
        zzP(0);
        return ((zzyo) this.zza).zzh();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final int zzt() throws IOException {
        zzP(5);
        return ((zzyo) this.zza).zzk();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final long zzu() throws IOException {
        zzP(1);
        return ((zzyo) this.zza).zzl();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final int zzv() throws IOException {
        zzP(0);
        return zzyo.zzt(((zzyo) this.zza).zzh());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final long zzw() throws IOException {
        zzP(0);
        return zzyo.zzu(((zzyo) this.zza).zzi());
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final void zzx(List<Double> list) throws IOException {
        int zza;
        int zza2;
        if (list instanceof zzyy) {
            zzyy zzyyVar = (zzyy) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzyyVar.zzd(Double.longBitsToDouble(((zzyo) this.zza).zzl()));
                    if (this.zza.zzo()) {
                        return;
                    }
                    zza2 = this.zza.zza();
                } while (zza2 == this.zzb);
                this.zzd = zza2;
                return;
            } else if (i == 2) {
                int zzh = ((zzyo) this.zza).zzh();
                zzU(zzh);
                int zzp = this.zza.zzp() + zzh;
                do {
                    zzyyVar.zzd(Double.longBitsToDouble(((zzyo) this.zza).zzl()));
                } while (this.zza.zzp() < zzp);
                return;
            } else {
                throw zzzw.zzg();
            }
        }
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                list.add(Double.valueOf(Double.longBitsToDouble(((zzyo) this.zza).zzl())));
                if (this.zza.zzo()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
        } else if (i2 == 2) {
            int zzh2 = ((zzyo) this.zza).zzh();
            zzU(zzh2);
            int zzp2 = this.zza.zzp() + zzh2;
            do {
                list.add(Double.valueOf(Double.longBitsToDouble(((zzyo) this.zza).zzl())));
            } while (this.zza.zzp() < zzp2);
        } else {
            throw zzzw.zzg();
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final void zzy(List<Float> list) throws IOException {
        int zza;
        int zza2;
        if (!(list instanceof zzzi)) {
            int i = this.zzb & 7;
            if (i == 2) {
                int zzh = ((zzyo) this.zza).zzh();
                zzT(zzh);
                int zzp = this.zza.zzp() + zzh;
                do {
                    list.add(Float.valueOf(Float.intBitsToFloat(((zzyo) this.zza).zzk())));
                } while (this.zza.zzp() < zzp);
                return;
            } else if (i != 5) {
                throw zzzw.zzg();
            } else {
                do {
                    list.add(Float.valueOf(Float.intBitsToFloat(((zzyo) this.zza).zzk())));
                    if (this.zza.zzo()) {
                        return;
                    }
                    zza = this.zza.zza();
                } while (zza == this.zzb);
                this.zzd = zza;
                return;
            }
        }
        zzzi zzziVar = (zzzi) list;
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int zzh2 = ((zzyo) this.zza).zzh();
            zzT(zzh2);
            int zzp2 = this.zza.zzp() + zzh2;
            do {
                zzziVar.zzd(Float.intBitsToFloat(((zzyo) this.zza).zzk()));
            } while (this.zza.zzp() < zzp2);
        } else if (i2 != 5) {
            throw zzzw.zzg();
        } else {
            do {
                zzziVar.zzd(Float.intBitsToFloat(((zzyo) this.zza).zzk()));
                if (this.zza.zzo()) {
                    return;
                }
                zza2 = this.zza.zza();
            } while (zza2 == this.zzb);
            this.zzd = zza2;
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabc
    public final void zzz(List<Long> list) throws IOException {
        int zza;
        int zza2;
        if (list instanceof zzaag) {
            zzaag zzaagVar = (zzaag) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaagVar.zzf(((zzyo) this.zza).zzi());
                    if (this.zza.zzo()) {
                        return;
                    }
                    zza2 = this.zza.zza();
                } while (zza2 == this.zzb);
                this.zzd = zza2;
                return;
            } else if (i == 2) {
                int zzp = this.zza.zzp() + ((zzyo) this.zza).zzh();
                do {
                    zzaagVar.zzf(((zzyo) this.zza).zzi());
                } while (this.zza.zzp() < zzp);
                zzS(zzp);
                return;
            } else {
                throw zzzw.zzg();
            }
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(((zzyo) this.zza).zzi()));
                if (this.zza.zzo()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
        } else if (i2 == 2) {
            int zzp2 = this.zza.zzp() + ((zzyo) this.zza).zzh();
            do {
                list.add(Long.valueOf(((zzyo) this.zza).zzi()));
            } while (this.zza.zzp() < zzp2);
            zzS(zzp2);
        } else {
            throw zzzw.zzg();
        }
    }

    public final void zzF(List<String> list, boolean z) throws IOException {
        int zza;
        int zza2;
        if ((this.zzb & 7) != 2) {
            throw zzzw.zzg();
        }
        if (!(list instanceof zzaab) || z) {
            do {
                list.add(z ? zzn() : zzm());
                if (this.zza.zzo()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
            return;
        }
        zzaab zzaabVar = (zzaab) list;
        do {
            zzaabVar.zzf(zzq());
            if (this.zza.zzo()) {
                return;
            }
            zza2 = this.zza.zza();
        } while (zza2 == this.zzb);
        this.zzd = zza2;
    }
}
