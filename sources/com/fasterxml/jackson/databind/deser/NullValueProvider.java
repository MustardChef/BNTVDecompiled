package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.util.AccessPattern;

/* loaded from: classes2.dex */
public interface NullValueProvider {
    Object getAbsentValue(DeserializationContext deserializationContext) throws JsonMappingException;

    AccessPattern getNullAccessPattern();

    Object getNullValue(DeserializationContext deserializationContext) throws JsonMappingException;

    /* renamed from: com.fasterxml.jackson.databind.deser.NullValueProvider$-CC  reason: invalid class name */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC {
    }
}
