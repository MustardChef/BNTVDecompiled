package com.applovin.impl.sdk;

import android.os.Process;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class AppLovinExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private static final AppLovinExceptionHandler f1444a = new AppLovinExceptionHandler();

    /* renamed from: b */
    private final Set<C1662k> f1445b = new HashSet(2);

    /* renamed from: c */
    private final AtomicBoolean f1446c = new AtomicBoolean();

    /* renamed from: d */
    private Thread.UncaughtExceptionHandler f1447d;

    public static AppLovinExceptionHandler shared() {
        return f1444a;
    }

    public void addSdk(C1662k c1662k) {
        this.f1445b.add(c1662k);
    }

    public void enable() {
        if (this.f1446c.compareAndSet(false, true)) {
            this.f1447d = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        for (C1662k c1662k : this.f1445b) {
            c1662k.m6588z().m6319b("AppLovinExceptionHandler", "Detected unhandled exception");
            ((EventServiceImpl) c1662k.m6593u()).trackEventSynchronously("paused");
            ((EventServiceImpl) c1662k.m6593u()).trackEventSynchronously("crashed");
        }
        try {
            Thread.sleep(100L);
        } catch (InterruptedException unused) {
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f1447d;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        Process.killProcess(Process.myPid());
        System.exit(1);
    }
}
