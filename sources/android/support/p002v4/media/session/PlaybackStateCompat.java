package android.support.p002v4.media.session;

import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.media.session.PlaybackStateCompat */
/* loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final long ACTION_FAST_FORWARD = 64;
    public static final long ACTION_PAUSE = 2;
    public static final long ACTION_PLAY = 4;
    public static final long ACTION_PLAY_FROM_MEDIA_ID = 1024;
    public static final long ACTION_PLAY_FROM_SEARCH = 2048;
    public static final long ACTION_PLAY_FROM_URI = 8192;
    public static final long ACTION_PLAY_PAUSE = 512;
    public static final long ACTION_PREPARE = 16384;
    public static final long ACTION_PREPARE_FROM_MEDIA_ID = 32768;
    public static final long ACTION_PREPARE_FROM_SEARCH = 65536;
    public static final long ACTION_PREPARE_FROM_URI = 131072;
    public static final long ACTION_REWIND = 8;
    public static final long ACTION_SEEK_TO = 256;
    public static final long ACTION_SET_CAPTIONING_ENABLED = 1048576;
    public static final long ACTION_SET_PLAYBACK_SPEED = 4194304;
    public static final long ACTION_SET_RATING = 128;
    public static final long ACTION_SET_REPEAT_MODE = 262144;
    public static final long ACTION_SET_SHUFFLE_MODE = 2097152;
    @Deprecated
    public static final long ACTION_SET_SHUFFLE_MODE_ENABLED = 524288;
    public static final long ACTION_SKIP_TO_NEXT = 32;
    public static final long ACTION_SKIP_TO_PREVIOUS = 16;
    public static final long ACTION_SKIP_TO_QUEUE_ITEM = 4096;
    public static final long ACTION_STOP = 1;
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new Parcelable.Creator<PlaybackStateCompat>() { // from class: android.support.v4.media.session.PlaybackStateCompat.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PlaybackStateCompat createFromParcel(Parcel in) {
            return new PlaybackStateCompat(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PlaybackStateCompat[] newArray(int size) {
            return new PlaybackStateCompat[size];
        }
    };
    public static final int ERROR_CODE_ACTION_ABORTED = 10;
    public static final int ERROR_CODE_APP_ERROR = 1;
    public static final int ERROR_CODE_AUTHENTICATION_EXPIRED = 3;
    public static final int ERROR_CODE_CONCURRENT_STREAM_LIMIT = 5;
    public static final int ERROR_CODE_CONTENT_ALREADY_PLAYING = 8;
    public static final int ERROR_CODE_END_OF_QUEUE = 11;
    public static final int ERROR_CODE_NOT_AVAILABLE_IN_REGION = 7;
    public static final int ERROR_CODE_NOT_SUPPORTED = 2;
    public static final int ERROR_CODE_PARENTAL_CONTROL_RESTRICTED = 6;
    public static final int ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED = 4;
    public static final int ERROR_CODE_SKIP_LIMIT_REACHED = 9;
    public static final int ERROR_CODE_UNKNOWN_ERROR = 0;
    private static final int KEYCODE_MEDIA_PAUSE = 127;
    private static final int KEYCODE_MEDIA_PLAY = 126;
    public static final long PLAYBACK_POSITION_UNKNOWN = -1;
    public static final int REPEAT_MODE_ALL = 2;
    public static final int REPEAT_MODE_GROUP = 3;
    public static final int REPEAT_MODE_INVALID = -1;
    public static final int REPEAT_MODE_NONE = 0;
    public static final int REPEAT_MODE_ONE = 1;
    public static final int SHUFFLE_MODE_ALL = 1;
    public static final int SHUFFLE_MODE_GROUP = 2;
    public static final int SHUFFLE_MODE_INVALID = -1;
    public static final int SHUFFLE_MODE_NONE = 0;
    public static final int STATE_BUFFERING = 6;
    public static final int STATE_CONNECTING = 8;
    public static final int STATE_ERROR = 7;
    public static final int STATE_FAST_FORWARDING = 4;
    public static final int STATE_NONE = 0;
    public static final int STATE_PAUSED = 2;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_REWINDING = 5;
    public static final int STATE_SKIPPING_TO_NEXT = 10;
    public static final int STATE_SKIPPING_TO_PREVIOUS = 9;
    public static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
    public static final int STATE_STOPPED = 1;
    final long mActions;
    final long mActiveItemId;
    final long mBufferedPosition;
    List<CustomAction> mCustomActions;
    final int mErrorCode;
    final CharSequence mErrorMessage;
    final Bundle mExtras;
    final long mPosition;
    final float mSpeed;
    final int mState;
    private PlaybackState mStateFwk;
    final long mUpdateTime;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$Actions */
    /* loaded from: classes.dex */
    public @interface Actions {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$MediaKeyAction */
    /* loaded from: classes.dex */
    public @interface MediaKeyAction {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$RepeatMode */
    /* loaded from: classes.dex */
    public @interface RepeatMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$ShuffleMode */
    /* loaded from: classes.dex */
    public @interface ShuffleMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$State */
    /* loaded from: classes.dex */
    public @interface State {
    }

    public static int toKeyCode(long action) {
        if (action == 4) {
            return 126;
        }
        if (action == 2) {
            return 127;
        }
        if (action == 32) {
            return 87;
        }
        if (action == 16) {
            return 88;
        }
        if (action == 1) {
            return 86;
        }
        if (action == 64) {
            return 90;
        }
        if (action == 8) {
            return 89;
        }
        return action == 512 ? 85 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    PlaybackStateCompat(int state, long position, long bufferedPosition, float rate, long actions, int errorCode, CharSequence errorMessage, long updateTime, List<CustomAction> customActions, long activeItemId, Bundle extras) {
        this.mState = state;
        this.mPosition = position;
        this.mBufferedPosition = bufferedPosition;
        this.mSpeed = rate;
        this.mActions = actions;
        this.mErrorCode = errorCode;
        this.mErrorMessage = errorMessage;
        this.mUpdateTime = updateTime;
        this.mCustomActions = new ArrayList(customActions);
        this.mActiveItemId = activeItemId;
        this.mExtras = extras;
    }

    PlaybackStateCompat(Parcel in) {
        this.mState = in.readInt();
        this.mPosition = in.readLong();
        this.mSpeed = in.readFloat();
        this.mUpdateTime = in.readLong();
        this.mBufferedPosition = in.readLong();
        this.mActions = in.readLong();
        this.mErrorMessage = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        this.mCustomActions = in.createTypedArrayList(CustomAction.CREATOR);
        this.mActiveItemId = in.readLong();
        this.mExtras = in.readBundle(MediaSessionCompat.class.getClassLoader());
        this.mErrorCode = in.readInt();
    }

    public String toString() {
        return "PlaybackState {state=" + this.mState + ", position=" + this.mPosition + ", buffered position=" + this.mBufferedPosition + ", speed=" + this.mSpeed + ", updated=" + this.mUpdateTime + ", actions=" + this.mActions + ", error code=" + this.mErrorCode + ", error message=" + this.mErrorMessage + ", custom actions=" + this.mCustomActions + ", active item id=" + this.mActiveItemId + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mState);
        dest.writeLong(this.mPosition);
        dest.writeFloat(this.mSpeed);
        dest.writeLong(this.mUpdateTime);
        dest.writeLong(this.mBufferedPosition);
        dest.writeLong(this.mActions);
        TextUtils.writeToParcel(this.mErrorMessage, dest, flags);
        dest.writeTypedList(this.mCustomActions);
        dest.writeLong(this.mActiveItemId);
        dest.writeBundle(this.mExtras);
        dest.writeInt(this.mErrorCode);
    }

    public int getState() {
        return this.mState;
    }

    public long getPosition() {
        return this.mPosition;
    }

    public long getLastPositionUpdateTime() {
        return this.mUpdateTime;
    }

    public long getCurrentPosition(Long timeDiff) {
        return Math.max(0L, this.mPosition + (this.mSpeed * ((float) (timeDiff != null ? timeDiff.longValue() : SystemClock.elapsedRealtime() - this.mUpdateTime))));
    }

    public long getBufferedPosition() {
        return this.mBufferedPosition;
    }

    public float getPlaybackSpeed() {
        return this.mSpeed;
    }

    public long getActions() {
        return this.mActions;
    }

    public List<CustomAction> getCustomActions() {
        return this.mCustomActions;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public CharSequence getErrorMessage() {
        return this.mErrorMessage;
    }

    public long getActiveQueueItemId() {
        return this.mActiveItemId;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public static PlaybackStateCompat fromPlaybackState(Object stateObj) {
        ArrayList arrayList;
        Bundle bundle = null;
        if (stateObj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        PlaybackState playbackState = (PlaybackState) stateObj;
        List<PlaybackState.CustomAction> customActions = Api21Impl.getCustomActions(playbackState);
        if (customActions != null) {
            ArrayList arrayList2 = new ArrayList(customActions.size());
            for (PlaybackState.CustomAction customAction : customActions) {
                arrayList2.add(CustomAction.fromCustomAction(customAction));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (Build.VERSION.SDK_INT >= 22) {
            bundle = Api22Impl.getExtras(playbackState);
            MediaSessionCompat.ensureClassLoader(bundle);
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(Api21Impl.getState(playbackState), Api21Impl.getPosition(playbackState), Api21Impl.getBufferedPosition(playbackState), Api21Impl.getPlaybackSpeed(playbackState), Api21Impl.getActions(playbackState), 0, Api21Impl.getErrorMessage(playbackState), Api21Impl.getLastPositionUpdateTime(playbackState), arrayList, Api21Impl.getActiveQueueItemId(playbackState), bundle);
        playbackStateCompat.mStateFwk = playbackState;
        return playbackStateCompat;
    }

    public Object getPlaybackState() {
        if (this.mStateFwk == null && Build.VERSION.SDK_INT >= 21) {
            PlaybackState.Builder createBuilder = Api21Impl.createBuilder();
            Api21Impl.setState(createBuilder, this.mState, this.mPosition, this.mSpeed, this.mUpdateTime);
            Api21Impl.setBufferedPosition(createBuilder, this.mBufferedPosition);
            Api21Impl.setActions(createBuilder, this.mActions);
            Api21Impl.setErrorMessage(createBuilder, this.mErrorMessage);
            for (CustomAction customAction : this.mCustomActions) {
                Api21Impl.addCustomAction(createBuilder, (PlaybackState.CustomAction) customAction.getCustomAction());
            }
            Api21Impl.setActiveQueueItemId(createBuilder, this.mActiveItemId);
            if (Build.VERSION.SDK_INT >= 22) {
                Api22Impl.setExtras(createBuilder, this.mExtras);
            }
            this.mStateFwk = Api21Impl.build(createBuilder);
        }
        return this.mStateFwk;
    }

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction */
    /* loaded from: classes.dex */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator<CustomAction>() { // from class: android.support.v4.media.session.PlaybackStateCompat.CustomAction.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CustomAction createFromParcel(Parcel p) {
                return new CustomAction(p);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CustomAction[] newArray(int size) {
                return new CustomAction[size];
            }
        };
        private final String mAction;
        private PlaybackState.CustomAction mCustomActionFwk;
        private final Bundle mExtras;
        private final int mIcon;
        private final CharSequence mName;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        CustomAction(String action, CharSequence name, int icon, Bundle extras) {
            this.mAction = action;
            this.mName = name;
            this.mIcon = icon;
            this.mExtras = extras;
        }

        CustomAction(Parcel in) {
            this.mAction = in.readString();
            this.mName = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            this.mIcon = in.readInt();
            this.mExtras = in.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.mAction);
            TextUtils.writeToParcel(this.mName, dest, flags);
            dest.writeInt(this.mIcon);
            dest.writeBundle(this.mExtras);
        }

        public static CustomAction fromCustomAction(Object customActionObj) {
            if (customActionObj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            PlaybackState.CustomAction customAction = (PlaybackState.CustomAction) customActionObj;
            Bundle extras = Api21Impl.getExtras(customAction);
            MediaSessionCompat.ensureClassLoader(extras);
            CustomAction customAction2 = new CustomAction(Api21Impl.getAction(customAction), Api21Impl.getName(customAction), Api21Impl.getIcon(customAction), extras);
            customAction2.mCustomActionFwk = customAction;
            return customAction2;
        }

        public Object getCustomAction() {
            if (this.mCustomActionFwk != null || Build.VERSION.SDK_INT < 21) {
                return this.mCustomActionFwk;
            }
            PlaybackState.CustomAction.Builder createCustomActionBuilder = Api21Impl.createCustomActionBuilder(this.mAction, this.mName, this.mIcon);
            Api21Impl.setExtras(createCustomActionBuilder, this.mExtras);
            return Api21Impl.build(createCustomActionBuilder);
        }

        public String getAction() {
            return this.mAction;
        }

        public CharSequence getName() {
            return this.mName;
        }

        public int getIcon() {
            return this.mIcon;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.mName) + ", mIcon=" + this.mIcon + ", mExtras=" + this.mExtras;
        }

        /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder */
        /* loaded from: classes.dex */
        public static final class Builder {
            private final String mAction;
            private Bundle mExtras;
            private final int mIcon;
            private final CharSequence mName;

            public Builder(String action, CharSequence name, int icon) {
                if (TextUtils.isEmpty(action)) {
                    throw new IllegalArgumentException("You must specify an action to build a CustomAction");
                }
                if (TextUtils.isEmpty(name)) {
                    throw new IllegalArgumentException("You must specify a name to build a CustomAction");
                }
                if (icon == 0) {
                    throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction");
                }
                this.mAction = action;
                this.mName = name;
                this.mIcon = icon;
            }

            public Builder setExtras(Bundle extras) {
                this.mExtras = extras;
                return this;
            }

            public CustomAction build() {
                return new CustomAction(this.mAction, this.mName, this.mIcon, this.mExtras);
            }
        }
    }

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$Builder */
    /* loaded from: classes.dex */
    public static final class Builder {
        private long mActions;
        private long mActiveItemId;
        private long mBufferedPosition;
        private final List<CustomAction> mCustomActions;
        private int mErrorCode;
        private CharSequence mErrorMessage;
        private Bundle mExtras;
        private long mPosition;
        private float mRate;
        private int mState;
        private long mUpdateTime;

        public Builder() {
            this.mCustomActions = new ArrayList();
            this.mActiveItemId = -1L;
        }

        public Builder(PlaybackStateCompat source) {
            ArrayList arrayList = new ArrayList();
            this.mCustomActions = arrayList;
            this.mActiveItemId = -1L;
            this.mState = source.mState;
            this.mPosition = source.mPosition;
            this.mRate = source.mSpeed;
            this.mUpdateTime = source.mUpdateTime;
            this.mBufferedPosition = source.mBufferedPosition;
            this.mActions = source.mActions;
            this.mErrorCode = source.mErrorCode;
            this.mErrorMessage = source.mErrorMessage;
            if (source.mCustomActions != null) {
                arrayList.addAll(source.mCustomActions);
            }
            this.mActiveItemId = source.mActiveItemId;
            this.mExtras = source.mExtras;
        }

        public Builder setState(int state, long position, float playbackSpeed) {
            return setState(state, position, playbackSpeed, SystemClock.elapsedRealtime());
        }

        public Builder setState(int state, long position, float playbackSpeed, long updateTime) {
            this.mState = state;
            this.mPosition = position;
            this.mUpdateTime = updateTime;
            this.mRate = playbackSpeed;
            return this;
        }

        public Builder setBufferedPosition(long bufferPosition) {
            this.mBufferedPosition = bufferPosition;
            return this;
        }

        public Builder setActions(long capabilities) {
            this.mActions = capabilities;
            return this;
        }

        public Builder addCustomAction(String action, String name, int icon) {
            return addCustomAction(new CustomAction(action, name, icon, null));
        }

        public Builder addCustomAction(CustomAction customAction) {
            if (customAction == null) {
                throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat");
            }
            this.mCustomActions.add(customAction);
            return this;
        }

        public Builder setActiveQueueItemId(long id) {
            this.mActiveItemId = id;
            return this;
        }

        @Deprecated
        public Builder setErrorMessage(CharSequence errorMessage) {
            this.mErrorMessage = errorMessage;
            return this;
        }

        public Builder setErrorMessage(int errorCode, CharSequence errorMessage) {
            this.mErrorCode = errorCode;
            this.mErrorMessage = errorMessage;
            return this;
        }

        public Builder setExtras(Bundle extras) {
            this.mExtras = extras;
            return this;
        }

        public PlaybackStateCompat build() {
            return new PlaybackStateCompat(this.mState, this.mPosition, this.mBufferedPosition, this.mRate, this.mActions, this.mErrorCode, this.mErrorMessage, this.mUpdateTime, this.mCustomActions, this.mActiveItemId, this.mExtras);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$Api21Impl */
    /* loaded from: classes.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        static PlaybackState.Builder createBuilder() {
            return new PlaybackState.Builder();
        }

        static void setState(PlaybackState.Builder builder, int state, long position, float playbackSpeed, long updateTime) {
            builder.setState(state, position, playbackSpeed, updateTime);
        }

        static void setBufferedPosition(PlaybackState.Builder builder, long bufferedPosition) {
            builder.setBufferedPosition(bufferedPosition);
        }

        static void setActions(PlaybackState.Builder builder, long actions) {
            builder.setActions(actions);
        }

        static void setErrorMessage(PlaybackState.Builder builder, CharSequence error) {
            builder.setErrorMessage(error);
        }

        static void addCustomAction(PlaybackState.Builder builder, PlaybackState.CustomAction customAction) {
            builder.addCustomAction(customAction);
        }

        static void setActiveQueueItemId(PlaybackState.Builder builder, long id) {
            builder.setActiveQueueItemId(id);
        }

        static List<PlaybackState.CustomAction> getCustomActions(PlaybackState state) {
            return state.getCustomActions();
        }

        static PlaybackState build(PlaybackState.Builder builder) {
            return builder.build();
        }

        static int getState(PlaybackState state) {
            return state.getState();
        }

        static long getPosition(PlaybackState state) {
            return state.getPosition();
        }

        static long getBufferedPosition(PlaybackState state) {
            return state.getBufferedPosition();
        }

        static float getPlaybackSpeed(PlaybackState state) {
            return state.getPlaybackSpeed();
        }

        static long getActions(PlaybackState state) {
            return state.getActions();
        }

        static CharSequence getErrorMessage(PlaybackState state) {
            return state.getErrorMessage();
        }

        static long getLastPositionUpdateTime(PlaybackState state) {
            return state.getLastPositionUpdateTime();
        }

        static long getActiveQueueItemId(PlaybackState state) {
            return state.getActiveQueueItemId();
        }

        static PlaybackState.CustomAction.Builder createCustomActionBuilder(String action, CharSequence name, int icon) {
            return new PlaybackState.CustomAction.Builder(action, name, icon);
        }

        static void setExtras(PlaybackState.CustomAction.Builder builder, Bundle extras) {
            builder.setExtras(extras);
        }

        static PlaybackState.CustomAction build(PlaybackState.CustomAction.Builder builder) {
            return builder.build();
        }

        static Bundle getExtras(PlaybackState.CustomAction customAction) {
            return customAction.getExtras();
        }

        static String getAction(PlaybackState.CustomAction customAction) {
            return customAction.getAction();
        }

        static CharSequence getName(PlaybackState.CustomAction customAction) {
            return customAction.getName();
        }

        static int getIcon(PlaybackState.CustomAction customAction) {
            return customAction.getIcon();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$Api22Impl */
    /* loaded from: classes.dex */
    public static class Api22Impl {
        private Api22Impl() {
        }

        static void setExtras(PlaybackState.Builder builder, Bundle extras) {
            builder.setExtras(extras);
        }

        static Bundle getExtras(PlaybackState state) {
            return state.getExtras();
        }
    }
}
