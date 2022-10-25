package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.view.WindowManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.xl */
/* loaded from: classes2.dex */
public final class C3190xl implements InterfaceC3189xk {

    /* renamed from: a */
    private final WindowManager f9409a;

    private C3190xl(WindowManager windowManager) {
        this.f9409a = windowManager;
    }

    /* renamed from: c */
    public static InterfaceC3189xk m618c(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            return new C3190xl(windowManager);
        }
        return null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3189xk
    /* renamed from: a */
    public final void mo617a() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3189xk
    /* renamed from: b */
    public final void mo616b(C3187xi c3187xi) {
        c3187xi.m620a(this.f9409a.getDefaultDisplay());
    }
}
