package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.dc */
/* loaded from: classes2.dex */
public final class C2641dc {

    /* renamed from: a */
    private Uri f7003a;

    /* renamed from: b */
    private int f7004b;

    /* renamed from: c */
    private byte[] f7005c;

    /* renamed from: d */
    private Map f7006d;

    /* renamed from: e */
    private long f7007e;

    /* renamed from: f */
    private long f7008f;

    /* renamed from: g */
    private String f7009g;

    /* renamed from: h */
    private int f7010h;

    public C2641dc() {
        this.f7004b = 1;
        this.f7006d = Collections.emptyMap();
        this.f7008f = -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2641dc(C2642dd c2642dd) {
        this.f7003a = c2642dd.f7011a;
        this.f7004b = c2642dd.f7012b;
        this.f7005c = c2642dd.f7013c;
        this.f7006d = c2642dd.f7014d;
        this.f7007e = c2642dd.f7015e;
        this.f7008f = c2642dd.f7016f;
        this.f7009g = c2642dd.f7017g;
        this.f7010h = c2642dd.f7018h;
    }

    /* renamed from: b */
    public final void m2499b(int i) {
        this.f7010h = i;
    }

    /* renamed from: c */
    public final void m2498c(byte[] bArr) {
        this.f7005c = bArr;
    }

    /* renamed from: d */
    public final void m2497d() {
        this.f7004b = 2;
    }

    /* renamed from: e */
    public final void m2496e(Map map) {
        this.f7006d = map;
    }

    /* renamed from: f */
    public final void m2495f(String str) {
        this.f7009g = str;
    }

    /* renamed from: g */
    public final void m2494g(long j) {
        this.f7008f = j;
    }

    /* renamed from: h */
    public final void m2493h(long j) {
        this.f7007e = j;
    }

    /* renamed from: i */
    public final void m2492i(Uri uri) {
        this.f7003a = uri;
    }

    /* renamed from: j */
    public final void m2491j(String str) {
        this.f7003a = Uri.parse(str);
    }

    /* renamed from: a */
    public final C2642dd m2500a() {
        Uri uri = this.f7003a;
        if (uri != null) {
            return new C2642dd(uri, this.f7004b, this.f7005c, this.f7006d, this.f7007e, this.f7008f, this.f7009g, this.f7010h, null);
        }
        throw new IllegalStateException("The uri must be set.");
    }
}
