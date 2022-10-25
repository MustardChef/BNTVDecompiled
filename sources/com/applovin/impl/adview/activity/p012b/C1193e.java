package com.applovin.impl.adview.activity.p012b;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
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
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.TracksInfo;
import com.google.android.exoplayer2.p036ui.PlayerControlView;
import com.google.android.exoplayer2.p036ui.PlayerView;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.adview.activity.b.e */
/* loaded from: classes.dex */
public class C1193e extends AbstractC1173a implements AppLovinCommunicatorSubscriber {

    /* renamed from: A */
    private final C1157a f420A;

    /* renamed from: B */
    private final C1267n f421B;

    /* renamed from: C */
    private final ImageView f422C;

    /* renamed from: D */
    private final C1317v f423D;

    /* renamed from: E */
    private final ProgressBar f424E;

    /* renamed from: F */
    private final C1202a f425F;

    /* renamed from: G */
    private final Handler f426G;

    /* renamed from: H */
    private final boolean f427H;

    /* renamed from: I */
    private long f428I;

    /* renamed from: J */
    private AtomicBoolean f429J;

    /* renamed from: K */
    private AtomicBoolean f430K;

    /* renamed from: L */
    private long f431L;

    /* renamed from: M */
    private long f432M;

    /* renamed from: r */
    protected final PlayerView f433r;

    /* renamed from: s */
    protected final SimpleExoPlayer f434s;

    /* renamed from: t */
    protected final C1254k f435t;

    /* renamed from: u */
    protected boolean f436u;

    /* renamed from: v */
    protected long f437v;

    /* renamed from: w */
    protected int f438w;

    /* renamed from: x */
    protected boolean f439x;

    /* renamed from: y */
    protected boolean f440y;

    /* renamed from: z */
    private final C1167c f441z;

    /* renamed from: com.applovin.impl.adview.activity.b.e$a */
    /* loaded from: classes.dex */
    private class C1202a implements C1318w.InterfaceC1319a {
        private C1202a() {
        }

        @Override // com.applovin.impl.adview.C1318w.InterfaceC1319a
        /* renamed from: a */
        public void mo7876a(C1317v c1317v) {
            C1193e.this.f368c.m6319b("InterActivityV2", "Clicking through from video button...");
            C1193e.this.mo8221a(c1317v.getAndClearLastClickLocation());
        }

        @Override // com.applovin.impl.adview.C1318w.InterfaceC1319a
        /* renamed from: b */
        public void mo7875b(C1317v c1317v) {
            C1193e.this.f368c.m6319b("InterActivityV2", "Closing ad from video button...");
            C1193e.this.mo8165g();
        }

        @Override // com.applovin.impl.adview.C1318w.InterfaceC1319a
        /* renamed from: c */
        public void mo7874c(C1317v c1317v) {
            C1193e.this.f368c.m6319b("InterActivityV2", "Skipping video from video button...");
            C1193e.this.mo8208u();
        }
    }

    /* renamed from: com.applovin.impl.adview.activity.b.e$b */
    /* loaded from: classes.dex */
    private class C1203b implements AppLovinTouchToClickListener.OnClickListener, Player.EventListener, PlayerControlView.VisibilityListener {
        private C1203b() {
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
            Player.EventListener.CC.$default$onAvailableCommandsChanged(this, commands);
        }

        @Override // com.applovin.impl.adview.AppLovinTouchToClickListener.OnClickListener
        public void onClick(View view, PointF pointF) {
            C1193e.this.mo8221a(pointF);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onEvents(Player player, Player.Events events) {
            Player.EventListener.CC.$default$onEvents(this, player, events);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onIsLoadingChanged(boolean z) {
            Player.EventListener.CC.$default$onIsLoadingChanged(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onIsPlayingChanged(boolean z) {
            Player.EventListener.CC.$default$onIsPlayingChanged(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onLoadingChanged(boolean z) {
            Player.EventListener.CC.$default$onLoadingChanged(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j) {
            Player.EventListener.CC.$default$onMaxSeekToPreviousPositionChanged(this, j);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
            Player.EventListener.CC.$default$onMediaItemTransition(this, mediaItem, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
            Player.EventListener.CC.$default$onMediaMetadataChanged(this, mediaMetadata);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
            Player.EventListener.CC.$default$onPlayWhenReadyChanged(this, z, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            Player.EventListener.CC.$default$onPlaybackParametersChanged(this, playbackParameters);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackStateChanged(int i) {
            C1710r c1710r = C1193e.this.f368c;
            c1710r.m6319b("InterActivityV2", "Player state changed to state " + i + " and will play when ready: " + C1193e.this.f434s.getPlayWhenReady());
            if (i == 2) {
                if (C1193e.this.f420A != null) {
                    C1193e.this.f420A.m8289a();
                }
                C1193e.this.f370e.m6913g();
            } else if (i != 3) {
                if (i == 4) {
                    C1193e.this.f368c.m6319b("InterActivityV2", "Video completed");
                    C1193e.this.f440y = true;
                    C1193e.this.mo8206w();
                }
            } else {
                C1193e.this.f434s.setVolume(!C1193e.this.f436u ? 1 : 0);
                C1193e c1193e = C1193e.this;
                c1193e.f437v = c1193e.f434s.getDuration();
                C1193e.this.mo8161s();
                C1710r c1710r2 = C1193e.this.f368c;
                c1710r2.m6319b("InterActivityV2", "MediaPlayer prepared: " + C1193e.this.f434s);
                C1193e.this.f435t.m8054a();
                if (C1193e.this.f421B != null) {
                    C1193e.this.m8204y();
                }
                if (C1193e.this.f420A != null) {
                    C1193e.this.f420A.m8288b();
                }
                if (C1193e.this.f380o.m7025d()) {
                    C1193e.this.mo8214c();
                }
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            Player.EventListener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
        }

        public void onPlayerError(ExoPlaybackException exoPlaybackException) {
            C1193e c1193e = C1193e.this;
            c1193e.mo8212c("Video view error (" + exoPlaybackException + ")");
            C1193e.this.mo8165g();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlayerError(PlaybackException playbackException) {
            Player.EventListener.CC.$default$onPlayerError(this, playbackException);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
            Player.EventListener.CC.$default$onPlayerErrorChanged(this, playbackException);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
            Player.EventListener.CC.$default$onPlayerStateChanged(this, z, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
            Player.EventListener.CC.$default$onPlaylistMetadataChanged(this, mediaMetadata);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPositionDiscontinuity(int i) {
            Player.EventListener.CC.$default$onPositionDiscontinuity(this, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
            Player.EventListener.CC.$default$onPositionDiscontinuity(this, positionInfo, positionInfo2, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onRepeatModeChanged(int i) {
            Player.EventListener.CC.$default$onRepeatModeChanged(this, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onSeekBackIncrementChanged(long j) {
            Player.EventListener.CC.$default$onSeekBackIncrementChanged(this, j);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onSeekForwardIncrementChanged(long j) {
            Player.EventListener.CC.$default$onSeekForwardIncrementChanged(this, j);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onSeekProcessed() {
            Player.EventListener.CC.$default$onSeekProcessed(this);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
            Player.EventListener.CC.$default$onShuffleModeEnabledChanged(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
            Player.EventListener.CC.$default$onTimelineChanged(this, timeline, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
            Player.EventListener.CC.$default$onTrackSelectionParametersChanged(this, trackSelectionParameters);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            Player.EventListener.CC.$default$onTracksChanged(this, trackGroupArray, trackSelectionArray);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTracksInfoChanged(TracksInfo tracksInfo) {
            Player.EventListener.CC.$default$onTracksInfoChanged(this, tracksInfo);
        }

        @Override // com.google.android.exoplayer2.p036ui.PlayerControlView.VisibilityListener
        public void onVisibilityChange(int i) {
            if (i == 0) {
                C1193e.this.f433r.hideController();
            }
        }
    }

    /* renamed from: com.applovin.impl.adview.activity.b.e$c */
    /* loaded from: classes.dex */
    private class View$OnClickListenerC1204c implements View.OnClickListener {
        private View$OnClickListenerC1204c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == C1193e.this.f421B) {
                if (!C1193e.this.mo8162q()) {
                    C1193e.this.mo8208u();
                    return;
                }
                C1193e.this.mo8214c();
                C1193e.this.m8250n();
                C1193e.this.f380o.m7029b();
            } else if (view == C1193e.this.f422C) {
                C1193e.this.mo8207v();
            } else {
                C1710r c1710r = C1193e.this.f368c;
                c1710r.m6314e("InterActivityV2", "Unhandled click on widget: " + view);
            }
        }
    }

    public C1193e(AbstractC1537g abstractC1537g, AppLovinFullscreenActivity appLovinFullscreenActivity, C1662k c1662k, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(abstractC1537g, appLovinFullscreenActivity, c1662k, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        this.f441z = new C1167c(this.f366a, this.f369d, this.f367b);
        C1202a c1202a = new C1202a();
        this.f425F = c1202a;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f426G = handler;
        C1254k c1254k = new C1254k(handler, this.f367b);
        this.f435t = c1254k;
        boolean mo7085f = this.f366a.mo7085f();
        this.f427H = mo7085f;
        this.f436u = m8247t();
        this.f428I = -1L;
        this.f429J = new AtomicBoolean();
        this.f430K = new AtomicBoolean();
        this.f431L = -2L;
        this.f432M = 0L;
        if (!abstractC1537g.hasVideoUrl()) {
            throw new IllegalStateException("Attempting to use fullscreen video ad presenter for non-video ad");
        }
        View$OnClickListenerC1204c view$OnClickListenerC1204c = new View$OnClickListenerC1204c();
        if (abstractC1537g.m7076s() >= 0) {
            C1267n c1267n = new C1267n(abstractC1537g.m7072w(), appLovinFullscreenActivity);
            this.f421B = c1267n;
            c1267n.setVisibility(8);
            c1267n.setOnClickListener(view$OnClickListenerC1204c);
        } else {
            this.f421B = null;
        }
        if (m8218a(this.f436u, c1662k)) {
            ImageView imageView = new ImageView(appLovinFullscreenActivity);
            this.f422C = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setClickable(true);
            imageView.setOnClickListener(view$OnClickListenerC1204c);
            m8210d(this.f436u);
        } else {
            this.f422C = null;
        }
        String m7171B = abstractC1537g.m7171B();
        if (StringUtils.isValidString(m7171B)) {
            C1318w c1318w = new C1318w(c1662k);
            c1318w.m7877a(new WeakReference<>(c1202a));
            C1317v c1317v = new C1317v(c1318w, appLovinFullscreenActivity);
            this.f423D = c1317v;
            c1317v.m7879a(m7171B);
        } else {
            this.f423D = null;
        }
        if (mo7085f) {
            C1157a c1157a = new C1157a(appLovinFullscreenActivity, ((Integer) c1662k.m6656a(C1568b.f1765cF)).intValue(), 16842874);
            this.f420A = c1157a;
            c1157a.setColor(Color.parseColor("#75FFFFFF"));
            c1157a.setBackgroundColor(Color.parseColor("#00000000"));
            c1157a.setVisibility(8);
            AppLovinCommunicator.getInstance(appLovinFullscreenActivity).subscribe(this, "video_caching_failed");
        } else {
            this.f420A = null;
        }
        if (abstractC1537g.m7159N()) {
            ProgressBar progressBar = new ProgressBar(appLovinFullscreenActivity, null, 16842872);
            this.f424E = progressBar;
            progressBar.setMax(10000);
            progressBar.setPadding(0, 0, 0, 0);
            if (C1724f.m6275d()) {
                progressBar.setProgressTintList(ColorStateList.valueOf(abstractC1537g.m7158O()));
            }
            c1254k.m8050a("PROGRESS_BAR", ((Long) c1662k.m6656a(C1568b.f1760cA)).longValue(), new C1254k.InterfaceC1256a() { // from class: com.applovin.impl.adview.activity.b.e.1
                @Override // com.applovin.impl.adview.C1254k.InterfaceC1256a
                /* renamed from: a */
                public void mo7891a() {
                    if (C1193e.this.f439x) {
                        C1193e.this.f424E.setVisibility(8);
                        return;
                    }
                    C1193e.this.f424E.setProgress((int) ((((float) C1193e.this.f434s.getCurrentPosition()) / ((float) C1193e.this.f437v)) * 10000.0f));
                }

                @Override // com.applovin.impl.adview.C1254k.InterfaceC1256a
                /* renamed from: b */
                public boolean mo7890b() {
                    return !C1193e.this.f439x;
                }
            });
        } else {
            this.f424E = null;
        }
        SimpleExoPlayer build = new SimpleExoPlayer.Builder(appLovinFullscreenActivity).build();
        this.f434s = build;
        C1203b c1203b = new C1203b();
        build.addListener(c1203b);
        build.setRepeatMode(0);
        PlayerView playerView = new PlayerView(appLovinFullscreenActivity);
        this.f433r = playerView;
        playerView.hideController();
        playerView.setControllerVisibilityListener(c1203b);
        playerView.setPlayer(build);
        playerView.setOnTouchListener(new AppLovinTouchToClickListener(c1662k, C1568b.f1664aJ, appLovinFullscreenActivity, c1203b));
        m8205x();
    }

    /* renamed from: C */
    private void m8222C() {
        C1317v c1317v;
        C1316u m7170C = this.f366a.m7170C();
        if (m7170C == null || !m7170C.m7885e() || this.f439x || (c1317v = this.f423D) == null) {
            return;
        }
        final boolean z = c1317v.getVisibility() == 4;
        final long m7884f = m7170C.m7884f();
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.activity.b.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    C1763o.m6157a(C1193e.this.f423D, m7884f, (Runnable) null);
                } else {
                    C1763o.m6155b(C1193e.this.f423D, m7884f, null);
                }
            }
        });
    }

    /* renamed from: a */
    private static boolean m8218a(boolean z, C1662k c1662k) {
        if (((Boolean) c1662k.m6656a(C1568b.f1803cr)).booleanValue()) {
            if (!((Boolean) c1662k.m6656a(C1568b.f1804cs)).booleanValue() || z) {
                return true;
            }
            return ((Boolean) c1662k.m6656a(C1568b.f1806cu)).booleanValue();
        }
        return false;
    }

    /* renamed from: A */
    protected void m8224A() {
        C1710r c1710r;
        String str;
        if (this.f439x) {
            c1710r = this.f368c;
            str = "Skip video resume - postitial shown";
        } else if (!this.f367b.m6638ab().m6134a()) {
            long j = this.f428I;
            if (j < 0) {
                C1710r c1710r2 = this.f368c;
                c1710r2.m6319b("InterActivityV2", "Invalid last video position, isVideoPlaying=" + this.f434s.isPlaying());
                return;
            }
            long m7128aL = this.f366a.m7128aL();
            if (m7128aL > 0) {
                j = Math.max(0L, j - m7128aL);
                this.f434s.seekTo(j);
            }
            C1710r c1710r3 = this.f368c;
            c1710r3.m6319b("InterActivityV2", "Resuming video at position " + j + "ms for MediaPlayer: " + this.f434s);
            this.f434s.setPlayWhenReady(true);
            this.f435t.m8054a();
            this.f428I = -1L;
            if (this.f434s.isPlaying()) {
                return;
            }
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.activity.b.e.7
                @Override // java.lang.Runnable
                public void run() {
                    if (C1193e.this.f420A != null) {
                        C1193e.this.f420A.m8289a();
                    }
                }
            });
            return;
        } else {
            c1710r = this.f368c;
            str = "Skip video resume - app paused";
        }
        c1710r.m6315d("InterActivityV2", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B */
    public int m8223B() {
        long currentPosition = this.f434s.getCurrentPosition();
        if (this.f440y) {
            return 100;
        }
        return currentPosition > 0 ? (int) ((((float) currentPosition) / ((float) this.f437v)) * 100.0f) : this.f438w;
    }

    @Override // com.applovin.impl.sdk.p028b.C1554b.InterfaceC1564a
    /* renamed from: a */
    public void mo7023a() {
        this.f368c.m6319b("InterActivityV2", "Continue video from prompt - will resume in onWindowFocusChanged(true) when alert dismisses");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8221a(PointF pointF) {
        if (!this.f366a.mo7169D()) {
            m8222C();
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
        mo8208u();
    }

    /* renamed from: b */
    public void m8217b(long j) {
        m8262a(new Runnable() { // from class: com.applovin.impl.adview.activity.b.e.6
            @Override // java.lang.Runnable
            public void run() {
                C1193e.this.m8224A();
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void mo8214c() {
        C1710r c1710r;
        String str;
        this.f368c.m6319b("InterActivityV2", "Pausing video");
        if (this.f434s.isPlaying()) {
            this.f428I = this.f434s.getCurrentPosition();
            this.f434s.setPlayWhenReady(false);
            this.f435t.m8047c();
            c1710r = this.f368c;
            str = "Paused video at position " + this.f428I + "ms";
        } else {
            c1710r = this.f368c;
            str = "Nothing to pause";
        }
        c1710r.m6319b("InterActivityV2", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void mo8212c(String str) {
        C1710r c1710r = this.f368c;
        c1710r.m6314e("InterActivityV2", "Encountered media error: " + str + " for ad: " + this.f366a);
        if (this.f429J.compareAndSet(false, true)) {
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
            m8217b(((Boolean) this.f367b.m6656a(C1568b.f1877eN)).booleanValue() ? 0L : 250L);
        } else if (this.f439x) {
        } else {
            mo8214c();
        }
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: d */
    public void mo8167d() {
        this.f441z.m8275a(this.f422C, this.f421B, this.f423D, this.f420A, this.f424E, this.f433r, this.f371f);
        this.f434s.setPlayWhenReady(true);
        if (this.f366a.m7113am()) {
            this.f380o.m7033a(this.f366a, new Runnable() { // from class: com.applovin.impl.adview.activity.b.e.2
                @Override // java.lang.Runnable
                public void run() {
                    C1193e.this.m8217b(250L);
                }
            });
        }
        if (this.f427H) {
            this.f420A.m8289a();
        }
        this.f371f.renderAd(this.f366a);
        this.f370e.m6920b(this.f427H ? 1L : 0L);
        if (this.f421B != null) {
            this.f367b.m6670Q().m6791a((AbstractRunnableC1589a) new C1642y(this.f367b, new Runnable() { // from class: com.applovin.impl.adview.activity.b.e.3
                @Override // java.lang.Runnable
                public void run() {
                    C1193e.this.m8204y();
                }
            }), C1620o.EnumC1622a.MAIN, this.f366a.m7075t(), true);
        }
        super.m8255b(this.f436u);
    }

    /* renamed from: d */
    protected void m8210d(boolean z) {
        if (C1724f.m6275d()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) this.f369d.getDrawable(z ? C1799R.C1801drawable.unmute_to_mute : C1799R.C1801drawable.mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.f422C.setScaleType(ImageView.ScaleType.FIT_XY);
                this.f422C.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
        }
        Uri m7135aE = z ? this.f366a.m7135aE() : this.f366a.m7134aF();
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        this.f422C.setImageURI(m7135aE);
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: g */
    public void mo8165g() {
        this.f435t.m8049b();
        this.f426G.removeCallbacksAndMessages(null);
        mo8164l();
        super.mo8165g();
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "FullscreenVideoAdExoPlayerPresenter";
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: i */
    public void mo8181i() {
        this.f434s.release();
        if (this.f427H) {
            AppLovinCommunicator.getInstance(this.f369d).unsubscribe(this, "video_caching_failed");
        }
        super.mo8181i();
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: l */
    protected void mo8164l() {
        super.m8267a(m8223B(), this.f427H, mo8163p(), this.f431L);
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("video_caching_failed".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            long j = messageData.getLong("ad_id");
            if (((Boolean) this.f367b.m6656a(C1568b.f1878eO)).booleanValue() && j == this.f366a.getAdIdNumber() && this.f427H) {
                int i = messageData.getInt("load_response_code");
                String string = messageData.getString("load_exception_message");
                if ((string == null && i >= 200 && i < 300) || this.f440y || this.f434s.isPlaying()) {
                    return;
                }
                mo8212c("Video cache error during stream. ResponseCode=" + i + ", exception=" + string);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: p */
    public boolean mo8163p() {
        return m8223B() >= this.f366a.m7157P();
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
                long j = this.f437v;
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
    public void mo8208u() {
        this.f431L = SystemClock.elapsedRealtime() - this.f432M;
        C1710r c1710r = this.f368c;
        c1710r.m6319b("InterActivityV2", "Skipping video with skip time: " + this.f431L + "ms");
        this.f370e.m6914f();
        if (this.f366a.m7071x()) {
            mo8165g();
        } else {
            mo8206w();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: v */
    public void mo8207v() {
        boolean z = !this.f436u ? 1 : 0;
        this.f436u = z;
        this.f434s.setVolume(!z ? 1 : 0);
        m8210d(this.f436u);
        m8258a(this.f436u, 0L);
    }

    /* renamed from: w */
    public void mo8206w() {
        m8203z();
        this.f441z.m8274a(this.f372g, this.f371f);
        m8260a("javascript:al_onPoststitialShow();", this.f366a.m7155R());
        if (this.f372g != null) {
            int i = (this.f366a.m7074u() > 0L ? 1 : (this.f366a.m7074u() == 0L ? 0 : -1));
            C1267n c1267n = this.f372g;
            if (i >= 0) {
                m8263a(c1267n, this.f366a.m7074u(), new Runnable() { // from class: com.applovin.impl.adview.activity.b.e.8
                    @Override // java.lang.Runnable
                    public void run() {
                        C1193e.this.f374i = SystemClock.elapsedRealtime();
                    }
                });
            } else {
                c1267n.setVisibility(0);
            }
        }
        this.f439x = true;
    }

    /* renamed from: x */
    protected void m8205x() {
        m8259a(!this.f427H);
        this.f434s.setMediaSource(new ProgressiveMediaSource.Factory(new DefaultDataSourceFactory(this.f369d, Util.getUserAgent(this.f369d, "com.applovin.sdk"))).createMediaSource(MediaItem.fromUri(this.f366a.mo7082h())));
        this.f434s.prepare();
        this.f434s.setPlayWhenReady(false);
    }

    /* renamed from: y */
    protected void m8204y() {
        if (this.f430K.compareAndSet(false, true)) {
            m8263a(this.f421B, this.f366a.m7076s(), new Runnable() { // from class: com.applovin.impl.adview.activity.b.e.4
                @Override // java.lang.Runnable
                public void run() {
                    C1193e.this.f431L = -1L;
                    C1193e.this.f432M = SystemClock.elapsedRealtime();
                }
            });
        }
    }

    /* renamed from: z */
    protected void m8203z() {
        this.f438w = m8223B();
        this.f434s.setPlayWhenReady(false);
    }
}
