package com.uwetrottmann.tmdb2.enumerations;

import com.google.common.net.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public enum VideoType {
    TRAILER(HttpHeaders.TRAILER),
    TEASER("Teaser"),
    CLIP("Clip"),
    FEATURETTE("Featurette"),
    OPENING_CREDITS("Opening Credits");
    
    private static final Map<String, VideoType> lookup = prepareLookup();
    private final String value;

    VideoType(String str) {
        this.value = str;
    }

    private static Map<String, VideoType> prepareLookup() {
        VideoType[] values;
        HashMap hashMap = new HashMap();
        for (VideoType videoType : values()) {
            hashMap.put(videoType.value, videoType);
        }
        return hashMap;
    }

    public static VideoType get(String str) {
        return lookup.get(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
