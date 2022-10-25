package androidx.tvprovider.media.p009tv;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Build;
import androidx.tvprovider.media.p009tv.BasePreviewProgram;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* renamed from: androidx.tvprovider.media.tv.WatchNextProgram */
/* loaded from: classes.dex */
public final class WatchNextProgram extends BasePreviewProgram {
    private static final int INVALID_INT_VALUE = -1;
    private static final long INVALID_LONG_VALUE = -1;
    public static final String[] PROJECTION = getProjection();
    public static final int WATCH_NEXT_TYPE_UNKNOWN = -1;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: androidx.tvprovider.media.tv.WatchNextProgram$WatchNextType */
    /* loaded from: classes.dex */
    public @interface WatchNextType {
    }

    WatchNextProgram(Builder builder) {
        super(builder);
    }

    public int getWatchNextType() {
        Integer asInteger = this.mValues.getAsInteger("watch_next_type");
        if (asInteger == null) {
            return -1;
        }
        return asInteger.intValue();
    }

    public long getLastEngagementTimeUtcMillis() {
        Long asLong = this.mValues.getAsLong("last_engagement_time_utc_millis");
        if (asLong == null) {
            return -1L;
        }
        return asLong.longValue();
    }

    @Override // androidx.tvprovider.media.p009tv.BasePreviewProgram, androidx.tvprovider.media.p009tv.BaseProgram
    public boolean equals(Object obj) {
        if (obj instanceof WatchNextProgram) {
            return this.mValues.equals(((WatchNextProgram) obj).mValues);
        }
        return false;
    }

    public boolean hasAnyUpdatedValues(WatchNextProgram watchNextProgram) {
        for (String str : watchNextProgram.mValues.keySet()) {
            if (!Objects.deepEquals(watchNextProgram.mValues.get(str), this.mValues.get(str))) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.tvprovider.media.p009tv.BaseProgram
    public String toString() {
        return "WatchNextProgram{" + this.mValues.toString() + "}";
    }

    @Override // androidx.tvprovider.media.p009tv.BasePreviewProgram, androidx.tvprovider.media.p009tv.BaseProgram
    public ContentValues toContentValues() {
        return toContentValues(false);
    }

    @Override // androidx.tvprovider.media.p009tv.BasePreviewProgram
    public ContentValues toContentValues(boolean z) {
        ContentValues contentValues = super.toContentValues(z);
        if (Build.VERSION.SDK_INT < 26) {
            contentValues.remove("watch_next_type");
            contentValues.remove("last_engagement_time_utc_millis");
        }
        return contentValues;
    }

    public static WatchNextProgram fromCursor(Cursor cursor) {
        Builder builder = new Builder();
        BasePreviewProgram.setFieldsFromCursor(cursor, (BasePreviewProgram.Builder) builder);
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

    private static String[] getProjection() {
        return (String[]) CollectionUtils.concatAll(BasePreviewProgram.PROJECTION, new String[]{"watch_next_type", "last_engagement_time_utc_millis"});
    }

    /* renamed from: androidx.tvprovider.media.tv.WatchNextProgram$Builder */
    /* loaded from: classes.dex */
    public static final class Builder extends BasePreviewProgram.Builder<Builder> {
        public Builder() {
        }

        public Builder(WatchNextProgram watchNextProgram) {
            this.mValues = new ContentValues(watchNextProgram.mValues);
        }

        public Builder setWatchNextType(int i) {
            this.mValues.put("watch_next_type", Integer.valueOf(i));
            return this;
        }

        public Builder setLastEngagementTimeUtcMillis(long j) {
            this.mValues.put("last_engagement_time_utc_millis", Long.valueOf(j));
            return this;
        }

        public WatchNextProgram build() {
            return new WatchNextProgram(this);
        }
    }
}
