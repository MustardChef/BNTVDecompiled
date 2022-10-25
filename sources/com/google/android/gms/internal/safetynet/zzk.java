package com.google.android.gms.internal.safetynet;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.HarmfulAppsData;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.SafeBrowsingThreat;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class zzk implements SafetyNetApi {
    private static final String TAG = "zzk";

    /* loaded from: classes3.dex */
    static class zza implements SafetyNetApi.zza {
        private final Status zzad;
        private final com.google.android.gms.safetynet.zza zzae;

        public zza(Status status, com.google.android.gms.safetynet.zza zzaVar) {
            this.zzad = status;
            this.zzae = zzaVar;
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.zza
        public final String getJwsResult() {
            com.google.android.gms.safetynet.zza zzaVar = this.zzae;
            if (zzaVar == null) {
                return null;
            }
            return zzaVar.getJwsResult();
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzad;
        }
    }

    /* loaded from: classes3.dex */
    static abstract class zzb extends com.google.android.gms.internal.safetynet.zzf<SafetyNetApi.zza> {
        protected com.google.android.gms.internal.safetynet.zzg zzaf;

        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzaf = new zzs(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ Result createFailedResult(Status status) {
            return new zza(status, null);
        }
    }

    /* loaded from: classes3.dex */
    static abstract class zzc extends com.google.android.gms.internal.safetynet.zzf<SafetyNetApi.zzc> {
        protected com.google.android.gms.internal.safetynet.zzg zzaf;

        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzaf = new zzt(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ Result createFailedResult(Status status) {
            return new zzj(status, false);
        }
    }

    /* loaded from: classes3.dex */
    static abstract class zzd extends com.google.android.gms.internal.safetynet.zzf<SafetyNetApi.zzb> {
        protected final com.google.android.gms.internal.safetynet.zzg zzaf;

        public zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzaf = new zzu(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ Result createFailedResult(Status status) {
            return new zzg(status, null);
        }
    }

    /* loaded from: classes3.dex */
    static abstract class zze extends com.google.android.gms.internal.safetynet.zzf<SafetyNetApi.RecaptchaTokenResult> {
        protected com.google.android.gms.internal.safetynet.zzg zzaf;

        public zze(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzaf = new zzv(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ Result createFailedResult(Status status) {
            return new zzh(status, null);
        }
    }

    /* loaded from: classes3.dex */
    static abstract class zzf extends com.google.android.gms.internal.safetynet.zzf<SafetyNetApi.SafeBrowsingResult> {
        protected com.google.android.gms.internal.safetynet.zzg zzaf;

        public zzf(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzaf = new zzw(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ Result createFailedResult(Status status) {
            return new zzi(status, null);
        }
    }

    /* loaded from: classes3.dex */
    static class zzg implements SafetyNetApi.zzb {
        private final Status zzad;
        private final com.google.android.gms.safetynet.zzd zzal;

        public zzg(Status status, com.google.android.gms.safetynet.zzd zzdVar) {
            this.zzad = status;
            this.zzal = zzdVar;
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.zzb
        public final List<HarmfulAppsData> getHarmfulAppsList() {
            com.google.android.gms.safetynet.zzd zzdVar = this.zzal;
            return zzdVar == null ? Collections.emptyList() : Arrays.asList(zzdVar.zzg);
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.zzb
        public final int getHoursSinceLastScanWithHarmfulApp() {
            com.google.android.gms.safetynet.zzd zzdVar = this.zzal;
            if (zzdVar == null) {
                return -1;
            }
            return zzdVar.zzh;
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.zzb
        public final long getLastScanTimeMs() {
            com.google.android.gms.safetynet.zzd zzdVar = this.zzal;
            if (zzdVar == null) {
                return 0L;
            }
            return zzdVar.zzf;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzad;
        }
    }

    /* loaded from: classes3.dex */
    static class zzh implements SafetyNetApi.RecaptchaTokenResult {
        private final Status zzad;
        private final com.google.android.gms.safetynet.zzf zzam;

        public zzh(Status status, com.google.android.gms.safetynet.zzf zzfVar) {
            this.zzad = status;
            this.zzam = zzfVar;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzad;
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.RecaptchaTokenResult
        public final String getTokenResult() {
            com.google.android.gms.safetynet.zzf zzfVar = this.zzam;
            if (zzfVar == null) {
                return null;
            }
            return zzfVar.getTokenResult();
        }
    }

    /* loaded from: classes3.dex */
    public static class zzi implements SafetyNetApi.SafeBrowsingResult {
        private Status zzad;
        private final SafeBrowsingData zzan;
        private String zzm;
        private long zzp;
        private byte[] zzq;

        public zzi(Status status, SafeBrowsingData safeBrowsingData) {
            this.zzad = status;
            this.zzan = safeBrowsingData;
            this.zzm = null;
            if (safeBrowsingData != null) {
                this.zzm = safeBrowsingData.getMetadata();
                this.zzp = safeBrowsingData.getLastUpdateTimeMs();
                this.zzq = safeBrowsingData.getState();
            } else if (status.isSuccess()) {
                this.zzad = new Status(8);
            }
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.SafeBrowsingResult
        public final List<SafeBrowsingThreat> getDetectedThreats() {
            ArrayList arrayList = new ArrayList();
            if (this.zzm == null) {
                return arrayList;
            }
            try {
                JSONArray jSONArray = new JSONObject(this.zzm).getJSONArray("matches");
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        arrayList.add(new SafeBrowsingThreat(Integer.parseInt(jSONArray.getJSONObject(i).getString("threat_type"))));
                    } catch (NumberFormatException | JSONException unused) {
                    }
                }
            } catch (JSONException unused2) {
            }
            return arrayList;
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.SafeBrowsingResult
        public final long getLastUpdateTimeMs() {
            return this.zzp;
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.SafeBrowsingResult
        public final String getMetadata() {
            return this.zzm;
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.SafeBrowsingResult
        public final byte[] getState() {
            return this.zzq;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzad;
        }
    }

    /* loaded from: classes3.dex */
    static class zzj implements SafetyNetApi.zzc {
        private Status zzad;
        private boolean zzao;

        public zzj() {
        }

        public zzj(Status status, boolean z) {
            this.zzad = status;
            this.zzao = z;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzad;
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.zzc
        public final boolean isVerifyAppsEnabled() {
            Status status = this.zzad;
            if (status == null || !status.isSuccess()) {
                return false;
            }
            return this.zzao;
        }
    }

    public static PendingResult<SafetyNetApi.SafeBrowsingResult> zza(GoogleApiClient googleApiClient, String str, int i, String str2, int... iArr) {
        if (iArr.length != 0) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Null or empty uri in lookupUri");
            }
            return googleApiClient.enqueue(new zzn(googleApiClient, iArr, i, str, str2));
        }
        throw new IllegalArgumentException("Null threatTypes in lookupUri");
    }

    public static PendingResult<SafetyNetApi.zza> zza(GoogleApiClient googleApiClient, byte[] bArr, String str) {
        return googleApiClient.enqueue(new zzl(googleApiClient, bArr, str));
    }

    @Override // com.google.android.gms.safetynet.SafetyNetApi
    public PendingResult<SafetyNetApi.zza> attest(GoogleApiClient googleApiClient, byte[] bArr) {
        return zza(googleApiClient, bArr, null);
    }

    @Override // com.google.android.gms.safetynet.SafetyNetApi
    public PendingResult<SafetyNetApi.zzc> enableVerifyApps(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzp(this, googleApiClient));
    }

    @Override // com.google.android.gms.safetynet.SafetyNetApi
    public PendingResult<SafetyNetApi.zzc> isVerifyAppsEnabled(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzo(this, googleApiClient));
    }

    @Override // com.google.android.gms.safetynet.SafetyNetApi
    public boolean isVerifyAppsEnabled(Context context) {
        GoogleApiClient build = new GoogleApiClient.Builder(context).addApi(SafetyNet.API).build();
        try {
            boolean z = false;
            if (!build.blockingConnect(3L, TimeUnit.SECONDS).isSuccess()) {
                if (build != null) {
                    build.disconnect();
                }
                return false;
            }
            SafetyNetApi.zzc await = isVerifyAppsEnabled(build).await(3L, TimeUnit.SECONDS);
            if (await != null) {
                if (await.isVerifyAppsEnabled()) {
                    z = true;
                }
            }
            return z;
        } finally {
            if (build != null) {
                build.disconnect();
            }
        }
    }

    @Override // com.google.android.gms.safetynet.SafetyNetApi
    public PendingResult<SafetyNetApi.zzb> listHarmfulApps(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzq(this, googleApiClient));
    }

    @Override // com.google.android.gms.safetynet.SafetyNetApi
    public PendingResult<SafetyNetApi.SafeBrowsingResult> lookupUri(GoogleApiClient googleApiClient, String str, String str2, int... iArr) {
        return zza(googleApiClient, str, 1, str2, iArr);
    }

    @Override // com.google.android.gms.safetynet.SafetyNetApi
    public PendingResult<SafetyNetApi.SafeBrowsingResult> lookupUri(GoogleApiClient googleApiClient, List<Integer> list, String str) {
        if (list != null) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Null or empty uri in lookupUri");
            }
            return googleApiClient.enqueue(new zzm(this, googleApiClient, list, str, null));
        }
        throw new IllegalArgumentException("Null threatTypes in lookupUri");
    }

    @Override // com.google.android.gms.safetynet.SafetyNetApi
    public PendingResult<SafetyNetApi.RecaptchaTokenResult> verifyWithRecaptcha(GoogleApiClient googleApiClient, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Null or empty site key in verifyWithRecaptcha");
        }
        return googleApiClient.enqueue(new zzr(this, googleApiClient, str));
    }
}
