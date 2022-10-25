package com.applovin.impl.mediation.debugger.p020ui.p022b.p023a;

import android.content.Context;
import android.text.SpannedString;
import com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c;
import com.applovin.impl.sdk.C1648h;

/* renamed from: com.applovin.impl.mediation.debugger.ui.b.a.b */
/* loaded from: classes.dex */
public class C1440b extends C1452c {

    /* renamed from: a */
    private final C1648h.C1649a f1147a;

    /* renamed from: o */
    private final Context f1148o;

    /* renamed from: p */
    private final boolean f1149p;

    public C1440b(C1648h.C1649a c1649a, boolean z, Context context) {
        super(C1452c.EnumC1455b.RIGHT_DETAIL);
        this.f1147a = c1649a;
        this.f1148o = context;
        this.f1212d = new SpannedString(c1649a.m6714a());
        this.f1149p = z;
    }

    @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c
    /* renamed from: b */
    public boolean mo7406b() {
        return true;
    }

    @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c
    /* renamed from: c_ */
    public SpannedString mo7404c_() {
        return new SpannedString(this.f1147a.m6711b(this.f1148o));
    }

    @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c
    /* renamed from: d_ */
    public boolean mo7403d_() {
        Boolean m6713a = this.f1147a.m6713a(this.f1148o);
        if (m6713a != null) {
            return m6713a.equals(Boolean.valueOf(this.f1149p));
        }
        return false;
    }
}
