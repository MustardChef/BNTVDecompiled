package com.applovin.impl.adview.activity.p012b;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.adview.AppLovinVideoView;
import com.applovin.impl.adview.C1157a;
import com.applovin.impl.adview.C1254k;
import com.applovin.impl.adview.C1267n;
import com.applovin.impl.adview.C1316u;
import com.applovin.impl.adview.C1317v;
import com.applovin.impl.adview.C1318w;
import com.applovin.impl.adview.activity.p011a.C1167c;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p027a.C1527a;
import com.applovin.impl.sdk.p027a.InterfaceC1544i;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p031e.AbstractRunnableC1589a;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.impl.sdk.p031e.C1642y;
import com.applovin.impl.sdk.utils.C1724f;
import com.applovin.impl.sdk.utils.C1728i;
import com.applovin.impl.sdk.utils.C1763o;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.C1799R;
import com.google.android.exoplayer2.ExoPlayer;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.adview.activity.b.f */
/* loaded from: classes.dex */
public class C1205f extends AbstractC1173a implements AppLovinCommunicatorSubscriber {

    /* renamed from: A */
    private final ImageView f455A;

    /* renamed from: B */
    private final C1317v f456B;

    /* renamed from: C */
    private final ProgressBar f457C;

    /* renamed from: D */
    private final C1216b f458D;

    /* renamed from: E */
    private final C1215a f459E;

    /* renamed from: F */
    private final Handler f460F;

    /* renamed from: G */
    private final boolean f461G;

    /* renamed from: H */
    private int f462H;

    /* renamed from: I */
    private int f463I;

    /* renamed from: J */
    private boolean f464J;

    /* renamed from: K */
    private AtomicBoolean f465K;

    /* renamed from: L */
    private AtomicBoolean f466L;

    /* renamed from: M */
    private long f467M;

    /* renamed from: N */
    private long f468N;

    /* renamed from: r */
    protected final AppLovinVideoView f469r;

    /* renamed from: s */
    protected final C1254k f470s;

    /* renamed from: t */
    protected boolean f471t;

    /* renamed from: u */
    protected long f472u;

    /* renamed from: v */
    protected boolean f473v;

    /* renamed from: w */
    private final C1167c f474w;

    /* renamed from: x */
    private MediaPlayer f475x;

    /* renamed from: y */
    private final C1157a f476y;

    /* renamed from: z */
    private final C1267n f477z;

    /* renamed from: com.applovin.impl.adview.activity.b.f$a */
    /* loaded from: classes.dex */
    private class C1215a implements C1318w.InterfaceC1319a {
        private C1215a() {
        }

        @Override // com.applovin.impl.adview.C1318w.InterfaceC1319a
        /* renamed from: a */
        public void mo7876a(C1317v c1317v) {
            C1205f.this.f368c.m6319b("InterActivityV2", "Clicking through from video button...");
            C1205f.this.mo8201a(c1317v.getAndClearLastClickLocation());
        }

        @Override // com.applovin.impl.adview.C1318w.InterfaceC1319a
        /* renamed from: b */
        public void mo7875b(C1317v c1317v) {
            C1205f.this.f368c.m6319b("InterActivityV2", "Closing ad from video button...");
            C1205f.this.mo8165g();
        }

        @Override // com.applovin.impl.adview.C1318w.InterfaceC1319a
        /* renamed from: c */
        public void mo7874c(C1317v c1317v) {
            C1205f.this.f368c.m6319b("InterActivityV2", "Skipping video from video button...");
            C1205f.this.mo8179u();
        }
    }

    /* renamed from: com.applovin.impl.adview.activity.b.f$b */
    /* loaded from: classes.dex */
    private class C1216b implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, AppLovinTouchToClickListener.OnClickListener {
        private C1216b() {
        }

        @Override // com.applovin.impl.adview.AppLovinTouchToClickListener.OnClickListener
        public void onClick(View view, PointF pointF) {
            C1205f.this.mo8201a(pointF);
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            C1205f.this.f368c.m6319b("InterActivityV2", "Video completed");
            C1205f.this.f464J = true;
            C1205f.this.mo8177w();
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            C1205f c1205f = C1205f.this;
            c1205f.mo8190c("Video view error (" + i + "," + i2 + ")");
            C1205f.this.f469r.start();
            return true;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            C1710r c1710r = C1205f.this.f368c;
            c1710r.m6319b("InterActivityV2", "MediaPlayer Info: (" + i + ", " + i2 + ")");
            if (i == 701) {
                if (C1205f.this.f476y != null) {
                    C1205f.this.f476y.m8289a();
                }
                C1205f.this.f370e.m6913g();
                return false;
            } else if (i != 3) {
                if (i != 702 || C1205f.this.f476y == null) {
                    return false;
                }
                C1205f.this.f476y.m8288b();
                return false;
            } else {
                C1205f.this.f470s.m8054a();
                if (C1205f.this.f477z != null) {
                    C1205f.this.m8175y();
                }
                if (C1205f.this.f476y != null) {
                    C1205f.this.f476y.m8288b();
                }
                if (C1205f.this.f380o.m7025d()) {
                    C1205f.this.mo8192c();
                    return false;
                }
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            C1205f.this.f475x = mediaPlayer;
            mediaPlayer.setOnInfoListener(C1205f.this.f458D);
            mediaPlayer.setOnErrorListener(C1205f.this.f458D);
            float f = !C1205f.this.f471t ? 1 : 0;
            mediaPlayer.setVolume(f, f);
            C1205f.this.f472u = mediaPlayer.getDuration();
            C1205f.this.mo8161s();
            C1205f.this.f368c.m6319b("InterActivityV2", "MediaPlayer prepared: " + C1205f.this.f475x);
        }
    }

    /* renamed from: com.applovin.impl.adview.activity.b.f$c */
    /* loaded from: classes.dex */
    private class View$OnClickListenerC1217c implements View.OnClickListener {
        private View$OnClickListenerC1217c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == C1205f.this.f477z) {
                if (!C1205f.this.mo8162q()) {
                    C1205f.this.mo8179u();
                    return;
                }
                C1205f.this.mo8192c();
                C1205f.this.m8250n();
                C1205f.this.f380o.m7029b();
            } else if (view == C1205f.this.f455A) {
                C1205f.this.mo8178v();
            } else {
                C1710r c1710r = C1205f.this.f368c;
                c1710r.m6314e("InterActivityV2", "Unhandled click on widget: " + view);
            }
        }
    }

    public C1205f(AbstractC1537g abstractC1537g, AppLovinFullscreenActivity appLovinFullscreenActivity, C1662k c1662k, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(abstractC1537g, appLovinFullscreenActivity, c1662k, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        this.f474w = new C1167c(this.f366a, this.f369d, this.f367b);
        C1216b c1216b = new C1216b();
        this.f458D = c1216b;
        C1215a c1215a = new C1215a();
        this.f459E = c1215a;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f460F = handler;
        C1254k c1254k = new C1254k(handler, this.f367b);
        this.f470s = c1254k;
        boolean mo7085f = this.f366a.mo7085f();
        this.f461G = mo7085f;
        this.f471t = m8247t();
        this.f463I = -1;
        this.f465K = new AtomicBoolean();
        this.f466L = new AtomicBoolean();
        this.f467M = -2L;
        this.f468N = 0L;
        if (!abstractC1537g.hasVideoUrl()) {
            throw new IllegalStateException("Attempting to use fullscreen video ad presenter for non-video ad");
        }
        AppLovinVideoView appLovinVideoView = new AppLovinVideoView(appLovinFullscreenActivity, c1662k);
        this.f469r = appLovinVideoView;
        appLovinVideoView.setOnPreparedListener(c1216b);
        appLovinVideoView.setOnCompletionListener(c1216b);
        appLovinVideoView.setOnErrorListener(c1216b);
        appLovinVideoView.setOnTouchListener(new AppLovinTouchToClickListener(c1662k, C1568b.f1664aJ, appLovinFullscreenActivity, c1216b));
        View$OnClickListenerC1217c view$OnClickListenerC1217c = new View$OnClickListenerC1217c();
        if (abstractC1537g.m7076s() >= 0) {
            C1267n c1267n = new C1267n(abstractC1537g.m7072w(), appLovinFullscreenActivity);
            this.f477z = c1267n;
            c1267n.setVisibility(8);
            c1267n.setOnClickListener(view$OnClickListenerC1217c);
        } else {
            this.f477z = null;
        }
        if (m8196a(this.f471t, c1662k)) {
            ImageView imageView = new ImageView(appLovinFullscreenActivity);
            this.f455A = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setClickable(true);
            imageView.setOnClickListener(view$OnClickListenerC1217c);
            m8185e(this.f471t);
        } else {
            this.f455A = null;
        }
        String m7171B = abstractC1537g.m7171B();
        if (StringUtils.isValidString(m7171B)) {
            C1318w c1318w = new C1318w(c1662k);
            c1318w.m7877a(new WeakReference<>(c1215a));
            C1317v c1317v = new C1317v(c1318w, appLovinFullscreenActivity);
            this.f456B = c1317v;
            c1317v.m7879a(m7171B);
        } else {
            this.f456B = null;
        }
        if (mo7085f) {
            C1157a c1157a = new C1157a(appLovinFullscreenActivity, ((Integer) c1662k.m6656a(C1568b.f1765cF)).intValue(), 16842874);
            this.f476y = c1157a;
            c1157a.setColor(Color.parseColor("#75FFFFFF"));
            c1157a.setBackgroundColor(Color.parseColor("#00000000"));
            c1157a.setVisibility(8);
            AppLovinCommunicator.getInstance(appLovinFullscreenActivity).subscribe(this, "video_caching_failed");
        } else {
            this.f476y = null;
        }
        if (!abstractC1537g.m7159N()) {
            this.f457C = null;
            return;
        }
        ProgressBar progressBar = new ProgressBar(appLovinFullscreenActivity, null, 16842872);
        this.f457C = progressBar;
        progressBar.setMax(10000);
        progressBar.setPadding(0, 0, 0, 0);
        if (C1724f.m6275d()) {
            progressBar.setProgressTintList(ColorStateList.valueOf(abstractC1537g.m7158O()));
        }
        c1254k.m8050a("PROGRESS_BAR", ((Long) c1662k.m6656a(C1568b.f1760cA)).longValue(), new C1254k.InterfaceC1256a() { // from class: com.applovin.impl.adview.activity.b.f.1
            @Override // com.applovin.impl.adview.C1254k.InterfaceC1256a
            /* renamed from: a */
            public void mo7891a() {
                if (C1205f.this.f473v) {
                    C1205f.this.f457C.setVisibility(8);
                    return;
                }
                C1205f.this.f457C.setProgress((int) ((C1205f.this.f469r.getCurrentPosition() / ((float) C1205f.this.f472u)) * 10000.0f));
            }

            @Override // com.applovin.impl.adview.C1254k.InterfaceC1256a
            /* renamed from: b */
            public boolean mo7890b() {
                return !C1205f.this.f473v;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public void m8202A() {
        C1710r c1710r;
        String str;
        if (this.f473v) {
            c1710r = this.f368c;
            str = "Skip video resume - postitial shown";
        } else if (!this.f367b.m6638ab().m6134a()) {
            if (this.f463I < 0) {
                this.f368c.m6319b("InterActivityV2", "Invalid last video position");
                return;
            }
            C1710r c1710r2 = this.f368c;
            c1710r2.m6319b("InterActivityV2", "Resuming video at position " + this.f463I + "ms for MediaPlayer: " + this.f475x);
            this.f469r.seekTo(this.f463I);
            this.f469r.start();
            this.f470s.m8054a();
            this.f463I = -1;
            m8262a(new Runnable() { // from class: com.applovin.impl.adview.activity.b.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (C1205f.this.f476y != null) {
                        C1205f.this.f476y.m8289a();
                        C1205f.this.m8262a(new Runnable() { // from class: com.applovin.impl.adview.activity.b.f.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                C1205f.this.f476y.m8288b();
                            }
                        }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                    }
                }
            }, 250L);
            return;
        } else {
            c1710r = this.f368c;
            str = "Skip video resume - app paused";
        }
        c1710r.m6315d("InterActivityV2", str);
    }

    /* renamed from: a */
    private static boolean m8196a(boolean z, C1662k c1662k) {
        if (((Boolean) c1662k.m6656a(C1568b.f1803cr)).booleanValue()) {
            if (!((Boolean) c1662k.m6656a(C1568b.f1804cs)).booleanValue() || z) {
                return true;
            }
            return ((Boolean) c1662k.m6656a(C1568b.f1806cu)).booleanValue();
        }
        return false;
    }

    /* renamed from: d */
    private void m8187d(boolean z) {
        this.f462H = m8176x();
        if (z) {
            this.f469r.pause();
        } else {
            this.f469r.stopPlayback();
        }
    }

    /* renamed from: e */
    private void m8185e(boolean z) {
        if (C1724f.m6275d()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) this.f369d.getDrawable(z ? C1799R.C1801drawable.unmute_to_mute : C1799R.C1801drawable.mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.f455A.setScaleType(ImageView.ScaleType.FIT_XY);
                this.f455A.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
        }
        Uri m7135aE = z ? this.f366a.m7135aE() : this.f366a.m7134aF();
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        this.f455A.setImageURI(m7135aE);
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public void m8175y() {
        if (this.f466L.compareAndSet(false, true)) {
            m8263a(this.f477z, this.f366a.m7076s(), new Runnable() { // from class: com.applovin.impl.adview.activity.b.f.4
                @Override // java.lang.Runnable
                public void run() {
                    C1205f.this.f467M = -1L;
                    C1205f.this.f468N = SystemClock.elapsedRealtime();
                }
            });
        }
    }

    /* renamed from: z */
    private void m8174z() {
        C1317v c1317v;
        C1316u m7170C = this.f366a.m7170C();
        if (m7170C == null || !m7170C.m7885e() || this.f473v || (c1317v = this.f456B) == null) {
            return;
        }
        final boolean z = c1317v.getVisibility() == 4;
        final long m7884f = m7170C.m7884f();
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.activity.b.f.5
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    C1763o.m6157a(C1205f.this.f456B, m7884f, (Runnable) null);
                } else {
                    C1763o.m6155b(C1205f.this.f456B, m7884f, null);
                }
            }
        });
    }

    @Override // com.applovin.impl.sdk.p028b.C1554b.InterfaceC1564a
    /* renamed from: a */
    public void mo7023a() {
        this.f368c.m6319b("InterActivityV2", "Continue video from prompt - will resume in onWindowFocusChanged(true) when alert dismisses");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8201a(PointF pointF) {
        if (!this.f366a.mo7169D()) {
            m8174z();
            return;
        }
        this.f368c.m6319b("InterActivityV2", "Clicking through video");
        Uri mo7080k = this.f366a.mo7080k();
        if (mo7080k != null) {
            C1728i.m6229a(this.f377l, this.f366a);
            this.f367b.m6594t().trackAndLaunchVideoClick(this.f366a, this.f371f, mo7080k, pointF);
            this.f370e.m6921b();
        }
    }

    @Override // com.applovin.impl.sdk.p028b.C1554b.InterfaceC1564a
    /* renamed from: b */
    public void mo7022b() {
        this.f368c.m6319b("InterActivityV2", "Skipping video from prompt");
        mo8179u();
    }

    /* renamed from: b */
    public void m8195b(long j) {
        m8262a(new Runnable() { // from class: com.applovin.impl.adview.activity.b.f.6
            @Override // java.lang.Runnable
            public void run() {
                C1205f.this.m8202A();
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void mo8192c() {
        this.f368c.m6319b("InterActivityV2", "Pausing video");
        this.f463I = this.f469r.getCurrentPosition();
        this.f469r.pause();
        this.f470s.m8047c();
        C1710r c1710r = this.f368c;
        c1710r.m6319b("InterActivityV2", "Paused video at position " + this.f463I + "ms");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void mo8190c(String str) {
        C1710r c1710r = this.f368c;
        c1710r.m6314e("InterActivityV2", "Encountered media error: " + str + " for ad: " + this.f366a);
        if (this.f465K.compareAndSet(false, true)) {
            if (this.f378m instanceof InterfaceC1544i) {
                ((InterfaceC1544i) this.f378m).onAdDisplayFailed(str);
            }
            mo8165g();
        }
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: c */
    public void mo8189c(boolean z) {
        super.mo8189c(z);
        if (z) {
            m8195b(((Boolean) this.f367b.m6656a(C1568b.f1877eN)).booleanValue() ? 0L : 250L);
        } else if (this.f473v) {
        } else {
            mo8192c();
        }
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: d */
    public void mo8167d() {
        this.f474w.m8275a(this.f455A, this.f477z, this.f456B, this.f476y, this.f457C, this.f469r, this.f371f);
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        m8259a(!this.f461G);
        this.f469r.setVideoURI(this.f366a.mo7082h());
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        if (this.f366a.m7113am()) {
            this.f380o.m7033a(this.f366a, new Runnable() { // from class: com.applovin.impl.adview.activity.b.f.2
                @Override // java.lang.Runnable
                public void run() {
                    C1205f.this.m8195b(250L);
                }
            });
        }
        this.f469r.start();
        if (this.f461G) {
            this.f476y.m8289a();
        }
        this.f371f.renderAd(this.f366a);
        this.f370e.m6920b(this.f461G ? 1L : 0L);
        if (this.f477z != null) {
            this.f367b.m6670Q().m6791a((AbstractRunnableC1589a) new C1642y(this.f367b, new Runnable() { // from class: com.applovin.impl.adview.activity.b.f.3
                @Override // java.lang.Runnable
                public void run() {
                    C1205f.this.m8175y();
                }
            }), C1620o.EnumC1622a.MAIN, this.f366a.m7075t(), true);
        }
        super.m8255b(this.f471t);
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: g */
    public void mo8165g() {
        this.f470s.m8049b();
        this.f460F.removeCallbacksAndMessages(null);
        mo8164l();
        super.mo8165g();
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "FullscreenVideoAdPresenter";
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: i */
    public void mo8181i() {
        this.f368c.m6317c("InterActivityV2", "Destroying video components");
        try {
            if (this.f461G) {
                AppLovinCommunicator.getInstance(this.f369d).unsubscribe(this, "video_caching_failed");
            }
            AppLovinVideoView appLovinVideoView = this.f469r;
            if (appLovinVideoView != null) {
                appLovinVideoView.pause();
                this.f469r.stopPlayback();
            }
            MediaPlayer mediaPlayer = this.f475x;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
        } catch (Throwable th) {
            Log.e("InterActivityV2", "Unable to destroy presenter", th);
        }
        super.mo8181i();
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: l */
    protected void mo8164l() {
        super.m8267a(m8176x(), this.f461G, mo8163p(), this.f467M);
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("video_caching_failed".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            long j = messageData.getLong("ad_id");
            if (((Boolean) this.f367b.m6656a(C1568b.f1878eO)).booleanValue() && j == this.f366a.getAdIdNumber() && this.f461G) {
                int i = messageData.getInt("load_response_code");
                String string = messageData.getString("load_exception_message");
                if ((string == null && i >= 200 && i < 300) || this.f464J || this.f469r.isPlaying()) {
                    return;
                }
                mo8190c("Video cache error during stream. ResponseCode=" + i + ", exception=" + string);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: p */
    public boolean mo8163p() {
        return m8176x() >= this.f366a.m7157P();
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: q */
    protected boolean mo8162q() {
        return m8248r() && !mo8163p();
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: s */
    protected void mo8161s() {
        long m7122ad;
        int m7229l;
        if (this.f366a.m7123ac() >= 0 || this.f366a.m7122ad() >= 0) {
            int i = (this.f366a.m7123ac() > 0L ? 1 : (this.f366a.m7123ac() == 0L ? 0 : -1));
            AbstractC1537g abstractC1537g = this.f366a;
            if (i >= 0) {
                m7122ad = abstractC1537g.m7123ac();
            } else {
                C1527a c1527a = (C1527a) abstractC1537g;
                long j = this.f472u;
                long j2 = j > 0 ? 0 + j : 0L;
                if (c1527a.m7121ae() && ((m7229l = (int) ((C1527a) this.f366a).m7229l()) > 0 || (m7229l = (int) c1527a.m7074u()) > 0)) {
                    j2 += TimeUnit.SECONDS.toMillis(m7229l);
                }
                m7122ad = (long) (j2 * (this.f366a.m7122ad() / 100.0d));
            }
            m8266a(m7122ad);
        }
    }

    /* renamed from: u */
    public void mo8179u() {
        this.f467M = SystemClock.elapsedRealtime() - this.f468N;
        C1710r c1710r = this.f368c;
        c1710r.m6319b("InterActivityV2", "Skipping video with skip time: " + this.f467M + "ms");
        this.f370e.m6914f();
        if (this.f366a.m7071x()) {
            mo8165g();
        } else {
            mo8177w();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: v */
    public void mo8178v() {
        MediaPlayer mediaPlayer = this.f475x;
        if (mediaPlayer == null) {
            return;
        }
        try {
            float f = !this.f471t ? 0 : 1;
            mediaPlayer.setVolume(f, f);
            boolean z = this.f471t ? false : true;
            this.f471t = z;
            m8185e(z);
            m8258a(this.f471t, 0L);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: w */
    public void mo8177w() {
        this.f368c.m6319b("InterActivityV2", "Showing postitial...");
        m8187d(this.f366a.m7127aM());
        this.f474w.m8274a(this.f372g, this.f371f);
        m8260a("javascript:al_onPoststitialShow();", this.f366a.m7155R());
        if (this.f372g != null) {
            int i = (this.f366a.m7074u() > 0L ? 1 : (this.f366a.m7074u() == 0L ? 0 : -1));
            C1267n c1267n = this.f372g;
            if (i >= 0) {
                m8263a(c1267n, this.f366a.m7074u(), new Runnable() { // from class: com.applovin.impl.adview.activity.b.f.8
                    @Override // java.lang.Runnable
                    public void run() {
                        C1205f.this.f374i = SystemClock.elapsedRealtime();
                    }
                });
            } else {
                c1267n.setVisibility(0);
            }
        }
        this.f473v = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: x */
    public int m8176x() {
        long currentPosition = this.f469r.getCurrentPosition();
        if (this.f464J) {
            return 100;
        }
        return currentPosition > 0 ? (int) ((((float) currentPosition) / ((float) this.f472u)) * 100.0f) : this.f462H;
    }
}
