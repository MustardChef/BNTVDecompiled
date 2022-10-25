package com.google.ads.interactivemedia.p034v3.api;

import com.google.ads.interactivemedia.p034v3.internal.agl;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose */
/* loaded from: classes2.dex */
public enum FriendlyObstructionPurpose {
    VIDEO_CONTROLS,
    CLOSE_AD,
    NOT_VISIBLE,
    OTHER;

    public agl getOmidPurpose() {
        return (agl) agl.valueOf(agl.class, name());
    }
}
