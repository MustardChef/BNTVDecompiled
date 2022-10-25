package com.google.android.gms.cast.framework.media;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
final class zzaa extends zzf {
    final /* synthetic */ NotificationActionsProvider zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzaa(NotificationActionsProvider notificationActionsProvider, zzz zzzVar) {
        this.zza = notificationActionsProvider;
    }

    @Override // com.google.android.gms.cast.framework.media.zzg
    public final IObjectWrapper zze() {
        return ObjectWrapper.wrap(this.zza);
    }

    @Override // com.google.android.gms.cast.framework.media.zzg
    public final List<NotificationAction> zzf() {
        return this.zza.getNotificationActions();
    }

    @Override // com.google.android.gms.cast.framework.media.zzg
    public final int[] zzg() {
        return this.zza.getCompactViewActionIndices();
    }
}
