package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Build;
import android.os.ConditionVariable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.amu */
/* loaded from: classes2.dex */
public final class amu {

    /* renamed from: b */
    protected volatile Boolean f4660b;

    /* renamed from: e */
    private final anw f4661e;

    /* renamed from: c */
    private static final ConditionVariable f4658c = new ConditionVariable();

    /* renamed from: a */
    protected static volatile asz f4657a = null;

    /* renamed from: d */
    private static volatile Random f4659d = null;

    public amu(anw anwVar) {
        this.f4661e = anwVar;
        anwVar.m4900j().execute(new amt(this));
    }

    /* renamed from: d */
    public static final int m4984d() {
        try {
            return Build.VERSION.SDK_INT >= 21 ? ThreadLocalRandom.current().nextInt() : m4982f().nextInt();
        } catch (RuntimeException unused) {
            return m4982f().nextInt();
        }
    }

    /* renamed from: f */
    private static Random m4982f() {
        if (f4659d == null) {
            synchronized (amu.class) {
                if (f4659d == null) {
                    f4659d = new Random();
                }
            }
        }
        return f4659d;
    }

    /* renamed from: c */
    public final void m4985c(int i, int i2, long j, String str, Exception exc) {
        try {
            f4658c.block();
            if (!this.f4660b.booleanValue() || f4657a == null) {
                return;
            }
            afc m5664j = afb.m5664j();
            m5664j.m5663a(this.f4661e.f4742a.getPackageName());
            m5664j.m5659e(j);
            if (str != null) {
                m5664j.m5662b(str);
            }
            if (exc != null) {
                StringWriter stringWriter = new StringWriter();
                exc.printStackTrace(new PrintWriter(stringWriter));
                m5664j.m5658f(stringWriter.toString());
                m5664j.m5660d(exc.getClass().getName());
            }
            asy m4637a = f4657a.m4637a(((afb) m5664j.mo3179aR()).mo3176ar());
            m4637a.m4639b(i);
            if (i2 != -1) {
                m4637a.m4638c(i2);
            }
            m4637a.m4640a();
        } catch (Exception unused) {
        }
    }

    /* renamed from: e */
    public final void m4983e(int i, long j, String str) {
        m4985c(i, -1, j, str, null);
    }
}
