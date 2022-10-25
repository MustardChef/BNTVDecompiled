package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.cast.MediaQueueContainerMetadata;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.media.MediaCommon;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public class MediaQueueData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MediaQueueData> CREATOR = new zzbz();
    public static final int MEDIA_QUEUE_TYPE_ALBUM = 1;
    public static final int MEDIA_QUEUE_TYPE_AUDIO_BOOK = 3;
    public static final int MEDIA_QUEUE_TYPE_GENERIC = 0;
    public static final int MEDIA_QUEUE_TYPE_LIVE_TV = 8;
    public static final int MEDIA_QUEUE_TYPE_MOVIE = 9;
    public static final int MEDIA_QUEUE_TYPE_PLAYLIST = 2;
    public static final int MEDIA_QUEUE_TYPE_PODCAST_SERIES = 5;
    public static final int MEDIA_QUEUE_TYPE_RADIO_STATION = 4;
    public static final int MEDIA_QUEUE_TYPE_TV_SERIES = 6;
    public static final int MEDIA_QUEUE_TYPE_VIDEO_PLAYLIST = 7;
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private MediaQueueContainerMetadata zze;
    private int zzf;
    private List<MediaQueueItem> zzg;
    private int zzh;
    private long zzi;

    /* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
    /* loaded from: classes2.dex */
    public static class Builder {
        private final MediaQueueData zza;

        public Builder() {
            this.zza = new MediaQueueData(null);
        }

        public MediaQueueData build() {
            return new MediaQueueData(this.zza, null);
        }

        public Builder setContainerMetadata(MediaQueueContainerMetadata mediaQueueContainerMetadata) {
            this.zza.zze = mediaQueueContainerMetadata;
            return this;
        }

        public Builder setEntity(String str) {
            this.zza.zzb = str;
            return this;
        }

        public Builder setItems(List<MediaQueueItem> list) {
            MediaQueueData.zzg(this.zza, list);
            return this;
        }

        public Builder setName(String str) {
            this.zza.zzd = str;
            return this;
        }

        public Builder setQueueId(String str) {
            this.zza.zza = str;
            return this;
        }

        public Builder setQueueType(int i) {
            this.zza.zzc = i;
            return this;
        }

        public Builder setRepeatMode(int i) {
            this.zza.setRepeatMode(i);
            return this;
        }

        public Builder setStartIndex(int i) {
            this.zza.zzh = i;
            return this;
        }

        public Builder setStartTime(long j) {
            this.zza.zzi = j;
            return this;
        }

        public final Builder zza(JSONObject jSONObject) {
            MediaQueueData.zzj(this.zza, jSONObject);
            return this;
        }

        public Builder(MediaQueueData mediaQueueData) {
            this.zza = new MediaQueueData(mediaQueueData, null);
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface MediaQueueType {
    }

    private MediaQueueData() {
        zzk();
    }

    static /* synthetic */ void zzg(MediaQueueData mediaQueueData, List list) {
        mediaQueueData.zzg = list == null ? null : new ArrayList(list);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ void zzj(MediaQueueData mediaQueueData, JSONObject jSONObject) {
        char c;
        mediaQueueData.zzk();
        if (jSONObject == null) {
            return;
        }
        mediaQueueData.zza = CastUtils.optStringOrNull(jSONObject, "id");
        mediaQueueData.zzb = CastUtils.optStringOrNull(jSONObject, "entity");
        String optString = jSONObject.optString("queueType");
        switch (optString.hashCode()) {
            case -1803151310:
                if (optString.equals("PODCAST_SERIES")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1758903120:
                if (optString.equals("RADIO_STATION")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1632865838:
                if (optString.equals("PLAYLIST")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1319760993:
                if (optString.equals("AUDIOBOOK")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1088524588:
                if (optString.equals("TV_SERIES")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 62359119:
                if (optString.equals("ALBUM")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 73549584:
                if (optString.equals("MOVIE")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 393100598:
                if (optString.equals("VIDEO_PLAYLIST")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 902303413:
                if (optString.equals("LIVE_TV")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                mediaQueueData.zzc = 1;
                break;
            case 1:
                mediaQueueData.zzc = 2;
                break;
            case 2:
                mediaQueueData.zzc = 3;
                break;
            case 3:
                mediaQueueData.zzc = 4;
                break;
            case 4:
                mediaQueueData.zzc = 5;
                break;
            case 5:
                mediaQueueData.zzc = 6;
                break;
            case 6:
                mediaQueueData.zzc = 7;
                break;
            case 7:
                mediaQueueData.zzc = 8;
                break;
            case '\b':
                mediaQueueData.zzc = 9;
                break;
        }
        mediaQueueData.zzd = CastUtils.optStringOrNull(jSONObject, "name");
        JSONObject optJSONObject = jSONObject.has("containerMetadata") ? jSONObject.optJSONObject("containerMetadata") : null;
        if (optJSONObject != null) {
            MediaQueueContainerMetadata.Builder builder = new MediaQueueContainerMetadata.Builder();
            builder.zza(optJSONObject);
            mediaQueueData.zze = builder.build();
        }
        Integer mediaRepeatModeFromString = MediaCommon.mediaRepeatModeFromString(jSONObject.optString("repeatMode"));
        if (mediaRepeatModeFromString != null) {
            mediaQueueData.zzf = mediaRepeatModeFromString.intValue();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(FirebaseAnalytics.Param.ITEMS);
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            mediaQueueData.zzg = arrayList;
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    try {
                        arrayList.add(new MediaQueueItem(optJSONObject2));
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        mediaQueueData.zzh = jSONObject.optInt("startIndex", mediaQueueData.zzh);
        if (jSONObject.has("startTime")) {
            mediaQueueData.zzi = CastUtils.secToMillisec(jSONObject.optDouble("startTime", mediaQueueData.zzi));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzk() {
        this.zza = null;
        this.zzb = null;
        this.zzc = 0;
        this.zzd = null;
        this.zzf = 0;
        this.zzg = null;
        this.zzh = 0;
        this.zzi = -1L;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MediaQueueData) {
            MediaQueueData mediaQueueData = (MediaQueueData) obj;
            return TextUtils.equals(this.zza, mediaQueueData.zza) && TextUtils.equals(this.zzb, mediaQueueData.zzb) && this.zzc == mediaQueueData.zzc && TextUtils.equals(this.zzd, mediaQueueData.zzd) && Objects.equal(this.zze, mediaQueueData.zze) && this.zzf == mediaQueueData.zzf && Objects.equal(this.zzg, mediaQueueData.zzg) && this.zzh == mediaQueueData.zzh && this.zzi == mediaQueueData.zzi;
        }
        return false;
    }

    public MediaQueueContainerMetadata getContainerMetadata() {
        return this.zze;
    }

    public String getEntity() {
        return this.zzb;
    }

    public List<MediaQueueItem> getItems() {
        List<MediaQueueItem> list = this.zzg;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public String getName() {
        return this.zzd;
    }

    public String getQueueId() {
        return this.zza;
    }

    public int getQueueType() {
        return this.zzc;
    }

    public int getRepeatMode() {
        return this.zzf;
    }

    public int getStartIndex() {
        return this.zzh;
    }

    public long getStartTime() {
        return this.zzi;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Integer.valueOf(this.zzc), this.zzd, this.zze, Integer.valueOf(this.zzf), this.zzg, Integer.valueOf(this.zzh), Long.valueOf(this.zzi));
    }

    public void setRepeatMode(int i) {
        this.zzf = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getQueueId(), false);
        SafeParcelWriter.writeString(parcel, 3, getEntity(), false);
        SafeParcelWriter.writeInt(parcel, 4, getQueueType());
        SafeParcelWriter.writeString(parcel, 5, getName(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, getContainerMetadata(), i, false);
        SafeParcelWriter.writeInt(parcel, 7, getRepeatMode());
        SafeParcelWriter.writeTypedList(parcel, 8, getItems(), false);
        SafeParcelWriter.writeInt(parcel, 9, getStartIndex());
        SafeParcelWriter.writeLong(parcel, 10, getStartTime());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.zza)) {
                jSONObject.put("id", this.zza);
            }
            if (!TextUtils.isEmpty(this.zzb)) {
                jSONObject.put("entity", this.zzb);
            }
            switch (this.zzc) {
                case 1:
                    jSONObject.put("queueType", "ALBUM");
                    break;
                case 2:
                    jSONObject.put("queueType", "PLAYLIST");
                    break;
                case 3:
                    jSONObject.put("queueType", "AUDIOBOOK");
                    break;
                case 4:
                    jSONObject.put("queueType", "RADIO_STATION");
                    break;
                case 5:
                    jSONObject.put("queueType", "PODCAST_SERIES");
                    break;
                case 6:
                    jSONObject.put("queueType", "TV_SERIES");
                    break;
                case 7:
                    jSONObject.put("queueType", "VIDEO_PLAYLIST");
                    break;
                case 8:
                    jSONObject.put("queueType", "LIVE_TV");
                    break;
                case 9:
                    jSONObject.put("queueType", "MOVIE");
                    break;
            }
            if (!TextUtils.isEmpty(this.zzd)) {
                jSONObject.put("name", this.zzd);
            }
            MediaQueueContainerMetadata mediaQueueContainerMetadata = this.zze;
            if (mediaQueueContainerMetadata != null) {
                jSONObject.put("containerMetadata", mediaQueueContainerMetadata.zzb());
            }
            String zza = MediaCommon.zza(Integer.valueOf(this.zzf));
            if (zza != null) {
                jSONObject.put("repeatMode", zza);
            }
            List<MediaQueueItem> list = this.zzg;
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (MediaQueueItem mediaQueueItem : this.zzg) {
                    jSONArray.put(mediaQueueItem.toJson());
                }
                jSONObject.put(FirebaseAnalytics.Param.ITEMS, jSONArray);
            }
            jSONObject.put("startIndex", this.zzh);
            long j = this.zzi;
            if (j != -1) {
                jSONObject.put("startTime", CastUtils.millisecToSec(j));
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* synthetic */ MediaQueueData(zzby zzbyVar) {
        zzk();
    }

    /* synthetic */ MediaQueueData(MediaQueueData mediaQueueData, zzby zzbyVar) {
        this.zza = mediaQueueData.zza;
        this.zzb = mediaQueueData.zzb;
        this.zzc = mediaQueueData.zzc;
        this.zzd = mediaQueueData.zzd;
        this.zze = mediaQueueData.zze;
        this.zzf = mediaQueueData.zzf;
        this.zzg = mediaQueueData.zzg;
        this.zzh = mediaQueueData.zzh;
        this.zzi = mediaQueueData.zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaQueueData(String str, String str2, int i, String str3, MediaQueueContainerMetadata mediaQueueContainerMetadata, int i2, List<MediaQueueItem> list, int i3, long j) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i;
        this.zzd = str3;
        this.zze = mediaQueueContainerMetadata;
        this.zzf = i2;
        this.zzg = list;
        this.zzh = i3;
        this.zzi = j;
    }
}
