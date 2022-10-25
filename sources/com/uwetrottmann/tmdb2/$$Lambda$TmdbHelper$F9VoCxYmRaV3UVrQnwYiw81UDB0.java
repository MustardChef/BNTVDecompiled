package com.uwetrottmann.tmdb2;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;

/* compiled from: lambda */
/* renamed from: com.uwetrottmann.tmdb2.-$$Lambda$TmdbHelper$F9VoCxYmRaV3UVrQnwYiw81UDB0  reason: invalid class name */
/* loaded from: classes4.dex */
public final /* synthetic */ class $$Lambda$TmdbHelper$F9VoCxYmRaV3UVrQnwYiw81UDB0 implements JsonDeserializer {
    public static final /* synthetic */ $$Lambda$TmdbHelper$F9VoCxYmRaV3UVrQnwYiw81UDB0 INSTANCE = new $$Lambda$TmdbHelper$F9VoCxYmRaV3UVrQnwYiw81UDB0();

    private /* synthetic */ $$Lambda$TmdbHelper$F9VoCxYmRaV3UVrQnwYiw81UDB0() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return TmdbHelper.lambda$getGsonBuilder$7(jsonElement, type, jsonDeserializationContext);
    }
}
