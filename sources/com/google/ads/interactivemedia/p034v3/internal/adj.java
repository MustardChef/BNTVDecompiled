package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Log;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.adj */
/* loaded from: classes2.dex */
final class adj {

    /* renamed from: d */
    private static final byte[] f3392d = {0, 0, 1};

    /* renamed from: a */
    public int f3393a;

    /* renamed from: b */
    public int f3394b;

    /* renamed from: c */
    public byte[] f3395c = new byte[128];

    /* renamed from: e */
    private boolean f3396e;

    /* renamed from: f */
    private int f3397f;

    /* renamed from: a */
    public final void m5799a(byte[] bArr, int i, int i2) {
        if (this.f3396e) {
            int i3 = i2 - i;
            byte[] bArr2 = this.f3395c;
            int length = bArr2.length;
            int i4 = this.f3393a + i3;
            if (length < i4) {
                this.f3395c = Arrays.copyOf(bArr2, i4 + i4);
            }
            System.arraycopy(bArr, i, this.f3395c, this.f3393a, i3);
            this.f3393a += i3;
        }
    }

    /* renamed from: b */
    public final void m5798b() {
        this.f3396e = false;
        this.f3393a = 0;
        this.f3397f = 0;
    }

    /* renamed from: c */
    public final boolean m5797c(int i, int i2) {
        int i3 = this.f3397f;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i == 179 || i == 181) {
                            this.f3393a -= i2;
                            this.f3396e = false;
                            return true;
                        }
                    } else if ((i & 240) != 32) {
                        Log.w("H263Reader", "Unexpected start code value");
                        m5798b();
                    } else {
                        this.f3394b = this.f3393a;
                        this.f3397f = 4;
                    }
                } else if (i > 31) {
                    Log.w("H263Reader", "Unexpected start code value");
                    m5798b();
                } else {
                    this.f3397f = 3;
                }
            } else if (i != 181) {
                Log.w("H263Reader", "Unexpected start code value");
                m5798b();
            } else {
                this.f3397f = 2;
            }
        } else if (i == 176) {
            this.f3397f = 1;
            this.f3396e = true;
        }
        m5799a(f3392d, 0, 3);
        return false;
    }
}
