package com.lagradost.cloudstream3.p041ui.search;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import androidx.preference.PreferenceManager;
import com.bongngotv2.R;
import com.lagradost.cloudstream3.SearchQuality;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.utils.DataStoreHelper;
import com.phimhd.ConfigHomeKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SearchResultBuilder.kt */
@Metadata(m108d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J[\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/search/SearchResultBuilder;", "", "()V", "showCache", "", "", "", "bind", "", "clickCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/ui/search/SearchClickCallback;", "card", "Lcom/lagradost/cloudstream3/SearchResponse;", "position", "", "itemView", "Landroid/view/View;", "nextFocusBehavior", "nextFocusUp", "nextFocusDown", "(Lkotlin/jvm/functions/Function1;Lcom/lagradost/cloudstream3/SearchResponse;ILandroid/view/View;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)V", "updateCache", "context", "Landroid/content/Context;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.search.SearchResultBuilder */
/* loaded from: classes4.dex */
public final class SearchResultBuilder {
    public static final SearchResultBuilder INSTANCE = new SearchResultBuilder();
    private static final Map<String, Boolean> showCache = new LinkedHashMap();

    /* compiled from: SearchResultBuilder.kt */
    @Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.search.SearchResultBuilder$WhenMappings */
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SearchQuality.values().length];
            iArr[SearchQuality.BlueRay.ordinal()] = 1;
            iArr[SearchQuality.Cam.ordinal()] = 2;
            iArr[SearchQuality.CamRip.ordinal()] = 3;
            iArr[SearchQuality.DVD.ordinal()] = 4;
            iArr[SearchQuality.HD.ordinal()] = 5;
            iArr[SearchQuality.HQ.ordinal()] = 6;
            iArr[SearchQuality.HdCam.ordinal()] = 7;
            iArr[SearchQuality.Telecine.ordinal()] = 8;
            iArr[SearchQuality.Telesync.ordinal()] = 9;
            iArr[SearchQuality.WorkPrint.ordinal()] = 10;
            iArr[SearchQuality.SD.ordinal()] = 11;
            iArr[SearchQuality.FourK.ordinal()] = 12;
            iArr[SearchQuality.UHD.ordinal()] = 13;
            iArr[SearchQuality.SDR.ordinal()] = 14;
            iArr[SearchQuality.HDR.ordinal()] = 15;
            iArr[SearchQuality.WebRip.ordinal()] = 16;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private SearchResultBuilder() {
    }

    public final void updateCache(Context context) {
        if (context == null) {
            return;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String[] stringArray = context.getResources().getStringArray(R.array.poster_ui_options_values);
        Intrinsics.checkNotNullExpressionValue(stringArray, "context.resources.getStr…poster_ui_options_values)");
        for (String k : stringArray) {
            Map<String, Boolean> map = showCache;
            Intrinsics.checkNotNullExpressionValue(k, "k");
            Boolean bool = map.get(k);
            map.put(k, Boolean.valueOf(defaultSharedPreferences.getBoolean(k, bool != null ? bool.booleanValue() : true)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:221:0x045a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void bind(final kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.p041ui.search.SearchClickCallback, kotlin.Unit> r25, final com.lagradost.cloudstream3.SearchResponse r26, final int r27, android.view.View r28, java.lang.Boolean r29, java.lang.Integer r30, java.lang.Integer r31) {
        /*
            Method dump skipped, instructions count: 1474
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.search.SearchResultBuilder.bind(kotlin.jvm.functions.Function1, com.lagradost.cloudstream3.SearchResponse, int, android.view.View, java.lang.Boolean, java.lang.Integer, java.lang.Integer):void");
    }

    private static final void bind$click(Function1<? super SearchClickCallback, Unit> function1, SearchResponse searchResponse, int i, View view) {
        int i2;
        if (searchResponse instanceof DataStoreHelper.ResumeWatchingResult) {
            i2 = 2;
        } else if (Intrinsics.areEqual(searchResponse.getApiName(), ConfigHomeKt.SPONSOR_API_NAME)) {
            i2 = 999;
        } else {
            i2 = Intrinsics.areEqual(searchResponse.getApiName(), ConfigHomeKt.IPTV_API_NAME) ? SearchAdaptorKt.SEARCH_ACTION_PLAY_FILE_IPTV : 0;
        }
        if (view == null) {
            return;
        }
        function1.invoke(new SearchClickCallback(i2, view, i, searchResponse));
    }

    private static final void bind$longClick(Function1<? super SearchClickCallback, Unit> function1, int i, SearchResponse searchResponse, View view) {
        if (view == null) {
            return;
        }
        function1.invoke(new SearchClickCallback(1, view, i, searchResponse));
    }

    private static final void bind$focus(Function1<? super SearchClickCallback, Unit> function1, int i, SearchResponse searchResponse, View view, boolean z) {
        if (!z || view == null) {
            return;
        }
        function1.invoke(new SearchClickCallback(4, view, i, searchResponse));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bind$lambda-7  reason: not valid java name */
    public static final void m8888bind$lambda7(Function1 clickCallback, SearchResponse card, int i, View view) {
        Intrinsics.checkNotNullParameter(clickCallback, "$clickCallback");
        Intrinsics.checkNotNullParameter(card, "$card");
        bind$click(clickCallback, card, i, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bind$lambda-8  reason: not valid java name */
    public static final void m8889bind$lambda8(Function1 clickCallback, SearchResponse card, int i, View view) {
        Intrinsics.checkNotNullParameter(clickCallback, "$clickCallback");
        Intrinsics.checkNotNullParameter(card, "$card");
        bind$click(clickCallback, card, i, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bind$lambda-9  reason: not valid java name */
    public static final boolean m8890bind$lambda9(Function1 clickCallback, int i, SearchResponse card, View view) {
        Intrinsics.checkNotNullParameter(clickCallback, "$clickCallback");
        Intrinsics.checkNotNullParameter(card, "$card");
        bind$longClick(clickCallback, i, card, view);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bind$lambda-10  reason: not valid java name */
    public static final boolean m8885bind$lambda10(Function1 clickCallback, int i, SearchResponse card, View view) {
        Intrinsics.checkNotNullParameter(clickCallback, "$clickCallback");
        Intrinsics.checkNotNullParameter(card, "$card");
        bind$longClick(clickCallback, i, card, view);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bind$lambda-11  reason: not valid java name */
    public static final void m8886bind$lambda11(Function1 clickCallback, int i, SearchResponse card, View view, boolean z) {
        Intrinsics.checkNotNullParameter(clickCallback, "$clickCallback");
        Intrinsics.checkNotNullParameter(card, "$card");
        bind$focus(clickCallback, i, card, view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bind$lambda-12  reason: not valid java name */
    public static final void m8887bind$lambda12(Function1 clickCallback, int i, SearchResponse card, View view, boolean z) {
        Intrinsics.checkNotNullParameter(clickCallback, "$clickCallback");
        Intrinsics.checkNotNullParameter(card, "$card");
        bind$focus(clickCallback, i, card, view, z);
    }
}
