package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.lang.reflect.Field;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.biw */
/* loaded from: classes2.dex */
final class biw {

    /* renamed from: a */
    final String f5822a;

    /* renamed from: b */
    final boolean f5823b;

    /* renamed from: c */
    final boolean f5824c;

    /* renamed from: d */
    final /* synthetic */ Field f5825d;

    /* renamed from: e */
    final /* synthetic */ boolean f5826e;

    /* renamed from: f */
    final /* synthetic */ bgy f5827f;

    /* renamed from: g */
    final /* synthetic */ bgh f5828g;

    /* renamed from: h */
    final /* synthetic */ bkt f5829h;

    /* renamed from: i */
    final /* synthetic */ boolean f5830i;

    protected biw(String str, boolean z, boolean z2) {
        this.f5822a = str;
        this.f5823b = z;
        this.f5824c = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public biw(String str, boolean z, boolean z2, Field field, boolean z3, bgy bgyVar, bgh bghVar, bkt bktVar, boolean z4) {
        this(str, z, z2);
        this.f5825d = field;
        this.f5826e = z3;
        this.f5827f = bgyVar;
        this.f5828g = bghVar;
        this.f5829h = bktVar;
        this.f5830i = z4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m3623a(bkv bkvVar, Object obj) throws IOException, IllegalAccessException {
        Object read = this.f5827f.read(bkvVar);
        if (read == null && this.f5830i) {
            return;
        }
        this.f5825d.set(obj, read);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final void m3622b(bkx bkxVar, Object obj) throws IOException, IllegalAccessException {
        (this.f5826e ? this.f5827f : new bjb(this.f5828g, this.f5827f, this.f5829h.m3599d())).write(bkxVar, this.f5825d.get(obj));
    }

    /* renamed from: c */
    public final boolean m3621c(Object obj) throws IOException, IllegalAccessException {
        return this.f5823b && this.f5825d.get(obj) != obj;
    }
}
