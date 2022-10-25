package com.applovin.impl.mediation.debugger.p020ui.p021a;

import android.content.Context;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.applovin.impl.mediation.debugger.p016a.p017a.C1402a;
import com.applovin.impl.mediation.debugger.p016a.p017a.C1403b;
import com.applovin.impl.mediation.debugger.p016a.p017a.C1405d;
import com.applovin.impl.mediation.debugger.p020ui.p022b.p023a.C1439a;
import com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d;
import com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c;
import com.applovin.impl.mediation.debugger.p020ui.p025d.C1459e;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.applovin.impl.mediation.debugger.ui.a.b */
/* loaded from: classes.dex */
public class C1422b extends AbstractView$OnClickListenerC1456d {

    /* renamed from: a */
    private final C1402a f1101a;

    /* renamed from: b */
    private final C1403b f1102b;

    /* renamed from: d */
    private final List<C1452c> f1103d;

    /* renamed from: e */
    private final List<C1452c> f1104e;

    /* renamed from: f */
    private final List<C1452c> f1105f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.applovin.impl.mediation.debugger.ui.a.b$a */
    /* loaded from: classes.dex */
    public class C1423a extends C1439a {

        /* renamed from: o */
        private final C1403b f1107o;

        C1423a(C1403b c1403b, String str, boolean z) {
            super(c1403b.m7548a(), C1422b.this.f1246c);
            this.f1107o = c1403b;
            this.f1212d = StringUtils.createSpannedString(c1403b.m7546c(), ViewCompat.MEASURED_STATE_MASK, 18, 1);
            this.f1213e = !TextUtils.isEmpty(str) ? new SpannedString(str) : null;
            this.f1211c = z;
        }

        /* renamed from: a */
        public C1403b m7474a() {
            return this.f1107o;
        }

        @Override // com.applovin.impl.mediation.debugger.p020ui.p022b.p023a.C1439a, com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c
        /* renamed from: b */
        public boolean mo7406b() {
            return this.f1211c;
        }

        @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c
        /* renamed from: c */
        public int mo7405c() {
            return -12303292;
        }
    }

    /* renamed from: com.applovin.impl.mediation.debugger.ui.a.b$b */
    /* loaded from: classes.dex */
    enum EnumC1424b {
        INFO,
        BIDDERS,
        WATERFALL,
        COUNT
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1422b(C1402a c1402a, C1403b c1403b, Context context) {
        super(context);
        this.f1101a = c1402a;
        this.f1102b = c1403b;
        this.f1103d = m7480c();
        this.f1104e = m7479d();
        this.f1105f = m7478e();
        notifyDataSetChanged();
    }

    /* renamed from: c */
    private List<C1452c> m7480c() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(m7477f());
        arrayList.add(m7476g());
        if (this.f1102b != null) {
            arrayList.add(m7475h());
        }
        return arrayList;
    }

    /* renamed from: d */
    private List<C1452c> m7479d() {
        C1403b c1403b = this.f1102b;
        if (c1403b == null || c1403b.m7544e()) {
            List<C1403b> m7542a = this.f1101a.m7551e().m7542a();
            ArrayList arrayList = new ArrayList(m7542a.size());
            for (C1403b c1403b2 : m7542a) {
                C1403b c1403b3 = this.f1102b;
                if (c1403b3 == null || c1403b3.m7547b().equals(c1403b2.m7547b())) {
                    arrayList.add(new C1423a(c1403b2, c1403b2.m7545d() != null ? c1403b2.m7545d().m7538a() : "", this.f1102b == null));
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    /* renamed from: e */
    private List<C1452c> m7478e() {
        C1403b c1403b = this.f1102b;
        if (c1403b == null || !c1403b.m7544e()) {
            List<C1403b> m7540b = this.f1101a.m7551e().m7540b();
            ArrayList arrayList = new ArrayList(m7540b.size());
            for (C1403b c1403b2 : m7540b) {
                C1403b c1403b3 = this.f1102b;
                if (c1403b3 == null || c1403b3.m7547b().equals(c1403b2.m7547b())) {
                    arrayList.add(new C1423a(c1403b2, null, this.f1102b == null));
                    for (C1405d c1405d : c1403b2.m7543f()) {
                        arrayList.add(C1452c.m7394p().m7389a(c1405d.m7538a()).m7385b(c1405d.m7537b()).m7384b(true).m7393a());
                    }
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    /* renamed from: f */
    private C1452c m7477f() {
        return C1452c.m7394p().m7389a("ID").m7385b(this.f1101a.m7556a()).m7393a();
    }

    /* renamed from: g */
    private C1452c m7476g() {
        return C1452c.m7394p().m7389a("Ad Format").m7385b(this.f1101a.m7553c()).m7393a();
    }

    /* renamed from: h */
    private C1452c m7475h() {
        return C1452c.m7394p().m7389a("Selected Network").m7385b(this.f1102b.m7546c()).m7393a();
    }

    @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d
    /* renamed from: a */
    protected int mo7369a(int i) {
        return (i == EnumC1424b.INFO.ordinal() ? this.f1103d : i == EnumC1424b.BIDDERS.ordinal() ? this.f1104e : this.f1105f).size();
    }

    /* renamed from: a */
    public String m7482a() {
        return this.f1101a.m7554b();
    }

    @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d
    /* renamed from: b */
    protected int mo7368b() {
        return EnumC1424b.COUNT.ordinal();
    }

    @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d
    /* renamed from: b */
    protected C1452c mo7367b(int i) {
        return i == EnumC1424b.INFO.ordinal() ? new C1459e("INFO") : i == EnumC1424b.BIDDERS.ordinal() ? new C1459e("BIDDERS") : new C1459e("WATERFALL");
    }

    @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d
    /* renamed from: c */
    protected List<C1452c> mo7366c(int i) {
        return i == EnumC1424b.INFO.ordinal() ? this.f1103d : i == EnumC1424b.BIDDERS.ordinal() ? this.f1104e : this.f1105f;
    }
}
