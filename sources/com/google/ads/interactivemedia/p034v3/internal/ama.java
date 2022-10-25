package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.impl.data.C2467al;
import com.google.android.exoplayer2.C3282C;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ama */
/* loaded from: classes2.dex */
public final class ama {

    /* renamed from: a */
    static boolean f4425a = false;

    /* renamed from: c */
    private static MessageDigest f4427c;

    /* renamed from: d */
    private static final Object f4428d = new Object();

    /* renamed from: e */
    private static final Object f4429e = new Object();

    /* renamed from: b */
    static final CountDownLatch f4426b = new CountDownLatch(1);

    /* renamed from: a */
    public static String m5007a(afr afrVar, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] m5000h;
        byte[] mo3176ar = afrVar.mo3176ar();
        if (((Boolean) aql.f4906s.m4770f()).booleanValue()) {
            Vector m5002f = m5002f(mo3176ar);
            if (m5002f == null || m5002f.size() == 0) {
                m5000h = m5000h(m5001g(afm.f3748t).mo3176ar(), str, true);
            } else {
                aga m5376a = agb.m5376a();
                int size = m5002f.size();
                for (int i = 0; i < size; i++) {
                    m5376a.m5438a(bls.m3504t(m5000h((byte[]) m5002f.get(i), str, false)));
                }
                m5376a.m5401b(bls.m3504t(m5004d(mo3176ar)));
                m5000h = ((agb) m5376a.mo3179aR()).mo3176ar();
            }
        } else if (anx.f4759a == null) {
            throw new GeneralSecurityException();
        } else {
            byte[] mo3771a = anx.f4759a.mo3771a(mo3176ar, str != null ? str.getBytes() : new byte[0]);
            aga m5376a2 = agb.m5376a();
            m5376a2.m5438a(bls.m3504t(mo3771a));
            m5376a2.m5400c(afv.f3903c);
            m5000h = ((agb) m5376a2.mo3179aR()).mo3176ar();
        }
        return C2467al.m6016a(m5000h, true);
    }

    /* renamed from: c */
    public static void m5005c() {
        synchronized (f4429e) {
            if (!f4425a) {
                f4425a = true;
                new Thread(new alz(null)).start();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x001e, code lost:
        r1.reset();
        r1.update(r6);
        r6 = com.google.ads.interactivemedia.p034v3.internal.ama.f4427c.digest();
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] m5004d(byte[] r6) throws java.security.NoSuchAlgorithmException {
        /*
            java.lang.Object r0 = com.google.ads.interactivemedia.p034v3.internal.ama.f4428d
            monitor-enter(r0)
            m5005c()     // Catch: java.lang.Throwable -> L34
            r1 = 0
            java.util.concurrent.CountDownLatch r2 = com.google.ads.interactivemedia.p034v3.internal.ama.f4426b     // Catch: java.lang.InterruptedException -> L1b java.lang.Throwable -> L34
            r3 = 2
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.InterruptedException -> L1b java.lang.Throwable -> L34
            boolean r2 = r2.await(r3, r5)     // Catch: java.lang.InterruptedException -> L1b java.lang.Throwable -> L34
            if (r2 != 0) goto L14
            goto L1c
        L14:
            java.security.MessageDigest r2 = com.google.ads.interactivemedia.p034v3.internal.ama.f4427c     // Catch: java.lang.Throwable -> L34
            if (r2 != 0) goto L19
            goto L1c
        L19:
            r1 = r2
            goto L1c
        L1b:
        L1c:
            if (r1 == 0) goto L2c
            r1.reset()     // Catch: java.lang.Throwable -> L34
            r1.update(r6)     // Catch: java.lang.Throwable -> L34
            java.security.MessageDigest r6 = com.google.ads.interactivemedia.p034v3.internal.ama.f4427c     // Catch: java.lang.Throwable -> L34
            byte[] r6 = r6.digest()     // Catch: java.lang.Throwable -> L34
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L34
            return r6
        L2c:
            java.security.NoSuchAlgorithmException r6 = new java.security.NoSuchAlgorithmException     // Catch: java.lang.Throwable -> L34
            java.lang.String r1 = "Cannot compute hash"
            r6.<init>(r1)     // Catch: java.lang.Throwable -> L34
            throw r6     // Catch: java.lang.Throwable -> L34
        L34:
            r6 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L34
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.ama.m5004d(byte[]):byte[]");
    }

    /* renamed from: e */
    public static byte[] m5003e(String str, String str2) {
        byte[] m6015b;
        aga m5528d = aft.m5528d();
        try {
            if (str.length() < 3) {
                m6015b = str.getBytes(C3282C.ISO88591_NAME);
            } else {
                m6015b = C2467al.m6015b(str, true);
            }
            m5528d.m5393j(bls.m3504t(m6015b));
            m5528d.m5394i(bls.m3504t(str2.length() < 3 ? str2.getBytes(C3282C.ISO88591_NAME) : C2467al.m6015b(str2, true)));
            return ((aft) m5528d.mo3179aR()).mo3176ar();
        } catch (UnsupportedEncodingException | GeneralSecurityException unused) {
            return null;
        }
    }

    /* renamed from: f */
    static Vector m5002f(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return null;
        }
        int i = (length + 254) / 255;
        Vector vector = new Vector();
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 255;
            try {
                int length2 = bArr.length;
                if (length2 - i3 > 255) {
                    length2 = i3 + 255;
                }
                vector.add(Arrays.copyOfRange(bArr, i3, length2));
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    /* renamed from: g */
    static afr m5001g(int i) {
        aga m5557an = afr.m5557an();
        m5557an.m5420ah(afm.m5629a(i));
        return (afr) m5557an.mo3179aR();
    }

    /* renamed from: h */
    private static byte[] m5000h(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] array;
        int i = true != z ? 255 : 239;
        if (bArr.length > i) {
            bArr = m5001g(afm.f3748t).mo3176ar();
        }
        int length = bArr.length;
        if (length < i) {
            byte[] bArr2 = new byte[i - length];
            new SecureRandom().nextBytes(bArr2);
            array = ByteBuffer.allocate(i + 1).put((byte) length).put(bArr).put(bArr2).array();
        } else {
            array = ByteBuffer.allocate(i + 1).put((byte) length).put(bArr).array();
        }
        if (z) {
            array = ByteBuffer.allocate(256).put(m5004d(array)).put(array).array();
        }
        byte[] bArr3 = new byte[256];
        amb[] ambVarArr = new amo().f4588cN;
        int length2 = ambVarArr.length;
        for (int i2 = 0; i2 < 12; i2++) {
            ambVarArr[i2].mo4999a(array, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new bkz(str.getBytes("UTF-8")).m3539a(bArr3);
        }
        return bArr3;
    }
}
