package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.azo */
/* loaded from: classes2.dex */
public abstract class azo {

    /* renamed from: a */
    private final Class f5328a;

    /* renamed from: b */
    private final Map f5329b;

    /* renamed from: c */
    private final Class f5330c;

    /* JADX INFO: Access modifiers changed from: protected */
    @SafeVarargs
    public azo(Class cls, azn... aznVarArr) {
        this.f5328a = cls;
        HashMap hashMap = new HashMap();
        for (int i = 0; i <= 0; i++) {
            azn aznVar = aznVarArr[i];
            if (!hashMap.containsKey(aznVar.m4272a())) {
                hashMap.put(aznVar.m4272a(), aznVar);
            } else {
                String valueOf = String.valueOf(aznVar.m4272a().getCanonicalName());
                throw new IllegalArgumentException(valueOf.length() != 0 ? "KeyTypeManager constructed with duplicate factories for primitive ".concat(valueOf) : new String("KeyTypeManager constructed with duplicate factories for primitive "));
            }
        }
        this.f5330c = aznVarArr[0].m4272a();
        this.f5329b = Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: a */
    public azm mo4173a() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }

    /* renamed from: b */
    public abstract boj mo4172b(bls blsVar) throws bnm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final Class m4271c() {
        return this.f5330c;
    }

    /* renamed from: d */
    public final Class m4270d() {
        return this.f5328a;
    }

    /* renamed from: e */
    public final Object m4269e(boj bojVar, Class cls) throws GeneralSecurityException {
        azn aznVar = (azn) this.f5329b.get(cls);
        if (aznVar == null) {
            String canonicalName = cls.getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 41);
            sb.append("Requested primitive class ");
            sb.append(canonicalName);
            sb.append(" not supported.");
            throw new IllegalArgumentException(sb.toString());
        }
        return aznVar.mo4178b(bojVar);
    }

    /* renamed from: f */
    public abstract String mo4171f();

    /* renamed from: g */
    public final Set m4268g() {
        return this.f5329b.keySet();
    }

    /* renamed from: h */
    public abstract void mo4170h(boj bojVar) throws GeneralSecurityException;

    /* renamed from: i */
    public int mo4169i() {
        return bbp.f5396a;
    }

    /* renamed from: j */
    public abstract int mo4168j();
}
