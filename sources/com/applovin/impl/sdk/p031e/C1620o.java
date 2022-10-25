package com.applovin.impl.sdk.p031e;

import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.utils.C1721d;
import com.applovin.impl.sdk.utils.C1724f;
import com.applovin.impl.sdk.utils.Utils;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.gms.cast.MediaTrack;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.e.o */
/* loaded from: classes.dex */
public class C1620o {

    /* renamed from: A */
    private boolean f2107A;

    /* renamed from: b */
    private final C1662k f2109b;

    /* renamed from: c */
    private final C1710r f2110c;

    /* renamed from: v */
    private final ScheduledThreadPoolExecutor f2129v;

    /* renamed from: w */
    private final ScheduledThreadPoolExecutor f2130w;

    /* renamed from: x */
    private final ScheduledThreadPoolExecutor f2131x;

    /* renamed from: a */
    private final String f2108a = "TaskManager";

    /* renamed from: y */
    private final List<RunnableC1625c> f2132y = new ArrayList(5);

    /* renamed from: z */
    private final Object f2133z = new Object();

    /* renamed from: d */
    private final ScheduledThreadPoolExecutor f2111d = m6785a(MediaTrack.ROLE_MAIN);

    /* renamed from: e */
    private final ScheduledThreadPoolExecutor f2112e = m6785a("timeout");

    /* renamed from: f */
    private final ScheduledThreadPoolExecutor f2113f = m6785a("back");

    /* renamed from: g */
    private final ScheduledThreadPoolExecutor f2114g = m6785a("advertising_info_collection");

    /* renamed from: h */
    private final ScheduledThreadPoolExecutor f2115h = m6785a("postbacks");

    /* renamed from: i */
    private final ScheduledThreadPoolExecutor f2116i = m6785a("caching_interstitial");

    /* renamed from: j */
    private final ScheduledThreadPoolExecutor f2117j = m6785a("caching_incentivized");

    /* renamed from: k */
    private final ScheduledThreadPoolExecutor f2118k = m6785a("caching_other");

    /* renamed from: l */
    private final ScheduledThreadPoolExecutor f2119l = m6785a("reward");

    /* renamed from: m */
    private final ScheduledThreadPoolExecutor f2120m = m6785a("mediation_main");

    /* renamed from: n */
    private final ScheduledThreadPoolExecutor f2121n = m6785a("mediation_timeout");

    /* renamed from: o */
    private final ScheduledThreadPoolExecutor f2122o = m6785a("mediation_background");

    /* renamed from: p */
    private final ScheduledThreadPoolExecutor f2123p = m6785a("mediation_postbacks");

    /* renamed from: q */
    private final ScheduledThreadPoolExecutor f2124q = m6785a("mediation_banner");

    /* renamed from: r */
    private final ScheduledThreadPoolExecutor f2125r = m6785a("mediation_interstitial");

    /* renamed from: s */
    private final ScheduledThreadPoolExecutor f2126s = m6785a("mediation_incentivized");

    /* renamed from: t */
    private final ScheduledThreadPoolExecutor f2127t = m6785a("mediation_rewarded_interstitial");

    /* renamed from: u */
    private final ScheduledThreadPoolExecutor f2128u = m6785a("mediation_reward");

    /* renamed from: com.applovin.impl.sdk.e.o$a */
    /* loaded from: classes.dex */
    public enum EnumC1622a {
        MAIN,
        TIMEOUT,
        BACKGROUND,
        ADVERTISING_INFO_COLLECTION,
        POSTBACKS,
        CACHING_INTERSTITIAL,
        CACHING_INCENTIVIZED,
        CACHING_OTHER,
        REWARD,
        MEDIATION_MAIN,
        MEDIATION_TIMEOUT,
        MEDIATION_BACKGROUND,
        MEDIATION_POSTBACKS,
        MEDIATION_BANNER,
        MEDIATION_INTERSTITIAL,
        MEDIATION_INCENTIVIZED,
        MEDIATION_REWARDED_INTERSTITIAL,
        MEDIATION_REWARD
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.applovin.impl.sdk.e.o$b */
    /* loaded from: classes.dex */
    public class ThreadFactoryC1623b implements ThreadFactory {

        /* renamed from: b */
        private final String f2157b;

        ThreadFactoryC1623b(String str) {
            this.f2157b = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "AppLovinSdk:" + this.f2157b + ":" + Utils.shortenKey(C1620o.this.f2109b.m6590x()));
            thread.setDaemon(true);
            thread.setPriority(10);
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.applovin.impl.sdk.e.o.b.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread2, Throwable th) {
                    C1620o.this.f2110c.m6318b("TaskManager", "Caught unhandled exception", th);
                }
            });
            return thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.applovin.impl.sdk.e.o$c */
    /* loaded from: classes.dex */
    public class RunnableC1625c implements Runnable {

        /* renamed from: b */
        private final String f2160b;

        /* renamed from: c */
        private final AbstractRunnableC1589a f2161c;

        /* renamed from: d */
        private final EnumC1622a f2162d;

        RunnableC1625c(AbstractRunnableC1589a abstractRunnableC1589a, EnumC1622a enumC1622a) {
            this.f2160b = abstractRunnableC1589a.m6878e();
            this.f2161c = abstractRunnableC1589a;
            this.f2162d = enumC1622a;
        }

        @Override // java.lang.Runnable
        public void run() {
            long m6790a;
            C1710r c1710r;
            StringBuilder sb;
            try {
                C1724f.m6280a();
            } catch (Throwable th) {
                try {
                    C1620o.this.f2110c.m6318b(this.f2161c.m6878e(), "Task failed execution", th);
                    m6790a = C1620o.this.m6790a(this.f2162d) - 1;
                    c1710r = C1620o.this.f2110c;
                    sb = new StringBuilder();
                } catch (Throwable th2) {
                    C1710r c1710r2 = C1620o.this.f2110c;
                    c1710r2.m6317c("TaskManager", this.f2162d + " queue finished task " + this.f2161c.m6878e() + " with queue size " + (C1620o.this.m6790a(this.f2162d) - 1));
                    throw th2;
                }
            }
            if (C1620o.this.f2109b.m6617c() && !this.f2161c.m6876g()) {
                C1620o.this.f2110c.m6317c(this.f2160b, "Task re-scheduled...");
                C1620o.this.m6792a(this.f2161c, this.f2162d, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                m6790a = C1620o.this.m6790a(this.f2162d) - 1;
                c1710r = C1620o.this.f2110c;
                sb = new StringBuilder();
                sb.append(this.f2162d);
                sb.append(" queue finished task ");
                sb.append(this.f2161c.m6878e());
                sb.append(" with queue size ");
                sb.append(m6790a);
                c1710r.m6317c("TaskManager", sb.toString());
            }
            this.f2161c.run();
            m6790a = C1620o.this.m6790a(this.f2162d) - 1;
            c1710r = C1620o.this.f2110c;
            sb = new StringBuilder();
            sb.append(this.f2162d);
            sb.append(" queue finished task ");
            sb.append(this.f2161c.m6878e());
            sb.append(" with queue size ");
            sb.append(m6790a);
            c1710r.m6317c("TaskManager", sb.toString());
        }
    }

    public C1620o(C1662k c1662k) {
        this.f2109b = c1662k;
        this.f2110c = c1662k.m6588z();
        this.f2129v = m6784a("auxiliary_operations", ((Integer) c1662k.m6656a(C1568b.f1727bT)).intValue());
        this.f2130w = m6784a("caching_operations", ((Integer) c1662k.m6656a(C1568b.f1728bU)).intValue());
        this.f2131x = m6784a("shared_thread_pool", ((Integer) c1662k.m6656a(C1568b.f1692al)).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public long m6790a(EnumC1622a enumC1622a) {
        long taskCount;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (enumC1622a == EnumC1622a.MAIN) {
            taskCount = this.f2111d.getTaskCount();
            scheduledThreadPoolExecutor = this.f2111d;
        } else if (enumC1622a == EnumC1622a.TIMEOUT) {
            taskCount = this.f2112e.getTaskCount();
            scheduledThreadPoolExecutor = this.f2112e;
        } else if (enumC1622a == EnumC1622a.BACKGROUND) {
            taskCount = this.f2113f.getTaskCount();
            scheduledThreadPoolExecutor = this.f2113f;
        } else if (enumC1622a == EnumC1622a.ADVERTISING_INFO_COLLECTION) {
            taskCount = this.f2114g.getTaskCount();
            scheduledThreadPoolExecutor = this.f2114g;
        } else if (enumC1622a == EnumC1622a.POSTBACKS) {
            taskCount = this.f2115h.getTaskCount();
            scheduledThreadPoolExecutor = this.f2115h;
        } else if (enumC1622a == EnumC1622a.CACHING_INTERSTITIAL) {
            taskCount = this.f2116i.getTaskCount();
            scheduledThreadPoolExecutor = this.f2116i;
        } else if (enumC1622a == EnumC1622a.CACHING_INCENTIVIZED) {
            taskCount = this.f2117j.getTaskCount();
            scheduledThreadPoolExecutor = this.f2117j;
        } else if (enumC1622a == EnumC1622a.CACHING_OTHER) {
            taskCount = this.f2118k.getTaskCount();
            scheduledThreadPoolExecutor = this.f2118k;
        } else if (enumC1622a == EnumC1622a.REWARD) {
            taskCount = this.f2119l.getTaskCount();
            scheduledThreadPoolExecutor = this.f2119l;
        } else if (enumC1622a == EnumC1622a.MEDIATION_MAIN) {
            taskCount = this.f2120m.getTaskCount();
            scheduledThreadPoolExecutor = this.f2120m;
        } else if (enumC1622a == EnumC1622a.MEDIATION_TIMEOUT) {
            taskCount = this.f2121n.getTaskCount();
            scheduledThreadPoolExecutor = this.f2121n;
        } else if (enumC1622a == EnumC1622a.MEDIATION_BACKGROUND) {
            taskCount = this.f2122o.getTaskCount();
            scheduledThreadPoolExecutor = this.f2122o;
        } else if (enumC1622a == EnumC1622a.MEDIATION_POSTBACKS) {
            taskCount = this.f2123p.getTaskCount();
            scheduledThreadPoolExecutor = this.f2123p;
        } else if (enumC1622a == EnumC1622a.MEDIATION_BANNER) {
            taskCount = this.f2124q.getTaskCount();
            scheduledThreadPoolExecutor = this.f2124q;
        } else if (enumC1622a == EnumC1622a.MEDIATION_INTERSTITIAL) {
            taskCount = this.f2125r.getTaskCount();
            scheduledThreadPoolExecutor = this.f2125r;
        } else if (enumC1622a == EnumC1622a.MEDIATION_INCENTIVIZED) {
            taskCount = this.f2126s.getTaskCount();
            scheduledThreadPoolExecutor = this.f2126s;
        } else if (enumC1622a == EnumC1622a.MEDIATION_REWARDED_INTERSTITIAL) {
            taskCount = this.f2127t.getTaskCount();
            scheduledThreadPoolExecutor = this.f2127t;
        } else if (enumC1622a != EnumC1622a.MEDIATION_REWARD) {
            return 0L;
        } else {
            taskCount = this.f2128u.getTaskCount();
            scheduledThreadPoolExecutor = this.f2128u;
        }
        return taskCount - scheduledThreadPoolExecutor.getCompletedTaskCount();
    }

    /* renamed from: a */
    private ScheduledThreadPoolExecutor m6785a(String str) {
        return m6784a(str, 1);
    }

    /* renamed from: a */
    private ScheduledThreadPoolExecutor m6784a(String str, int i) {
        return new ScheduledThreadPoolExecutor(i, new ThreadFactoryC1623b(str));
    }

    /* renamed from: a */
    private void m6786a(final Runnable runnable, long j, final ScheduledExecutorService scheduledExecutorService, boolean z) {
        if (j <= 0) {
            scheduledExecutorService.submit(runnable);
        } else if (z) {
            C1721d.m6283a(j, this.f2109b, new Runnable() { // from class: com.applovin.impl.sdk.e.o.1
                @Override // java.lang.Runnable
                public void run() {
                    scheduledExecutorService.execute(runnable);
                }
            });
        } else {
            scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: a */
    private boolean m6789a(RunnableC1625c runnableC1625c) {
        if (runnableC1625c.f2161c.m6876g()) {
            return false;
        }
        synchronized (this.f2133z) {
            if (this.f2107A) {
                return false;
            }
            this.f2132y.add(runnableC1625c);
            return true;
        }
    }

    /* renamed from: a */
    public void m6794a(AbstractRunnableC1589a abstractRunnableC1589a) {
        if (abstractRunnableC1589a == null) {
            this.f2110c.m6314e("TaskManager", "Attempted to execute null task immediately");
            return;
        }
        try {
            abstractRunnableC1589a.run();
        } catch (Throwable th) {
            this.f2110c.m6318b(abstractRunnableC1589a.m6878e(), "Task failed execution", th);
        }
    }

    /* renamed from: a */
    public void m6793a(AbstractRunnableC1589a abstractRunnableC1589a, EnumC1622a enumC1622a) {
        m6792a(abstractRunnableC1589a, enumC1622a, 0L);
    }

    /* renamed from: a */
    public void m6792a(AbstractRunnableC1589a abstractRunnableC1589a, EnumC1622a enumC1622a, long j) {
        m6791a(abstractRunnableC1589a, enumC1622a, j, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public void m6791a(AbstractRunnableC1589a abstractRunnableC1589a, EnumC1622a enumC1622a, long j, boolean z) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        C1620o c1620o;
        RunnableC1625c runnableC1625c;
        long j2;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2;
        if (abstractRunnableC1589a == 0) {
            throw new IllegalArgumentException("No task specified");
        }
        if (j < 0) {
            throw new IllegalArgumentException("Invalid delay specified: " + j);
        }
        RunnableC1625c runnableC1625c2 = new RunnableC1625c(abstractRunnableC1589a, enumC1622a);
        if (m6789a(runnableC1625c2)) {
            this.f2110c.m6317c(abstractRunnableC1589a.m6878e(), "Task execution delayed until after init");
            return;
        }
        if (((Boolean) this.f2109b.m6656a(C1568b.f1693am)).booleanValue()) {
            scheduledThreadPoolExecutor2 = this.f2131x;
            c1620o = this;
            runnableC1625c = abstractRunnableC1589a;
            j2 = j;
        } else {
            C1710r c1710r = this.f2110c;
            c1710r.m6319b("TaskManager", "Scheduling " + abstractRunnableC1589a.m6878e() + " on " + enumC1622a + " queue in " + j + "ms with new queue size " + (m6790a(enumC1622a) + 1));
            if (enumC1622a == EnumC1622a.MAIN) {
                scheduledThreadPoolExecutor = this.f2111d;
            } else if (enumC1622a == EnumC1622a.TIMEOUT) {
                scheduledThreadPoolExecutor = this.f2112e;
            } else if (enumC1622a == EnumC1622a.BACKGROUND) {
                scheduledThreadPoolExecutor = this.f2113f;
            } else if (enumC1622a == EnumC1622a.ADVERTISING_INFO_COLLECTION) {
                scheduledThreadPoolExecutor = this.f2114g;
            } else if (enumC1622a == EnumC1622a.POSTBACKS) {
                scheduledThreadPoolExecutor = this.f2115h;
            } else if (enumC1622a == EnumC1622a.CACHING_INTERSTITIAL) {
                scheduledThreadPoolExecutor = this.f2116i;
            } else if (enumC1622a == EnumC1622a.CACHING_INCENTIVIZED) {
                scheduledThreadPoolExecutor = this.f2117j;
            } else if (enumC1622a == EnumC1622a.CACHING_OTHER) {
                scheduledThreadPoolExecutor = this.f2118k;
            } else if (enumC1622a == EnumC1622a.REWARD) {
                scheduledThreadPoolExecutor = this.f2119l;
            } else if (enumC1622a == EnumC1622a.MEDIATION_MAIN) {
                scheduledThreadPoolExecutor = this.f2120m;
            } else if (enumC1622a == EnumC1622a.MEDIATION_TIMEOUT) {
                scheduledThreadPoolExecutor = this.f2121n;
            } else if (enumC1622a == EnumC1622a.MEDIATION_BACKGROUND) {
                scheduledThreadPoolExecutor = this.f2122o;
            } else if (enumC1622a == EnumC1622a.MEDIATION_POSTBACKS) {
                scheduledThreadPoolExecutor = this.f2123p;
            } else if (enumC1622a == EnumC1622a.MEDIATION_BANNER) {
                scheduledThreadPoolExecutor = this.f2124q;
            } else if (enumC1622a == EnumC1622a.MEDIATION_INTERSTITIAL) {
                scheduledThreadPoolExecutor = this.f2125r;
            } else if (enumC1622a == EnumC1622a.MEDIATION_INCENTIVIZED) {
                scheduledThreadPoolExecutor = this.f2126s;
            } else if (enumC1622a == EnumC1622a.MEDIATION_REWARDED_INTERSTITIAL) {
                scheduledThreadPoolExecutor = this.f2127t;
            } else if (enumC1622a != EnumC1622a.MEDIATION_REWARD) {
                return;
            } else {
                scheduledThreadPoolExecutor = this.f2128u;
            }
            c1620o = this;
            runnableC1625c = runnableC1625c2;
            j2 = j;
            scheduledThreadPoolExecutor2 = scheduledThreadPoolExecutor;
        }
        c1620o.m6786a(runnableC1625c, j2, scheduledThreadPoolExecutor2, z);
    }

    /* renamed from: a */
    public boolean m6795a() {
        return this.f2107A;
    }

    /* renamed from: b */
    public ScheduledExecutorService m6783b() {
        return this.f2129v;
    }

    /* renamed from: c */
    public void m6781c() {
        synchronized (this.f2133z) {
            this.f2107A = false;
        }
    }

    /* renamed from: d */
    public void m6780d() {
        synchronized (this.f2133z) {
            this.f2107A = true;
            for (RunnableC1625c runnableC1625c : this.f2132y) {
                m6793a(runnableC1625c.f2161c, runnableC1625c.f2162d);
            }
            this.f2132y.clear();
        }
    }
}
