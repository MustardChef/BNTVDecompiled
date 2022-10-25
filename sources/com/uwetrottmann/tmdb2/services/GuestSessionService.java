package com.uwetrottmann.tmdb2.services;

import com.uwetrottmann.tmdb2.entities.MovieResultsPage;
import com.uwetrottmann.tmdb2.entities.TvEpisodeResultsPage;
import com.uwetrottmann.tmdb2.entities.TvShowResultsPage;
import com.uwetrottmann.tmdb2.enumerations.SortBy;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* loaded from: classes4.dex */
public interface GuestSessionService {
    @GET("guest_session/{id}/rated/movies")
    Call<MovieResultsPage> ratedMovies(@Path("id") String str, @Query("language") String str2, @Query("sort_by") SortBy sortBy);

    @GET("guest_session/{id}/rated/tv/episodes")
    Call<TvEpisodeResultsPage> ratedTvEpisodes(@Path("id") String str, @Query("language") String str2, @Query("sort_by") SortBy sortBy);

    @GET("guest_session/{id}/rated/tv")
    Call<TvShowResultsPage> ratedTvShows(@Path("id") String str, @Query("language") String str2, @Query("sort_by") SortBy sortBy);
}
