package com.google.android.gms.internal.p038firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Strings;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxk */
/* loaded from: classes3.dex */
public final class zzxk extends AbstractSafeParcelable implements zztz<zzxk> {
    public static final Parcelable.Creator<zzxk> CREATOR = new zzxl();
    private static final String zza = "zzxk";
    private String zzb;
    private String zzc;
    private long zzd;
    private boolean zze;

    public zzxk() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zztz
    public final /* bridge */ /* synthetic */ zzxk zza(String str) throws zzpp {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("idToken", null));
            this.zzc = Strings.emptyToNull(jSONObject.optString("refreshToken", null));
            this.zzd = jSONObject.optLong("expiresIn", 0L);
            this.zze = jSONObject.optBoolean("isNewUser", false);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzxs.zzb(e, zza, str);
        }
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final long zzd() {
        return this.zzd;
    }

    public final boolean zze() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxk(String str, String str2, long j, boolean z) {
        this.zzb = str;
        this.zzc = str2;
        this.zzd = j;
        this.zze = z;
    }
}
