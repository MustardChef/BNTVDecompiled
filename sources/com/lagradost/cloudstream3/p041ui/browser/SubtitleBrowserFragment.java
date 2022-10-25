package com.lagradost.cloudstream3.p041ui.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Insets;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowMetrics;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.blankj.utilcode.util.KeyboardUtils;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.p041ui.player.PlayerGeneratorViewModel;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* compiled from: SubtitleBrowserFragment.kt */
@Metadata(m108d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\u001a\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0015\u0010\f\u001a\u00020\r*\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006!"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/browser/SubtitleBrowserFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "elementDownloadLink", "Lorg/jsoup/nodes/Element;", "iCallback", "Lcom/lagradost/cloudstream3/ui/browser/ICallback;", "", "shareViewModel", "Lcom/lagradost/cloudstream3/ui/player/PlayerGeneratorViewModel;", "viewModel", "Lcom/lagradost/cloudstream3/ui/browser/SubtitleBrowserViewModel;", "windowHeight", "", "Landroidx/fragment/app/Fragment;", "getWindowHeight", "(Landroidx/fragment/app/Fragment;)I", "downloadSub", "", "getUrlDownload", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "parseHtmlAndDownload", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.browser.SubtitleBrowserFragment */
/* loaded from: classes.dex */
public final class SubtitleBrowserFragment extends BottomSheetDialogFragment {
    private Element elementDownloadLink;
    private PlayerGeneratorViewModel shareViewModel;
    private SubtitleBrowserViewModel viewModel;
    public static final Companion Companion = new Companion(null);
    private static final HashMap<String, String> pairDomainWithQueryJsoup = new HashMap<>();
    public static final String DOMAIN_SUBSCENE = "https://subscene.com";
    public static final String DOMAIN_PHUDEVIET = "http://phudeviet.org";
    public static final String DOMAIN_YTS = "https://yts-subs.com";
    public static final String DOMAIN_OPENSUBTITLE = "https://www.opensubtitles.org";
    private static final ArrayList<String> listDomain = CollectionsKt.arrayListOf(DOMAIN_SUBSCENE, DOMAIN_PHUDEVIET, DOMAIN_YTS, DOMAIN_OPENSUBTITLE);
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final ICallback<String> iCallback = new ICallback() { // from class: com.lagradost.cloudstream3.ui.browser.-$$Lambda$SubtitleBrowserFragment$BmqrtJEKJUxpZXqEUs_Hhh2aURI
        @Override // com.lagradost.cloudstream3.p041ui.browser.ICallback
        public final void onCallback(Object obj) {
            SubtitleBrowserFragment.m8615iCallback$lambda1(SubtitleBrowserFragment.this, (String) obj);
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

    /* compiled from: SubtitleBrowserFragment.kt */
    @Metadata(m108d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\tj\b\u0012\u0004\u0012\u00020\u0004`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR-\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000ej\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/browser/SubtitleBrowserFragment$Companion;", "", "()V", "DOMAIN_OPENSUBTITLE", "", "DOMAIN_PHUDEVIET", "DOMAIN_SUBSCENE", "DOMAIN_YTS", "listDomain", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getListDomain", "()Ljava/util/ArrayList;", "pairDomainWithQueryJsoup", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getPairDomainWithQueryJsoup", "()Ljava/util/HashMap;", "newInstance", "Lcom/lagradost/cloudstream3/ui/browser/SubtitleBrowserFragment;", "nameMovie", "pushSearch", "", "activity", "Landroid/app/Activity;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.browser.SubtitleBrowserFragment$Companion */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void pushSearch(Activity activity) {
            UIHelper uIHelper = UIHelper.INSTANCE;
            Bundle bundle = new Bundle();
            Unit unit = Unit.INSTANCE;
            uIHelper.navigate(activity, R.id.global_to_navigation_subtitle_browser, bundle);
        }

        public static /* synthetic */ SubtitleBrowserFragment newInstance$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.newInstance(str);
        }

        public final SubtitleBrowserFragment newInstance(String str) {
            Bundle bundle = new Bundle();
            if (str != null) {
                bundle.putString("nameMovie", str);
            }
            SubtitleBrowserFragment subtitleBrowserFragment = new SubtitleBrowserFragment();
            subtitleBrowserFragment.setArguments(bundle);
            return subtitleBrowserFragment;
        }

        public final HashMap<String, String> getPairDomainWithQueryJsoup() {
            return SubtitleBrowserFragment.pairDomainWithQueryJsoup;
        }

        public final ArrayList<String> getListDomain() {
            return SubtitleBrowserFragment.listDomain;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: iCallback$lambda-1  reason: not valid java name */
    public static final void m8615iCallback$lambda1(SubtitleBrowserFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Document parse = Jsoup.parse(str);
        Object selectedItem = ((Spinner) this$0._$_findCachedViewById(C4761R.C4764id.spinner)).getSelectedItem();
        Objects.requireNonNull(selectedItem, "null cannot be cast to non-null type kotlin.String");
        String str2 = pairDomainWithQueryJsoup.get((String) selectedItem);
        if (str2 == null) {
            str2 = "downloadButton";
        } else {
            Intrinsics.checkNotNullExpressionValue(str2, "pairDomainWithQueryJsoup[it]?:selectionQueryHtml");
        }
        Element selectFirst = parse.body().selectFirst(str2);
        if (selectFirst == null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new SubtitleBrowserFragment$iCallback$1$3(this$0, null), 3, null);
            return;
        }
        Log.d("DuongKK", "element " + selectFirst.attr(ShareConstants.WEB_DIALOG_PARAM_HREF));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new SubtitleBrowserFragment$iCallback$1$2(this$0, null), 3, null);
        this$0.elementDownloadLink = selectFirst;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_subtitle_browser, viewGroup, false);
    }

    public final int getWindowHeight(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        if (Build.VERSION.SDK_INT >= 30) {
            WindowMetrics currentWindowMetrics = fragment.requireActivity().getWindowManager().getCurrentWindowMetrics();
            Intrinsics.checkNotNullExpressionValue(currentWindowMetrics, "requireActivity().window…ager.currentWindowMetrics");
            Insets insets = currentWindowMetrics.getWindowInsets().getInsets(WindowInsets.Type.systemBars());
            Intrinsics.checkNotNullExpressionValue(insets, "metrics.windowInsets.get…Insets.Type.systemBars())");
            return (currentWindowMetrics.getBounds().height() - insets.top) - insets.bottom;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        fragment.requireActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ViewGroup.LayoutParams layoutParams = ((ConstraintLayout) _$_findCachedViewById(C4761R.C4764id.layoutRoot)).getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "layoutRoot.layoutParams");
        layoutParams.height = getWindowHeight(this);
        ((ConstraintLayout) _$_findCachedViewById(C4761R.C4764id.layoutRoot)).setLayoutParams(layoutParams);
        ViewParent parent = view.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.View");
        final BottomSheetBehavior from = BottomSheetBehavior.from((View) parent);
        Intrinsics.checkNotNullExpressionValue(from, "from(view.parent as View)");
        from.setHideable(false);
        from.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: com.lagradost.cloudstream3.ui.browser.SubtitleBrowserFragment$onViewCreated$1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(View bottomSheet, int i) {
                Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(View bottomSheet, float f) {
                Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                from.setState(3);
            }
        });
        HashMap<String, String> hashMap = pairDomainWithQueryJsoup;
        hashMap.put(DOMAIN_SUBSCENE, "#downloadButton");
        hashMap.put(DOMAIN_PHUDEVIET, ".info > a");
        hashMap.put(DOMAIN_YTS, ".btn-icon");
        hashMap.put(DOMAIN_OPENSUBTITLE, "#bt-dwl-bt");
        Context context = getContext();
        if (context != null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367049, listDomain);
            arrayAdapter.setDropDownViewResource(17367049);
            ((Spinner) _$_findCachedViewById(C4761R.C4764id.spinner)).setAdapter((SpinnerAdapter) arrayAdapter);
        }
        Spinner spinner = (Spinner) _$_findCachedViewById(C4761R.C4764id.spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.lagradost.cloudstream3.ui.browser.SubtitleBrowserFragment$onViewCreated$3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view2, int i, long j) {
                    String str = SubtitleBrowserFragment.Companion.getListDomain().get(i);
                    Intrinsics.checkNotNullExpressionValue(str, "listDomain[position]");
                    ((WebView) SubtitleBrowserFragment.this._$_findCachedViewById(C4761R.C4764id.webview)).loadUrl(str);
                }
            });
        }
        this.viewModel = (SubtitleBrowserViewModel) new ViewModelProvider(this).get(SubtitleBrowserViewModel.class);
        ((ImageView) _$_findCachedViewById(C4761R.C4764id.btnBack)).setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.browser.-$$Lambda$SubtitleBrowserFragment$_fuv7rMRRCCiLlNoWws7Fofxpmc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SubtitleBrowserFragment.m8617onViewCreated$lambda3(SubtitleBrowserFragment.this, view2);
            }
        });
        ((ImageView) _$_findCachedViewById(C4761R.C4764id.btnBack)).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.lagradost.cloudstream3.ui.browser.-$$Lambda$SubtitleBrowserFragment$MkCa7JZvgClQh_BwACfIQZOs6K8
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean m8618onViewCreated$lambda4;
                m8618onViewCreated$lambda4 = SubtitleBrowserFragment.m8618onViewCreated$lambda4(SubtitleBrowserFragment.this, view2);
                return m8618onViewCreated$lambda4;
            }
        });
        ((TextView) _$_findCachedViewById(C4761R.C4764id.tvDownload)).setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.browser.-$$Lambda$SubtitleBrowserFragment$-vI7d2t1YXKsJx_oyiwy92-F8CQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SubtitleBrowserFragment.m8619onViewCreated$lambda5(SubtitleBrowserFragment.this, view2);
            }
        });
        ((ImageView) _$_findCachedViewById(C4761R.C4764id.btnMore)).setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.browser.-$$Lambda$SubtitleBrowserFragment$g6pz0MmNQLzza2_KpnAuOkUUg0w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SubtitleBrowserFragment.m8620onViewCreated$lambda6(SubtitleBrowserFragment.this, view2);
            }
        });
        ((WebView) _$_findCachedViewById(C4761R.C4764id.webview)).getSettings().setJavaScriptEnabled(true);
        ((WebView) _$_findCachedViewById(C4761R.C4764id.webview)).addJavascriptInterface(new JavaScriptInterface(this.iCallback), "HTMLOUT");
        ((WebView) _$_findCachedViewById(C4761R.C4764id.webview)).setWebViewClient(new WebViewClient() { // from class: com.lagradost.cloudstream3.ui.browser.SubtitleBrowserFragment$onViewCreated$8
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view2, WebResourceRequest request) {
                Element element;
                String urlDownload;
                Intrinsics.checkNotNullParameter(view2, "view");
                Intrinsics.checkNotNullParameter(request, "request");
                Log.d("DuongKK", " onPageFinished " + request.getUrl());
                String uri = request.getUrl().toString();
                Intrinsics.checkNotNullExpressionValue(uri, "request.url.toString()");
                element = SubtitleBrowserFragment.this.elementDownloadLink;
                if (element != null) {
                    SubtitleBrowserFragment subtitleBrowserFragment = SubtitleBrowserFragment.this;
                    urlDownload = subtitleBrowserFragment.getUrlDownload(element);
                    if (Intrinsics.areEqual(urlDownload, uri)) {
                        subtitleBrowserFragment.downloadSub();
                        return false;
                    }
                    return false;
                }
                return false;
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view2, String url) {
                Intrinsics.checkNotNullParameter(view2, "view");
                Intrinsics.checkNotNullParameter(url, "url");
                Log.d("DuongKK", "onPageFinished " + url);
                ProgressBar progressBar = (ProgressBar) SubtitleBrowserFragment.this._$_findCachedViewById(C4761R.C4764id.loading);
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                TextView textView = (TextView) SubtitleBrowserFragment.this._$_findCachedViewById(C4761R.C4764id.tvTitle);
                if (textView != null) {
                    textView.setText(url);
                }
                SubtitleBrowserFragment.this.parseHtmlAndDownload();
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                ProgressBar progressBar = (ProgressBar) SubtitleBrowserFragment.this._$_findCachedViewById(C4761R.C4764id.loading);
                if (progressBar != null) {
                    progressBar.setVisibility(0);
                }
                TextView textView = (TextView) SubtitleBrowserFragment.this._$_findCachedViewById(C4761R.C4764id.tvTitle);
                if (textView != null) {
                    textView.setText(str);
                }
            }
        });
        ((WebView) _$_findCachedViewById(C4761R.C4764id.webview)).setWebChromeClient(new WebChromeClient() { // from class: com.lagradost.cloudstream3.ui.browser.SubtitleBrowserFragment$onViewCreated$9
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                ProgressBar progressBar = (ProgressBar) SubtitleBrowserFragment.this._$_findCachedViewById(C4761R.C4764id.loading);
                if (progressBar != null) {
                    progressBar.setIndeterminate(false);
                    progressBar.setMax(100);
                    progressBar.setProgress(i);
                    if (progressBar.getProgress() == 100) {
                        progressBar.setVisibility(8);
                    } else {
                        progressBar.setVisibility(0);
                    }
                }
            }
        });
        ((WebView) _$_findCachedViewById(C4761R.C4764id.webview)).loadUrl(DOMAIN_SUBSCENE);
        SubtitleBrowserFragment subtitleBrowserFragment = this;
        SubtitleBrowserViewModel subtitleBrowserViewModel = this.viewModel;
        if (subtitleBrowserViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            subtitleBrowserViewModel = null;
        }
        ArchComponentExt.observe(subtitleBrowserFragment, subtitleBrowserViewModel.getResultResponse(), new SubtitleBrowserFragment$onViewCreated$10(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m8617onViewCreated$lambda3(SubtitleBrowserFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        KeyboardUtils.hideSoftInput(this$0.getActivity());
        if (((WebView) this$0._$_findCachedViewById(C4761R.C4764id.webview)).canGoBack()) {
            ((WebView) this$0._$_findCachedViewById(C4761R.C4764id.webview)).goBack();
            return;
        }
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            UIHelper.INSTANCE.popCurrentPage(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-4  reason: not valid java name */
    public static final boolean m8618onViewCreated$lambda4(SubtitleBrowserFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        KeyboardUtils.hideSoftInput(this$0.getActivity());
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            UIHelper.INSTANCE.popCurrentPage(activity);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-5  reason: not valid java name */
    public static final void m8619onViewCreated$lambda5(SubtitleBrowserFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = (TextView) this$0._$_findCachedViewById(C4761R.C4764id.tvDownload);
        if (textView != null) {
            textView.setVisibility(8);
        }
        this$0.downloadSub();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-6  reason: not valid java name */
    public static final void m8620onViewCreated$lambda6(SubtitleBrowserFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(((WebView) this$0._$_findCachedViewById(C4761R.C4764id.webview)).getUrl()));
        try {
            this$0.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void parseHtmlAndDownload() {
        WebView webView = (WebView) _$_findCachedViewById(C4761R.C4764id.webview);
        if (webView != null) {
            webView.loadUrl("javascript:window.HTMLOUT.processHTML('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>');");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getUrlDownload(Element element) {
        String href = element.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
        Intrinsics.checkNotNullExpressionValue(href, "href");
        if (!StringsKt.contains$default((CharSequence) href, (CharSequence) "http", false, 2, (Object) null)) {
            StringBuilder sb = new StringBuilder();
            Object selectedItem = ((Spinner) _$_findCachedViewById(C4761R.C4764id.spinner)).getSelectedItem();
            Objects.requireNonNull(selectedItem, "null cannot be cast to non-null type kotlin.String");
            sb.append((String) selectedItem);
            sb.append(href);
            href = sb.toString();
        }
        Intrinsics.checkNotNullExpressionValue(href, "href");
        return href;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadSub() {
        File externalFilesDir;
        Element element = this.elementDownloadLink;
        if (element != null) {
            String urlDownload = getUrlDownload(element);
            Context context = getContext();
            SubtitleBrowserViewModel subtitleBrowserViewModel = null;
            String absolutePath = (context == null || (externalFilesDir = context.getExternalFilesDir(null)) == null) ? null : externalFilesDir.getAbsolutePath();
            if (absolutePath != null) {
                Log.d("DuongKK", "URL SUB " + urlDownload + " to " + absolutePath);
                SubtitleBrowserViewModel subtitleBrowserViewModel2 = this.viewModel;
                if (subtitleBrowserViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    subtitleBrowserViewModel = subtitleBrowserViewModel2;
                }
                subtitleBrowserViewModel.downloadSubtitle(urlDownload, absolutePath);
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        SubtitleBrowserViewModel subtitleBrowserViewModel = this.viewModel;
        if (subtitleBrowserViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            subtitleBrowserViewModel = null;
        }
        subtitleBrowserViewModel.getResultResponse().removeObservers(this);
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}
