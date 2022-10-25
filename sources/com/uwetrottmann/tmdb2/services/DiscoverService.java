package com.uwetrottmann.tmdb2.services;

import com.uwetrottmann.tmdb2.entities.DiscoverFilter;
import com.uwetrottmann.tmdb2.entities.MovieResultsPage;
import com.uwetrottmann.tmdb2.entities.TmdbDate;
import com.uwetrottmann.tmdb2.entities.TvShowResultsPage;
import com.uwetrottmann.tmdb2.enumerations.SortBy;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* loaded from: classes4.dex */
public interface DiscoverService {
    @GET("discover/movie")
    Call<MovieResultsPage> discoverMovie(@Query("language") String str, @Query("region") String str2, @Query("sort_by") SortBy sortBy, @Query("certification_country") String str3, @Query("certification") String str4, @Query("certification_lte") String str5, @Query("include_adult") Boolean bool, @Query("include_video") Boolean bool2, @Query("page") Integer num, @Query("primary_release_year") Integer num2, @Query("primary_release_date.gte") TmdbDate tmdbDate, @Query("primary_release_date.lte") TmdbDate tmdbDate2, @Query("release_date.gte") TmdbDate tmdbDate3, @Query("release_date.lte") TmdbDate tmdbDate4, @Query("vote_count.gte") Integer num3, @Query("vote_count.lte") Integer num4, @Query("vote_average.gte") Float f, @Query("vote_average.lte") Float f2, @Query("with_cast") DiscoverFilter discoverFilter, @Query("with_crew") DiscoverFilter discoverFilter2, @Query("with_companies") DiscoverFilter discoverFilter3, @Query("with_genres") DiscoverFilter discoverFilter4, @Query("with_keywords") DiscoverFilter discoverFilter5, @Query("with_people") DiscoverFilter discoverFilter6, @Query("year") Integer num5, @Query("without_genres") DiscoverFilter discoverFilter7, @Query("with_runtime.gte") Integer num6, @Query("with_runtime.lte") Integer num7, @Query("with_release_type") DiscoverFilter discoverFilter8, @Query("with_original_language") String str6, @Query("without_keywords") DiscoverFilter discoverFilter9, @Query("with_watch_providers") DiscoverFilter discoverFilter10, @Query("watch_region") String str7, @Query("with_watch_monetization_types") String str8);

    @GET("discover/tv")
    Call<TvShowResultsPage> discoverTv(@Query("language") String str, @Query("sort_by") SortBy sortBy, @Query("air_date.gte") TmdbDate tmdbDate, @Query("air_date.lte") TmdbDate tmdbDate2, @Query("first_air_date.gte") TmdbDate tmdbDate3, @Query("first_air_date.lte") TmdbDate tmdbDate4, @Query("first_air_date_year") Integer num, @Query("page") Integer num2, @Query("timezone") String str2, @Query("vote_average.gte") Float f, @Query("vote_count.gte") Integer num3, @Query("with_genres") DiscoverFilter discoverFilter, @Query("with_networks") DiscoverFilter discoverFilter2, @Query("without_genres") DiscoverFilter discoverFilter3, @Query("with_runtime.gte") Integer num4, @Query("with_runtime.lte") Integer num5, @Query("include_null_first_air_dates") Boolean bool, @Query("with_original_language") String str3, @Query("without_keywords") DiscoverFilter discoverFilter4, @Query("screened_theatrically") Boolean bool2, @Query("with_companies") DiscoverFilter discoverFilter5, @Query("with_keywords") DiscoverFilter discoverFilter6, @Query("with_watch_providers") DiscoverFilter discoverFilter7, @Query("watch_region") String str4, @Query("with_watch_monetization_types") String str5);
}
