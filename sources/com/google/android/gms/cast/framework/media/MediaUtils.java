package com.google.android.gms.cast.framework.media;

import android.net.Uri;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public class MediaUtils {
    private MediaUtils() {
    }

    public static Uri getImageUri(MediaInfo mediaInfo, int i) {
        MediaMetadata metadata;
        if (mediaInfo == null || (metadata = mediaInfo.getMetadata()) == null || metadata.getImages() == null || metadata.getImages().size() <= i) {
            return null;
        }
        return metadata.getImages().get(i).getUrl();
    }

    public static String getImageUrl(MediaInfo mediaInfo, int i) {
        Uri imageUri = getImageUri(mediaInfo, i);
        if (imageUri == null) {
            return null;
        }
        return imageUri.toString();
    }

    @Deprecated
    public static Locale getTrackLanguage(MediaTrack mediaTrack) {
        String language = mediaTrack.getLanguage();
        if (language != null) {
            if (PlatformVersion.isAtLeastLollipop()) {
                return Locale.forLanguageTag(language);
            }
            String[] split = language.split("-");
            if (split.length == 1) {
                return new Locale(split[0]);
            }
            return new Locale(split[0], split[1]);
        }
        return null;
    }
}
