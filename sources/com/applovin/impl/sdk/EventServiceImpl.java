package com.applovin.impl.sdk;

import android.content.Intent;
import android.text.TextUtils;
import com.applovin.impl.sdk.network.C1697g;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p029c.C1570d;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.impl.sdk.p031e.C1642y;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.cast.HlsSegmentFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class EventServiceImpl implements AppLovinEventService {

    /* renamed from: a */
    private final C1662k f1448a;

    /* renamed from: b */
    private final Map<String, Object> f1449b;

    /* renamed from: c */
    private final AtomicBoolean f1450c = new AtomicBoolean();

    public EventServiceImpl(C1662k c1662k) {
        this.f1448a = c1662k;
        if (((Boolean) c1662k.m6656a(C1568b.f1734ba)).booleanValue()) {
            this.f1449b = JsonUtils.toStringObjectMap((String) c1662k.m6623b((C1570d<C1570d<String>>) C1570d.f1946r, (C1570d<String>) JsonUtils.EMPTY_JSON), new HashMap());
            return;
        }
        this.f1449b = new HashMap();
        c1662k.m6653a((C1570d<C1570d<String>>) C1570d.f1946r, (C1570d<String>) JsonUtils.EMPTY_JSON);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m7254a() {
        return ((String) this.f1448a.m6656a(C1568b.f1673aS)) + "4.0/pix";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Map<String, String> m7250a(C1705o c1705o, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        boolean contains = this.f1448a.m6625b(C1568b.f1679aY).contains(c1705o.m6360a());
        hashMap.put("AppLovin-Event", contains ? c1705o.m6360a() : "postinstall");
        if (!contains) {
            hashMap.put("AppLovin-Sub-Event", c1705o.m6360a());
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Map<String, String> m7249a(C1705o c1705o, boolean z) {
        boolean contains = this.f1448a.m6625b(C1568b.f1679aY).contains(c1705o.m6360a());
        Map<String, Object> m6557a = this.f1448a.m6667T().m6557a(null, z, false);
        m6557a.put("event", contains ? c1705o.m6360a() : "postinstall");
        m6557a.put("event_id", c1705o.m6357d());
        m6557a.put(HlsSegmentFormat.f9702TS, Long.toString(c1705o.m6358c()));
        if (!contains) {
            m6557a.put("sub_event", c1705o.m6360a());
        }
        return Utils.stringifyObjectMap(m6557a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public String m7248b() {
        return ((String) this.f1448a.m6656a(C1568b.f1674aT)) + "4.0/pix";
    }

    /* renamed from: c */
    private void m7246c() {
        if (((Boolean) this.f1448a.m6656a(C1568b.f1734ba)).booleanValue()) {
            this.f1448a.m6653a((C1570d<C1570d<String>>) C1570d.f1946r, (C1570d<String>) CollectionUtils.toJsonString(this.f1449b, JsonUtils.EMPTY_JSON));
        }
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public Map<String, Object> getSuperProperties() {
        return new HashMap(this.f1449b);
    }

    public void maybeTrackAppOpenEvent() {
        if (this.f1450c.compareAndSet(false, true)) {
            this.f1448a.m6593u().trackEvent("landing");
        }
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void setSuperProperty(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            C1710r.m6310i("AppLovinEventService", "Super property key cannot be null or empty");
        } else if (obj == null) {
            this.f1449b.remove(str);
            m7246c();
        } else {
            List<String> m6625b = this.f1448a.m6625b(C1568b.f1680aZ);
            if (Utils.objectIsOfType(obj, m6625b, this.f1448a)) {
                this.f1449b.put(str, Utils.sanitizeSuperProperty(obj, this.f1448a));
                m7246c();
                return;
            }
            C1710r.m6310i("AppLovinEventService", "Failed to set super property '" + obj + "' for key '" + str + "' - valid super property types include: " + m6625b);
        }
    }

    public String toString() {
        return "EventService{}";
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackCheckout(String str, Map<String, String> map) {
        HashMap hashMap = map != null ? new HashMap(map) : new HashMap(1);
        hashMap.put("transaction_id", str);
        trackEvent(AppLovinEventTypes.USER_COMPLETED_CHECKOUT, hashMap);
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackEvent(String str) {
        trackEvent(str, new HashMap());
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackEvent(String str, Map<String, String> map) {
        trackEvent(str, map, null);
    }

    public void trackEvent(String str, Map<String, String> map, final Map<String, String> map2) {
        C1710r m6588z = this.f1448a.m6588z();
        m6588z.m6319b("AppLovinEventService", "Tracking event: \"" + str + "\" with parameters: " + map);
        final C1705o c1705o = new C1705o(str, map, this.f1449b);
        try {
            this.f1448a.m6670Q().m6793a(new C1642y(this.f1448a, new Runnable() { // from class: com.applovin.impl.sdk.EventServiceImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    EventServiceImpl.this.f1448a.m6668S().m6452a(C1697g.m6421o().m6410c(EventServiceImpl.this.m7254a()).m6406d(EventServiceImpl.this.m7248b()).m6417a(EventServiceImpl.this.m7249a(c1705o, false)).m6413b(EventServiceImpl.this.m7250a(c1705o, map2)).m6409c(c1705o.m6359b()).m6412b(((Boolean) EventServiceImpl.this.f1448a.m6656a(C1568b.f1912ew)).booleanValue()).m6416a(((Boolean) EventServiceImpl.this.f1448a.m6656a(C1568b.f1903en)).booleanValue()).m6420a());
                }
            }), C1620o.EnumC1622a.BACKGROUND);
        } catch (Throwable th) {
            C1710r m6588z2 = this.f1448a.m6588z();
            m6588z2.m6318b("AppLovinEventService", "Unable to track event: " + c1705o, th);
        }
    }

    public void trackEventSynchronously(String str) {
        C1710r m6588z = this.f1448a.m6588z();
        m6588z.m6319b("AppLovinEventService", "Tracking event: \"" + str + "\" synchronously");
        C1705o c1705o = new C1705o(str, new HashMap(), this.f1449b);
        this.f1448a.m6668S().m6452a(C1697g.m6421o().m6410c(m7254a()).m6406d(m7248b()).m6417a(m7249a(c1705o, true)).m6413b(m7250a(c1705o, (Map<String, String>) null)).m6409c(c1705o.m6359b()).m6412b(((Boolean) this.f1448a.m6656a(C1568b.f1912ew)).booleanValue()).m6416a(((Boolean) this.f1448a.m6656a(C1568b.f1903en)).booleanValue()).m6420a());
    }

    @Override // com.applovin.sdk.AppLovinEventService
    public void trackInAppPurchase(Intent intent, Map<String, String> map) {
        HashMap hashMap = map != null ? new HashMap(map) : new HashMap();
        try {
            hashMap.put(AppLovinEventParameters.IN_APP_PURCHASE_DATA, intent.getStringExtra("INAPP_PURCHASE_DATA"));
            hashMap.put(AppLovinEventParameters.IN_APP_DATA_SIGNATURE, intent.getStringExtra("INAPP_DATA_SIGNATURE"));
        } catch (Throwable th) {
            C1710r.m6316c("AppLovinEventService", "Unable to track in app purchase - invalid purchase intent", th);
        }
        trackEvent(AppLovinEventTypes.USER_COMPLETED_IN_APP_PURCHASE, hashMap);
    }
}
