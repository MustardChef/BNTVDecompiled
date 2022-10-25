package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public final class zaf extends zad<Void> {
    public final zacc zab;

    public zaf(zacc zaccVar, TaskCompletionSource<Void> taskCompletionSource) {
        super(3, taskCompletionSource);
        this.zab = zaccVar;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final Feature[] zaa(zabl<?> zablVar) {
        return this.zab.zaa.getRequiredFeatures();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean zab(zabl<?> zablVar) {
        return this.zab.zaa.zaa();
    }

    @Override // com.google.android.gms.common.api.internal.zad, com.google.android.gms.common.api.internal.zai
    public final /* bridge */ /* synthetic */ void zae(zaaa zaaaVar, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zad
    public final void zag(zabl<?> zablVar) throws RemoteException {
        this.zab.zaa.registerListener(zablVar.zaf(), this.zaa);
        ListenerHolder.ListenerKey<?> listenerKey = this.zab.zaa.getListenerKey();
        if (listenerKey != null) {
            zablVar.zag().put(listenerKey, this.zab);
        }
    }
}
