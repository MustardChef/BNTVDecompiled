package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzm implements Cast.CastApi {
    @Override // com.google.android.gms.cast.Cast.CastApi
    public final int getActiveInputState(GoogleApiClient googleApiClient) throws IllegalStateException {
        return ((com.google.android.gms.cast.internal.zzw) googleApiClient.getClient(com.google.android.gms.cast.internal.zzai.zza)).zzz();
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException {
        return ((com.google.android.gms.cast.internal.zzw) googleApiClient.getClient(com.google.android.gms.cast.internal.zzai.zza)).zzD();
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException {
        return ((com.google.android.gms.cast.internal.zzw) googleApiClient.getClient(com.google.android.gms.cast.internal.zzai.zza)).zzE();
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final int getStandbyState(GoogleApiClient googleApiClient) throws IllegalStateException {
        return ((com.google.android.gms.cast.internal.zzw) googleApiClient.getClient(com.google.android.gms.cast.internal.zzai.zza)).zzA();
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException {
        return ((com.google.android.gms.cast.internal.zzw) googleApiClient.getClient(com.google.android.gms.cast.internal.zzai.zza)).zzx();
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException {
        return ((com.google.android.gms.cast.internal.zzw) googleApiClient.getClient(com.google.android.gms.cast.internal.zzai.zza)).zzy();
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, null, null, null);
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new zzg(this, googleApiClient, str));
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new zzj(this, googleApiClient));
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException {
        try {
            ((com.google.android.gms.cast.internal.zzw) googleApiClient.getClient(com.google.android.gms.cast.internal.zzai.zza)).zzC(str);
        } catch (RemoteException unused) {
            throw new IOException("service error");
        }
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException {
        try {
            ((com.google.android.gms.cast.internal.zzw) googleApiClient.getClient(com.google.android.gms.cast.internal.zzai.zza)).zzu();
        } catch (RemoteException unused) {
            throw new IOException("service error");
        }
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2) {
        return googleApiClient.execute(new zzf(this, googleApiClient, str, str2));
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, Cast.MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException {
        try {
            ((com.google.android.gms.cast.internal.zzw) googleApiClient.getClient(com.google.android.gms.cast.internal.zzai.zza)).zzB(str, messageReceivedCallback);
        } catch (RemoteException unused) {
            throw new IOException("service error");
        }
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException, IllegalStateException {
        try {
            ((com.google.android.gms.cast.internal.zzw) googleApiClient.getClient(com.google.android.gms.cast.internal.zzai.zza)).zzw(z);
        } catch (RemoteException unused) {
            throw new IOException("service error");
        }
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final void setVolume(GoogleApiClient googleApiClient, double d) throws IOException, IllegalArgumentException, IllegalStateException {
        try {
            ((com.google.android.gms.cast.internal.zzw) googleApiClient.getClient(com.google.android.gms.cast.internal.zzai.zza)).zzv(d);
        } catch (RemoteException unused) {
            throw new IOException("service error");
        }
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final PendingResult<Status> stopApplication(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new zzk(this, googleApiClient));
    }

    public final PendingResult<Cast.ApplicationConnectionResult> zza(GoogleApiClient googleApiClient, String str, String str2, zzbl zzblVar) {
        return googleApiClient.execute(new zzi(this, googleApiClient, str, str2, null));
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str) {
        return zza(googleApiClient, str, null, null);
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions) {
        return googleApiClient.execute(new zzh(this, googleApiClient, str, launchOptions));
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new zzl(this, googleApiClient, str));
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2) {
        return zza(googleApiClient, str, str2, null);
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    @Deprecated
    public final PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z) {
        LaunchOptions.Builder builder = new LaunchOptions.Builder();
        builder.setRelaunchIfRunning(z);
        return googleApiClient.execute(new zzh(this, googleApiClient, str, builder.build()));
    }
}
