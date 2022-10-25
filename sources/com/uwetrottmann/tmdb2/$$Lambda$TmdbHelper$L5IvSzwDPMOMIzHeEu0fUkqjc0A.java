package com.uwetrottmann.tmdb2;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;

/* compiled from: lambda */
/* renamed from: com.uwetrottmann.tmdb2.-$$Lambda$TmdbHelper$L5IvSzwDPMOMIzHeEu0fUkqjc0A  reason: invalid class name */
/* loaded from: classes4.dex */
public final /* synthetic */ class $$Lambda$TmdbHelper$L5IvSzwDPMOMIzHeEu0fUkqjc0A implements JsonDeserializer {
    public static final /* synthetic */ $$Lambda$TmdbHelper$L5IvSzwDPMOMIzHeEu0fUkqjc0A INSTANCE = new $$Lambda$TmdbHelper$L5IvSzwDPMOMIzHeEu0fUkqjc0A();

    private /* synthetic */ $$Lambda$TmdbHelper$L5IvSzwDPMOMIzHeEu0fUkqjc0A() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return TmdbHelper.lambda$getGsonBuilder$3(jsonElement, type, jsonDeserializationContext);
    }
}
