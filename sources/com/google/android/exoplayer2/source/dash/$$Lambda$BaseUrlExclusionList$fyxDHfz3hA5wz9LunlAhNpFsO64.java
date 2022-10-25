package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.source.dash.manifest.BaseUrl;
import java.util.Comparator;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.source.dash.-$$Lambda$BaseUrlExclusionList$fyxDHfz3hA5wz9LunlAhNpFsO64  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$BaseUrlExclusionList$fyxDHfz3hA5wz9LunlAhNpFsO64 implements Comparator {
    public static final /* synthetic */ $$Lambda$BaseUrlExclusionList$fyxDHfz3hA5wz9LunlAhNpFsO64 INSTANCE = new $$Lambda$BaseUrlExclusionList$fyxDHfz3hA5wz9LunlAhNpFsO64();

    private /* synthetic */ $$Lambda$BaseUrlExclusionList$fyxDHfz3hA5wz9LunlAhNpFsO64() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int compareBaseUrl;
        compareBaseUrl = BaseUrlExclusionList.compareBaseUrl((BaseUrl) obj, (BaseUrl) obj2);
        return compareBaseUrl;
    }
}
