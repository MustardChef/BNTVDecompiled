package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzal {
    public static <R extends Result, T> PendingResult<R> zza(Task<T> task, final zzak<R, T> zzakVar, final zzak<R, Status> zzakVar2) {
        final zzaj zzajVar = new zzaj(zzakVar2);
        task.addOnSuccessListener(new OnSuccessListener(zzajVar, zzakVar) { // from class: com.google.android.gms.internal.cast.zzah
            private final zzaj zza;
            private final zzak zzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = zzajVar;
                this.zzb = zzakVar;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                zzaj zzajVar2 = this.zza;
                Void r3 = (Void) obj;
                int i = CastSession.zza;
                zzajVar2.setResult(new Status(0));
            }
        }).addOnFailureListener(new OnFailureListener(zzajVar, zzakVar2) { // from class: com.google.android.gms.internal.cast.zzai
            private final zzaj zza;
            private final zzak zzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = zzajVar;
                this.zzb = zzakVar2;
            }

            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                zzaj zzajVar2 = this.zza;
                Status status = new Status(8, "unknown error");
                if (exc instanceof ApiException) {
                    ApiException apiException = (ApiException) exc;
                    status = new Status(apiException.getStatusCode(), apiException.getMessage());
                }
                int i = CastSession.zza;
                zzajVar2.setResult(status);
            }
        });
        return zzajVar;
    }
}
