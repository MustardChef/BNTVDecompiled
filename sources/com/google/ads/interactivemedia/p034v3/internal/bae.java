package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bae */
/* loaded from: classes2.dex */
public final class bae {

    /* renamed from: a */
    private static final Logger f5367a = Logger.getLogger(bae.class.getName());

    /* renamed from: b */
    private static final ConcurrentMap f5368b = new ConcurrentHashMap();

    /* renamed from: c */
    private static final ConcurrentMap f5369c = new ConcurrentHashMap();

    /* renamed from: d */
    private static final ConcurrentMap f5370d = new ConcurrentHashMap();

    /* renamed from: e */
    private static final ConcurrentMap f5371e = new ConcurrentHashMap();

    /* renamed from: f */
    private static final ConcurrentMap f5372f = new ConcurrentHashMap();

    /* renamed from: g */
    private static final ConcurrentMap f5373g = new ConcurrentHashMap();

    private bae() {
    }

    @Deprecated
    /* renamed from: a */
    public static azc m4242a(String str) throws GeneralSecurityException {
        if (str == null) {
            throw new IllegalArgumentException("catalogueName must be non-null.");
        }
        azc azcVar = (azc) f5371e.get(str.toLowerCase(Locale.US));
        if (azcVar == null) {
            String format = String.format("no catalogue found for %s. ", str);
            if (str.toLowerCase(Locale.US).startsWith("tinkaead")) {
                format = String.valueOf(format).concat("Maybe call AeadConfig.register().");
            }
            if (str.toLowerCase(Locale.US).startsWith("tinkdeterministicaead")) {
                format = String.valueOf(format).concat("Maybe call DeterministicAeadConfig.register().");
            } else if (str.toLowerCase(Locale.US).startsWith("tinkstreamingaead")) {
                format = String.valueOf(format).concat("Maybe call StreamingAeadConfig.register().");
            } else if (str.toLowerCase(Locale.US).startsWith("tinkhybriddecrypt") || str.toLowerCase(Locale.US).startsWith("tinkhybridencrypt")) {
                format = String.valueOf(format).concat("Maybe call HybridConfig.register().");
            } else if (str.toLowerCase(Locale.US).startsWith("tinkmac")) {
                format = String.valueOf(format).concat("Maybe call MacConfig.register().");
            } else if (str.toLowerCase(Locale.US).startsWith("tinkpublickeysign") || str.toLowerCase(Locale.US).startsWith("tinkpublickeyverify")) {
                format = String.valueOf(format).concat("Maybe call SignatureConfig.register().");
            } else if (str.toLowerCase(Locale.US).startsWith("tink")) {
                format = String.valueOf(format).concat("Maybe call TinkConfig.register().");
            }
            throw new GeneralSecurityException(format);
        }
        return azcVar;
    }

    /* renamed from: b */
    public static azh m4241b(String str) throws GeneralSecurityException {
        return m4226q(str).mo4246b();
    }

    /* renamed from: c */
    public static synchronized boj m4240c(bed bedVar) throws GeneralSecurityException {
        boj mo4284b;
        synchronized (bae.class) {
            azh m4241b = m4241b(bedVar.m3934d());
            if (((Boolean) f5370d.get(bedVar.m3934d())).booleanValue()) {
                mo4284b = m4241b.mo4284b(bedVar.m3935c());
            } else {
                String valueOf = String.valueOf(bedVar.m3934d());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return mo4284b;
    }

    /* renamed from: d */
    public static Class m4239d(Class cls) {
        azx azxVar = (azx) f5372f.get(cls);
        if (azxVar == null) {
            return null;
        }
        return azxVar.mo4162a();
    }

    /* renamed from: e */
    public static Object m4238e(beb bebVar, Class cls) throws GeneralSecurityException {
        return m4225r(bebVar.m3945d(), bebVar.m3946c(), cls);
    }

    /* renamed from: f */
    public static Object m4237f(String str, boj bojVar, Class cls) throws GeneralSecurityException {
        return m4228o(str, cls).mo4281e(bojVar);
    }

    /* renamed from: g */
    public static Object m4236g(String str, byte[] bArr, Class cls) throws GeneralSecurityException {
        return m4225r(str, bls.m3504t(bArr), cls);
    }

    /* renamed from: h */
    public static Object m4235h(azw azwVar, Class cls) throws GeneralSecurityException {
        azx azxVar = (azx) f5372f.get(cls);
        if (azxVar == null) {
            String valueOf = String.valueOf(azwVar.m4254d().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "No wrapper found for ".concat(valueOf) : new String("No wrapper found for "));
        } else if (!azxVar.mo4162a().equals(azwVar.m4254d())) {
            String obj = azxVar.mo4162a().toString();
            String obj2 = azwVar.m4254d().toString();
            StringBuilder sb = new StringBuilder(obj.length() + 44 + obj2.length());
            sb.append("Wrong input primitive class, expected ");
            sb.append(obj);
            sb.append(", got ");
            sb.append(obj2);
            throw new GeneralSecurityException(sb.toString());
        } else {
            return azxVar.mo4160c(azwVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public static synchronized Map m4234i() {
        Map unmodifiableMap;
        synchronized (bae.class) {
            unmodifiableMap = Collections.unmodifiableMap(f5373g);
        }
        return unmodifiableMap;
    }

    /* renamed from: k */
    public static synchronized void m4232k(azx azxVar) throws GeneralSecurityException {
        synchronized (bae.class) {
            if (azxVar != null) {
                Class mo4161b = azxVar.mo4161b();
                ConcurrentMap concurrentMap = f5372f;
                if (concurrentMap.containsKey(mo4161b)) {
                    azx azxVar2 = (azx) concurrentMap.get(mo4161b);
                    if (!azxVar.getClass().getName().equals(azxVar2.getClass().getName())) {
                        f5367a.logp(Level.WARNING, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", "Attempted overwrite of a registered PrimitiveWrapper for type ".concat(mo4161b.toString()));
                        throw new GeneralSecurityException(String.format("PrimitiveWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", mo4161b.getName(), azxVar2.getClass().getName(), azxVar.getClass().getName()));
                    }
                }
                concurrentMap.put(mo4161b, azxVar);
            } else {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
        }
    }

    /* renamed from: l */
    public static synchronized void m4231l(bed bedVar) throws GeneralSecurityException {
        synchronized (bae.class) {
            azh m4241b = m4241b(bedVar.m3934d());
            if (((Boolean) f5370d.get(bedVar.m3934d())).booleanValue()) {
                m4241b.mo4285a(bedVar.m3935c());
            } else {
                String valueOf = String.valueOf(bedVar.m3934d());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
    }

    /* renamed from: m */
    public static synchronized void m4230m(azy azyVar, azo azoVar) throws GeneralSecurityException {
        Class mo4244d;
        synchronized (bae.class) {
            m4224s("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", azyVar.getClass(), azyVar.mo4173a().mo4175d(), true);
            m4224s("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", azoVar.getClass(), Collections.emptyMap(), false);
            int i = bbp.f5396a;
            int i2 = bbp.f5396a;
            if (!bbp.m4200a(i)) {
                String valueOf = String.valueOf(azyVar.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 61);
                sb.append("failed to register key manager ");
                sb.append(valueOf);
                sb.append(" as it is not FIPS compatible.");
                throw new GeneralSecurityException(sb.toString());
            } else if (bbp.m4200a(i2)) {
                ConcurrentMap concurrentMap = f5368b;
                if (concurrentMap.containsKey("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey") && (mo4244d = ((bad) concurrentMap.get("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")).mo4244d()) != null && !mo4244d.getName().equals(azoVar.getClass().getName())) {
                    Logger logger = f5367a;
                    Level level = Level.WARNING;
                    StringBuilder sb2 = new StringBuilder((int) bqk.f6557bQ);
                    sb2.append("Attempted overwrite of a registered key manager for key type ");
                    sb2.append("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
                    sb2.append(" with inconsistent public key type ");
                    sb2.append("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
                    logger.logp(level, "com.google.crypto.tink.Registry", "registerAsymmetricKeyManagers", sb2.toString());
                    throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", azyVar.getClass().getName(), mo4244d.getName(), azoVar.getClass().getName()));
                }
                if (!concurrentMap.containsKey("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey") || ((bad) concurrentMap.get("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")).mo4244d() == null) {
                    concurrentMap.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", new bab(azyVar, azoVar));
                    f5369c.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", m4222u(azyVar));
                    m4223t("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", azyVar.mo4173a().mo4175d());
                }
                ConcurrentMap concurrentMap2 = f5370d;
                concurrentMap2.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", true);
                if (!concurrentMap.containsKey("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey")) {
                    concurrentMap.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", m4227p(azoVar));
                }
                concurrentMap2.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", false);
            } else {
                String valueOf2 = String.valueOf(azoVar.getClass());
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 61);
                sb3.append("failed to register key manager ");
                sb3.append(valueOf2);
                sb3.append(" as it is not FIPS compatible.");
                throw new GeneralSecurityException(sb3.toString());
            }
        }
    }

    /* renamed from: n */
    public static synchronized void m4229n(azo azoVar) throws GeneralSecurityException {
        synchronized (bae.class) {
            String mo4171f = azoVar.mo4171f();
            m4224s(mo4171f, azoVar.getClass(), azoVar.mo4173a().mo4175d(), true);
            if (bbp.m4200a(azoVar.mo4169i())) {
                ConcurrentMap concurrentMap = f5368b;
                if (!concurrentMap.containsKey(mo4171f)) {
                    concurrentMap.put(mo4171f, m4227p(azoVar));
                    f5369c.put(mo4171f, m4222u(azoVar));
                    m4223t(mo4171f, azoVar.mo4173a().mo4175d());
                }
                f5370d.put(mo4171f, true);
            } else {
                String valueOf = String.valueOf(azoVar.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 61);
                sb.append("failed to register key manager ");
                sb.append(valueOf);
                sb.append(" as it is not FIPS compatible.");
                throw new GeneralSecurityException(sb.toString());
            }
        }
    }

    /* renamed from: o */
    private static azh m4228o(String str, Class cls) throws GeneralSecurityException {
        bad m4226q = m4226q(str);
        if (m4226q.mo4243e().contains(cls)) {
            return m4226q.mo4247a(cls);
        }
        String name = cls.getName();
        String valueOf = String.valueOf(m4226q.mo4245c());
        Set<Class> mo4243e = m4226q.mo4243e();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class cls2 : mo4243e) {
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

    /* renamed from: p */
    private static bad m4227p(azo azoVar) {
        return new baa(azoVar);
    }

    /* renamed from: q */
    private static synchronized bad m4226q(String str) throws GeneralSecurityException {
        bad badVar;
        synchronized (bae.class) {
            ConcurrentMap concurrentMap = f5368b;
            if (!concurrentMap.containsKey(str)) {
                String valueOf = String.valueOf(str);
                throw new GeneralSecurityException(valueOf.length() != 0 ? "No key manager found for key type ".concat(valueOf) : new String("No key manager found for key type "));
            }
            badVar = (bad) concurrentMap.get(str);
        }
        return badVar;
    }

    /* renamed from: r */
    private static Object m4225r(String str, bls blsVar, Class cls) throws GeneralSecurityException {
        return m4228o(str, cls).mo4282d(blsVar);
    }

    /* renamed from: s */
    private static synchronized void m4224s(String str, Class cls, Map map, boolean z) throws GeneralSecurityException {
        synchronized (bae.class) {
            ConcurrentMap concurrentMap = f5368b;
            bad badVar = (bad) concurrentMap.get(str);
            if (badVar != null && !badVar.mo4245c().equals(cls)) {
                f5367a.logp(Level.WARNING, "com.google.crypto.tink.Registry", "ensureKeyManagerInsertable", str.length() != 0 ? "Attempted overwrite of a registered key manager for key type ".concat(str) : new String("Attempted overwrite of a registered key manager for key type "));
                throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", str, badVar.mo4245c().getName(), cls.getName()));
            } else if (z) {
                ConcurrentMap concurrentMap2 = f5370d;
                if (!concurrentMap2.containsKey(str) || ((Boolean) concurrentMap2.get(str)).booleanValue()) {
                    if (concurrentMap.containsKey(str)) {
                        for (Map.Entry entry : map.entrySet()) {
                            if (!f5373g.containsKey(entry.getKey())) {
                                String str2 = (String) entry.getKey();
                                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 79 + str.length());
                                sb.append("Attempted to register a new key template ");
                                sb.append(str2);
                                sb.append(" from an existing key manager of type ");
                                sb.append(str);
                                throw new GeneralSecurityException(sb.toString());
                            }
                        }
                    } else {
                        for (Map.Entry entry2 : map.entrySet()) {
                            if (f5373g.containsKey(entry2.getKey())) {
                                String valueOf = String.valueOf((String) entry2.getKey());
                                throw new GeneralSecurityException(valueOf.length() != 0 ? "Attempted overwrite of a registered key template ".concat(valueOf) : new String("Attempted overwrite of a registered key template "));
                            }
                        }
                    }
                } else {
                    throw new GeneralSecurityException(str.length() != 0 ? "New keys are already disallowed for key type ".concat(str) : new String("New keys are already disallowed for key type "));
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.google.ads.interactivemedia.v3.internal.boj, java.lang.Object] */
    /* renamed from: t */
    private static void m4223t(String str, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            f5373g.put((String) entry.getKey(), azk.m4274d(str, ((azl) entry.getValue()).f5324a.mo3176ar(), ((azl) entry.getValue()).f5325b));
        }
    }

    /* renamed from: u */
    private static bac m4222u(azo azoVar) {
        return new bac();
    }

    /* renamed from: j */
    public static synchronized void m4233j(azh azhVar, boolean z) throws GeneralSecurityException {
        synchronized (bae.class) {
            if (azhVar == null) {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
            String mo4280f = azhVar.mo4280f();
            m4224s(mo4280f, azhVar.getClass(), Collections.emptyMap(), z);
            f5368b.putIfAbsent(mo4280f, new azz(azhVar));
            f5370d.put(mo4280f, Boolean.valueOf(z));
        }
    }
}
