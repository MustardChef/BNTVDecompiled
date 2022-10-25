package com.google.android.gms.internal.p038firebaseauthapi;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaj */
/* loaded from: classes3.dex */
public final class zzaaj implements zzabe {
    private static final zzaap zzb = new zzaah();
    private final zzaap zza;

    public zzaaj() {
        zzaap zzaapVar;
        zzaap[] zzaapVarArr = new zzaap[2];
        zzaapVarArr[0] = zzzj.zza();
        try {
            zzaapVar = (zzaap) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzaapVar = zzb;
        }
        zzaapVarArr[1] = zzaapVar;
        zzaai zzaaiVar = new zzaai(zzaapVarArr);
        zzzu.zzb(zzaaiVar, "messageInfoFactory");
        this.zza = zzaaiVar;
    }

    private static boolean zzb(zzaao zzaaoVar) {
        return zzaaoVar.zzc() == 1;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzabe
    public final <T> zzabd<T> zza(Class<T> cls) {
        zzabf.zza(cls);
        zzaao zzc = this.zza.zzc(cls);
        if (!zzc.zza()) {
            if (zzzo.class.isAssignableFrom(cls)) {
                if (zzb(zzc)) {
                    return zzaau.zzl(cls, zzc, zzaax.zzb(), zzaaf.zze(), zzabf.zzC(), zzze.zza(), zzaan.zzb());
                }
                return zzaau.zzl(cls, zzc, zzaax.zzb(), zzaaf.zze(), zzabf.zzC(), null, zzaan.zzb());
            } else if (zzb(zzc)) {
                return zzaau.zzl(cls, zzc, zzaax.zza(), zzaaf.zzd(), zzabf.zzA(), zzze.zzb(), zzaan.zza());
            } else {
                return zzaau.zzl(cls, zzc, zzaax.zza(), zzaaf.zzd(), zzabf.zzB(), null, zzaan.zza());
            }
        } else if (zzzo.class.isAssignableFrom(cls)) {
            return zzaav.zzg(zzabf.zzC(), zzze.zza(), zzc.zzb());
        } else {
            return zzaav.zzg(zzabf.zzA(), zzze.zzb(), zzc.zzb());
        }
    }
}
