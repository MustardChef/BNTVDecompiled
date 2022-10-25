package com.applovin.impl.sdk.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.fasterxml.jackson.core.JsonPointer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.applovin.impl.sdk.utils.k */
/* loaded from: classes.dex */
public class C1758k {
    /* renamed from: a */
    public static String m6189a(String str, String str2) {
        return m6186a(str, str2, new byte[]{-83, -98, -53, -112, -29, -118, 55, 117, 59, 8, -12, -15, 73, 110, -67, 57, 117, 4, -26, 97, 66, -12, 125, 91, -119, -103, -30, 114, 123, 54, 51, -77});
    }

    /* renamed from: a */
    public static String m6188a(String str, String str2, long j) {
        return m6187a(str, str2, j, new byte[]{-83, -98, -53, -112, -29, -118, 55, 117, 59, 8, -12, -15, 73, 110, -67, 57, 117, 4, -26, 97, 66, -12, 125, 91, -119, -103, -30, 114, 123, 54, 51, -77});
    }

    /* renamed from: a */
    private static String m6187a(String str, String str2, long j, byte[] bArr) {
        if (str2 != null) {
            if (str2.length() >= 80) {
                if (bArr != null) {
                    char c = ' ';
                    if (bArr.length >= 32) {
                        if (str == null || str.isEmpty()) {
                            return str;
                        }
                        try {
                            String substring = str2.substring(32);
                            String substring2 = str2.substring(0, 32);
                            byte[] bytes = str.getBytes("UTF-8");
                            byte[] m6185a = m6185a(substring2, bArr);
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            byteArrayOutputStream.write(((byte) ((j >> 0) & 255)) ^ m6185a[0]);
                            byteArrayOutputStream.write(((byte) ((j >> 8) & 255)) ^ m6185a[1]);
                            byteArrayOutputStream.write(((byte) ((j >> 16) & 255)) ^ m6185a[2]);
                            byteArrayOutputStream.write(((byte) ((j >> 24) & 255)) ^ m6185a[3]);
                            byteArrayOutputStream.write(((byte) ((j >> 32) & 255)) ^ m6185a[4]);
                            byteArrayOutputStream.write(((byte) ((j >> 40) & 255)) ^ m6185a[5]);
                            byteArrayOutputStream.write(((byte) ((j >> 48) & 255)) ^ m6185a[6]);
                            byteArrayOutputStream.write(((byte) ((j >> 56) & 255)) ^ m6185a[7]);
                            int i = 0;
                            while (i < bytes.length) {
                                long j2 = j + i;
                                long j3 = (j2 ^ (j2 >> 33)) * (-4417276706812531889L);
                                long j4 = (j3 ^ (j3 >> 29)) * (-8796714831421723037L);
                                long j5 = j4 ^ (j4 >> c);
                                int i2 = i + 0;
                                byteArrayOutputStream.write((byte) (((i2 >= bytes.length ? (byte) 0 : bytes[i2]) ^ m6185a[i2 % m6185a.length]) ^ ((j5 >> 0) & 255)));
                                int i3 = i + 1;
                                byteArrayOutputStream.write((byte) ((m6185a[i3 % m6185a.length] ^ (i3 >= bytes.length ? (byte) 0 : bytes[i3])) ^ ((j5 >> 8) & 255)));
                                int i4 = i + 2;
                                byteArrayOutputStream.write((byte) ((m6185a[i4 % m6185a.length] ^ (i4 >= bytes.length ? (byte) 0 : bytes[i4])) ^ ((j5 >> 16) & 255)));
                                int i5 = i + 3;
                                byteArrayOutputStream.write((byte) ((m6185a[i5 % m6185a.length] ^ (i5 >= bytes.length ? (byte) 0 : bytes[i5])) ^ ((j5 >> 24) & 255)));
                                int i6 = i + 4;
                                byteArrayOutputStream.write((byte) ((m6185a[i6 % m6185a.length] ^ (i6 >= bytes.length ? (byte) 0 : bytes[i6])) ^ ((j5 >> 32) & 255)));
                                int i7 = i + 5;
                                byteArrayOutputStream.write((byte) ((m6185a[i7 % m6185a.length] ^ (i7 >= bytes.length ? (byte) 0 : bytes[i7])) ^ ((j5 >> 40) & 255)));
                                int i8 = i + 6;
                                byteArrayOutputStream.write((byte) ((m6185a[i8 % m6185a.length] ^ (i8 >= bytes.length ? (byte) 0 : bytes[i8])) ^ ((j5 >> 48) & 255)));
                                int i9 = i + 7;
                                byteArrayOutputStream.write((byte) ((m6185a[i9 % m6185a.length] ^ (i9 >= bytes.length ? (byte) 0 : bytes[i9])) ^ ((j5 >> 56) & 255)));
                                i += 8;
                                c = ' ';
                            }
                            String m6182b = m6182b(byteArrayOutputStream.toByteArray());
                            String m6184a = m6184a(bArr);
                            return "1:" + m6184a + ":" + substring + ":" + m6182b;
                        } catch (IOException unused) {
                            return null;
                        }
                    }
                    throw new IllegalArgumentException("Salt is too short");
                }
                throw new IllegalArgumentException("No salt specified");
            }
            throw new IllegalArgumentException("SDK key is too short");
        }
        throw new IllegalArgumentException("No SDK key specified");
    }

    /* renamed from: a */
    private static String m6186a(String str, String str2, byte[] bArr) {
        if (str2 != null) {
            if (str2.length() >= 80) {
                if (bArr != null) {
                    char c = ' ';
                    if (bArr.length >= 32) {
                        if (TextUtils.isEmpty(str) || str.trim().startsWith("{")) {
                            return str;
                        }
                        String[] split = str.split(":");
                        char c2 = 0;
                        try {
                            if ("1".equals(split[0]) && split.length == 4) {
                                char c3 = 1;
                                String str3 = split[1];
                                String str4 = split[2];
                                byte[] m6190a = m6190a(split[3]);
                                if (str2.endsWith(str4) && m6184a(bArr).equals(str3)) {
                                    byte[] m6185a = m6185a(str2.substring(0, 32), bArr);
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(m6190a);
                                    char c4 = '\b';
                                    try {
                                        long read = (((byteArrayInputStream.read() ^ m6185a[5]) & 255) << 40) | (((byteArrayInputStream.read() ^ m6185a[0]) & 255) << 0) | (((byteArrayInputStream.read() ^ m6185a[1]) & 255) << 8) | (((byteArrayInputStream.read() ^ m6185a[2]) & 255) << 16) | (((byteArrayInputStream.read() ^ m6185a[3]) & 255) << 24) | (((byteArrayInputStream.read() ^ m6185a[4]) & 255) << 32) | (((byteArrayInputStream.read() ^ m6185a[6]) & 255) << 48) | (((byteArrayInputStream.read() ^ m6185a[7]) & 255) << 56);
                                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                        byte[] bArr2 = new byte[8];
                                        int read2 = byteArrayInputStream.read(bArr2);
                                        int i = 0;
                                        while (read2 >= 0) {
                                            long j = i + read;
                                            long j2 = (j ^ (j >> 33)) * (-4417276706812531889L);
                                            long j3 = (j2 ^ (j2 >> 29)) * (-8796714831421723037L);
                                            long j4 = j3 ^ (j3 >> c);
                                            byteArrayOutputStream.write((byte) ((bArr2[c2] ^ m6185a[(i + 0) % m6185a.length]) ^ ((j4 >> c2) & 255)));
                                            byteArrayOutputStream.write((byte) ((bArr2[c3] ^ m6185a[(i + 1) % m6185a.length]) ^ ((j4 >> c4) & 255)));
                                            long j5 = read;
                                            byteArrayOutputStream.write((byte) ((m6185a[(i + 2) % m6185a.length] ^ bArr2[2]) ^ ((j4 >> 16) & 255)));
                                            byteArrayOutputStream.write((byte) ((bArr2[3] ^ m6185a[(i + 3) % m6185a.length]) ^ ((j4 >> 24) & 255)));
                                            byteArrayOutputStream.write((byte) ((m6185a[(i + 4) % m6185a.length] ^ bArr2[4]) ^ ((j4 >> c) & 255)));
                                            byteArrayOutputStream.write((byte) ((bArr2[5] ^ m6185a[(i + 5) % m6185a.length]) ^ ((j4 >> 40) & 255)));
                                            byteArrayOutputStream.write((byte) ((m6185a[(i + 6) % m6185a.length] ^ bArr2[6]) ^ ((j4 >> 48) & 255)));
                                            byteArrayOutputStream.write((byte) ((m6185a[(i + 7) % m6185a.length] ^ bArr2[7]) ^ ((j4 >> 56) & 255)));
                                            i += 8;
                                            read2 = byteArrayInputStream.read(bArr2);
                                            read = j5;
                                            c4 = '\b';
                                            c2 = 0;
                                            c = ' ';
                                            c3 = 1;
                                        }
                                        return new String(byteArrayOutputStream.toByteArray(), "UTF-8").trim();
                                    } catch (IOException unused) {
                                        return null;
                                    }
                                }
                                return null;
                            }
                            return null;
                        } catch (IOException unused2) {
                            return null;
                        }
                    }
                    throw new IllegalArgumentException("Salt is too short");
                }
                throw new IllegalArgumentException("No salt specified");
            }
            throw new IllegalArgumentException("SDK key is too short");
        }
        throw new IllegalArgumentException("No SDK key specified");
    }

    /* renamed from: a */
    private static String m6184a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(bArr);
            return StringUtils.toHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-1 algorithm not found", e);
        }
    }

    /* renamed from: a */
    private static byte[] m6190a(String str) {
        return Base64.decode(m6183b(str), 0);
    }

    /* renamed from: a */
    private static byte[] m6185a(String str, byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            messageDigest.update(str.getBytes("UTF-8"));
            return messageDigest.digest();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 encoding not found", e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("SHA-1 algorithm not found", e2);
        }
    }

    /* renamed from: b */
    private static String m6183b(String str) {
        return str.replace('-', '+').replace('_', JsonPointer.SEPARATOR).replace('*', '=');
    }

    /* renamed from: b */
    private static String m6182b(byte[] bArr) throws UnsupportedEncodingException {
        return m6181c(Base64.encode(bArr, 2));
    }

    /* renamed from: c */
    private static String m6181c(byte[] bArr) throws UnsupportedEncodingException {
        return new String(bArr, "UTF-8").replace('+', '-').replace(JsonPointer.SEPARATOR, '_').replace('=', '*');
    }
}
