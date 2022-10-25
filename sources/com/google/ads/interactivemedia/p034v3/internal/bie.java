package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.Modifier;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bie */
/* loaded from: classes2.dex */
public abstract class bie {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static void m3641b(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            String valueOf = String.valueOf(cls.getName());
            throw new UnsupportedOperationException(valueOf.length() != 0 ? "Interface can't be instantiated! Interface name: ".concat(valueOf) : new String("Interface can't be instantiated! Interface name: "));
        } else if (Modifier.isAbstract(modifiers)) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new UnsupportedOperationException(valueOf2.length() != 0 ? "Abstract class can't be instantiated! Class name: ".concat(valueOf2) : new String("Abstract class can't be instantiated! Class name: "));
        }
    }

    /* renamed from: a */
    public abstract Object mo3642a(Class cls) throws Exception;
}
