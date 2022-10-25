package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.ads.interactivemedia.p034v3.impl.data.C2472aq;
import com.google.android.gms.common.util.Hex;
import java.io.File;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.asq */
/* loaded from: classes2.dex */
public final class asq {

    /* renamed from: a */
    final File f5002a;

    /* renamed from: b */
    private final File f5003b;

    /* renamed from: c */
    private final SharedPreferences f5004c;

    /* renamed from: d */
    private final int f5005d;

    public asq(Context context, int i) {
        this.f5004c = context.getSharedPreferences("pcvmspf", 0);
        File dir = context.getDir("pccache", 0);
        C2472aq.m6004e(dir, false);
        this.f5003b = dir;
        File dir2 = context.getDir("tmppccache", 0);
        C2472aq.m6004e(dir2, true);
        this.f5002a = dir2;
        this.f5005d = i;
    }

    /* renamed from: a */
    static String m4668a(apk apkVar) {
        return Hex.bytesToStringLowercase(apkVar.mo3177ap().m3509C());
    }

    /* renamed from: e */
    private final File m4664e() {
        File file = new File(this.f5003b, Integer.toString(aph.m4840b(this.f5005d)));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    /* renamed from: f */
    private final String m4663f() {
        int m4840b = aph.m4840b(this.f5005d);
        StringBuilder sb = new StringBuilder(17);
        sb.append("FBAMTD");
        sb.append(m4840b);
        return sb.toString();
    }

    /* renamed from: g */
    private final String m4662g() {
        int m4840b = aph.m4840b(this.f5005d);
        StringBuilder sb = new StringBuilder(17);
        sb.append("LATMTD");
        sb.append(m4840b);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0160  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m4667b(com.google.ads.interactivemedia.p034v3.internal.C2557api r8, com.google.ads.interactivemedia.p034v3.internal.InterfaceC2563ast r9) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.asq.m4667b(com.google.ads.interactivemedia.v3.internal.api, com.google.ads.interactivemedia.v3.internal.ast):boolean");
    }

    /* renamed from: c */
    final apk m4666c(int i) {
        String string;
        if (i == 1) {
            string = this.f5004c.getString(m4662g(), null);
        } else {
            string = this.f5004c.getString(m4663f(), null);
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            apk m4823g = apk.m4823g(bls.m3504t(Hex.stringToBytes(string)));
            String m4820k = m4823g.m4820k();
            File m6008a = C2472aq.m6008a(m4820k, "pcam.jar", m4664e());
            if (!m6008a.exists()) {
                m6008a = C2472aq.m6008a(m4820k, "pcam", m4664e());
            }
            File m6008a2 = C2472aq.m6008a(m4820k, "pcbc", m4664e());
            if (m6008a.exists()) {
                if (m6008a2.exists()) {
                    return m4823g;
                }
            }
        } catch (bnm unused) {
        }
        return null;
    }

    /* renamed from: d */
    public final asp m4665d(int i) {
        apk m4666c = m4666c(1);
        if (m4666c == null) {
            return null;
        }
        String m4820k = m4666c.m4820k();
        File m6008a = C2472aq.m6008a(m4820k, "pcam.jar", m4664e());
        if (!m6008a.exists()) {
            m6008a = C2472aq.m6008a(m4820k, "pcam", m4664e());
        }
        return new asp(m4666c, m6008a, C2472aq.m6008a(m4820k, "pcbc", m4664e()), C2472aq.m6008a(m4820k, "pcopt", m4664e()));
    }
}
