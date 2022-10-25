package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public class AdBreakInfo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AdBreakInfo> CREATOR = new zzb();
    private final long zza;
    private final String zzb;
    private final long zzc;
    private final boolean zzd;
    private final String[] zze;
    private final boolean zzf;
    private final boolean zzg;

    /* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
    /* loaded from: classes2.dex */
    public static class Builder {
        private final long zza;
        private String zzb;
        private long zzc;
        private boolean zzd;
        private boolean zze;
        private String[] zzf;
        private boolean zzg;

        public Builder(long j) {
            this.zza = j;
        }

        public AdBreakInfo build() {
            return new AdBreakInfo(this.zza, this.zzb, this.zzc, this.zzd, this.zzf, this.zze, this.zzg);
        }

        public Builder setBreakClipIds(String[] strArr) {
            this.zzf = strArr;
            return this;
        }

        public Builder setDurationInMs(long j) {
            this.zzc = j;
            return this;
        }

        public Builder setId(String str) {
            this.zzb = str;
            return this;
        }

        public Builder setIsEmbedded(boolean z) {
            this.zze = z;
            return this;
        }

        public Builder setIsExpanded(boolean z) {
            this.zzg = z;
            return this;
        }

        public Builder setIsWatched(boolean z) {
            this.zzd = z;
            return this;
        }
    }

    public AdBreakInfo(long j, String str, long j2, boolean z, String[] strArr, boolean z2, boolean z3) {
        this.zza = j;
        this.zzb = str;
        this.zzc = j2;
        this.zzd = z;
        this.zze = strArr;
        this.zzf = z2;
        this.zzg = z3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdBreakInfo) {
            AdBreakInfo adBreakInfo = (AdBreakInfo) obj;
            return CastUtils.zza(this.zzb, adBreakInfo.zzb) && this.zza == adBreakInfo.zza && this.zzc == adBreakInfo.zzc && this.zzd == adBreakInfo.zzd && Arrays.equals(this.zze, adBreakInfo.zze) && this.zzf == adBreakInfo.zzf && this.zzg == adBreakInfo.zzg;
        }
        return false;
    }

    public String[] getBreakClipIds() {
        return this.zze;
    }

    public long getDurationInMs() {
        return this.zzc;
    }

    public String getId() {
        return this.zzb;
    }

    public long getPlaybackPositionInMs() {
        return this.zza;
    }

    public int hashCode() {
        return this.zzb.hashCode();
    }

    public boolean isEmbedded() {
        return this.zzf;
    }

    public boolean isExpanded() {
        return this.zzg;
    }

    public boolean isWatched() {
        return this.zzd;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, getPlaybackPositionInMs());
        SafeParcelWriter.writeString(parcel, 3, getId(), false);
        SafeParcelWriter.writeLong(parcel, 4, getDurationInMs());
        SafeParcelWriter.writeBoolean(parcel, 5, isWatched());
        SafeParcelWriter.writeStringArray(parcel, 6, getBreakClipIds(), false);
        SafeParcelWriter.writeBoolean(parcel, 7, isEmbedded());
        SafeParcelWriter.writeBoolean(parcel, 8, isExpanded());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.zzb);
            jSONObject.put("position", CastUtils.millisecToSec(this.zza));
            jSONObject.put("isWatched", this.zzd);
            jSONObject.put("isEmbedded", this.zzf);
            jSONObject.put(TypedValues.TransitionType.S_DURATION, CastUtils.millisecToSec(this.zzc));
            jSONObject.put("expanded", this.zzg);
            if (this.zze != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : this.zze) {
                    jSONArray.put(str);
                }
                jSONObject.put("breakClipIds", jSONArray);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
