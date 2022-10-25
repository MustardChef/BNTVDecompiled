package com.google.android.gms.cast;

import com.google.android.gms.cast.CastRemoteDisplayLocalService;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzag implements OnCompleteListener<Void> {
    final /* synthetic */ CastRemoteDisplayLocalService zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzag(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        this.zza = castRemoteDisplayLocalService;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<Void> task) {
        WeakReference weakReference;
        if (!task.isSuccessful()) {
            this.zza.zzx("Unable to stop the remote display, result unsuccessful");
            weakReference = this.zza.zzf;
            CastRemoteDisplayLocalService.Callbacks callbacks = (CastRemoteDisplayLocalService.Callbacks) weakReference.get();
            if (callbacks != null) {
                callbacks.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_STOPPING_SERVICE_FAILED));
            }
        } else {
            this.zza.zzx("remote display stopped");
        }
        this.zza.zzm = null;
    }
}
