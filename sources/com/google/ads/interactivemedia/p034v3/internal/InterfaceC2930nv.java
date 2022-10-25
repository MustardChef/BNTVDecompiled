package com.google.ads.interactivemedia.p034v3.internal;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.nv */
/* loaded from: classes2.dex */
public interface InterfaceC2930nv {
    /* renamed from: a */
    int mo1501a();

    /* renamed from: b */
    InterfaceC2663dy mo1500b(byte[] bArr) throws MediaCryptoException;

    /* renamed from: c */
    C2929nu mo1499c();

    /* renamed from: d */
    Map mo1498d(byte[] bArr);

    /* renamed from: e */
    void mo1497e(byte[] bArr);

    /* renamed from: f */
    void mo1496f(byte[] bArr) throws DeniedByServerException;

    /* renamed from: g */
    void mo1495g();

    /* renamed from: h */
    void mo1494h(byte[] bArr, byte[] bArr2);

    /* renamed from: i */
    void mo1493i(InterfaceC2928nt interfaceC2928nt);

    /* renamed from: j */
    boolean mo1492j(byte[] bArr, String str);

    /* renamed from: k */
    byte[] mo1491k() throws MediaDrmException;

    /* renamed from: l */
    byte[] mo1490l(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException;

    /* renamed from: m */
    aeg mo1489m(byte[] bArr, List list, int i, HashMap hashMap) throws NotProvisionedException;
}
