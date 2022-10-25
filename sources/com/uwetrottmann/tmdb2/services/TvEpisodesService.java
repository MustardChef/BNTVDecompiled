package com.uwetrottmann.tmdb2.services;

import com.uwetrottmann.tmdb2.entities.AppendToResponse;
import com.uwetrottmann.tmdb2.entities.BaseAccountStates;
import com.uwetrottmann.tmdb2.entities.Changes;
import com.uwetrottmann.tmdb2.entities.Credits;
import com.uwetrottmann.tmdb2.entities.Images;
import com.uwetrottmann.tmdb2.entities.RatingObject;
import com.uwetrottmann.tmdb2.entities.Status;
import com.uwetrottmann.tmdb2.entities.TmdbDate;
import com.uwetrottmann.tmdb2.entities.TvEpisode;
import com.uwetrottmann.tmdb2.entities.TvEpisodeExternalIds;
import com.uwetrottmann.tmdb2.entities.Videos;
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
public interface TvEpisodesService {
    @GET("tv/{tv_id}/season/{season_number}/episode/{episode_number}/account_states")
    Call<BaseAccountStates> accountStates(@Path("tv_id") int i, @Path("season_number") int i2, @Path("episode_number") int i3);

    @POST("tv/{tv_id}/season/{season_number}/episode/{episode_number}/rating")
    Call<Status> addRating(@Path("tv_id") int i, @Path("season_number") int i2, @Path("episode_number") int i3, @Body RatingObject ratingObject);

    @GET("tv/episode/{episode_id}/changes")
    Call<Changes> changes(@Path("episode_id") int i, @Query("start_date") TmdbDate tmdbDate, @Query("end_date") TmdbDate tmdbDate2, @Query("page") Integer num);

    @GET("tv/{tv_id}/season/{season_number}/episode/{episode_number}/credits")
    Call<Credits> credits(@Path("tv_id") int i, @Path("season_number") int i2, @Path("episode_number") int i3);

    @DELETE("tv/{tv_id}/season/{season_number}/episode/{episode_number}/rating")
    Call<Status> deleteRating(@Path("tv_id") int i, @Path("season_number") int i2, @Path("episode_number") int i3);

    @GET("tv/{tv_id}/season/{season_number}/episode/{episode_number}")
    Call<TvEpisode> episode(@Path("tv_id") int i, @Path("season_number") int i2, @Path("episode_number") int i3, @Query("language") String str);

    @GET("tv/{tv_id}/season/{season_number}/episode/{episode_number}")
    Call<TvEpisode> episode(@Path("tv_id") int i, @Path("season_number") int i2, @Path("episode_number") int i3, @Query("language") String str, @Query("append_to_response") AppendToResponse appendToResponse);

    @GET("tv/{tv_id}/season/{season_number}/episode/{episode_number}")
    Call<TvEpisode> episode(@Path("tv_id") int i, @Path("season_number") int i2, @Path("episode_number") int i3, @Query("language") String str, @Query("append_to_response") AppendToResponse appendToResponse, @QueryMap Map<String, String> map);

    @GET("tv/{tv_id}/season/{season_number}/episode/{episode_number}/external_ids")
    Call<TvEpisodeExternalIds> externalIds(@Path("tv_id") int i, @Path("season_number") int i2, @Path("episode_number") int i3);

    @GET("tv/{tv_id}/season/{season_number}/episode/{episode_number}/images")
    Call<Images> images(@Path("tv_id") int i, @Path("season_number") int i2, @Path("episode_number") int i3);

    @GET("tv/{tv_id}/season/{season_number}/episode/{episode_number}/videos")
    Call<Videos> videos(@Path("tv_id") int i, @Path("season_number") int i2, @Path("episode_number") int i3, @Query("language") String str);
}
