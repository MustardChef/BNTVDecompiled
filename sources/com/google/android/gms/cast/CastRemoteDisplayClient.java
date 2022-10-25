package com.google.android.gms.cast;

import android.app.PendingIntent;
import android.content.Context;
import android.hardware.display.VirtualDisplay;
import android.os.Bundle;
import android.view.Display;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public class CastRemoteDisplayClient extends GoogleApi<Api.ApiOptions.NoOptions> {
    private static final Api.AbstractClientBuilder<com.google.android.gms.internal.cast.zzbz, Api.ApiOptions.NoOptions> zzc;
    private static final Api<Api.ApiOptions.NoOptions> zzd;
    private final Logger zza;
    private VirtualDisplay zzb;

    static {
        zzv zzvVar = new zzv();
        zzc = zzvVar;
        zzd = new Api<>("CastRemoteDisplay.API", zzvVar, com.google.android.gms.cast.internal.zzai.zzd);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CastRemoteDisplayClient(Context context) {
        super(context, zzd, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.zza = new Logger("CastRemoteDisplay");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzb(CastRemoteDisplayClient castRemoteDisplayClient) {
        VirtualDisplay virtualDisplay = castRemoteDisplayClient.zzb;
        if (virtualDisplay != null) {
            if (virtualDisplay.getDisplay() != null) {
                Logger logger = castRemoteDisplayClient.zza;
                int displayId = castRemoteDisplayClient.zzb.getDisplay().getDisplayId();
                StringBuilder sb = new StringBuilder(38);
                sb.append("releasing virtual display: ");
                sb.append(displayId);
                logger.m369d(sb.toString(), new Object[0]);
            }
            VirtualDisplay virtualDisplay2 = castRemoteDisplayClient.zzb;
            if (virtualDisplay2 != null) {
                virtualDisplay2.release();
                castRemoteDisplayClient.zzb = null;
            }
        }
    }

    public Task<Display> startRemoteDisplay(CastDevice castDevice, String str, int i, PendingIntent pendingIntent) {
        return zze(castDevice, str, i, pendingIntent, null);
    }

    public Task<Void> stopRemoteDisplay() {
        return doWrite(TaskApiCall.builder().setMethodKey(8402).run(new RemoteCall(this) { // from class: com.google.android.gms.cast.zzu
            private final CastRemoteDisplayClient zza;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((com.google.android.gms.internal.cast.zzce) ((com.google.android.gms.internal.cast.zzbz) obj).getService()).zzi(new zzx(this.zza, (TaskCompletionSource) obj2));
            }
        }).build());
    }

    public final Task<Display> zze(final CastDevice castDevice, final String str, final int i, final PendingIntent pendingIntent, final zzae zzaeVar) {
        return doWrite(TaskApiCall.builder().setMethodKey(8401).run(new RemoteCall(this, i, zzaeVar, pendingIntent, castDevice, str, null) { // from class: com.google.android.gms.cast.zzt
            private final CastRemoteDisplayClient zza;
            private final int zzb;
            private final PendingIntent zzc;
            private final CastDevice zzd;
            private final String zze;
            private final zzae zzf;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = i;
                this.zzf = zzaeVar;
                this.zzc = pendingIntent;
                this.zzd = castDevice;
                this.zze = str;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                CastRemoteDisplayClient castRemoteDisplayClient = this.zza;
                int i2 = this.zzb;
                zzae zzaeVar2 = this.zzf;
                PendingIntent pendingIntent2 = this.zzc;
                CastDevice castDevice2 = this.zzd;
                String str2 = this.zze;
                com.google.android.gms.internal.cast.zzbz zzbzVar = (com.google.android.gms.internal.cast.zzbz) obj;
                Bundle bundle = new Bundle();
                bundle.putInt("configuration", i2);
                ((com.google.android.gms.internal.cast.zzce) zzbzVar.getService()).zzg(new zzw(castRemoteDisplayClient, (TaskCompletionSource) obj2, zzbzVar, zzaeVar2, null), pendingIntent2, castDevice2.getDeviceId(), str2, bundle);
            }
        }).build());
    }
}
