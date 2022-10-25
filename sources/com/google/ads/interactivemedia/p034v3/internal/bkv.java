package com.google.ads.interactivemedia.p034v3.internal;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import kotlin.text.Typography;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bkv */
/* loaded from: classes2.dex */
public class bkv implements Closeable {

    /* renamed from: b */
    private final Reader f5962b;

    /* renamed from: i */
    private long f5969i;

    /* renamed from: j */
    private int f5970j;

    /* renamed from: k */
    private String f5971k;

    /* renamed from: l */
    private int[] f5972l;

    /* renamed from: n */
    private String[] f5974n;

    /* renamed from: o */
    private int[] f5975o;

    /* renamed from: c */
    private boolean f5963c = false;

    /* renamed from: d */
    private final char[] f5964d = new char[1024];

    /* renamed from: e */
    private int f5965e = 0;

    /* renamed from: f */
    private int f5966f = 0;

    /* renamed from: g */
    private int f5967g = 0;

    /* renamed from: h */
    private int f5968h = 0;

    /* renamed from: a */
    int f5961a = 0;

    /* renamed from: m */
    private int f5973m = 1;

    static {
        bhp.f5742a = new bku();
    }

    public bkv(Reader reader) {
        int[] iArr = new int[32];
        this.f5972l = iArr;
        iArr[0] = 6;
        this.f5974n = new String[32];
        this.f5975o = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f5962b = reader;
    }

    /* renamed from: A */
    private final void m3597A() throws IOException {
        if (!this.f5963c) {
            throw m3569w("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    /* renamed from: B */
    private final void m3596B(int i) {
        int i2 = this.f5973m;
        int[] iArr = this.f5972l;
        if (i2 == iArr.length) {
            int i3 = i2 + i2;
            this.f5972l = Arrays.copyOf(iArr, i3);
            this.f5975o = Arrays.copyOf(this.f5975o, i3);
            this.f5974n = (String[]) Arrays.copyOf(this.f5974n, i3);
        }
        int[] iArr2 = this.f5972l;
        int i4 = this.f5973m;
        this.f5973m = i4 + 1;
        iArr2[i4] = i;
    }

    /* renamed from: C */
    private final void m3595C(char c) throws IOException {
        char[] cArr = this.f5964d;
        do {
            int i = this.f5965e;
            int i2 = this.f5966f;
            while (i < i2) {
                int i3 = i + 1;
                char c2 = cArr[i];
                if (c2 == c) {
                    this.f5965e = i3;
                    return;
                } else if (c2 == '\\') {
                    this.f5965e = i3;
                    m3588d();
                    i = this.f5965e;
                    i2 = this.f5966f;
                } else {
                    if (c2 == '\n') {
                        this.f5967g++;
                        this.f5968h = i3;
                    }
                    i = i3;
                }
            }
            this.f5965e = i;
        } while (m3593E(1));
        throw m3569w("Unterminated string");
    }

    /* renamed from: D */
    private final void m3594D() throws IOException {
        char c;
        do {
            if (this.f5965e >= this.f5966f && !m3593E(1)) {
                return;
            }
            char[] cArr = this.f5964d;
            int i = this.f5965e;
            int i2 = i + 1;
            this.f5965e = i2;
            c = cArr[i];
            if (c == '\n') {
                this.f5967g++;
                this.f5968h = i2;
                return;
            }
        } while (c != '\r');
    }

    /* renamed from: E */
    private final boolean m3593E(int i) throws IOException {
        int i2;
        char[] cArr = this.f5964d;
        int i3 = this.f5968h;
        int i4 = this.f5965e;
        this.f5968h = i3 - i4;
        int i5 = this.f5966f;
        if (i5 != i4) {
            int i6 = i5 - i4;
            this.f5966f = i6;
            System.arraycopy(cArr, i4, cArr, 0, i6);
        } else {
            this.f5966f = 0;
        }
        this.f5965e = 0;
        do {
            Reader reader = this.f5962b;
            int i7 = this.f5966f;
            int read = reader.read(cArr, i7, 1024 - i7);
            if (read == -1) {
                return false;
            }
            i2 = this.f5966f + read;
            this.f5966f = i2;
            if (this.f5967g == 0 && this.f5968h == 0 && i2 > 0 && cArr[0] == 65279) {
                this.f5965e++;
                this.f5968h = 1;
                i++;
                continue;
            }
        } while (i2 < i);
        return true;
    }

    /* renamed from: F */
    private final boolean m3592F(char c) throws IOException {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        m3597A();
        return false;
    }

    /* renamed from: d */
    private final char m3588d() throws IOException {
        int i;
        if (this.f5965e != this.f5966f || m3593E(1)) {
            char[] cArr = this.f5964d;
            int i2 = this.f5965e;
            int i3 = i2 + 1;
            this.f5965e = i3;
            char c = cArr[i2];
            if (c == '\n') {
                this.f5967g++;
                this.f5968h = i3;
            } else if (c != '\"' && c != '\'' && c != '/' && c != '\\') {
                if (c != 'b') {
                    if (c != 'f') {
                        if (c != 'n') {
                            if (c != 'r') {
                                if (c != 't') {
                                    if (c == 'u') {
                                        if (i3 + 4 <= this.f5966f || m3593E(4)) {
                                            int i4 = this.f5965e;
                                            int i5 = i4 + 4;
                                            char c2 = 0;
                                            while (i4 < i5) {
                                                char[] cArr2 = this.f5964d;
                                                char c3 = cArr2[i4];
                                                char c4 = (char) (c2 << 4);
                                                if (c3 >= '0' && c3 <= '9') {
                                                    i = c3 - '0';
                                                } else if (c3 >= 'a' && c3 <= 'f') {
                                                    i = c3 - 'W';
                                                } else if (c3 < 'A' || c3 > 'F') {
                                                    String str = new String(cArr2, this.f5965e, 4);
                                                    throw new NumberFormatException(str.length() != 0 ? "\\u".concat(str) : new String("\\u"));
                                                } else {
                                                    i = c3 - '7';
                                                }
                                                c2 = (char) (c4 + i);
                                                i4++;
                                            }
                                            this.f5965e += 4;
                                            return c2;
                                        }
                                        throw m3569w("Unterminated escape sequence");
                                    }
                                    throw m3569w("Invalid escape sequence");
                                }
                                return '\t';
                            }
                            return '\r';
                        }
                        return '\n';
                    }
                    return '\f';
                }
                return '\b';
            }
            return c;
        }
        throw m3569w("Unterminated escape sequence");
    }

    /* renamed from: n */
    private final int m3578n(boolean z) throws IOException {
        int i;
        char[] cArr = this.f5964d;
        int i2 = this.f5965e;
        int i3 = this.f5966f;
        while (true) {
            if (i2 == i3) {
                this.f5965e = i2;
                if (!m3593E(1)) {
                    if (z) {
                        String valueOf = String.valueOf(m3572t());
                        throw new EOFException(valueOf.length() != 0 ? "End of input".concat(valueOf) : new String("End of input"));
                    }
                    return -1;
                }
                i2 = this.f5965e;
                i3 = this.f5966f;
            }
            int i4 = i2 + 1;
            char c = cArr[i2];
            if (c == '\n') {
                this.f5967g++;
                this.f5968h = i4;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c == '/') {
                    this.f5965e = i4;
                    if (i4 == i3) {
                        this.f5965e = i4 - 1;
                        boolean m3593E = m3593E(2);
                        this.f5965e++;
                        if (!m3593E) {
                            return 47;
                        }
                    }
                    m3597A();
                    int i5 = this.f5965e;
                    char c2 = cArr[i5];
                    if (c2 == '*') {
                        this.f5965e = i5 + 1;
                        while (true) {
                            if (this.f5965e + 2 <= this.f5966f || m3593E(2)) {
                                char[] cArr2 = this.f5964d;
                                int i6 = this.f5965e;
                                if (cArr2[i6] != '\n') {
                                    while (i < 2) {
                                        i = this.f5964d[this.f5965e + i] == "*/".charAt(i) ? i + 1 : 0;
                                    }
                                    i2 = 2 + this.f5965e;
                                    i3 = this.f5966f;
                                    break;
                                }
                                this.f5967g++;
                                this.f5968h = i6 + 1;
                                this.f5965e++;
                            } else {
                                throw m3569w("Unterminated comment");
                            }
                        }
                    } else if (c2 != '/') {
                        return 47;
                    } else {
                        this.f5965e = i5 + 1;
                        m3594D();
                        i2 = this.f5965e;
                        i3 = this.f5966f;
                    }
                } else if (c != '#') {
                    this.f5965e = i4;
                    return c;
                } else {
                    this.f5965e = i4;
                    m3597A();
                    m3594D();
                    i2 = this.f5965e;
                    i3 = this.f5966f;
                }
            }
            i2 = i4;
        }
    }

    /* renamed from: w */
    private final IOException m3569w(String str) throws IOException {
        String valueOf = String.valueOf(m3572t());
        throw new bky(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    /* renamed from: x */
    private String m3568x(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(Typography.dollar);
        int i = 0;
        while (true) {
            int i2 = this.f5973m;
            if (i >= i2) {
                return sb.toString();
            }
            int i3 = this.f5972l[i];
            if (i3 == 1 || i3 == 2) {
                int i4 = this.f5975o[i];
                if (z && i4 > 0 && i == i2 - 1) {
                    i4--;
                }
                sb.append('[');
                sb.append(i4);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                String str = this.f5974n[i];
                if (str != null) {
                    sb.append(str);
                }
            }
            i++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005d, code lost:
        if (r1 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005f, code lost:
        r1 = r2 - r3;
        r1 = new java.lang.StringBuilder(java.lang.Math.max(r1 + r1, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
        r1.append(r0, r3, r2 - r3);
        r9.f5965e = r2;
     */
    /* renamed from: y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String m3567y(char r10) throws java.io.IOException {
        /*
            r9 = this;
            char[] r0 = r9.f5964d
            r1 = 0
        L3:
            int r2 = r9.f5965e
            int r3 = r9.f5966f
        L7:
            r4 = r3
            r3 = r2
        L9:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L5d
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L29
            r9.f5965e = r7
            int r7 = r7 - r3
            int r7 = r7 + (-1)
            if (r1 != 0) goto L21
            java.lang.String r10 = new java.lang.String
            r10.<init>(r0, r3, r7)
            return r10
        L21:
            r1.append(r0, r3, r7)
            java.lang.String r10 = r1.toString()
            return r10
        L29:
            r8 = 92
            if (r2 != r8) goto L50
            r9.f5965e = r7
            int r7 = r7 - r3
            int r7 = r7 + (-1)
            if (r1 != 0) goto L41
            int r1 = r7 + 1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = r1 + r1
            int r1 = java.lang.Math.max(r1, r5)
            r2.<init>(r1)
            r1 = r2
        L41:
            r1.append(r0, r3, r7)
            char r2 = r9.m3588d()
            r1.append(r2)
            int r2 = r9.f5965e
            int r3 = r9.f5966f
            goto L7
        L50:
            r5 = 10
            if (r2 != r5) goto L5b
            int r2 = r9.f5967g
            int r2 = r2 + r6
            r9.f5967g = r2
            r9.f5968h = r7
        L5b:
            r2 = r7
            goto L9
        L5d:
            if (r1 != 0) goto L6c
            int r1 = r2 - r3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = r1 + r1
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L6c:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r9.f5965e = r2
            boolean r2 = r9.m3593E(r6)
            if (r2 == 0) goto L7a
            goto L3
        L7a:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r10 = r9.m3569w(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.bkv.m3567y(char):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0048, code lost:
        m3597A();
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0086  */
    /* renamed from: z */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String m3566z() throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = 0
        L3:
            int r3 = r5.f5965e
            int r3 = r3 + r2
            int r4 = r5.f5966f
            if (r3 >= r4) goto L4c
            char[] r4 = r5.f5964d
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L58
            r4 = 10
            if (r3 == r4) goto L58
            r4 = 12
            if (r3 == r4) goto L58
            r4 = 13
            if (r3 == r4) goto L58
            r4 = 32
            if (r3 == r4) goto L58
            r4 = 35
            if (r3 == r4) goto L48
            r4 = 44
            if (r3 == r4) goto L58
            r4 = 47
            if (r3 == r4) goto L48
            r4 = 61
            if (r3 == r4) goto L48
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L58
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L58
            r4 = 58
            if (r3 == r4) goto L58
            r4 = 59
            if (r3 == r4) goto L48
            switch(r3) {
                case 91: goto L58;
                case 92: goto L48;
                case 93: goto L58;
                default: goto L45;
            }
        L45:
            int r2 = r2 + 1
            goto L3
        L48:
            r5.m3597A()
            goto L58
        L4c:
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 >= r3) goto L5a
            int r3 = r2 + 1
            boolean r3 = r5.m3593E(r3)
            if (r3 != 0) goto L3
        L58:
            r0 = r2
            goto L7a
        L5a:
            if (r1 != 0) goto L67
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r1.<init>(r3)
        L67:
            char[] r3 = r5.f5964d
            int r4 = r5.f5965e
            r1.append(r3, r4, r2)
            int r3 = r5.f5965e
            int r3 = r3 + r2
            r5.f5965e = r3
            r2 = 1
            boolean r2 = r5.m3593E(r2)
            if (r2 != 0) goto L2
        L7a:
            if (r1 != 0) goto L86
            java.lang.String r1 = new java.lang.String
            char[] r2 = r5.f5964d
            int r3 = r5.f5965e
            r1.<init>(r2, r3, r0)
            goto L91
        L86:
            char[] r2 = r5.f5964d
            int r3 = r5.f5965e
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L91:
            int r2 = r5.f5965e
            int r2 = r2 + r0
            r5.f5965e = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.bkv.m3566z():java.lang.String");
    }

    /* renamed from: a */
    public double mo3591a() throws IOException {
        int i = this.f5961a;
        if (i == 0) {
            i = m3573s();
        }
        if (i == 15) {
            this.f5961a = 0;
            int[] iArr = this.f5975o;
            int i2 = this.f5973m - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f5969i;
        }
        if (i == 16) {
            char[] cArr = this.f5964d;
            int i3 = this.f5965e;
            int i4 = this.f5970j;
            this.f5971k = new String(cArr, i3, i4);
            this.f5965e = i3 + i4;
        } else if (i == 8 || i == 9) {
            this.f5971k = m3567y(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.f5971k = m3566z();
        } else if (i != 11) {
            String m3565a = bkw.m3565a(mo3574r());
            String m3572t = m3572t();
            StringBuilder sb = new StringBuilder(m3565a.length() + 26 + String.valueOf(m3572t).length());
            sb.append("Expected a double but was ");
            sb.append(m3565a);
            sb.append(m3572t);
            throw new IllegalStateException(sb.toString());
        }
        this.f5961a = 11;
        double parseDouble = Double.parseDouble(this.f5971k);
        if (this.f5963c || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.f5971k = null;
            this.f5961a = 0;
            int[] iArr2 = this.f5975o;
            int i5 = this.f5973m - 1;
            iArr2[i5] = iArr2[i5] + 1;
            return parseDouble;
        }
        String m3572t2 = m3572t();
        StringBuilder sb2 = new StringBuilder(String.valueOf(m3572t2).length() + 57);
        sb2.append("JSON forbids NaN and infinities: ");
        sb2.append(parseDouble);
        sb2.append(m3572t2);
        throw new bky(sb2.toString());
    }

    /* renamed from: b */
    public int mo3590b() throws IOException {
        int i = this.f5961a;
        if (i == 0) {
            i = m3573s();
        }
        if (i == 15) {
            long j = this.f5969i;
            int i2 = (int) j;
            if (j == i2) {
                this.f5961a = 0;
                int[] iArr = this.f5975o;
                int i3 = this.f5973m - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            String m3572t = m3572t();
            StringBuilder sb = new StringBuilder(String.valueOf(m3572t).length() + 44);
            sb.append("Expected an int but was ");
            sb.append(j);
            sb.append(m3572t);
            throw new NumberFormatException(sb.toString());
        }
        if (i == 16) {
            char[] cArr = this.f5964d;
            int i4 = this.f5965e;
            int i5 = this.f5970j;
            this.f5971k = new String(cArr, i4, i5);
            this.f5965e = i4 + i5;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.f5971k = m3566z();
            } else {
                this.f5971k = m3567y(i == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.f5971k);
                this.f5961a = 0;
                int[] iArr2 = this.f5975o;
                int i6 = this.f5973m - 1;
                iArr2[i6] = iArr2[i6] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            String m3565a = bkw.m3565a(mo3574r());
            String m3572t2 = m3572t();
            StringBuilder sb2 = new StringBuilder(m3565a.length() + 24 + String.valueOf(m3572t2).length());
            sb2.append("Expected an int but was ");
            sb2.append(m3565a);
            sb2.append(m3572t2);
            throw new IllegalStateException(sb2.toString());
        }
        this.f5961a = 11;
        double parseDouble = Double.parseDouble(this.f5971k);
        int i7 = (int) parseDouble;
        if (i7 == parseDouble) {
            this.f5971k = null;
            this.f5961a = 0;
            int[] iArr3 = this.f5975o;
            int i8 = this.f5973m - 1;
            iArr3[i8] = iArr3[i8] + 1;
            return i7;
        }
        String str = this.f5971k;
        String m3572t3 = m3572t();
        StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 24 + String.valueOf(m3572t3).length());
        sb3.append("Expected an int but was ");
        sb3.append(str);
        sb3.append(m3572t3);
        throw new NumberFormatException(sb3.toString());
    }

    /* renamed from: c */
    public long mo3589c() throws IOException {
        int i = this.f5961a;
        if (i == 0) {
            i = m3573s();
        }
        if (i == 15) {
            this.f5961a = 0;
            int[] iArr = this.f5975o;
            int i2 = this.f5973m - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f5969i;
        }
        if (i == 16) {
            char[] cArr = this.f5964d;
            int i3 = this.f5965e;
            int i4 = this.f5970j;
            this.f5971k = new String(cArr, i3, i4);
            this.f5965e = i3 + i4;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.f5971k = m3566z();
            } else {
                this.f5971k = m3567y(i == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.f5971k);
                this.f5961a = 0;
                int[] iArr2 = this.f5975o;
                int i5 = this.f5973m - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            String m3565a = bkw.m3565a(mo3574r());
            String m3572t = m3572t();
            StringBuilder sb = new StringBuilder(m3565a.length() + 24 + String.valueOf(m3572t).length());
            sb.append("Expected a long but was ");
            sb.append(m3565a);
            sb.append(m3572t);
            throw new IllegalStateException(sb.toString());
        }
        this.f5961a = 11;
        double parseDouble = Double.parseDouble(this.f5971k);
        long j = (long) parseDouble;
        if (j == parseDouble) {
            this.f5971k = null;
            this.f5961a = 0;
            int[] iArr3 = this.f5975o;
            int i6 = this.f5973m - 1;
            iArr3[i6] = iArr3[i6] + 1;
            return j;
        }
        String str = this.f5971k;
        String m3572t2 = m3572t();
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 24 + String.valueOf(m3572t2).length());
        sb2.append("Expected a long but was ");
        sb2.append(str);
        sb2.append(m3572t2);
        throw new NumberFormatException(sb2.toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5961a = 0;
        this.f5972l[0] = 8;
        this.f5973m = 1;
        this.f5962b.close();
    }

    /* renamed from: e */
    public String mo3587e() {
        return m3568x(false);
    }

    /* renamed from: f */
    public String mo3586f() {
        return m3568x(true);
    }

    /* renamed from: g */
    public String mo3585g() throws IOException {
        String m3567y;
        int i = this.f5961a;
        if (i == 0) {
            i = m3573s();
        }
        if (i == 14) {
            m3567y = m3566z();
        } else if (i == 12) {
            m3567y = m3567y('\'');
        } else if (i == 13) {
            m3567y = m3567y('\"');
        } else {
            String m3565a = bkw.m3565a(mo3574r());
            String m3572t = m3572t();
            StringBuilder sb = new StringBuilder(m3565a.length() + 24 + String.valueOf(m3572t).length());
            sb.append("Expected a name but was ");
            sb.append(m3565a);
            sb.append(m3572t);
            throw new IllegalStateException(sb.toString());
        }
        this.f5961a = 0;
        this.f5974n[this.f5973m - 1] = m3567y;
        return m3567y;
    }

    /* renamed from: h */
    public String mo3584h() throws IOException {
        String str;
        int i = this.f5961a;
        if (i == 0) {
            i = m3573s();
        }
        if (i == 10) {
            str = m3566z();
        } else if (i == 8) {
            str = m3567y('\'');
        } else if (i == 9) {
            str = m3567y('\"');
        } else if (i == 11) {
            str = this.f5971k;
            this.f5971k = null;
        } else if (i == 15) {
            str = Long.toString(this.f5969i);
        } else if (i == 16) {
            str = new String(this.f5964d, this.f5965e, this.f5970j);
            this.f5965e += this.f5970j;
        } else {
            String m3565a = bkw.m3565a(mo3574r());
            String m3572t = m3572t();
            StringBuilder sb = new StringBuilder(m3565a.length() + 26 + String.valueOf(m3572t).length());
            sb.append("Expected a string but was ");
            sb.append(m3565a);
            sb.append(m3572t);
            throw new IllegalStateException(sb.toString());
        }
        this.f5961a = 0;
        int[] iArr = this.f5975o;
        int i2 = this.f5973m - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    /* renamed from: i */
    public void mo3583i() throws IOException {
        int i = this.f5961a;
        if (i == 0) {
            i = m3573s();
        }
        if (i == 3) {
            m3596B(1);
            this.f5975o[this.f5973m - 1] = 0;
            this.f5961a = 0;
            return;
        }
        String m3565a = bkw.m3565a(mo3574r());
        String m3572t = m3572t();
        StringBuilder sb = new StringBuilder(m3565a.length() + 29 + String.valueOf(m3572t).length());
        sb.append("Expected BEGIN_ARRAY but was ");
        sb.append(m3565a);
        sb.append(m3572t);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: j */
    public void mo3582j() throws IOException {
        int i = this.f5961a;
        if (i == 0) {
            i = m3573s();
        }
        if (i == 1) {
            m3596B(3);
            this.f5961a = 0;
            return;
        }
        String m3565a = bkw.m3565a(mo3574r());
        String m3572t = m3572t();
        StringBuilder sb = new StringBuilder(m3565a.length() + 30 + String.valueOf(m3572t).length());
        sb.append("Expected BEGIN_OBJECT but was ");
        sb.append(m3565a);
        sb.append(m3572t);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: k */
    public void mo3581k() throws IOException {
        int i = this.f5961a;
        if (i == 0) {
            i = m3573s();
        }
        if (i == 4) {
            int i2 = this.f5973m - 1;
            this.f5973m = i2;
            int[] iArr = this.f5975o;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.f5961a = 0;
            return;
        }
        String m3565a = bkw.m3565a(mo3574r());
        String m3572t = m3572t();
        StringBuilder sb = new StringBuilder(m3565a.length() + 27 + String.valueOf(m3572t).length());
        sb.append("Expected END_ARRAY but was ");
        sb.append(m3565a);
        sb.append(m3572t);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: l */
    public void mo3580l() throws IOException {
        int i = this.f5961a;
        if (i == 0) {
            i = m3573s();
        }
        if (i == 2) {
            int i2 = this.f5973m - 1;
            this.f5973m = i2;
            this.f5974n[i2] = null;
            int[] iArr = this.f5975o;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.f5961a = 0;
            return;
        }
        String m3565a = bkw.m3565a(mo3574r());
        String m3572t = m3572t();
        StringBuilder sb = new StringBuilder(m3565a.length() + 28 + String.valueOf(m3572t).length());
        sb.append("Expected END_OBJECT but was ");
        sb.append(m3565a);
        sb.append(m3572t);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: m */
    public void mo3579m() throws IOException {
        int i = this.f5961a;
        if (i == 0) {
            i = m3573s();
        }
        if (i == 7) {
            this.f5961a = 0;
            int[] iArr = this.f5975o;
            int i2 = this.f5973m - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        String m3565a = bkw.m3565a(mo3574r());
        String m3572t = m3572t();
        StringBuilder sb = new StringBuilder(m3565a.length() + 22 + String.valueOf(m3572t).length());
        sb.append("Expected null but was ");
        sb.append(m3565a);
        sb.append(m3572t);
        throw new IllegalStateException(sb.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x009d, code lost:
        m3597A();
     */
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo3577o() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.bkv.mo3577o():void");
    }

    /* renamed from: p */
    public boolean mo3576p() throws IOException {
        int i = this.f5961a;
        if (i == 0) {
            i = m3573s();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    /* renamed from: q */
    public boolean mo3575q() throws IOException {
        int i = this.f5961a;
        if (i == 0) {
            i = m3573s();
        }
        if (i == 5) {
            this.f5961a = 0;
            int[] iArr = this.f5975o;
            int i2 = this.f5973m - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.f5961a = 0;
            int[] iArr2 = this.f5975o;
            int i3 = this.f5973m - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            String m3565a = bkw.m3565a(mo3574r());
            String m3572t = m3572t();
            StringBuilder sb = new StringBuilder(m3565a.length() + 27 + String.valueOf(m3572t).length());
            sb.append("Expected a boolean but was ");
            sb.append(m3565a);
            sb.append(m3572t);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* renamed from: r */
    public int mo3574r() throws IOException {
        int i = this.f5961a;
        if (i == 0) {
            i = m3573s();
        }
        switch (i) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            default:
                return 10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x019f, code lost:
        r1 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0211, code lost:
        if (m3592F(r1) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0214, code lost:
        if (r9 != 2) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0216, code lost:
        if (r13 == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x021c, code lost:
        if (r11 != Long.MIN_VALUE) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x021e, code lost:
        if (r16 == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0220, code lost:
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0222, code lost:
        r14 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0226, code lost:
        if (r11 != 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0228, code lost:
        if (r14 != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x022a, code lost:
        if (r14 == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x022d, code lost:
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x022e, code lost:
        r19.f5969i = r11;
        r19.f5965e += r10;
        r19.f5961a = 15;
        r14 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x023c, code lost:
        r1 = 2;
        r9 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x023e, code lost:
        if (r9 == r1) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0241, code lost:
        if (r9 == 4) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0244, code lost:
        if (r9 != 7) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0246, code lost:
        r19.f5970j = r10;
        r19.f5961a = 16;
        r14 = 16;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0277 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0293 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e5  */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m3573s() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 817
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.bkv.m3573s():int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: t */
    public String m3572t() {
        int i = this.f5967g;
        int i2 = this.f5965e;
        int i3 = this.f5968h;
        String mo3587e = mo3587e();
        StringBuilder sb = new StringBuilder(String.valueOf(mo3587e).length() + 45);
        sb.append(" at line ");
        sb.append(i + 1);
        sb.append(" column ");
        sb.append((i2 - i3) + 1);
        sb.append(" path ");
        sb.append(mo3587e);
        return sb.toString();
    }

    public String toString() {
        String valueOf = String.valueOf(getClass().getSimpleName());
        String valueOf2 = String.valueOf(m3572t());
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* renamed from: u */
    public final void m3571u(boolean z) {
        this.f5963c = z;
    }

    /* renamed from: v */
    public final boolean m3570v() {
        return this.f5963c;
    }
}
