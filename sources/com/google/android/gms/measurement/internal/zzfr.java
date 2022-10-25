package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzfr extends zzgq {
    private static final AtomicLong zzj = new AtomicLong(Long.MIN_VALUE);
    private zzfv zza;
    private zzfv zzb;
    private final PriorityBlockingQueue<zzfs<?>> zzc;
    private final BlockingQueue<zzfs<?>> zzd;
    private final Thread.UncaughtExceptionHandler zze;
    private final Thread.UncaughtExceptionHandler zzf;
    private final Object zzg;
    private final Semaphore zzh;
    private volatile boolean zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfr(zzfu zzfuVar) {
        super(zzfuVar);
        this.zzg = new Object();
        this.zzh = new Semaphore(2);
        this.zzc = new PriorityBlockingQueue<>();
        this.zzd = new LinkedBlockingQueue();
        this.zze = new zzft(this, "Thread death: Uncaught exception on worker thread");
        this.zzf = new zzft(this, "Thread death: Uncaught exception on network thread");
    }

    @Override // com.google.android.gms.measurement.internal.zzgq
    protected final boolean zzd() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final void zzc() {
        if (Thread.currentThread() != this.zza) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final void zzb() {
        if (Thread.currentThread() != this.zzb) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final boolean zzf() {
        return Thread.currentThread() == this.zza;
    }

    public final <V> Future<V> zza(Callable<V> callable) throws IllegalStateException {
        zzab();
        Preconditions.checkNotNull(callable);
        zzfs<?> zzfsVar = new zzfs<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zza) {
            if (!this.zzc.isEmpty()) {
                zzq().zzh().zza("Callable skipped the worker queue.");
            }
            zzfsVar.run();
        } else {
            zza(zzfsVar);
        }
        return zzfsVar;
    }

    public final <V> Future<V> zzb(Callable<V> callable) throws IllegalStateException {
        zzab();
        Preconditions.checkNotNull(callable);
        zzfs<?> zzfsVar = new zzfs<>(this, (Callable<?>) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zza) {
            zzfsVar.run();
        } else {
            zza(zzfsVar);
        }
        return zzfsVar;
    }

    public final void zza(Runnable runnable) throws IllegalStateException {
        zzab();
        Preconditions.checkNotNull(runnable);
        zza(new zzfs<>(this, runnable, false, "Task exception on worker thread"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T> T zza(AtomicReference<T> atomicReference, long j, String str, Runnable runnable) {
        synchronized (atomicReference) {
            zzp().zza(runnable);
            try {
                atomicReference.wait(j);
            } catch (InterruptedException unused) {
                zzes zzh = zzq().zzh();
                String valueOf = String.valueOf(str);
                zzh.zza(valueOf.length() != 0 ? "Interrupted waiting for ".concat(valueOf) : new String("Interrupted waiting for "));
                return null;
            }
        }
        T t = atomicReference.get();
        if (t == null) {
            zzes zzh2 = zzq().zzh();
            String valueOf2 = String.valueOf(str);
            zzh2.zza(valueOf2.length() != 0 ? "Timed out waiting for ".concat(valueOf2) : new String("Timed out waiting for "));
        }
        return t;
    }

    public final void zzb(Runnable runnable) throws IllegalStateException {
        zzab();
        Preconditions.checkNotNull(runnable);
        zza(new zzfs<>(this, runnable, true, "Task exception on worker thread"));
    }

    private final void zza(zzfs<?> zzfsVar) {
        synchronized (this.zzg) {
            this.zzc.add(zzfsVar);
            zzfv zzfvVar = this.zza;
            if (zzfvVar == null) {
                zzfv zzfvVar2 = new zzfv(this, "Measurement Worker", this.zzc);
                this.zza = zzfvVar2;
                zzfvVar2.setUncaughtExceptionHandler(this.zze);
                this.zza.start();
            } else {
                zzfvVar.zza();
            }
        }
    }

    public final void zzc(Runnable runnable) throws IllegalStateException {
        zzab();
        Preconditions.checkNotNull(runnable);
        zzfs<?> zzfsVar = new zzfs<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzg) {
            this.zzd.add(zzfsVar);
            zzfv zzfvVar = this.zzb;
            if (zzfvVar == null) {
                zzfv zzfvVar2 = new zzfv(this, "Measurement Network", this.zzd);
                this.zzb = zzfvVar2;
                zzfvVar2.setUncaughtExceptionHandler(this.zzf);
                this.zzb.start();
            } else {
                zzfvVar.zza();
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzak zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzeo zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzkv zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ zzfr zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ zzeq zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzfc zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzab zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ zzw zzt() {
        return super.zzt();
    }
}
