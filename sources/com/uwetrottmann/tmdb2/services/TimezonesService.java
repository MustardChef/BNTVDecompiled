package com.uwetrottmann.tmdb2.services;

import com.uwetrottmann.tmdb2.entities.Timezones;
import retrofit2.Call;
import retrofit2.http.GET;

/* loaded from: classes4.dex */
public interface TimezonesService {
    @GET("timezones/list")
    Call<Timezones> timezones();
}
