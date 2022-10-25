package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
final class zzu implements Runnable {
    final /* synthetic */ zzw zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzu(zzv zzvVar, zzw zzwVar, String str, String str2) {
        this.zza = zzwVar;
        this.zzb = str;
        this.zzc = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map map;
        Map map2;
        Cast.MessageReceivedCallback messageReceivedCallback;
        Logger logger;
        CastDevice castDevice;
        map = this.zza.zzi;
        synchronized (map) {
            map2 = this.zza.zzi;
            messageReceivedCallback = (Cast.MessageReceivedCallback) map2.get(this.zzb);
        }
        if (messageReceivedCallback != null) {
            castDevice = this.zza.zzg;
            messageReceivedCallback.onMessageReceived(castDevice, this.zzb, this.zzc);
            return;
        }
        logger = zzw.zze;
        logger.m369d("Discarded message for unknown namespace '%s'", this.zzb);
    }
}
