package com.applovin.impl.sdk.p030d;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.d.f */
/* loaded from: classes.dex */
public class C1586f {

    /* renamed from: u */
    private final String f2053u;

    /* renamed from: t */
    private static final Set<String> f2051t = new HashSet(32);

    /* renamed from: v */
    private static final Set<C1586f> f2052v = new HashSet(16);

    /* renamed from: a */
    public static final C1586f f2032a = m6897a("ad_req");

    /* renamed from: b */
    public static final C1586f f2033b = m6897a("ad_imp");

    /* renamed from: c */
    public static final C1586f f2034c = m6897a("ad_session_start");

    /* renamed from: d */
    public static final C1586f f2035d = m6897a("ad_imp_session");

    /* renamed from: e */
    public static final C1586f f2036e = m6897a("cached_files_expired");

    /* renamed from: f */
    public static final C1586f f2037f = m6897a("cache_drop_count");

    /* renamed from: g */
    public static final C1586f f2038g = m6896a("sdk_reset_state_count", true);

    /* renamed from: h */
    public static final C1586f f2039h = m6896a("ad_response_process_failures", true);

    /* renamed from: i */
    public static final C1586f f2040i = m6896a("response_process_failures", true);

    /* renamed from: j */
    public static final C1586f f2041j = m6896a("incent_failed_to_display_count", true);

    /* renamed from: k */
    public static final C1586f f2042k = m6897a("app_paused_and_resumed");

    /* renamed from: l */
    public static final C1586f f2043l = m6896a("ad_rendered_with_mismatched_sdk_key", true);

    /* renamed from: m */
    public static final C1586f f2044m = m6897a("ad_shown_outside_app_count");

    /* renamed from: n */
    public static final C1586f f2045n = m6897a("med_ad_req");

    /* renamed from: o */
    public static final C1586f f2046o = m6896a("med_ad_response_process_failures", true);

    /* renamed from: p */
    public static final C1586f f2047p = m6896a("med_adapters_failed_init_missing_activity", true);

    /* renamed from: q */
    public static final C1586f f2048q = m6896a("med_waterfall_ad_no_fill", true);

    /* renamed from: r */
    public static final C1586f f2049r = m6896a("med_waterfall_ad_adapter_load_failed", true);

    /* renamed from: s */
    public static final C1586f f2050s = m6896a("med_waterfall_ad_invalid_response", true);

    static {
        m6897a("fullscreen_ad_nil_vc_count");
        m6897a("applovin_bundle_missing");
    }

    private C1586f(String str) {
        this.f2053u = str;
    }

    /* renamed from: a */
    private static C1586f m6897a(String str) {
        return m6896a(str, false);
    }

    /* renamed from: a */
    private static C1586f m6896a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No key name specified");
        }
        Set<String> set = f2051t;
        if (set.contains(str)) {
            throw new IllegalArgumentException("Key has already been used: " + str);
        }
        set.add(str);
        C1586f c1586f = new C1586f(str);
        if (z) {
            f2052v.add(c1586f);
        }
        return c1586f;
    }

    /* renamed from: b */
    public static Set<C1586f> m6895b() {
        return f2052v;
    }

    /* renamed from: a */
    public String m6898a() {
        return this.f2053u;
    }
}
