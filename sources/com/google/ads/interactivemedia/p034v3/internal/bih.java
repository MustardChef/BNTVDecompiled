package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Date;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bih */
/* loaded from: classes2.dex */
final class bih implements bgz {

    /* renamed from: a */
    private final /* synthetic */ int f5792a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bih(int i) {
        this.f5792a = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgz
    /* renamed from: a */
    public final bgy mo3604a(bgh bghVar, bkt bktVar) {
        Type componentType;
        int i = this.f5792a;
        if (i == 0) {
            if (bktVar.m3600c() == Date.class) {
                return new bii();
            }
            return null;
        } else if (i != 1) {
            Class m3600c = bktVar.m3600c();
            if (!Enum.class.isAssignableFrom(m3600c) || m3600c == Enum.class) {
                return null;
            }
            if (!m3600c.isEnum()) {
                m3600c = m3600c.getSuperclass();
            }
            return new bkg(m3600c);
        } else {
            Type m3599d = bktVar.m3599d();
            boolean z = m3599d instanceof GenericArrayType;
            if (z || ((m3599d instanceof Class) && ((Class) m3599d).isArray())) {
                if (z) {
                    componentType = ((GenericArrayType) m3599d).getGenericComponentType();
                } else {
                    componentType = ((Class) m3599d).getComponentType();
                }
                return new bif(bghVar, bghVar.m3728a(bkt.m3601b(componentType)), bhf.m3694a(componentType));
            }
            return null;
        }
    }
}
