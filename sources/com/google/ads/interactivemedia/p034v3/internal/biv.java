package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.biv */
/* loaded from: classes2.dex */
public final class biv<T> extends bgy<T> {

    /* renamed from: a */
    private final bhz f5820a;

    /* renamed from: b */
    private final Map f5821b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public biv(bhz bhzVar, Map map) {
        this.f5820a = bhzVar;
        this.f5821b = map;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final T read(bkv bkvVar) throws IOException {
        if (bkvVar.mo3574r() == 9) {
            bkvVar.mo3579m();
            return null;
        }
        T t = (T) this.f5820a.mo3659a();
        try {
            bkvVar.mo3582j();
            while (bkvVar.mo3576p()) {
                biw biwVar = (biw) this.f5821b.get(bkvVar.mo3585g());
                if (biwVar != null && biwVar.f5824c) {
                    biwVar.m3623a(bkvVar, t);
                }
                bkvVar.mo3577o();
            }
            bkvVar.mo3580l();
            return t;
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (IllegalStateException e2) {
            throw new bgt(e2);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final void write(bkx bkxVar, T t) throws IOException {
        if (t == null) {
            bkxVar.mo3558g();
            return;
        }
        bkxVar.mo3562c();
        try {
            for (biw biwVar : this.f5821b.values()) {
                if (biwVar.m3621c(t)) {
                    bkxVar.mo3559f(biwVar.f5822a);
                    biwVar.m3622b(bkxVar, t);
                }
            }
            bkxVar.mo3560e();
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
