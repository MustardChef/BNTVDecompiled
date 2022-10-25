package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.Method;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bib */
/* loaded from: classes2.dex */
final class bib extends bie {

    /* renamed from: a */
    final /* synthetic */ Method f5784a;

    /* renamed from: b */
    final /* synthetic */ int f5785b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bib(Method method, int i) {
        this.f5784a = method;
        this.f5785b = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bie
    /* renamed from: a */
    public final Object mo3642a(Class cls) throws Exception {
        m3641b(cls);
        return this.f5784a.invoke(null, cls, Integer.valueOf(this.f5785b));
    }
}
