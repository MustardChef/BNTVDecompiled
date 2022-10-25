package com.google.ads.interactivemedia.p034v3.internal;

import android.media.MediaCodec;
import android.os.HandlerThread;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.qn */
/* loaded from: classes2.dex */
public final class C3003qn implements InterfaceC3015qz {

    /* renamed from: b */
    private final atn f8622b;

    /* renamed from: c */
    private final atn f8623c;

    public C3003qn(final int i) {
        atn atnVar = new atn() { // from class: com.google.ads.interactivemedia.v3.internal.qm
            @Override // com.google.ads.interactivemedia.p034v3.internal.atn
            /* renamed from: a */
            public final Object mo1308a() {
                String m1303s;
                String m1303s2;
                if (r2 != 0) {
                    m1303s2 = C3004qo.m1303s(i, "ExoPlayer:MediaCodecAsyncAdapter:");
                    return new HandlerThread(m1303s2);
                }
                m1303s = C3004qo.m1303s(i, "ExoPlayer:MediaCodecQueueingThread:");
                return new HandlerThread(m1303s);
            }
        };
        atn atnVar2 = new atn() { // from class: com.google.ads.interactivemedia.v3.internal.qm
            @Override // com.google.ads.interactivemedia.p034v3.internal.atn
            /* renamed from: a */
            public final Object mo1308a() {
                String m1303s;
                String m1303s2;
                if (r2 != 0) {
                    m1303s2 = C3004qo.m1303s(i, "ExoPlayer:MediaCodecAsyncAdapter:");
                    return new HandlerThread(m1303s2);
                }
                m1303s = C3004qo.m1303s(i, "ExoPlayer:MediaCodecQueueingThread:");
                return new HandlerThread(m1303s);
            }
        };
        this.f8622b = atnVar;
        this.f8623c = atnVar2;
    }

    /* renamed from: a */
    public final C3004qo m1307a(C3014qy c3014qy) throws IOException {
        MediaCodec mediaCodec;
        String str = c3014qy.f8670a.f8676a;
        C3004qo c3004qo = null;
        try {
            String valueOf = String.valueOf(str);
            C2616ce.m2672u(valueOf.length() != 0 ? "createCodec:".concat(valueOf) : new String("createCodec:"));
            mediaCodec = MediaCodec.createByCodecName(str);
            try {
                C3004qo c3004qo2 = new C3004qo(mediaCodec, (HandlerThread) this.f8622b.mo1308a(), (HandlerThread) this.f8623c.mo1308a());
                try {
                    C2616ce.m2671v();
                    C3004qo.m1304o(c3004qo2, c3014qy.f8671b, c3014qy.f8673d, c3014qy.f8674e);
                    return c3004qo2;
                } catch (Exception e) {
                    e = e;
                    c3004qo = c3004qo2;
                    if (c3004qo != null) {
                        c3004qo.mo1197i();
                    } else if (mediaCodec != null) {
                        mediaCodec.release();
                    }
                    throw e;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            mediaCodec = null;
        }
    }
}
