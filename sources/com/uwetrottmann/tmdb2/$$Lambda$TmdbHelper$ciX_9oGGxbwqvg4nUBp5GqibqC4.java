package com.uwetrottmann.tmdb2;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;

/* compiled from: lambda */
/* renamed from: com.uwetrottmann.tmdb2.-$$Lambda$TmdbHelper$ciX_9oGGxbwqvg4nUBp5GqibqC4  reason: invalid class name */
/* loaded from: classes4.dex */
public final /* synthetic */ class $$Lambda$TmdbHelper$ciX_9oGGxbwqvg4nUBp5GqibqC4 implements JsonDeserializer {
    public static final /* synthetic */ $$Lambda$TmdbHelper$ciX_9oGGxbwqvg4nUBp5GqibqC4 INSTANCE = new $$Lambda$TmdbHelper$ciX_9oGGxbwqvg4nUBp5GqibqC4();

    private /* synthetic */ $$Lambda$TmdbHelper$ciX_9oGGxbwqvg4nUBp5GqibqC4() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        Integer valueOf;
        valueOf = Integer.valueOf(jsonElement.getAsInt());
        return valueOf;
    }
}
