package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bob */
/* loaded from: classes2.dex */
final class bob implements boh {

    /* renamed from: a */
    private final boh[] f6307a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bob(boh... bohVarArr) {
        this.f6307a = bohVarArr;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boh
    /* renamed from: a */
    public final bog mo3182a(Class cls) {
        boh[] bohVarArr = this.f6307a;
        for (int i = 0; i < 2; i++) {
            boh bohVar = bohVarArr[i];
            if (bohVar.mo3181b(cls)) {
                return bohVar.mo3182a(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boh
    /* renamed from: b */
    public final boolean mo3181b(Class cls) {
        boh[] bohVarArr = this.f6307a;
        for (int i = 0; i < 2; i++) {
            if (bohVarArr[i].mo3181b(cls)) {
                return true;
            }
        }
        return false;
    }
}
