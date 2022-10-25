package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.analytics.-$$Lambda$AnalyticsCollector$fI7_k5bnH4sXLiJdPiak7lV4xU8  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$AnalyticsCollector$fI7_k5bnH4sXLiJdPiak7lV4xU8 implements ListenerSet.IterationFinishedEvent {
    public static final /* synthetic */ $$Lambda$AnalyticsCollector$fI7_k5bnH4sXLiJdPiak7lV4xU8 INSTANCE = new $$Lambda$AnalyticsCollector$fI7_k5bnH4sXLiJdPiak7lV4xU8();

    private /* synthetic */ $$Lambda$AnalyticsCollector$fI7_k5bnH4sXLiJdPiak7lV4xU8() {
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.IterationFinishedEvent
    public final void invoke(Object obj, FlagSet flagSet) {
        AnalyticsCollector.lambda$new$0((AnalyticsListener) obj, flagSet);
    }
}
