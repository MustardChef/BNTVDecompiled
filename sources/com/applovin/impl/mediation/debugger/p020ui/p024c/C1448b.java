package com.applovin.impl.mediation.debugger.p020ui.p024c;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import com.applovin.impl.mediation.debugger.p016a.p018b.C1406a;
import com.applovin.impl.mediation.debugger.p016a.p018b.C1407b;
import com.applovin.impl.mediation.debugger.p016a.p018b.C1410c;
import com.applovin.impl.mediation.debugger.p016a.p018b.C1411d;
import com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d;
import com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c;
import com.applovin.impl.mediation.debugger.p020ui.p025d.C1459e;
import com.applovin.impl.sdk.utils.C1723e;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.C1799R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.applovin.impl.mediation.debugger.ui.c.b */
/* loaded from: classes.dex */
public class C1448b extends AbstractView$OnClickListenerC1456d {

    /* renamed from: a */
    private final C1407b f1188a;

    /* renamed from: b */
    private List<C1452c> f1189b;

    /* renamed from: d */
    private final List<C1452c> f1190d;

    /* renamed from: e */
    private final List<C1452c> f1191e;

    /* renamed from: f */
    private final List<C1452c> f1192f;

    /* renamed from: g */
    private final List<C1452c> f1193g;

    /* renamed from: h */
    private SpannedString f1194h;

    /* renamed from: com.applovin.impl.mediation.debugger.ui.c.b$a */
    /* loaded from: classes.dex */
    public enum EnumC1449a {
        INTEGRATIONS,
        PERMISSIONS,
        CONFIGURATION,
        DEPENDENCIES,
        TEST_ADS,
        COUNT
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1448b(C1407b c1407b, Context context) {
        super(context);
        this.f1188a = c1407b;
        if (c1407b.m7533a() == C1407b.EnumC1408a.INVALID_INTEGRATION) {
            SpannableString spannableString = new SpannableString("Tap for more information");
            spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, spannableString.length(), 33);
            this.f1194h = new SpannedString(spannableString);
        } else {
            this.f1194h = new SpannedString("");
        }
        this.f1189b = m7419d();
        this.f1190d = m7425a(c1407b.m7513p());
        this.f1191e = m7426a(c1407b.m7511r());
        this.f1192f = m7423b(c1407b.m7512q());
        this.f1193g = m7414h();
        notifyDataSetChanged();
    }

    /* renamed from: a */
    private int m7424a(boolean z) {
        return z ? C1799R.C1801drawable.applovin_ic_check_mark_bordered : C1799R.C1801drawable.applovin_ic_x_mark;
    }

    /* renamed from: a */
    private C1452c m7427a(C1407b.EnumC1409b enumC1409b) {
        C1452c.C1454a m7394p = C1452c.m7394p();
        if (enumC1409b == C1407b.EnumC1409b.READY) {
            m7394p.m7391a(this.f1246c);
        }
        return m7394p.m7389a("Test Mode").m7385b(enumC1409b.m7505a()).m7387b(enumC1409b.m7504b()).m7381d(enumC1409b.m7503c()).m7388a(true).m7393a();
    }

    /* renamed from: a */
    private List<C1452c> m7426a(C1410c c1410c) {
        ArrayList arrayList = new ArrayList(1);
        if (c1410c.m7502a()) {
            boolean m7501b = c1410c.m7501b();
            arrayList.add(C1452c.m7407a(m7501b ? C1452c.EnumC1455b.RIGHT_DETAIL : C1452c.EnumC1455b.DETAIL).m7389a("Cleartext Traffic").m7386b(m7501b ? null : this.f1194h).m7381d(c1410c.m7500c()).m7392a(m7424a(m7501b)).m7383c(m7422b(m7501b)).m7388a(true ^ m7501b).m7393a());
        }
        return arrayList;
    }

    /* renamed from: a */
    private List<C1452c> m7425a(List<C1411d> list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list.size() > 0) {
            for (C1411d c1411d : list) {
                boolean m7497c = c1411d.m7497c();
                arrayList.add(C1452c.m7407a(m7497c ? C1452c.EnumC1455b.RIGHT_DETAIL : C1452c.EnumC1455b.DETAIL).m7389a(c1411d.m7499a()).m7386b(m7497c ? null : this.f1194h).m7381d(c1411d.m7498b()).m7392a(m7424a(m7497c)).m7383c(m7422b(m7497c)).m7388a(!m7497c).m7393a());
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private int m7422b(boolean z) {
        return C1723e.m6281a(z ? C1799R.C1800color.applovin_sdk_checkmarkColor : C1799R.C1800color.applovin_sdk_xmarkColor, this.f1246c);
    }

    /* renamed from: b */
    private List<C1452c> m7423b(List<C1406a> list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list.size() > 0) {
            for (C1406a c1406a : list) {
                boolean m7534c = c1406a.m7534c();
                arrayList.add(C1452c.m7407a(m7534c ? C1452c.EnumC1455b.RIGHT_DETAIL : C1452c.EnumC1455b.DETAIL).m7389a(c1406a.m7536a()).m7386b(m7534c ? null : this.f1194h).m7381d(c1406a.m7535b()).m7392a(m7424a(m7534c)).m7383c(m7422b(m7534c)).m7388a(!m7534c).m7393a());
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    private C1452c m7420c(List<String> list) {
        return C1452c.m7394p().m7389a("Region/VPN Required").m7385b(CollectionUtils.implode(list, ", ", list.size())).m7393a();
    }

    /* renamed from: d */
    private List<C1452c> m7419d() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(m7418e());
        arrayList.add(m7416f());
        arrayList.add(m7415g());
        return arrayList;
    }

    /* renamed from: e */
    private C1452c m7418e() {
        C1452c.C1454a m7385b = C1452c.m7394p().m7389a("SDK").m7385b(this.f1188a.m7520i());
        if (TextUtils.isEmpty(this.f1188a.m7520i())) {
            m7385b.m7392a(m7424a(this.f1188a.m7525d())).m7383c(m7422b(this.f1188a.m7525d()));
        }
        return m7385b.m7393a();
    }

    /* renamed from: e */
    private String m7417e(int i) {
        return (MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS.getCode() == i || MaxAdapter.InitializationStatus.INITIALIZED_UNKNOWN.getCode() == i || MaxAdapter.InitializationStatus.DOES_NOT_APPLY.getCode() == i) ? "Initialized" : MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.getCode() == i ? "Failure" : MaxAdapter.InitializationStatus.INITIALIZING.getCode() == i ? "Initializing..." : "Waiting to Initialize...";
    }

    /* renamed from: f */
    private C1452c m7416f() {
        C1452c.C1454a m7385b = C1452c.m7394p().m7389a("Adapter").m7385b(this.f1188a.m7519j());
        if (TextUtils.isEmpty(this.f1188a.m7519j())) {
            m7385b.m7392a(m7424a(this.f1188a.m7524e())).m7383c(m7422b(this.f1188a.m7524e()));
        }
        return m7385b.m7393a();
    }

    /* renamed from: g */
    private C1452c m7415g() {
        C1452c.C1454a m7385b;
        boolean z = false;
        if (this.f1188a.m7510s().m6685B().m7338b()) {
            m7385b = C1452c.m7394p().m7389a("Initialize with Activity Context").m7381d("Please ensure that you are initializing the AppLovin MAX SDK with an Activity Context.").m7392a(m7424a(false)).m7383c(m7422b(false));
            z = true;
        } else {
            m7385b = C1452c.m7394p().m7389a("Initialization Status").m7385b(m7417e(this.f1188a.m7528b()));
        }
        return m7385b.m7388a(z).m7393a();
    }

    /* renamed from: h */
    private List<C1452c> m7414h() {
        ArrayList arrayList = new ArrayList(2);
        if (this.f1188a.m7526c() != C1407b.EnumC1409b.NOT_SUPPORTED) {
            if (this.f1188a.m7516m() != null) {
                arrayList.add(m7420c(this.f1188a.m7516m()));
            }
            arrayList.add(m7427a(this.f1188a.m7526c()));
        }
        return arrayList;
    }

    @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d
    /* renamed from: a */
    protected int mo7369a(int i) {
        return (i == EnumC1449a.INTEGRATIONS.ordinal() ? this.f1189b : i == EnumC1449a.PERMISSIONS.ordinal() ? this.f1190d : i == EnumC1449a.CONFIGURATION.ordinal() ? this.f1191e : i == EnumC1449a.DEPENDENCIES.ordinal() ? this.f1192f : this.f1193g).size();
    }

    /* renamed from: a */
    public C1407b m7428a() {
        return this.f1188a;
    }

    @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d
    /* renamed from: b */
    protected int mo7368b() {
        return EnumC1449a.COUNT.ordinal();
    }

    @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d
    /* renamed from: b */
    protected C1452c mo7367b(int i) {
        return i == EnumC1449a.INTEGRATIONS.ordinal() ? new C1459e("INTEGRATIONS") : i == EnumC1449a.PERMISSIONS.ordinal() ? new C1459e("PERMISSIONS") : i == EnumC1449a.CONFIGURATION.ordinal() ? new C1459e("CONFIGURATION") : i == EnumC1449a.DEPENDENCIES.ordinal() ? new C1459e("DEPENDENCIES") : new C1459e("TEST ADS");
    }

    @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d
    /* renamed from: c */
    protected List<C1452c> mo7366c(int i) {
        return i == EnumC1449a.INTEGRATIONS.ordinal() ? this.f1189b : i == EnumC1449a.PERMISSIONS.ordinal() ? this.f1190d : i == EnumC1449a.CONFIGURATION.ordinal() ? this.f1191e : i == EnumC1449a.DEPENDENCIES.ordinal() ? this.f1192f : this.f1193g;
    }

    /* renamed from: c */
    public void m7421c() {
        this.f1189b = m7419d();
    }

    public String toString() {
        return "MediatedNetworkListAdapter{}";
    }
}
