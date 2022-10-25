package com.uwetrottmann.tmdb2.services;

import com.uwetrottmann.tmdb2.entities.AccountStates;
import com.uwetrottmann.tmdb2.entities.AlternativeTitles;
import com.uwetrottmann.tmdb2.entities.AppendToResponse;
import com.uwetrottmann.tmdb2.entities.Changes;
import com.uwetrottmann.tmdb2.entities.Credits;
import com.uwetrottmann.tmdb2.entities.Images;
import com.uwetrottmann.tmdb2.entities.Keywords;
import com.uwetrottmann.tmdb2.entities.ListResultsPage;
import com.uwetrottmann.tmdb2.entities.Movie;
import com.uwetrottmann.tmdb2.entities.MovieExternalIds;
import com.uwetrottmann.tmdb2.entities.MovieResultsPage;
import com.uwetrottmann.tmdb2.entities.RatingObject;
import com.uwetrottmann.tmdb2.entities.ReleaseDatesResults;
import com.uwetrottmann.tmdb2.entities.ReviewResultsPage;
import com.uwetrottmann.tmdb2.entities.Status;
import com.uwetrottmann.tmdb2.entities.TmdbDate;
import com.uwetrottmann.tmdb2.entities.Translations;
import com.uwetrottmann.tmdb2.entities.Videos;
import com.uwetrottmann.tmdb2.entities.WatchProviders;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/* loaded from: classes4.dex */
public interface MoviesService {
    @GET("movie/{movie_id}/account_states")
    Call<AccountStates> accountStates(@Path("movie_id") int i);

    @POST("movie/{movie_id}/rating")
    Call<Status> addRating(@Path("movie_id") Integer num, @Body RatingObject ratingObject);

    @GET("movie/{movie_id}/alternative_titles")
    Call<AlternativeTitles> alternativeTitles(@Path("movie_id") int i, @Query("country") String str);

    @GET("movie/{movie_id}/changes")
    Call<Changes> changes(@Path("movie_id") int i, @Query("start_date") TmdbDate tmdbDate, @Query("end_date") TmdbDate tmdbDate2, @Query("page") Integer num);

    @GET("movie/{movie_id}/credits")
    Call<Credits> credits(@Path("movie_id") int i);

    @DELETE("movie/{movie_id}/rating")
    Call<Status> deleteRating(@Path("movie_id") Integer num);

    @GET("movie/{movie_id}/external_ids")
    Call<MovieExternalIds> externalIds(@Path("movie_id") int i, @Query("language") String str);

    @GET("movie/{movie_id}/images")
    Call<Images> images(@Path("movie_id") int i, @Query("language") String str);

    @GET("movie/{movie_id}/keywords")
    Call<Keywords> keywords(@Path("movie_id") int i);

    @GET("movie/latest")
    Call<Movie> latest();

    @GET("movie/{movie_id}/lists")
    Call<ListResultsPage> lists(@Path("movie_id") int i, @Query("page") Integer num, @Query("language") String str);

    @GET("movie/now_playing")
    Call<MovieResultsPage> nowPlaying(@Query("page") Integer num, @Query("language") String str, @Query("region") String str2);

    @GET("movie/popular")
    Call<MovieResultsPage> popular(@Query("page") Integer num, @Query("language") String str, @Query("region") String str2);

    @GET("movie/{movie_id}/recommendations")
    Call<MovieResultsPage> recommendations(@Path("movie_id") int i, @Query("page") Integer num, @Query("language") String str);

    @GET("movie/{movie_id}/release_dates")
    Call<ReleaseDatesResults> releaseDates(@Path("movie_id") int i);

    @GET("movie/{movie_id}/reviews")
    Call<ReviewResultsPage> reviews(@Path("movie_id") int i, @Query("page") Integer num, @Query("language") String str);

    @GET("movie/{movie_id}/similar")
    Call<MovieResultsPage> similar(@Path("movie_id") int i, @Query("page") Integer num, @Query("language") String str);

    @GET("movie/{movie_id}")
    Call<Movie> summary(@Path("movie_id") int i, @Query("language") String str);

    @GET("movie/{movie_id}")
    Call<Movie> summary(@Path("movie_id") int i, @Query("language") String str, @Query("append_to_response") AppendToResponse appendToResponse);

    @GET("movie/{movie_id}")
    Call<Movie> summary(@Path("movie_id") int i, @Query("language") String str, @Query("append_to_response") AppendToResponse appendToResponse, @QueryMap Map<String, String> map);

    @GET("movie/top_rated")
    Call<MovieResultsPage> topRated(@Query("page") Integer num, @Query("language") String str, @Query("region") String str2);

    @GET("movie/{movie_id}/translations")
    Call<Translations> translations(@Path("movie_id") int i);

    @GET("movie/upcoming")
    Call<MovieResultsPage> upcoming(@Query("page") Integer num, @Query("language") String str, @Query("region") String str2);

    @GET("movie/{movie_id}/videos")
    Call<Videos> videos(@Path("movie_id") int i, @Query("language") String str);

    @GET("movie/{movie_id}/watch/providers")
    Call<WatchProviders> watchProviders(@Path("movie_id") int i);
}
