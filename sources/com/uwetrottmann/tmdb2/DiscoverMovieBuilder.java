package com.uwetrottmann.tmdb2;

import com.uwetrottmann.tmdb2.entities.DiscoverFilter;
import com.uwetrottmann.tmdb2.entities.MovieResultsPage;
import com.uwetrottmann.tmdb2.entities.TmdbDate;
import com.uwetrottmann.tmdb2.enumerations.SortBy;
import com.uwetrottmann.tmdb2.services.DiscoverService;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import retrofit2.Call;

/* loaded from: classes4.dex */
public class DiscoverMovieBuilder {
    @Nullable
    private String certification;
    @Nullable
    private String certification_country;
    @Nullable
    private String certification_lte;
    private final DiscoverService discoverService;
    @Nullable
    private Boolean include_adult;
    @Nullable
    private Boolean include_video;
    @Nullable
    private String language;
    @Nullable
    private Integer page;
    @Nullable
    private TmdbDate primary_release_date_gte;
    @Nullable
    private TmdbDate primary_release_date_lte;
    @Nullable
    private Integer primary_release_year;
    @Nullable
    private String region;
    @Nullable
    private TmdbDate release_date_gte;
    @Nullable
    private TmdbDate release_date_lte;
    @Nullable
    private SortBy sort_by;
    @Nullable
    private Float vote_average_gte;
    @Nullable
    private Float vote_average_lte;
    @Nullable
    private Integer vote_count_gte;
    @Nullable
    private Integer vote_count_lte;
    @Nullable
    private String watch_region;
    @Nullable
    private DiscoverFilter with_cast;
    @Nullable
    private DiscoverFilter with_companies;
    @Nullable
    private DiscoverFilter with_crew;
    @Nullable
    private DiscoverFilter with_genres;
    @Nullable
    private DiscoverFilter with_keywords;
    @Nullable
    private String with_original_language;
    @Nullable
    private DiscoverFilter with_people;
    @Nullable
    private DiscoverFilter with_release_type;
    @Nullable
    private Integer with_runtime_gte;
    @Nullable
    private Integer with_runtime_lte;
    @Nullable
    private String with_watch_monetization_types;
    @Nullable
    private DiscoverFilter with_watch_providers;
    @Nullable
    private DiscoverFilter without_genres;
    @Nullable
    private DiscoverFilter without_keywords;
    @Nullable
    private Integer year;

    public DiscoverMovieBuilder(@Nonnull DiscoverService discoverService) {
        this.discoverService = discoverService;
    }

    public DiscoverMovieBuilder language(@Nullable String str) {
        this.language = str;
        return this;
    }

    public DiscoverMovieBuilder region(@Nullable String str) {
        this.region = str;
        return this;
    }

    public DiscoverMovieBuilder sort_by(@Nullable SortBy sortBy) {
        this.sort_by = sortBy;
        return this;
    }

    public DiscoverMovieBuilder certification_country(@Nullable String str) {
        this.certification_country = str;
        return this;
    }

    public DiscoverMovieBuilder certification(@Nullable String str) {
        this.certification = str;
        return this;
    }

    public DiscoverMovieBuilder certification_lte(@Nullable String str) {
        this.certification_lte = str;
        return this;
    }

    public DiscoverMovieBuilder includeAdult() {
        this.include_adult = true;
        return this;
    }

    public DiscoverMovieBuilder includeVideo() {
        this.include_video = true;
        return this;
    }

    public DiscoverMovieBuilder page(@Nullable Integer num) {
        this.page = num;
        return this;
    }

    public DiscoverMovieBuilder primary_release_year(@Nullable Integer num) {
        this.primary_release_year = num;
        return this;
    }

    public DiscoverMovieBuilder primary_release_date_gte(@Nullable TmdbDate tmdbDate) {
        this.primary_release_date_gte = tmdbDate;
        return this;
    }

    public DiscoverMovieBuilder primary_release_date_lte(@Nullable TmdbDate tmdbDate) {
        this.primary_release_date_lte = tmdbDate;
        return this;
    }

    public DiscoverMovieBuilder release_date_gte(@Nullable TmdbDate tmdbDate) {
        this.release_date_gte = tmdbDate;
        return this;
    }

    public DiscoverMovieBuilder release_date_lte(@Nullable TmdbDate tmdbDate) {
        this.release_date_lte = tmdbDate;
        return this;
    }

    public DiscoverMovieBuilder vote_count_gte(@Nullable Integer num) {
        this.vote_count_gte = num;
        return this;
    }

    public DiscoverMovieBuilder vote_count_lte(@Nullable Integer num) {
        this.vote_count_lte = num;
        return this;
    }

    public DiscoverMovieBuilder vote_average_gte(@Nullable Float f) {
        this.vote_average_gte = f;
        return this;
    }

    public DiscoverMovieBuilder vote_average_lte(@Nullable Float f) {
        this.vote_average_lte = f;
        return this;
    }

    public DiscoverMovieBuilder with_cast(@Nullable DiscoverFilter discoverFilter) {
        this.with_cast = discoverFilter;
        return this;
    }

    public DiscoverMovieBuilder with_crew(@Nullable DiscoverFilter discoverFilter) {
        this.with_crew = discoverFilter;
        return this;
    }

    public DiscoverMovieBuilder with_companies(@Nullable DiscoverFilter discoverFilter) {
        this.with_companies = discoverFilter;
        return this;
    }

    public DiscoverMovieBuilder with_genres(@Nullable DiscoverFilter discoverFilter) {
        this.with_genres = discoverFilter;
        return this;
    }

    public DiscoverMovieBuilder with_keywords(@Nullable DiscoverFilter discoverFilter) {
        this.with_keywords = discoverFilter;
        return this;
    }

    public DiscoverMovieBuilder with_people(@Nullable DiscoverFilter discoverFilter) {
        this.with_people = discoverFilter;
        return this;
    }

    public DiscoverMovieBuilder year(@Nullable Integer num) {
        this.year = num;
        return this;
    }

    public DiscoverMovieBuilder without_genres(@Nullable DiscoverFilter discoverFilter) {
        this.without_genres = discoverFilter;
        return this;
    }

    public DiscoverMovieBuilder with_runtime_gte(@Nullable Integer num) {
        this.with_runtime_gte = num;
        return this;
    }

    public DiscoverMovieBuilder with_runtime_lte(@Nullable Integer num) {
        this.with_runtime_lte = num;
        return this;
    }

    public DiscoverMovieBuilder with_release_type(@Nullable DiscoverFilter discoverFilter) {
        this.with_release_type = discoverFilter;
        return this;
    }

    public DiscoverMovieBuilder with_original_language(@Nullable String str) {
        this.with_original_language = str;
        return this;
    }

    public DiscoverMovieBuilder without_keywords(@Nullable DiscoverFilter discoverFilter) {
        this.without_keywords = discoverFilter;
        return this;
    }

    public DiscoverMovieBuilder with_watch_providers(@Nullable DiscoverFilter discoverFilter) {
        this.with_watch_providers = discoverFilter;
        return this;
    }

    public DiscoverMovieBuilder watch_region(@Nullable String str) {
        this.watch_region = str;
        return this;
    }

    public DiscoverMovieBuilder with_watch_monetization_types(@Nullable String str) {
        this.with_watch_monetization_types = str;
        return this;
    }

    public Call<MovieResultsPage> build() {
        return this.discoverService.discoverMovie(this.language, this.region, this.sort_by, this.certification_country, this.certification, this.certification_lte, this.include_adult, this.include_video, this.page, this.primary_release_year, this.primary_release_date_gte, this.primary_release_date_lte, this.release_date_gte, this.release_date_lte, this.vote_count_gte, this.vote_count_lte, this.vote_average_gte, this.vote_average_lte, this.with_cast, this.with_crew, this.with_companies, this.with_genres, this.with_keywords, this.with_people, this.year, this.without_genres, this.with_runtime_gte, this.with_runtime_lte, this.with_release_type, this.with_original_language, this.without_keywords, this.with_watch_providers, this.watch_region, this.with_watch_monetization_types);
    }
}
