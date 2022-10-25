package com.lagradost.cloudstream3.p041ui.result;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.FragmentActivity;
import com.bongngotv2.R;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.button.MaterialButton;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivity;
import com.lagradost.cloudstream3.ProviderType;
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.VPNStatus;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.p041ui.download.DownloadButtonSetup;
import com.lagradost.cloudstream3.p041ui.download.DownloadClickEvent;
import com.lagradost.cloudstream3.p041ui.download.EasyDownloadButton;
import com.lagradost.cloudstream3.p041ui.quicksearch.QuickSearchFragment;
import com.lagradost.cloudstream3.p041ui.settings.SettingsFragment;
import com.lagradost.cloudstream3.utils.UIHelper;
import com.lagradost.cloudstream3.utils.VideoDownloadHelper;
import com.lagradost.cloudstream3.utils.VideoDownloadManager;
import com.lagradost.cloudstream3.widget.FlowLayout;
import com.phimhd.AppController;
import com.phimhd.Key;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* compiled from: ResultFragmentPhimHD.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", "data", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "Lcom/lagradost/cloudstream3/LoadResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD$onViewCreated$29 */
/* loaded from: classes4.dex */
final class ResultFragmentPhimHD$onViewCreated$29 extends Lambda implements Function1<Resource<? extends LoadResponse>, Unit> {
    final /* synthetic */ MainAPI $api;
    final /* synthetic */ String $apiName;
    final /* synthetic */ ResultFragmentPhimHD this$0;

    /* compiled from: ResultFragmentPhimHD.kt */
    @Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD$onViewCreated$29$WhenMappings */
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[VPNStatus.values().length];
            iArr[VPNStatus.MightBeNeeded.ordinal()] = 1;
            iArr[VPNStatus.Torrent.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ProviderType.values().length];
            iArr2[ProviderType.MetaProvider.ordinal()] = 1;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[TvType.values().length];
            iArr3[TvType.TvSeries.ordinal()] = 1;
            iArr3[TvType.Anime.ordinal()] = 2;
            iArr3[TvType.OVA.ordinal()] = 3;
            iArr3[TvType.AnimeMovie.ordinal()] = 4;
            iArr3[TvType.Cartoon.ordinal()] = 5;
            iArr3[TvType.Documentary.ordinal()] = 6;
            iArr3[TvType.Movie.ordinal()] = 7;
            iArr3[TvType.Torrent.ordinal()] = 8;
            iArr3[TvType.AsianDrama.ordinal()] = 9;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultFragmentPhimHD$onViewCreated$29(ResultFragmentPhimHD resultFragmentPhimHD, MainAPI mainAPI, String str) {
        super(1);
        this.this$0 = resultFragmentPhimHD;
        this.$api = mainAPI;
        this.$apiName = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends LoadResponse> resource) {
        invoke2(resource);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Resource<? extends LoadResponse> data) {
        ShowStatus showStatus;
        SyncViewModel syncViewModel;
        SyncViewModel syncViewModel2;
        ResultFragmentPhimHD resultFragmentPhimHD;
        int i;
        EasyDownloadButton easyDownloadButton;
        EasyDownloadButton easyDownloadButton2;
        CardView cardView;
        SyncViewModel syncViewModel3;
        SyncViewModel syncViewModel4;
        List<Episode> episodes;
        String str;
        String string;
        Intrinsics.checkNotNullParameter(data, "data");
        if (data instanceof Resource.Success) {
            final LoadResponse loadResponse = (LoadResponse) ((Resource.Success) data).getValue();
            boolean z = loadResponse instanceof AnimeLoadResponse;
            if (!z) {
                ShimmerFrameLayout result_episode_loading = (ShimmerFrameLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.result_episode_loading);
                Intrinsics.checkNotNullExpressionValue(result_episode_loading, "result_episode_loading");
                if (result_episode_loading.getVisibility() == 0) {
                    ShimmerFrameLayout result_episode_loading2 = (ShimmerFrameLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.result_episode_loading);
                    Intrinsics.checkNotNullExpressionValue(result_episode_loading2, "result_episode_loading");
                    result_episode_loading2.setVisibility(8);
                }
            }
            this.this$0.updateVisStatus(2);
            TextView textView = (TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_vpn);
            if (textView != null) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[this.$api.getVpnStatus().ordinal()];
                if (i2 == 1) {
                    string = this.this$0.getString(R.string.vpn_might_be_needed);
                } else if (i2 == 2) {
                    string = this.this$0.getString(R.string.vpn_torrent);
                }
                textView.setText(string);
            }
            TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_vpn);
            if (textView2 != null) {
                textView2.setVisibility(this.$api.getVpnStatus() == VPNStatus.None ? 8 : 0);
            }
            TextView textView3 = (TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_info);
            if (textView3 != null) {
                if (WhenMappings.$EnumSwitchMapping$1[this.$api.getProviderType().ordinal()] == 1) {
                    str = this.this$0.getString(R.string.provider_info_meta);
                }
                textView3.setText(str);
            }
            TextView textView4 = (TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_info);
            if (textView4 != null) {
                textView4.setVisibility(this.$api.getProviderType() == ProviderType.MetaProvider ? 0 : 8);
            }
            if (MainAPIKt.isEpisodeBased(loadResponse.getType())) {
                TvSeriesLoadResponse tvSeriesLoadResponse = loadResponse instanceof TvSeriesLoadResponse ? (TvSeriesLoadResponse) loadResponse : null;
                if (((tvSeriesLoadResponse == null || (episodes = tvSeriesLoadResponse.getEpisodes()) == null) ? 1 : episodes.size()) < 1) {
                    TextView textView5 = (TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_info);
                    if (textView5 != null) {
                        textView5.setText(this.this$0.getString(R.string.no_episodes_found));
                    }
                    TextView textView6 = (TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_info);
                    if (textView6 != null) {
                        textView6.setVisibility(0);
                    }
                }
            }
            this.this$0.currentHeaderName = loadResponse.getName();
            this.this$0.currentType = loadResponse.getType();
            this.this$0.currentPoster = loadResponse.getPosterUrl();
            this.this$0.currentIsMovie = Boolean.valueOf(!MainAPIKt.isEpisodeBased(loadResponse));
            MaterialButton materialButton = (MaterialButton) this.this$0._$_findCachedViewById(C4761R.C4764id.result_open_in_browser);
            if (materialButton != null) {
                final ResultFragmentPhimHD resultFragmentPhimHD2 = this.this$0;
                materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$ResultFragmentPhimHD$onViewCreated$29$mNwlDXGYORwr5f8JwR22TOiBK_Y
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ResultFragmentPhimHD$onViewCreated$29.m8786invoke$lambda0(LoadResponse.this, resultFragmentPhimHD2, view);
                    }
                });
                Unit unit = Unit.INSTANCE;
            }
            MaterialButton materialButton2 = (MaterialButton) this.this$0._$_findCachedViewById(C4761R.C4764id.result_search);
            if (materialButton2 != null) {
                final ResultFragmentPhimHD resultFragmentPhimHD3 = this.this$0;
                materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$ResultFragmentPhimHD$onViewCreated$29$qczR9LOs8-sTAOAtBxsrS3HiNfo
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ResultFragmentPhimHD$onViewCreated$29.m8787invoke$lambda1(ResultFragmentPhimHD.this, loadResponse, view);
                    }
                });
                Unit unit2 = Unit.INSTANCE;
            }
            MaterialButton materialButton3 = (MaterialButton) this.this$0._$_findCachedViewById(C4761R.C4764id.result_share);
            if (materialButton3 != null) {
                final ResultFragmentPhimHD resultFragmentPhimHD4 = this.this$0;
                materialButton3.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$ResultFragmentPhimHD$onViewCreated$29$pSaLgsesVrLV_djoiHY87-PtX1s
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ResultFragmentPhimHD$onViewCreated$29.m8791invoke$lambda2(LoadResponse.this, resultFragmentPhimHD4, view);
                    }
                });
                Unit unit3 = Unit.INSTANCE;
            }
            if (loadResponse instanceof TvSeriesLoadResponse) {
                showStatus = ((TvSeriesLoadResponse) loadResponse).getShowStatus();
            } else {
                showStatus = z ? ((AnimeLoadResponse) loadResponse).getShowStatus() : null;
            }
            this.this$0.setShow(showStatus);
            this.this$0.setDuration(loadResponse.getDuration());
            this.this$0.setYear(loadResponse.getYear());
            this.this$0.setRating(loadResponse.getRating());
            this.this$0.setRecommendations(loadResponse.getRecommendations(), null);
            this.this$0.setActors(loadResponse.getActors());
            syncViewModel = this.this$0.syncModel;
            if (syncViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("syncModel");
                syncViewModel = null;
            }
            if (syncViewModel.addSyncs(loadResponse.getSyncData())) {
                syncViewModel3 = this.this$0.syncModel;
                if (syncViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("syncModel");
                    syncViewModel3 = null;
                }
                syncViewModel3.updateMetaAndUser();
                syncViewModel4 = this.this$0.syncModel;
                if (syncViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("syncModel");
                    syncViewModel4 = null;
                }
                syncViewModel4.updateSynced();
            } else {
                syncViewModel2 = this.this$0.syncModel;
                if (syncViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("syncModel");
                    syncViewModel2 = null;
                }
                syncViewModel2.addFromUrl(loadResponse.getUrl());
            }
            MaterialButton materialButton4 = (MaterialButton) this.this$0._$_findCachedViewById(C4761R.C4764id.result_meta_site);
            if (materialButton4 != null) {
                materialButton4.setText(loadResponse.getApiName());
            }
            final String posterUrl = loadResponse.getPosterUrl();
            String str2 = posterUrl;
            if (!(str2 == null || str2.length() == 0)) {
                ImageView imageView = (ImageView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_poster);
                if (imageView != null) {
                    Boolean.valueOf(UIHelper.setImage$default(UIHelper.INSTANCE, imageView, posterUrl, loadResponse.getPosterHeaders(), null, 4, null));
                }
                ImageView imageView2 = (ImageView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_poster_blur);
                if (imageView2 != null) {
                    UIHelper.INSTANCE.setImageBlur(imageView2, posterUrl, 10, 3, loadResponse.getPosterHeaders());
                    Unit unit4 = Unit.INSTANCE;
                }
                Context context = this.this$0.getContext();
                if (((context == null || SettingsFragment.Companion.isTrueTvSettings(context)) ? false : true) && (cardView = (CardView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_poster_holder)) != null) {
                    final ResultFragmentPhimHD resultFragmentPhimHD5 = this.this$0;
                    cardView.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$ResultFragmentPhimHD$onViewCreated$29$Nff7XMd3p2BbXqFVu0gcAULi1PU
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ResultFragmentPhimHD$onViewCreated$29.m8792invoke$lambda4(ResultFragmentPhimHD.this, posterUrl, view);
                        }
                    });
                    Unit unit5 = Unit.INSTANCE;
                }
            } else {
                ImageView imageView3 = (ImageView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_poster);
                if (imageView3 != null) {
                    imageView3.setImageResource(R.drawable.default_cover);
                    Unit unit6 = Unit.INSTANCE;
                }
                ImageView imageView4 = (ImageView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_poster_blur);
                if (imageView4 != null) {
                    imageView4.setImageResource(R.drawable.default_cover);
                    Unit unit7 = Unit.INSTANCE;
                }
            }
            CardView cardView2 = (CardView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_poster_holder);
            if (cardView2 != null) {
                cardView2.setVisibility(0);
            }
            String plot = loadResponse.getPlot();
            if (!(plot == null || plot.length() == 0)) {
                String plot2 = loadResponse.getPlot();
                Intrinsics.checkNotNull(plot2);
                if (plot2.length() > 1000) {
                    StringBuilder sb = new StringBuilder();
                    String substring = plot2.substring(0, 1000);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    sb.append(substring);
                    sb.append("...");
                    plot2 = sb.toString();
                }
                final ResultFragmentPhimHD resultFragmentPhimHD6 = this.this$0;
                ((TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_description)).setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$ResultFragmentPhimHD$onViewCreated$29$XtIiy-WF3_rfcgxxvb4sbMsxPmI
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ResultFragmentPhimHD$onViewCreated$29.m8793invoke$lambda5(ResultFragmentPhimHD.this, loadResponse, view);
                    }
                });
                ((TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_description)).setText(plot2);
            } else {
                TextView textView7 = (TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_description);
                if (loadResponse.getType() == TvType.Torrent) {
                    resultFragmentPhimHD = this.this$0;
                    i = R.string.torrent_no_plot;
                } else {
                    resultFragmentPhimHD = this.this$0;
                    i = R.string.normal_no_plot;
                }
                textView7.setText(resultFragmentPhimHD.getString(i));
            }
            FlowLayout flowLayout = (FlowLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.result_tag);
            if (flowLayout != null) {
                flowLayout.removeAllViews();
                Unit unit8 = Unit.INSTANCE;
            }
            boolean comingSoon = loadResponse.getComingSoon();
            ResultFragmentPhimHD resultFragmentPhimHD7 = this.this$0;
            TextView result_coming_soon = (TextView) resultFragmentPhimHD7._$_findCachedViewById(C4761R.C4764id.result_coming_soon);
            if (result_coming_soon != null) {
                Intrinsics.checkNotNullExpressionValue(result_coming_soon, "result_coming_soon");
                result_coming_soon.setVisibility(comingSoon ? 0 : 8);
            }
            LinearLayout result_data_holder = (LinearLayout) resultFragmentPhimHD7._$_findCachedViewById(C4761R.C4764id.result_data_holder);
            if (result_data_holder != null) {
                Intrinsics.checkNotNullExpressionValue(result_data_holder, "result_data_holder");
                result_data_holder.setVisibility(comingSoon ? 8 : 0);
            }
            Unit unit9 = Unit.INSTANCE;
            List<String> tags = loadResponse.getTags();
            List<String> list = tags;
            if (!(list == null || list.isEmpty())) {
                Context context2 = this.this$0.getContext();
                boolean z2 = context2 != null && SettingsFragment.Companion.isTrueTvSettings(context2);
                int i3 = 0;
                for (String str3 : tags) {
                    int i4 = i3 + 1;
                    View inflate = this.this$0.getLayoutInflater().inflate(R.layout.result_tag, (ViewGroup) null);
                    MaterialButton materialButton5 = (MaterialButton) inflate.findViewById(R.id.result_tag_card);
                    materialButton5.setText(str3);
                    materialButton5.setFocusable(!z2);
                    materialButton5.setClickable(!z2);
                    FlowLayout flowLayout2 = (FlowLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.result_tag);
                    if (flowLayout2 != null) {
                        flowLayout2.addView(inflate, i3);
                        Unit unit10 = Unit.INSTANCE;
                    }
                    i3 = i4;
                }
            }
            if (!MainAPIKt.isMovieType(loadResponse.getType())) {
                this.this$0.lateFixDownloadButton(false);
                MaterialButton materialButton6 = (MaterialButton) this.this$0._$_findCachedViewById(C4761R.C4764id.result_play_movie);
                if (materialButton6 != null) {
                    final ResultFragmentPhimHD resultFragmentPhimHD8 = this.this$0;
                    final String str4 = this.$apiName;
                    final MainAPI mainAPI = this.$api;
                    materialButton6.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$ResultFragmentPhimHD$onViewCreated$29$Q3FefuE3q5i0hslBuRvwyJFI5N8
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ResultFragmentPhimHD$onViewCreated$29.m8789invoke$lambda11(ResultFragmentPhimHD.this, str4, mainAPI, view);
                        }
                    });
                    Unit unit11 = Unit.INSTANCE;
                }
                MaterialButton materialButton7 = (MaterialButton) this.this$0._$_findCachedViewById(C4761R.C4764id.result_play_movie);
                if (materialButton7 != null) {
                    final ResultFragmentPhimHD resultFragmentPhimHD9 = this.this$0;
                    final String str5 = this.$apiName;
                    final MainAPI mainAPI2 = this.$api;
                    materialButton7.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$ResultFragmentPhimHD$onViewCreated$29$8QuM49Oa24iqI604mHXPSihlfP0
                        @Override // android.view.View.OnLongClickListener
                        public final boolean onLongClick(View view) {
                            boolean m8790invoke$lambda12;
                            m8790invoke$lambda12 = ResultFragmentPhimHD$onViewCreated$29.m8790invoke$lambda12(ResultFragmentPhimHD.this, str5, mainAPI2, view);
                            return m8790invoke$lambda12;
                        }
                    });
                    Unit unit12 = Unit.INSTANCE;
                }
            } else {
                boolean hasDownloadSupport = this.$api.getHasDownloadSupport();
                this.this$0.lateFixDownloadButton(true);
                MaterialButton materialButton8 = (MaterialButton) this.this$0._$_findCachedViewById(C4761R.C4764id.result_play_movie);
                if (materialButton8 != null) {
                    final ResultFragmentPhimHD resultFragmentPhimHD10 = this.this$0;
                    final String str6 = this.$apiName;
                    final MainAPI mainAPI3 = this.$api;
                    materialButton8.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$ResultFragmentPhimHD$onViewCreated$29$bZ761W8R9mOJ47m79OJkOd9024M
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ResultFragmentPhimHD$onViewCreated$29.m8794invoke$lambda7(ResultFragmentPhimHD.this, str6, mainAPI3, view);
                        }
                    });
                    Unit unit13 = Unit.INSTANCE;
                }
                MaterialButton materialButton9 = (MaterialButton) this.this$0._$_findCachedViewById(C4761R.C4764id.result_play_movie);
                if (materialButton9 != null) {
                    final ResultFragmentPhimHD resultFragmentPhimHD11 = this.this$0;
                    final String str7 = this.$apiName;
                    final MainAPI mainAPI4 = this.$api;
                    materialButton9.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$ResultFragmentPhimHD$onViewCreated$29$W3KMB3Nmoh-i3cirQ7eFEIoQnos
                        @Override // android.view.View.OnLongClickListener
                        public final boolean onLongClick(View view) {
                            boolean m8795invoke$lambda8;
                            m8795invoke$lambda8 = ResultFragmentPhimHD$onViewCreated$29.m8795invoke$lambda8(ResultFragmentPhimHD.this, str7, mainAPI4, view);
                            return m8795invoke$lambda8;
                        }
                    });
                    Unit unit14 = Unit.INSTANCE;
                }
                MaterialButton materialButton10 = (MaterialButton) this.this$0._$_findCachedViewById(C4761R.C4764id.result_download_movie);
                if (materialButton10 != null) {
                    final ResultFragmentPhimHD resultFragmentPhimHD12 = this.this$0;
                    final String str8 = this.$apiName;
                    final MainAPI mainAPI5 = this.$api;
                    materialButton10.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$ResultFragmentPhimHD$onViewCreated$29$YjU9HKrdppL0-veMcQOJbjyiDPc
                        @Override // android.view.View.OnLongClickListener
                        public final boolean onLongClick(View view) {
                            boolean m8796invoke$lambda9;
                            m8796invoke$lambda9 = ResultFragmentPhimHD$onViewCreated$29.m8796invoke$lambda9(ResultFragmentPhimHD.this, str8, mainAPI5, view);
                            return m8796invoke$lambda9;
                        }
                    });
                    Unit unit15 = Unit.INSTANCE;
                }
                if (hasDownloadSupport) {
                    int id = APIHolder.INSTANCE.getId(loadResponse);
                    VideoDownloadManager videoDownloadManager = VideoDownloadManager.INSTANCE;
                    Context requireContext = this.this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    VideoDownloadManager.DownloadedFileInfoResult downloadFileInfoAndUpdateSettings = videoDownloadManager.getDownloadFileInfoAndUpdateSettings(requireContext, id);
                    easyDownloadButton = this.this$0.downloadButton;
                    if (easyDownloadButton != null) {
                        easyDownloadButton.dispose();
                        Unit unit16 = Unit.INSTANCE;
                    }
                    this.this$0.downloadButton = new EasyDownloadButton();
                    easyDownloadButton2 = this.this$0.downloadButton;
                    if (easyDownloadButton2 != null) {
                        Long valueOf = downloadFileInfoAndUpdateSettings != null ? Long.valueOf(downloadFileInfoAndUpdateSettings.getFileLength()) : null;
                        Long valueOf2 = downloadFileInfoAndUpdateSettings != null ? Long.valueOf(downloadFileInfoAndUpdateSettings.getTotalBytes()) : null;
                        ContentLoadingProgressBar result_movie_progress_downloaded = (ContentLoadingProgressBar) this.this$0._$_findCachedViewById(C4761R.C4764id.result_movie_progress_downloaded);
                        Intrinsics.checkNotNullExpressionValue(result_movie_progress_downloaded, "result_movie_progress_downloaded");
                        ImageView result_movie_download_icon = (ImageView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_movie_download_icon);
                        Intrinsics.checkNotNullExpressionValue(result_movie_download_icon, "result_movie_download_icon");
                        TextView textView8 = (TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_movie_download_text);
                        TextView textView9 = (TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_movie_download_text_precentage);
                        MaterialButton result_download_movie = (MaterialButton) this.this$0._$_findCachedViewById(C4761R.C4764id.result_download_movie);
                        Intrinsics.checkNotNullExpressionValue(result_download_movie, "result_download_movie");
                        easyDownloadButton2.setUpMoreButton(valueOf, valueOf2, result_movie_progress_downloaded, result_movie_download_icon, textView8, textView9, result_download_movie, true, new VideoDownloadHelper.DownloadEpisodeCached(loadResponse.getName(), loadResponse.getPosterUrl(), 0, null, id, id, loadResponse.getRating(), loadResponse.getPlot(), System.currentTimeMillis()), new C493310(this.this$0, loadResponse, id, this.$apiName, this.$api));
                        Unit unit17 = Unit.INSTANCE;
                    }
                    MaterialButton materialButton11 = (MaterialButton) this.this$0._$_findCachedViewById(C4761R.C4764id.result_download_movie);
                    if (materialButton11 != null) {
                        final ResultFragmentPhimHD resultFragmentPhimHD13 = this.this$0;
                        final String str9 = this.$apiName;
                        final MainAPI mainAPI6 = this.$api;
                        materialButton11.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$ResultFragmentPhimHD$onViewCreated$29$e_c7zIjXCG8E_kjKd4f7MIySM_k
                            @Override // android.view.View.OnLongClickListener
                            public final boolean onLongClick(View view) {
                                boolean m8788invoke$lambda10;
                                m8788invoke$lambda10 = ResultFragmentPhimHD$onViewCreated$29.m8788invoke$lambda10(ResultFragmentPhimHD.this, str9, mainAPI6, view);
                                return m8788invoke$lambda10;
                            }
                        });
                        Unit unit18 = Unit.INSTANCE;
                    }
                }
            }
            Context context3 = this.this$0.getContext();
            if (context3 != null) {
                int i5 = WhenMappings.$EnumSwitchMapping$2[loadResponse.getType().ordinal()];
                int i6 = R.string.movies_singular;
                switch (i5) {
                    case 1:
                        i6 = R.string.tv_series_singular;
                        break;
                    case 2:
                        i6 = R.string.anime_singular;
                        break;
                    case 3:
                        i6 = R.string.ova_singular;
                        break;
                    case 4:
                    case 7:
                        break;
                    case 5:
                        i6 = R.string.cartoons_singular;
                        break;
                    case 6:
                        i6 = R.string.documentaries_singular;
                        break;
                    case 8:
                        i6 = R.string.torrent_singular;
                        break;
                    case 9:
                        i6 = R.string.asian_drama_singular;
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                String string2 = context3.getString(i6);
                if (string2 != null) {
                    TextView textView10 = (TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_meta_type);
                    if (textView10 != null) {
                        textView10.setText(string2);
                    }
                    Unit unit19 = Unit.INSTANCE;
                    Unit unit20 = Unit.INSTANCE;
                }
            }
            String reviewUrl = loadResponse.getReviewUrl();
            if (reviewUrl != null) {
                ResultFragmentPhimHD resultFragmentPhimHD14 = this.this$0;
                WebView webReview = (WebView) resultFragmentPhimHD14._$_findCachedViewById(C4761R.C4764id.webReview);
                Intrinsics.checkNotNullExpressionValue(webReview, "webReview");
                resultFragmentPhimHD14.loadComments(webReview, reviewUrl);
                Unit unit21 = Unit.INSTANCE;
                Unit unit22 = Unit.INSTANCE;
            }
            if (z) {
                ((TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_title)).setText(loadResponse.getName());
            } else {
                ((TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_title)).setText(loadResponse.getName());
            }
        } else if (data instanceof Resource.Failure) {
            TextView textView11 = (TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_error_text);
            StringBuilder sb2 = new StringBuilder();
            String url = this.this$0.getUrl();
            sb2.append(url != null ? url + '\n' : null);
            sb2.append(((Resource.Failure) data).getErrorString());
            textView11.setText(sb2.toString());
            this.this$0.updateVisStatus(1);
        } else if (data instanceof Resource.Loading) {
            this.this$0.updateVisStatus(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m8786invoke$lambda0(LoadResponse d, ResultFragmentPhimHD this$0, View view) {
        Intrinsics.checkNotNullParameter(d, "$d");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(d.getUrl()));
        try {
            this$0.startActivity(intent);
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final void m8787invoke$lambda1(ResultFragmentPhimHD this$0, LoadResponse d, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(d, "$d");
        QuickSearchFragment.Companion.pushSearch$default(QuickSearchFragment.Companion, this$0.getActivity(), d.getName(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final void m8791invoke$lambda2(LoadResponse d, ResultFragmentPhimHD this$0, View view) {
        Intrinsics.checkNotNullParameter(d, "$d");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", d.getName());
            intent.putExtra("android.intent.extra.TEXT", d.getUrl());
            this$0.startActivity(Intent.createChooser(intent, d.getName()));
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-4  reason: not valid java name */
    public static final void m8792invoke$lambda4(ResultFragmentPhimHD this$0, String str, View view) {
        Object runBlocking$default;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Context context = this$0.getContext();
            if (context != null) {
                runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new ResultFragmentPhimHD$onViewCreated$29$4$1$1(context, str, null), 1, null);
                ImageView imageView = (ImageView) runBlocking$default;
            }
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-5  reason: not valid java name */
    public static final void m8793invoke$lambda5(ResultFragmentPhimHD this$0, LoadResponse d, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(d, "$d");
        new AlertDialog.Builder(this$0.requireContext()).setMessage(d.getPlot()).setTitle(d.getType() == TvType.Torrent ? R.string.torrent_plot : R.string.result_plot).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-7  reason: not valid java name */
    public static final void m8794invoke$lambda7(ResultFragmentPhimHD this$0, String apiName, MainAPI api, View view) {
        List list;
        ResultEpisode resultEpisode;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(apiName, "$apiName");
        Intrinsics.checkNotNullParameter(api, "$api");
        list = this$0.currentEpisodes;
        if (list == null || (resultEpisode = (ResultEpisode) CollectionsKt.firstOrNull((List<? extends Object>) list)) == null) {
            return;
        }
        ResultFragmentPhimHD.onViewCreated$handleAction(this$0, apiName, api, new EpisodeClickEvent(11, resultEpisode));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-8  reason: not valid java name */
    public static final boolean m8795invoke$lambda8(ResultFragmentPhimHD this$0, String apiName, MainAPI api, View view) {
        List list;
        ResultEpisode resultEpisode;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(apiName, "$apiName");
        Intrinsics.checkNotNullParameter(api, "$api");
        list = this$0.currentEpisodes;
        if (list != null && (resultEpisode = (ResultEpisode) CollectionsKt.firstOrNull((List<? extends Object>) list)) != null) {
            ResultFragmentPhimHD.onViewCreated$handleAction(this$0, apiName, api, new EpisodeClickEvent(10, resultEpisode));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-9  reason: not valid java name */
    public static final boolean m8796invoke$lambda9(ResultFragmentPhimHD this$0, String apiName, MainAPI api, View view) {
        List list;
        ResultEpisode resultEpisode;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(apiName, "$apiName");
        Intrinsics.checkNotNullParameter(api, "$api");
        list = this$0.currentEpisodes;
        if (list != null && (resultEpisode = (ResultEpisode) CollectionsKt.firstOrNull((List<? extends Object>) list)) != null) {
            ResultFragmentPhimHD.onViewCreated$handleAction(this$0, apiName, api, new EpisodeClickEvent(10, resultEpisode));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResultFragmentPhimHD.kt */
    @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "downloadClickEvent", "Lcom/lagradost/cloudstream3/ui/download/DownloadClickEvent;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD$onViewCreated$29$10 */
    /* loaded from: classes4.dex */
    public static final class C493310 extends Lambda implements Function1<DownloadClickEvent, Unit> {
        final /* synthetic */ MainAPI $api;
        final /* synthetic */ String $apiName;

        /* renamed from: $d */
        final /* synthetic */ LoadResponse f10019$d;
        final /* synthetic */ int $localId;
        final /* synthetic */ ResultFragmentPhimHD this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C493310(ResultFragmentPhimHD resultFragmentPhimHD, LoadResponse loadResponse, int i, String str, MainAPI mainAPI) {
            super(1);
            this.this$0 = resultFragmentPhimHD;
            this.f10019$d = loadResponse;
            this.$localId = i;
            this.$apiName = str;
            this.$api = mainAPI;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DownloadClickEvent downloadClickEvent) {
            invoke2(downloadClickEvent);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(DownloadClickEvent downloadClickEvent) {
            String str;
            List list;
            ResultEpisode resultEpisode;
            Intrinsics.checkNotNullParameter(downloadClickEvent, "downloadClickEvent");
            if (downloadClickEvent.getAction() != 4) {
                str = this.this$0.currentHeaderName;
                DownloadButtonSetup.INSTANCE.handleDownloadClick(this.this$0.getActivity(), str, downloadClickEvent);
                return;
            }
            AppController companion = AppController.Companion.getInstance();
            if ((companion != null ? companion.getKey() : null) != null) {
                AppController companion2 = AppController.Companion.getInstance();
                Key key = companion2 != null ? companion2.getKey() : null;
                Intrinsics.checkNotNull(key);
                if (!key.isExpired()) {
                    list = this.this$0.currentEpisodes;
                    if (list == null || (resultEpisode = (ResultEpisode) CollectionsKt.firstOrNull((List<? extends Object>) list)) == null) {
                        return;
                    }
                    LoadResponse loadResponse = this.f10019$d;
                    int i = this.$localId;
                    ResultFragmentPhimHD.onViewCreated$handleAction(this.this$0, this.$apiName, this.$api, new EpisodeClickEvent(6, new ResultEpisode(loadResponse.getName(), loadResponse.getName(), null, 0, null, resultEpisode.getData(), loadResponse.getApiName(), i, 0, 0L, 0L, null, null, null, loadResponse.getType(), i)));
                    return;
                }
                Log.d("DuongKK", "start Countdownads");
                FragmentActivity activity = this.this$0.getActivity();
                Objects.requireNonNull(activity, "null cannot be cast to non-null type com.lagradost.cloudstream3.MainActivity");
                ((MainActivity) activity).showDialogUpgrade();
                return;
            }
            FragmentActivity activity2 = this.this$0.getActivity();
            Objects.requireNonNull(activity2, "null cannot be cast to non-null type com.lagradost.cloudstream3.MainActivity");
            ((MainActivity) activity2).showDialogUpgrade();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-10  reason: not valid java name */
    public static final boolean m8788invoke$lambda10(ResultFragmentPhimHD this$0, String apiName, MainAPI api, View view) {
        List list;
        ResultEpisode resultEpisode;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(apiName, "$apiName");
        Intrinsics.checkNotNullParameter(api, "$api");
        list = this$0.currentEpisodes;
        if (list == null || (resultEpisode = (ResultEpisode) CollectionsKt.firstOrNull((List<? extends Object>) list)) == null) {
            return false;
        }
        ResultFragmentPhimHD.onViewCreated$handleAction(this$0, apiName, api, new EpisodeClickEvent(7, resultEpisode));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-11  reason: not valid java name */
    public static final void m8789invoke$lambda11(ResultFragmentPhimHD this$0, String apiName, MainAPI api, View view) {
        List list;
        ResultEpisode resultEpisode;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(apiName, "$apiName");
        Intrinsics.checkNotNullParameter(api, "$api");
        list = this$0.currentEpisodes;
        if (list == null || (resultEpisode = (ResultEpisode) CollectionsKt.firstOrNull((List<? extends Object>) list)) == null) {
            return;
        }
        ResultFragmentPhimHD.onViewCreated$handleAction(this$0, apiName, api, new EpisodeClickEvent(11, resultEpisode));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-12  reason: not valid java name */
    public static final boolean m8790invoke$lambda12(ResultFragmentPhimHD this$0, String apiName, MainAPI api, View view) {
        List list;
        ResultEpisode resultEpisode;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(apiName, "$apiName");
        Intrinsics.checkNotNullParameter(api, "$api");
        list = this$0.currentEpisodes;
        if (list != null && (resultEpisode = (ResultEpisode) CollectionsKt.firstOrNull((List<? extends Object>) list)) != null) {
            ResultFragmentPhimHD.onViewCreated$handleAction(this$0, apiName, api, new EpisodeClickEvent(10, resultEpisode));
        }
        return true;
    }
}
