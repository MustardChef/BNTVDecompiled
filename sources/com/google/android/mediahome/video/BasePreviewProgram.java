package com.google.android.mediahome.video;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.media.tv.TvContentRating;
import android.net.Uri;
import com.google.android.mediahome.video.VideoContract;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: com.google.android.mediahome:video@@1.0.0 */
/* loaded from: classes3.dex */
abstract class BasePreviewProgram {
    public static final String[] PROJECTION = {"_id", "package_name", "author", "availability", "canonical_genre", "content_id", "content_rating", "duration_millis", "episode_display_number", "episode_title", "genre", "intent_uri", "interaction_count", "interaction_type", "internal_provider_id", "item_count", "last_playback_position_millis", "live", "logo_uri", "logo_content_description", "offer_price", "poster_art_aspect_ratio", "poster_art_uri", "preview_audio_uri", "preview_video_uri", "release_date", "review_rating", "review_rating_style", "season_display_number", "season_title", "short_description", "start_time_utc_millis", "end_time_utc_millis", "starting_price", "poster_thumbnail_aspect_ratio", "thumbnail_uri", "title", "type", VideoContract.PreviewProgramColumns.COLUMN_SERIES_ID, "tv_series_item_type", "video_height", "video_width"};
    protected ContentValues values;

    /* compiled from: com.google.android.mediahome:video@@1.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface AspectRatio {
    }

    /* compiled from: com.google.android.mediahome:video@@1.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Availability {
    }

    /* compiled from: com.google.android.mediahome:video@@1.0.0 */
    /* loaded from: classes3.dex */
    public static abstract class Builder<T extends Builder> {
        private static final SimpleDateFormat zza;
        protected ContentValues values = new ContentValues();

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
            zza = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-0"));
        }

        public T setAuthor(String str) {
            this.values.put("author", str);
            return this;
        }

        public T setAvailability(int i) {
            this.values.put("availability", Integer.valueOf(i));
            return this;
        }

        public T setCanonicalGenres(String[] strArr) {
            this.values.put("canonical_genre", VideoContract.PreviewProgramColumns.Genres.encode(strArr));
            return this;
        }

        public T setContentId(String str) {
            this.values.put("content_id", str);
            return this;
        }

        public T setContentRatings(TvContentRating[] tvContentRatingArr) {
            this.values.put("content_rating", VideoContractUtils.contentRatingsToString(tvContentRatingArr));
            return this;
        }

        public T setDescription(String str) {
            this.values.put("short_description", str);
            return this;
        }

        public T setDurationMillis(long j) {
            this.values.put("duration_millis", Long.valueOf(j));
            return this;
        }

        public T setEndTimeUtcMillis(long j) {
            this.values.put("end_time_utc_millis", Long.valueOf(j));
            return this;
        }

        public T setEpisodeNumber(int i) {
            setEpisodeNumber(String.valueOf(i));
            return this;
        }

        public T setEpisodeTitle(String str) {
            this.values.put("episode_title", str);
            return this;
        }

        public T setGenre(String str) {
            this.values.put("genre", str);
            return this;
        }

        T setId(long j) {
            this.values.put("_id", Long.valueOf(j));
            return this;
        }

        public T setIntent(Intent intent) {
            return setIntentUri(Uri.parse(intent.toUri(1)));
        }

        public T setIntentUri(Uri uri) {
            this.values.put("intent_uri", uri == null ? null : uri.toString());
            return this;
        }

        public T setInteractionCount(long j) {
            this.values.put("interaction_count", Long.valueOf(j));
            return this;
        }

        public T setInteractionType(int i) {
            this.values.put("interaction_type", Integer.valueOf(i));
            return this;
        }

        public T setInternalProviderId(String str) {
            this.values.put("internal_provider_id", str);
            return this;
        }

        public T setItemCount(int i) {
            this.values.put("item_count", Integer.valueOf(i));
            return this;
        }

        public T setLastPlaybackPositionMillis(int i) {
            this.values.put("last_playback_position_millis", Integer.valueOf(i));
            return this;
        }

        public T setLive(boolean z) {
            this.values.put("live", Integer.valueOf(z ? 1 : 0));
            return this;
        }

        public T setLogoContentDescription(String str) {
            this.values.put("logo_content_description", str);
            return this;
        }

        public T setLogoUri(Uri uri) {
            this.values.put("logo_uri", uri == null ? null : uri.toString());
            return this;
        }

        public T setOfferPrice(String str) {
            this.values.put("offer_price", str);
            return this;
        }

        T setPackageName(String str) {
            this.values.put("package_name", str);
            return this;
        }

        public T setPosterArtAspectRatio(int i) {
            this.values.put("poster_art_aspect_ratio", Integer.valueOf(i));
            return this;
        }

        public T setPosterArtUri(Uri uri) {
            this.values.put("poster_art_uri", uri == null ? null : uri.toString());
            return this;
        }

        public T setPreviewAudioUri(Uri uri) {
            this.values.put("preview_audio_uri", uri == null ? null : uri.toString());
            return this;
        }

        public T setPreviewVideoUri(Uri uri) {
            this.values.put("preview_video_uri", uri == null ? null : uri.toString());
            return this;
        }

        public T setReleaseDate(String str) {
            this.values.put("release_date", str);
            return this;
        }

        public T setReviewRating(String str) {
            this.values.put("review_rating", str);
            return this;
        }

        public T setReviewRatingStyle(int i) {
            this.values.put("review_rating_style", Integer.valueOf(i));
            return this;
        }

        public T setSeasonNumber(int i) {
            setSeasonNumber(String.valueOf(i));
            return this;
        }

        public T setSeasonTitle(String str) {
            this.values.put("season_title", str);
            return this;
        }

        public T setSeriesId(String str) {
            this.values.put(VideoContract.PreviewProgramColumns.COLUMN_SERIES_ID, str);
            return this;
        }

        public T setStartTimeUtcMillis(long j) {
            this.values.put("start_time_utc_millis", Long.valueOf(j));
            return this;
        }

        public T setStartingPrice(String str) {
            this.values.put("starting_price", str);
            return this;
        }

        public T setThumbnailAspectRatio(int i) {
            this.values.put("poster_thumbnail_aspect_ratio", Integer.valueOf(i));
            return this;
        }

        public T setThumbnailUri(Uri uri) {
            this.values.put("thumbnail_uri", uri == null ? null : uri.toString());
            return this;
        }

        public T setTitle(String str) {
            this.values.put("title", str);
            return this;
        }

        public T setTvSeriesItemType(int i) {
            this.values.put("tv_series_item_type", Integer.valueOf(i));
            return this;
        }

        public T setType(int i) {
            this.values.put("type", Integer.valueOf(i));
            return this;
        }

        public T setVideoHeight(int i) {
            this.values.put("video_height", Integer.valueOf(i));
            return this;
        }

        public T setVideoWidth(int i) {
            this.values.put("video_width", Integer.valueOf(i));
            return this;
        }

        public T setEpisodeNumber(String str) {
            this.values.put("episode_display_number", str);
            return this;
        }

        public T setSeasonNumber(String str) {
            this.values.put("season_display_number", str);
            return this;
        }
    }

    /* compiled from: com.google.android.mediahome:video@@1.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface InteractionType {
    }

    /* compiled from: com.google.android.mediahome:video@@1.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    @interface ReviewRatingStyle {
    }

    /* compiled from: com.google.android.mediahome:video@@1.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface TvSeriesItemType {
    }

    /* compiled from: com.google.android.mediahome:video@@1.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Type {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BasePreviewProgram(Builder builder) {
        this.values = builder.values;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setFieldsFromCursor(Cursor cursor, Builder builder) {
        int columnIndex = cursor.getColumnIndex("_id");
        if (columnIndex >= 0 && !cursor.isNull(columnIndex)) {
            builder.setId(cursor.getLong(columnIndex));
        }
        int columnIndex2 = cursor.getColumnIndex("package_name");
        if (columnIndex2 >= 0 && !cursor.isNull(columnIndex2)) {
            builder.setPackageName(cursor.getString(columnIndex2));
        }
        int columnIndex3 = cursor.getColumnIndex("author");
        if (columnIndex3 >= 0 && !cursor.isNull(columnIndex3)) {
            builder.setAuthor(cursor.getString(columnIndex3));
        }
        int columnIndex4 = cursor.getColumnIndex("availability");
        if (columnIndex4 >= 0 && !cursor.isNull(columnIndex4)) {
            builder.setAvailability(cursor.getInt(columnIndex4));
        }
        int columnIndex5 = cursor.getColumnIndex("canonical_genre");
        if (columnIndex5 >= 0 && !cursor.isNull(columnIndex5)) {
            builder.setCanonicalGenres(VideoContract.PreviewProgramColumns.Genres.decode(cursor.getString(columnIndex5)));
        }
        int columnIndex6 = cursor.getColumnIndex("content_id");
        if (columnIndex6 >= 0 && !cursor.isNull(columnIndex6)) {
            builder.setContentId(cursor.getString(columnIndex6));
        }
        int columnIndex7 = cursor.getColumnIndex("content_rating");
        if (columnIndex7 >= 0 && !cursor.isNull(columnIndex7)) {
            builder.setContentRatings(VideoContractUtils.stringToContentRatings(cursor.getString(columnIndex7)));
        }
        int columnIndex8 = cursor.getColumnIndex("duration_millis");
        if (columnIndex8 >= 0 && !cursor.isNull(columnIndex8)) {
            builder.setDurationMillis(cursor.getLong(columnIndex8));
        }
        int columnIndex9 = cursor.getColumnIndex("episode_display_number");
        if (columnIndex9 >= 0 && !cursor.isNull(columnIndex9)) {
            builder.setEpisodeNumber(cursor.getString(columnIndex9));
        }
        int columnIndex10 = cursor.getColumnIndex("episode_title");
        if (columnIndex10 >= 0 && !cursor.isNull(columnIndex10)) {
            builder.setEpisodeTitle(cursor.getString(columnIndex10));
        }
        int columnIndex11 = cursor.getColumnIndex("genre");
        if (columnIndex11 >= 0 && !cursor.isNull(columnIndex11)) {
            builder.setGenre(cursor.getString(columnIndex11));
        }
        int columnIndex12 = cursor.getColumnIndex("intent_uri");
        if (columnIndex12 >= 0 && !cursor.isNull(columnIndex12)) {
            builder.setIntentUri(Uri.parse(cursor.getString(columnIndex12)));
        }
        int columnIndex13 = cursor.getColumnIndex("interaction_count");
        if (columnIndex13 >= 0 && !cursor.isNull(columnIndex13)) {
            builder.setInteractionCount(cursor.getInt(columnIndex13));
        }
        int columnIndex14 = cursor.getColumnIndex("interaction_type");
        if (columnIndex14 >= 0 && !cursor.isNull(columnIndex14)) {
            builder.setInteractionType(cursor.getInt(columnIndex14));
        }
        int columnIndex15 = cursor.getColumnIndex("internal_provider_id");
        if (columnIndex15 >= 0 && !cursor.isNull(columnIndex15)) {
            builder.setInternalProviderId(cursor.getString(columnIndex15));
        }
        int columnIndex16 = cursor.getColumnIndex("item_count");
        if (columnIndex16 >= 0 && !cursor.isNull(columnIndex16)) {
            builder.setItemCount(cursor.getInt(columnIndex16));
        }
        int columnIndex17 = cursor.getColumnIndex("last_playback_position_millis");
        if (columnIndex17 >= 0 && !cursor.isNull(columnIndex17)) {
            builder.setLastPlaybackPositionMillis(cursor.getInt(columnIndex17));
        }
        int columnIndex18 = cursor.getColumnIndex("live");
        if (columnIndex18 >= 0 && !cursor.isNull(columnIndex18)) {
            builder.setLive(cursor.getInt(columnIndex18) == 1);
        }
        int columnIndex19 = cursor.getColumnIndex("logo_uri");
        if (columnIndex19 >= 0 && !cursor.isNull(columnIndex19)) {
            builder.setLogoUri(Uri.parse(cursor.getString(columnIndex19)));
        }
        int columnIndex20 = cursor.getColumnIndex("logo_content_description");
        if (columnIndex20 >= 0 && !cursor.isNull(columnIndex20)) {
            builder.setLogoContentDescription(cursor.getString(columnIndex20));
        }
        int columnIndex21 = cursor.getColumnIndex("offer_price");
        if (columnIndex21 >= 0 && !cursor.isNull(columnIndex21)) {
            builder.setOfferPrice(cursor.getString(columnIndex21));
        }
        int columnIndex22 = cursor.getColumnIndex("poster_art_aspect_ratio");
        if (columnIndex22 >= 0 && !cursor.isNull(columnIndex22)) {
            builder.setPosterArtAspectRatio(cursor.getInt(columnIndex22));
        }
        int columnIndex23 = cursor.getColumnIndex("poster_art_uri");
        if (columnIndex23 >= 0 && !cursor.isNull(columnIndex23)) {
            builder.setPosterArtUri(Uri.parse(cursor.getString(columnIndex23)));
        }
        int columnIndex24 = cursor.getColumnIndex("preview_audio_uri");
        if (columnIndex24 >= 0 && !cursor.isNull(columnIndex24)) {
            builder.setPreviewAudioUri(Uri.parse(cursor.getString(columnIndex24)));
        }
        int columnIndex25 = cursor.getColumnIndex("preview_video_uri");
        if (columnIndex25 >= 0 && !cursor.isNull(columnIndex25)) {
            builder.setPreviewVideoUri(Uri.parse(cursor.getString(columnIndex25)));
        }
        int columnIndex26 = cursor.getColumnIndex("release_date");
        if (columnIndex26 >= 0 && !cursor.isNull(columnIndex26)) {
            builder.setReleaseDate(cursor.getString(columnIndex26));
        }
        int columnIndex27 = cursor.getColumnIndex("review_rating");
        if (columnIndex27 >= 0 && !cursor.isNull(columnIndex27)) {
            builder.setReviewRating(cursor.getString(columnIndex27));
        }
        int columnIndex28 = cursor.getColumnIndex("review_rating_style");
        if (columnIndex28 >= 0 && !cursor.isNull(columnIndex28)) {
            builder.setReviewRatingStyle(cursor.getInt(columnIndex28));
        }
        int columnIndex29 = cursor.getColumnIndex("season_display_number");
        if (columnIndex29 >= 0 && !cursor.isNull(columnIndex29)) {
            builder.setSeasonNumber(cursor.getString(columnIndex29));
        }
        int columnIndex30 = cursor.getColumnIndex("season_title");
        if (columnIndex30 >= 0 && !cursor.isNull(columnIndex30)) {
            builder.setSeasonTitle(cursor.getString(columnIndex30));
        }
        int columnIndex31 = cursor.getColumnIndex("short_description");
        if (columnIndex31 >= 0 && !cursor.isNull(columnIndex31)) {
            builder.setDescription(cursor.getString(columnIndex31));
        }
        int columnIndex32 = cursor.getColumnIndex("start_time_utc_millis");
        if (columnIndex32 >= 0 && !cursor.isNull(columnIndex32)) {
            builder.setStartTimeUtcMillis(cursor.getLong(columnIndex32));
        }
        int columnIndex33 = cursor.getColumnIndex("end_time_utc_millis");
        if (columnIndex33 >= 0 && !cursor.isNull(columnIndex33)) {
            builder.setEndTimeUtcMillis(cursor.getLong(columnIndex33));
        }
        int columnIndex34 = cursor.getColumnIndex("starting_price");
        if (columnIndex34 >= 0 && !cursor.isNull(columnIndex34)) {
            builder.setStartingPrice(cursor.getString(columnIndex34));
        }
        int columnIndex35 = cursor.getColumnIndex("poster_thumbnail_aspect_ratio");
        if (columnIndex35 >= 0 && !cursor.isNull(columnIndex35)) {
            builder.setThumbnailAspectRatio(cursor.getInt(columnIndex35));
        }
        int columnIndex36 = cursor.getColumnIndex("thumbnail_uri");
        if (columnIndex36 >= 0 && !cursor.isNull(columnIndex36)) {
            builder.setThumbnailUri(Uri.parse(cursor.getString(columnIndex36)));
        }
        int columnIndex37 = cursor.getColumnIndex("title");
        if (columnIndex37 >= 0 && !cursor.isNull(columnIndex37)) {
            builder.setTitle(cursor.getString(columnIndex37));
        }
        int columnIndex38 = cursor.getColumnIndex("type");
        if (columnIndex38 >= 0 && !cursor.isNull(columnIndex38)) {
            builder.setType(cursor.getInt(columnIndex38));
        }
        int columnIndex39 = cursor.getColumnIndex(VideoContract.PreviewProgramColumns.COLUMN_SERIES_ID);
        if (columnIndex39 >= 0 && !cursor.isNull(columnIndex39)) {
            builder.setSeriesId(cursor.getString(columnIndex39));
        }
        int columnIndex40 = cursor.getColumnIndex("tv_series_item_type");
        if (columnIndex40 >= 0 && !cursor.isNull(columnIndex40)) {
            builder.setTvSeriesItemType(cursor.getInt(columnIndex40));
        }
        int columnIndex41 = cursor.getColumnIndex("video_height");
        if (columnIndex41 >= 0 && !cursor.isNull(columnIndex41)) {
            builder.setVideoHeight((int) cursor.getLong(columnIndex41));
        }
        int columnIndex42 = cursor.getColumnIndex("video_width");
        if (columnIndex42 < 0 || cursor.isNull(columnIndex42)) {
            return;
        }
        builder.setVideoWidth((int) cursor.getLong(columnIndex42));
    }

    public String getAuthor() {
        return this.values.getAsString("author");
    }

    public int getAvailability() {
        Integer asInteger = this.values.getAsInteger("availability");
        if (asInteger == null) {
            return -1;
        }
        return asInteger.intValue();
    }

    public String[] getCanonicalGenres() {
        return VideoContract.PreviewProgramColumns.Genres.decode(this.values.getAsString("canonical_genre"));
    }

    public String getContentId() {
        return this.values.getAsString("content_id");
    }

    public TvContentRating[] getContentRatings() {
        return VideoContractUtils.stringToContentRatings(this.values.getAsString("content_rating"));
    }

    public String getDescription() {
        return this.values.getAsString("short_description");
    }

    public long getDurationMillis() {
        Long asLong = this.values.getAsLong("duration_millis");
        if (asLong == null) {
            return -1L;
        }
        return asLong.longValue();
    }

    public long getEndTimeUtcMillis() {
        Long asLong = this.values.getAsLong("end_time_utc_millis");
        if (asLong == null) {
            return -1L;
        }
        return asLong.longValue();
    }

    public String getEpisodeNumber() {
        return this.values.getAsString("episode_display_number");
    }

    public String getEpisodeTitle() {
        return this.values.getAsString("episode_title");
    }

    public String getGenre() {
        return this.values.getAsString("genre");
    }

    public long getId() {
        Long asLong = this.values.getAsLong("_id");
        if (asLong == null) {
            return -1L;
        }
        return asLong.longValue();
    }

    public Intent getIntent() throws URISyntaxException {
        String asString = this.values.getAsString("intent_uri");
        if (asString == null) {
            return null;
        }
        return Intent.parseUri(asString, 1);
    }

    public Uri getIntentUri() {
        String asString = this.values.getAsString("intent_uri");
        if (asString == null) {
            return null;
        }
        return Uri.parse(asString);
    }

    public long getInteractionCount() {
        Long asLong = this.values.getAsLong("interaction_count");
        if (asLong == null) {
            return -1L;
        }
        return asLong.longValue();
    }

    public int getInteractionType() {
        Integer asInteger = this.values.getAsInteger("interaction_type");
        if (asInteger == null) {
            return -1;
        }
        return asInteger.intValue();
    }

    public String getInternalProviderId() {
        return this.values.getAsString("internal_provider_id");
    }

    public int getItemCount() {
        Integer asInteger = this.values.getAsInteger("item_count");
        if (asInteger == null) {
            return -1;
        }
        return asInteger.intValue();
    }

    public int getLastPlaybackPositionMillis() {
        Integer asInteger = this.values.getAsInteger("last_playback_position_millis");
        if (asInteger == null) {
            return -1;
        }
        return asInteger.intValue();
    }

    public String getLogoContentDescription() {
        return this.values.getAsString("logo_content_description");
    }

    public Uri getLogoUri() {
        String asString = this.values.getAsString("logo_uri");
        if (asString == null) {
            return null;
        }
        return Uri.parse(asString);
    }

    public String getOfferPrice() {
        return this.values.getAsString("offer_price");
    }

    public String getPackageName() {
        return this.values.getAsString("package_name");
    }

    public int getPosterArtAspectRatio() {
        Integer asInteger = this.values.getAsInteger("poster_art_aspect_ratio");
        if (asInteger == null) {
            return -1;
        }
        return asInteger.intValue();
    }

    public Uri getPosterArtUri() {
        String asString = this.values.getAsString("poster_art_uri");
        if (asString == null) {
            return null;
        }
        return Uri.parse(asString);
    }

    public Uri getPreviewAudioUri() {
        String asString = this.values.getAsString("preview_audio_uri");
        if (asString == null) {
            return null;
        }
        return Uri.parse(asString);
    }

    public Uri getPreviewVideoUri() {
        String asString = this.values.getAsString("preview_video_uri");
        if (asString == null) {
            return null;
        }
        return Uri.parse(asString);
    }

    public String getReleaseDate() {
        return this.values.getAsString("release_date");
    }

    public String getReviewRating() {
        return this.values.getAsString("review_rating");
    }

    public int getReviewRatingStyle() {
        Integer asInteger = this.values.getAsInteger("review_rating_style");
        if (asInteger == null) {
            return -1;
        }
        return asInteger.intValue();
    }

    public String getSeasonNumber() {
        return this.values.getAsString("season_display_number");
    }

    public String getSeasonTitle() {
        return this.values.getAsString("season_title");
    }

    public String getSeriesId() {
        return this.values.getAsString(VideoContract.PreviewProgramColumns.COLUMN_SERIES_ID);
    }

    public long getStartTimeUtcMillis() {
        Long asLong = this.values.getAsLong("start_time_utc_millis");
        if (asLong == null) {
            return -1L;
        }
        return asLong.longValue();
    }

    public String getStartingPrice() {
        return this.values.getAsString("starting_price");
    }

    public int getThumbnailAspectRatio() {
        Integer asInteger = this.values.getAsInteger("poster_thumbnail_aspect_ratio");
        if (asInteger == null) {
            return -1;
        }
        return asInteger.intValue();
    }

    public Uri getThumbnailUri() {
        String asString = this.values.getAsString("thumbnail_uri");
        if (asString == null) {
            return null;
        }
        return Uri.parse(asString);
    }

    public String getTitle() {
        return this.values.getAsString("title");
    }

    public int getTvSeriesItemType() {
        Integer asInteger = this.values.getAsInteger("tv_series_item_type");
        if (asInteger == null) {
            return -1;
        }
        return asInteger.intValue();
    }

    public int getType() {
        Integer asInteger = this.values.getAsInteger("type");
        if (asInteger == null) {
            return -1;
        }
        return asInteger.intValue();
    }

    public int getVideoHeight() {
        Integer asInteger = this.values.getAsInteger("video_height");
        if (asInteger == null) {
            return -1;
        }
        return asInteger.intValue();
    }

    public int getVideoWidth() {
        Integer asInteger = this.values.getAsInteger("video_width");
        if (asInteger == null) {
            return -1;
        }
        return asInteger.intValue();
    }

    public boolean isLive() {
        Integer asInteger = this.values.getAsInteger("live");
        return asInteger != null && asInteger.intValue() == 1;
    }

    public ContentValues toContentValues() {
        return new ContentValues(this.values);
    }
}
