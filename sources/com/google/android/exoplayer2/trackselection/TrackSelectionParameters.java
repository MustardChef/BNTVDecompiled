package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Ints;
import java.util.Collection;
import java.util.Locale;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes2.dex */
public class TrackSelectionParameters implements Bundleable {
    public static final Bundleable.Creator<TrackSelectionParameters> CREATOR;
    @Deprecated
    public static final TrackSelectionParameters DEFAULT;
    public static final TrackSelectionParameters DEFAULT_WITHOUT_CONTEXT;
    private static final int FIELD_DISABLED_TRACK_TYPE = 25;
    private static final int FIELD_FORCE_HIGHEST_SUPPORTED_BITRATE = 22;
    private static final int FIELD_FORCE_LOWEST_BITRATE = 21;
    private static final int FIELD_MAX_AUDIO_BITRATE = 19;
    private static final int FIELD_MAX_AUDIO_CHANNEL_COUNT = 18;
    private static final int FIELD_MAX_VIDEO_BITRATE = 9;
    private static final int FIELD_MAX_VIDEO_FRAMERATE = 8;
    private static final int FIELD_MAX_VIDEO_HEIGHT = 7;
    private static final int FIELD_MAX_VIDEO_WIDTH = 6;
    private static final int FIELD_MIN_VIDEO_BITRATE = 13;
    private static final int FIELD_MIN_VIDEO_FRAMERATE = 12;
    private static final int FIELD_MIN_VIDEO_HEIGHT = 11;
    private static final int FIELD_MIN_VIDEO_WIDTH = 10;
    private static final int FIELD_PREFERRED_AUDIO_LANGUAGES = 1;
    private static final int FIELD_PREFERRED_AUDIO_MIME_TYPES = 20;
    private static final int FIELD_PREFERRED_AUDIO_ROLE_FLAGS = 2;
    private static final int FIELD_PREFERRED_TEXT_LANGUAGES = 3;
    private static final int FIELD_PREFERRED_TEXT_ROLE_FLAGS = 4;
    private static final int FIELD_PREFERRED_VIDEO_MIMETYPES = 17;
    private static final int FIELD_SELECTION_OVERRIDE_KEYS = 23;
    private static final int FIELD_SELECTION_OVERRIDE_VALUES = 24;
    private static final int FIELD_SELECT_UNDETERMINED_TEXT_LANGUAGE = 5;
    private static final int FIELD_VIEWPORT_HEIGHT = 15;
    private static final int FIELD_VIEWPORT_ORIENTATION_MAY_CHANGE = 16;
    private static final int FIELD_VIEWPORT_WIDTH = 14;
    public final ImmutableSet<Integer> disabledTrackTypes;
    public final boolean forceHighestSupportedBitrate;
    public final boolean forceLowestBitrate;
    public final int maxAudioBitrate;
    public final int maxAudioChannelCount;
    public final int maxVideoBitrate;
    public final int maxVideoFrameRate;
    public final int maxVideoHeight;
    public final int maxVideoWidth;
    public final int minVideoBitrate;
    public final int minVideoFrameRate;
    public final int minVideoHeight;
    public final int minVideoWidth;
    public final ImmutableList<String> preferredAudioLanguages;
    public final ImmutableList<String> preferredAudioMimeTypes;
    public final int preferredAudioRoleFlags;
    public final ImmutableList<String> preferredTextLanguages;
    public final int preferredTextRoleFlags;
    public final ImmutableList<String> preferredVideoMimeTypes;
    public final boolean selectUndeterminedTextLanguage;
    public final TrackSelectionOverrides trackSelectionOverrides;
    public final int viewportHeight;
    public final boolean viewportOrientationMayChange;
    public final int viewportWidth;

    /* loaded from: classes2.dex */
    public static class Builder {
        private ImmutableSet<Integer> disabledTrackTypes;
        private boolean forceHighestSupportedBitrate;
        private boolean forceLowestBitrate;
        private int maxAudioBitrate;
        private int maxAudioChannelCount;
        private int maxVideoBitrate;
        private int maxVideoFrameRate;
        private int maxVideoHeight;
        private int maxVideoWidth;
        private int minVideoBitrate;
        private int minVideoFrameRate;
        private int minVideoHeight;
        private int minVideoWidth;
        private ImmutableList<String> preferredAudioLanguages;
        private ImmutableList<String> preferredAudioMimeTypes;
        private int preferredAudioRoleFlags;
        private ImmutableList<String> preferredTextLanguages;
        private int preferredTextRoleFlags;
        private ImmutableList<String> preferredVideoMimeTypes;
        private boolean selectUndeterminedTextLanguage;
        private TrackSelectionOverrides trackSelectionOverrides;
        private int viewportHeight;
        private boolean viewportOrientationMayChange;
        private int viewportWidth;

        @Deprecated
        public Builder() {
            this.maxVideoWidth = Integer.MAX_VALUE;
            this.maxVideoHeight = Integer.MAX_VALUE;
            this.maxVideoFrameRate = Integer.MAX_VALUE;
            this.maxVideoBitrate = Integer.MAX_VALUE;
            this.viewportWidth = Integer.MAX_VALUE;
            this.viewportHeight = Integer.MAX_VALUE;
            this.viewportOrientationMayChange = true;
            this.preferredVideoMimeTypes = ImmutableList.m295of();
            this.preferredAudioLanguages = ImmutableList.m295of();
            this.preferredAudioRoleFlags = 0;
            this.maxAudioChannelCount = Integer.MAX_VALUE;
            this.maxAudioBitrate = Integer.MAX_VALUE;
            this.preferredAudioMimeTypes = ImmutableList.m295of();
            this.preferredTextLanguages = ImmutableList.m295of();
            this.preferredTextRoleFlags = 0;
            this.selectUndeterminedTextLanguage = false;
            this.forceLowestBitrate = false;
            this.forceHighestSupportedBitrate = false;
            this.trackSelectionOverrides = TrackSelectionOverrides.EMPTY;
            this.disabledTrackTypes = ImmutableSet.m253of();
        }

        public Builder(Context context) {
            this();
            setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context);
            setViewportSizeToPhysicalDisplaySize(context, true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Builder(TrackSelectionParameters trackSelectionParameters) {
            init(trackSelectionParameters);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Builder(Bundle bundle) {
            this.maxVideoWidth = bundle.getInt(TrackSelectionParameters.keyForField(6), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.maxVideoWidth);
            this.maxVideoHeight = bundle.getInt(TrackSelectionParameters.keyForField(7), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.maxVideoHeight);
            this.maxVideoFrameRate = bundle.getInt(TrackSelectionParameters.keyForField(8), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.maxVideoFrameRate);
            this.maxVideoBitrate = bundle.getInt(TrackSelectionParameters.keyForField(9), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.maxVideoBitrate);
            this.minVideoWidth = bundle.getInt(TrackSelectionParameters.keyForField(10), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.minVideoWidth);
            this.minVideoHeight = bundle.getInt(TrackSelectionParameters.keyForField(11), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.minVideoHeight);
            this.minVideoFrameRate = bundle.getInt(TrackSelectionParameters.keyForField(12), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.minVideoFrameRate);
            this.minVideoBitrate = bundle.getInt(TrackSelectionParameters.keyForField(13), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.minVideoBitrate);
            this.viewportWidth = bundle.getInt(TrackSelectionParameters.keyForField(14), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.viewportWidth);
            this.viewportHeight = bundle.getInt(TrackSelectionParameters.keyForField(15), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.viewportHeight);
            this.viewportOrientationMayChange = bundle.getBoolean(TrackSelectionParameters.keyForField(16), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.viewportOrientationMayChange);
            this.preferredVideoMimeTypes = ImmutableList.copyOf((String[]) MoreObjects.firstNonNull(bundle.getStringArray(TrackSelectionParameters.keyForField(17)), new String[0]));
            this.preferredAudioLanguages = normalizeLanguageCodes((String[]) MoreObjects.firstNonNull(bundle.getStringArray(TrackSelectionParameters.keyForField(1)), new String[0]));
            this.preferredAudioRoleFlags = bundle.getInt(TrackSelectionParameters.keyForField(2), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.preferredAudioRoleFlags);
            this.maxAudioChannelCount = bundle.getInt(TrackSelectionParameters.keyForField(18), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.maxAudioChannelCount);
            this.maxAudioBitrate = bundle.getInt(TrackSelectionParameters.keyForField(19), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.maxAudioBitrate);
            this.preferredAudioMimeTypes = ImmutableList.copyOf((String[]) MoreObjects.firstNonNull(bundle.getStringArray(TrackSelectionParameters.keyForField(20)), new String[0]));
            this.preferredTextLanguages = normalizeLanguageCodes((String[]) MoreObjects.firstNonNull(bundle.getStringArray(TrackSelectionParameters.keyForField(3)), new String[0]));
            this.preferredTextRoleFlags = bundle.getInt(TrackSelectionParameters.keyForField(4), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.preferredTextRoleFlags);
            this.selectUndeterminedTextLanguage = bundle.getBoolean(TrackSelectionParameters.keyForField(5), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.selectUndeterminedTextLanguage);
            this.forceLowestBitrate = bundle.getBoolean(TrackSelectionParameters.keyForField(21), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.forceLowestBitrate);
            this.forceHighestSupportedBitrate = bundle.getBoolean(TrackSelectionParameters.keyForField(22), TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT.forceHighestSupportedBitrate);
            this.trackSelectionOverrides = (TrackSelectionOverrides) BundleableUtil.fromNullableBundle(TrackSelectionOverrides.CREATOR, bundle.getBundle(TrackSelectionParameters.keyForField(23)), TrackSelectionOverrides.EMPTY);
            this.disabledTrackTypes = ImmutableSet.copyOf((Collection) Ints.asList((int[]) MoreObjects.firstNonNull(bundle.getIntArray(TrackSelectionParameters.keyForField(25)), new int[0])));
        }

        @EnsuresNonNull({"preferredVideoMimeTypes", "preferredAudioLanguages", "preferredAudioMimeTypes", "preferredTextLanguages", "trackSelectionOverrides", "disabledTrackTypes"})
        private void init(TrackSelectionParameters trackSelectionParameters) {
            this.maxVideoWidth = trackSelectionParameters.maxVideoWidth;
            this.maxVideoHeight = trackSelectionParameters.maxVideoHeight;
            this.maxVideoFrameRate = trackSelectionParameters.maxVideoFrameRate;
            this.maxVideoBitrate = trackSelectionParameters.maxVideoBitrate;
            this.minVideoWidth = trackSelectionParameters.minVideoWidth;
            this.minVideoHeight = trackSelectionParameters.minVideoHeight;
            this.minVideoFrameRate = trackSelectionParameters.minVideoFrameRate;
            this.minVideoBitrate = trackSelectionParameters.minVideoBitrate;
            this.viewportWidth = trackSelectionParameters.viewportWidth;
            this.viewportHeight = trackSelectionParameters.viewportHeight;
            this.viewportOrientationMayChange = trackSelectionParameters.viewportOrientationMayChange;
            this.preferredVideoMimeTypes = trackSelectionParameters.preferredVideoMimeTypes;
            this.preferredAudioLanguages = trackSelectionParameters.preferredAudioLanguages;
            this.preferredAudioRoleFlags = trackSelectionParameters.preferredAudioRoleFlags;
            this.maxAudioChannelCount = trackSelectionParameters.maxAudioChannelCount;
            this.maxAudioBitrate = trackSelectionParameters.maxAudioBitrate;
            this.preferredAudioMimeTypes = trackSelectionParameters.preferredAudioMimeTypes;
            this.preferredTextLanguages = trackSelectionParameters.preferredTextLanguages;
            this.preferredTextRoleFlags = trackSelectionParameters.preferredTextRoleFlags;
            this.selectUndeterminedTextLanguage = trackSelectionParameters.selectUndeterminedTextLanguage;
            this.forceLowestBitrate = trackSelectionParameters.forceLowestBitrate;
            this.forceHighestSupportedBitrate = trackSelectionParameters.forceHighestSupportedBitrate;
            this.trackSelectionOverrides = trackSelectionParameters.trackSelectionOverrides;
            this.disabledTrackTypes = trackSelectionParameters.disabledTrackTypes;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Builder set(TrackSelectionParameters trackSelectionParameters) {
            init(trackSelectionParameters);
            return this;
        }

        public Builder setMaxVideoSizeSd() {
            return setMaxVideoSize(AdaptiveTrackSelection.DEFAULT_MAX_WIDTH_TO_DISCARD, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD);
        }

        public Builder clearVideoSizeConstraints() {
            return setMaxVideoSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        public Builder setMaxVideoSize(int i, int i2) {
            this.maxVideoWidth = i;
            this.maxVideoHeight = i2;
            return this;
        }

        public Builder setMaxVideoFrameRate(int i) {
            this.maxVideoFrameRate = i;
            return this;
        }

        public Builder setMaxVideoBitrate(int i) {
            this.maxVideoBitrate = i;
            return this;
        }

        public Builder setMinVideoSize(int i, int i2) {
            this.minVideoWidth = i;
            this.minVideoHeight = i2;
            return this;
        }

        public Builder setMinVideoFrameRate(int i) {
            this.minVideoFrameRate = i;
            return this;
        }

        public Builder setMinVideoBitrate(int i) {
            this.minVideoBitrate = i;
            return this;
        }

        public Builder setViewportSizeToPhysicalDisplaySize(Context context, boolean z) {
            Point currentDisplayModeSize = Util.getCurrentDisplayModeSize(context);
            return setViewportSize(currentDisplayModeSize.x, currentDisplayModeSize.y, z);
        }

        public Builder clearViewportSizeConstraints() {
            return setViewportSize(Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public Builder setViewportSize(int i, int i2, boolean z) {
            this.viewportWidth = i;
            this.viewportHeight = i2;
            this.viewportOrientationMayChange = z;
            return this;
        }

        public Builder setPreferredVideoMimeType(String str) {
            return str == null ? setPreferredVideoMimeTypes(new String[0]) : setPreferredVideoMimeTypes(str);
        }

        public Builder setPreferredVideoMimeTypes(String... strArr) {
            this.preferredVideoMimeTypes = ImmutableList.copyOf(strArr);
            return this;
        }

        public Builder setPreferredAudioLanguage(String str) {
            if (str == null) {
                return setPreferredAudioLanguages(new String[0]);
            }
            return setPreferredAudioLanguages(str);
        }

        public Builder setPreferredAudioLanguages(String... strArr) {
            this.preferredAudioLanguages = normalizeLanguageCodes(strArr);
            return this;
        }

        public Builder setPreferredAudioRoleFlags(int i) {
            this.preferredAudioRoleFlags = i;
            return this;
        }

        public Builder setMaxAudioChannelCount(int i) {
            this.maxAudioChannelCount = i;
            return this;
        }

        public Builder setMaxAudioBitrate(int i) {
            this.maxAudioBitrate = i;
            return this;
        }

        public Builder setPreferredAudioMimeType(String str) {
            return str == null ? setPreferredAudioMimeTypes(new String[0]) : setPreferredAudioMimeTypes(str);
        }

        public Builder setPreferredAudioMimeTypes(String... strArr) {
            this.preferredAudioMimeTypes = ImmutableList.copyOf(strArr);
            return this;
        }

        public Builder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context) {
            if (Util.SDK_INT >= 19) {
                m391x58dbf263(context);
            }
            return this;
        }

        public Builder setPreferredTextLanguage(String str) {
            if (str == null) {
                return setPreferredTextLanguages(new String[0]);
            }
            return setPreferredTextLanguages(str);
        }

        public Builder setPreferredTextLanguages(String... strArr) {
            this.preferredTextLanguages = normalizeLanguageCodes(strArr);
            return this;
        }

        public Builder setPreferredTextRoleFlags(int i) {
            this.preferredTextRoleFlags = i;
            return this;
        }

        public Builder setSelectUndeterminedTextLanguage(boolean z) {
            this.selectUndeterminedTextLanguage = z;
            return this;
        }

        public Builder setForceLowestBitrate(boolean z) {
            this.forceLowestBitrate = z;
            return this;
        }

        public Builder setForceHighestSupportedBitrate(boolean z) {
            this.forceHighestSupportedBitrate = z;
            return this;
        }

        public Builder setTrackSelectionOverrides(TrackSelectionOverrides trackSelectionOverrides) {
            this.trackSelectionOverrides = trackSelectionOverrides;
            return this;
        }

        public Builder setDisabledTrackTypes(Set<Integer> set) {
            this.disabledTrackTypes = ImmutableSet.copyOf((Collection) set);
            return this;
        }

        public TrackSelectionParameters build() {
            return new TrackSelectionParameters(this);
        }

        /* renamed from: setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettingsV19 */
        private void m391x58dbf263(Context context) {
            CaptioningManager captioningManager;
            if ((Util.SDK_INT >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.preferredTextRoleFlags = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.preferredTextLanguages = ImmutableList.m294of(Util.getLocaleLanguageTag(locale));
                }
            }
        }

        private static ImmutableList<String> normalizeLanguageCodes(String[] strArr) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (String str : (String[]) Assertions.checkNotNull(strArr)) {
                builder.add((ImmutableList.Builder) Util.normalizeLanguageCode((String) Assertions.checkNotNull(str)));
            }
            return builder.build();
        }
    }

    static {
        TrackSelectionParameters build = new Builder().build();
        DEFAULT_WITHOUT_CONTEXT = build;
        DEFAULT = build;
        CREATOR = $$Lambda$TrackSelectionParameters$7IqjqdFhkNWmWIJyOMUsGWPS58k.INSTANCE;
    }

    public static TrackSelectionParameters getDefaults(Context context) {
        return new Builder(context).build();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TrackSelectionParameters(Builder builder) {
        this.maxVideoWidth = builder.maxVideoWidth;
        this.maxVideoHeight = builder.maxVideoHeight;
        this.maxVideoFrameRate = builder.maxVideoFrameRate;
        this.maxVideoBitrate = builder.maxVideoBitrate;
        this.minVideoWidth = builder.minVideoWidth;
        this.minVideoHeight = builder.minVideoHeight;
        this.minVideoFrameRate = builder.minVideoFrameRate;
        this.minVideoBitrate = builder.minVideoBitrate;
        this.viewportWidth = builder.viewportWidth;
        this.viewportHeight = builder.viewportHeight;
        this.viewportOrientationMayChange = builder.viewportOrientationMayChange;
        this.preferredVideoMimeTypes = builder.preferredVideoMimeTypes;
        this.preferredAudioLanguages = builder.preferredAudioLanguages;
        this.preferredAudioRoleFlags = builder.preferredAudioRoleFlags;
        this.maxAudioChannelCount = builder.maxAudioChannelCount;
        this.maxAudioBitrate = builder.maxAudioBitrate;
        this.preferredAudioMimeTypes = builder.preferredAudioMimeTypes;
        this.preferredTextLanguages = builder.preferredTextLanguages;
        this.preferredTextRoleFlags = builder.preferredTextRoleFlags;
        this.selectUndeterminedTextLanguage = builder.selectUndeterminedTextLanguage;
        this.forceLowestBitrate = builder.forceLowestBitrate;
        this.forceHighestSupportedBitrate = builder.forceHighestSupportedBitrate;
        this.trackSelectionOverrides = builder.trackSelectionOverrides;
        this.disabledTrackTypes = builder.disabledTrackTypes;
    }

    public Builder buildUpon() {
        return new Builder(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters) obj;
        return this.maxVideoWidth == trackSelectionParameters.maxVideoWidth && this.maxVideoHeight == trackSelectionParameters.maxVideoHeight && this.maxVideoFrameRate == trackSelectionParameters.maxVideoFrameRate && this.maxVideoBitrate == trackSelectionParameters.maxVideoBitrate && this.minVideoWidth == trackSelectionParameters.minVideoWidth && this.minVideoHeight == trackSelectionParameters.minVideoHeight && this.minVideoFrameRate == trackSelectionParameters.minVideoFrameRate && this.minVideoBitrate == trackSelectionParameters.minVideoBitrate && this.viewportOrientationMayChange == trackSelectionParameters.viewportOrientationMayChange && this.viewportWidth == trackSelectionParameters.viewportWidth && this.viewportHeight == trackSelectionParameters.viewportHeight && this.preferredVideoMimeTypes.equals(trackSelectionParameters.preferredVideoMimeTypes) && this.preferredAudioLanguages.equals(trackSelectionParameters.preferredAudioLanguages) && this.preferredAudioRoleFlags == trackSelectionParameters.preferredAudioRoleFlags && this.maxAudioChannelCount == trackSelectionParameters.maxAudioChannelCount && this.maxAudioBitrate == trackSelectionParameters.maxAudioBitrate && this.preferredAudioMimeTypes.equals(trackSelectionParameters.preferredAudioMimeTypes) && this.preferredTextLanguages.equals(trackSelectionParameters.preferredTextLanguages) && this.preferredTextRoleFlags == trackSelectionParameters.preferredTextRoleFlags && this.selectUndeterminedTextLanguage == trackSelectionParameters.selectUndeterminedTextLanguage && this.forceLowestBitrate == trackSelectionParameters.forceLowestBitrate && this.forceHighestSupportedBitrate == trackSelectionParameters.forceHighestSupportedBitrate && this.trackSelectionOverrides.equals(trackSelectionParameters.trackSelectionOverrides) && this.disabledTrackTypes.equals(trackSelectionParameters.disabledTrackTypes);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((this.maxVideoWidth + 31) * 31) + this.maxVideoHeight) * 31) + this.maxVideoFrameRate) * 31) + this.maxVideoBitrate) * 31) + this.minVideoWidth) * 31) + this.minVideoHeight) * 31) + this.minVideoFrameRate) * 31) + this.minVideoBitrate) * 31) + (this.viewportOrientationMayChange ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight) * 31) + this.preferredVideoMimeTypes.hashCode()) * 31) + this.preferredAudioLanguages.hashCode()) * 31) + this.preferredAudioRoleFlags) * 31) + this.maxAudioChannelCount) * 31) + this.maxAudioBitrate) * 31) + this.preferredAudioMimeTypes.hashCode()) * 31) + this.preferredTextLanguages.hashCode()) * 31) + this.preferredTextRoleFlags) * 31) + (this.selectUndeterminedTextLanguage ? 1 : 0)) * 31) + (this.forceLowestBitrate ? 1 : 0)) * 31) + (this.forceHighestSupportedBitrate ? 1 : 0)) * 31) + this.trackSelectionOverrides.hashCode()) * 31) + this.disabledTrackTypes.hashCode();
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(keyForField(6), this.maxVideoWidth);
        bundle.putInt(keyForField(7), this.maxVideoHeight);
        bundle.putInt(keyForField(8), this.maxVideoFrameRate);
        bundle.putInt(keyForField(9), this.maxVideoBitrate);
        bundle.putInt(keyForField(10), this.minVideoWidth);
        bundle.putInt(keyForField(11), this.minVideoHeight);
        bundle.putInt(keyForField(12), this.minVideoFrameRate);
        bundle.putInt(keyForField(13), this.minVideoBitrate);
        bundle.putInt(keyForField(14), this.viewportWidth);
        bundle.putInt(keyForField(15), this.viewportHeight);
        bundle.putBoolean(keyForField(16), this.viewportOrientationMayChange);
        bundle.putStringArray(keyForField(17), (String[]) this.preferredVideoMimeTypes.toArray(new String[0]));
        bundle.putStringArray(keyForField(1), (String[]) this.preferredAudioLanguages.toArray(new String[0]));
        bundle.putInt(keyForField(2), this.preferredAudioRoleFlags);
        bundle.putInt(keyForField(18), this.maxAudioChannelCount);
        bundle.putInt(keyForField(19), this.maxAudioBitrate);
        bundle.putStringArray(keyForField(20), (String[]) this.preferredAudioMimeTypes.toArray(new String[0]));
        bundle.putStringArray(keyForField(3), (String[]) this.preferredTextLanguages.toArray(new String[0]));
        bundle.putInt(keyForField(4), this.preferredTextRoleFlags);
        bundle.putBoolean(keyForField(5), this.selectUndeterminedTextLanguage);
        bundle.putBoolean(keyForField(21), this.forceLowestBitrate);
        bundle.putBoolean(keyForField(22), this.forceHighestSupportedBitrate);
        bundle.putBundle(keyForField(23), this.trackSelectionOverrides.toBundle());
        bundle.putIntArray(keyForField(25), Ints.toArray(this.disabledTrackTypes));
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String keyForField(int i) {
        return Integer.toString(i, 36);
    }
}
