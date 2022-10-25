package com.uwetrottmann.tmdb2.services;

import com.uwetrottmann.tmdb2.entities.AppendToResponse;
import com.uwetrottmann.tmdb2.entities.Keyword;
import com.uwetrottmann.tmdb2.entities.MovieResultsPage;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/* loaded from: classes4.dex */
public interface KeywordsService {
    @GET("keyword/{keyword_id}/movies")
    Call<MovieResultsPage> movies(@Path("keyword_id") Integer num);

    @GET("keyword/{keyword_id}")
    Call<Keyword> summary(@Path("keyword_id") Integer num);

    @GET("keyword/{keyword_id}")
    Call<Keyword> summary(@Path("keyword_id") Integer num, @Query("append_to_response") AppendToResponse appendToResponse);

    @GET("keyword/{keyword_id}")
    Call<Keyword> summary(@Path("keyword_id") Integer num, @Query("append_to_response") AppendToResponse appendToResponse, @QueryMap Map<String, String> map);
}
