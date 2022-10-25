package com.uwetrottmann.tmdb2;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;

/* compiled from: lambda */
/* renamed from: com.uwetrottmann.tmdb2.-$$Lambda$TmdbHelper$hKWzfbyVyw-aMxa3PxsZKvieGIU  reason: invalid class name */
/* loaded from: classes4.dex */
public final /* synthetic */ class $$Lambda$TmdbHelper$hKWzfbyVywaMxa3PxsZKvieGIU implements JsonDeserializer {
    public static final /* synthetic */ $$Lambda$TmdbHelper$hKWzfbyVywaMxa3PxsZKvieGIU INSTANCE = new $$Lambda$TmdbHelper$hKWzfbyVywaMxa3PxsZKvieGIU();

    private /* synthetic */ $$Lambda$TmdbHelper$hKWzfbyVywaMxa3PxsZKvieGIU() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return TmdbHelper.lambda$getGsonBuilder$5(jsonElement, type, jsonDeserializationContext);
    }
}
