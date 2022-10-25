package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public class MediaLiveSeekableRange extends AbstractSafeParcelable {
    private final long zzb;
    private final long zzc;
    private final boolean zzd;
    private final boolean zze;
    private static final Logger zza = new Logger("MediaLiveSeekableRange");
    public static final Parcelable.Creator<MediaLiveSeekableRange> CREATOR = new zzbq();

    /* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
    /* loaded from: classes2.dex */
    public static class Builder {
        private long zza;
        private long zzb;
        private boolean zzc;
        private boolean zzd;

        public MediaLiveSeekableRange build() {
            return new MediaLiveSeekableRange(this.zza, this.zzb, this.zzc, this.zzd);
        }

        public Builder setEndTime(long j) {
            this.zzb = j;
            return this;
        }

        public Builder setIsLiveDone(boolean z) {
            this.zzd = z;
            return this;
        }

        public Builder setIsMovingWindow(boolean z) {
            this.zzc = z;
            return this;
        }

        public Builder setStartTime(long j) {
            this.zza = j;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaLiveSeekableRange(long j, long j2, boolean z, boolean z2) {
        this.zzb = Math.max(j, 0L);
        this.zzc = Math.max(j2, 0L);
        this.zzd = z;
        this.zze = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MediaLiveSeekableRange zzb(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has(TtmlNode.START) && jSONObject.has(TtmlNode.END)) {
            try {
                long secToMillisec = CastUtils.secToMillisec(jSONObject.getDouble(TtmlNode.START));
                double d = jSONObject.getDouble(TtmlNode.END);
                return new MediaLiveSeekableRange(secToMillisec, CastUtils.secToMillisec(d), jSONObject.optBoolean("isMovingWindow"), jSONObject.optBoolean("isLiveDone"));
            } catch (JSONException unused) {
                Logger logger = zza;
                String valueOf = String.valueOf(jSONObject);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 43);
                sb.append("Ignoring Malformed MediaLiveSeekableRange: ");
                sb.append(valueOf);
                logger.m367e(sb.toString(), new Object[0]);
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MediaLiveSeekableRange) {
            MediaLiveSeekableRange mediaLiveSeekableRange = (MediaLiveSeekableRange) obj;
            return this.zzb == mediaLiveSeekableRange.zzb && this.zzc == mediaLiveSeekableRange.zzc && this.zzd == mediaLiveSeekableRange.zzd && this.zze == mediaLiveSeekableRange.zze;
        }
        return false;
    }

    public long getEndTime() {
        return this.zzc;
    }

    public long getStartTime() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zzb), Long.valueOf(this.zzc), Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze));
    }

    public boolean isLiveDone() {
        return this.zze;
    }

    public boolean isMovingWindow() {
        return this.zzd;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, getStartTime());
        SafeParcelWriter.writeLong(parcel, 3, getEndTime());
        SafeParcelWriter.writeBoolean(parcel, 4, isMovingWindow());
        SafeParcelWriter.writeBoolean(parcel, 5, isLiveDone());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final JSONObject zza() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TtmlNode.START, CastUtils.millisecToSec(this.zzb));
            jSONObject.put(TtmlNode.END, CastUtils.millisecToSec(this.zzc));
            jSONObject.put("isMovingWindow", this.zzd);
            jSONObject.put("isLiveDone", this.zze);
            return jSONObject;
        } catch (JSONException unused) {
            zza.m367e("Error transforming MediaLiveSeekableRange into JSONObject", new Object[0]);
            return new JSONObject();
        }
    }
}
