package com.phimhd;

import android.util.Log;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.LiveTvSearchResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.p041ui.home.HomeParentItemAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ConfigHome.kt */
@Metadata(m108d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0006\u001a\u0010\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u0006\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, m107d2 = {"IPTV_API_NAME", "", "SPONSOR_API_NAME", "toHomePageList", "Lcom/lagradost/cloudstream3/HomePageList;", "Lcom/phimhd/Collection;", "Lcom/phimhd/ListIPTV;", "toLiveTvSearchResponse", "", "Lcom/lagradost/cloudstream3/LiveTvSearchResponse;", "toSearchResponse", "Lcom/lagradost/cloudstream3/MovieSearchResponse;", "Lcom/phimhd/Banner;", "app_release"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class ConfigHomeKt {
    public static final String IPTV_API_NAME = "iptv";
    public static final String SPONSOR_API_NAME = "sponsor";

    public static final HomePageList toHomePageList(ListIPTV listIPTV) {
        String str;
        Intrinsics.checkNotNullParameter(listIPTV, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listIPTV.getData().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((IPTV) next).getLink() != null) {
                arrayList.add(next);
            }
        }
        ArrayList<IPTV> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (IPTV iptv : arrayList2) {
            String title = iptv.getTitle();
            Intrinsics.checkNotNull(title);
            List<String> link = iptv.getLink();
            if (link == null || (str = (String) CollectionsKt.first((List<? extends Object>) link)) == null) {
                str = "";
            }
            TvType tvType = TvType.Movie;
            String thumbnail = iptv.getThumbnail();
            Intrinsics.checkNotNull(thumbnail);
            arrayList3.add(new MovieSearchResponse(title, str, IPTV_API_NAME, tvType, thumbnail, 0, null, null, null, 448, null));
        }
        return new HomePageList("TV", arrayList3, null, null, HomeParentItemAdapter.CardType.TV_CARD, 12, null);
    }

    public static final List<LiveTvSearchResponse> toLiveTvSearchResponse(ListIPTV listIPTV) {
        String str;
        Intrinsics.checkNotNullParameter(listIPTV, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listIPTV.getData().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((IPTV) next).getLink() != null) {
                arrayList.add(next);
            }
        }
        ArrayList<IPTV> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (IPTV iptv : arrayList2) {
            String title = iptv.getTitle();
            Intrinsics.checkNotNull(title);
            List<String> link = iptv.getLink();
            if (link == null || (str = (String) CollectionsKt.first((List<? extends Object>) link)) == null) {
                str = "";
            }
            TvType tvType = TvType.Movie;
            String thumbnail = iptv.getThumbnail();
            Intrinsics.checkNotNull(thumbnail);
            arrayList3.add(new LiveTvSearchResponse(title, str, IPTV_API_NAME, tvType, thumbnail, 0, null, null, null, 448, null));
        }
        return arrayList3;
    }

    public static final MovieSearchResponse toSearchResponse(Banner banner) {
        Intrinsics.checkNotNullParameter(banner, "<this>");
        String title = banner.getTitle();
        String urlDetail = banner.getUrlDetail();
        String str = "";
        String str2 = urlDetail == null ? "" : urlDetail;
        String urlPhoto = banner.getUrlPhoto();
        APIHolder aPIHolder = APIHolder.INSTANCE;
        String urlDetail2 = banner.getUrlDetail();
        if (urlDetail2 == null) {
            String urlStream = banner.getUrlStream();
            if (urlStream != null) {
                str = urlStream;
            }
        } else {
            str = urlDetail2;
        }
        return new MovieSearchResponse(title, str2, aPIHolder.getApiNameFromUrl(str), null, urlPhoto, null, null, null, null, 488, null);
    }

    public static final HomePageList toHomePageList(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        String name = collection.getName();
        List<MovieHome> movies = collection.getMovies();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(movies, 10));
        Iterator<T> it = movies.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            MovieHome movieHome = (MovieHome) it.next();
            Log.d("DuongKK", String.valueOf(movieHome));
            arrayList.add(new MovieSearchResponse(movieHome.getTitle(), movieHome.isSponsor() ? movieHome.getUrlStream() : movieHome.getUrlDetail(), movieHome.isSponsor() ? SPONSOR_API_NAME : APIHolder.INSTANCE.getApiNameFromUrl(movieHome.getUrlDetail()), TvType.Movie, movieHome.getUrlPhoto(), 0, null, null, null, 448, null));
        }
        ArrayList arrayList2 = arrayList;
        String urlDetail = collection.getUrlDetail();
        return new HomePageList(name, arrayList2, (urlDetail == null || StringsKt.isBlank(urlDetail)) ? true : true ? null : collection.getUrlDetail(), collection.getUrlDetail(), null, 16, null);
    }
}
