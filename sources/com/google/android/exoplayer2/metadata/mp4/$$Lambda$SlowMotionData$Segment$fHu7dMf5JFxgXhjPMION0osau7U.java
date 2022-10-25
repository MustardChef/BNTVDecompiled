package com.google.android.exoplayer2.metadata.mp4;

import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.common.collect.ComparisonChain;
import java.util.Comparator;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.metadata.mp4.-$$Lambda$SlowMotionData$Segment$fHu7dMf5JFxgXhjPMION0osau7U  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$SlowMotionData$Segment$fHu7dMf5JFxgXhjPMION0osau7U implements Comparator {
    public static final /* synthetic */ $$Lambda$SlowMotionData$Segment$fHu7dMf5JFxgXhjPMION0osau7U INSTANCE = new $$Lambda$SlowMotionData$Segment$fHu7dMf5JFxgXhjPMION0osau7U();

    private /* synthetic */ $$Lambda$SlowMotionData$Segment$fHu7dMf5JFxgXhjPMION0osau7U() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int result;
        result = ComparisonChain.start().compare(r1.startTimeMs, r2.startTimeMs).compare(r1.endTimeMs, r2.endTimeMs).compare(((SlowMotionData.Segment) obj).speedDivisor, ((SlowMotionData.Segment) obj2).speedDivisor).result();
        return result;
    }
}
