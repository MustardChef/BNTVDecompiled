package com.lagradost.cloudstream3.p041ui.player;

import com.bongngotv2.R;
import kotlin.Metadata;

/* compiled from: AbstractPlayerFragment.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/PlayerResize;", "", "nameRes", "", "(Ljava/lang/String;II)V", "getNameRes", "()I", "Fit", "Fill", "Zoom", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.PlayerResize */
/* loaded from: classes3.dex */
public enum PlayerResize {
    Fit(R.string.resize_fit),
    Fill(R.string.resize_fill),
    Zoom(R.string.resize_zoom);
    
    private final int nameRes;

    PlayerResize(int i) {
        this.nameRes = i;
    }

    public final int getNameRes() {
        return this.nameRes;
    }
}
