package com.google.ads.interactivemedia.p034v3.internal;

import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.text.TextUtils;
import android.util.Log;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.oa */
/* loaded from: classes2.dex */
public final class C2936oa implements InterfaceC2930nv {

    /* renamed from: a */
    public static final C2933ny f8229a = C2933ny.f8198a;

    /* renamed from: b */
    private final UUID f8230b;

    /* renamed from: c */
    private final MediaDrm f8231c;

    /* renamed from: d */
    private int f8232d;

    private C2936oa(UUID uuid) throws UnsupportedSchemeException {
        C2616ce.m2689d(uuid);
        C2616ce.m2686g(!C2692f.f7208b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f8230b = uuid;
        MediaDrm mediaDrm = new MediaDrm(m1487o(uuid));
        this.f8231c = mediaDrm;
        this.f8232d = 1;
        if (C2692f.f7210d.equals(uuid) && "ASUS_Z00AD".equals(C2628cq.f6964d)) {
            mediaDrm.setPropertyString("securityLevel", "L3");
        }
    }

    /* renamed from: n */
    public static C2936oa m1488n(UUID uuid) throws C2941of {
        try {
            return new C2936oa(uuid);
        } catch (UnsupportedSchemeException e) {
            throw new C2941of(e);
        } catch (Exception e2) {
            throw new C2941of(e2);
        }
    }

    /* renamed from: o */
    private static UUID m1487o(UUID uuid) {
        return (C2628cq.f6961a >= 27 || !C2692f.f7209c.equals(uuid)) ? uuid : C2692f.f7208b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2930nv
    /* renamed from: a */
    public final int mo1501a() {
        return 2;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2930nv
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ InterfaceC2663dy mo1500b(byte[] bArr) throws MediaCryptoException {
        boolean z = false;
        if (C2628cq.f6961a < 21 && C2692f.f7210d.equals(this.f8230b) && "L3".equals(this.f8231c.getPropertyString("securityLevel"))) {
            z = true;
        }
        return new C2931nw(m1487o(this.f8230b), bArr, z);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2930nv
    /* renamed from: c */
    public final C2929nu mo1499c() {
        MediaDrm.ProvisionRequest provisionRequest = this.f8231c.getProvisionRequest();
        return new C2929nu(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2930nv
    /* renamed from: d */
    public final Map mo1498d(byte[] bArr) {
        return this.f8231c.queryKeyStatus(bArr);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2930nv
    /* renamed from: e */
    public final void mo1497e(byte[] bArr) {
        this.f8231c.closeSession(bArr);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2930nv
    /* renamed from: f */
    public final void mo1496f(byte[] bArr) throws DeniedByServerException {
        this.f8231c.provideProvisionResponse(bArr);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2930nv
    /* renamed from: g */
    public final synchronized void mo1495g() {
        int i = this.f8232d - 1;
        this.f8232d = i;
        if (i == 0) {
            this.f8231c.release();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2930nv
    /* renamed from: h */
    public final void mo1494h(byte[] bArr, byte[] bArr2) {
        this.f8231c.restoreKeys(bArr, bArr2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2930nv
    /* renamed from: i */
    public final void mo1493i(final InterfaceC2928nt interfaceC2928nt) {
        this.f8231c.setOnEventListener(new MediaDrm.OnEventListener() { // from class: com.google.ads.interactivemedia.v3.internal.nx
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
                HandlerC2898mq handlerC2898mq = ((C2897mp) interfaceC2928nt).f8133a.f8146a;
                C2616ce.m2689d(handlerC2898mq);
                handlerC2898mq.obtainMessage(i, bArr).sendToTarget();
            }
        });
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2930nv
    /* renamed from: j */
    public final boolean mo1492j(byte[] bArr, String str) {
        if (C2628cq.f6961a >= 31) {
            return C2934nz.m1564a(this.f8231c, str);
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(this.f8230b, bArr);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(str);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2930nv
    /* renamed from: k */
    public final byte[] mo1491k() throws MediaDrmException {
        return this.f8231c.openSession();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2930nv
    /* renamed from: l */
    public final byte[] mo1490l(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException {
        if (C2692f.f7209c.equals(this.f8230b)) {
            bArr2 = C2958ow.m1436c(bArr2);
        }
        return this.f8231c.provideKeyResponse(bArr, bArr2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2930nv
    /* renamed from: m */
    public final aeg mo1489m(byte[] bArr, List list, int i, HashMap hashMap) throws NotProvisionedException {
        byte[] bArr2;
        String str;
        C2827k c2827k;
        byte[] bArr3;
        C2827k c2827k2 = null;
        if (list != null) {
            if (!C2692f.f7210d.equals(this.f8230b)) {
                c2827k = (C2827k) list.get(0);
            } else {
                if (C2628cq.f6961a >= 28 && list.size() > 1) {
                    C2827k c2827k3 = (C2827k) list.get(0);
                    int i2 = 0;
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        C2827k c2827k4 = (C2827k) list.get(i3);
                        byte[] bArr4 = (byte[]) C2616ce.m2689d(c2827k4.f7783d);
                        if (C2628cq.m2563T(c2827k4.f7782c, c2827k3.f7782c) && C2628cq.m2563T(c2827k4.f7781b, c2827k3.f7781b) && acn.m5834c(bArr4)) {
                            i2 += bArr4.length;
                        }
                    }
                    byte[] bArr5 = new byte[i2];
                    int i4 = 0;
                    for (int i5 = 0; i5 < list.size(); i5++) {
                        byte[] bArr6 = (byte[]) C2616ce.m2689d(((C2827k) list.get(i5)).f7783d);
                        int length = bArr6.length;
                        System.arraycopy(bArr6, 0, bArr5, i4, length);
                        i4 += length;
                    }
                    c2827k = c2827k3.m1840a(bArr5);
                }
                for (int i6 = 0; i6 < list.size(); i6++) {
                    C2827k c2827k5 = (C2827k) list.get(i6);
                    int m5836a = acn.m5836a((byte[]) C2616ce.m2689d(c2827k5.f7783d));
                    if ((C2628cq.f6961a < 23 && m5836a == 0) || (C2628cq.f6961a >= 23 && m5836a == 1)) {
                        c2827k2 = c2827k5;
                        break;
                    }
                }
                c2827k = (C2827k) list.get(0);
            }
            c2827k2 = c2827k;
            UUID uuid = this.f8230b;
            byte[] bArr7 = (byte[]) C2616ce.m2689d(c2827k2.f7783d);
            if (C2692f.f7211e.equals(uuid)) {
                byte[] m5831f = acn.m5831f(bArr7, uuid);
                if (m5831f != null) {
                    bArr7 = m5831f;
                }
                UUID uuid2 = C2692f.f7211e;
                C2621cj c2621cj = new C2621cj(bArr7);
                int m2636f = c2621cj.m2636f();
                short m2619w = c2621cj.m2619w();
                short m2619w2 = c2621cj.m2619w();
                if (m2619w != 1 || m2619w2 != 1) {
                    Log.i("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
                } else {
                    String m2620v = c2621cj.m2620v(c2621cj.m2619w(), atg.f5039c);
                    if (!m2620v.contains("<LA_URL>")) {
                        int indexOf = m2620v.indexOf("</DATA>");
                        if (indexOf == -1) {
                            Log.w("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
                            indexOf = -1;
                        }
                        String substring = m2620v.substring(0, indexOf);
                        String substring2 = m2620v.substring(indexOf);
                        StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 26 + String.valueOf(substring2).length());
                        sb.append(substring);
                        sb.append("<LA_URL>https://x</LA_URL>");
                        sb.append(substring2);
                        String sb2 = sb.toString();
                        int i7 = m2636f + 52;
                        ByteBuffer allocate = ByteBuffer.allocate(i7);
                        allocate.order(ByteOrder.LITTLE_ENDIAN);
                        allocate.putInt(i7);
                        allocate.putShort((short) 1);
                        allocate.putShort((short) 1);
                        int length2 = sb2.length();
                        allocate.putShort((short) (length2 + length2));
                        allocate.put(sb2.getBytes(atg.f5039c));
                        bArr7 = allocate.array();
                    }
                }
                bArr7 = acn.m5833d(uuid2, bArr7);
            }
            if (((C2628cq.f6961a >= 23 || !C2692f.f7210d.equals(uuid)) && (!C2692f.f7211e.equals(uuid) || !"Amazon".equals(C2628cq.f6963c) || (!"AFTB".equals(C2628cq.f6964d) && !"AFTS".equals(C2628cq.f6964d) && !"AFTM".equals(C2628cq.f6964d) && !"AFTT".equals(C2628cq.f6964d)))) || (bArr3 = acn.m5831f(bArr7, uuid)) == null) {
                bArr3 = bArr7;
            }
            UUID uuid3 = this.f8230b;
            String str2 = c2827k2.f7782c;
            bArr2 = bArr3;
            str = (C2628cq.f6961a < 26 && C2692f.f7209c.equals(uuid3) && (MimeTypes.VIDEO_MP4.equals(str2) || MimeTypes.AUDIO_MP4.equals(str2))) ? C3282C.CENC_TYPE_cenc : str2;
        } else {
            bArr2 = null;
            str = null;
        }
        MediaDrm.KeyRequest keyRequest = this.f8231c.getKeyRequest(bArr, bArr2, str, i, hashMap);
        UUID uuid4 = this.f8230b;
        byte[] data = keyRequest.getData();
        if (C2692f.f7209c.equals(uuid4) && C2628cq.f6961a < 27) {
            data = C2628cq.m2554ab(C2628cq.m2576G(data).replace('+', '-').replace(JsonPointer.SEPARATOR, '_'));
        }
        String defaultUrl = keyRequest.getDefaultUrl();
        if (true == "https://x".equals(defaultUrl)) {
            defaultUrl = "";
        }
        if (TextUtils.isEmpty(defaultUrl) && c2827k2 != null && !TextUtils.isEmpty(c2827k2.f7781b)) {
            defaultUrl = c2827k2.f7781b;
        }
        if (C2628cq.f6961a >= 23) {
            keyRequest.getRequestType();
        }
        return new aeg(data, defaultUrl);
    }
}
