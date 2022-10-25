package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.internal.axo;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.axw */
/* loaded from: classes2.dex */
class axw extends axo.AbstractC2578i {

    /* renamed from: a */
    private static final axt f5284a;

    /* renamed from: b */
    private static final Logger f5285b = Logger.getLogger(axw.class.getName());
    private volatile int remaining;
    private volatile Set<Throwable> seenExceptions = null;

    static {
        axt axvVar;
        Throwable th;
        try {
            AtomicReferenceFieldUpdater.newUpdater(axw.class, Set.class, "seenExceptions");
            axvVar = new axu(AtomicIntegerFieldUpdater.newUpdater(axw.class, "remaining"));
            th = null;
        } catch (Throwable th2) {
            axvVar = new axv(null);
            th = th2;
        }
        f5284a = axvVar;
        if (th != null) {
            f5285b.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public axw(int i) {
        this.remaining = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: u */
    public static /* synthetic */ int m4346u(axw axwVar) {
        int i = axwVar.remaining - 1;
        axwVar.remaining = i;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: v */
    public final int m4345v() {
        return f5284a.mo4347a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: w */
    public final void m4344w() {
        this.seenExceptions = null;
    }
}
