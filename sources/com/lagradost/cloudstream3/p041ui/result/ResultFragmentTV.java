package com.lagradost.cloudstream3.p041ui.result;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.mediarouter.app.MediaRouteButton;
import androidx.preference.PreferenceManager;
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
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.AcraApplication;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.DubStatus;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.p041ui.AutofitRecyclerView;
import com.lagradost.cloudstream3.p041ui.WatchType;
import com.lagradost.cloudstream3.p041ui.download.EasyDownloadButton;
import com.lagradost.cloudstream3.p041ui.player.CSPlayerEvent;
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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import kotlinx.coroutines.Job;

/* compiled from: ResultFragmentTV.kt */
@Metadata(m108d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 p2\u00020\u0001:\u0001pB\u0005¢\u0006\u0002\u0010\u0002J\b\u00103\u001a\u000204H\u0002J\u0017\u00105\u001a\u00020\u00072\b\u00106\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u00107J\u0010\u00108\u001a\u0002042\u0006\u00109\u001a\u00020\fH\u0002J\u0019\u0010:\u001a\u0002042\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010&J\b\u0010<\u001a\u000204H\u0016J\u0010\u0010=\u001a\u0002042\u0006\u0010>\u001a\u00020?H\u0016J&\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\b\u0010H\u001a\u000204H\u0016J\b\u0010I\u001a\u000204H\u0016J\u0016\u0010J\u001a\u0002042\f\u0010K\u001a\b\u0012\u0004\u0012\u00020L0\u0004H\u0016J\b\u0010M\u001a\u000204H\u0016J\b\u0010N\u001a\u000204H\u0016J\u001a\u0010O\u001a\u0002042\u0006\u0010P\u001a\u00020A2\b\u0010F\u001a\u0004\u0018\u00010GH\u0017J\u0014\u0010Q\u001a\u0002042\n\u0010R\u001a\u00060Sj\u0002`TH\u0016J\u0018\u0010U\u001a\u0002042\u000e\u0010V\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010\u0004H\u0002J\u0017\u0010X\u001a\u0002042\b\u0010Y\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010&J&\u0010Z\u001a\u0002042\b\u0010[\u001a\u0004\u0018\u00010\\2\b\b\u0001\u0010]\u001a\u00020\t2\b\u0010^\u001a\u0004\u0018\u00010_H\u0002J\u0017\u0010`\u001a\u0002042\b\u0010a\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010&J\"\u0010b\u001a\u0002042\u000e\u0010c\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010\u00042\b\u0010e\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010f\u001a\u0002042\b\u0010g\u001a\u0004\u0018\u00010hH\u0002J\u0018\u0010i\u001a\u0002042\u000e\u0010j\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0002J\u0017\u0010k\u001a\u0002042\b\u0010l\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010&J\b\u0010m\u001a\u000204H\u0002J\u0010\u0010n\u001a\u0002042\u0006\u0010o\u001a\u00020\tH\u0002R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0012\u0010'\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000¨\u0006q"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/result/ResultFragmentTV;", "Lcom/lagradost/cloudstream3/ui/result/ResultTrailerPlayer;", "()V", "currentEpisodes", "", "Lcom/lagradost/cloudstream3/ui/result/ResultEpisode;", "currentHeaderName", "", "currentId", "", "Ljava/lang/Integer;", "currentIsMovie", "", "Ljava/lang/Boolean;", "currentLoadingCount", "currentPoster", "currentTrailerIndex", "getCurrentTrailerIndex", "()I", "setCurrentTrailerIndex", "(I)V", "currentTrailers", "getCurrentTrailers", "()Ljava/util/List;", "setCurrentTrailers", "(Ljava/util/List;)V", "currentType", "Lcom/lagradost/cloudstream3/TvType;", "downloadButton", "Lcom/lagradost/cloudstream3/ui/download/EasyDownloadButton;", "dubRange", "", "Lcom/lagradost/cloudstream3/DubStatus;", "episodeRanges", "startAction", "getStartAction", "()Ljava/lang/Integer;", "setStartAction", "(Ljava/lang/Integer;)V", "startValue", "syncModel", "Lcom/lagradost/cloudstream3/ui/result/SyncViewModel;", "syncdata", "", "url", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "viewModel", "Lcom/lagradost/cloudstream3/ui/result/ResultViewModel;", "fixGrid", "", "fromIndexToSeasonText", "selection", "(Ljava/lang/Integer;)Ljava/lang/String;", "lateFixDownloadButton", "show", "loadTrailer", FirebaseAnalytics.Param.INDEX, "nextMirror", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDestroyView", "onGestureRegionsUpdate", "gestureRegions", "Landroid/graphics/Rect;", "onPause", "onResume", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "playerError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "setActors", "actors", "Lcom/lagradost/cloudstream3/ActorData;", "setDuration", TypedValues.TransitionType.S_DURATION, "setFormatText", "textView", "Landroid/widget/TextView;", "format", "arg", "", "setRating", "rating", "setRecommendations", "rec", "Lcom/lagradost/cloudstream3/SearchResponse;", "validApiName", "setShow", "showStatus", "Lcom/lagradost/cloudstream3/ShowStatus;", "setTrailers", "trailers", "setYear", "year", "updateUI", "updateVisStatus", ServerProtocol.DIALOG_PARAM_STATE, "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV */
/* loaded from: classes4.dex */
public final class ResultFragmentTV extends ResultTrailerPlayer {
    public static final String API_NAME_BUNDLE = "apiName";
    public static final Companion Companion = new Companion(null);
    public static final String EPISODE_BUNDLE = "episode";
    public static final String RESTART_BUNDLE = "restart";
    public static final String SEASON_BUNDLE = "season";
    public static final String START_ACTION_BUNDLE = "startAction";
    public static final String START_VALUE_BUNDLE = "startValue";
    public static final String URL_BUNDLE = "url";
    private static Functions<Unit> updateUIListener;
    private List<ResultEpisode> currentEpisodes;
    private String currentHeaderName;
    private Integer currentId;
    private Boolean currentIsMovie;
    private int currentLoadingCount;
    private String currentPoster;
    private int currentTrailerIndex;
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
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private List<String> currentTrailers = CollectionsKt.emptyList();

    /* compiled from: ResultFragmentTV.kt */
    @Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$WhenMappings */
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

    @Override // com.lagradost.cloudstream3.p041ui.result.ResultTrailerPlayer, com.lagradost.cloudstream3.p041ui.player.FullScreenPlayer, com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // com.lagradost.cloudstream3.p041ui.result.ResultTrailerPlayer, com.lagradost.cloudstream3.p041ui.player.FullScreenPlayer, com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
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

    /* compiled from: ResultFragmentTV.kt */
    @Metadata(m108d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J[\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\"\u0010\u001e\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J*\u0010\u001e\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u0004H\u0002J8\u0010*\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u0017H\u0002J)\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020\u001b2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u00102J*\u0010,\u001a\u00020-2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u00020\u001b2\b\b\u0002\u00101\u001a\u00020\u001bJn\u00103\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\f\u00104\u001a\b\u0012\u0004\u0012\u000206052\u000e\u00107\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u000105J\u0006\u00108\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00069"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/result/ResultFragmentTV$Companion;", "", "()V", "API_NAME_BUNDLE", "", "EPISODE_BUNDLE", "RESTART_BUNDLE", "SEASON_BUNDLE", "START_ACTION_BUNDLE", "START_VALUE_BUNDLE", "URL_BUNDLE", "updateUIListener", "Lkotlin/Function0;", "", "downloadEpisode", "activity", "Landroid/app/Activity;", "episode", "Lcom/lagradost/cloudstream3/ui/result/ResultEpisode;", "currentIsMovie", "", "currentHeaderName", "currentType", "Lcom/lagradost/cloudstream3/TvType;", "currentPoster", "apiName", "parentId", "", "url", "(Landroid/app/Activity;Lcom/lagradost/cloudstream3/ui/result/ResultEpisode;ZLjava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadSubtitle", "context", "Landroid/content/Context;", "link", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", "meta", "Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadEpisodeMetadata;", "Lcom/lagradost/cloudstream3/utils/ExtractorSubtitleLink;", "fileName", "folder", "getFolder", "titleName", "getMeta", "tvType", "newInstance", "Landroid/os/Bundle;", "card", "Lcom/lagradost/cloudstream3/SearchResponse;", "startAction", "startValue", "(Lcom/lagradost/cloudstream3/SearchResponse;ILjava/lang/Integer;)Landroid/os/Bundle;", "startDownload", "links", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "subs", "updateUI", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$Companion */
    /* loaded from: classes4.dex */
    public static final class Companion {

        /* compiled from: ResultFragmentTV.kt */
        @Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
        /* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$Companion$WhenMappings */
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
            Functions functions = ResultFragmentTV.updateUIListener;
            if (functions != null) {
                functions.invoke();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void downloadSubtitle(Context context, SubtitleData subtitleData, VideoDownloadManager.DownloadEpisodeMetadata downloadEpisodeMetadata) {
            if (context != null) {
                String fileName = VideoDownloadManager.INSTANCE.getFileName(context, downloadEpisodeMetadata);
                Companion companion = ResultFragmentTV.Companion;
                TvType type = downloadEpisodeMetadata.getType();
                if (type == null) {
                    return;
                }
                ResultFragmentTV.Companion.downloadSubtitle(context, new ExtractorSubtitleLink(subtitleData.getName(), subtitleData.getUrl(), "", null, 8, null), fileName, companion.getFolder(type, downloadEpisodeMetadata.getMainName()));
            }
        }

        private final void downloadSubtitle(Context context, ExtractorSubtitleLink extractorSubtitleLink, String str, String str2) {
            Coroutines.INSTANCE.ioSafe(new ResultFragmentTV$Companion$downloadSubtitle$2(context, extractorSubtitleLink, str, str2, null));
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
                        ResultFragmentTV.Companion.downloadSubtitle(context, extractorSubtitleLink, VideoDownloadManager.INSTANCE.getFileName(context, meta), folder);
                    }
                }
            } catch (Exception e) {
                ArchComponentExt.logError(e);
            }
        }

        public final Object downloadEpisode(Activity activity, ResultEpisode resultEpisode, boolean z, String str, TvType tvType, String str2, String str3, int i, String str4, Continuation<? super Unit> continuation) {
            Object safeApiCall = ArchComponentExt.safeApiCall(new ResultFragmentTV$Companion$downloadEpisode$2(resultEpisode, activity, z, str, tvType, str2, str3, i, str4, null), continuation);
            return safeApiCall == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? safeApiCall : Unit.INSTANCE;
        }
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ResultFragmentTV resultFragmentTV = this;
        this.viewModel = (ResultViewModel) new ViewModelProvider(resultFragmentTV).get(ResultViewModel.class);
        this.syncModel = (SyncViewModel) new ViewModelProvider(resultFragmentTV).get(SyncViewModel.class);
        return inflater.inflate(R.layout.fragment_result_swipe_tv, viewGroup, false);
    }

    @Override // com.lagradost.cloudstream3.p041ui.result.ResultTrailerPlayer, com.lagradost.cloudstream3.p041ui.player.FullScreenPlayer, com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C4761R.C4764id.result_episodes);
        EpisodeAdapter episodeAdapter = (EpisodeAdapter) (recyclerView != null ? recyclerView.getAdapter() : null);
        if (episodeAdapter != null) {
            episodeAdapter.killAdapter();
        }
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.FullScreenPlayer, com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment, androidx.fragment.app.Fragment
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

    @Override // com.lagradost.cloudstream3.p041ui.player.FullScreenPlayer, com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment, androidx.fragment.app.Fragment
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
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a7, code lost:
        if ((r6.getVisibility() == 0) == true) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void updateVisStatus(int r6) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.result.ResultFragmentTV.updateVisStatus(int):void");
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
        ArchComponentExt.normalSafeApiCall(new ResultFragmentTV$setFormatText$1(obj, textView, this, i));
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

    public final List<String> getCurrentTrailers() {
        return this.currentTrailers;
    }

    public final void setCurrentTrailers(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.currentTrailers = list;
    }

    public final int getCurrentTrailerIndex() {
        return this.currentTrailerIndex;
    }

    public final void setCurrentTrailerIndex(int i) {
        this.currentTrailerIndex = i;
    }

    @Override // com.lagradost.cloudstream3.p041ui.result.ResultTrailerPlayer, com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
    public void nextMirror() {
        this.currentTrailerIndex++;
        loadTrailer$default(this, null, 1, null);
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
    public void playerError(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (getPlayer().getIsPlaying()) {
            super.playerError(exception);
        } else {
            nextMirror();
        }
    }

    static /* synthetic */ void loadTrailer$default(ResultFragmentTV resultFragmentTV, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        resultFragmentTV.loadTrailer(num);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void loadTrailer(java.lang.Integer r19) {
        /*
            r18 = this;
            r0 = r18
            java.util.List<java.lang.String> r1 = r0.currentTrailers
            if (r19 == 0) goto Lb
            int r2 = r19.intValue()
            goto Ld
        Lb:
            int r2 = r0.currentTrailerIndex
        Ld:
            java.lang.Object r1 = kotlin.collections.CollectionsKt.getOrNull(r1, r2)
            r5 = r1
            java.lang.String r5 = (java.lang.String) r5
            r1 = 0
            if (r5 == 0) goto L6e
            android.content.Context r13 = r18.getContext()
            if (r13 == 0) goto L6a
            com.lagradost.cloudstream3.ui.player.IPlayer r2 = r18.getPlayer()
            r2.onPause()
            com.lagradost.cloudstream3.ui.player.IPlayer r14 = r18.getPlayer()
            java.lang.String r2 = "ctx"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r2)
            r15 = 0
            com.lagradost.cloudstream3.utils.ExtractorLink r16 = new com.lagradost.cloudstream3.utils.ExtractorLink
            com.lagradost.cloudstream3.utils.Qualities r2 = com.lagradost.cloudstream3.utils.Qualities.Unknown
            int r7 = r2.getValue()
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 224(0xe0, float:3.14E-43)
            r12 = 0
            java.lang.String r3 = ""
            java.lang.String r4 = "Trailer"
            java.lang.String r6 = ""
            r2 = r16
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r2 = 0
            java.lang.Long r11 = java.lang.Long.valueOf(r2)
            java.util.Set r12 = kotlin.collections.SetsKt.emptySet()
            r2 = 0
            r3 = 0
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)
            r5 = 128(0x80, float:1.8E-43)
            r17 = 0
            r6 = r14
            r7 = r13
            r8 = r15
            r9 = r16
            r13 = r2
            r14 = r3
            r15 = r4
            r16 = r5
            com.lagradost.cloudstream3.p041ui.player.IPlayer.DefaultImpls.loadPlayer$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r2 = 1
            goto L72
        L6a:
            r2 = r0
            com.lagradost.cloudstream3.ui.result.ResultFragmentTV r2 = (com.lagradost.cloudstream3.p041ui.result.ResultFragmentTV) r2
            goto L71
        L6e:
            r2 = r0
            com.lagradost.cloudstream3.ui.result.ResultFragmentTV r2 = (com.lagradost.cloudstream3.p041ui.result.ResultFragmentTV) r2
        L71:
            r2 = 0
        L72:
            int r3 = com.lagradost.cloudstream3.C4761R.C4764id.result_trailer_loading
            android.view.View r3 = r0._$_findCachedViewById(r3)
            com.facebook.shimmer.ShimmerFrameLayout r3 = (com.facebook.shimmer.ShimmerFrameLayout) r3
            if (r3 != 0) goto L7d
            goto L87
        L7d:
            android.view.View r3 = (android.view.View) r3
            if (r2 == 0) goto L82
            goto L84
        L82:
            r1 = 8
        L84:
            r3.setVisibility(r1)
        L87:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.result.ResultFragmentTV.loadTrailer(java.lang.Integer):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTrailers(List<String> list) {
        Context context = getContext();
        if (context == null || SettingsFragment.Companion.isTvSettings(context) || !PreferenceManager.getDefaultSharedPreferences(context).getBoolean(context.getString(R.string.show_trailers_key), true)) {
            return;
        }
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        this.currentTrailers = list;
        loadTrailer$default(this, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setActors(List<ActorData> list) {
        List<ActorData> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            TextView textView = (TextView) _$_findCachedViewById(C4761R.C4764id.result_cast_text);
            if (textView != null) {
                textView.setVisibility(8);
            }
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C4761R.C4764id.result_cast_items);
            if (recyclerView == null) {
                return;
            }
            recyclerView.setVisibility(8);
            return;
        }
        if (((ActorData) CollectionsKt.first((List<? extends Object>) list)).getActor().getImage() != null) {
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
        TextView textView3 = (TextView) _$_findCachedViewById(C4761R.C4764id.result_cast_text);
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        RecyclerView recyclerView4 = (RecyclerView) _$_findCachedViewById(C4761R.C4764id.result_cast_items);
        if (recyclerView4 != null) {
            recyclerView4.setVisibility(8);
        }
        setFormatText((TextView) _$_findCachedViewById(C4761R.C4764id.result_cast_text), R.string.cast_format, CollectionsKt.joinToString$default(list, null, null, null, 0, null, ResultFragmentTV$setActors$2.INSTANCE, 31, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRecommendations(final List<? extends SearchResponse> list, final String str) {
        MaterialButton result_recommendations_filter_button;
        SearchResponse searchResponse;
        List<? extends SearchResponse> list2 = list;
        boolean z = list2 == null || list2.isEmpty();
        AutofitRecyclerView autofitRecyclerView = (AutofitRecyclerView) _$_findCachedViewById(C4761R.C4764id.result_recommendations);
        if (autofitRecyclerView != null) {
            autofitRecyclerView.setVisibility(z ? 8 : 0);
        }
        ImageView imageView = (ImageView) _$_findCachedViewById(C4761R.C4764id.result_recommendations_btt);
        if (imageView != null) {
            imageView.setVisibility(z ? 8 : 0);
        }
        ImageView imageView2 = (ImageView) _$_findCachedViewById(C4761R.C4764id.result_recommendations_btt);
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$ResultFragmentTV$dJymV3X2OhqvC3K0UsSCBDYBdA8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResultFragmentTV.m8837setRecommendations$lambda9(ResultFragmentTV.this, view);
                }
            });
        }
        OverlappingPanelsLayout overlappingPanelsLayout = (OverlappingPanelsLayout) _$_findCachedViewById(C4761R.C4764id.result_overlapping_panels);
        if (overlappingPanelsLayout != null) {
            overlappingPanelsLayout.setEndPanelLockState(z ? OverlappingPanelsLayout.LockState.CLOSE : OverlappingPanelsLayout.LockState.UNLOCKED);
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
                    materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$ResultFragmentTV$n__8rXGTlTlUhQJuQR64vIAa1nk
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ResultFragmentTV.m8835setRecommendations$lambda12$lambda11(ResultFragmentTV.this, distinct, str, list, view);
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
        AutofitRecyclerView autofitRecyclerView2 = (AutofitRecyclerView) _$_findCachedViewById(C4761R.C4764id.result_recommendations);
        if (autofitRecyclerView2 != null) {
            autofitRecyclerView2.post(new Runnable() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$ResultFragmentTV$jQ_cHH0RrwHfidHfqRmvoJSsOM0
                @Override // java.lang.Runnable
                public final void run() {
                    ResultFragmentTV.m8836setRecommendations$lambda16(list, this, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setRecommendations$lambda-9  reason: not valid java name */
    public static final void m8837setRecommendations$lambda9(ResultFragmentTV this$0, View view) {
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
        ImageView imageView2 = (ImageView) this$0._$_findCachedViewById(C4761R.C4764id.result_search);
        if (imageView2 != null) {
            imageView2.setNextFocusDownId(i);
        }
        ImageView imageView3 = (ImageView) this$0._$_findCachedViewById(C4761R.C4764id.result_open_in_browser);
        if (imageView3 != null) {
            imageView3.setNextFocusDownId(i);
        }
        ImageView imageView4 = (ImageView) this$0._$_findCachedViewById(C4761R.C4764id.result_share);
        if (imageView4 == null) {
            return;
        }
        imageView4.setNextFocusDownId(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setRecommendations$lambda-12$lambda-11  reason: not valid java name */
    public static final void m8835setRecommendations$lambda12$lambda11(ResultFragmentTV this$0, List apiNames, String str, List list, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(apiNames, "$apiNames");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            int indexOf = CollectionsKt.indexOf((List<? extends String>) apiNames, str);
            String string = this$0.getString(R.string.home_change_provider_img_des);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.home_change_provider_img_des)");
            SingleSelectionHelper.INSTANCE.showBottomDialog(activity, apiNames, indexOf, string, false, ResultFragmentTV$setRecommendations$3$1$1.INSTANCE, new ResultFragmentTV$setRecommendations$3$1$2(this$0, list, apiNames));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setRecommendations$lambda-16  reason: not valid java name */
    public static final void m8836setRecommendations$lambda16(List list, ResultFragmentTV this$0, String str) {
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

    @Override // com.lagradost.cloudstream3.p041ui.result.ResultTrailerPlayer, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
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
        ((LinearLayout) _$_findCachedViewById(C4761R.C4764id.result_movie_parent)).setVisibility(8);
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

    /* JADX WARN: Code restructure failed: missing block: B:296:0x0756, code lost:
        if (r2.getResult().getValue() == null) goto L263;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0713  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0736  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0746  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x075c  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0761  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014f  */
    @Override // com.lagradost.cloudstream3.p041ui.result.ResultTrailerPlayer, com.lagradost.cloudstream3.p041ui.player.FullScreenPlayer, com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onViewCreated(android.view.View r23, android.os.Bundle r24) {
        /*
            Method dump skipped, instructions count: 1908
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.result.ResultFragmentTV.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-20  reason: not valid java name */
    public static final void m8817onViewCreated$lambda20(ResultFragmentTV this$0, View view) {
        Context context;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = (String) CollectionsKt.getOrNull(this$0.currentTrailers, this$0.currentTrailerIndex);
        if (str == null || (context = this$0.getContext()) == null) {
            return;
        }
        AppUtils appUtils = AppUtils.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        appUtils.openBrowser(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-21  reason: not valid java name */
    public static final void m8818onViewCreated$lambda21(ResultFragmentTV this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CommonActivity.INSTANCE.showToast(this$0.getActivity(), R.string.no_chromecast_support_toast, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-23$lambda-22  reason: not valid java name */
    public static final void m8819onViewCreated$lambda23$lambda22(ResultFragmentTV this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MediaRouteButton mediaRouteButton = (MediaRouteButton) this$0._$_findCachedViewById(C4761R.C4764id.media_route_button);
        if (mediaRouteButton == null) {
            return;
        }
        mediaRouteButton.setVisibility(i == 1 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-24  reason: not valid java name */
    public static final void m8820onViewCreated$lambda24(ResultFragmentTV this$0, NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
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
        if (this$0.isFullScreenPlayer() || !this$0.getPlayer().getIsPlaying()) {
            return;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) this$0._$_findCachedViewById(C4761R.C4764id.player_background);
        if (i2 > (constraintLayout != null ? constraintLayout.getHeight() : i2)) {
            this$0.getPlayer().handleEvent(CSPlayerEvent.Pause);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-25  reason: not valid java name */
    public static final void m8821onViewCreated$lambda25(ResultFragmentTV this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            UIHelper.INSTANCE.popCurrentPage(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Job onViewCreated$handleAction(ResultFragmentTV resultFragmentTV, String str, MainAPI mainAPI, EpisodeClickEvent episodeClickEvent) {
        return Coroutines.INSTANCE.main(new ResultFragmentTV$onViewCreated$handleAction$1(episodeClickEvent, resultFragmentTV, str, mainAPI, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-27  reason: not valid java name */
    public static final void m8822onViewCreated$lambda27(ResultFragmentTV this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UIHelper uIHelper = UIHelper.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        WatchType[] values = WatchType.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (WatchType watchType : values) {
            arrayList.add(new Tuples(Integer.valueOf(watchType.getInternalId()), Integer.valueOf(watchType.getStringRes())));
        }
        uIHelper.popupMenuNoIcons(it, arrayList, new ResultFragmentTV$onViewCreated$8$2(this$0));
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
    /* renamed from: onViewCreated$lambda-35$lambda-29  reason: not valid java name */
    public static final void m8823onViewCreated$lambda35$lambda29(ResultFragmentTV this$0, AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SyncViewModel syncViewModel = this$0.syncModel;
        if (syncViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncModel");
            syncViewModel = null;
        }
        syncViewModel.setStatus(i - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-35$lambda-30  reason: not valid java name */
    public static final void m8824onViewCreated$lambda35$lambda30(ResultFragmentTV this$0, Slider slider, float f, boolean z) {
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
    /* renamed from: onViewCreated$lambda-35$lambda-31  reason: not valid java name */
    public static final void m8825onViewCreated$lambda35$lambda31(ResultFragmentTV this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SyncViewModel syncViewModel = this$0.syncModel;
        if (syncViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncModel");
            syncViewModel = null;
        }
        syncViewModel.setEpisodesDelta(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-35$lambda-32  reason: not valid java name */
    public static final void m8826onViewCreated$lambda35$lambda32(ResultFragmentTV this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SyncViewModel syncViewModel = this$0.syncModel;
        if (syncViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncModel");
            syncViewModel = null;
        }
        syncViewModel.setEpisodesDelta(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$setSyncMaxEpisodes(ResultFragmentTV resultFragmentTV, Integer num) {
        ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) resultFragmentTV._$_findCachedViewById(C4761R.C4764id.result_sync_episodes);
        if (contentLoadingProgressBar != null) {
            contentLoadingProgressBar.setMax((num != null ? num.intValue() : 0) * 1000);
        }
        ArchComponentExt.normalSafeApiCall(new ResultFragmentTV$onViewCreated$setSyncMaxEpisodes$1(resultFragmentTV, num));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-36  reason: not valid java name */
    public static final void m8827onViewCreated$lambda36(ResultFragmentTV this$0, View view, boolean z) {
        MaterialButton materialButton;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!z || (materialButton = (MaterialButton) this$0._$_findCachedViewById(C4761R.C4764id.result_bookmark_button)) == null) {
            return;
        }
        materialButton.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-38  reason: not valid java name */
    public static final void m8828onViewCreated$lambda38(ResultFragmentTV this$0, View it) {
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
            uIHelper.popupMenuNoIconsAndNoStringRes(it, CollectionsKt.toList(arrayList), new ResultFragmentTV$onViewCreated$24$2(this$0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-40  reason: not valid java name */
    public static final void m8829onViewCreated$lambda40(ResultFragmentTV this$0, View it) {
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
            uIHelper.popupMenuNoIconsAndNoStringRes(it, CollectionsKt.toList(arrayList), new ResultFragmentTV$onViewCreated$25$2(this$0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-41  reason: not valid java name */
    public static final void m8830onViewCreated$lambda41(ResultFragmentTV this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SyncViewModel syncViewModel = this$0.syncModel;
        if (syncViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncModel");
            syncViewModel = null;
        }
        syncViewModel.publishUserData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-47$lambda-43  reason: not valid java name */
    public static final void m8831onViewCreated$lambda47$lambda43(ResultFragmentTV this$0, String str, String apiName, boolean z, View view) {
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
    /* renamed from: onViewCreated$lambda-47$lambda-44  reason: not valid java name */
    public static final void m8832onViewCreated$lambda47$lambda44(String str, ResultFragmentTV this$0, View view) {
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
    /* renamed from: onViewCreated$lambda-47$lambda-45  reason: not valid java name */
    public static final void m8833onViewCreated$lambda47$lambda45(String str, ResultFragmentTV this$0, View view) {
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
    /* renamed from: onViewCreated$lambda-47$lambda-46  reason: not valid java name */
    public static final void m8834onViewCreated$lambda47$lambda46(String str, View view) {
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

    @Override // com.lagradost.cloudstream3.p041ui.result.ResultTrailerPlayer, com.discord.panels.PanelsChildGestureRegionObserver.GestureRegionsListener
    public void onGestureRegionsUpdate(List<Rect> gestureRegions) {
        Intrinsics.checkNotNullParameter(gestureRegions, "gestureRegions");
        OverlappingPanelsLayout overlappingPanelsLayout = (OverlappingPanelsLayout) _$_findCachedViewById(C4761R.C4764id.result_overlapping_panels);
        if (overlappingPanelsLayout != null) {
            overlappingPanelsLayout.setChildGestureRegions(gestureRegions);
        }
    }
}
