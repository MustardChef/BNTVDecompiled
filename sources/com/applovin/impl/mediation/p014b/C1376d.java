package com.applovin.impl.mediation.p014b;

import android.net.Uri;
import androidx.browser.trusted.sharing.ShareTarget;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.p013a.AbstractC1334a;
import com.applovin.impl.mediation.p013a.C1338e;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.network.C1697g;
import com.applovin.impl.sdk.network.C1700h;
import com.applovin.impl.sdk.p029c.C1567a;
import com.applovin.impl.sdk.p031e.AbstractRunnableC1589a;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.d */
/* loaded from: classes.dex */
public class C1376d extends AbstractRunnableC1589a {

    /* renamed from: a */
    private final String f937a;

    /* renamed from: c */
    private final String f938c;

    /* renamed from: d */
    private final C1338e f939d;

    /* renamed from: e */
    private final Map<String, String> f940e;

    /* renamed from: f */
    private final Map<String, String> f941f;

    /* renamed from: g */
    private final MaxError f942g;

    public C1376d(String str, Map<String, String> map, MaxError maxError, C1338e c1338e, C1662k c1662k) {
        super("TaskFireMediationPostbacks", c1662k);
        this.f937a = str;
        this.f938c = str + "_urls";
        this.f940e = Utils.toUrlSafeMap(map);
        this.f942g = maxError != null ? maxError : new MaxErrorImpl(-1);
        this.f939d = c1338e;
        HashMap hashMap = new HashMap(7);
        hashMap.put("AppLovin-Event-Type", str);
        hashMap.put("AppLovin-Ad-Network-Name", c1338e.m7763K());
        if (c1338e instanceof AbstractC1334a) {
            AbstractC1334a abstractC1334a = (AbstractC1334a) c1338e;
            hashMap.put("AppLovin-Ad-Unit-Id", abstractC1334a.getAdUnitId());
            hashMap.put("AppLovin-Ad-Format", abstractC1334a.getFormat().getLabel());
            hashMap.put("AppLovin-Third-Party-Ad-Placement-ID", abstractC1334a.m7808j());
        }
        if (maxError != null) {
            hashMap.put("AppLovin-Error-Code", String.valueOf(maxError.getCode()));
            hashMap.put("AppLovin-Error-Message", maxError.getMessage());
        }
        this.f941f = hashMap;
    }

    /* renamed from: a */
    private String m7636a(String str, MaxError maxError) {
        int i;
        String str2;
        if (maxError instanceof MaxAdapterError) {
            MaxAdapterError maxAdapterError = (MaxAdapterError) maxError;
            i = maxAdapterError.getThirdPartySdkErrorCode();
            str2 = maxAdapterError.getThirdPartySdkErrorMessage();
        } else {
            i = 0;
            str2 = "";
        }
        return str.replace("{ERROR_CODE}", String.valueOf(maxError.getCode())).replace("{ERROR_MESSAGE}", StringUtils.encodeUrlString(maxError.getMessage())).replace("{THIRD_PARTY_SDK_ERROR_CODE}", String.valueOf(i)).replace("{THIRD_PARTY_SDK_ERROR_MESSAGE}", StringUtils.encodeUrlString(str2));
    }

    /* renamed from: a */
    private List<String> m7633a(List<String> list, Map<String, String> map, Map<String, String> map2, MaxError maxError) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            for (String str : map.keySet()) {
                next = next.replace(str, this.f939d.m7733e(map.get(str)));
            }
            arrayList.add(m7636a(m7632b(next, map2), maxError));
        }
        return arrayList;
    }

    /* renamed from: a */
    private Map<String, String> m7638a() {
        try {
            return JsonUtils.toStringMap(new JSONObject((String) this.f2058b.m6656a(C1567a.f1631i)));
        } catch (JSONException unused) {
            return Collections.EMPTY_MAP;
        }
    }

    /* renamed from: a */
    private void m7635a(String str, Map<String, Object> map) {
        m6880d().m6668S().m6452a(C1697g.m6421o().m6410c(str).m6414b(ShareTarget.METHOD_POST).m6413b(this.f941f).m6416a(false).m6409c(map).m6412b(((Boolean) this.f2058b.m6656a(C1567a.f1622U)).booleanValue()).m6420a());
    }

    /* renamed from: a */
    private void m7634a(List<String> list) {
        if (list.isEmpty()) {
            return;
        }
        for (String str : list) {
            m6880d().m6668S().m6452a(C1697g.m6421o().m6410c(str).m6416a(false).m6413b(this.f941f).m6420a());
        }
    }

    /* renamed from: b */
    private String m7632b(String str, Map<String, String> map) {
        for (String str2 : map.keySet()) {
            str = str.replace(str2, map.get(str2));
        }
        return str;
    }

    /* renamed from: b */
    private void m7631b(List<String> list) {
        if (list.isEmpty()) {
            return;
        }
        for (String str : list) {
            m6880d().m6665V().dispatchPostbackRequest(C1700h.m6399b(m6880d()).mo6391a(str).mo6378c(false).mo6383b(this.f941f).mo6395a(), C1620o.EnumC1622a.MEDIATION_POSTBACKS, new AppLovinPostbackListener() { // from class: com.applovin.impl.mediation.b.d.1
                @Override // com.applovin.sdk.AppLovinPostbackListener
                public void onPostbackFailure(String str2, int i) {
                    C1376d c1376d = C1376d.this;
                    c1376d.m6879d("Failed to fire postback with code: " + i + " and url: " + str2);
                }

                @Override // com.applovin.sdk.AppLovinPostbackListener
                public void onPostbackSuccess(String str2) {
                }
            });
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        List<String> m7734d = this.f939d.m7734d(this.f938c);
        Map<String, String> m7638a = m7638a();
        if (!((Boolean) m6880d().m6656a(C1567a.f1619R)).booleanValue()) {
            List<String> m7633a = m7633a(m7734d, m7638a, this.f940e, this.f942g);
            if (((Boolean) m6880d().m6656a(C1567a.f1632j)).booleanValue()) {
                m7634a(m7633a);
                return;
            } else {
                m7631b(m7633a);
                return;
            }
        }
        for (String str : m7734d) {
            Uri parse = Uri.parse(m7636a(m7632b(str, this.f940e), this.f942g));
            Uri.Builder clearQuery = parse.buildUpon().clearQuery();
            HashMap hashMap = new HashMap(m7638a.size());
            for (String str2 : parse.getQueryParameterNames()) {
                String queryParameter = parse.getQueryParameter(str2);
                if (m7638a.containsKey(queryParameter)) {
                    hashMap.put(str2, this.f939d.m7733e(m7638a.get(queryParameter)));
                } else {
                    clearQuery.appendQueryParameter(str2, queryParameter);
                }
            }
            m7635a(clearQuery.build().toString(), hashMap);
        }
    }
}
