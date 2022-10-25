package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ew */
/* loaded from: classes2.dex */
public final /* synthetic */ class C2688ew implements atn {

    /* renamed from: a */
    public final /* synthetic */ Context f7184a;

    /* renamed from: b */
    private final /* synthetic */ int f7185b;

    public /* synthetic */ C2688ew(Context context, int i) {
        this.f7185b = i;
        this.f7184a = context;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.atn
    /* renamed from: a */
    public final Object mo1308a() {
        int i = this.f7185b;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    Context context = this.f7184a;
                    int i2 = C3225yt.f9536a;
                    return new C3054sk(context);
                }
                Context context2 = this.f7184a;
                aqf aqfVar = aql.f4888a;
                apz.m4778b().m4757e(context2);
                return null;
            }
            return new C3140vp(this.f7184a);
        }
        return C3156we.m752i(this.f7184a);
    }
}
