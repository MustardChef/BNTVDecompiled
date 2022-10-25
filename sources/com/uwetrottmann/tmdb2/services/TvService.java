package com.uwetrottmann.tmdb2.services;

import com.uwetrottmann.tmdb2.entities.AccountStates;
import com.uwetrottmann.tmdb2.entities.AlternativeTitles;
import com.uwetrottmann.tmdb2.entities.AppendToResponse;
import com.uwetrottmann.tmdb2.entities.Changes;
import com.uwetrottmann.tmdb2.entities.ContentRatings;
import com.uwetrottmann.tmdb2.entities.Credits;
import com.uwetrottmann.tmdb2.entities.Images;
import com.uwetrottmann.tmdb2.entities.Keywords;
import com.uwetrottmann.tmdb2.entities.RatingObject;
import com.uwetrottmann.tmdb2.entities.Status;
import com.uwetrottmann.tmdb2.entities.TmdbDate;
import com.uwetrottmann.tmdb2.entities.Translations;
import com.uwetrottmann.tmdb2.entities.TvExternalIds;
import com.uwetrottmann.tmdb2.entities.TvShow;
import com.uwetrottmann.tmdb2.entities.TvShowResultsPage;
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
public interface TvService {
    @GET("tv/{tv_id}/account_states")
    Call<AccountStates> accountStates(@Path("tv_id") int i);

    @POST("tv/{tv_id}/rating")
    Call<Status> addRating(@Path("tv_id") Integer num, @Body RatingObject ratingObject);

    @GET("tv/airing_today")
    Call<TvShowResultsPage> airingToday(@Query("page") Integer num, @Query("language") String str);

    @GET("tv/{tv_id}/alternative_titles")
    Call<AlternativeTitles> alternativeTitles(@Path("tv_id") int i);

    @GET("tv/{tv_id}/changes")
    Call<Changes> changes(@Path("tv_id") int i, @Query("start_date") TmdbDate tmdbDate, @Query("end_date") TmdbDate tmdbDate2, @Query("page") Integer num);

    @GET("tv/{tv_id}/content_ratings")
    Call<ContentRatings> content_ratings(@Path("tv_id") int i);

    @GET("tv/{tv_id}/credits")
    Call<Credits> credits(@Path("tv_id") int i, @Query("language") String str);

    @DELETE("tv/{tv_id}/rating")
    Call<Status> deleteRating(@Path("tv_id") Integer num);

    @GET("tv/{tv_id}/external_ids")
    Call<TvExternalIds> externalIds(@Path("tv_id") int i, @Query("language") String str);

    @GET("tv/{tv_id}/images")
    Call<Images> images(@Path("tv_id") int i, @Query("language") String str);

    @GET("tv/{tv_id}/keywords")
    Call<Keywords> keywords(@Path("tv_id") int i);

    @GET("tv/latest")
    Call<TvShow> latest();

    @GET("tv/on_the_air")
    Call<TvShowResultsPage> onTheAir(@Query("page") Integer num, @Query("language") String str);

    @GET("tv/popular")
    Call<TvShowResultsPage> popular(@Query("page") Integer num, @Query("language") String str);

    @GET("tv/{tv_id}/recommendations")
    Call<TvShowResultsPage> recommendations(@Path("tv_id") int i, @Query("page") Integer num, @Query("language") String str);

    @GET("tv/{tv_id}/similar")
    Call<TvShowResultsPage> similar(@Path("tv_id") int i, @Query("page") Integer num, @Query("language") String str);

    @GET("tv/top_rated")
    Call<TvShowResultsPage> topRated(@Query("page") Integer num, @Query("language") String str);

    @GET("tv/{tv_id}/translations")
    Call<Translations> translations(@Path("tv_id") int i, @Query("language") String str);

    @GET("tv/{tv_id}")
    /* renamed from: tv */
    Call<TvShow> m132tv(@Path("tv_id") int i, @Query("language") String str);

    @GET("tv/{tv_id}")
    /* renamed from: tv */
    Call<TvShow> m131tv(@Path("tv_id") int i, @Query("language") String str, @Query("append_to_response") AppendToResponse appendToResponse);

    @GET("tv/{tv_id}")
    /* renamed from: tv */
    Call<TvShow> m130tv(@Path("tv_id") int i, @Query("language") String str, @Query("append_to_response") AppendToResponse appendToResponse, @QueryMap Map<String, String> map);

    @GET("tv/{tv_id}/videos")
    Call<Videos> videos(@Path("tv_id") int i, @Query("language") String str);

    @GET("tv/{tv_id}/watch/providers")
    Call<WatchProviders> watchProviders(@Path("tv_id") int i);
}
