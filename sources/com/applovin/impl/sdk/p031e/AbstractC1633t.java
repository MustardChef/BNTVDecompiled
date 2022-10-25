package com.applovin.impl.sdk.p031e;

import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.network.C1684b;
import com.applovin.impl.sdk.network.C1688c;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p029c.C1569c;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.e.t */
/* loaded from: classes.dex */
public abstract class AbstractC1633t<T> extends AbstractRunnableC1589a implements C1684b.InterfaceC1687c<T> {

    /* renamed from: a */
    private final C1688c<T> f2177a;

    /* renamed from: c */
    private final C1684b.InterfaceC1687c<T> f2178c;

    /* renamed from: d */
    protected C1684b.C1685a f2179d;

    /* renamed from: e */
    private C1620o.EnumC1622a f2180e;

    /* renamed from: f */
    private C1568b<String> f2181f;

    /* renamed from: g */
    private C1568b<String> f2182g;

    public AbstractC1633t(C1688c<T> c1688c, C1662k c1662k) {
        this(c1688c, c1662k, false);
    }

    public AbstractC1633t(C1688c<T> c1688c, final C1662k c1662k, boolean z) {
        super("TaskRepeatRequest", c1662k, z);
        this.f2180e = C1620o.EnumC1622a.BACKGROUND;
        this.f2181f = null;
        this.f2182g = null;
        if (c1688c == null) {
            throw new IllegalArgumentException("No request specified");
        }
        this.f2177a = c1688c;
        this.f2179d = new C1684b.C1685a();
        this.f2178c = new C1684b.InterfaceC1687c<T>() { // from class: com.applovin.impl.sdk.e.t.1
            @Override // com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
            /* renamed from: a */
            public void mo6491a(int i, String str, T t) {
                AbstractC1633t abstractC1633t;
                C1568b c1568b;
                boolean z2 = false;
                boolean z3 = i < 200 || i >= 500;
                boolean z4 = i == 429;
                if ((i != -1009) && (z3 || z4 || AbstractC1633t.this.f2177a.m6473m())) {
                    String m6480f = AbstractC1633t.this.f2177a.m6480f();
                    if (AbstractC1633t.this.f2177a.m6478h() > 0) {
                        AbstractC1633t abstractC1633t2 = AbstractC1633t.this;
                        abstractC1633t2.m6881c("Unable to send request due to server failure (code " + i + "). " + AbstractC1633t.this.f2177a.m6478h() + " attempts left, retrying in " + TimeUnit.MILLISECONDS.toSeconds(AbstractC1633t.this.f2177a.m6475k()) + " seconds...");
                        int m6478h = AbstractC1633t.this.f2177a.m6478h() - 1;
                        AbstractC1633t.this.f2177a.m6488a(m6478h);
                        if (m6478h == 0) {
                            AbstractC1633t abstractC1633t3 = AbstractC1633t.this;
                            abstractC1633t3.m6764c(abstractC1633t3.f2181f);
                            if (StringUtils.isValidString(m6480f) && m6480f.length() >= 4) {
                                AbstractC1633t abstractC1633t4 = AbstractC1633t.this;
                                abstractC1633t4.m6882b("Switching to backup endpoint " + m6480f);
                                AbstractC1633t.this.f2177a.m6486a(m6480f);
                                z2 = true;
                            }
                        }
                        long millis = (((Boolean) c1662k.m6656a(C1568b.f1844dg)).booleanValue() && z2) ? 0L : AbstractC1633t.this.f2177a.m6474l() ? TimeUnit.SECONDS.toMillis((long) Math.pow(2.0d, AbstractC1633t.this.f2177a.m6477i())) : AbstractC1633t.this.f2177a.m6475k();
                        C1620o m6670Q = c1662k.m6670Q();
                        AbstractC1633t abstractC1633t5 = AbstractC1633t.this;
                        m6670Q.m6792a(abstractC1633t5, abstractC1633t5.f2180e, millis);
                        return;
                    }
                    if (m6480f == null || !m6480f.equals(AbstractC1633t.this.f2177a.m6489a())) {
                        abstractC1633t = AbstractC1633t.this;
                        c1568b = abstractC1633t.f2181f;
                    } else {
                        abstractC1633t = AbstractC1633t.this;
                        c1568b = abstractC1633t.f2182g;
                    }
                    abstractC1633t.m6764c(c1568b);
                }
                AbstractC1633t.this.mo6491a(i, str, t);
            }

            @Override // com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
            /* renamed from: a */
            public void mo6490a(T t, int i) {
                AbstractC1633t.this.f2177a.m6488a(0);
                AbstractC1633t.this.mo6490a((AbstractC1633t) t, i);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public <ST> void m6764c(C1568b<ST> c1568b) {
        if (c1568b != null) {
            C1569c m6678I = m6880d().m6678I();
            m6678I.m7002a((C1568b<?>) c1568b, (Object) c1568b.m7006b());
            m6678I.m7004a();
        }
    }

    /* renamed from: a */
    public abstract void mo6491a(int i, String str, T t);

    /* renamed from: a */
    public void m6770a(C1568b<String> c1568b) {
        this.f2181f = c1568b;
    }

    /* renamed from: a */
    public void m6769a(C1620o.EnumC1622a enumC1622a) {
        this.f2180e = enumC1622a;
    }

    /* renamed from: a */
    public abstract void mo6490a(T t, int i);

    /* renamed from: b */
    public void m6766b(C1568b<String> c1568b) {
        this.f2182g = c1568b;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        C1684b m6671P = m6880d().m6671P();
        if (!m6880d().m6617c() && !m6880d().m6613d()) {
            C1710r.m6310i("AppLovinSdk", "AppLovin SDK is disabled");
            i = -22;
        } else if (StringUtils.isValidString(this.f2177a.m6489a()) && this.f2177a.m6489a().length() >= 4) {
            if (TextUtils.isEmpty(this.f2177a.m6485b())) {
                this.f2177a.m6484b(this.f2177a.m6481e() != null ? ShareTarget.METHOD_POST : ShareTarget.METHOD_GET);
            }
            m6671P.m6508a(this.f2177a, this.f2179d, this.f2178c);
            return;
        } else {
            m6879d("Task has an invalid or null request endpoint.");
            i = AppLovinErrorCodes.INVALID_URL;
        }
        mo6491a(i, null, null);
    }
}
