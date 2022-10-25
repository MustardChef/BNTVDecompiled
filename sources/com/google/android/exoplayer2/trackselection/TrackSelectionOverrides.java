package com.google.android.exoplayer2.trackselection;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.Ints;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class TrackSelectionOverrides implements Bundleable {
    private static final int FIELD_OVERRIDES = 0;
    private final ImmutableMap<TrackGroup, TrackSelectionOverride> overrides;
    public static final TrackSelectionOverrides EMPTY = new TrackSelectionOverrides(ImmutableMap.m276of());
    public static final Bundleable.Creator<TrackSelectionOverrides> CREATOR = $$Lambda$TrackSelectionOverrides$HcdyYnvjsiamDg1GuS5kTmTk2XM.INSTANCE;

    /* loaded from: classes2.dex */
    public static final class Builder {
        private final HashMap<TrackGroup, TrackSelectionOverride> overrides;

        public Builder() {
            this.overrides = new HashMap<>();
        }

        private Builder(Map<TrackGroup, TrackSelectionOverride> map) {
            this.overrides = new HashMap<>(map);
        }

        public Builder addOverride(TrackSelectionOverride trackSelectionOverride) {
            this.overrides.put(trackSelectionOverride.trackGroup, trackSelectionOverride);
            return this;
        }

        public Builder clearOverride(TrackGroup trackGroup) {
            this.overrides.remove(trackGroup);
            return this;
        }

        public Builder setOverrideForType(TrackSelectionOverride trackSelectionOverride) {
            clearOverridesOfType(trackSelectionOverride.getTrackType());
            this.overrides.put(trackSelectionOverride.trackGroup, trackSelectionOverride);
            return this;
        }

        public Builder clearOverridesOfType(int i) {
            Iterator<TrackSelectionOverride> it = this.overrides.values().iterator();
            while (it.hasNext()) {
                if (it.next().getTrackType() == i) {
                    it.remove();
                }
            }
            return this;
        }

        public TrackSelectionOverrides build() {
            return new TrackSelectionOverrides(this.overrides);
        }
    }

    /* loaded from: classes2.dex */
    public static final class TrackSelectionOverride implements Bundleable {
        public static final Bundleable.Creator<TrackSelectionOverride> CREATOR = C3519x190fa46d.INSTANCE;
        private static final int FIELD_TRACKS = 1;
        private static final int FIELD_TRACK_GROUP = 0;
        public final TrackGroup trackGroup;
        public final ImmutableList<Integer> trackIndices;

        public TrackSelectionOverride(TrackGroup trackGroup) {
            this.trackGroup = trackGroup;
            ImmutableList.Builder builder = new ImmutableList.Builder();
            for (int i = 0; i < trackGroup.length; i++) {
                builder.add((ImmutableList.Builder) Integer.valueOf(i));
            }
            this.trackIndices = builder.build();
        }

        public TrackSelectionOverride(TrackGroup trackGroup, List<Integer> list) {
            if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= trackGroup.length)) {
                throw new IndexOutOfBoundsException();
            }
            this.trackGroup = trackGroup;
            this.trackIndices = ImmutableList.copyOf((Collection) list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) obj;
            return this.trackGroup.equals(trackSelectionOverride.trackGroup) && this.trackIndices.equals(trackSelectionOverride.trackIndices);
        }

        public int hashCode() {
            return this.trackGroup.hashCode() + (this.trackIndices.hashCode() * 31);
        }

        public int getTrackType() {
            return MimeTypes.getTrackType(this.trackGroup.getFormat(0).sampleMimeType);
        }

        @Override // com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putBundle(keyForField(0), this.trackGroup.toBundle());
            bundle.putIntArray(keyForField(1), Ints.toArray(this.trackIndices));
            return bundle;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ TrackSelectionOverride lambda$static$0(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle(keyForField(0));
            Assertions.checkNotNull(bundle2);
            TrackGroup fromBundle = TrackGroup.CREATOR.fromBundle(bundle2);
            int[] intArray = bundle.getIntArray(keyForField(1));
            if (intArray == null) {
                return new TrackSelectionOverride(fromBundle);
            }
            return new TrackSelectionOverride(fromBundle, Ints.asList(intArray));
        }

        private static String keyForField(int i) {
            return Integer.toString(i, 36);
        }
    }

    private TrackSelectionOverrides(Map<TrackGroup, TrackSelectionOverride> map) {
        this.overrides = ImmutableMap.copyOf((Map) map);
    }

    public Builder buildUpon() {
        return new Builder(this.overrides);
    }

    public ImmutableList<TrackSelectionOverride> asList() {
        return ImmutableList.copyOf((Collection) this.overrides.values());
    }

    public TrackSelectionOverride getOverride(TrackGroup trackGroup) {
        return this.overrides.get(trackGroup);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.overrides.equals(((TrackSelectionOverrides) obj).overrides);
    }

    public int hashCode() {
        return this.overrides.hashCode();
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(keyForField(0), BundleableUtil.toBundleArrayList(this.overrides.values()));
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TrackSelectionOverrides lambda$static$0(Bundle bundle) {
        List fromBundleNullableList = BundleableUtil.fromBundleNullableList(TrackSelectionOverride.CREATOR, bundle.getParcelableArrayList(keyForField(0)), ImmutableList.m295of());
        ImmutableMap.Builder builder = new ImmutableMap.Builder();
        for (int i = 0; i < fromBundleNullableList.size(); i++) {
            TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) fromBundleNullableList.get(i);
            builder.put(trackSelectionOverride.trackGroup, trackSelectionOverride);
        }
        return new TrackSelectionOverrides(builder.build());
    }

    private static String keyForField(int i) {
        return Integer.toString(i, 36);
    }
}
