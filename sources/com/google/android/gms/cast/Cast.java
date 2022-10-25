package com.google.android.gms.cast;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class Cast {
    public static final int ACTIVE_INPUT_STATE_NO = 0;
    public static final int ACTIVE_INPUT_STATE_UNKNOWN = -1;
    public static final int ACTIVE_INPUT_STATE_YES = 1;
    public static final Api<CastOptions> API;
    public static final CastApi CastApi;
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    public static final int STANDBY_STATE_NO = 0;
    public static final int STANDBY_STATE_UNKNOWN = -1;
    public static final int STANDBY_STATE_YES = 1;
    static final Api.AbstractClientBuilder<com.google.android.gms.cast.internal.zzw, CastOptions> zza;

    /* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
    /* loaded from: classes2.dex */
    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    /* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
    @Deprecated
    /* loaded from: classes2.dex */
    public interface CastApi {
        int getActiveInputState(GoogleApiClient googleApiClient) throws IllegalStateException;

        ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException;

        String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException;

        int getStandbyState(GoogleApiClient googleApiClient) throws IllegalStateException;

        double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException;

        boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException;

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions);

        @Deprecated
        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z);

        PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException;

        void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException;

        PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException;

        void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException, IllegalStateException;

        void setVolume(GoogleApiClient googleApiClient, double d) throws IOException, IllegalArgumentException, IllegalStateException;

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient);

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str);
    }

    /* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
    /* loaded from: classes2.dex */
    public static final class CastOptions implements Api.ApiOptions.HasOptions {
        final CastDevice zza;
        final Listener zzb;
        final Bundle zzc;
        final int zzd;
        final String zze = UUID.randomUUID().toString();

        /* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
        /* loaded from: classes2.dex */
        public static final class Builder {
            CastDevice zza;
            Listener zzb;
            private int zzc;
            private Bundle zzd;

            public Builder(CastDevice castDevice, Listener listener) {
                Preconditions.checkNotNull(castDevice, "CastDevice parameter cannot be null");
                Preconditions.checkNotNull(listener, "CastListener parameter cannot be null");
                this.zza = castDevice;
                this.zzb = listener;
                this.zzc = 0;
            }

            public CastOptions build() {
                return new CastOptions(this, null);
            }

            public Builder setVerboseLoggingEnabled(boolean z) {
                this.zzc = z ? 1 : 0;
                return this;
            }

            public final Builder zza(Bundle bundle) {
                this.zzd = bundle;
                return this;
            }
        }

        /* synthetic */ CastOptions(Builder builder, zze zzeVar) {
            this.zza = builder.zza;
            this.zzb = builder.zzb;
            this.zzd = builder.zzc;
            this.zzc = builder.zzd;
        }

        @Deprecated
        public static Builder builder(CastDevice castDevice, Listener listener) {
            return new Builder(castDevice, listener);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0057, code lost:
            if (r1 == r3) goto L24;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean equals(java.lang.Object r8) {
            /*
                r7 = this;
                r0 = 1
                if (r8 != r7) goto L4
                return r0
            L4:
                boolean r1 = r8 instanceof com.google.android.gms.cast.Cast.CastOptions
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                com.google.android.gms.cast.Cast$CastOptions r8 = (com.google.android.gms.cast.Cast.CastOptions) r8
                com.google.android.gms.cast.CastDevice r1 = r7.zza
                com.google.android.gms.cast.CastDevice r3 = r8.zza
                boolean r1 = com.google.android.gms.common.internal.Objects.equal(r1, r3)
                if (r1 == 0) goto L6a
                android.os.Bundle r1 = r7.zzc
                android.os.Bundle r3 = r8.zzc
                if (r1 == 0) goto L57
                if (r3 != 0) goto L1f
                goto L57
            L1f:
                int r4 = r1.size()
                int r5 = r3.size()
                if (r4 == r5) goto L2a
                goto L6a
            L2a:
                java.util.Set r4 = r1.keySet()
                java.util.Set r5 = r3.keySet()
                boolean r5 = r4.containsAll(r5)
                if (r5 == 0) goto L6a
                java.util.Iterator r4 = r4.iterator()
            L3c:
                boolean r5 = r4.hasNext()
                if (r5 == 0) goto L59
                java.lang.Object r5 = r4.next()
                java.lang.String r5 = (java.lang.String) r5
                java.lang.Object r6 = r1.get(r5)
                java.lang.Object r5 = r3.get(r5)
                boolean r5 = com.google.android.gms.common.internal.Objects.equal(r6, r5)
                if (r5 != 0) goto L3c
                goto L6a
            L57:
                if (r1 != r3) goto L6a
            L59:
                int r1 = r7.zzd
                int r3 = r8.zzd
                if (r1 != r3) goto L6a
                java.lang.String r1 = r7.zze
                java.lang.String r8 = r8.zze
                boolean r8 = com.google.android.gms.common.internal.Objects.equal(r1, r8)
                if (r8 == 0) goto L6a
                return r0
            L6a:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.Cast.CastOptions.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            return Objects.hashCode(this.zza, this.zzc, Integer.valueOf(this.zzd), this.zze);
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
    /* loaded from: classes2.dex */
    public static class Listener {
        public void onActiveInputStateChanged(int i) {
        }

        public void onApplicationDisconnected(int i) {
        }

        public void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onStandbyStateChanged(int i) {
        }

        public void onVolumeChanged() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
    /* loaded from: classes2.dex */
    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    static {
        zze zzeVar = new zze();
        zza = zzeVar;
        API = new Api<>("Cast.API", zzeVar, com.google.android.gms.cast.internal.zzai.zza);
        CastApi = new zzm();
    }

    private Cast() {
    }

    public static zzq zza(Context context, CastOptions castOptions) {
        return new zzbk(context, castOptions);
    }
}
