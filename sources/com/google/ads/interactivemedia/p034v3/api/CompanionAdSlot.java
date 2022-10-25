package com.google.ads.interactivemedia.p034v3.api;

import android.view.ViewGroup;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.api.CompanionAdSlot */
/* loaded from: classes2.dex */
public interface CompanionAdSlot {

    /* compiled from: IMASDK */
    /* renamed from: com.google.ads.interactivemedia.v3.api.CompanionAdSlot$ClickListener */
    /* loaded from: classes2.dex */
    public interface ClickListener {
        void onCompanionAdClick();
    }

    void addClickListener(ClickListener clickListener);

    ViewGroup getContainer();

    int getHeight();

    int getWidth();

    boolean isFilled();

    void removeClickListener(ClickListener clickListener);

    void setContainer(ViewGroup viewGroup);

    void setSize(int i, int i2);
}
