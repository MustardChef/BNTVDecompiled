package com.lagradost.cloudstream3.p041ui.player;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.fragment.Fragment;
import androidx.preference.PreferenceManager;
import com.anggrayudi.storage.file.MimeType;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.p036ui.PlayerView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.material.button.MaterialButton;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.p041ui.browser.SubtitleBrowserFragment;
import com.lagradost.cloudstream3.p041ui.browser.SubtitleBrowserViewModel;
import com.lagradost.cloudstream3.p041ui.player.IPlayer;
import com.lagradost.cloudstream3.p041ui.result.ResultEpisode;
import com.lagradost.cloudstream3.p041ui.result.ResultFragmentPhimHD;
import com.lagradost.cloudstream3.p041ui.result.SyncViewModel;
import com.lagradost.cloudstream3.p041ui.settings.SettingsFragment;
import com.lagradost.cloudstream3.p041ui.subtitles.SubtitlesFragment;
import com.lagradost.cloudstream3.subtitles.AbstractSubtitleEntities;
import com.lagradost.cloudstream3.syncproviders.AccountManager;
import com.lagradost.cloudstream3.syncproviders.providers.OpenSubtitlesApi;
import com.lagradost.cloudstream3.utils.Coroutines;
import com.lagradost.cloudstream3.utils.DataStoreHelper;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorUri;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.cloudstream3.utils.SingleSelectionHelper;
import com.lagradost.cloudstream3.utils.SubtitleHelper;
import com.lagradost.cloudstream3.utils.UIHelper;
import com.phimhd.AppController;
import com.phimhd.ConfigHomeKt;
import com.phimhd.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;

/* compiled from: GeneratorPlayer.kt */
@Metadata(m108d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 q2\u00020\u0001:\u0002qrB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\fH\u0002J\b\u00106\u001a\u00020\u0015H\u0002J\b\u00107\u001a\u00020\u0015H\u0002J\b\u00108\u001a\u000204H\u0002J\u0016\u00109\u001a\u0002042\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\f0;H\u0016J(\u0010<\u001a\u0004\u0018\u00010\f2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010=\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u0015H\u0002J\b\u0010?\u001a\u00020@H\u0002J\b\u0010A\u001a\u00020!H\u0002J\b\u0010B\u001a\u00020CH\u0002J\u0012\u0010D\u001a\u0002042\b\u0010E\u001a\u0004\u0018\u00010\u0006H\u0002J*\u0010F\u001a\u0002042\u0018\u0010G\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00052\u0006\u0010H\u001a\u00020\u0015H\u0002J\b\u0010I\u001a\u000204H\u0016J\b\u0010J\u001a\u000204H\u0016J\b\u0010K\u001a\u000204H\u0002J\b\u0010L\u001a\u00020\u0015H\u0002J&\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010R2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\b\u0010U\u001a\u000204H\u0016J\b\u0010V\u001a\u000204H\u0016J\b\u0010W\u001a\u000204H\u0016J\u001a\u0010X\u001a\u0002042\u0006\u0010Y\u001a\u00020N2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J-\u0010Z\u001a\u0002042\u0006\u0010[\u001a\u00020\\2\b\u0010]\u001a\u0004\u0018\u00010C2\f\u0010^\u001a\b\u0012\u0004\u0012\u0002040_H\u0016¢\u0006\u0002\u0010`J\b\u0010a\u001a\u000204H\u0002J\u001c\u0010b\u001a\u0002042\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0005H\u0016J\u001c\u0010d\u001a\u0002042\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020C0\u0005H\u0016J\b\u0010f\u001a\u000204H\u0016J\u001e\u0010g\u001a\u0002042\u0014\u0010c\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0005H\u0007J\u0012\u0010h\u001a\u00020\u00152\b\u0010i\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010j\u001a\u000204H\u0007J\b\u0010k\u001a\u000204H\u0016J(\u0010l\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00050;2\b\b\u0002\u0010m\u001a\u00020\u0015H\u0002J\b\u0010n\u001a\u000204H\u0002J\b\u0010o\u001a\u000204H\u0002J\u0012\u0010p\u001a\u0002042\b\u0010S\u001a\u0004\u0018\u00010TH\u0002R$\u0010\u0003\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R(\u0010(\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020! +*\n\u0012\u0004\u0012\u00020!\u0018\u00010*0*0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000¨\u0006s"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/GeneratorPlayer;", "Lcom/lagradost/cloudstream3/ui/player/FullScreenPlayer;", "()V", "currentLinks", "", "Lkotlin/Pair;", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "Lcom/lagradost/cloudstream3/utils/ExtractorUri;", "currentMeta", "", "currentSelectedLink", "currentSelectedSubtitles", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", "currentSubs", "currentVerifyLink", "Lkotlinx/coroutines/Job;", "getCurrentVerifyLink", "()Lkotlinx/coroutines/Job;", "setCurrentVerifyLink", "(Lkotlinx/coroutines/Job;)V", "isActive", "", "isNextEpisode", "limitTitle", "", "maxEpisodeSet", "getMaxEpisodeSet", "()Ljava/lang/Integer;", "setMaxEpisodeSet", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "nextMeta", "preferredAutoSelectSubtitles", "", "selectSourceDialog", "Landroidx/appcompat/app/AlertDialog;", "getSelectSourceDialog", "()Landroidx/appcompat/app/AlertDialog;", "setSelectSourceDialog", "(Landroidx/appcompat/app/AlertDialog;)V", "subsPathPicker", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "sync", "Lcom/lagradost/cloudstream3/ui/result/SyncViewModel;", "titleRez", "viewModel", "Lcom/lagradost/cloudstream3/ui/player/PlayerGeneratorViewModel;", "viewModelBrowserSubtitle", "Lcom/lagradost/cloudstream3/ui/browser/SubtitleBrowserViewModel;", "addAndSelectSubtitles", "", "subtitleData", "autoSelectFromDownloads", "autoSelectFromSettings", "autoSelectSubtitles", "embeddedSubtitlesFetched", "subtitles", "", "getAutoSelectSubtitle", "settings", "downloads", "getMetaData", "Lcom/lagradost/cloudstream3/ui/player/GeneratorPlayer$TempMetaData;", "getPlayerVideoTitle", "getPos", "", "loadExtractorJob", "extractorLink", "loadLink", "link", "sameEpisode", "nextEpisode", "nextMirror", "noLinksFound", "noSubtitles", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDestroyView", "onResume", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "openOnlineSubPicker", "context", "Landroid/content/Context;", "imdbId", "dismissCallback", "Lkotlin/Function0;", "(Landroid/content/Context;Ljava/lang/Long;Lkotlin/jvm/functions/Function0;)V", "openSubPicker", "playerDimensionsLoaded", "widthHeight", "playerPositionChanged", "posDur", "prevEpisode", "setPlayerDimen", "setSubtitles", "sub", "setTitle", "showMirrorsDialogue", "sortLinks", "useQualitySettings", "startLoading", "startPlayer", "unwrapBundle", "Companion", "TempMetaData", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.GeneratorPlayer */
/* loaded from: classes3.dex */
public final class GeneratorPlayer extends FullScreenPlayer {
    public static final Companion Companion = new Companion(null);
    private static IGenerator lastUsedGenerator;
    private Object currentMeta;
    private Tuples<? extends ExtractorLink, ExtractorUri> currentSelectedLink;
    private SubtitleData currentSelectedSubtitles;
    private Job currentVerifyLink;
    private boolean isActive;
    private boolean isNextEpisode;
    private int limitTitle;
    private Integer maxEpisodeSet;
    private Object nextMeta;
    private String preferredAutoSelectSubtitles;
    private AlertDialog selectSourceDialog;
    private final ActivityResultLauncher<String[]> subsPathPicker;
    private SyncViewModel sync;
    private PlayerGeneratorViewModel viewModel;
    private SubtitleBrowserViewModel viewModelBrowserSubtitle;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private int titleRez = 3;
    private Set<? extends Tuples<? extends ExtractorLink, ExtractorUri>> currentLinks = SetsKt.emptySet();
    private Set<SubtitleData> currentSubs = SetsKt.emptySet();

    @Override // com.lagradost.cloudstream3.p041ui.player.FullScreenPlayer, com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.FullScreenPlayer, com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
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

    /* compiled from: GeneratorPlayer.kt */
    @Metadata(m108d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042(\b\u0002\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/GeneratorPlayer$Companion;", "", "()V", "lastUsedGenerator", "Lcom/lagradost/cloudstream3/ui/player/IGenerator;", "subsProviders", "", "Lcom/lagradost/cloudstream3/syncproviders/providers/OpenSubtitlesApi;", "getSubsProviders", "()Ljava/util/List;", "subsProvidersIsActive", "", "getSubsProvidersIsActive", "()Z", "newInstance", "Landroid/os/Bundle;", "generator", "syncData", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.player.GeneratorPlayer$Companion */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Bundle newInstance$default(Companion companion, IGenerator iGenerator, HashMap hashMap, int i, Object obj) {
            if ((i & 2) != 0) {
                hashMap = null;
            }
            return companion.newInstance(iGenerator, hashMap);
        }

        public final Bundle newInstance(IGenerator generator, HashMap<String, String> hashMap) {
            Intrinsics.checkNotNullParameter(generator, "generator");
            Log.i(CS3IPlayerKt.TAG, "newInstance = " + hashMap);
            GeneratorPlayer.lastUsedGenerator = generator;
            Bundle bundle = new Bundle();
            if (hashMap != null) {
                bundle.putSerializable("syncData", hashMap);
            }
            return bundle;
        }

        public final List<OpenSubtitlesApi> getSubsProviders() {
            ArrayList arrayList = new ArrayList();
            for (Object obj : AccountManager.Companion.getSubtitleProviders()) {
                OpenSubtitlesApi openSubtitlesApi = (OpenSubtitlesApi) obj;
                if ((openSubtitlesApi.getRequiresLogin() && openSubtitlesApi.loginInfo() == null) ? false : true) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }

        public final boolean getSubsProvidersIsActive() {
            return !getSubsProviders().isEmpty();
        }
    }

    public GeneratorPlayer() {
        ActivityResultLauncher<String[]> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.OpenDocument(), new ActivityResultCallback() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$GeneratorPlayer$9ksNnf2uBMcOYiG6qtwlhg8lAww
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                GeneratorPlayer.m8735subsPathPicker$lambda14(GeneratorPlayer.this, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul…)\n            }\n        }");
        this.subsPathPicker = registerForActivityResult;
    }

    public final void startLoading() {
        getPlayer().release();
        this.currentSelectedSubtitles = null;
        this.isActive = false;
        MaterialButton materialButton = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.overlay_loading_skip_button);
        if (materialButton != null) {
            materialButton.setVisibility(8);
        }
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_loading_overlay);
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(0);
    }

    private final boolean setSubtitles(SubtitleData subtitleData) {
        this.currentSelectedSubtitles = subtitleData;
        return getPlayer().setPreferredSubtitles(subtitleData);
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
    public void embeddedSubtitlesFetched(List<SubtitleData> subtitles) {
        Intrinsics.checkNotNullParameter(subtitles, "subtitles");
        PlayerGeneratorViewModel playerGeneratorViewModel = this.viewModel;
        if (playerGeneratorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            playerGeneratorViewModel = null;
        }
        playerGeneratorViewModel.addSubtitles(CollectionsKt.toSet(subtitles));
    }

    private final boolean noSubtitles() {
        return setSubtitles(null);
    }

    private final long getPos() {
        DataStoreHelper dataStoreHelper = DataStoreHelper.INSTANCE;
        PlayerGeneratorViewModel playerGeneratorViewModel = this.viewModel;
        if (playerGeneratorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            playerGeneratorViewModel = null;
        }
        DataStoreHelper.PosDur viewPos = dataStoreHelper.getViewPos(playerGeneratorViewModel.getId());
        if (viewPos == null || viewPos.getDuration() == 0 || (viewPos.getPosition() * 100) / viewPos.getDuration() > 95) {
            return 0L;
        }
        return viewPos.getPosition();
    }

    public final Job getCurrentVerifyLink() {
        return this.currentVerifyLink;
    }

    public final void setCurrentVerifyLink(Job job) {
        this.currentVerifyLink = job;
    }

    private final void loadExtractorJob(ExtractorLink extractorLink) {
        Job job = this.currentVerifyLink;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (extractorLink != null) {
            this.currentVerifyLink = Coroutines.INSTANCE.ioSafe(new GeneratorPlayer$loadExtractorJob$1$1(extractorLink, null));
        }
    }

    private final void loadLink(Tuples<? extends ExtractorLink, ExtractorUri> tuples, boolean z) {
        Long valueOf;
        if (tuples == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_loading_overlay);
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        uiReset();
        this.currentSelectedLink = tuples;
        PlayerGeneratorViewModel playerGeneratorViewModel = this.viewModel;
        if (playerGeneratorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            playerGeneratorViewModel = null;
        }
        this.currentMeta = playerGeneratorViewModel.getMeta();
        PlayerGeneratorViewModel playerGeneratorViewModel2 = this.viewModel;
        if (playerGeneratorViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            playerGeneratorViewModel2 = null;
        }
        this.nextMeta = playerGeneratorViewModel2.getNextMeta();
        this.isActive = true;
        setPlayerDimen(null);
        setTitle();
        loadExtractorJob(tuples.getFirst());
        Context context = getContext();
        if (context != null) {
            ExtractorLink component1 = tuples.component1();
            ExtractorUri component2 = tuples.component2();
            IPlayer player = getPlayer();
            if (z) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(this.isNextEpisode ? 0L : getPos());
            }
            Set<SubtitleData> set = this.currentSubs;
            SubtitleData subtitleData = z ? this.currentSelectedSubtitles : null;
            IPlayer.DefaultImpls.loadPlayer$default(player, context, z, component1, component2, valueOf, set, subtitleData == null ? getAutoSelectSubtitle(set, true, true) : subtitleData, (PlayerView) _$_findCachedViewById(C4761R.C4764id.player_view), null, 256, null);
        }
    }

    static /* synthetic */ List sortLinks$default(GeneratorPlayer generatorPlayer, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return generatorPlayer.sortLinks(z);
    }

    private final List<Tuples<ExtractorLink, ExtractorUri>> sortLinks(final boolean z) {
        return CollectionsKt.sortedWith(this.currentLinks, new Comparator() { // from class: com.lagradost.cloudstream3.ui.player.GeneratorPlayer$sortLinks$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                ExtractorLink extractorLink = (ExtractorLink) ((Tuples) t).component1();
                int quality = extractorLink != null ? extractorLink.getQuality() : Qualities.Unknown.getValue();
                if (z && quality > this.getCurrentPrefQuality()) {
                    quality = (this.getCurrentPrefQuality() - quality) - 1;
                }
                Integer valueOf = Integer.valueOf(-quality);
                ExtractorLink extractorLink2 = (ExtractorLink) ((Tuples) t2).component1();
                int quality2 = extractorLink2 != null ? extractorLink2.getQuality() : Qualities.Unknown.getValue();
                if (z && quality2 > this.getCurrentPrefQuality()) {
                    quality2 = (this.getCurrentPrefQuality() - quality2) - 1;
                }
                return ComparisonsKt.compareValues(valueOf, Integer.valueOf(-quality2));
            }
        });
    }

    /* compiled from: GeneratorPlayer.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000b¨\u0006\u001d"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/GeneratorPlayer$TempMetaData;", "", "episode", "", "season", "name", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getEpisode", "()Ljava/lang/Integer;", "setEpisode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getSeason", "setSeason", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/lagradost/cloudstream3/ui/player/GeneratorPlayer$TempMetaData;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.player.GeneratorPlayer$TempMetaData */
    /* loaded from: classes3.dex */
    public static final class TempMetaData {
        private Integer episode;
        private String name;
        private Integer season;

        public TempMetaData() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ TempMetaData copy$default(TempMetaData tempMetaData, Integer num, Integer num2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                num = tempMetaData.episode;
            }
            if ((i & 2) != 0) {
                num2 = tempMetaData.season;
            }
            if ((i & 4) != 0) {
                str = tempMetaData.name;
            }
            return tempMetaData.copy(num, num2, str);
        }

        public final Integer component1() {
            return this.episode;
        }

        public final Integer component2() {
            return this.season;
        }

        public final String component3() {
            return this.name;
        }

        public final TempMetaData copy(Integer num, Integer num2, String str) {
            return new TempMetaData(num, num2, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TempMetaData) {
                TempMetaData tempMetaData = (TempMetaData) obj;
                return Intrinsics.areEqual(this.episode, tempMetaData.episode) && Intrinsics.areEqual(this.season, tempMetaData.season) && Intrinsics.areEqual(this.name, tempMetaData.name);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.episode;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.season;
            int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str = this.name;
            return hashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "TempMetaData(episode=" + this.episode + ", season=" + this.season + ", name=" + this.name + ')';
        }

        public TempMetaData(Integer num, Integer num2, String str) {
            this.episode = num;
            this.season = num2;
            this.name = str;
        }

        public /* synthetic */ TempMetaData(Integer num, Integer num2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : str);
        }

        public final Integer getEpisode() {
            return this.episode;
        }

        public final void setEpisode(Integer num) {
            this.episode = num;
        }

        public final Integer getSeason() {
            return this.season;
        }

        public final void setSeason(Integer num) {
            this.season = num;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            this.name = str;
        }
    }

    private final TempMetaData getMetaData() {
        TempMetaData tempMetaData = new TempMetaData(null, null, null, 7, null);
        Object obj = this.currentMeta;
        if (obj instanceof ResultEpisode) {
            ResultEpisode resultEpisode = (ResultEpisode) obj;
            if (!MainAPIKt.isMovieType(resultEpisode.getTvType())) {
                tempMetaData.setEpisode(Integer.valueOf(resultEpisode.getEpisode()));
                tempMetaData.setSeason(resultEpisode.getSeason());
            }
            tempMetaData.setName(resultEpisode.getHeaderName());
        } else if (obj instanceof ExtractorUri) {
            ExtractorUri extractorUri = (ExtractorUri) obj;
            TvType tvType = extractorUri.getTvType();
            boolean z = false;
            if (tvType != null && !MainAPIKt.isMovieType(tvType)) {
                z = true;
            }
            if (z) {
                tempMetaData.setEpisode(extractorUri.getEpisode());
                tempMetaData.setSeason(extractorUri.getSeason());
            }
            tempMetaData.setName(extractorUri.getHeaderName());
        }
        return tempMetaData;
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r0v18, types: [T, java.lang.String] */
    @Override // com.lagradost.cloudstream3.p041ui.player.FullScreenPlayer
    public void openOnlineSubPicker(final Context context, final Long l, final Functions<Unit> dismissCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dismissCallback, "dismissCallback");
        final List<OpenSubtitlesApi> subsProviders = Companion.getSubsProviders();
        final Dialog dialog = new Dialog(context, R.style.AlertDialogCustomBlack);
        dialog.setContentView(R.layout.dialog_online_subtitles);
        ArrayAdapter arrayAdapter = new ArrayAdapter(dialog.getContext(), R.layout.sort_bottom_single_choice);
        dialog.show();
        ((MaterialButton) dialog.findViewById(C4761R.C4764id.cancel_btt)).setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$GeneratorPlayer$Z2PmITOwsBX5cYFogTkJrxaeybU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GeneratorPlayer.m8720openOnlineSubPicker$lambda3(dialog, view);
            }
        });
        ((ListView) dialog.findViewById(C4761R.C4764id.subtitle_adapter)).setChoiceMode(1);
        ((ListView) dialog.findViewById(C4761R.C4764id.subtitle_adapter)).setAdapter((ListAdapter) arrayAdapter);
        ListAdapter adapter = ((ListView) dialog.findViewById(C4761R.C4764id.subtitle_adapter)).getAdapter();
        final ArrayAdapter arrayAdapter2 = adapter instanceof ArrayAdapter ? (ArrayAdapter) adapter : null;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = CollectionsKt.emptyList();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        ((ListView) dialog.findViewById(C4761R.C4764id.subtitle_adapter)).setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$GeneratorPlayer$CWYj6Qur5dADk0kS32qq6auzDKU
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                GeneratorPlayer.m8721openOnlineSubPicker$lambda4(Ref.ObjectRef.this, objectRef, adapterView, view, i, j);
            }
        });
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        objectRef3.element = SubtitlesFragment.Companion.getAutoSelectLanguageISO639_1();
        final TempMetaData metaData = getMetaData();
        ColorStateList valueOf = ColorStateList.valueOf(UIHelper.INSTANCE.colorFromAttribute(context, R.attr.colorAccent));
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(context.colorFro…bute(R.attr.colorAccent))");
        ((ContentLoadingProgressBar) dialog.findViewById(C4761R.C4764id.search_loading_bar)).setProgressTintList(valueOf);
        ((ContentLoadingProgressBar) dialog.findViewById(C4761R.C4764id.search_loading_bar)).setIndeterminateTintList(valueOf);
        ((SearchView) dialog.findViewById(C4761R.C4764id.subtitles_search)).setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.lagradost.cloudstream3.ui.player.GeneratorPlayer$openOnlineSubPicker$3
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String str) {
                return true;
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String str) {
                ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) dialog.findViewById(C4761R.C4764id.search_loading_bar);
                if (contentLoadingProgressBar != null) {
                    contentLoadingProgressBar.show();
                }
                Coroutines.INSTANCE.ioSafe(new GeneratorPlayer$openOnlineSubPicker$3$onQueryTextSubmit$1(str, metaData, objectRef3, l, subsProviders, this, dialog, objectRef, arrayAdapter2, null));
                return true;
            }
        });
        ((ImageView) dialog.findViewById(C4761R.C4764id.search_filter)).setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$GeneratorPlayer$j5KA0A1nytbQkQum7eI503BIeXE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GeneratorPlayer.m8722openOnlineSubPicker$lambda8(GeneratorPlayer.this, objectRef3, context, dialog, view);
            }
        });
        ((MaterialButton) dialog.findViewById(C4761R.C4764id.apply_btt)).setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$GeneratorPlayer$ZF0iUlFlPZTUabFaC9fmuu4LuQ4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GeneratorPlayer.m8718openOnlineSubPicker$lambda12(Ref.ObjectRef.this, dialog, subsProviders, this, view);
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$GeneratorPlayer$m2uNmmkgSsmvboVs2vQqwQdBh90
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                GeneratorPlayer.m8719openOnlineSubPicker$lambda13(Functions.this, dialogInterface);
            }
        });
        dialog.show();
        ((SearchView) dialog.findViewById(C4761R.C4764id.subtitles_search)).setQuery(metaData.getName(), true);
    }

    /* renamed from: openOnlineSubPicker$lambda-3 */
    public static final void m8720openOnlineSubPicker$lambda3(Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        UIHelper.INSTANCE.dismissSafe(dialog);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.lagradost.cloudstream3.subtitles.AbstractSubtitleEntities$SubtitleEntity, T] */
    /* renamed from: openOnlineSubPicker$lambda-4 */
    public static final void m8721openOnlineSubPicker$lambda4(Ref.ObjectRef currentSubtitle, Ref.ObjectRef currentSubtitles, AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(currentSubtitle, "$currentSubtitle");
        Intrinsics.checkNotNullParameter(currentSubtitles, "$currentSubtitles");
        ?? r1 = (AbstractSubtitleEntities.SubtitleEntity) CollectionsKt.getOrNull((List) currentSubtitles.element, i);
        if (r1 == 0) {
            return;
        }
        currentSubtitle.element = r1;
    }

    public static final String openOnlineSubPicker$getName(AbstractSubtitleEntities.SubtitleEntity subtitleEntity) {
        if (StringsKt.isBlank(subtitleEntity.getLang())) {
            return subtitleEntity.getName();
        }
        String fromTwoLettersToLanguage = SubtitleHelper.INSTANCE.fromTwoLettersToLanguage(StringsKt.trim((CharSequence) subtitleEntity.getLang()).toString());
        if (fromTwoLettersToLanguage == null) {
            fromTwoLettersToLanguage = subtitleEntity.getLang();
        }
        return fromTwoLettersToLanguage + ' ' + subtitleEntity.getName();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void openOnlineSubPicker$setSubtitlesList(Ref.ObjectRef<List<AbstractSubtitleEntities.SubtitleEntity>> objectRef, ArrayAdapter<String> arrayAdapter, List<AbstractSubtitleEntities.SubtitleEntity> list) {
        objectRef.element = list;
        if (arrayAdapter != null) {
            arrayAdapter.clear();
        }
        if (arrayAdapter != null) {
            List<AbstractSubtitleEntities.SubtitleEntity> list2 = objectRef.element;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (AbstractSubtitleEntities.SubtitleEntity subtitleEntity : list2) {
                arrayList.add(openOnlineSubPicker$getName(subtitleEntity));
            }
            arrayAdapter.addAll(arrayList);
        }
    }

    /* renamed from: openOnlineSubPicker$lambda-8 */
    public static final void m8722openOnlineSubPicker$lambda8(GeneratorPlayer this$0, Ref.ObjectRef currentLanguageTwoLetters, Context context, Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(currentLanguageTwoLetters, "$currentLanguageTwoLetters");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        List<SubtitleHelper.Language639> languages = SubtitleHelper.INSTANCE.getLanguages();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(languages, 10));
        for (SubtitleHelper.Language639 language639 : languages) {
            arrayList.add(language639.getISO_639_1());
        }
        ArrayList arrayList2 = arrayList;
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            SingleSelectionHelper singleSelectionHelper = SingleSelectionHelper.INSTANCE;
            FragmentActivity fragmentActivity = activity;
            List<SubtitleHelper.Language639> languages2 = SubtitleHelper.INSTANCE.getLanguages();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(languages2, 10));
            for (SubtitleHelper.Language639 language6392 : languages2) {
                arrayList3.add(language6392.getLanguageName());
            }
            int indexOf = arrayList2.indexOf(currentLanguageTwoLetters.element);
            String string = context.getString(R.string.subs_subtitle_languages);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri….subs_subtitle_languages)");
            singleSelectionHelper.showDialog(fragmentActivity, arrayList3, indexOf, string, true, GeneratorPlayer$openOnlineSubPicker$4$2.INSTANCE, new GeneratorPlayer$openOnlineSubPicker$4$3(currentLanguageTwoLetters, arrayList2, dialog));
        }
    }

    /* renamed from: openOnlineSubPicker$lambda-12 */
    public static final void m8718openOnlineSubPicker$lambda12(Ref.ObjectRef currentSubtitle, Dialog dialog, List providers, GeneratorPlayer this$0, View view) {
        Object obj;
        Intrinsics.checkNotNullParameter(currentSubtitle, "$currentSubtitle");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(providers, "$providers");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AbstractSubtitleEntities.SubtitleEntity subtitleEntity = (AbstractSubtitleEntities.SubtitleEntity) currentSubtitle.element;
        if (subtitleEntity != null) {
            Iterator it = providers.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((OpenSubtitlesApi) obj).getIdPrefix(), subtitleEntity.getIdPrefix())) {
                    break;
                }
            }
            OpenSubtitlesApi openSubtitlesApi = (OpenSubtitlesApi) obj;
            if (openSubtitlesApi != null) {
                Coroutines.INSTANCE.ioSafe(new GeneratorPlayer$openOnlineSubPicker$5$1$2$1(openSubtitlesApi, subtitleEntity, this$0, null));
            }
        }
        UIHelper.INSTANCE.dismissSafe(dialog);
    }

    /* renamed from: openOnlineSubPicker$lambda-13 */
    public static final void m8719openOnlineSubPicker$lambda13(Functions dismissCallback, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dismissCallback, "$dismissCallback");
        dismissCallback.invoke();
    }

    private final void openSubPicker() {
        try {
            this.subsPathPicker.launch(new String[]{"text/plain", "text/str", MimeType.BINARY_FILE, MimeTypes.TEXT_UNKNOWN, MimeTypes.TEXT_VTT, MimeTypes.TEXT_SSA, MimeTypes.APPLICATION_TTML, MimeTypes.APPLICATION_MP4VTT, MimeTypes.APPLICATION_SUBRIP});
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }

    public final void addAndSelectSubtitles(SubtitleData subtitleData) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        setSubtitles(subtitleData);
        Set<SubtitleData> mutableSet = CollectionsKt.toMutableSet(this.currentSubs);
        mutableSet.add(subtitleData);
        getPlayer().setActiveSubtitles(mutableSet);
        getPlayer().reloadPlayer(context);
        PlayerGeneratorViewModel playerGeneratorViewModel = this.viewModel;
        if (playerGeneratorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            playerGeneratorViewModel = null;
        }
        playerGeneratorViewModel.addSubtitles(SetsKt.setOf(subtitleData));
        AlertDialog alertDialog = this.selectSourceDialog;
        if (alertDialog != null) {
            UIHelper.INSTANCE.dismissSafe(alertDialog);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = context.getString(R.string.player_loaded_subtitles);
        Intrinsics.checkNotNullExpressionValue(string, "ctx.getString(R.string.player_loaded_subtitles)");
        String format = String.format(string, Arrays.copyOf(new Object[]{subtitleData.getName()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        CommonActivity.INSTANCE.showToast((Activity) getActivity(), format, (Integer) 1);
    }

    /* renamed from: subsPathPicker$lambda-14 */
    public static final void m8735subsPathPicker$lambda14(GeneratorPlayer this$0, Uri uri) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArchComponentExt.normalSafeApiCall(new GeneratorPlayer$subsPathPicker$1$1(uri, this$0));
    }

    public final AlertDialog getSelectSourceDialog() {
        return this.selectSourceDialog;
    }

    public final void setSelectSourceDialog(AlertDialog alertDialog) {
        this.selectSourceDialog = alertDialog;
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.FullScreenPlayer
    public void showMirrorsDialogue() {
        String name;
        Iterator it;
        Integer num;
        try {
            this.currentSelectedSubtitles = getPlayer().getCurrentPreferredSubtitle();
            final Context context = getContext();
            if (context != null) {
                final boolean isPlaying = getPlayer().getIsPlaying();
                getPlayer().handleEvent(CSPlayerEvent.Pause);
                final List<SubtitleData> sortSubs = MainAPIKt.sortSubs(this.currentSubs);
                final AlertDialog create = new AlertDialog.Builder(context, R.style.AlertDialogCustomBlack).setView(R.layout.player_select_source_and_subs).create();
                Intrinsics.checkNotNullExpressionValue(create, "sourceBuilder.create()");
                this.selectSourceDialog = create;
                create.show();
                final ListView listView = (ListView) create.findViewById(C4761R.C4764id.sort_providers);
                final ListView listView2 = (ListView) create.findViewById(C4761R.C4764id.sort_subtitles);
                View inflate = getLayoutInflater().inflate(R.layout.sort_bottom_footer_add_choice, (ViewGroup) null);
                if (inflate == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
                }
                TextView textView = (TextView) inflate;
                textView.setText(context.getString(R.string.player_load_subtitles));
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$GeneratorPlayer$f_d5TNOEQpJ-Uq2z3ExiT_59iJI
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GeneratorPlayer.m8726showMirrorsDialogue$lambda30$lambda15(GeneratorPlayer.this, view);
                    }
                });
                listView2.addFooterView(textView);
                final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                booleanRef.element = true;
                if (Companion.getSubsProvidersIsActive()) {
                    View inflate2 = getLayoutInflater().inflate(R.layout.sort_bottom_footer_add_choice, (ViewGroup) null);
                    if (inflate2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
                    }
                    TextView textView2 = (TextView) inflate2;
                    textView2.setText(context.getString(R.string.player_load_subtitles_online));
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$GeneratorPlayer$h6ocGA-TI494B60F1TtKIWEYXjY
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            GeneratorPlayer.m8727showMirrorsDialogue$lambda30$lambda16(Ref.BooleanRef.this, create, this, isPlaying, view);
                        }
                    });
                    listView2.addFooterView(textView2);
                }
                View inflate3 = getLayoutInflater().inflate(R.layout.sort_bottom_footer_add_choice, (ViewGroup) null);
                if (inflate3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
                }
                TextView textView3 = (TextView) inflate3;
                textView3.setText(getString(R.string.open_browser_load_subtitle));
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$GeneratorPlayer$1joU2_q0DUHDKF8kjXBp4aRuLig
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GeneratorPlayer.m8728showMirrorsDialogue$lambda30$lambda17(Ref.BooleanRef.this, create, this, view);
                    }
                });
                listView2.addFooterView(textView3);
                final Ref.IntRef intRef = new Ref.IntRef();
                final Ref.IntRef intRef2 = new Ref.IntRef();
                final List<Tuples<ExtractorLink, ExtractorUri>> sortLinks = sortLinks(false);
                if (sortLinks.isEmpty()) {
                    LinearLayout linearLayout = (LinearLayout) create.findViewById(R.id.sort_sources_holder);
                    if (linearLayout != null) {
                        Intrinsics.checkNotNullExpressionValue(linearLayout, "findViewById<LinearLayou…R.id.sort_sources_holder)");
                        linearLayout.setVisibility(8);
                    }
                } else {
                    intRef2.element = CollectionsKt.indexOf((List<? extends Tuples<? extends ExtractorLink, ExtractorUri>>) sortLinks, this.currentSelectedLink);
                    intRef.element = intRef2.element;
                    ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.sort_bottom_single_choice);
                    List<Tuples<ExtractorLink, ExtractorUri>> list = sortLinks;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        Tuples tuples = (Tuples) it2.next();
                        ExtractorLink extractorLink = (ExtractorLink) tuples.component1();
                        ExtractorUri extractorUri = (ExtractorUri) tuples.component2();
                        if (extractorLink == null || (name = extractorLink.getName()) == null) {
                            name = extractorUri != null ? extractorUri.getName() : "NULL";
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(name);
                        sb.append(' ');
                        Qualities.Companion companion = Qualities.Companion;
                        if (extractorLink != null) {
                            Integer valueOf = Integer.valueOf(extractorLink.getQuality());
                            it = it2;
                            num = valueOf;
                        } else {
                            it = it2;
                            num = null;
                        }
                        sb.append(companion.getStringByInt(num));
                        arrayList.add(sb.toString());
                        it2 = it;
                    }
                    arrayAdapter.addAll(arrayList);
                    listView.setChoiceMode(1);
                    listView.setAdapter((ListAdapter) arrayAdapter);
                    listView.setSelection(intRef.element);
                    listView.setItemChecked(intRef.element, true);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$GeneratorPlayer$DvGEsU25_Egwcc3evOsdDZvDfQY
                        @Override // android.widget.AdapterView.OnItemClickListener
                        public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                            GeneratorPlayer.m8729showMirrorsDialogue$lambda30$lambda19(Ref.IntRef.this, listView, adapterView, view, i, j);
                        }
                    });
                }
                create.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$GeneratorPlayer$zRL1iQ76JXbh03oHfJ4NiO34uwE
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        GeneratorPlayer.m8730showMirrorsDialogue$lambda30$lambda20(Ref.BooleanRef.this, this, isPlaying, dialogInterface);
                    }
                });
                final int indexOf = CollectionsKt.indexOf((List<? extends SubtitleData>) sortSubs, this.currentSelectedSubtitles) + 1;
                final Ref.IntRef intRef3 = new Ref.IntRef();
                intRef3.element = indexOf;
                ArrayAdapter arrayAdapter2 = new ArrayAdapter(context, R.layout.sort_bottom_single_choice);
                arrayAdapter2.add(getString(R.string.no_subtitles));
                List<SubtitleData> list2 = sortSubs;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (SubtitleData subtitleData : list2) {
                    arrayList2.add(subtitleData.getName());
                }
                arrayAdapter2.addAll(arrayList2);
                listView2.setAdapter((ListAdapter) arrayAdapter2);
                listView2.setChoiceMode(1);
                listView2.setSelection(intRef3.element);
                listView2.setItemChecked(intRef3.element, true);
                listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$GeneratorPlayer$gbeSUXRR7Il_GLmNMZ5x1iJS88E
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                        GeneratorPlayer.m8731showMirrorsDialogue$lambda30$lambda22(Ref.IntRef.this, listView2, adapterView, view, i, j);
                    }
                });
                MaterialButton materialButton = (MaterialButton) create.findViewById(C4761R.C4764id.cancel_btt);
                if (materialButton != null) {
                    materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$GeneratorPlayer$2Saf8xsphw-3frug7fXR5UDNxgw
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            GeneratorPlayer.m8732showMirrorsDialogue$lambda30$lambda23(AlertDialog.this, this, view);
                        }
                    });
                }
                TextView subtitles_encoding_format = (TextView) create.findViewById(C4761R.C4764id.subtitles_encoding_format);
                if (subtitles_encoding_format != null) {
                    Intrinsics.checkNotNullExpressionValue(subtitles_encoding_format, "subtitles_encoding_format");
                    SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                    String[] stringArray = context.getResources().getStringArray(R.array.subtitles_encoding_list);
                    Intrinsics.checkNotNullExpressionValue(stringArray, "ctx.resources.getStringA….subtitles_encoding_list)");
                    String[] stringArray2 = context.getResources().getStringArray(R.array.subtitles_encoding_values);
                    Intrinsics.checkNotNullExpressionValue(stringArray2, "ctx.resources.getStringA…ubtitles_encoding_values)");
                    int indexOf2 = ArraysKt.indexOf(stringArray2, defaultSharedPreferences.getString(context.getString(R.string.subtitles_encoding_key), null));
                    subtitles_encoding_format.setText(stringArray[indexOf2 == -1 ? 0 : indexOf2]);
                }
                LinearLayout linearLayout2 = (LinearLayout) create.findViewById(C4761R.C4764id.subtitles_click_settings);
                if (linearLayout2 != null) {
                    linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$GeneratorPlayer$fx_p-zuyuXq9syLXmmvuece8EME
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            GeneratorPlayer.m8733showMirrorsDialogue$lambda30$lambda25(context, this, booleanRef, create, isPlaying, view);
                        }
                    });
                }
                MaterialButton materialButton2 = (MaterialButton) create.findViewById(C4761R.C4764id.apply_btt);
                if (materialButton2 != null) {
                    materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$GeneratorPlayer$w2IHyRlUB7cNUoCr0bw3sgPFAFg
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            GeneratorPlayer.m8734showMirrorsDialogue$lambda30$lambda29(Ref.IntRef.this, intRef2, intRef3, indexOf, this, sortSubs, sortLinks, create, view);
                        }
                    });
                }
            }
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }

    /* renamed from: showMirrorsDialogue$lambda-30$lambda-15 */
    public static final void m8726showMirrorsDialogue$lambda30$lambda15(GeneratorPlayer this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.openSubPicker();
    }

    /* renamed from: showMirrorsDialogue$lambda-30$dismiss */
    public static final void m8725showMirrorsDialogue$lambda30$dismiss(boolean z, GeneratorPlayer generatorPlayer) {
        if (z) {
            generatorPlayer.getPlayer().handleEvent(CSPlayerEvent.Play);
        }
        FragmentActivity activity = generatorPlayer.getActivity();
        if (activity != null) {
            UIHelper.INSTANCE.hideSystemUI(activity);
        }
    }

    /* renamed from: showMirrorsDialogue$lambda-30$lambda-16 */
    public static final void m8727showMirrorsDialogue$lambda30$lambda16(Ref.BooleanRef shouldDismiss, AlertDialog sourceDialog, GeneratorPlayer this$0, boolean z, View view) {
        Intrinsics.checkNotNullParameter(shouldDismiss, "$shouldDismiss");
        Intrinsics.checkNotNullParameter(sourceDialog, "$sourceDialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        shouldDismiss.element = false;
        UIHelper.INSTANCE.dismissSafe(sourceDialog, this$0.getActivity());
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        this$0.openOnlineSubPicker(context, null, new GeneratorPlayer$showMirrorsDialogue$1$2$1(z, this$0));
    }

    /* renamed from: showMirrorsDialogue$lambda-30$lambda-17 */
    public static final void m8728showMirrorsDialogue$lambda30$lambda17(Ref.BooleanRef shouldDismiss, AlertDialog sourceDialog, GeneratorPlayer this$0, View view) {
        Intrinsics.checkNotNullParameter(shouldDismiss, "$shouldDismiss");
        Intrinsics.checkNotNullParameter(sourceDialog, "$sourceDialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        shouldDismiss.element = false;
        UIHelper.INSTANCE.dismissSafe(sourceDialog, this$0.getActivity());
        SubtitleBrowserFragment.Companion.pushSearch(this$0.getActivity());
    }

    /* renamed from: showMirrorsDialogue$lambda-30$lambda-19 */
    public static final void m8729showMirrorsDialogue$lambda30$lambda19(Ref.IntRef sourceIndex, ListView listView, AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(sourceIndex, "$sourceIndex");
        sourceIndex.element = i;
        listView.setItemChecked(i, true);
    }

    /* renamed from: showMirrorsDialogue$lambda-30$lambda-20 */
    public static final void m8730showMirrorsDialogue$lambda30$lambda20(Ref.BooleanRef shouldDismiss, GeneratorPlayer this$0, boolean z, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(shouldDismiss, "$shouldDismiss");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (shouldDismiss.element) {
            m8725showMirrorsDialogue$lambda30$dismiss(z, this$0);
        }
        this$0.selectSourceDialog = null;
    }

    /* renamed from: showMirrorsDialogue$lambda-30$lambda-22 */
    public static final void m8731showMirrorsDialogue$lambda30$lambda22(Ref.IntRef subtitleIndex, ListView listView, AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(subtitleIndex, "$subtitleIndex");
        subtitleIndex.element = i;
        listView.setItemChecked(i, true);
    }

    /* renamed from: showMirrorsDialogue$lambda-30$lambda-23 */
    public static final void m8732showMirrorsDialogue$lambda30$lambda23(AlertDialog sourceDialog, GeneratorPlayer this$0, View view) {
        Intrinsics.checkNotNullParameter(sourceDialog, "$sourceDialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UIHelper.INSTANCE.dismissSafe(sourceDialog, this$0.getActivity());
    }

    /* renamed from: showMirrorsDialogue$lambda-30$lambda-25 */
    public static final void m8733showMirrorsDialogue$lambda30$lambda25(Context ctx, GeneratorPlayer this$0, Ref.BooleanRef shouldDismiss, AlertDialog sourceDialog, boolean z, View view) {
        Intrinsics.checkNotNullParameter(ctx, "$ctx");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(shouldDismiss, "$shouldDismiss");
        Intrinsics.checkNotNullParameter(sourceDialog, "$sourceDialog");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        String[] stringArray = ctx.getResources().getStringArray(R.array.subtitles_encoding_list);
        Intrinsics.checkNotNullExpressionValue(stringArray, "ctx.resources.getStringA….subtitles_encoding_list)");
        String[] stringArray2 = ctx.getResources().getStringArray(R.array.subtitles_encoding_values);
        Intrinsics.checkNotNullExpressionValue(stringArray2, "ctx.resources.getStringA…ubtitles_encoding_values)");
        String string = defaultSharedPreferences.getString(this$0.getString(R.string.subtitles_encoding_key), null);
        shouldDismiss.element = false;
        UIHelper.INSTANCE.dismissSafe(sourceDialog, this$0.getActivity());
        int indexOf = ArraysKt.indexOf(stringArray2, string);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            SingleSelectionHelper singleSelectionHelper = SingleSelectionHelper.INSTANCE;
            FragmentActivity fragmentActivity = activity;
            List<String> list = ArraysKt.toList(stringArray);
            int i = indexOf == -1 ? 0 : indexOf;
            String string2 = ctx.getString(R.string.subtitles_encoding);
            Intrinsics.checkNotNullExpressionValue(string2, "ctx.getString(R.string.subtitles_encoding)");
            singleSelectionHelper.showDialog(fragmentActivity, list, i, string2, true, GeneratorPlayer$showMirrorsDialogue$1$11$1.INSTANCE, new GeneratorPlayer$showMirrorsDialogue$1$11$2(defaultSharedPreferences, ctx, stringArray2, this$0, z));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x009b, code lost:
        if (r3 != false) goto L33;
     */
    /* renamed from: showMirrorsDialogue$lambda-30$lambda-29 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m8734showMirrorsDialogue$lambda30$lambda29(kotlin.jvm.internal.Ref.IntRef r2, kotlin.jvm.internal.Ref.IntRef r3, kotlin.jvm.internal.Ref.IntRef r4, int r5, com.lagradost.cloudstream3.p041ui.player.GeneratorPlayer r6, java.util.List r7, java.util.List r8, androidx.appcompat.app.AlertDialog r9, android.view.View r10) {
        /*
            java.lang.String r10 = "$sourceIndex"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r10)
            java.lang.String r10 = "$startSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r10)
            java.lang.String r10 = "$subtitleIndex"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r10)
            java.lang.String r10 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r10)
            java.lang.String r10 = "$currentSubtitles"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r10)
            java.lang.String r10 = "$sortedUrls"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r10)
            java.lang.String r10 = "$sourceDialog"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r10)
            int r10 = r2.element
            int r3 = r3.element
            r0 = 0
            r1 = 1
            if (r10 == r3) goto L2d
            r3 = 1
            goto L2e
        L2d:
            r3 = 0
        L2e:
            int r10 = r4.element
            if (r10 == r5) goto L9f
            if (r3 != 0) goto L9d
            int r3 = r4.element
            if (r3 > 0) goto L3d
            boolean r3 = r6.noSubtitles()
            goto L9b
        L3d:
            int r3 = r4.element
            int r3 = r3 - r1
            java.lang.Object r3 = kotlin.collections.CollectionsKt.getOrNull(r7, r3)
            com.lagradost.cloudstream3.ui.player.SubtitleData r3 = (com.lagradost.cloudstream3.p041ui.player.SubtitleData) r3
            if (r3 == 0) goto L9a
            java.lang.Boolean r4 = r3.isZipUrl()
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
            if (r4 == 0) goto L95
            android.content.Context r2 = r6.getContext()
            r4 = 0
            if (r2 == 0) goto L68
            java.io.File r2 = r2.getExternalFilesDir(r4)
            if (r2 == 0) goto L68
            java.lang.String r2 = r2.getAbsolutePath()
            goto L69
        L68:
            r2 = r4
        L69:
            if (r2 == 0) goto L94
            android.content.Context r5 = r6.getContext()
            r7 = 2131952036(0x7f1301a4, float:1.9540503E38)
            java.lang.String r7 = r6.getString(r7)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            android.widget.Toast r5 = android.widget.Toast.makeText(r5, r7, r0)
            r5.show()
            com.lagradost.cloudstream3.ui.player.PlayerGeneratorViewModel r5 = r6.viewModel
            if (r5 != 0) goto L89
            java.lang.String r5 = "viewModel"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            goto L8a
        L89:
            r4 = r5
        L8a:
            com.lagradost.cloudstream3.ui.player.GeneratorPlayer$showMirrorsDialogue$1$12$1$1$1 r5 = new com.lagradost.cloudstream3.ui.player.GeneratorPlayer$showMirrorsDialogue$1$12$1$1$1
            r5.<init>(r6)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r4.extrasZipSubtitle(r3, r2, r5)
        L94:
            return
        L95:
            boolean r3 = r6.setSubtitles(r3)
            goto L9b
        L9a:
            r3 = 0
        L9b:
            if (r3 == 0) goto L9e
        L9d:
            r0 = 1
        L9e:
            r3 = r0
        L9f:
            if (r3 == 0) goto Lae
            int r2 = r2.element
            java.lang.Object r2 = kotlin.collections.CollectionsKt.getOrNull(r8, r2)
            kotlin.Pair r2 = (kotlin.Tuples) r2
            if (r2 == 0) goto Lae
            r6.loadLink(r2, r1)
        Lae:
            com.lagradost.cloudstream3.utils.UIHelper r2 = com.lagradost.cloudstream3.utils.UIHelper.INSTANCE
            android.app.Dialog r9 = (android.app.Dialog) r9
            androidx.fragment.app.FragmentActivity r3 = r6.getActivity()
            android.app.Activity r3 = (android.app.Activity) r3
            r2.dismissSafe(r9, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.player.GeneratorPlayer.m8734showMirrorsDialogue$lambda30$lambda29(kotlin.jvm.internal.Ref$IntRef, kotlin.jvm.internal.Ref$IntRef, kotlin.jvm.internal.Ref$IntRef, int, com.lagradost.cloudstream3.ui.player.GeneratorPlayer, java.util.List, java.util.List, androidx.appcompat.app.AlertDialog, android.view.View):void");
    }

    private final void noLinksFound() {
        CommonActivity.INSTANCE.showToast(getActivity(), R.string.no_links_found_toast, 0);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            UIHelper.INSTANCE.popCurrentPage(activity);
        }
    }

    public final void startPlayer() {
        if (this.isActive) {
            return;
        }
        List sortLinks$default = sortLinks$default(this, false, 1, null);
        if (sortLinks$default.isEmpty()) {
            noLinksFound();
        } else {
            loadLink((Tuples) CollectionsKt.first((List<? extends Object>) sortLinks$default), false);
        }
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
    public void nextEpisode() {
        this.isNextEpisode = true;
        getPlayer().release();
        PlayerGeneratorViewModel playerGeneratorViewModel = this.viewModel;
        if (playerGeneratorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            playerGeneratorViewModel = null;
        }
        playerGeneratorViewModel.loadLinksNext();
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
    public void prevEpisode() {
        this.isNextEpisode = true;
        getPlayer().release();
        PlayerGeneratorViewModel playerGeneratorViewModel = this.viewModel;
        if (playerGeneratorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            playerGeneratorViewModel = null;
        }
        playerGeneratorViewModel.loadLinksPrev();
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
    public void nextMirror() {
        List sortLinks$default = sortLinks$default(this, false, 1, null);
        if (sortLinks$default.isEmpty()) {
            noLinksFound();
            return;
        }
        int indexOf = CollectionsKt.indexOf((List<? extends Tuples<? extends ExtractorLink, ExtractorUri>>) sortLinks$default, this.currentSelectedLink) + 1;
        if (indexOf >= sortLinks$default.size()) {
            noLinksFound();
        } else {
            loadLink((Tuples) sortLinks$default.get(indexOf), true);
        }
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.FullScreenPlayer, com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        ResultFragmentPhimHD.Companion.updateUI();
        Job job = this.currentVerifyLink;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        super.onDestroy();
    }

    public final Integer getMaxEpisodeSet() {
        return this.maxEpisodeSet;
    }

    public final void setMaxEpisodeSet(Integer num) {
        this.maxEpisodeSet = num;
    }

    /* JADX WARN: Code restructure failed: missing block: B:158:0x0174, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.hasNextEpisode(), (java.lang.Object) true) != false) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:173:? A[RETURN, SYNTHETIC] */
    @Override // com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void playerPositionChanged(kotlin.Tuples<java.lang.Long, java.lang.Long> r24) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.player.GeneratorPlayer.playerPositionChanged(kotlin.Pair):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x004c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x00bc A[EDGE_INSN: B:155:0x00bc->B:129:0x00bc ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x00fa A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.lagradost.cloudstream3.p041ui.player.SubtitleData getAutoSelectSubtitle(java.util.Set<com.lagradost.cloudstream3.p041ui.player.SubtitleData> r13, boolean r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.player.GeneratorPlayer.getAutoSelectSubtitle(java.util.Set, boolean, boolean):com.lagradost.cloudstream3.ui.player.SubtitleData");
    }

    public final boolean autoSelectFromSettings() {
        SubtitleData autoSelectSubtitle;
        Context ctx;
        String str = this.preferredAutoSelectSubtitles;
        if ((str == null || str.length() == 0) || getPlayer().getCurrentPreferredSubtitle() != null || (autoSelectSubtitle = getAutoSelectSubtitle(this.currentSubs, true, false)) == null || (ctx = getContext()) == null || !setSubtitles(autoSelectSubtitle)) {
            return false;
        }
        IPlayer player = getPlayer();
        Intrinsics.checkNotNullExpressionValue(ctx, "ctx");
        player.reloadPlayer(ctx);
        getPlayer().handleEvent(CSPlayerEvent.Play);
        return true;
    }

    public final boolean autoSelectFromDownloads() {
        SubtitleData autoSelectSubtitle;
        Context ctx;
        if (getPlayer().getCurrentPreferredSubtitle() != null || (autoSelectSubtitle = getAutoSelectSubtitle(this.currentSubs, false, true)) == null || (ctx = getContext()) == null || !setSubtitles(autoSelectSubtitle)) {
            return false;
        }
        IPlayer player = getPlayer();
        Intrinsics.checkNotNullExpressionValue(ctx, "ctx");
        player.reloadPlayer(ctx);
        getPlayer().handleEvent(CSPlayerEvent.Play);
        return true;
    }

    public final void autoSelectSubtitles() {
        ArchComponentExt.normalSafeApiCall(new GeneratorPlayer$autoSelectSubtitles$1(this));
    }

    private final String getPlayerVideoTitle() {
        TvType tvType;
        String str;
        Integer num;
        Integer num2;
        String str2;
        Object obj = this.currentMeta;
        String str3 = null;
        if (obj instanceof ResultEpisode) {
            ResultEpisode resultEpisode = (ResultEpisode) obj;
            str3 = resultEpisode.getHeaderName();
            str = resultEpisode.getName();
            num = Integer.valueOf(resultEpisode.getEpisode());
            num2 = resultEpisode.getSeason();
            tvType = resultEpisode.getTvType();
        } else if (obj instanceof ExtractorUri) {
            ExtractorUri extractorUri = (ExtractorUri) obj;
            str3 = extractorUri.getHeaderName();
            str = extractorUri.getName();
            num = extractorUri.getEpisode();
            num2 = extractorUri.getSeason();
            tvType = extractorUri.getTvType();
        } else {
            tvType = null;
            str = null;
            num = null;
            num2 = null;
        }
        String str4 = "";
        if (str3 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            if (!MainAPIKt.isEpisodeBased(tvType) || num == null) {
                str2 = "";
            } else if (num2 == null) {
                str2 = " - " + getString(R.string.episode) + ' ' + num;
            } else {
                str2 = " \"" + getString(R.string.season_short) + num2 + ':' + getString(R.string.episode_short) + num + '\"';
            }
            sb.append(str2);
            String str5 = str;
            if (!(str5 == null || StringsKt.isBlank(str5)) && !Intrinsics.areEqual(str, str3)) {
                str4 = " - " + str;
            }
            sb.append(str4);
            return sb.toString();
        }
        return "";
    }

    public final void setTitle() {
        String playerVideoTitle = getPlayerVideoTitle();
        if (this.limitTitle < 0) {
            TextView textView = (TextView) _$_findCachedViewById(C4761R.C4764id.player_video_title);
            if (textView != null) {
                textView.setVisibility(8);
            }
        } else {
            int length = playerVideoTitle.length();
            int i = this.limitTitle;
            int i2 = length - i;
            if (i > 0 && i2 > 3) {
                StringBuilder sb = new StringBuilder();
                String substring = playerVideoTitle.substring(0, this.limitTitle - 1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                sb.append(substring);
                sb.append("...");
                playerVideoTitle = sb.toString();
            }
        }
        Object obj = this.currentMeta;
        ResultEpisode resultEpisode = obj instanceof ResultEpisode ? (ResultEpisode) obj : null;
        Boolean isFiller = resultEpisode != null ? resultEpisode.isFiller() : null;
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_episode_filler_holder);
        if (frameLayout != null) {
            frameLayout.setVisibility(isFiller != null ? isFiller.booleanValue() : false ? 0 : 8);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(C4761R.C4764id.player_video_title);
        if (textView2 != null) {
            textView2.setText(playerVideoTitle);
        }
        IGenerator iGenerator = lastUsedGenerator;
        if (iGenerator instanceof SponsorFileGenerator) {
            Objects.requireNonNull(iGenerator, "null cannot be cast to non-null type com.lagradost.cloudstream3.ui.player.SponsorFileGenerator");
            if (Intrinsics.areEqual(((SponsorFileGenerator) iGenerator).getApiName(), ConfigHomeKt.IPTV_API_NAME)) {
                TextView textView3 = (TextView) _$_findCachedViewById(C4761R.C4764id.player_video_title_live);
                if (textView3 != null) {
                    textView3.setVisibility(0);
                    TextView textView4 = (TextView) _$_findCachedViewById(C4761R.C4764id.player_video_title);
                    if (textView4 != null) {
                        textView4.setVisibility(8);
                    }
                }
                FrameLayout frameLayout2 = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.player_episode_filler_holder);
                if (frameLayout2 != null) {
                    frameLayout2.setVisibility(0);
                    frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$GeneratorPlayer$PvSjDtSFJa71UexnvXjPn_tcUi8
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            GeneratorPlayer.m8723setTitle$lambda44$lambda42(GeneratorPlayer.this, view);
                        }
                    });
                    MaterialButton materialButton = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.player_episode_filler);
                    if (materialButton != null) {
                        materialButton.setText(getString(R.string.bug_report_txt));
                    }
                    MaterialButton materialButton2 = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.player_episode_filler);
                    if (materialButton2 != null) {
                        materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$GeneratorPlayer$Pntgmp_J-pj5m1OIqASiEhsyeEU
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                GeneratorPlayer.m8724setTitle$lambda44$lambda43(GeneratorPlayer.this, view);
                            }
                        });
                    }
                }
            }
        }
    }

    /* renamed from: setTitle$lambda-44$lambda-42 */
    public static final void m8723setTitle$lambda44$lambda42(GeneratorPlayer this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(Constants.URL_PAGE));
        this$0.startActivity(intent);
    }

    /* renamed from: setTitle$lambda-44$lambda-43 */
    public static final void m8724setTitle$lambda44$lambda43(GeneratorPlayer this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(Constants.URL_PAGE));
        this$0.startActivity(intent);
    }

    public final void setPlayerDimen(Tuples<Integer, Integer> tuples) {
        String str;
        String name;
        ExtractorUri second;
        String str2;
        ExtractorLink first;
        if (tuples != null) {
            int intValue = tuples.component1().intValue();
            int intValue2 = tuples.component2().intValue();
            StringBuilder sb = new StringBuilder();
            sb.append(intValue);
            sb.append('x');
            sb.append(intValue2);
            str = sb.toString();
        } else {
            str = "";
        }
        Tuples<? extends ExtractorLink, ExtractorUri> tuples2 = this.currentSelectedLink;
        if (tuples2 == null || (first = tuples2.getFirst()) == null || (name = first.getName()) == null) {
            Tuples<? extends ExtractorLink, ExtractorUri> tuples3 = this.currentSelectedLink;
            name = (tuples3 == null || (second = tuples3.getSecond()) == null) ? "NULL" : second.getName();
        }
        TextView textView = (TextView) _$_findCachedViewById(C4761R.C4764id.player_video_title_rez);
        if (textView == null) {
            return;
        }
        int i = this.titleRez;
        if (i != 0) {
            if (i == 1) {
                str2 = str;
            } else if (i == 2) {
                str2 = name;
            } else if (i == 3) {
                str2 = name + " - " + str;
            }
        }
        textView.setText(str2);
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment
    public void playerDimensionsLoaded(Tuples<Integer, Integer> widthHeight) {
        Intrinsics.checkNotNullParameter(widthHeight, "widthHeight");
        setPlayerDimen(widthHeight);
    }

    private final void unwrapBundle(Bundle bundle) {
        Log.i(CS3IPlayerKt.TAG, "unwrapBundle = " + bundle);
        if (bundle != null) {
            SyncViewModel syncViewModel = this.sync;
            if (syncViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sync");
                syncViewModel = null;
            }
            Serializable serializable = bundle.getSerializable("syncData");
            syncViewModel.addSyncs(serializable instanceof HashMap ? (HashMap) serializable : null);
        }
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context context = getContext();
        boolean z = true;
        setLayout((context == null || !SettingsFragment.Companion.isTvSettings(context)) ? false : false ? R.layout.fragment_player_tv : R.layout.fragment_player);
        GeneratorPlayer generatorPlayer = this;
        this.viewModel = (PlayerGeneratorViewModel) new ViewModelProvider(generatorPlayer).get(PlayerGeneratorViewModel.class);
        this.viewModelBrowserSubtitle = (SubtitleBrowserViewModel) new ViewModelProvider(generatorPlayer).get(SubtitleBrowserViewModel.class);
        this.sync = (SyncViewModel) new ViewModelProvider(generatorPlayer).get(SyncViewModel.class);
        PlayerGeneratorViewModel playerGeneratorViewModel = this.viewModel;
        if (playerGeneratorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            playerGeneratorViewModel = null;
        }
        playerGeneratorViewModel.attachGenerator(lastUsedGenerator);
        unwrapBundle(bundle);
        unwrapBundle(getArguments());
        return super.onCreateView(inflater, viewGroup, bundle);
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.FullScreenPlayer, com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment, androidx.fragment.app.Fragment
    public void onResume() {
        SavedStateHandle savedStateHandle;
        MutableLiveData liveData;
        super.onResume();
        PlayerGeneratorViewModel playerGeneratorViewModel = this.viewModel;
        if (playerGeneratorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            playerGeneratorViewModel = null;
        }
        Log.d("BLUE --> onResume", playerGeneratorViewModel.getNotifyData().toString());
        NavBackStackEntry currentBackStackEntry = Fragment.findNavController(this).getCurrentBackStackEntry();
        if (currentBackStackEntry == null || (savedStateHandle = currentBackStackEntry.getSavedStateHandle()) == null || (liveData = savedStateHandle.getLiveData("your_key")) == null) {
            return;
        }
        liveData.observe(getViewLifecycleOwner(), new Observer() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$GeneratorPlayer$xTn3mJmXOvWjmIBjr0Z1I1UkDj8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GeneratorPlayer.m8715onResume$lambda46(GeneratorPlayer.this, (String) obj);
            }
        });
    }

    /* renamed from: onResume$lambda-46 */
    public static final void m8715onResume$lambda46(GeneratorPlayer this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.d("BLUE --> onResume", it);
        PlayerGeneratorViewModel playerGeneratorViewModel = this$0.viewModel;
        if (playerGeneratorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            playerGeneratorViewModel = null;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        playerGeneratorViewModel.uploadFileSub(it, new GeneratorPlayer$onResume$1$1(this$0));
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.FullScreenPlayer, com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        GeneratorPlayer generatorPlayer = this;
        SubtitleBrowserViewModel subtitleBrowserViewModel = this.viewModelBrowserSubtitle;
        PlayerGeneratorViewModel playerGeneratorViewModel = null;
        if (subtitleBrowserViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelBrowserSubtitle");
            subtitleBrowserViewModel = null;
        }
        ArchComponentExt.observe(generatorPlayer, subtitleBrowserViewModel.getResultResponse(), GeneratorPlayer$onViewCreated$1.INSTANCE);
        PlayerGeneratorViewModel playerGeneratorViewModel2 = this.viewModel;
        if (playerGeneratorViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            playerGeneratorViewModel2 = null;
        }
        ArchComponentExt.observe(generatorPlayer, playerGeneratorViewModel2.getNotifyData(), GeneratorPlayer$onViewCreated$2.INSTANCE);
        Context context = getContext();
        if (context != null) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            this.titleRez = defaultSharedPreferences.getInt(getString(R.string.prefer_limit_title_rez_key), 3);
            this.limitTitle = defaultSharedPreferences.getInt(getString(R.string.prefer_limit_title_key), 0);
            CustomDecoder.Companion.updateForcedEncoding(context);
        }
        unwrapBundle(bundle);
        unwrapBundle(getArguments());
        SyncViewModel syncViewModel = this.sync;
        if (syncViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sync");
            syncViewModel = null;
        }
        syncViewModel.updateUserData();
        this.preferredAutoSelectSubtitles = SubtitlesFragment.Companion.getAutoSelectLanguageISO639_1();
        if (this.currentSelectedLink == null) {
            PlayerGeneratorViewModel playerGeneratorViewModel3 = this.viewModel;
            if (playerGeneratorViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                playerGeneratorViewModel3 = null;
            }
            PlayerGeneratorViewModel.loadLinks$default(playerGeneratorViewModel3, false, false, 3, null);
        }
        MaterialButton materialButton = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.overlay_loading_skip_button);
        if (materialButton != null) {
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$GeneratorPlayer$WHujn8-6XQLWKbTwruFDWaKkpY4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GeneratorPlayer.m8716onViewCreated$lambda48(GeneratorPlayer.this, view2);
                }
            });
        }
        ImageView imageView = (ImageView) _$_findCachedViewById(C4761R.C4764id.player_loading_go_back);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$GeneratorPlayer$HtWU9hjscP9iZeffoskMNTzLU0Q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GeneratorPlayer.m8717onViewCreated$lambda49(GeneratorPlayer.this, view2);
                }
            });
        }
        PlayerGeneratorViewModel playerGeneratorViewModel4 = this.viewModel;
        if (playerGeneratorViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            playerGeneratorViewModel4 = null;
        }
        ArchComponentExt.observe(generatorPlayer, playerGeneratorViewModel4.getLoadingLinks(), new GeneratorPlayer$onViewCreated$6(this));
        PlayerGeneratorViewModel playerGeneratorViewModel5 = this.viewModel;
        if (playerGeneratorViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            playerGeneratorViewModel5 = null;
        }
        ArchComponentExt.observe(generatorPlayer, playerGeneratorViewModel5.getCurrentLinks(), new GeneratorPlayer$onViewCreated$7(this));
        PlayerGeneratorViewModel playerGeneratorViewModel6 = this.viewModel;
        if (playerGeneratorViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            playerGeneratorViewModel = playerGeneratorViewModel6;
        }
        ArchComponentExt.observe(generatorPlayer, playerGeneratorViewModel.getCurrentSubs(), new GeneratorPlayer$onViewCreated$8(this));
    }

    /* renamed from: onViewCreated$lambda-48 */
    public static final void m8716onViewCreated$lambda48(GeneratorPlayer this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startPlayer();
    }

    /* renamed from: onViewCreated$lambda-49 */
    public static final void m8717onViewCreated$lambda49(GeneratorPlayer this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getPlayer().release();
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            UIHelper.INSTANCE.popCurrentPage(activity);
        }
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.FullScreenPlayer, com.lagradost.cloudstream3.p041ui.player.AbstractPlayerFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        AppController companion = AppController.Companion.getInstance();
        if (companion != null) {
            companion.setVastAdded(false);
        }
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}
