package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.common.base.Predicate;
import java.util.Map;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.upstream.-$$Lambda$DefaultHttpDataSource$NullFilteringHeadersMap$DVYd1RNlWDfio80CnK0S49qNCjc */
/* loaded from: classes2.dex */
public final /* synthetic */ class C3579xa6a940e1 implements Predicate {
    public static final /* synthetic */ C3579xa6a940e1 INSTANCE = new C3579xa6a940e1();

    private /* synthetic */ C3579xa6a940e1() {
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        return DefaultHttpDataSource.NullFilteringHeadersMap.lambda$entrySet$1((Map.Entry) obj);
    }
}
