package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.p033io.CharacterEscapes;
import com.fasterxml.jackson.core.p033io.SerializedString;

/* loaded from: classes2.dex */
public class JsonpCharacterEscapes extends CharacterEscapes {
    private static final int[] asciiEscapes = CharacterEscapes.standardAsciiEscapesForJSON();
    private static final SerializedString escapeFor2028 = new SerializedString("\\u2028");
    private static final SerializedString escapeFor2029 = new SerializedString("\\u2029");
    private static final JsonpCharacterEscapes sInstance = new JsonpCharacterEscapes();
    private static final long serialVersionUID = 1;

    public static JsonpCharacterEscapes instance() {
        return sInstance;
    }

    @Override // com.fasterxml.jackson.core.p033io.CharacterEscapes
    public SerializableString getEscapeSequence(int i) {
        if (i != 8232) {
            if (i != 8233) {
                return null;
            }
            return escapeFor2029;
        }
        return escapeFor2028;
    }

    @Override // com.fasterxml.jackson.core.p033io.CharacterEscapes
    public int[] getEscapeCodesForAscii() {
        return asciiEscapes;
    }
}
