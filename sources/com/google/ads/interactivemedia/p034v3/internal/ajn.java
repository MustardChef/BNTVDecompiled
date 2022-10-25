package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.api.CompanionAdSlot;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ajn */
/* loaded from: classes2.dex */
final class ajn implements bgs {
    @Override // com.google.ads.interactivemedia.p034v3.internal.bgs
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ bgm mo3702a(Object obj) {
        CompanionAdSlot companionAdSlot = (CompanionAdSlot) obj;
        int width = companionAdSlot.getWidth();
        int height = companionAdSlot.getHeight();
        StringBuilder sb = new StringBuilder(23);
        sb.append(width);
        sb.append("x");
        sb.append(height);
        return new bgr(sb.toString());
    }
}
