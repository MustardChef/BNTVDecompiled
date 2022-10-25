package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.xm */
/* loaded from: classes2.dex */
public final class C3191xm implements DisplayManager.DisplayListener, InterfaceC3189xk {

    /* renamed from: a */
    private final DisplayManager f9410a;

    /* renamed from: b */
    private C3187xi f9411b;

    private C3191xm(DisplayManager displayManager) {
        this.f9410a = displayManager;
    }

    /* renamed from: c */
    public static InterfaceC3189xk m615c(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager != null) {
            return new C3191xm(displayManager);
        }
        return null;
    }

    /* renamed from: d */
    private final Display m614d() {
        return this.f9410a.getDisplay(0);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3189xk
    /* renamed from: a */
    public final void mo617a() {
        this.f9410a.unregisterDisplayListener(this);
        this.f9411b = null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3189xk
    /* renamed from: b */
    public final void mo616b(C3187xi c3187xi) {
        this.f9411b = c3187xi;
        this.f9410a.registerDisplayListener(this, C2628cq.m2508z());
        c3187xi.m620a(m614d());
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i) {
        C3187xi c3187xi = this.f9411b;
        if (c3187xi == null || i != 0) {
            return;
        }
        c3187xi.m620a(m614d());
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i) {
    }
}
