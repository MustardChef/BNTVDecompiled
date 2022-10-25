package com.uwetrottmann.tmdb2.services;

import com.uwetrottmann.tmdb2.entities.AppendToResponse;
import com.uwetrottmann.tmdb2.entities.Changes;
import com.uwetrottmann.tmdb2.entities.Person;
import com.uwetrottmann.tmdb2.entities.PersonCredits;
import com.uwetrottmann.tmdb2.entities.PersonExternalIds;
import com.uwetrottmann.tmdb2.entities.PersonImages;
import com.uwetrottmann.tmdb2.entities.PersonResultsPage;
import com.uwetrottmann.tmdb2.entities.TaggedImagesResultsPage;
import com.uwetrottmann.tmdb2.entities.TmdbDate;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/* loaded from: classes4.dex */
public interface PeopleService {
    @GET("person/{person_id}/changes")
    Call<Changes> changes(@Path("person_id") int i, @Query("language") String str, @Query("start_date") TmdbDate tmdbDate, @Query("end_date") TmdbDate tmdbDate2, @Query("page") Integer num);

    @GET("person/{person_id}/combined_credits")
    Call<PersonCredits> combinedCredits(@Path("person_id") int i, @Query("language") String str);

    @GET("person/{person_id}/external_ids")
    Call<PersonExternalIds> externalIds(@Path("person_id") int i);

    @GET("person/{person_id}/images")
    Call<PersonImages> images(@Path("person_id") int i);

    @GET("person/latest")
    Call<Person> latest();

    @GET("person/{person_id}/movie_credits")
    Call<PersonCredits> movieCredits(@Path("person_id") int i, @Query("language") String str);

    @GET("person/popular")
    Call<PersonResultsPage> popular(@Query("page") Integer num);

    @GET("person/{person_id}")
    Call<Person> summary(@Path("person_id") int i, @Query("language") String str);

    @GET("person/{person_id}")
    Call<Person> summary(@Path("person_id") int i, @Query("language") String str, @Query("append_to_response") AppendToResponse appendToResponse);

    @GET("person/{person_id}")
    Call<Person> summary(@Path("person_id") int i, @Query("language") String str, @Query("append_to_response") AppendToResponse appendToResponse, @QueryMap Map<String, String> map);

    @GET("person/{person_id}/tagged_images")
    Call<TaggedImagesResultsPage> taggedImages(@Path("person_id") int i, @Query("page") Integer num, @Query("language") String str);

    @GET("person/{person_id}/tv_credits")
    Call<PersonCredits> tvCredits(@Path("person_id") int i, @Query("language") String str);
}
