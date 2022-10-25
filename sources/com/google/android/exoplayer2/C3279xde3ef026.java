package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.MediaItem;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.-$$Lambda$MediaItem$ClippingConfiguration$4pyVj5Cp-fNpq6xhvLCIEAFTHF8 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C3279xde3ef026 implements Bundleable.Creator {
    public static final /* synthetic */ C3279xde3ef026 INSTANCE = new C3279xde3ef026();

    private /* synthetic */ C3279xde3ef026() {
    }

    @Override // com.google.android.exoplayer2.Bundleable.Creator
    public final Bundleable fromBundle(Bundle bundle) {
        MediaItem.ClippingProperties buildClippingProperties;
        buildClippingProperties = new MediaItem.ClippingConfiguration.Builder().setStartPositionMs(bundle.getLong(MediaItem.ClippingConfiguration.keyForField(0), 0L)).setEndPositionMs(bundle.getLong(MediaItem.ClippingConfiguration.keyForField(1), Long.MIN_VALUE)).setRelativeToLiveWindow(bundle.getBoolean(MediaItem.ClippingConfiguration.keyForField(2), false)).setRelativeToDefaultPosition(bundle.getBoolean(MediaItem.ClippingConfiguration.keyForField(3), false)).setStartsAtKeyFrame(bundle.getBoolean(MediaItem.ClippingConfiguration.keyForField(4), false)).buildClippingProperties();
        return buildClippingProperties;
    }
}
