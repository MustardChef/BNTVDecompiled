package com.uwetrottmann.tmdb2.services;

import com.uwetrottmann.tmdb2.entities.List;
import com.uwetrottmann.tmdb2.entities.ListCreateRequest;
import com.uwetrottmann.tmdb2.entities.ListCreateResponse;
import com.uwetrottmann.tmdb2.entities.ListItemStatus;
import com.uwetrottmann.tmdb2.entities.ListOperation;
import com.uwetrottmann.tmdb2.entities.Status;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* loaded from: classes4.dex */
public interface ListsService {
    @POST("list/{list_id}/add_item")
    Call<Status> addMovie(@Path("list_id") Integer num, @Body ListOperation listOperation);

    @POST("list/{list_id}/add_item")
    Call<Status> addMovie(@Path("list_id") String str, @Body ListOperation listOperation);

    @POST("list/{list_id}/clear")
    Call<Status> clear(@Path("list_id") Integer num, @Query("confirm") Boolean bool);

    @POST("list/{list_id}/clear")
    Call<Status> clear(@Path("list_id") String str, @Query("confirm") Boolean bool);

    @POST("list")
    Call<ListCreateResponse> createList(@Body ListCreateRequest listCreateRequest);

    @DELETE("list/{list_id}")
    Call<Status> delete(@Path("list_id") Integer num);

    @DELETE("list/{list_id}")
    Call<Status> delete(@Path("list_id") String str);

    @GET("list/{list_id}/item_status")
    Call<ListItemStatus> itemStatus(@Path("list_id") Integer num, @Query("movie_id") Integer num2);

    @GET("list/{list_id}/item_status")
    Call<ListItemStatus> itemStatus(@Path("list_id") String str, @Query("movie_id") Integer num);

    @POST("list/{list_id}/remove_item")
    Call<Status> removeMovie(@Path("list_id") Integer num, @Body ListOperation listOperation);

    @POST("list/{list_id}/remove_item")
    Call<Status> removeMovie(@Path("list_id") String str, @Body ListOperation listOperation);

    @GET("list/{list_id}")
    Call<List> summary(@Path("list_id") Integer num);

    @GET("list/{list_id}")
    Call<List> summary(@Path("list_id") String str);
}
