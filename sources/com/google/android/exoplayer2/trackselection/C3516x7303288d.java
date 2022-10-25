package com.google.android.exoplayer2.trackselection;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.trackselection.-$$Lambda$DefaultTrackSelector$Parameters$U98Wdd2EwvvSUOXBjakY0Uxo3EE */
/* loaded from: classes2.dex */
public final /* synthetic */ class C3516x7303288d implements Bundleable.Creator {
    public static final /* synthetic */ C3516x7303288d INSTANCE = new C3516x7303288d();

    private /* synthetic */ C3516x7303288d() {
    }

    @Override // com.google.android.exoplayer2.Bundleable.Creator
    public final Bundleable fromBundle(Bundle bundle) {
        DefaultTrackSelector.Parameters build;
        build = new DefaultTrackSelector.ParametersBuilder(bundle).build();
        return build;
    }
}
