package com.google.android.gms.internal.p038firebaseauthapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztp */
/* loaded from: classes3.dex */
public abstract class zztp extends zzb implements zztq {
    public zztp() {
        super("com.google.firebase.auth.api.internal.IFirebaseAuthService");
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zztn zztnVar = null;
        switch (i) {
            case 101:
                zzlu zzluVar = (zzlu) zzc.zza(parcel, zzlu.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface;
                    } else {
                        zztnVar = new zztl(readStrongBinder);
                    }
                }
                zzb(zzluVar, zztnVar);
                break;
            case 102:
                zzms zzmsVar = (zzms) zzc.zza(parcel, zzms.CREATOR);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface2;
                    } else {
                        zztnVar = new zztl(readStrongBinder2);
                    }
                }
                zzc(zzmsVar, zztnVar);
                break;
            case 103:
                zzmq zzmqVar = (zzmq) zzc.zza(parcel, zzmq.CREATOR);
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface3 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface3;
                    } else {
                        zztnVar = new zztl(readStrongBinder3);
                    }
                }
                zzd(zzmqVar, zztnVar);
                break;
            case 104:
                zznk zznkVar = (zznk) zzc.zza(parcel, zznk.CREATOR);
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface4 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface4;
                    } else {
                        zztnVar = new zztl(readStrongBinder4);
                    }
                }
                zze(zznkVar, zztnVar);
                break;
            case 105:
                zzle zzleVar = (zzle) zzc.zza(parcel, zzle.CREATOR);
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface5 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface5;
                    } else {
                        zztnVar = new zztl(readStrongBinder5);
                    }
                }
                zzf(zzleVar, zztnVar);
                break;
            case 106:
                zzlg zzlgVar = (zzlg) zzc.zza(parcel, zzlg.CREATOR);
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface6 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface6;
                    } else {
                        zztnVar = new zztl(readStrongBinder6);
                    }
                }
                zzg(zzlgVar, zztnVar);
                break;
            case 107:
                zzlm zzlmVar = (zzlm) zzc.zza(parcel, zzlm.CREATOR);
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface7 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface7;
                    } else {
                        zztnVar = new zztl(readStrongBinder7);
                    }
                }
                zzh(zzlmVar, zztnVar);
                break;
            case 108:
                zzmu zzmuVar = (zzmu) zzc.zza(parcel, zzmu.CREATOR);
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface8 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface8;
                    } else {
                        zztnVar = new zztl(readStrongBinder8);
                    }
                }
                zzi(zzmuVar, zztnVar);
                break;
            case 109:
                zzlw zzlwVar = (zzlw) zzc.zza(parcel, zzlw.CREATOR);
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 != null) {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface9 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface9;
                    } else {
                        zztnVar = new zztl(readStrongBinder9);
                    }
                }
                zzj(zzlwVar, zztnVar);
                break;
            case 110:
            case 118:
            case 125:
            default:
                return false;
            case 111:
                zzly zzlyVar = (zzly) zzc.zza(parcel, zzly.CREATOR);
                IBinder readStrongBinder10 = parcel.readStrongBinder();
                if (readStrongBinder10 != null) {
                    IInterface queryLocalInterface10 = readStrongBinder10.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface10 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface10;
                    } else {
                        zztnVar = new zztl(readStrongBinder10);
                    }
                }
                zzk(zzlyVar, zztnVar);
                break;
            case 112:
                zzma zzmaVar = (zzma) zzc.zza(parcel, zzma.CREATOR);
                IBinder readStrongBinder11 = parcel.readStrongBinder();
                if (readStrongBinder11 != null) {
                    IInterface queryLocalInterface11 = readStrongBinder11.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface11 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface11;
                    } else {
                        zztnVar = new zztl(readStrongBinder11);
                    }
                }
                zzl(zzmaVar, zztnVar);
                break;
            case 113:
                zzng zzngVar = (zzng) zzc.zza(parcel, zzng.CREATOR);
                IBinder readStrongBinder12 = parcel.readStrongBinder();
                if (readStrongBinder12 != null) {
                    IInterface queryLocalInterface12 = readStrongBinder12.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface12 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface12;
                    } else {
                        zztnVar = new zztl(readStrongBinder12);
                    }
                }
                zzm(zzngVar, zztnVar);
                break;
            case 114:
                zzni zzniVar = (zzni) zzc.zza(parcel, zzni.CREATOR);
                IBinder readStrongBinder13 = parcel.readStrongBinder();
                if (readStrongBinder13 != null) {
                    IInterface queryLocalInterface13 = readStrongBinder13.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface13 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface13;
                    } else {
                        zztnVar = new zztl(readStrongBinder13);
                    }
                }
                zzn(zzniVar, zztnVar);
                break;
            case 115:
                zzme zzmeVar = (zzme) zzc.zza(parcel, zzme.CREATOR);
                IBinder readStrongBinder14 = parcel.readStrongBinder();
                if (readStrongBinder14 != null) {
                    IInterface queryLocalInterface14 = readStrongBinder14.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface14 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface14;
                    } else {
                        zztnVar = new zztl(readStrongBinder14);
                    }
                }
                zzo(zzmeVar, zztnVar);
                break;
            case 116:
                zzmo zzmoVar = (zzmo) zzc.zza(parcel, zzmo.CREATOR);
                IBinder readStrongBinder15 = parcel.readStrongBinder();
                if (readStrongBinder15 != null) {
                    IInterface queryLocalInterface15 = readStrongBinder15.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface15 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface15;
                    } else {
                        zztnVar = new zztl(readStrongBinder15);
                    }
                }
                zzp(zzmoVar, zztnVar);
                break;
            case 117:
                zzlo zzloVar = (zzlo) zzc.zza(parcel, zzlo.CREATOR);
                IBinder readStrongBinder16 = parcel.readStrongBinder();
                if (readStrongBinder16 != null) {
                    IInterface queryLocalInterface16 = readStrongBinder16.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface16 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface16;
                    } else {
                        zztnVar = new zztl(readStrongBinder16);
                    }
                }
                zzq(zzloVar, zztnVar);
                break;
            case 119:
                zzli zzliVar = (zzli) zzc.zza(parcel, zzli.CREATOR);
                IBinder readStrongBinder17 = parcel.readStrongBinder();
                if (readStrongBinder17 != null) {
                    IInterface queryLocalInterface17 = readStrongBinder17.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface17 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface17;
                    } else {
                        zztnVar = new zztl(readStrongBinder17);
                    }
                }
                zzr(zzliVar, zztnVar);
                break;
            case 120:
                zzlc zzlcVar = (zzlc) zzc.zza(parcel, zzlc.CREATOR);
                IBinder readStrongBinder18 = parcel.readStrongBinder();
                if (readStrongBinder18 != null) {
                    IInterface queryLocalInterface18 = readStrongBinder18.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface18 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface18;
                    } else {
                        zztnVar = new zztl(readStrongBinder18);
                    }
                }
                zzs(zzlcVar, zztnVar);
                break;
            case 121:
                zzlk zzlkVar = (zzlk) zzc.zza(parcel, zzlk.CREATOR);
                IBinder readStrongBinder19 = parcel.readStrongBinder();
                if (readStrongBinder19 != null) {
                    IInterface queryLocalInterface19 = readStrongBinder19.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface19 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface19;
                    } else {
                        zztnVar = new zztl(readStrongBinder19);
                    }
                }
                zzt(zzlkVar, zztnVar);
                break;
            case 122:
                zzmk zzmkVar = (zzmk) zzc.zza(parcel, zzmk.CREATOR);
                IBinder readStrongBinder20 = parcel.readStrongBinder();
                if (readStrongBinder20 != null) {
                    IInterface queryLocalInterface20 = readStrongBinder20.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface20 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface20;
                    } else {
                        zztnVar = new zztl(readStrongBinder20);
                    }
                }
                zzu(zzmkVar, zztnVar);
                break;
            case 123:
                zzmy zzmyVar = (zzmy) zzc.zza(parcel, zzmy.CREATOR);
                IBinder readStrongBinder21 = parcel.readStrongBinder();
                if (readStrongBinder21 != null) {
                    IInterface queryLocalInterface21 = readStrongBinder21.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface21 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface21;
                    } else {
                        zztnVar = new zztl(readStrongBinder21);
                    }
                }
                zzv(zzmyVar, zztnVar);
                break;
            case 124:
                zzmc zzmcVar = (zzmc) zzc.zza(parcel, zzmc.CREATOR);
                IBinder readStrongBinder22 = parcel.readStrongBinder();
                if (readStrongBinder22 != null) {
                    IInterface queryLocalInterface22 = readStrongBinder22.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface22 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface22;
                    } else {
                        zztnVar = new zztl(readStrongBinder22);
                    }
                }
                zzw(zzmcVar, zztnVar);
                break;
            case 126:
                zzmg zzmgVar = (zzmg) zzc.zza(parcel, zzmg.CREATOR);
                IBinder readStrongBinder23 = parcel.readStrongBinder();
                if (readStrongBinder23 != null) {
                    IInterface queryLocalInterface23 = readStrongBinder23.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface23 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface23;
                    } else {
                        zztnVar = new zztl(readStrongBinder23);
                    }
                }
                zzx(zzmgVar, zztnVar);
                break;
            case 127:
                zzmm zzmmVar = (zzmm) zzc.zza(parcel, zzmm.CREATOR);
                IBinder readStrongBinder24 = parcel.readStrongBinder();
                if (readStrongBinder24 != null) {
                    IInterface queryLocalInterface24 = readStrongBinder24.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface24 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface24;
                    } else {
                        zztnVar = new zztl(readStrongBinder24);
                    }
                }
                zzy(zzmmVar, zztnVar);
                break;
            case 128:
                zzmi zzmiVar = (zzmi) zzc.zza(parcel, zzmi.CREATOR);
                IBinder readStrongBinder25 = parcel.readStrongBinder();
                if (readStrongBinder25 != null) {
                    IInterface queryLocalInterface25 = readStrongBinder25.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface25 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface25;
                    } else {
                        zztnVar = new zztl(readStrongBinder25);
                    }
                }
                zzz(zzmiVar, zztnVar);
                break;
            case 129:
                zzmw zzmwVar = (zzmw) zzc.zza(parcel, zzmw.CREATOR);
                IBinder readStrongBinder26 = parcel.readStrongBinder();
                if (readStrongBinder26 != null) {
                    IInterface queryLocalInterface26 = readStrongBinder26.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface26 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface26;
                    } else {
                        zztnVar = new zztl(readStrongBinder26);
                    }
                }
                zzA(zzmwVar, zztnVar);
                break;
            case 130:
                zzna zznaVar = (zzna) zzc.zza(parcel, zzna.CREATOR);
                IBinder readStrongBinder27 = parcel.readStrongBinder();
                if (readStrongBinder27 != null) {
                    IInterface queryLocalInterface27 = readStrongBinder27.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface27 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface27;
                    } else {
                        zztnVar = new zztl(readStrongBinder27);
                    }
                }
                zzB(zznaVar, zztnVar);
                break;
            case 131:
                zzne zzneVar = (zzne) zzc.zza(parcel, zzne.CREATOR);
                IBinder readStrongBinder28 = parcel.readStrongBinder();
                if (readStrongBinder28 != null) {
                    IInterface queryLocalInterface28 = readStrongBinder28.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface28 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface28;
                    } else {
                        zztnVar = new zztl(readStrongBinder28);
                    }
                }
                zzD(zzneVar, zztnVar);
                break;
            case 132:
                zzlq zzlqVar = (zzlq) zzc.zza(parcel, zzlq.CREATOR);
                IBinder readStrongBinder29 = parcel.readStrongBinder();
                if (readStrongBinder29 != null) {
                    IInterface queryLocalInterface29 = readStrongBinder29.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface29 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface29;
                    } else {
                        zztnVar = new zztl(readStrongBinder29);
                    }
                }
                zzC(zzlqVar, zztnVar);
                break;
            case 133:
                zznc zzncVar = (zznc) zzc.zza(parcel, zznc.CREATOR);
                IBinder readStrongBinder30 = parcel.readStrongBinder();
                if (readStrongBinder30 != null) {
                    IInterface queryLocalInterface30 = readStrongBinder30.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface30 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface30;
                    } else {
                        zztnVar = new zztl(readStrongBinder30);
                    }
                }
                zzE(zzncVar, zztnVar);
                break;
            case 134:
                zzls zzlsVar = (zzls) zzc.zza(parcel, zzls.CREATOR);
                IBinder readStrongBinder31 = parcel.readStrongBinder();
                if (readStrongBinder31 != null) {
                    IInterface queryLocalInterface31 = readStrongBinder31.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface31 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface31;
                    } else {
                        zztnVar = new zztl(readStrongBinder31);
                    }
                }
                zzF(zzlsVar, zztnVar);
                break;
            case 135:
                zznm zznmVar = (zznm) zzc.zza(parcel, zznm.CREATOR);
                IBinder readStrongBinder32 = parcel.readStrongBinder();
                if (readStrongBinder32 != null) {
                    IInterface queryLocalInterface32 = readStrongBinder32.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface32 instanceof zztn) {
                        zztnVar = (zztn) queryLocalInterface32;
                    } else {
                        zztnVar = new zztl(readStrongBinder32);
                    }
                }
                zzG(zznmVar, zztnVar);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
