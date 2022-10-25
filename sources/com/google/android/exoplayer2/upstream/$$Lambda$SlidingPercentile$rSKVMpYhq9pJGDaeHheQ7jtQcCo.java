package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.SlidingPercentile;
import java.util.Comparator;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.upstream.-$$Lambda$SlidingPercentile$rSKVMpYhq9pJGDaeHheQ7jtQcCo  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$SlidingPercentile$rSKVMpYhq9pJGDaeHheQ7jtQcCo implements Comparator {
    public static final /* synthetic */ $$Lambda$SlidingPercentile$rSKVMpYhq9pJGDaeHheQ7jtQcCo INSTANCE = new $$Lambda$SlidingPercentile$rSKVMpYhq9pJGDaeHheQ7jtQcCo();

    private /* synthetic */ $$Lambda$SlidingPercentile$rSKVMpYhq9pJGDaeHheQ7jtQcCo() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return SlidingPercentile.lambda$static$0((SlidingPercentile.Sample) obj, (SlidingPercentile.Sample) obj2);
    }
}
