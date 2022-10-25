package com.google.ads.interactivemedia.p034v3.internal;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.TextureView;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.gx */
/* loaded from: classes2.dex */
public final class SurfaceHolder$CallbackC2743gx implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, InterfaceC3203xy, InterfaceC2802jb, InterfaceC2676ek, InterfaceC2672eg, InterfaceC2748hb, InterfaceC2564at, InterfaceC2686eu {

    /* renamed from: a */
    final /* synthetic */ C2745gz f7451a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ SurfaceHolder$CallbackC2743gx(C2745gz c2745gz) {
        this.f7451a = c2745gz;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2802jb
    /* renamed from: A */
    public final void mo1953A(String str) {
        C2785il c2785il;
        c2785il = this.f7451a.f7463h;
        c2785il.mo1953A(str);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2802jb
    /* renamed from: B */
    public final void mo1952B(C2679en c2679en) {
        C2785il c2785il;
        c2785il = this.f7451a.f7463h;
        c2785il.mo1952B(c2679en);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2802jb
    /* renamed from: C */
    public final void mo1951C(C2679en c2679en) {
        C2785il c2785il;
        c2785il = this.f7451a.f7463h;
        c2785il.mo1951C(c2679en);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2802jb
    /* renamed from: D */
    public final void mo1950D(C2962p c2962p, C2680eo c2680eo) {
        C2785il c2785il;
        c2785il = this.f7451a.f7463h;
        c2785il.mo1950D(c2962p, c2680eo);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2802jb
    /* renamed from: E */
    public final void mo1949E(long j) {
        C2785il c2785il;
        c2785il = this.f7451a.f7463h;
        c2785il.mo1949E(j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2802jb
    /* renamed from: F */
    public final void mo1948F(Exception exc) {
        C2785il c2785il;
        c2785il = this.f7451a.f7463h;
        c2785il.mo1948F(exc);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2802jb
    /* renamed from: G */
    public final void mo1947G(int i, long j, long j2) {
        C2785il c2785il;
        c2785il = this.f7451a.f7463h;
        c2785il.mo1947G(i, j, j2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3203xy
    /* renamed from: H */
    public final void mo574H(int i, long j) {
        C2785il c2785il;
        c2785il = this.f7451a.f7463h;
        c2785il.mo574H(i, j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3203xy
    /* renamed from: I */
    public final void mo573I(Object obj, long j) {
        C2785il c2785il;
        Object obj2;
        CopyOnWriteArraySet copyOnWriteArraySet;
        c2785il = this.f7451a.f7463h;
        c2785il.mo573I(obj, j);
        C2745gz c2745gz = this.f7451a;
        obj2 = c2745gz.f7471p;
        if (obj2 == obj) {
            copyOnWriteArraySet = c2745gz.f7462g;
            Iterator it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                ((InterfaceC2565au) it.next()).mo2041u();
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3203xy
    /* renamed from: J */
    public final void mo572J(Exception exc) {
        C2785il c2785il;
        c2785il = this.f7451a.f7463h;
        c2785il.mo572J(exc);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3203xy
    /* renamed from: K */
    public final void mo571K(String str, long j, long j2) {
        C2785il c2785il;
        c2785il = this.f7451a.f7463h;
        c2785il.mo571K(str, j, j2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3203xy
    /* renamed from: L */
    public final void mo570L(String str) {
        C2785il c2785il;
        c2785il = this.f7451a.f7463h;
        c2785il.mo570L(str);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3203xy
    /* renamed from: M */
    public final void mo569M(C2679en c2679en) {
        C2785il c2785il;
        c2785il = this.f7451a.f7463h;
        c2785il.mo569M(c2679en);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3203xy
    /* renamed from: N */
    public final void mo568N(C2679en c2679en) {
        C2785il c2785il;
        c2785il = this.f7451a.f7463h;
        c2785il.mo568N(c2679en);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3203xy
    /* renamed from: O */
    public final void mo567O(long j, int i) {
        C2785il c2785il;
        c2785il = this.f7451a.f7463h;
        c2785il.mo567O(j, i);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3203xy
    /* renamed from: P */
    public final void mo566P(C2962p c2962p, C2680eo c2680eo) {
        C2785il c2785il;
        c2785il = this.f7451a.f7463h;
        c2785il.mo566P(c2962p, c2680eo);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: a */
    public final /* synthetic */ void mo2069a(C2561as c2561as) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: ah */
    public final void mo2062ah(boolean z) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: ai */
    public final /* synthetic */ void mo2061ai(boolean z) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: aj */
    public final /* synthetic */ void mo2060aj(C2543ae c2543ae, int i) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: ak */
    public final /* synthetic */ void mo2059ak(C2546ah c2546ah) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: al */
    public final void mo2058al(boolean z, int i) {
        C2745gz.m2154I(this.f7451a);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: am */
    public final /* synthetic */ void mo2057am(C2559aq c2559aq) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: an */
    public final void mo2056an(int i) {
        C2745gz.m2154I(this.f7451a);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: ao */
    public final /* synthetic */ void mo2055ao(int i) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: ap */
    public final /* synthetic */ void mo2054ap(C2556ap c2556ap) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: k */
    public final /* synthetic */ void mo2051k(boolean z, int i) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: l */
    public final /* synthetic */ void mo2050l(C2566av c2566av, C2566av c2566av2, int i) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: m */
    public final /* synthetic */ void mo2049m() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: n */
    public final /* synthetic */ void mo2048n(C2588bd c2588bd, C2590bf c2590bf) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: o */
    public final /* synthetic */ void mo2047o(C2596bl c2596bl) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        C2745gz.m2157F(this.f7451a, surfaceTexture);
        this.f7451a.m2137Z(i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f7451a.m2134ac(null);
        this.f7451a.m2137Z(0, 0);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f7451a.m2137Z(i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: p */
    public final /* synthetic */ void mo2046p() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: q */
    public final /* synthetic */ void mo2045q() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: r */
    public final /* synthetic */ void mo2044r() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: s */
    public final /* synthetic */ void mo2043s() {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.f7451a.m2137Z(i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        boolean z;
        C2745gz c2745gz = this.f7451a;
        z = c2745gz.f7474s;
        if (z) {
            c2745gz.m2134ac(surfaceHolder.getSurface());
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        boolean z;
        C2745gz c2745gz = this.f7451a;
        z = c2745gz.f7474s;
        if (z) {
            c2745gz.m2134ac(null);
        }
        this.f7451a.m2137Z(0, 0);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2564at
    /* renamed from: t */
    public final /* synthetic */ void mo2042t(int i) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2686eu
    /* renamed from: u */
    public final /* synthetic */ void mo2164u() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2802jb
    /* renamed from: v */
    public final void mo1946v(boolean z) {
        boolean z2;
        C2745gz c2745gz = this.f7451a;
        z2 = c2745gz.f7481z;
        if (z2 == z) {
            return;
        }
        c2745gz.f7481z = z;
        C2745gz.m2159D(this.f7451a);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2686eu
    /* renamed from: w */
    public final void mo2163w() {
        C2745gz.m2154I(this.f7451a);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3203xy
    /* renamed from: x */
    public final void mo565x(C2597bm c2597bm) {
        C2785il c2785il;
        CopyOnWriteArraySet copyOnWriteArraySet;
        c2785il = this.f7451a.f7463h;
        c2785il.mo2038x(c2597bm);
        copyOnWriteArraySet = this.f7451a.f7462g;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((InterfaceC2565au) it.next()).mo2038x(c2597bm);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2802jb
    /* renamed from: y */
    public final void mo1945y(Exception exc) {
        C2785il c2785il;
        c2785il = this.f7451a.f7463h;
        c2785il.mo1945y(exc);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2802jb
    /* renamed from: z */
    public final void mo1944z(String str, long j, long j2) {
        C2785il c2785il;
        c2785il = this.f7451a.f7463h;
        c2785il.mo1944z(str, j, j2);
    }
}
