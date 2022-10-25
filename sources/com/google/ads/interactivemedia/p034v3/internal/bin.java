package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bin */
/* loaded from: classes2.dex */
public final class bin extends bkv {

    /* renamed from: b */
    private static final Reader f5799b = new bim();

    /* renamed from: c */
    private static final Object f5800c = new Object();

    /* renamed from: d */
    private Object[] f5801d;

    /* renamed from: e */
    private int f5802e;

    /* renamed from: f */
    private String[] f5803f;

    /* renamed from: g */
    private int[] f5804g;

    public bin(bgm bgmVar) {
        super(f5799b);
        this.f5801d = new Object[32];
        this.f5802e = 0;
        this.f5803f = new String[32];
        this.f5804g = new int[32];
        m3638A(bgmVar);
    }

    /* renamed from: A */
    private final void m3638A(Object obj) {
        int i = this.f5802e;
        Object[] objArr = this.f5801d;
        if (i == objArr.length) {
            int i2 = i + i;
            this.f5801d = Arrays.copyOf(objArr, i2);
            this.f5804g = Arrays.copyOf(this.f5804g, i2);
            this.f5803f = (String[]) Arrays.copyOf(this.f5803f, i2);
        }
        Object[] objArr2 = this.f5801d;
        int i3 = this.f5802e;
        this.f5802e = i3 + 1;
        objArr2[i3] = obj;
    }

    /* renamed from: B */
    private final void m3637B(int i) throws IOException {
        if (mo3574r() == i) {
            return;
        }
        String m3565a = bkw.m3565a(i);
        String m3565a2 = bkw.m3565a(mo3574r());
        String m3631z = m3631z();
        StringBuilder sb = new StringBuilder(m3565a.length() + 18 + m3565a2.length() + String.valueOf(m3631z).length());
        sb.append("Expected ");
        sb.append(m3565a);
        sb.append(" but was ");
        sb.append(m3565a2);
        sb.append(m3631z);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: w */
    private final Object m3634w() {
        return this.f5801d[this.f5802e - 1];
    }

    /* renamed from: x */
    private final Object m3633x() {
        Object[] objArr = this.f5801d;
        int i = this.f5802e - 1;
        this.f5802e = i;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    /* renamed from: y */
    private final String m3632y(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(Typography.dollar);
        int i = 0;
        while (true) {
            int i2 = this.f5802e;
            if (i >= i2) {
                return sb.toString();
            }
            Object[] objArr = this.f5801d;
            Object obj = objArr[i];
            if (obj instanceof bgk) {
                i++;
                if (i < i2 && (objArr[i] instanceof Iterator)) {
                    int i3 = this.f5804g[i];
                    if (z && i3 > 0 && (i == i2 - 1 || i == i2 - 2)) {
                        i3--;
                    }
                    sb.append('[');
                    sb.append(i3);
                    sb.append(']');
                }
            } else if ((obj instanceof bgp) && (i = i + 1) < i2 && (objArr[i] instanceof Iterator)) {
                sb.append('.');
                String str = this.f5803f[i];
                if (str != null) {
                    sb.append(str);
                }
            }
            i++;
        }
    }

    /* renamed from: z */
    private final String m3631z() {
        String valueOf = String.valueOf(mo3587e());
        return valueOf.length() != 0 ? " at path ".concat(valueOf) : new String(" at path ");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkv
    /* renamed from: a */
    public final double mo3591a() throws IOException {
        int mo3574r = mo3574r();
        if (mo3574r == 7 || mo3574r == 6) {
            bgr bgrVar = (bgr) m3634w();
            double doubleValue = bgrVar.m3705e() ? bgrVar.m3709a().doubleValue() : Double.parseDouble(bgrVar.m3708b());
            if (m3570v() || (!Double.isNaN(doubleValue) && !Double.isInfinite(doubleValue))) {
                m3633x();
                int i = this.f5802e;
                if (i > 0) {
                    int[] iArr = this.f5804g;
                    int i2 = i - 1;
                    iArr[i2] = iArr[i2] + 1;
                }
                return doubleValue;
            }
            StringBuilder sb = new StringBuilder(57);
            sb.append("JSON forbids NaN and infinities: ");
            sb.append(doubleValue);
            throw new NumberFormatException(sb.toString());
        }
        String m3565a = bkw.m3565a(mo3574r);
        String m3631z = m3631z();
        StringBuilder sb2 = new StringBuilder(24 + m3565a.length() + String.valueOf(m3631z).length());
        sb2.append("Expected ");
        sb2.append("NUMBER");
        sb2.append(" but was ");
        sb2.append(m3565a);
        sb2.append(m3631z);
        throw new IllegalStateException(sb2.toString());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkv
    /* renamed from: b */
    public final int mo3590b() throws IOException {
        int mo3574r = mo3574r();
        if (mo3574r == 7 || mo3574r == 6) {
            bgr bgrVar = (bgr) m3634w();
            int intValue = bgrVar.m3705e() ? bgrVar.m3709a().intValue() : Integer.parseInt(bgrVar.m3708b());
            m3633x();
            int i = this.f5802e;
            if (i > 0) {
                int[] iArr = this.f5804g;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return intValue;
        }
        String m3565a = bkw.m3565a(mo3574r);
        String m3631z = m3631z();
        StringBuilder sb = new StringBuilder(24 + m3565a.length() + String.valueOf(m3631z).length());
        sb.append("Expected ");
        sb.append("NUMBER");
        sb.append(" but was ");
        sb.append(m3565a);
        sb.append(m3631z);
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkv
    /* renamed from: c */
    public final long mo3589c() throws IOException {
        int mo3574r = mo3574r();
        if (mo3574r == 7 || mo3574r == 6) {
            bgr bgrVar = (bgr) m3634w();
            long longValue = bgrVar.m3705e() ? bgrVar.m3709a().longValue() : Long.parseLong(bgrVar.m3708b());
            m3633x();
            int i = this.f5802e;
            if (i > 0) {
                int[] iArr = this.f5804g;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return longValue;
        }
        String m3565a = bkw.m3565a(mo3574r);
        String m3631z = m3631z();
        StringBuilder sb = new StringBuilder(24 + m3565a.length() + String.valueOf(m3631z).length());
        sb.append("Expected ");
        sb.append("NUMBER");
        sb.append(" but was ");
        sb.append(m3565a);
        sb.append(m3631z);
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkv, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f5801d = new Object[]{f5800c};
        this.f5802e = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final bgm m3636d() throws IOException {
        int mo3574r = mo3574r();
        if (mo3574r == 5 || mo3574r == 2 || mo3574r == 4 || mo3574r == 10) {
            String m3565a = bkw.m3565a(mo3574r);
            StringBuilder sb = new StringBuilder(m3565a.length() + 39);
            sb.append("Unexpected ");
            sb.append(m3565a);
            sb.append(" when reading a JsonElement.");
            throw new IllegalStateException(sb.toString());
        }
        bgm bgmVar = (bgm) m3634w();
        mo3577o();
        return bgmVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkv
    /* renamed from: e */
    public final String mo3587e() {
        return m3632y(false);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkv
    /* renamed from: f */
    public final String mo3586f() {
        return m3632y(true);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkv
    /* renamed from: g */
    public final String mo3585g() throws IOException {
        m3637B(5);
        Map.Entry entry = (Map.Entry) ((Iterator) m3634w()).next();
        String str = (String) entry.getKey();
        this.f5803f[this.f5802e - 1] = str;
        m3638A(entry.getValue());
        return str;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkv
    /* renamed from: h */
    public final String mo3584h() throws IOException {
        int mo3574r = mo3574r();
        if (mo3574r == 6 || mo3574r == 7) {
            String m3708b = ((bgr) m3633x()).m3708b();
            int i = this.f5802e;
            if (i > 0) {
                int[] iArr = this.f5804g;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return m3708b;
        }
        String m3565a = bkw.m3565a(mo3574r);
        String m3631z = m3631z();
        StringBuilder sb = new StringBuilder(24 + m3565a.length() + String.valueOf(m3631z).length());
        sb.append("Expected ");
        sb.append("STRING");
        sb.append(" but was ");
        sb.append(m3565a);
        sb.append(m3631z);
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkv
    /* renamed from: i */
    public final void mo3583i() throws IOException {
        m3637B(1);
        m3638A(((bgk) m3634w()).iterator());
        this.f5804g[this.f5802e - 1] = 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkv
    /* renamed from: j */
    public final void mo3582j() throws IOException {
        m3637B(3);
        m3638A(((bgp) m3634w()).m3711a().iterator());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkv
    /* renamed from: k */
    public final void mo3581k() throws IOException {
        m3637B(2);
        m3633x();
        m3633x();
        int i = this.f5802e;
        if (i > 0) {
            int[] iArr = this.f5804g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkv
    /* renamed from: l */
    public final void mo3580l() throws IOException {
        m3637B(4);
        m3633x();
        m3633x();
        int i = this.f5802e;
        if (i > 0) {
            int[] iArr = this.f5804g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkv
    /* renamed from: m */
    public final void mo3579m() throws IOException {
        m3637B(9);
        m3633x();
        int i = this.f5802e;
        if (i > 0) {
            int[] iArr = this.f5804g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    /* renamed from: n */
    public final void m3635n() throws IOException {
        m3637B(5);
        Map.Entry entry = (Map.Entry) ((Iterator) m3634w()).next();
        m3638A(entry.getValue());
        m3638A(new bgr((String) entry.getKey()));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkv
    /* renamed from: o */
    public final void mo3577o() throws IOException {
        if (mo3574r() == 5) {
            mo3585g();
            this.f5803f[this.f5802e - 2] = "null";
        } else {
            m3633x();
            int i = this.f5802e;
            if (i > 0) {
                this.f5803f[i - 1] = "null";
            }
        }
        int i2 = this.f5802e;
        if (i2 > 0) {
            int[] iArr = this.f5804g;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkv
    /* renamed from: p */
    public final boolean mo3576p() throws IOException {
        int mo3574r = mo3574r();
        return (mo3574r == 4 || mo3574r == 2) ? false : true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkv
    /* renamed from: q */
    public final boolean mo3575q() throws IOException {
        m3637B(8);
        boolean m3707c = ((bgr) m3633x()).m3707c();
        int i = this.f5802e;
        if (i > 0) {
            int[] iArr = this.f5804g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return m3707c;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkv
    /* renamed from: r */
    public final int mo3574r() throws IOException {
        if (this.f5802e == 0) {
            return 10;
        }
        Object m3634w = m3634w();
        if (m3634w instanceof Iterator) {
            boolean z = this.f5801d[this.f5802e - 2] instanceof bgp;
            Iterator it = (Iterator) m3634w;
            if (!it.hasNext()) {
                return z ? 4 : 2;
            } else if (z) {
                return 5;
            } else {
                m3638A(it.next());
                return mo3574r();
            }
        } else if (m3634w instanceof bgp) {
            return 3;
        } else {
            if (m3634w instanceof bgk) {
                return 1;
            }
            if (m3634w instanceof bgr) {
                bgr bgrVar = (bgr) m3634w;
                if (bgrVar.m3704f()) {
                    return 6;
                }
                if (bgrVar.m3706d()) {
                    return 8;
                }
                if (bgrVar.m3705e()) {
                    return 7;
                }
                throw new AssertionError();
            } else if (m3634w instanceof bgo) {
                return 9;
            } else {
                if (m3634w == f5800c) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bkv
    public final String toString() {
        String valueOf = String.valueOf(getClass().getSimpleName());
        String valueOf2 = String.valueOf(m3631z());
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }
}
