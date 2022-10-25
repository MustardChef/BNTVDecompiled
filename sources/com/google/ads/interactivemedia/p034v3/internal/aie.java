package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.api.player.AdMediaInfo;
import com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer;
import com.google.ads.interactivemedia.p034v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2506bx;
import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2512cc;
import java.util.HashMap;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aie */
/* loaded from: classes2.dex */
final class aie implements VideoAdPlayer.VideoAdPlayerCallback {

    /* renamed from: b */
    private aid f4127b;

    /* renamed from: c */
    private boolean f4128c = false;

    /* renamed from: a */
    private final HashMap f4126a = axd.m4394r(2);

    /* renamed from: d */
    private final void m5212d(ajp ajpVar, AdMediaInfo adMediaInfo) {
        m5211e(ajpVar, adMediaInfo, null);
    }

    /* renamed from: e */
    private final void m5211e(ajp ajpVar, AdMediaInfo adMediaInfo, Object obj) {
        aid aidVar = this.f4127b;
        if (aidVar != null) {
            aidVar.mo5112b(ajpVar, adMediaInfo, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m5215a(aid aidVar) {
        this.f4127b = aidVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final void m5214b() {
        this.f4128c = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final void m5213c() {
        this.f4128c = false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer.VideoAdPlayerCallback
    public final void onAdProgress(AdMediaInfo adMediaInfo, VideoProgressUpdate videoProgressUpdate) {
        if (this.f4128c && videoProgressUpdate != null && videoProgressUpdate.getDuration() > 0.0f) {
            if (this.f4126a.get(adMediaInfo) == null && videoProgressUpdate.getCurrentTime() > 0.0f) {
                m5212d(ajp.start, adMediaInfo);
                this.f4126a.put(adMediaInfo, true);
            }
            m5211e(ajp.timeupdate, adMediaInfo, AbstractC2506bx.create(videoProgressUpdate));
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer.VideoAdPlayerCallback
    public final void onBuffering(AdMediaInfo adMediaInfo) {
        if (this.f4128c) {
            m5212d(ajp.waiting, adMediaInfo);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer.VideoAdPlayerCallback
    public final void onContentComplete() {
        aid aidVar = this.f4127b;
        if (aidVar != null) {
            aidVar.mo5113a(ajo.adsLoader, ajp.contentComplete);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer.VideoAdPlayerCallback
    public final void onEnded(AdMediaInfo adMediaInfo) {
        if (this.f4128c) {
            m5212d(ajp.end, adMediaInfo);
            this.f4126a.remove(adMediaInfo);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer.VideoAdPlayerCallback
    public final void onError(AdMediaInfo adMediaInfo) {
        if (this.f4128c) {
            m5212d(ajp.error, adMediaInfo);
            this.f4126a.remove(adMediaInfo);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer.VideoAdPlayerCallback
    public final void onLoaded(AdMediaInfo adMediaInfo) {
        if (this.f4128c) {
            m5212d(ajp.loaded, adMediaInfo);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer.VideoAdPlayerCallback
    public final void onPause(AdMediaInfo adMediaInfo) {
        if (this.f4128c) {
            m5212d(ajp.pause, adMediaInfo);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer.VideoAdPlayerCallback
    public final void onPlay(AdMediaInfo adMediaInfo) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer.VideoAdPlayerCallback
    public final void onResume(AdMediaInfo adMediaInfo) {
        if (this.f4128c) {
            m5212d(ajp.play, adMediaInfo);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer.VideoAdPlayerCallback
    public final void onVolumeChanged(AdMediaInfo adMediaInfo, int i) {
        if (this.f4128c) {
            m5211e(ajp.volumeChange, adMediaInfo, AbstractC2512cc.builder().volumePercentage(i).build());
        }
    }
}
