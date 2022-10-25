package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.-$$Lambda$ExoPlayerImpl$eZVQ1P4AuRBXX3IBVzj-JmjEs8k  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$ExoPlayerImpl$eZVQ1P4AuRBXX3IBVzjJmjEs8k implements ListenerSet.Event {
    public static final /* synthetic */ $$Lambda$ExoPlayerImpl$eZVQ1P4AuRBXX3IBVzjJmjEs8k INSTANCE = new $$Lambda$ExoPlayerImpl$eZVQ1P4AuRBXX3IBVzjJmjEs8k();

    private /* synthetic */ $$Lambda$ExoPlayerImpl$eZVQ1P4AuRBXX3IBVzjJmjEs8k() {
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public final void invoke(Object obj) {
        ((Player.EventListener) obj).onPlayerError(ExoPlaybackException.createForUnexpected(new ExoTimeoutException(1), 1003));
    }
}
