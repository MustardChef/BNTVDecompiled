package com.google.android.gms.cast;

import com.google.android.gms.common.internal.Objects;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public class MediaSeekOptions {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    private final long zza;
    private final int zzb;
    private final boolean zzc;
    private final JSONObject zzd;

    /* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
    /* loaded from: classes2.dex */
    public static class Builder {
        private long zza;
        private int zzb = 0;
        private boolean zzc;
        private JSONObject zzd;

        public MediaSeekOptions build() {
            return new MediaSeekOptions(this.zza, this.zzb, this.zzc, this.zzd, null);
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zzd = jSONObject;
            return this;
        }

        public Builder setIsSeekToInfinite(boolean z) {
            this.zzc = z;
            return this;
        }

        public Builder setPosition(long j) {
            this.zza = j;
            return this;
        }

        public Builder setResumeState(int i) {
            this.zzb = i;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface ResumeState {
    }

    /* synthetic */ MediaSeekOptions(long j, int i, boolean z, JSONObject jSONObject, zzcc zzccVar) {
        this.zza = j;
        this.zzb = i;
        this.zzc = z;
        this.zzd = jSONObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MediaSeekOptions) {
            MediaSeekOptions mediaSeekOptions = (MediaSeekOptions) obj;
            return this.zza == mediaSeekOptions.zza && this.zzb == mediaSeekOptions.zzb && this.zzc == mediaSeekOptions.zzc && Objects.equal(this.zzd, mediaSeekOptions.zzd);
        }
        return false;
    }

    public JSONObject getCustomData() {
        return this.zzd;
    }

    public long getPosition() {
        return this.zza;
    }

    public int getResumeState() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Integer.valueOf(this.zzb), Boolean.valueOf(this.zzc), this.zzd);
    }

    public boolean isSeekToInfinite() {
        return this.zzc;
    }
}
