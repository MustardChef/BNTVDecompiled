package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.alq */
/* loaded from: classes2.dex */
public final class alq {

    /* renamed from: a */
    private final Context f4398a;

    /* renamed from: b */
    private final boolean f4399b;

    public alq(Context context, boolean z) {
        this.f4398a = context;
        this.f4399b = z;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:6:0x001e
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* renamed from: a */
    public final com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2490bh m5019a() {
        /*
            r8 = this;
            com.google.ads.interactivemedia.v3.internal.alp r0 = new com.google.ads.interactivemedia.v3.internal.alp
            java.lang.String r1 = ""
            r2 = 0
            r0.<init>(r1, r2)
            android.content.Context r3 = r8.f4398a     // Catch: java.lang.Throwable -> L1f
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r3 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r3)     // Catch: java.lang.Throwable -> L1f
            com.google.ads.interactivemedia.v3.internal.alp r4 = new com.google.ads.interactivemedia.v3.internal.alp     // Catch: java.lang.Throwable -> L1f
            java.lang.String r5 = r3.getId()     // Catch: java.lang.Throwable -> L1f
            boolean r3 = r3.isLimitAdTrackingEnabled()     // Catch: java.lang.Throwable -> L1f
            r4.<init>(r5, r3)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r0 = "adid"
            goto L45
        L1e:
            r0 = r4
        L1f:
            android.content.Context r3 = r8.f4398a     // Catch: android.provider.Settings.SettingNotFoundException -> L3e
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch: android.provider.Settings.SettingNotFoundException -> L3e
            com.google.ads.interactivemedia.v3.internal.alp r4 = new com.google.ads.interactivemedia.v3.internal.alp     // Catch: android.provider.Settings.SettingNotFoundException -> L3e
            java.lang.String r5 = "advertising_id"
            java.lang.String r5 = android.provider.Settings.Secure.getString(r3, r5)     // Catch: android.provider.Settings.SettingNotFoundException -> L3e
            java.lang.String r6 = "limit_ad_tracking"
            int r3 = android.provider.Settings.Secure.getInt(r3, r6)     // Catch: android.provider.Settings.SettingNotFoundException -> L3e
            r6 = 1
            if (r3 != r6) goto L37
            goto L38
        L37:
            r6 = 0
        L38:
            r4.<init>(r5, r6)     // Catch: android.provider.Settings.SettingNotFoundException -> L3e
            java.lang.String r0 = "afai"
            goto L45
        L3e:
            r4 = r0
        L3f:
            java.lang.String r0 = "Failed to get advertising ID."
            com.google.ads.interactivemedia.p034v3.impl.data.C2525p.m5988d(r0)
            r0 = r1
        L45:
            boolean r3 = r8.f4399b
            if (r3 == 0) goto L71
            android.content.Context r3 = r8.f4398a     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L6c
            com.google.android.gms.appset.AppSetIdClient r3 = com.google.android.gms.appset.AppSet.getClient(r3)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L6c
            com.google.android.gms.tasks.Task r3 = r3.getAppSetIdInfo()     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L6c
            r5 = 150(0x96, double:7.4E-322)
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L6c
            java.lang.Object r3 = com.google.android.gms.tasks.Tasks.await(r3, r5, r7)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L6c
            com.google.android.gms.appset.AppSetIdInfo r3 = (com.google.android.gms.appset.AppSetIdInfo) r3     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L6c
            java.lang.String r1 = r3.getId()     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L6c
            int r2 = r3.getScope()     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L6c
            goto L71
        L66:
            java.lang.String r3 = "Unable to contact the App Set SDK."
            com.google.ads.interactivemedia.p034v3.impl.data.C2525p.m5988d(r3)
            goto L71
        L6c:
            java.lang.String r3 = "Timeout getting AppSet ID."
            com.google.ads.interactivemedia.p034v3.impl.data.C2525p.m5988d(r3)
        L71:
            java.lang.String r3 = r4.f4396a
            boolean r4 = r4.f4397b
            com.google.ads.interactivemedia.v3.impl.data.bh r0 = com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2490bh.create(r3, r0, r4, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.alq.m5019a():com.google.ads.interactivemedia.v3.impl.data.bh");
    }
}
