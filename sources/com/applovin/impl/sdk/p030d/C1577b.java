package com.applovin.impl.sdk.p030d;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.d.b */
/* loaded from: classes.dex */
public class C1577b {

    /* renamed from: A */
    public static final C1577b f1972A;

    /* renamed from: B */
    public static final C1577b f1973B;

    /* renamed from: C */
    public static final C1577b f1974C;

    /* renamed from: D */
    public static final C1577b f1975D;

    /* renamed from: G */
    private static final Set<String> f1976G = new HashSet(32);

    /* renamed from: a */
    public static final C1577b f1977a;

    /* renamed from: b */
    public static final C1577b f1978b;

    /* renamed from: c */
    public static final C1577b f1979c;

    /* renamed from: d */
    public static final C1577b f1980d;

    /* renamed from: e */
    public static final C1577b f1981e;

    /* renamed from: f */
    public static final C1577b f1982f;

    /* renamed from: g */
    public static final C1577b f1983g;

    /* renamed from: h */
    public static final C1577b f1984h;

    /* renamed from: i */
    public static final C1577b f1985i;

    /* renamed from: j */
    public static final C1577b f1986j;

    /* renamed from: k */
    public static final C1577b f1987k;

    /* renamed from: l */
    public static final C1577b f1988l;

    /* renamed from: m */
    public static final C1577b f1989m;

    /* renamed from: n */
    public static final C1577b f1990n;

    /* renamed from: o */
    public static final C1577b f1991o;

    /* renamed from: p */
    public static final C1577b f1992p;

    /* renamed from: q */
    public static final C1577b f1993q;

    /* renamed from: r */
    public static final C1577b f1994r;

    /* renamed from: s */
    public static final C1577b f1995s;

    /* renamed from: t */
    public static final C1577b f1996t;

    /* renamed from: u */
    public static final C1577b f1997u;

    /* renamed from: v */
    public static final C1577b f1998v;

    /* renamed from: w */
    public static final C1577b f1999w;

    /* renamed from: x */
    public static final C1577b f2000x;

    /* renamed from: y */
    public static final C1577b f2001y;

    /* renamed from: z */
    public static final C1577b f2002z;

    /* renamed from: E */
    private final String f2003E;

    /* renamed from: F */
    private final String f2004F;

    static {
        m6957a("sisw", "IS_STREAMING_WEBKIT");
        m6957a("surw", "UNABLE_TO_RETRIEVE_WEBKIT_HTML_STRING");
        m6957a("surp", "UNABLE_TO_PERSIST_WEBKIT_HTML_PLACEMENT_REPLACED_STRING");
        m6957a("swhp", "SUCCESSFULLY_PERSISTED_WEBKIT_HTML_STRING");
        m6957a("skr", "STOREKIT_REDIRECTED");
        m6957a("sklf", "STOREKIT_LOAD_FAILURE");
        m6957a("skps", "STOREKIT_PRELOAD_SKIPPED");
        f1977a = m6957a("sas", "AD_SOURCE");
        f1978b = m6957a("srt", "AD_RENDER_TIME");
        f1979c = m6957a("sft", "AD_FETCH_TIME");
        f1980d = m6957a("sfs", "AD_FETCH_SIZE");
        f1981e = m6957a("sadb", "AD_DOWNLOADED_BYTES");
        f1982f = m6957a("sacb", "AD_CACHED_BYTES");
        f1983g = m6957a("stdl", "TIME_TO_DISPLAY_FROM_LOAD");
        f1984h = m6957a("stdi", "TIME_TO_DISPLAY_FROM_INIT");
        f1985i = m6957a("snas", "AD_NUMBER_IN_SESSION");
        f1986j = m6957a("snat", "AD_NUMBER_TOTAL");
        f1987k = m6957a("stah", "TIME_AD_HIDDEN_FROM_SHOW");
        f1988l = m6957a("stas", "TIME_TO_SKIP_FROM_SHOW");
        f1989m = m6957a("stac", "TIME_TO_CLICK_FROM_SHOW");
        f1990n = m6957a("stbe", "TIME_TO_EXPAND_FROM_SHOW");
        f1991o = m6957a("stbc", "TIME_TO_CONTRACT_FROM_SHOW");
        f1992p = m6957a("saan", "AD_SHOWN_WITH_ACTIVE_NETWORK");
        f1993q = m6957a("suvs", "INTERSTITIAL_USED_VIDEO_STREAM");
        f1994r = m6957a("sugs", "AD_USED_GRAPHIC_STREAM");
        f1995s = m6957a("svpv", "INTERSTITIAL_VIDEO_PERCENT_VIEWED");
        f1996t = m6957a("stpd", "INTERSTITIAL_PAUSED_DURATION");
        f1997u = m6957a("shsc", "HTML_RESOURCE_CACHE_SUCCESS_COUNT");
        f1998v = m6957a("shfc", "HTML_RESOURCE_CACHE_FAILURE_COUNT");
        f1999w = m6957a("schc", "AD_CANCELLED_HTML_CACHING");
        f2000x = m6957a("smwm", "AD_SHOWN_IN_MULTIWINDOW_MODE");
        f2001y = m6957a("vssc", "VIDEO_STREAM_STALLED_COUNT");
        f2002z = m6957a("wvem", "WEB_VIEW_ERROR_MESSAGES");
        f1972A = m6957a("wvhec", "WEB_VIEW_HTTP_ERROR_COUNT");
        f1973B = m6957a("wvrec", "WEB_VIEW_RENDER_ERROR_COUNT");
        f1974C = m6957a("wvsem", "WEB_VIEW_SSL_ERROR_MESSAGES");
        f1975D = m6957a("wvruc", "WEB_VIEW_RENDERER_UNRESPONSIVE_COUNT");
    }

    private C1577b(String str, String str2) {
        this.f2003E = str;
        this.f2004F = str2;
    }

    /* renamed from: a */
    private static C1577b m6957a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No key name specified");
        }
        Set<String> set = f1976G;
        if (set.contains(str)) {
            throw new IllegalArgumentException("Key has already been used: " + str);
        } else if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("No debug name specified");
        } else {
            set.add(str);
            return new C1577b(str, str2);
        }
    }

    /* renamed from: a */
    public String m6958a() {
        return this.f2003E;
    }

    /* renamed from: b */
    public String m6956b() {
        return this.f2004F;
    }
}
