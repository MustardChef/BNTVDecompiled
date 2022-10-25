package com.uwetrottmann.tmdb2.services;

import com.uwetrottmann.tmdb2.entities.Configuration;
import com.uwetrottmann.tmdb2.entities.Jobs;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/* loaded from: classes4.dex */
public interface ConfigurationService {
    @GET("configuration")
    Call<Configuration> configuration();

    @GET("configuration/jobs")
    Call<List<Jobs>> jobs();
}
