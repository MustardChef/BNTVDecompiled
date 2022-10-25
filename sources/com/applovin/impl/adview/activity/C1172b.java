package com.applovin.impl.adview.activity;

import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.adview.activity.b */
/* loaded from: classes.dex */
public class C1172b {

    /* renamed from: a */
    private final AppLovinFullscreenActivity f362a;

    /* renamed from: b */
    private final int f363b;

    /* renamed from: c */
    private final int f364c;

    /* renamed from: d */
    private final boolean f365d;

    public C1172b(AppLovinFullscreenActivity appLovinFullscreenActivity) {
        this.f362a = appLovinFullscreenActivity;
        int rotation = Utils.getRotation(appLovinFullscreenActivity);
        this.f364c = rotation;
        boolean isTablet = AppLovinSdkUtils.isTablet(appLovinFullscreenActivity);
        this.f365d = isTablet;
        this.f363b = m8271a(rotation, isTablet);
    }

    /* renamed from: a */
    private int m8271a(int i, boolean z) {
        if (z) {
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 9;
            }
            if (i == 2) {
                return 8;
            }
            return i == 3 ? 1 : -1;
        } else if (i == 0) {
            return 1;
        } else {
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 9;
            }
            return i == 3 ? 8 : -1;
        }
    }

    /* renamed from: a */
    private void m8272a(int i) {
        try {
            this.f362a.setRequestedOrientation(i);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0032, code lost:
        if (r6 == 2) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0035, code lost:
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x003f, code lost:
        if (r6 == 1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
        if (r6 != 3) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0010, code lost:
        if (r6 != 1) goto L7;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m8270a(com.applovin.impl.sdk.p027a.AbstractC1537g.EnumC1540b r5, int r6, boolean r7) {
        /*
            r4 = this;
            com.applovin.impl.sdk.a.g$b r0 = com.applovin.impl.sdk.p027a.AbstractC1537g.EnumC1540b.ACTIVITY_PORTRAIT
            r1 = 3
            r2 = 2
            r3 = 1
            if (r5 != r0) goto L24
            r5 = 9
            if (r7 == 0) goto L16
            if (r6 == r3) goto L10
            if (r6 == r1) goto L10
            goto L1a
        L10:
            if (r6 != r3) goto L1a
        L12:
            r4.m8272a(r5)
            goto L42
        L16:
            if (r6 == 0) goto L1e
            if (r6 == r2) goto L1e
        L1a:
            r4.m8272a(r3)
            goto L42
        L1e:
            if (r6 != 0) goto L21
            goto L1a
        L21:
            r3 = 9
            goto L1a
        L24:
            com.applovin.impl.sdk.a.g$b r0 = com.applovin.impl.sdk.p027a.AbstractC1537g.EnumC1540b.ACTIVITY_LANDSCAPE
            if (r5 != r0) goto L42
            r5 = 8
            r0 = 0
            if (r7 == 0) goto L37
            if (r6 == 0) goto L32
            if (r6 == r2) goto L32
            goto L3b
        L32:
            if (r6 != r2) goto L35
            goto L12
        L35:
            r5 = 0
            goto L12
        L37:
            if (r6 == r3) goto L3f
            if (r6 == r1) goto L3f
        L3b:
            r4.m8272a(r0)
            goto L42
        L3f:
            if (r6 != r3) goto L12
            goto L35
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.activity.C1172b.m8270a(com.applovin.impl.sdk.a.g$b, int, boolean):void");
    }

    /* renamed from: a */
    public void m8269a(AbstractC1537g abstractC1537g) {
        int i;
        if (!abstractC1537g.m7168E() || (i = this.f363b) == -1) {
            m8270a(abstractC1537g.m7078q(), this.f364c, this.f365d);
        } else {
            m8272a(i);
        }
    }
}
