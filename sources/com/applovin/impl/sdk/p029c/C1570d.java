package com.applovin.impl.sdk.p029c;

import java.util.HashSet;

/* renamed from: com.applovin.impl.sdk.c.d */
/* loaded from: classes.dex */
public class C1570d<T> {

    /* renamed from: C */
    private final String f1955C;

    /* renamed from: D */
    private final Class<T> f1956D;

    /* renamed from: a */
    public static final C1570d<String> f1929a = new C1570d<>("com.applovin.sdk.impl.isFirstRun", String.class);

    /* renamed from: b */
    public static final C1570d<Boolean> f1930b = new C1570d<>("com.applovin.sdk.launched_before", Boolean.class);

    /* renamed from: c */
    public static final C1570d<String> f1931c = new C1570d<>("com.applovin.sdk.latest_installed_version", String.class);

    /* renamed from: d */
    public static final C1570d<Long> f1932d = new C1570d<>("com.applovin.sdk.install_date", Long.class);

    /* renamed from: e */
    public static final C1570d<String> f1933e = new C1570d<>("com.applovin.sdk.user_id", String.class);

    /* renamed from: f */
    public static final C1570d<String> f1934f = new C1570d<>("com.applovin.sdk.compass_id", String.class);

    /* renamed from: g */
    public static final C1570d<String> f1935g = new C1570d<>("com.applovin.sdk.compass_random_token", String.class);

    /* renamed from: h */
    public static final C1570d<String> f1936h = new C1570d<>("com.applovin.sdk.applovin_random_token", String.class);

    /* renamed from: i */
    public static final C1570d<String> f1937i = new C1570d<>("com.applovin.sdk.device_test_group", String.class);

    /* renamed from: j */
    public static final C1570d<String> f1938j = new C1570d<>("com.applovin.sdk.variables", String.class);

    /* renamed from: k */
    public static final C1570d<Boolean> f1939k = new C1570d<>("com.applovin.sdk.compliance.has_user_consent", Boolean.class);

    /* renamed from: l */
    public static final C1570d<Boolean> f1940l = new C1570d<>("com.applovin.sdk.compliance.is_age_restricted_user", Boolean.class);

    /* renamed from: m */
    public static final C1570d<Boolean> f1941m = new C1570d<>("com.applovin.sdk.compliance.is_do_not_sell", Boolean.class);

    /* renamed from: n */
    public static final C1570d<HashSet> f1942n = new C1570d<>("com.applovin.sdk.impl.postbackQueue.key", HashSet.class);

    /* renamed from: o */
    public static final C1570d<String> f1943o = new C1570d<>("com.applovin.sdk.stats", String.class);

    /* renamed from: p */
    public static final C1570d<HashSet> f1944p = new C1570d<>("com.applovin.sdk.task.stats", HashSet.class);

    /* renamed from: q */
    public static final C1570d<String> f1945q = new C1570d<>("com.applovin.sdk.network_response_code_mapping", String.class);

    /* renamed from: r */
    public static final C1570d<String> f1946r = new C1570d<>("com.applovin.sdk.event_tracking.super_properties", String.class);

    /* renamed from: s */
    public static final C1570d<String> f1947s = new C1570d<>("com.applovin.sdk.request_tracker.counter", String.class);

    /* renamed from: t */
    public static final C1570d<HashSet> f1948t = new C1570d<>("com.applovin.sdk.ad.stats", HashSet.class);

    /* renamed from: u */
    public static final C1570d<Integer> f1949u = new C1570d<>("com.applovin.sdk.last_video_position", Integer.class);

    /* renamed from: v */
    public static final C1570d<Boolean> f1950v = new C1570d<>("com.applovin.sdk.should_resume_video", Boolean.class);

    /* renamed from: w */
    public static final C1570d<String> f1951w = new C1570d<>("com.applovin.sdk.mediation.signal_providers", String.class);

    /* renamed from: x */
    public static final C1570d<String> f1952x = new C1570d<>("com.applovin.sdk.mediation.auto_init_adapters", String.class);

    /* renamed from: y */
    public static final C1570d<String> f1953y = new C1570d<>("com.applovin.sdk.persisted_data", String.class);

    /* renamed from: z */
    public static final C1570d<String> f1954z = new C1570d<>("com.applovin.sdk.mediation_provider", String.class);

    /* renamed from: A */
    public static final C1570d<String> f1927A = new C1570d<>("com.applovin.sdk.mediation.test_mode_network", String.class);

    /* renamed from: B */
    public static final C1570d<Boolean> f1928B = new C1570d<>("com.applovin.sdk.mediation.test_mode_enabled", Boolean.class);

    public C1570d(String str, Class<T> cls) {
        this.f1955C = str;
        this.f1956D = cls;
    }

    /* renamed from: a */
    public String m6992a() {
        return this.f1955C;
    }

    /* renamed from: b */
    public Class<T> m6991b() {
        return this.f1956D;
    }

    public String toString() {
        return "Key{name='" + this.f1955C + "', type=" + this.f1956D + '}';
    }
}
