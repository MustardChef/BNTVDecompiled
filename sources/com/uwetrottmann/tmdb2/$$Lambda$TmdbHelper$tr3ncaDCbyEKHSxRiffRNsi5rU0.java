package com.uwetrottmann.tmdb2;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;

/* compiled from: lambda */
/* renamed from: com.uwetrottmann.tmdb2.-$$Lambda$TmdbHelper$tr3ncaDCbyEKHSxRiffRNsi5rU0  reason: invalid class name */
/* loaded from: classes4.dex */
public final /* synthetic */ class $$Lambda$TmdbHelper$tr3ncaDCbyEKHSxRiffRNsi5rU0 implements JsonDeserializer {
    public static final /* synthetic */ $$Lambda$TmdbHelper$tr3ncaDCbyEKHSxRiffRNsi5rU0 INSTANCE = new $$Lambda$TmdbHelper$tr3ncaDCbyEKHSxRiffRNsi5rU0();

    private /* synthetic */ $$Lambda$TmdbHelper$tr3ncaDCbyEKHSxRiffRNsi5rU0() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return TmdbHelper.lambda$getGsonBuilder$9(jsonElement, type, jsonDeserializationContext);
    }
}
