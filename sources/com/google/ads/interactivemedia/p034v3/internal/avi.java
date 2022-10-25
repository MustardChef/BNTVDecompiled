package com.google.ads.interactivemedia.p034v3.internal;

import java.io.Serializable;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.avi */
/* loaded from: classes2.dex */
class avi implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    private final Object f5174a;

    /* renamed from: b */
    private final Object f5175b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public avi(avj avjVar) {
        Object[] objArr = new Object[avjVar.size()];
        Object[] objArr2 = new Object[avjVar.size()];
        axf it = avjVar.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            objArr[i] = entry.getKey();
            objArr2[i] = entry.getValue();
            i++;
        }
        this.f5174a = objArr;
        this.f5175b = objArr2;
    }

    /* renamed from: a */
    avh mo4486a(int i) {
        return new avh(i);
    }

    final Object readResolve() {
        Object obj = this.f5174a;
        if (!(obj instanceof avo)) {
            Object[] objArr = (Object[]) obj;
            Object[] objArr2 = (Object[]) this.f5175b;
            avh mo4486a = mo4486a(objArr.length);
            for (int i = 0; i < objArr.length; i++) {
                mo4486a.mo4491a(objArr[i], objArr2[i]);
            }
            return mo4486a.mo4490b();
        }
        avo avoVar = (avo) obj;
        avh mo4486a2 = mo4486a(avoVar.size());
        axf it = avoVar.iterator();
        axf it2 = ((avb) this.f5175b).iterator();
        while (it.hasNext()) {
            mo4486a2.mo4491a(it.next(), it2.next());
        }
        return mo4486a2.mo4490b();
    }
}
