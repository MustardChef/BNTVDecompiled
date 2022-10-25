package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import com.google.ads.interactivemedia.p034v3.api.AdError;
import com.google.ads.interactivemedia.p034v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.p034v3.api.player.ResizablePlayer;
import com.google.ads.interactivemedia.p034v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.p034v3.api.player.VideoStreamPlayer;
import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2506bx;
import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2512cc;
import com.google.ads.interactivemedia.p034v3.impl.data.C2464ai;
import com.google.ads.interactivemedia.p034v3.impl.data.C2496bn;
import com.google.ads.interactivemedia.p034v3.impl.data.C2509c;
import com.google.ads.interactivemedia.p034v3.impl.data.C2525p;
import com.google.ads.interactivemedia.p034v3.impl.data.C2533x;
import com.google.ads.interactivemedia.p034v3.impl.data.ResizeAndPositionVideoMsgData;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aku */
/* loaded from: classes2.dex */
public final class aku implements VideoStreamPlayer.VideoStreamPlayerCallback, akv, ako {

    /* renamed from: a */
    private final VideoStreamPlayer f4335a;

    /* renamed from: b */
    private final ajx f4336b;

    /* renamed from: c */
    private final aji f4337c;

    /* renamed from: d */
    private boolean f4338d;

    /* renamed from: e */
    private final akw f4339e;

    /* renamed from: f */
    private final String f4340f;

    /* renamed from: g */
    private final String f4341g;

    /* renamed from: h */
    private final StreamDisplayContainer f4342h;

    /* renamed from: i */
    private final akp f4343i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aku(String str, ajx ajxVar, aji ajiVar, StreamDisplayContainer streamDisplayContainer, String str2) {
        akp akpVar = new akp(streamDisplayContainer.getVideoStreamPlayer());
        akw akwVar = new akw(ajxVar.m5144a(), streamDisplayContainer.getAdContainer());
        this.f4338d = false;
        this.f4335a = streamDisplayContainer.getVideoStreamPlayer();
        this.f4337c = ajiVar;
        this.f4340f = str;
        this.f4336b = ajxVar;
        this.f4341g = str2;
        this.f4338d = false;
        this.f4342h = streamDisplayContainer;
        this.f4343i = akpVar;
        this.f4339e = akwVar;
    }

    /* renamed from: o */
    private final void m5068o(ajp ajpVar, Object obj) {
        this.f4336b.mo5122o(new ajq(ajo.videoDisplay1, ajpVar, this.f4340f, obj));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ako
    /* renamed from: a */
    public final void mo5077a(VideoProgressUpdate videoProgressUpdate) {
        if (!this.f4338d) {
            m5068o(ajp.start, AbstractC2512cc.builder().volumePercentage(this.f4335a.getVolume()).build());
            this.f4338d = true;
        }
        m5068o(ajp.timeupdate, AbstractC2506bx.create(videoProgressUpdate));
    }

    /* renamed from: b */
    public final void m5076b() {
        this.f4335a.onAdBreakEnded();
        m5069n();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.akv
    /* renamed from: c */
    public final void mo5067c() {
        C2525p.m5989c("Destroying StreamVideoDisplay");
        this.f4335a.removeCallback(this);
        this.f4343i.m5091e();
        this.f4343i.m5093c(this);
        this.f4339e.m5062a();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.akv
    /* renamed from: d */
    public final void mo5066d() {
        this.f4343i.m5094b(this);
        this.f4343i.m5092d();
    }

    /* renamed from: e */
    public final void m5075e() {
        this.f4335a.onAdBreakStarted();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.akv
    /* renamed from: f */
    public final void mo5065f(ajo ajoVar, ajp ajpVar, C2496bn c2496bn) {
        String str;
        ajp ajpVar2 = ajp.activate;
        int ordinal = ajpVar.ordinal();
        if (ordinal != 45) {
            if (ordinal == 52) {
                this.f4335a.pause();
            } else if (ordinal == 53) {
                this.f4335a.resume();
            }
        } else if (c2496bn == null || (str = c2496bn.streamUrl) == null) {
            this.f4337c.m5165c(new aib(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Load message must contain video url.")));
        } else {
            int i = 0;
            this.f4338d = false;
            String str2 = this.f4341g;
            if (str2 != null && str2.length() != 0) {
                String str3 = "";
                String replaceAll = this.f4341g.trim().replaceAll("\\s+", "");
                if (replaceAll.charAt(0) == '?') {
                    replaceAll = replaceAll.substring(1);
                }
                if (replaceAll.length() != 0) {
                    Map m6017a = C2464ai.m6017a(Uri.parse(str));
                    HashMap hashMap = new HashMap();
                    Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                    buildUpon.clearQuery();
                    String valueOf = String.valueOf(replaceAll);
                    Map m6017a2 = C2464ai.m6017a(Uri.parse(valueOf.length() != 0 ? "http://www.dom.com/path?".concat(valueOf) : new String("http://www.dom.com/path?")));
                    hashMap.putAll(m6017a2);
                    if (!m6017a.isEmpty()) {
                        for (String str4 : m6017a.keySet()) {
                            if (!m6017a2.containsKey(str4)) {
                                hashMap.put(str4, (String) m6017a.get(str4));
                            }
                        }
                    }
                    if (hashMap.size() != 0) {
                        StringBuilder sb = new StringBuilder();
                        for (Map.Entry entry : hashMap.entrySet()) {
                            sb.append((String) entry.getKey());
                            sb.append("=");
                            sb.append((String) entry.getValue());
                            if (i < hashMap.size() - 1) {
                                sb.append("&");
                            }
                            i++;
                        }
                        str3 = sb.toString();
                    }
                    buildUpon.encodedQuery(str3);
                    str = buildUpon.build().toString();
                }
            }
            this.f4335a.loadUrl(str, c2496bn.subtitles);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.akv
    /* renamed from: g */
    public final void mo5064g(ResizeAndPositionVideoMsgData resizeAndPositionVideoMsgData) {
        if (!(this.f4335a instanceof ResizablePlayer)) {
            C2525p.m5991a("Stream player does not support resizing.");
        } else if (!C2533x.m5986a(this.f4342h, resizeAndPositionVideoMsgData)) {
            C2525p.m5991a("Video resize parameters were not within the container bounds.");
        } else {
            int width = this.f4342h.getAdContainer().getWidth();
            int height = this.f4342h.getAdContainer().getHeight();
            int intValue = resizeAndPositionVideoMsgData.mo6010x().intValue();
            int intValue2 = resizeAndPositionVideoMsgData.width().intValue();
            int intValue3 = resizeAndPositionVideoMsgData.mo6009y().intValue();
            ((ResizablePlayer) this.f4335a).resize(resizeAndPositionVideoMsgData.mo6010x().intValue(), resizeAndPositionVideoMsgData.mo6009y().intValue(), (width - intValue) - intValue2, (height - intValue3) - resizeAndPositionVideoMsgData.height().intValue());
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.AdProgressProvider
    public final VideoProgressUpdate getAdProgress() {
        return this.f4335a.getContentProgress();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.akv
    /* renamed from: h */
    public final void mo5063h() {
        VideoStreamPlayer videoStreamPlayer = this.f4335a;
        if (videoStreamPlayer instanceof ResizablePlayer) {
            ((ResizablePlayer) videoStreamPlayer).resize(0, 0, 0, 0);
        }
    }

    /* renamed from: i */
    public final void m5074i() {
        this.f4335a.onAdPeriodEnded();
    }

    /* renamed from: j */
    public final void m5073j() {
        this.f4335a.onAdPeriodStarted();
    }

    /* renamed from: k */
    public final void m5072k() {
        this.f4335a.addCallback(this);
    }

    /* renamed from: l */
    public final void m5071l(long j) {
        this.f4335a.seek(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public final void m5070m(C2509c c2509c) {
        if (c2509c.isLinear()) {
            this.f4339e.m5061b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public final void m5069n() {
        this.f4339e.m5062a();
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoStreamPlayer.VideoStreamPlayerCallback
    public final void onContentComplete() {
        this.f4336b.mo5122o(new ajq(ajo.adsLoader, ajp.contentComplete, "*"));
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoStreamPlayer.VideoStreamPlayerCallback
    public final void onPause() {
        m5068o(ajp.pause, null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoStreamPlayer.VideoStreamPlayerCallback
    public final void onResume() {
        m5068o(ajp.play, null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoStreamPlayer.VideoStreamPlayerCallback
    public final void onUserTextReceived(String str) {
        m5068o(ajp.timedMetadata, akt.create(str));
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoStreamPlayer.VideoStreamPlayerCallback
    public final void onVolumeChanged(int i) {
        m5068o(ajp.volumeChange, AbstractC2512cc.builder().volumePercentage(i).build());
    }
}
