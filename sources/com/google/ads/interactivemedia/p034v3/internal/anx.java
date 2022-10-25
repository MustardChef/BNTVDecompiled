package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.impl.data.C2467al;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.anx */
/* loaded from: classes2.dex */
public final class anx {

    /* renamed from: a */
    static azg f4759a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m4883a(anw anwVar) throws IllegalAccessException, InvocationTargetException {
        Method m4901i;
        if (f4759a != null) {
            return;
        }
        String str = (String) aql.f4905r.m4770f();
        if (str == null || str.length() == 0) {
            str = null;
            if (anwVar != null && (m4901i = anwVar.m4901i("PDJGtr7hH5z8kziZtOwKBHfUklGaxsnuMOcaf4/XJNQXH5uqgOnO+ZxxlrN1G5R2", "8jFByxLLStK1ZA6Q/SQPKITUmXlRJfaQf0bJ+6rt27M=")) != null) {
                str = (String) m4901i.invoke(null, new Object[0]);
            }
            if (str == null) {
                return;
            }
        }
        try {
            azp m4262a = azt.m4262a(C2467al.m6015b(str, true));
            for (bee beeVar : bcc.f5409a.m3872c()) {
                if (!beeVar.m3924e().isEmpty()) {
                    if (!beeVar.m3925d().isEmpty()) {
                        if (!beeVar.m3926c().isEmpty()) {
                            if (!beeVar.m3926c().equals("TinkAead") && !beeVar.m3926c().equals("TinkMac") && !beeVar.m3926c().equals("TinkHybridDecrypt") && !beeVar.m3926c().equals("TinkHybridEncrypt") && !beeVar.m3926c().equals("TinkPublicKeySign") && !beeVar.m3926c().equals("TinkPublicKeyVerify") && !beeVar.m3926c().equals("TinkStreamingAead") && !beeVar.m3926c().equals("TinkDeterministicAead")) {
                                azc m4242a = bae.m4242a(beeVar.m3926c());
                                bae.m4232k(m4242a.m4288a());
                                beeVar.m3924e();
                                beeVar.m3925d();
                                beeVar.m3928a();
                                bae.m4233j(m4242a.m4287b(), beeVar.m3923f());
                            }
                        } else {
                            throw new GeneralSecurityException("Missing catalogue_name.");
                        }
                    } else {
                        throw new GeneralSecurityException("Missing primitive_name.");
                    }
                } else {
                    throw new GeneralSecurityException("Missing type_url.");
                }
            }
            f4759a = bcf.m4188a(m4262a);
        } catch (IllegalArgumentException | GeneralSecurityException unused) {
        }
    }

    /* renamed from: b */
    public static boolean m4882b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: c */
    public static String m4881c(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (m4877g(str.charAt(i))) {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c = charArray[i];
                    if (m4877g(c)) {
                        charArray[i] = (char) (c ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    /* renamed from: d */
    public static String m4880d(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (m4878f(str.charAt(i))) {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c = charArray[i];
                    if (m4878f(c)) {
                        charArray[i] = (char) (c ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    /* renamed from: e */
    public static boolean m4879e(CharSequence charSequence, CharSequence charSequence2) {
        int m4876h;
        int length = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (length == charSequence2.length()) {
            for (int i = 0; i < length; i++) {
                char charAt = charSequence.charAt(i);
                char charAt2 = charSequence2.charAt(i);
                if (charAt != charAt2 && ((m4876h = m4876h(charAt)) >= 26 || m4876h != m4876h(charAt2))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public static boolean m4878f(char c) {
        return c >= 'a' && c <= 'z';
    }

    /* renamed from: g */
    public static boolean m4877g(char c) {
        return c >= 'A' && c <= 'Z';
    }

    /* renamed from: h */
    private static int m4876h(char c) {
        return (char) ((c | ' ') - 97);
    }
}
