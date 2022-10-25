package com.google.android.exoplayer2.upstream.cache;

import java.util.Comparator;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.upstream.cache.-$$Lambda$LeastRecentlyUsedCacheEvictor$fGGQpb4lm4rCLKn4-zylNcQiqeo */
/* loaded from: classes2.dex */
public final /* synthetic */ class C3587x250fcd60 implements Comparator {
    public static final /* synthetic */ C3587x250fcd60 INSTANCE = new C3587x250fcd60();

    private /* synthetic */ C3587x250fcd60() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int compare;
        compare = LeastRecentlyUsedCacheEvictor.compare((CacheSpan) obj, (CacheSpan) obj2);
        return compare;
    }
}
