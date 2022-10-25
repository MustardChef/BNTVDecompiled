package com.google.firebase.auth.internal;

import com.google.android.gms.internal.p038firebaseauthapi.zzwr;
import com.google.firebase.auth.ActionCodeInfo;
import com.google.firebase.auth.ActionCodeResult;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class zzo implements ActionCodeResult {
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final ActionCodeInfo zzd;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public zzo(zzwr zzwrVar) {
        char c;
        this.zzb = zzwrVar.zzg() ? zzwrVar.zzc() : zzwrVar.zzb();
        this.zzc = zzwrVar.zzb();
        ActionCodeInfo actionCodeInfo = null;
        if (!zzwrVar.zzh()) {
            this.zza = 3;
            this.zzd = null;
            return;
        }
        String zzd = zzwrVar.zzd();
        switch (zzd.hashCode()) {
            case -1874510116:
                if (zzd.equals("REVERT_SECOND_FACTOR_ADDITION")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1452371317:
                if (zzd.equals("PASSWORD_RESET")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1341836234:
                if (zzd.equals("VERIFY_EMAIL")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1288726400:
                if (zzd.equals("VERIFY_BEFORE_UPDATE_EMAIL")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 870738373:
                if (zzd.equals("EMAIL_SIGNIN")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 970484929:
                if (zzd.equals("RECOVER_EMAIL")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        int i = c != 0 ? c != 1 ? c != 2 ? c != 3 ? c != 4 ? c != 5 ? 3 : 6 : 2 : 5 : 4 : 1 : 0;
        this.zza = i;
        if (i == 4 || i == 3) {
            this.zzd = null;
            return;
        }
        if (zzwrVar.zzi()) {
            actionCodeInfo = new zzn(zzwrVar.zzb(), zzba.zza(zzwrVar.zze()));
        } else if (zzwrVar.zzg()) {
            actionCodeInfo = new zzl(zzwrVar.zzc(), zzwrVar.zzb());
        } else if (zzwrVar.zzf()) {
            actionCodeInfo = new zzm(zzwrVar.zzb());
        }
        this.zzd = actionCodeInfo;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final String getData(int i) {
        if (this.zza == 4) {
            return null;
        }
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return this.zzc;
        }
        return this.zzb;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final ActionCodeInfo getInfo() {
        return this.zzd;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final int getOperation() {
        return this.zza;
    }
}
