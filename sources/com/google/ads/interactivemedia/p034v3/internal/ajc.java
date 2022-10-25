package com.google.ads.interactivemedia.p034v3.internal;

import android.view.ViewGroup;
import com.google.ads.interactivemedia.p034v3.api.CompanionAdSlot;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ajc */
/* loaded from: classes2.dex */
public final class ajc implements CompanionAdSlot {

    /* renamed from: a */
    private int f4215a;

    /* renamed from: b */
    private int f4216b;

    /* renamed from: c */
    private ViewGroup f4217c;

    /* renamed from: d */
    private String f4218d;

    /* renamed from: e */
    private final List f4219e = new ArrayList(1);

    /* renamed from: a */
    public final List m5169a() {
        return this.f4219e;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.CompanionAdSlot
    public final void addClickListener(CompanionAdSlot.ClickListener clickListener) {
        this.f4219e.add(clickListener);
    }

    /* renamed from: b */
    public final void m5168b(String str) {
        this.f4218d = str;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.CompanionAdSlot
    public final ViewGroup getContainer() {
        return this.f4217c;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.CompanionAdSlot
    public final int getHeight() {
        return this.f4216b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.CompanionAdSlot
    public final int getWidth() {
        return this.f4215a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.CompanionAdSlot
    public final boolean isFilled() {
        return this.f4217c.findViewWithTag(this.f4218d) != null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.CompanionAdSlot
    public final void removeClickListener(CompanionAdSlot.ClickListener clickListener) {
        this.f4219e.remove(clickListener);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.CompanionAdSlot
    public final void setContainer(ViewGroup viewGroup) {
        this.f4217c = viewGroup;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.CompanionAdSlot
    public final void setSize(int i, int i2) {
        this.f4215a = i;
        this.f4216b = i2;
    }
}
