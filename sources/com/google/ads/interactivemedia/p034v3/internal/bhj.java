package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bhj */
/* loaded from: classes2.dex */
final class bhj implements bhz {

    /* renamed from: a */
    final /* synthetic */ Constructor f5725a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bhj(Constructor constructor) {
        this.f5725a = constructor;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bhz
    /* renamed from: a */
    public final Object mo3659a() {
        try {
            return this.f5725a.newInstance(null);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            String valueOf = String.valueOf(this.f5725a);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 30);
            sb.append("Failed to invoke ");
            sb.append(valueOf);
            sb.append(" with no args");
            throw new RuntimeException(sb.toString(), e2);
        } catch (InvocationTargetException e3) {
            String valueOf2 = String.valueOf(this.f5725a);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 30);
            sb2.append("Failed to invoke ");
            sb2.append(valueOf2);
            sb2.append(" with no args");
            throw new RuntimeException(sb2.toString(), e3.getTargetException());
        }
    }
}
