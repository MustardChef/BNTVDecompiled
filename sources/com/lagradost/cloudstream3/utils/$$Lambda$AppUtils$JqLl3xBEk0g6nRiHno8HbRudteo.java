package com.lagradost.cloudstream3.utils;

import android.media.AudioManager;

/* compiled from: lambda */
/* renamed from: com.lagradost.cloudstream3.utils.-$$Lambda$AppUtils$JqLl3xBEk0g6nRiHno8HbRudteo  reason: invalid class name */
/* loaded from: classes4.dex */
public final /* synthetic */ class $$Lambda$AppUtils$JqLl3xBEk0g6nRiHno8HbRudteo implements AudioManager.OnAudioFocusChangeListener {
    public static final /* synthetic */ $$Lambda$AppUtils$JqLl3xBEk0g6nRiHno8HbRudteo INSTANCE = new $$Lambda$AppUtils$JqLl3xBEk0g6nRiHno8HbRudteo();

    private /* synthetic */ $$Lambda$AppUtils$JqLl3xBEk0g6nRiHno8HbRudteo() {
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        AppUtils.m8990getAudioListener$lambda5(i);
    }
}
