package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Log;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import java.nio.ByteBuffer;
import java.util.UUID;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.acn */
/* loaded from: classes2.dex */
public final class acn {
    /* renamed from: a */
    public static int m5836a(byte[] bArr) {
        int i;
        acm m5830g = m5830g(bArr);
        if (m5830g == null) {
            return -1;
        }
        i = m5830g.f3227b;
        return i;
    }

    /* renamed from: b */
    public static UUID m5835b(byte[] bArr) {
        UUID uuid;
        acm m5830g = m5830g(bArr);
        if (m5830g == null) {
            return null;
        }
        uuid = m5830g.f3226a;
        return uuid;
    }

    /* renamed from: c */
    public static boolean m5834c(byte[] bArr) {
        return m5830g(bArr) != null;
    }

    /* renamed from: d */
    public static byte[] m5833d(UUID uuid, byte[] bArr) {
        return m5832e(uuid, null, bArr);
    }

    /* renamed from: e */
    public static byte[] m5832e(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        int length;
        int length2 = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length2 += (uuidArr.length * 16) + 4;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length2);
        allocate.putInt(length2);
        allocate.putInt(Atom.TYPE_pssh);
        allocate.putInt(uuidArr != null ? 16777216 : 0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            allocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                allocate.putLong(uuid2.getMostSignificantBits());
                allocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (bArr != null && (length = bArr.length) != 0) {
            allocate.putInt(length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    /* renamed from: f */
    public static byte[] m5831f(byte[] bArr, UUID uuid) {
        UUID uuid2;
        byte[] bArr2;
        UUID uuid3;
        acm m5830g = m5830g(bArr);
        if (m5830g == null) {
            return null;
        }
        uuid2 = m5830g.f3226a;
        if (uuid.equals(uuid2)) {
            bArr2 = m5830g.f3228c;
            return bArr2;
        }
        String valueOf = String.valueOf(uuid);
        uuid3 = m5830g.f3226a;
        String obj = uuid3.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 33 + obj.length());
        sb.append("UUID mismatch. Expected: ");
        sb.append(valueOf);
        sb.append(", got: ");
        sb.append(obj);
        sb.append(".");
        Log.w("PsshAtomUtil", sb.toString());
        return null;
    }

    /* renamed from: g */
    private static acm m5830g(byte[] bArr) {
        C2621cj c2621cj = new C2621cj(bArr);
        if (c2621cj.m2638d() < 32) {
            return null;
        }
        c2621cj.m2644F(0);
        if (c2621cj.m2637e() == c2621cj.m2641a() + 4 && c2621cj.m2637e() == 1886614376) {
            int m5888f = abt.m5888f(c2621cj.m2637e());
            if (m5888f > 1) {
                StringBuilder sb = new StringBuilder(37);
                sb.append("Unsupported pssh version: ");
                sb.append(m5888f);
                Log.w("PsshAtomUtil", sb.toString());
                return null;
            }
            UUID uuid = new UUID(c2621cj.m2627o(), c2621cj.m2627o());
            if (m5888f == 1) {
                c2621cj.m2643G(c2621cj.m2630l() * 16);
            }
            int m2630l = c2621cj.m2630l();
            if (m2630l != c2621cj.m2641a()) {
                return null;
            }
            byte[] bArr2 = new byte[m2630l];
            c2621cj.m2649A(bArr2, 0, m2630l);
            return new acm(uuid, m5888f, bArr2);
        }
        return null;
    }
}
