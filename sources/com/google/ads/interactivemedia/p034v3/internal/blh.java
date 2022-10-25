package com.google.ads.interactivemedia.p034v3.internal;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.blh */
/* loaded from: classes2.dex */
public final class blh implements bot {

    /* renamed from: a */
    private final byte[] f6000a;

    /* renamed from: b */
    private int f6001b;

    /* renamed from: c */
    private int f6002c;

    /* renamed from: d */
    private int f6003d;

    /* renamed from: e */
    private int f6004e;

    public blh(ByteBuffer byteBuffer) {
        this((byte[]) null);
        this.f6000a = byteBuffer.array();
        this.f6001b = byteBuffer.arrayOffset() + byteBuffer.position();
        this.f6002c = byteBuffer.arrayOffset() + byteBuffer.limit();
    }

    /* synthetic */ blh(byte[] bArr) {
    }

    /* renamed from: V */
    private final byte m3535V() throws IOException {
        int i = this.f6001b;
        if (i == this.f6002c) {
            throw bnm.m3250i();
        }
        byte[] bArr = this.f6000a;
        this.f6001b = i + 1;
        return bArr[i];
    }

    /* renamed from: W */
    private final int m3534W() throws IOException {
        m3526ae(4);
        return m3533X();
    }

    /* renamed from: X */
    private final int m3533X() {
        int i = this.f6001b;
        byte[] bArr = this.f6000a;
        this.f6001b = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* renamed from: Y */
    private final int m3532Y() throws IOException {
        int i;
        int i2 = this.f6001b;
        int i3 = this.f6002c;
        if (i3 == i2) {
            throw bnm.m3250i();
        }
        byte[] bArr = this.f6000a;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            this.f6001b = i4;
            return b;
        } else if (i3 - i4 < 9) {
            return (int) m3529ab();
        } else {
            int i5 = i4 + 1;
            int i6 = b ^ (bArr[i4] << 7);
            if (i6 < 0) {
                i = i6 ^ (-128);
            } else {
                int i7 = i5 + 1;
                int i8 = i6 ^ (bArr[i5] << Ascii.f9767SO);
                if (i8 >= 0) {
                    i = i8 ^ 16256;
                } else {
                    i5 = i7 + 1;
                    int i9 = i8 ^ (bArr[i7] << Ascii.NAK);
                    if (i9 < 0) {
                        i = i9 ^ (-2080896);
                    } else {
                        i7 = i5 + 1;
                        byte b2 = bArr[i5];
                        i = (i9 ^ (b2 << Ascii.f9760FS)) ^ 266354560;
                        if (b2 < 0) {
                            i5 = i7 + 1;
                            if (bArr[i7] < 0) {
                                i7 = i5 + 1;
                                if (bArr[i5] < 0) {
                                    i5 = i7 + 1;
                                    if (bArr[i7] < 0) {
                                        i7 = i5 + 1;
                                        if (bArr[i5] < 0) {
                                            i5 = i7 + 1;
                                            if (bArr[i7] < 0) {
                                                throw bnm.m3254e();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                i5 = i7;
            }
            this.f6001b = i5;
            return i;
        }
    }

    /* renamed from: Z */
    private final long m3531Z() throws IOException {
        m3526ae(8);
        return m3530aa();
    }

    /* renamed from: aa */
    private final long m3530aa() {
        int i = this.f6001b;
        byte[] bArr = this.f6000a;
        this.f6001b = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    /* renamed from: ab */
    private final long m3529ab() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte m3535V = m3535V();
            j |= (m3535V & Byte.MAX_VALUE) << i;
            if ((m3535V & 128) == 0) {
                return j;
            }
        }
        throw bnm.m3254e();
    }

    /* renamed from: ac */
    private final Object m3528ac(boy boyVar, bmr bmrVar) throws IOException {
        int i = this.f6004e;
        this.f6004e = bqb.m2851c(bqb.m2853a(this.f6003d), 4);
        try {
            Object mo3038e = boyVar.mo3038e();
            boyVar.mo3035h(mo3038e, this, bmrVar);
            boyVar.mo3037f(mo3038e);
            if (this.f6003d == this.f6004e) {
                return mo3038e;
            }
            throw bnm.m3252g();
        } finally {
            this.f6004e = i;
        }
    }

    /* renamed from: ad */
    private final Object m3527ad(boy boyVar, bmr bmrVar) throws IOException {
        int m3532Y = m3532Y();
        m3526ae(m3532Y);
        int i = this.f6002c;
        int i2 = this.f6001b + m3532Y;
        this.f6002c = i2;
        try {
            Object mo3038e = boyVar.mo3038e();
            boyVar.mo3035h(mo3038e, this, bmrVar);
            boyVar.mo3037f(mo3038e);
            if (this.f6001b == i2) {
                return mo3038e;
            }
            throw bnm.m3252g();
        } finally {
            this.f6002c = i;
        }
    }

    /* renamed from: ae */
    private final void m3526ae(int i) throws IOException {
        if (i < 0 || i > this.f6002c - this.f6001b) {
            throw bnm.m3250i();
        }
    }

    /* renamed from: af */
    private final void m3525af(int i) throws IOException {
        if (this.f6001b != i) {
            throw bnm.m3250i();
        }
    }

    /* renamed from: ag */
    private final void m3524ag(int i) throws IOException {
        if (bqb.m2852b(this.f6003d) != i) {
            throw bnm.m3258a();
        }
    }

    /* renamed from: ah */
    private final void m3523ah(int i) throws IOException {
        m3526ae(i);
        this.f6001b += i;
    }

    /* renamed from: ai */
    private final void m3522ai(int i) throws IOException {
        m3526ae(i);
        if ((i & 3) != 0) {
            throw bnm.m3252g();
        }
    }

    /* renamed from: aj */
    private final void m3521aj(int i) throws IOException {
        m3526ae(i);
        if ((i & 7) != 0) {
            throw bnm.m3252g();
        }
    }

    /* renamed from: ak */
    private final boolean m3520ak() {
        return this.f6001b == this.f6002c;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: A */
    public final void mo3111A(List list) throws IOException {
        int i;
        int i2;
        if (list instanceof bmo) {
            bmo bmoVar = (bmo) list;
            int m2852b = bqb.m2852b(this.f6003d);
            if (m2852b == 1) {
                do {
                    bmoVar.m3346e(mo3091a());
                    if (m3520ak()) {
                        return;
                    }
                    i2 = this.f6001b;
                } while (m3532Y() == this.f6003d);
                this.f6001b = i2;
                return;
            } else if (m2852b == 2) {
                int m3532Y = m3532Y();
                m3521aj(m3532Y);
                int i3 = this.f6001b + m3532Y;
                while (this.f6001b < i3) {
                    bmoVar.m3346e(Double.longBitsToDouble(m3530aa()));
                }
                return;
            } else {
                throw bnm.m3258a();
            }
        }
        int m2852b2 = bqb.m2852b(this.f6003d);
        if (m2852b2 == 1) {
            do {
                list.add(Double.valueOf(mo3091a()));
                if (m3520ak()) {
                    return;
                }
                i = this.f6001b;
            } while (m3532Y() == this.f6003d);
            this.f6001b = i;
        } else if (m2852b2 == 2) {
            int m3532Y2 = m3532Y();
            m3521aj(m3532Y2);
            int i4 = this.f6001b + m3532Y2;
            while (this.f6001b < i4) {
                list.add(Double.valueOf(Double.longBitsToDouble(m3530aa())));
            }
        } else {
            throw bnm.m3258a();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: B */
    public final void mo3110B(List list) throws IOException {
        int i;
        int i2;
        if (list instanceof bne) {
            bne bneVar = (bne) list;
            int m2852b = bqb.m2852b(this.f6003d);
            if (m2852b != 0) {
                if (m2852b == 2) {
                    int m3532Y = this.f6001b + m3532Y();
                    while (this.f6001b < m3532Y) {
                        bneVar.m3273g(m3532Y());
                    }
                    return;
                }
                throw bnm.m3258a();
            }
            do {
                bneVar.m3273g(mo3087e());
                if (m3520ak()) {
                    return;
                }
                i2 = this.f6001b;
            } while (m3532Y() == this.f6003d);
            this.f6001b = i2;
            return;
        }
        int m2852b2 = bqb.m2852b(this.f6003d);
        if (m2852b2 != 0) {
            if (m2852b2 == 2) {
                int m3532Y2 = this.f6001b + m3532Y();
                while (this.f6001b < m3532Y2) {
                    list.add(Integer.valueOf(m3532Y()));
                }
                return;
            }
            throw bnm.m3258a();
        }
        do {
            list.add(Integer.valueOf(mo3087e()));
            if (m3520ak()) {
                return;
            }
            i = this.f6001b;
        } while (m3532Y() == this.f6003d);
        this.f6001b = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: C */
    public final void mo3109C(List list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof bne)) {
            int m2852b = bqb.m2852b(this.f6003d);
            if (m2852b == 2) {
                int m3532Y = m3532Y();
                m3522ai(m3532Y);
                int i3 = this.f6001b + m3532Y;
                while (this.f6001b < i3) {
                    list.add(Integer.valueOf(m3533X()));
                }
                return;
            } else if (m2852b == 5) {
                do {
                    list.add(Integer.valueOf(mo3086f()));
                    if (m3520ak()) {
                        return;
                    }
                    i = this.f6001b;
                } while (m3532Y() == this.f6003d);
                this.f6001b = i;
                return;
            } else {
                throw bnm.m3258a();
            }
        }
        bne bneVar = (bne) list;
        int m2852b2 = bqb.m2852b(this.f6003d);
        if (m2852b2 == 2) {
            int m3532Y2 = m3532Y();
            m3522ai(m3532Y2);
            int i4 = this.f6001b + m3532Y2;
            while (this.f6001b < i4) {
                bneVar.m3273g(m3533X());
            }
        } else if (m2852b2 == 5) {
            do {
                bneVar.m3273g(mo3086f());
                if (m3520ak()) {
                    return;
                }
                i2 = this.f6001b;
            } while (m3532Y() == this.f6003d);
            this.f6001b = i2;
        } else {
            throw bnm.m3258a();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: D */
    public final void mo3108D(List list) throws IOException {
        int i;
        int i2;
        if (list instanceof bnz) {
            bnz bnzVar = (bnz) list;
            int m2852b = bqb.m2852b(this.f6003d);
            if (m2852b == 1) {
                do {
                    bnzVar.m3199f(mo3081k());
                    if (m3520ak()) {
                        return;
                    }
                    i2 = this.f6001b;
                } while (m3532Y() == this.f6003d);
                this.f6001b = i2;
                return;
            } else if (m2852b == 2) {
                int m3532Y = m3532Y();
                m3521aj(m3532Y);
                int i3 = this.f6001b + m3532Y;
                while (this.f6001b < i3) {
                    bnzVar.m3199f(m3530aa());
                }
                return;
            } else {
                throw bnm.m3258a();
            }
        }
        int m2852b2 = bqb.m2852b(this.f6003d);
        if (m2852b2 == 1) {
            do {
                list.add(Long.valueOf(mo3081k()));
                if (m3520ak()) {
                    return;
                }
                i = this.f6001b;
            } while (m3532Y() == this.f6003d);
            this.f6001b = i;
        } else if (m2852b2 == 2) {
            int m3532Y2 = m3532Y();
            m3521aj(m3532Y2);
            int i4 = this.f6001b + m3532Y2;
            while (this.f6001b < i4) {
                list.add(Long.valueOf(m3530aa()));
            }
        } else {
            throw bnm.m3258a();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: E */
    public final void mo3107E(List list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof bmx)) {
            int m2852b = bqb.m2852b(this.f6003d);
            if (m2852b == 2) {
                int m3532Y = m3532Y();
                m3522ai(m3532Y);
                int i3 = this.f6001b + m3532Y;
                while (this.f6001b < i3) {
                    list.add(Float.valueOf(Float.intBitsToFloat(m3533X())));
                }
                return;
            } else if (m2852b == 5) {
                do {
                    list.add(Float.valueOf(mo3090b()));
                    if (m3520ak()) {
                        return;
                    }
                    i = this.f6001b;
                } while (m3532Y() == this.f6003d);
                this.f6001b = i;
                return;
            } else {
                throw bnm.m3258a();
            }
        }
        bmx bmxVar = (bmx) list;
        int m2852b2 = bqb.m2852b(this.f6003d);
        if (m2852b2 == 2) {
            int m3532Y2 = m3532Y();
            m3522ai(m3532Y2);
            int i4 = this.f6001b + m3532Y2;
            while (this.f6001b < i4) {
                bmxVar.m3316e(Float.intBitsToFloat(m3533X()));
            }
        } else if (m2852b2 == 5) {
            do {
                bmxVar.m3316e(mo3090b());
                if (m3520ak()) {
                    return;
                }
                i2 = this.f6001b;
            } while (m3532Y() == this.f6003d);
            this.f6001b = i2;
        } else {
            throw bnm.m3258a();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    @Deprecated
    /* renamed from: F */
    public final void mo3106F(List list, boy boyVar, bmr bmrVar) throws IOException {
        int i;
        int i2 = this.f6003d;
        if (bqb.m2852b(i2) != 3) {
            throw bnm.m3258a();
        }
        do {
            list.add(m3528ac(boyVar, bmrVar));
            if (m3520ak()) {
                return;
            }
            i = this.f6001b;
        } while (m3532Y() == i2);
        this.f6001b = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: G */
    public final void mo3105G(List list) throws IOException {
        int i;
        int i2;
        if (list instanceof bne) {
            bne bneVar = (bne) list;
            int m2852b = bqb.m2852b(this.f6003d);
            if (m2852b == 0) {
                do {
                    bneVar.m3273g(mo3085g());
                    if (m3520ak()) {
                        return;
                    }
                    i2 = this.f6001b;
                } while (m3532Y() == this.f6003d);
                this.f6001b = i2;
                return;
            } else if (m2852b == 2) {
                int m3532Y = this.f6001b + m3532Y();
                while (this.f6001b < m3532Y) {
                    bneVar.m3273g(m3532Y());
                }
                m3525af(m3532Y);
                return;
            } else {
                throw bnm.m3258a();
            }
        }
        int m2852b2 = bqb.m2852b(this.f6003d);
        if (m2852b2 == 0) {
            do {
                list.add(Integer.valueOf(mo3085g()));
                if (m3520ak()) {
                    return;
                }
                i = this.f6001b;
            } while (m3532Y() == this.f6003d);
            this.f6001b = i;
        } else if (m2852b2 == 2) {
            int m3532Y2 = this.f6001b + m3532Y();
            while (this.f6001b < m3532Y2) {
                list.add(Integer.valueOf(m3532Y()));
            }
            m3525af(m3532Y2);
        } else {
            throw bnm.m3258a();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: H */
    public final void mo3104H(List list) throws IOException {
        int i;
        int i2;
        if (list instanceof bnz) {
            bnz bnzVar = (bnz) list;
            int m2852b = bqb.m2852b(this.f6003d);
            if (m2852b == 0) {
                do {
                    bnzVar.m3199f(mo3080l());
                    if (m3520ak()) {
                        return;
                    }
                    i2 = this.f6001b;
                } while (m3532Y() == this.f6003d);
                this.f6001b = i2;
                return;
            } else if (m2852b == 2) {
                int m3532Y = this.f6001b + m3532Y();
                while (this.f6001b < m3532Y) {
                    bnzVar.m3199f(m3519p());
                }
                m3525af(m3532Y);
                return;
            } else {
                throw bnm.m3258a();
            }
        }
        int m2852b2 = bqb.m2852b(this.f6003d);
        if (m2852b2 == 0) {
            do {
                list.add(Long.valueOf(mo3080l()));
                if (m3520ak()) {
                    return;
                }
                i = this.f6001b;
            } while (m3532Y() == this.f6003d);
            this.f6001b = i;
        } else if (m2852b2 == 2) {
            int m3532Y2 = this.f6001b + m3532Y();
            while (this.f6001b < m3532Y2) {
                list.add(Long.valueOf(m3519p()));
            }
            m3525af(m3532Y2);
        } else {
            throw bnm.m3258a();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: I */
    public final void mo3103I(List list, boy boyVar, bmr bmrVar) throws IOException {
        int i;
        int i2 = this.f6003d;
        if (bqb.m2852b(i2) != 2) {
            throw bnm.m3258a();
        }
        do {
            list.add(m3527ad(boyVar, bmrVar));
            if (m3520ak()) {
                return;
            }
            i = this.f6001b;
        } while (m3532Y() == i2);
        this.f6001b = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: J */
    public final void mo3102J(List list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof bne)) {
            int m2852b = bqb.m2852b(this.f6003d);
            if (m2852b == 2) {
                int m3532Y = m3532Y();
                m3522ai(m3532Y);
                int i3 = this.f6001b + m3532Y;
                while (this.f6001b < i3) {
                    list.add(Integer.valueOf(m3533X()));
                }
                return;
            } else if (m2852b == 5) {
                do {
                    list.add(Integer.valueOf(mo3084h()));
                    if (m3520ak()) {
                        return;
                    }
                    i = this.f6001b;
                } while (m3532Y() == this.f6003d);
                this.f6001b = i;
                return;
            } else {
                throw bnm.m3258a();
            }
        }
        bne bneVar = (bne) list;
        int m2852b2 = bqb.m2852b(this.f6003d);
        if (m2852b2 == 2) {
            int m3532Y2 = m3532Y();
            m3522ai(m3532Y2);
            int i4 = this.f6001b + m3532Y2;
            while (this.f6001b < i4) {
                bneVar.m3273g(m3533X());
            }
        } else if (m2852b2 == 5) {
            do {
                bneVar.m3273g(mo3084h());
                if (m3520ak()) {
                    return;
                }
                i2 = this.f6001b;
            } while (m3532Y() == this.f6003d);
            this.f6001b = i2;
        } else {
            throw bnm.m3258a();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: K */
    public final void mo3101K(List list) throws IOException {
        int i;
        int i2;
        if (list instanceof bnz) {
            bnz bnzVar = (bnz) list;
            int m2852b = bqb.m2852b(this.f6003d);
            if (m2852b == 1) {
                do {
                    bnzVar.m3199f(mo3079m());
                    if (m3520ak()) {
                        return;
                    }
                    i2 = this.f6001b;
                } while (m3532Y() == this.f6003d);
                this.f6001b = i2;
                return;
            } else if (m2852b == 2) {
                int m3532Y = m3532Y();
                m3521aj(m3532Y);
                int i3 = this.f6001b + m3532Y;
                while (this.f6001b < i3) {
                    bnzVar.m3199f(m3530aa());
                }
                return;
            } else {
                throw bnm.m3258a();
            }
        }
        int m2852b2 = bqb.m2852b(this.f6003d);
        if (m2852b2 == 1) {
            do {
                list.add(Long.valueOf(mo3079m()));
                if (m3520ak()) {
                    return;
                }
                i = this.f6001b;
            } while (m3532Y() == this.f6003d);
            this.f6001b = i;
        } else if (m2852b2 == 2) {
            int m3532Y2 = m3532Y();
            m3521aj(m3532Y2);
            int i4 = this.f6001b + m3532Y2;
            while (this.f6001b < i4) {
                list.add(Long.valueOf(m3530aa()));
            }
        } else {
            throw bnm.m3258a();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: L */
    public final void mo3100L(List list) throws IOException {
        int i;
        int i2;
        if (list instanceof bne) {
            bne bneVar = (bne) list;
            int m2852b = bqb.m2852b(this.f6003d);
            if (m2852b != 0) {
                if (m2852b == 2) {
                    int m3532Y = this.f6001b + m3532Y();
                    while (this.f6001b < m3532Y) {
                        bneVar.m3273g(blw.m3458F(m3532Y()));
                    }
                    return;
                }
                throw bnm.m3258a();
            }
            do {
                bneVar.m3273g(mo3083i());
                if (m3520ak()) {
                    return;
                }
                i2 = this.f6001b;
            } while (m3532Y() == this.f6003d);
            this.f6001b = i2;
            return;
        }
        int m2852b2 = bqb.m2852b(this.f6003d);
        if (m2852b2 != 0) {
            if (m2852b2 == 2) {
                int m3532Y2 = this.f6001b + m3532Y();
                while (this.f6001b < m3532Y2) {
                    list.add(Integer.valueOf(blw.m3458F(m3532Y())));
                }
                return;
            }
            throw bnm.m3258a();
        }
        do {
            list.add(Integer.valueOf(mo3083i()));
            if (m3520ak()) {
                return;
            }
            i = this.f6001b;
        } while (m3532Y() == this.f6003d);
        this.f6001b = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: M */
    public final void mo3099M(List list) throws IOException {
        int i;
        int i2;
        if (list instanceof bnz) {
            bnz bnzVar = (bnz) list;
            int m2852b = bqb.m2852b(this.f6003d);
            if (m2852b != 0) {
                if (m2852b == 2) {
                    int m3532Y = this.f6001b + m3532Y();
                    while (this.f6001b < m3532Y) {
                        bnzVar.m3199f(blw.m3457G(m3519p()));
                    }
                    return;
                }
                throw bnm.m3258a();
            }
            do {
                bnzVar.m3199f(mo3078n());
                if (m3520ak()) {
                    return;
                }
                i2 = this.f6001b;
            } while (m3532Y() == this.f6003d);
            this.f6001b = i2;
            return;
        }
        int m2852b2 = bqb.m2852b(this.f6003d);
        if (m2852b2 != 0) {
            if (m2852b2 == 2) {
                int m3532Y2 = this.f6001b + m3532Y();
                while (this.f6001b < m3532Y2) {
                    list.add(Long.valueOf(blw.m3457G(m3519p())));
                }
                return;
            }
            throw bnm.m3258a();
        }
        do {
            list.add(Long.valueOf(mo3078n()));
            if (m3520ak()) {
                return;
            }
            i = this.f6001b;
        } while (m3532Y() == this.f6003d);
        this.f6001b = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: N */
    public final void mo3098N(List list) throws IOException {
        m3536O(list, false);
    }

    /* renamed from: O */
    public final void m3536O(List list, boolean z) throws IOException {
        int i;
        int i2;
        if (bqb.m2852b(this.f6003d) != 2) {
            throw bnm.m3258a();
        }
        if (!(list instanceof bnu) || z) {
            do {
                list.add(m3518w(z));
                if (m3520ak()) {
                    return;
                }
                i = this.f6001b;
            } while (m3532Y() == this.f6003d);
            this.f6001b = i;
            return;
        }
        bnu bnuVar = (bnu) list;
        do {
            bnuVar.mo2936i(mo3076q());
            if (m3520ak()) {
                return;
            }
            i2 = this.f6001b;
        } while (m3532Y() == this.f6003d);
        this.f6001b = i2;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: P */
    public final void mo3097P(List list) throws IOException {
        m3536O(list, true);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: Q */
    public final void mo3096Q(List list) throws IOException {
        int i;
        int i2;
        if (list instanceof bne) {
            bne bneVar = (bne) list;
            int m2852b = bqb.m2852b(this.f6003d);
            if (m2852b != 0) {
                if (m2852b == 2) {
                    int m3532Y = this.f6001b + m3532Y();
                    while (this.f6001b < m3532Y) {
                        bneVar.m3273g(m3532Y());
                    }
                    return;
                }
                throw bnm.m3258a();
            }
            do {
                bneVar.m3273g(mo3082j());
                if (m3520ak()) {
                    return;
                }
                i2 = this.f6001b;
            } while (m3532Y() == this.f6003d);
            this.f6001b = i2;
            return;
        }
        int m2852b2 = bqb.m2852b(this.f6003d);
        if (m2852b2 != 0) {
            if (m2852b2 == 2) {
                int m3532Y2 = this.f6001b + m3532Y();
                while (this.f6001b < m3532Y2) {
                    list.add(Integer.valueOf(m3532Y()));
                }
                return;
            }
            throw bnm.m3258a();
        }
        do {
            list.add(Integer.valueOf(mo3082j()));
            if (m3520ak()) {
                return;
            }
            i = this.f6001b;
        } while (m3532Y() == this.f6003d);
        this.f6001b = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: R */
    public final void mo3095R(List list) throws IOException {
        int i;
        int i2;
        if (list instanceof bnz) {
            bnz bnzVar = (bnz) list;
            int m2852b = bqb.m2852b(this.f6003d);
            if (m2852b == 0) {
                do {
                    bnzVar.m3199f(mo3077o());
                    if (m3520ak()) {
                        return;
                    }
                    i2 = this.f6001b;
                } while (m3532Y() == this.f6003d);
                this.f6001b = i2;
                return;
            } else if (m2852b == 2) {
                int m3532Y = this.f6001b + m3532Y();
                while (this.f6001b < m3532Y) {
                    bnzVar.m3199f(m3519p());
                }
                m3525af(m3532Y);
                return;
            } else {
                throw bnm.m3258a();
            }
        }
        int m2852b2 = bqb.m2852b(this.f6003d);
        if (m2852b2 == 0) {
            do {
                list.add(Long.valueOf(mo3077o()));
                if (m3520ak()) {
                    return;
                }
                i = this.f6001b;
            } while (m3532Y() == this.f6003d);
            this.f6001b = i;
        } else if (m2852b2 == 2) {
            int m3532Y2 = this.f6001b + m3532Y();
            while (this.f6001b < m3532Y2) {
                list.add(Long.valueOf(m3519p()));
            }
            m3525af(m3532Y2);
        } else {
            throw bnm.m3258a();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: S */
    public final boolean mo3094S() throws IOException {
        m3524ag(0);
        return m3532Y() != 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: T */
    public final boolean mo3093T() throws IOException {
        int i;
        int i2;
        if (m3520ak() || (i = this.f6003d) == (i2 = this.f6004e)) {
            return false;
        }
        int m2852b = bqb.m2852b(i);
        if (m2852b == 0) {
            int i3 = this.f6002c;
            int i4 = this.f6001b;
            if (i3 - i4 >= 10) {
                byte[] bArr = this.f6000a;
                int i5 = 0;
                while (i5 < 10) {
                    int i6 = i4 + 1;
                    if (bArr[i4] >= 0) {
                        this.f6001b = i6;
                        break;
                    }
                    i5++;
                    i4 = i6;
                }
            }
            for (int i7 = 0; i7 < 10; i7++) {
                if (m3535V() >= 0) {
                    return true;
                }
            }
            throw bnm.m3254e();
        } else if (m2852b == 1) {
            m3523ah(8);
            return true;
        } else if (m2852b == 2) {
            m3523ah(m3532Y());
            return true;
        } else if (m2852b == 3) {
            this.f6004e = bqb.m2851c(bqb.m2853a(i), 4);
            while (mo3089c() != Integer.MAX_VALUE && mo3093T()) {
            }
            if (this.f6003d == this.f6004e) {
                this.f6004e = i2;
                return true;
            }
            throw bnm.m3252g();
        } else {
            if (m2852b == 5) {
                m3523ah(4);
                return true;
            }
            throw bnm.m3258a();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: U */
    public final void mo3092U(Map map, bod bodVar) throws IOException {
        m3524ag(2);
        int m3532Y = m3532Y();
        m3526ae(m3532Y);
        int i = this.f6002c;
        this.f6002c = this.f6001b + m3532Y;
        try {
            Object obj = bodVar.f6311b;
            Object obj2 = bodVar.f6313d;
            while (true) {
                int mo3089c = mo3089c();
                if (mo3089c == Integer.MAX_VALUE) {
                    map.put(null, null);
                    return;
                } else if (mo3089c == 1) {
                    bpz bpzVar = bodVar.f6310a;
                    int i2 = blg.f5999b;
                    throw null;
                } else if (mo3089c == 2) {
                    bpz bpzVar2 = bodVar.f6312c;
                    Object obj3 = bodVar.f6313d;
                    throw null;
                } else {
                    try {
                    } catch (bnl unused) {
                        if (!mo3093T()) {
                            throw new bnm("Unable to parse map entry.");
                        }
                    }
                    if (!mo3093T()) {
                        throw new bnm("Unable to parse map entry.");
                    }
                }
            }
        } finally {
            this.f6002c = i;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: a */
    public final double mo3091a() throws IOException {
        m3524ag(1);
        return Double.longBitsToDouble(m3531Z());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: b */
    public final float mo3090b() throws IOException {
        m3524ag(5);
        return Float.intBitsToFloat(m3534W());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: c */
    public final int mo3089c() throws IOException {
        if (m3520ak()) {
            return Integer.MAX_VALUE;
        }
        int m3532Y = m3532Y();
        this.f6003d = m3532Y;
        if (m3532Y == this.f6004e) {
            return Integer.MAX_VALUE;
        }
        return bqb.m2853a(m3532Y);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: d */
    public final int mo3088d() {
        return this.f6003d;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: e */
    public final int mo3087e() throws IOException {
        m3524ag(0);
        return m3532Y();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: f */
    public final int mo3086f() throws IOException {
        m3524ag(5);
        return m3534W();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: g */
    public final int mo3085g() throws IOException {
        m3524ag(0);
        return m3532Y();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: h */
    public final int mo3084h() throws IOException {
        m3524ag(5);
        return m3534W();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: i */
    public final int mo3083i() throws IOException {
        m3524ag(0);
        return blw.m3458F(m3532Y());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: j */
    public final int mo3082j() throws IOException {
        m3524ag(0);
        return m3532Y();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: k */
    public final long mo3081k() throws IOException {
        m3524ag(1);
        return m3531Z();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: l */
    public final long mo3080l() throws IOException {
        m3524ag(0);
        return m3519p();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: m */
    public final long mo3079m() throws IOException {
        m3524ag(1);
        return m3531Z();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: n */
    public final long mo3078n() throws IOException {
        m3524ag(0);
        return blw.m3457G(m3519p());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: o */
    public final long mo3077o() throws IOException {
        m3524ag(0);
        return m3519p();
    }

    /* renamed from: p */
    public final long m3519p() throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        int i;
        int i2 = this.f6001b;
        int i3 = this.f6002c;
        if (i3 == i2) {
            throw bnm.m3250i();
        }
        byte[] bArr = this.f6000a;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            this.f6001b = i4;
            return b;
        } else if (i3 - i4 < 9) {
            return m3529ab();
        } else {
            int i5 = i4 + 1;
            int i6 = b ^ (bArr[i4] << 7);
            if (i6 >= 0) {
                int i7 = i5 + 1;
                int i8 = i6 ^ (bArr[i5] << Ascii.f9767SO);
                if (i8 >= 0) {
                    j = i8 ^ 16256;
                } else {
                    i5 = i7 + 1;
                    int i9 = i8 ^ (bArr[i7] << Ascii.NAK);
                    if (i9 < 0) {
                        i = i9 ^ (-2080896);
                    } else {
                        i7 = i5 + 1;
                        long j5 = (bArr[i5] << 28) ^ i9;
                        if (j5 < 0) {
                            int i10 = i7 + 1;
                            long j6 = j5 ^ (bArr[i7] << 35);
                            if (j6 < 0) {
                                j3 = -34093383808L;
                            } else {
                                i7 = i10 + 1;
                                j5 = j6 ^ (bArr[i10] << 42);
                                if (j5 >= 0) {
                                    j4 = 4363953127296L;
                                } else {
                                    i10 = i7 + 1;
                                    j6 = j5 ^ (bArr[i7] << 49);
                                    if (j6 < 0) {
                                        j3 = -558586000294016L;
                                    } else {
                                        i7 = i10 + 1;
                                        j = (j6 ^ (bArr[i10] << 56)) ^ 71499008037633920L;
                                        if (j < 0) {
                                            i10 = i7 + 1;
                                            if (bArr[i7] >= 0) {
                                                j2 = j;
                                                i5 = i10;
                                                this.f6001b = i5;
                                                return j2;
                                            }
                                            throw bnm.m3254e();
                                        }
                                    }
                                }
                            }
                            j2 = j3 ^ j6;
                            i5 = i10;
                            this.f6001b = i5;
                            return j2;
                        }
                        j4 = 266354560;
                        j = j5 ^ j4;
                    }
                }
                i5 = i7;
                j2 = j;
                this.f6001b = i5;
                return j2;
            }
            i = i6 ^ (-128);
            j2 = i;
            this.f6001b = i5;
            return j2;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: q */
    public final bls mo3076q() throws IOException {
        m3524ag(2);
        int m3532Y = m3532Y();
        if (m3532Y == 0) {
            return bls.f6015b;
        }
        m3526ae(m3532Y);
        bls m3499y = bls.m3499y(this.f6000a, this.f6001b, m3532Y);
        this.f6001b += m3532Y;
        return m3499y;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    @Deprecated
    /* renamed from: r */
    public final Object mo3075r(Class cls, bmr bmrVar) throws IOException {
        m3524ag(3);
        return m3528ac(boq.m3120a().m3119b(cls), bmrVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    @Deprecated
    /* renamed from: s */
    public final Object mo3074s(boy boyVar, bmr bmrVar) throws IOException {
        m3524ag(3);
        return m3528ac(boyVar, bmrVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: t */
    public final Object mo3073t(Class cls, bmr bmrVar) throws IOException {
        m3524ag(2);
        return m3527ad(boq.m3120a().m3119b(cls), bmrVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: u */
    public final Object mo3072u(boy boyVar, bmr bmrVar) throws IOException {
        m3524ag(2);
        return m3527ad(boyVar, bmrVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: v */
    public final String mo3071v() throws IOException {
        return m3518w(false);
    }

    /* renamed from: w */
    public final String m3518w(boolean z) throws IOException {
        m3524ag(2);
        int m3532Y = m3532Y();
        if (m3532Y == 0) {
            return "";
        }
        m3526ae(m3532Y);
        if (z) {
            byte[] bArr = this.f6000a;
            int i = this.f6001b;
            if (!bpy.m2862j(bArr, i, i + m3532Y)) {
                throw bnm.m3255d();
            }
        }
        String str = new String(this.f6000a, this.f6001b, m3532Y, bnk.f6265b);
        this.f6001b += m3532Y;
        return str;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: x */
    public final String mo3070x() throws IOException {
        return m3518w(true);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: y */
    public final void mo3069y(List list) throws IOException {
        int i;
        int i2;
        if (list instanceof blj) {
            blj bljVar = (blj) list;
            int m2852b = bqb.m2852b(this.f6003d);
            if (m2852b != 0) {
                if (m2852b == 2) {
                    int m3532Y = this.f6001b + m3532Y();
                    while (this.f6001b < m3532Y) {
                        bljVar.m3517e(m3532Y() != 0);
                    }
                    m3525af(m3532Y);
                    return;
                }
                throw bnm.m3258a();
            }
            do {
                bljVar.m3517e(mo3094S());
                if (m3520ak()) {
                    return;
                }
                i2 = this.f6001b;
            } while (m3532Y() == this.f6003d);
            this.f6001b = i2;
            return;
        }
        int m2852b2 = bqb.m2852b(this.f6003d);
        if (m2852b2 != 0) {
            if (m2852b2 == 2) {
                int m3532Y2 = this.f6001b + m3532Y();
                while (this.f6001b < m3532Y2) {
                    list.add(Boolean.valueOf(m3532Y() != 0));
                }
                m3525af(m3532Y2);
                return;
            }
            throw bnm.m3258a();
        }
        do {
            list.add(Boolean.valueOf(mo3094S()));
            if (m3520ak()) {
                return;
            }
            i = this.f6001b;
        } while (m3532Y() == this.f6003d);
        this.f6001b = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: z */
    public final void mo3068z(List list) throws IOException {
        int i;
        if (bqb.m2852b(this.f6003d) != 2) {
            throw bnm.m3258a();
        }
        do {
            list.add(mo3076q());
            if (m3520ak()) {
                return;
            }
            i = this.f6001b;
        } while (m3532Y() == this.f6003d);
        this.f6001b = i;
    }

    private blh() {
    }
}
