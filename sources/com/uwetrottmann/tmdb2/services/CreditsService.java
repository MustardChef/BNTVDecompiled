package com.uwetrottmann.tmdb2.services;

import com.uwetrottmann.tmdb2.entities.Credit;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/* loaded from: classes4.dex */
public interface CreditsService {
    @GET("credit/{id}")
    Call<Credit> credit(@Path("id") String str);
}
