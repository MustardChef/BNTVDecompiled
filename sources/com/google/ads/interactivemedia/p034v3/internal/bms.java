package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bms */
/* loaded from: classes2.dex */
final class bms {

    /* renamed from: a */
    private static final bnv f6177a = new bnv((byte[]) null);

    /* renamed from: b */
    private static final bnv f6178b;

    static {
        bnv bnvVar = null;
        try {
            bnvVar = (bnv) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
        }
        f6178b = bnvVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static bnv m3339a() {
        bnv bnvVar = f6178b;
        if (bnvVar != null) {
            return bnvVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static bnv m3338b() {
        return f6177a;
    }
}
