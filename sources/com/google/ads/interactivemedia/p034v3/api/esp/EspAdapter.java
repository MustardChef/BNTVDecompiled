package com.google.ads.interactivemedia.p034v3.api.esp;

import android.content.Context;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.api.esp.EspAdapter */
/* loaded from: classes2.dex */
public interface EspAdapter {
    void collectSignals(Context context, EspCollectSignalsCallback espCollectSignalsCallback);

    VersionInfo getSDKVersionInfo();

    VersionInfo getVersionInfo();

    void initialize(Context context, EspInitializeCallback espInitializeCallback);
}
