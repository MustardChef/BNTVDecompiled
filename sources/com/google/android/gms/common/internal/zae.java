package com.google.android.gms.common.internal;

import android.content.Intent;
import androidx.fragment.app.Fragment;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
final class zae extends zag {
    final /* synthetic */ Intent zaa;
    final /* synthetic */ Fragment zab;
    final /* synthetic */ int zac;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zae(Intent intent, Fragment fragment, int i) {
        this.zaa = intent;
        this.zab = fragment;
        this.zac = i;
    }

    @Override // com.google.android.gms.common.internal.zag
    public final void zaa() {
        Intent intent = this.zaa;
        if (intent != null) {
            this.zab.startActivityForResult(intent, this.zac);
        }
    }
}
