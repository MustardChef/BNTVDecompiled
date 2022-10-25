package com.google.android.gms.internal.p038firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzat */
/* loaded from: classes3.dex */
public final class zzat {
    private final zzib zza;

    private zzat(zzib zzibVar) {
        this.zza = zzibVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final zzat zza(zzib zzibVar) throws GeneralSecurityException {
        zzg(zzibVar);
        return new zzat(zzibVar);
    }

    public static void zzg(zzib zzibVar) throws GeneralSecurityException {
        if (zzibVar == null || zzibVar.zzc() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    public static final zzat zzi(zzdo zzdoVar, zzag zzagVar) throws GeneralSecurityException, IOException {
        zzgy zzb = zzdoVar.zzb();
        if (zzb == null || zzb.zza().zzc() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        try {
            zzib zze = zzib.zze(zzagVar.zzb(zzb.zza().zzp(), new byte[0]), zzzb.zza());
            zzg(zze);
            return new zzat(zze);
        } catch (zzzw unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    public final String toString() {
        return zzbl.zza(this.zza).toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzib zzb() {
        return this.zza;
    }

    public final zzig zzc() {
        return zzbl.zza(this.zza);
    }

    public final void zzd(zzav zzavVar, zzag zzagVar) throws GeneralSecurityException, IOException {
        zzib zzibVar = this.zza;
        byte[] zza = zzagVar.zza(zzibVar.zzI(), new byte[0]);
        try {
            if (!zzib.zze(zzagVar.zzb(zza, new byte[0]), zzzb.zza()).equals(zzibVar)) {
                throw new GeneralSecurityException("cannot encrypt keyset");
            }
            zzgx zzc = zzgy.zzc();
            zzc.zza(zzym.zzm(zza));
            zzc.zzb(zzbl.zza(zzibVar));
            zzavVar.zzc(zzc.zzl());
        } catch (zzzw unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zze(com.google.android.gms.internal.p038firebaseauthapi.zzav r5) throws java.security.GeneralSecurityException, java.io.IOException {
        /*
            r4 = this;
            com.google.android.gms.internal.firebase-auth-api.zzib r0 = r4.zza
            java.util.List r0 = r0.zzb()
            java.util.Iterator r0 = r0.iterator()
        La:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L60
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.firebase-auth-api.zzia r1 = (com.google.android.gms.internal.p038firebaseauthapi.zzia) r1
            com.google.android.gms.internal.firebase-auth-api.zzho r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzhn r2 = r2.zzc()
            com.google.android.gms.internal.firebase-auth-api.zzhn r3 = com.google.android.gms.internal.p038firebaseauthapi.zzhn.UNKNOWN_KEYMATERIAL
            if (r2 == r3) goto L3b
            com.google.android.gms.internal.firebase-auth-api.zzho r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzhn r2 = r2.zzc()
            com.google.android.gms.internal.firebase-auth-api.zzhn r3 = com.google.android.gms.internal.p038firebaseauthapi.zzhn.SYMMETRIC
            if (r2 == r3) goto L3b
            com.google.android.gms.internal.firebase-auth-api.zzho r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzhn r2 = r2.zzc()
            com.google.android.gms.internal.firebase-auth-api.zzhn r3 = com.google.android.gms.internal.p038firebaseauthapi.zzhn.ASYMMETRIC_PRIVATE
            if (r2 == r3) goto L3b
            goto La
        L3b:
            java.security.GeneralSecurityException r5 = new java.security.GeneralSecurityException
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r2 = 0
            com.google.android.gms.internal.firebase-auth-api.zzho r3 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzhn r3 = r3.zzc()
            r0[r2] = r3
            r2 = 1
            com.google.android.gms.internal.firebase-auth-api.zzho r1 = r1.zzb()
            java.lang.String r1 = r1.zza()
            r0[r2] = r1
            java.lang.String r1 = "keyset contains key material of type %s for type url %s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            r5.<init>(r0)
            throw r5
        L60:
            com.google.android.gms.internal.firebase-auth-api.zzib r0 = r4.zza
            r5.zzb(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p038firebaseauthapi.zzat.zze(com.google.android.gms.internal.firebase-auth-api.zzav):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <P> P zzh(Class<P> cls) throws GeneralSecurityException {
        Class<?> zzm = zzbk.zzm(cls);
        if (zzm == null) {
            String valueOf = String.valueOf(cls.getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "No wrapper found for ".concat(valueOf) : new String("No wrapper found for "));
        }
        zzbl.zzb(this.zza);
        zzbc zzb = zzbc.zzb(zzm);
        for (zzia zziaVar : this.zza.zzb()) {
            if (zziaVar.zzc() == zzhq.ENABLED) {
                zzba zzd = zzb.zzd(zzbk.zzk(zziaVar.zzb(), zzm), zziaVar);
                if (zziaVar.zzd() == this.zza.zza()) {
                    zzb.zzc(zzd);
                }
            }
        }
        return (P) zzbk.zzl(zzb, cls);
    }

    public final zzat zzf() throws GeneralSecurityException {
        if (this.zza == null) {
            throw new GeneralSecurityException("cleartext keyset is not available");
        }
        zzhy zzf = zzib.zzf();
        for (zzia zziaVar : this.zza.zzb()) {
            zzho zzb = zziaVar.zzb();
            if (zzb.zzc() == zzhn.ASYMMETRIC_PRIVATE) {
                zzho zzg = zzbk.zzg(zzb.zza(), zzb.zzb());
                zzbk.zzj(zzg);
                zzhz zzf2 = zzia.zzf();
                zzf2.zzm(zziaVar);
                zzf2.zza(zzg);
                zzf.zze(zzf2.zzl());
            } else {
                throw new GeneralSecurityException("The keyset contains a non-private key");
            }
        }
        zzf.zza(this.zza.zza());
        return new zzat(zzf.zzl());
    }
}
