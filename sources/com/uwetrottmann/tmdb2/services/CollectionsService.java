package com.uwetrottmann.tmdb2.services;

import com.uwetrottmann.tmdb2.entities.AppendToResponse;
import com.uwetrottmann.tmdb2.entities.Collection;
import com.uwetrottmann.tmdb2.entities.Images;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/* loaded from: classes4.dex */
public interface CollectionsService {
    @GET("collection/{collection_id}/images")
    Call<Images> images(@Path("collection_id") int i, @Query("language") String str);

    @GET("collection/{collection_id}")
    Call<Collection> summary(@Path("collection_id") int i, @Query("language") String str);

    @GET("collection/{collection_id}")
    Call<Collection> summary(@Path("collection_id") int i, @Query("language") String str, @Query("append_to_response") AppendToResponse appendToResponse);

    @GET("collection/{collection_id}")
    Call<Collection> summary(@Path("collection_id") int i, @Query("language") String str, @Query("append_to_response") AppendToResponse appendToResponse, @QueryMap Map<String, String> map);
}
