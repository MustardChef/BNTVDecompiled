package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.p034v3.internal.ate;

/* compiled from: IMASDK */
@ate(m4626a = C2474as.class)
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.bx */
/* loaded from: classes2.dex */
public abstract class AbstractC2506bx {
    private static final String DEFAULT_TIME_UNIT = "ms";

    public static AbstractC2506bx create(VideoProgressUpdate videoProgressUpdate) {
        return new C2474as(videoProgressUpdate.getCurrentTimeMs(), videoProgressUpdate.getDurationMs(), DEFAULT_TIME_UNIT);
    }

    public abstract long currentTime();

    public abstract long duration();

    public abstract String timeUnit();
}
