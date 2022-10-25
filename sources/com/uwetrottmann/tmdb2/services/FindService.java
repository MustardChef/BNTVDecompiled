package com.uwetrottmann.tmdb2.services;

import com.uwetrottmann.tmdb2.entities.FindResults;
import com.uwetrottmann.tmdb2.enumerations.ExternalSource;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* loaded from: classes4.dex */
public interface FindService {
    @GET("find/{external_id}")
    Call<FindResults> find(@Path("external_id") int i, @Query("external_source") ExternalSource externalSource, @Query("language") String str);

    @GET("find/{external_id}")
    Call<FindResults> find(@Path("external_id") String str, @Query("external_source") ExternalSource externalSource, @Query("language") String str2);
}
