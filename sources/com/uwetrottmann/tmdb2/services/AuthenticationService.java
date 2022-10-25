package com.uwetrottmann.tmdb2.services;

import com.uwetrottmann.tmdb2.entities.GuestSession;
import com.uwetrottmann.tmdb2.entities.RequestToken;
import com.uwetrottmann.tmdb2.entities.Session;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* loaded from: classes4.dex */
public interface AuthenticationService {
    @GET("authentication/guest_session/new")
    Call<GuestSession> createGuestSession();

    @GET("authentication/session/new")
    Call<Session> createSession(@Query("request_token") String str);

    @GET("authentication/token/new")
    Call<RequestToken> requestToken();

    @GET("authentication/token/validate_with_login")
    Call<RequestToken> validateToken(@Query("username") String str, @Query("password") String str2, @Query("request_token") String str3);
}
