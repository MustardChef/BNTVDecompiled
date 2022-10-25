package com.uwetrottmann.tmdb2.services;

import com.uwetrottmann.tmdb2.entities.Certifications;
import retrofit2.Call;
import retrofit2.http.GET;

/* loaded from: classes4.dex */
public interface CertificationsService {
    @GET("certification/movie/list")
    Call<Certifications> movie();

    @GET("certification/tv/list")
    /* renamed from: tv */
    Call<Certifications> m136tv();
}
