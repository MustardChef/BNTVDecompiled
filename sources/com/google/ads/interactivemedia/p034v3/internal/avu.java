package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;
import java.util.Comparator;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.avu */
/* loaded from: classes2.dex */
public final class avu extends avm {

    /* renamed from: d */
    private final Comparator f5192d;

    public avu(Comparator comparator) {
        atm.m4612j(comparator);
        this.f5192d = comparator;
    }

    /* renamed from: g */
    public final avw m4475g() {
        awx awxVar;
        Object[] objArr = this.f5160a;
        Comparator comparator = this.f5192d;
        int i = this.f5161b;
        if (i == 0) {
            awxVar = avw.m4468x(comparator);
        } else {
            axd.m4398n(objArr, i);
            Arrays.sort(objArr, 0, i, comparator);
            int i2 = 1;
            for (int i3 = 1; i3 < i; i3++) {
                Object obj = objArr[i3];
                if (comparator.compare(obj, objArr[i2 - 1]) != 0) {
                    objArr[i2] = obj;
                    i2++;
                }
            }
            Arrays.fill(objArr, i2, i, (Object) null);
            if (i2 < (objArr.length >> 1)) {
                objArr = Arrays.copyOf(objArr, i2);
            }
            awxVar = new awx(avg.m4518k(objArr, i2), comparator);
        }
        this.f5161b = awxVar.size();
        this.f5162c = true;
        return awxVar;
    }

    /* renamed from: h */
    public final void m4474h(Object... objArr) {
        super.m4500d(objArr);
    }
}
