package com.google.ads.interactivemedia.p034v3.internal;

import java.io.File;
import java.security.GeneralSecurityException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.amq */
/* loaded from: classes2.dex */
final class amq implements InterfaceC2563ast {

    /* renamed from: a */
    final /* synthetic */ ari f4639a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public amq(ari ariVar) {
        this.f4639a = ariVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2563ast
    /* renamed from: a */
    public final boolean mo4661a(File file) {
        try {
            return this.f4639a.m4735a(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
