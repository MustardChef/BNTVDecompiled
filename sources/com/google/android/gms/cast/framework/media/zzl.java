package com.google.android.gms.cast.framework.media;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.TaskStackBuilder;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzch;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
final class zzl extends BroadcastReceiver {
    final /* synthetic */ MediaNotificationService zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzl(MediaNotificationService mediaNotificationService) {
        this.zza = mediaNotificationService;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        CastContext castContext;
        PendingIntent pendingIntent;
        Logger logger;
        ComponentName componentName = (ComponentName) Preconditions.checkNotNull((ComponentName) intent.getParcelableExtra("targetActivity"));
        Intent intent2 = new Intent();
        intent2.setComponent(componentName);
        castContext = this.zza.zzq;
        if (castContext.zzb()) {
            intent2.setFlags(603979776);
            pendingIntent = zzch.zza(context, 1, intent2, zzch.zza | 134217728);
        } else {
            TaskStackBuilder create = TaskStackBuilder.create(this.zza);
            create.addParentStack(componentName);
            create.addNextIntent(intent2);
            pendingIntent = create.getPendingIntent(1, zzch.zza | 134217728);
        }
        try {
            ((PendingIntent) Preconditions.checkNotNull(pendingIntent)).send(context, 1, new Intent().setFlags(268435456));
        } catch (PendingIntent.CanceledException e) {
            logger = MediaNotificationService.zza;
            logger.m368d(e, "Sending PendingIntent failed", new Object[0]);
        }
    }
}
