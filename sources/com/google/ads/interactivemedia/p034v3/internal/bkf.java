package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.Field;
import java.security.PrivilegedAction;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bkf */
/* loaded from: classes2.dex */
final class bkf implements PrivilegedAction {

    /* renamed from: a */
    final /* synthetic */ Field f5890a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bkf(Field field) {
        this.f5890a = field;
    }

    @Override // java.security.PrivilegedAction
    public final /* bridge */ /* synthetic */ Object run() {
        this.f5890a.setAccessible(true);
        return null;
    }
}
