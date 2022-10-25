package com.google.ads.interactivemedia.p034v3.internal;

import android.support.p002v4.media.session.PlaybackStateCompat;
import android.util.Pair;
import com.google.android.exoplayer2.C3282C;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.acra.ACRAConstants;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aev */
/* loaded from: classes2.dex */
public final class aev {
    /* renamed from: a */
    public static long m5713a(ByteBuffer byteBuffer) {
        m5704j(byteBuffer);
        return m5706h(byteBuffer, byteBuffer.position() + 16);
    }

    /* renamed from: b */
    public static long m5712b(ByteBuffer byteBuffer) {
        m5704j(byteBuffer);
        return m5706h(byteBuffer, byteBuffer.position() + 12);
    }

    /* renamed from: c */
    static Pair m5711c(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair m5705i = m5705i(randomAccessFile, 0);
        return m5705i != null ? m5705i : m5705i(randomAccessFile, 65535);
    }

    /* renamed from: d */
    public static void m5710d(ByteBuffer byteBuffer, long j) {
        m5704j(byteBuffer);
        int position = byteBuffer.position() + 16;
        if (j < 0 || j > 4294967295L) {
            StringBuilder sb = new StringBuilder(47);
            sb.append("uint32 value of out range: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
        byteBuffer.putInt(byteBuffer.position() + position, (int) j);
    }

    /* renamed from: e */
    public static X509Certificate[][] m5709e(String str) throws aes, SecurityException, IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            Pair m5711c = m5711c(randomAccessFile);
            if (m5711c != null) {
                ByteBuffer byteBuffer = (ByteBuffer) m5711c.first;
                long longValue = ((Long) m5711c.second).longValue();
                long j = (-20) + longValue;
                if (j >= 0) {
                    randomAccessFile.seek(j);
                    if (randomAccessFile.readInt() == 1347094023) {
                        throw new aes("ZIP64 APK not supported");
                    }
                }
                long m5713a = m5713a(byteBuffer);
                if (m5713a >= longValue) {
                    StringBuilder sb = new StringBuilder(122);
                    sb.append("ZIP Central Directory offset out of range: ");
                    sb.append(m5713a);
                    sb.append(". ZIP End of Central Directory offset: ");
                    sb.append(longValue);
                    throw new aes(sb.toString());
                } else if (m5712b(byteBuffer) + m5713a == longValue) {
                    if (m5713a < 32) {
                        StringBuilder sb2 = new StringBuilder(87);
                        sb2.append("APK too small for APK Signing Block. ZIP Central Directory offset: ");
                        sb2.append(m5713a);
                        throw new aes(sb2.toString());
                    }
                    ByteBuffer allocate = ByteBuffer.allocate(24);
                    allocate.order(ByteOrder.LITTLE_ENDIAN);
                    randomAccessFile.seek(m5713a - allocate.capacity());
                    randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                    int i = 8;
                    if (allocate.getLong(8) != 2334950737559900225L || allocate.getLong(16) != 3617552046287187010L) {
                        throw new aes("No APK Signing Block before ZIP Central Directory");
                    }
                    int i2 = 0;
                    long j2 = allocate.getLong(0);
                    if (j2 < allocate.capacity() || j2 > 2147483639) {
                        StringBuilder sb3 = new StringBuilder(57);
                        sb3.append("APK Signing Block size out of range: ");
                        sb3.append(j2);
                        throw new aes(sb3.toString());
                    }
                    int i3 = (int) (8 + j2);
                    long j3 = m5713a - i3;
                    if (j3 < 0) {
                        StringBuilder sb4 = new StringBuilder(59);
                        sb4.append("APK Signing Block offset out of range: ");
                        sb4.append(j3);
                        throw new aes(sb4.toString());
                    }
                    ByteBuffer allocate2 = ByteBuffer.allocate(i3);
                    allocate2.order(ByteOrder.LITTLE_ENDIAN);
                    randomAccessFile.seek(j3);
                    randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                    long j4 = allocate2.getLong(0);
                    if (j4 != j2) {
                        StringBuilder sb5 = new StringBuilder(103);
                        sb5.append("APK Signing Block sizes in header and footer do not match: ");
                        sb5.append(j4);
                        sb5.append(" vs ");
                        sb5.append(j2);
                        throw new aes(sb5.toString());
                    }
                    Pair create = Pair.create(allocate2, Long.valueOf(j3));
                    ByteBuffer byteBuffer2 = (ByteBuffer) create.first;
                    long longValue2 = ((Long) create.second).longValue();
                    if (byteBuffer2.order() == ByteOrder.LITTLE_ENDIAN) {
                        int capacity = byteBuffer2.capacity() - 24;
                        if (capacity < 8) {
                            StringBuilder sb6 = new StringBuilder(38);
                            sb6.append("end < start: ");
                            sb6.append(capacity);
                            sb6.append(" < ");
                            sb6.append(8);
                            throw new IllegalArgumentException(sb6.toString());
                        }
                        int capacity2 = byteBuffer2.capacity();
                        if (capacity > byteBuffer2.capacity()) {
                            StringBuilder sb7 = new StringBuilder(41);
                            sb7.append("end > capacity: ");
                            sb7.append(capacity);
                            sb7.append(" > ");
                            sb7.append(capacity2);
                            throw new IllegalArgumentException(sb7.toString());
                        }
                        int limit = byteBuffer2.limit();
                        int position = byteBuffer2.position();
                        byteBuffer2.position(0);
                        byteBuffer2.limit(capacity);
                        byteBuffer2.position(8);
                        ByteBuffer slice = byteBuffer2.slice();
                        slice.order(byteBuffer2.order());
                        byteBuffer2.position(0);
                        byteBuffer2.limit(limit);
                        byteBuffer2.position(position);
                        while (slice.hasRemaining()) {
                            i2++;
                            if (slice.remaining() >= i) {
                                long j5 = slice.getLong();
                                if (j5 >= 4 && j5 <= 2147483647L) {
                                    int i4 = (int) j5;
                                    int position2 = slice.position() + i4;
                                    if (i4 <= slice.remaining()) {
                                        if (slice.getInt() != 1896449818) {
                                            slice.position(position2);
                                            i = 8;
                                        } else {
                                            X509Certificate[][] m5694t = m5694t(randomAccessFile.getChannel(), new aer(m5700n(slice, i4 - 4), longValue2, m5713a, longValue, byteBuffer));
                                            randomAccessFile.close();
                                            return m5694t;
                                        }
                                    } else {
                                        int remaining = slice.remaining();
                                        StringBuilder sb8 = new StringBuilder(91);
                                        sb8.append("APK Signing Block entry #");
                                        sb8.append(i2);
                                        sb8.append(" size out of range: ");
                                        sb8.append(i4);
                                        sb8.append(", available: ");
                                        sb8.append(remaining);
                                        throw new aes(sb8.toString());
                                    }
                                } else {
                                    StringBuilder sb9 = new StringBuilder(76);
                                    sb9.append("APK Signing Block entry #");
                                    sb9.append(i2);
                                    sb9.append(" size out of range: ");
                                    sb9.append(j5);
                                    throw new aes(sb9.toString());
                                }
                            } else {
                                StringBuilder sb10 = new StringBuilder(70);
                                sb10.append("Insufficient data to read size of APK Signing Block entry #");
                                sb10.append(i2);
                                throw new aes(sb10.toString());
                            }
                        }
                        throw new aes("No APK Signature Scheme v2 block in APK Signing Block");
                    }
                    throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
                } else {
                    throw new aes("ZIP Central Directory is not immediately followed by End of Central Directory");
                }
            }
            long length = randomAccessFile.length();
            StringBuilder sb11 = new StringBuilder(102);
            sb11.append("Not an APK file: ZIP End of Central Directory record not found in file with ");
            sb11.append(length);
            sb11.append(" bytes");
            throw new aes(sb11.toString());
        } finally {
            try {
                randomAccessFile.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: f */
    public static int m5708f(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] != 71) {
            i++;
        }
        return i;
    }

    /* renamed from: g */
    public static long m5707g(C2621cj c2621cj, int i, int i2) {
        c2621cj.m2644F(i);
        if (c2621cj.m2641a() < 5) {
            return C3282C.TIME_UNSET;
        }
        int m2637e = c2621cj.m2637e();
        if ((8388608 & m2637e) == 0 && ((m2637e >> 8) & 8191) == i2 && (m2637e & 32) != 0 && c2621cj.m2633i() >= 7 && c2621cj.m2641a() >= 7 && (c2621cj.m2633i() & 16) == 16) {
            byte[] bArr = new byte[6];
            c2621cj.m2649A(bArr, 0, 6);
            byte b = bArr[0];
            byte b2 = bArr[1];
            byte b3 = bArr[2];
            long j = bArr[3] & 255;
            return ((b2 & 255) << 17) | ((b & 255) << 25) | ((b3 & 255) << 9) | (j + j) | ((bArr[4] & 255) >> 7);
        }
        return C3282C.TIME_UNSET;
    }

    /* renamed from: h */
    private static long m5706h(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getInt(i) & 4294967295L;
    }

    /* renamed from: i */
    private static Pair m5705i(RandomAccessFile randomAccessFile, int i) throws IOException {
        int i2;
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min(i, (-22) + length)) + 22);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        long capacity = length - allocate.capacity();
        randomAccessFile.seek(capacity);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        m5704j(allocate);
        int capacity2 = allocate.capacity();
        if (capacity2 >= 22) {
            int i3 = capacity2 - 22;
            int min = Math.min(i3, 65535);
            for (int i4 = 0; i4 < min; i4++) {
                i2 = i3 - i4;
                if (allocate.getInt(i2) == 101010256 && ((char) allocate.getShort(i2 + 20)) == i4) {
                    break;
                }
            }
        }
        i2 = -1;
        if (i2 == -1) {
            return null;
        }
        allocate.position(i2);
        ByteBuffer slice = allocate.slice();
        slice.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(slice, Long.valueOf(capacity + i2));
    }

    /* renamed from: j */
    private static void m5704j(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    /* renamed from: k */
    private static int m5703k(int i) {
        if (i != 1) {
            if (i == 2) {
                return 64;
            }
            StringBuilder sb = new StringBuilder(44);
            sb.append("Unknown content digest algorthm: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        return 32;
    }

    /* renamed from: l */
    private static int m5702l(int i) {
        if (i != 513) {
            if (i != 514) {
                if (i != 769) {
                    switch (i) {
                        case 257:
                        case 259:
                            return 1;
                        case 258:
                        case 260:
                            return 2;
                        default:
                            String valueOf = String.valueOf(Long.toHexString(i));
                            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unknown signature algorithm: 0x".concat(valueOf) : new String("Unknown signature algorithm: 0x"));
                    }
                }
                return 1;
            }
            return 2;
        }
        return 1;
    }

    /* renamed from: m */
    private static String m5701m(int i) {
        if (i != 1) {
            if (i == 2) {
                return "SHA-512";
            }
            StringBuilder sb = new StringBuilder(44);
            sb.append("Unknown content digest algorthm: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        return "SHA-256";
    }

    /* renamed from: n */
    private static ByteBuffer m5700n(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i2 = i + position;
        if (i2 < position || i2 > limit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i2);
        try {
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            byteBuffer.position(i2);
            return slice;
        } finally {
            byteBuffer.limit(limit);
        }
    }

    /* renamed from: o */
    private static ByteBuffer m5699o(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() < 4) {
            int remaining = byteBuffer.remaining();
            StringBuilder sb = new StringBuilder(93);
            sb.append("Remaining buffer too short to contain length of length-prefixed field. Remaining: ");
            sb.append(remaining);
            throw new IOException(sb.toString());
        }
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        if (i > byteBuffer.remaining()) {
            int remaining2 = byteBuffer.remaining();
            StringBuilder sb2 = new StringBuilder(101);
            sb2.append("Length-prefixed field longer than remaining buffer. Field length: ");
            sb2.append(i);
            sb2.append(", remaining: ");
            sb2.append(remaining2);
            throw new IOException(sb2.toString());
        }
        return m5700n(byteBuffer, i);
    }

    /* renamed from: p */
    private static void m5698p(Map map, FileChannel fileChannel, long j, long j2, long j3, ByteBuffer byteBuffer) throws SecurityException {
        if (!map.isEmpty()) {
            aeq aeqVar = new aeq(fileChannel, 0L, j);
            aeq aeqVar2 = new aeq(fileChannel, j2, j3 - j2);
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.order(ByteOrder.LITTLE_ENDIAN);
            m5710d(duplicate, j);
            aeo aeoVar = new aeo(duplicate);
            int size = map.size();
            int[] iArr = new int[size];
            int i = 0;
            for (Integer num : map.keySet()) {
                iArr[i] = num.intValue();
                i++;
            }
            try {
                byte[][] m5695s = m5695s(iArr, new aep[]{aeqVar, aeqVar2, aeoVar});
                for (int i2 = 0; i2 < size; i2++) {
                    int i3 = iArr[i2];
                    if (!MessageDigest.isEqual((byte[]) map.get(Integer.valueOf(i3)), m5695s[i2])) {
                        throw new SecurityException(m5701m(i3).concat(" digest of contents did not verify"));
                    }
                }
                return;
            } catch (DigestException e) {
                throw new SecurityException("Failed to compute digest(s) of contents", e);
            }
        }
        throw new SecurityException("No digests provided");
    }

    /* renamed from: q */
    private static byte[] m5697q(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IOException("Negative length");
        }
        if (i <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            return bArr;
        }
        int remaining = byteBuffer.remaining();
        StringBuilder sb = new StringBuilder(90);
        sb.append("Underflow while reading length-prefixed value. Length: ");
        sb.append(i);
        sb.append(", available: ");
        sb.append(remaining);
        throw new IOException(sb.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
        r11 = m5702l(r5);
        r12 = m5702l(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
        if (r11 == 1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
        if (r12 == 1) goto L19;
     */
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.security.cert.X509Certificate[] m5696r(java.nio.ByteBuffer r22, java.util.Map r23, java.security.cert.CertificateFactory r24) throws java.lang.SecurityException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 728
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.aev.m5696r(java.nio.ByteBuffer, java.util.Map, java.security.cert.CertificateFactory):java.security.cert.X509Certificate[]");
    }

    /* renamed from: s */
    private static byte[][] m5695s(int[] iArr, aep[] aepVarArr) throws DigestException {
        long j;
        int i;
        int length;
        long j2 = 0;
        long j3 = 0;
        int i2 = 0;
        while (true) {
            j = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            if (i2 >= 3) {
                break;
            }
            j3 += (aepVarArr[i2].mo5720a() + 1048575) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            i2++;
        }
        if (j3 >= 2097151) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Too many chunks: ");
            sb.append(j3);
            throw new DigestException(sb.toString());
        }
        int i3 = (int) j3;
        byte[][] bArr = new byte[iArr.length];
        int i4 = 0;
        while (true) {
            length = iArr.length;
            if (i4 >= length) {
                break;
            }
            byte[] bArr2 = new byte[(m5703k(iArr[i4]) * i3) + 5];
            bArr2[0] = 90;
            m5693u(i3, bArr2);
            bArr[i4] = bArr2;
            i4++;
        }
        byte[] bArr3 = new byte[5];
        bArr3[0] = -91;
        MessageDigest[] messageDigestArr = new MessageDigest[length];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            String m5701m = m5701m(iArr[i5]);
            try {
                messageDigestArr[i5] = MessageDigest.getInstance(m5701m);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(m5701m.concat(" digest not supported"), e);
            }
        }
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (i = 3; i6 < i; i = 3) {
            aep aepVar = aepVarArr[i6];
            long j4 = j2;
            int i9 = i6;
            long mo5720a = aepVar.mo5720a();
            while (mo5720a > j2) {
                int min = (int) Math.min(mo5720a, j);
                m5693u(min, bArr3);
                for (int i10 = 0; i10 < length; i10++) {
                    messageDigestArr[i10].update(bArr3);
                }
                long j5 = j4;
                try {
                    aepVar.mo5719b(messageDigestArr, j5, min);
                    int i11 = 0;
                    while (i11 < iArr.length) {
                        int i12 = iArr[i11];
                        aep aepVar2 = aepVar;
                        byte[] bArr4 = bArr[i11];
                        int m5703k = m5703k(i12);
                        byte[] bArr5 = bArr3;
                        MessageDigest messageDigest = messageDigestArr[i11];
                        MessageDigest[] messageDigestArr2 = messageDigestArr;
                        int digest = messageDigest.digest(bArr4, (i7 * m5703k) + 5, m5703k);
                        if (digest != m5703k) {
                            String algorithm = messageDigest.getAlgorithm();
                            StringBuilder sb2 = new StringBuilder(String.valueOf(algorithm).length() + 46);
                            sb2.append("Unexpected output size of ");
                            sb2.append(algorithm);
                            sb2.append(" digest: ");
                            sb2.append(digest);
                            throw new RuntimeException(sb2.toString());
                        }
                        i11++;
                        aepVar = aepVar2;
                        bArr3 = bArr5;
                        messageDigestArr = messageDigestArr2;
                    }
                    aep aepVar3 = aepVar;
                    long j6 = min;
                    long j7 = j5 + j6;
                    mo5720a -= j6;
                    i7++;
                    j2 = 0;
                    j = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                    aepVar = aepVar3;
                    j4 = j7;
                    bArr3 = bArr3;
                } catch (IOException e2) {
                    StringBuilder sb3 = new StringBuilder(59);
                    sb3.append("Failed to digest chunk #");
                    sb3.append(i7);
                    sb3.append(" of section #");
                    sb3.append(i8);
                    throw new DigestException(sb3.toString(), e2);
                }
            }
            i8++;
            i6 = i9 + 1;
            j2 = 0;
            j = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        }
        byte[][] bArr6 = new byte[iArr.length];
        for (int i13 = 0; i13 < iArr.length; i13++) {
            int i14 = iArr[i13];
            byte[] bArr7 = bArr[i13];
            String m5701m2 = m5701m(i14);
            try {
                bArr6[i13] = MessageDigest.getInstance(m5701m2).digest(bArr7);
            } catch (NoSuchAlgorithmException e3) {
                throw new RuntimeException(m5701m2.concat(" digest not supported"), e3);
            }
        }
        return bArr6;
    }

    /* renamed from: t */
    private static X509Certificate[][] m5694t(FileChannel fileChannel, aer aerVar) throws SecurityException {
        ByteBuffer byteBuffer;
        long j;
        long j2;
        long j3;
        ByteBuffer byteBuffer2;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance(ACRAConstants.DEFAULT_CERTIFICATE_TYPE);
            try {
                byteBuffer = aerVar.f3627a;
                ByteBuffer m5699o = m5699o(byteBuffer);
                int i = 0;
                while (m5699o.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(m5696r(m5699o(m5699o), hashMap, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        StringBuilder sb = new StringBuilder(48);
                        sb.append("Failed to parse/verify signer #");
                        sb.append(i);
                        sb.append(" block");
                        throw new SecurityException(sb.toString(), e);
                    }
                }
                if (i <= 0) {
                    throw new SecurityException("No signers found");
                }
                if (!hashMap.isEmpty()) {
                    j = aerVar.f3628b;
                    j2 = aerVar.f3629c;
                    j3 = aerVar.f3630d;
                    byteBuffer2 = aerVar.f3631e;
                    m5698p(hashMap, fileChannel, j, j2, j3, byteBuffer2);
                    return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()]);
                }
                throw new SecurityException("No content digests found");
            } catch (IOException e2) {
                throw new SecurityException("Failed to read list of signers", e2);
            }
        } catch (CertificateException e3) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
        }
    }

    /* renamed from: u */
    private static void m5693u(int i, byte[] bArr) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >>> 8) & 255);
        bArr[3] = (byte) ((i >>> 16) & 255);
        bArr[4] = (byte) (i >> 24);
    }
}
