package com.uwetrottmann.tmdb2;

import com.uwetrottmann.tmdb2.entities.DiscoverFilter;
import com.uwetrottmann.tmdb2.entities.TmdbDate;
import com.uwetrottmann.tmdb2.entities.TvShowResultsPage;
import com.uwetrottmann.tmdb2.enumerations.SortBy;
import com.uwetrottmann.tmdb2.services.DiscoverService;
import javax.annotation.Nullable;
import retrofit2.Call;

/* loaded from: classes4.dex */
public class DiscoverTvBuilder {
    @Nullable
    private TmdbDate air_date_gte;
    @Nullable
    private TmdbDate air_date_lte;
    protected final DiscoverService discoverService;
    @Nullable
    private TmdbDate first_air_date_gte;
    @Nullable
    private TmdbDate first_air_date_lte;
    @Nullable
    private Integer first_air_date_year;
    @Nullable
    private Boolean include_null_first_air_dates;
    @Nullable
    private String language;
    @Nullable
    private Integer page;
    @Nullable
    private Boolean screened_theatrically;
    @Nullable
    private SortBy sort_by;
    @Nullable
    private String timezone;
    @Nullable
    private Float vote_average_gte;
    @Nullable
    private Integer vote_count_gte;
    @Nullable
    private String watch_region;
    @Nullable
    private DiscoverFilter with_companies;
    @Nullable
    private DiscoverFilter with_genres;
    @Nullable
    private DiscoverFilter with_keywords;
    @Nullable
    private DiscoverFilter with_networks;
    @Nullable
    private String with_original_language;
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

    public DiscoverTvBuilder(DiscoverService discoverService) {
        this.discoverService = discoverService;
    }

    public DiscoverTvBuilder language(@Nullable String str) {
        this.language = str;
        return this;
    }

    public DiscoverTvBuilder sort_by(@Nullable SortBy sortBy) {
        this.sort_by = sortBy;
        return this;
    }

    public DiscoverTvBuilder air_date_gte(@Nullable TmdbDate tmdbDate) {
        this.air_date_gte = tmdbDate;
        return this;
    }

    public DiscoverTvBuilder air_date_lte(@Nullable TmdbDate tmdbDate) {
        this.air_date_lte = tmdbDate;
        return this;
    }

    public DiscoverTvBuilder first_air_date_gte(@Nullable TmdbDate tmdbDate) {
        this.first_air_date_gte = tmdbDate;
        return this;
    }

    public DiscoverTvBuilder first_air_date_lte(@Nullable TmdbDate tmdbDate) {
        this.first_air_date_lte = tmdbDate;
        return this;
    }

    public DiscoverTvBuilder first_air_date_year(@Nullable Integer num) {
        this.first_air_date_year = num;
        return this;
    }

    public DiscoverTvBuilder page(@Nullable Integer num) {
        this.page = num;
        return this;
    }

    public DiscoverTvBuilder timezone(@Nullable String str) {
        this.timezone = str;
        return this;
    }

    public DiscoverTvBuilder vote_average_gte(@Nullable Float f) {
        this.vote_average_gte = f;
        return this;
    }

    public DiscoverTvBuilder vote_count_gte(@Nullable Integer num) {
        this.vote_count_gte = num;
        return this;
    }

    public DiscoverTvBuilder with_genres(@Nullable DiscoverFilter discoverFilter) {
        this.with_genres = discoverFilter;
        return this;
    }

    public DiscoverTvBuilder with_networks(@Nullable DiscoverFilter discoverFilter) {
        this.with_networks = discoverFilter;
        return this;
    }

    public DiscoverTvBuilder without_genres(@Nullable DiscoverFilter discoverFilter) {
        this.without_genres = discoverFilter;
        return this;
    }

    public DiscoverTvBuilder with_runtime_gte(@Nullable Integer num) {
        this.with_runtime_gte = num;
        return this;
    }

    public DiscoverTvBuilder with_runtime_lte(@Nullable Integer num) {
        this.with_runtime_lte = num;
        return this;
    }

    public DiscoverTvBuilder include_null_first_air_dates() {
        this.include_null_first_air_dates = true;
        return this;
    }

    public DiscoverTvBuilder with_original_language(@Nullable String str) {
        this.with_original_language = str;
        return this;
    }

    public DiscoverTvBuilder without_keywords(@Nullable DiscoverFilter discoverFilter) {
        this.without_keywords = discoverFilter;
        return this;
    }

    public DiscoverTvBuilder screened_theatrically(@Nullable Boolean bool) {
        this.screened_theatrically = bool;
        return this;
    }

    public DiscoverTvBuilder with_companies(@Nullable DiscoverFilter discoverFilter) {
        this.with_companies = discoverFilter;
        return this;
    }

    public DiscoverTvBuilder with_keywords(@Nullable DiscoverFilter discoverFilter) {
        this.with_keywords = discoverFilter;
        return this;
    }

    public DiscoverTvBuilder with_watch_providers(@Nullable DiscoverFilter discoverFilter) {
        this.with_watch_providers = discoverFilter;
        return this;
    }

    public DiscoverTvBuilder watch_region(@Nullable String str) {
        this.watch_region = str;
        return this;
    }

    public DiscoverTvBuilder with_watch_monetization_types(@Nullable String str) {
        this.with_watch_monetization_types = str;
        return this;
    }

    public Call<TvShowResultsPage> build() {
        return this.discoverService.discoverTv(this.language, this.sort_by, this.air_date_gte, this.air_date_lte, this.first_air_date_gte, this.first_air_date_lte, this.first_air_date_year, this.page, this.timezone, this.vote_average_gte, this.vote_count_gte, this.with_genres, this.with_networks, this.without_genres, this.with_runtime_gte, this.with_runtime_lte, this.include_null_first_air_dates, this.with_original_language, this.without_keywords, this.screened_theatrically, this.with_companies, this.with_keywords, this.with_watch_providers, this.watch_region, this.with_watch_monetization_types);
    }
}
