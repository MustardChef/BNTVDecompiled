package com.applovin.impl.sdk.p029c;

import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.c.a */
/* loaded from: classes.dex */
public class C1567a<T> extends C1568b<T> {

    /* renamed from: a */
    public static final C1568b<String> f1623a = m7007a("afi", "");

    /* renamed from: b */
    public static final C1568b<Long> f1624b = m7007a("afi_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(5)));

    /* renamed from: c */
    public static final C1568b<String> f1625c = m7007a("mediation_endpoint", "https://ms.applovin.com/");

    /* renamed from: d */
    public static final C1568b<String> f1626d = m7007a("mediation_backup_endpoint", "https://ms.applvn.com/");

    /* renamed from: e */
    public static final C1568b<Long> f1627e = m7007a("fetch_next_ad_retry_delay_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(2)));

    /* renamed from: f */
    public static final C1568b<Long> f1628f = m7007a("fetch_next_ad_timeout_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(5)));

    /* renamed from: g */
    public static final C1568b<Long> f1629g = m7007a("fetch_mediation_debugger_info_timeout_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(7)));

    /* renamed from: h */
    public static final C1568b<Boolean> f1630h = m7007a("auto_init_mediation_debugger", true);

    /* renamed from: i */
    public static final C1568b<String> f1631i = m7007a("postback_macros", "{\"{MCODE}\":\"mcode\",\"{BCODE}\":\"bcode\",\"{ICODE}\":\"icode\",\"{SCODE}\":\"scode\"}");

    /* renamed from: j */
    public static final C1568b<Boolean> f1632j = m7007a("persistent_mediated_postbacks", false);

    /* renamed from: k */
    public static final C1568b<Long> f1633k = m7007a("max_signal_provider_latency_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(30)));

    /* renamed from: l */
    public static final C1568b<Long> f1634l = m7007a("default_adapter_timeout_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(10)));

    /* renamed from: m */
    public static final C1568b<Long> f1635m = m7007a("ad_refresh_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(30)));

    /* renamed from: n */
    public static final C1568b<Long> f1636n = m7007a("ad_load_failure_refresh_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(30)));

    /* renamed from: o */
    public static final C1568b<String> f1637o = m7007a("ad_load_failure_refresh_ignore_error_codes", "204");

    /* renamed from: p */
    public static final C1568b<Long> f1638p = m7007a("refresh_ad_on_app_resume_elapsed_threshold_ms", 0L);

    /* renamed from: q */
    public static final C1568b<Boolean> f1639q = m7007a("refresh_ad_view_timer_responds_to_background", true);

    /* renamed from: r */
    public static final C1568b<Boolean> f1640r = m7007a("refresh_ad_view_timer_responds_to_store_kit", true);

    /* renamed from: s */
    public static final C1568b<Boolean> f1641s = m7007a("refresh_ad_view_timer_responds_to_window_visibility_changed", false);

    /* renamed from: t */
    public static final C1568b<Boolean> f1642t = m7007a("avrsponse", false);

    /* renamed from: u */
    public static final C1568b<Long> f1643u = m7007a("ad_view_fade_in_animation_ms", 150L);

    /* renamed from: v */
    public static final C1568b<Long> f1644v = m7007a("ad_view_fade_out_animation_ms", 150L);

    /* renamed from: w */
    public static final C1568b<Long> f1645w = m7007a("fullscreen_display_delay_ms", 600L);

    /* renamed from: x */
    public static final C1568b<Long> f1646x = m7007a("ahdm", 500L);

    /* renamed from: y */
    public static final C1568b<Integer> f1647y = m7007a("ad_load_reminder_delay_seconds", 5);

    /* renamed from: z */
    public static final C1568b<Long> f1648z = m7007a("ad_view_refresh_precache_request_viewability_undesired_flags", 502L);

    /* renamed from: A */
    public static final C1568b<Long> f1602A = m7007a("ad_view_refresh_precache_request_delay_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(2)));

    /* renamed from: B */
    public static final C1568b<Boolean> f1603B = m7007a("ad_view_block_publisher_load_if_refresh_scheduled", true);

    /* renamed from: C */
    public static final C1568b<Boolean> f1604C = m7007a("fullscreen_ads_block_publisher_load_if_another_showing", true);

    /* renamed from: D */
    public static final C1568b<Boolean> f1605D = m7007a("fabsina", false);

    /* renamed from: E */
    public static final C1568b<Long> f1606E = m7007a("ad_expiration_ms", Long.valueOf(TimeUnit.HOURS.toMillis(4)));

    /* renamed from: F */
    public static final C1568b<Boolean> f1607F = m7007a("saewib", false);

    /* renamed from: G */
    public static final C1568b<Long> f1608G = m7007a("fullscreen_ad_displayed_timeout_ms", -1L);

    /* renamed from: H */
    public static final C1568b<Long> f1609H = m7007a("ad_hidden_timeout_ms", -1L);

    /* renamed from: I */
    public static final C1568b<Boolean> f1610I = m7007a("schedule_ad_hidden_on_ad_dismiss", false);

    /* renamed from: J */
    public static final C1568b<Long> f1611J = m7007a("ad_hidden_on_ad_dismiss_callback_delay_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(1)));

    /* renamed from: K */
    public static final C1568b<Boolean> f1612K = m7007a("proe", false);

    /* renamed from: L */
    public static final C1568b<Integer> f1613L = m7007a("mute_state", 2);

    /* renamed from: M */
    public static final C1568b<Boolean> f1614M = m7007a("adapters_to_re_fetch_sdk_version_if_empty", true);

    /* renamed from: N */
    public static final C1568b<String> f1615N = m7007a("saf", "");

    /* renamed from: O */
    public static final C1568b<String> f1616O = m7007a("saui", "");

    /* renamed from: P */
    public static final C1568b<Integer> f1617P = m7007a("mra", -1);

    /* renamed from: Q */
    public static final C1568b<String> f1618Q = m7007a("mra_af", "INTER,REWARDED,REWARDED_INTER,BANNER,LEADER,MREC");

    /* renamed from: R */
    public static final C1568b<Boolean> f1619R = m7007a("pmp", false);

    /* renamed from: S */
    public static final C1568b<Long> f1620S = m7007a("lpd_s", -1L);

    /* renamed from: T */
    public static final C1568b<Boolean> f1621T = m7007a("fetch_mediated_ad_gzip", false);

    /* renamed from: U */
    public static final C1568b<Boolean> f1622U = m7007a("max_postback_gzip", false);
}
