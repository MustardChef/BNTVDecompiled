package com.uwetrottmann.tmdb2.services;

import com.uwetrottmann.tmdb2.entities.GenreResults;
import com.uwetrottmann.tmdb2.entities.MovieResultsPage;
import com.uwetrottmann.tmdb2.enumerations.SortBy;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* loaded from: classes4.dex */
public interface GenresService {
    @GET("genre/movie/list")
    Call<GenreResults> movie(@Query("language") String str);

    @GET("genre/{genre_id}/movies")
    Call<MovieResultsPage> movies(@Path("genre_id") int i, @Query("language") String str, @Query("include_adult") Boolean bool, @Query("sort_by") SortBy sortBy);

    @GET("genre/tv/list")
    /* renamed from: tv */
    Call<GenreResults> m134tv(@Query("language") String str);
}
