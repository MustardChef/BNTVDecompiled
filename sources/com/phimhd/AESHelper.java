package com.phimhd;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
public class AESHelper {
    static String AES = "AES";
    static String APPEND = "Salted__";
    static String CHARSET_TYPE = "UTF-8";
    static String HASH_CIPHER = "AES/CBC/PKCS7Padding";
    static int IV_SIZE = 128;
    static String KDF_DIGEST = "MD5";
    static int KEY_SIZE = 256;

    public static String encrypt(String str, String str2) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        byte[] generateSalt = generateSalt(8);
        byte[] bArr = new byte[KEY_SIZE / 8];
        byte[] bArr2 = new byte[IV_SIZE / 8];
        EvpKDF(str.getBytes(CHARSET_TYPE), KEY_SIZE, IV_SIZE, generateSalt, bArr, bArr2);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, AES);
        Cipher cipher = Cipher.getInstance(HASH_CIPHER);
        cipher.init(1, secretKeySpec, new IvParameterSpec(bArr2));
        byte[] doFinal = cipher.doFinal(str2.getBytes(CHARSET_TYPE));
        byte[] bytes = APPEND.getBytes(CHARSET_TYPE);
        byte[] bArr3 = new byte[bytes.length + generateSalt.length + doFinal.length];
        System.arraycopy(bytes, 0, bArr3, 0, bytes.length);
        System.arraycopy(generateSalt, 0, bArr3, bytes.length, generateSalt.length);
        System.arraycopy(doFinal, 0, bArr3, bytes.length + generateSalt.length, doFinal.length);
        return new String(Base64.encode(bArr3, 0));
    }

    public static String decrypt(String str, String str2) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        byte[] decode = Base64.decode(str2.getBytes(CHARSET_TYPE), 0);
        byte[] copyOfRange = Arrays.copyOfRange(decode, 8, 16);
        byte[] copyOfRange2 = Arrays.copyOfRange(decode, 16, decode.length);
        byte[] bArr = new byte[KEY_SIZE / 8];
        byte[] bArr2 = new byte[IV_SIZE / 8];
        EvpKDF(str.getBytes(CHARSET_TYPE), KEY_SIZE, IV_SIZE, copyOfRange, bArr, bArr2);
        Cipher cipher = Cipher.getInstance(HASH_CIPHER);
        cipher.init(2, new SecretKeySpec(bArr, AES), new IvParameterSpec(bArr2));
        return new String(cipher.doFinal(copyOfRange2));
    }

    private static byte[] EvpKDF(byte[] bArr, int i, int i2, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws NoSuchAlgorithmException {
        return EvpKDF(bArr, i, i2, bArr2, 1, KDF_DIGEST, bArr3, bArr4);
    }

    private static byte[] EvpKDF(byte[] bArr, int i, int i2, byte[] bArr2, int i3, String str, byte[] bArr3, byte[] bArr4) throws NoSuchAlgorithmException {
        int i4 = i / 32;
        int i5 = i2 / 32;
        int i6 = i4 + i5;
        byte[] bArr5 = new byte[i6 * 4];
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[] bArr6 = null;
        int i7 = 0;
        while (i7 < i6) {
            if (bArr6 != null) {
                messageDigest.update(bArr6);
            }
            messageDigest.update(bArr);
            bArr6 = messageDigest.digest(bArr2);
            messageDigest.reset();
            for (int i8 = 1; i8 < i3; i8++) {
                bArr6 = messageDigest.digest(bArr6);
                messageDigest.reset();
            }
            System.arraycopy(bArr6, 0, bArr5, i7 * 4, Math.min(bArr6.length, (i6 - i7) * 4));
            i7 += bArr6.length / 4;
        }
        int i9 = i4 * 4;
        System.arraycopy(bArr5, 0, bArr3, 0, i9);
        System.arraycopy(bArr5, i9, bArr4, 0, i5 * 4);
        return bArr5;
    }

    private static byte[] generateSalt(int i) {
        byte[] bArr = new byte[i];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }
}
