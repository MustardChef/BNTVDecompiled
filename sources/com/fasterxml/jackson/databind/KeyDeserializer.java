package com.fasterxml.jackson.databind;

import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class KeyDeserializer {

    /* loaded from: classes2.dex */
    public static abstract class None extends KeyDeserializer {
    }

    public abstract Object deserializeKey(String str, DeserializationContext deserializationContext) throws IOException;
}
