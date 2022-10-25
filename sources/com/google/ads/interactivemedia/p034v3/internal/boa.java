package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.boa */
/* loaded from: classes2.dex */
final class boa implements boh {

    /* renamed from: b */
    private static final boa f6305b = new boa(1, null);

    /* renamed from: a */
    private final /* synthetic */ int f6306a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boa(int i) {
        this.f6306a = i;
    }

    private boa(int i, byte[] bArr) {
        this.f6306a = i;
    }

    /* renamed from: c */
    public static boa m3193c() {
        return f6305b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boh
    /* renamed from: b */
    public final boolean mo3181b(Class cls) {
        if (this.f6306a != 0) {
            return bnd.class.isAssignableFrom(cls);
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boh
    /* renamed from: a */
    public final bog mo3182a(Class cls) {
        if (this.f6306a != 0) {
            if (!bnd.class.isAssignableFrom(cls)) {
                String valueOf = String.valueOf(cls.getName());
                throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
            }
            try {
                return (bog) bnd.m3282au(cls.asSubclass(bnd.class)).m3289aE(3);
            } catch (Exception e) {
                String valueOf2 = String.valueOf(cls.getName());
                throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
            }
        }
        throw new IllegalStateException("This should never be called.");
    }
}
