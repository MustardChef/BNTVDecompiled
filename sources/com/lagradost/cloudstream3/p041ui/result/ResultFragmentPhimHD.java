package com.lagradost.cloudstream3.p041ui.result;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.mediarouter.app.MediaRouteButton;
import androidx.recyclerview.widget.RecyclerView;
import com.bongngotv2.R;
import com.discord.panels.OverlappingPanelsLayout;
import com.discord.panels.PanelsChildGestureRegionObserver;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.slider.Slider;
import com.lagradost.cloudstream3.AcraApplication;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.DubStatus;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivity;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.p041ui.AutofitRecyclerView;
import com.lagradost.cloudstream3.p041ui.WatchType;
import com.lagradost.cloudstream3.p041ui.download.EasyDownloadButton;
import com.lagradost.cloudstream3.p041ui.player.SubtitleData;
import com.lagradost.cloudstream3.p041ui.search.SearchAdaptor;
import com.lagradost.cloudstream3.p041ui.settings.SettingsFragment;
import com.lagradost.cloudstream3.p041ui.subtitles.SubtitlesFragment;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.Coroutines;
import com.lagradost.cloudstream3.utils.DataStore;
import com.lagradost.cloudstream3.utils.DataStoreHelper;
import com.lagradost.cloudstream3.utils.DataStoreKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorSubtitleLink;
import com.lagradost.cloudstream3.utils.SingleSelectionHelper;
import com.lagradost.cloudstream3.utils.SubtitleHelper;
import com.lagradost.cloudstream3.utils.UIHelper;
import com.lagradost.cloudstream3.utils.VideoDownloadHelper;
import com.lagradost.cloudstream3.utils.VideoDownloadManager;
import com.phimhd.AppController;
import com.phimhd.Key;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;

/* compiled from: ResultFragmentPhimHD.kt */
@Metadata(m108d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 e2\u00020\u00012\u00020\u0002:\u0002efB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010*\u001a\u00020+H\u0002J\u0017\u0010,\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\bJ\u0010\u00102\u001a\u00020+2\u0006\u00103\u001a\u00020\rH\u0002J\u0018\u00104\u001a\u00020+2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\bH\u0002J\u0010\u00108\u001a\u00020+2\u0006\u00109\u001a\u00020:H\u0016J&\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020+H\u0016J\b\u0010D\u001a\u00020+H\u0016J\u0016\u0010E\u001a\u00020+2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u0005H\u0016J\b\u0010H\u001a\u00020+H\u0016J\b\u0010I\u001a\u00020+H\u0016J\u001a\u0010J\u001a\u00020+2\u0006\u0010K\u001a\u00020<2\b\u0010A\u001a\u0004\u0018\u00010BH\u0017J\u0018\u0010L\u001a\u00020+2\u000e\u0010M\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010\u0005H\u0002J\u0017\u0010O\u001a\u00020+2\b\u0010P\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010\u001dJ&\u0010Q\u001a\u00020+2\b\u0010R\u001a\u0004\u0018\u00010S2\b\b\u0001\u0010T\u001a\u00020\n2\b\u0010U\u001a\u0004\u0018\u00010VH\u0002J\u0017\u0010W\u001a\u00020+2\b\u0010X\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010\u001dJ\"\u0010Y\u001a\u00020+2\u000e\u0010Z\u001a\n\u0012\u0004\u0012\u00020[\u0018\u00010\u00052\b\u0010\\\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010]\u001a\u00020+2\b\u0010^\u001a\u0004\u0018\u00010_H\u0002J\u0017\u0010`\u001a\u00020+2\b\u0010a\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010\u001dJ\b\u0010b\u001a\u00020+H\u0002J\u0010\u0010c\u001a\u00020+2\u0006\u0010d\u001a\u00020\nH\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000¨\u0006g"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/result/ResultFragmentPhimHD;", "Landroidx/fragment/app/Fragment;", "Lcom/discord/panels/PanelsChildGestureRegionObserver$GestureRegionsListener;", "()V", "currentEpisodes", "", "Lcom/lagradost/cloudstream3/ui/result/ResultEpisode;", "currentHeaderName", "", "currentId", "", "Ljava/lang/Integer;", "currentIsMovie", "", "Ljava/lang/Boolean;", "currentLoadingCount", "currentPoster", "currentType", "Lcom/lagradost/cloudstream3/TvType;", "downloadButton", "Lcom/lagradost/cloudstream3/ui/download/EasyDownloadButton;", "dubRange", "", "Lcom/lagradost/cloudstream3/DubStatus;", "episodeRanges", "startAction", "getStartAction", "()Ljava/lang/Integer;", "setStartAction", "(Ljava/lang/Integer;)V", "startValue", "syncModel", "Lcom/lagradost/cloudstream3/ui/result/SyncViewModel;", "syncdata", "", "url", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "viewModel", "Lcom/lagradost/cloudstream3/ui/result/ResultViewModel;", "fixGrid", "", "fromIndexToSeasonText", "selection", "(Ljava/lang/Integer;)Ljava/lang/String;", "getHtmlComment", "idPost", "shortName", "lateFixDownloadButton", "show", "loadComments", "web", "Landroid/webkit/WebView;", "urlReview", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDestroyView", "onGestureRegionsUpdate", "gestureRegions", "Landroid/graphics/Rect;", "onPause", "onResume", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "setActors", "actors", "Lcom/lagradost/cloudstream3/ActorData;", "setDuration", TypedValues.TransitionType.S_DURATION, "setFormatText", "textView", "Landroid/widget/TextView;", "format", "arg", "", "setRating", "rating", "setRecommendations", "rec", "Lcom/lagradost/cloudstream3/SearchResponse;", "validApiName", "setShow", "showStatus", "Lcom/lagradost/cloudstream3/ShowStatus;", "setYear", "year", "updateUI", "updateVisStatus", ServerProtocol.DIALOG_PARAM_STATE, "Companion", "UriWebViewClient", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD */
/* loaded from: classes4.dex */
public final class ResultFragmentPhimHD extends Fragment implements PanelsChildGestureRegionObserver.GestureRegionsListener {
    public static final String API_NAME_BUNDLE = "apiName";
    public static final Companion Companion = new Companion(null);
    public static final String EPISODE_BUNDLE = "episode";
    public static final String RESTART_BUNDLE = "restart";
    public static final String SEASON_BUNDLE = "season";
    public static final String START_ACTION_BUNDLE = "startAction";
    public static final String START_VALUE_BUNDLE = "startValue";
    public static final String URL_BUNDLE = "url";
    private static Functions<Unit> updateUIListener;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private List<ResultEpisode> currentEpisodes;
    private String currentHeaderName;
    private Integer currentId;
    private Boolean currentIsMovie;
    private int currentLoadingCount;
    private String currentPoster;
    private TvType currentType;
    private EasyDownloadButton downloadButton;
    private Set<? extends DubStatus> dubRange;
    private List<String> episodeRanges;
    private Integer startAction;
    private Integer startValue;
    private SyncViewModel syncModel;
    private Map<String, String> syncdata;
    private String url;
    private ResultViewModel viewModel;

    /* compiled from: ResultFragmentPhimHD.kt */
    @Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD$WhenMappings */
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ShowStatus.values().length];
            iArr[ShowStatus.Ongoing.ordinal()] = 1;
            iArr[ShowStatus.Completed.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    /* compiled from: ResultFragmentPhimHD.kt */
    @Metadata(m108d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J[\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\"\u0010\u001e\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J*\u0010\u001e\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u0004H\u0002J8\u0010*\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u0017H\u0002J)\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020\u001b2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u00102J*\u0010,\u001a\u00020-2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u00020\u001b2\b\b\u0002\u00101\u001a\u00020\u001bJn\u00103\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\f\u00104\u001a\b\u0012\u0004\u0012\u000206052\u000e\u00107\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u000105J\u0006\u00108\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00069"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/result/ResultFragmentPhimHD$Companion;", "", "()V", "API_NAME_BUNDLE", "", "EPISODE_BUNDLE", "RESTART_BUNDLE", "SEASON_BUNDLE", "START_ACTION_BUNDLE", "START_VALUE_BUNDLE", "URL_BUNDLE", "updateUIListener", "Lkotlin/Function0;", "", "downloadEpisode", "activity", "Landroid/app/Activity;", "episode", "Lcom/lagradost/cloudstream3/ui/result/ResultEpisode;", "currentIsMovie", "", "currentHeaderName", "currentType", "Lcom/lagradost/cloudstream3/TvType;", "currentPoster", "apiName", "parentId", "", "url", "(Landroid/app/Activity;Lcom/lagradost/cloudstream3/ui/result/ResultEpisode;ZLjava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadSubtitle", "context", "Landroid/content/Context;", "link", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", "meta", "Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadEpisodeMetadata;", "Lcom/lagradost/cloudstream3/utils/ExtractorSubtitleLink;", "fileName", "folder", "getFolder", "titleName", "getMeta", "tvType", "newInstance", "Landroid/os/Bundle;", "card", "Lcom/lagradost/cloudstream3/SearchResponse;", "startAction", "startValue", "(Lcom/lagradost/cloudstream3/SearchResponse;ILjava/lang/Integer;)Landroid/os/Bundle;", "startDownload", "links", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "subs", "updateUI", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD$Companion */
    /* loaded from: classes4.dex */
    public static final class Companion {

        /* compiled from: ResultFragmentPhimHD.kt */
        @Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
        /* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD$Companion$WhenMappings */
        /* loaded from: classes4.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[TvType.values().length];
                iArr[TvType.Anime.ordinal()] = 1;
                iArr[TvType.Movie.ordinal()] = 2;
                iArr[TvType.AnimeMovie.ordinal()] = 3;
                iArr[TvType.TvSeries.ordinal()] = 4;
                iArr[TvType.OVA.ordinal()] = 5;
                iArr[TvType.Cartoon.ordinal()] = 6;
                iArr[TvType.Torrent.ordinal()] = 7;
                iArr[TvType.Documentary.ordinal()] = 8;
                iArr[TvType.AsianDrama.ordinal()] = 9;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Bundle newInstance$default(Companion companion, SearchResponse searchResponse, int i, Integer num, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            if ((i2 & 4) != 0) {
                num = null;
            }
            return companion.newInstance(searchResponse, i, num);
        }

        public final Bundle newInstance(SearchResponse card, int i, Integer num) {
            Intrinsics.checkNotNullParameter(card, "card");
            Bundle bundle = new Bundle();
            bundle.putString("url", card.getUrl());
            bundle.putString("apiName", card.getApiName());
            if (card instanceof DataStoreHelper.ResumeWatchingResult) {
                DataStoreHelper.ResumeWatchingResult resumeWatchingResult = (DataStoreHelper.ResumeWatchingResult) card;
                if (resumeWatchingResult.getSeason() != null) {
                    bundle.putInt("season", resumeWatchingResult.getSeason().intValue());
                }
                if (resumeWatchingResult.getEpisode() != null) {
                    bundle.putInt("episode", resumeWatchingResult.getEpisode().intValue());
                }
            }
            bundle.putInt("startAction", i);
            if (num != null) {
                bundle.putInt("startValue", num.intValue());
            }
            bundle.putBoolean("restart", true);
            return bundle;
        }

        public static /* synthetic */ Bundle newInstance$default(Companion companion, String str, String str2, int i, int i2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                i = 0;
            }
            if ((i3 & 8) != 0) {
                i2 = 0;
            }
            return companion.newInstance(str, str2, i, i2);
        }

        public final Bundle newInstance(String url, String apiName, int i, int i2) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(apiName, "apiName");
            Bundle bundle = new Bundle();
            bundle.putString("url", url);
            bundle.putString("apiName", apiName);
            bundle.putInt("startAction", i);
            bundle.putInt("startValue", i2);
            bundle.putBoolean("restart", true);
            return bundle;
        }

        public final void updateUI() {
            Functions functions = ResultFragmentPhimHD.updateUIListener;
            if (functions != null) {
                functions.invoke();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void downloadSubtitle(Context context, SubtitleData subtitleData, VideoDownloadManager.DownloadEpisodeMetadata downloadEpisodeMetadata) {
            if (context != null) {
                String fileName = VideoDownloadManager.INSTANCE.getFileName(context, downloadEpisodeMetadata);
                Companion companion = ResultFragmentPhimHD.Companion;
                TvType type = downloadEpisodeMetadata.getType();
                if (type == null) {
                    return;
                }
                ResultFragmentPhimHD.Companion.downloadSubtitle(context, new ExtractorSubtitleLink(subtitleData.getName(), subtitleData.getUrl(), "", null, 8, null), fileName, companion.getFolder(type, downloadEpisodeMetadata.getMainName()));
            }
        }

        private final void downloadSubtitle(Context context, ExtractorSubtitleLink extractorSubtitleLink, String str, String str2) {
            Coroutines.INSTANCE.ioSafe(new ResultFragmentPhimHD$Companion$downloadSubtitle$2(context, extractorSubtitleLink, str, str2, null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final VideoDownloadManager.DownloadEpisodeMetadata getMeta(ResultEpisode resultEpisode, String str, String str2, String str3, boolean z, TvType tvType) {
            int id = resultEpisode.getId();
            String sanitizeFilename = VideoDownloadManager.INSTANCE.sanitizeFilename(str);
            String poster = resultEpisode.getPoster();
            return new VideoDownloadManager.DownloadEpisodeMetadata(id, sanitizeFilename, str2, poster == null ? str3 : poster, resultEpisode.getName(), z ? null : resultEpisode.getSeason(), z ? null : Integer.valueOf(resultEpisode.getEpisode()), tvType);
        }

        private final String getFolder(TvType tvType, String str) {
            String sanitizeFilename = VideoDownloadManager.INSTANCE.sanitizeFilename(str);
            switch (WhenMappings.$EnumSwitchMapping$0[tvType.ordinal()]) {
                case 1:
                    return "Anime/" + sanitizeFilename;
                case 2:
                case 3:
                    return "Movies";
                case 4:
                    return "TVSeries/" + sanitizeFilename;
                case 5:
                    return "OVA";
                case 6:
                    return "Cartoons/" + sanitizeFilename;
                case 7:
                    return "Torrent";
                case 8:
                    return "Documentaries";
                case 9:
                    return "AsianDrama";
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        public final void startDownload(Context context, ResultEpisode episode, boolean z, String currentHeaderName, TvType currentType, String currentPoster, String apiName, int i, String url, List<? extends ExtractorLink> links, List<SubtitleData> list) {
            Intrinsics.checkNotNullParameter(episode, "episode");
            Intrinsics.checkNotNullParameter(currentHeaderName, "currentHeaderName");
            Intrinsics.checkNotNullParameter(currentType, "currentType");
            Intrinsics.checkNotNullParameter(currentPoster, "currentPoster");
            Intrinsics.checkNotNullParameter(apiName, "apiName");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(links, "links");
            if (context == null) {
                return;
            }
            try {
                VideoDownloadManager.DownloadEpisodeMetadata meta = getMeta(episode, currentHeaderName, apiName, currentPoster, z, currentType);
                String folder = getFolder(currentType, currentHeaderName);
                AcraApplication.Companion.setKey(DataStoreKt.DOWNLOAD_HEADER_CACHE, String.valueOf(i), new VideoDownloadHelper.DownloadHeaderCached(apiName, url, currentType, currentHeaderName, currentPoster, i, System.currentTimeMillis()));
                AcraApplication.Companion.setKey(DataStore.INSTANCE.getFolderName(DataStoreKt.DOWNLOAD_EPISODE_CACHE, String.valueOf(i)), String.valueOf(episode.getId()), new VideoDownloadHelper.DownloadEpisodeCached(episode.getName(), episode.getPoster(), episode.getEpisode(), episode.getSeason(), episode.getId(), i, episode.getRating(), episode.getDescription(), System.currentTimeMillis()));
                VideoDownloadManager.INSTANCE.downloadEpisodeUsingWorker(context, "downloadpage/" + i, folder, meta, links);
                List<String> downloadSubsLanguageISO639_1 = SubtitlesFragment.Companion.getDownloadSubsLanguageISO639_1();
                if (list != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list) {
                        if (CollectionsKt.contains(downloadSubsLanguageISO639_1, SubtitleHelper.INSTANCE.fromLanguageToTwoLetters(((SubtitleData) obj).getName(), true))) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList<SubtitleData> arrayList2 = arrayList;
                    ArrayList<ExtractorSubtitleLink> arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                    for (SubtitleData subtitleData : arrayList2) {
                        arrayList3.add(new ExtractorSubtitleLink(subtitleData.getName(), subtitleData.getUrl(), "", null, 8, null));
                    }
                    for (ExtractorSubtitleLink extractorSubtitleLink : arrayList3) {
                        ResultFragmentPhimHD.Companion.downloadSubtitle(context, extractorSubtitleLink, VideoDownloadManager.INSTANCE.getFileName(context, meta), folder);
                    }
                }
            } catch (Exception e) {
                ArchComponentExt.logError(e);
            }
        }

        public final Object downloadEpisode(Activity activity, ResultEpisode resultEpisode, boolean z, String str, TvType tvType, String str2, String str3, int i, String str4, Continuation<? super Unit> continuation) {
            AppController companion = AppController.Companion.getInstance();
            if ((companion != null ? companion.getKey() : null) != null) {
                AppController companion2 = AppController.Companion.getInstance();
                Key key = companion2 != null ? companion2.getKey() : null;
                Intrinsics.checkNotNull(key);
                if (key.isExpired()) {
                    Log.d("DuongKK", "start Countdownads");
                    Objects.requireNonNull(activity, "null cannot be cast to non-null type com.lagradost.cloudstream3.MainActivity");
                    ((MainActivity) activity).showDialogUpgrade();
                    return Unit.INSTANCE;
                }
                CommonActivity.INSTANCE.showToast(activity, R.string.download_started, 0);
                Object safeApiCall = ArchComponentExt.safeApiCall(new ResultFragmentPhimHD$Companion$downloadEpisode$2(resultEpisode, activity, z, str, tvType, str2, str3, i, str4, null), continuation);
                return safeApiCall == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? safeApiCall : Unit.INSTANCE;
            }
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.lagradost.cloudstream3.MainActivity");
            ((MainActivity) activity).showDialogUpgrade();
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ResultFragmentPhimHD resultFragmentPhimHD = this;
        this.viewModel = (ResultViewModel) new ViewModelProvider(resultFragmentPhimHD).get(ResultViewModel.class);
        this.syncModel = (SyncViewModel) new ViewModelProvider(resultFragmentPhimHD).get(SyncViewModel.class);
        return inflater.inflate(R.layout.fragment_result_swipe, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C4761R.C4764id.result_episodes);
        EpisodeAdapter episodeAdapter = (EpisodeAdapter) (recyclerView != null ? recyclerView.getAdapter() : null);
        if (episodeAdapter != null) {
            episodeAdapter.killAdapter();
        }
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        EasyDownloadButton easyDownloadButton = this.downloadButton;
        if (easyDownloadButton != null) {
            easyDownloadButton.dispose();
        }
        updateUIListener = null;
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C4761R.C4764id.result_cast_items);
        if (recyclerView != null) {
            PanelsChildGestureRegionObserver.Provider.get().unregister(recyclerView);
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Window window;
        super.onResume();
        FragmentActivity activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.setNavigationBarColor(UIHelper.INSTANCE.colorFromAttribute(activity, R.attr.primaryBlackBackground));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0086, code lost:
        if ((r5.getVisibility() == 0) == true) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void updateVisStatus(int r5) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.result.ResultFragmentPhimHD.updateVisStatus(int):void");
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String fromIndexToSeasonText(Integer num) {
        if (num == null) {
            String string = getString(R.string.no_season);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.no_season)");
            return string;
        } else if (num.intValue() == -2) {
            String string2 = getString(R.string.no_season);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.no_season)");
            return string2;
        } else {
            return getString(R.string.season) + ' ' + num;
        }
    }

    public final Integer getStartAction() {
        return this.startAction;
    }

    public final void setStartAction(Integer num) {
        this.startAction = num;
    }

    private final void setFormatText(TextView textView, int i, Object obj) {
        ArchComponentExt.normalSafeApiCall(new ResultFragmentPhimHD$setFormatText$1(obj, textView, this, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDuration(Integer num) {
        setFormatText((TextView) _$_findCachedViewById(C4761R.C4764id.result_meta_duration), R.string.duration_format, num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setShow(ShowStatus showStatus) {
        Integer num;
        String string;
        TextView textView;
        int i = showStatus == null ? -1 : WhenMappings.$EnumSwitchMapping$0[showStatus.ordinal()];
        if (i == -1) {
            num = null;
        } else if (i == 1) {
            num = Integer.valueOf((int) R.string.status_ongoing);
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            num = Integer.valueOf((int) R.string.status_completed);
        }
        if (num == null) {
            TextView textView2 = (TextView) _$_findCachedViewById(C4761R.C4764id.result_meta_status);
            if (textView2 == null) {
                return;
            }
            textView2.setVisibility(8);
            return;
        }
        Context context = getContext();
        if (context == null || (string = context.getString(num.intValue())) == null || (textView = (TextView) _$_findCachedViewById(C4761R.C4764id.result_meta_status)) == null) {
            return;
        }
        textView.setText(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setYear(Integer num) {
        setFormatText((TextView) _$_findCachedViewById(C4761R.C4764id.result_meta_year), R.string.year_format, num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRating(Integer num) {
        setFormatText((TextView) _$_findCachedViewById(C4761R.C4764id.result_meta_rating), R.string.rating_format, num != null ? Float.valueOf(num.intValue() / 1000.0f) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setActors(List<ActorData> list) {
        List<ActorData> list2 = list;
        boolean z = true;
        if (list2 == null || list2.isEmpty()) {
            TextView textView = (TextView) _$_findCachedViewById(C4761R.C4764id.result_cast_text);
            if (textView != null) {
                textView.setVisibility(0);
            }
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C4761R.C4764id.result_cast_items);
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            setFormatText((TextView) _$_findCachedViewById(C4761R.C4764id.result_cast_text), R.string.cast_format, getString(R.string.updating));
            return;
        }
        if (((ActorData) CollectionsKt.first((List<? extends Object>) list)).getActor().getImage() != null) {
            Context context = getContext();
            if ((context == null || !SettingsFragment.Companion.isTvSettings(context)) ? false : false) {
                RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C4761R.C4764id.result_cast_items);
                ActorAdaptor actorAdaptor = (ActorAdaptor) (recyclerView2 != null ? recyclerView2.getAdapter() : null);
                if (actorAdaptor != null) {
                    actorAdaptor.updateList(list);
                }
                TextView textView2 = (TextView) _$_findCachedViewById(C4761R.C4764id.result_cast_text);
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                RecyclerView recyclerView3 = (RecyclerView) _$_findCachedViewById(C4761R.C4764id.result_cast_items);
                if (recyclerView3 == null) {
                    return;
                }
                recyclerView3.setVisibility(0);
                return;
            }
        }
        TextView textView3 = (TextView) _$_findCachedViewById(C4761R.C4764id.result_cast_text);
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        RecyclerView recyclerView4 = (RecyclerView) _$_findCachedViewById(C4761R.C4764id.result_cast_items);
        if (recyclerView4 != null) {
            recyclerView4.setVisibility(8);
        }
        setFormatText((TextView) _$_findCachedViewById(C4761R.C4764id.result_cast_text), R.string.cast_format, CollectionsKt.joinToString$default(list, null, null, null, 0, null, ResultFragmentPhimHD$setActors$2.INSTANCE, 31, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRecommendations(final List<? extends SearchResponse> list, final String str) {
        MaterialButton result_recommendations_filter_button;
        SearchResponse searchResponse;
        List<? extends SearchResponse> list2 = list;
        boolean z = list2 == null || list2.isEmpty();
        ImageView imageView = (ImageView) _$_findCachedViewById(C4761R.C4764id.result_recommendations_btt);
        if (imageView != null) {
            imageView.setVisibility(z ? 8 : 0);
        }
        ImageView imageView2 = (ImageView) _$_findCachedViewById(C4761R.C4764id.result_recommendations_btt);
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$ResultFragmentPhimHD$NHzZk2JY4iye8KqdNlANecH56WQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResultFragmentPhimHD.m8780setRecommendations$lambda4(ResultFragmentPhimHD.this, view);
                }
            });
        }
        OverlappingPanelsLayout overlappingPanelsLayout = (OverlappingPanelsLayout) _$_findCachedViewById(C4761R.C4764id.result_overlapping_panels);
        if (overlappingPanelsLayout != null) {
            overlappingPanelsLayout.setEndPanelLockState(OverlappingPanelsLayout.LockState.CLOSE);
        }
        Unit unit = null;
        if (str == null) {
            str = (list == null || (searchResponse = (SearchResponse) CollectionsKt.firstOrNull((List<? extends Object>) list)) == null) ? null : searchResponse.getApiName();
        }
        if (list != null) {
            List<? extends SearchResponse> list3 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            for (SearchResponse searchResponse2 : list3) {
                arrayList.add(searchResponse2.getApiName());
            }
            final List distinct = CollectionsKt.distinct(arrayList);
            if (distinct != null) {
                MaterialButton result_recommendations_filter_button2 = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.result_recommendations_filter_button);
                if (result_recommendations_filter_button2 != null) {
                    Intrinsics.checkNotNullExpressionValue(result_recommendations_filter_button2, "result_recommendations_filter_button");
                    result_recommendations_filter_button2.setVisibility(distinct.size() > 1 ? 0 : 8);
                }
                MaterialButton materialButton = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.result_recommendations_filter_button);
                if (materialButton != null) {
                    materialButton.setText(str);
                }
                MaterialButton materialButton2 = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.result_recommendations_filter_button);
                if (materialButton2 != null) {
                    materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$ResultFragmentPhimHD$WCz3dbeIpGSSoeYFiK7tQp58AdA
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ResultFragmentPhimHD.m8781setRecommendations$lambda7$lambda6(ResultFragmentPhimHD.this, distinct, str, list, view);
                        }
                    });
                    unit = Unit.INSTANCE;
                }
            }
        }
        if (unit == null && (result_recommendations_filter_button = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.result_recommendations_filter_button)) != null) {
            Intrinsics.checkNotNullExpressionValue(result_recommendations_filter_button, "result_recommendations_filter_button");
            result_recommendations_filter_button.setVisibility(8);
        }
        AutofitRecyclerView autofitRecyclerView = (AutofitRecyclerView) _$_findCachedViewById(C4761R.C4764id.result_recommendations);
        if (autofitRecyclerView != null) {
            autofitRecyclerView.post(new Runnable() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$ResultFragmentPhimHD$oaayFelw591rzhZ9GNQKkYqbZ_Q
                @Override // java.lang.Runnable
                public final void run() {
                    ResultFragmentPhimHD.m8779setRecommendations$lambda11(list, this, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setRecommendations$lambda-4  reason: not valid java name */
    public static final void m8780setRecommendations$lambda4(ResultFragmentPhimHD this$0, View view) {
        int i;
        OverlappingPanelsLayout.Panel selectedPanel;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OverlappingPanelsLayout overlappingPanelsLayout = (OverlappingPanelsLayout) this$0._$_findCachedViewById(C4761R.C4764id.result_overlapping_panels);
        boolean z = true;
        if ((overlappingPanelsLayout == null || (selectedPanel = overlappingPanelsLayout.getSelectedPanel()) == null || selectedPanel.ordinal() != 1) ? false : false) {
            OverlappingPanelsLayout overlappingPanelsLayout2 = (OverlappingPanelsLayout) this$0._$_findCachedViewById(C4761R.C4764id.result_overlapping_panels);
            if (overlappingPanelsLayout2 != null) {
                overlappingPanelsLayout2.openEndPanel();
            }
            i = R.id.result_recommendations;
        } else {
            OverlappingPanelsLayout overlappingPanelsLayout3 = (OverlappingPanelsLayout) this$0._$_findCachedViewById(C4761R.C4764id.result_overlapping_panels);
            if (overlappingPanelsLayout3 != null) {
                overlappingPanelsLayout3.closePanels();
            }
            i = R.id.result_description;
        }
        ImageView imageView = (ImageView) this$0._$_findCachedViewById(C4761R.C4764id.result_recommendations_btt);
        if (imageView != null) {
            imageView.setNextFocusDownId(i);
        }
        MaterialButton materialButton = (MaterialButton) this$0._$_findCachedViewById(C4761R.C4764id.result_search);
        if (materialButton != null) {
            materialButton.setNextFocusDownId(i);
        }
        MaterialButton materialButton2 = (MaterialButton) this$0._$_findCachedViewById(C4761R.C4764id.result_open_in_browser);
        if (materialButton2 != null) {
            materialButton2.setNextFocusDownId(i);
        }
        MaterialButton materialButton3 = (MaterialButton) this$0._$_findCachedViewById(C4761R.C4764id.result_share);
        if (materialButton3 == null) {
            return;
        }
        materialButton3.setNextFocusDownId(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setRecommendations$lambda-7$lambda-6  reason: not valid java name */
    public static final void m8781setRecommendations$lambda7$lambda6(ResultFragmentPhimHD this$0, List apiNames, String str, List list, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(apiNames, "$apiNames");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            int indexOf = CollectionsKt.indexOf((List<? extends String>) apiNames, str);
            String string = this$0.getString(R.string.home_change_provider_img_des);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.home_change_provider_img_des)");
            SingleSelectionHelper.INSTANCE.showBottomDialog(activity, apiNames, indexOf, string, false, ResultFragmentPhimHD$setRecommendations$3$1$1.INSTANCE, new ResultFragmentPhimHD$setRecommendations$3$1$2(this$0, list, apiNames));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setRecommendations$lambda-11  reason: not valid java name */
    public static final void m8779setRecommendations$lambda11(List list, ResultFragmentPhimHD this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (list != null) {
            AutofitRecyclerView autofitRecyclerView = (AutofitRecyclerView) this$0._$_findCachedViewById(C4761R.C4764id.result_recommendations);
            SearchAdaptor searchAdaptor = (SearchAdaptor) (autofitRecyclerView != null ? autofitRecyclerView.getAdapter() : null);
            if (searchAdaptor != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (Intrinsics.areEqual(((SearchResponse) obj).getApiName(), str)) {
                        arrayList.add(obj);
                    }
                }
                searchAdaptor.updateList(arrayList);
            }
        }
    }

    private final void fixGrid() {
        Integer spanCount;
        FragmentActivity activity = getActivity();
        if (activity == null || (spanCount = UIHelper.INSTANCE.getSpanCount(activity)) == null) {
            return;
        }
        spanCount.intValue();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        fixGrid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void lateFixDownloadButton(boolean z) {
        if (z) {
            TvType tvType = this.currentType;
            if (!((tvType == null || MainAPIKt.isMovieType(tvType)) ? false : true)) {
                ((LinearLayout) _$_findCachedViewById(C4761R.C4764id.result_movie_parent)).setVisibility(0);
                ((TextView) _$_findCachedViewById(C4761R.C4764id.result_episodes_text)).setVisibility(8);
                ((RecyclerView) _$_findCachedViewById(C4761R.C4764id.result_episodes)).setVisibility(8);
                return;
            }
        }
        ((LinearLayout) _$_findCachedViewById(C4761R.C4764id.result_movie_parent)).setVisibility(0);
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.frame_download);
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        ((TextView) _$_findCachedViewById(C4761R.C4764id.result_episodes_text)).setVisibility(0);
        ((RecyclerView) _$_findCachedViewById(C4761R.C4764id.result_episodes)).setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUI() {
        SyncViewModel syncViewModel = this.syncModel;
        ResultViewModel resultViewModel = null;
        if (syncViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncModel");
            syncViewModel = null;
        }
        syncViewModel.updateUserData();
        ResultViewModel resultViewModel2 = this.viewModel;
        if (resultViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            resultViewModel = resultViewModel2;
        }
        resultViewModel.reloadEpisodes();
    }

    /* JADX WARN: Code restructure failed: missing block: B:313:0x079c, code lost:
        if (r2.getResult().getValue() == null) goto L262;
     */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0759  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x077c  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x078c  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x07a2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01b6  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onViewCreated(android.view.View r23, android.os.Bundle r24) {
        /*
            Method dump skipped, instructions count: 2216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.result.ResultFragmentPhimHD.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-14  reason: not valid java name */
    public static final void m8762onViewCreated$lambda14(ResultFragmentPhimHD this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CommonActivity.INSTANCE.showToast(this$0.getActivity(), R.string.no_chromecast_support_toast, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-16$lambda-15  reason: not valid java name */
    public static final void m8763onViewCreated$lambda16$lambda15(ResultFragmentPhimHD this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MediaRouteButton mediaRouteButton = (MediaRouteButton) this$0._$_findCachedViewById(C4761R.C4764id.media_route_button);
        if (mediaRouteButton == null) {
            return;
        }
        mediaRouteButton.setVisibility(i == 1 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-17  reason: not valid java name */
    public static final void m8764onViewCreated$lambda17(ResultFragmentPhimHD this$0, NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        ExtendedFloatingActionButton extendedFloatingActionButton;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(nestedScrollView, "<anonymous parameter 0>");
        int i5 = i2 - i4;
        if (i5 > 0) {
            ExtendedFloatingActionButton extendedFloatingActionButton2 = (ExtendedFloatingActionButton) this$0._$_findCachedViewById(C4761R.C4764id.result_bookmark_fab);
            if (extendedFloatingActionButton2 != null) {
                extendedFloatingActionButton2.shrink();
            }
        } else if (i5 < -5 && (extendedFloatingActionButton = (ExtendedFloatingActionButton) this$0._$_findCachedViewById(C4761R.C4764id.result_bookmark_fab)) != null) {
            extendedFloatingActionButton.extend();
        }
        FrameLayout frameLayout = (FrameLayout) this$0._$_findCachedViewById(C4761R.C4764id.result_poster_blur_holder);
        if (frameLayout == null) {
            return;
        }
        frameLayout.setTranslationY(-i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-18  reason: not valid java name */
    public static final void m8765onViewCreated$lambda18(ResultFragmentPhimHD this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            UIHelper.INSTANCE.popCurrentPage(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Job onViewCreated$handleAction(ResultFragmentPhimHD resultFragmentPhimHD, String str, MainAPI mainAPI, EpisodeClickEvent episodeClickEvent) {
        return Coroutines.INSTANCE.main(new ResultFragmentPhimHD$onViewCreated$handleAction$1(episodeClickEvent, resultFragmentPhimHD, str, mainAPI, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-20  reason: not valid java name */
    public static final void m8766onViewCreated$lambda20(ResultFragmentPhimHD this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UIHelper uIHelper = UIHelper.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        WatchType[] values = WatchType.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (WatchType watchType : values) {
            arrayList.add(new Tuples(Integer.valueOf(watchType.getInternalId()), Integer.valueOf(watchType.getStringRes())));
        }
        uIHelper.popupMenuNoIcons(it, arrayList, new ResultFragmentPhimHD$onViewCreated$8$2(this$0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$setFocusUpAndDown(View view, View view2) {
        if (view == null || view2 == null) {
            return;
        }
        view.setNextFocusDownId(view2.getId());
        view2.setNextFocusUpId(view.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-28$lambda-22  reason: not valid java name */
    public static final void m8767onViewCreated$lambda28$lambda22(ResultFragmentPhimHD this$0, AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SyncViewModel syncViewModel = this$0.syncModel;
        if (syncViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncModel");
            syncViewModel = null;
        }
        syncViewModel.setStatus(i - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-28$lambda-23  reason: not valid java name */
    public static final void m8768onViewCreated$lambda28$lambda23(ResultFragmentPhimHD this$0, Slider slider, float f, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(slider, "<anonymous parameter 0>");
        SyncViewModel syncViewModel = this$0.syncModel;
        if (syncViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncModel");
            syncViewModel = null;
        }
        syncViewModel.setScore((int) f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-28$lambda-24  reason: not valid java name */
    public static final void m8769onViewCreated$lambda28$lambda24(ResultFragmentPhimHD this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SyncViewModel syncViewModel = this$0.syncModel;
        if (syncViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncModel");
            syncViewModel = null;
        }
        syncViewModel.setEpisodesDelta(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-28$lambda-25  reason: not valid java name */
    public static final void m8770onViewCreated$lambda28$lambda25(ResultFragmentPhimHD this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SyncViewModel syncViewModel = this$0.syncModel;
        if (syncViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncModel");
            syncViewModel = null;
        }
        syncViewModel.setEpisodesDelta(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$setSyncMaxEpisodes(ResultFragmentPhimHD resultFragmentPhimHD, Integer num) {
        ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) resultFragmentPhimHD._$_findCachedViewById(C4761R.C4764id.result_sync_episodes);
        if (contentLoadingProgressBar != null) {
            contentLoadingProgressBar.setMax((num != null ? num.intValue() : 0) * 1000);
        }
        ArchComponentExt.normalSafeApiCall(new ResultFragmentPhimHD$onViewCreated$setSyncMaxEpisodes$1(resultFragmentPhimHD, num));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-29  reason: not valid java name */
    public static final void m8771onViewCreated$lambda29(ResultFragmentPhimHD this$0, View view, boolean z) {
        MaterialButton materialButton;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!z || (materialButton = (MaterialButton) this$0._$_findCachedViewById(C4761R.C4764id.result_bookmark_button)) == null) {
            return;
        }
        materialButton.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-31  reason: not valid java name */
    public static final void m8772onViewCreated$lambda31(ResultFragmentPhimHD this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Set<? extends DubStatus> set = this$0.dubRange;
        if (set != null) {
            UIHelper uIHelper = UIHelper.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            Set<? extends DubStatus> set2 = set;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set2, 10));
            for (DubStatus dubStatus : set2) {
                arrayList.add(new Tuples(Integer.valueOf(dubStatus.ordinal()), dubStatus.toString()));
            }
            uIHelper.popupMenuNoIconsAndNoStringRes(it, CollectionsKt.toList(arrayList), new ResultFragmentPhimHD$onViewCreated$24$2(this$0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-33  reason: not valid java name */
    public static final void m8773onViewCreated$lambda33(ResultFragmentPhimHD this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<String> list = this$0.episodeRanges;
        if (list != null) {
            UIHelper uIHelper = UIHelper.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            List<String> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            int i = 0;
            for (Object obj : list2) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(new Tuples(Integer.valueOf(i), (String) obj));
                i = i2;
            }
            uIHelper.popupMenuNoIconsAndNoStringRes(it, CollectionsKt.toList(arrayList), new ResultFragmentPhimHD$onViewCreated$25$2(this$0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-34  reason: not valid java name */
    public static final void m8774onViewCreated$lambda34(ResultFragmentPhimHD this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SyncViewModel syncViewModel = this$0.syncModel;
        if (syncViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncModel");
            syncViewModel = null;
        }
        syncViewModel.publishUserData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-40$lambda-36  reason: not valid java name */
    public static final void m8775onViewCreated$lambda40$lambda36(ResultFragmentPhimHD this$0, String str, String apiName, boolean z, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(apiName, "$apiName");
        ResultViewModel resultViewModel = this$0.viewModel;
        if (resultViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            resultViewModel = null;
        }
        resultViewModel.load(str, apiName, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-40$lambda-37  reason: not valid java name */
    public static final void m8776onViewCreated$lambda40$lambda37(String str, ResultFragmentPhimHD this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        try {
            this$0.startActivity(intent);
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-40$lambda-38  reason: not valid java name */
    public static final void m8777onViewCreated$lambda40$lambda38(String str, ResultFragmentPhimHD this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        try {
            this$0.startActivity(intent);
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-40$lambda-39  reason: not valid java name */
    public static final void m8778onViewCreated$lambda40$lambda39(String str, View view) {
        Context context = view.getContext();
        if (context != null) {
            AppUtils.INSTANCE.openBrowser(context, str);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        PanelsChildGestureRegionObserver.Provider.get().addGestureRegionsUpdateListener(this);
    }

    @Override // com.discord.panels.PanelsChildGestureRegionObserver.GestureRegionsListener
    public void onGestureRegionsUpdate(List<Rect> gestureRegions) {
        OverlappingPanelsLayout overlappingPanelsLayout;
        Intrinsics.checkNotNullParameter(gestureRegions, "gestureRegions");
        Context context = getContext();
        boolean z = true;
        if (!((context == null || !SettingsFragment.Companion.isTvSettings(context)) ? false : false) || (overlappingPanelsLayout = (OverlappingPanelsLayout) _$_findCachedViewById(C4761R.C4764id.result_overlapping_panels)) == null) {
            return;
        }
        overlappingPanelsLayout.setChildGestureRegions(gestureRegions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ResultFragmentPhimHD.kt */
    @Metadata(m108d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000b"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/result/ResultFragmentPhimHD$UriWebViewClient;", "Landroid/webkit/WebViewClient;", "()V", "onPageFinished", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/webkit/WebView;", "url", "", "shouldOverrideUrlLoading", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD$UriWebViewClient */
    /* loaded from: classes4.dex */
    public static final class UriWebViewClient extends WebViewClient {
        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onPageFinished$lambda-0  reason: not valid java name */
        public static final void m8782onPageFinished$lambda0() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            return !Intrinsics.areEqual(Uri.parse(url).getHost(), "m.facebook.com");
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.onPageFinished(view, url);
            Uri.parse(url).getHost();
            if (StringsKt.contains$default((CharSequence) url, (CharSequence) "/plugins/close_popup.php?reload", false, 2, (Object) null)) {
                new Handler().postDelayed(RunnableC4888x90df1c9a.INSTANCE, 600L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadComments(WebView webView, String str) {
        String htmlComment;
        webView.setWebViewClient(new UriWebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.getSettings().setSupportZoom(false);
        webView.getSettings().setBuiltInZoomControls(false);
        CookieManager.getInstance().setAcceptCookie(true);
        if (Build.VERSION.SDK_INT >= 21) {
            webView.getSettings().setMixedContentMode(0);
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        }
        if (StringsKt.startsWith$default(str, "http", false, 2, (Object) null)) {
            htmlComment = "<!doctype html> <html lang=\"en\"> <head></head> <body> <div id=\"fb-root\"></div> <script>(function(d, s, id) { var js, fjs = d.getElementsByTagName(s)[0]; if (d.getElementById(id)) return; js = d.createElement(s); js.id = id; js.src = \"//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.6\"; fjs.parentNode.insertBefore(js, fjs); }(document, 'script', 'facebook-jssdk'));</script> <div class=\"fb-comments\" data-href=\"" + str + "\" data-numposts=\"5\" data-order-by=\"reverse_time\" data-colorscheme=\"dark\"></div> </body> </html>";
        } else {
            htmlComment = getHtmlComment(str, "free-movies-online-1");
        }
        webView.loadDataWithBaseURL("http://www.nothing.com", htmlComment, "text/html", "UTF-8", null);
        webView.setMinimumHeight(100);
    }

    public final String getHtmlComment(String idPost, String shortName) {
        Intrinsics.checkNotNullParameter(idPost, "idPost");
        Intrinsics.checkNotNullParameter(shortName, "shortName");
        return "<div id='disqus_thread'></div><script type='text/javascript'>var disqus_identifier = '" + idPost + "';var disqus_shortname = '" + shortName + "'; (function() { var dsq = document.createElement('script'); dsq.type = 'text/javascript'; dsq.async = true;dsq.src = 'http://' + disqus_shortname + '.disqus.com/embed.js';(document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(dsq); })();</script>";
    }
}
