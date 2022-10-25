package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public abstract class zai {
    public final int zac;

    public zai(int i) {
        this.zac = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Status zah(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract void zac(Status status);

    public abstract void zad(Exception exc);

    public abstract void zae(zaaa zaaaVar, boolean z);

    public abstract void zaf(zabl<?> zablVar) throws DeadObjectException;
}
