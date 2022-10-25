package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public final class zah extends zad<Boolean> {
    public final ListenerHolder.ListenerKey<?> zab;

    public zah(ListenerHolder.ListenerKey<?> listenerKey, TaskCompletionSource<Boolean> taskCompletionSource) {
        super(4, taskCompletionSource);
        this.zab = listenerKey;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final Feature[] zaa(zabl<?> zablVar) {
        zacc zaccVar = zablVar.zag().get(this.zab);
        if (zaccVar == null) {
            return null;
        }
        return zaccVar.zaa.getRequiredFeatures();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean zab(zabl<?> zablVar) {
        zacc zaccVar = zablVar.zag().get(this.zab);
        return zaccVar != null && zaccVar.zaa.zaa();
    }

    @Override // com.google.android.gms.common.api.internal.zad, com.google.android.gms.common.api.internal.zai
    public final /* bridge */ /* synthetic */ void zae(zaaa zaaaVar, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zad
    public final void zag(zabl<?> zablVar) throws RemoteException {
        zacc remove = zablVar.zag().remove(this.zab);
        if (remove != null) {
            remove.zab.unregisterListener(zablVar.zaf(), this.zaa);
            remove.zaa.clearListener();
            return;
        }
        this.zaa.trySetResult(false);
    }
}
