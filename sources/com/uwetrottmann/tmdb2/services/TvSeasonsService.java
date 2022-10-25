package com.uwetrottmann.tmdb2.services;

import com.uwetrottmann.tmdb2.entities.AccountStatesResults;
import com.uwetrottmann.tmdb2.entities.AppendToResponse;
import com.uwetrottmann.tmdb2.entities.Changes;
import com.uwetrottmann.tmdb2.entities.Credits;
import com.uwetrottmann.tmdb2.entities.Images;
import com.uwetrottmann.tmdb2.entities.TmdbDate;
import com.uwetrottmann.tmdb2.entities.TvSeason;
import com.uwetrottmann.tmdb2.entities.TvSeasonExternalIds;
import com.uwetrottmann.tmdb2.entities.Videos;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/* loaded from: classes4.dex */
public interface TvSeasonsService {
    @GET("tv/{tv_id}/season/{season_number}/account_states")
    Call<AccountStatesResults> accountStates(@Path("tv_id") int i, @Path("season_number") int i2);

    @GET("tv/season/{season_id}/changes")
    Call<Changes> changes(@Path("season_id") int i, @Query("start_date") TmdbDate tmdbDate, @Query("end_date") TmdbDate tmdbDate2, @Query("page") Integer num);

    @GET("tv/{tv_id}/season/{season_number}/credits")
    Call<Credits> credits(@Path("tv_id") int i, @Path("season_number") int i2);

    @GET("tv/{tv_id}/season/{season_number}/external_ids")
    Call<TvSeasonExternalIds> externalIds(@Path("tv_id") int i, @Path("season_number") int i2, @Query("language") String str);

    @GET("tv/{tv_id}/season/{season_number}/images")
    Call<Images> images(@Path("tv_id") int i, @Path("season_number") int i2, @Query("language") String str);

    @GET("tv/{tv_id}/season/{season_number}")
    Call<TvSeason> season(@Path("tv_id") int i, @Path("season_number") int i2, @Query("language") String str);

    @GET("tv/{tv_id}/season/{season_number}")
    Call<TvSeason> season(@Path("tv_id") int i, @Path("season_number") int i2, @Query("language") String str, @Query("append_to_response") AppendToResponse appendToResponse);

    @GET("tv/{tv_id}/season/{season_number}")
    Call<TvSeason> season(@Path("tv_id") int i, @Path("season_number") int i2, @Query("language") String str, @Query("append_to_response") AppendToResponse appendToResponse, @QueryMap Map<String, String> map);

    @GET("tv/{tv_id}/season/{season_number}/videos")
    Call<Videos> videos(@Path("tv_id") int i, @Path("season_number") int i2, @Query("language") String str);
}
