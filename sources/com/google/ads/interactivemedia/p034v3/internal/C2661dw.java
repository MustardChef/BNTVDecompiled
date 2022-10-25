package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.dw */
/* loaded from: classes2.dex */
public final class C2661dw extends AbstractC2631ct {

    /* renamed from: a */
    private final byte[] f7069a;

    /* renamed from: b */
    private final DatagramPacket f7070b;

    /* renamed from: c */
    private Uri f7071c;

    /* renamed from: d */
    private DatagramSocket f7072d;

    /* renamed from: e */
    private MulticastSocket f7073e;

    /* renamed from: f */
    private InetAddress f7074f;

    /* renamed from: g */
    private boolean f7075g;

    /* renamed from: h */
    private int f7076h;

    public C2661dw() {
        super(true);
        byte[] bArr = new byte[2000];
        this.f7069a = bArr;
        this.f7070b = new DatagramPacket(bArr, 0, 2000);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2746h
    /* renamed from: a */
    public final int mo501a(byte[] bArr, int i, int i2) throws C2660dv {
        if (i2 == 0) {
            return 0;
        }
        if (this.f7076h == 0) {
            try {
                DatagramSocket datagramSocket = this.f7072d;
                C2616ce.m2689d(datagramSocket);
                datagramSocket.receive(this.f7070b);
                int length = this.f7070b.getLength();
                this.f7076h = length;
                m2507g(length);
            } catch (SocketTimeoutException e) {
                throw new C2660dv(e, 2002);
            } catch (IOException e2) {
                throw new C2660dv(e2, 2001);
            }
        }
        int length2 = this.f7070b.getLength();
        int i3 = this.f7076h;
        int min = Math.min(i3, i2);
        System.arraycopy(this.f7069a, length2 - i3, bArr, i, min);
        this.f7076h -= min;
        return min;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: b */
    public final long mo1127b(C2642dd c2642dd) throws C2660dv {
        Uri uri = c2642dd.f7011a;
        this.f7071c = uri;
        String host = uri.getHost();
        C2616ce.m2689d(host);
        int port = this.f7071c.getPort();
        m2505i(c2642dd);
        try {
            this.f7074f = InetAddress.getByName(host);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f7074f, port);
            if (this.f7074f.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.f7073e = multicastSocket;
                multicastSocket.joinGroup(this.f7074f);
                this.f7072d = this.f7073e;
            } else {
                this.f7072d = new DatagramSocket(inetSocketAddress);
            }
            this.f7072d.setSoTimeout(8000);
            this.f7075g = true;
            m2504j(c2642dd);
            return -1L;
        } catch (IOException e) {
            throw new C2660dv(e, 2001);
        } catch (SecurityException e2) {
            throw new C2660dv(e2, 2006);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: c */
    public final Uri mo1126c() {
        return this.f7071c;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: d */
    public final void mo1125d() {
        this.f7071c = null;
        MulticastSocket multicastSocket = this.f7073e;
        if (multicastSocket != null) {
            try {
                InetAddress inetAddress = this.f7074f;
                C2616ce.m2689d(inetAddress);
                multicastSocket.leaveGroup(inetAddress);
            } catch (IOException unused) {
            }
            this.f7073e = null;
        }
        DatagramSocket datagramSocket = this.f7072d;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f7072d = null;
        }
        this.f7074f = null;
        this.f7076h = 0;
        if (this.f7075g) {
            this.f7075g = false;
            m2506h();
        }
    }
}
