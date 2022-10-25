package com.google.android.exoplayer2.ext.cast;

import android.net.Uri;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaQueueItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class DefaultMediaItemConverter implements MediaItemConverter {
    private static final String KEY_DRM_CONFIGURATION = "drmConfiguration";
    private static final String KEY_LICENSE_URI = "licenseUri";
    private static final String KEY_MEDIA_ITEM = "mediaItem";
    private static final String KEY_MIME_TYPE = "mimeType";
    private static final String KEY_PLAYER_CONFIG = "exoPlayerConfig";
    private static final String KEY_REQUEST_HEADERS = "requestHeaders";
    private static final String KEY_TITLE = "title";
    private static final String KEY_URI = "uri";
    private static final String KEY_UUID = "uuid";

    @Override // com.google.android.exoplayer2.ext.cast.MediaItemConverter
    public MediaItem toMediaItem(MediaQueueItem mediaQueueItem) {
        MediaInfo media = mediaQueueItem.getMedia();
        Assertions.checkNotNull(media);
        return getMediaItem((JSONObject) Assertions.checkNotNull(media.getCustomData()));
    }

    @Override // com.google.android.exoplayer2.ext.cast.MediaItemConverter
    public MediaQueueItem toMediaQueueItem(MediaItem mediaItem) {
        Assertions.checkNotNull(mediaItem.localConfiguration);
        if (mediaItem.localConfiguration.mimeType == null) {
            throw new IllegalArgumentException("The item must specify its mimeType");
        }
        MediaMetadata mediaMetadata = new MediaMetadata(1);
        if (mediaItem.mediaMetadata.title != null) {
            mediaMetadata.putString(MediaMetadata.KEY_TITLE, mediaItem.mediaMetadata.title.toString());
        }
        return new MediaQueueItem.Builder(new MediaInfo.Builder(mediaItem.localConfiguration.uri.toString()).setStreamType(1).setContentType(mediaItem.localConfiguration.mimeType).setMetadata(mediaMetadata).setCustomData(getCustomData(mediaItem)).build()).build();
    }

    private static MediaItem getMediaItem(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(KEY_MEDIA_ITEM);
            MediaItem.Builder builder = new MediaItem.Builder();
            builder.setUri(Uri.parse(jSONObject2.getString("uri")));
            if (jSONObject2.has("title")) {
                builder.setMediaMetadata(new MediaMetadata.Builder().setTitle(jSONObject2.getString("title")).build());
            }
            if (jSONObject2.has(KEY_MIME_TYPE)) {
                builder.setMimeType(jSONObject2.getString(KEY_MIME_TYPE));
            }
            if (jSONObject2.has(KEY_DRM_CONFIGURATION)) {
                populateDrmConfiguration(jSONObject2.getJSONObject(KEY_DRM_CONFIGURATION), builder);
            }
            return builder.build();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static void populateDrmConfiguration(JSONObject jSONObject, MediaItem.Builder builder) throws JSONException {
        MediaItem.DrmConfiguration.Builder licenseUri = new MediaItem.DrmConfiguration.Builder(UUID.fromString(jSONObject.getString(KEY_UUID))).setLicenseUri(jSONObject.getString(KEY_LICENSE_URI));
        JSONObject jSONObject2 = jSONObject.getJSONObject(KEY_REQUEST_HEADERS);
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject2.getString(next));
        }
        licenseUri.setLicenseRequestHeaders(hashMap);
        builder.setDrmConfiguration(licenseUri.build());
    }

    private static JSONObject getCustomData(MediaItem mediaItem) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_MEDIA_ITEM, getMediaItemJson(mediaItem));
            JSONObject playerConfigJson = getPlayerConfigJson(mediaItem);
            if (playerConfigJson != null) {
                jSONObject.put(KEY_PLAYER_CONFIG, playerConfigJson);
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static JSONObject getMediaItemJson(MediaItem mediaItem) throws JSONException {
        Assertions.checkNotNull(mediaItem.localConfiguration);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("title", mediaItem.mediaMetadata.title);
        jSONObject.put("uri", mediaItem.localConfiguration.uri.toString());
        jSONObject.put(KEY_MIME_TYPE, mediaItem.localConfiguration.mimeType);
        if (mediaItem.localConfiguration.drmConfiguration != null) {
            jSONObject.put(KEY_DRM_CONFIGURATION, getDrmConfigurationJson(mediaItem.localConfiguration.drmConfiguration));
        }
        return jSONObject;
    }

    private static JSONObject getDrmConfigurationJson(MediaItem.DrmConfiguration drmConfiguration) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(KEY_UUID, drmConfiguration.scheme);
        jSONObject.put(KEY_LICENSE_URI, drmConfiguration.licenseUri);
        jSONObject.put(KEY_REQUEST_HEADERS, new JSONObject(drmConfiguration.licenseRequestHeaders));
        return jSONObject;
    }

    private static JSONObject getPlayerConfigJson(MediaItem mediaItem) throws JSONException {
        String str;
        JSONObject jSONObject = null;
        if (mediaItem.localConfiguration != null && mediaItem.localConfiguration.drmConfiguration != null) {
            MediaItem.DrmConfiguration drmConfiguration = mediaItem.localConfiguration.drmConfiguration;
            if (C3282C.WIDEVINE_UUID.equals(drmConfiguration.scheme)) {
                str = "widevine";
            } else {
                str = C3282C.PLAYREADY_UUID.equals(drmConfiguration.scheme) ? "playready" : "playready";
            }
            jSONObject = new JSONObject();
            jSONObject.put("withCredentials", false);
            jSONObject.put("protectionSystem", str);
            if (drmConfiguration.licenseUri != null) {
                jSONObject.put("licenseUrl", drmConfiguration.licenseUri);
            }
            if (!drmConfiguration.licenseRequestHeaders.isEmpty()) {
                jSONObject.put("headers", new JSONObject(drmConfiguration.licenseRequestHeaders));
            }
        }
        return jSONObject;
    }
}
