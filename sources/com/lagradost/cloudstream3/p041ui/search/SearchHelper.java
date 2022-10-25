package com.lagradost.cloudstream3.p041ui.search;

import android.app.Activity;
import com.bongngotv2.R;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.p041ui.download.DownloadButtonSetup;
import com.lagradost.cloudstream3.p041ui.download.DownloadClickEvent;
import com.lagradost.cloudstream3.p041ui.player.GeneratorPlayer;
import com.lagradost.cloudstream3.p041ui.player.SponsorFileGenerator;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.DataStoreHelper;
import com.lagradost.cloudstream3.utils.UIHelper;
import com.lagradost.cloudstream3.utils.VideoDownloadHelper;
import com.phimhd.ConfigHomeKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SearchHelper.kt */
@Metadata(m108d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/search/SearchHelper;", "", "()V", "handleSearchClickCallback", "", "activity", "Landroid/app/Activity;", "callback", "Lcom/lagradost/cloudstream3/ui/search/SearchClickCallback;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.search.SearchHelper */
/* loaded from: classes4.dex */
public final class SearchHelper {
    public static final SearchHelper INSTANCE = new SearchHelper();

    private SearchHelper() {
    }

    public final void handleSearchClickCallback(Activity activity, SearchClickCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SearchResponse card = callback.getCard();
        int action = callback.getAction();
        if (action == 0) {
            AppUtils.loadSearchResult$default(AppUtils.INSTANCE, activity, card, 0, null, 6, null);
        } else if (action == 1) {
            CommonActivity.INSTANCE.showToast(activity, callback.getCard().getName(), (Integer) 0);
        } else {
            if (action != 2) {
                if (action != 998) {
                    if (action == 999 && activity != null) {
                        UIHelper.INSTANCE.navigate(activity, R.id.global_to_navigation_player, GeneratorPlayer.Companion.newInstance$default(GeneratorPlayer.Companion, new SponsorFileGenerator(CollectionsKt.listOf(card.getUrl()), card.getName(), ConfigHomeKt.SPONSOR_API_NAME), null, 2, null));
                    }
                } else if (activity != null) {
                    UIHelper.INSTANCE.navigate(activity, R.id.global_to_navigation_player, GeneratorPlayer.Companion.newInstance$default(GeneratorPlayer.Companion, new SponsorFileGenerator(CollectionsKt.listOf(card.getUrl()), card.getName(), ConfigHomeKt.IPTV_API_NAME), null, 2, null));
                }
            } else if (card instanceof DataStoreHelper.ResumeWatchingResult) {
                Integer id = card.getId();
                if (id == null) {
                    CommonActivity.INSTANCE.showToast(activity, R.string.error_invalid_id, 0);
                } else {
                    DataStoreHelper.ResumeWatchingResult resumeWatchingResult = (DataStoreHelper.ResumeWatchingResult) card;
                    if (resumeWatchingResult.isFromDownload()) {
                        DownloadButtonSetup downloadButtonSetup = DownloadButtonSetup.INSTANCE;
                        String name = card.getName();
                        String name2 = card.getName();
                        String posterUrl = card.getPosterUrl();
                        Integer episode = resumeWatchingResult.getEpisode();
                        int intValue = episode != null ? episode.intValue() : 0;
                        Integer season = resumeWatchingResult.getSeason();
                        int intValue2 = id.intValue();
                        Integer parentId = resumeWatchingResult.getParentId();
                        if (parentId == null) {
                            return;
                        }
                        downloadButtonSetup.handleDownloadClick(activity, name, new DownloadClickEvent(0, new VideoDownloadHelper.DownloadEpisodeCached(name2, posterUrl, intValue, season, intValue2, parentId.intValue(), null, null, System.currentTimeMillis())));
                    } else {
                        AppUtils.INSTANCE.loadSearchResult(activity, card, 2, id);
                    }
                }
            } else {
                handleSearchClickCallback(activity, new SearchClickCallback(0, callback.getView(), -1, callback.getCard()));
            }
        }
    }
}
