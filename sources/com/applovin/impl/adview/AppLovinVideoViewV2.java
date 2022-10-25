package com.applovin.impl.adview;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.MediaController;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.impl.sdk.p031e.C1642y;
import java.util.Map;

/* loaded from: classes.dex */
public class AppLovinVideoViewV2 extends SurfaceView implements MediaController.MediaPlayerControl {

    /* renamed from: A */
    private final MediaPlayer.OnCompletionListener f292A;

    /* renamed from: B */
    private final MediaPlayer.OnInfoListener f293B;

    /* renamed from: C */
    private final MediaPlayer.OnErrorListener f294C;

    /* renamed from: D */
    private final MediaPlayer.OnBufferingUpdateListener f295D;

    /* renamed from: E */
    private final MediaPlayer.OnSeekCompleteListener f296E;

    /* renamed from: a */
    private final C1710r f297a;

    /* renamed from: b */
    private final AbstractC1537g.EnumC1542d f298b;

    /* renamed from: c */
    private final C1662k f299c;

    /* renamed from: d */
    private Uri f300d;

    /* renamed from: e */
    private int f301e;

    /* renamed from: f */
    private int f302f;

    /* renamed from: g */
    private SurfaceHolder f303g;

    /* renamed from: h */
    private MediaPlayer f304h;

    /* renamed from: i */
    private int f305i;

    /* renamed from: j */
    private int f306j;

    /* renamed from: k */
    private int f307k;

    /* renamed from: l */
    private int f308l;

    /* renamed from: m */
    private int f309m;

    /* renamed from: n */
    private MediaPlayer.OnCompletionListener f310n;

    /* renamed from: o */
    private MediaPlayer.OnPreparedListener f311o;

    /* renamed from: p */
    private int f312p;

    /* renamed from: q */
    private MediaPlayer.OnErrorListener f313q;

    /* renamed from: r */
    private MediaPlayer.OnInfoListener f314r;

    /* renamed from: s */
    private int f315s;

    /* renamed from: t */
    private boolean f316t;

    /* renamed from: u */
    private boolean f317u;

    /* renamed from: v */
    private boolean f318v;

    /* renamed from: w */
    private AudioManager f319w;

    /* renamed from: x */
    private int f320x;

    /* renamed from: y */
    private final MediaPlayer.OnVideoSizeChangedListener f321y;

    /* renamed from: z */
    private final MediaPlayer.OnPreparedListener f322z;

    public AppLovinVideoViewV2(AbstractC1537g.EnumC1542d enumC1542d, Context context, C1662k c1662k) {
        super(context);
        this.f301e = 0;
        this.f302f = 0;
        this.f303g = null;
        this.f304h = null;
        this.f320x = 1;
        this.f321y = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.applovin.impl.adview.AppLovinVideoViewV2.3
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                AppLovinVideoViewV2.this.f306j = mediaPlayer.getVideoWidth();
                AppLovinVideoViewV2.this.f307k = mediaPlayer.getVideoHeight();
                if (AppLovinVideoViewV2.this.f306j == 0 || AppLovinVideoViewV2.this.f307k == 0) {
                    return;
                }
                AppLovinVideoViewV2.this.getHolder().setFixedSize(AppLovinVideoViewV2.this.f306j, AppLovinVideoViewV2.this.f307k);
                AppLovinVideoViewV2.this.requestLayout();
            }
        };
        this.f322z = new MediaPlayer.OnPreparedListener() { // from class: com.applovin.impl.adview.AppLovinVideoViewV2.4
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                AppLovinVideoViewV2.this.f301e = 2;
                AppLovinVideoViewV2 appLovinVideoViewV2 = AppLovinVideoViewV2.this;
                appLovinVideoViewV2.f316t = appLovinVideoViewV2.f317u = appLovinVideoViewV2.f318v = true;
                if (AppLovinVideoViewV2.this.f311o != null) {
                    AppLovinVideoViewV2.this.f311o.onPrepared(AppLovinVideoViewV2.this.f304h);
                }
                AppLovinVideoViewV2.this.f306j = mediaPlayer.getVideoWidth();
                AppLovinVideoViewV2.this.f307k = mediaPlayer.getVideoHeight();
                int i = AppLovinVideoViewV2.this.f315s;
                if (i != 0) {
                    AppLovinVideoViewV2.this.seekTo(i);
                }
                if (AppLovinVideoViewV2.this.f306j != 0 && AppLovinVideoViewV2.this.f307k != 0) {
                    AppLovinVideoViewV2.this.getHolder().setFixedSize(AppLovinVideoViewV2.this.f306j, AppLovinVideoViewV2.this.f307k);
                    if (AppLovinVideoViewV2.this.f308l != AppLovinVideoViewV2.this.f306j || AppLovinVideoViewV2.this.f309m != AppLovinVideoViewV2.this.f307k || AppLovinVideoViewV2.this.f302f != 3) {
                        return;
                    }
                } else if (AppLovinVideoViewV2.this.f302f != 3) {
                    return;
                }
                AppLovinVideoViewV2.this.start();
            }
        };
        this.f292A = new MediaPlayer.OnCompletionListener() { // from class: com.applovin.impl.adview.AppLovinVideoViewV2.5
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                AppLovinVideoViewV2.this.f301e = 5;
                AppLovinVideoViewV2.this.f302f = 5;
                if (AppLovinVideoViewV2.this.f310n != null) {
                    AppLovinVideoViewV2.this.f310n.onCompletion(AppLovinVideoViewV2.this.f304h);
                }
                if (AppLovinVideoViewV2.this.f320x != 0) {
                    AppLovinVideoViewV2.this.f319w.abandonAudioFocus(null);
                }
            }
        };
        this.f293B = new MediaPlayer.OnInfoListener() { // from class: com.applovin.impl.adview.AppLovinVideoViewV2.6
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                if (AppLovinVideoViewV2.this.f314r != null) {
                    AppLovinVideoViewV2.this.f314r.onInfo(mediaPlayer, i, i2);
                    return true;
                }
                return true;
            }
        };
        this.f294C = new MediaPlayer.OnErrorListener() { // from class: com.applovin.impl.adview.AppLovinVideoViewV2.7
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                C1710r c1710r = AppLovinVideoViewV2.this.f297a;
                c1710r.m6319b("AppLovinVideoView", "Media player error: " + i + ", " + i2);
                AppLovinVideoViewV2.this.f301e = -1;
                AppLovinVideoViewV2.this.f302f = -1;
                if (AppLovinVideoViewV2.this.f313q == null || AppLovinVideoViewV2.this.f313q.onError(AppLovinVideoViewV2.this.f304h, i, i2)) {
                }
                return true;
            }
        };
        this.f295D = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.applovin.impl.adview.AppLovinVideoViewV2.8
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                C1710r c1710r = AppLovinVideoViewV2.this.f297a;
                c1710r.m6319b("AppLovinVideoView", "Buffered: " + i + "%");
                AppLovinVideoViewV2.this.f312p = i;
            }
        };
        this.f296E = new MediaPlayer.OnSeekCompleteListener() { // from class: com.applovin.impl.adview.AppLovinVideoViewV2.9
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                AppLovinVideoViewV2.this.f297a.m6319b("AppLovinVideoView", "Seek finished");
            }
        };
        this.f298b = enumC1542d;
        this.f297a = c1662k.m6588z();
        this.f299c = c1662k;
        this.f319w = (AudioManager) context.getSystemService("audio");
        getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.applovin.impl.adview.AppLovinVideoViewV2.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                C1710r c1710r = AppLovinVideoViewV2.this.f297a;
                c1710r.m6319b("AppLovinVideoView", "Surface changed with format: " + i + ", width: " + i2 + ", height: " + i3);
                AppLovinVideoViewV2.this.f308l = i2;
                AppLovinVideoViewV2.this.f309m = i3;
                boolean z = false;
                boolean z2 = AppLovinVideoViewV2.this.f302f == 3 || AppLovinVideoViewV2.this.f302f == 4;
                if (AppLovinVideoViewV2.this.f306j == i2 && AppLovinVideoViewV2.this.f307k == i3) {
                    z = true;
                }
                if (AppLovinVideoViewV2.this.f304h != null && z2 && z) {
                    if (AppLovinVideoViewV2.this.f315s != 0) {
                        AppLovinVideoViewV2 appLovinVideoViewV2 = AppLovinVideoViewV2.this;
                        appLovinVideoViewV2.seekTo(appLovinVideoViewV2.f315s);
                    }
                    AppLovinVideoViewV2.this.start();
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                AppLovinVideoViewV2.this.f297a.m6319b("AppLovinVideoView", "Surface created");
                AppLovinVideoViewV2.this.f303g = surfaceHolder;
                if (AppLovinVideoViewV2.this.f304h != null) {
                    AppLovinVideoViewV2.this.f304h.setSurface(surfaceHolder.getSurface());
                } else {
                    AppLovinVideoViewV2.this.m8317a();
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                AppLovinVideoViewV2.this.f297a.m6319b("AppLovinVideoView", "Surface destroyed");
                AppLovinVideoViewV2.this.f303g = null;
            }
        });
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f301e = 0;
        this.f302f = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8317a() {
        this.f297a.m6319b("AppLovinVideoView", "Opening video");
        if (this.f300d == null || this.f303g == null) {
            return;
        }
        if (this.f304h != null) {
            this.f297a.m6319b("AppLovinVideoView", "Using existing MediaPlayer");
            this.f304h.start();
            return;
        }
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f304h = mediaPlayer;
            int i = this.f305i;
            if (i != 0) {
                mediaPlayer.setAudioSessionId(i);
            } else {
                this.f305i = mediaPlayer.getAudioSessionId();
            }
            this.f304h.setOnPreparedListener(this.f322z);
            this.f304h.setOnVideoSizeChangedListener(this.f321y);
            this.f304h.setOnCompletionListener(this.f292A);
            this.f304h.setOnErrorListener(this.f294C);
            this.f304h.setOnInfoListener(this.f293B);
            this.f304h.setOnBufferingUpdateListener(this.f295D);
            this.f304h.setOnSeekCompleteListener(this.f296E);
            this.f312p = 0;
            this.f304h.setDataSource(getContext(), this.f300d, (Map<String, String>) null);
            this.f304h.setDisplay(this.f303g);
            this.f304h.setScreenOnWhilePlaying(true);
            this.f304h.prepareAsync();
            this.f301e = 1;
        } catch (Throwable th) {
            C1710r.m6316c("AppLovinVideoView", "Unable to open video: " + this.f300d, th);
            this.f301e = -1;
            this.f302f = -1;
            this.f294C.onError(this.f304h, 1, 0);
        }
    }

    /* renamed from: b */
    private boolean m8312b() {
        int i;
        return (this.f304h == null || (i = this.f301e) == -1 || i == 0 || i == 1) ? false : true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return this.f316t;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return this.f317u;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return this.f318v;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        if (this.f305i == 0) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f305i = mediaPlayer.getAudioSessionId();
            mediaPlayer.release();
        }
        return this.f305i;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.f304h != null) {
            return this.f312p;
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (m8312b()) {
            return this.f304h.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (m8312b()) {
            return this.f304h.getDuration();
        }
        return -1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return m8312b() && this.f304h.isPlaying();
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.f306j, i);
        int defaultSize2 = getDefaultSize(this.f307k, i2);
        if (this.f306j > 0 && this.f307k > 0) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            int i3 = this.f306j;
            int i4 = i3 * defaultSize2;
            int i5 = this.f307k;
            boolean z = i4 < defaultSize * i5;
            boolean z2 = i3 * defaultSize2 > i5 * defaultSize;
            if (this.f298b == AbstractC1537g.EnumC1542d.RESIZE_ASPECT) {
                if (z) {
                    defaultSize = (this.f306j * size2) / this.f307k;
                    defaultSize2 = size2;
                } else {
                    if (z2) {
                        defaultSize2 = (this.f307k * size) / this.f306j;
                        defaultSize = size;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                }
            } else if (this.f298b == AbstractC1537g.EnumC1542d.RESIZE_ASPECT_FILL) {
                if (z) {
                    defaultSize2 = (int) (this.f307k * (size / this.f306j));
                    defaultSize = size;
                } else {
                    if (z2) {
                        defaultSize = (int) (this.f306j * (size2 / this.f307k));
                        defaultSize2 = size2;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        this.f297a.m6319b("AppLovinVideoView", "Pausing video");
        if (m8312b() && this.f304h.isPlaying()) {
            this.f304h.pause();
        }
        this.f302f = 4;
    }

    public void resume() {
        this.f297a.m6319b("AppLovinVideoView", "Resuming video");
        m8317a();
    }

    public void seekAndStart(long j) {
        C1710r c1710r = this.f297a;
        c1710r.m6319b("AppLovinVideoView", "Seeking and starting to " + j + "ms...");
        MediaPlayer mediaPlayer = this.f304h;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo((int) j);
        } else {
            this.f297a.m6314e("AppLovinVideoView", "Media player unavailable");
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        C1710r c1710r = this.f297a;
        c1710r.m6319b("AppLovinVideoView", "Seeking to " + i + "ms");
        if (m8312b()) {
            this.f304h.seekTo(i);
            i = 0;
        } else {
            this.f297a.m6319b("AppLovinVideoView", "Seek delayed");
        }
        this.f315s = i;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.f310n = onCompletionListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.f313q = onErrorListener;
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.f314r = onInfoListener;
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.f311o = onPreparedListener;
    }

    public void setVideoURI(Uri uri) {
        C1710r c1710r = this.f297a;
        c1710r.m6319b("AppLovinVideoView", "Setting video uri: " + uri);
        this.f300d = uri;
        this.f315s = 0;
        m8317a();
        requestLayout();
        invalidate();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.f297a.m6319b("AppLovinVideoView", "Starting video");
        if (m8312b()) {
            this.f304h.start();
        }
        this.f302f = 3;
    }

    public void stopPlayback() {
        this.f297a.m6319b("AppLovinVideoView", "Stopping playback");
        MediaPlayer mediaPlayer = this.f304h;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            final MediaPlayer mediaPlayer2 = this.f304h;
            this.f304h = null;
            this.f301e = 0;
            this.f302f = 0;
            this.f319w.abandonAudioFocus(null);
            if (((Boolean) this.f299c.m6656a(C1568b.f1872eI)).booleanValue()) {
                this.f299c.m6670Q().m6793a(new C1642y(this.f299c, new Runnable() { // from class: com.applovin.impl.adview.AppLovinVideoViewV2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        mediaPlayer2.release();
                    }
                }), C1620o.EnumC1622a.BACKGROUND);
            } else {
                mediaPlayer2.release();
            }
        }
    }
}
