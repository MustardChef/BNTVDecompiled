package com.applovin.impl.sdk.p030d;

import android.app.Activity;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p030d.C1578c;
import com.applovin.impl.sdk.utils.C1724f;
import com.applovin.impl.sdk.utils.C1725g;

/* renamed from: com.applovin.impl.sdk.d.d */
/* loaded from: classes.dex */
public class C1584d {

    /* renamed from: a */
    private final C1662k f2017a;

    /* renamed from: b */
    private final C1587g f2018b;

    /* renamed from: c */
    private final C1578c.C1582b f2019c;

    /* renamed from: d */
    private final Object f2020d = new Object();

    /* renamed from: e */
    private final long f2021e;

    /* renamed from: f */
    private long f2022f;

    /* renamed from: g */
    private long f2023g;

    /* renamed from: h */
    private long f2024h;

    public C1584d(AppLovinAdBase appLovinAdBase, C1662k c1662k) {
        if (appLovinAdBase == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        if (c1662k == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f2017a = c1662k;
        this.f2018b = c1662k.m6669R();
        C1578c.C1582b m6954a = c1662k.m6639aa().m6954a(appLovinAdBase);
        this.f2019c = m6954a;
        m6954a.m6929a(C1577b.f1977a, appLovinAdBase.getSource().ordinal()).m6931a();
        this.f2021e = appLovinAdBase.getCreatedAtMillis();
    }

    /* renamed from: a */
    public static void m6925a(long j, AppLovinAdBase appLovinAdBase, C1662k c1662k) {
        if (appLovinAdBase == null || c1662k == null) {
            return;
        }
        c1662k.m6639aa().m6954a(appLovinAdBase).m6929a(C1577b.f1978b, j).m6931a();
    }

    /* renamed from: a */
    public static void m6924a(AppLovinAdBase appLovinAdBase, C1662k c1662k) {
        if (appLovinAdBase == null || c1662k == null) {
            return;
        }
        c1662k.m6639aa().m6954a(appLovinAdBase).m6929a(C1577b.f1979c, appLovinAdBase.getFetchLatencyMillis()).m6929a(C1577b.f1980d, appLovinAdBase.getFetchResponseSize()).m6931a();
    }

    /* renamed from: a */
    private void m6923a(C1577b c1577b) {
        synchronized (this.f2020d) {
            if (this.f2022f > 0) {
                this.f2019c.m6929a(c1577b, System.currentTimeMillis() - this.f2022f).m6931a();
            }
        }
    }

    /* renamed from: a */
    public static void m6922a(C1585e c1585e, AppLovinAdBase appLovinAdBase, C1662k c1662k) {
        if (appLovinAdBase == null || c1662k == null || c1585e == null) {
            return;
        }
        c1662k.m6639aa().m6954a(appLovinAdBase).m6929a(C1577b.f1981e, c1585e.m6906c()).m6929a(C1577b.f1982f, c1585e.m6905d()).m6929a(C1577b.f1997u, c1585e.m6902g()).m6929a(C1577b.f1998v, c1585e.m6901h()).m6929a(C1577b.f1999w, c1585e.m6908b() ? 1L : 0L).m6931a();
    }

    /* renamed from: a */
    public void m6927a() {
        this.f2019c.m6929a(C1577b.f1986j, this.f2018b.m6893a(C1586f.f2033b)).m6929a(C1577b.f1985i, this.f2018b.m6893a(C1586f.f2035d));
        synchronized (this.f2020d) {
            long j = 0;
            if (this.f2021e > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f2022f = currentTimeMillis;
                long m6674M = currentTimeMillis - this.f2017a.m6674M();
                long j2 = this.f2022f - this.f2021e;
                long j3 = C1725g.m6267a(this.f2017a.m6677J()) ? 1L : 0L;
                Activity m7240a = this.f2017a.m6636ad().m7240a();
                if (C1724f.m6273f() && m7240a != null && m7240a.isInMultiWindowMode()) {
                    j = 1;
                }
                this.f2019c.m6929a(C1577b.f1984h, m6674M).m6929a(C1577b.f1983g, j2).m6929a(C1577b.f1992p, j3).m6929a(C1577b.f2000x, j);
            }
        }
        this.f2019c.m6931a();
    }

    /* renamed from: a */
    public void m6926a(long j) {
        this.f2019c.m6929a(C1577b.f1994r, j).m6931a();
    }

    /* renamed from: b */
    public void m6921b() {
        synchronized (this.f2020d) {
            if (this.f2023g < 1) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f2023g = currentTimeMillis;
                long j = this.f2022f;
                if (j > 0) {
                    this.f2019c.m6929a(C1577b.f1989m, currentTimeMillis - j).m6931a();
                }
            }
        }
    }

    /* renamed from: b */
    public void m6920b(long j) {
        this.f2019c.m6929a(C1577b.f1993q, j).m6931a();
    }

    /* renamed from: c */
    public void m6919c() {
        m6923a(C1577b.f1987k);
    }

    /* renamed from: c */
    public void m6918c(long j) {
        this.f2019c.m6929a(C1577b.f1995s, j).m6931a();
    }

    /* renamed from: d */
    public void m6917d() {
        m6923a(C1577b.f1990n);
    }

    /* renamed from: d */
    public void m6916d(long j) {
        synchronized (this.f2020d) {
            if (this.f2024h < 1) {
                this.f2024h = j;
                this.f2019c.m6929a(C1577b.f1996t, j).m6931a();
            }
        }
    }

    /* renamed from: e */
    public void m6915e() {
        m6923a(C1577b.f1991o);
    }

    /* renamed from: f */
    public void m6914f() {
        m6923a(C1577b.f1988l);
    }

    /* renamed from: g */
    public void m6913g() {
        this.f2019c.m6930a(C1577b.f2001y).m6931a();
    }
}
