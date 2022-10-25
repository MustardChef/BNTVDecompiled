package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzfv extends Thread {
    private final Object zza;
    private final BlockingQueue<zzfs<?>> zzb;
    private boolean zzc = false;
    private final /* synthetic */ zzfr zzd;

    public zzfv(zzfr zzfrVar, String str, BlockingQueue<zzfs<?>> blockingQueue) {
        this.zzd = zzfrVar;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zza = new Object();
        this.zzb = blockingQueue;
        setName(str);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Object obj;
        boolean z;
        Semaphore semaphore;
        boolean z2 = false;
        while (!z2) {
            try {
                semaphore = this.zzd.zzh;
                semaphore.acquire();
                z2 = true;
            } catch (InterruptedException e) {
                zza(e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                zzfs<?> poll = this.zzb.poll();
                if (poll != null) {
                    Process.setThreadPriority(poll.zza ? threadPriority : 10);
                    poll.run();
                } else {
                    synchronized (this.zza) {
                        if (this.zzb.peek() == null) {
                            z = this.zzd.zzi;
                            if (!z) {
                                try {
                                    this.zza.wait(30000L);
                                } catch (InterruptedException e2) {
                                    zza(e2);
                                }
                            }
                        }
                    }
                    obj = this.zzd.zzg;
                    synchronized (obj) {
                        if (this.zzb.peek() == null) {
                            break;
                        }
                    }
                }
            }
            if (this.zzd.zzs().zza(zzas.zzbq)) {
                zzb();
            }
        } finally {
            zzb();
        }
    }

    private final void zzb() {
        Object obj;
        Semaphore semaphore;
        Object obj2;
        zzfv zzfvVar;
        zzfv zzfvVar2;
        obj = this.zzd.zzg;
        synchronized (obj) {
            if (!this.zzc) {
                semaphore = this.zzd.zzh;
                semaphore.release();
                obj2 = this.zzd.zzg;
                obj2.notifyAll();
                zzfvVar = this.zzd.zza;
                if (this == zzfvVar) {
                    this.zzd.zza = null;
                } else {
                    zzfvVar2 = this.zzd.zzb;
                    if (this != zzfvVar2) {
                        this.zzd.zzq().zze().zza("Current scheduler thread is neither worker nor network");
                    } else {
                        this.zzd.zzb = null;
                    }
                }
                this.zzc = true;
            }
        }
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.notifyAll();
        }
    }

    private final void zza(InterruptedException interruptedException) {
        this.zzd.zzq().zzh().zza(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }
}
