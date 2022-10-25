package com.google.android.mediahome.video;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.media.tv.TvContentRating;
import android.net.Uri;
import com.google.android.mediahome.video.BasePreviewProgram;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URISyntaxException;

/* compiled from: com.google.android.mediahome:video@@1.0.0 */
/* loaded from: classes3.dex */
public final class WatchNextProgram extends BasePreviewProgram {
    public static final String[] PROJECTION = (String[]) zza.zza(BasePreviewProgram.PROJECTION, new String[]{"watch_next_type", "last_engagement_time_utc_millis"});
    public static final int WATCH_NEXT_TYPE_UNKNOWN = -1;

    /* compiled from: com.google.android.mediahome:video@@1.0.0 */
    /* loaded from: classes3.dex */
    public static final class Builder extends BasePreviewProgram.Builder<Builder> {
        public Builder() {
        }

        public WatchNextProgram build() {
            return new WatchNextProgram(this);
        }

        public Builder setLastEngagementTimeUtcMillis(long j) {
            this.values.put("last_engagement_time_utc_millis", Long.valueOf(j));
            return this;
        }

        public Builder setWatchNextType(int i) {
            this.values.put("watch_next_type", Integer.valueOf(i));
            return this;
        }

        public Builder(WatchNextProgram watchNextProgram) {
            this.values = new ContentValues(watchNextProgram.values);
        }
    }

    /* compiled from: com.google.android.mediahome:video@@1.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface WatchNextType {
    }

    WatchNextProgram(Builder builder) {
        super(builder);
    }

    public static WatchNextProgram fromCursor(Cursor cursor) {
        Builder builder = new Builder();
        BasePreviewProgram.setFieldsFromCursor(cursor, builder);
        int columnIndex = cursor.getColumnIndex("watch_next_type");
        if (columnIndex >= 0 && !cursor.isNull(columnIndex)) {
            builder.setWatchNextType(cursor.getInt(columnIndex));
        }
        int columnIndex2 = cursor.getColumnIndex("last_engagement_time_utc_millis");
        if (columnIndex2 >= 0 && !cursor.isNull(columnIndex2)) {
            builder.setLastEngagementTimeUtcMillis(cursor.getLong(columnIndex2));
        }
        return builder.build();
    }

    public boolean equals(Object obj) {
        if (obj instanceof WatchNextProgram) {
            return this.values.equals(((WatchNextProgram) obj).values);
        }
        return false;
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ String getAuthor() {
        return super.getAuthor();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ int getAvailability() {
        return super.getAvailability();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ String[] getCanonicalGenres() {
        return super.getCanonicalGenres();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ String getContentId() {
        return super.getContentId();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ TvContentRating[] getContentRatings() {
        return super.getContentRatings();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ String getDescription() {
        return super.getDescription();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ long getDurationMillis() {
        return super.getDurationMillis();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ long getEndTimeUtcMillis() {
        return super.getEndTimeUtcMillis();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ String getEpisodeNumber() {
        return super.getEpisodeNumber();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ String getEpisodeTitle() {
        return super.getEpisodeTitle();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ String getGenre() {
        return super.getGenre();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ long getId() {
        return super.getId();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ Intent getIntent() throws URISyntaxException {
        return super.getIntent();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ Uri getIntentUri() {
        return super.getIntentUri();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ long getInteractionCount() {
        return super.getInteractionCount();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ int getInteractionType() {
        return super.getInteractionType();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ String getInternalProviderId() {
        return super.getInternalProviderId();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ int getItemCount() {
        return super.getItemCount();
    }

    public long getLastEngagementTimeUtcMillis() {
        Long asLong = this.values.getAsLong("last_engagement_time_utc_millis");
        if (asLong == null) {
            return -1L;
        }
        return asLong.longValue();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ int getLastPlaybackPositionMillis() {
        return super.getLastPlaybackPositionMillis();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ String getLogoContentDescription() {
        return super.getLogoContentDescription();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ Uri getLogoUri() {
        return super.getLogoUri();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ String getOfferPrice() {
        return super.getOfferPrice();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ String getPackageName() {
        return super.getPackageName();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ int getPosterArtAspectRatio() {
        return super.getPosterArtAspectRatio();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ Uri getPosterArtUri() {
        return super.getPosterArtUri();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ Uri getPreviewAudioUri() {
        return super.getPreviewAudioUri();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ Uri getPreviewVideoUri() {
        return super.getPreviewVideoUri();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ String getReleaseDate() {
        return super.getReleaseDate();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ String getReviewRating() {
        return super.getReviewRating();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ int getReviewRatingStyle() {
        return super.getReviewRatingStyle();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ String getSeasonNumber() {
        return super.getSeasonNumber();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ String getSeasonTitle() {
        return super.getSeasonTitle();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ String getSeriesId() {
        return super.getSeriesId();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ long getStartTimeUtcMillis() {
        return super.getStartTimeUtcMillis();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ String getStartingPrice() {
        return super.getStartingPrice();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ int getThumbnailAspectRatio() {
        return super.getThumbnailAspectRatio();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ Uri getThumbnailUri() {
        return super.getThumbnailUri();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ String getTitle() {
        return super.getTitle();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ int getTvSeriesItemType() {
        return super.getTvSeriesItemType();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ int getType() {
        return super.getType();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ int getVideoHeight() {
        return super.getVideoHeight();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ int getVideoWidth() {
        return super.getVideoWidth();
    }

    public int getWatchNextType() {
        Integer asInteger = this.values.getAsInteger("watch_next_type");
        if (asInteger == null) {
            return -1;
        }
        return asInteger.intValue();
    }

    public boolean hasAnyUpdatedValues(WatchNextProgram watchNextProgram) {
        for (String str : watchNextProgram.values.keySet()) {
            if (!WatchNextProgram$$ExternalSyntheticBackport0.m326m(watchNextProgram.values.get(str), this.values.get(str))) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.values.hashCode();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public /* bridge */ /* synthetic */ boolean isLive() {
        return super.isLive();
    }

    @Override // com.google.android.mediahome.video.BasePreviewProgram
    public ContentValues toContentValues() {
        return super.toContentValues();
    }

    public String toString() {
        String valueOf = String.valueOf(this.values);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
        sb.append("WatchNextProgram{");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }
}
