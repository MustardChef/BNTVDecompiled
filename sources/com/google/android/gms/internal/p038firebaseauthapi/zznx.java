package com.google.android.gms.internal.p038firebaseauthapi;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznx */
/* loaded from: classes3.dex */
public final class zznx implements zzup<zzwx> {
    final /* synthetic */ zzww zza;
    final /* synthetic */ zzvz zzb;
    final /* synthetic */ zztb zzc;
    final /* synthetic */ zzwg zzd;
    final /* synthetic */ zzuo zze;
    final /* synthetic */ zzpj zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznx(zzpj zzpjVar, zzww zzwwVar, zzvz zzvzVar, zztb zztbVar, zzwg zzwgVar, zzuo zzuoVar) {
        this.zzf = zzpjVar;
        this.zza = zzwwVar;
        this.zzb = zzvzVar;
        this.zzc = zztbVar;
        this.zzd = zzwgVar;
        this.zze = zzuoVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzuo
    public final void zza(String str) {
        this.zze.zza(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ void zzb(com.google.android.gms.internal.p038firebaseauthapi.zzwx r7) {
        /*
            r6 = this;
            com.google.android.gms.internal.firebase-auth-api.zzwx r7 = (com.google.android.gms.internal.p038firebaseauthapi.zzwx) r7
            com.google.android.gms.internal.firebase-auth-api.zzww r0 = r6.zza
            java.lang.String r1 = "EMAIL"
            boolean r0 = r0.zzb(r1)
            r1 = 0
            if (r0 == 0) goto L13
            com.google.android.gms.internal.firebase-auth-api.zzvz r0 = r6.zzb
            r0.zzj(r1)
            goto L26
        L13:
            com.google.android.gms.internal.firebase-auth-api.zzww r0 = r6.zza
            java.lang.String r0 = r0.zzc()
            if (r0 == 0) goto L26
            com.google.android.gms.internal.firebase-auth-api.zzvz r0 = r6.zzb
            com.google.android.gms.internal.firebase-auth-api.zzww r2 = r6.zza
            java.lang.String r2 = r2.zzc()
            r0.zzj(r2)
        L26:
            com.google.android.gms.internal.firebase-auth-api.zzww r0 = r6.zza
            java.lang.String r2 = "DISPLAY_NAME"
            boolean r0 = r0.zzb(r2)
            if (r0 == 0) goto L36
            com.google.android.gms.internal.firebase-auth-api.zzvz r0 = r6.zzb
            r0.zzk(r1)
            goto L49
        L36:
            com.google.android.gms.internal.firebase-auth-api.zzww r0 = r6.zza
            java.lang.String r0 = r0.zze()
            if (r0 == 0) goto L49
            com.google.android.gms.internal.firebase-auth-api.zzvz r0 = r6.zzb
            com.google.android.gms.internal.firebase-auth-api.zzww r2 = r6.zza
            java.lang.String r2 = r2.zze()
            r0.zzk(r2)
        L49:
            com.google.android.gms.internal.firebase-auth-api.zzww r0 = r6.zza
            java.lang.String r2 = "PHOTO_URL"
            boolean r0 = r0.zzb(r2)
            if (r0 == 0) goto L59
            com.google.android.gms.internal.firebase-auth-api.zzvz r0 = r6.zzb
        L55:
            r0.zzl(r1)
            goto L6a
        L59:
            com.google.android.gms.internal.firebase-auth-api.zzww r0 = r6.zza
            java.lang.String r0 = r0.zzf()
            if (r0 == 0) goto L6a
            com.google.android.gms.internal.firebase-auth-api.zzvz r0 = r6.zzb
            com.google.android.gms.internal.firebase-auth-api.zzww r1 = r6.zza
            java.lang.String r1 = r1.zzf()
            goto L55
        L6a:
            com.google.android.gms.internal.firebase-auth-api.zzww r0 = r6.zza
            java.lang.String r0 = r0.zzd()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L85
            com.google.android.gms.internal.firebase-auth-api.zzvz r0 = r6.zzb
            java.lang.String r1 = "redacted"
            byte[] r1 = r1.getBytes()
            java.lang.String r1 = com.google.android.gms.common.util.Base64Utils.encode(r1)
            r0.zzm(r1)
        L85:
            java.util.List r0 = r7.zzf()
            if (r0 != 0) goto L90
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L90:
            com.google.android.gms.internal.firebase-auth-api.zzvz r1 = r6.zzb
            r1.zzn(r0)
            com.google.android.gms.internal.firebase-auth-api.zztb r0 = r6.zzc
            com.google.android.gms.internal.firebase-auth-api.zzwg r1 = r6.zzd
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)
            java.lang.String r2 = r7.zzb()
            java.lang.String r3 = r7.zzc()
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto Lc5
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto Lc5
            long r4 = r7.zzd()
            com.google.android.gms.internal.firebase-auth-api.zzwg r7 = new com.google.android.gms.internal.firebase-auth-api.zzwg
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.String r1 = r1.zzg()
            r7.<init>(r3, r2, r4, r1)
            r1 = r7
        Lc5:
            com.google.android.gms.internal.firebase-auth-api.zzvz r7 = r6.zzb
            r0.zzb(r1, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p038firebaseauthapi.zznx.zzb(java.lang.Object):void");
    }
}
