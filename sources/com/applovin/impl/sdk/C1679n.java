package com.applovin.impl.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.applovin.impl.mediation.p013a.AbstractC1334a;
import com.applovin.impl.p010a.C1129a;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.utils.C1721d;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdk;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.applovin.impl.sdk.n */
/* loaded from: classes.dex */
public class C1679n {

    /* renamed from: a */
    private static final AtomicBoolean f2337a = new AtomicBoolean();

    /* renamed from: b */
    private static final Lock f2338b = new ReentrantLock();

    /* renamed from: c */
    private static Runnable f2339c;

    /* renamed from: d */
    private static Thread f2340d;

    /* renamed from: g */
    private final C1662k f2343g;

    /* renamed from: e */
    private final Map<Integer, Thread> f2341e = new HashMap();

    /* renamed from: f */
    private final Object f2342f = new Object();

    /* renamed from: i */
    private C1721d f2345i = null;

    /* renamed from: j */
    private final Map<Integer, String> f2346j = new HashMap();

    /* renamed from: k */
    private final Map<Integer, String> f2347k = new HashMap();

    /* renamed from: h */
    private final Runnable f2344h = new Runnable() { // from class: com.applovin.impl.sdk.n.1
        @Override // java.lang.Runnable
        public void run() {
            C1679n.this.f2345i = null;
            C1679n.this.m6521b();
        }
    };

    public C1679n(C1662k c1662k) {
        this.f2343g = c1662k;
    }

    /* renamed from: a */
    private static Thread m6522a(String str) {
        Thread thread = new Thread(f2339c, str);
        thread.setDaemon(true);
        return thread;
    }

    /* renamed from: a */
    public static void m6525a() {
        if (f2337a.compareAndSet(false, true)) {
            f2338b.lock();
            f2339c = new Runnable() { // from class: com.applovin.impl.sdk.n.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        C1679n.f2338b.lockInterruptibly();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            };
            Thread m6522a = m6522a("ALDEBUG-" + AppLovinSdk.VERSION);
            f2340d = m6522a;
            m6522a.start();
        }
    }

    /* renamed from: c */
    private String m6518c(Object obj) {
        if (obj instanceof AbstractC1334a) {
            AbstractC1334a abstractC1334a = (AbstractC1334a) obj;
            if ("APPLOVIN".equals(abstractC1334a.m7762L())) {
                return null;
            }
            StringBuilder sb = new StringBuilder(abstractC1334a.m7762L());
            sb.append("/");
            sb.append(abstractC1334a.getFormat().getLabel());
            String creativeId = abstractC1334a.getCreativeId();
            if (StringUtils.isValidString(creativeId)) {
                sb.append("/");
                sb.append(creativeId);
            }
            return sb.toString();
        }
        return null;
    }

    /* renamed from: d */
    private String m6516d(Object obj) {
        if (obj instanceof AbstractC1537g) {
            AbstractC1537g abstractC1537g = (AbstractC1537g) obj;
            StringBuilder sb = new StringBuilder("AL/");
            sb.append(abstractC1537g.getSize().getLabel());
            sb.append("/");
            sb.append(abstractC1537g.getAdIdNumber());
            if (abstractC1537g instanceof C1129a) {
                sb.append("/VAST/");
                sb.append(((C1129a) abstractC1537g).m8415i().m8364a());
            }
            if (StringUtils.isValidString(abstractC1537g.m7077r())) {
                sb.append("/DSP/");
                sb.append(abstractC1537g.m7077r());
            }
            return sb.toString();
        }
        return null;
    }

    /* renamed from: d */
    private void m6517d() {
        Context m6677J = this.f2343g.m6677J();
        StringBuilder sb = new StringBuilder("ALDEBUG-");
        sb.append(AppLovinSdk.VERSION);
        try {
            PackageInfo packageInfo = m6677J.getPackageManager().getPackageInfo("com.google.android.webview", 0);
            sb.append("-");
            sb.append(packageInfo.versionName);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        ActivityManager activityManager = (ActivityManager) m6677J.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
            sb.append("-");
            sb.append(memoryInfo.availMem / 1000000);
            sb.append("MB");
            sb.append("/");
            sb.append(memoryInfo.totalMem / 1000000);
            sb.append("MB");
            sb.append("(");
            sb.append(memoryInfo.lowMemory);
            sb.append(")");
        }
        Map<String, Object> m6555b = this.f2343g.m6667T().m6555b();
        if (m6555b.containsKey("gms_mb")) {
            sb.append("-GMS-");
            sb.append(m6555b.get("gms_mb"));
            sb.append("MB");
        }
        for (Integer num : this.f2346j.keySet()) {
            int intValue = num.intValue();
            sb.append("-");
            sb.append(this.f2346j.get(Integer.valueOf(intValue)));
        }
        for (Integer num2 : this.f2347k.keySet()) {
            int intValue2 = num2.intValue();
            sb.append("-");
            sb.append(this.f2347k.get(Integer.valueOf(intValue2)));
        }
        String sb2 = sb.toString();
        Thread thread = f2340d;
        if (thread != null) {
            thread.setName(sb2);
            return;
        }
        Thread m6522a = m6522a(sb2);
        f2340d = m6522a;
        m6522a.start();
    }

    /* renamed from: e */
    private String m6515e(Object obj) {
        if (obj instanceof AbstractC1334a) {
            AbstractC1334a abstractC1334a = (AbstractC1334a) obj;
            StringBuilder sb = new StringBuilder("MAX-");
            sb.append(AppLovinSdk.VERSION);
            sb.append("-");
            sb.append(abstractC1334a.getFormat().getLabel());
            sb.append("-");
            sb.append(abstractC1334a.m7762L());
            if (StringUtils.isValidString(abstractC1334a.getCreativeId())) {
                sb.append("-");
                sb.append(abstractC1334a.getCreativeId());
            }
            return sb.toString();
        } else if (obj instanceof AbstractC1537g) {
            AbstractC1537g abstractC1537g = (AbstractC1537g) obj;
            String label = abstractC1537g.getAdZone().m7212b() != null ? abstractC1537g.getAdZone().m7212b().getLabel() : "NULL";
            StringBuilder sb2 = new StringBuilder("AL-");
            sb2.append(AppLovinSdk.VERSION);
            sb2.append("-");
            sb2.append(label);
            sb2.append("-");
            sb2.append(abstractC1537g.getAdIdNumber());
            if (abstractC1537g instanceof C1129a) {
                sb2.append("-VAST-");
                sb2.append(((C1129a) abstractC1537g).m8415i().m8364a());
            }
            if (StringUtils.isValidString(abstractC1537g.m7077r())) {
                sb2.append("-DSP-");
                sb2.append(abstractC1537g.m7077r());
            }
            return sb2.toString();
        } else {
            return null;
        }
    }

    /* renamed from: a */
    public void m6523a(Object obj) {
        if (!((Boolean) this.f2343g.m6656a(C1568b.f1831dT)).booleanValue() || obj == null) {
            return;
        }
        Integer valueOf = Integer.valueOf(System.identityHashCode(obj));
        synchronized (this.f2342f) {
            if (!this.f2341e.containsKey(valueOf)) {
                String m6515e = m6515e(obj);
                if (m6515e == null) {
                    return;
                }
                String m6518c = m6518c(obj);
                if (StringUtils.isValidString(m6518c)) {
                    this.f2346j.put(valueOf, m6518c);
                }
                String m6516d = m6516d(obj);
                if (StringUtils.isValidString(m6516d)) {
                    this.f2347k.put(valueOf, m6516d);
                }
                C1710r m6588z = this.f2343g.m6588z();
                m6588z.m6319b("AppLovinSdk", "Creating ad debug thread with name: " + m6515e);
                Thread m6522a = m6522a(m6515e);
                m6522a.start();
                this.f2341e.put(valueOf, m6522a);
            }
        }
    }

    /* renamed from: b */
    public void m6521b() {
        if (!((Boolean) this.f2343g.m6656a(C1568b.f1831dT)).booleanValue() || this.f2343g.m6611e()) {
            return;
        }
        long longValue = ((Long) this.f2343g.m6656a(C1568b.f1833dV)).longValue();
        if (longValue <= 0 || this.f2345i != null) {
            return;
        }
        m6517d();
        this.f2345i = C1721d.m6283a(longValue, this.f2343g, this.f2344h);
    }

    /* renamed from: b */
    public void m6520b(Object obj) {
        if (!((Boolean) this.f2343g.m6656a(C1568b.f1831dT)).booleanValue() || obj == null) {
            return;
        }
        Integer valueOf = Integer.valueOf(System.identityHashCode(obj));
        synchronized (this.f2342f) {
            Thread thread = this.f2341e.get(valueOf);
            if (thread != null) {
                C1710r m6588z = this.f2343g.m6588z();
                m6588z.m6319b("AppLovinSdk", "Destroying ad debug thread with name: " + thread.getName());
                thread.interrupt();
                this.f2341e.remove(valueOf);
                this.f2346j.remove(valueOf);
                this.f2347k.remove(valueOf);
            }
        }
    }
}
