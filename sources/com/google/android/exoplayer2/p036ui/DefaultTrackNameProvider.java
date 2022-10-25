package com.google.android.exoplayer2.p036ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.Locale;

/* renamed from: com.google.android.exoplayer2.ui.DefaultTrackNameProvider */
/* loaded from: classes2.dex */
public class DefaultTrackNameProvider implements TrackNameProvider {
    private final Resources resources;

    public DefaultTrackNameProvider(Resources resources) {
        this.resources = (Resources) Assertions.checkNotNull(resources);
    }

    @Override // com.google.android.exoplayer2.p036ui.TrackNameProvider
    public String getTrackName(Format format) {
        String buildLanguageOrLabelString;
        int inferPrimaryTrackType = inferPrimaryTrackType(format);
        if (inferPrimaryTrackType == 2) {
            buildLanguageOrLabelString = joinWithSeparator(buildRoleString(format), buildResolutionString(format), buildBitrateString(format));
        } else if (inferPrimaryTrackType == 1) {
            buildLanguageOrLabelString = joinWithSeparator(buildLanguageOrLabelString(format), buildAudioChannelString(format), buildBitrateString(format));
        } else {
            buildLanguageOrLabelString = buildLanguageOrLabelString(format);
        }
        return buildLanguageOrLabelString.length() == 0 ? this.resources.getString(C3559R.string.exo_track_unknown) : buildLanguageOrLabelString;
    }

    private String buildResolutionString(Format format) {
        int i = format.width;
        int i2 = format.height;
        return (i == -1 || i2 == -1) ? "" : this.resources.getString(C3559R.string.exo_track_resolution, Integer.valueOf(i), Integer.valueOf(i2));
    }

    private String buildBitrateString(Format format) {
        int i = format.bitrate;
        return i == -1 ? "" : this.resources.getString(C3559R.string.exo_track_bitrate, Float.valueOf(i / 1000000.0f));
    }

    private String buildAudioChannelString(Format format) {
        int i = format.channelCount;
        if (i == -1 || i < 1) {
            return "";
        }
        if (i != 1) {
            if (i != 2) {
                if (i == 6 || i == 7) {
                    return this.resources.getString(C3559R.string.exo_track_surround_5_point_1);
                }
                if (i == 8) {
                    return this.resources.getString(C3559R.string.exo_track_surround_7_point_1);
                }
                return this.resources.getString(C3559R.string.exo_track_surround);
            }
            return this.resources.getString(C3559R.string.exo_track_stereo);
        }
        return this.resources.getString(C3559R.string.exo_track_mono);
    }

    private String buildLanguageOrLabelString(Format format) {
        String joinWithSeparator = joinWithSeparator(buildLanguageString(format), buildRoleString(format));
        return TextUtils.isEmpty(joinWithSeparator) ? buildLabelString(format) : joinWithSeparator;
    }

    private String buildLabelString(Format format) {
        return TextUtils.isEmpty(format.label) ? "" : format.label;
    }

    private String buildLanguageString(Format format) {
        String str = format.language;
        if (TextUtils.isEmpty(str) || C3282C.LANGUAGE_UNDETERMINED.equals(str)) {
            return "";
        }
        Locale forLanguageTag = Util.SDK_INT >= 21 ? Locale.forLanguageTag(str) : new Locale(str);
        Locale defaultDisplayLocale = Util.getDefaultDisplayLocale();
        String displayName = forLanguageTag.getDisplayName(defaultDisplayLocale);
        if (TextUtils.isEmpty(displayName)) {
            return "";
        }
        try {
            int offsetByCodePoints = displayName.offsetByCodePoints(0, 1);
            String valueOf = String.valueOf(displayName.substring(0, offsetByCodePoints).toUpperCase(defaultDisplayLocale));
            String valueOf2 = String.valueOf(displayName.substring(offsetByCodePoints));
            displayName = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        } catch (IndexOutOfBoundsException unused) {
        }
        return displayName;
    }

    private String buildRoleString(Format format) {
        String string = (format.roleFlags & 2) != 0 ? this.resources.getString(C3559R.string.exo_track_role_alternate) : "";
        if ((format.roleFlags & 4) != 0) {
            string = joinWithSeparator(string, this.resources.getString(C3559R.string.exo_track_role_supplementary));
        }
        if ((format.roleFlags & 8) != 0) {
            string = joinWithSeparator(string, this.resources.getString(C3559R.string.exo_track_role_commentary));
        }
        return (format.roleFlags & 1088) != 0 ? joinWithSeparator(string, this.resources.getString(C3559R.string.exo_track_role_closed_captions)) : string;
    }

    private String joinWithSeparator(String... strArr) {
        String str = "";
        for (String str2 : strArr) {
            if (str2.length() > 0) {
                str = TextUtils.isEmpty(str) ? str2 : this.resources.getString(C3559R.string.exo_item_list, str, str2);
            }
        }
        return str;
    }

    private static int inferPrimaryTrackType(Format format) {
        int trackType = MimeTypes.getTrackType(format.sampleMimeType);
        if (trackType != -1) {
            return trackType;
        }
        if (MimeTypes.getVideoMediaMimeType(format.codecs) != null) {
            return 2;
        }
        if (MimeTypes.getAudioMediaMimeType(format.codecs) != null) {
            return 1;
        }
        if (format.width == -1 && format.height == -1) {
            return (format.channelCount == -1 && format.sampleRate == -1) ? -1 : 1;
        }
        return 2;
    }
}
