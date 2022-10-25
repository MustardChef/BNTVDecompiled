package com.google.android.gms.cast.internal;

import android.os.Handler;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.internal.cast.zzci;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzv extends zzaf {
    private final AtomicReference<zzw> zza;
    private final Handler zzb;

    public zzv(zzw zzwVar) {
        this.zza = new AtomicReference<>(zzwVar);
        this.zzb = new zzci(zzwVar.getLooper());
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzb(int i) {
        Logger logger;
        zzw zzq = zzq();
        if (zzq == null) {
            return;
        }
        logger = zzw.zze;
        logger.m369d("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i));
        if (i != 0) {
            zzq.triggerConnectionSuspended(2);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzc(int i) {
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzd(int i) {
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zze(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
        Object obj;
        BaseImplementation.ResultHolder resultHolder;
        BaseImplementation.ResultHolder resultHolder2;
        zzw zzwVar = this.zza.get();
        if (zzwVar == null) {
            return;
        }
        zzwVar.zzf = applicationMetadata;
        zzwVar.zzw = applicationMetadata.getApplicationId();
        zzwVar.zzx = str2;
        zzwVar.zzm = str;
        obj = zzw.zzC;
        synchronized (obj) {
            resultHolder = zzwVar.zzA;
            if (resultHolder != null) {
                resultHolder2 = zzwVar.zzA;
                resultHolder2.setResult(new zzq(new Status(0), applicationMetadata, str, str2, z));
                zzwVar.zzA = null;
            }
        }
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzf(int i) {
        zzw zzwVar = this.zza.get();
        if (zzwVar == null) {
            return;
        }
        zzwVar.zzH(i);
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzg(int i) {
        zzw zzwVar = this.zza.get();
        if (zzwVar == null) {
            return;
        }
        zzwVar.zzad(i);
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzh(int i) {
        zzw zzwVar = this.zza.get();
        if (zzwVar == null) {
            return;
        }
        zzwVar.zzad(i);
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzi(int i) {
        Cast.Listener listener;
        zzw zzwVar = this.zza.get();
        if (zzwVar == null) {
            return;
        }
        zzwVar.zzw = null;
        zzwVar.zzx = null;
        zzwVar.zzad(i);
        listener = zzwVar.zzh;
        if (listener != null) {
            this.zzb.post(new zzr(this, zzwVar, i));
        }
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzj(String str, double d, boolean z) {
        Logger logger;
        logger = zzw.zze;
        logger.m369d("Deprecated callback: \"onStatusreceived\"", new Object[0]);
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzk(zzy zzyVar) {
        Logger logger;
        zzw zzwVar = this.zza.get();
        if (zzwVar == null) {
            return;
        }
        logger = zzw.zze;
        logger.m369d("onDeviceStatusChanged", new Object[0]);
        this.zzb.post(new zzs(this, zzwVar, zzyVar));
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzl(zza zzaVar) {
        Logger logger;
        zzw zzwVar = this.zza.get();
        if (zzwVar == null) {
            return;
        }
        logger = zzw.zze;
        logger.m369d("onApplicationStatusChanged", new Object[0]);
        this.zzb.post(new zzt(this, zzwVar, zzaVar));
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzm(String str, String str2) {
        Logger logger;
        zzw zzwVar = this.zza.get();
        if (zzwVar == null) {
            return;
        }
        logger = zzw.zze;
        logger.m369d("Receive (type=text, ns=%s) %s", str, str2);
        this.zzb.post(new zzu(this, zzwVar, str, str2));
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzn(String str, byte[] bArr) {
        Logger logger;
        if (this.zza.get() == null) {
            return;
        }
        logger = zzw.zze;
        logger.m369d("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzo(String str, long j, int i) {
        zzw zzwVar = this.zza.get();
        if (zzwVar == null) {
            return;
        }
        zzwVar.zzac(j, i);
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzp(String str, long j) {
        zzw zzwVar = this.zza.get();
        if (zzwVar == null) {
            return;
        }
        zzwVar.zzac(j, 0);
    }

    public final zzw zzq() {
        zzw andSet = this.zza.getAndSet(null);
        if (andSet == null) {
            return null;
        }
        andSet.zzY();
        return andSet;
    }

    public final boolean zzr() {
        return this.zza.get() == null;
    }
}
