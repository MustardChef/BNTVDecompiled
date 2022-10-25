package com.phimhd;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.p041ui.browser.ICallback;
import com.lagradost.cloudstream3.utils.SingleSelectionHelper;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: BottomUpgradeDialog.kt */
@Metadata(m108d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u000bH\u0016J\u0006\u0010\u001c\u001a\u00020\u000bJ\u0006\u0010\u001d\u001a\u00020\u000bJ\u000e\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0016J\u001a\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0017J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\""}, m107d2 = {"Lcom/phimhd/BottomUpgradeDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "iCallback", "Lcom/lagradost/cloudstream3/ui/browser/ICallback;", "", "getICallback", "()Lcom/lagradost/cloudstream3/ui/browser/ICallback;", "setICallback", "(Lcom/lagradost/cloudstream3/ui/browser/ICallback;)V", "crosslineTextView", "", "tv", "Landroid/widget/TextView;", "onAttach", "context", "Landroid/content/Context;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onDetach", "onViewBackClicked", "onViewClicked", ViewHierarchyConstants.VIEW_KEY, "onViewCreated", "removecrosslineTextView", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class BottomUpgradeDialog extends BottomSheetDialogFragment {
    public static final Companion Companion = new Companion(null);
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private ICallback<String> iCallback;

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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final ICallback<String> getICallback() {
        return this.iCallback;
    }

    public final void setICallback(ICallback<String> iCallback) {
        this.iCallback = iCallback;
    }

    /* compiled from: BottomUpgradeDialog.kt */
    @Metadata(m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¨\u0006\u0005"}, m107d2 = {"Lcom/phimhd/BottomUpgradeDialog$Companion;", "", "()V", "newInstance", "Lcom/phimhd/BottomUpgradeDialog;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BottomUpgradeDialog newInstance() {
            Bundle bundle = new Bundle();
            BottomUpgradeDialog bottomUpgradeDialog = new BottomUpgradeDialog();
            bottomUpgradeDialog.setArguments(bundle);
            return bottomUpgradeDialog;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_upgrade_layout, viewGroup, false);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(bundle);
        bottomSheetDialog.setOnShowListener($$Lambda$BottomUpgradeDialog$Reen6GEwZ9ReCZRxtog0ixylHw.INSTANCE);
        return bottomSheetDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreateDialog$lambda-0  reason: not valid java name */
    public static final void m9057onCreateDialog$lambda0(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        View findViewById = ((BottomSheetDialog) dialog).findViewById(R.id.design_bottom_sheet);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
        Intrinsics.checkNotNullExpressionValue(from, "from(bottomSheet)");
        from.setPeekHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
        from.setState(3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Config config;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ((ViewPager) _$_findCachedViewById(C4761R.C4764id.viewpager)).setClipToPadding(false);
        ((ViewPager) _$_findCachedViewById(C4761R.C4764id.viewpager)).setPageMargin(12);
        ((ViewPager) _$_findCachedViewById(C4761R.C4764id.viewpager)).setAdapter(new AdapterUpgradeItem());
        ((ViewPager) _$_findCachedViewById(C4761R.C4764id.viewpager)).addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.phimhd.BottomUpgradeDialog$onViewCreated$1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i == 1) {
                    ((TextView) BottomUpgradeDialog.this._$_findCachedViewById(C4761R.C4764id.tvQuality)).setText(BottomUpgradeDialog.this.getString(R.string.ben_quality));
                    BottomUpgradeDialog bottomUpgradeDialog = BottomUpgradeDialog.this;
                    TextView tvAds = (TextView) bottomUpgradeDialog._$_findCachedViewById(C4761R.C4764id.tvAds);
                    Intrinsics.checkNotNullExpressionValue(tvAds, "tvAds");
                    bottomUpgradeDialog.removecrosslineTextView(tvAds);
                    BottomUpgradeDialog bottomUpgradeDialog2 = BottomUpgradeDialog.this;
                    TextView tvSupport = (TextView) bottomUpgradeDialog2._$_findCachedViewById(C4761R.C4764id.tvSupport);
                    Intrinsics.checkNotNullExpressionValue(tvSupport, "tvSupport");
                    bottomUpgradeDialog2.crosslineTextView(tvSupport);
                    BottomUpgradeDialog bottomUpgradeDialog3 = BottomUpgradeDialog.this;
                    TextView tvDownload = (TextView) bottomUpgradeDialog3._$_findCachedViewById(C4761R.C4764id.tvDownload);
                    Intrinsics.checkNotNullExpressionValue(tvDownload, "tvDownload");
                    bottomUpgradeDialog3.crosslineTextView(tvDownload);
                    ((TextView) BottomUpgradeDialog.this._$_findCachedViewById(C4761R.C4764id.textView15)).setText(BottomUpgradeDialog.this.getString(R.string.premium_plan));
                    Context context = BottomUpgradeDialog.this.getContext();
                    Intrinsics.checkNotNull(context);
                    ((TextView) BottomUpgradeDialog.this._$_findCachedViewById(C4761R.C4764id.tvAds)).setTextColor(ContextCompat.getColor(context, R.color.background_color));
                    Context context2 = BottomUpgradeDialog.this.getContext();
                    Intrinsics.checkNotNull(context2);
                    ((TextView) BottomUpgradeDialog.this._$_findCachedViewById(C4761R.C4764id.tvSupport)).setTextColor(ContextCompat.getColor(context2, R.color.gray_light));
                    Context context3 = BottomUpgradeDialog.this.getContext();
                    Intrinsics.checkNotNull(context3);
                    ((TextView) BottomUpgradeDialog.this._$_findCachedViewById(C4761R.C4764id.tvDownload)).setTextColor(ContextCompat.getColor(context3, R.color.gray_light));
                } else if (i == 2) {
                    ((TextView) BottomUpgradeDialog.this._$_findCachedViewById(C4761R.C4764id.tvQuality)).setText(BottomUpgradeDialog.this.getString(R.string.ben_quality));
                    ((TextView) BottomUpgradeDialog.this._$_findCachedViewById(C4761R.C4764id.textView15)).setText(BottomUpgradeDialog.this.getString(R.string.unlimited_plan));
                    BottomUpgradeDialog bottomUpgradeDialog4 = BottomUpgradeDialog.this;
                    TextView tvAds2 = (TextView) bottomUpgradeDialog4._$_findCachedViewById(C4761R.C4764id.tvAds);
                    Intrinsics.checkNotNullExpressionValue(tvAds2, "tvAds");
                    bottomUpgradeDialog4.removecrosslineTextView(tvAds2);
                    BottomUpgradeDialog bottomUpgradeDialog5 = BottomUpgradeDialog.this;
                    TextView tvDownload2 = (TextView) bottomUpgradeDialog5._$_findCachedViewById(C4761R.C4764id.tvDownload);
                    Intrinsics.checkNotNullExpressionValue(tvDownload2, "tvDownload");
                    bottomUpgradeDialog5.removecrosslineTextView(tvDownload2);
                    BottomUpgradeDialog bottomUpgradeDialog6 = BottomUpgradeDialog.this;
                    TextView tvSupport2 = (TextView) bottomUpgradeDialog6._$_findCachedViewById(C4761R.C4764id.tvSupport);
                    Intrinsics.checkNotNullExpressionValue(tvSupport2, "tvSupport");
                    bottomUpgradeDialog6.removecrosslineTextView(tvSupport2);
                    Context context4 = BottomUpgradeDialog.this.getContext();
                    Intrinsics.checkNotNull(context4);
                    ((TextView) BottomUpgradeDialog.this._$_findCachedViewById(C4761R.C4764id.tvSupport)).setTextColor(ContextCompat.getColor(context4, R.color.background_color));
                    Context context5 = BottomUpgradeDialog.this.getContext();
                    Intrinsics.checkNotNull(context5);
                    ((TextView) BottomUpgradeDialog.this._$_findCachedViewById(C4761R.C4764id.tvAds)).setTextColor(ContextCompat.getColor(context5, R.color.background_color));
                    Context context6 = BottomUpgradeDialog.this.getContext();
                    Intrinsics.checkNotNull(context6);
                    ((TextView) BottomUpgradeDialog.this._$_findCachedViewById(C4761R.C4764id.tvDownload)).setTextColor(ContextCompat.getColor(context6, R.color.background_color));
                } else {
                    ((TextView) BottomUpgradeDialog.this._$_findCachedViewById(C4761R.C4764id.tvQuality)).setText(BottomUpgradeDialog.this.getString(R.string.ben_quality));
                    ((TextView) BottomUpgradeDialog.this._$_findCachedViewById(C4761R.C4764id.textView15)).setText(BottomUpgradeDialog.this.getString(R.string.standard_plan));
                    BottomUpgradeDialog bottomUpgradeDialog7 = BottomUpgradeDialog.this;
                    TextView tvAds3 = (TextView) bottomUpgradeDialog7._$_findCachedViewById(C4761R.C4764id.tvAds);
                    Intrinsics.checkNotNullExpressionValue(tvAds3, "tvAds");
                    bottomUpgradeDialog7.crosslineTextView(tvAds3);
                    BottomUpgradeDialog bottomUpgradeDialog8 = BottomUpgradeDialog.this;
                    TextView tvDownload3 = (TextView) bottomUpgradeDialog8._$_findCachedViewById(C4761R.C4764id.tvDownload);
                    Intrinsics.checkNotNullExpressionValue(tvDownload3, "tvDownload");
                    bottomUpgradeDialog8.crosslineTextView(tvDownload3);
                    BottomUpgradeDialog bottomUpgradeDialog9 = BottomUpgradeDialog.this;
                    TextView tvSupport3 = (TextView) bottomUpgradeDialog9._$_findCachedViewById(C4761R.C4764id.tvSupport);
                    Intrinsics.checkNotNullExpressionValue(tvSupport3, "tvSupport");
                    bottomUpgradeDialog9.crosslineTextView(tvSupport3);
                    Context context7 = BottomUpgradeDialog.this.getContext();
                    Intrinsics.checkNotNull(context7);
                    ((TextView) BottomUpgradeDialog.this._$_findCachedViewById(C4761R.C4764id.tvAds)).setTextColor(ContextCompat.getColor(context7, R.color.gray_light));
                    Context context8 = BottomUpgradeDialog.this.getContext();
                    Intrinsics.checkNotNull(context8);
                    ((TextView) BottomUpgradeDialog.this._$_findCachedViewById(C4761R.C4764id.tvSupport)).setTextColor(ContextCompat.getColor(context8, R.color.gray_light));
                    Context context9 = BottomUpgradeDialog.this.getContext();
                    Intrinsics.checkNotNull(context9);
                    ((TextView) BottomUpgradeDialog.this._$_findCachedViewById(C4761R.C4764id.tvDownload)).setTextColor(ContextCompat.getColor(context9, R.color.gray_light));
                }
            }
        });
        Object[] objArr = new Object[1];
        AppController companion = AppController.Companion.getInstance();
        objArr[0] = (companion == null || (config = companion.getConfig()) == null) ? null : config.phone;
        String string = getString(R.string.step_1, objArr);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.step_….instance?.config?.phone)");
        String string2 = getString(R.string.step_2);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.step_2)");
        String string3 = getString(R.string.step_3);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.step_3)");
        String string4 = getString(R.string.contact_us);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.contact_us)");
        if (Build.VERSION.SDK_INT >= 24) {
            ((TextView) _$_findCachedViewById(C4761R.C4764id.tvStep1)).setText(Html.fromHtml(string, 63));
            ((TextView) _$_findCachedViewById(C4761R.C4764id.tvStep2)).setText(Html.fromHtml(string2, 63));
            ((TextView) _$_findCachedViewById(C4761R.C4764id.textView24)).setText(Html.fromHtml(string3, 63));
            ((TextView) _$_findCachedViewById(C4761R.C4764id.tvContact)).setText(Html.fromHtml(string4, 63));
        } else {
            ((TextView) _$_findCachedViewById(C4761R.C4764id.tvStep1)).setText(Html.fromHtml(string));
            ((TextView) _$_findCachedViewById(C4761R.C4764id.tvStep1)).setText(Html.fromHtml(string2));
            ((TextView) _$_findCachedViewById(C4761R.C4764id.textView24)).setText(Html.fromHtml(string3));
            ((TextView) _$_findCachedViewById(C4761R.C4764id.tvContact)).setText(Html.fromHtml(string4));
        }
        ((ViewPager) _$_findCachedViewById(C4761R.C4764id.viewpager)).setCurrentItem(1);
        AppController companion2 = AppController.Companion.getInstance();
        Config config2 = companion2 != null ? companion2.getConfig() : null;
        if (config2 != null) {
            if (config2.isShowUpgradeMethod()) {
                ((Group) _$_findCachedViewById(C4761R.C4764id.groupVisible)).setVisibility(0);
            } else {
                ((Group) _$_findCachedViewById(C4761R.C4764id.groupVisible)).setVisibility(8);
            }
        }
        ((MaterialButton) _$_findCachedViewById(C4761R.C4764id.upgradeBtn)).setOnClickListener(new View.OnClickListener() { // from class: com.phimhd.-$$Lambda$BottomUpgradeDialog$yAqfGIomTVTcJgyVjJT4W3AVztU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BottomUpgradeDialog.m9058onViewCreated$lambda1(BottomUpgradeDialog.this, view2);
            }
        });
        ((ImageView) _$_findCachedViewById(C4761R.C4764id.imgBack)).setOnClickListener(new View.OnClickListener() { // from class: com.phimhd.-$$Lambda$BottomUpgradeDialog$Yq7RJuujsTYWHqLqblYsGgC10Qk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BottomUpgradeDialog.m9059onViewCreated$lambda2(BottomUpgradeDialog.this, view2);
            }
        });
        ((MaterialButton) _$_findCachedViewById(C4761R.C4764id.button)).setOnClickListener(new View.OnClickListener() { // from class: com.phimhd.-$$Lambda$BottomUpgradeDialog$frm0fGuGWELdq_HaTweFwSliZL0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BottomUpgradeDialog.m9060onViewCreated$lambda3(BottomUpgradeDialog.this, view2);
            }
        });
        ((TextView) _$_findCachedViewById(C4761R.C4764id.tvContact)).setOnClickListener(new View.OnClickListener() { // from class: com.phimhd.-$$Lambda$BottomUpgradeDialog$k_IdvJLGeOQuAqnOawgxV2ghxQg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BottomUpgradeDialog.m9061onViewCreated$lambda4(BottomUpgradeDialog.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m9058onViewCreated$lambda1(BottomUpgradeDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onViewClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m9059onViewCreated$lambda2(BottomUpgradeDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onViewBackClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m9060onViewCreated$lambda3(BottomUpgradeDialog this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-4  reason: not valid java name */
    public static final void m9061onViewCreated$lambda4(BottomUpgradeDialog this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void crosslineTextView(TextView textView) {
        textView.setPaintFlags(textView.getPaintFlags() | 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removecrosslineTextView(TextView textView) {
        textView.setPaintFlags(textView.getPaintFlags() & (-17));
    }

    public final void onViewClicked() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = Constants.URL_RECEIVE;
        String string = getString(R.string.pay_with_momo);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.pay_with_momo)");
        String string2 = getString(R.string.pay_with_paypal);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.pay_with_paypal)");
        ArrayList arrayListOf = CollectionsKt.arrayListOf(string, string2);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            String string3 = getString(R.string.select_payment_method);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.select_payment_method)");
            SingleSelectionHelper.INSTANCE.showDialog(activity, arrayListOf, 0, string3, true, BottomUpgradeDialog$onViewClicked$1.INSTANCE, new BottomUpgradeDialog$onViewClicked$2(objectRef, this));
        }
    }

    public final void onViewBackClicked() {
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof ICallback) {
            this.iCallback = (ICallback) context;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.iCallback = null;
    }

    public final void onViewClicked(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        if (id != R.id.button) {
            if (id != R.id.tvContact) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(Constants.URL_PAGE));
            startActivity(intent);
            return;
        }
        UIHelper.INSTANCE.hideKeyboard(this);
        if (this.iCallback != null) {
            if (((EditText) _$_findCachedViewById(C4761R.C4764id.editTextTextEmailAddress)).getText().toString().length() == 0) {
                Toast.makeText(getContext(), getString(R.string.please_fill_key), 0).show();
            } else {
                ICallback<String> iCallback = this.iCallback;
                Intrinsics.checkNotNull(iCallback);
                iCallback.onCallback(((EditText) _$_findCachedViewById(C4761R.C4764id.editTextTextEmailAddress)).getText().toString());
            }
        }
        dismiss();
    }
}
