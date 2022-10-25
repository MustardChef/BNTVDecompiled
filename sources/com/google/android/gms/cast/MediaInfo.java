package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.JsonUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public class MediaInfo extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<MediaInfo> CREATOR = new zzbp();
    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;
    public static final long UNKNOWN_DURATION = -1;
    public static final long UNKNOWN_START_ABSOLUTE_TIME = -1;
    String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private MediaMetadata zze;
    private long zzf;
    private List<MediaTrack> zzg;
    private TextTrackStyle zzh;
    private List<AdBreakInfo> zzi;
    private List<AdBreakClipInfo> zzj;
    private String zzk;
    private VastAdsRequest zzl;
    private long zzm;
    private String zzn;
    private String zzo;
    private String zzp;
    private String zzq;
    private JSONObject zzr;
    private final Writer zzs;

    /* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
    /* loaded from: classes2.dex */
    public static class Builder {
        private final MediaInfo zza;

        public Builder(String str) throws IllegalArgumentException {
            this.zza = new MediaInfo(str);
        }

        public MediaInfo build() {
            return this.zza;
        }

        public Builder setAdBreakClips(List<AdBreakClipInfo> list) {
            this.zza.getWriter().setAdBreakClips(list);
            return this;
        }

        public Builder setAdBreaks(List<AdBreakInfo> list) {
            this.zza.getWriter().setAdBreaks(list);
            return this;
        }

        public Builder setAtvEntity(String str) {
            this.zza.zzn = str;
            return this;
        }

        public Builder setContentType(String str) {
            this.zza.getWriter().setContentType(str);
            return this;
        }

        public Builder setContentUrl(String str) {
            this.zza.getWriter().setContentUrl(str);
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zza.getWriter().setCustomData(jSONObject);
            return this;
        }

        public Builder setEntity(String str) {
            this.zza.getWriter().setEntity(str);
            return this;
        }

        public Builder setHlsSegmentFormat(String str) {
            this.zza.getWriter().setHlsSegmentFormat(str);
            return this;
        }

        public Builder setHlsVideoSegmentFormat(String str) {
            this.zza.getWriter().setHlsVideoSegmentFormat(str);
            return this;
        }

        public Builder setMediaTracks(List<MediaTrack> list) {
            this.zza.getWriter().setMediaTracks(list);
            return this;
        }

        public Builder setMetadata(MediaMetadata mediaMetadata) {
            this.zza.getWriter().setMetadata(mediaMetadata);
            return this;
        }

        public Builder setStreamDuration(long j) throws IllegalArgumentException {
            this.zza.getWriter().setStreamDuration(j);
            return this;
        }

        public Builder setStreamType(int i) throws IllegalArgumentException {
            this.zza.getWriter().setStreamType(i);
            return this;
        }

        public Builder setTextTrackStyle(TextTrackStyle textTrackStyle) {
            this.zza.getWriter().setTextTrackStyle(textTrackStyle);
            return this;
        }

        public Builder setVmapAdsRequest(VastAdsRequest vastAdsRequest) {
            this.zza.getWriter().setVmapAdsRequest(vastAdsRequest);
            return this;
        }

        public Builder(String str, String str2) throws IllegalArgumentException {
            this.zza = new MediaInfo(str, str2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
    /* loaded from: classes2.dex */
    public class Writer {
        public Writer() {
        }

        public void setAdBreakClips(List<AdBreakClipInfo> list) {
            MediaInfo.this.zzj = list;
        }

        public void setAdBreaks(List<AdBreakInfo> list) {
            MediaInfo.this.zzi = list;
        }

        public void setContentId(String str) {
            MediaInfo.this.zzb = str;
        }

        public void setContentType(String str) {
            MediaInfo.this.zzd = str;
        }

        public void setContentUrl(String str) {
            MediaInfo.this.zzo = str;
        }

        public void setCustomData(JSONObject jSONObject) {
            MediaInfo.this.zzr = jSONObject;
        }

        public void setEntity(String str) {
            MediaInfo.this.zzk = str;
        }

        public void setHlsSegmentFormat(String str) {
            MediaInfo.this.zzp = str;
        }

        public void setHlsVideoSegmentFormat(String str) {
            MediaInfo.this.zzq = str;
        }

        public void setMediaTracks(List<MediaTrack> list) {
            MediaInfo.this.zzg = list;
        }

        public void setMetadata(MediaMetadata mediaMetadata) {
            MediaInfo.this.zze = mediaMetadata;
        }

        public void setStreamType(int i) {
            if (i < -1 || i > 2) {
                throw new IllegalArgumentException("invalid stream type");
            }
            MediaInfo.this.zzc = i;
        }

        public void setTextTrackStyle(TextTrackStyle textTrackStyle) {
            MediaInfo.this.zzh = textTrackStyle;
        }

        public void setVmapAdsRequest(VastAdsRequest vastAdsRequest) {
            MediaInfo.this.zzl = vastAdsRequest;
        }

        public void setStartAbsoluteTime(long j) {
            if (j >= 0 || j == -1) {
                MediaInfo.this.zzm = j;
                return;
            }
            throw new IllegalArgumentException("Invalid start absolute time");
        }

        public void setStreamDuration(long j) {
            if (j >= 0 || j == -1) {
                MediaInfo.this.zzf = j;
                return;
            }
            throw new IllegalArgumentException("Invalid stream duration");
        }
    }

    MediaInfo(String str) throws IllegalArgumentException {
        this(str, -1, null, null, -1L, null, null, null, null, null, null, null, -1L, null, null, null, null);
        if (str == null) {
            throw new IllegalArgumentException("contentID cannot be null");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MediaInfo) {
            MediaInfo mediaInfo = (MediaInfo) obj;
            JSONObject jSONObject = this.zzr;
            boolean z = jSONObject == null;
            JSONObject jSONObject2 = mediaInfo.zzr;
            if (z != (jSONObject2 == null)) {
                return false;
            }
            return (jSONObject == null || jSONObject2 == null || JsonUtils.areJsonValuesEquivalent(jSONObject, jSONObject2)) && CastUtils.zza(this.zzb, mediaInfo.zzb) && this.zzc == mediaInfo.zzc && CastUtils.zza(this.zzd, mediaInfo.zzd) && CastUtils.zza(this.zze, mediaInfo.zze) && this.zzf == mediaInfo.zzf && CastUtils.zza(this.zzg, mediaInfo.zzg) && CastUtils.zza(this.zzh, mediaInfo.zzh) && CastUtils.zza(this.zzi, mediaInfo.zzi) && CastUtils.zza(this.zzj, mediaInfo.zzj) && CastUtils.zza(this.zzk, mediaInfo.zzk) && CastUtils.zza(this.zzl, mediaInfo.zzl) && this.zzm == mediaInfo.zzm && CastUtils.zza(this.zzn, mediaInfo.zzn) && CastUtils.zza(this.zzo, mediaInfo.zzo) && CastUtils.zza(this.zzp, mediaInfo.zzp) && CastUtils.zza(this.zzq, mediaInfo.zzq);
        }
        return false;
    }

    public List<AdBreakClipInfo> getAdBreakClips() {
        List<AdBreakClipInfo> list = this.zzj;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public List<AdBreakInfo> getAdBreaks() {
        List<AdBreakInfo> list = this.zzi;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public String getContentId() {
        return this.zzb;
    }

    public String getContentType() {
        return this.zzd;
    }

    public String getContentUrl() {
        return this.zzo;
    }

    public JSONObject getCustomData() {
        return this.zzr;
    }

    public String getEntity() {
        return this.zzk;
    }

    public String getHlsSegmentFormat() {
        return this.zzp;
    }

    public String getHlsVideoSegmentFormat() {
        return this.zzq;
    }

    public List<MediaTrack> getMediaTracks() {
        return this.zzg;
    }

    public MediaMetadata getMetadata() {
        return this.zze;
    }

    public long getStartAbsoluteTime() {
        return this.zzm;
    }

    public long getStreamDuration() {
        return this.zzf;
    }

    public int getStreamType() {
        return this.zzc;
    }

    public TextTrackStyle getTextTrackStyle() {
        return this.zzh;
    }

    public VastAdsRequest getVmapAdsRequest() {
        return this.zzl;
    }

    public Writer getWriter() {
        return this.zzs;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb, Integer.valueOf(this.zzc), this.zzd, this.zze, Long.valueOf(this.zzf), String.valueOf(this.zzr), this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, Long.valueOf(this.zzm), this.zzn, this.zzp, this.zzq);
    }

    public void setTextTrackStyle(TextTrackStyle textTrackStyle) {
        this.zzh = textTrackStyle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        JSONObject jSONObject = this.zzr;
        this.zza = jSONObject == null ? null : jSONObject.toString();
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getContentId(), false);
        SafeParcelWriter.writeInt(parcel, 3, getStreamType());
        SafeParcelWriter.writeString(parcel, 4, getContentType(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, getMetadata(), i, false);
        SafeParcelWriter.writeLong(parcel, 6, getStreamDuration());
        SafeParcelWriter.writeTypedList(parcel, 7, getMediaTracks(), false);
        SafeParcelWriter.writeParcelable(parcel, 8, getTextTrackStyle(), i, false);
        SafeParcelWriter.writeString(parcel, 9, this.zza, false);
        SafeParcelWriter.writeTypedList(parcel, 10, getAdBreaks(), false);
        SafeParcelWriter.writeTypedList(parcel, 11, getAdBreakClips(), false);
        SafeParcelWriter.writeString(parcel, 12, getEntity(), false);
        SafeParcelWriter.writeParcelable(parcel, 13, getVmapAdsRequest(), i, false);
        SafeParcelWriter.writeLong(parcel, 14, getStartAbsoluteTime());
        SafeParcelWriter.writeString(parcel, 15, this.zzn, false);
        SafeParcelWriter.writeString(parcel, 16, getContentUrl(), false);
        SafeParcelWriter.writeString(parcel, 17, getHlsSegmentFormat(), false);
        SafeParcelWriter.writeString(parcel, 18, getHlsVideoSegmentFormat(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ac A[LOOP:0: B:5:0x0022->B:26:0x00ac, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x018a A[LOOP:2: B:32:0x00d3->B:59:0x018a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0191 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(org.json.JSONObject r40) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaInfo.zza(org.json.JSONObject):void");
    }

    public final JSONObject zzb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentId", this.zzb);
            jSONObject.putOpt("contentUrl", this.zzo);
            int i = this.zzc;
            jSONObject.put("streamType", i != 1 ? i != 2 ? "NONE" : "LIVE" : "BUFFERED");
            String str = this.zzd;
            if (str != null) {
                jSONObject.put("contentType", str);
            }
            MediaMetadata mediaMetadata = this.zze;
            if (mediaMetadata != null) {
                jSONObject.put(TtmlNode.TAG_METADATA, mediaMetadata.zza());
            }
            long j = this.zzf;
            if (j <= -1) {
                jSONObject.put(TypedValues.TransitionType.S_DURATION, JSONObject.NULL);
            } else {
                jSONObject.put(TypedValues.TransitionType.S_DURATION, CastUtils.millisecToSec(j));
            }
            if (this.zzg != null) {
                JSONArray jSONArray = new JSONArray();
                for (MediaTrack mediaTrack : this.zzg) {
                    jSONArray.put(mediaTrack.zza());
                }
                jSONObject.put("tracks", jSONArray);
            }
            TextTrackStyle textTrackStyle = this.zzh;
            if (textTrackStyle != null) {
                jSONObject.put("textTrackStyle", textTrackStyle.zza());
            }
            JSONObject jSONObject2 = this.zzr;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
            String str2 = this.zzk;
            if (str2 != null) {
                jSONObject.put("entity", str2);
            }
            if (this.zzi != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (AdBreakInfo adBreakInfo : this.zzi) {
                    jSONArray2.put(adBreakInfo.zza());
                }
                jSONObject.put("breaks", jSONArray2);
            }
            if (this.zzj != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (AdBreakClipInfo adBreakClipInfo : this.zzj) {
                    jSONArray3.put(adBreakClipInfo.zza());
                }
                jSONObject.put("breakClips", jSONArray3);
            }
            VastAdsRequest vastAdsRequest = this.zzl;
            if (vastAdsRequest != null) {
                jSONObject.put("vmapAdsRequest", vastAdsRequest.zza());
            }
            long j2 = this.zzm;
            if (j2 != -1) {
                jSONObject.put("startAbsoluteTime", CastUtils.millisecToSec(j2));
            }
            jSONObject.putOpt("atvEntity", this.zzn);
            String str3 = this.zzp;
            if (str3 != null) {
                jSONObject.put("hlsSegmentFormat", str3);
            }
            String str4 = this.zzq;
            if (str4 != null) {
                jSONObject.put("hlsVideoSegmentFormat", str4);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaInfo(String str, int i, String str2, MediaMetadata mediaMetadata, long j, List<MediaTrack> list, TextTrackStyle textTrackStyle, String str3, List<AdBreakInfo> list2, List<AdBreakClipInfo> list3, String str4, VastAdsRequest vastAdsRequest, long j2, String str5, String str6, String str7, String str8) {
        this.zzs = new Writer();
        this.zzb = str;
        this.zzc = i;
        this.zzd = str2;
        this.zze = mediaMetadata;
        this.zzf = j;
        this.zzg = list;
        this.zzh = textTrackStyle;
        this.zza = str3;
        if (str3 != null) {
            try {
                this.zzr = new JSONObject(str3);
            } catch (JSONException unused) {
                this.zzr = null;
                this.zza = null;
            }
        } else {
            this.zzr = null;
        }
        this.zzi = list2;
        this.zzj = list3;
        this.zzk = str4;
        this.zzl = vastAdsRequest;
        this.zzm = j2;
        this.zzn = str5;
        this.zzo = str6;
        this.zzp = str7;
        this.zzq = str8;
    }

    MediaInfo(String str, String str2) throws IllegalArgumentException {
        this(str, -1, null, null, -1L, null, null, null, null, null, str2, null, -1L, null, null, null, null);
        if (str == null) {
            throw new IllegalArgumentException("contentID cannot be null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaInfo(JSONObject jSONObject) throws JSONException {
        this(jSONObject.optString("contentId"), -1, null, null, -1L, null, null, null, null, null, null, null, -1L, null, null, null, null);
        MediaInfo mediaInfo;
        int i;
        int i2;
        com.google.android.gms.internal.cast.zzdk zzdkVar;
        String optString = jSONObject.optString("streamType", "NONE");
        if ("NONE".equals(optString)) {
            mediaInfo = this;
            mediaInfo.zzc = 0;
        } else {
            mediaInfo = this;
            if ("BUFFERED".equals(optString)) {
                mediaInfo.zzc = 1;
            } else if ("LIVE".equals(optString)) {
                mediaInfo.zzc = 2;
            } else {
                mediaInfo.zzc = -1;
            }
        }
        mediaInfo.zzd = CastUtils.optStringOrNull(jSONObject, "contentType");
        if (jSONObject.has(TtmlNode.TAG_METADATA)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(TtmlNode.TAG_METADATA);
            MediaMetadata mediaMetadata = new MediaMetadata(jSONObject2.getInt("metadataType"));
            mediaInfo.zze = mediaMetadata;
            mediaMetadata.zzb(jSONObject2);
        }
        mediaInfo.zzf = -1L;
        if (jSONObject.has(TypedValues.TransitionType.S_DURATION) && !jSONObject.isNull(TypedValues.TransitionType.S_DURATION)) {
            double optDouble = jSONObject.optDouble(TypedValues.TransitionType.S_DURATION, 0.0d);
            if (!Double.isNaN(optDouble) && !Double.isInfinite(optDouble)) {
                mediaInfo.zzf = CastUtils.secToMillisec(optDouble);
            }
        }
        if (jSONObject.has("tracks")) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("tracks");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                String str = MediaTrack.ROLE_ALTERNATE;
                long j = jSONObject3.getLong("trackId");
                String optString2 = jSONObject3.optString("type");
                if ("TEXT".equals(optString2)) {
                    i = 1;
                } else if ("AUDIO".equals(optString2)) {
                    i = 2;
                } else {
                    i = ShareConstants.VIDEO_URL.equals(optString2) ? 3 : 0;
                }
                String optStringOrNull = CastUtils.optStringOrNull(jSONObject3, "trackContentId");
                String optStringOrNull2 = CastUtils.optStringOrNull(jSONObject3, "trackContentType");
                String optStringOrNull3 = CastUtils.optStringOrNull(jSONObject3, "name");
                String optStringOrNull4 = CastUtils.optStringOrNull(jSONObject3, "language");
                if (jSONObject3.has("subtype")) {
                    String string = jSONObject3.getString("subtype");
                    if ("SUBTITLES".equals(string)) {
                        i2 = 1;
                    } else if ("CAPTIONS".equals(string)) {
                        i2 = 2;
                    } else if ("DESCRIPTIONS".equals(string)) {
                        i2 = 3;
                    } else if ("CHAPTERS".equals(string)) {
                        i2 = 4;
                    } else {
                        i2 = "METADATA".equals(string) ? 5 : -1;
                    }
                } else {
                    i2 = 0;
                }
                if (jSONObject3.has("roles")) {
                    com.google.android.gms.internal.cast.zzdh zzm = com.google.android.gms.internal.cast.zzdk.zzm();
                    JSONArray jSONArray2 = jSONObject3.getJSONArray("roles");
                    for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                        zzm.zzb((com.google.android.gms.internal.cast.zzdh) jSONArray2.optString(i4));
                    }
                    zzdkVar = zzm.zzc();
                } else {
                    zzdkVar = null;
                }
                arrayList.add(new MediaTrack(j, i, optStringOrNull, optStringOrNull2, optStringOrNull3, optStringOrNull4, i2, zzdkVar, jSONObject3.optJSONObject("customData")));
            }
            mediaInfo.zzg = new ArrayList(arrayList);
        } else {
            mediaInfo.zzg = null;
        }
        if (jSONObject.has("textTrackStyle")) {
            JSONObject jSONObject4 = jSONObject.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle = new TextTrackStyle();
            textTrackStyle.fromJson(jSONObject4);
            mediaInfo.zzh = textTrackStyle;
        } else {
            mediaInfo.zzh = null;
        }
        zza(jSONObject);
        mediaInfo.zzr = jSONObject.optJSONObject("customData");
        mediaInfo.zzk = CastUtils.optStringOrNull(jSONObject, "entity");
        mediaInfo.zzn = CastUtils.optStringOrNull(jSONObject, "atvEntity");
        mediaInfo.zzl = VastAdsRequest.fromJson(jSONObject.optJSONObject("vmapAdsRequest"));
        if (jSONObject.has("startAbsoluteTime") && !jSONObject.isNull("startAbsoluteTime")) {
            double optDouble2 = jSONObject.optDouble("startAbsoluteTime");
            if (!Double.isNaN(optDouble2) && !Double.isInfinite(optDouble2) && optDouble2 >= 0.0d) {
                mediaInfo.zzm = CastUtils.secToMillisec(optDouble2);
            }
        }
        if (jSONObject.has("contentUrl")) {
            mediaInfo.zzo = jSONObject.optString("contentUrl");
        }
        mediaInfo.zzp = CastUtils.optStringOrNull(jSONObject, "hlsSegmentFormat");
        mediaInfo.zzq = CastUtils.optStringOrNull(jSONObject, "hlsVideoSegmentFormat");
    }
}
