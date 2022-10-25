package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.SlidingPercentile;
import java.util.Comparator;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.upstream.-$$Lambda$SlidingPercentile$kHXYHfok8QC8DQsYRzQ_7PvLqTo  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$SlidingPercentile$kHXYHfok8QC8DQsYRzQ_7PvLqTo implements Comparator {
    public static final /* synthetic */ $$Lambda$SlidingPercentile$kHXYHfok8QC8DQsYRzQ_7PvLqTo INSTANCE = new $$Lambda$SlidingPercentile$kHXYHfok8QC8DQsYRzQ_7PvLqTo();

    private /* synthetic */ $$Lambda$SlidingPercentile$kHXYHfok8QC8DQsYRzQ_7PvLqTo() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int compare;
        compare = Float.compare(((SlidingPercentile.Sample) obj).value, ((SlidingPercentile.Sample) obj2).value);
        return compare;
    }
}
