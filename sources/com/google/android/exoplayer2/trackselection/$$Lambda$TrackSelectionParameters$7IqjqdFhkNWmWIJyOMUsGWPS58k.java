package com.google.android.exoplayer2.trackselection;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.trackselection.-$$Lambda$TrackSelectionParameters$7IqjqdFhkNWmWIJyOMUsGWPS58k  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$TrackSelectionParameters$7IqjqdFhkNWmWIJyOMUsGWPS58k implements Bundleable.Creator {
    public static final /* synthetic */ $$Lambda$TrackSelectionParameters$7IqjqdFhkNWmWIJyOMUsGWPS58k INSTANCE = new $$Lambda$TrackSelectionParameters$7IqjqdFhkNWmWIJyOMUsGWPS58k();

    private /* synthetic */ $$Lambda$TrackSelectionParameters$7IqjqdFhkNWmWIJyOMUsGWPS58k() {
    }

    @Override // com.google.android.exoplayer2.Bundleable.Creator
    public final Bundleable fromBundle(Bundle bundle) {
        TrackSelectionParameters build;
        build = new TrackSelectionParameters.Builder(bundle).build();
        return build;
    }
}
