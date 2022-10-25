package com.uwetrottmann.tmdb2;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;

/* compiled from: lambda */
/* renamed from: com.uwetrottmann.tmdb2.-$$Lambda$TmdbHelper$VGOfRxmFZuMsehYFi3Gg0NOy-I8  reason: invalid class name */
/* loaded from: classes4.dex */
public final /* synthetic */ class $$Lambda$TmdbHelper$VGOfRxmFZuMsehYFi3Gg0NOyI8 implements JsonDeserializer {
    public static final /* synthetic */ $$Lambda$TmdbHelper$VGOfRxmFZuMsehYFi3Gg0NOyI8 INSTANCE = new $$Lambda$TmdbHelper$VGOfRxmFZuMsehYFi3Gg0NOyI8();

    private /* synthetic */ $$Lambda$TmdbHelper$VGOfRxmFZuMsehYFi3Gg0NOyI8() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return TmdbHelper.lambda$getGsonBuilder$4(jsonElement, type, jsonDeserializationContext);
    }
}
