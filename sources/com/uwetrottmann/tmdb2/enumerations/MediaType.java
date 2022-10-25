package com.uwetrottmann.tmdb2.enumerations;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public enum MediaType {
    MOVIE("movie"),
    TV("tv"),
    PERSON("person");
    
    private static final Map<String, MediaType> lookup = prepareLookup();
    private final String value;

    private static Map<String, MediaType> prepareLookup() {
        MediaType[] values;
        HashMap hashMap = new HashMap();
        for (MediaType mediaType : values()) {
            hashMap.put(mediaType.value, mediaType);
        }
        return hashMap;
    }

    public static MediaType get(String str) {
        return lookup.get(str);
    }

    MediaType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
