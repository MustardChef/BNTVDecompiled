package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Status;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzbj extends com.google.android.gms.cast.internal.zzaf {
    final /* synthetic */ zzbk zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbj(zzbk zzbkVar) {
        this.zza = zzbkVar;
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzb(final int i) {
        zzbk.zzB(this.zza).post(new Runnable(this, i) { // from class: com.google.android.gms.cast.zzbc
            private final zzbj zza;
            private final int zzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                List list;
                List<zzp> list2;
                zzbj zzbjVar = this.zza;
                int i2 = this.zzb;
                zzbk.zzR(zzbjVar.zza);
                zzbjVar.zza.zzz = 1;
                list = zzbjVar.zza.zzy;
                synchronized (list) {
                    list2 = zzbjVar.zza.zzy;
                    for (zzp zzpVar : list2) {
                        zzpVar.zzd(i2);
                    }
                }
                zzbjVar.zza.zzV();
                zzbk zzbkVar = zzbjVar.zza;
                zzbkVar.zzU(zzbkVar.zza);
            }
        });
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzc(final int i) {
        zzbk.zzB(this.zza).post(new Runnable(this, i) { // from class: com.google.android.gms.cast.zzbd
            private final zzbj zza;
            private final int zzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                List list;
                List<zzp> list2;
                List list3;
                List<zzp> list4;
                zzbj zzbjVar = this.zza;
                int i2 = this.zzb;
                if (i2 == 0) {
                    zzbjVar.zza.zzz = 2;
                    zzbjVar.zza.zzk = true;
                    zzbjVar.zza.zzl = true;
                    list3 = zzbjVar.zza.zzy;
                    synchronized (list3) {
                        list4 = zzbjVar.zza.zzy;
                        for (zzp zzpVar : list4) {
                            zzpVar.zza();
                        }
                    }
                    return;
                }
                zzbjVar.zza.zzz = 1;
                list = zzbjVar.zza.zzy;
                synchronized (list) {
                    list2 = zzbjVar.zza.zzy;
                    for (zzp zzpVar2 : list2) {
                        zzpVar2.zzb(i2);
                    }
                }
                zzbjVar.zza.zzV();
            }
        });
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzd(final int i) {
        zzbk.zzB(this.zza).post(new Runnable(this, i) { // from class: com.google.android.gms.cast.zzbe
            private final zzbj zza;
            private final int zzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                List list;
                List<zzp> list2;
                zzbj zzbjVar = this.zza;
                int i2 = this.zzb;
                zzbjVar.zza.zzz = 3;
                list = zzbjVar.zza.zzy;
                synchronized (list) {
                    list2 = zzbjVar.zza.zzy;
                    for (zzp zzpVar : list2) {
                        zzpVar.zzc(i2);
                    }
                }
            }
        });
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zze(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
        this.zza.zzp = applicationMetadata;
        this.zza.zzq = str;
        zzbk.zzE(this.zza, new com.google.android.gms.cast.internal.zzq(new Status(0), applicationMetadata, str, str2, z));
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzf(int i) {
        this.zza.zzZ(i);
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzg(int i) {
        zzbk.zzG(this.zza, i);
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzh(int i) {
        zzbk.zzG(this.zza, i);
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzi(final int i) {
        Cast.Listener listener;
        zzbk.zzG(this.zza, i);
        listener = this.zza.zzx;
        if (listener != null) {
            zzbk.zzB(this.zza).post(new Runnable(this, i) { // from class: com.google.android.gms.cast.zzbf
                private final zzbj zza;
                private final int zzb;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zza = this;
                    this.zzb = i;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Cast.Listener listener2;
                    zzbj zzbjVar = this.zza;
                    int i2 = this.zzb;
                    listener2 = zzbjVar.zza.zzx;
                    listener2.onApplicationDisconnected(i2);
                }
            });
        }
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzj(String str, double d, boolean z) {
        Logger logger;
        logger = zzbk.zzg;
        logger.m369d("Deprecated callback: \"onStatusReceived\"", new Object[0]);
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzk(final com.google.android.gms.cast.internal.zzy zzyVar) {
        zzbk.zzB(this.zza).post(new Runnable(this, zzyVar) { // from class: com.google.android.gms.cast.zzbg
            private final zzbj zza;
            private final com.google.android.gms.cast.internal.zzy zzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = zzyVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzbj zzbjVar = this.zza;
                zzbk.zzM(zzbjVar.zza, this.zzb);
            }
        });
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzl(final com.google.android.gms.cast.internal.zza zzaVar) {
        zzbk.zzB(this.zza).post(new Runnable(this, zzaVar) { // from class: com.google.android.gms.cast.zzbh
            private final zzbj zza;
            private final com.google.android.gms.cast.internal.zza zzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = zzaVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzbj zzbjVar = this.zza;
                zzbk.zzL(zzbjVar.zza, this.zzb);
            }
        });
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzm(final String str, final String str2) {
        Logger logger;
        logger = zzbk.zzg;
        logger.m369d("Receive (type=text, ns=%s) %s", str, str2);
        zzbk.zzB(this.zza).post(new Runnable(this, str, str2) { // from class: com.google.android.gms.cast.zzbi
            private final zzbj zza;
            private final String zzb;
            private final String zzc;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = str;
                this.zzc = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Cast.MessageReceivedCallback messageReceivedCallback;
                Logger logger2;
                CastDevice castDevice;
                zzbj zzbjVar = this.zza;
                String str3 = this.zzb;
                String str4 = this.zzc;
                synchronized (zzbjVar.zza.zze) {
                    messageReceivedCallback = zzbjVar.zza.zze.get(str3);
                }
                if (messageReceivedCallback != null) {
                    castDevice = zzbjVar.zza.zzw;
                    messageReceivedCallback.onMessageReceived(castDevice, str3, str4);
                    return;
                }
                logger2 = zzbk.zzg;
                logger2.m369d("Discarded message for unknown namespace '%s'", str3);
            }
        });
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzn(String str, byte[] bArr) {
        Logger logger;
        logger = zzbk.zzg;
        logger.m369d("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzo(String str, long j, int i) {
        zzbk.zzJ(this.zza, j, i);
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzp(String str, long j) {
        zzbk.zzJ(this.zza, j, 0);
    }
}
