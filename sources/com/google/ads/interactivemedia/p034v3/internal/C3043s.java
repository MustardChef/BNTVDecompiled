package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.s */
/* loaded from: classes2.dex */
public final class C3043s {

    /* renamed from: a */
    private String f8798a;

    /* renamed from: b */
    private Uri f8799b;

    /* renamed from: c */
    private String f8800c;

    /* renamed from: d */
    private final C3070t f8801d;

    /* renamed from: e */
    private C3151w f8802e;

    /* renamed from: f */
    private List f8803f;

    /* renamed from: g */
    private avg f8804g;

    /* renamed from: h */
    private C2546ah f8805h;

    /* renamed from: i */
    private C3205y f8806i;

    public C3043s() {
        this.f8801d = new C3070t();
        this.f8802e = new C3151w((byte[]) null);
        this.f8803f = Collections.emptyList();
        this.f8804g = avg.m4515n();
        this.f8806i = new C3205y();
    }

    /* renamed from: a */
    public final C2543ae m1177a() {
        C2540ac c2540ac;
        C3151w.m770e(this.f8802e);
        C2616ce.m2685h(true);
        Uri uri = this.f8799b;
        if (uri != null) {
            c2540ac = new C2540ac(uri, this.f8800c, C3151w.m772c(this.f8802e) != null ? new C3178x(this.f8802e) : null, this.f8803f, this.f8804g);
        } else {
            c2540ac = null;
        }
        String str = this.f8798a;
        if (str == null) {
            str = "";
        }
        String str2 = str;
        C3124v m1091a = this.f8801d.m1091a();
        C3232z m559f = this.f8806i.m559f();
        C2546ah c2546ah = this.f8805h;
        if (c2546ah == null) {
            c2546ah = C2546ah.f4036a;
        }
        return new C2543ae(str2, m1091a, c2540ac, m559f, c2546ah);
    }

    /* renamed from: b */
    public final void m1176b(String str) {
        this.f8798a = str;
    }

    /* renamed from: c */
    public final void m1175c(String str) {
        this.f8800c = str;
    }

    /* renamed from: d */
    public final void m1174d(List list) {
        List emptyList;
        if (list == null || list.isEmpty()) {
            emptyList = Collections.emptyList();
        } else {
            emptyList = Collections.unmodifiableList(new ArrayList(list));
        }
        this.f8803f = emptyList;
    }

    /* renamed from: e */
    public final void m1173e(Uri uri) {
        this.f8799b = uri;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C3043s(C2543ae c2543ae) {
        this();
        this.f8801d = new C3070t(c2543ae.f3565e);
        this.f8798a = c2543ae.f3561a;
        this.f8805h = c2543ae.f3564d;
        this.f8806i = c2543ae.f3563c.m490a();
        C2537aa c2537aa = c2543ae.f3562b;
        if (c2537aa != null) {
            this.f8800c = c2537aa.f2864b;
            this.f8799b = c2537aa.f2863a;
            this.f8803f = c2537aa.f2867e;
            this.f8804g = c2537aa.f2869g;
            C3178x c3178x = c2537aa.f2865c;
            this.f8802e = c3178x != null ? new C3151w(c3178x) : new C3151w((byte[]) null);
        }
    }
}
