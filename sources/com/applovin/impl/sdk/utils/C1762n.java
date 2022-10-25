package com.applovin.impl.sdk.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p029c.C1570d;
import com.applovin.impl.sdk.p029c.C1571e;
import java.util.Locale;
import java.util.UUID;

/* renamed from: com.applovin.impl.sdk.utils.n */
/* loaded from: classes.dex */
public final class C1762n {

    /* renamed from: a */
    private final C1662k f2579a;

    /* renamed from: b */
    private String f2580b;

    /* renamed from: c */
    private final String f2581c;

    /* renamed from: d */
    private final String f2582d;

    public C1762n(C1662k c1662k) {
        this.f2579a = c1662k;
        this.f2581c = m6166a(C1570d.f1935g, (String) C1571e.m6977b(C1570d.f1934f, (Object) null, c1662k.m6677J()));
        this.f2582d = m6166a(C1570d.f1936h, (String) c1662k.m6656a(C1568b.f1650W));
        m6164a(m6161d());
    }

    /* renamed from: a */
    private String m6166a(C1570d<String> c1570d, String str) {
        String str2 = (String) C1571e.m6977b(c1570d, (Object) null, this.f2579a.m6677J());
        if (StringUtils.isValidString(str2)) {
            return str2;
        }
        if (!StringUtils.isValidString(str)) {
            str = UUID.randomUUID().toString().toLowerCase(Locale.US);
        }
        C1571e.m6984a(c1570d, str, this.f2579a.m6677J());
        return str;
    }

    /* renamed from: a */
    public static String m6165a(C1662k c1662k) {
        String str = (String) c1662k.m6654a(C1570d.f1937i);
        if (TextUtils.isEmpty(str)) {
            String valueOf = String.valueOf(((int) (Math.random() * 100.0d)) + 1);
            c1662k.m6653a((C1570d<C1570d<String>>) C1570d.f1937i, (C1570d<String>) valueOf);
            return valueOf;
        }
        return str;
    }

    /* renamed from: d */
    private String m6161d() {
        if (!((Boolean) this.f2579a.m6656a(C1568b.f1862dy)).booleanValue()) {
            this.f2579a.m6624b(C1570d.f1933e);
        }
        String str = (String) this.f2579a.m6654a(C1570d.f1933e);
        if (StringUtils.isValidString(str)) {
            C1710r m6588z = this.f2579a.m6588z();
            m6588z.m6319b("AppLovinSdk", "Using identifier (" + str + ") from previous session");
            return str;
        }
        return null;
    }

    /* renamed from: a */
    public String m6167a() {
        return this.f2580b;
    }

    /* renamed from: a */
    public void m6164a(String str) {
        if (((Boolean) this.f2579a.m6656a(C1568b.f1862dy)).booleanValue()) {
            this.f2579a.m6653a((C1570d<C1570d<String>>) C1570d.f1933e, (C1570d<String>) str);
        }
        this.f2580b = str;
        Bundle bundle = new Bundle();
        bundle.putString("user_id", StringUtils.emptyIfNull(str));
        bundle.putString("applovin_random_token", m6162c());
        this.f2579a.m6634af().m6731a(bundle, "user_info");
    }

    /* renamed from: b */
    public String m6163b() {
        return this.f2581c;
    }

    /* renamed from: c */
    public String m6162c() {
        return this.f2582d;
    }
}
