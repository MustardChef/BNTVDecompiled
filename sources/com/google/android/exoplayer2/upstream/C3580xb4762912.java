package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.common.base.Predicate;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.upstream.-$$Lambda$DefaultHttpDataSource$NullFilteringHeadersMap$KEnQ8YaC9x7448-o-c4v_duvcOo */
/* loaded from: classes2.dex */
public final /* synthetic */ class C3580xb4762912 implements Predicate {
    public static final /* synthetic */ C3580xb4762912 INSTANCE = new C3580xb4762912();

    private /* synthetic */ C3580xb4762912() {
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        return DefaultHttpDataSource.NullFilteringHeadersMap.lambda$keySet$0((String) obj);
    }
}
