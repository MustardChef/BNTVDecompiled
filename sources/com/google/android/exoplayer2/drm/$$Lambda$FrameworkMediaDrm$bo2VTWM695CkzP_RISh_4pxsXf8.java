package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.ExoMediaDrm;
import java.util.UUID;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.drm.-$$Lambda$FrameworkMediaDrm$bo2VTWM695CkzP_RISh_4pxsXf8  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$FrameworkMediaDrm$bo2VTWM695CkzP_RISh_4pxsXf8 implements ExoMediaDrm.Provider {
    public static final /* synthetic */ $$Lambda$FrameworkMediaDrm$bo2VTWM695CkzP_RISh_4pxsXf8 INSTANCE = new $$Lambda$FrameworkMediaDrm$bo2VTWM695CkzP_RISh_4pxsXf8();

    private /* synthetic */ $$Lambda$FrameworkMediaDrm$bo2VTWM695CkzP_RISh_4pxsXf8() {
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm.Provider
    public final ExoMediaDrm acquireExoMediaDrm(UUID uuid) {
        return FrameworkMediaDrm.lambda$static$0(uuid);
    }
}
