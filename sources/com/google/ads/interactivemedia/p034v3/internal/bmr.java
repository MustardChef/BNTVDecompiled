package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bmr */
/* loaded from: classes2.dex */
public class bmr {

    /* renamed from: a */
    static final bmr f6172a = new bmr(null);

    /* renamed from: b */
    private static volatile boolean f6173b = false;

    /* renamed from: c */
    private static volatile bmr f6174c;

    /* renamed from: d */
    private static volatile bmr f6175d;

    /* renamed from: e */
    private final Map f6176e;

    bmr() {
        this.f6176e = new HashMap();
    }

    /* renamed from: a */
    public static bmr m3341a() {
        bmr bmrVar = f6174c;
        if (bmrVar == null) {
            synchronized (bmr.class) {
                bmrVar = f6174c;
                if (bmrVar == null) {
                    bmrVar = f6172a;
                    f6174c = bmrVar;
                }
            }
        }
        return bmrVar;
    }

    /* renamed from: c */
    public bmp mo2766c(boj bojVar, int i) {
        return (bmp) this.f6176e.get(new bmq(bojVar, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bmr(byte[] bArr) {
        this.f6176e = Collections.emptyMap();
    }

    /* renamed from: b */
    public static bmr m3340b() {
        bmr bmrVar = f6175d;
        if (bmrVar != null) {
            return bmrVar;
        }
        synchronized (bmr.class) {
            bmr bmrVar2 = f6175d;
            if (bmrVar2 != null) {
                return bmrVar2;
            }
            bmr m3313b = bmy.m3313b(bmr.class);
            f6175d = m3313b;
            return m3313b;
        }
    }
}
