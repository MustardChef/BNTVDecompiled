package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
final class zaaj extends zabb {
    final /* synthetic */ ConnectionResult zaa;
    final /* synthetic */ zaal zab;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zaaj(zaal zaalVar, zaba zabaVar, ConnectionResult connectionResult) {
        super(zabaVar);
        this.zab = zaalVar;
        this.zaa = connectionResult;
    }

    @Override // com.google.android.gms.common.api.internal.zabb
    public final void zaa() {
        this.zab.zaa.zaF(this.zaa);
    }
}
