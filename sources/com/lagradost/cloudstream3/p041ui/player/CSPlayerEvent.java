package com.lagradost.cloudstream3.p041ui.player;

import kotlin.Metadata;

/* compiled from: IPlayer.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/CSPlayerEvent;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Pause", "Play", "SeekForward", "SeekBack", "NextEpisode", "PrevEpisode", "PlayPauseToggle", "ToggleMute", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.CSPlayerEvent */
/* loaded from: classes3.dex */
public enum CSPlayerEvent {
    Pause(0),
    Play(1),
    SeekForward(2),
    SeekBack(3),
    NextEpisode(5),
    PrevEpisode(6),
    PlayPauseToggle(7),
    ToggleMute(8);
    
    private final int value;

    CSPlayerEvent(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
