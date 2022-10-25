package com.applovin.impl.adview;

import android.webkit.WebSettings;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import kotlinx.coroutines.Debug;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.adview.x */
/* loaded from: classes.dex */
public final class C1320x {

    /* renamed from: a */
    private JSONObject f767a;

    public C1320x(JSONObject jSONObject) {
        this.f767a = jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Integer m7873a() {
        int i;
        String string = JsonUtils.getString(this.f767a, "mixed_content_mode", null);
        if (StringUtils.isValidString(string)) {
            if ("always_allow".equalsIgnoreCase(string)) {
                i = 0;
            } else if ("never_allow".equalsIgnoreCase(string)) {
                i = 1;
            } else if ("compatibility_mode".equalsIgnoreCase(string)) {
                i = 2;
            }
            return Integer.valueOf(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public WebSettings.PluginState m7872b() {
        String string = JsonUtils.getString(this.f767a, "plugin_state", null);
        if (StringUtils.isValidString(string)) {
            if (Debug.DEBUG_PROPERTY_VALUE_ON.equalsIgnoreCase(string)) {
                return WebSettings.PluginState.ON;
            }
            if ("on_demand".equalsIgnoreCase(string)) {
                return WebSettings.PluginState.ON_DEMAND;
            }
            if (Debug.DEBUG_PROPERTY_VALUE_OFF.equalsIgnoreCase(string)) {
                return WebSettings.PluginState.OFF;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public Boolean m7871c() {
        return JsonUtils.getBoolean(this.f767a, "allow_file_access", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public Boolean m7870d() {
        return JsonUtils.getBoolean(this.f767a, "load_with_overview_mode", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public Boolean m7869e() {
        return JsonUtils.getBoolean(this.f767a, "use_wide_view_port", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public Boolean m7868f() {
        return JsonUtils.getBoolean(this.f767a, "allow_content_access", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public Boolean m7867g() {
        return JsonUtils.getBoolean(this.f767a, "use_built_in_zoom_controls", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public Boolean m7866h() {
        return JsonUtils.getBoolean(this.f767a, "display_zoom_controls", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public Boolean m7865i() {
        return JsonUtils.getBoolean(this.f767a, "save_form_data", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public Boolean m7864j() {
        return JsonUtils.getBoolean(this.f767a, "geolocation_enabled", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public Boolean m7863k() {
        return JsonUtils.getBoolean(this.f767a, "need_initial_focus", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public Boolean m7862l() {
        return JsonUtils.getBoolean(this.f767a, "allow_file_access_from_file_urls", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public Boolean m7861m() {
        return JsonUtils.getBoolean(this.f767a, "allow_universal_access_from_file_urls", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public Boolean m7860n() {
        return JsonUtils.getBoolean(this.f767a, "offscreen_pre_raster", null);
    }
}
