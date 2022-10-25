package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.byte_const_span;
import com.frostwire.jlibtorrent.swig.byte_vector;
import com.frostwire.jlibtorrent.swig.int64_vector;
import com.frostwire.jlibtorrent.swig.int_vector;
import com.frostwire.jlibtorrent.swig.string_vector;
import com.google.android.exoplayer2.C3282C;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class Vectors {
    private Vectors() {
    }

    public static byte[] byte_vector2bytes(byte_vector byte_vectorVar) {
        int size = (int) byte_vectorVar.size();
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            bArr[i] = byte_vectorVar.get(i);
        }
        return bArr;
    }

    public static void byte_vector2bytes(byte_vector byte_vectorVar, byte[] bArr) {
        int size = (int) byte_vectorVar.size();
        for (int i = 0; i < size; i++) {
            bArr[i] = byte_vectorVar.get(i);
        }
    }

    public static byte_vector bytes2byte_vector(byte[] bArr) {
        byte_vector byte_vectorVar = new byte_vector();
        for (byte b : bArr) {
            byte_vectorVar.push_back(b);
        }
        return byte_vectorVar;
    }

    public static void bytes2byte_vector(byte[] bArr, byte_vector byte_vectorVar) {
        for (int i = 0; i < bArr.length; i++) {
            byte_vectorVar.set(i, bArr[i]);
        }
    }

    public static int[] int_vector2ints(int_vector int_vectorVar) {
        int size = (int) int_vectorVar.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = int_vectorVar.get(i);
        }
        return iArr;
    }

    public static long[] int64_vector2longs(int64_vector int64_vectorVar) {
        int size = (int) int64_vectorVar.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = int64_vectorVar.get(i);
        }
        return jArr;
    }

    public static byte[] byte_span2bytes(byte_const_span byte_const_spanVar) {
        int size = (int) byte_const_spanVar.size();
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            bArr[i] = byte_const_spanVar.get(i);
        }
        return bArr;
    }

    public static byte_vector new_byte_vector(int i) {
        byte_vector byte_vectorVar = new byte_vector();
        for (int i2 = 0; i2 < i; i2++) {
            byte_vectorVar.push_back((byte) 0);
        }
        return byte_vectorVar;
    }

    public static List<String> string_vector2list(string_vector string_vectorVar) {
        int size = (int) string_vectorVar.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(string_vectorVar.get(i));
        }
        return arrayList;
    }

    public static String byte_vector2string(byte_vector byte_vectorVar, String str) {
        byte[] byte_vector2bytes = byte_vector2bytes(byte_vectorVar);
        int i = 0;
        while (i < byte_vector2bytes.length && byte_vector2bytes[i] != 0) {
            i++;
        }
        if (i == 0) {
            return "";
        }
        try {
            return new String(byte_vector2bytes, 0, i, str);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String byte_vector2ascii(byte_vector byte_vectorVar) {
        return byte_vector2string(byte_vectorVar, C3282C.ASCII_NAME);
    }

    public static String byte_vector2utf8(byte_vector byte_vectorVar) {
        return byte_vector2string(byte_vectorVar, "UTF-8");
    }

    public static byte_vector string2byte_vector(String str, String str2) {
        try {
            return bytes2byte_vector(str.getBytes(str2));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte_vector ascii2byte_vector(String str) {
        return string2byte_vector(str, C3282C.ASCII_NAME);
    }
}
