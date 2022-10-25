package com.uwetrottmann.tmdb2.enumerations;

/* loaded from: classes4.dex */
public enum AppendToResponseItem {
    IMAGES("images"),
    CHANGES("changes"),
    CREDITS("credits"),
    VIDEOS("videos"),
    ALTERNATIVE_TITLES("alternative_titles"),
    KEYWORDS("keywords"),
    RECOMMENDATIONS("recommendations"),
    RELEASE_DATES("release_dates"),
    REVIEWS("reviews"),
    SIMILAR("similar"),
    TRANSLATIONS("translations"),
    LISTS("lists"),
    EXTERNAL_IDS("external_ids"),
    CONTENT_RATINGS("content_ratings"),
    MOVIE_CREDITS("movie_credits"),
    TV_CREDITS("tv_credits"),
    COMBINED_CREDITS("combined_credits"),
    TAGGED_IMAGES("tagged_images"),
    MOVIES("movies");
    
    private final String value;

    AppendToResponseItem(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
