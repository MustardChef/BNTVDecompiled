package com.google.android.gms.common.internal;

import android.util.Log;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* loaded from: classes2.dex */
public abstract class zzc<TListener> {
    private TListener zza;
    private boolean zzb = false;
    final /* synthetic */ BaseGmsClient zzd;

    public zzc(BaseGmsClient baseGmsClient, TListener tlistener) {
        this.zzd = baseGmsClient;
        this.zza = tlistener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void zzc();

    protected abstract void zzd(TListener tlistener);

    public final void zze() {
        TListener tlistener;
        synchronized (this) {
            tlistener = this.zza;
            if (this.zzb) {
                String valueOf = String.valueOf(this);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                sb.append("Callback proxy ");
                sb.append(valueOf);
                sb.append(" being reused. This is not safe.");
                Log.w("GmsClient", sb.toString());
            }
        }
        if (tlistener != null) {
            try {
                zzd(tlistener);
            } catch (RuntimeException e) {
                throw e;
            }
        }
        synchronized (this) {
            this.zzb = true;
        }
        zzf();
    }

    public final void zzf() {
        ArrayList arrayList;
        ArrayList arrayList2;
        zzg();
        arrayList = this.zzd.zzt;
        synchronized (arrayList) {
            arrayList2 = this.zzd.zzt;
            arrayList2.remove(this);
        }
    }

    public final void zzg() {
        synchronized (this) {
            this.zza = null;
        }
    }
}
