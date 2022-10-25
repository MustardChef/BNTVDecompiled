package com.google.android.gms.common.api.internal;

import android.os.Handler;
import com.google.android.gms.common.api.internal.BackgroundDetector;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
final class zabg implements BackgroundDetector.BackgroundStateChangeListener {
    final /* synthetic */ GoogleApiManager zaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zabg(GoogleApiManager googleApiManager) {
        this.zaa = googleApiManager;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void onBackgroundStateChanged(boolean z) {
        Handler handler;
        Handler handler2;
        handler = this.zaa.zat;
        handler2 = this.zaa.zat;
        handler.sendMessage(handler2.obtainMessage(1, Boolean.valueOf(z)));
    }
}
