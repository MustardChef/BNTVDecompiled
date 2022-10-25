package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ao */
/* loaded from: classes2.dex */
public class C2555ao extends IOException {

    /* renamed from: a */
    public final boolean f4772a;

    /* renamed from: b */
    public final int f4773b;

    /* JADX INFO: Access modifiers changed from: protected */
    public C2555ao(String str, Throwable th, boolean z, int i) {
        super(str, th);
        this.f4772a = z;
        this.f4773b = i;
    }

    /* renamed from: a */
    public static C2555ao m4866a(String str, Throwable th) {
        return new C2555ao(str, th, true, 1);
    }

    /* renamed from: b */
    public static C2555ao m4865b(String str, Throwable th) {
        return new C2555ao(str, th, true, 0);
    }

    /* renamed from: c */
    public static C2555ao m4864c(String str, Throwable th) {
        return new C2555ao(str, th, true, 4);
    }

    /* renamed from: d */
    public static C2555ao m4863d(String str) {
        return new C2555ao(str, null, false, 1);
    }
}
