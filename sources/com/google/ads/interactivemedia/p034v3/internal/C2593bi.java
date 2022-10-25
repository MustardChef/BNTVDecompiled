package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.graphics.Point;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import java.util.Locale;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bi */
/* loaded from: classes2.dex */
public class C2593bi {

    /* renamed from: a */
    private int f5766a = Integer.MAX_VALUE;

    /* renamed from: b */
    private int f5767b = Integer.MAX_VALUE;

    /* renamed from: c */
    private int f5768c = Integer.MAX_VALUE;

    /* renamed from: d */
    private int f5769d = Integer.MAX_VALUE;

    /* renamed from: e */
    private int f5770e = Integer.MAX_VALUE;

    /* renamed from: f */
    private int f5771f = Integer.MAX_VALUE;

    /* renamed from: g */
    private boolean f5772g = true;

    /* renamed from: h */
    private avg f5773h = avg.m4515n();

    /* renamed from: i */
    private avg f5774i = avg.m4515n();

    /* renamed from: j */
    private int f5775j = Integer.MAX_VALUE;

    /* renamed from: k */
    private int f5776k = Integer.MAX_VALUE;

    /* renamed from: l */
    private avg f5777l = avg.m4515n();

    /* renamed from: m */
    private avg f5778m = avg.m4515n();

    /* renamed from: n */
    private int f5779n = 0;

    /* renamed from: o */
    private C2592bh f5780o = C2592bh.f5709a;

    /* renamed from: p */
    private avo f5781p = avo.m4493n();

    /* renamed from: q */
    public void mo825q(Context context) {
        CaptioningManager captioningManager;
        if (C2628cq.f6961a >= 19) {
            if ((C2628cq.f6961a >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.f5779n = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.f5778m = avg.m4514o(C2628cq.m2570M(locale));
                }
            }
        }
    }

    /* renamed from: r */
    public C2593bi mo824r(int i, int i2) {
        this.f5770e = i;
        this.f5771f = i2;
        this.f5772g = true;
        return this;
    }

    /* renamed from: s */
    public void mo823s(Context context) {
        Point m2510x = C2628cq.m2510x(context);
        mo824r(m2510x.x, m2510x.y);
    }
}
