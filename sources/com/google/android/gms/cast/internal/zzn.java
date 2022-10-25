package com.google.android.gms.cast.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzn extends GoogleApi<Api.ApiOptions.NoOptions> {
    private static final Api.ClientKey<zzo> zza;
    private static final Api.AbstractClientBuilder<zzo, Api.ApiOptions.NoOptions> zzb;
    private static final Api<Api.ApiOptions.NoOptions> zzc;

    static {
        Api.ClientKey<zzo> clientKey = new Api.ClientKey<>();
        zza = clientKey;
        zzi zziVar = new zzi();
        zzb = zziVar;
        zzc = new Api<>("CastApi.API", zziVar, clientKey);
    }

    public zzn(Context context) {
        super(context, zzc, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public final Task<Void> zza(final String[] strArr, final String str, List list) {
        return doWrite(TaskApiCall.builder().setMethodKey(8423).run(new RemoteCall(this, strArr, str, null) { // from class: com.google.android.gms.cast.internal.zze
            private final zzn zza;
            private final String[] zzb;
            private final String zzc;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = strArr;
                this.zzc = str;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzn zznVar = this.zza;
                String[] strArr2 = this.zzb;
                String str2 = this.zzc;
                ((zzah) ((zzo) obj).getService()).zze(new zzj(zznVar, (TaskCompletionSource) obj2), strArr2, str2, null);
            }
        }).build());
    }

    public final Task<Bundle> zzb(final String[] strArr) {
        return doRead(TaskApiCall.builder().run(new RemoteCall(this, strArr) { // from class: com.google.android.gms.cast.internal.zzf
            private final zzn zza;
            private final String[] zzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = strArr;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzn zznVar = this.zza;
                String[] strArr2 = this.zzb;
                ((zzah) ((zzo) obj).getService()).zzf(new zzk(zznVar, (TaskCompletionSource) obj2), strArr2);
            }
        }).setFeatures(com.google.android.gms.cast.zzao.zzd).setAutoResolveMissingFeatures(false).setMethodKey(8425).build());
    }

    public final Task<Bundle> zzc(final String[] strArr) {
        return doRead(TaskApiCall.builder().run(new RemoteCall(this, strArr) { // from class: com.google.android.gms.cast.internal.zzg
            private final zzn zza;
            private final String[] zzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = strArr;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzn zznVar = this.zza;
                String[] strArr2 = this.zzb;
                ((zzah) ((zzo) obj).getService()).zzg(new zzl(zznVar, (TaskCompletionSource) obj2), strArr2);
            }
        }).setFeatures(com.google.android.gms.cast.zzao.zzg).setAutoResolveMissingFeatures(false).setMethodKey(8426).build());
    }

    public final Task<Bundle> zzd(final String[] strArr) {
        return doRead(TaskApiCall.builder().run(new RemoteCall(this, strArr) { // from class: com.google.android.gms.cast.internal.zzh
            private final zzn zza;
            private final String[] zzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
                this.zzb = strArr;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzn zznVar = this.zza;
                String[] strArr2 = this.zzb;
                ((zzah) ((zzo) obj).getService()).zzh(new zzm(zznVar, (TaskCompletionSource) obj2), strArr2);
            }
        }).setFeatures(com.google.android.gms.cast.zzao.zzh).setAutoResolveMissingFeatures(false).setMethodKey(8427).build());
    }
}
