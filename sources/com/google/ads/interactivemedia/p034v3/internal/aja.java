package com.google.ads.interactivemedia.p034v3.internal;

import android.view.View;
import android.view.ViewGroup;
import com.google.ads.interactivemedia.p034v3.api.BaseDisplayContainer;
import com.google.ads.interactivemedia.p034v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.p034v3.api.FriendlyObstruction;
import com.google.ads.interactivemedia.p034v3.api.FriendlyObstructionPurpose;
import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2487be;
import com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2486bd;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aja */
/* loaded from: classes2.dex */
public class aja implements BaseDisplayContainer {

    /* renamed from: a */
    private static int f4194a;

    /* renamed from: b */
    private ViewGroup f4195b;

    /* renamed from: c */
    private Collection f4196c = avg.m4515n();

    /* renamed from: d */
    private Map f4197d = avs.m4480n();

    /* renamed from: e */
    private final Set f4198e = new HashSet();

    /* renamed from: f */
    private aiz f4199f = null;

    /* renamed from: g */
    private boolean f4200g = false;

    public aja(ViewGroup viewGroup) {
        this.f4195b = viewGroup;
    }

    /* renamed from: a */
    public final Map m5180a() {
        return this.f4197d;
    }

    /* renamed from: b */
    public final Set m5179b() {
        return new HashSet(this.f4198e);
    }

    /* renamed from: c */
    public final void m5178c(aiz aizVar) {
        this.f4199f = aizVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.BaseDisplayContainer
    public final void claim() {
        atm.m4617e(!this.f4200g, "A given DisplayContainer may only be used once");
        this.f4200g = true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.BaseDisplayContainer
    public final void destroy() {
        ViewGroup viewGroup = this.f4195b;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.BaseDisplayContainer
    public final ViewGroup getAdContainer() {
        return this.f4195b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.BaseDisplayContainer
    public final Collection<CompanionAdSlot> getCompanionSlots() {
        return this.f4196c;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.BaseDisplayContainer
    public final void registerFriendlyObstruction(FriendlyObstruction friendlyObstruction) {
        if (friendlyObstruction == null || this.f4198e.contains(friendlyObstruction)) {
            return;
        }
        this.f4198e.add(friendlyObstruction);
        aiz aizVar = this.f4199f;
        if (aizVar != null) {
            ((akm) aizVar).m5103c(friendlyObstruction);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.BaseDisplayContainer
    public final void registerVideoControlsOverlay(View view) {
        if (view == null) {
            return;
        }
        InterfaceC2486bd builder = AbstractC2487be.builder();
        builder.view(view);
        builder.purpose(FriendlyObstructionPurpose.VIDEO_CONTROLS);
        AbstractC2487be build = builder.build();
        if (this.f4198e.contains(build)) {
            return;
        }
        this.f4198e.add(build);
        aiz aizVar = this.f4199f;
        if (aizVar != null) {
            ((akm) aizVar).m5103c(build);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.BaseDisplayContainer
    public final void setAdContainer(ViewGroup viewGroup) {
        atm.m4612j(viewGroup);
        this.f4195b = viewGroup;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.BaseDisplayContainer
    public final void setCompanionSlots(Collection<CompanionAdSlot> collection) {
        if (collection == null) {
            collection = avg.m4515n();
        }
        avh avhVar = new avh();
        for (CompanionAdSlot companionAdSlot : collection) {
            if (companionAdSlot != null) {
                int i = f4194a;
                f4194a = i + 1;
                StringBuilder sb = new StringBuilder(20);
                sb.append("compSlot_");
                sb.append(i);
                avhVar.mo4491a(sb.toString(), companionAdSlot);
            }
        }
        this.f4197d = avhVar.mo4489c();
        this.f4196c = collection;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.BaseDisplayContainer
    public final void unregisterAllFriendlyObstructions() {
        this.f4198e.clear();
        aiz aizVar = this.f4199f;
        if (aizVar != null) {
            ((akm) aizVar).m5099g();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.BaseDisplayContainer
    public final void unregisterAllVideoControlsOverlays() {
        this.f4198e.clear();
        aiz aizVar = this.f4199f;
        if (aizVar != null) {
            ((akm) aizVar).m5099g();
        }
    }
}
