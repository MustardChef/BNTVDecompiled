package com.applovin.impl.mediation.debugger.p020ui.p022b;

import android.content.Context;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.mediation.debugger.p016a.p017a.C1402a;
import com.applovin.impl.mediation.debugger.p016a.p018b.C1407b;
import com.applovin.impl.mediation.debugger.p020ui.p022b.p023a.C1439a;
import com.applovin.impl.mediation.debugger.p020ui.p022b.p023a.C1440b;
import com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d;
import com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c;
import com.applovin.impl.mediation.debugger.p020ui.p025d.C1459e;
import com.applovin.impl.sdk.C1648h;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.utils.C1723e;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.C1799R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.mediation.debugger.ui.b.b */
/* loaded from: classes.dex */
public class C1441b extends AbstractView$OnClickListenerC1456d implements AppLovinCommunicatorSubscriber {

    /* renamed from: a */
    private C1662k f1150a;

    /* renamed from: b */
    private List<C1402a> f1151b;

    /* renamed from: d */
    private String f1152d;

    /* renamed from: e */
    private String f1153e;

    /* renamed from: f */
    private String f1154f;

    /* renamed from: g */
    private final StringBuilder f1155g;

    /* renamed from: h */
    private final AtomicBoolean f1156h;

    /* renamed from: i */
    private boolean f1157i;

    /* renamed from: j */
    private List<C1407b> f1158j;

    /* renamed from: k */
    private List<C1407b> f1159k;

    /* renamed from: l */
    private List<C1407b> f1160l;

    /* renamed from: m */
    private List<C1407b> f1161m;

    /* renamed from: n */
    private List<C1452c> f1162n;

    /* renamed from: o */
    private List<C1452c> f1163o;

    /* renamed from: p */
    private List<C1452c> f1164p;

    /* renamed from: q */
    private List<C1452c> f1165q;

    /* renamed from: r */
    private List<C1452c> f1166r;

    /* renamed from: s */
    private List<C1452c> f1167s;

    /* renamed from: t */
    private List<C1452c> f1168t;

    /* renamed from: com.applovin.impl.mediation.debugger.ui.b.b$a */
    /* loaded from: classes.dex */
    public enum EnumC1443a {
        AD_UNITS,
        SELECT_LIVE_NETWORKS,
        COUNT
    }

    /* renamed from: com.applovin.impl.mediation.debugger.ui.b.b$b */
    /* loaded from: classes.dex */
    public enum EnumC1444b {
        APP_INFO,
        MAX,
        PRIVACY,
        ADS,
        INCOMPLETE_NETWORKS,
        COMPLETED_NETWORKS,
        MISSING_NETWORKS,
        COUNT
    }

    public C1441b(Context context) {
        super(context);
        this.f1155g = new StringBuilder("");
        this.f1156h = new AtomicBoolean();
        this.f1157i = false;
        this.f1158j = new ArrayList();
        this.f1159k = new ArrayList();
        this.f1160l = new ArrayList();
        this.f1161m = new ArrayList();
        this.f1162n = new ArrayList();
        this.f1163o = new ArrayList();
        this.f1164p = new ArrayList();
        this.f1165q = new ArrayList();
        this.f1166r = new ArrayList();
        this.f1167s = new ArrayList();
        this.f1168t = new ArrayList();
    }

    /* renamed from: a */
    private C1452c m7449a(String str, String str2) {
        C1452c.C1454a m7389a = C1452c.m7394p().m7389a(str);
        if (StringUtils.isValidString(str2)) {
            m7389a.m7385b(str2);
        } else {
            m7389a.m7392a(C1799R.C1801drawable.applovin_ic_x_mark);
            m7389a.m7383c(C1723e.m6281a(C1799R.C1800color.applovin_sdk_xmarkColor, this.f1246c));
        }
        return m7389a.m7393a();
    }

    /* renamed from: a */
    private void m7450a(C1452c.C1454a c1454a, String str) {
        c1454a.m7382c("MAX Ad Review").m7381d(str).m7392a(C1799R.C1801drawable.applovin_ic_x_mark).m7383c(C1723e.m6281a(C1799R.C1800color.applovin_sdk_xmarkColor, this.f1246c)).m7388a(true);
    }

    /* renamed from: a */
    private void m7448a(StringBuilder sb, String str) {
        String sb2 = sb.toString();
        if (sb2.length() + str.length() >= ((Integer) this.f1150a.m6656a(C1568b.f1691ak)).intValue()) {
            C1710r.m6313f("MediationDebuggerListAdapter", sb2);
            this.f1155g.append(sb2);
            sb.setLength(1);
        }
        sb.append(str);
    }

    /* renamed from: a */
    private void m7447a(List<C1407b> list) {
        List<C1407b> list2;
        for (C1407b c1407b : list) {
            if (c1407b.m7533a() == C1407b.EnumC1408a.INCOMPLETE_INTEGRATION || c1407b.m7533a() == C1407b.EnumC1408a.INVALID_INTEGRATION) {
                list2 = this.f1158j;
            } else if (c1407b.m7533a() == C1407b.EnumC1408a.COMPLETE) {
                this.f1159k.add(c1407b);
                list2 = this.f1161m;
            } else if (c1407b.m7533a() == C1407b.EnumC1408a.MISSING) {
                list2 = this.f1160l;
            }
            list2.add(c1407b);
        }
    }

    /* renamed from: b */
    private List<C1452c> m7444b(List<C1407b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (C1407b c1407b : list) {
            arrayList.add(new C1439a(c1407b, this.f1246c));
        }
        return arrayList;
    }

    /* renamed from: j */
    private void m7437j() {
        Map<String, String> metaData;
        StringBuilder sb = new StringBuilder("\n========== MEDIATION DEBUGGER ==========");
        sb.append("\n========== APP INFO ==========");
        sb.append("\nDev Build - " + Utils.isPubInDebugMode(this.f1246c));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nTest Mode - ");
        sb2.append(this.f1150a.m6679H().m7351a() ? "enabled" : "disabled");
        sb.append(sb2.toString());
        sb.append("\nTarget SDK - " + this.f1150a.m6667T().m6546g().get("target_sdk"));
        sb.append("\n========== MAX ==========");
        String str = AppLovinSdk.VERSION;
        String str2 = (String) this.f1150a.m6656a(C1568b.f1863dz);
        String safedkVersion = Utils.getSafedkVersion();
        sb.append("\nSDK Version - " + str);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("\nPlugin Version - ");
        if (!StringUtils.isValidString(str2)) {
            str2 = "None";
        }
        sb3.append(str2);
        sb.append(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("\nAd Review Version - ");
        if (!StringUtils.isValidString(safedkVersion)) {
            safedkVersion = "Disabled";
        }
        sb4.append(safedkVersion);
        sb.append(sb4.toString());
        if (this.f1150a.m6607g() && (metaData = Utils.getMetaData(this.f1150a.m6598p())) != null) {
            String str3 = metaData.get("UnityVersion");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\nUnity Version - ");
            sb5.append(StringUtils.isValidString(str3) ? str3 : "None");
            sb.append(sb5.toString());
        }
        sb.append("\n========== PRIVACY ==========");
        sb.append(C1648h.m6722a(this.f1246c));
        sb.append("\n========== NETWORKS ==========");
        for (C1407b c1407b : this.f1159k) {
            m7448a(sb, c1407b.m7509t());
        }
        for (C1407b c1407b2 : this.f1158j) {
            m7448a(sb, c1407b2.m7509t());
        }
        sb.append("\n========== AD UNITS ==========");
        for (C1402a c1402a : this.f1151b) {
            m7448a(sb, c1402a.m7550f());
        }
        sb.append("\n========== END ==========");
        C1710r.m6313f("MediationDebuggerListAdapter", sb.toString());
        this.f1155g.append(sb.toString());
    }

    /* renamed from: k */
    private List<C1452c> m7436k() {
        String str;
        ArrayList arrayList = new ArrayList(5);
        try {
            str = this.f1246c.getPackageManager().getPackageInfo(this.f1246c.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            str = null;
        }
        arrayList.add(C1452c.m7394p().m7389a("Package Name").m7385b(this.f1246c.getPackageName()).m7393a());
        C1452c.C1454a m7389a = C1452c.m7394p().m7389a("App Version");
        if (!StringUtils.isValidString(str)) {
            str = "None";
        }
        arrayList.add(m7389a.m7385b(str).m7393a());
        arrayList.add(C1452c.m7394p().m7389a("OS").m7385b(Utils.getAndroidOSInfo()).m7393a());
        arrayList.add(C1452c.m7394p().m7389a("Account").m7385b(StringUtils.isValidString(this.f1154f) ? this.f1154f : "None").m7393a());
        arrayList.add(C1452c.m7394p().m7389a("Mediation Provider").m7385b(StringUtils.isValidString(this.f1150a.m6595s()) ? this.f1150a.m6595s() : "None").m7393a());
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00c4  */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c> m7435l() {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 4
            r0.<init>(r1)
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c.m7394p()
            java.lang.String r2 = "SDK Version"
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = r1.m7389a(r2)
            java.lang.String r2 = com.applovin.sdk.AppLovinSdk.VERSION
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = r1.m7385b(r2)
            com.applovin.impl.mediation.debugger.ui.d.c r1 = r1.m7393a()
            r0.add(r1)
            com.applovin.impl.sdk.k r1 = r6.f1150a
            com.applovin.impl.sdk.c.b<java.lang.String> r2 = com.applovin.impl.sdk.p029c.C1568b.f1863dz
            java.lang.Object r1 = r1.m6656a(r2)
            java.lang.String r1 = (java.lang.String) r1
            com.applovin.impl.mediation.debugger.ui.d.c$a r2 = com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c.m7394p()
            java.lang.String r3 = "Plugin Version"
            com.applovin.impl.mediation.debugger.ui.d.c$a r2 = r2.m7389a(r3)
            boolean r3 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r1)
            java.lang.String r4 = "None"
            if (r3 == 0) goto L3a
            goto L3b
        L3a:
            r1 = r4
        L3b:
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = r2.m7385b(r1)
            com.applovin.impl.mediation.debugger.ui.d.c r1 = r1.m7393a()
            r0.add(r1)
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c.m7394p()
            java.lang.String r2 = "Ad Review Version"
            com.applovin.impl.mediation.debugger.ui.d.c$a r1 = r1.m7389a(r2)
            java.lang.String r2 = com.applovin.impl.sdk.utils.Utils.getSafedkVersion()
            boolean r3 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r2)
            if (r3 == 0) goto L96
            java.lang.String r3 = com.applovin.impl.sdk.utils.Utils.getSafedkSdkKey()
            boolean r5 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r3)
            if (r5 == 0) goto L92
            com.applovin.impl.sdk.k r5 = r6.f1150a
            java.lang.String r5 = r5.m6590x()
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L71
            goto L92
        L71:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "MAX Ad Review integrated with wrong SDK key. Please check that your "
            r2.<init>(r3)
            com.applovin.impl.sdk.k r3 = r6.f1150a
            boolean r3 = r3.m6607g()
            if (r3 == 0) goto L83
            java.lang.String r3 = "SDK key is downloaded"
            goto L85
        L83:
            java.lang.String r3 = "Gradle plugin snippet is integrated"
        L85:
            r2.append(r3)
            java.lang.String r3 = " from the correct account."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            goto L98
        L92:
            r1.m7385b(r2)
            goto L9b
        L96:
            java.lang.String r2 = "Integrating MAX Ad review is OPTIONAL. This feature gives developers unprecedented transparency into the creatives the users see in their apps."
        L98:
            r6.m7450a(r1, r2)
        L9b:
            com.applovin.impl.mediation.debugger.ui.d.c r1 = r1.m7393a()
            r0.add(r1)
            com.applovin.impl.sdk.k r1 = r6.f1150a
            boolean r1 = r1.m6607g()
            if (r1 == 0) goto Lce
            com.applovin.impl.sdk.k r1 = r6.f1150a
            com.applovin.sdk.AppLovinSdkSettings r1 = r1.m6598p()
            java.util.Map r1 = com.applovin.impl.sdk.utils.Utils.getMetaData(r1)
            if (r1 == 0) goto Lce
            java.lang.String r2 = "UnityVersion"
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            boolean r2 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r1)
            if (r2 == 0) goto Lc5
            r4 = r1
        Lc5:
            java.lang.String r1 = "Unity Version"
            com.applovin.impl.mediation.debugger.ui.d.c r1 = r6.m7449a(r1, r4)
            r0.add(r1)
        Lce:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.debugger.p020ui.p022b.C1441b.m7435l():java.util.List");
    }

    /* renamed from: m */
    private List<C1452c> m7434m() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new C1440b(C1648h.m6723a(), true, this.f1246c));
        arrayList.add(new C1440b(C1648h.m6718b(), false, this.f1246c));
        arrayList.add(new C1440b(C1648h.m6716c(), true, this.f1246c));
        return arrayList;
    }

    /* renamed from: n */
    private List<C1452c> m7433n() {
        ArrayList arrayList = new ArrayList(2);
        C1452c.C1454a m7394p = C1452c.m7394p();
        arrayList.add(m7394p.m7389a("View Ad Units (" + this.f1151b.size() + ")").m7391a(this.f1246c).m7388a(true).m7393a());
        arrayList.add(m7432o());
        return arrayList;
    }

    /* renamed from: o */
    private C1452c m7432o() {
        C1452c.C1454a m7394p = C1452c.m7394p();
        if (!this.f1150a.m6679H().m7351a()) {
            m7394p.m7391a(this.f1246c);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1150a.m6679H().m7345c() != null ? "" : "Select ");
        sb.append("Live Network");
        return m7394p.m7389a(sb.toString()).m7385b(this.f1150a.m6679H().m7351a() ? "Enable" : null).m7387b(-16776961).m7381d("Ad loads are not supported while Test Mode is enabled. Please restart the app and make sure your GAID has not been enabled for test mode and that you are not on an emulator.").m7388a(true).m7393a();
    }

    @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d
    /* renamed from: a */
    protected int mo7369a(int i) {
        return (i == EnumC1444b.APP_INFO.ordinal() ? this.f1162n : i == EnumC1444b.MAX.ordinal() ? this.f1163o : i == EnumC1444b.PRIVACY.ordinal() ? this.f1164p : i == EnumC1444b.ADS.ordinal() ? this.f1165q : i == EnumC1444b.INCOMPLETE_NETWORKS.ordinal() ? this.f1166r : i == EnumC1444b.COMPLETED_NETWORKS.ordinal() ? this.f1167s : this.f1168t).size();
    }

    /* renamed from: a */
    public void m7446a(List<C1407b> list, List<C1402a> list2, String str, String str2, String str3, C1662k c1662k) {
        this.f1150a = c1662k;
        this.f1151b = list2;
        this.f1152d = str;
        this.f1153e = str2;
        this.f1154f = str3;
        if (list != null && this.f1156h.compareAndSet(false, true)) {
            c1662k.m6588z().m6319b("MediationDebuggerListAdapter", "Populating networks...");
            m7447a(list);
            this.f1162n.addAll(m7436k());
            this.f1163o.addAll(m7435l());
            this.f1164p.addAll(m7434m());
            this.f1165q.addAll(m7433n());
            this.f1166r = m7444b(this.f1158j);
            this.f1167s = m7444b(this.f1159k);
            this.f1168t = m7444b(this.f1160l);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add("privacy_setting_updated");
            arrayList.add("network_sdk_version_updated");
            AppLovinCommunicator.getInstance(this.f1246c).subscribe(this, arrayList);
            m7437j();
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.mediation.debugger.ui.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                C1441b.this.notifyDataSetChanged();
            }
        });
    }

    /* renamed from: a */
    public void m7445a(boolean z) {
        this.f1157i = z;
    }

    /* renamed from: a */
    public boolean m7451a() {
        return this.f1156h.get();
    }

    @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d
    /* renamed from: b */
    protected int mo7368b() {
        return EnumC1444b.COUNT.ordinal();
    }

    @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d
    /* renamed from: b */
    protected C1452c mo7367b(int i) {
        return i == EnumC1444b.APP_INFO.ordinal() ? new C1459e("APP INFO") : i == EnumC1444b.MAX.ordinal() ? new C1459e("MAX") : i == EnumC1444b.PRIVACY.ordinal() ? new C1459e("PRIVACY") : i == EnumC1444b.ADS.ordinal() ? new C1459e("ADS") : i == EnumC1444b.INCOMPLETE_NETWORKS.ordinal() ? new C1459e("INCOMPLETE INTEGRATIONS") : i == EnumC1444b.COMPLETED_NETWORKS.ordinal() ? new C1459e("COMPLETED INTEGRATIONS") : new C1459e("MISSING INTEGRATIONS");
    }

    @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d
    /* renamed from: c */
    protected List<C1452c> mo7366c(int i) {
        return i == EnumC1444b.APP_INFO.ordinal() ? this.f1162n : i == EnumC1444b.MAX.ordinal() ? this.f1163o : i == EnumC1444b.PRIVACY.ordinal() ? this.f1164p : i == EnumC1444b.ADS.ordinal() ? this.f1165q : i == EnumC1444b.INCOMPLETE_NETWORKS.ordinal() ? this.f1166r : i == EnumC1444b.COMPLETED_NETWORKS.ordinal() ? this.f1167s : this.f1168t;
    }

    /* renamed from: c */
    public boolean m7443c() {
        return this.f1157i;
    }

    /* renamed from: d */
    public C1662k m7442d() {
        return this.f1150a;
    }

    /* renamed from: e */
    public List<C1402a> m7441e() {
        return this.f1151b;
    }

    /* renamed from: f */
    public String m7440f() {
        return this.f1152d;
    }

    /* renamed from: g */
    public String m7439g() {
        return this.f1153e;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "MediationDebuggerListAdapter";
    }

    /* renamed from: h */
    public List<C1407b> m7438h() {
        return this.f1161m;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("privacy_setting_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            this.f1164p = m7434m();
        } else if (!"network_sdk_version_updated".equals(appLovinCommunicatorMessage.getTopic())) {
            return;
        } else {
            this.f1166r = m7444b(this.f1158j);
            this.f1167s = m7444b(this.f1159k);
        }
        m7374i();
    }

    public String toString() {
        return "MediationDebuggerListAdapter{isInitialized=" + this.f1156h.get() + "}";
    }
}
