package androidx.mediarouter.media;

import android.content.IntentFilter;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class MediaRouteDescriptor {
    static final String IS_DYNAMIC_GROUP_ROUTE = "isDynamicGroupRoute";
    static final String KEY_CAN_DISCONNECT = "canDisconnect";
    static final String KEY_CONNECTING = "connecting";
    static final String KEY_CONNECTION_STATE = "connectionState";
    static final String KEY_CONTROL_FILTERS = "controlFilters";
    static final String KEY_DESCRIPTION = "status";
    static final String KEY_DEVICE_TYPE = "deviceType";
    static final String KEY_ENABLED = "enabled";
    static final String KEY_EXTRAS = "extras";
    static final String KEY_GROUP_MEMBER_IDS = "groupMemberIds";
    static final String KEY_ICON_URI = "iconUri";
    static final String KEY_ID = "id";
    static final String KEY_MAX_CLIENT_VERSION = "maxClientVersion";
    static final String KEY_MIN_CLIENT_VERSION = "minClientVersion";
    static final String KEY_NAME = "name";
    static final String KEY_PLAYBACK_STREAM = "playbackStream";
    static final String KEY_PLAYBACK_TYPE = "playbackType";
    static final String KEY_PRESENTATION_DISPLAY_ID = "presentationDisplayId";
    static final String KEY_SETTINGS_INTENT = "settingsIntent";
    static final String KEY_VOLUME = "volume";
    static final String KEY_VOLUME_HANDLING = "volumeHandling";
    static final String KEY_VOLUME_MAX = "volumeMax";
    final Bundle mBundle;
    List<IntentFilter> mControlFilters;
    List<String> mGroupMemberIds;

    MediaRouteDescriptor(Bundle bundle) {
        this.mBundle = bundle;
    }

    public String getId() {
        return this.mBundle.getString("id");
    }

    public List<String> getGroupMemberIds() {
        ensureGroupMemberIds();
        return this.mGroupMemberIds;
    }

    void ensureGroupMemberIds() {
        if (this.mGroupMemberIds == null) {
            ArrayList<String> stringArrayList = this.mBundle.getStringArrayList(KEY_GROUP_MEMBER_IDS);
            this.mGroupMemberIds = stringArrayList;
            if (stringArrayList == null) {
                this.mGroupMemberIds = Collections.emptyList();
            }
        }
    }

    public String getName() {
        return this.mBundle.getString("name");
    }

    public String getDescription() {
        return this.mBundle.getString("status");
    }

    public Uri getIconUri() {
        String string = this.mBundle.getString(KEY_ICON_URI);
        if (string == null) {
            return null;
        }
        return Uri.parse(string);
    }

    public boolean isEnabled() {
        return this.mBundle.getBoolean(KEY_ENABLED, true);
    }

    public boolean isDynamicGroupRoute() {
        return this.mBundle.getBoolean(IS_DYNAMIC_GROUP_ROUTE, false);
    }

    @Deprecated
    public boolean isConnecting() {
        return this.mBundle.getBoolean(KEY_CONNECTING, false);
    }

    public int getConnectionState() {
        return this.mBundle.getInt(KEY_CONNECTION_STATE, 0);
    }

    public boolean canDisconnectAndKeepPlaying() {
        return this.mBundle.getBoolean(KEY_CAN_DISCONNECT, false);
    }

    public IntentSender getSettingsActivity() {
        return (IntentSender) this.mBundle.getParcelable(KEY_SETTINGS_INTENT);
    }

    public List<IntentFilter> getControlFilters() {
        ensureControlFilters();
        return this.mControlFilters;
    }

    void ensureControlFilters() {
        if (this.mControlFilters == null) {
            ArrayList parcelableArrayList = this.mBundle.getParcelableArrayList(KEY_CONTROL_FILTERS);
            this.mControlFilters = parcelableArrayList;
            if (parcelableArrayList == null) {
                this.mControlFilters = Collections.emptyList();
            }
        }
    }

    public int getPlaybackType() {
        return this.mBundle.getInt(KEY_PLAYBACK_TYPE, 1);
    }

    public int getPlaybackStream() {
        return this.mBundle.getInt(KEY_PLAYBACK_STREAM, -1);
    }

    public int getDeviceType() {
        return this.mBundle.getInt(KEY_DEVICE_TYPE);
    }

    public int getVolume() {
        return this.mBundle.getInt("volume");
    }

    public int getVolumeMax() {
        return this.mBundle.getInt(KEY_VOLUME_MAX);
    }

    public int getVolumeHandling() {
        return this.mBundle.getInt(KEY_VOLUME_HANDLING, 0);
    }

    public int getPresentationDisplayId() {
        return this.mBundle.getInt(KEY_PRESENTATION_DISPLAY_ID, -1);
    }

    public Bundle getExtras() {
        return this.mBundle.getBundle("extras");
    }

    public int getMinClientVersion() {
        return this.mBundle.getInt(KEY_MIN_CLIENT_VERSION, 1);
    }

    public int getMaxClientVersion() {
        return this.mBundle.getInt(KEY_MAX_CLIENT_VERSION, Integer.MAX_VALUE);
    }

    public boolean isValid() {
        ensureControlFilters();
        return (TextUtils.isEmpty(getId()) || TextUtils.isEmpty(getName()) || this.mControlFilters.contains(null)) ? false : true;
    }

    public String toString() {
        return "MediaRouteDescriptor{ id=" + getId() + ", groupMemberIds=" + getGroupMemberIds() + ", name=" + getName() + ", description=" + getDescription() + ", iconUri=" + getIconUri() + ", isEnabled=" + isEnabled() + ", connectionState=" + getConnectionState() + ", controlFilters=" + Arrays.toString(getControlFilters().toArray()) + ", playbackType=" + getPlaybackType() + ", playbackStream=" + getPlaybackStream() + ", deviceType=" + getDeviceType() + ", volume=" + getVolume() + ", volumeMax=" + getVolumeMax() + ", volumeHandling=" + getVolumeHandling() + ", presentationDisplayId=" + getPresentationDisplayId() + ", extras=" + getExtras() + ", isValid=" + isValid() + ", minClientVersion=" + getMinClientVersion() + ", maxClientVersion=" + getMaxClientVersion() + " }";
    }

    public Bundle asBundle() {
        return this.mBundle;
    }

    public static MediaRouteDescriptor fromBundle(Bundle bundle) {
        if (bundle != null) {
            return new MediaRouteDescriptor(bundle);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private final Bundle mBundle;
        private ArrayList<IntentFilter> mControlFilters;
        private ArrayList<String> mGroupMemberIds;

        public Builder(String str, String str2) {
            this.mBundle = new Bundle();
            setId(str);
            setName(str2);
        }

        public Builder(MediaRouteDescriptor mediaRouteDescriptor) {
            if (mediaRouteDescriptor == null) {
                throw new IllegalArgumentException("descriptor must not be null");
            }
            this.mBundle = new Bundle(mediaRouteDescriptor.mBundle);
            if (!mediaRouteDescriptor.getGroupMemberIds().isEmpty()) {
                this.mGroupMemberIds = new ArrayList<>(mediaRouteDescriptor.getGroupMemberIds());
            }
            if (mediaRouteDescriptor.getControlFilters().isEmpty()) {
                return;
            }
            this.mControlFilters = new ArrayList<>(mediaRouteDescriptor.mControlFilters);
        }

        public Builder setId(String str) {
            this.mBundle.putString("id", str);
            return this;
        }

        public Builder clearGroupMemberIds() {
            ArrayList<String> arrayList = this.mGroupMemberIds;
            if (arrayList == null) {
                this.mGroupMemberIds = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            return this;
        }

        public Builder addGroupMemberId(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("groupMemberId must not be empty");
            }
            if (this.mGroupMemberIds == null) {
                this.mGroupMemberIds = new ArrayList<>();
            }
            if (!this.mGroupMemberIds.contains(str)) {
                this.mGroupMemberIds.add(str);
            }
            return this;
        }

        public Builder addGroupMemberIds(Collection<String> collection) {
            if (collection == null) {
                throw new IllegalArgumentException("groupMemberIds must not be null");
            }
            if (!collection.isEmpty()) {
                for (String str : collection) {
                    addGroupMemberId(str);
                }
            }
            return this;
        }

        public Builder removeGroupMemberId(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("memberRouteId must not be empty");
            }
            ArrayList<String> arrayList = this.mGroupMemberIds;
            if (arrayList != null) {
                arrayList.remove(str);
            }
            return this;
        }

        public Builder setName(String str) {
            this.mBundle.putString("name", str);
            return this;
        }

        public Builder setDescription(String str) {
            this.mBundle.putString("status", str);
            return this;
        }

        public Builder setIconUri(Uri uri) {
            if (uri == null) {
                throw new IllegalArgumentException("iconUri must not be null");
            }
            this.mBundle.putString(MediaRouteDescriptor.KEY_ICON_URI, uri.toString());
            return this;
        }

        public Builder setEnabled(boolean z) {
            this.mBundle.putBoolean(MediaRouteDescriptor.KEY_ENABLED, z);
            return this;
        }

        public Builder setIsDynamicGroupRoute(boolean z) {
            this.mBundle.putBoolean(MediaRouteDescriptor.IS_DYNAMIC_GROUP_ROUTE, z);
            return this;
        }

        @Deprecated
        public Builder setConnecting(boolean z) {
            this.mBundle.putBoolean(MediaRouteDescriptor.KEY_CONNECTING, z);
            return this;
        }

        public Builder setConnectionState(int i) {
            this.mBundle.putInt(MediaRouteDescriptor.KEY_CONNECTION_STATE, i);
            return this;
        }

        public Builder setCanDisconnect(boolean z) {
            this.mBundle.putBoolean(MediaRouteDescriptor.KEY_CAN_DISCONNECT, z);
            return this;
        }

        public Builder setSettingsActivity(IntentSender intentSender) {
            this.mBundle.putParcelable(MediaRouteDescriptor.KEY_SETTINGS_INTENT, intentSender);
            return this;
        }

        public Builder addControlFilter(IntentFilter intentFilter) {
            if (intentFilter == null) {
                throw new IllegalArgumentException("filter must not be null");
            }
            if (this.mControlFilters == null) {
                this.mControlFilters = new ArrayList<>();
            }
            if (!this.mControlFilters.contains(intentFilter)) {
                this.mControlFilters.add(intentFilter);
            }
            return this;
        }

        public Builder addControlFilters(Collection<IntentFilter> collection) {
            if (collection == null) {
                throw new IllegalArgumentException("filters must not be null");
            }
            if (!collection.isEmpty()) {
                for (IntentFilter intentFilter : collection) {
                    addControlFilter(intentFilter);
                }
            }
            return this;
        }

        public Builder setPlaybackType(int i) {
            this.mBundle.putInt(MediaRouteDescriptor.KEY_PLAYBACK_TYPE, i);
            return this;
        }

        public Builder setPlaybackStream(int i) {
            this.mBundle.putInt(MediaRouteDescriptor.KEY_PLAYBACK_STREAM, i);
            return this;
        }

        public Builder setDeviceType(int i) {
            this.mBundle.putInt(MediaRouteDescriptor.KEY_DEVICE_TYPE, i);
            return this;
        }

        public Builder setVolume(int i) {
            this.mBundle.putInt("volume", i);
            return this;
        }

        public Builder setVolumeMax(int i) {
            this.mBundle.putInt(MediaRouteDescriptor.KEY_VOLUME_MAX, i);
            return this;
        }

        public Builder setVolumeHandling(int i) {
            this.mBundle.putInt(MediaRouteDescriptor.KEY_VOLUME_HANDLING, i);
            return this;
        }

        public Builder setPresentationDisplayId(int i) {
            this.mBundle.putInt(MediaRouteDescriptor.KEY_PRESENTATION_DISPLAY_ID, i);
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.mBundle.putBundle("extras", bundle);
            return this;
        }

        public Builder setMinClientVersion(int i) {
            this.mBundle.putInt(MediaRouteDescriptor.KEY_MIN_CLIENT_VERSION, i);
            return this;
        }

        public Builder setMaxClientVersion(int i) {
            this.mBundle.putInt(MediaRouteDescriptor.KEY_MAX_CLIENT_VERSION, i);
            return this;
        }

        public MediaRouteDescriptor build() {
            ArrayList<IntentFilter> arrayList = this.mControlFilters;
            if (arrayList != null) {
                this.mBundle.putParcelableArrayList(MediaRouteDescriptor.KEY_CONTROL_FILTERS, arrayList);
            }
            ArrayList<String> arrayList2 = this.mGroupMemberIds;
            if (arrayList2 != null) {
                this.mBundle.putStringArrayList(MediaRouteDescriptor.KEY_GROUP_MEMBER_IDS, arrayList2);
            }
            return new MediaRouteDescriptor(this.mBundle);
        }
    }
}
