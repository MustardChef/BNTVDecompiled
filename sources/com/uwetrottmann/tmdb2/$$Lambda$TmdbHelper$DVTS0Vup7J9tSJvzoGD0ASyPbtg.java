package com.uwetrottmann.tmdb2;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;

/* compiled from: lambda */
/* renamed from: com.uwetrottmann.tmdb2.-$$Lambda$TmdbHelper$DVTS0Vup7J9tSJvzoGD0ASyPbtg  reason: invalid class name */
/* loaded from: classes4.dex */
public final /* synthetic */ class $$Lambda$TmdbHelper$DVTS0Vup7J9tSJvzoGD0ASyPbtg implements JsonDeserializer {
    public static final /* synthetic */ $$Lambda$TmdbHelper$DVTS0Vup7J9tSJvzoGD0ASyPbtg INSTANCE = new $$Lambda$TmdbHelper$DVTS0Vup7J9tSJvzoGD0ASyPbtg();

    private /* synthetic */ $$Lambda$TmdbHelper$DVTS0Vup7J9tSJvzoGD0ASyPbtg() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return TmdbHelper.lambda$getGsonBuilder$6(jsonElement, type, jsonDeserializationContext);
    }
}
