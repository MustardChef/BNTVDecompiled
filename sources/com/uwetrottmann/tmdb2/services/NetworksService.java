package com.uwetrottmann.tmdb2.services;

import com.uwetrottmann.tmdb2.entities.Network;
import com.uwetrottmann.tmdb2.entities.NetworkImages;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/* loaded from: classes4.dex */
public interface NetworksService {
    @GET("network/{id}/images")
    Call<NetworkImages> images(@Path("id") Integer num);

    @GET("network/{id}")
    Call<Network> summary(@Path("id") Integer num);
}
