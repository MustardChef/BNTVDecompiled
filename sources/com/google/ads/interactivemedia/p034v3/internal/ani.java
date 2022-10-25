package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.impl.data.C2467al;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ani */
/* loaded from: classes2.dex */
public final class ani {

    /* renamed from: a */
    private static Cipher f4711a;

    /* renamed from: b */
    private static final Object f4712b = new Object();

    /* renamed from: c */
    private static final Object f4713c = new Object();

    /* renamed from: c */
    private static final Cipher m4915c() throws NoSuchAlgorithmException, NoSuchPaddingException {
        Cipher cipher;
        synchronized (f4713c) {
            if (f4711a == null) {
                f4711a = Cipher.getInstance("AES/CBC/PKCS5Padding");
            }
            cipher = f4711a;
        }
        return cipher;
    }

    /* renamed from: a */
    public final String m4917a(byte[] bArr, byte[] bArr2) throws anh {
        byte[] doFinal;
        byte[] iv;
        int length = bArr.length;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (f4712b) {
                m4915c().init(1, secretKeySpec, (SecureRandom) null);
                doFinal = m4915c().doFinal(bArr2);
                iv = m4915c().getIV();
            }
            int length2 = doFinal.length + iv.length;
            ByteBuffer allocate = ByteBuffer.allocate(length2);
            allocate.put(iv).put(doFinal);
            allocate.flip();
            byte[] bArr3 = new byte[length2];
            allocate.get(bArr3);
            return C2467al.m6016a(bArr3, false);
        } catch (InvalidKeyException e) {
            throw new anh(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new anh(e2);
        } catch (BadPaddingException e3) {
            throw new anh(e3);
        } catch (IllegalBlockSizeException e4) {
            throw new anh(e4);
        } catch (NoSuchPaddingException e5) {
            throw new anh(e5);
        }
    }

    /* renamed from: b */
    public final byte[] m4916b(byte[] bArr, String str) throws anh {
        byte[] doFinal;
        int length = bArr.length;
        try {
            byte[] m6015b = C2467al.m6015b(str, false);
            int length2 = m6015b.length;
            if (length2 > 16) {
                ByteBuffer allocate = ByteBuffer.allocate(length2);
                allocate.put(m6015b);
                allocate.flip();
                byte[] bArr2 = new byte[16];
                byte[] bArr3 = new byte[length2 - 16];
                allocate.get(bArr2);
                allocate.get(bArr3);
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                synchronized (f4712b) {
                    m4915c().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                    doFinal = m4915c().doFinal(bArr3);
                }
                return doFinal;
            }
            throw new anh();
        } catch (IllegalArgumentException e) {
            throw new anh(e);
        } catch (InvalidAlgorithmParameterException e2) {
            throw new anh(e2);
        } catch (InvalidKeyException e3) {
            throw new anh(e3);
        } catch (NoSuchAlgorithmException e4) {
            throw new anh(e4);
        } catch (BadPaddingException e5) {
            throw new anh(e5);
        } catch (IllegalBlockSizeException e6) {
            throw new anh(e6);
        } catch (NoSuchPaddingException e7) {
            throw new anh(e7);
        }
    }
}
