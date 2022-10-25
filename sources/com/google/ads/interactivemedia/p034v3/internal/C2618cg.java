package com.google.ads.interactivemedia.p034v3.internal;

import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyDisplayInfo;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.cg */
/* loaded from: classes2.dex */
final class C2618cg extends PhoneStateListener {

    /* renamed from: a */
    final /* synthetic */ C2619ch f6936a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2618cg(C2619ch c2619ch) {
        this.f6936a = c2619ch;
    }

    @Override // android.telephony.PhoneStateListener
    public final void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
        int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
        C2619ch.m2665c(this.f6936a, true != (overrideNetworkType == 3 || overrideNetworkType == 4) ? 5 : 10);
    }

    @Override // android.telephony.PhoneStateListener
    public final void onServiceStateChanged(ServiceState serviceState) {
        String serviceState2 = serviceState == null ? "" : serviceState.toString();
        C2619ch.m2665c(this.f6936a, true != (serviceState2.contains("nrState=CONNECTED") || serviceState2.contains("nrState=NOT_RESTRICTED")) ? 5 : 10);
    }
}
