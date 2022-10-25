package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public class AdBreakClipInfo extends AbstractSafeParcelable {
    public static final long AD_BREAK_CLIP_NOT_SKIPPABLE = -1;
    public static final Parcelable.Creator<AdBreakClipInfo> CREATOR = new zza();
    private final String zza;
    private final String zzb;
    private final long zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private String zzg;
    private final String zzh;
    private final String zzi;
    private final long zzj;
    private final String zzk;
    private final VastAdsRequest zzl;
    private JSONObject zzm;

    /* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
    /* loaded from: classes2.dex */
    public static class Builder {
        private final String zza;
        private String zzb;
        private long zzc;
        private String zzd;
        private String zze;
        private String zzf;
        private String zzg;
        private String zzh;
        private String zzi;
        private long zzj = -1;
        private String zzk;
        private VastAdsRequest zzl;

        public Builder(String str) {
            this.zza = str;
        }

        public AdBreakClipInfo build() {
            return new AdBreakClipInfo(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl);
        }

        public Builder setClickThroughUrl(String str) {
            this.zzf = str;
            return this;
        }

        public Builder setContentId(String str) {
            this.zzh = str;
            return this;
        }

        public Builder setContentUrl(String str) {
            this.zzd = str;
            return this;
        }

        public Builder setCustomDataJsonString(String str) {
            this.zzg = str;
            return this;
        }

        public Builder setDurationInMs(long j) {
            this.zzc = j;
            return this;
        }

        public Builder setHlsSegmentFormat(String str) {
            this.zzk = str;
            return this;
        }

        public Builder setImageUrl(String str) {
            this.zzi = str;
            return this;
        }

        public Builder setMimeType(String str) {
            this.zze = str;
            return this;
        }

        public Builder setTitle(String str) {
            this.zzb = str;
            return this;
        }

        public Builder setVastAdsRequest(VastAdsRequest vastAdsRequest) {
            this.zzl = vastAdsRequest;
            return this;
        }

        public Builder setWhenSkippableInMs(long j) {
            this.zzj = j;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdBreakClipInfo(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, long j2, String str9, VastAdsRequest vastAdsRequest) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        this.zzd = str3;
        this.zze = str4;
        this.zzf = str5;
        this.zzg = str6;
        this.zzh = str7;
        this.zzi = str8;
        this.zzj = j2;
        this.zzk = str9;
        this.zzl = vastAdsRequest;
        if (!TextUtils.isEmpty(str6)) {
            try {
                this.zzm = new JSONObject(this.zzg);
                return;
            } catch (JSONException e) {
                Log.w("AdBreakClipInfo", String.format(Locale.ROOT, "Error creating AdBreakClipInfo: %s", e.getMessage()));
                this.zzg = null;
                this.zzm = new JSONObject();
                return;
            }
        }
        this.zzm = new JSONObject();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdBreakClipInfo) {
            AdBreakClipInfo adBreakClipInfo = (AdBreakClipInfo) obj;
            return CastUtils.zza(this.zza, adBreakClipInfo.zza) && CastUtils.zza(this.zzb, adBreakClipInfo.zzb) && this.zzc == adBreakClipInfo.zzc && CastUtils.zza(this.zzd, adBreakClipInfo.zzd) && CastUtils.zza(this.zze, adBreakClipInfo.zze) && CastUtils.zza(this.zzf, adBreakClipInfo.zzf) && CastUtils.zza(this.zzg, adBreakClipInfo.zzg) && CastUtils.zza(this.zzh, adBreakClipInfo.zzh) && CastUtils.zza(this.zzi, adBreakClipInfo.zzi) && this.zzj == adBreakClipInfo.zzj && CastUtils.zza(this.zzk, adBreakClipInfo.zzk) && CastUtils.zza(this.zzl, adBreakClipInfo.zzl);
        }
        return false;
    }

    public String getClickThroughUrl() {
        return this.zzf;
    }

    public String getContentId() {
        return this.zzh;
    }

    public String getContentUrl() {
        return this.zzd;
    }

    public JSONObject getCustomData() {
        return this.zzm;
    }

    public long getDurationInMs() {
        return this.zzc;
    }

    public String getHlsSegmentFormat() {
        return this.zzk;
    }

    public String getId() {
        return this.zza;
    }

    public String getImageUrl() {
        return this.zzi;
    }

    public String getMimeType() {
        return this.zze;
    }

    public String getTitle() {
        return this.zzb;
    }

    public VastAdsRequest getVastAdsRequest() {
        return this.zzl;
    }

    public long getWhenSkippableInMs() {
        return this.zzj;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Long.valueOf(this.zzc), this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, Long.valueOf(this.zzj), this.zzk, this.zzl);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getId(), false);
        SafeParcelWriter.writeString(parcel, 3, getTitle(), false);
        SafeParcelWriter.writeLong(parcel, 4, getDurationInMs());
        SafeParcelWriter.writeString(parcel, 5, getContentUrl(), false);
        SafeParcelWriter.writeString(parcel, 6, getMimeType(), false);
        SafeParcelWriter.writeString(parcel, 7, getClickThroughUrl(), false);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.writeString(parcel, 9, getContentId(), false);
        SafeParcelWriter.writeString(parcel, 10, getImageUrl(), false);
        SafeParcelWriter.writeLong(parcel, 11, getWhenSkippableInMs());
        SafeParcelWriter.writeString(parcel, 12, getHlsSegmentFormat(), false);
        SafeParcelWriter.writeParcelable(parcel, 13, getVastAdsRequest(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.zza);
            jSONObject.put(TypedValues.TransitionType.S_DURATION, CastUtils.millisecToSec(this.zzc));
            long j = this.zzj;
            if (j != -1) {
                jSONObject.put("whenSkippable", CastUtils.millisecToSec(j));
            }
            String str = this.zzh;
            if (str != null) {
                jSONObject.put("contentId", str);
            }
            String str2 = this.zze;
            if (str2 != null) {
                jSONObject.put("contentType", str2);
            }
            String str3 = this.zzb;
            if (str3 != null) {
                jSONObject.put("title", str3);
            }
            String str4 = this.zzd;
            if (str4 != null) {
                jSONObject.put("contentUrl", str4);
            }
            String str5 = this.zzf;
            if (str5 != null) {
                jSONObject.put("clickThroughUrl", str5);
            }
            JSONObject jSONObject2 = this.zzm;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
            String str6 = this.zzi;
            if (str6 != null) {
                jSONObject.put("posterUrl", str6);
            }
            String str7 = this.zzk;
            if (str7 != null) {
                jSONObject.put("hlsSegmentFormat", str7);
            }
            VastAdsRequest vastAdsRequest = this.zzl;
            if (vastAdsRequest != null) {
                jSONObject.put("vastAdsRequest", vastAdsRequest.zza());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
