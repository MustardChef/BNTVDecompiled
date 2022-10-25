package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.tk */
/* loaded from: classes2.dex */
final class C3081tk implements InterfaceC3163wl, InterfaceC3057sn {

    /* renamed from: a */
    final /* synthetic */ C3086tp f8910a;

    /* renamed from: c */
    private final Uri f8912c;

    /* renamed from: d */
    private final C2658dt f8913d;

    /* renamed from: e */
    private final InterfaceC3078th f8914e;

    /* renamed from: f */
    private final InterfaceC3233za f8915f;

    /* renamed from: h */
    private volatile boolean f8917h;

    /* renamed from: j */
    private long f8919j;

    /* renamed from: m */
    private InterfaceC3253zu f8922m;

    /* renamed from: n */
    private boolean f8923n;

    /* renamed from: o */
    private final age f8924o;

    /* renamed from: g */
    private final C3247zo f8916g = new C3247zo();

    /* renamed from: i */
    private boolean f8918i = true;

    /* renamed from: l */
    private long f8921l = -1;

    /* renamed from: b */
    private final long f8911b = C3059sp.m1122a();

    /* renamed from: k */
    private C2642dd f8920k = m1051j(0);

    public C3081tk(C3086tp c3086tp, Uri uri, InterfaceC2637cz interfaceC2637cz, InterfaceC3078th interfaceC3078th, InterfaceC3233za interfaceC3233za, age ageVar, byte[] bArr) {
        this.f8910a = c3086tp;
        this.f8912c = uri;
        this.f8913d = new C2658dt(interfaceC2637cz);
        this.f8914e = interfaceC3078th;
        this.f8915f = interfaceC3233za;
        this.f8924o = ageVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public static /* bridge */ /* synthetic */ void m1052i(C3081tk c3081tk, long j, long j2) {
        c3081tk.f8916g.f9610a = j;
        c3081tk.f8919j = j2;
        c3081tk.f8918i = true;
        c3081tk.f8923n = false;
    }

    /* renamed from: j */
    private final C2642dd m1051j(long j) {
        C2641dc c2641dc = new C2641dc();
        c2641dc.m2492i(this.f8912c);
        c2641dc.m2493h(j);
        c2641dc.m2495f(null);
        c2641dc.m2499b(6);
        c2641dc.m2496e(C3086tp.m1013z());
        return c2641dc.m2500a();
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x01a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0227 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01e6 A[EDGE_INSN: B:129:0x01e6->B:94:0x01e6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0095 A[Catch: all -> 0x0208, TryCatch #2 {all -> 0x0208, blocks: (B:6:0x000c, B:8:0x0022, B:9:0x0025, B:12:0x003a, B:13:0x0040, B:31:0x008a, B:33:0x0095, B:35:0x00a1, B:37:0x00ab, B:39:0x00b7, B:41:0x00c1, B:43:0x00cd, B:45:0x00d7, B:47:0x00e9, B:49:0x00f3, B:50:0x00f9, B:68:0x0139, B:69:0x013f, B:71:0x014c, B:73:0x0154, B:75:0x0170, B:77:0x018f, B:78:0x0194, B:80:0x0198, B:53:0x0101, B:55:0x010b, B:57:0x0115, B:56:0x0110, B:61:0x011d, B:63:0x0127, B:65:0x0131, B:64:0x012c, B:17:0x004a, B:19:0x0056, B:21:0x0061, B:20:0x005b, B:25:0x006a, B:27:0x0076, B:29:0x0080, B:28:0x007b), top: B:117:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ab A[Catch: all -> 0x0208, TryCatch #2 {all -> 0x0208, blocks: (B:6:0x000c, B:8:0x0022, B:9:0x0025, B:12:0x003a, B:13:0x0040, B:31:0x008a, B:33:0x0095, B:35:0x00a1, B:37:0x00ab, B:39:0x00b7, B:41:0x00c1, B:43:0x00cd, B:45:0x00d7, B:47:0x00e9, B:49:0x00f3, B:50:0x00f9, B:68:0x0139, B:69:0x013f, B:71:0x014c, B:73:0x0154, B:75:0x0170, B:77:0x018f, B:78:0x0194, B:80:0x0198, B:53:0x0101, B:55:0x010b, B:57:0x0115, B:56:0x0110, B:61:0x011d, B:63:0x0127, B:65:0x0131, B:64:0x012c, B:17:0x004a, B:19:0x0056, B:21:0x0061, B:20:0x005b, B:25:0x006a, B:27:0x0076, B:29:0x0080, B:28:0x007b), top: B:117:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c1 A[Catch: all -> 0x0208, TryCatch #2 {all -> 0x0208, blocks: (B:6:0x000c, B:8:0x0022, B:9:0x0025, B:12:0x003a, B:13:0x0040, B:31:0x008a, B:33:0x0095, B:35:0x00a1, B:37:0x00ab, B:39:0x00b7, B:41:0x00c1, B:43:0x00cd, B:45:0x00d7, B:47:0x00e9, B:49:0x00f3, B:50:0x00f9, B:68:0x0139, B:69:0x013f, B:71:0x014c, B:73:0x0154, B:75:0x0170, B:77:0x018f, B:78:0x0194, B:80:0x0198, B:53:0x0101, B:55:0x010b, B:57:0x0115, B:56:0x0110, B:61:0x011d, B:63:0x0127, B:65:0x0131, B:64:0x012c, B:17:0x004a, B:19:0x0056, B:21:0x0061, B:20:0x005b, B:25:0x006a, B:27:0x0076, B:29:0x0080, B:28:0x007b), top: B:117:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d7 A[Catch: all -> 0x0208, TryCatch #2 {all -> 0x0208, blocks: (B:6:0x000c, B:8:0x0022, B:9:0x0025, B:12:0x003a, B:13:0x0040, B:31:0x008a, B:33:0x0095, B:35:0x00a1, B:37:0x00ab, B:39:0x00b7, B:41:0x00c1, B:43:0x00cd, B:45:0x00d7, B:47:0x00e9, B:49:0x00f3, B:50:0x00f9, B:68:0x0139, B:69:0x013f, B:71:0x014c, B:73:0x0154, B:75:0x0170, B:77:0x018f, B:78:0x0194, B:80:0x0198, B:53:0x0101, B:55:0x010b, B:57:0x0115, B:56:0x0110, B:61:0x011d, B:63:0x0127, B:65:0x0131, B:64:0x012c, B:17:0x004a, B:19:0x0056, B:21:0x0061, B:20:0x005b, B:25:0x006a, B:27:0x0076, B:29:0x0080, B:28:0x007b), top: B:117:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f3 A[Catch: all -> 0x0208, TRY_LEAVE, TryCatch #2 {all -> 0x0208, blocks: (B:6:0x000c, B:8:0x0022, B:9:0x0025, B:12:0x003a, B:13:0x0040, B:31:0x008a, B:33:0x0095, B:35:0x00a1, B:37:0x00ab, B:39:0x00b7, B:41:0x00c1, B:43:0x00cd, B:45:0x00d7, B:47:0x00e9, B:49:0x00f3, B:50:0x00f9, B:68:0x0139, B:69:0x013f, B:71:0x014c, B:73:0x0154, B:75:0x0170, B:77:0x018f, B:78:0x0194, B:80:0x0198, B:53:0x0101, B:55:0x010b, B:57:0x0115, B:56:0x0110, B:61:0x011d, B:63:0x0127, B:65:0x0131, B:64:0x012c, B:17:0x004a, B:19:0x0056, B:21:0x0061, B:20:0x005b, B:25:0x006a, B:27:0x0076, B:29:0x0080, B:28:0x007b), top: B:117:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0139 A[Catch: all -> 0x0208, TryCatch #2 {all -> 0x0208, blocks: (B:6:0x000c, B:8:0x0022, B:9:0x0025, B:12:0x003a, B:13:0x0040, B:31:0x008a, B:33:0x0095, B:35:0x00a1, B:37:0x00ab, B:39:0x00b7, B:41:0x00c1, B:43:0x00cd, B:45:0x00d7, B:47:0x00e9, B:49:0x00f3, B:50:0x00f9, B:68:0x0139, B:69:0x013f, B:71:0x014c, B:73:0x0154, B:75:0x0170, B:77:0x018f, B:78:0x0194, B:80:0x0198, B:53:0x0101, B:55:0x010b, B:57:0x0115, B:56:0x0110, B:61:0x011d, B:63:0x0127, B:65:0x0131, B:64:0x012c, B:17:0x004a, B:19:0x0056, B:21:0x0061, B:20:0x005b, B:25:0x006a, B:27:0x0076, B:29:0x0080, B:28:0x007b), top: B:117:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014c A[Catch: all -> 0x0208, TryCatch #2 {all -> 0x0208, blocks: (B:6:0x000c, B:8:0x0022, B:9:0x0025, B:12:0x003a, B:13:0x0040, B:31:0x008a, B:33:0x0095, B:35:0x00a1, B:37:0x00ab, B:39:0x00b7, B:41:0x00c1, B:43:0x00cd, B:45:0x00d7, B:47:0x00e9, B:49:0x00f3, B:50:0x00f9, B:68:0x0139, B:69:0x013f, B:71:0x014c, B:73:0x0154, B:75:0x0170, B:77:0x018f, B:78:0x0194, B:80:0x0198, B:53:0x0101, B:55:0x010b, B:57:0x0115, B:56:0x0110, B:61:0x011d, B:63:0x0127, B:65:0x0131, B:64:0x012c, B:17:0x004a, B:19:0x0056, B:21:0x0061, B:20:0x005b, B:25:0x006a, B:27:0x0076, B:29:0x0080, B:28:0x007b), top: B:117:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x018f A[Catch: all -> 0x0208, TryCatch #2 {all -> 0x0208, blocks: (B:6:0x000c, B:8:0x0022, B:9:0x0025, B:12:0x003a, B:13:0x0040, B:31:0x008a, B:33:0x0095, B:35:0x00a1, B:37:0x00ab, B:39:0x00b7, B:41:0x00c1, B:43:0x00cd, B:45:0x00d7, B:47:0x00e9, B:49:0x00f3, B:50:0x00f9, B:68:0x0139, B:69:0x013f, B:71:0x014c, B:73:0x0154, B:75:0x0170, B:77:0x018f, B:78:0x0194, B:80:0x0198, B:53:0x0101, B:55:0x010b, B:57:0x0115, B:56:0x0110, B:61:0x011d, B:63:0x0127, B:65:0x0131, B:64:0x012c, B:17:0x004a, B:19:0x0056, B:21:0x0061, B:20:0x005b, B:25:0x006a, B:27:0x0076, B:29:0x0080, B:28:0x007b), top: B:117:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0198 A[Catch: all -> 0x0208, TRY_LEAVE, TryCatch #2 {all -> 0x0208, blocks: (B:6:0x000c, B:8:0x0022, B:9:0x0025, B:12:0x003a, B:13:0x0040, B:31:0x008a, B:33:0x0095, B:35:0x00a1, B:37:0x00ab, B:39:0x00b7, B:41:0x00c1, B:43:0x00cd, B:45:0x00d7, B:47:0x00e9, B:49:0x00f3, B:50:0x00f9, B:68:0x0139, B:69:0x013f, B:71:0x014c, B:73:0x0154, B:75:0x0170, B:77:0x018f, B:78:0x0194, B:80:0x0198, B:53:0x0101, B:55:0x010b, B:57:0x0115, B:56:0x0110, B:61:0x011d, B:63:0x0127, B:65:0x0131, B:64:0x012c, B:17:0x004a, B:19:0x0056, B:21:0x0061, B:20:0x005b, B:25:0x006a, B:27:0x0076, B:29:0x0080, B:28:0x007b), top: B:117:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01e9  */
    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3163wl
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo701e() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 552
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C3081tk.mo701e():void");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3163wl
    /* renamed from: r */
    public final void mo700r() {
        this.f8917h = true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3057sn
    /* renamed from: a */
    public final void mo1058a(C2621cj c2621cj) {
        long max = !this.f8923n ? this.f8919j : Math.max(C3086tp.m1019r(this.f8910a), this.f8919j);
        int m2641a = c2621cj.m2641a();
        InterfaceC3253zu interfaceC3253zu = this.f8922m;
        C2616ce.m2689d(interfaceC3253zu);
        interfaceC3253zu.mo442e(c2621cj, m2641a);
        interfaceC3253zu.mo441f(max, 1, m2641a, 0, null);
        this.f8923n = true;
    }
}
