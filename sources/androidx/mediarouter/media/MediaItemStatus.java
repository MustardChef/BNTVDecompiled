package androidx.mediarouter.media;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.core.util.TimeUtils;

/* loaded from: classes.dex */
public final class MediaItemStatus {
    public static final String EXTRA_HTTP_RESPONSE_HEADERS = "android.media.status.extra.HTTP_RESPONSE_HEADERS";
    public static final String EXTRA_HTTP_STATUS_CODE = "android.media.status.extra.HTTP_STATUS_CODE";
    static final String KEY_CONTENT_DURATION = "contentDuration";
    static final String KEY_CONTENT_POSITION = "contentPosition";
    static final String KEY_EXTRAS = "extras";
    static final String KEY_PLAYBACK_STATE = "playbackState";
    static final String KEY_TIMESTAMP = "timestamp";
    public static final int PLAYBACK_STATE_BUFFERING = 3;
    public static final int PLAYBACK_STATE_CANCELED = 5;
    public static final int PLAYBACK_STATE_ERROR = 7;
    public static final int PLAYBACK_STATE_FINISHED = 4;
    public static final int PLAYBACK_STATE_INVALIDATED = 6;
    public static final int PLAYBACK_STATE_PAUSED = 2;
    public static final int PLAYBACK_STATE_PENDING = 0;
    public static final int PLAYBACK_STATE_PLAYING = 1;
    final Bundle mBundle;

    MediaItemStatus(Bundle bundle) {
        this.mBundle = bundle;
    }

    public long getTimestamp() {
        return this.mBundle.getLong(KEY_TIMESTAMP);
    }

    public int getPlaybackState() {
        return this.mBundle.getInt(KEY_PLAYBACK_STATE, 7);
    }

    public long getContentPosition() {
        return this.mBundle.getLong(KEY_CONTENT_POSITION, -1L);
    }

    public long getContentDuration() {
        return this.mBundle.getLong(KEY_CONTENT_DURATION, -1L);
    }

    public Bundle getExtras() {
        return this.mBundle.getBundle("extras");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MediaItemStatus{ ");
        sb.append("timestamp=");
        TimeUtils.formatDuration(SystemClock.elapsedRealtime() - getTimestamp(), sb);
        sb.append(" ms ago");
        sb.append(", playbackState=");
        sb.append(playbackStateToString(getPlaybackState()));
        sb.append(", contentPosition=");
        sb.append(getContentPosition());
        sb.append(", contentDuration=");
        sb.append(getContentDuration());
        sb.append(", extras=");
        sb.append(getExtras());
        sb.append(" }");
        return sb.toString();
    }

    private static String playbackStateToString(int i) {
        switch (i) {
            case 0:
                return "pending";
            case 1:
                return "playing";
            case 2:
                return "paused";
            case 3:
                return "buffering";
            case 4:
                return "finished";
            case 5:
                return "canceled";
            case 6:
                return "invalidated";
            case 7:
                return "error";
            default:
                return Integer.toString(i);
        }
    }

    public Bundle asBundle() {
        return this.mBundle;
    }

    public static MediaItemStatus fromBundle(Bundle bundle) {
        if (bundle != null) {
            return new MediaItemStatus(bundle);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private final Bundle mBundle;

        public Builder(int i) {
            this.mBundle = new Bundle();
            setTimestamp(SystemClock.elapsedRealtime());
            setPlaybackState(i);
        }

        public Builder(MediaItemStatus mediaItemStatus) {
            if (mediaItemStatus == null) {
                throw new IllegalArgumentException("status must not be null");
            }
            this.mBundle = new Bundle(mediaItemStatus.mBundle);
        }

        public Builder setTimestamp(long j) {
            this.mBundle.putLong(MediaItemStatus.KEY_TIMESTAMP, j);
            return this;
        }

        public Builder setPlaybackState(int i) {
            this.mBundle.putInt(MediaItemStatus.KEY_PLAYBACK_STATE, i);
            return this;
        }

        public Builder setContentPosition(long j) {
            this.mBundle.putLong(MediaItemStatus.KEY_CONTENT_POSITION, j);
            return this;
        }

        public Builder setContentDuration(long j) {
            this.mBundle.putLong(MediaItemStatus.KEY_CONTENT_DURATION, j);
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.mBundle.putBundle("extras", bundle);
            return this;
        }

        public MediaItemStatus build() {
            return new MediaItemStatus(this.mBundle);
        }
    }
}
