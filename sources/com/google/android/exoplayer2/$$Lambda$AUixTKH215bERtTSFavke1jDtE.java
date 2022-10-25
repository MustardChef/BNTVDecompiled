package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.-$$Lambda$AUi-xTKH215bERtTSFavke1jDtE  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$AUixTKH215bERtTSFavke1jDtE implements ListenerSet.Event {
    public static final /* synthetic */ $$Lambda$AUixTKH215bERtTSFavke1jDtE INSTANCE = new $$Lambda$AUixTKH215bERtTSFavke1jDtE();

    private /* synthetic */ $$Lambda$AUixTKH215bERtTSFavke1jDtE() {
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public final void invoke(Object obj) {
        ((Player.EventListener) obj).onSeekProcessed();
    }
}
