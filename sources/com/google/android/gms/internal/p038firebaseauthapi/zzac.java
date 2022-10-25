package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzac */
/* loaded from: classes3.dex */
abstract class zzac extends zzj<String> {
    final CharSequence zzb;
    final zzp zzc;
    int zzd = 0;
    int zze;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzac(zzae zzaeVar, CharSequence charSequence) {
        zzp zzpVar;
        zzpVar = zzaeVar.zza;
        this.zzc = zzpVar;
        this.zze = Integer.MAX_VALUE;
        this.zzb = charSequence;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzj
    protected final /* bridge */ /* synthetic */ String zza() {
        int zzd;
        int i = this.zzd;
        while (true) {
            int i2 = this.zzd;
            if (i2 == -1) {
                zzb();
                return null;
            }
            int zzc = zzc(i2);
            if (zzc == -1) {
                zzc = this.zzb.length();
                this.zzd = -1;
                zzd = -1;
            } else {
                zzd = zzd(zzc);
                this.zzd = zzd;
            }
            if (zzd != i) {
                if (i < zzc) {
                    this.zzb.charAt(i);
                }
                if (i < zzc) {
                    this.zzb.charAt(zzc - 1);
                }
                int i3 = this.zze;
                if (i3 == 1) {
                    zzc = this.zzb.length();
                    this.zzd = -1;
                    if (zzc > i) {
                        this.zzb.charAt(zzc - 1);
                    }
                } else {
                    this.zze = i3 - 1;
                }
                return this.zzb.subSequence(i, zzc).toString();
            }
            int i4 = zzd + 1;
            this.zzd = i4;
            if (i4 > this.zzb.length()) {
                this.zzd = -1;
            }
        }
    }

    abstract int zzc(int i);

    abstract int zzd(int i);
}
