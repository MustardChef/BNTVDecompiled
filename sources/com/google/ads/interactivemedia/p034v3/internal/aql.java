package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.blankj.utilcode.constant.TimeConstants;
import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.concurrent.TimeUnit;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aql */
/* loaded from: classes2.dex */
public final class aql {

    /* renamed from: a */
    public static final aqf f4888a;

    /* renamed from: b */
    public static final aqf f4889b;

    /* renamed from: c */
    public static final aqf f4890c;

    /* renamed from: d */
    public static final aqf f4891d;

    /* renamed from: e */
    public static final aqf f4892e;

    /* renamed from: f */
    public static final aqf f4893f;

    /* renamed from: g */
    public static final aqf f4894g;

    /* renamed from: h */
    public static final aqf f4895h;

    /* renamed from: i */
    public static final aqn f4896i;

    /* renamed from: j */
    public static final aqf f4897j;

    /* renamed from: k */
    public static final aqf f4898k;

    /* renamed from: l */
    public static final aqf f4899l;

    /* renamed from: m */
    public static final aqf f4900m;

    /* renamed from: n */
    public static final aqf f4901n;

    /* renamed from: o */
    public static final aqf f4902o;

    /* renamed from: p */
    public static final aqf f4903p;

    /* renamed from: q */
    public static final aqf f4904q;

    /* renamed from: r */
    public static final aqf f4905r;

    /* renamed from: s */
    public static final aqf f4906s;

    /* renamed from: t */
    public static final aqf f4907t;

    /* renamed from: u */
    public static final aqf f4908u;

    /* renamed from: v */
    public static final aqf f4909v;

    /* renamed from: w */
    public static final aqf f4910w;

    static {
        aqf.m4764l("gads:sdk_core_location:client:html", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/production/sdk-core-v40-impl.html");
        aqf.m4764l("gads:active_view_location:html", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/production/sdk-core-v40-impl.html");
        aqn aqnVar = aqp.f4915a;
        aqf.m4766j("gads:http_url_connection_factory:timeout_millis", 10000);
        aqf.m4764l("gads:video_exo_player:version", "3");
        aqf.m4766j("gads:video_exo_player:connect_timeout", 8000);
        aqf.m4766j("gads:video_exo_player:read_timeout", 8000);
        aqf.m4766j("gads:video_exo_player:loading_check_interval", 1048576);
        aqf.m4766j("gads:video_exo_player:exo_player_precache_limit", Integer.MAX_VALUE);
        aqf.m4766j("gads:video_exo_player:byte_buffer_precache_limit", Integer.MAX_VALUE);
        aqf.m4766j("gads:video_exo_player_socket_receive_buffer_size", 0);
        aqf.m4766j("gads:video_exo_player:min_retry_count", -1);
        aqf.m4771e(1, "gads:video_exo_player:fmp4_extractor_enabled", true);
        aqf.m4771e(1, "gads:video_exo_player:use_play_back_info_for_should_start_play_back", false);
        aqf.m4771e(1, "gads:video_exo_player:treat_load_exception_as_non_fatal", true);
        aqf.m4766j("gads:video_stream_cache:limit_count", 5);
        aqf.m4766j("gads:video_stream_cache:limit_space", 8388608);
        aqf.m4766j("gads:video_stream_exo_cache:buffer_size", 8388608);
        aqf.m4765k("gads:video_stream_cache:limit_time_sec", 300L);
        aqf.m4765k("gads:video_stream_cache:notify_interval_millis", 125L);
        aqf.m4766j("gads:video_stream_cache:connect_timeout_millis", 10000);
        aqf.m4764l("gads:video:metric_frame_hash_times", "");
        aqf.m4765k("gads:video:metric_frame_hash_time_leniency", 500L);
        aqf.m4771e(1, "gads:video:force_watermark", false);
        aqf.m4765k("gads:video:surface_update_min_spacing_ms", 1000L);
        aqf.m4771e(1, "gads:video:spinner:enabled", false);
        aqf.m4771e(1, "gads:video:shutter:enabled", false);
        aqf.m4766j("gads:video:spinner:scale", 4);
        aqf.m4765k("gads:video:spinner:jank_threshold_ms", 50L);
        aqf.m4771e(1, "gads:video:aggressive_media_codec_release", false);
        aqf.m4771e(1, "gads:memory_bundle:debug_info", false);
        aqf.m4764l("gads:video:codec_query_mime_types", "");
        aqf.m4766j("gads:video:codec_query_minimum_version", 16);
        aqf.m4764l("gad:mraid:url_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/production/mraid/v3/mraid_app_banner.js");
        aqf.m4764l("gad:mraid:url_expanded_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/production/mraid/v3/mraid_app_expanded_banner.js");
        aqf.m4764l("gad:mraid:url_interstitial", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/production/mraid/v3/mraid_app_interstitial.js");
        aqf.m4764l("gad:mraid:version", "3.0");
        aqf.m4771e(1, "gads:mraid:expanded_interstitial_fix", false);
        aqf.m4771e(1, "gads:mraid:initial_size_fallback", false);
        aqf.m4766j("gads:content_vertical_fingerprint_number", 100);
        aqf.m4766j("gads:content_vertical_fingerprint_bits", 23);
        aqf.m4766j("gads:content_vertical_fingerprint_ngram", 3);
        aqf.m4764l("gads:content_fetch_view_tag_id", "googlebot");
        aqf.m4764l("gads:content_fetch_exclude_view_tag", "none");
        aqf.m4771e(1, "gads:content_fetch_disable_get_title_from_webview", false);
        aqf.m4771e(1, "gads:content_fetch_enable_new_content_score", false);
        aqf.m4771e(1, "gads:content_fetch_enable_serve_once", false);
        aqf.m4771e(1, "gads:sai:enabled", true);
        aqf.m4764l("gads:sai:click_ping_schema_v2", "^[^?]*(/aclk\\?|/pcs/click\\?).*");
        aqf.m4764l("gads:sai:impression_ping_schema_v2", "^[^?]*(/adview|/pcs/view).*");
        aqf.m4771e(1, "gads:sai:using_macro:enabled", false);
        aqf.m4764l("gads:sai:ad_event_id_macro_name", "[gw_fbsaeid]");
        aqf.m4765k("gads:sai:timeout_ms", -1L);
        aqf.m4766j("gads:sai:scion_thread_pool_size", 5);
        aqf.m4771e(1, "gads:sai:app_measurement_enabled3", false);
        aqf.m4766j("gads:sai:app_measurement_min_client_dynamite_version", 20290);
        aqf.m4771e(1, "gads:sai:force_through_reflection", true);
        aqf.m4771e(1, "gads:sai:gmscore_availability_check_disabled", false);
        aqf.m4771e(1, "gads:sai:logging_disabled_for_drx", false);
        aqf.m4771e(1, "gads:sai:app_measurement_npa_enabled", false);
        aqf.m4771e(1, "gads:idless:idless_disables_attestation", true);
        aqf.m4771e(1, "gads:idless:app_measurement_idless_enabled", true);
        aqf.m4771e(1, "gads:sai:server_side_npa:disable_writing", false);
        aqf.m4771e(1, "gads:sai:server_side_npa:enabled", false);
        aqf.m4765k("gads:sai:server_side_npa:ttl", TimeUnit.DAYS.toMillis(90L));
        aqf.m4764l("gads:sai:server_side_npa:shared_preference_key_list", "{  \"__default__\": [    \"IABTCF_TCString\"  ],  \"mobileads_consent\": [    \"consent_string\"  ]}");
        aqf.m4771e(1, "gads:idless:internal_state_enabled", true);
        aqf.m4771e(1, "gads:idless:idless_disables_offline_ads_signalling", true);
        aqf.m4771e(1, "gads:custom_idless:enabled", false);
        aqf.m4764l("gads:idless:cookie_modification", "=; Max-Age=-1; path=/; domain=.doubleclick.net");
        aqf.m4771e(1, "gads:tfcd_deny_ad_storage:enabled", false);
        aqf.m4771e(1, "gads:tfua_deny_ad_storage:enabled", false);
        aqf.m4771e(1, "gads:interstitial:app_must_be_foreground:enabled", false);
        aqf.m4771e(1, "gads:interstitial:foreground_report:enabled", false);
        aqf.m4771e(1, "gads:interstitial:default_immersive", false);
        aqf.m4766j("gads:show_interstitial_with_context:min_version", 204890000);
        aqf.m4771e(1, "gads:webview:error_web_response:enabled", false);
        aqf.m4771e(1, "gads:webview:set_fixed_text_zoom", true);
        aqf.m4771e(1, "gads:webviewgone:kill_process:enabled", false);
        aqf.m4771e(1, "gads:webviewgone:new_onshow:enabled", false);
        aqf.m4764l("gads:webview_cookie_url", "googleads.g.doubleclick.net");
        aqf.m4771e(1, "gads:new_rewarded_ad:enabled", true);
        aqf.m4771e(1, "gads:rewarded:adapter_initialization_enabled", false);
        aqf.m4771e(1, "gads:rewarded:ad_metadata_enabled", false);
        aqf.m4765k("gads:app_activity_tracker:notify_background_listeners_delay_ms", 500L);
        aqf.m4765k("gads:app_activity_tracker:app_session_timeout_ms", TimeUnit.MINUTES.toMillis(5L));
        aqf.m4771e(1, "gads:adid_values_in_adrequest:enabled", false);
        aqf.m4765k("gads:adid_values_in_adrequest:timeout", ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        aqf.m4771e(1, "gads:disable_adid_values_in_ms", false);
        aqf.m4765k("gads:ad_overlay:delay_page_close_timeout_ms", 5000L);
        aqf.m4771e(1, "gads:custom_close_blocking:enabled", false);
        aqf.m4771e(1, "gads:disabling_closable_area:enabled", false);
        aqf.m4771e(1, "gads:force_top_right_close_button:enabled", false);
        aqf.m4764l("gads:close_button_asset_name", MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY);
        aqf.m4765k("gads:close_button_fade_in_duration_ms", 0L);
        aqf.m4771e(1, "gads:disable_click_during_fade_in", false);
        aqf.m4771e(1, "gads:use_system_ui_for_fullscreen:enabled", false);
        aqf.m4771e(1, "gads:ad_overlay:collect_cutout_info:enabled", false);
        aqf.m4764l("gads:spherical_video:vertex_shader", "");
        aqf.m4764l("gads:spherical_video:fragment_shader", "");
        aqf.m4771e(1, "gads:include_local_global_rectangles", false);
        aqf.m4765k("gads:position_watcher:throttle_ms", 200L);
        aqf.m4765k("gads:position_watcher:scroll_aware_throttle_ms", 33L);
        aqf.m4771e(1, "gads:position_watcher:enable_scroll_aware_ads", false);
        aqf.m4771e(1, "gads:position_watcher:send_scroll_data", false);
        aqf.m4771e(1, "gads:gen204_signals:enabled", false);
        aqf.m4764l("gads:logged_adapter_version_classes", "");
        aqf.m4765k("gads:rtb_v1_1:signal_timeout_ms", 1000L);
        aqf.m4764l("gads:rtb_logging:regex", "(?!)");
        aqf.m4771e(1, "gads:presentation_error:urls_enabled", true);
        aqf.m4771e(1, "gads:rtb_interstitial:use_fullscreen_monitor", true);
        aqf.m4771e(1, "gads:native_required_assets:enabled", false);
        aqf.m4771e(1, "gads:native_required_assets:check_inner_mediaview:enabled", true);
        aqf.m4766j("gads:native_ad_options_rtb:min_version", 204890000);
        aqf.m4771e(1, "gads:track_view_next_runloop:enabled", false);
        aqf.m4771e(1, "gads:synchronize_measurement_listener:enabled", false);
        aqf.m4771e(1, "gads:native_required_assets:viewability:enabled", false);
        aqf.m4771e(1, "gads:signal_adapters:enabled", false);
        aqf.m4766j("gads:adapter_initialization:min_sdk_version", 15301000);
        aqf.m4765k("gads:adapter_initialization:timeout", 30L);
        aqf.m4765k("gads:adapter_initialization:cld_timeout", 10L);
        aqf.m4771e(1, "gads:additional_video_csi:enabled", false);
        aqf.m4771e(1, "gads:using_official_simple_exoplayer:enabled", false);
        aqf.m4771e(1, "gads:multiple_video_playback:enabled", false);
        aqf.m4771e(1, "gads:video:use_range_http_data_source", false);
        aqf.m4765k("gads:video:range_http_data_source_high_water_mark", 614400L);
        aqf.m4765k("gads:video:range_http_data_source_low_water_mark", 102400L);
        aqf.m4771e(1, "gads:run_exoplayer_video_stream_task_in_ui_thread:enabled", false);
        aqf.m4771e(1, "gads:csi:enabled_per_sampling", false);
        aqf.m4771e(1, "gads:always_set_transfer_listener:enabled", false);
        aqf.m4771e(1, "gads:initialization_csi:enabled", false);
        aqf.m4771e(1, "gads:msa:experiments:enabled", false);
        f4888a = aqf.m4771e(1, "gads:msa:experiments:ps:enabled", true);
        aqf.m4771e(1, "gads:msa:experiments:fb:enabled", true);
        f4889b = aqf.m4771e(1, "gads:msa:experiments:ps:er", true);
        aqf.m4766j("gads:gestures:a2:enabled", 0);
        aqf.m4771e(1, "gads:msa:experiments:a2", false);
        f4890c = aqf.m4771e(1, "gads:msa:experiments:log", false);
        aqf.m4771e(1, "gads:msa:experiments:vfb", true);
        f4891d = aqf.m4771e(1, "gads:msa:experiments:incapi:enabled", false);
        f4892e = aqf.m4771e(1, "gads:msa:experiments:incapigass:enabled", false);
        f4893f = aqf.m4764l("gads:msa:experiments:incapi:trusted_cert", "308204433082032ba003020102020900c2e08746644a308d300d06092a864886f70d01010405003074310b3009060355040613025553311330110603550408130a43616c69666f726e6961311630140603550407130d4d6f756e7461696e205669657731143012060355040a130b476f6f676c6520496e632e3110300e060355040b1307416e64726f69643110300e06035504031307416e64726f6964301e170d3038303832313233313333345a170d3336303130373233313333345a3074310b3009060355040613025553311330110603550408130a43616c69666f726e6961311630140603550407130d4d6f756e7461696e205669657731143012060355040a130b476f6f676c6520496e632e3110300e060355040b1307416e64726f69643110300e06035504031307416e64726f696430820120300d06092a864886f70d01010105000382010d00308201080282010100ab562e00d83ba208ae0a966f124e29da11f2ab56d08f58e2cca91303e9b754d372f640a71b1dcb130967624e4656a7776a92193db2e5bfb724a91e77188b0e6a47a43b33d9609b77183145ccdf7b2e586674c9e1565b1f4c6a5955bff251a63dabf9c55c27222252e875e4f8154a645f897168c0b1bfc612eabf785769bb34aa7984dc7e2ea2764cae8307d8c17154d7ee5f64a51a44a602c249054157dc02cd5f5c0e55fbef8519fbe327f0b1511692c5a06f19d18385f5c4dbc2d6b93f68cc2979c70e18ab93866b3bd5db8999552a0e3b4c99df58fb918bedc182ba35e003c1b4b10dd244a8ee24fffd333872ab5221985edab0fc0d0b145b6aa192858e79020103a381d93081d6301d0603551d0e04160414c77d8cc2211756259a7fd382df6be398e4d786a53081a60603551d2304819e30819b8014c77d8cc2211756259a7fd382df6be398e4d786a5a178a4763074310b3009060355040613025553311330110603550408130a43616c69666f726e6961311630140603550407130d4d6f756e7461696e205669657731143012060355040a130b476f6f676c6520496e632e3110300e060355040b1307416e64726f69643110300e06035504031307416e64726f6964820900c2e08746644a308d300c0603551d13040530030101ff300d06092a864886f70d010104050003820101006dd252ceef85302c360aaace939bcff2cca904bb5d7a1661f8ae46b2994204d0ff4a68c7ed1a531ec4595a623ce60763b167297a7ae35712c407f208f0cb109429124d7b106219c084ca3eb3f9ad5fb871ef92269a8be28bf16d44c8d9a08e6cb2f005bb3fe2cb96447e868e731076ad45b33f6009ea19c161e62641aa99271dfd5228c5c587875ddb7f452758d661f6cc0cccb7352e424cc4365c523532f7325137593c4ae341f4db41edda0d0b1071a7c440f0fe9ea01cb627ca674369d084bd2fd911ff06cdbf2cfa10dc0f893ae35762919048c7efc64c7144178342f70581c9de573af55b390dd7fdb9418631895d5f759f30112687ff621410c069308a");
        f4894g = aqf.m4764l("gads:msa:experiments:incapi:debug_cert", "308204a830820390a003020102020900d585b86c7dd34ef5300d06092a864886f70d0101040500308194310b3009060355040613025553311330110603550408130a43616c69666f726e6961311630140603550407130d4d6f756e7461696e20566965773110300e060355040a1307416e64726f69643110300e060355040b1307416e64726f69643110300e06035504031307416e64726f69643122302006092a864886f70d0109011613616e64726f696440616e64726f69642e636f6d301e170d3038303431353233333635365a170d3335303930313233333635365a308194310b3009060355040613025553311330110603550408130a43616c69666f726e6961311630140603550407130d4d6f756e7461696e20566965773110300e060355040a1307416e64726f69643110300e060355040b1307416e64726f69643110300e06035504031307416e64726f69643122302006092a864886f70d0109011613616e64726f696440616e64726f69642e636f6d30820120300d06092a864886f70d01010105000382010d00308201080282010100d6ce2e080abfe2314dd18db3cfd3185cb43d33fa0c74e1bdb6d1db8913f62c5c39df56f846813d65bec0f3ca426b07c5a8ed5a3990c167e76bc999b927894b8f0b22001994a92915e572c56d2a301ba36fc5fc113ad6cb9e7435a16d23ab7dfaeee165e4df1f0a8dbda70a869d516c4e9d051196ca7c0c557f175bc375f948c56aae86089ba44f8aa6a4dd9a7dbf2c0a352282ad06b8cc185eb15579eef86d080b1d6189c0f9af98b1c2ebd107ea45abdb68a3c7838a5e5488c76c53d40b121de7bbd30e620c188ae1aa61dbbc87dd3c645f2f55f3d4c375ec4070a93f7151d83670c16a971abe5ef2d11890e1b8aef3298cf066bf9e6ce144ac9ae86d1c1b0f020103a381fc3081f9301d0603551d0e041604148d1cc5be954c433c61863a15b04cbc03f24fe0b23081c90603551d230481c13081be80148d1cc5be954c433c61863a15b04cbc03f24fe0b2a1819aa48197308194310b3009060355040613025553311330110603550408130a43616c69666f726e6961311630140603550407130d4d6f756e7461696e20566965773110300e060355040a1307416e64726f69643110300e060355040b1307416e64726f69643110300e06035504031307416e64726f69643122302006092a864886f70d0109011613616e64726f696440616e64726f69642e636f6d820900d585b86c7dd34ef5300c0603551d13040530030101ff300d06092a864886f70d0101040500038201010019d30cf105fb78923f4c0d7dd223233d40967acfce00081d5bd7c6e9d6ed206b0e11209506416ca244939913d26b4aa0e0f524cad2bb5c6e4ca1016a15916ea1ec5dc95a5e3a010036f49248d5109bbf2e1e618186673a3be56daf0b77b1c229e3c255e3e84c905d2387efba09cbf13b202b4e5a22c93263484a23d2fc29fa9f1939759733afd8aa160f4296c2d0163e8182859c6643e9c1962fa0c18333335bc090ff9a6b22ded1ad444229a539a94eefadabd065ced24b3e51e5dd7b66787bef12fe97fba484c423fb4ff8cc494c02f0f5051612ff6529393e8e46eac5bb21f277c151aa5f2aa627d1e89da70ab6033569de3b9897bfff7ca9da3e1243f60b");
        f4895h = aqf.m4771e(1, "gads:gestures:clearTd:enabled", false);
        f4896i = aqo.f4914a;
        f4897j = aqf.m4771e(1, "gads:gestures:errorlogging:enabled", false);
        f4898k = aqf.m4765k("gads:gestures:task_timeout", ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        f4899l = aqf.m4771e(1, "gads:gestures:asig:enabled", false);
        f4900m = aqf.m4771e(1, "gads:gestures:ans:enabled", false);
        f4901n = aqf.m4771e(1, "gads:gestures:tos:enabled", false);
        f4902o = aqf.m4771e(1, "gads:gestures:brt:enabled", true);
        f4903p = aqf.m4771e(1, "gads:gestures:fpi:enabled", false);
        aqf.m4771e(1, "gads:signal:app_permissions:disabled", false);
        aqf.m4771e(1, "gads:signal:app_set_id_info_in_ad_request:enabled", false);
        f4904q = aqf.m4771e(1, "gads:gestures:hpk:enabled", true);
        f4905r = aqf.m4764l("gads:gestures:pk", "");
        f4906s = aqf.m4771e(1, "gads:gestures:bs:enabled", true);
        f4907t = aqf.m4771e(1, "gads:gestures:check_initialization_thread:enabled", false);
        aqf.m4771e(1, "gads:gestures:init_new_thread:enabled", true);
        f4908u = aqf.m4771e(1, "gads:gestures:pds:enabled", true);
        aqf.m4766j("gads:gestures:as2percentage", 0);
        f4909v = aqf.m4771e(1, "gads:gestures:ns:enabled", true);
        f4910w = aqf.m4771e(1, "gads:gestures:vdd:enabled", false);
        aqf.m4771e(1, "gads:native:asset_view_touch_events", false);
        aqf.m4771e(1, "gads:native:set_touch_listener_on_asset_views", true);
        aqf.m4771e(1, "gads:ais:enabled", true);
        aqf.m4771e(1, "gads:stav:enabled", false);
        aqf.m4771e(1, "gads:spam:impression_ui_idle:enable", false);
        aqf.m4766j("gads:gass:impression_retry:count", 0);
        aqf.m4766j("gads:gass:impression_retry:delay_ms", 400);
        apz.m4779a().m4763a(aqf.m4764l("gads:sdk_core_constants:experiment_id", null));
        aqf.m4764l("gads:sdk_core_constants:caps", "");
        aqf.m4771e(1, "gads:js_flags:disable_phenotype", false);
        aqf.m4764l("gads:native:engine_url_with_protocol", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/native_ads.html");
        aqf.m4764l("gads:native:video_url_with_protocol", "https://imasdk.googleapis.com/admob/sdkloader/native_video.html");
        aqf.m4771e(1, "gads:native:get_native_ad_view_signals", false);
        aqf.m4766j("gads:native_video_load_timeout", 10);
        aqf.m4764l("gads:ad_choices_content_description", "Ad Choices Icon");
        aqf.m4771e(1, "gads:enable_singleton_broadcast_receiver", false);
        aqf.m4771e(1, "gads:native:media_view_match_parent:enabled", true);
        aqf.m4771e(1, "gads:video:restrict_inside_web_view:enabled", false);
        aqf.m4771e(1, "gads:native:count_impression_for_assets", false);
        aqf.m4771e(1, "gads:native:enable_enigma_watermarking", false);
        aqf.m4771e(1, "gads:fluid_ad:use_wrap_content_height", false);
        aqf.m4771e(1, "gads:rtb_v1_1:fetch_app_settings_using_cld:enabled", true);
        aqf.m4771e(1, "gads:get_request_signals_cld:enabled", true);
        aqf.m4771e(1, "gads:get_request_signals_common_cld:enabled", true);
        aqf.m4771e(1, "gads:rtb_v1_1:use_manifest_appid_cld:enabled", true);
        aqf.m4765k("gads:fetch_app_settings_using_cld:refresh_interval_ms", 7200000L);
        aqf.m4765k("gads:parental_controls:timeout", ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        aqf.m4766j("gads:cache:ad_request_timeout_millis", 250);
        aqf.m4766j("gads:cache:max_concurrent_downloads", 10);
        aqf.m4771e(1, "gads:cache:downloader_use_high_priority", false);
        aqf.m4765k("gads:cache:javascript_timeout_millis", 5000L);
        aqf.m4771e(1, "gads:cache:bind_on_foreground", false);
        aqf.m4771e(1, "gads:cache:bind_on_init", false);
        aqf.m4771e(1, "gads:cache:bind_on_request", false);
        aqf.m4765k("gads:cache:bind_on_request_keep_alive", TimeUnit.SECONDS.toMillis(30L));
        aqf.m4771e(1, "gads:cache:use_cache_data_source", false);
        aqf.m4771e(1, "gads:cache:connection_per_read", false);
        aqf.m4765k("gads:cache:connection_timeout", 5000L);
        aqf.m4765k("gads:cache:read_only_connection_timeout", 5000L);
        aqf.m4771e(1, "gads:cache:read_inner_data_source_if_gcache_miss", false);
        aqf.m4771e(1, "gads:cache:read_inner_data_source_if_gcache_not_downloaded", false);
        aqf.m4771e(1, "gads:cache:function_call_timeout_v1:enabled", false);
        aqf.m4765k("gads:cache:function_call_timeout", 5000L);
        aqf.m4771e(1, "gads:cache:add_itag_to_cache_key:enabled", false);
        aqf.m4771e(1, "gads:http_assets_cache:enabled", false);
        aqf.m4764l("gads:http_assets_cache:regex", "(?i)https:\\/\\/(tpc\\.googlesyndication\\.com\\/(.*)|lh\\d+\\.googleusercontent\\.com\\/(.*))");
        aqf.m4766j("gads:http_assets_cache:time_out", 100);
        aqf.m4771e(1, "gads:chrome_custom_tabs_browser:enabled", false);
        aqf.m4771e(1, "gads:chrome_custom_tabs:disabled", false);
        aqf.m4771e(1, "gads:chrome_custom_tabs_browser_v2:enabled", false);
        aqf.m4771e(1, "gads:cct_v2_connection:enabled", false);
        aqf.m4771e(1, "gads:cct_v2_direct_launch:enabled", false);
        aqf.m4771e(1, "gads:chrome_custom_tabs_for_native_ads:enabled", false);
        aqf.m4771e(1, "gad:cct_v2_beta:enabled", false);
        aqf.m4764l("gad:publisher_testing:cct_v2:enabled_list", "");
        aqf.m4771e(2, "CHROME_CUSTOM_TAB_OPT_OUT", false);
        aqf.m4765k("gads:debug_hold_gesture:time_millis", ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        aqf.m4764l("gads:drx_debug:debug_device_linking_url", "https://www.google.com/dfp/linkDevice");
        aqf.m4764l("gads:drx_debug:in_app_preview_status_url", "https://www.google.com/dfp/inAppPreview");
        aqf.m4764l("gads:drx_debug:debug_signal_status_url", "https://www.google.com/dfp/debugSignals");
        aqf.m4764l("gads:drx_debug:send_debug_data_url", "https://www.google.com/dfp/sendDebugData");
        aqf.m4766j("gads:drx_debug:timeout_ms", 5000);
        aqf.m4766j("gad:pixel_dp_comparision_multiplier", 1);
        aqf.m4771e(1, "gad:interstitial_notify_publisher_without_delay", false);
        aqf.m4771e(1, "gad:interstitial_for_multi_window", false);
        aqf.m4771e(1, "gad:interstitial_ad_stay_active_in_multi_window", false);
        aqf.m4771e(1, "gad:interstitial_multi_window_method", false);
        aqf.m4766j("gad:interstitial:close_button_padding_dip", 0);
        aqf.m4771e(1, "gads:clearcut_logging:enabled", false);
        aqf.m4771e(1, "gads:clearcut_logging:write_to_file", false);
        aqf.m4771e(1, "gad:publisher_testing:force_local_request:enabled", true);
        aqf.m4764l("gad:publisher_testing:force_local_request:enabled_list", "");
        aqf.m4764l("gad:publisher_testing:force_local_request:disabled_list", "");
        aqf.m4766j("gad:http_redirect_max_count:times", 8);
        aqf.m4771e(1, "gads:omid:enabled", true);
        aqf.m4766j("gads:omid:destroy_webview_delay", 1000);
        aqf.m4771e(1, "gads:omid_use_admob_impl_dependency:enabled", true);
        aqf.m4771e(1, "gads:omid_use_base_64_encoding_for_native_html:enabled", false);
        aqf.m4771e(1, "gads:nonagon:banner:enabled", true);
        aqf.m4764l("gads:nonagon:banner:ad_unit_exclusions", "(?!)");
        aqf.m4771e(1, "gads:nonagon:app_open:enabled", true);
        aqf.m4766j("gads:app_open_beta:min_version", 999999999);
        aqf.m4766j("gads:app_open_ad_open_beta_api:min_version", 202490999);
        aqf.m4771e(1, "gads:nonagon:app_open_app_switch_signal:enabled", false);
        aqf.m4764l("gads:nonagon:app_open:ad_unit_exclusions", "(?!)");
        aqf.m4771e(1, "gads:nonagon:interstitial:enabled", true);
        aqf.m4764l("gads:nonagon:interstitial:ad_unit_exclusions", "(?!)");
        aqf.m4771e(1, "gads:nonagon:rewardedvideo:enabled", true);
        aqf.m4771e(1, "gads:nonagon:mobile_ads_setting_manager:enabled", true);
        aqf.m4764l("gads:nonagon:rewardedvideo:ad_unit_exclusions", "(?!)");
        aqf.m4771e(1, "gads:nonagon:banner:check_dp_size", true);
        aqf.m4771e(1, "gads:nonagon:rewarded:load_multiple_ads", true);
        aqf.m4771e(1, "gads:nonagon:return_no_fill_error_code", false);
        aqf.m4771e(1, "gads:nonagon:continue_on_no_fill", false);
        aqf.m4771e(1, "gads:nonagon:separate_timeout:enabled", true);
        aqf.m4766j("gads:nonagon:request_timeout:seconds", 60);
        aqf.m4771e(1, "gads:nonagon:banner_recursive_renderer", false);
        aqf.m4771e(1, "gads:nonagon:app_stats_lock:enabled", false);
        aqf.m4771e(1, "gads:nonagon:app_stats_main_thread:enabled", false);
        aqf.m4771e(1, "gads:uri_query_to_map_bg_thread:enabled", false);
        aqf.m4764l("gads:uri_query_to_map_bg_thread:types", "/result");
        aqf.m4766j("gads:uri_query_to_map_bg_thread:min_length", 1000);
        aqf.m4771e(1, "gads:nonagon:active_view_gmsg_background_thread:enabled", true);
        aqf.m4771e(1, "gads:active_view_gmsg_separate_pool:enabled", true);
        aqf.m4771e(1, "gads:active_view_audio_signal_audio_mode:enabled", false);
        aqf.m4771e(1, "gads:signals:ad_id_info:enabled", false);
        aqf.m4771e(1, "gads:signals:app_index:enabled", false);
        aqf.m4771e(1, "gads:signals:attestation_token:enabled", false);
        aqf.m4771e(1, "gads:signals:cache:enabled", false);
        aqf.m4771e(1, "gads:signals:doritos:enabled", false);
        aqf.m4771e(1, "gads:signals:doritos:v1:enabled", false);
        aqf.m4771e(1, "gads:signals:doritos:v2:immediate:enabled", false);
        aqf.m4771e(1, "gads:signals:parental_control:enabled", false);
        aqf.m4771e(1, "gads:signals:video_decoder:enabled", false);
        aqf.m4771e(1, "gads:signals:banner_hardware_acceleration:enabled", false);
        aqf.m4771e(1, "gads:signals:native_hardware_acceleration:enabled", false);
        aqf.m4771e(1, "gads:attestation_token:enabled", false);
        aqf.m4765k("gads:mobius_linking:sdk_side_cooldown_time_threshold:ms", 3600000L);
        aqf.m4766j("gads:adoverlay:b68684796:targeting_sdk:lower_bound", 27);
        aqf.m4766j("gads:adoverlay:b68684796:targeting_sdk:upper_bound", 26);
        aqf.m4766j("gads:adoverlay:b68684796:sdk_int:lower_bound", 27);
        aqf.m4766j("gads:adoverlay:b68684796:sdk_int:upper_bound", 26);
        aqf.m4771e(1, "gads:consent:shared_preference_reading:enabled", true);
        aqf.m4771e(1, "gads:consent:iab_consent_info:enabled", true);
        aqf.m4771e(1, "gads:fc_consent:shared_preference_reading:enabled", true);
        aqf.m4764l("gads:sp:json_string", "");
        aqf.m4771e(1, "gads:nativeads:image:sample:enabled", true);
        aqf.m4766j("gads:nativeads:image:sample:pixels", 1048576);
        aqf.m4771e(1, "gads:nativeads:pub_image_scale_type:enabled", true);
        aqf.m4771e(1, "gads:offline_signaling:enabled", false);
        aqf.m4766j("gads:offline_signaling:log_maximum", 100);
        aqf.m4771e(1, "gads:nativeads:template_signal:enabled", true);
        aqf.m4771e(1, "gads:nativeads:media_content_aspect_ratio:enabled", true);
        aqf.m4771e(1, "gads:nativeads:media_content_metadata:enabled", true);
        aqf.m4771e(1, "gads:buffer_click_url_as_ready_to_ping:enabled", false);
        aqf.m4771e(1, "gads:predictive_prefetch_from_cld:enabled", false);
        aqf.m4771e(1, "gads:cache_layer_from_cld:enabled", false);
        aqf.m4771e(1, "gads:cache_layer_wait_for_app_settings:enabled", false);
        aqf.m4771e(1, "gads:precache_pool:verbose_logging", false);
        aqf.m4766j("gads:rewarded_precache_pool:count", 0);
        aqf.m4766j("gads:interstitial_precache_pool:count", 0);
        aqf.m4764l("gads:rewarded_precache_pool:discard_strategy", "lru");
        aqf.m4764l("gads:interstitial_precache_pool:discard_strategy", "lru");
        aqf.m4764l("gads:rewarded_precache_pool:cache_start_trigger", "onAdClosed");
        aqf.m4764l("gads:interstitial_precache_pool:cache_start_trigger", "onAdClosed");
        aqf.m4766j("gads:rewarded_precache_pool:size", 1);
        aqf.m4766j("gads:interstitial_precache_pool:size", 1);
        aqf.m4766j("gads:rewarded_precache_pool:ad_time_limit", 1200);
        aqf.m4766j("gads:interstitial_precache_pool:ad_time_limit", 1200);
        aqf.m4764l("gads:rewarded_precache_pool:schema", "customTargeting,npa,tagForChildDirectedTreatment,tagForUnderAgeOfConsent,maxAdContentRating");
        aqf.m4764l("gads:interstitial_precache_pool:schema", "customTargeting,npa,tagForChildDirectedTreatment,tagForUnderAgeOfConsent,maxAdContentRating");
        aqf.m4764l("gads:app_open_precache_pool:schema", "orientation,npa,tagForChildDirectedTreatment,tagForUnderAgeOfConsent,maxAdContentRating");
        aqf.m4764l("gads:app_open_precache_pool:discard_strategy", "oldest");
        aqf.m4766j("gads:app_open_precache_pool:count", 0);
        aqf.m4764l("gads:app_open_precache_pool:cache_start_trigger", "onAdClosed");
        aqf.m4766j("gads:app_open_precache_pool:size", 1);
        aqf.m4766j("gads:app_open_precache_pool:ad_time_limit", 14400);
        aqf.m4771e(1, "gads:memory_leak:b129558083", false);
        aqf.m4771e(1, "gads:unhandled_event_reporting:enabled", false);
        aqf.m4771e(1, "gads:response_info:enabled", true);
        aqf.m4771e(1, "gads:csi:interstitial_failed_to_show:enabled", false);
        aqf.m4771e(1, "gads:csi:mediation_failure:enabled", false);
        aqf.m4764l("gads:csi:error_parsing:regex", "^(\\d+)");
        aqf.m4771e(1, "gads:csi:eids_from_cld:enabled", false);
        aqf.m4771e(1, "gads:request_id_check:enabled", false);
        aqf.m4771e(1, "gads:request_id_int32:enabled", true);
        aqf.m4771e(1, "gads:render_decouple:enabled", true);
        aqf.m4766j("gads:maximum_query_json_cache_size", 200);
        aqf.m4765k("gads:timeout_query_json_cache:millis", 3600000L);
        aqf.m4771e(1, "gads:scar_csi:enabled", false);
        aqf.m4771e(1, "gads:scar_signal_comparison_experiment:enabled", false);
        aqf.m4771e(1, "gads:scar_signal_comparison_format:unknown", false);
        aqf.m4765k("gads:timeout_signal_collection_in_exp:millis", 1000L);
        aqf.m4771e(1, "gads:scar_trustless_token_for_gbid:enabled", false);
        aqf.m4771e(1, "gads:scar_v2:send_click_ping:enabled", false);
        aqf.m4771e(1, "gads:scar_v2:send_impression_pings:enabled", false);
        aqf.m4771e(1, "gads:scar_v2:user_agent:enabled", false);
        aqf.m4764l("gads:scar_v2:user_agent:key", "ua");
        aqf.m4771e(1, "gads:scar_v2:prior_click_count:enabled", false);
        aqf.m4764l("gads:scar_v2:prior_click_count:key", "pcc");
        aqf.m4764l("gads:scar_v2:pings_from_gma:key", "is_gma");
        aqf.m4771e(1, "gads:signal_collection_without_rendering:enabled", true);
        aqf.m4766j("gads:native_ads_signal:timeout", 1000);
        aqf.m4771e(2, "DISABLE_CRASH_REPORTING", false);
        aqf.m4771e(1, "gads:paid_event_listener:enabled", true);
        aqf.m4771e(1, "gads:interscroller_ad:enabled", true);
        aqf.m4771e(1, "gads:interscroller_ad:refresh:enabled", false);
        aqf.m4766j("gads:interscroller:min_width", 300);
        aqf.m4766j("gads:interscroller:min_height", 250);
        aqf.m4771e(1, "gads:is_in_scroll_view_new_api:enabled", true);
        aqf.m4771e(1, "gads:policy_validator_for_all_pubs:enabled", true);
        aqf.m4764l("gad:publisher_testing:policy_validator:enabled_list", "");
        aqf.m4766j("gads:policy_validator_layoutparam:flags", 808);
        aqf.m4771e(2, "NATIVE_AD_DEBUGGER_ENABLED", true);
        aqf.m4766j("gads:policy_validator_overlay_width:dp", 350);
        aqf.m4766j("gads:policy_validator_overlay_height:dp", 140);
        aqf.m4771e(1, "gads:use_wide_viewport:enabled", false);
        aqf.m4771e(1, "gads:load_with_overview_mode:enabled", false);
        aqf.m4771e(1, "gads:wire_banner_listener_after_request:enabled", false);
        aqf.m4771e(1, "gads:wire_app_open_listener_after_request:enabled", false);
        aqf.m4771e(1, "gads:wire_interstitial_listener_after_request:enabled", false);
        aqf.m4764l("gads:server_transaction_source:list", "Network");
        aqf.m4771e(1, "gads:can_open_app_and_open_app_action:enabled", false);
        aqf.m4771e(1, "gads:open_gmsg:set_uri_data_and_type:enabled", false);
        aqf.m4766j("gads:ad_error_api:min_version", 202006000);
        aqf.m4771e(1, "gads:forward_bow_error_string:enabled", true);
        aqf.m4771e(1, "gads:continue_on_process_response:enabled", false);
        aqf.m4771e(1, "gads:mediation_status_reporting:enabled", true);
        aqf.m4766j("gads:mediation_no_fill_error:min_version", 999999999);
        aqf.m4771e(1, "gads:line_item_no_fill_conversion:enabled", false);
        aqf.m4766j("gads:offline_database_version:version", 1);
        aqf.m4771e(1, "gads:offline_ads_notification:enabled", true);
        aqf.m4771e(1, "gads:use_new_network_api:enabled", true);
        aqf.m4771e(1, "gads:handle_click_recorded_event:enabled", false);
        aqf.m4771e(1, "gads:default_network_type_fine_to_unknown:enabled", true);
        aqf.m4771e(1, "gads:handle_intent_async:enabled", true);
        aqf.m4771e(1, "gads:skip_deep_link_validation_native_ads:enabled", true);
        aqf.m4771e(1, "gads:try_deep_link_fallback_native_ads:enabled", true);
        aqf.m4771e(1, "gads:in_app_link_handling_for_android_11_enabled:enabled", true);
        aqf.m4771e(1, "gads:new_remote_logging_utils:enabled", false);
        aqf.m4771e(1, "gads:remote_logging:enabled", false);
        aqf.m4766j("gads:remote_log_send_rate_ms", TimeConstants.MIN);
        aqf.m4766j("gads:remote_log_queue_max_entries", 500);
        aqf.m4764l("gads:remote_capture_service_url", "https://pagead2.googlesyndication.com/pagead/ping?e=2&f=1");
        aqf.m4766j("gads:cui_monitoring_interval_ms", 300000);
        aqf.m4764l("gads:plugin_regex", "^Flutter-GMA-.*|^unity-.*");
        aqf.m4766j("gads:app_event_queue_size", 20);
        aqf.m4771e(1, "gads:hide_grey_title_bar:enabled", false);
        aqf.m4771e(1, "gads:interstitial_ad_parameter_handler:enabled", true);
        aqf.m4771e(1, "gads:inspector:enabled", true);
        aqf.m4764l("gads:inspector:ui_url", "https://admob-gmats.uc.r.appspot.com/");
        aqf.m4766j("gads:inspector:max_ad_life_cycles", 1000);
        aqf.m4766j("gads:inspector:ui_invocation_millis", 2000);
        aqf.m4771e(1, "gads:inspector:shake_enabled", true);
        aqf.m4767i("gads:inspector:shake_strength", 2.0f);
        aqf.m4766j("gads:inspector:shake_interval", 500);
        aqf.m4766j("gads:inspector:shake_reset_time_ms", PathInterpolatorCompat.MAX_NUM_POINTS);
        aqf.m4766j("gads:inspector:shake_count", 3);
        aqf.m4771e(1, "gads:inspector:flick_enabled", true);
        aqf.m4767i("gads:inspector:flick_rotation_threshold", 45.0f);
        aqf.m4766j("gads:inspector:flick_reset_time_ms", PathInterpolatorCompat.MAX_NUM_POINTS);
        aqf.m4766j("gads:inspector:flick_count", 2);
        aqf.m4766j("gads:inspector:icon_width_px", 256);
        aqf.m4766j("gads:inspector:icon_height_px", 256);
        aqf.m4771e(1, "gads:inspector:ad_manager_enabled", true);
        aqf.m4771e(1, "gads:inspector:policy_violations_enabled", false);
        aqf.m4771e(1, "gads:inspector:bidding_data_enabled", true);
        aqf.m4771e(1, "gads:paw_register_webview:enabled", true);
        aqf.m4771e(1, "gads:paw_webview_early_initialization:enabled", false);
        aqf.m4771e(1, "gads:h5ads:enabled", true);
        aqf.m4766j("gads:h5ads:max_num_ad_objects", 10);
        aqf.m4766j("gads:h5ads:max_gmsg_length", 5000);
        aqf.m4764l("gads:h5ads:afma_prefix", "(window.AFMA_ReceiveMessage||function(msg,params){window.h5_iframe.contentWindow.postMessage({messageName:'receive_message_action',parameters:{messageName:msg,parameters:params}},'*');})");
        aqf.m4771e(1, "gads:native_html_video_asset:enabled", true);
        aqf.m4771e(1, "gads:native_html_image_asset:enabled", true);
        aqf.m4771e(1, "gads:leibniz:events:enabled", false);
        aqf.m4771e(1, "gads:msa:alphavis_enabled", false);
        aqf.m4771e(1, "gads:msa:adutilalphavis_enabled", false);
        aqf.m4771e(1, "gads:msa:nativealphavis_enabled", false);
        aqf.m4766j("gads:msa:visminalpha", 90);
        aqf.m4771e(1, "gads:msa:vswfl", false);
        aqf.m4771e(1, "gads:msa:poslogger", false);
        aqf.m4771e(1, "gads:new_dynamite_module_method:enabled", false);
        aqf.m4771e(1, "gads:new_show_failure_coverage:enabled", false);
        aqf.m4766j("gads:timeout_for_show_call_succeed:ms", PathInterpolatorCompat.MAX_NUM_POINTS);
        aqf.m4771e(1, "gads:read_pub_callback_param_open_gmsg:enabled", true);
        aqf.m4771e(1, "gads:read_pub_callback_param_click_gmsg:enabled", true);
        aqf.m4771e(1, "gads:forward_physical_click_to_ad_listener:enabled", true);
        aqf.m4771e(1, "gads:webview_destroy_workaround:enabled", true);
        aqf.m4771e(1, "gads:appstate_getresource_fix:enabled", false);
        aqf.m4771e(1, "gads:convert_ad_unit_lower_case_rtb:enabled", false);
        aqf.m4771e(1, "gads:drx_ad_unit_regex_case_insensitive:enabled", false);
        aqf.m4771e(1, "gads:csi_ping_for_invalid_dynamite_flags_access:enabled", false);
    }

    /* renamed from: a */
    public static void m4755a(Context context) {
        aqm.m4754a(new C2688ew(context, 3));
    }
}
