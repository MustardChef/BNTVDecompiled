package com.google.ads.interactivemedia.p034v3.internal;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.primitives.SignedBytes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.add */
/* loaded from: classes2.dex */
public final class add implements aei {

    /* renamed from: a */
    private final int f3351a;

    /* renamed from: b */
    private final List f3352b;

    public add() {
        this(null);
    }

    public add(int i, List list) {
        this.f3351a = i;
        this.f3352b = list;
    }

    /* renamed from: c */
    private final adz m5807c(aeh aehVar) {
        return new adz(m5805e(aehVar));
    }

    /* renamed from: d */
    private final ael m5806d(aeh aehVar) {
        return new ael(m5805e(aehVar));
    }

    /* renamed from: e */
    private final List m5805e(aeh aehVar) {
        String str;
        int i;
        List list;
        if (m5804f(32)) {
            return this.f3352b;
        }
        C2621cj c2621cj = new C2621cj(aehVar.f3610d);
        List list2 = this.f3352b;
        while (c2621cj.m2641a() > 0) {
            int m2633i = c2621cj.m2633i();
            int m2639c = c2621cj.m2639c() + c2621cj.m2633i();
            if (m2633i == 134) {
                list2 = new ArrayList();
                int m2633i2 = c2621cj.m2633i() & 31;
                for (int i2 = 0; i2 < m2633i2; i2++) {
                    String m2621u = c2621cj.m2621u(3);
                    int m2633i3 = c2621cj.m2633i();
                    int i3 = m2633i3 & 128;
                    if (i3 != 0) {
                        i = m2633i3 & 63;
                        str = MimeTypes.APPLICATION_CEA708;
                    } else {
                        str = MimeTypes.APPLICATION_CEA608;
                        i = 1;
                    }
                    byte m2633i4 = (byte) c2621cj.m2633i();
                    c2621cj.m2643G(1);
                    if (i3 != 0) {
                        int i4 = C2599bo.f6302a;
                        list = Collections.singletonList((m2633i4 & SignedBytes.MAX_POWER_OF_TWO) != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        list = null;
                    }
                    C2935o c2935o = new C2935o();
                    c2935o.m1532ae(str);
                    c2935o.m1542V(m2621u);
                    c2935o.m1558F(i);
                    c2935o.m1544T(list);
                    list2.add(c2935o.m1506v());
                }
            }
            c2621cj.m2644F(m2639c);
        }
        return list2;
    }

    /* renamed from: f */
    private final boolean m5804f(int i) {
        return (i & this.f3351a) != 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aei
    /* renamed from: a */
    public final SparseArray mo5733a() {
        return new SparseArray();
    }

    public add(byte[] bArr) {
        this(0, avg.m4515n());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aei
    /* renamed from: b */
    public final aek mo5732b(int i, aeh aehVar) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new adw(new adt(aehVar.f3608b));
            }
            if (i != 21) {
                if (i == 27) {
                    if (m5804f(4)) {
                        return null;
                    }
                    return new adw(new ado(m5807c(aehVar), m5804f(1), m5804f(8)));
                } else if (i != 36) {
                    if (i != 89) {
                        if (i != 138) {
                            if (i != 172) {
                                if (i != 257) {
                                    if (i == 134) {
                                        if (m5804f(16)) {
                                            return null;
                                        }
                                        return new ady(new adv(MimeTypes.APPLICATION_SCTE35));
                                    }
                                    if (i != 135) {
                                        switch (i) {
                                            case 15:
                                                if (m5804f(2)) {
                                                    return null;
                                                }
                                                return new adw(new adc(false, aehVar.f3608b));
                                            case 16:
                                                return new adw(new adl(m5806d(aehVar)));
                                            case 17:
                                                if (m5804f(2)) {
                                                    return null;
                                                }
                                                return new adw(new C2542ads(aehVar.f3608b));
                                            default:
                                                switch (i) {
                                                    case 128:
                                                        break;
                                                    case 129:
                                                        break;
                                                    case 130:
                                                        if (!m5804f(64)) {
                                                            return null;
                                                        }
                                                        break;
                                                    default:
                                                        return null;
                                                }
                                        }
                                    }
                                    return new adw(new acx(aehVar.f3608b));
                                }
                                return new ady(new adv(MimeTypes.APPLICATION_AIT));
                            }
                            return new adw(new ada(aehVar.f3608b));
                        }
                        return new adw(new ade(aehVar.f3608b));
                    }
                    return new adw(new adf(aehVar.f3609c));
                } else {
                    return new adw(new adq(m5807c(aehVar)));
                }
            }
            return new adw(new adr());
        }
        return new adw(new adi(m5806d(aehVar)));
    }
}
