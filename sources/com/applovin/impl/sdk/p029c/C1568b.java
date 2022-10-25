package com.applovin.impl.sdk.p029c;

import android.net.Uri;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.p010a.C1143j;
import com.applovin.sdk.AppLovinAdSize;
import com.google.android.exoplayer2.audio.AacUtil;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.c.b */
/* loaded from: classes.dex */
public class C1568b<T> implements Comparable {

    /* renamed from: c */
    private final String f1918c;

    /* renamed from: d */
    private final T f1919d;

    /* renamed from: a */
    private static final List<?> f1654a = Arrays.asList(Boolean.class, Float.class, Integer.class, Long.class, String.class);

    /* renamed from: b */
    private static final Map<String, C1568b<?>> f1707b = new HashMap(512);

    /* renamed from: V */
    public static final C1568b<Boolean> f1649V = m7007a("is_disabled", false);

    /* renamed from: W */
    public static final C1568b<String> f1650W = m7007a("device_id", "");

    /* renamed from: X */
    public static final C1568b<Boolean> f1651X = m7007a("rss", true);

    /* renamed from: Y */
    public static final C1568b<String> f1652Y = m7007a("device_token", "");

    /* renamed from: Z */
    public static final C1568b<Long> f1653Z = m7007a("publisher_id", 0L);

    /* renamed from: aa */
    public static final C1568b<Boolean> f1681aa = m7007a("is_verbose_logging", false);

    /* renamed from: ab */
    public static final C1568b<String> f1682ab = m7007a("sc", "");

    /* renamed from: ac */
    public static final C1568b<String> f1683ac = m7007a("sc2", "");

    /* renamed from: ad */
    public static final C1568b<String> f1684ad = m7007a("sc3", "");

    /* renamed from: ae */
    public static final C1568b<String> f1685ae = m7007a("server_installed_at", "");

    /* renamed from: af */
    public static final C1568b<Boolean> f1686af = m7007a("track_network_response_codes", false);

    /* renamed from: ag */
    public static final C1568b<Boolean> f1687ag = m7007a("submit_network_response_codes", false);

    /* renamed from: ah */
    public static final C1568b<Boolean> f1688ah = m7007a("clear_network_response_codes_on_request", true);

    /* renamed from: ai */
    public static final C1568b<Boolean> f1689ai = m7007a("clear_completion_callback_on_failure", false);

    /* renamed from: aj */
    public static final C1568b<Long> f1690aj = m7007a("sicd_ms", 0L);

    /* renamed from: ak */
    public static final C1568b<Integer> f1691ak = m7007a("logcat_max_line_size", 1000);

    /* renamed from: al */
    public static final C1568b<Integer> f1692al = m7007a("stps", 32);

    /* renamed from: am */
    public static final C1568b<Boolean> f1693am = m7007a("ustp", false);

    /* renamed from: an */
    public static final C1568b<Boolean> f1694an = m7007a("exception_handler_enabled", true);

    /* renamed from: ao */
    public static final C1568b<Boolean> f1695ao = m7007a("publisher_can_show_consent_dialog", true);

    /* renamed from: ap */
    public static final C1568b<String> f1696ap = m7007a("consent_dialog_url", "https://assets.applovin.com/gdpr/flow_v1/gdpr-flow-1.html");

    /* renamed from: aq */
    public static final C1568b<Boolean> f1697aq = m7007a("consent_dialog_immersive_mode_on", false);

    /* renamed from: ar */
    public static final C1568b<Long> f1698ar = m7007a("consent_dialog_show_from_alert_delay_ms", 450L);

    /* renamed from: as */
    public static final C1568b<Boolean> f1699as = m7007a("alert_consent_for_dialog_rejected", false);

    /* renamed from: at */
    public static final C1568b<Boolean> f1700at = m7007a("alert_consent_for_dialog_closed", false);

    /* renamed from: au */
    public static final C1568b<Boolean> f1701au = m7007a("alert_consent_for_dialog_closed_with_back_button", false);

    /* renamed from: av */
    public static final C1568b<Boolean> f1702av = m7007a("alert_consent_after_init", false);

    /* renamed from: aw */
    public static final C1568b<Long> f1703aw = m7007a("alert_consent_after_init_interval_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(5)));

    /* renamed from: ax */
    public static final C1568b<Long> f1704ax = m7007a("alert_consent_after_dialog_rejection_interval_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(30)));

    /* renamed from: ay */
    public static final C1568b<Long> f1705ay = m7007a("alert_consent_after_dialog_close_interval_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(5)));

    /* renamed from: az */
    public static final C1568b<Long> f1706az = m7007a("alert_consent_after_dialog_close_with_back_button_interval_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(5)));

    /* renamed from: aA */
    public static final C1568b<Long> f1655aA = m7007a("alert_consent_after_cancel_interval_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(10)));

    /* renamed from: aB */
    public static final C1568b<Long> f1656aB = m7007a("alert_consent_reschedule_interval_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(5)));

    /* renamed from: aC */
    public static final C1568b<String> f1657aC = m7007a("text_alert_consent_title", "Make this App Better and Stay Free!");

    /* renamed from: aD */
    public static final C1568b<String> f1658aD = m7007a("text_alert_consent_body", "If you don't give us consent to use your data, you will be making our ability to support this app harder, which may negatively affect the user experience.");

    /* renamed from: aE */
    public static final C1568b<String> f1659aE = m7007a("text_alert_consent_yes_option", "I Agree");

    /* renamed from: aF */
    public static final C1568b<String> f1660aF = m7007a("text_alert_consent_no_option", "Cancel");

    /* renamed from: aG */
    public static final C1568b<Long> f1661aG = m7007a("ttc_max_click_duration_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(1)));

    /* renamed from: aH */
    public static final C1568b<Integer> f1662aH = m7007a("ttc_max_click_distance_dp", 10);

    /* renamed from: aI */
    public static final C1568b<Integer> f1663aI = m7007a("ttc_acrs", Integer.valueOf(AppLovinTouchToClickListener.ClickRecognitionState.DISABLED.ordinal()));

    /* renamed from: aJ */
    public static final C1568b<Integer> f1664aJ = m7007a("ttc_acrsv2a", Integer.valueOf(AppLovinTouchToClickListener.ClickRecognitionState.ACTION_DOWN.ordinal()));

    /* renamed from: aK */
    public static final C1568b<Integer> f1665aK = m7007a("ttc_edge_buffer_dp", 0);

    /* renamed from: aL */
    public static final C1568b<String> f1666aL = m7007a("whitelisted_postback_endpoints", "https://prod-a.applovin.com,https://rt.applovin.com/4.0/pix, https://rt.applvn.com/4.0/pix,https://ms.applovin.com/,https://ms.applvn.com/");

    /* renamed from: aM */
    public static final C1568b<String> f1667aM = m7007a("fetch_settings_endpoint", "https://ms.applovin.com/");

    /* renamed from: aN */
    public static final C1568b<String> f1668aN = m7007a("fetch_settings_backup_endpoint", "https://ms.applvn.com/");

    /* renamed from: aO */
    public static final C1568b<String> f1669aO = m7007a("adserver_endpoint", "https://a.applovin.com/");

    /* renamed from: aP */
    public static final C1568b<String> f1670aP = m7007a("adserver_backup_endpoint", "https://a.applvn.com/");

    /* renamed from: aQ */
    public static final C1568b<String> f1671aQ = m7007a("api_endpoint", "https://d.applovin.com/");

    /* renamed from: aR */
    public static final C1568b<String> f1672aR = m7007a("api_backup_endpoint", "https://d.applvn.com/");

    /* renamed from: aS */
    public static final C1568b<String> f1673aS = m7007a("event_tracking_endpoint_v2", "https://rt.applovin.com/");

    /* renamed from: aT */
    public static final C1568b<String> f1674aT = m7007a("event_tracking_backup_endpoint_v2", "https://rt.applvn.com/");

    /* renamed from: aU */
    public static final C1568b<String> f1675aU = m7007a("fetch_variables_endpoint", "https://ms.applovin.com/");

    /* renamed from: aV */
    public static final C1568b<String> f1676aV = m7007a("fetch_variables_backup_endpoint", "https://ms.applvn.com/");

    /* renamed from: aW */
    public static final C1568b<String> f1677aW = m7007a("token_type_prefixes_r", "4!");

    /* renamed from: aX */
    public static final C1568b<String> f1678aX = m7007a("token_type_prefixes_arj", "json_v3!");

    /* renamed from: aY */
    public static final C1568b<String> f1679aY = m7007a("top_level_events", "landing,paused,resumed,ref,rdf,checkout,iap");

    /* renamed from: aZ */
    public static final C1568b<String> f1680aZ = m7007a("valid_super_property_types", String.class.getName() + "," + Integer.class.getName() + "," + Long.class.getName() + "," + Double.class.getName() + "," + Float.class.getName() + "," + Date.class.getName() + "," + Uri.class.getName() + "," + List.class.getName() + "," + Map.class.getName());

    /* renamed from: ba */
    public static final C1568b<Boolean> f1734ba = m7007a("persist_super_properties", true);

    /* renamed from: bb */
    public static final C1568b<Integer> f1735bb = m7007a("super_property_string_max_length", 1024);

    /* renamed from: bc */
    public static final C1568b<Integer> f1736bc = m7007a("super_property_url_max_length", 1024);

    /* renamed from: bd */
    public static final C1568b<Long> f1737bd = m7007a("cached_advertising_info_ttl_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(10)));

    /* renamed from: be */
    public static final C1568b<Boolean> f1738be = m7007a("use_per_format_cache_queues", true);

    /* renamed from: bf */
    public static final C1568b<Boolean> f1739bf = m7007a("cache_cleanup_enabled", false);

    /* renamed from: bg */
    public static final C1568b<Long> f1740bg = m7007a("cache_file_ttl_seconds", Long.valueOf(TimeUnit.DAYS.toSeconds(1)));

    /* renamed from: bh */
    public static final C1568b<Integer> f1741bh = m7007a("cache_max_size_mb", -1);

    /* renamed from: bi */
    public static final C1568b<String> f1742bi = m7007a("precache_delimiters", ")]',");

    /* renamed from: bj */
    public static final C1568b<Boolean> f1743bj = m7007a("ad_resource_caching_enabled", true);

    /* renamed from: bk */
    public static final C1568b<Boolean> f1744bk = m7007a("fail_ad_load_on_failed_video_cache", true);

    /* renamed from: bl */
    public static final C1568b<String> f1745bl = m7007a("resource_cache_prefix", "https://vid.applovin.com/,https://pdn.applovin.com/,https://img.applovin.com/,https://d.applovin.com/,https://assets.applovin.com/,https://cdnjs.cloudflare.com/,http://vid.applovin.com/,http://pdn.applovin.com/,http://img.applovin.com/,http://d.applovin.com/,http://assets.applovin.com/,http://cdnjs.cloudflare.com/");

    /* renamed from: bm */
    public static final C1568b<String> f1746bm = m7007a("preserved_cached_assets", "sound_off.png,sound_on.png,closeOptOut.png,1381250003_28x28.png,zepto-1.1.3.min.js,jquery-2.1.1.min.js,jquery-1.9.1.min.js,jquery.knob.js");

    /* renamed from: bn */
    public static final C1568b<Integer> f1747bn = m7007a("vr_retry_count_v1", 1);

    /* renamed from: bo */
    public static final C1568b<Integer> f1748bo = m7007a("cr_retry_count_v1", 1);

    /* renamed from: bp */
    public static final C1568b<Boolean> f1749bp = m7007a("incent_warning_enabled", false);

    /* renamed from: bq */
    public static final C1568b<String> f1750bq = m7007a("text_incent_warning_title", "Attention!");

    /* renamed from: br */
    public static final C1568b<String> f1751br = m7007a("text_incent_warning_body", "You won’t get your reward if the video hasn’t finished.");

    /* renamed from: bs */
    public static final C1568b<String> f1752bs = m7007a("text_incent_warning_close_option", "Close");

    /* renamed from: bt */
    public static final C1568b<String> f1753bt = m7007a("text_incent_warning_continue_option", "Keep Watching");

    /* renamed from: bu */
    public static final C1568b<Boolean> f1754bu = m7007a("incent_nonvideo_warning_enabled", false);

    /* renamed from: bv */
    public static final C1568b<String> f1755bv = m7007a("text_incent_nonvideo_warning_title", "Attention!");

    /* renamed from: bw */
    public static final C1568b<String> f1756bw = m7007a("text_incent_nonvideo_warning_body", "You won’t get your reward if the game hasn’t finished.");

    /* renamed from: bx */
    public static final C1568b<String> f1757bx = m7007a("text_incent_nonvideo_warning_close_option", "Close");

    /* renamed from: by */
    public static final C1568b<String> f1758by = m7007a("text_incent_nonvideo_warning_continue_option", "Keep Playing");

    /* renamed from: bz */
    public static final C1568b<Boolean> f1759bz = m7007a("check_webview_has_gesture", false);

    /* renamed from: bA */
    public static final C1568b<Integer> f1708bA = m7007a("close_button_touch_area", 0);

    /* renamed from: bB */
    public static final C1568b<Integer> f1709bB = m7007a("close_button_outside_touch_area", 0);

    /* renamed from: bC */
    public static final C1568b<Boolean> f1710bC = m7007a("creative_debugger_enabled", false);

    /* renamed from: bD */
    public static final C1568b<Long> f1711bD = m7007a("viewability_adview_imp_delay_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(1)));

    /* renamed from: bE */
    public static final C1568b<Integer> f1712bE = m7007a("viewability_adview_banner_min_width", 320);

    /* renamed from: bF */
    public static final C1568b<Integer> f1713bF = m7007a("viewability_adview_banner_min_height", Integer.valueOf(AppLovinAdSize.BANNER.getHeight()));

    /* renamed from: bG */
    public static final C1568b<Integer> f1714bG = m7007a("viewability_adview_mrec_min_width", Integer.valueOf(AppLovinAdSize.MREC.getWidth()));

    /* renamed from: bH */
    public static final C1568b<Integer> f1715bH = m7007a("viewability_adview_mrec_min_height", Integer.valueOf(AppLovinAdSize.MREC.getHeight()));

    /* renamed from: bI */
    public static final C1568b<Integer> f1716bI = m7007a("viewability_adview_leader_min_width", 728);

    /* renamed from: bJ */
    public static final C1568b<Integer> f1717bJ = m7007a("viewability_adview_leader_min_height", Integer.valueOf(AppLovinAdSize.LEADER.getHeight()));

    /* renamed from: bK */
    public static final C1568b<Float> f1718bK = m7007a("viewability_adview_min_alpha", Float.valueOf(10.0f));

    /* renamed from: bL */
    public static final C1568b<Long> f1719bL = m7007a("viewability_timer_min_visible_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(1)));

    /* renamed from: bM */
    public static final C1568b<Long> f1720bM = m7007a("viewability_timer_interval_ms", 100L);

    /* renamed from: bN */
    public static final C1568b<Integer> f1721bN = m7007a("expandable_close_button_size", 27);

    /* renamed from: bO */
    public static final C1568b<Integer> f1722bO = m7007a("expandable_h_close_button_margin", 10);

    /* renamed from: bP */
    public static final C1568b<Integer> f1723bP = m7007a("expandable_t_close_button_margin", 10);

    /* renamed from: bQ */
    public static final C1568b<Boolean> f1724bQ = m7007a("expandable_lhs_close_button", false);

    /* renamed from: bR */
    public static final C1568b<Integer> f1725bR = m7007a("expandable_close_button_touch_area", 0);

    /* renamed from: bS */
    public static final C1568b<Boolean> f1726bS = m7007a("iaad", false);

    /* renamed from: bT */
    public static final C1568b<Integer> f1727bT = m7007a("auxiliary_operations_threads", 3);

    /* renamed from: bU */
    public static final C1568b<Integer> f1728bU = m7007a("caching_operations_threads", 8);

    /* renamed from: bV */
    public static final C1568b<Long> f1729bV = m7007a("fullscreen_ad_pending_display_state_timeout_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(10)));

    /* renamed from: bW */
    public static final C1568b<Long> f1730bW = m7007a("fullscreen_ad_showing_state_timeout_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(2)));

    /* renamed from: bX */
    public static final C1568b<Boolean> f1731bX = m7007a("lhs_close_button_video", false);

    /* renamed from: bY */
    public static final C1568b<Integer> f1732bY = m7007a("close_button_right_margin_video", 4);

    /* renamed from: bZ */
    public static final C1568b<Integer> f1733bZ = m7007a("close_button_size_video", 30);

    /* renamed from: ca */
    public static final C1568b<Integer> f1786ca = m7007a("close_button_top_margin_video", 8);

    /* renamed from: cb */
    public static final C1568b<Boolean> f1787cb = m7007a("show_close_on_exit", true);

    /* renamed from: cc */
    public static final C1568b<Integer> f1788cc = m7007a("video_countdown_clock_margin", 10);

    /* renamed from: cd */
    public static final C1568b<Integer> f1789cd = m7007a("video_countdown_clock_gravity", 83);

    /* renamed from: ce */
    public static final C1568b<Integer> f1790ce = m7007a("countdown_clock_size", 32);

    /* renamed from: cf */
    public static final C1568b<Integer> f1791cf = m7007a("countdown_clock_stroke_size", 4);

    /* renamed from: cg */
    public static final C1568b<Integer> f1792cg = m7007a("countdown_clock_text_size", 28);

    /* renamed from: ch */
    public static final C1568b<Boolean> f1793ch = m7007a("draw_countdown_clock", true);

    /* renamed from: ci */
    public static final C1568b<Boolean> f1794ci = m7007a("force_back_button_enabled_always", false);

    /* renamed from: cj */
    public static final C1568b<Boolean> f1795cj = m7007a("force_back_button_enabled_close_button", false);

    /* renamed from: ck */
    public static final C1568b<Boolean> f1796ck = m7007a("force_back_button_enabled_poststitial", false);

    /* renamed from: cl */
    public static final C1568b<Long> f1797cl = m7007a("inter_display_delay", 200L);

    /* renamed from: cm */
    public static final C1568b<Boolean> f1798cm = m7007a("lock_specific_orientation", false);

    /* renamed from: cn */
    public static final C1568b<Boolean> f1799cn = m7007a("lhs_skip_button", true);

    /* renamed from: co */
    public static final C1568b<String> f1800co = m7007a("soft_buttons_resource_id", "config_showNavigationBar");

    /* renamed from: cp */
    public static final C1568b<Boolean> f1801cp = m7007a("countdown_toggleable", false);

    /* renamed from: cq */
    public static final C1568b<Boolean> f1802cq = m7007a("track_app_killed", false);

    /* renamed from: cr */
    public static final C1568b<Boolean> f1803cr = m7007a("mute_controls_enabled", false);

    /* renamed from: cs */
    public static final C1568b<Boolean> f1804cs = m7007a("allow_user_muting", true);

    /* renamed from: ct */
    public static final C1568b<Boolean> f1805ct = m7007a("mute_videos", false);

    /* renamed from: cu */
    public static final C1568b<Boolean> f1806cu = m7007a("show_mute_by_default", false);

    /* renamed from: cv */
    public static final C1568b<Boolean> f1807cv = m7007a("mute_with_user_settings", true);

    /* renamed from: cw */
    public static final C1568b<Integer> f1808cw = m7007a("mute_button_size", 32);

    /* renamed from: cx */
    public static final C1568b<Integer> f1809cx = m7007a("mute_button_margin", 10);

    /* renamed from: cy */
    public static final C1568b<Integer> f1810cy = m7007a("mute_button_gravity", 85);

    /* renamed from: cz */
    public static final C1568b<Boolean> f1811cz = m7007a("video_immersive_mode_enabled", false);

    /* renamed from: cA */
    public static final C1568b<Long> f1760cA = m7007a("progress_bar_step", 25L);

    /* renamed from: cB */
    public static final C1568b<Integer> f1761cB = m7007a("progress_bar_scale", 10000);

    /* renamed from: cC */
    public static final C1568b<Integer> f1762cC = m7007a("progress_bar_vertical_padding", -8);

    /* renamed from: cD */
    public static final C1568b<Long> f1763cD = m7007a("video_resume_delay", 250L);

    /* renamed from: cE */
    public static final C1568b<Boolean> f1764cE = m7007a("is_video_skippable", false);

    /* renamed from: cF */
    public static final C1568b<Integer> f1765cF = m7007a("vs_buffer_indicator_size", 50);

    /* renamed from: cG */
    public static final C1568b<Boolean> f1766cG = m7007a("video_zero_length_as_computed", false);

    /* renamed from: cH */
    public static final C1568b<Long> f1767cH = m7007a("set_poststitial_muted_initial_delay_ms", 500L);

    /* renamed from: cI */
    public static final C1568b<Integer> f1768cI = m7007a("minepsv", -1);

    /* renamed from: cJ */
    public static final C1568b<Integer> f1769cJ = m7007a("maxepsv", -1);

    /* renamed from: cK */
    public static final C1568b<Boolean> f1770cK = m7007a("pctfnc", false);

    /* renamed from: cL */
    public static final C1568b<Integer> f1771cL = m7007a("submit_postback_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(10)));

    /* renamed from: cM */
    public static final C1568b<Integer> f1772cM = m7007a("submit_postback_retries", 4);

    /* renamed from: cN */
    public static final C1568b<Integer> f1773cN = m7007a("max_postback_attempts", 3);

    /* renamed from: cO */
    public static final C1568b<Boolean> f1774cO = m7007a("fppopq", false);

    /* renamed from: cP */
    public static final C1568b<Boolean> f1775cP = m7007a("retry_on_all_errors", false);

    /* renamed from: cQ */
    public static final C1568b<Integer> f1776cQ = m7007a("get_retry_delay_v1", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(10)));

    /* renamed from: cR */
    public static final C1568b<Integer> f1777cR = m7007a("http_connection_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(30)));

    /* renamed from: cS */
    public static final C1568b<Integer> f1778cS = m7007a("http_socket_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(20)));

    /* renamed from: cT */
    public static final C1568b<Boolean> f1779cT = m7007a("force_ssl", false);

    /* renamed from: cU */
    public static final C1568b<Integer> f1780cU = m7007a("fetch_ad_connection_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(30)));

    /* renamed from: cV */
    public static final C1568b<Integer> f1781cV = m7007a("fetch_ad_retry_count_v1", 1);

    /* renamed from: cW */
    public static final C1568b<Boolean> f1782cW = m7007a("faer", false);

    /* renamed from: cX */
    public static final C1568b<Boolean> f1783cX = m7007a("faroae", false);

    /* renamed from: cY */
    public static final C1568b<Integer> f1784cY = m7007a("submit_data_retry_count_v1", 1);

    /* renamed from: cZ */
    public static final C1568b<Integer> f1785cZ = m7007a("response_buffer_size", Integer.valueOf((int) AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND));

    /* renamed from: da */
    public static final C1568b<Integer> f1838da = m7007a("fetch_basic_settings_connection_timeout_ms", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(10)));

    /* renamed from: db */
    public static final C1568b<Integer> f1839db = m7007a("fetch_basic_settings_retry_count", 3);

    /* renamed from: dc */
    public static final C1568b<Boolean> f1840dc = m7007a("fetch_basic_settings_on_reconnect", false);

    /* renamed from: dd */
    public static final C1568b<Boolean> f1841dd = m7007a("skip_fetch_basic_settings_if_not_connected", false);

    /* renamed from: de */
    public static final C1568b<Integer> f1842de = m7007a("fetch_basic_settings_retry_delay_ms", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(2)));

    /* renamed from: df */
    public static final C1568b<Integer> f1843df = m7007a("fetch_variables_connection_timeout_ms", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(5)));

    /* renamed from: dg */
    public static final C1568b<Boolean> f1844dg = m7007a("idflrwbe", false);

    /* renamed from: dh */
    public static final C1568b<Boolean> f1845dh = m7007a("falawpr", false);

    /* renamed from: di */
    public static final C1568b<Boolean> f1846di = m7007a("sort_query_parameters", false);

    /* renamed from: dj */
    public static final C1568b<Long> f1847dj = m7007a("communicator_request_timeout_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(10)));

    /* renamed from: dk */
    public static final C1568b<Integer> f1848dk = m7007a("communicator_request_retry_count", 3);

    /* renamed from: dl */
    public static final C1568b<Long> f1849dl = m7007a("communicator_request_retry_delay_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(2)));

    /* renamed from: dm */
    public static final C1568b<Integer> f1850dm = m7007a("ad_session_minutes", 60);

    /* renamed from: dn */
    public static final C1568b<Boolean> f1851dn = m7007a("session_tracking_cooldown_on_event_fire", true);

    /* renamed from: do */
    public static final C1568b<Long> f1852do = m7007a("session_tracking_resumed_cooldown_minutes", 90L);

    /* renamed from: dp */
    public static final C1568b<Long> f1853dp = m7007a("session_tracking_paused_cooldown_minutes", 90L);

    /* renamed from: dq */
    public static final C1568b<Boolean> f1854dq = m7007a("qq", false);

    /* renamed from: dr */
    public static final C1568b<Boolean> f1855dr = m7007a("qq1", true);

    /* renamed from: ds */
    public static final C1568b<Boolean> f1856ds = m7007a("qq3", true);

    /* renamed from: dt */
    public static final C1568b<Boolean> f1857dt = m7007a("qq4", true);

    /* renamed from: du */
    public static final C1568b<Boolean> f1858du = m7007a("qq5", true);

    /* renamed from: dv */
    public static final C1568b<Boolean> f1859dv = m7007a("qq6", true);

    /* renamed from: dw */
    public static final C1568b<Boolean> f1860dw = m7007a("qq7", true);

    /* renamed from: dx */
    public static final C1568b<Boolean> f1861dx = m7007a("qq8", true);

    /* renamed from: dy */
    public static final C1568b<Boolean> f1862dy = m7007a("pui", true);

    /* renamed from: dz */
    public static final C1568b<String> f1863dz = m7007a("plugin_version", "");

    /* renamed from: dA */
    public static final C1568b<Boolean> f1812dA = m7007a("hgn", false);

    /* renamed from: dB */
    public static final C1568b<Boolean> f1813dB = m7007a("cso", false);

    /* renamed from: dC */
    public static final C1568b<Boolean> f1814dC = m7007a("cfs", false);

    /* renamed from: dD */
    public static final C1568b<Boolean> f1815dD = m7007a("cmi", false);

    /* renamed from: dE */
    public static final C1568b<Boolean> f1816dE = m7007a("crat", false);

    /* renamed from: dF */
    public static final C1568b<Boolean> f1817dF = m7007a("cvs", false);

    /* renamed from: dG */
    public static final C1568b<Boolean> f1818dG = m7007a("caf", false);

    /* renamed from: dH */
    public static final C1568b<Boolean> f1819dH = m7007a("cf", false);

    /* renamed from: dI */
    public static final C1568b<Boolean> f1820dI = m7007a("cnr", false);

    /* renamed from: dJ */
    public static final C1568b<Boolean> f1821dJ = m7007a("adr", false);

    /* renamed from: dK */
    public static final C1568b<Float> f1822dK = m7007a("volume_normalization_factor", Float.valueOf(6.6666665f));

    /* renamed from: dL */
    public static final C1568b<Boolean> f1823dL = m7007a("system_user_agent_collection_enabled", false);

    /* renamed from: dM */
    public static final C1568b<Boolean> f1824dM = m7007a("user_agent_collection_enabled", false);

    /* renamed from: dN */
    public static final C1568b<Boolean> f1825dN = m7007a("http_headers_collection_enabled", false);

    /* renamed from: dO */
    public static final C1568b<String> f1826dO = m7007a("webview_package_name", "com.google.android.webview");

    /* renamed from: dP */
    public static final C1568b<Boolean> f1827dP = m7007a("collect_device_angle", false);

    /* renamed from: dQ */
    public static final C1568b<Boolean> f1828dQ = m7007a("collect_device_movement", false);

    /* renamed from: dR */
    public static final C1568b<Float> f1829dR = m7007a("movement_degradation", Float.valueOf(0.75f));

    /* renamed from: dS */
    public static final C1568b<Integer> f1830dS = m7007a("device_sensor_period_ms", 250);

    /* renamed from: dT */
    public static final C1568b<Boolean> f1831dT = m7007a("dte", true);

    /* renamed from: dU */
    public static final C1568b<Boolean> f1832dU = m7007a("idcw", false);

    /* renamed from: dV */
    public static final C1568b<Long> f1833dV = m7007a("anr_debug_thread_refresh_time_ms", -1L);

    /* renamed from: dW */
    public static final C1568b<Boolean> f1834dW = m7007a("is_track_ad_info", true);

    /* renamed from: dX */
    public static final C1568b<Boolean> f1835dX = m7007a("submit_ad_stats_enabled", false);

    /* renamed from: dY */
    public static final C1568b<Integer> f1836dY = m7007a("submit_ad_stats_connection_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(30)));

    /* renamed from: dZ */
    public static final C1568b<Integer> f1837dZ = m7007a("submit_ad_stats_retry_count", 1);

    /* renamed from: ea */
    public static final C1568b<Integer> f1890ea = m7007a("submit_ad_stats_max_count", 500);

    /* renamed from: eb */
    public static final C1568b<Boolean> f1891eb = m7007a("asdm", false);

    /* renamed from: ec */
    public static final C1568b<String> f1892ec = m7007a("vast_image_html", "<html><head><style>html,body{height:100%;width:100%}body{background-image:url({SOURCE});background-repeat:no-repeat;background-size:contain;background-position:center;}a{position:absolute;top:0;bottom:0;left:0;right:0}</style></head><body><a href=\"applovin://com.applovin.sdk/adservice/track_click_now\"></a></body></html>");

    /* renamed from: ed */
    public static final C1568b<String> f1893ed = m7007a("vast_link_html", "<html><head><style>html,body,iframe{height:100%;width:100%;}body{margin:0}iframe{border:0;overflow:hidden;position:absolute}</style></head><body><iframe src={SOURCE} frameborder=0></iframe></body></html>");

    /* renamed from: ee */
    public static final C1568b<Integer> f1894ee = m7007a("vast_max_response_length", 640000);

    /* renamed from: ef */
    public static final C1568b<Integer> f1895ef = m7007a("vast_max_wrapper_depth", 5);

    /* renamed from: eg */
    public static final C1568b<Long> f1896eg = m7007a("vast_progress_tracking_countdown_step", Long.valueOf(TimeUnit.SECONDS.toMillis(1)));

    /* renamed from: eh */
    public static final C1568b<String> f1897eh = m7007a("vast_unsupported_video_extensions", "ogv,flv");

    /* renamed from: ei */
    public static final C1568b<String> f1898ei = m7007a("vast_unsupported_video_types", "video/ogg,video/x-flv");

    /* renamed from: ej */
    public static final C1568b<Boolean> f1899ej = m7007a("vast_validate_with_extension_if_no_video_type", true);

    /* renamed from: ek */
    public static final C1568b<Integer> f1900ek = m7007a("vast_video_selection_policy", Integer.valueOf(C1143j.EnumC1145a.MEDIUM.ordinal()));

    /* renamed from: el */
    public static final C1568b<Integer> f1901el = m7007a("vast_wrapper_resolution_retry_count_v1", 1);

    /* renamed from: em */
    public static final C1568b<Integer> f1902em = m7007a("vast_wrapper_resolution_connection_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(30)));

    /* renamed from: en */
    public static final C1568b<Boolean> f1903en = m7007a("ree", true);

    /* renamed from: eo */
    public static final C1568b<Boolean> f1904eo = m7007a("btee", true);

    /* renamed from: ep */
    public static final C1568b<Long> f1905ep = m7007a("server_timestamp_ms", 0L);

    /* renamed from: eq */
    public static final C1568b<Long> f1906eq = m7007a("device_timestamp_ms", 0L);

    /* renamed from: er */
    public static final C1568b<Integer> f1907er = m7007a("gzip_min_length", 0);

    /* renamed from: es */
    public static final C1568b<Boolean> f1908es = m7007a("gzip_encoding_default", false);

    /* renamed from: et */
    public static final C1568b<Boolean> f1909et = m7007a("fetch_settings_gzip", false);

    /* renamed from: eu */
    public static final C1568b<Boolean> f1910eu = m7007a("device_init_gzip", false);

    /* renamed from: ev */
    public static final C1568b<Boolean> f1911ev = m7007a("fetch_ad_gzip", false);

    /* renamed from: ew */
    public static final C1568b<Boolean> f1912ew = m7007a("event_tracking_gzip", false);

    /* renamed from: ex */
    public static final C1568b<Boolean> f1913ex = m7007a("submit_ad_stats_gzip", false);

    /* renamed from: ey */
    public static final C1568b<Boolean> f1914ey = m7007a("reward_postback_gzip", false);

    /* renamed from: ez */
    public static final C1568b<Boolean> f1915ez = m7007a("zt_flush_gzip", false);

    /* renamed from: eA */
    public static final C1568b<Boolean> f1864eA = m7007a("force_rerender", false);

    /* renamed from: eB */
    public static final C1568b<Boolean> f1865eB = m7007a("daostr", false);

    /* renamed from: eC */
    public static final C1568b<Boolean> f1866eC = m7007a("tctlaa", false);

    /* renamed from: eD */
    public static final C1568b<Boolean> f1867eD = m7007a("rwvdv", false);

    /* renamed from: eE */
    public static final C1568b<Boolean> f1868eE = m7007a("handle_render_process_gone", true);

    /* renamed from: eF */
    public static final C1568b<Boolean> f1869eF = m7007a("comcr", true);

    /* renamed from: eG */
    public static final C1568b<Boolean> f1870eG = m7007a("gcoas", false);

    /* renamed from: eH */
    public static final C1568b<Boolean> f1871eH = m7007a("teorpc", false);

    /* renamed from: eI */
    public static final C1568b<Boolean> f1872eI = m7007a("rmpibt", false);

    /* renamed from: eJ */
    public static final C1568b<Boolean> f1873eJ = m7007a("spbcioa", false);

    /* renamed from: eK */
    public static final C1568b<Boolean> f1874eK = m7007a("set_webview_render_process_client", false);

    /* renamed from: eL */
    public static final C1568b<Boolean> f1875eL = m7007a("disable_webview_hardware_acceleration", false);

    /* renamed from: eM */
    public static final C1568b<Integer> f1876eM = m7007a("mmbfas", -1);

    /* renamed from: eN */
    public static final C1568b<Boolean> f1877eN = m7007a("fvrunc", false);

    /* renamed from: eO */
    public static final C1568b<Boolean> f1878eO = m7007a("dsaovcf", false);

    /* renamed from: eP */
    public static final C1568b<Boolean> f1879eP = m7007a("daoar", false);

    /* renamed from: eQ */
    public static final C1568b<String> f1880eQ = m7007a("config_consent_dialog_state", "unknown");

    /* renamed from: eR */
    public static final C1568b<String> f1881eR = m7007a("country_code", "");

    /* renamed from: eS */
    public static final C1568b<String> f1882eS = m7007a("c_sticky_topics", "user_engagement_sdk_init,adjust_init,safedk_init,discovery_init,max_ad_events,send_http_request,adapter_initialization_status,privacy_setting_updated,network_sdk_version_updated");

    /* renamed from: eT */
    public static final C1568b<Boolean> f1883eT = m7007a("zt_enabled", true);

    /* renamed from: eU */
    public static final C1568b<String> f1884eU = m7007a("zt_endpoint", "https://a.applovin.com/");

    /* renamed from: eV */
    public static final C1568b<String> f1885eV = m7007a("zt_backup_endpoint", "https://a.applvn.com/");

    /* renamed from: eW */
    public static final C1568b<Integer> f1886eW = m7007a("zt_timeout_ms", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(10)));

    /* renamed from: eX */
    public static final C1568b<Long> f1887eX = m7007a("zt_flush_interval_s", -1L);

    /* renamed from: eY */
    public static final C1568b<Boolean> f1888eY = m7007a("zt_bg_aware_timer", true);

    /* renamed from: eZ */
    public static final C1568b<Boolean> f1889eZ = m7007a("zt_flush_on_impression", true);

    /* renamed from: fa */
    public static final C1568b<Boolean> f1916fa = m7007a("zt_flush_on_app_bg", false);

    /* renamed from: fb */
    public static final C1568b<Boolean> f1917fb = m7007a("zt_continue_through_error", true);

    public C1568b(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified");
        }
        if (t == null) {
            throw new IllegalArgumentException("No default value specified");
        }
        this.f1918c = str;
        this.f1919d = t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static <T> C1568b<T> m7007a(String str, T t) {
        if (t != null) {
            if (!f1654a.contains(t.getClass())) {
                throw new IllegalArgumentException("Unsupported value type: " + t.getClass());
            }
            C1568b<T> c1568b = new C1568b<>(str, t);
            Map<String, C1568b<?>> map = f1707b;
            if (!map.containsKey(str)) {
                map.put(str, c1568b);
                return c1568b;
            }
            throw new IllegalArgumentException("Setting has already been used: " + str);
        }
        throw new IllegalArgumentException("No default value specified");
    }

    /* renamed from: c */
    public static Collection<C1568b<?>> m7005c() {
        return Collections.synchronizedCollection(f1707b.values());
    }

    /* renamed from: a */
    public T m7008a(Object obj) {
        return (T) this.f1919d.getClass().cast(obj);
    }

    /* renamed from: a */
    public String m7009a() {
        return this.f1918c;
    }

    /* renamed from: b */
    public T m7006b() {
        return this.f1919d;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof C1568b) {
            return this.f1918c.compareTo(((C1568b) obj).m7009a());
        }
        return 0;
    }
}
