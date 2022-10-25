package com.applovin.impl.mediation.debugger.p016a.p018b;

import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.mediation.p015c.C1391c;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.a.b.b */
/* loaded from: classes.dex */
public class C1407b implements AppLovinCommunicatorSubscriber, Comparable<C1407b> {

    /* renamed from: a */
    private final C1662k f1032a;

    /* renamed from: b */
    private final EnumC1408a f1033b;

    /* renamed from: c */
    private int f1034c;

    /* renamed from: d */
    private final boolean f1035d;

    /* renamed from: e */
    private final boolean f1036e;

    /* renamed from: f */
    private final boolean f1037f;

    /* renamed from: g */
    private final boolean f1038g;

    /* renamed from: h */
    private final boolean f1039h;

    /* renamed from: i */
    private final boolean f1040i;

    /* renamed from: j */
    private final String f1041j;

    /* renamed from: k */
    private final String f1042k;

    /* renamed from: l */
    private final String f1043l;

    /* renamed from: m */
    private String f1044m;

    /* renamed from: n */
    private final String f1045n;

    /* renamed from: o */
    private final String f1046o;

    /* renamed from: p */
    private final int f1047p;

    /* renamed from: q */
    private final List<MaxAdFormat> f1048q;

    /* renamed from: r */
    private final List<C1411d> f1049r;

    /* renamed from: s */
    private final List<C1406a> f1050s;

    /* renamed from: t */
    private final List<String> f1051t;

    /* renamed from: u */
    private final C1410c f1052u;

    /* renamed from: com.applovin.impl.mediation.debugger.a.b.b$a */
    /* loaded from: classes.dex */
    public enum EnumC1408a {
        MISSING("MISSING"),
        INCOMPLETE_INTEGRATION("INCOMPLETE INTEGRATION"),
        INVALID_INTEGRATION("INVALID INTEGRATION"),
        COMPLETE("COMPLETE");
        

        /* renamed from: e */
        private final String f1058e;

        EnumC1408a(String str) {
            this.f1058e = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public String m7507a() {
            return this.f1058e;
        }
    }

    /* renamed from: com.applovin.impl.mediation.debugger.a.b.b$b */
    /* loaded from: classes.dex */
    public enum EnumC1409b {
        NOT_SUPPORTED("Not Supported", SupportMenu.CATEGORY_MASK, "This network does not support test mode."),
        INVALID_INTEGRATION("Invalid Integration", SupportMenu.CATEGORY_MASK, "Please address all the integration issue(s) marked in red above."),
        NOT_INITIALIZED("Not Initialized", SupportMenu.CATEGORY_MASK, "Please configure this network in your MAX dashboard."),
        DISABLED("Enable", -16776961, "Please re-launch the app to enable test ads."),
        READY("", -16776961, "");
        

        /* renamed from: f */
        private final String f1065f;

        /* renamed from: g */
        private final int f1066g;

        /* renamed from: h */
        private final String f1067h;

        EnumC1409b(String str, int i, String str2) {
            this.f1065f = str;
            this.f1066g = i;
            this.f1067h = str2;
        }

        /* renamed from: a */
        public String m7505a() {
            return this.f1065f;
        }

        /* renamed from: b */
        public int m7504b() {
            return this.f1066g;
        }

        /* renamed from: c */
        public String m7503c() {
            return this.f1067h;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x010c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C1407b(org.json.JSONObject r12, com.applovin.impl.sdk.C1662k r13) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.debugger.p016a.p018b.C1407b.<init>(org.json.JSONObject, com.applovin.impl.sdk.k):void");
    }

    /* renamed from: a */
    private List<MaxAdFormat> m7531a(MaxAdapter maxAdapter) {
        ArrayList arrayList = new ArrayList(5);
        if (maxAdapter instanceof MaxInterstitialAdapter) {
            arrayList.add(MaxAdFormat.INTERSTITIAL);
        }
        if (maxAdapter instanceof MaxRewardedAdapter) {
            arrayList.add(MaxAdFormat.REWARDED);
        }
        if (maxAdapter instanceof MaxRewardedInterstitialAdapter) {
            arrayList.add(MaxAdFormat.REWARDED_INTERSTITIAL);
        }
        if (maxAdapter instanceof MaxAdViewAdapter) {
            arrayList.add(MaxAdFormat.BANNER);
            arrayList.add(MaxAdFormat.LEADER);
            arrayList.add(MaxAdFormat.MREC);
        }
        return arrayList;
    }

    /* renamed from: a */
    private List<String> m7530a(JSONObject jSONObject) {
        return JsonUtils.optList(JsonUtils.getJSONArray(jSONObject, "supported_regions", null), null);
    }

    /* renamed from: a */
    private List<C1411d> m7529a(JSONObject jSONObject, C1662k c1662k) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "permissions", new JSONObject());
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                arrayList.add(new C1411d(next, jSONObject2.getString(next), c1662k.m6677J()));
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private List<C1406a> m7527b(JSONObject jSONObject, C1662k c1662k) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "dependencies", new JSONArray());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject2 != null) {
                arrayList.add(new C1406a(jSONObject2, c1662k));
            }
        }
        return arrayList;
    }

    /* renamed from: u */
    private EnumC1408a m7508u() {
        if (this.f1035d || this.f1036e) {
            for (C1411d c1411d : this.f1049r) {
                if (!c1411d.m7497c()) {
                    return EnumC1408a.INVALID_INTEGRATION;
                }
            }
            for (C1406a c1406a : this.f1050s) {
                if (!c1406a.m7534c()) {
                    return EnumC1408a.INVALID_INTEGRATION;
                }
            }
            if (!this.f1052u.m7502a() || this.f1052u.m7501b()) {
                if (this.f1035d) {
                    if (this.f1036e) {
                        return EnumC1408a.COMPLETE;
                    }
                    if (this.f1038g) {
                        return EnumC1408a.MISSING;
                    }
                }
                return EnumC1408a.INCOMPLETE_INTEGRATION;
            }
            return EnumC1408a.INVALID_INTEGRATION;
        }
        return EnumC1408a.MISSING;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(C1407b c1407b) {
        return this.f1042k.compareToIgnoreCase(c1407b.f1042k);
    }

    /* renamed from: a */
    public EnumC1408a m7533a() {
        return this.f1033b;
    }

    /* renamed from: b */
    public int m7528b() {
        return this.f1034c;
    }

    /* renamed from: c */
    public EnumC1409b m7526c() {
        return !this.f1039h ? EnumC1409b.NOT_SUPPORTED : this.f1033b == EnumC1408a.INVALID_INTEGRATION ? EnumC1409b.INVALID_INTEGRATION : !this.f1032a.m6679H().m7351a() ? EnumC1409b.DISABLED : (this.f1040i && (this.f1034c == MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.getCode() || this.f1034c == MaxAdapter.InitializationStatus.INITIALIZING.getCode())) ? EnumC1409b.NOT_INITIALIZED : EnumC1409b.READY;
    }

    /* renamed from: d */
    public boolean m7525d() {
        return this.f1035d;
    }

    /* renamed from: e */
    public boolean m7524e() {
        return this.f1036e;
    }

    /* renamed from: f */
    public boolean m7523f() {
        return this.f1037f;
    }

    /* renamed from: g */
    public String m7522g() {
        return this.f1041j;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "MediatedNetwork";
    }

    /* renamed from: h */
    public String m7521h() {
        return this.f1042k;
    }

    /* renamed from: i */
    public String m7520i() {
        return this.f1044m;
    }

    /* renamed from: j */
    public String m7519j() {
        return this.f1045n;
    }

    /* renamed from: k */
    public String m7518k() {
        return this.f1046o;
    }

    /* renamed from: l */
    public String m7517l() {
        return this.f1043l;
    }

    /* renamed from: m */
    public List<String> m7516m() {
        return this.f1051t;
    }

    /* renamed from: n */
    public int m7515n() {
        return this.f1047p;
    }

    /* renamed from: o */
    public List<MaxAdFormat> m7514o() {
        return this.f1048q;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        String string = appLovinCommunicatorMessage.getMessageData().getString("adapter_class", "");
        if (this.f1043l.equals(string)) {
            this.f1034c = appLovinCommunicatorMessage.getMessageData().getInt("init_status", 0);
            MaxAdapter m7596a = C1391c.m7596a(string, this.f1032a);
            if (m7596a == null || this.f1044m.equals(m7596a.getSdkVersion())) {
                return;
            }
            this.f1044m = m7596a.getSdkVersion();
            this.f1032a.m6634af().m6727a(this.f1044m, string);
        }
    }

    /* renamed from: p */
    public List<C1411d> m7513p() {
        return this.f1049r;
    }

    /* renamed from: q */
    public List<C1406a> m7512q() {
        return this.f1050s;
    }

    /* renamed from: r */
    public final C1410c m7511r() {
        return this.f1052u;
    }

    /* renamed from: s */
    public final C1662k m7510s() {
        return this.f1032a;
    }

    /* renamed from: t */
    public final String m7509t() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n---------- ");
        sb.append(this.f1041j);
        sb.append(" ----------");
        sb.append("\nStatus  - ");
        sb.append(this.f1033b.m7507a());
        sb.append("\nSDK     - ");
        String str = "UNAVAILABLE";
        sb.append((!this.f1035d || TextUtils.isEmpty(this.f1044m)) ? "UNAVAILABLE" : this.f1044m);
        sb.append("\nAdapter - ");
        if (this.f1036e && !TextUtils.isEmpty(this.f1045n)) {
            str = this.f1045n;
        }
        sb.append(str);
        if (this.f1052u.m7502a() && !this.f1052u.m7501b()) {
            sb.append("\n* ");
            sb.append(this.f1052u.m7500c());
        }
        for (C1411d c1411d : m7513p()) {
            if (!c1411d.m7497c()) {
                sb.append("\n* MISSING ");
                sb.append(c1411d.m7499a());
                sb.append(": ");
                sb.append(c1411d.m7498b());
            }
        }
        for (C1406a c1406a : m7512q()) {
            if (!c1406a.m7534c()) {
                sb.append("\n* MISSING ");
                sb.append(c1406a.m7536a());
                sb.append(": ");
                sb.append(c1406a.m7535b());
            }
        }
        return sb.toString();
    }

    public String toString() {
        return "MediatedNetwork{name=" + this.f1041j + ", displayName=" + this.f1042k + ", sdkAvailable=" + this.f1035d + ", sdkVersion=" + this.f1044m + ", adapterAvailable=" + this.f1036e + ", adapterVersion=" + this.f1045n + "}";
    }
}
