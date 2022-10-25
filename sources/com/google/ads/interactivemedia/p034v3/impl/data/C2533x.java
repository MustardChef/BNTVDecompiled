package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.api.BaseDisplayContainer;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.x */
/* loaded from: classes2.dex */
public final /* synthetic */ class C2533x {
    /* renamed from: a */
    public static boolean m5986a(BaseDisplayContainer baseDisplayContainer, ResizeAndPositionVideoMsgData resizeAndPositionVideoMsgData) {
        return resizeAndPositionVideoMsgData.mo6010x().intValue() >= 0 && resizeAndPositionVideoMsgData.width().intValue() >= 0 && resizeAndPositionVideoMsgData.mo6010x().intValue() + resizeAndPositionVideoMsgData.width().intValue() <= baseDisplayContainer.getAdContainer().getWidth() && resizeAndPositionVideoMsgData.mo6009y().intValue() >= 0 && resizeAndPositionVideoMsgData.height().intValue() >= 0 && resizeAndPositionVideoMsgData.mo6009y().intValue() + resizeAndPositionVideoMsgData.height().intValue() <= baseDisplayContainer.getAdContainer().getHeight();
    }
}
