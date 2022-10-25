package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzjl implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzir zza;
    private volatile boolean zzb;
    private volatile zzer zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzjl(zzir zzirVar) {
        this.zza = zzirVar;
    }

    public final void zza(Intent intent) {
        zzjl zzjlVar;
        this.zza.zzc();
        Context zzm = this.zza.zzm();
        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
        synchronized (this) {
            if (this.zzb) {
                this.zza.zzq().zzw().zza("Connection attempt already in progress");
                return;
            }
            this.zza.zzq().zzw().zza("Using local app measurement service");
            this.zzb = true;
            zzjlVar = this.zza.zza;
            connectionTracker.bindService(zzm, intent, zzjlVar, 129);
        }
    }

    public final void zza() {
        if (this.zzc != null && (this.zzc.isConnected() || this.zzc.isConnecting())) {
            this.zzc.disconnect();
        }
        this.zzc = null;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzjl zzjlVar;
        zzei zzekVar;
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.zzb = false;
                this.zza.zzq().zze().zza("Service connected with null binder");
                return;
            }
            zzei zzeiVar = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    if (iBinder != null) {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                        if (queryLocalInterface instanceof zzei) {
                            zzekVar = (zzei) queryLocalInterface;
                        } else {
                            zzekVar = new zzek(iBinder);
                        }
                        zzeiVar = zzekVar;
                    }
                    this.zza.zzq().zzw().zza("Bound to IMeasurementService interface");
                } else {
                    this.zza.zzq().zze().zza("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.zza.zzq().zze().zza("Service connect failed to get IMeasurementService");
            }
            if (zzeiVar == null) {
                this.zzb = false;
                try {
                    ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
                    Context zzm = this.zza.zzm();
                    zzjlVar = this.zza.zza;
                    connectionTracker.unbindService(zzm, zzjlVar);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.zza.zzp().zza(new zzjk(this, zzeiVar));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        this.zza.zzq().zzv().zza("Service disconnected");
        this.zza.zzp().zza(new zzjn(this, componentName));
    }

    public final void zzb() {
        this.zza.zzc();
        Context zzm = this.zza.zzm();
        synchronized (this) {
            if (this.zzb) {
                this.zza.zzq().zzw().zza("Connection attempt already in progress");
            } else if (this.zzc != null && (this.zzc.isConnecting() || this.zzc.isConnected())) {
                this.zza.zzq().zzw().zza("Already awaiting connection attempt");
            } else {
                this.zzc = new zzer(zzm, Looper.getMainLooper(), this, this);
                this.zza.zzq().zzw().zza("Connecting to remote service");
                this.zzb = true;
                this.zzc.checkAvailabilityAndConnect();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                this.zza.zzp().zza(new zzjm(this, this.zzc.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.zzc = null;
                this.zzb = false;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        this.zza.zzq().zzv().zza("Service connection suspended");
        this.zza.zzp().zza(new zzjp(this));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzeq zzc = this.zza.zzy.zzc();
        if (zzc != null) {
            zzc.zzh().zza("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzb = false;
            this.zzc = null;
        }
        this.zza.zzp().zza(new zzjo(this));
    }
}
