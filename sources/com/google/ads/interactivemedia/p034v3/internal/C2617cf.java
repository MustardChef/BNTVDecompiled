package com.google.ads.interactivemedia.p034v3.internal;

import android.content.BroadcastReceiver;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.cf */
/* loaded from: classes2.dex */
public final class C2617cf extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C2619ch f6935a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2617cf(C2619ch c2619ch) {
        this.f6935a = c2619ch;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0053  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onReceive(android.content.Context r10, android.content.Intent r11) {
        /*
            r9 = this;
            java.lang.String r11 = "connectivity"
            java.lang.Object r11 = r10.getSystemService(r11)
            android.net.ConnectivityManager r11 = (android.net.ConnectivityManager) r11
            r0 = 2
            r1 = 9
            r2 = 6
            r3 = 4
            r4 = 29
            r5 = 1
            r6 = 0
            r7 = 5
            if (r11 != 0) goto L16
        L14:
            r0 = 0
            goto L4f
        L16:
            android.net.NetworkInfo r11 = r11.getActiveNetworkInfo()     // Catch: java.lang.SecurityException -> L14
            if (r11 == 0) goto L4e
            boolean r8 = r11.isConnected()
            if (r8 != 0) goto L23
            goto L4e
        L23:
            int r8 = r11.getType()
            if (r8 == 0) goto L3a
            if (r8 == r5) goto L4f
            if (r8 == r3) goto L3a
            if (r8 == r7) goto L3a
            if (r8 == r2) goto L38
            if (r8 == r1) goto L36
            r0 = 8
            goto L4f
        L36:
            r0 = 7
            goto L4f
        L38:
            r0 = 5
            goto L4f
        L3a:
            int r11 = r11.getSubtype()
            switch(r11) {
                case 1: goto L4c;
                case 2: goto L4c;
                case 3: goto L4a;
                case 4: goto L4a;
                case 5: goto L4a;
                case 6: goto L4a;
                case 7: goto L4a;
                case 8: goto L4a;
                case 9: goto L4a;
                case 10: goto L4a;
                case 11: goto L4a;
                case 12: goto L4a;
                case 13: goto L38;
                case 14: goto L4a;
                case 15: goto L4a;
                case 16: goto L41;
                case 17: goto L4a;
                case 18: goto L4f;
                case 19: goto L41;
                case 20: goto L43;
                default: goto L41;
            }
        L41:
            r0 = 6
            goto L4f
        L43:
            int r11 = com.google.ads.interactivemedia.p034v3.internal.C2628cq.f6961a
            if (r11 < r4) goto L14
            r0 = 9
            goto L4f
        L4a:
            r0 = 4
            goto L4f
        L4c:
            r0 = 3
            goto L4f
        L4e:
            r0 = 1
        L4f:
            int r11 = com.google.ads.interactivemedia.p034v3.internal.C2628cq.f6961a
            if (r11 < r4) goto L7d
            com.google.ads.interactivemedia.p034v3.internal.C2616ce.m2692a()
            if (r0 != r7) goto L7d
            java.lang.String r11 = "phone"
            java.lang.Object r10 = r10.getSystemService(r11)     // Catch: java.lang.RuntimeException -> L7e
            android.telephony.TelephonyManager r10 = (android.telephony.TelephonyManager) r10     // Catch: java.lang.RuntimeException -> L7e
            com.google.ads.interactivemedia.p034v3.internal.C2616ce.m2689d(r10)     // Catch: java.lang.RuntimeException -> L7e
            com.google.ads.interactivemedia.v3.internal.cg r11 = new com.google.ads.interactivemedia.v3.internal.cg     // Catch: java.lang.RuntimeException -> L7e
            com.google.ads.interactivemedia.v3.internal.ch r0 = r9.f6935a     // Catch: java.lang.RuntimeException -> L7e
            r11.<init>(r0)     // Catch: java.lang.RuntimeException -> L7e
            int r0 = com.google.ads.interactivemedia.p034v3.internal.C2628cq.f6961a     // Catch: java.lang.RuntimeException -> L7e
            r1 = 31
            if (r0 >= r1) goto L74
            r10.listen(r11, r5)     // Catch: java.lang.RuntimeException -> L7e
            goto L79
        L74:
            r0 = 1048576(0x100000, float:1.469368E-39)
            r10.listen(r11, r0)     // Catch: java.lang.RuntimeException -> L7e
        L79:
            r10.listen(r11, r6)     // Catch: java.lang.RuntimeException -> L7e
            return
        L7d:
            r7 = r0
        L7e:
            com.google.ads.interactivemedia.v3.internal.ch r10 = r9.f6935a
            com.google.ads.interactivemedia.p034v3.internal.C2619ch.m2665c(r10, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2617cf.onReceive(android.content.Context, android.content.Intent):void");
    }
}
