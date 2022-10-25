package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public class AdBreakStatus extends AbstractSafeParcelable {
    @Deprecated
    public static final int AD_BREAK_CLIP_NOT_SKIPPABLE = -1;
    private final long zzb;
    private final long zzc;
    private final String zzd;
    private final String zze;
    private final long zzf;
    private static final Logger zza = new Logger("AdBreakStatus");
    public static final Parcelable.Creator<AdBreakStatus> CREATOR = new zzc();

    /* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
    /* loaded from: classes2.dex */
    public static class Builder {
        private long zza;
        private long zzb;
        private String zzc;
        private String zzd;
        private long zze = -1;

        public AdBreakStatus build() {
            return new AdBreakStatus(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
        }

        public Builder setBreakClipId(String str) {
            this.zzd = str;
            return this;
        }

        public Builder setBreakId(String str) {
            this.zzc = str;
            return this;
        }

        public Builder setCurrentBreakClipTimeInMs(long j) {
            this.zzb = j;
            return this;
        }

        public Builder setCurrentBreakTimeInMs(long j) {
            this.zza = j;
            return this;
        }

        public Builder setWhenSkippableInMs(long j) {
            this.zze = j;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdBreakStatus(long j, long j2, String str, String str2, long j3) {
        this.zzb = j;
        this.zzc = j2;
        this.zzd = str;
        this.zze = str2;
        this.zzf = j3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AdBreakStatus zzb(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("currentBreakTime") && jSONObject.has("currentBreakClipTime")) {
            try {
                long secToMillisec = CastUtils.secToMillisec(jSONObject.getLong("currentBreakTime"));
                long secToMillisec2 = CastUtils.secToMillisec(jSONObject.getLong("currentBreakClipTime"));
                String optStringOrNull = CastUtils.optStringOrNull(jSONObject, "breakId");
                String optStringOrNull2 = CastUtils.optStringOrNull(jSONObject, "breakClipId");
                long optLong = jSONObject.optLong("whenSkippable", -1L);
                return new AdBreakStatus(secToMillisec, secToMillisec2, optStringOrNull, optStringOrNull2, optLong != -1 ? CastUtils.secToMillisec(optLong) : optLong);
            } catch (JSONException e) {
                zza.m366e(e, "Error while creating an AdBreakClipInfo from JSON", new Object[0]);
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdBreakStatus) {
            AdBreakStatus adBreakStatus = (AdBreakStatus) obj;
            return this.zzb == adBreakStatus.zzb && this.zzc == adBreakStatus.zzc && CastUtils.zza(this.zzd, adBreakStatus.zzd) && CastUtils.zza(this.zze, adBreakStatus.zze) && this.zzf == adBreakStatus.zzf;
        }
        return false;
    }

    public String getBreakClipId() {
        return this.zze;
    }

    public String getBreakId() {
        return this.zzd;
    }

    public long getCurrentBreakClipTimeInMs() {
        return this.zzc;
    }

    public long getCurrentBreakTimeInMs() {
        return this.zzb;
    }

    public long getWhenSkippableInMs() {
        return this.zzf;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zzb), Long.valueOf(this.zzc), this.zzd, this.zze, Long.valueOf(this.zzf));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, getCurrentBreakTimeInMs());
        SafeParcelWriter.writeLong(parcel, 3, getCurrentBreakClipTimeInMs());
        SafeParcelWriter.writeString(parcel, 4, getBreakId(), false);
        SafeParcelWriter.writeString(parcel, 5, getBreakClipId(), false);
        SafeParcelWriter.writeLong(parcel, 6, getWhenSkippableInMs());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("currentBreakTime", CastUtils.millisecToSec(this.zzb));
            jSONObject.put("currentBreakClipTime", CastUtils.millisecToSec(this.zzc));
            jSONObject.putOpt("breakId", this.zzd);
            jSONObject.putOpt("breakClipId", this.zze);
            long j = this.zzf;
            if (j != -1) {
                jSONObject.put("whenSkippable", CastUtils.millisecToSec(j));
            }
            return jSONObject;
        } catch (JSONException e) {
            zza.m366e(e, "Error transforming AdBreakStatus into JSONObject", new Object[0]);
            return new JSONObject();
        }
    }
}
