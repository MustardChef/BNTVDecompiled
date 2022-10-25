package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Booleans;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public final class TracksInfo implements Bundleable {
    private static final int FIELD_TRACK_GROUP_INFOS = 0;
    private final ImmutableList<TrackGroupInfo> trackGroupInfos;
    public static final TracksInfo EMPTY = new TracksInfo(ImmutableList.m295of());
    public static final Bundleable.Creator<TracksInfo> CREATOR = $$Lambda$TracksInfo$Ny0exJr17o12WevQtALIedKavVs.INSTANCE;

    /* loaded from: classes2.dex */
    public static final class TrackGroupInfo implements Bundleable {
        public static final Bundleable.Creator<TrackGroupInfo> CREATOR = $$Lambda$TracksInfo$TrackGroupInfo$D4ofyCIaHIGAOxMGv6TYCYOcbYI.INSTANCE;
        private static final int FIELD_TRACK_GROUP = 0;
        private static final int FIELD_TRACK_SELECTED = 3;
        private static final int FIELD_TRACK_SUPPORT = 1;
        private static final int FIELD_TRACK_TYPE = 2;
        private final TrackGroup trackGroup;
        private final boolean[] trackSelected;
        private final int[] trackSupport;
        private final int trackType;

        public TrackGroupInfo(TrackGroup trackGroup, int[] iArr, int i, boolean[] zArr) {
            int i2 = trackGroup.length;
            Assertions.checkArgument(i2 == iArr.length && i2 == zArr.length);
            this.trackGroup = trackGroup;
            this.trackSupport = (int[]) iArr.clone();
            this.trackType = i;
            this.trackSelected = (boolean[]) zArr.clone();
        }

        public TrackGroup getTrackGroup() {
            return this.trackGroup;
        }

        public int getTrackSupport(int i) {
            return this.trackSupport[i];
        }

        public boolean isTrackSupported(int i) {
            return this.trackSupport[i] == 4;
        }

        public boolean isSelected() {
            return Booleans.contains(this.trackSelected, true);
        }

        public boolean isSupported() {
            for (int i = 0; i < this.trackSupport.length; i++) {
                if (isTrackSupported(i)) {
                    return true;
                }
            }
            return false;
        }

        public boolean isTrackSelected(int i) {
            return this.trackSelected[i];
        }

        public int getTrackType() {
            return this.trackType;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            TrackGroupInfo trackGroupInfo = (TrackGroupInfo) obj;
            return this.trackType == trackGroupInfo.trackType && this.trackGroup.equals(trackGroupInfo.trackGroup) && Arrays.equals(this.trackSupport, trackGroupInfo.trackSupport) && Arrays.equals(this.trackSelected, trackGroupInfo.trackSelected);
        }

        public int hashCode() {
            return (((((this.trackGroup.hashCode() * 31) + Arrays.hashCode(this.trackSupport)) * 31) + this.trackType) * 31) + Arrays.hashCode(this.trackSelected);
        }

        @Override // com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putBundle(keyForField(0), this.trackGroup.toBundle());
            bundle.putIntArray(keyForField(1), this.trackSupport);
            bundle.putInt(keyForField(2), this.trackType);
            bundle.putBooleanArray(keyForField(3), this.trackSelected);
            return bundle;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ TrackGroupInfo lambda$static$0(Bundle bundle) {
            TrackGroup trackGroup = (TrackGroup) BundleableUtil.fromNullableBundle(TrackGroup.CREATOR, bundle.getBundle(keyForField(0)));
            Assertions.checkNotNull(trackGroup);
            return new TrackGroupInfo(trackGroup, (int[]) MoreObjects.firstNonNull(bundle.getIntArray(keyForField(1)), new int[trackGroup.length]), bundle.getInt(keyForField(2), -1), (boolean[]) MoreObjects.firstNonNull(bundle.getBooleanArray(keyForField(3)), new boolean[trackGroup.length]));
        }

        private static String keyForField(int i) {
            return Integer.toString(i, 36);
        }
    }

    public TracksInfo(List<TrackGroupInfo> list) {
        this.trackGroupInfos = ImmutableList.copyOf((Collection) list);
    }

    public ImmutableList<TrackGroupInfo> getTrackGroupInfos() {
        return this.trackGroupInfos;
    }

    public boolean isTypeSupportedOrEmpty(int i) {
        boolean z = true;
        for (int i2 = 0; i2 < this.trackGroupInfos.size(); i2++) {
            if (this.trackGroupInfos.get(i2).trackType == i) {
                if (this.trackGroupInfos.get(i2).isSupported()) {
                    return true;
                }
                z = false;
            }
        }
        return z;
    }

    public boolean isTypeSelected(int i) {
        for (int i2 = 0; i2 < this.trackGroupInfos.size(); i2++) {
            TrackGroupInfo trackGroupInfo = this.trackGroupInfos.get(i2);
            if (trackGroupInfo.isSelected() && trackGroupInfo.getTrackType() == i) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.trackGroupInfos.equals(((TracksInfo) obj).trackGroupInfos);
    }

    public int hashCode() {
        return this.trackGroupInfos.hashCode();
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(keyForField(0), BundleableUtil.toBundleArrayList(this.trackGroupInfos));
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TracksInfo lambda$static$0(Bundle bundle) {
        return new TracksInfo(BundleableUtil.fromBundleNullableList(TrackGroupInfo.CREATOR, bundle.getParcelableArrayList(keyForField(0)), ImmutableList.m295of()));
    }

    private static String keyForField(int i) {
        return Integer.toString(i, 36);
    }
}
