package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Objects;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aru */
/* loaded from: classes2.dex */
public final class aru {

    /* renamed from: a */
    private String f4952a;

    /* renamed from: b */
    private Boolean f4953b;

    /* renamed from: c */
    private Boolean f4954c;

    public aru() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aru(byte[] bArr) {
        this();
    }

    /* renamed from: a */
    public final arv m4721a() {
        Boolean bool;
        String str = this.f4952a;
        if (str == null || (bool = this.f4953b) == null || this.f4954c == null) {
            StringBuilder sb = new StringBuilder();
            if (this.f4952a == null) {
                sb.append(" clientVersion");
            }
            if (this.f4953b == null) {
                sb.append(" shouldGetAdvertisingId");
            }
            if (this.f4954c == null) {
                sb.append(" isGooglePlayServicesAvailable");
            }
            throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
        }
        boolean booleanValue = bool.booleanValue();
        this.f4954c.booleanValue();
        return new arv(str, booleanValue, true);
    }

    /* renamed from: b */
    public final void m4720b(String str) {
        Objects.requireNonNull(str, "Null clientVersion");
        this.f4952a = str;
    }

    /* renamed from: c */
    public final void m4719c() {
        this.f4954c = true;
    }

    /* renamed from: d */
    public final void m4718d(boolean z) {
        this.f4953b = Boolean.valueOf(z);
    }
}
