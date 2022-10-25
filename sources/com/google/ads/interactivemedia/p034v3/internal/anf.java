package com.google.ads.interactivemedia.p034v3.internal;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.anf */
/* loaded from: classes2.dex */
public final class anf extends ConnectivityManager.NetworkCallback {

    /* renamed from: a */
    final /* synthetic */ ang f4709a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public anf(ang angVar) {
        this.f4709a = angVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        synchronized (ang.class) {
            this.f4709a.f4710a = networkCapabilities;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        synchronized (ang.class) {
            this.f4709a.f4710a = null;
        }
    }
}
