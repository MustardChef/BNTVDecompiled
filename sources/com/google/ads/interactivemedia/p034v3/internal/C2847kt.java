package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.kt */
/* loaded from: classes2.dex */
public final class C2847kt implements InterfaceC3160wi {

    /* renamed from: a */
    final /* synthetic */ C2849kv f7910a;

    /* renamed from: b */
    private final /* synthetic */ int f7911b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2847kt(C2849kv c2849kv, int i) {
        this.f7911b = i;
        this.f7910a = c2849kv;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3160wi
    /* renamed from: bb */
    public final /* synthetic */ void mo704bb(InterfaceC3163wl interfaceC3163wl, long j, long j2) {
        if (this.f7911b == 0) {
            this.f7910a.m1753m((C3170ws) interfaceC3163wl, j, j2);
            return;
        }
        this.f7910a.m1754l((C3170ws) interfaceC3163wl, j, j2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3160wi
    /* renamed from: bc */
    public final /* synthetic */ C3158wg mo703bc(InterfaceC3163wl interfaceC3163wl, long j, long j2, IOException iOException, int i) {
        if (this.f7911b == 0) {
            return this.f7910a.m1751s((C3170ws) interfaceC3163wl, j, j2, iOException);
        }
        return this.f7910a.m1752r((C3170ws) interfaceC3163wl, j, j2, iOException, i);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3160wi
    /* renamed from: bf */
    public final /* synthetic */ void mo702bf(InterfaceC3163wl interfaceC3163wl, long j, long j2, boolean z) {
        if (this.f7911b == 0) {
            this.f7910a.m1755k((C3170ws) interfaceC3163wl, j, j2);
            return;
        }
        this.f7910a.m1755k((C3170ws) interfaceC3163wl, j, j2);
    }
}
