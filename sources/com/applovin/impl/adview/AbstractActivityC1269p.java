package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Intent;
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
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.adview.C1254k;
import com.applovin.impl.adview.C1318w;
import com.applovin.impl.p010a.C1129a;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1644f;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p027a.C1527a;
import com.applovin.impl.sdk.p027a.C1531d;
import com.applovin.impl.sdk.p027a.C1543h;
import com.applovin.impl.sdk.p027a.InterfaceC1544i;
import com.applovin.impl.sdk.p028b.C1554b;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p029c.C1570d;
import com.applovin.impl.sdk.p030d.C1584d;
import com.applovin.impl.sdk.utils.AbstractC1718a;
import com.applovin.impl.sdk.utils.AppKilledService;
import com.applovin.impl.sdk.utils.C1719b;
import com.applovin.impl.sdk.utils.C1724f;
import com.applovin.impl.sdk.utils.C1728i;
import com.applovin.impl.sdk.utils.C1760m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.C1799R;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.adview.p */
/* loaded from: classes.dex */
public abstract class AbstractActivityC1269p extends Activity implements InterfaceC1258l, C1644f.InterfaceC1646a {
    public static volatile C1304q lastKnownWrapper;

    /* renamed from: C */
    private FrameLayout f636C;

    /* renamed from: D */
    private AbstractC1252j f637D;

    /* renamed from: E */
    private View f638E;

    /* renamed from: F */
    private AbstractC1252j f639F;

    /* renamed from: G */
    private View f640G;

    /* renamed from: H */
    private C1249h f641H;

    /* renamed from: I */
    private ImageView f642I;

    /* renamed from: K */
    private C1554b f644K;

    /* renamed from: L */
    private C1317v f645L;

    /* renamed from: M */
    private ProgressBar f646M;

    /* renamed from: N */
    private C1318w.InterfaceC1319a f647N;

    /* renamed from: O */
    private C1157a f648O;

    /* renamed from: P */
    private C1760m f649P;

    /* renamed from: Q */
    private AbstractC1718a f650Q;

    /* renamed from: R */
    private AppLovinBroadcastManager.Receiver f651R;

    /* renamed from: a */
    private C1268o f652a;

    /* renamed from: b */
    private C1304q f653b;

    /* renamed from: c */
    private C1584d f654c;
    protected C1254k countdownManager;
    public volatile AbstractC1537g currentAd;
    public C1710r logger;
    public C1662k sdk;
    public AppLovinVideoView videoView;

    /* renamed from: z */
    private boolean f677z;

    /* renamed from: d */
    private volatile boolean f655d = false;

    /* renamed from: e */
    private volatile boolean f656e = false;

    /* renamed from: f */
    private volatile boolean f657f = false;

    /* renamed from: g */
    private volatile boolean f658g = false;

    /* renamed from: h */
    private volatile boolean f659h = false;

    /* renamed from: i */
    private volatile boolean f660i = false;

    /* renamed from: j */
    private volatile boolean f661j = false;
    protected volatile boolean postitialWasDisplayed = false;

    /* renamed from: k */
    private boolean f662k = false;
    protected volatile boolean videoMuted = false;

    /* renamed from: l */
    private volatile boolean f663l = false;

    /* renamed from: m */
    private boolean f664m = true;

    /* renamed from: n */
    private boolean f665n = false;
    protected int computedLengthSeconds = 0;

    /* renamed from: o */
    private long f666o = 0;

    /* renamed from: p */
    private long f667p = 0;

    /* renamed from: q */
    private long f668q = 0;

    /* renamed from: r */
    private long f669r = 0;

    /* renamed from: s */
    private long f670s = -2;

    /* renamed from: t */
    private int f671t = 0;

    /* renamed from: u */
    private int f672u = Integer.MIN_VALUE;

    /* renamed from: v */
    private AtomicBoolean f673v = new AtomicBoolean(false);

    /* renamed from: w */
    private AtomicBoolean f674w = new AtomicBoolean(false);

    /* renamed from: x */
    private AtomicBoolean f675x = new AtomicBoolean(false);

    /* renamed from: y */
    private int f676y = C1644f.f2195a;

    /* renamed from: A */
    private final Handler f634A = new Handler(Looper.getMainLooper());

    /* renamed from: B */
    private final Handler f635B = new Handler(Looper.getMainLooper());

    /* renamed from: J */
    private WeakReference<MediaPlayer> f643J = new WeakReference<>(null);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.applovin.impl.adview.p$27 */
    /* loaded from: classes.dex */
    public class C129027 implements MediaPlayer.OnPreparedListener {
        C129027() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            AbstractActivityC1269p.this.f643J = new WeakReference(mediaPlayer);
            float f = !AbstractActivityC1269p.this.m7957i() ? 1 : 0;
            mediaPlayer.setVolume(f, f);
            int videoWidth = mediaPlayer.getVideoWidth();
            int videoHeight = mediaPlayer.getVideoHeight();
            AbstractActivityC1269p.this.computedLengthSeconds = (int) TimeUnit.MILLISECONDS.toSeconds(mediaPlayer.getDuration());
            AbstractActivityC1269p.this.videoView.setVideoSize(videoWidth, videoHeight);
            SurfaceHolder holder = AbstractActivityC1269p.this.videoView.getHolder();
            if (holder.getSurface() != null) {
                mediaPlayer.setDisplay(holder);
            }
            mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.applovin.impl.adview.p.27.1
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer2, final int i, final int i2) {
                    AbstractActivityC1269p.this.f635B.post(new Runnable() { // from class: com.applovin.impl.adview.p.27.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AbstractActivityC1269p abstractActivityC1269p = AbstractActivityC1269p.this;
                            abstractActivityC1269p.handleMediaError("Media player error (" + i + "," + i2 + ")");
                        }
                    });
                    return true;
                }
            });
            mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.applovin.impl.adview.p.27.2
                @Override // android.media.MediaPlayer.OnInfoListener
                public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                    if (i != 3) {
                        if (i == 701) {
                            AbstractActivityC1269p.this.m7925y();
                            if (AbstractActivityC1269p.this.f654c != null) {
                                AbstractActivityC1269p.this.f654c.m6913g();
                                return false;
                            }
                            return false;
                        } else if (i != 702) {
                            return false;
                        }
                    }
                    AbstractActivityC1269p.this.m7923z();
                    return false;
                }
            });
            if (AbstractActivityC1269p.this.f667p == 0) {
                AbstractActivityC1269p.this.m7941q();
                AbstractActivityC1269p.this.m7953k();
                AbstractActivityC1269p.this.m7931v();
                AbstractActivityC1269p.this.m7933u();
                AbstractActivityC1269p.this.playVideo();
                AbstractActivityC1269p.this.m8012I();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public void m8027A() {
        if (!m8023C()) {
            skipVideo();
            return;
        }
        m8008M();
        pauseReportRewardTask();
        this.logger.m6319b("InterActivity", "Prompting incentivized ad close warning");
        this.f644K.m7029b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public void m8025B() {
        C1238d m8098s;
        if (this.currentAd.m7152U() && (m8098s = this.f652a.getAdViewController().m8098s()) != null) {
            m8098s.m8086a("javascript:al_onCloseButtonTapped();");
        }
        if (!m8021D()) {
            dismiss();
            return;
        }
        this.logger.m6319b("InterActivity", "Prompting incentivized non-video ad close warning");
        this.f644K.m7027c();
    }

    /* renamed from: C */
    private boolean m8023C() {
        return m8015G() && !isFullyWatched() && ((Boolean) this.sdk.m6656a(C1568b.f1749bp)).booleanValue() && this.f644K != null;
    }

    /* renamed from: D */
    private boolean m8021D() {
        return m8013H() && !m8017F() && ((Boolean) this.sdk.m6656a(C1568b.f1754bu)).booleanValue() && this.f644K != null;
    }

    /* renamed from: E */
    private int m8019E() {
        if (this.currentAd instanceof C1527a) {
            float m7229l = ((C1527a) this.currentAd).m7229l();
            if (m7229l <= 0.0f) {
                m7229l = (float) this.currentAd.m7074u();
            }
            return (int) Math.min((Utils.millisToSeconds(System.currentTimeMillis() - this.f666o) / m7229l) * 100.0d, 100.0d);
        }
        return 0;
    }

    /* renamed from: F */
    private boolean m8017F() {
        return m8019E() >= this.currentAd.m7157P();
    }

    /* renamed from: G */
    private boolean m8015G() {
        return AppLovinAdType.INCENTIVIZED.equals(this.currentAd.getType());
    }

    /* renamed from: H */
    private boolean m8013H() {
        return !this.currentAd.hasVideoUrl() && m8015G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
        if (r1 > 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0098, code lost:
        if (r1 > 0) goto L27;
     */
    /* renamed from: I */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m8012I() {
        /*
            r7 = this;
            com.applovin.impl.sdk.a.g r0 = r7.currentAd
            if (r0 == 0) goto Ld9
            com.applovin.impl.sdk.a.g r0 = r7.currentAd
            long r0 = r0.m7123ac()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L18
            com.applovin.impl.sdk.a.g r0 = r7.currentAd
            int r0 = r0.m7122ad()
            if (r0 < 0) goto Ld9
        L18:
            com.applovin.impl.sdk.utils.m r0 = r7.f649P
            if (r0 != 0) goto Ld9
            com.applovin.impl.sdk.a.g r0 = r7.currentAd
            long r0 = r0.m7123ac()
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L2e
            com.applovin.impl.sdk.a.g r0 = r7.currentAd
            long r0 = r0.m7123ac()
            goto La9
        L2e:
            boolean r0 = r7.isVastAd()
            if (r0 == 0) goto L69
            com.applovin.impl.sdk.a.g r0 = r7.currentAd
            com.applovin.impl.a.a r0 = (com.applovin.impl.p010a.C1129a) r0
            com.applovin.impl.a.j r1 = r0.m8414l()
            if (r1 == 0) goto L51
            int r4 = r1.m8333b()
            if (r4 <= 0) goto L51
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS
            int r1 = r1.m8333b()
            long r5 = (long) r1
            long r4 = r4.toMillis(r5)
            long r2 = r2 + r4
            goto L5b
        L51:
            com.applovin.impl.adview.AppLovinVideoView r1 = r7.videoView
            int r1 = r1.getDuration()
            if (r1 <= 0) goto L5b
            long r4 = (long) r1
            long r2 = r2 + r4
        L5b:
            boolean r1 = r0.m7121ae()
            if (r1 == 0) goto L9b
            long r0 = r0.m7074u()
            int r1 = (int) r0
            if (r1 <= 0) goto L9b
            goto L8a
        L69:
            com.applovin.impl.sdk.a.g r0 = r7.currentAd
            boolean r0 = r0 instanceof com.applovin.impl.sdk.p027a.C1527a
            if (r0 == 0) goto L9b
            com.applovin.impl.sdk.a.g r0 = r7.currentAd
            com.applovin.impl.sdk.a.a r0 = (com.applovin.impl.sdk.p027a.C1527a) r0
            com.applovin.impl.adview.AppLovinVideoView r1 = r7.videoView
            int r1 = r1.getDuration()
            if (r1 <= 0) goto L7d
            long r4 = (long) r1
            long r2 = r2 + r4
        L7d:
            boolean r1 = r0.m7121ae()
            if (r1 == 0) goto L9b
            float r1 = r0.m7229l()
            int r1 = (int) r1
            if (r1 <= 0) goto L93
        L8a:
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS
            long r4 = (long) r1
            long r0 = r0.toMillis(r4)
            long r2 = r2 + r0
            goto L9b
        L93:
            long r0 = r0.m7074u()
            int r1 = (int) r0
            if (r1 <= 0) goto L9b
            goto L8a
        L9b:
            double r0 = (double) r2
            com.applovin.impl.sdk.a.g r2 = r7.currentAd
            int r2 = r2.m7122ad()
            double r2 = (double) r2
            r4 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r2 = r2 / r4
            double r0 = r0 * r2
            long r0 = (long) r0
        La9:
            com.applovin.impl.sdk.r r2 = r7.logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Scheduling report reward in "
            r3.append(r4)
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r4 = r4.toSeconds(r0)
            r3.append(r4)
            java.lang.String r4 = " seconds..."
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "InterActivity"
            r2.m6319b(r4, r3)
            com.applovin.impl.sdk.k r2 = r7.sdk
            com.applovin.impl.adview.p$17 r3 = new com.applovin.impl.adview.p$17
            r3.<init>()
            com.applovin.impl.sdk.utils.m r0 = com.applovin.impl.sdk.utils.C1760m.m6176a(r0, r2, r3)
            r7.f649P = r0
        Ld9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.AbstractActivityC1269p.m8012I():void");
    }

    /* renamed from: J */
    private void m8011J() {
        View view;
        C1710r c1710r;
        StringBuilder sb;
        String str;
        C1268o c1268o = this.f652a;
        if (c1268o == null) {
            exitWithError("AdView was null");
            return;
        }
        c1268o.setAdDisplayListener(new AppLovinAdDisplayListener() { // from class: com.applovin.impl.adview.p.18
            @Override // com.applovin.sdk.AppLovinAdDisplayListener
            public void adDisplayed(AppLovinAd appLovinAd) {
                if (AbstractActivityC1269p.this.f656e) {
                    return;
                }
                AbstractActivityC1269p.this.m7990a(appLovinAd);
            }

            @Override // com.applovin.sdk.AppLovinAdDisplayListener
            public void adHidden(AppLovinAd appLovinAd) {
                AbstractActivityC1269p.this.m7978b(appLovinAd);
            }
        });
        this.f652a.setAdClickListener(new AppLovinAdClickListener() { // from class: com.applovin.impl.adview.p.19
            @Override // com.applovin.sdk.AppLovinAdClickListener
            public void adClicked(AppLovinAd appLovinAd) {
                C1728i.m6229a(AbstractActivityC1269p.this.f653b.m7904e(), appLovinAd);
            }
        });
        this.currentAd = this.f653b.m7908b();
        if (this.f674w.compareAndSet(false, true)) {
            this.sdk.m6594t().trackImpression(this.currentAd);
            this.currentAd.setHasShown(true);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        FrameLayout frameLayout = new FrameLayout(this);
        this.f636C = frameLayout;
        frameLayout.setLayoutParams(layoutParams);
        this.f636C.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.countdownManager = new C1254k(this.f634A, this.sdk);
        m7955j();
        if (this.currentAd.isVideoAd()) {
            this.f663l = this.currentAd.mo7085f();
            if (this.f663l) {
                c1710r = this.logger;
                sb = new StringBuilder();
                str = "Preparing stream for ";
            } else {
                c1710r = this.logger;
                sb = new StringBuilder();
                str = "Preparing cached video playback for ";
            }
            sb.append(str);
            sb.append(this.currentAd.mo7082h());
            c1710r.m6319b("InterActivity", sb.toString());
            C1584d c1584d = this.f654c;
            if (c1584d != null) {
                c1584d.m6920b(this.f663l ? 1L : 0L);
            }
        }
        this.videoMuted = m7957i();
        Uri mo7082h = this.currentAd.mo7082h();
        m7999a(mo7082h);
        if (mo7082h == null) {
            m8012I();
        }
        this.f637D.bringToFront();
        if (m7947n() && (view = this.f638E) != null) {
            view.bringToFront();
        }
        AbstractC1252j abstractC1252j = this.f639F;
        if (abstractC1252j != null) {
            abstractC1252j.bringToFront();
        }
        if (((Boolean) this.sdk.m6656a(C1568b.f1867eD)).booleanValue()) {
            this.f636C.addView(this.f652a);
            this.f652a.setVisibility(4);
        }
        this.f652a.renderAd(this.currentAd);
        if (this.currentAd.hasVideoUrl()) {
            return;
        }
        if (m8013H()) {
            m7966d(this.currentAd);
        }
        showPostitial();
    }

    /* renamed from: K */
    private void m8010K() {
        if (this.videoView != null) {
            boolean z = false;
            try {
                z = this.currentAd.m7127aM();
            } catch (Throwable unused) {
            }
            this.f671t = getVideoPercentViewed();
            if (z) {
                this.videoView.pause();
            } else {
                this.videoView.stopPlayback();
            }
        }
    }

    /* renamed from: L */
    private boolean m8009L() {
        return this.videoMuted;
    }

    /* renamed from: M */
    private void m8008M() {
        AppLovinVideoView appLovinVideoView = this.videoView;
        this.sdk.m6653a((C1570d<C1570d<Integer>>) C1570d.f1949u, (C1570d<Integer>) Integer.valueOf(appLovinVideoView != null ? appLovinVideoView.getCurrentPosition() : 0));
        this.sdk.m6653a((C1570d<C1570d<Boolean>>) C1570d.f1950v, (C1570d<Boolean>) true);
        try {
            this.countdownManager.m8047c();
        } catch (Throwable th) {
            this.logger.m6318b("InterActivity", "Unable to pause countdown timers", th);
        }
        AppLovinVideoView appLovinVideoView2 = this.videoView;
        if (appLovinVideoView2 != null) {
            appLovinVideoView2.pause();
        }
    }

    /* renamed from: N */
    private void m8007N() {
        long max = Math.max(0L, ((Long) this.sdk.m6656a(C1568b.f1763cD)).longValue());
        if (max <= 0) {
            this.sdk.m6588z().m6319b("InterActivity", "Resuming video immediately");
            m8006O();
            return;
        }
        C1710r m6588z = this.sdk.m6588z();
        m6588z.m6319b("InterActivity", "Resuming video with delay of " + max);
        this.f635B.postDelayed(new Runnable() { // from class: com.applovin.impl.adview.p.20
            @Override // java.lang.Runnable
            public void run() {
                AbstractActivityC1269p.this.m8006O();
            }
        }, max);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public void m8006O() {
        AppLovinVideoView appLovinVideoView;
        if (this.postitialWasDisplayed || (appLovinVideoView = this.videoView) == null || appLovinVideoView.isPlaying()) {
            return;
        }
        this.videoView.seekTo(((Integer) this.sdk.m6623b((C1570d<C1570d<Integer>>) C1570d.f1949u, (C1570d<Integer>) Integer.valueOf(this.videoView.getDuration()))).intValue());
        this.videoView.start();
        this.countdownManager.m8054a();
    }

    /* renamed from: P */
    private void m8005P() {
        if (this.f659h) {
            return;
        }
        boolean z = true;
        this.f659h = true;
        try {
            int videoPercentViewed = getVideoPercentViewed();
            if (this.currentAd.hasVideoUrl()) {
                m7989a(this.currentAd, videoPercentViewed, isFullyWatched());
                C1584d c1584d = this.f654c;
                if (c1584d != null) {
                    c1584d.m6918c(videoPercentViewed);
                }
            } else if ((this.currentAd instanceof C1527a) && m8013H()) {
                int m8019E = m8019E();
                C1710r c1710r = this.logger;
                c1710r.m6319b("InterActivity", "Rewarded playable engaged at " + m8019E + " percent");
                AbstractC1537g abstractC1537g = this.currentAd;
                double d = (double) m8019E;
                if (m8019E < this.currentAd.m7157P()) {
                    z = false;
                }
                m7989a(abstractC1537g, d, z);
            }
            this.sdk.m6594t().trackVideoEnd(this.currentAd, TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.f666o), videoPercentViewed, this.f663l);
            this.sdk.m6594t().trackFullScreenAdClosed(this.currentAd, SystemClock.elapsedRealtime() - this.f668q, this.f670s, this.f677z, this.f676y);
        } catch (Throwable th) {
            C1710r c1710r2 = this.logger;
            if (c1710r2 != null) {
                c1710r2.m6318b("InterActivity", "Failed to notify end listener.", th);
            }
        }
    }

    /* renamed from: a */
    private int m8003a(int i) {
        return AppLovinSdkUtils.dpToPx(this, i);
    }

    /* renamed from: a */
    private int m8002a(int i, boolean z) {
        if (z) {
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 9;
            }
            if (i == 2) {
                return 8;
            }
            return i == 3 ? 1 : -1;
        } else if (i == 0) {
            return 1;
        } else {
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 9;
            }
            return i == 3 ? 8 : -1;
        }
    }

    /* renamed from: a */
    private void m8001a(long j, final AbstractC1252j abstractC1252j) {
        this.f635B.postDelayed(new Runnable() { // from class: com.applovin.impl.adview.p.10
            @Override // java.lang.Runnable
            public void run() {
                if (abstractC1252j.equals(AbstractActivityC1269p.this.f637D)) {
                    AbstractActivityC1269p.this.m7949m();
                } else if (abstractC1252j.equals(AbstractActivityC1269p.this.f639F)) {
                    AbstractActivityC1269p.this.m7945o();
                }
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8000a(PointF pointF) {
        if (!this.currentAd.mo7169D() || this.currentAd.mo7080k() == null) {
            m7965e();
            m7963f();
            return;
        }
        this.sdk.m6588z().m6319b("InterActivity", "Clicking through video...");
        clickThroughFromVideo(pointF);
    }

    /* renamed from: a */
    private void m7999a(Uri uri) {
        AppLovinVideoView appLovinVideoView = new AppLovinVideoView(this, this.sdk);
        this.videoView = appLovinVideoView;
        if (uri != null) {
            appLovinVideoView.setOnPreparedListener(new C129027());
            this.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.applovin.impl.adview.p.28
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    AbstractActivityC1269p.this.m7959h();
                }
            });
            this.videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.applovin.impl.adview.p.29
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, final int i, final int i2) {
                    AbstractActivityC1269p.this.f635B.post(new Runnable() { // from class: com.applovin.impl.adview.p.29.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AbstractActivityC1269p abstractActivityC1269p = AbstractActivityC1269p.this;
                            abstractActivityC1269p.handleMediaError("Video view error (" + i + "," + i2 + ")");
                        }
                    });
                    return true;
                }
            });
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            this.videoView.setVideoURI(uri);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
        this.videoView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        this.videoView.setOnTouchListener(new AppLovinTouchToClickListener(this.sdk, this, new AppLovinTouchToClickListener.OnClickListener() { // from class: com.applovin.impl.adview.p.2
            @Override // com.applovin.impl.adview.AppLovinTouchToClickListener.OnClickListener
            public void onClick(View view, PointF pointF) {
                AbstractActivityC1269p.this.m8000a(pointF);
            }
        }));
        this.f636C.addView(this.videoView);
        setContentView(this.f636C);
        m7943p();
        m7927x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7998a(final View view, final boolean z, long j) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(z ? 0.0f : 1.0f, z ? 1.0f : 0.0f);
        alphaAnimation.setDuration(j);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.applovin.impl.adview.p.25
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (z) {
                    return;
                }
                view.setVisibility(4);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }
        });
        view.startAnimation(alphaAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7990a(AppLovinAd appLovinAd) {
        C1728i.m6228a(this.f653b.m7905d(), appLovinAd);
        this.f656e = true;
        this.sdk.m6637ac().m6334a(appLovinAd);
        this.sdk.m6629ak().m6578a(appLovinAd);
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.adview.p.21
            @Override // java.lang.Runnable
            public void run() {
                AbstractActivityC1269p abstractActivityC1269p = AbstractActivityC1269p.this;
                abstractActivityC1269p.m7976b(abstractActivityC1269p.videoMuted);
            }
        }, ((Long) this.sdk.m6656a(C1568b.f1767cH)).longValue());
    }

    /* renamed from: a */
    private void m7989a(AppLovinAd appLovinAd, double d, boolean z) {
        C1728i.m6223a(this.f653b.m7906c(), appLovinAd, d, z);
    }

    /* renamed from: a */
    private void m7988a(final String str) {
        C1304q c1304q = this.f653b;
        if (c1304q != null) {
            final AppLovinAdDisplayListener m7905d = c1304q.m7905d();
            if ((m7905d instanceof InterfaceC1544i) && this.f675x.compareAndSet(false, true)) {
                runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.p.26
                    @Override // java.lang.Runnable
                    public void run() {
                        ((InterfaceC1544i) m7905d).onAdDisplayFailed(str);
                    }
                });
            }
        }
    }

    /* renamed from: a */
    private void m7987a(final String str, long j) {
        if (j >= 0) {
            this.f635B.postDelayed(new Runnable() { // from class: com.applovin.impl.adview.p.22
                @Override // java.lang.Runnable
                public void run() {
                    C1238d m8098s = AbstractActivityC1269p.this.f652a.getAdViewController().m8098s();
                    if (m8098s == null || !StringUtils.isValidString(str)) {
                        return;
                    }
                    m8098s.m8086a(str);
                }
            }, j);
        }
    }

    /* renamed from: a */
    private void m7986a(boolean z) {
        if (!C1724f.m6275d()) {
            Uri m7135aE = z ? this.currentAd.m7135aE() : this.currentAd.m7134aF();
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            this.f642I.setImageURI(m7135aE);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return;
        }
        AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) getDrawable(z ? C1799R.C1801drawable.unmute_to_mute : C1799R.C1801drawable.mute_to_unmute);
        if (animatedVectorDrawable != null) {
            this.f642I.setScaleType(ImageView.ScaleType.FIT_XY);
            this.f642I.setImageDrawable(animatedVectorDrawable);
            animatedVectorDrawable.start();
        }
    }

    /* renamed from: a */
    private boolean m8004a() {
        int identifier = getResources().getIdentifier((String) this.sdk.m6656a(C1568b.f1800co), "bool", "android");
        return identifier > 0 && getResources().getBoolean(identifier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7985b() {
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* renamed from: b */
    private void m7984b(int i) {
        try {
            setRequestedOrientation(i);
        } catch (Throwable th) {
            this.sdk.m6588z().m6318b("InterActivity", "Failed to set requested orientation", th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
        if (r7 == 1) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
        if (r7 == 2) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0061, code lost:
        if (r7 == 1) goto L31;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m7983b(int r7, boolean r8) {
        /*
            r6 = this;
            com.applovin.impl.sdk.k r0 = r6.sdk
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r1 = com.applovin.impl.sdk.p029c.C1568b.f1798cm
            java.lang.Object r0 = r0.m6656a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            com.applovin.impl.adview.q r1 = r6.f653b
            com.applovin.impl.sdk.a.g$b r1 = r1.m7903f()
            com.applovin.impl.sdk.a.g$b r2 = com.applovin.impl.sdk.p027a.AbstractC1537g.EnumC1540b.ACTIVITY_PORTRAIT
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 != r2) goto L3c
            r1 = 9
            if (r8 == 0) goto L2c
            if (r7 == r5) goto L24
            if (r7 == r3) goto L24
            goto L30
        L24:
            if (r0 == 0) goto L64
            if (r7 != r5) goto L30
        L28:
            r6.m7984b(r1)
            goto L64
        L2c:
            if (r7 == 0) goto L34
            if (r7 == r4) goto L34
        L30:
            r6.m7984b(r5)
            goto L64
        L34:
            if (r0 == 0) goto L64
            if (r7 != 0) goto L39
            goto L30
        L39:
            r5 = 9
            goto L30
        L3c:
            com.applovin.impl.adview.q r1 = r6.f653b
            com.applovin.impl.sdk.a.g$b r1 = r1.m7903f()
            com.applovin.impl.sdk.a.g$b r2 = com.applovin.impl.sdk.p027a.AbstractC1537g.EnumC1540b.ACTIVITY_LANDSCAPE
            if (r1 != r2) goto L64
            r1 = 8
            r2 = 0
            if (r8 == 0) goto L57
            if (r7 == 0) goto L50
            if (r7 == r4) goto L50
            goto L5b
        L50:
            if (r0 == 0) goto L64
            if (r7 != r4) goto L55
            goto L28
        L55:
            r1 = 0
            goto L28
        L57:
            if (r7 == r5) goto L5f
            if (r7 == r3) goto L5f
        L5b:
            r6.m7984b(r2)
            goto L64
        L5f:
            if (r0 == 0) goto L64
            if (r7 != r5) goto L28
            goto L55
        L64:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.AbstractActivityC1269p.m7983b(int, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7978b(AppLovinAd appLovinAd) {
        dismiss();
        m7971c(appLovinAd);
    }

    /* renamed from: b */
    private void m7977b(String str) {
        AbstractC1537g abstractC1537g = this.currentAd;
        if (abstractC1537g == null || !abstractC1537g.m7151V()) {
            return;
        }
        m7987a(str, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7976b(boolean z) {
        C1238d m8098s;
        if (!this.currentAd.m7153T() || (m8098s = this.f652a.getAdViewController().m8098s()) == null) {
            return;
        }
        try {
            m8098s.m8086a(z ? "javascript:al_mute();" : "javascript:al_unmute();");
        } catch (Throwable th) {
            this.logger.m6318b("InterActivity", "Unable to forward mute setting to template.", th);
        }
    }

    /* renamed from: c */
    private void m7971c(AppLovinAd appLovinAd) {
        if (this.f657f) {
            return;
        }
        this.f657f = true;
        C1304q c1304q = this.f653b;
        if (c1304q != null) {
            C1728i.m6216b(c1304q.m7905d(), appLovinAd);
        }
        this.sdk.m6637ac().m6330b(appLovinAd);
        this.sdk.m6629ak().m6586a();
    }

    /* renamed from: c */
    private void m7970c(boolean z) {
        this.videoMuted = z;
        MediaPlayer mediaPlayer = this.f643J.get();
        if (mediaPlayer != null) {
            float f = z ? 0 : 1;
            try {
                mediaPlayer.setVolume(f, f);
            } catch (IllegalStateException e) {
                this.logger.m6318b("InterActivity", "Failed to set MediaPlayer muted: " + z, e);
            }
        }
    }

    /* renamed from: c */
    private boolean m7975c() {
        C1662k c1662k;
        if (this.f653b == null || (c1662k = this.sdk) == null || ((Boolean) c1662k.m6656a(C1568b.f1794ci)).booleanValue()) {
            return true;
        }
        if (((Boolean) this.sdk.m6656a(C1568b.f1795cj)).booleanValue() && this.f660i) {
            return true;
        }
        return ((Boolean) this.sdk.m6656a(C1568b.f1796ck)).booleanValue() && this.postitialWasDisplayed;
    }

    /* renamed from: d */
    private void m7969d() {
        int i;
        if (this.sdk == null || !isFinishing()) {
            if (this.currentAd != null && (i = this.f672u) != Integer.MIN_VALUE) {
                m7984b(i);
            }
            finish();
        }
    }

    /* renamed from: d */
    private void m7966d(AppLovinAd appLovinAd) {
        if (this.f658g) {
            return;
        }
        this.f658g = true;
        C1728i.m6224a(this.f653b.m7906c(), appLovinAd);
    }

    /* renamed from: e */
    private void m7965e() {
        C1249h c1249h;
        if (!((Boolean) this.sdk.m6656a(C1568b.f1801cp)).booleanValue() || (c1249h = this.f641H) == null || c1249h.getVisibility() == 8) {
            return;
        }
        m7998a(this.f641H, this.f641H.getVisibility() == 4, 750L);
    }

    /* renamed from: f */
    private void m7963f() {
        C1317v c1317v;
        C1316u m7170C = this.currentAd.m7170C();
        if (m7170C == null || !m7170C.m7885e() || this.postitialWasDisplayed || (c1317v = this.f645L) == null) {
            return;
        }
        m7998a(this.f645L, c1317v.getVisibility() == 4, m7170C.m7884f());
    }

    /* renamed from: g */
    private void m7961g() {
        C1662k c1662k = this.sdk;
        if (c1662k != null) {
            c1662k.m6653a((C1570d<C1570d<Boolean>>) C1570d.f1950v, (C1570d<Boolean>) false);
            this.sdk.m6653a((C1570d<C1570d<Integer>>) C1570d.f1949u, (C1570d<Integer>) 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m7959h() {
        this.f655d = true;
        showPostitial();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public boolean m7957i() {
        return ((Integer) this.sdk.m6623b((C1570d<C1570d<Integer>>) C1570d.f1949u, (C1570d<Integer>) 0)).intValue() > 0 ? this.videoMuted : ((Boolean) this.sdk.m6656a(C1568b.f1807cv)).booleanValue() ? this.sdk.m6598p().isMuted() : ((Boolean) this.sdk.m6656a(C1568b.f1805ct)).booleanValue();
    }

    /* renamed from: j */
    private void m7955j() {
        AbstractC1252j m8056a = AbstractC1252j.m8056a(this.currentAd.m7073v(), this);
        this.f637D = m8056a;
        m8056a.setVisibility(8);
        this.f637D.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.adview.p.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AbstractActivityC1269p.this.m8025B();
            }
        });
        int m8003a = m8003a(this.currentAd.m7149X());
        int i = (this.currentAd.m7125aa() ? 3 : 5) | 48;
        int i2 = (this.currentAd.m7124ab() ? 3 : 5) | 48;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(m8003a, m8003a, i | 48);
        this.f637D.mo7900a(m8003a);
        int m8003a2 = m8003a(this.currentAd.m7148Y());
        int m8003a3 = m8003a(this.currentAd.m7147Z());
        layoutParams.setMargins(m8003a3, m8003a2, m8003a3, m8003a2);
        this.f636C.addView(this.f637D, layoutParams);
        AbstractC1252j m8056a2 = AbstractC1252j.m8056a(this.currentAd.m7072w(), this);
        this.f639F = m8056a2;
        m8056a2.setVisibility(8);
        this.f639F.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.adview.p.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AbstractActivityC1269p.this.m8027A();
            }
        });
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(m8003a, m8003a, i2);
        layoutParams2.setMargins(m8003a3, m8003a2, m8003a3, m8003a2);
        this.f639F.mo7900a(m8003a);
        this.f636C.addView(this.f639F, layoutParams2);
        this.f639F.bringToFront();
        if (m7947n()) {
            int m8003a4 = m8003a(((Integer) this.sdk.m6656a(C1568b.f1708bA)).intValue());
            View view = new View(this);
            this.f638E = view;
            view.setBackgroundColor(0);
            this.f638E.setVisibility(8);
            View view2 = new View(this);
            this.f640G = view2;
            view2.setBackgroundColor(0);
            this.f640G.setVisibility(8);
            int i3 = m8003a + m8003a4;
            int m8003a5 = m8003a2 - m8003a(5);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i3, i3, i);
            layoutParams3.setMargins(m8003a5, m8003a5, m8003a5, m8003a5);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(i3, i3, i2);
            layoutParams4.setMargins(m8003a5, m8003a5, m8003a5, m8003a5);
            this.f638E.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.adview.p.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    AbstractActivityC1269p.this.f637D.performClick();
                }
            });
            this.f640G.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.adview.p.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    AbstractActivityC1269p.this.f639F.performClick();
                }
            });
            this.f636C.addView(this.f638E, layoutParams3);
            this.f638E.bringToFront();
            this.f636C.addView(this.f640G, layoutParams4);
            this.f640G.bringToFront();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m7953k() {
        if (this.f642I == null) {
            try {
                this.videoMuted = m7957i();
                this.f642I = new ImageView(this);
                if (m7951l()) {
                    this.sdk.m6588z().m6319b("InterActivity", "Mute button should be hidden");
                    return;
                }
                int m8003a = m8003a(((Integer) this.sdk.m6656a(C1568b.f1808cw)).intValue());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(m8003a, m8003a, ((Integer) this.sdk.m6656a(C1568b.f1810cy)).intValue());
                this.f642I.setScaleType(ImageView.ScaleType.FIT_CENTER);
                int m8003a2 = m8003a(((Integer) this.sdk.m6656a(C1568b.f1809cx)).intValue());
                layoutParams.setMargins(m8003a2, m8003a2, m8003a2, m8003a2);
                if ((this.videoMuted ? this.currentAd.m7135aE() : this.currentAd.m7134aF()) == null) {
                    this.sdk.m6588z().m6314e("InterActivity", "Attempting to add mute button but could not find uri");
                    return;
                }
                C1710r m6588z = this.sdk.m6588z();
                m6588z.m6319b("InterActivity", "Added mute button with params: " + layoutParams);
                m7986a(this.videoMuted);
                this.f642I.setClickable(true);
                this.f642I.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.adview.p.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AbstractActivityC1269p.this.toggleMute();
                    }
                });
                this.f636C.addView(this.f642I, layoutParams);
                this.f642I.bringToFront();
            } catch (Exception e) {
                this.sdk.m6588z().m6321a("InterActivity", "Failed to attach mute button", e);
            }
        }
    }

    /* renamed from: l */
    private boolean m7951l() {
        if (((Boolean) this.sdk.m6656a(C1568b.f1803cr)).booleanValue()) {
            if (!((Boolean) this.sdk.m6656a(C1568b.f1804cs)).booleanValue() || m7957i()) {
                return false;
            }
            return !((Boolean) this.sdk.m6656a(C1568b.f1806cu)).booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m7949m() {
        runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.p.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AbstractActivityC1269p.this.f660i) {
                        AbstractActivityC1269p.this.f637D.setVisibility(0);
                        return;
                    }
                    AbstractActivityC1269p.this.f668q = SystemClock.elapsedRealtime();
                    AbstractActivityC1269p.this.f660i = true;
                    if (AbstractActivityC1269p.this.m7947n() && AbstractActivityC1269p.this.f638E != null) {
                        AbstractActivityC1269p.this.f638E.setVisibility(0);
                        AbstractActivityC1269p.this.f638E.bringToFront();
                    }
                    AbstractActivityC1269p.this.f637D.setVisibility(0);
                    AbstractActivityC1269p.this.f637D.bringToFront();
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(400L);
                    alphaAnimation.setRepeatCount(0);
                    AbstractActivityC1269p.this.f637D.startAnimation(alphaAnimation);
                } catch (Throwable unused) {
                    AbstractActivityC1269p.this.dismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public boolean m7947n() {
        return ((Integer) this.sdk.m6656a(C1568b.f1708bA)).intValue() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m7945o() {
        runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.p.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AbstractActivityC1269p.this.f661j || AbstractActivityC1269p.this.f639F == null) {
                        return;
                    }
                    AbstractActivityC1269p.this.f670s = -1L;
                    AbstractActivityC1269p.this.f669r = SystemClock.elapsedRealtime();
                    AbstractActivityC1269p.this.f661j = true;
                    AbstractActivityC1269p.this.f639F.setVisibility(0);
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(400L);
                    alphaAnimation.setRepeatCount(0);
                    AbstractActivityC1269p.this.f639F.startAnimation(alphaAnimation);
                    if (!AbstractActivityC1269p.this.m7947n() || AbstractActivityC1269p.this.f640G == null) {
                        return;
                    }
                    AbstractActivityC1269p.this.f640G.setVisibility(0);
                    AbstractActivityC1269p.this.f640G.bringToFront();
                } catch (Throwable th) {
                    C1710r c1710r = AbstractActivityC1269p.this.logger;
                    c1710r.m6315d("InterActivity", "Unable to show skip button: " + th);
                }
            }
        });
    }

    /* renamed from: p */
    private void m7943p() {
        AbstractC1252j abstractC1252j;
        if (this.currentAd.m7076s() >= 0) {
            if (!this.f662k || (abstractC1252j = this.f639F) == null) {
                abstractC1252j = this.f637D;
            }
            m8001a(Utils.secondsToMillisLong((float) this.currentAd.m7076s()), abstractC1252j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m7941q() {
        boolean z = ((Boolean) this.sdk.m6656a(C1568b.f1793ch)).booleanValue() && m7935t() > 0;
        if (this.f641H == null && z) {
            this.f641H = new C1249h(this);
            int m7166G = this.currentAd.m7166G();
            this.f641H.setTextColor(m7166G);
            this.f641H.setTextSize(((Integer) this.sdk.m6656a(C1568b.f1792cg)).intValue());
            this.f641H.setFinishedStrokeColor(m7166G);
            this.f641H.setFinishedStrokeWidth(((Integer) this.sdk.m6656a(C1568b.f1791cf)).intValue());
            this.f641H.setMax(m7935t());
            this.f641H.setProgress(m7935t());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(m8003a(((Integer) this.sdk.m6656a(C1568b.f1790ce)).intValue()), m8003a(((Integer) this.sdk.m6656a(C1568b.f1790ce)).intValue()), ((Integer) this.sdk.m6656a(C1568b.f1789cd)).intValue());
            int m8003a = m8003a(((Integer) this.sdk.m6656a(C1568b.f1788cc)).intValue());
            layoutParams.setMargins(m8003a, m8003a, m8003a, m8003a);
            this.f636C.addView(this.f641H, layoutParams);
            this.f641H.bringToFront();
            this.f641H.setVisibility(0);
            final long m7937s = m7937s();
            this.countdownManager.m8050a("COUNTDOWN_CLOCK", 1000L, new C1254k.InterfaceC1256a() { // from class: com.applovin.impl.adview.p.11
                @Override // com.applovin.impl.adview.C1254k.InterfaceC1256a
                /* renamed from: a */
                public void mo7891a() {
                    if (AbstractActivityC1269p.this.f641H != null) {
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(m7937s - AbstractActivityC1269p.this.videoView.getCurrentPosition());
                        if (seconds <= 0) {
                            AbstractActivityC1269p.this.f641H.setVisibility(8);
                            AbstractActivityC1269p.this.f665n = true;
                        } else if (AbstractActivityC1269p.this.m7939r()) {
                            AbstractActivityC1269p.this.f641H.setProgress((int) seconds);
                        }
                    }
                }

                @Override // com.applovin.impl.adview.C1254k.InterfaceC1256a
                /* renamed from: b */
                public boolean mo7890b() {
                    return AbstractActivityC1269p.this.m7939r();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public boolean m7939r() {
        return (this.f665n || this.postitialWasDisplayed || !this.videoView.isPlaying()) ? false : true;
    }

    /* renamed from: s */
    private long m7937s() {
        return TimeUnit.SECONDS.toMillis(m7935t());
    }

    /* renamed from: t */
    private int m7935t() {
        int m7167F = this.currentAd.m7167F();
        return (m7167F <= 0 && ((Boolean) this.sdk.m6656a(C1568b.f1766cG)).booleanValue()) ? this.computedLengthSeconds + 1 : m7167F;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void m7933u() {
        if (this.f646M == null && this.currentAd.m7159N()) {
            this.logger.m6317c("InterActivity", "Attaching video progress bar...");
            ProgressBar progressBar = new ProgressBar(this, null, 16842872);
            this.f646M = progressBar;
            progressBar.setMax(((Integer) this.sdk.m6656a(C1568b.f1761cB)).intValue());
            this.f646M.setPadding(0, 0, 0, 0);
            if (C1724f.m6275d()) {
                try {
                    this.f646M.setProgressTintList(ColorStateList.valueOf(this.currentAd.m7158O()));
                } catch (Throwable th) {
                    this.logger.m6318b("InterActivity", "Unable to update progress bar color.", th);
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.videoView.getWidth(), 20, 80);
            layoutParams.setMargins(0, 0, 0, ((Integer) this.sdk.m6656a(C1568b.f1762cC)).intValue());
            this.f636C.addView(this.f646M, layoutParams);
            this.f646M.bringToFront();
            this.countdownManager.m8050a("PROGRESS_BAR", ((Long) this.sdk.m6656a(C1568b.f1760cA)).longValue(), new C1254k.InterfaceC1256a() { // from class: com.applovin.impl.adview.p.13
                @Override // com.applovin.impl.adview.C1254k.InterfaceC1256a
                /* renamed from: a */
                public void mo7891a() {
                    if (AbstractActivityC1269p.this.f646M != null) {
                        if (!AbstractActivityC1269p.this.shouldContinueFullLengthVideoCountdown()) {
                            AbstractActivityC1269p.this.f646M.setVisibility(8);
                            return;
                        }
                        AbstractActivityC1269p.this.f646M.setProgress((int) ((AbstractActivityC1269p.this.videoView.getCurrentPosition() / AbstractActivityC1269p.this.videoView.getDuration()) * ((Integer) AbstractActivityC1269p.this.sdk.m6656a(C1568b.f1761cB)).intValue()));
                    }
                }

                @Override // com.applovin.impl.adview.C1254k.InterfaceC1256a
                /* renamed from: b */
                public boolean mo7890b() {
                    return AbstractActivityC1269p.this.shouldContinueFullLengthVideoCountdown();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public void m7931v() {
        final C1316u m7170C = this.currentAd.m7170C();
        if (StringUtils.isValidString(this.currentAd.m7171B()) && m7170C != null && this.f645L == null) {
            this.logger.m6317c("InterActivity", "Attaching video button...");
            this.f645L = m7929w();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) ((m7170C.m7889a() / 100.0d) * this.videoView.getWidth()), (int) ((m7170C.m7888b() / 100.0d) * this.videoView.getHeight()), m7170C.m7886d());
            int m8003a = m8003a(m7170C.m7887c());
            layoutParams.setMargins(m8003a, m8003a, m8003a, m8003a);
            this.f636C.addView(this.f645L, layoutParams);
            this.f645L.bringToFront();
            if (m7170C.m7881i() > 0.0f) {
                this.f645L.setVisibility(4);
                this.f635B.postDelayed(new Runnable() { // from class: com.applovin.impl.adview.p.14
                    @Override // java.lang.Runnable
                    public void run() {
                        long m7883g = m7170C.m7883g();
                        AbstractActivityC1269p abstractActivityC1269p = AbstractActivityC1269p.this;
                        abstractActivityC1269p.m7998a((View) abstractActivityC1269p.f645L, true, m7883g);
                        AbstractActivityC1269p.this.f645L.bringToFront();
                    }
                }, Utils.secondsToMillisLong(m7170C.m7881i()));
            }
            if (m7170C.m7880j() > 0.0f) {
                this.f635B.postDelayed(new Runnable() { // from class: com.applovin.impl.adview.p.15
                    @Override // java.lang.Runnable
                    public void run() {
                        long m7882h = m7170C.m7882h();
                        AbstractActivityC1269p abstractActivityC1269p = AbstractActivityC1269p.this;
                        abstractActivityC1269p.m7998a((View) abstractActivityC1269p.f645L, false, m7882h);
                    }
                }, Utils.secondsToMillisLong(m7170C.m7880j()));
            }
        }
    }

    /* renamed from: w */
    private C1317v m7929w() {
        C1710r c1710r = this.logger;
        c1710r.m6319b("InterActivity", "Create video button with HTML = " + this.currentAd.m7171B());
        C1318w c1318w = new C1318w(this.sdk);
        this.f647N = new C1318w.InterfaceC1319a() { // from class: com.applovin.impl.adview.p.16
            @Override // com.applovin.impl.adview.C1318w.InterfaceC1319a
            /* renamed from: a */
            public void mo7876a(C1317v c1317v) {
                AbstractActivityC1269p.this.logger.m6319b("InterActivity", "Clicking through from video button...");
                AbstractActivityC1269p.this.clickThroughFromVideo(c1317v.getAndClearLastClickLocation());
            }

            @Override // com.applovin.impl.adview.C1318w.InterfaceC1319a
            /* renamed from: b */
            public void mo7875b(C1317v c1317v) {
                AbstractActivityC1269p.this.logger.m6319b("InterActivity", "Closing ad from video button...");
                AbstractActivityC1269p.this.dismiss();
            }

            @Override // com.applovin.impl.adview.C1318w.InterfaceC1319a
            /* renamed from: c */
            public void mo7874c(C1317v c1317v) {
                AbstractActivityC1269p.this.logger.m6319b("InterActivity", "Skipping video from video button...");
                AbstractActivityC1269p.this.skipVideo();
            }
        };
        c1318w.m7877a(new WeakReference<>(this.f647N));
        C1317v c1317v = new C1317v(c1318w, getApplicationContext());
        c1317v.m7879a(this.currentAd.m7171B());
        return c1317v;
    }

    /* renamed from: x */
    private void m7927x() {
        if (this.f663l) {
            C1157a c1157a = new C1157a(this, ((Integer) this.sdk.m6656a(C1568b.f1765cF)).intValue(), 16842874);
            this.f648O = c1157a;
            c1157a.setColor(Color.parseColor("#75FFFFFF"));
            this.f648O.setBackgroundColor(Color.parseColor("#00000000"));
            this.f648O.setVisibility(8);
            this.f636C.addView(this.f648O, new FrameLayout.LayoutParams(-1, -1, 17));
            this.f636C.bringChildToFront(this.f648O);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public void m7925y() {
        C1157a c1157a = this.f648O;
        if (c1157a != null) {
            c1157a.m8289a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public void m7923z() {
        C1157a c1157a = this.f648O;
        if (c1157a != null) {
            c1157a.m8288b();
        }
    }

    public void clickThroughFromVideo(PointF pointF) {
        try {
            this.sdk.m6594t().trackAndLaunchVideoClick(this.currentAd, this.f652a, this.currentAd.mo7080k(), pointF);
            C1728i.m6229a(this.f653b.m7904e(), this.currentAd);
            C1584d c1584d = this.f654c;
            if (c1584d != null) {
                c1584d.m6921b();
            }
        } catch (Throwable th) {
            this.sdk.m6588z().m6318b("InterActivity", "Encountered error while clicking through video.", th);
        }
    }

    public void continueVideo() {
        m8006O();
    }

    @Override // com.applovin.impl.adview.InterfaceC1258l
    public void dismiss() {
        long currentTimeMillis = System.currentTimeMillis() - this.f666o;
        C1710r.m6313f("InterActivity", "Dismissing ad after " + currentTimeMillis + " milliseconds elapsed");
        C1662k c1662k = this.sdk;
        if (c1662k != null) {
            if (((Boolean) c1662k.m6656a(C1568b.f1802cq)).booleanValue()) {
                stopService(new Intent(getBaseContext(), AppKilledService.class));
                this.sdk.m6631ai().unregisterReceiver(this.f651R);
            }
            this.sdk.m6632ah().m6734b(this);
        }
        m7961g();
        m8005P();
        if (this.f653b != null) {
            if (this.currentAd != null) {
                m7971c(this.currentAd);
                C1584d c1584d = this.f654c;
                if (c1584d != null) {
                    c1584d.m6919c();
                    this.f654c = null;
                }
                m7987a("javascript:al_onPoststitialDismiss();", this.currentAd.m7154S());
            }
            this.f653b.m7902g();
        }
        lastKnownWrapper = null;
        m7969d();
    }

    public void exitWithError(String str) {
        m7988a(str);
        try {
            C1710r.m6316c("InterActivity", "Failed to properly render an Interstitial Activity, due to error: " + str, new Throwable("Initialized = " + C1304q.f726b + "; CleanedUp = " + C1304q.f727c));
            m7971c(new C1543h(this.currentAd != null ? this.currentAd.getAdZone() : C1531d.m7215a(str), this.sdk));
        } catch (Exception e) {
            C1710r.m6316c("InterActivity", "Failed to show a video ad due to error:", e);
        }
        dismiss();
    }

    public boolean getPostitialWasDisplayed() {
        return this.postitialWasDisplayed;
    }

    public int getVideoPercentViewed() {
        if (this.f655d) {
            return 100;
        }
        AppLovinVideoView appLovinVideoView = this.videoView;
        if (appLovinVideoView != null) {
            int duration = appLovinVideoView.getDuration();
            return duration > 0 ? (int) ((this.videoView.getCurrentPosition() / duration) * 100.0d) : this.f671t;
        }
        this.logger.m6314e("InterActivity", "No video view detected on video end");
        return 0;
    }

    public void handleMediaError(String str) {
        this.logger.m6314e("InterActivity", str);
        if (this.f673v.compareAndSet(false, true)) {
            m7988a(str);
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isFullyWatched() {
        return getVideoPercentViewed() >= this.currentAd.m7157P();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isVastAd() {
        return this.currentAd instanceof C1129a;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        AbstractC1252j abstractC1252j;
        AbstractC1252j abstractC1252j2;
        if (this.currentAd != null) {
            if (this.currentAd.m7137aC() && !this.postitialWasDisplayed) {
                return;
            }
            if (this.currentAd.m7136aD() && this.postitialWasDisplayed) {
                return;
            }
        }
        if (m7975c()) {
            this.logger.m6319b("InterActivity", "Back button was pressed; forwarding to Android for handling...");
        } else {
            try {
                if (this.postitialWasDisplayed || !this.f662k || (abstractC1252j2 = this.f639F) == null || abstractC1252j2.getVisibility() != 0 || this.f639F.getAlpha() <= 0.0f) {
                    AbstractC1252j abstractC1252j3 = this.f637D;
                    if (abstractC1252j3 == null || abstractC1252j3.getVisibility() != 0 || this.f637D.getAlpha() <= 0.0f) {
                        this.logger.m6319b("InterActivity", "Back button was pressed, but was not eligible for dismissal.");
                        m7977b("javascript:al_onBackPressed();");
                        return;
                    }
                    this.logger.m6319b("InterActivity", "Back button was pressed; forwarding as a click to close button.");
                    abstractC1252j = this.f637D;
                } else {
                    this.logger.m6319b("InterActivity", "Back button was pressed; forwarding as a click to skip button.");
                    abstractC1252j = this.f639F;
                }
                abstractC1252j.performClick();
                m7977b("javascript:al_onBackPressed();");
                return;
            } catch (Exception unused) {
            }
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01ce  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r10) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.AbstractActivityC1269p.onCreate(android.os.Bundle):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005a, code lost:
        if (r4.currentAd != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
        if (r4.currentAd == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006d, code lost:
        m8005P();
        m7971c(r4.currentAd);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0075, code lost:
        super.onDestroy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0078, code lost:
        return;
     */
    /* JADX WARN: Finally extract failed */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onDestroy() {
        /*
            r4 = this;
            com.applovin.impl.adview.o r0 = r4.f652a     // Catch: java.lang.Throwable -> L5d
            r1 = 0
            if (r0 == 0) goto L1b
            android.view.ViewParent r0 = r0.getParent()     // Catch: java.lang.Throwable -> L5d
            boolean r2 = r0 instanceof android.view.ViewGroup     // Catch: java.lang.Throwable -> L5d
            if (r2 == 0) goto L14
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch: java.lang.Throwable -> L5d
            com.applovin.impl.adview.o r2 = r4.f652a     // Catch: java.lang.Throwable -> L5d
            r0.removeView(r2)     // Catch: java.lang.Throwable -> L5d
        L14:
            com.applovin.impl.adview.o r0 = r4.f652a     // Catch: java.lang.Throwable -> L5d
            r0.destroy()     // Catch: java.lang.Throwable -> L5d
            r4.f652a = r1     // Catch: java.lang.Throwable -> L5d
        L1b:
            com.applovin.impl.adview.AppLovinVideoView r0 = r4.videoView     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L27
            r0.pause()     // Catch: java.lang.Throwable -> L5d
            com.applovin.impl.adview.AppLovinVideoView r0 = r4.videoView     // Catch: java.lang.Throwable -> L5d
            r0.stopPlayback()     // Catch: java.lang.Throwable -> L5d
        L27:
            com.applovin.impl.sdk.k r0 = r4.sdk     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L43
            java.lang.ref.WeakReference<android.media.MediaPlayer> r0 = r4.f643J     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L5d
            android.media.MediaPlayer r0 = (android.media.MediaPlayer) r0     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L38
            r0.release()     // Catch: java.lang.Throwable -> L5d
        L38:
            com.applovin.impl.sdk.k r0 = r4.sdk     // Catch: java.lang.Throwable -> L5d
            com.applovin.impl.sdk.a r0 = r0.m6636ad()     // Catch: java.lang.Throwable -> L5d
            com.applovin.impl.sdk.utils.a r2 = r4.f650Q     // Catch: java.lang.Throwable -> L5d
            r0.m7237b(r2)     // Catch: java.lang.Throwable -> L5d
        L43:
            com.applovin.impl.adview.k r0 = r4.countdownManager     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L4a
            r0.m8049b()     // Catch: java.lang.Throwable -> L5d
        L4a:
            android.os.Handler r0 = r4.f635B     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L51
            r0.removeCallbacksAndMessages(r1)     // Catch: java.lang.Throwable -> L5d
        L51:
            android.os.Handler r0 = r4.f634A     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L58
            r0.removeCallbacksAndMessages(r1)     // Catch: java.lang.Throwable -> L5d
        L58:
            com.applovin.impl.sdk.a.g r0 = r4.currentAd
            if (r0 == 0) goto L75
            goto L6d
        L5d:
            r0 = move-exception
            com.applovin.impl.sdk.r r1 = r4.logger     // Catch: java.lang.Throwable -> L79
            if (r1 == 0) goto L69
            java.lang.String r2 = "InterActivity"
            java.lang.String r3 = "Unable to destroy video view"
            r1.m6321a(r2, r3, r0)     // Catch: java.lang.Throwable -> L79
        L69:
            com.applovin.impl.sdk.a.g r0 = r4.currentAd
            if (r0 == 0) goto L75
        L6d:
            r4.m8005P()
            com.applovin.impl.sdk.a.g r0 = r4.currentAd
            r4.m7971c(r0)
        L75:
            super.onDestroy()
            return
        L79:
            r0 = move-exception
            com.applovin.impl.sdk.a.g r1 = r4.currentAd
            if (r1 == 0) goto L86
            r4.m8005P()
            com.applovin.impl.sdk.a.g r1 = r4.currentAd
            r4.m7971c(r1)
        L86:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.AbstractActivityC1269p.onDestroy():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.logger.m6319b("InterActivity", "App paused...");
        this.f667p = System.currentTimeMillis();
        if (this.postitialWasDisplayed) {
            m8008M();
        }
        this.f644K.m7034a();
        pauseReportRewardTask();
        m7977b("javascript:al_onAppPaused();");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0065, code lost:
        if (r0 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0095, code lost:
        if (r2 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0097, code lost:
        m8001a(0, r0);
     */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onResume() {
        /*
            r5 = this;
            super.onResume()     // Catch: java.lang.IllegalArgumentException -> Lb7
            com.applovin.impl.sdk.r r0 = r5.logger
            java.lang.String r1 = "InterActivity"
            java.lang.String r2 = "App resumed..."
            r0.m6319b(r1, r2)
            boolean r0 = r5.f664m
            if (r0 != 0) goto L9e
            com.applovin.impl.sdk.d.d r0 = r5.f654c
            if (r0 == 0) goto L1e
            long r1 = java.lang.System.currentTimeMillis()
            long r3 = r5.f667p
            long r1 = r1 - r3
            r0.m6916d(r1)
        L1e:
            com.applovin.impl.sdk.k r0 = r5.sdk
            com.applovin.impl.sdk.c.d<java.lang.Boolean> r1 = com.applovin.impl.sdk.p029c.C1570d.f1950v
            r2 = 0
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            java.lang.Object r0 = r0.m6623b(r1, r3)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r3 = 0
            if (r0 == 0) goto L68
            com.applovin.impl.sdk.b.b r0 = r5.f644K
            boolean r0 = r0.m7025d()
            if (r0 != 0) goto L68
            boolean r0 = r5.postitialWasDisplayed
            if (r0 != 0) goto L68
            r5.m8007N()
            r5.m7925y()
            com.applovin.impl.sdk.a.g r0 = r5.currentAd
            if (r0 == 0) goto L9a
            com.applovin.impl.sdk.k r0 = r5.sdk
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r1 = com.applovin.impl.sdk.p029c.C1568b.f1787cb
            java.lang.Object r0 = r0.m6656a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L9a
            boolean r0 = r5.postitialWasDisplayed
            if (r0 != 0) goto L9a
            boolean r0 = r5.f662k
            if (r0 == 0) goto L9a
            com.applovin.impl.adview.j r0 = r5.f639F
            if (r0 == 0) goto L9a
            goto L97
        L68:
            com.applovin.impl.sdk.a.g r0 = r5.currentAd
            boolean r0 = r0 instanceof com.applovin.impl.sdk.p027a.C1527a
            if (r0 == 0) goto L79
            com.applovin.impl.sdk.a.g r0 = r5.currentAd
            com.applovin.impl.sdk.a.a r0 = (com.applovin.impl.sdk.p027a.C1527a) r0
            boolean r0 = r0.m7228m()
            if (r0 == 0) goto L79
            r2 = 1
        L79:
            com.applovin.impl.sdk.a.g r0 = r5.currentAd
            if (r0 == 0) goto L9a
            com.applovin.impl.sdk.k r0 = r5.sdk
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r1 = com.applovin.impl.sdk.p029c.C1568b.f1787cb
            java.lang.Object r0 = r0.m6656a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L9a
            boolean r0 = r5.postitialWasDisplayed
            if (r0 == 0) goto L9a
            com.applovin.impl.adview.j r0 = r5.f637D
            if (r0 == 0) goto L9a
            if (r2 != 0) goto L9a
        L97:
            r5.m8001a(r3, r0)
        L9a:
            r5.resumeReportRewardTask()
            goto Lb1
        L9e:
            com.applovin.impl.sdk.b.b r0 = r5.f644K
            boolean r0 = r0.m7025d()
            if (r0 != 0) goto Lb1
            boolean r0 = r5.postitialWasDisplayed
            if (r0 != 0) goto Lb1
            com.applovin.impl.sdk.a.g r0 = r5.currentAd
            if (r0 == 0) goto Lb1
            r5.m7925y()
        Lb1:
            java.lang.String r0 = "javascript:al_onAppResumed();"
            r5.m7977b(r0)
            return
        Lb7:
            java.lang.String r0 = "Error was encountered in onResume()."
            r5.exitWithError(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.AbstractActivityC1269p.onResume():void");
    }

    @Override // com.applovin.impl.sdk.C1644f.InterfaceC1646a
    public void onRingerModeChanged(int i) {
        String str;
        if (this.f676y != C1644f.f2195a) {
            this.f677z = true;
        }
        C1238d m8098s = this.f652a.getAdViewController().m8098s();
        if (m8098s != null) {
            if (!C1644f.m6738a(i) || C1644f.m6738a(this.f676y)) {
                str = i == 2 ? "javascript:al_muteSwitchOff();" : "javascript:al_muteSwitchOff();";
            } else {
                str = "javascript:al_muteSwitchOn();";
            }
            m8098s.m8086a(str);
        }
        this.f676y = i;
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("instance_impression_tracked", this.f674w.get());
        bundle.putInt("original_orientation", this.f672u);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        String str;
        super.onWindowFocusChanged(z);
        C1662k c1662k = this.sdk;
        if (z) {
            if (c1662k != null) {
                this.logger.m6319b("InterActivity", "Window gained focus");
                try {
                    if (C1724f.m6276c() && ((Boolean) this.sdk.m6656a(C1568b.f1811cz)).booleanValue() && m8004a()) {
                        m7985b();
                        this.f635B.postDelayed(new Runnable() { // from class: com.applovin.impl.adview.p.24
                            @Override // java.lang.Runnable
                            public void run() {
                                AbstractActivityC1269p.this.m7985b();
                            }
                        }, 2500L);
                    } else {
                        getWindow().setFlags(1024, 1024);
                    }
                    if (!this.postitialWasDisplayed) {
                        m8007N();
                        resumeReportRewardTask();
                    }
                } catch (Throwable th) {
                    this.logger.m6318b("InterActivity", "Setting window flags failed.", th);
                }
                this.f664m = false;
                m7977b("javascript:al_onWindowFocusChanged( " + z + " );");
            }
            str = "Window gained focus. SDK is null.";
        } else if (c1662k != null) {
            this.logger.m6319b("InterActivity", "Window lost focus");
            if (!this.postitialWasDisplayed) {
                m8008M();
                pauseReportRewardTask();
            }
            this.f664m = false;
            m7977b("javascript:al_onWindowFocusChanged( " + z + " );");
        } else {
            str = "Window lost focus. SDK is null.";
        }
        C1710r.m6313f("InterActivity", str);
        this.f664m = false;
        m7977b("javascript:al_onWindowFocusChanged( " + z + " );");
    }

    public void pauseReportRewardTask() {
        C1760m c1760m = this.f649P;
        if (c1760m != null) {
            c1760m.m6173b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void playVideo() {
        m7966d(this.currentAd);
        this.videoView.start();
        this.countdownManager.m8054a();
    }

    public void resumeReportRewardTask() {
        C1760m c1760m = this.f649P;
        if (c1760m != null) {
            c1760m.m6171c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean shouldContinueFullLengthVideoCountdown() {
        return (this.f655d || this.postitialWasDisplayed) ? false : true;
    }

    public void showPostitial() {
        View view;
        try {
            m8010K();
            C1268o c1268o = this.f652a;
            if (c1268o != null) {
                ViewParent parent = c1268o.getParent();
                if ((parent instanceof ViewGroup) && (!((Boolean) this.sdk.m6656a(C1568b.f1867eD)).booleanValue() || parent != this.f636C)) {
                    ((ViewGroup) parent).removeView(this.f652a);
                }
                FrameLayout frameLayout = ((Boolean) this.sdk.m6656a(C1568b.f1867eD)).booleanValue() ? this.f636C : new FrameLayout(this);
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.setBackgroundColor(this.currentAd.m7165H());
                if (((Boolean) this.sdk.m6656a(C1568b.f1867eD)).booleanValue()) {
                    this.f652a.setVisibility(0);
                } else {
                    frameLayout.addView(this.f652a);
                }
                if (this.f636C != null) {
                    if (((Boolean) this.sdk.m6656a(C1568b.f1867eD)).booleanValue()) {
                        C1719b.m6291a(this.f636C, this.f652a);
                    } else {
                        this.f636C.removeAllViewsInLayout();
                    }
                }
                if (m7947n() && (view = this.f638E) != null) {
                    if (view.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.f638E.getParent()).removeView(this.f638E);
                    }
                    frameLayout.addView(this.f638E);
                    this.f638E.bringToFront();
                }
                AbstractC1252j abstractC1252j = this.f637D;
                if (abstractC1252j != null) {
                    ViewParent parent2 = abstractC1252j.getParent();
                    if (parent2 instanceof ViewGroup) {
                        ((ViewGroup) parent2).removeView(this.f637D);
                    }
                    frameLayout.addView(this.f637D);
                    this.f637D.bringToFront();
                }
                if (!((Boolean) this.sdk.m6656a(C1568b.f1867eD)).booleanValue()) {
                    setContentView(frameLayout);
                }
                if (((Boolean) this.sdk.m6656a(C1568b.f1864eA)).booleanValue()) {
                    this.f652a.setVisibility(4);
                    this.f652a.setVisibility(0);
                }
                m7987a("javascript:al_onPoststitialShow();", this.currentAd.m7155R());
            }
            if ((this.currentAd instanceof C1527a) && ((C1527a) this.currentAd).m7228m()) {
                this.logger.m6319b("InterActivity", "Skip showing of close button");
            } else if (this.currentAd.m7074u() >= 0) {
                m8001a(Utils.secondsToMillisLong((float) this.currentAd.m7074u()), this.f637D);
            } else if (this.currentAd.m7074u() == -2) {
                this.f637D.setVisibility(0);
            } else {
                m8001a(0L, this.f637D);
            }
            this.postitialWasDisplayed = true;
        } catch (Throwable th) {
            this.logger.m6318b("InterActivity", "Encountered error while showing postitial. Dismissing...", th);
            dismiss();
        }
    }

    public void skipVideo() {
        this.f670s = SystemClock.elapsedRealtime() - this.f669r;
        C1584d c1584d = this.f654c;
        if (c1584d != null) {
            c1584d.m6914f();
        }
        if (this.currentAd.m7071x()) {
            dismiss();
        } else {
            showPostitial();
        }
    }

    public void toggleMute() {
        boolean z = !m8009L();
        try {
            m7970c(z);
            m7986a(z);
            m7976b(z);
        } catch (Throwable th) {
            this.logger.m6318b("InterActivity", "Unable to set volume to " + z, th);
        }
    }
}
