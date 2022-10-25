package com.uwetrottmann.tmdb2;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;

/* compiled from: lambda */
/* renamed from: com.uwetrottmann.tmdb2.-$$Lambda$TmdbHelper$fVk_AdvBbdW1KjlkIom2OwqQ08o  reason: invalid class name */
/* loaded from: classes4.dex */
public final /* synthetic */ class $$Lambda$TmdbHelper$fVk_AdvBbdW1KjlkIom2OwqQ08o implements JsonDeserializer {
    public static final /* synthetic */ $$Lambda$TmdbHelper$fVk_AdvBbdW1KjlkIom2OwqQ08o INSTANCE = new $$Lambda$TmdbHelper$fVk_AdvBbdW1KjlkIom2OwqQ08o();

    private /* synthetic */ $$Lambda$TmdbHelper$fVk_AdvBbdW1KjlkIom2OwqQ08o() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return TmdbHelper.lambda$getGsonBuilder$8(jsonElement, type, jsonDeserializationContext);
    }
}
