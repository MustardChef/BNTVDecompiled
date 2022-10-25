package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* loaded from: classes2.dex */
public final class zzq extends GmsClientSupervisor {
    private final Context zzb;
    private final Handler zzc;
    private final HashMap<zzm, zzo> zza = new HashMap<>();
    private final ConnectionTracker zzd = ConnectionTracker.getInstance();
    private final long zze = 5000;
    private final long zzf = 300000;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzq(Context context) {
        this.zzb = context.getApplicationContext();
        this.zzc = new com.google.android.gms.internal.common.zzh(context.getMainLooper(), new zzp(this, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final boolean zzb(zzm zzmVar, ServiceConnection serviceConnection, String str) {
        boolean zze;
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zza) {
            zzo zzoVar = this.zza.get(zzmVar);
            if (zzoVar == null) {
                zzoVar = new zzo(this, zzmVar);
                zzoVar.zzc(serviceConnection, serviceConnection, str);
                zzoVar.zza(str);
                this.zza.put(zzmVar, zzoVar);
            } else {
                this.zzc.removeMessages(0, zzmVar);
                if (zzoVar.zzg(serviceConnection)) {
                    String valueOf = String.valueOf(zzmVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
                zzoVar.zzc(serviceConnection, serviceConnection, str);
                int zzf = zzoVar.zzf();
                if (zzf == 1) {
                    serviceConnection.onServiceConnected(zzoVar.zzj(), zzoVar.zzi());
                } else if (zzf == 2) {
                    zzoVar.zza(str);
                }
            }
            zze = zzoVar.zze();
        }
        return zze;
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    protected final void zzc(zzm zzmVar, ServiceConnection serviceConnection, String str) {
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zza) {
            zzo zzoVar = this.zza.get(zzmVar);
            if (zzoVar == null) {
                String valueOf = String.valueOf(zzmVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (!zzoVar.zzg(serviceConnection)) {
                String valueOf2 = String.valueOf(zzmVar);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            } else {
                zzoVar.zzd(serviceConnection, str);
                if (zzoVar.zzh()) {
                    this.zzc.sendMessageDelayed(this.zzc.obtainMessage(0, zzmVar), this.zze);
                }
            }
        }
    }
}
