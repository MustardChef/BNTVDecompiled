package com.lagradost.cloudstream3.p041ui.home;

import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import com.bongngotv2.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.AcraApplication;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.utils.DataStoreKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: HomeFragment.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "apiName", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.home.HomeFragment$onViewCreated$3 */
/* loaded from: classes3.dex */
final class HomeFragment$onViewCreated$3 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeFragment$onViewCreated$3(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String apiName) {
        boolean z;
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        this.this$0.setCurrentApiName(apiName);
        AcraApplication.Companion.setKey(DataStoreKt.HOMEPAGE_API, apiName);
        ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) this.this$0._$_findCachedViewById(C4761R.C4764id.home_api_fab);
        if (extendedFloatingActionButton != null) {
            extendedFloatingActionButton.setText(apiName);
        }
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.home_provider_name);
        if (textView != null) {
            textView.setText(apiName);
        }
        try {
            SearchView searchView = (SearchView) this.this$0._$_findCachedViewById(C4761R.C4764id.home_search);
            if (searchView != null) {
                String string = this.this$0.getString(R.string.search_hint_site);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.search_hint_site)");
                String format = String.format(string, Arrays.copyOf(new Object[]{apiName}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                searchView.setQueryHint(format);
            }
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
        TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.home_provider_meta_info);
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        MainAPI apiFromNameNull = APIHolder.INSTANCE.getApiFromNameNull(apiName);
        if (apiFromNameNull != null) {
            HomeFragment homeFragment = this.this$0;
            Tuples[] tuplesArr = {new Tuples(Integer.valueOf((int) R.string.movies), CollectionsKt.listOf(TvType.Movie)), new Tuples(Integer.valueOf((int) R.string.tv_series), CollectionsKt.listOf(TvType.TvSeries)), new Tuples(Integer.valueOf((int) R.string.documentaries), CollectionsKt.listOf(TvType.Documentary)), new Tuples(Integer.valueOf((int) R.string.cartoons), CollectionsKt.listOf(TvType.Cartoon)), new Tuples(Integer.valueOf((int) R.string.anime), CollectionsKt.listOf((Object[]) new TvType[]{TvType.Anime, TvType.OVA, TvType.AnimeMovie})), new Tuples(Integer.valueOf((int) R.string.torrent), CollectionsKt.listOf(TvType.Torrent)), new Tuples(Integer.valueOf((int) R.string.asian_drama), CollectionsKt.listOf(TvType.AsianDrama))};
            ArrayList arrayList = new ArrayList();
            for (Object obj : CollectionsKt.listOf((Object[]) tuplesArr)) {
                Tuples tuples = (Tuples) obj;
                Set<TvType> supportedTypes = apiFromNameNull.getSupportedTypes();
                if (!(supportedTypes instanceof Collection) || !supportedTypes.isEmpty()) {
                    for (TvType tvType : supportedTypes) {
                        if (((List) tuples.getSecond()).contains(tvType)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (z) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            TextView textView3 = (TextView) homeFragment._$_findCachedViewById(C4761R.C4764id.home_provider_meta_info);
            if (textView3 != null) {
                textView3.setText(CollectionsKt.joinToString$default(arrayList2, ", ", null, null, 0, null, new HomeFragment$onViewCreated$3$1$1(homeFragment), 30, null));
            }
            TextView home_provider_meta_info = (TextView) homeFragment._$_findCachedViewById(C4761R.C4764id.home_provider_meta_info);
            if (home_provider_meta_info == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(home_provider_meta_info, "home_provider_meta_info");
            home_provider_meta_info.setVisibility(0);
        }
    }
}
