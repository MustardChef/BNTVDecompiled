package com.google.ads.interactivemedia.p034v3.internal;

import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.apb */
/* loaded from: classes2.dex */
public final class apb extends ape {

    /* renamed from: h */
    private final View f4819h;

    public apb(anw anwVar, aga agaVar, int i, View view, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "hQ5xuCRMiz6eJqaT4+9Wf/Kj854Yma0NmQLTM8SLOoEkyUHQjbgUSxF3PTxTz3Bq", "CIY4BMAyy7Fe28Pq7/h8od2SEEojcWEgmd3J7ORxssU=", agaVar, i, 57, null, null, null);
        this.f4819h = view;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ape
    /* renamed from: a */
    protected final void mo4844a() throws IllegalAccessException, InvocationTargetException {
        if (this.f4819h != null) {
            Boolean bool = (Boolean) aql.f4910w.m4770f();
            aoa aoaVar = new aoa((String) this.f4830d.invoke(null, this.f4819h, this.f4827a.m4908b().getResources().getDisplayMetrics(), bool));
            aga m5599f = afq.m5599f();
            m5599f.m5391l(aoaVar.f4774a.longValue());
            m5599f.m5390m(aoaVar.f4775b.longValue());
            m5599f.m5389n(aoaVar.f4776c.longValue());
            if (bool.booleanValue()) {
                m5599f.m5392k(aoaVar.f4777d.longValue());
            }
            this.f4833g.m5435aC((afq) m5599f.mo3179aR());
        }
    }
}
