package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.-$$Lambda$n6AEZlPe6KFdrCRlRyWNkQZFDPQ  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$n6AEZlPe6KFdrCRlRyWNkQZFDPQ implements Bundleable.Creator {
    public static final /* synthetic */ $$Lambda$n6AEZlPe6KFdrCRlRyWNkQZFDPQ INSTANCE = new $$Lambda$n6AEZlPe6KFdrCRlRyWNkQZFDPQ();

    private /* synthetic */ $$Lambda$n6AEZlPe6KFdrCRlRyWNkQZFDPQ() {
    }

    @Override // com.google.android.exoplayer2.Bundleable.Creator
    public final Bundleable fromBundle(Bundle bundle) {
        return new PlaybackException(bundle);
    }
}
