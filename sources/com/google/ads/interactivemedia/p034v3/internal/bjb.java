package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bjb */
/* loaded from: classes2.dex */
final class bjb<T> extends bgy<T> {

    /* renamed from: a */
    private final bgh f5872a;

    /* renamed from: b */
    private final bgy f5873b;

    /* renamed from: c */
    private final Type f5874c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bjb(bgh bghVar, bgy bgyVar, Type type) {
        this.f5872a = bghVar;
        this.f5873b = bgyVar;
        this.f5874c = type;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final T read(bkv bkvVar) throws IOException {
        return (T) this.f5873b.read(bkvVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.reflect.Type] */
    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final void write(bkx bkxVar, T t) throws IOException {
        bgy bgyVar = this.f5873b;
        ?? r1 = this.f5874c;
        Class<?> cls = (t == null || !(r1 == Object.class || (r1 instanceof TypeVariable) || (r1 instanceof Class))) ? r1 : t.getClass();
        if (cls != r1) {
            bgyVar = this.f5872a.m3728a(bkt.m3601b(cls));
            if (bgyVar instanceof biv) {
                bgy bgyVar2 = this.f5873b;
                if (!(bgyVar2 instanceof biv)) {
                    bgyVar = bgyVar2;
                }
            }
        }
        bgyVar.write(bkxVar, t);
    }
}
