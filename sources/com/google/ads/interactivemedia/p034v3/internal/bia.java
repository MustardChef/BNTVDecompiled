package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.Method;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bia */
/* loaded from: classes2.dex */
final class bia extends bie {

    /* renamed from: a */
    final /* synthetic */ Method f5782a;

    /* renamed from: b */
    final /* synthetic */ Object f5783b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bia(Method method, Object obj) {
        this.f5782a = method;
        this.f5783b = obj;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bie
    /* renamed from: a */
    public final Object mo3642a(Class cls) throws Exception {
        m3641b(cls);
        return this.f5782a.invoke(this.f5783b, cls);
    }
}
