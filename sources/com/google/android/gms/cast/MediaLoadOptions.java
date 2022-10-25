package com.google.android.gms.cast;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public class MediaLoadOptions {
    public static final double PLAYBACK_RATE_MAX = 2.0d;
    public static final double PLAYBACK_RATE_MIN = 0.5d;
    private boolean zza;
    private long zzb;
    private double zzc;
    private final long[] zzd;
    private final JSONObject zze;
    private final String zzf;
    private final String zzg;

    /* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
    /* loaded from: classes2.dex */
    public static class Builder {
        private boolean zza = true;
        private long zzb = -1;
        private double zzc = 1.0d;
        private long[] zzd;
        private JSONObject zze;
        private String zzf;
        private String zzg;

        public MediaLoadOptions build() {
            return new MediaLoadOptions(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, null);
        }

        public Builder setActiveTrackIds(long[] jArr) {
            this.zzd = jArr;
            return this;
        }

        public Builder setAutoplay(boolean z) {
            this.zza = z;
            return this;
        }

        public Builder setCredentials(String str) {
            this.zzf = str;
            return this;
        }

        public Builder setCredentialsType(String str) {
            this.zzg = str;
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zze = jSONObject;
            return this;
        }

        public Builder setPlayPosition(long j) {
            this.zzb = j;
            return this;
        }

        public Builder setPlaybackRate(double d) {
            if (Double.compare(d, 2.0d) > 0 || Double.compare(d, 0.5d) < 0) {
                throw new IllegalArgumentException("playbackRate must be between PLAYBACK_RATE_MIN and PLAYBACK_RATE_MAX");
            }
            this.zzc = d;
            return this;
        }
    }

    /* synthetic */ MediaLoadOptions(boolean z, long j, double d, long[] jArr, JSONObject jSONObject, String str, String str2, zzbr zzbrVar) {
        this.zza = z;
        this.zzb = j;
        this.zzc = d;
        this.zzd = jArr;
        this.zze = jSONObject;
        this.zzf = str;
        this.zzg = str2;
    }

    public long[] getActiveTrackIds() {
        return this.zzd;
    }

    public boolean getAutoplay() {
        return this.zza;
    }

    public String getCredentials() {
        return this.zzf;
    }

    public String getCredentialsType() {
        return this.zzg;
    }

    public JSONObject getCustomData() {
        return this.zze;
    }

    public long getPlayPosition() {
        return this.zzb;
    }

    public double getPlaybackRate() {
        return this.zzc;
    }
}
