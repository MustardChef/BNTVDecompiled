package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public class MediaMetadata extends AbstractSafeParcelable {
    public static final String KEY_ALBUM_ARTIST = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
    public static final String KEY_ALBUM_TITLE = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
    public static final String KEY_ARTIST = "com.google.android.gms.cast.metadata.ARTIST";
    public static final String KEY_BOOK_TITLE = "com.google.android.gms.cast.metadata.BOOK_TITLE";
    public static final String KEY_BROADCAST_DATE = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
    public static final String KEY_CHAPTER_NUMBER = "com.google.android.gms.cast.metadata.CHAPTER_NUMBER";
    public static final String KEY_CHAPTER_TITLE = "com.google.android.gms.cast.metadata.CHAPTER_TITLE";
    public static final String KEY_COMPOSER = "com.google.android.gms.cast.metadata.COMPOSER";
    public static final String KEY_CREATION_DATE = "com.google.android.gms.cast.metadata.CREATION_DATE";
    public static final String KEY_DISC_NUMBER = "com.google.android.gms.cast.metadata.DISC_NUMBER";
    public static final String KEY_EPISODE_NUMBER = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
    public static final String KEY_HEIGHT = "com.google.android.gms.cast.metadata.HEIGHT";
    public static final String KEY_LOCATION_LATITUDE = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
    public static final String KEY_LOCATION_LONGITUDE = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";
    public static final String KEY_LOCATION_NAME = "com.google.android.gms.cast.metadata.LOCATION_NAME";
    public static final String KEY_QUEUE_ITEM_ID = "com.google.android.gms.cast.metadata.QUEUE_ITEM_ID";
    public static final String KEY_RELEASE_DATE = "com.google.android.gms.cast.metadata.RELEASE_DATE";
    public static final String KEY_SEASON_NUMBER = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
    public static final String KEY_SECTION_DURATION = "com.google.android.gms.cast.metadata.SECTION_DURATION";
    public static final String KEY_SECTION_START_ABSOLUTE_TIME = "com.google.android.gms.cast.metadata.SECTION_START_ABSOLUTE_TIME";
    public static final String KEY_SECTION_START_TIME_IN_CONTAINER = "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_CONTAINER";
    public static final String KEY_SECTION_START_TIME_IN_MEDIA = "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA";
    public static final String KEY_SERIES_TITLE = "com.google.android.gms.cast.metadata.SERIES_TITLE";
    public static final String KEY_STUDIO = "com.google.android.gms.cast.metadata.STUDIO";
    public static final String KEY_SUBTITLE = "com.google.android.gms.cast.metadata.SUBTITLE";
    public static final String KEY_TITLE = "com.google.android.gms.cast.metadata.TITLE";
    public static final String KEY_TRACK_NUMBER = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
    public static final String KEY_WIDTH = "com.google.android.gms.cast.metadata.WIDTH";
    public static final int MEDIA_TYPE_AUDIOBOOK_CHAPTER = 5;
    public static final int MEDIA_TYPE_GENERIC = 0;
    public static final int MEDIA_TYPE_MOVIE = 1;
    public static final int MEDIA_TYPE_MUSIC_TRACK = 3;
    public static final int MEDIA_TYPE_PHOTO = 4;
    public static final int MEDIA_TYPE_TV_SHOW = 2;
    public static final int MEDIA_TYPE_USER = 100;
    private static final zzbu zzc;
    final Bundle zza;
    private final List<WebImage> zzd;
    private int zze;
    private final Writer zzf;
    private static final String[] zzb = {"none", "String", "int", "double", "ISO-8601 date String", "Time in milliseconds as long"};
    public static final Parcelable.Creator<MediaMetadata> CREATOR = new zzbv();

    /* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
    /* loaded from: classes2.dex */
    public class Writer {
        public Writer() {
        }

        public Object getRawValue(String str) {
            return MediaMetadata.this.zza.get(str);
        }

        public void remove(String str) {
            MediaMetadata.this.zza.remove(str);
        }

        public void setMediaType(int i) {
            MediaMetadata.this.zze = i;
        }
    }

    static {
        zzbu zzbuVar = new zzbu();
        zzbuVar.zza(KEY_CREATION_DATE, "creationDateTime", 4);
        zzbuVar.zza(KEY_RELEASE_DATE, "releaseDate", 4);
        zzbuVar.zza(KEY_BROADCAST_DATE, "originalAirdate", 4);
        zzbuVar.zza(KEY_TITLE, "title", 1);
        zzbuVar.zza(KEY_SUBTITLE, "subtitle", 1);
        zzbuVar.zza(KEY_ARTIST, "artist", 1);
        zzbuVar.zza(KEY_ALBUM_ARTIST, "albumArtist", 1);
        zzbuVar.zza(KEY_ALBUM_TITLE, "albumName", 1);
        zzbuVar.zza(KEY_COMPOSER, "composer", 1);
        zzbuVar.zza(KEY_DISC_NUMBER, "discNumber", 2);
        zzbuVar.zza(KEY_TRACK_NUMBER, "trackNumber", 2);
        zzbuVar.zza(KEY_SEASON_NUMBER, "season", 2);
        zzbuVar.zza(KEY_EPISODE_NUMBER, "episode", 2);
        zzbuVar.zza(KEY_SERIES_TITLE, "seriesTitle", 1);
        zzbuVar.zza(KEY_STUDIO, "studio", 1);
        zzbuVar.zza(KEY_WIDTH, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, 2);
        zzbuVar.zza(KEY_HEIGHT, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 2);
        zzbuVar.zza(KEY_LOCATION_NAME, FirebaseAnalytics.Param.LOCATION, 1);
        zzbuVar.zza(KEY_LOCATION_LATITUDE, "latitude", 3);
        zzbuVar.zza(KEY_LOCATION_LONGITUDE, "longitude", 3);
        zzbuVar.zza(KEY_SECTION_DURATION, "sectionDuration", 5);
        zzbuVar.zza(KEY_SECTION_START_TIME_IN_MEDIA, "sectionStartTimeInMedia", 5);
        zzbuVar.zza(KEY_SECTION_START_ABSOLUTE_TIME, "sectionStartAbsoluteTime", 5);
        zzbuVar.zza(KEY_SECTION_START_TIME_IN_CONTAINER, "sectionStartTimeInContainer", 5);
        zzbuVar.zza(KEY_QUEUE_ITEM_ID, "queueItemId", 2);
        zzbuVar.zza(KEY_BOOK_TITLE, "bookTitle", 1);
        zzbuVar.zza(KEY_CHAPTER_NUMBER, "chapterNumber", 2);
        zzbuVar.zza(KEY_CHAPTER_TITLE, "chapterTitle", 1);
        zzc = zzbuVar;
    }

    public MediaMetadata() {
        this(0);
    }

    public static int getTypeForKey(String str) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        }
        return zzc.zzd(str);
    }

    public static void throwIfWrongType(String str, int i) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        }
        int zzd = zzc.zzd(str);
        if (zzd == i || zzd == 0) {
            return;
        }
        String str2 = zzb[i];
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length());
        sb.append("Value for ");
        sb.append(str);
        sb.append(" must be a ");
        sb.append(str2);
        throw new IllegalArgumentException(sb.toString());
    }

    private final boolean zzd(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !zzd((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null) {
                if (obj2 != null || !bundle2.containsKey(str)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    public void addImage(WebImage webImage) {
        this.zzd.add(webImage);
    }

    public void clear() {
        this.zza.clear();
        this.zzd.clear();
    }

    public void clearImages() {
        this.zzd.clear();
    }

    public boolean containsKey(String str) {
        return this.zza.containsKey(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MediaMetadata) {
            MediaMetadata mediaMetadata = (MediaMetadata) obj;
            return zzd(this.zza, mediaMetadata.zza) && this.zzd.equals(mediaMetadata.zzd);
        }
        return false;
    }

    public Calendar getDate(String str) {
        throwIfWrongType(str, 4);
        String string = this.zza.getString(str);
        if (string != null) {
            return com.google.android.gms.cast.internal.media.zza.zzd(string);
        }
        return null;
    }

    public String getDateAsString(String str) {
        throwIfWrongType(str, 4);
        return this.zza.getString(str);
    }

    public double getDouble(String str) {
        throwIfWrongType(str, 3);
        return this.zza.getDouble(str);
    }

    public List<WebImage> getImages() {
        return this.zzd;
    }

    public int getInt(String str) {
        throwIfWrongType(str, 2);
        return this.zza.getInt(str);
    }

    public int getMediaType() {
        return this.zze;
    }

    public String getString(String str) {
        throwIfWrongType(str, 1);
        return this.zza.getString(str);
    }

    public long getTimeMillis(String str) {
        throwIfWrongType(str, 5);
        return this.zza.getLong(str);
    }

    public Writer getWriter() {
        return this.zzf;
    }

    public boolean hasImages() {
        List<WebImage> list = this.zzd;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public int hashCode() {
        Bundle bundle = this.zza;
        int i = 17;
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object obj = this.zza.get(str);
                i = (i * 31) + (obj != null ? obj.hashCode() : 0);
            }
        }
        return (i * 31) + this.zzd.hashCode();
    }

    public Set<String> keySet() {
        return this.zza.keySet();
    }

    public void putDate(String str, Calendar calendar) {
        throwIfWrongType(str, 4);
        this.zza.putString(str, com.google.android.gms.cast.internal.media.zza.zzc(calendar));
    }

    public void putDouble(String str, double d) {
        throwIfWrongType(str, 3);
        this.zza.putDouble(str, d);
    }

    public void putInt(String str, int i) {
        throwIfWrongType(str, 2);
        this.zza.putInt(str, i);
    }

    public void putString(String str, String str2) {
        throwIfWrongType(str, 1);
        this.zza.putString(str, str2);
    }

    public void putTimeMillis(String str, long j) {
        throwIfWrongType(str, 5);
        this.zza.putLong(str, j);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, getImages(), false);
        SafeParcelWriter.writeBundle(parcel, 3, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 4, getMediaType());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final JSONObject zza() {
        zzbu zzbuVar;
        String zzb2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metadataType", this.zze);
        } catch (JSONException unused) {
        }
        JSONArray zzb3 = com.google.android.gms.cast.internal.media.zza.zzb(this.zzd);
        if (zzb3.length() != 0) {
            try {
                jSONObject.put("images", zzb3);
            } catch (JSONException unused2) {
            }
        }
        ArrayList<String> arrayList = new ArrayList();
        int i = this.zze;
        if (i == 0) {
            Collections.addAll(arrayList, KEY_TITLE, KEY_ARTIST, KEY_SUBTITLE, KEY_RELEASE_DATE);
        } else if (i == 1) {
            Collections.addAll(arrayList, KEY_TITLE, KEY_STUDIO, KEY_SUBTITLE, KEY_RELEASE_DATE);
        } else if (i == 2) {
            Collections.addAll(arrayList, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
        } else if (i == 3) {
            Collections.addAll(arrayList, KEY_TITLE, KEY_ARTIST, KEY_ALBUM_TITLE, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
        } else if (i == 4) {
            Collections.addAll(arrayList, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
        } else if (i == 5) {
            Collections.addAll(arrayList, KEY_CHAPTER_TITLE, KEY_CHAPTER_NUMBER, KEY_TITLE, KEY_BOOK_TITLE, KEY_SUBTITLE);
        }
        Collections.addAll(arrayList, KEY_SECTION_DURATION, KEY_SECTION_START_TIME_IN_MEDIA, KEY_SECTION_START_ABSOLUTE_TIME, KEY_SECTION_START_TIME_IN_CONTAINER, KEY_QUEUE_ITEM_ID);
        try {
            for (String str : arrayList) {
                if (str != null && this.zza.containsKey(str) && (zzb2 = (zzbuVar = zzc).zzb(str)) != null) {
                    int zzd = zzbuVar.zzd(str);
                    if (zzd != 1) {
                        if (zzd == 2) {
                            jSONObject.put(zzb2, this.zza.getInt(str));
                        } else if (zzd == 3) {
                            jSONObject.put(zzb2, this.zza.getDouble(str));
                        } else if (zzd != 4) {
                            if (zzd == 5) {
                                jSONObject.put(zzb2, CastUtils.millisecToSec(this.zza.getLong(str)));
                            }
                        }
                    }
                    jSONObject.put(zzb2, this.zza.getString(str));
                }
            }
            for (String str2 : this.zza.keySet()) {
                if (!str2.startsWith("com.google.")) {
                    Object obj = this.zza.get(str2);
                    if (obj instanceof String) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Integer) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Double) {
                        jSONObject.put(str2, obj);
                    }
                }
            }
        } catch (JSONException unused3) {
        }
        return jSONObject;
    }

    public final void zzb(JSONObject jSONObject) {
        clear();
        this.zze = 0;
        try {
            this.zze = jSONObject.getInt("metadataType");
        } catch (JSONException unused) {
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("images");
        if (optJSONArray != null) {
            com.google.android.gms.cast.internal.media.zza.zza(this.zzd, optJSONArray);
        }
        ArrayList arrayList = new ArrayList();
        int i = this.zze;
        if (i == 0) {
            Collections.addAll(arrayList, KEY_TITLE, KEY_ARTIST, KEY_SUBTITLE, KEY_RELEASE_DATE);
        } else if (i == 1) {
            Collections.addAll(arrayList, KEY_TITLE, KEY_STUDIO, KEY_SUBTITLE, KEY_RELEASE_DATE);
        } else if (i == 2) {
            Collections.addAll(arrayList, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
        } else if (i == 3) {
            Collections.addAll(arrayList, KEY_TITLE, KEY_ALBUM_TITLE, KEY_ARTIST, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
        } else if (i == 4) {
            Collections.addAll(arrayList, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
        } else if (i == 5) {
            Collections.addAll(arrayList, KEY_CHAPTER_TITLE, KEY_CHAPTER_NUMBER, KEY_TITLE, KEY_BOOK_TITLE, KEY_SUBTITLE);
        }
        Collections.addAll(arrayList, KEY_SECTION_DURATION, KEY_SECTION_START_TIME_IN_MEDIA, KEY_SECTION_START_ABSOLUTE_TIME, KEY_SECTION_START_TIME_IN_CONTAINER, KEY_QUEUE_ITEM_ID);
        HashSet hashSet = new HashSet(arrayList);
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && !"metadataType".equals(next)) {
                    zzbu zzbuVar = zzc;
                    String zzc2 = zzbuVar.zzc(next);
                    if (zzc2 != null) {
                        if (hashSet.contains(zzc2)) {
                            try {
                                Object obj = jSONObject.get(next);
                                if (obj != null) {
                                    int zzd = zzbuVar.zzd(zzc2);
                                    if (zzd != 1) {
                                        if (zzd != 2) {
                                            if (zzd == 3) {
                                                double optDouble = jSONObject.optDouble(next);
                                                if (!Double.isNaN(optDouble)) {
                                                    this.zza.putDouble(zzc2, optDouble);
                                                }
                                            } else if (zzd != 4) {
                                                if (zzd == 5) {
                                                    this.zza.putLong(zzc2, CastUtils.secToMillisec(jSONObject.optLong(next)));
                                                }
                                            } else if (obj instanceof String) {
                                                String str = (String) obj;
                                                if (com.google.android.gms.cast.internal.media.zza.zzd(str) != null) {
                                                    this.zza.putString(zzc2, str);
                                                }
                                            }
                                        } else if (obj instanceof Integer) {
                                            this.zza.putInt(zzc2, ((Integer) obj).intValue());
                                        }
                                    } else if (obj instanceof String) {
                                        this.zza.putString(zzc2, (String) obj);
                                    }
                                }
                            } catch (JSONException unused2) {
                            }
                        }
                    } else {
                        Object obj2 = jSONObject.get(next);
                        if (obj2 instanceof String) {
                            this.zza.putString(next, (String) obj2);
                        } else if (obj2 instanceof Integer) {
                            this.zza.putInt(next, ((Integer) obj2).intValue());
                        } else if (obj2 instanceof Double) {
                            this.zza.putDouble(next, ((Double) obj2).doubleValue());
                        }
                    }
                }
            }
        } catch (JSONException unused3) {
        }
    }

    public MediaMetadata(int i) {
        this(new ArrayList(), new Bundle(), i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaMetadata(List<WebImage> list, Bundle bundle, int i) {
        this.zzf = new Writer();
        this.zzd = list;
        this.zza = bundle;
        this.zze = i;
    }
}
