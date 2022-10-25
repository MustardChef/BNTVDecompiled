package com.uwetrottmann.tmdb2.services;

import com.uwetrottmann.tmdb2.entities.AppendToResponse;
import com.uwetrottmann.tmdb2.entities.Company;
import com.uwetrottmann.tmdb2.entities.MovieResultsPage;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/* loaded from: classes4.dex */
public interface CompaniesService {
    @GET("company/{company_id}/movies")
    Call<MovieResultsPage> movies(@Path("company_id") int i);

    @GET("company/{company_id}")
    Call<Company> summary(@Path("company_id") int i);

    @GET("company/{company_id}")
    Call<Company> summary(@Path("company_id") int i, @Query("append_to_response") AppendToResponse appendToResponse);

    @GET("company/{company_id}")
    Call<Company> summary(@Path("company_id") int i, @Query("append_to_response") AppendToResponse appendToResponse, @QueryMap Map<String, String> map);
}
