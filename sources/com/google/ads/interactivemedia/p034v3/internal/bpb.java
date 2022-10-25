package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bpb */
/* loaded from: classes2.dex */
public final class bpb extends bpi {
    /* JADX INFO: Access modifiers changed from: package-private */
    public bpb(int i) {
        super(i);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bpi
    /* renamed from: a */
    public final void mo2970a() {
        if (!m2961j()) {
            for (int i = 0; i < m2969b(); i++) {
                Map.Entry m2964g = m2964g(i);
                if (((bmt) m2964g.getKey()).mo3296e()) {
                    m2964g.setValue(Collections.unmodifiableList((List) m2964g.getValue()));
                }
            }
            for (Map.Entry entry : m2967d()) {
                if (((bmt) entry.getKey()).mo3296e()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.mo2970a();
    }
}
