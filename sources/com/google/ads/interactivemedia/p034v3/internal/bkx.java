package com.google.ads.interactivemedia.p034v3.internal;

import com.facebook.internal.ServerProtocol;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bkx */
/* loaded from: classes2.dex */
public class bkx implements Closeable, Flushable {

    /* renamed from: a */
    private static final String[] f5976a = new String[128];

    /* renamed from: b */
    private static final String[] f5977b;

    /* renamed from: c */
    private final Writer f5978c;

    /* renamed from: d */
    private int[] f5979d = new int[32];

    /* renamed from: e */
    private int f5980e = 0;

    /* renamed from: f */
    private final String f5981f;

    /* renamed from: g */
    private boolean f5982g;

    /* renamed from: h */
    private boolean f5983h;

    /* renamed from: i */
    private String f5984i;

    /* renamed from: j */
    private boolean f5985j;

    static {
        for (int i = 0; i <= 31; i++) {
            f5976a[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = f5976a;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f5977b = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public bkx(Writer writer) {
        m3545t(6);
        this.f5981f = ":";
        this.f5985j = true;
        Objects.requireNonNull(writer, "out == null");
        this.f5978c = writer;
    }

    /* renamed from: a */
    private final int m3564a() {
        int i = this.f5980e;
        if (i == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.f5979d[i - 1];
    }

    /* renamed from: s */
    private final void m3546s() throws IOException {
        int m3564a = m3564a();
        if (m3564a == 1) {
            m3544u(2);
        } else if (m3564a == 2) {
            this.f5978c.append(',');
        } else if (m3564a != 4) {
            if (m3564a != 6) {
                if (m3564a != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f5982g) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            m3544u(7);
        } else {
            this.f5978c.append((CharSequence) this.f5981f);
            m3544u(5);
        }
    }

    /* renamed from: t */
    private final void m3545t(int i) {
        int i2 = this.f5980e;
        int[] iArr = this.f5979d;
        if (i2 == iArr.length) {
            this.f5979d = Arrays.copyOf(iArr, i2 + i2);
        }
        int[] iArr2 = this.f5979d;
        int i3 = this.f5980e;
        this.f5980e = i3 + 1;
        iArr2[i3] = i;
    }

    /* renamed from: u */
    private final void m3544u(int i) {
        this.f5979d[this.f5980e - 1] = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void m3543v(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f5983h
            if (r0 == 0) goto L7
            java.lang.String[] r0 = com.google.ads.interactivemedia.p034v3.internal.bkx.f5977b
            goto L9
        L7:
            java.lang.String[] r0 = com.google.ads.interactivemedia.p034v3.internal.bkx.f5976a
        L9:
            java.io.Writer r1 = r8.f5978c
            r2 = 34
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = 0
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.f5978c
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f5978c
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f5978c
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.f5978c
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.bkx.m3543v(java.lang.String):void");
    }

    /* renamed from: w */
    private final void m3542w() throws IOException {
        if (this.f5984i != null) {
            int m3564a = m3564a();
            if (m3564a == 5) {
                this.f5978c.write(44);
            } else if (m3564a != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            m3544u(4);
            m3543v(this.f5984i);
            this.f5984i = null;
        }
    }

    /* renamed from: x */
    private final void m3541x(int i, int i2, char c) throws IOException {
        int m3564a = m3564a();
        if (m3564a == i2 || m3564a == i) {
            String str = this.f5984i;
            if (str != null) {
                String valueOf = String.valueOf(str);
                throw new IllegalStateException(valueOf.length() != 0 ? "Dangling name: ".concat(valueOf) : new String("Dangling name: "));
            }
            this.f5980e--;
            this.f5978c.write(c);
            return;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    /* renamed from: y */
    private final void m3540y(int i, char c) throws IOException {
        m3546s();
        m3545t(i);
        this.f5978c.write(c);
    }

    /* renamed from: b */
    public void mo3563b() throws IOException {
        m3542w();
        m3540y(1, '[');
    }

    /* renamed from: c */
    public void mo3562c() throws IOException {
        m3542w();
        m3540y(3, '{');
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5978c.close();
        int i = this.f5980e;
        if (i > 1 || (i == 1 && this.f5979d[0] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f5980e = 0;
    }

    /* renamed from: d */
    public void mo3561d() throws IOException {
        m3541x(1, 2, ']');
    }

    /* renamed from: e */
    public void mo3560e() throws IOException {
        m3541x(3, 5, '}');
    }

    /* renamed from: f */
    public void mo3559f(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.f5984i == null) {
            if (this.f5980e != 0) {
                this.f5984i = str;
                return;
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }
        throw new IllegalStateException();
    }

    public void flush() throws IOException {
        if (this.f5980e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f5978c.flush();
    }

    /* renamed from: g */
    public void mo3558g() throws IOException {
        if (this.f5984i != null) {
            if (!this.f5985j) {
                this.f5984i = null;
                return;
            }
            m3542w();
        }
        m3546s();
        this.f5978c.write("null");
    }

    /* renamed from: h */
    public void mo3557h(long j) throws IOException {
        m3542w();
        m3546s();
        this.f5978c.write(Long.toString(j));
    }

    /* renamed from: i */
    public void mo3556i(Boolean bool) throws IOException {
        if (bool == null) {
            mo3558g();
            return;
        }
        m3542w();
        m3546s();
        this.f5978c.write(true != bool.booleanValue() ? "false" : ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
    }

    /* renamed from: j */
    public void mo3555j(Number number) throws IOException {
        if (number == null) {
            mo3558g();
            return;
        }
        m3542w();
        String obj = number.toString();
        if (this.f5982g || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            m3546s();
            this.f5978c.append((CharSequence) obj);
            return;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(number.toString()));
    }

    /* renamed from: k */
    public void mo3554k(String str) throws IOException {
        if (str == null) {
            mo3558g();
            return;
        }
        m3542w();
        m3546s();
        m3543v(str);
    }

    /* renamed from: l */
    public void mo3553l(boolean z) throws IOException {
        m3542w();
        m3546s();
        this.f5978c.write(true != z ? "false" : ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
    }

    /* renamed from: m */
    public final void m3552m(boolean z) {
        this.f5983h = z;
    }

    /* renamed from: n */
    public final void m3551n(boolean z) {
        this.f5982g = z;
    }

    /* renamed from: o */
    public final void m3550o(boolean z) {
        this.f5985j = z;
    }

    /* renamed from: p */
    public final boolean m3549p() {
        return this.f5985j;
    }

    /* renamed from: q */
    public final boolean m3548q() {
        return this.f5983h;
    }

    /* renamed from: r */
    public final boolean m3547r() {
        return this.f5982g;
    }
}
