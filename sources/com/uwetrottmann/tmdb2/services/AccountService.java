package com.uwetrottmann.tmdb2.services;

import com.uwetrottmann.tmdb2.entities.Account;
import com.uwetrottmann.tmdb2.entities.FavoriteMedia;
import com.uwetrottmann.tmdb2.entities.ListResultsPage;
import com.uwetrottmann.tmdb2.entities.MovieResultsPage;
import com.uwetrottmann.tmdb2.entities.Status;
import com.uwetrottmann.tmdb2.entities.TvEpisodeResultsPage;
import com.uwetrottmann.tmdb2.entities.TvShowResultsPage;
import com.uwetrottmann.tmdb2.entities.WatchlistMedia;
import com.uwetrottmann.tmdb2.enumerations.SortBy;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* loaded from: classes4.dex */
public interface AccountService {
    @POST("account/{account_id}/favorite")
    Call<Status> favorite(@Path("account_id") Integer num, @Body FavoriteMedia favoriteMedia);

    @GET("account/{account_id}/favorite/movies")
    Call<MovieResultsPage> favoriteMovies(@Path("account_id") Integer num, @Query("language") String str, @Query("sort_by") SortBy sortBy, @Query("page") Integer num2);

    @GET("account/{account_id}/favorite/tv")
    Call<TvShowResultsPage> favoriteTvShows(@Path("account_id") Integer num, @Query("language") String str, @Query("sort_by") SortBy sortBy, @Query("page") Integer num2);

    @GET("account/{account_id}/lists")
    Call<ListResultsPage> lists(@Path("account_id") Integer num);

    @GET("account/{account_id}/rated/movies")
    Call<MovieResultsPage> ratedMovies(@Path("account_id") Integer num, @Query("language") String str, @Query("sort_by") SortBy sortBy, @Query("page") Integer num2);

    @GET("account/{account_id}/rated/tv/episodes")
    Call<TvEpisodeResultsPage> ratedTvShowEpisodes(@Path("account_id") Integer num, @Query("language") String str, @Query("sort_by") SortBy sortBy, @Query("page") Integer num2);

    @GET("account/{account_id}/rated/tv")
    Call<TvShowResultsPage> ratedTvShows(@Path("account_id") Integer num, @Query("language") String str, @Query("sort_by") SortBy sortBy, @Query("page") Integer num2);

    @GET("account")
    Call<Account> summary();

    @POST("account/{account_id}/watchlist")
    Call<Status> watchlist(@Path("account_id") Integer num, @Body WatchlistMedia watchlistMedia);

    @GET("account/{account_id}/watchlist/movies")
    Call<MovieResultsPage> watchlistMovies(@Path("account_id") Integer num, @Query("language") String str, @Query("sort_by") SortBy sortBy, @Query("page") Integer num2);

    @GET("account/{account_id}/watchlist/tv")
    Call<TvShowResultsPage> watchlistTvShows(@Path("account_id") Integer num, @Query("language") String str, @Query("sort_by") SortBy sortBy, @Query("page") Integer num2);
}
