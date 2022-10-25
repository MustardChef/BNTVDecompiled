package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.JsonUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public class SessionState extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SessionState> CREATOR = new zzdi();
    String zza;
    private final MediaLoadRequestData zzb;
    private final JSONObject zzc;

    /* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
    /* loaded from: classes2.dex */
    public static class Builder {
        private MediaLoadRequestData zza;
        private JSONObject zzb;

        public SessionState build() {
            return new SessionState(this.zza, this.zzb);
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zzb = jSONObject;
            return this;
        }

        public Builder setLoadRequestData(MediaLoadRequestData mediaLoadRequestData) {
            this.zza = mediaLoadRequestData;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionState(MediaLoadRequestData mediaLoadRequestData, JSONObject jSONObject) {
        this.zzb = mediaLoadRequestData;
        this.zzc = jSONObject;
    }

    public static SessionState fromJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("loadRequestData");
        return new SessionState(optJSONObject != null ? MediaLoadRequestData.fromJson(optJSONObject) : null, jSONObject.optJSONObject("customData"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SessionState) {
            SessionState sessionState = (SessionState) obj;
            if (JsonUtils.areJsonValuesEquivalent(this.zzc, sessionState.zzc)) {
                return Objects.equal(this.zzb, sessionState.zzb);
            }
            return false;
        }
        return false;
    }

    public JSONObject getCustomData() {
        return this.zzc;
    }

    public MediaLoadRequestData getLoadRequestData() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb, String.valueOf(this.zzc));
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            MediaLoadRequestData mediaLoadRequestData = this.zzb;
            if (mediaLoadRequestData != null) {
                jSONObject.put("loadRequestData", mediaLoadRequestData.toJson());
            }
            jSONObject.put("customData", this.zzc);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        JSONObject jSONObject = this.zzc;
        this.zza = jSONObject == null ? null : jSONObject.toString();
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getLoadRequestData(), i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
