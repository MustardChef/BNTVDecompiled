package com.google.ads.interactivemedia.p034v3.internal;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.audio.DtsUtil;
import com.google.android.exoplayer2.audio.MpegAudioUtil;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.jp */
/* loaded from: classes2.dex */
public final class C2816jp {

    /* renamed from: a */
    public final C2962p f7703a;

    /* renamed from: b */
    public final int f7704b;

    /* renamed from: c */
    public final int f7705c;

    /* renamed from: d */
    public final int f7706d;

    /* renamed from: e */
    public final int f7707e;

    /* renamed from: f */
    public final int f7708f;

    /* renamed from: g */
    public final int f7709g;

    /* renamed from: h */
    public final int f7710h;

    /* renamed from: i */
    public final InterfaceC2791ir[] f7711i;

    /* renamed from: e */
    private final int m1909e(long j) {
        int i;
        int i2 = this.f7709g;
        switch (i2) {
            case 5:
                i = Ac3Util.AC3_MAX_RATE_BYTES_PER_SECOND;
                break;
            case 6:
            case 18:
                i = Ac3Util.E_AC3_MAX_RATE_BYTES_PER_SECOND;
                break;
            case 7:
                i = DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND;
                break;
            case 8:
                i = DtsUtil.DTS_HD_MAX_RATE_BYTES_PER_SECOND;
                break;
            case 9:
                i = MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND;
                break;
            case 10:
                i = AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND;
                break;
            case 11:
                i = AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND;
                break;
            case 12:
                i = AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND;
                break;
            case 13:
            default:
                throw new IllegalArgumentException();
            case 14:
                i = Ac3Util.TRUEHD_MAX_RATE_BYTES_PER_SECOND;
                break;
            case 15:
                i = 8000;
                break;
            case 16:
                i = AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND;
                break;
            case 17:
                i = Ac4Util.MAX_RATE_BYTES_PER_SECOND;
                break;
        }
        if (i2 == 5) {
            i += i;
        }
        return (int) ((j * i) / 1000000);
    }

    /* renamed from: f */
    private static AudioAttributes m1908f(C2611c c2611c, boolean z) {
        if (z) {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }
        return c2611c.m2707a();
    }

    /* renamed from: a */
    public final long m1913a(long j) {
        return (j * this.f7707e) / 1000000;
    }

    /* renamed from: b */
    public final long m1912b(long j) {
        return (j * 1000000) / this.f7707e;
    }

    /* renamed from: c */
    public final AudioTrack m1911c(boolean z, C2611c c2611c, int i) throws C2804jd {
        AudioTrack audioTrack;
        AudioFormat build;
        AudioFormat build2;
        try {
            if (C2628cq.f6961a >= 29) {
                build2 = new AudioFormat.Builder().setSampleRate(this.f7707e).setChannelMask(this.f7708f).setEncoding(this.f7709g).build();
                audioTrack = new AudioTrack.Builder().setAudioAttributes(m1908f(c2611c, z)).setAudioFormat(build2).setTransferMode(1).setBufferSizeInBytes(this.f7710h).setSessionId(i).setOffloadedPlayback(this.f7705c == 1).build();
            } else if (C2628cq.f6961a < 21) {
                int i2 = c2611c.f6919c;
                if (i == 0) {
                    audioTrack = new AudioTrack(3, this.f7707e, this.f7708f, this.f7709g, this.f7710h, 1);
                } else {
                    audioTrack = new AudioTrack(3, this.f7707e, this.f7708f, this.f7709g, this.f7710h, 1, i);
                }
            } else {
                AudioAttributes m1908f = m1908f(c2611c, z);
                build = new AudioFormat.Builder().setSampleRate(this.f7707e).setChannelMask(this.f7708f).setEncoding(this.f7709g).build();
                audioTrack = new AudioTrack(m1908f, build, this.f7710h, 1, i);
            }
            int state = audioTrack.getState();
            if (state == 1) {
                return audioTrack;
            }
            try {
                audioTrack.release();
            } catch (Exception unused) {
            }
            throw new C2804jd(state, this.f7707e, this.f7708f, this.f7710h, this.f7703a, m1910d(), null);
        } catch (IllegalArgumentException | UnsupportedOperationException e) {
            throw new C2804jd(0, this.f7707e, this.f7708f, this.f7710h, this.f7703a, m1910d(), e);
        }
    }

    /* renamed from: d */
    public final boolean m1910d() {
        return this.f7705c == 1;
    }

    public C2816jp(C2962p c2962p, int i, int i2, int i3, int i4, int i5, int i6, boolean z, InterfaceC2791ir[] interfaceC2791irArr) {
        int m2531c;
        this.f7703a = c2962p;
        this.f7704b = i;
        this.f7705c = i2;
        this.f7706d = i3;
        this.f7707e = i4;
        this.f7708f = i5;
        this.f7709g = i6;
        this.f7711i = interfaceC2791irArr;
        if (i2 == 0) {
            int minBufferSize = AudioTrack.getMinBufferSize(i4, i5, i6);
            C2616ce.m2685h(minBufferSize != -2);
            m2531c = C2628cq.m2531c(minBufferSize * 4, ((int) m1913a(250000L)) * i3, Math.max(minBufferSize, ((int) m1913a(750000L)) * i3));
        } else {
            m2531c = i2 != 1 ? m1909e(250000L) : m1909e(50000000L);
        }
        this.f7710h = m2531c;
    }
}
