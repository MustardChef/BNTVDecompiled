package com.applovin.impl.mediation;

import com.applovin.impl.mediation.p013a.AbstractC1334a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.applovin.impl.mediation.h */
/* loaded from: classes.dex */
public class C1514h {

    /* renamed from: a */
    private final List<InterfaceC1515a> f1406a = Collections.synchronizedList(new ArrayList());

    /* renamed from: com.applovin.impl.mediation.h$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1515a {
        /* renamed from: a */
        void mo6843a(AbstractC1334a abstractC1334a);
    }

    /* renamed from: a */
    public void m7277a(AbstractC1334a abstractC1334a) {
        Iterator it = new ArrayList(this.f1406a).iterator();
        while (it.hasNext()) {
            ((InterfaceC1515a) it.next()).mo6843a(abstractC1334a);
        }
    }

    /* renamed from: a */
    public void m7276a(InterfaceC1515a interfaceC1515a) {
        this.f1406a.add(interfaceC1515a);
    }

    /* renamed from: b */
    public void m7275b(InterfaceC1515a interfaceC1515a) {
        this.f1406a.remove(interfaceC1515a);
    }
}
