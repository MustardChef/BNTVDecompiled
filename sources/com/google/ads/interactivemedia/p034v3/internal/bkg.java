package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bkg */
/* loaded from: classes2.dex */
final class bkg extends bgy {

    /* renamed from: a */
    private final Map f5891a = new HashMap();

    /* renamed from: b */
    private final Map f5892b = new HashMap();

    public bkg(Class cls) {
        Field[] declaredFields;
        try {
            for (Field field : cls.getDeclaredFields()) {
                if (field.isEnumConstant()) {
                    AccessController.doPrivileged(new bkf(field));
                    Enum r4 = (Enum) field.get(null);
                    String name = r4.name();
                    bhb bhbVar = (bhb) field.getAnnotation(bhb.class);
                    if (bhbVar != null) {
                        name = bhbVar.m3696a();
                        for (String str : bhbVar.m3695b()) {
                            this.f5891a.put(str, r4);
                        }
                    }
                    this.f5891a.put(name, r4);
                    this.f5892b.put(r4, name);
                }
            }
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ Object read(bkv bkvVar) throws IOException {
        if (bkvVar.mo3574r() == 9) {
            bkvVar.mo3579m();
            return null;
        }
        return (Enum) this.f5891a.get(bkvVar.mo3584h());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        Enum r3 = (Enum) obj;
        bkxVar.mo3554k(r3 == null ? null : (String) this.f5892b.get(r3));
    }
}
