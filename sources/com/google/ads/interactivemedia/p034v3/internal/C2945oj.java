package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.extractor.p035ts.TsExtractor;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.oj */
/* loaded from: classes2.dex */
public final class C2945oj implements InterfaceC2954os {

    /* renamed from: b */
    private static final int[] f8249b = {8, 13, 11, 2, 0, 1, 7};

    /* renamed from: b */
    private static void m1477b(int i, List list) {
        int[] iArr = f8249b;
        for (int i2 = 0; i2 < 7; i2++) {
            if (iArr[i2] == i) {
                Integer valueOf = Integer.valueOf(i);
                if (list.contains(valueOf)) {
                    return;
                }
                list.add(valueOf);
                return;
            }
        }
    }

    /* renamed from: c */
    private static boolean m1476c(InterfaceC3229yx interfaceC3229yx, InterfaceC3230yy interfaceC3230yy) throws IOException {
        try {
            boolean mo433D = interfaceC3229yx.mo433D(interfaceC3230yy);
            interfaceC3230yy.mo494h();
            return mo433D;
        } catch (EOFException unused) {
            interfaceC3230yy.mo494h();
            return false;
        } catch (Throwable th) {
            interfaceC3230yy.mo494h();
            throw th;
        }
    }

    /* renamed from: a */
    public final C2943oh m1478a(Uri uri, C2962p c2962p, List list, C2626co c2626co, Map map, InterfaceC3230yy interfaceC3230yy) throws IOException {
        InterfaceC3229yx acwVar;
        int i;
        List singletonList;
        int i2;
        int m5963a = C2539ab.m5963a(c2962p.f8372l);
        int m5962b = C2539ab.m5962b(map);
        int m5961c = C2539ab.m5961c(uri);
        int i3 = 7;
        ArrayList arrayList = new ArrayList(7);
        m1477b(m5963a, arrayList);
        m1477b(m5962b, arrayList);
        m1477b(m5961c, arrayList);
        int[] iArr = f8249b;
        for (int i4 = 0; i4 < 7; i4++) {
            m1477b(iArr[i4], arrayList);
        }
        interfaceC3230yy.mo494h();
        int i5 = 0;
        InterfaceC3229yx interfaceC3229yx = null;
        while (i5 < arrayList.size()) {
            int intValue = ((Integer) arrayList.get(i5)).intValue();
            if (intValue == 0) {
                acwVar = new acw();
            } else if (intValue == 1) {
                acwVar = new acz();
            } else if (intValue == 2) {
                acwVar = new adb();
            } else if (intValue == i3) {
                acwVar = new abn(0L);
            } else if (intValue == 8) {
                C2549ak c2549ak = c2962p.f8370j;
                if (c2549ak != null) {
                    int i6 = 0;
                    while (true) {
                        if (i6 >= c2549ak.m5127a()) {
                            break;
                        }
                        InterfaceC2548aj m5126b = c2549ak.m5126b(i6);
                        if (!(m5126b instanceof C2970ph)) {
                            i6++;
                        } else if (!((C2970ph) m5126b).f8457c.isEmpty()) {
                            i = 4;
                        }
                    }
                }
                i = 0;
                acwVar = new acg(i, c2626co, list != null ? list : Collections.emptyList());
            } else if (intValue == 11) {
                if (list != null) {
                    i2 = 48;
                    singletonList = list;
                } else {
                    C2935o c2935o = new C2935o();
                    c2935o.m1532ae(MimeTypes.APPLICATION_CEA608);
                    singletonList = Collections.singletonList(c2935o.m1506v());
                    i2 = 16;
                }
                String str = c2962p.f8369i;
                if (!TextUtils.isEmpty(str)) {
                    if (!C2554an.m4965l(str, MimeTypes.AUDIO_AAC)) {
                        i2 |= 2;
                    }
                    if (!C2554an.m4965l(str, MimeTypes.VIDEO_H264)) {
                        i2 |= 4;
                    }
                }
                acwVar = new aef(2, c2626co, new add(i2, singletonList), TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES);
            } else {
                acwVar = intValue != 13 ? null : new C2973pk(c2962p.f8363c, c2626co);
            }
            C2616ce.m2689d(acwVar);
            if (m1476c(acwVar, interfaceC3230yy)) {
                return new C2943oh(acwVar, c2962p, c2626co);
            }
            if (interfaceC3229yx == null && (intValue == m5963a || intValue == m5962b || intValue == m5961c || intValue == 11)) {
                interfaceC3229yx = acwVar;
            }
            i5++;
            i3 = 7;
        }
        C2616ce.m2689d(interfaceC3229yx);
        return new C2943oh(interfaceC3229yx, c2962p, c2626co);
    }
}
