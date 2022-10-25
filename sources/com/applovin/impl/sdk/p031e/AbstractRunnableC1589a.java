package com.applovin.impl.sdk.p031e;

import android.content.Context;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;

/* renamed from: com.applovin.impl.sdk.e.a */
/* loaded from: classes.dex */
public abstract class AbstractRunnableC1589a implements Runnable {

    /* renamed from: a */
    private final String f2057a;

    /* renamed from: b */
    protected final C1662k f2058b;

    /* renamed from: c */
    private final C1710r f2059c;

    /* renamed from: d */
    private final Context f2060d;

    /* renamed from: e */
    private final boolean f2061e;

    public AbstractRunnableC1589a(String str, C1662k c1662k) {
        this(str, c1662k, false);
    }

    public AbstractRunnableC1589a(String str, C1662k c1662k, boolean z) {
        this.f2057a = str;
        this.f2058b = c1662k;
        this.f2059c = c1662k.m6588z();
        this.f2060d = c1662k.m6677J();
        this.f2061e = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m6884a(String str) {
        this.f2059c.m6319b(this.f2057a, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m6883a(String str, Throwable th) {
        this.f2059c.m6318b(this.f2057a, str, th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m6882b(String str) {
        this.f2059c.m6317c(this.f2057a, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void m6881c(String str) {
        this.f2059c.m6315d(this.f2057a, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public C1662k m6880d() {
        return this.f2058b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public void m6879d(String str) {
        this.f2059c.m6314e(this.f2057a, str);
    }

    /* renamed from: e */
    public String m6878e() {
        return this.f2057a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public Context m6877f() {
        return this.f2060d;
    }

    /* renamed from: g */
    public boolean m6876g() {
        return this.f2061e;
    }
}
