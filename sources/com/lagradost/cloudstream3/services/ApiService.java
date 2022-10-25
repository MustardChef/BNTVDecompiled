package com.lagradost.cloudstream3.services;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.subtitleproviders.MovieIMDB;
import com.lagradost.cloudstream3.subtitleproviders.SubtitleResponseOpenSubtitle;
import com.phimhd.Config;
import com.phimhd.Key;
import java.util.List;
import kotlin.Metadata;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;

/* compiled from: ApiService.kt */
@Metadata(m108d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0005H'J(\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0005H'J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\f\u001a\u00020\u0007H'J\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\f\u001a\u00020\u0007H'J\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\f\u001a\u00020\u0007H'J(\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u0007H'J\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\f\u001a\u00020\u0007H'J\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\b\b\u0001\u0010\u0018\u001a\u00020\u0019H'¨\u0006\u001a"}, m107d2 = {"Lcom/lagradost/cloudstream3/services/ApiService;", "", "checkKey", "Lretrofit2/Call;", "Lcom/lagradost/cloudstream3/services/ApiResponse;", "Lcom/phimhd/Key;", FirebaseAnalytics.Param.CONTENT_TYPE, "", "phone", "checkKeyWithToken", "downloadZipSubtitleFile", "Lokhttp3/ResponseBody;", "url", "getConfig", "Lcom/phimhd/Config;", "getInfoMovieFromIMDB", "Lcom/lagradost/cloudstream3/subtitleproviders/MovieIMDB;", "getSubtitleFromOpenSubtitles", "", "Lcom/lagradost/cloudstream3/subtitleproviders/SubtitleResponseOpenSubtitle;", "cookies", "getUrl", "upload", "Lcom/lagradost/cloudstream3/services/ResponseSubtitle;", "myFile", "Lokhttp3/MultipartBody$Part;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public interface ApiService {
    @POST("api/phimhd/checkKey")
    Call<ApiResponse<Key>> checkKey(@Header("Content-Type") String str, @Body Key key);

    @POST("api/phimhd/checkKeyWithToken")
    Call<ApiResponse<Key>> checkKeyWithToken(@Header("Content-Type") String str, @Body Key key);

    @GET
    Call<ResponseBody> downloadZipSubtitleFile(@Url String str);

    @GET
    Call<Config> getConfig(@Url String str);

    @GET
    Call<MovieIMDB> getInfoMovieFromIMDB(@Url String str);

    @GET
    Call<List<SubtitleResponseOpenSubtitle>> getSubtitleFromOpenSubtitles(@Header("X-User-Agent") String str, @Url String str2);

    @GET
    Call<ResponseBody> getUrl(@Url String str);

    @POST("http://phimhd.xyz:5035/uploadfile")
    @Multipart
    Call<ResponseSubtitle> upload(@Part MultipartBody.Part part);
}
