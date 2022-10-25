package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ca */
/* loaded from: classes2.dex */
public final class C2612ca {

    /* renamed from: a */
    private final InterfaceC2598bn f6922a;

    /* renamed from: b */
    private final InterfaceC2605bu f6923b;

    /* renamed from: c */
    private final InterfaceC2609by f6924c;

    /* renamed from: d */
    private final CopyOnWriteArraySet f6925d;

    /* renamed from: e */
    private final ArrayDeque f6926e;

    /* renamed from: f */
    private final ArrayDeque f6927f;

    /* renamed from: g */
    private boolean f6928g;

    public C2612ca(Looper looper, InterfaceC2598bn interfaceC2598bn, InterfaceC2609by interfaceC2609by) {
        this(new CopyOnWriteArraySet(), looper, interfaceC2598bn, interfaceC2609by);
    }

    /* renamed from: h */
    public static /* synthetic */ void m2699h(C2612ca c2612ca) {
        Iterator it = c2612ca.f6925d.iterator();
        while (it.hasNext()) {
            ((C2610bz) it.next()).m2709b(c2612ca.f6924c);
            if (c2612ca.f6923b.mo2607c()) {
                return;
            }
        }
    }

    /* renamed from: a */
    public final C2612ca m2706a(Looper looper, InterfaceC2609by interfaceC2609by) {
        return new C2612ca(this.f6925d, looper, this.f6922a, interfaceC2609by);
    }

    /* renamed from: b */
    public final void m2705b(Object obj) {
        if (this.f6928g) {
            return;
        }
        C2616ce.m2689d(obj);
        this.f6925d.add(new C2610bz(obj));
    }

    /* renamed from: c */
    public final void m2704c() {
        if (this.f6927f.isEmpty()) {
            return;
        }
        if (!this.f6923b.mo2607c()) {
            InterfaceC2605bu interfaceC2605bu = this.f6923b;
            interfaceC2605bu.mo2600j(interfaceC2605bu.mo2609a(0));
        }
        boolean isEmpty = this.f6926e.isEmpty();
        this.f6926e.addAll(this.f6927f);
        this.f6927f.clear();
        if (!isEmpty) {
            return;
        }
        while (!this.f6926e.isEmpty()) {
            ((Runnable) this.f6926e.peekFirst()).run();
            this.f6926e.removeFirst();
        }
    }

    /* renamed from: d */
    public final void m2703d(final int i, final InterfaceC2608bx interfaceC2608bx) {
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.f6925d);
        this.f6927f.add(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.bw
            @Override // java.lang.Runnable
            public final void run() {
                CopyOnWriteArraySet copyOnWriteArraySet2 = copyOnWriteArraySet;
                int i2 = i;
                InterfaceC2608bx interfaceC2608bx2 = interfaceC2608bx;
                Iterator it = copyOnWriteArraySet2.iterator();
                while (it.hasNext()) {
                    ((C2610bz) it.next()).m2710a(i2, interfaceC2608bx2);
                }
            }
        });
    }

    /* renamed from: e */
    public final void m2702e() {
        Iterator it = this.f6925d.iterator();
        while (it.hasNext()) {
            ((C2610bz) it.next()).m2708c(this.f6924c);
        }
        this.f6925d.clear();
        this.f6928g = true;
    }

    /* renamed from: f */
    public final void m2701f(Object obj) {
        Iterator it = this.f6925d.iterator();
        while (it.hasNext()) {
            C2610bz c2610bz = (C2610bz) it.next();
            if (c2610bz.f6913a.equals(obj)) {
                c2610bz.m2708c(this.f6924c);
                this.f6925d.remove(c2610bz);
            }
        }
    }

    /* renamed from: g */
    public final void m2700g(int i, InterfaceC2608bx interfaceC2608bx) {
        m2703d(i, interfaceC2608bx);
        m2704c();
    }

    private C2612ca(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, InterfaceC2598bn interfaceC2598bn, InterfaceC2609by interfaceC2609by) {
        this.f6922a = interfaceC2598bn;
        this.f6925d = copyOnWriteArraySet;
        this.f6924c = interfaceC2609by;
        this.f6926e = new ArrayDeque();
        this.f6927f = new ArrayDeque();
        this.f6923b = interfaceC2598bn.mo2614b(looper, new Handler.Callback() { // from class: com.google.ads.interactivemedia.v3.internal.bv
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                C2612ca.m2699h(C2612ca.this);
                return true;
            }
        });
    }
}
