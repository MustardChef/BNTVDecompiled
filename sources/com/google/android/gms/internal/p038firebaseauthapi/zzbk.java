package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.ads.interactivemedia.p034v3.internal.bqk;
import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbk */
/* loaded from: classes3.dex */
public final class zzbk {
    private static final Logger zza = Logger.getLogger(zzbk.class.getName());
    private static final ConcurrentMap<String, zzbj> zzb = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzbi> zzc = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Boolean> zzd = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Object> zze = new ConcurrentHashMap();
    private static final ConcurrentMap<Class<?>, zzbd<?, ?>> zzf = new ConcurrentHashMap();

    private zzbk() {
    }

    public static synchronized <KeyProtoT extends zzaar> void zza(zzas<KeyProtoT> zzasVar, boolean z) throws GeneralSecurityException {
        synchronized (zzbk.class) {
            String zzb2 = zzasVar.zzb();
            zzo(zzb2, zzasVar.getClass(), true);
            ConcurrentMap<String, zzbj> concurrentMap = zzb;
            if (!concurrentMap.containsKey(zzb2)) {
                concurrentMap.put(zzb2, new zzbg(zzasVar));
                zzc.put(zzb2, new zzbi(zzasVar));
            }
            zzd.put(zzb2, true);
        }
    }

    public static synchronized <KeyProtoT extends zzaar, PublicKeyProtoT extends zzaar> void zzb(zzbf<KeyProtoT, PublicKeyProtoT> zzbfVar, zzas<PublicKeyProtoT> zzasVar, boolean z) throws GeneralSecurityException {
        Class<?> zze2;
        synchronized (zzbk.class) {
            zzo("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", zzbfVar.getClass(), true);
            zzo("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", zzasVar.getClass(), false);
            ConcurrentMap<String, zzbj> concurrentMap = zzb;
            if (concurrentMap.containsKey("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey") && (zze2 = concurrentMap.get("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey").zze()) != null && !zze2.equals(zzasVar.getClass())) {
                Logger logger = zza;
                Level level = Level.WARNING;
                StringBuilder sb = new StringBuilder((int) bqk.f6557bQ);
                sb.append("Attempted overwrite of a registered key manager for key type ");
                sb.append("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
                sb.append(" with inconsistent public key type ");
                sb.append("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
                logger.logp(level, "com.google.crypto.tink.Registry", "registerAsymmetricKeyManagers", sb.toString());
                throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", zzbfVar.getClass().getName(), zze2.getName(), zzasVar.getClass().getName()));
            }
            if (!concurrentMap.containsKey("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey") || concurrentMap.get("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey").zze() == null) {
                concurrentMap.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", new zzbh(zzbfVar, zzasVar));
                zzc.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", new zzbi(zzbfVar));
            }
            ConcurrentMap<String, Boolean> concurrentMap2 = zzd;
            concurrentMap2.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", true);
            if (!concurrentMap.containsKey("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey")) {
                concurrentMap.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", new zzbg(zzasVar));
            }
            concurrentMap2.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", false);
        }
    }

    public static synchronized <B, P> void zzc(zzbd<B, P> zzbdVar) throws GeneralSecurityException {
        synchronized (zzbk.class) {
            if (zzbdVar != null) {
                Class<P> zzb2 = zzbdVar.zzb();
                ConcurrentMap<Class<?>, zzbd<?, ?>> concurrentMap = zzf;
                if (concurrentMap.containsKey(zzb2)) {
                    zzbd<?, ?> zzbdVar2 = concurrentMap.get(zzb2);
                    if (!zzbdVar.getClass().equals(zzbdVar2.getClass())) {
                        Logger logger = zza;
                        Level level = Level.WARNING;
                        String valueOf = String.valueOf(zzb2);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 56);
                        sb.append("Attempted overwrite of a registered SetWrapper for type ");
                        sb.append(valueOf);
                        logger.logp(level, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", sb.toString());
                        throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", zzb2.getName(), zzbdVar2.getClass().getName(), zzbdVar.getClass().getName()));
                    }
                }
                concurrentMap.put(zzb2, zzbdVar);
            } else {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
        }
    }

    public static zzam<?> zzd(String str) throws GeneralSecurityException {
        return zzn(str).zzb();
    }

    public static synchronized zzho zze(zzht zzhtVar) throws GeneralSecurityException {
        zzho zzd2;
        synchronized (zzbk.class) {
            zzam<?> zzd3 = zzd(zzhtVar.zza());
            if (zzd.get(zzhtVar.zza()).booleanValue()) {
                zzd2 = zzd3.zzd(zzhtVar.zzb());
            } else {
                String valueOf = String.valueOf(zzhtVar.zza());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzd2;
    }

    public static synchronized zzaar zzf(zzht zzhtVar) throws GeneralSecurityException {
        zzaar zzc2;
        synchronized (zzbk.class) {
            zzam<?> zzd2 = zzd(zzhtVar.zza());
            if (zzd.get(zzhtVar.zza()).booleanValue()) {
                zzc2 = zzd2.zzc(zzhtVar.zzb());
            } else {
                String valueOf = String.valueOf(zzhtVar.zza());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzc2;
    }

    public static zzho zzg(String str, zzym zzymVar) throws GeneralSecurityException {
        zzam zzp = zzp(str, null);
        if (!(zzp instanceof zzbe)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 48);
            sb.append("manager for key type ");
            sb.append(str);
            sb.append(" is not a PrivateKeyManager");
            throw new GeneralSecurityException(sb.toString());
        }
        return ((zzbe) zzp).zze(zzymVar);
    }

    public static <P> P zzh(String str, zzaar zzaarVar, Class<P> cls) throws GeneralSecurityException {
        return (P) zzp(str, cls).zzb(zzaarVar);
    }

    public static <P> P zzi(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        return (P) zzq(str, zzym.zzm(bArr), cls);
    }

    @Deprecated
    public static <P> P zzj(zzho zzhoVar) throws GeneralSecurityException {
        return (P) zzq(zzhoVar.zza(), zzhoVar.zzb(), null);
    }

    public static <P> P zzk(zzho zzhoVar, Class<P> cls) throws GeneralSecurityException {
        return (P) zzq(zzhoVar.zza(), zzhoVar.zzb(), cls);
    }

    public static <B, P> P zzl(zzbc<B> zzbcVar, Class<P> cls) throws GeneralSecurityException {
        zzbd<?, ?> zzbdVar = zzf.get(cls);
        if (zzbdVar == null) {
            String valueOf = String.valueOf(zzbcVar.zze().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "No wrapper found for ".concat(valueOf) : new String("No wrapper found for "));
        } else if (!zzbdVar.zzc().equals(zzbcVar.zze())) {
            String valueOf2 = String.valueOf(zzbdVar.zzc());
            String valueOf3 = String.valueOf(zzbcVar.zze());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 44 + String.valueOf(valueOf3).length());
            sb.append("Wrong input primitive class, expected ");
            sb.append(valueOf2);
            sb.append(", got ");
            sb.append(valueOf3);
            throw new GeneralSecurityException(sb.toString());
        } else {
            return (P) zzbdVar.zza(zzbcVar);
        }
    }

    public static Class<?> zzm(Class<?> cls) {
        zzbd<?, ?> zzbdVar = zzf.get(cls);
        if (zzbdVar == null) {
            return null;
        }
        return zzbdVar.zzc();
    }

    private static synchronized zzbj zzn(String str) throws GeneralSecurityException {
        zzbj zzbjVar;
        synchronized (zzbk.class) {
            ConcurrentMap<String, zzbj> concurrentMap = zzb;
            if (!concurrentMap.containsKey(str)) {
                String valueOf = String.valueOf(str);
                throw new GeneralSecurityException(valueOf.length() != 0 ? "No key manager found for key type ".concat(valueOf) : new String("No key manager found for key type "));
            }
            zzbjVar = concurrentMap.get(str);
        }
        return zzbjVar;
    }

    private static synchronized void zzo(String str, Class<?> cls, boolean z) throws GeneralSecurityException {
        synchronized (zzbk.class) {
            ConcurrentMap<String, zzbj> concurrentMap = zzb;
            if (concurrentMap.containsKey(str)) {
                zzbj zzbjVar = concurrentMap.get(str);
                if (!zzbjVar.zzc().equals(cls)) {
                    zza.logp(Level.WARNING, "com.google.crypto.tink.Registry", "ensureKeyManagerInsertable", str.length() != 0 ? "Attempted overwrite of a registered key manager for key type ".concat(str) : new String("Attempted overwrite of a registered key manager for key type "));
                    throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", str, zzbjVar.zzc().getName(), cls.getName()));
                } else if (!z || zzd.get(str).booleanValue()) {
                } else {
                    throw new GeneralSecurityException(str.length() != 0 ? "New keys are already disallowed for key type ".concat(str) : new String("New keys are already disallowed for key type "));
                }
            }
        }
    }

    private static <P> zzam<P> zzp(String str, Class<P> cls) throws GeneralSecurityException {
        zzbj zzn = zzn(str);
        if (cls == null) {
            return (zzam<P>) zzn.zzb();
        }
        if (zzn.zzd().contains(cls)) {
            return zzn.zza(cls);
        }
        String name = cls.getName();
        String valueOf = String.valueOf(zzn.zzc());
        Set<Class<?>> zzd2 = zzn.zzd();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class<?> cls2 : zzd2) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(cls2.getCanonicalName());
            z = false;
        }
        String sb2 = sb.toString();
        int length = String.valueOf(name).length();
        StringBuilder sb3 = new StringBuilder(length + 77 + String.valueOf(valueOf).length() + String.valueOf(sb2).length());
        sb3.append("Primitive type ");
        sb3.append(name);
        sb3.append(" not supported by key manager of type ");
        sb3.append(valueOf);
        sb3.append(", supported primitives: ");
        sb3.append(sb2);
        throw new GeneralSecurityException(sb3.toString());
    }

    private static <P> P zzq(String str, zzym zzymVar, Class<P> cls) throws GeneralSecurityException {
        return (P) zzp(str, cls).zza(zzymVar);
    }
}
