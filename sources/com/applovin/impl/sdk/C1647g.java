package com.applovin.impl.sdk;

import android.os.Bundle;
import androidx.browser.trusted.sharing.ShareTarget;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.communicator.C1326c;
import com.applovin.impl.communicator.CommunicatorMessageImpl;
import com.applovin.impl.mediation.p013a.AbstractC1334a;
import com.applovin.impl.mediation.p015c.C1391c;
import com.applovin.impl.sdk.network.C1682a;
import com.applovin.impl.sdk.network.C1688c;
import com.applovin.impl.sdk.network.C1697g;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.g */
/* loaded from: classes.dex */
public class C1647g implements AppLovinCommunicatorPublisher, AppLovinCommunicatorSubscriber {

    /* renamed from: a */
    private final C1662k f2206a;

    /* renamed from: b */
    private final AppLovinCommunicator f2207b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1647g(C1662k c1662k) {
        this.f2206a = c1662k;
        AppLovinCommunicator appLovinCommunicator = AppLovinCommunicator.getInstance(c1662k.m6677J());
        this.f2207b = appLovinCommunicator;
        if (c1662k.m6611e()) {
            return;
        }
        appLovinCommunicator.m8433a(c1662k);
        appLovinCommunicator.subscribe(this, C1326c.f787a);
    }

    /* renamed from: b */
    private Bundle m6724b(AbstractC1334a abstractC1334a) {
        Bundle bundle = new Bundle();
        bundle.putString("id", abstractC1334a.m7813e());
        bundle.putString("network_name", abstractC1334a.m7763K());
        bundle.putString("max_ad_unit_id", abstractC1334a.getAdUnitId());
        bundle.putString("third_party_ad_placement_id", abstractC1334a.m7808j());
        bundle.putString(FirebaseAnalytics.Param.AD_FORMAT, abstractC1334a.getFormat().getLabel());
        if (StringUtils.isValidString(abstractC1334a.getCreativeId())) {
            bundle.putString("creative_id", abstractC1334a.getCreativeId());
        }
        bundle.putAll(JsonUtils.toBundle(abstractC1334a.m7819a()));
        return bundle;
    }

    /* renamed from: a */
    public void m6732a() {
        m6731a(new Bundle(), "privacy_setting_updated");
    }

    /* renamed from: a */
    public void m6731a(Bundle bundle, String str) {
        if (this.f2206a.m6611e()) {
            return;
        }
        this.f2207b.getMessagingService().publish(CommunicatorMessageImpl.create(bundle, str, this, this.f2206a.m6625b(C1568b.f1882eS).contains(str)));
    }

    /* renamed from: a */
    public void m6730a(AbstractC1334a abstractC1334a) {
        Bundle m6724b = m6724b(abstractC1334a);
        m6724b.putAll(JsonUtils.toBundle(abstractC1334a.m7816b()));
        m6724b.putString("country_code", this.f2206a.m6596r().getCountryCode());
        BundleUtils.putStringIfValid("user_segment", this.f2206a.m6597q().getName(), m6724b);
        m6731a(m6724b, "max_revenue_events");
    }

    /* renamed from: a */
    public void m6729a(AbstractC1334a abstractC1334a, String str) {
        Bundle m6724b = m6724b(abstractC1334a);
        m6724b.putString("type", str);
        C1710r m6588z = this.f2206a.m6588z();
        m6588z.m6319b("CommunicatorService", "Sending \"max_ad_events\" message: " + m6724b);
        m6731a(m6724b, "max_ad_events");
    }

    /* renamed from: a */
    public void m6728a(MaxAdapter.InitializationStatus initializationStatus, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("adapter_class", str);
        bundle.putInt("init_status", initializationStatus.getCode());
        m6731a(bundle, "adapter_initialization_status");
    }

    /* renamed from: a */
    public void m6727a(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("adapter_class", str2);
        bundle.putString("sdk_version", str);
        m6731a(bundle, "network_sdk_version_updated");
    }

    /* renamed from: a */
    public void m6726a(String str, String str2, int i, Object obj, String str3, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        bundle.putString("url", str2);
        bundle.putInt("code", i);
        bundle.putBundle("body", JsonUtils.toBundle(obj));
        bundle.putBoolean("success", z);
        BundleUtils.putString("error_message", str3, bundle);
        m6731a(bundle, "receive_http_response");
    }

    /* renamed from: a */
    public void m6725a(JSONObject jSONObject, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f2206a.m6590x());
        bundle.putString("applovin_random_token", this.f2206a.m6599o());
        bundle.putString("compass_random_token", this.f2206a.m6600n());
        bundle.putString("device_type", AppLovinSdkUtils.isTablet(this.f2206a.m6677J()) ? "tablet" : "phone");
        bundle.putString("init_success", String.valueOf(z));
        bundle.putParcelableArrayList("installed_mediation_adapters", JsonUtils.toBundle(C1391c.m7599a(this.f2206a)));
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "communicator_settings", new JSONObject());
        Bundle bundle2 = (Bundle) bundle.clone();
        JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONObject2, "user_engagement_sdk_settings", new JSONObject());
        JsonUtils.putString(jSONObject3, "lsc", "Y29tLmFuZHJvaWQudmVuZGluZy5saWNlbnNpbmcuSUxpY2Vuc2luZ1NlcnZpY2U=");
        JsonUtils.putString(jSONObject3, "psp", "Y29tLmFuZHJvaWQudmVuZGluZw==");
        bundle2.putBundle("settings", JsonUtils.toBundle(jSONObject3));
        m6731a(bundle2, "user_engagement_sdk_init");
        Bundle bundle3 = (Bundle) bundle.clone();
        bundle3.putBundle("settings", JsonUtils.toBundle(JsonUtils.getJSONObject(jSONObject2, "safedk_settings", new JSONObject())));
        C1710r m6588z = this.f2206a.m6588z();
        m6588z.m6319b("CommunicatorService", "Sending \"safedk_init\" message: " + bundle);
        m6731a(bundle3, "safedk_init");
        Bundle bundle4 = (Bundle) bundle.clone();
        bundle4.putBundle("settings", JsonUtils.toBundle(JsonUtils.getJSONObject(jSONObject2, "adjust_settings", new JSONObject())));
        m6731a(bundle4, "adjust_init");
        Bundle bundle5 = (Bundle) bundle.clone();
        bundle5.putBundle("settings", JsonUtils.toBundle(JsonUtils.getJSONObject(jSONObject2, "discovery_settings", new JSONObject())));
        m6731a(bundle5, "discovery_init");
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "applovin_sdk";
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        long j;
        if ("send_http_request".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            Map<String, String> stringMap = BundleUtils.toStringMap(messageData.getBundle("query_params"));
            Map<String, Object> map = BundleUtils.toMap(messageData.getBundle("post_body"));
            Map<String, String> stringMap2 = BundleUtils.toStringMap(messageData.getBundle("headers"));
            String string = messageData.getString("id", "");
            if (!map.containsKey(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY)) {
                map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f2206a.m6590x());
            }
            this.f2206a.m6668S().m6452a(new C1697g.C1699a().m6410c(messageData.getString("url")).m6406d(messageData.getString("backup_url")).m6417a(stringMap).m6409c(map).m6413b(stringMap2).m6416a(((Boolean) this.f2206a.m6656a(C1568b.f1903en)).booleanValue()).m6418a(string).m6420a());
        } else if (!"send_http_request_v2".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
            if ("set_ad_request_query_params".equalsIgnoreCase(appLovinCommunicatorMessage.getTopic())) {
                this.f2206a.m6594t().addCustomQueryParams(Utils.stringifyObjectMap(BundleUtils.toMap(appLovinCommunicatorMessage.getMessageData())));
            }
        } else {
            Bundle messageData2 = appLovinCommunicatorMessage.getMessageData();
            String string2 = messageData2.getString("http_method", ShareTarget.METHOD_POST);
            long millis = messageData2.containsKey("timeout_sec") ? TimeUnit.SECONDS.toMillis(messageData2.getLong("timeout_sec")) : ((Long) this.f2206a.m6656a(C1568b.f1847dj)).longValue();
            int i = messageData2.getInt("retry_count", ((Integer) this.f2206a.m6656a(C1568b.f1848dk)).intValue());
            long millis2 = messageData2.containsKey("retry_delay_sec") ? TimeUnit.SECONDS.toMillis(messageData2.getLong("retry_delay_sec")) : ((Long) this.f2206a.m6656a(C1568b.f1849dl)).longValue();
            Map<String, Object> map2 = BundleUtils.toMap(messageData2.getBundle("post_body"));
            if (messageData2.getBoolean("include_data_collector_info", true)) {
                Map<String, Object> m6546g = this.f2206a.m6667T().m6546g();
                Map<String, Object> m6549d = this.f2206a.m6667T().m6549d();
                j = millis2;
                m6546g.put("server_installed_at", this.f2206a.m6656a(C1568b.f1685ae));
                m6546g.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f2206a.m6590x());
                map2.put("app", m6546g);
                map2.put("device", m6549d);
            } else {
                j = millis2;
            }
            this.f2206a.m6670Q().m6793a(new C1682a(appLovinCommunicatorMessage.getPublisherId(), C1688c.m6487a(this.f2206a).mo6391a(messageData2.getString("url")).mo6380c(messageData2.getString("backup_url")).mo6390a(BundleUtils.toStringMap(messageData2.getBundle("query_params"))).mo6384b(string2).mo6383b(BundleUtils.toStringMap(messageData2.getBundle("headers"))).mo6389a(new JSONObject(map2)).mo6387b((int) millis).mo6394a(i).mo6381c((int) j).mo6392a((C1688c.C1689a) new JSONObject()).mo6378c(messageData2.getBoolean("is_encoding_enabled", false)).mo6395a(), this.f2206a), C1620o.EnumC1622a.MAIN);
        }
    }
}
