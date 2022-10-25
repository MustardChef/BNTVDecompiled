package com.google.android.exoplayer2.analytics;

import com.google.common.base.Supplier;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.analytics.-$$Lambda$DefaultPlaybackSessionManager$vmk78wQ9svbZ0HpAtbMXEpmt6SE */
/* loaded from: classes2.dex */
public final /* synthetic */ class C3299xa5dbaaae implements Supplier {
    public static final /* synthetic */ C3299xa5dbaaae INSTANCE = new C3299xa5dbaaae();

    private /* synthetic */ C3299xa5dbaaae() {
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        String generateDefaultSessionId;
        generateDefaultSessionId = DefaultPlaybackSessionManager.generateDefaultSessionId();
        return generateDefaultSessionId;
    }
}
