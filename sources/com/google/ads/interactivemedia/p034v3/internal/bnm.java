package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bnm */
/* loaded from: classes2.dex */
public class bnm extends IOException {
    private static final long serialVersionUID = -1616151763072450476L;

    /* renamed from: a */
    private boolean f6268a;

    public bnm(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static bnl m3258a() {
        return new bnl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static bnm m3257b() {
        return new bnm("Protocol message end-group tag did not match expected tag.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static bnm m3256c() {
        return new bnm("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static bnm m3255d() {
        return new bnm("Protocol message had invalid UTF-8.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static bnm m3254e() {
        return new bnm("CodedInputStream encountered a malformed varint.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static bnm m3253f() {
        return new bnm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static bnm m3252g() {
        return new bnm("Failed to parse the message.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public static bnm m3251h() {
        return new bnm("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public static bnm m3250i() {
        return new bnm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public final void m3249j() {
        this.f6268a = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public final boolean m3248k() {
        return this.f6268a;
    }

    public bnm(String str) {
        super(str);
    }
}
