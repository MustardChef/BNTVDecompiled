package com.google.android.gms.safetynet;

import android.content.Context;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import java.util.List;

/* loaded from: classes3.dex */
public interface SafetyNetApi {

    /* loaded from: classes3.dex */
    public static class AttestationResponse extends Response<zza> {
        public String getJwsResult() {
            return getResult().getJwsResult();
        }
    }

    /* loaded from: classes3.dex */
    public static class HarmfulAppsResponse extends Response<zzb> {
        public List<HarmfulAppsData> getHarmfulAppsList() {
            return getResult().getHarmfulAppsList();
        }

        public int getHoursSinceLastScanWithHarmfulApp() {
            return getResult().getHoursSinceLastScanWithHarmfulApp();
        }

        public long getLastScanTimeMs() {
            return getResult().getLastScanTimeMs();
        }
    }

    /* loaded from: classes3.dex */
    public static class RecaptchaTokenResponse extends Response<RecaptchaTokenResult> {
        public String getTokenResult() {
            return getResult().getTokenResult();
        }
    }

    @Deprecated
    /* loaded from: classes3.dex */
    public interface RecaptchaTokenResult extends Result {
        String getTokenResult();
    }

    /* loaded from: classes3.dex */
    public static class SafeBrowsingResponse extends Response<SafeBrowsingResult> {
        public List<SafeBrowsingThreat> getDetectedThreats() {
            return getResult().getDetectedThreats();
        }

        public long getLastUpdateTimeMs() {
            return getResult().getLastUpdateTimeMs();
        }

        public String getMetadata() {
            return getResult().getMetadata();
        }

        public byte[] getState() {
            return getResult().getState();
        }
    }

    @Deprecated
    /* loaded from: classes3.dex */
    public interface SafeBrowsingResult extends Result {
        List<SafeBrowsingThreat> getDetectedThreats();

        long getLastUpdateTimeMs();

        String getMetadata();

        byte[] getState();
    }

    /* loaded from: classes3.dex */
    public static class VerifyAppsUserResponse extends Response<zzc> {
        public boolean isVerifyAppsEnabled() {
            return getResult().isVerifyAppsEnabled();
        }
    }

    @Deprecated
    /* loaded from: classes3.dex */
    public interface zza extends Result {
        String getJwsResult();
    }

    @Deprecated
    /* loaded from: classes3.dex */
    public interface zzb extends Result {
        List<HarmfulAppsData> getHarmfulAppsList();

        int getHoursSinceLastScanWithHarmfulApp();

        long getLastScanTimeMs();
    }

    @Deprecated
    /* loaded from: classes3.dex */
    public interface zzc extends Result {
        boolean isVerifyAppsEnabled();
    }

    @Deprecated
    PendingResult<zza> attest(GoogleApiClient googleApiClient, byte[] bArr);

    @Deprecated
    PendingResult<zzc> enableVerifyApps(GoogleApiClient googleApiClient);

    @Deprecated
    PendingResult<zzc> isVerifyAppsEnabled(GoogleApiClient googleApiClient);

    @Deprecated
    boolean isVerifyAppsEnabled(Context context);

    @Deprecated
    PendingResult<zzb> listHarmfulApps(GoogleApiClient googleApiClient);

    @Deprecated
    PendingResult<SafeBrowsingResult> lookupUri(GoogleApiClient googleApiClient, String str, String str2, int... iArr);

    PendingResult<SafeBrowsingResult> lookupUri(GoogleApiClient googleApiClient, List<Integer> list, String str);

    @Deprecated
    PendingResult<RecaptchaTokenResult> verifyWithRecaptcha(GoogleApiClient googleApiClient, String str);
}
