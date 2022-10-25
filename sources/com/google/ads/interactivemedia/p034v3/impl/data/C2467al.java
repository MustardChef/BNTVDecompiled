package com.google.ads.interactivemedia.p034v3.impl.data;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.google.ads.interactivemedia.p034v3.internal.aph;
import com.google.ads.interactivemedia.p034v3.internal.art;
import com.google.ads.interactivemedia.p034v3.internal.atl;
import com.google.ads.interactivemedia.p034v3.internal.axh;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.al */
/* loaded from: classes2.dex */
public final /* synthetic */ class C2467al {
    /* renamed from: a */
    public static String m6016a(byte[] bArr, boolean z) {
        return Base64.encodeToString(bArr, true != z ? 2 : 11);
    }

    /* renamed from: b */
    public static byte[] m6015b(String str, boolean z) throws IllegalArgumentException {
        byte[] decode = Base64.decode(str, true != z ? 2 : 11);
        if (decode.length != 0 || str.length() <= 0) {
            return decode;
        }
        String valueOf = String.valueOf(str);
        throw new IllegalArgumentException(valueOf.length() != 0 ? "Unable to decode ".concat(valueOf) : new String("Unable to decode "));
    }

    /* renamed from: c */
    public static boolean m6014c(int i) {
        int i2 = i - 1;
        int i3 = aph.f4836a;
        if (i != 0) {
            return i2 == 2 || i2 == 4 || i2 == 5 || i2 == 6;
        }
        throw null;
    }

    /* renamed from: d */
    public static final int m6013d(Context context, art artVar) {
        int i;
        FileInputStream fileInputStream;
        byte[] bArr;
        File file = new File(new File(context.getApplicationInfo().dataDir), "lib");
        if (!file.exists()) {
            artVar.m4728b(5017, "No lib/");
            i = aph.f4841f;
        } else {
            File[] listFiles = file.listFiles(new axh(Pattern.compile(".*\\.so$", 2)));
            if (listFiles == null || listFiles.length == 0) {
                artVar.m4728b(5017, "No .so");
                i = aph.f4841f;
            } else {
                try {
                    fileInputStream = new FileInputStream(listFiles[0]);
                    bArr = new byte[20];
                } catch (IOException e) {
                    m6011f(null, e.toString(), artVar);
                }
                if (fileInputStream.read(bArr) == 20) {
                    byte[] bArr2 = {0, 0};
                    if (bArr[5] == 2) {
                        m6011f(bArr, null, artVar);
                        i = aph.f4836a;
                    } else {
                        bArr2[0] = bArr[19];
                        bArr2[1] = bArr[18];
                        short s = ByteBuffer.wrap(bArr2).getShort();
                        if (s == 3) {
                            i = aph.f4838c;
                        } else if (s == 40) {
                            i = aph.f4837b;
                        } else if (s == 62) {
                            i = aph.f4840e;
                        } else if (s == 183) {
                            i = aph.f4839d;
                        } else {
                            m6011f(bArr, null, artVar);
                            i = aph.f4836a;
                        }
                    }
                    fileInputStream.close();
                } else {
                    fileInputStream.close();
                    i = aph.f4836a;
                }
            }
        }
        if (i == aph.f4841f) {
            String m6012e = m6012e(artVar);
            if (TextUtils.isEmpty(m6012e)) {
                m6011f(null, "Empty dev arch", artVar);
                i = aph.f4836a;
            } else if (m6012e.equalsIgnoreCase("i686") || m6012e.equalsIgnoreCase("x86")) {
                i = aph.f4838c;
            } else if (m6012e.equalsIgnoreCase("x86_64")) {
                i = aph.f4840e;
            } else if (m6012e.equalsIgnoreCase("arm64-v8a")) {
                i = aph.f4839d;
            } else if (m6012e.equalsIgnoreCase("armeabi-v7a") || m6012e.equalsIgnoreCase("armv71")) {
                i = aph.f4837b;
            } else {
                m6011f(null, m6012e, artVar);
                i = aph.f4836a;
            }
        }
        String m4841a = aph.m4841a(i);
        if (i != 0) {
            artVar.m4728b(5018, m4841a);
            return i;
        }
        throw null;
    }

    /* renamed from: e */
    private static final String m6012e(art artVar) {
        HashSet hashSet = new HashSet(Arrays.asList("i686", "armv71"));
        String m4622a = atl.OS_ARCH.m4622a();
        if (TextUtils.isEmpty(m4622a) || !hashSet.contains(m4622a)) {
            try {
                String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
                if (strArr != null && strArr.length > 0) {
                    return strArr[0];
                }
            } catch (IllegalAccessException e) {
                artVar.m4727c(2024, 0L, e);
            } catch (NoSuchFieldException e2) {
                artVar.m4727c(2024, 0L, e2);
            }
            return Build.CPU_ABI != null ? Build.CPU_ABI : Build.CPU_ABI2;
        }
        return m4622a;
    }

    /* renamed from: f */
    private static final void m6011f(byte[] bArr, String str, art artVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("os.arch:");
        sb.append(atl.OS_ARCH.m4622a());
        sb.append(";");
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
            if (strArr != null) {
                sb.append("supported_abis:");
                sb.append(Arrays.toString(strArr));
                sb.append(";");
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
        sb.append("CPU_ABI:");
        sb.append(Build.CPU_ABI);
        sb.append(";CPU_ABI2:");
        sb.append(Build.CPU_ABI2);
        sb.append(";");
        if (bArr != null) {
            sb.append("ELF:");
            sb.append(Arrays.toString(bArr));
            sb.append(";");
        }
        if (str != null) {
            sb.append("dbg:");
            sb.append(str);
            sb.append(";");
        }
        artVar.m4728b(4007, sb.toString());
    }
}
