package com.applovin.impl.sdk.p027a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p031e.C1615m;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.impl.sdk.utils.C1721d;
import com.applovin.impl.sdk.utils.C1760m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.a.f */
/* loaded from: classes.dex */
public class RunnableC1533f implements Runnable {

    /* renamed from: i */
    private static boolean f1499i;

    /* renamed from: a */
    private final C1662k f1500a;

    /* renamed from: b */
    private final MaxAdFormat f1501b;

    /* renamed from: c */
    private List<C1531d> f1502c;

    /* renamed from: f */
    private C1531d f1505f;

    /* renamed from: h */
    private boolean f1507h;

    /* renamed from: g */
    private EnumC1536b f1506g = EnumC1536b.NONE;

    /* renamed from: d */
    private final List<JSONObject> f1503d = new ArrayList();

    /* renamed from: e */
    private final Object f1504e = new Object();

    /* renamed from: com.applovin.impl.sdk.a.f$a */
    /* loaded from: classes.dex */
    public static class C1535a implements AppLovinAdLoadListener {

        /* renamed from: a */
        private final C1662k f1509a;

        /* renamed from: b */
        private final C1531d f1510b;

        /* renamed from: c */
        private final AppLovinAdLoadListener f1511c;

        /* renamed from: d */
        private boolean f1512d;

        public C1535a(C1531d c1531d, AppLovinAdLoadListener appLovinAdLoadListener, C1662k c1662k) {
            this.f1509a = c1662k;
            this.f1510b = c1531d;
            this.f1511c = appLovinAdLoadListener;
        }

        /* renamed from: a */
        public void m7175a(boolean z) {
            this.f1512d = z;
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(AppLovinAd appLovinAd) {
            this.f1509a.m6661Z().m7200a((AppLovinAdBase) ((AbstractC1537g) appLovinAd), false, this.f1512d);
            this.f1511c.adReceived(appLovinAd);
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(int i) {
            this.f1509a.m6661Z().m7199a(this.f1510b, this.f1512d, i);
            this.f1511c.failedToReceiveAd(i);
        }
    }

    /* renamed from: com.applovin.impl.sdk.a.f$b */
    /* loaded from: classes.dex */
    public enum EnumC1536b {
        NONE(0, "none"),
        TIMER(1, "timer"),
        APP_PAUSED(2, "backgrounded"),
        IMPRESSION(3, "impression"),
        WATERFALL_RESTARTED(3, "waterfall_restarted"),
        UNKNOWN_ZONE(4, "unknown_zone"),
        SKIPPED_ZONE(5, "skipped_zone"),
        REPEATED_ZONE(6, "repeated_zone");
        

        /* renamed from: i */
        private final int f1522i;

        /* renamed from: j */
        private final String f1523j;

        EnumC1536b(int i, String str) {
            this.f1522i = i;
            this.f1523j = str;
        }

        /* renamed from: a */
        public int m7174a() {
            return this.f1522i;
        }

        /* renamed from: b */
        public String m7173b() {
            return this.f1523j;
        }
    }

    public RunnableC1533f(MaxAdFormat maxAdFormat, C1662k c1662k) {
        this.f1500a = c1662k;
        this.f1501b = maxAdFormat;
    }

    /* renamed from: a */
    private static JSONObject m7190a(C1531d c1531d, C1662k c1662k) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "id", c1531d.m7218a());
        JsonUtils.putLong(jSONObject, "response_ts_s", TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
        return jSONObject;
    }

    /* renamed from: a */
    public static void m7191a(C1531d c1531d, int i, C1662k c1662k) {
        if (!((Boolean) c1662k.m6656a(C1568b.f1917fb)).booleanValue()) {
            if (f1499i) {
                return;
            }
            C1710r.m6310i("AppLovinSdk", "Unknown zone in waterfall: " + c1531d.m7218a());
            f1499i = true;
        }
        JSONObject m7190a = m7190a(c1531d, c1662k);
        JsonUtils.putInt(m7190a, "error_code", i);
        m7185a(EnumC1536b.UNKNOWN_ZONE, EnumC1536b.NONE, JsonUtils.getJSONArray(m7190a), null, c1662k);
    }

    /* renamed from: a */
    private void m7189a(C1531d c1531d, JSONObject jSONObject) {
        EnumC1536b enumC1536b;
        JsonUtils.putAll(jSONObject, m7190a(c1531d, this.f1500a));
        synchronized (this.f1504e) {
            if (m7192a(c1531d)) {
                m7187a(EnumC1536b.WATERFALL_RESTARTED);
            } else {
                if (m7179b(c1531d)) {
                    m7181a(jSONObject, c1531d);
                    enumC1536b = EnumC1536b.REPEATED_ZONE;
                } else if (m7176c(c1531d)) {
                    m7181a(jSONObject, c1531d);
                    enumC1536b = EnumC1536b.SKIPPED_ZONE;
                }
                m7186a(enumC1536b, c1531d);
            }
            m7181a(jSONObject, c1531d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7187a(EnumC1536b enumC1536b) {
        m7186a(enumC1536b, (C1531d) null);
    }

    /* renamed from: a */
    private void m7186a(EnumC1536b enumC1536b, C1531d c1531d) {
        if (!((Boolean) this.f1500a.m6656a(C1568b.f1917fb)).booleanValue()) {
            if (this.f1507h) {
                return;
            }
            if (enumC1536b == EnumC1536b.SKIPPED_ZONE || enumC1536b == EnumC1536b.REPEATED_ZONE) {
                C1710r.m6310i("AppLovinSdk", "Invalid zone in waterfall: " + c1531d);
                this.f1507h = true;
            }
        }
        synchronized (this.f1504e) {
            if (this.f1503d.isEmpty()) {
                return;
            }
            JSONArray jSONArray = new JSONArray((Collection) this.f1503d);
            this.f1503d.clear();
            EnumC1536b enumC1536b2 = this.f1506g;
            this.f1506g = enumC1536b;
            m7185a(enumC1536b, enumC1536b2, jSONArray, this.f1501b, this.f1500a);
        }
    }

    /* renamed from: a */
    private static void m7185a(EnumC1536b enumC1536b, EnumC1536b enumC1536b2, JSONArray jSONArray, MaxAdFormat maxAdFormat, C1662k c1662k) {
        c1662k.m6670Q().m6793a(new C1615m(enumC1536b, enumC1536b2, jSONArray, maxAdFormat, c1662k), C1620o.EnumC1622a.BACKGROUND);
    }

    /* renamed from: a */
    private void m7181a(JSONObject jSONObject, C1531d c1531d) {
        synchronized (this.f1504e) {
            this.f1503d.add(jSONObject);
            this.f1505f = c1531d;
        }
    }

    /* renamed from: a */
    private boolean m7192a(C1531d c1531d) {
        if (this.f1505f != null) {
            int indexOf = this.f1502c.indexOf(c1531d);
            int indexOf2 = this.f1502c.indexOf(this.f1505f);
            if (indexOf == 0 || indexOf < indexOf2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m7180b() {
        long m7177c = m7177c();
        if (m7177c > 0) {
            if (((Boolean) this.f1500a.m6656a(C1568b.f1888eY)).booleanValue()) {
                C1721d.m6283a(m7177c, this.f1500a, this);
            } else {
                C1760m.m6176a(m7177c, this.f1500a, this);
            }
        }
    }

    /* renamed from: b */
    private boolean m7179b(C1531d c1531d) {
        return this.f1505f == c1531d;
    }

    /* renamed from: c */
    private long m7177c() {
        return TimeUnit.SECONDS.toMillis(((Long) this.f1500a.m6656a(C1568b.f1887eX)).longValue());
    }

    /* renamed from: c */
    private boolean m7176c(C1531d c1531d) {
        int indexOf = this.f1502c.indexOf(c1531d);
        C1531d c1531d2 = this.f1505f;
        return indexOf != (c1531d2 != null ? this.f1502c.indexOf(c1531d2) + 1 : 0);
    }

    /* renamed from: a */
    public void m7194a() {
        if (((Boolean) this.f1500a.m6656a(C1568b.f1889eZ)).booleanValue()) {
            m7187a(EnumC1536b.IMPRESSION);
        }
    }

    /* renamed from: a */
    public void m7193a(AppLovinAdBase appLovinAdBase, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putLong(jSONObject, "ad_id", appLovinAdBase.getAdIdNumber());
        JsonUtils.putLong(jSONObject, "ad_created_ts_s", TimeUnit.MILLISECONDS.toSeconds(appLovinAdBase.getCreatedAtMillis()));
        JsonUtils.putBoolean(jSONObject, "is_preloaded", z);
        JsonUtils.putBoolean(jSONObject, "for_bidding", z2);
        m7189a(appLovinAdBase.getAdZone(), jSONObject);
    }

    /* renamed from: a */
    public void m7188a(C1531d c1531d, boolean z, int i) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putInt(jSONObject, "error_code", i);
        JsonUtils.putBoolean(jSONObject, "for_bidding", z);
        m7189a(c1531d, jSONObject);
    }

    /* renamed from: a */
    public void m7182a(List<C1531d> list) {
        if (this.f1502c != null) {
            return;
        }
        this.f1502c = list;
        m7180b();
        if (((Boolean) this.f1500a.m6656a(C1568b.f1916fa)).booleanValue()) {
            this.f1500a.m6631ai().registerReceiver(new AppLovinBroadcastManager.Receiver() { // from class: com.applovin.impl.sdk.a.f.1
                @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
                public void onReceive(Context context, Intent intent, Map<String, Object> map) {
                    RunnableC1533f.this.m7187a(EnumC1536b.APP_PAUSED);
                    synchronized (RunnableC1533f.this.f1504e) {
                        RunnableC1533f.this.f1503d.clear();
                    }
                }
            }, new IntentFilter("com.applovin.application_paused"));
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        m7187a(EnumC1536b.TIMER);
        m7180b();
    }
}
