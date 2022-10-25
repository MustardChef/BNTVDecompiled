package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.internal.ate;

/* compiled from: IMASDK */
@ate(m4626a = C2469an.class)
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.ResizeAndPositionVideoMsgData */
/* loaded from: classes2.dex */
public abstract class ResizeAndPositionVideoMsgData {
    public static ResizeAndPositionVideoMsgData create(Integer num, Integer num2, Integer num3, Integer num4) {
        return new C2469an(num, num2, num3, num4);
    }

    public abstract Integer height();

    public final String toString() {
        String valueOf = String.valueOf(mo6010x());
        String valueOf2 = String.valueOf(mo6009y());
        String valueOf3 = String.valueOf(width());
        String valueOf4 = String.valueOf(height());
        int length = String.valueOf(valueOf).length();
        int length2 = String.valueOf(valueOf2).length();
        StringBuilder sb = new StringBuilder(length + 55 + length2 + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("ResizeAndPositionVideoMsgData [x=");
        sb.append(valueOf);
        sb.append(", y=");
        sb.append(valueOf2);
        sb.append(", width=");
        sb.append(valueOf3);
        sb.append(", height=");
        sb.append(valueOf4);
        sb.append("]");
        return sb.toString();
    }

    public abstract Integer width();

    /* renamed from: x */
    public abstract Integer mo6010x();

    /* renamed from: y */
    public abstract Integer mo6009y();
}
