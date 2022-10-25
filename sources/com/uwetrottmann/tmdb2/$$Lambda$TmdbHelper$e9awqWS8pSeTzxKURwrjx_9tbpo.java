package com.uwetrottmann.tmdb2;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.uwetrottmann.tmdb2.enumerations.VideoType;
import java.lang.reflect.Type;

/* compiled from: lambda */
/* renamed from: com.uwetrottmann.tmdb2.-$$Lambda$TmdbHelper$e9awqWS8pSeTzxKURwrjx_9tbpo  reason: invalid class name */
/* loaded from: classes4.dex */
public final /* synthetic */ class $$Lambda$TmdbHelper$e9awqWS8pSeTzxKURwrjx_9tbpo implements JsonDeserializer {
    public static final /* synthetic */ $$Lambda$TmdbHelper$e9awqWS8pSeTzxKURwrjx_9tbpo INSTANCE = new $$Lambda$TmdbHelper$e9awqWS8pSeTzxKURwrjx_9tbpo();

    private /* synthetic */ $$Lambda$TmdbHelper$e9awqWS8pSeTzxKURwrjx_9tbpo() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        VideoType videoType;
        videoType = VideoType.get(jsonElement.getAsString());
        return videoType;
    }
}
