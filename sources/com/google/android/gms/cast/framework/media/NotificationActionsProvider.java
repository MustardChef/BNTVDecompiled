package com.google.android.gms.cast.framework.media;

import android.content.Context;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public abstract class NotificationActionsProvider {
    private final Context zza;
    private final zzg zzb = new zzaa(this, null);

    public NotificationActionsProvider(Context context) {
        this.zza = context.getApplicationContext();
    }

    public Context getApplicationContext() {
        return this.zza;
    }

    public abstract int[] getCompactViewActionIndices();

    public abstract List<NotificationAction> getNotificationActions();

    public final zzg zza() {
        return this.zzb;
    }
}
