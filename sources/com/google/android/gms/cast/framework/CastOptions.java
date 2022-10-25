package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.cast.zzcz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public class CastOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CastOptions> CREATOR = new zze();
    private String zza;
    private final List<String> zzb;
    private boolean zzc;
    private LaunchOptions zzd;
    private final boolean zze;
    private final CastMediaOptions zzf;
    private final boolean zzg;
    private final double zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;

    /* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
    /* loaded from: classes2.dex */
    public static final class Builder {
        private String zza;
        private boolean zzc;
        private List<String> zzb = new ArrayList();
        private LaunchOptions zzd = new LaunchOptions();
        private boolean zze = true;
        private zzcz<CastMediaOptions> zzf = null;
        private boolean zzg = true;
        private double zzh = 0.05000000074505806d;

        public Builder setCastMediaOptions(CastMediaOptions castMediaOptions) {
            this.zzf = zzcz.zzb(castMediaOptions);
            return this;
        }

        public Builder setEnableReconnectionService(boolean z) {
            this.zzg = z;
            return this;
        }

        public Builder setLaunchOptions(LaunchOptions launchOptions) {
            this.zzd = launchOptions;
            return this;
        }

        public Builder setReceiverApplicationId(String str) {
            this.zza = str;
            return this;
        }

        public Builder setResumeSavedSession(boolean z) {
            this.zze = z;
            return this;
        }

        public Builder setStopReceiverApplicationWhenEndingSession(boolean z) {
            this.zzc = z;
            return this;
        }

        public Builder setSupportedNamespaces(List<String> list) {
            this.zzb = list;
            return this;
        }

        public Builder setVolumeDeltaBeforeIceCreamSandwich(double d) throws IllegalArgumentException {
            if (d <= 0.0d || d > 0.5d) {
                throw new IllegalArgumentException("volumeDelta must be greater than 0 and less or equal to 0.5");
            }
            this.zzh = d;
            return this;
        }

        public CastOptions build() {
            zzcz<CastMediaOptions> zzczVar = this.zzf;
            return new CastOptions(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzczVar != null ? zzczVar.zza() : new CastMediaOptions.Builder().build(), this.zzg, this.zzh, false, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CastOptions(String str, List<String> list, boolean z, LaunchOptions launchOptions, boolean z2, CastMediaOptions castMediaOptions, boolean z3, double d, boolean z4, boolean z5, boolean z6) {
        this.zza = true == TextUtils.isEmpty(str) ? "" : str;
        int size = list == null ? 0 : list.size();
        ArrayList arrayList = new ArrayList(size);
        this.zzb = arrayList;
        if (size > 0) {
            arrayList.addAll(list);
        }
        this.zzc = z;
        this.zzd = launchOptions == null ? new LaunchOptions() : launchOptions;
        this.zze = z2;
        this.zzf = castMediaOptions;
        this.zzg = z3;
        this.zzh = d;
        this.zzi = z4;
        this.zzj = z5;
        this.zzk = z6;
    }

    public CastMediaOptions getCastMediaOptions() {
        return this.zzf;
    }

    public boolean getEnableReconnectionService() {
        return this.zzg;
    }

    public LaunchOptions getLaunchOptions() {
        return this.zzd;
    }

    public String getReceiverApplicationId() {
        return this.zza;
    }

    public boolean getResumeSavedSession() {
        return this.zze;
    }

    public boolean getStopReceiverApplicationWhenEndingSession() {
        return this.zzc;
    }

    public List<String> getSupportedNamespaces() {
        return Collections.unmodifiableList(this.zzb);
    }

    public double getVolumeDeltaBeforeIceCreamSandwich() {
        return this.zzh;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getReceiverApplicationId(), false);
        SafeParcelWriter.writeStringList(parcel, 3, getSupportedNamespaces(), false);
        SafeParcelWriter.writeBoolean(parcel, 4, getStopReceiverApplicationWhenEndingSession());
        SafeParcelWriter.writeParcelable(parcel, 5, getLaunchOptions(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 6, getResumeSavedSession());
        SafeParcelWriter.writeParcelable(parcel, 7, getCastMediaOptions(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 8, getEnableReconnectionService());
        SafeParcelWriter.writeDouble(parcel, 9, getVolumeDeltaBeforeIceCreamSandwich());
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzj);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final void zza(String str) {
        this.zza = str;
    }

    public final void zzb(LaunchOptions launchOptions) {
        this.zzd = launchOptions;
    }

    public final boolean zzc() {
        return this.zzj;
    }

    public final boolean zzd() {
        return this.zzk;
    }
}
