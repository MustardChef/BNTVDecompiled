package com.uwetrottmann.tmdb2.enumerations;

/* loaded from: classes4.dex */
public enum ExternalSource {
    IMDB_ID("imdb_id"),
    FREEBASE_MID("freebase_mid"),
    FREEBASE_ID("freebase_id"),
    TVRAGE_ID("tvrage_id"),
    TVDB_ID("tvdb_id");
    
    private final String value;

    ExternalSource(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
