package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
final class zam {
    private final int zaa;
    private final ConnectionResult zab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zam(ConnectionResult connectionResult, int i) {
        Preconditions.checkNotNull(connectionResult);
        this.zab = connectionResult;
        this.zaa = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zaa() {
        return this.zaa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ConnectionResult zab() {
        return this.zab;
    }
}
