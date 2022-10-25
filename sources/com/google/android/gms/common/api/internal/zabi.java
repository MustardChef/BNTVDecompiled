package com.google.android.gms.common.api.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public final class zabi implements Runnable {
    final /* synthetic */ int zaa;
    final /* synthetic */ zabl zab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zabi(zabl zablVar, int i) {
        this.zab = zablVar;
        this.zaa = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zab.zaC(this.zaa);
    }
}
