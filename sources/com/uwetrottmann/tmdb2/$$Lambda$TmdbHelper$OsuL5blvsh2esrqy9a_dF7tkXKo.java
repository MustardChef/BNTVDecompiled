package com.uwetrottmann.tmdb2;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.uwetrottmann.tmdb2.enumerations.MediaType;
import java.lang.reflect.Type;

/* compiled from: lambda */
/* renamed from: com.uwetrottmann.tmdb2.-$$Lambda$TmdbHelper$OsuL5blvsh2esrqy9a_dF7tkXKo  reason: invalid class name */
/* loaded from: classes4.dex */
public final /* synthetic */ class $$Lambda$TmdbHelper$OsuL5blvsh2esrqy9a_dF7tkXKo implements JsonDeserializer {
    public static final /* synthetic */ $$Lambda$TmdbHelper$OsuL5blvsh2esrqy9a_dF7tkXKo INSTANCE = new $$Lambda$TmdbHelper$OsuL5blvsh2esrqy9a_dF7tkXKo();

    private /* synthetic */ $$Lambda$TmdbHelper$OsuL5blvsh2esrqy9a_dF7tkXKo() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        MediaType mediaType;
        mediaType = MediaType.get(jsonElement.getAsString());
        return mediaType;
    }
}
