package com.applovin.impl.adview;

import android.os.Handler;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.applovin.impl.adview.k */
/* loaded from: classes.dex */
public final class C1254k {

    /* renamed from: a */
    private final C1710r f609a;

    /* renamed from: b */
    private final Handler f610b;

    /* renamed from: c */
    private final Set<C1257b> f611c = new HashSet();

    /* renamed from: d */
    private final AtomicInteger f612d = new AtomicInteger();

    /* renamed from: com.applovin.impl.adview.k$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1256a {
        /* renamed from: a */
        void mo7891a();

        /* renamed from: b */
        boolean mo7890b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.applovin.impl.adview.k$b */
    /* loaded from: classes.dex */
    public static class C1257b {

        /* renamed from: a */
        private final String f616a;

        /* renamed from: b */
        private final InterfaceC1256a f617b;

        /* renamed from: c */
        private final long f618c;

        private C1257b(String str, long j, InterfaceC1256a interfaceC1256a) {
            this.f616a = str;
            this.f618c = j;
            this.f617b = interfaceC1256a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public String m8046a() {
            return this.f616a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public long m8044b() {
            return this.f618c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public InterfaceC1256a m8042c() {
            return this.f617b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof C1257b) {
                String str = this.f616a;
                String str2 = ((C1257b) obj).f616a;
                return str != null ? str.equalsIgnoreCase(str2) : str2 == null;
            }
            return false;
        }

        public int hashCode() {
            String str = this.f616a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "CountdownProxy{identifier='" + this.f616a + "', countdownStepMillis=" + this.f618c + '}';
        }
    }

    public C1254k(Handler handler, C1662k c1662k) {
        if (handler == null) {
            throw new IllegalArgumentException("No handler specified.");
        }
        if (c1662k == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        this.f610b = handler;
        this.f609a = c1662k.m6588z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8053a(final C1257b c1257b, final int i) {
        this.f610b.postDelayed(new Runnable() { // from class: com.applovin.impl.adview.k.1
            @Override // java.lang.Runnable
            public void run() {
                InterfaceC1256a m8042c = c1257b.m8042c();
                if (!m8042c.mo7890b()) {
                    C1710r c1710r = C1254k.this.f609a;
                    c1710r.m6319b("CountdownManager", "Ending countdown for " + c1257b.m8046a());
                } else if (C1254k.this.f612d.get() != i) {
                    C1710r c1710r2 = C1254k.this.f609a;
                    c1710r2.m6315d("CountdownManager", "Killing duplicate countdown from previous generation: " + c1257b.m8046a());
                } else {
                    try {
                        m8042c.mo7891a();
                    } catch (Throwable th) {
                        C1710r c1710r3 = C1254k.this.f609a;
                        c1710r3.m6318b("CountdownManager", "Encountered error on countdown step for: " + c1257b.m8046a(), th);
                    }
                    C1254k.this.m8053a(c1257b, i);
                }
            }
        }, c1257b.m8044b());
    }

    /* renamed from: a */
    public void m8054a() {
        HashSet<C1257b> hashSet = new HashSet(this.f611c);
        C1710r c1710r = this.f609a;
        c1710r.m6319b("CountdownManager", "Starting " + hashSet.size() + " countdowns...");
        int incrementAndGet = this.f612d.incrementAndGet();
        for (C1257b c1257b : hashSet) {
            C1710r c1710r2 = this.f609a;
            c1710r2.m6319b("CountdownManager", "Starting countdown: " + c1257b.m8046a() + " for generation " + incrementAndGet + "...");
            m8053a(c1257b, incrementAndGet);
        }
    }

    /* renamed from: a */
    public void m8050a(String str, long j, InterfaceC1256a interfaceC1256a) {
        if (j <= 0) {
            throw new IllegalArgumentException("Invalid step specified.");
        }
        if (this.f610b == null) {
            throw new IllegalArgumentException("No handler specified.");
        }
        C1710r c1710r = this.f609a;
        c1710r.m6319b("CountdownManager", "Adding countdown: " + str);
        this.f611c.add(new C1257b(str, j, interfaceC1256a));
    }

    /* renamed from: b */
    public void m8049b() {
        this.f609a.m6319b("CountdownManager", "Removing all countdowns...");
        m8047c();
        this.f611c.clear();
    }

    /* renamed from: c */
    public void m8047c() {
        this.f609a.m6319b("CountdownManager", "Stopping countdowns...");
        this.f612d.incrementAndGet();
        this.f610b.removeCallbacksAndMessages(null);
    }
}
