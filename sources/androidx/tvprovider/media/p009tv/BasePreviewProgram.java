package androidx.tvprovider.media.p009tv;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import androidx.tvprovider.media.p009tv.BaseProgram;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* renamed from: androidx.tvprovider.media.tv.BasePreviewProgram */
/* loaded from: classes.dex */
public abstract class BasePreviewProgram extends BaseProgram {
    private static final int ASPECT_RATIO_UNKNOWN = -1;
    private static final int AVAILABILITY_UNKNOWN = -1;
    private static final int INTERACTION_TYPE_UNKNOWN = -1;
    private static final int INVALID_INT_VALUE = -1;
    private static final long INVALID_LONG_VALUE = -1;
    private static final int IS_BROWSABLE = 1;
    private static final int IS_LIVE = 1;
    private static final int IS_TRANSIENT = 1;
    public static final String[] PROJECTION = getProjection();
    private static final int TYPE_UNKNOWN = -1;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: androidx.tvprovider.media.tv.BasePreviewProgram$AspectRatio */
    /* loaded from: classes.dex */
    public @interface AspectRatio {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: androidx.tvprovider.media.tv.BasePreviewProgram$Availability */
    /* loaded from: classes.dex */
    public @interface Availability {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: androidx.tvprovider.media.tv.BasePreviewProgram$InteractionType */
    /* loaded from: classes.dex */
    public @interface InteractionType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: androidx.tvprovider.media.tv.BasePreviewProgram$TvSeriesItemType */
    /* loaded from: classes.dex */
    public @interface TvSeriesItemType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: androidx.tvprovider.media.tv.BasePreviewProgram$Type */
    /* loaded from: classes.dex */
    public @interface Type {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BasePreviewProgram(Builder builder) {
        super(builder);
    }

    public String getInternalProviderId() {
        return this.mValues.getAsString("internal_provider_id");
    }

    public Uri getPreviewVideoUri() {
        String asString = this.mValues.getAsString("preview_video_uri");
        if (asString == null) {
            return null;
        }
        return Uri.parse(asString);
    }

    public int getLastPlaybackPositionMillis() {
        Integer asInteger = this.mValues.getAsInteger("last_playback_position_millis");
        if (asInteger == null) {
            return -1;
        }
        return asInteger.intValue();
    }

    public int getDurationMillis() {
        Integer asInteger = this.mValues.getAsInteger("duration_millis");
        if (asInteger == null) {
            return -1;
        }
        return asInteger.intValue();
    }

    public Uri getIntentUri() {
        String asString = this.mValues.getAsString("intent_uri");
        if (asString == null) {
            return null;
        }
        return Uri.parse(asString);
    }

    public Intent getIntent() throws URISyntaxException {
        String asString = this.mValues.getAsString("intent_uri");
        if (asString == null) {
            return null;
        }
        return Intent.parseUri(asString, 1);
    }

    public boolean isTransient() {
        Integer asInteger = this.mValues.getAsInteger("transient");
        return asInteger != null && asInteger.intValue() == 1;
    }

    public int getType() {
        Integer asInteger = this.mValues.getAsInteger("type");
        if (asInteger == null) {
            return -1;
        }
        return asInteger.intValue();
    }

    public int getTvSeriesItemType() {
        return this.mValues.getAsInteger("tv_series_item_type").intValue();
    }

    public int getPosterArtAspectRatio() {
        Integer asInteger = this.mValues.getAsInteger("poster_art_aspect_ratio");
        if (asInteger == null) {
            return -1;
        }
        return asInteger.intValue();
    }

    public int getThumbnailAspectRatio() {
        Integer asInteger = this.mValues.getAsInteger("poster_thumbnail_aspect_ratio");
        if (asInteger == null) {
            return -1;
        }
        return asInteger.intValue();
    }

    public Uri getLogoUri() {
        String asString = this.mValues.getAsString("logo_uri");
        if (asString == null) {
            return null;
        }
        return Uri.parse(asString);
    }

    public int getAvailability() {
        Integer asInteger = this.mValues.getAsInteger("availability");
        if (asInteger == null) {
            return -1;
        }
        return asInteger.intValue();
    }

    public String getStartingPrice() {
        return this.mValues.getAsString("starting_price");
    }

    public String getOfferPrice() {
        return this.mValues.getAsString("offer_price");
    }

    public String getReleaseDate() {
        return this.mValues.getAsString("release_date");
    }

    public int getItemCount() {
        Integer asInteger = this.mValues.getAsInteger("item_count");
        if (asInteger == null) {
            return -1;
        }
        return asInteger.intValue();
    }

    public boolean isLive() {
        Integer asInteger = this.mValues.getAsInteger("live");
        return asInteger != null && asInteger.intValue() == 1;
    }

    public int getInteractionType() {
        Integer asInteger = this.mValues.getAsInteger("interaction_type");
        if (asInteger == null) {
            return -1;
        }
        return asInteger.intValue();
    }

    public long getInteractionCount() {
        Long asLong = this.mValues.getAsLong("interaction_count");
        if (asLong == null) {
            return -1L;
        }
        return asLong.longValue();
    }

    public String getAuthor() {
        return this.mValues.getAsString("author");
    }

    public boolean isBrowsable() {
        Integer asInteger = this.mValues.getAsInteger("browsable");
        return asInteger != null && asInteger.intValue() == 1;
    }

    public String getContentId() {
        return this.mValues.getAsString("content_id");
    }

    public String getLogoContentDescription() {
        return this.mValues.getAsString("logo_content_description");
    }

    public String getGenre() {
        return this.mValues.getAsString("genre");
    }

    public long getStartTimeUtcMillis() {
        Long asLong = this.mValues.getAsLong("start_time_utc_millis");
        if (asLong == null) {
            return -1L;
        }
        return asLong.longValue();
    }

    public long getEndTimeUtcMillis() {
        Long asLong = this.mValues.getAsLong("end_time_utc_millis");
        if (asLong == null) {
            return -1L;
        }
        return asLong.longValue();
    }

    public Uri getPreviewAudioUri() {
        String asString = this.mValues.getAsString("preview_audio_uri");
        if (asString == null) {
            return null;
        }
        return Uri.parse(asString);
    }

    @Override // androidx.tvprovider.media.p009tv.BaseProgram
    public boolean equals(Object obj) {
        if (obj instanceof BasePreviewProgram) {
            return this.mValues.equals(((BasePreviewProgram) obj).mValues);
        }
        return false;
    }

    @Override // androidx.tvprovider.media.p009tv.BaseProgram
    public ContentValues toContentValues() {
        return toContentValues(false);
    }

    public ContentValues toContentValues(boolean z) {
        ContentValues contentValues = super.toContentValues();
        if (Build.VERSION.SDK_INT < 26) {
            contentValues.remove("internal_provider_id");
            contentValues.remove("preview_video_uri");
            contentValues.remove("last_playback_position_millis");
            contentValues.remove("duration_millis");
            contentValues.remove("intent_uri");
            contentValues.remove("transient");
            contentValues.remove("type");
            contentValues.remove("poster_art_aspect_ratio");
            contentValues.remove("poster_thumbnail_aspect_ratio");
            contentValues.remove("logo_uri");
            contentValues.remove("availability");
            contentValues.remove("starting_price");
            contentValues.remove("offer_price");
            contentValues.remove("release_date");
            contentValues.remove("item_count");
            contentValues.remove("live");
            contentValues.remove("interaction_count");
            contentValues.remove("author");
            contentValues.remove("content_id");
            contentValues.remove("logo_content_description");
            contentValues.remove("genre");
            contentValues.remove("start_time_utc_millis");
            contentValues.remove("end_time_utc_millis");
            contentValues.remove("preview_audio_uri");
            contentValues.remove("tv_series_item_type");
        }
        if (Build.VERSION.SDK_INT < 26 || !z) {
            contentValues.remove("browsable");
        }
        return contentValues;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setFieldsFromCursor(Cursor cursor, Builder builder) {
        BaseProgram.setFieldsFromCursor(cursor, builder);
        if (Build.VERSION.SDK_INT >= 26) {
            int columnIndex = cursor.getColumnIndex("internal_provider_id");
            if (columnIndex >= 0 && !cursor.isNull(columnIndex)) {
                builder.setInternalProviderId(cursor.getString(columnIndex));
            }
            int columnIndex2 = cursor.getColumnIndex("preview_video_uri");
            if (columnIndex2 >= 0 && !cursor.isNull(columnIndex2)) {
                builder.setPreviewVideoUri(Uri.parse(cursor.getString(columnIndex2)));
            }
            int columnIndex3 = cursor.getColumnIndex("last_playback_position_millis");
            if (columnIndex3 >= 0 && !cursor.isNull(columnIndex3)) {
                builder.setLastPlaybackPositionMillis(cursor.getInt(columnIndex3));
            }
            int columnIndex4 = cursor.getColumnIndex("duration_millis");
            if (columnIndex4 >= 0 && !cursor.isNull(columnIndex4)) {
                builder.setDurationMillis(cursor.getInt(columnIndex4));
            }
            int columnIndex5 = cursor.getColumnIndex("intent_uri");
            if (columnIndex5 >= 0 && !cursor.isNull(columnIndex5)) {
                builder.setIntentUri(Uri.parse(cursor.getString(columnIndex5)));
            }
            int columnIndex6 = cursor.getColumnIndex("transient");
            if (columnIndex6 >= 0 && !cursor.isNull(columnIndex6)) {
                builder.setTransient(cursor.getInt(columnIndex6) == 1);
            }
            int columnIndex7 = cursor.getColumnIndex("type");
            if (columnIndex7 >= 0 && !cursor.isNull(columnIndex7)) {
                builder.setType(cursor.getInt(columnIndex7));
            }
            int columnIndex8 = cursor.getColumnIndex("poster_art_aspect_ratio");
            if (columnIndex8 >= 0 && !cursor.isNull(columnIndex8)) {
                builder.setPosterArtAspectRatio(cursor.getInt(columnIndex8));
            }
            int columnIndex9 = cursor.getColumnIndex("poster_thumbnail_aspect_ratio");
            if (columnIndex9 >= 0 && !cursor.isNull(columnIndex9)) {
                builder.setThumbnailAspectRatio(cursor.getInt(columnIndex9));
            }
            int columnIndex10 = cursor.getColumnIndex("logo_uri");
            if (columnIndex10 >= 0 && !cursor.isNull(columnIndex10)) {
                builder.setLogoUri(Uri.parse(cursor.getString(columnIndex10)));
            }
            int columnIndex11 = cursor.getColumnIndex("availability");
            if (columnIndex11 >= 0 && !cursor.isNull(columnIndex11)) {
                builder.setAvailability(cursor.getInt(columnIndex11));
            }
            int columnIndex12 = cursor.getColumnIndex("starting_price");
            if (columnIndex12 >= 0 && !cursor.isNull(columnIndex12)) {
                builder.setStartingPrice(cursor.getString(columnIndex12));
            }
            int columnIndex13 = cursor.getColumnIndex("offer_price");
            if (columnIndex13 >= 0 && !cursor.isNull(columnIndex13)) {
                builder.setOfferPrice(cursor.getString(columnIndex13));
            }
            int columnIndex14 = cursor.getColumnIndex("release_date");
            if (columnIndex14 >= 0 && !cursor.isNull(columnIndex14)) {
                builder.setReleaseDate(cursor.getString(columnIndex14));
            }
            int columnIndex15 = cursor.getColumnIndex("item_count");
            if (columnIndex15 >= 0 && !cursor.isNull(columnIndex15)) {
                builder.setItemCount(cursor.getInt(columnIndex15));
            }
            int columnIndex16 = cursor.getColumnIndex("live");
            if (columnIndex16 >= 0 && !cursor.isNull(columnIndex16)) {
                builder.setLive(cursor.getInt(columnIndex16) == 1);
            }
            int columnIndex17 = cursor.getColumnIndex("interaction_type");
            if (columnIndex17 >= 0 && !cursor.isNull(columnIndex17)) {
                builder.setInteractionType(cursor.getInt(columnIndex17));
            }
            int columnIndex18 = cursor.getColumnIndex("interaction_count");
            if (columnIndex18 >= 0 && !cursor.isNull(columnIndex18)) {
                builder.setInteractionCount(cursor.getInt(columnIndex18));
            }
            int columnIndex19 = cursor.getColumnIndex("author");
            if (columnIndex19 >= 0 && !cursor.isNull(columnIndex19)) {
                builder.setAuthor(cursor.getString(columnIndex19));
            }
            int columnIndex20 = cursor.getColumnIndex("browsable");
            if (columnIndex20 >= 0 && !cursor.isNull(columnIndex20)) {
                builder.setBrowsable(cursor.getInt(columnIndex20) == 1);
            }
            int columnIndex21 = cursor.getColumnIndex("content_id");
            if (columnIndex21 >= 0 && !cursor.isNull(columnIndex21)) {
                builder.setContentId(cursor.getString(columnIndex21));
            }
            int columnIndex22 = cursor.getColumnIndex("logo_content_description");
            if (columnIndex22 >= 0 && !cursor.isNull(columnIndex22)) {
                builder.setLogoContentDescription(cursor.getString(columnIndex22));
            }
            int columnIndex23 = cursor.getColumnIndex("genre");
            if (columnIndex23 >= 0 && !cursor.isNull(columnIndex23)) {
                builder.setGenre(cursor.getString(columnIndex23));
            }
            int columnIndex24 = cursor.getColumnIndex("start_time_utc_millis");
            if (columnIndex24 >= 0 && !cursor.isNull(columnIndex24)) {
                builder.setStartTimeUtcMillis(cursor.getLong(columnIndex24));
            }
            int columnIndex25 = cursor.getColumnIndex("end_time_utc_millis");
            if (columnIndex25 >= 0 && !cursor.isNull(columnIndex25)) {
                builder.setEndTimeUtcMillis(cursor.getLong(columnIndex25));
            }
            int columnIndex26 = cursor.getColumnIndex("preview_audio_uri");
            if (columnIndex26 >= 0 && !cursor.isNull(columnIndex26)) {
                builder.setPreviewAudioUri(Uri.parse(cursor.getString(columnIndex26)));
            }
            int columnIndex27 = cursor.getColumnIndex("tv_series_item_type");
            if (columnIndex27 < 0 || cursor.isNull(columnIndex27)) {
                return;
            }
            builder.setTvSeriesItemType(cursor.getInt(columnIndex27));
        }
    }

    private static String[] getProjection() {
        return (String[]) CollectionUtils.concatAll(BaseProgram.PROJECTION, new String[]{"internal_provider_id", "preview_video_uri", "last_playback_position_millis", "duration_millis", "intent_uri", "transient", "type", "poster_art_aspect_ratio", "poster_thumbnail_aspect_ratio", "logo_uri", "availability", "starting_price", "offer_price", "release_date", "item_count", "live", "interaction_type", "interaction_count", "author", "browsable", "content_id", "logo_content_description", "genre", "start_time_utc_millis", "end_time_utc_millis", "preview_audio_uri", "tv_series_item_type"});
    }

    /* renamed from: androidx.tvprovider.media.tv.BasePreviewProgram$Builder */
    /* loaded from: classes.dex */
    public static abstract class Builder<T extends Builder> extends BaseProgram.Builder<T> {
        private static final SimpleDateFormat sFormat;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            sFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-0"));
        }

        public Builder() {
        }

        public Builder(BasePreviewProgram basePreviewProgram) {
            this.mValues = new ContentValues(basePreviewProgram.mValues);
        }

        public T setInternalProviderId(String str) {
            this.mValues.put("internal_provider_id", str);
            return this;
        }

        public T setPreviewVideoUri(Uri uri) {
            this.mValues.put("preview_video_uri", uri == null ? null : uri.toString());
            return this;
        }

        public T setLastPlaybackPositionMillis(int i) {
            this.mValues.put("last_playback_position_millis", Integer.valueOf(i));
            return this;
        }

        public T setDurationMillis(int i) {
            this.mValues.put("duration_millis", Integer.valueOf(i));
            return this;
        }

        public T setIntentUri(Uri uri) {
            this.mValues.put("intent_uri", uri == null ? null : uri.toString());
            return this;
        }

        public T setIntent(Intent intent) {
            return setIntentUri(Uri.parse(intent.toUri(1)));
        }

        public T setTransient(boolean z) {
            this.mValues.put("transient", Integer.valueOf(z ? 1 : 0));
            return this;
        }

        public T setType(int i) {
            this.mValues.put("type", Integer.valueOf(i));
            return this;
        }

        public T setPosterArtAspectRatio(int i) {
            this.mValues.put("poster_art_aspect_ratio", Integer.valueOf(i));
            return this;
        }

        public T setThumbnailAspectRatio(int i) {
            this.mValues.put("poster_thumbnail_aspect_ratio", Integer.valueOf(i));
            return this;
        }

        public T setLogoUri(Uri uri) {
            this.mValues.put("logo_uri", uri == null ? null : uri.toString());
            return this;
        }

        public T setAvailability(int i) {
            this.mValues.put("availability", Integer.valueOf(i));
            return this;
        }

        public T setStartingPrice(String str) {
            this.mValues.put("starting_price", str);
            return this;
        }

        public T setOfferPrice(String str) {
            this.mValues.put("offer_price", str);
            return this;
        }

        public T setReleaseDate(String str) {
            this.mValues.put("release_date", str);
            return this;
        }

        public T setReleaseDate(Date date) {
            this.mValues.put("release_date", sFormat.format(date));
            return this;
        }

        public T setItemCount(int i) {
            this.mValues.put("item_count", Integer.valueOf(i));
            return this;
        }

        public T setLive(boolean z) {
            this.mValues.put("live", Integer.valueOf(z ? 1 : 0));
            return this;
        }

        public T setInteractionType(int i) {
            this.mValues.put("interaction_type", Integer.valueOf(i));
            return this;
        }

        public T setInteractionCount(long j) {
            this.mValues.put("interaction_count", Long.valueOf(j));
            return this;
        }

        public T setAuthor(String str) {
            this.mValues.put("author", str);
            return this;
        }

        public T setBrowsable(boolean z) {
            this.mValues.put("browsable", Integer.valueOf(z ? 1 : 0));
            return this;
        }

        public T setContentId(String str) {
            this.mValues.put("content_id", str);
            return this;
        }

        public T setLogoContentDescription(String str) {
            this.mValues.put("logo_content_description", str);
            return this;
        }

        public T setGenre(String str) {
            this.mValues.put("genre", str);
            return this;
        }

        public T setStartTimeUtcMillis(long j) {
            this.mValues.put("start_time_utc_millis", Long.valueOf(j));
            return this;
        }

        public T setEndTimeUtcMillis(long j) {
            this.mValues.put("end_time_utc_millis", Long.valueOf(j));
            return this;
        }

        public T setPreviewAudioUri(Uri uri) {
            this.mValues.put("preview_audio_uri", uri == null ? null : uri.toString());
            return this;
        }

        public T setTvSeriesItemType(int i) {
            this.mValues.put("tv_series_item_type", Integer.valueOf(i));
            return this;
        }
    }
}
