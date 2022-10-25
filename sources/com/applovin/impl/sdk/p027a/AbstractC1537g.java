package com.applovin.impl.sdk.p027a;

import android.graphics.Point;
import android.graphics.PointF;
import android.net.Uri;
import androidx.core.view.ViewCompat;
import com.applovin.impl.adview.AbstractC1252j;
import com.applovin.impl.adview.C1316u;
import com.applovin.impl.adview.C1320x;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1780y;
import com.applovin.impl.sdk.p028b.C1565c;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p030d.C1576a;
import com.applovin.impl.sdk.utils.C1724f;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.a.g */
/* loaded from: classes.dex */
public abstract class AbstractC1537g extends AppLovinAdBase {

    /* renamed from: a */
    private final List<Uri> f1524a;

    /* renamed from: b */
    private final AtomicBoolean f1525b;

    /* renamed from: c */
    private final AtomicBoolean f1526c;

    /* renamed from: d */
    private final AtomicReference<C1565c> f1527d;

    /* renamed from: e */
    private boolean f1528e;

    /* renamed from: f */
    private List<C1576a> f1529f;

    /* renamed from: g */
    private List<C1576a> f1530g;

    /* renamed from: h */
    private List<C1576a> f1531h;

    /* renamed from: i */
    private List<C1576a> f1532i;

    /* renamed from: j */
    private C1541c f1533j;

    /* renamed from: com.applovin.impl.sdk.a.g$a */
    /* loaded from: classes.dex */
    public enum EnumC1539a {
        UNSPECIFIED,
        DISMISS,
        DO_NOT_DISMISS
    }

    /* renamed from: com.applovin.impl.sdk.a.g$b */
    /* loaded from: classes.dex */
    public enum EnumC1540b {
        DEFAULT,
        ACTIVITY_PORTRAIT,
        ACTIVITY_LANDSCAPE
    }

    /* renamed from: com.applovin.impl.sdk.a.g$c */
    /* loaded from: classes.dex */
    public class C1541c {

        /* renamed from: a */
        public final int f1542a;

        /* renamed from: b */
        public final int f1543b;

        /* renamed from: c */
        public final int f1544c;

        /* renamed from: d */
        public final int f1545d;

        /* renamed from: e */
        public final int f1546e;

        private C1541c() {
            this.f1542a = AppLovinSdkUtils.dpToPx(AbstractC1537g.this.sdk.m6677J(), AbstractC1537g.this.m7149X());
            this.f1543b = AppLovinSdkUtils.dpToPx(AbstractC1537g.this.sdk.m6677J(), AbstractC1537g.this.m7148Y());
            this.f1544c = AppLovinSdkUtils.dpToPx(AbstractC1537g.this.sdk.m6677J(), AbstractC1537g.this.m7147Z());
            this.f1545d = AppLovinSdkUtils.dpToPx(AbstractC1537g.this.sdk.m6677J(), ((Integer) AbstractC1537g.this.sdk.m6656a(C1568b.f1709bB)).intValue());
            this.f1546e = AppLovinSdkUtils.dpToPx(AbstractC1537g.this.sdk.m6677J(), ((Integer) AbstractC1537g.this.sdk.m6656a(C1568b.f1708bA)).intValue());
        }
    }

    /* renamed from: com.applovin.impl.sdk.a.g$d */
    /* loaded from: classes.dex */
    public enum EnumC1542d {
        RESIZE_ASPECT,
        RESIZE_ASPECT_FILL,
        RESIZE
    }

    public AbstractC1537g(JSONObject jSONObject, JSONObject jSONObject2, EnumC1528b enumC1528b, C1662k c1662k) {
        super(jSONObject, jSONObject2, enumC1528b, c1662k);
        this.f1524a = CollectionUtils.synchronizedList();
        this.f1525b = new AtomicBoolean();
        this.f1526c = new AtomicBoolean();
        this.f1527d = new AtomicReference<>();
    }

    /* renamed from: b */
    private String m7098b(PointF pointF, boolean z) {
        String stringFromAdObject = getStringFromAdObject("click_tracking_url", null);
        Map<String, String> m7093c = m7093c(pointF, z);
        if (stringFromAdObject != null) {
            return StringUtils.replace(stringFromAdObject, m7093c);
        }
        return null;
    }

    /* renamed from: c */
    private AbstractC1252j.EnumC1253a m7090c(boolean z) {
        return z ? AbstractC1252j.EnumC1253a.WHITE_ON_TRANSPARENT : AbstractC1252j.EnumC1253a.WHITE_ON_BLACK;
    }

    /* renamed from: c */
    private String m7094c() {
        String stringFromAdObject = getStringFromAdObject("video_end_url", null);
        if (stringFromAdObject != null) {
            return stringFromAdObject.replace(Utils.MACRO_CLCODE, getClCode());
        }
        return null;
    }

    /* renamed from: c */
    private Map<String, String> m7093c(PointF pointF, boolean z) {
        Point m6279a = C1724f.m6279a(this.sdk.m6677J());
        HashMap hashMap = new HashMap(5);
        hashMap.put(Utils.MACRO_CLCODE, getClCode());
        hashMap.put(Utils.MACRO_CLICK_X, String.valueOf(pointF.x));
        hashMap.put(Utils.MACRO_CLICK_Y, String.valueOf(pointF.y));
        hashMap.put(Utils.MACRO_SCREEN_WIDTH, String.valueOf(m6279a.x));
        hashMap.put(Utils.MACRO_SCREEN_HEIGHT, String.valueOf(m6279a.y));
        hashMap.put(Utils.MACRO_IS_VIDEO_CLICK, String.valueOf(z));
        return hashMap;
    }

    /* renamed from: A */
    public List<Uri> m7172A() {
        return this.f1524a;
    }

    /* renamed from: B */
    public String m7171B() {
        JSONObject jsonObjectFromAdObject = getJsonObjectFromAdObject("video_button_properties", null);
        return jsonObjectFromAdObject != null ? JsonUtils.getString(jsonObjectFromAdObject, "video_button_html", "") : "";
    }

    /* renamed from: C */
    public C1316u m7170C() {
        return new C1316u(getJsonObjectFromAdObject("video_button_properties", null), this.sdk);
    }

    /* renamed from: D */
    public boolean mo7169D() {
        return getBooleanFromAdObject("video_clickable", false);
    }

    /* renamed from: E */
    public boolean m7168E() {
        return getBooleanFromAdObject("lock_current_orientation", false);
    }

    /* renamed from: F */
    public int m7167F() {
        return getIntFromAdObject("countdown_length", 0);
    }

    /* renamed from: G */
    public int m7166G() {
        return getColorFromAdObject("countdown_color", -922746881);
    }

    /* renamed from: H */
    public int m7165H() {
        return getColorFromAdObject("graphic_background_color", hasVideoUrl() ? ViewCompat.MEASURED_STATE_MASK : -1157627904);
    }

    /* renamed from: I */
    public EnumC1539a m7164I() {
        String stringFromAdObject = getStringFromAdObject("poststitial_dismiss_type", null);
        if (StringUtils.isValidString(stringFromAdObject)) {
            if ("dismiss".equalsIgnoreCase(stringFromAdObject)) {
                return EnumC1539a.DISMISS;
            }
            if ("no_dismiss".equalsIgnoreCase(stringFromAdObject)) {
                return EnumC1539a.DO_NOT_DISMISS;
            }
        }
        return EnumC1539a.UNSPECIFIED;
    }

    /* renamed from: J */
    public List<String> m7163J() {
        String stringFromAdObject = getStringFromAdObject("resource_cache_prefix", null);
        return stringFromAdObject != null ? CollectionUtils.explode(stringFromAdObject) : this.sdk.m6625b(C1568b.f1745bl);
    }

    /* renamed from: K */
    public String m7162K() {
        return getStringFromAdObject("cache_prefix", null);
    }

    /* renamed from: L */
    public boolean m7161L() {
        return getBooleanFromAdObject("sscomt", false);
    }

    /* renamed from: M */
    public String m7160M() {
        return getStringFromFullResponse("event_id", null);
    }

    /* renamed from: N */
    public boolean m7159N() {
        return getBooleanFromAdObject("progress_bar_enabled", false);
    }

    /* renamed from: O */
    public int m7158O() {
        return getColorFromAdObject("progress_bar_color", -922746881);
    }

    /* renamed from: P */
    public int m7157P() {
        int videoCompletionPercent;
        synchronized (this.adObjectLock) {
            videoCompletionPercent = Utils.getVideoCompletionPercent(this.adObject);
        }
        return videoCompletionPercent;
    }

    /* renamed from: Q */
    public int m7156Q() {
        synchronized (this.adObjectLock) {
            int i = JsonUtils.getInt(this.adObject, "graphic_completion_percent", -1);
            if (i < 0 || i > 100) {
                return 90;
            }
            return i;
        }
    }

    /* renamed from: R */
    public int m7155R() {
        return getIntFromAdObject("poststitial_shown_forward_delay_millis", -1);
    }

    /* renamed from: S */
    public int m7154S() {
        return getIntFromAdObject("poststitial_dismiss_forward_delay_millis", -1);
    }

    /* renamed from: T */
    public boolean m7153T() {
        return getBooleanFromAdObject("should_apply_mute_setting_to_poststitial", false);
    }

    /* renamed from: U */
    public boolean m7152U() {
        return getBooleanFromAdObject("should_forward_close_button_tapped_to_poststitial", false);
    }

    /* renamed from: V */
    public boolean m7151V() {
        return getBooleanFromAdObject("forward_lifecycle_events_to_webview", false);
    }

    /* renamed from: W */
    public C1541c m7150W() {
        if (this.f1533j == null) {
            this.f1533j = new C1541c();
        }
        return this.f1533j;
    }

    /* renamed from: X */
    public int m7149X() {
        return getIntFromAdObject("close_button_size", ((Integer) this.sdk.m6656a(C1568b.f1733bZ)).intValue());
    }

    /* renamed from: Y */
    public int m7148Y() {
        return getIntFromAdObject("close_button_top_margin", ((Integer) this.sdk.m6656a(C1568b.f1786ca)).intValue());
    }

    /* renamed from: Z */
    public int m7147Z() {
        return getIntFromAdObject("close_button_horizontal_margin", ((Integer) this.sdk.m6656a(C1568b.f1732bY)).intValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public AbstractC1252j.EnumC1253a m7145a(int i) {
        return i == 1 ? AbstractC1252j.EnumC1253a.WHITE_ON_TRANSPARENT : i == 2 ? AbstractC1252j.EnumC1253a.INVISIBLE : AbstractC1252j.EnumC1253a.WHITE_ON_BLACK;
    }

    /* renamed from: a */
    public List<C1576a> m7144a(PointF pointF) {
        List<C1576a> postbacks;
        synchronized (this.adObjectLock) {
            postbacks = Utils.getPostbacks("video_click_tracking_urls", this.adObject, m7093c(pointF, true), null, m7105au(), m7070y(), this.sdk);
        }
        return postbacks.isEmpty() ? m7143a(pointF, true) : postbacks;
    }

    /* renamed from: a */
    public List<C1576a> m7143a(PointF pointF, boolean z) {
        List<C1576a> postbacks;
        synchronized (this.adObjectLock) {
            postbacks = Utils.getPostbacks("click_tracking_urls", this.adObject, m7093c(pointF, z), m7098b(pointF, z), m7105au(), m7070y(), this.sdk);
        }
        return postbacks;
    }

    /* renamed from: a */
    public abstract void mo7146a();

    /* renamed from: a */
    public void m7141a(C1565c c1565c) {
        this.f1527d.set(c1565c);
    }

    /* renamed from: a */
    public void m7140a(boolean z) {
        try {
            synchronized (this.adObjectLock) {
                this.adObject.put("html_resources_cached", z);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: aA */
    public List<String> m7139aA() {
        return CollectionUtils.explode(getStringFromAdObject("wls", ""));
    }

    /* renamed from: aB */
    public List<String> m7138aB() {
        return CollectionUtils.explode(getStringFromAdObject("wlh", null));
    }

    /* renamed from: aC */
    public boolean m7137aC() {
        return getBooleanFromAdObject("ibbdfs", false);
    }

    /* renamed from: aD */
    public boolean m7136aD() {
        return getBooleanFromAdObject("ibbdfc", false);
    }

    /* renamed from: aE */
    public Uri m7135aE() {
        String stringFromAdObject = getStringFromAdObject("mute_image", null);
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    /* renamed from: aF */
    public Uri m7134aF() {
        String stringFromAdObject = getStringFromAdObject("unmute_image", "");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    /* renamed from: aG */
    public boolean m7133aG() {
        return this.f1526c.get();
    }

    /* renamed from: aH */
    public void m7132aH() {
        this.f1526c.set(true);
    }

    /* renamed from: aI */
    public C1565c m7131aI() {
        return this.f1527d.getAndSet(null);
    }

    /* renamed from: aJ */
    public boolean m7130aJ() {
        return getBooleanFromAdObject("suep", false) || (getBooleanFromAdObject("suepfs", false) && mo7085f());
    }

    /* renamed from: aK */
    public boolean m7129aK() {
        return getBooleanFromAdObject("rwvbv", false);
    }

    /* renamed from: aL */
    public long m7128aL() {
        return getLongFromAdObject("vrsbt_ms", TimeUnit.SECONDS.toMillis(3L));
    }

    /* renamed from: aM */
    public boolean m7127aM() {
        return getBooleanFromAdObject("upiosp", false);
    }

    /* renamed from: aN */
    public boolean m7126aN() {
        return getBooleanFromAdObject("web_video", false);
    }

    /* renamed from: aa */
    public boolean m7125aa() {
        return getBooleanFromAdObject("lhs_close_button", (Boolean) this.sdk.m6656a(C1568b.f1731bX));
    }

    /* renamed from: ab */
    public boolean m7124ab() {
        return getBooleanFromAdObject("lhs_skip_button", (Boolean) this.sdk.m6656a(C1568b.f1799cn));
    }

    /* renamed from: ac */
    public long m7123ac() {
        long longFromAdObject = getLongFromAdObject("report_reward_duration", -1L);
        if (longFromAdObject >= 0) {
            return TimeUnit.SECONDS.toMillis(longFromAdObject);
        }
        return -1L;
    }

    /* renamed from: ad */
    public int m7122ad() {
        return getIntFromAdObject("report_reward_percent", -1);
    }

    /* renamed from: ae */
    public boolean m7121ae() {
        return getBooleanFromAdObject("report_reward_percent_include_close_delay", true);
    }

    /* renamed from: af */
    public AtomicBoolean m7120af() {
        return this.f1525b;
    }

    /* renamed from: ag */
    public boolean m7119ag() {
        return getBooleanFromAdObject("show_nia", false);
    }

    /* renamed from: ah */
    public String m7118ah() {
        return getStringFromAdObject("nia_title", "");
    }

    /* renamed from: ai */
    public String m7117ai() {
        return getStringFromAdObject("nia_message", "");
    }

    /* renamed from: aj */
    public String m7116aj() {
        return getStringFromAdObject("nia_button_title", "");
    }

    /* renamed from: ak */
    public boolean m7115ak() {
        return getBooleanFromAdObject("avoms", false);
    }

    /* renamed from: al */
    public boolean m7114al() {
        return this.f1528e;
    }

    /* renamed from: am */
    public boolean m7113am() {
        return getBooleanFromAdObject("show_rewarded_interstitial_overlay_alert", Boolean.valueOf(AppLovinAdType.AUTO_INCENTIVIZED == getType()));
    }

    /* renamed from: an */
    public String m7112an() {
        return getStringFromAdObject("text_rewarded_inter_alert_title", "Watch a video to earn a reward!");
    }

    /* renamed from: ao */
    public String m7111ao() {
        return getStringFromAdObject("text_rewarded_inter_alert_body", "");
    }

    /* renamed from: ap */
    public String m7110ap() {
        return getStringFromAdObject("text_rewarded_inter_alert_ok_action", "OK!");
    }

    /* renamed from: aq */
    public List<C1576a> m7109aq() {
        List<C1576a> postbacks;
        List<C1576a> list = this.f1529f;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            postbacks = Utils.getPostbacks("video_end_urls", this.adObject, getClCode(), m7094c(), this.sdk);
            this.f1529f = postbacks;
        }
        return postbacks;
    }

    /* renamed from: ar */
    public List<C1576a> m7108ar() {
        List<C1576a> postbacks;
        List<C1576a> list = this.f1530g;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            postbacks = Utils.getPostbacks("ad_closed_urls", this.adObject, getClCode(), (String) null, this.sdk);
            this.f1530g = postbacks;
        }
        return postbacks;
    }

    /* renamed from: as */
    public List<C1576a> m7107as() {
        List<C1576a> postbacks;
        List<C1576a> list = this.f1531h;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            postbacks = Utils.getPostbacks("app_killed_urls", this.adObject, getClCode(), (String) null, this.sdk);
            this.f1531h = postbacks;
        }
        return postbacks;
    }

    /* renamed from: at */
    public List<C1576a> mo7106at() {
        List<C1576a> postbacks;
        List<C1576a> list = this.f1532i;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            postbacks = Utils.getPostbacks("imp_urls", this.adObject, getClCode(), CollectionUtils.map(Utils.SHOWN_OUT_OF_CONTEXT_MACRO, String.valueOf(m7114al())), null, m7105au(), m7070y(), this.sdk);
            this.f1532i = postbacks;
        }
        return postbacks;
    }

    /* renamed from: au */
    public Map<String, String> m7105au() {
        HashMap hashMap = new HashMap();
        if (getBooleanFromAdObject("send_webview_http_headers", false)) {
            hashMap.putAll(C1780y.m6107b());
        }
        if (getBooleanFromAdObject("use_webview_ua_for_postbacks", false)) {
            hashMap.put("User-Agent", C1780y.m6111a());
        }
        return hashMap;
    }

    /* renamed from: av */
    public boolean m7104av() {
        return getBooleanFromAdObject("playback_requires_user_action", true);
    }

    /* renamed from: aw */
    public String m7103aw() {
        String stringFromAdObject = getStringFromAdObject("base_url", "/");
        if ("null".equalsIgnoreCase(stringFromAdObject)) {
            return null;
        }
        return stringFromAdObject;
    }

    /* renamed from: ax */
    public boolean m7102ax() {
        return getBooleanFromAdObject("web_contents_debugging_enabled", false);
    }

    /* renamed from: ay */
    public C1320x m7101ay() {
        JSONObject jsonObjectFromAdObject = getJsonObjectFromAdObject("web_view_settings", null);
        if (jsonObjectFromAdObject != null) {
            return new C1320x(jsonObjectFromAdObject);
        }
        return null;
    }

    /* renamed from: az */
    public int m7100az() {
        return getIntFromAdObject("whalt", Utils.isBML(getSize()) ? 1 : ((Boolean) this.sdk.m6656a(C1568b.f1875eL)).booleanValue() ? 0 : -1);
    }

    /* renamed from: b */
    public abstract JSONObject mo7099b();

    /* renamed from: b */
    public void m7097b(Uri uri) {
        this.f1524a.add(uri);
    }

    /* renamed from: b */
    public void m7095b(boolean z) {
        this.f1528e = z;
    }

    /* renamed from: c */
    public void m7092c(Uri uri) {
        synchronized (this.adObjectLock) {
            JsonUtils.putObject(this.adObject, "mute_image", uri);
        }
    }

    /* renamed from: d */
    public abstract String mo7089d();

    /* renamed from: d */
    public void m7088d(Uri uri) {
        synchronized (this.adObjectLock) {
            JsonUtils.putObject(this.adObject, "unmute_image", uri);
        }
    }

    /* renamed from: f */
    public boolean mo7085f() {
        this.sdk.m6588z().m6314e("DirectAd", "Attempting to invoke isVideoStream() from base ad class");
        return false;
    }

    /* renamed from: h */
    public Uri mo7082h() {
        this.sdk.m6588z().m6314e("DirectAd", "Attempting to invoke getVideoUri() from base ad class");
        return null;
    }

    /* renamed from: j */
    public Uri mo7081j() {
        this.sdk.m6588z().m6314e("DirectAd", "Attempting to invoke getClickDestinationUri() from base ad class");
        return null;
    }

    /* renamed from: k */
    public Uri mo7080k() {
        this.sdk.m6588z().m6314e("DirectAd", "Attempting to invoke getVideoClickDestinationUri() from base ad class");
        return null;
    }

    /* renamed from: p */
    public boolean m7079p() {
        return getBooleanFromAdObject("fs_2", false);
    }

    /* renamed from: q */
    public EnumC1540b m7078q() {
        String upperCase = getStringFromAdObject("ad_target", EnumC1540b.DEFAULT.toString()).toUpperCase(Locale.ENGLISH);
        return "ACTIVITY_PORTRAIT".equalsIgnoreCase(upperCase) ? EnumC1540b.ACTIVITY_PORTRAIT : "ACTIVITY_LANDSCAPE".equalsIgnoreCase(upperCase) ? EnumC1540b.ACTIVITY_LANDSCAPE : EnumC1540b.DEFAULT;
    }

    /* renamed from: r */
    public String m7077r() {
        return getStringFromFullResponse("dsp_name", "");
    }

    /* renamed from: s */
    public long m7076s() {
        return getLongFromAdObject("close_delay", 0L);
    }

    /* renamed from: t */
    public long m7075t() {
        return TimeUnit.SECONDS.toMillis(getLongFromAdObject("close_delay_max_buffering_time_seconds", 5L));
    }

    /* renamed from: u */
    public long m7074u() {
        long longFromAdObject = getLongFromAdObject("close_delay_graphic", 0L);
        if (m7079p()) {
            if (longFromAdObject == -1 || longFromAdObject == -2) {
                return 0L;
            }
            return longFromAdObject;
        }
        return longFromAdObject;
    }

    /* renamed from: v */
    public AbstractC1252j.EnumC1253a m7073v() {
        int intFromAdObject = getIntFromAdObject("close_style", -1);
        return intFromAdObject == -1 ? m7090c(hasVideoUrl()) : m7145a(intFromAdObject);
    }

    /* renamed from: w */
    public AbstractC1252j.EnumC1253a m7072w() {
        int intFromAdObject = getIntFromAdObject("skip_style", -1);
        return intFromAdObject == -1 ? m7073v() : m7145a(intFromAdObject);
    }

    /* renamed from: x */
    public boolean m7071x() {
        return getBooleanFromAdObject("dismiss_on_skip", false);
    }

    /* renamed from: y */
    public boolean m7070y() {
        return getBooleanFromAdObject("fire_postbacks_from_webview", false);
    }

    /* renamed from: z */
    public boolean m7069z() {
        return getBooleanFromAdObject("html_resources_cached", false);
    }
}
