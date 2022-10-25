package com.lagradost.cloudstream3.subtitleproviders;

import android.util.Log;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.services.ApiService;
import com.lagradost.cloudstream3.services.ApiUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import retrofit2.Response;

/* compiled from: OpenSubtitleProvider.kt */
@Metadata(m108d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002JM\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0004\u0012\u00020\u00060\u000eH\u0016¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/subtitleproviders/OpenSubtitleProvider;", "Lcom/lagradost/cloudstream3/subtitleproviders/SubtitleApi;", "()V", "getService", "Lcom/lagradost/cloudstream3/services/ApiService;", "getSubtitles", "", "title", "", "year", "lang", "isTvSeries", "", "callback", "Lkotlin/Function1;", "", "Lcom/lagradost/cloudstream3/SubtitleFile;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;)V", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class OpenSubtitleProvider extends SubtitleApi {
    private final ApiService getService() {
        return new ApiUtils().createApi();
    }

    @Override // com.lagradost.cloudstream3.subtitleproviders.SubtitleApi
    public void getSubtitles(String title, String str, String str2, Boolean bool, Function1<? super List<SubtitleFile>, Unit> callback) {
        MovieIMDB body;
        String imdbID;
        List<SubtitleResponseOpenSubtitle> listSub;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String replace$default = StringsKt.replace$default(StringsKt.replace$default(title, "(", "", false, 4, (Object) null), ")", "", false, 4, (Object) null);
        if (str != null) {
            replace$default = StringsKt.replace$default(replace$default, str, "", false, 4, (Object) null);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayListOf = CollectionsKt.arrayListOf("f395e338", "5161ca84", "7b72cfe2", "6f9425fa", "6d91a85b");
        String str3 = "http://www.omdbapi.com/?t=" + replace$default + "&apikey=" + ((String) CollectionsKt.random(arrayListOf, Random.Default)) + "&y=" + str;
        Log.d("DuongKK", "URL GETIMDB - " + str3);
        Response<MovieIMDB> execute = getService().getInfoMovieFromIMDB(str3).execute();
        if (!execute.isSuccessful() || (body = execute.body()) == null || (imdbID = body.getImdbID()) == null) {
            return;
        }
        String str4 = "https://rest.opensubtitles.org/search/imdbid-" + imdbID + "/sublanguageid-" + str2;
        Log.d("DuongKK", "URL GETSUB - " + str4);
        Response<List<SubtitleResponseOpenSubtitle>> execute2 = getService().getSubtitleFromOpenSubtitles("phimhd", str4).execute();
        if (!execute2.isSuccessful() || (listSub = execute2.body()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(listSub, "listSub");
        for (SubtitleResponseOpenSubtitle subtitleResponseOpenSubtitle : listSub) {
            String zipDownloadLink = subtitleResponseOpenSubtitle.getZipDownloadLink();
            String subFileName = subtitleResponseOpenSubtitle.getSubFileName();
            if (zipDownloadLink != null && subFileName != null) {
                arrayList.add(new SubtitleFile(String.valueOf(subFileName), zipDownloadLink, true));
            }
        }
        callback.invoke(arrayList);
    }
}
