package com.google.android.gms.cast.framework.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public class NotificationAction extends AbstractSafeParcelable {
    public static final Parcelable.Creator<NotificationAction> CREATOR = new zzy();
    private final String zza;
    private final int zzb;
    private final String zzc;

    /* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
    /* loaded from: classes2.dex */
    public static final class Builder {
        String zza;
        int zzb;
        String zzc;

        public NotificationAction build() {
            return new NotificationAction(this.zza, this.zzb, this.zzc);
        }

        public Builder setAction(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.zza = str;
                return this;
            }
            throw new IllegalArgumentException("action cannot be null or an empty string.");
        }

        public Builder setContentDescription(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.zzc = str;
                return this;
            }
            throw new IllegalArgumentException("contentDescription cannot be null  or an empty string.");
        }

        public Builder setIconResId(int i) {
            this.zzb = i;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NotificationAction(String str, int i, String str2) {
        this.zza = str;
        this.zzb = i;
        this.zzc = str2;
    }

    public String getAction() {
        return this.zza;
    }

    public String getContentDescription() {
        return this.zzc;
    }

    public int getIconResId() {
        return this.zzb;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getAction(), false);
        SafeParcelWriter.writeInt(parcel, 3, getIconResId());
        SafeParcelWriter.writeString(parcel, 4, getContentDescription(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
