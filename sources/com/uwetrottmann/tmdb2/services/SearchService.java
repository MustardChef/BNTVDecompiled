package com.uwetrottmann.tmdb2.services;

import com.uwetrottmann.tmdb2.entities.CollectionResultsPage;
import com.uwetrottmann.tmdb2.entities.CompanyResultsPage;
import com.uwetrottmann.tmdb2.entities.KeywordResultsPage;
import com.uwetrottmann.tmdb2.entities.MediaResultsPage;
import com.uwetrottmann.tmdb2.entities.MovieResultsPage;
import com.uwetrottmann.tmdb2.entities.PersonResultsPage;
import com.uwetrottmann.tmdb2.entities.TvShowResultsPage;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* loaded from: classes4.dex */
public interface SearchService {
    @GET("search/collection")
    Call<CollectionResultsPage> collection(@Query("query") String str, @Query("page") Integer num, @Query("language") String str2);

    @GET("search/company")
    Call<CompanyResultsPage> company(@Query("query") String str, @Query("page") Integer num);

    @GET("search/keyword")
    Call<KeywordResultsPage> keyword(@Query("query") String str, @Query("page") Integer num);

    @GET("search/movie")
    Call<MovieResultsPage> movie(@Query("query") String str, @Query("page") Integer num, @Query("language") String str2, @Query("region") String str3, @Query("include_adult") Boolean bool, @Query("year") Integer num2, @Query("primary_release_year") Integer num3);

    @GET("search/multi")
    Call<MediaResultsPage> multi(@Query("query") String str, @Query("page") Integer num, @Query("language") String str2, @Query("region") String str3, @Query("include_adult") Boolean bool);

    @GET("search/person")
    Call<PersonResultsPage> person(@Query("query") String str, @Query("page") Integer num, @Query("language") String str2, @Query("region") String str3, @Query("include_adult") Boolean bool);

    @GET("search/tv")
    /* renamed from: tv */
    Call<TvShowResultsPage> m133tv(@Query("query") String str, @Query("page") Integer num, @Query("language") String str2, @Query("first_air_date_year") Integer num2, @Query("include_adult") Boolean bool);
}
