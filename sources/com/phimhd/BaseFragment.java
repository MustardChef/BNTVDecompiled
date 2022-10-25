package com.phimhd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bongngotv2.R;
import com.google.android.material.button.MaterialButton;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.DubStatus;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.MainActivity;
import com.lagradost.cloudstream3.Page;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.p041ui.browser.ICallback;
import com.lagradost.cloudstream3.p041ui.home.HomeFragment;
import com.lagradost.cloudstream3.p041ui.home.PageBottomSheet;
import com.lagradost.cloudstream3.p041ui.livetv.LiveTvSportFragment;
import com.lagradost.cloudstream3.p041ui.quicksearch.QuickSearchFragment;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* compiled from: BaseFragment.kt */
@Metadata(m108d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\b\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\fH\u0002J\f\u0010\u001a\u001a\u00020\f*\u00020\u001bH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m107d2 = {"Lcom/phimhd/BaseFragment;", "Landroidx/fragment/app/Fragment;", "()V", "iCallbackDialogFilter", "Lcom/phimhd/ICallbackDialogFilter;", "getICallbackDialogFilter", "()Lcom/phimhd/ICallbackDialogFilter;", "setICallbackDialogFilter", "(Lcom/phimhd/ICallbackDialogFilter;)V", "receiver", "Landroid/content/BroadcastReceiver;", "onAttach", "", "context", "Landroid/content/Context;", "onDetach", "onPause", "onResume", "setUpActionHeaderMovieHomeScreen", "random", "Lcom/lagradost/cloudstream3/SearchResponse;", "setUpPageHomeScreen", "d", "Lcom/lagradost/cloudstream3/HomePageResponse;", "updateKeyToUI", "upgradeBtnClick", "setUpHomeScreenWithPhimHD", "Lcom/lagradost/cloudstream3/ui/home/HomeFragment;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public class BaseFragment extends Fragment {
    private ICallbackDialogFilter iCallbackDialogFilter;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final BroadcastReceiver receiver = new BroadcastReceiver() { // from class: com.phimhd.BaseFragment$receiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            BaseFragment.this.updateKeyToUI();
        }
    };

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

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final ICallbackDialogFilter getICallbackDialogFilter() {
        return this.iCallbackDialogFilter;
    }

    public final void setICallbackDialogFilter(ICallbackDialogFilter iCallbackDialogFilter) {
        this.iCallbackDialogFilter = iCallbackDialogFilter;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setUpHomeScreenWithPhimHD(final com.lagradost.cloudstream3.p041ui.home.HomeFragment r9) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phimhd.BaseFragment.setUpHomeScreenWithPhimHD(com.lagradost.cloudstream3.ui.home.HomeFragment):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setUpHomeScreenWithPhimHD$lambda-2$lambda-1$lambda-0  reason: not valid java name */
    public static final void m9047setUpHomeScreenWithPhimHD$lambda2$lambda1$lambda0(HomeFragment this_setUpHomeScreenWithPhimHD, View view) {
        Config config;
        Intrinsics.checkNotNullParameter(this_setUpHomeScreenWithPhimHD, "$this_setUpHomeScreenWithPhimHD");
        AppController companion = AppController.Companion.getInstance();
        String str = (companion == null || (config = companion.getConfig()) == null) ? null : config.urlRedirectPoster;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this_setUpHomeScreenWithPhimHD.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setUpHomeScreenWithPhimHD$lambda-6$lambda-5  reason: not valid java name */
    public static final void m9048setUpHomeScreenWithPhimHD$lambda6$lambda5(HomeFragment this_setUpHomeScreenWithPhimHD, View view) {
        Intrinsics.checkNotNullParameter(this_setUpHomeScreenWithPhimHD, "$this_setUpHomeScreenWithPhimHD");
        QuickSearchFragment.Companion companion = QuickSearchFragment.Companion;
        FragmentActivity activity = this_setUpHomeScreenWithPhimHD.getActivity();
        String currentApiName = this_setUpHomeScreenWithPhimHD.getCurrentApiName();
        companion.pushSearch(activity, "", currentApiName != null ? new String[]{currentApiName} : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setUpHomeScreenWithPhimHD$lambda-7  reason: not valid java name */
    public static final void m9049setUpHomeScreenWithPhimHD$lambda7(HomeFragment this_setUpHomeScreenWithPhimHD, View view) {
        Intrinsics.checkNotNullParameter(this_setUpHomeScreenWithPhimHD, "$this_setUpHomeScreenWithPhimHD");
        LiveTvSportFragment.Companion.pushSearch(this_setUpHomeScreenWithPhimHD.getActivity());
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setUpPageHomeScreen(final com.lagradost.cloudstream3.HomePageResponse r6) {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
            if (r6 == 0) goto L2d
            java.util.List r2 = r6.getListGenre()
            if (r2 == 0) goto L2d
            int r3 = com.lagradost.cloudstream3.C4761R.C4764id.tvGenre
            android.view.View r3 = r5._$_findCachedViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            if (r3 != 0) goto L15
            goto L18
        L15:
            r3.setVisibility(r0)
        L18:
            int r3 = com.lagradost.cloudstream3.C4761R.C4764id.tvGenre
            android.view.View r3 = r5._$_findCachedViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            if (r3 == 0) goto L2d
            com.phimhd.-$$Lambda$BaseFragment$YrxBw0LjNUhVQEpEuNcIPPzMKXM r4 = new com.phimhd.-$$Lambda$BaseFragment$YrxBw0LjNUhVQEpEuNcIPPzMKXM
            r4.<init>()
            r3.setOnClickListener(r4)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            goto L2e
        L2d:
            r2 = r1
        L2e:
            r3 = 8
            if (r2 != 0) goto L40
            int r2 = com.lagradost.cloudstream3.C4761R.C4764id.tvGenre
            android.view.View r2 = r5._$_findCachedViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 != 0) goto L3d
            goto L40
        L3d:
            r2.setVisibility(r3)
        L40:
            if (r6 == 0) goto L6b
            java.util.List r2 = r6.getListCountry()
            if (r2 == 0) goto L6b
            int r4 = com.lagradost.cloudstream3.C4761R.C4764id.tvCountry
            android.view.View r4 = r5._$_findCachedViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 != 0) goto L53
            goto L56
        L53:
            r4.setVisibility(r0)
        L56:
            int r0 = com.lagradost.cloudstream3.C4761R.C4764id.tvCountry
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L6b
            com.phimhd.-$$Lambda$BaseFragment$YoDMbsfYho0IuweaxSpOsFisF44 r1 = new com.phimhd.-$$Lambda$BaseFragment$YoDMbsfYho0IuweaxSpOsFisF44
            r1.<init>()
            r0.setOnClickListener(r1)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r1 = r6
        L6b:
            if (r1 != 0) goto L7b
            int r6 = com.lagradost.cloudstream3.C4761R.C4764id.tvCountry
            android.view.View r6 = r5._$_findCachedViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 != 0) goto L78
            goto L7b
        L78:
            r6.setVisibility(r3)
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phimhd.BaseFragment.setUpPageHomeScreen(com.lagradost.cloudstream3.HomePageResponse):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setUpPageHomeScreen$lambda-10$lambda-9  reason: not valid java name */
    public static final void m9050setUpPageHomeScreen$lambda10$lambda9(final BaseFragment this$0, List list, final HomePageResponse homePageResponse, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(list, "$list");
        ICallbackDialogFilter iCallbackDialogFilter = this$0.iCallbackDialogFilter;
        if (iCallbackDialogFilter != null) {
            iCallbackDialogFilter.showDialogFilter(list, new ICallback() { // from class: com.phimhd.-$$Lambda$BaseFragment$_u0lx04CZcSHuGRlmpuJz-jLxaw
                @Override // com.lagradost.cloudstream3.p041ui.browser.ICallback
                public final void onCallback(Object obj) {
                    BaseFragment.m9051setUpPageHomeScreen$lambda10$lambda9$lambda8(BaseFragment.this, homePageResponse, (Page) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setUpPageHomeScreen$lambda-10$lambda-9$lambda-8  reason: not valid java name */
    public static final void m9051setUpPageHomeScreen$lambda10$lambda9$lambda8(BaseFragment this$0, HomePageResponse homePageResponse, Page page) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.d("Blue", "Page " + page.getName() + ' ' + page.getUrl());
        TextView textView = (TextView) this$0._$_findCachedViewById(C4761R.C4764id.tvGenre);
        if (textView != null) {
            textView.setText(page.getName());
        }
        TextView textView2 = (TextView) this$0._$_findCachedViewById(C4761R.C4764id.tvCountry);
        if (textView2 != null) {
            String titleMenuCountry = homePageResponse.getTitleMenuCountry();
            if (titleMenuCountry == null) {
                titleMenuCountry = this$0.getString(R.string.menu_country);
            }
            textView2.setText(titleMenuCountry);
        }
        PageBottomSheet.Companion.newInstance(page.getUrl(), page.getName(), page.getNameApi()).show(this$0.getChildFragmentManager(), "page");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setUpPageHomeScreen$lambda-14$lambda-13  reason: not valid java name */
    public static final void m9052setUpPageHomeScreen$lambda14$lambda13(final BaseFragment this$0, List list, final HomePageResponse homePageResponse, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(list, "$list");
        ICallbackDialogFilter iCallbackDialogFilter = this$0.iCallbackDialogFilter;
        if (iCallbackDialogFilter != null) {
            iCallbackDialogFilter.showDialogFilter(list, new ICallback() { // from class: com.phimhd.-$$Lambda$BaseFragment$A5m9GptVcSxxms8h0c6kslkkLE8
                @Override // com.lagradost.cloudstream3.p041ui.browser.ICallback
                public final void onCallback(Object obj) {
                    BaseFragment.m9053setUpPageHomeScreen$lambda14$lambda13$lambda12(BaseFragment.this, homePageResponse, (Page) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setUpPageHomeScreen$lambda-14$lambda-13$lambda-12  reason: not valid java name */
    public static final void m9053setUpPageHomeScreen$lambda14$lambda13$lambda12(BaseFragment this$0, HomePageResponse homePageResponse, Page page) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.d("Blue", "Page " + page.getName() + ' ' + page.getUrl());
        TextView textView = (TextView) this$0._$_findCachedViewById(C4761R.C4764id.tvGenre);
        if (textView != null) {
            String titleMenuGenres = homePageResponse.getTitleMenuGenres();
            if (titleMenuGenres == null) {
                titleMenuGenres = this$0.getString(R.string.menu_genre);
            }
            textView.setText(titleMenuGenres);
        }
        TextView textView2 = (TextView) this$0._$_findCachedViewById(C4761R.C4764id.tvCountry);
        if (textView2 != null) {
            textView2.setText(page.getName());
        }
        PageBottomSheet.Companion.newInstance(page.getUrl(), page.getName(), page.getNameApi()).show(this$0.getChildFragmentManager(), "page");
    }

    public final void setUpActionHeaderMovieHomeScreen(final SearchResponse random) {
        String str;
        List<Banner> listBannerHome;
        Intrinsics.checkNotNullParameter(random, "random");
        AppController companion = AppController.Companion.getInstance();
        boolean z = true;
        if (companion != null && (listBannerHome = companion.getListBannerHome()) != null) {
            List<Banner> list = listBannerHome;
            if (!list.isEmpty()) {
                final Banner banner = (Banner) CollectionsKt.random(list, Random.Default);
                MaterialButton materialButton = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.home_main_play);
                if (materialButton != null) {
                    materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.phimhd.-$$Lambda$BaseFragment$VhrLiiAOlqxvMspquIWEPCWf9oM
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            BaseFragment.m9041setUpActionHeaderMovieHomeScreen$lambda19$lambda16(BaseFragment.this, banner, view);
                        }
                    });
                }
                MaterialButton materialButton2 = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.home_main_info);
                if (materialButton2 != null) {
                    materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.phimhd.-$$Lambda$BaseFragment$9R7QrvYCAvNrn8mAWRGqy-tHWk8
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            BaseFragment.m9042setUpActionHeaderMovieHomeScreen$lambda19$lambda17(BaseFragment.this, banner, view);
                        }
                    });
                }
                MaterialButton materialButton3 = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.home_main_save);
                if (materialButton3 != null) {
                    materialButton3.setOnClickListener(new View.OnClickListener() { // from class: com.phimhd.-$$Lambda$BaseFragment$oHUf2RHOfOSuiyniTLgC5fgl0lQ
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            BaseFragment.m9043setUpActionHeaderMovieHomeScreen$lambda19$lambda18(BaseFragment.this, banner, view);
                        }
                    });
                }
                ImageView imageView = (ImageView) _$_findCachedViewById(C4761R.C4764id.posterBlurHeader);
                if (imageView != null) {
                    UIHelper.setImage$default(UIHelper.INSTANCE, imageView, banner.getUrlPhoto(), null, null, 6, null);
                }
                ImageView imageView2 = (ImageView) _$_findCachedViewById(C4761R.C4764id.home_main_poster);
                if (imageView2 != null) {
                    UIHelper.setImage$default(UIHelper.INSTANCE, imageView2, banner.getLogo(), null, null, 6, null);
                }
                ImageView imageView3 = (ImageView) _$_findCachedViewById(C4761R.C4764id.home_main_poster);
                if (imageView3 != null) {
                    imageView3.setScaleType(ImageView.ScaleType.FIT_END);
                }
                TextView textView = (TextView) _$_findCachedViewById(C4761R.C4764id.home_main_text);
                if (textView == null) {
                    return;
                }
                textView.setText(banner.getTitle());
                return;
            }
        }
        MaterialButton materialButton4 = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.home_main_play);
        if (materialButton4 != null) {
            materialButton4.setOnClickListener(new View.OnClickListener() { // from class: com.phimhd.-$$Lambda$BaseFragment$XUagghToWrU0va6Qut3mochxCXA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseFragment.m9044setUpActionHeaderMovieHomeScreen$lambda20(BaseFragment.this, random, view);
                }
            });
        }
        MaterialButton materialButton5 = (MaterialButton) _$_findCachedViewById(C4761R.C4764id.home_main_info);
        if (materialButton5 != null) {
            materialButton5.setOnClickListener(new View.OnClickListener() { // from class: com.phimhd.-$$Lambda$BaseFragment$83Uszjxf1Fb2WUfQrZLNVKav1ZY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseFragment.m9045setUpActionHeaderMovieHomeScreen$lambda21(BaseFragment.this, random, view);
                }
            });
        }
        ((MaterialButton) _$_findCachedViewById(C4761R.C4764id.home_main_save)).setOnClickListener(new View.OnClickListener() { // from class: com.phimhd.-$$Lambda$BaseFragment$fX8tPky3NGF-phGXk5GjHzUy1Zg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseFragment.m9046setUpActionHeaderMovieHomeScreen$lambda22(BaseFragment.this, random, view);
            }
        });
        TextView textView2 = (TextView) _$_findCachedViewById(C4761R.C4764id.home_main_text);
        if (textView2 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(random.getName());
            if (random instanceof AnimeSearchResponse) {
                AnimeSearchResponse animeSearchResponse = (AnimeSearchResponse) random;
                EnumSet<DubStatus> dubStatus = animeSearchResponse.getDubStatus();
                if (dubStatus != null && !dubStatus.isEmpty()) {
                    z = false;
                }
                if (!z) {
                    EnumSet<DubStatus> dubStatus2 = animeSearchResponse.getDubStatus();
                    str = dubStatus2 != null ? CollectionsKt.joinToString$default(dubStatus2, " | ", " • ", null, 0, null, BaseFragment$setUpActionHeaderMovieHomeScreen$5.INSTANCE, 28, null) : null;
                    sb.append(str);
                    textView2.setText(sb.toString());
                }
            }
            str = "";
            sb.append(str);
            textView2.setText(sb.toString());
        }
        ImageView imageView4 = (ImageView) _$_findCachedViewById(C4761R.C4764id.home_main_poster);
        if (imageView4 != null) {
            UIHelper.setImage$default(UIHelper.INSTANCE, imageView4, random.getPosterUrl(), null, null, 6, null);
        }
        ImageView imageView5 = (ImageView) _$_findCachedViewById(C4761R.C4764id.posterBlurHeader);
        if (imageView5 != null) {
            UIHelper.INSTANCE.setImageBlur(imageView5, random.getPosterUrl(), 50, 10, random.getPosterHeaders());
        }
        ImageView imageView6 = (ImageView) _$_findCachedViewById(C4761R.C4764id.home_main_poster);
        if (imageView6 == null) {
            return;
        }
        imageView6.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setUpActionHeaderMovieHomeScreen$lambda-19$lambda-16  reason: not valid java name */
    public static final void m9041setUpActionHeaderMovieHomeScreen$lambda19$lambda16(BaseFragment this$0, Banner randomItem, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(randomItem, "$randomItem");
        AppUtils.loadSearchResult$default(AppUtils.INSTANCE, this$0.getActivity(), ConfigHomeKt.toSearchResponse(randomItem), 1, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setUpActionHeaderMovieHomeScreen$lambda-19$lambda-17  reason: not valid java name */
    public static final void m9042setUpActionHeaderMovieHomeScreen$lambda19$lambda17(BaseFragment this$0, Banner randomItem, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(randomItem, "$randomItem");
        AppUtils.loadSearchResult$default(AppUtils.INSTANCE, this$0.getActivity(), ConfigHomeKt.toSearchResponse(randomItem), 0, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setUpActionHeaderMovieHomeScreen$lambda-19$lambda-18  reason: not valid java name */
    public static final void m9043setUpActionHeaderMovieHomeScreen$lambda19$lambda18(BaseFragment this$0, Banner randomItem, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(randomItem, "$randomItem");
        AppUtils.loadSearchResult$default(AppUtils.INSTANCE, this$0.getActivity(), ConfigHomeKt.toSearchResponse(randomItem), 9, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setUpActionHeaderMovieHomeScreen$lambda-20  reason: not valid java name */
    public static final void m9044setUpActionHeaderMovieHomeScreen$lambda20(BaseFragment this$0, SearchResponse random, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(random, "$random");
        AppUtils.loadSearchResult$default(AppUtils.INSTANCE, this$0.getActivity(), random, 1, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setUpActionHeaderMovieHomeScreen$lambda-21  reason: not valid java name */
    public static final void m9045setUpActionHeaderMovieHomeScreen$lambda21(BaseFragment this$0, SearchResponse random, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(random, "$random");
        AppUtils.loadSearchResult$default(AppUtils.INSTANCE, this$0.getActivity(), random, 0, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setUpActionHeaderMovieHomeScreen$lambda-22  reason: not valid java name */
    public static final void m9046setUpActionHeaderMovieHomeScreen$lambda22(BaseFragment this$0, SearchResponse random, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(random, "$random");
        AppUtils.loadSearchResult$default(AppUtils.INSTANCE, this$0.getActivity(), random, 9, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void updateKeyToUI() {
        /*
            r4 = this;
            com.phimhd.AppController$Companion r0 = com.phimhd.AppController.Companion
            com.phimhd.AppController r0 = r0.getInstance()
            r1 = 0
            if (r0 == 0) goto Le
            com.phimhd.Key r0 = r0.getKey()
            goto Lf
        Le:
            r0 = r1
        Lf:
            r2 = 8
            r3 = 0
            if (r0 == 0) goto L56
            com.phimhd.AppController$Companion r0 = com.phimhd.AppController.Companion
            com.phimhd.AppController r0 = r0.getInstance()
            if (r0 == 0) goto L20
            com.phimhd.Key r1 = r0.getKey()
        L20:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            boolean r0 = r1.isExpired()
            if (r0 != 0) goto L56
            int r0 = com.lagradost.cloudstream3.C4761R.C4764id.home_key
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L39
            r1 = 2131231546(0x7f08033a, float:1.8079176E38)
            r0.setImageResource(r1)
        L39:
            int r0 = com.lagradost.cloudstream3.C4761R.C4764id.home_key_btn
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 != 0) goto L44
            goto L47
        L44:
            r0.setVisibility(r2)
        L47:
            int r0 = com.lagradost.cloudstream3.C4761R.C4764id.home_key
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 != 0) goto L52
            goto L82
        L52:
            r0.setVisibility(r3)
            goto L82
        L56:
            int r0 = com.lagradost.cloudstream3.C4761R.C4764id.home_key_btn
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 != 0) goto L61
            goto L64
        L61:
            r0.setVisibility(r3)
        L64:
            int r0 = com.lagradost.cloudstream3.C4761R.C4764id.home_key
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 != 0) goto L6f
            goto L72
        L6f:
            r0.setVisibility(r2)
        L72:
            int r0 = com.lagradost.cloudstream3.C4761R.C4764id.home_key
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L82
            r1 = 2131231268(0x7f080224, float:1.8078612E38)
            r0.setImageResource(r1)
        L82:
            int r0 = com.lagradost.cloudstream3.C4761R.C4764id.home_key
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L94
            com.phimhd.-$$Lambda$BaseFragment$B51c4yNNIL0NZKKCxOLLA42R0oU r1 = new com.phimhd.-$$Lambda$BaseFragment$B51c4yNNIL0NZKKCxOLLA42R0oU
            r1.<init>()
            r0.setOnClickListener(r1)
        L94:
            int r0 = com.lagradost.cloudstream3.C4761R.C4764id.home_key_btn
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto La6
            com.phimhd.-$$Lambda$BaseFragment$pRoaGOzZgORtacq5a1BuRHNmu84 r1 = new com.phimhd.-$$Lambda$BaseFragment$pRoaGOzZgORtacq5a1BuRHNmu84
            r1.<init>()
            r0.setOnClickListener(r1)
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phimhd.BaseFragment.updateKeyToUI():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateKeyToUI$lambda-23  reason: not valid java name */
    public static final void m9054updateKeyToUI$lambda23(BaseFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.upgradeBtnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateKeyToUI$lambda-24  reason: not valid java name */
    public static final void m9055updateKeyToUI$lambda24(BaseFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.upgradeBtnClick();
    }

    private final void upgradeBtnClick() {
        AppController companion = AppController.Companion.getInstance();
        if ((companion != null ? companion.getKey() : null) != null) {
            AppController companion2 = AppController.Companion.getInstance();
            Key key = companion2 != null ? companion2.getKey() : null;
            Intrinsics.checkNotNull(key);
            if (!key.isExpired()) {
                ((ImageView) _$_findCachedViewById(C4761R.C4764id.home_key)).setImageResource(R.drawable.ic_vip);
                FragmentActivity activity = getActivity();
                Objects.requireNonNull(activity, "null cannot be cast to non-null type com.lagradost.cloudstream3.MainActivity");
                ((MainActivity) activity).showDialogKeyUpgrade();
                TextView textView = (TextView) _$_findCachedViewById(C4761R.C4764id.home_key_btn);
                if (textView == null) {
                    return;
                }
                textView.setVisibility(8);
                return;
            }
        }
        ((ImageView) _$_findCachedViewById(C4761R.C4764id.home_key)).setImageResource(R.drawable.ic_ad_block__1_);
        TextView textView2 = (TextView) _$_findCachedViewById(C4761R.C4764id.home_key_btn);
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        ImageView imageView = (ImageView) _$_findCachedViewById(C4761R.C4764id.home_key);
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        FragmentActivity activity2 = getActivity();
        Objects.requireNonNull(activity2, "null cannot be cast to non-null type com.lagradost.cloudstream3.MainActivity");
        ((MainActivity) activity2).showDialogUpgrade();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.iCallbackDialogFilter = (ICallbackDialogFilter) context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.iCallbackDialogFilter = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter(Constants.INTENT_UPDATE_KEY);
        Context context = getContext();
        if (context != null) {
            LocalBroadcastManager.getInstance(context).registerReceiver(this.receiver, intentFilter);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Context context = getContext();
        if (context != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this.receiver);
        }
        super.onPause();
    }
}
