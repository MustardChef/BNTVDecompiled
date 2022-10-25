package com.google.ads.interactivemedia.p034v3.internal;

import java.io.EOFException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Locale;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.axn */
/* loaded from: classes2.dex */
public final class axn {
    /* renamed from: a */
    public static int[] m4380a(Collection collection) {
        if (collection instanceof axm) {
            axm axmVar = (axm) collection;
            throw null;
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            Object obj = array[i];
            atm.m4612j(obj);
            iArr[i] = ((Number) obj).intValue();
        }
        return iArr;
    }

    /* renamed from: b */
    public static int m4379b(boolean z, boolean z2) {
        if (z == z2) {
            return 0;
        }
        return !z ? -1 : 1;
    }

    /* renamed from: c */
    public static bgm m4378c(bkv bkvVar) throws bgq {
        boolean z;
        try {
            try {
                bkvVar.mo3574r();
                try {
                    return (bgm) bkh.f5911S.read(bkvVar);
                } catch (EOFException e) {
                    e = e;
                    z = false;
                    if (z) {
                        return bgo.f5697a;
                    }
                    throw new bgt(e);
                }
            } catch (bky e2) {
                throw new bgt(e2);
            } catch (IOException e3) {
                throw new bgn(e3);
            } catch (NumberFormatException e4) {
                throw new bgt(e4);
            }
        } catch (EOFException e5) {
            e = e5;
            z = true;
        }
    }

    /* renamed from: d */
    public static void m4377d(bgm bgmVar, bkx bkxVar) throws IOException {
        bkh.f5911S.write(bkxVar, bgmVar);
    }

    /* renamed from: e */
    public static DateFormat m4376e(int i, int i2) {
        StringBuilder sb = new StringBuilder(21);
        sb.append("MMM d, yyyy");
        sb.append(" ");
        sb.append("h:mm:ss a");
        return new SimpleDateFormat(sb.toString(), Locale.US);
    }
}
