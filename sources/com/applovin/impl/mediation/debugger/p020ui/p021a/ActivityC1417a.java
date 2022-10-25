package com.applovin.impl.mediation.debugger.p020ui.p021a;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.applovin.impl.mediation.debugger.p016a.p017a.C1402a;
import com.applovin.impl.mediation.debugger.p016a.p017a.C1403b;
import com.applovin.impl.mediation.debugger.p020ui.ActivityC1414a;
import com.applovin.impl.mediation.debugger.p020ui.p021a.C1422b;
import com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d;
import com.applovin.impl.mediation.debugger.p020ui.p025d.C1450a;
import com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c;
import com.applovin.impl.mediation.debugger.p020ui.testmode.AdControlButton;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.mediation.ads.MaxRewardedAd;
import com.applovin.mediation.ads.MaxRewardedInterstitialAd;
import com.applovin.sdk.C1799R;

/* renamed from: com.applovin.impl.mediation.debugger.ui.a.a */
/* loaded from: classes.dex */
public class ActivityC1417a extends ActivityC1414a implements AdControlButton.InterfaceC1464a, MaxAdRevenueListener, MaxAdViewAdListener, MaxRewardedAdListener {

    /* renamed from: a */
    private C1662k f1081a;

    /* renamed from: b */
    private C1402a f1082b;

    /* renamed from: c */
    private C1422b f1083c;

    /* renamed from: d */
    private C1403b f1084d;

    /* renamed from: e */
    private MaxAdView f1085e;

    /* renamed from: f */
    private MaxInterstitialAd f1086f;

    /* renamed from: g */
    private MaxRewardedInterstitialAd f1087g;

    /* renamed from: h */
    private MaxRewardedAd f1088h;

    /* renamed from: i */
    private DialogC1429d f1089i;

    /* renamed from: j */
    private ListView f1090j;

    /* renamed from: k */
    private View f1091k;

    /* renamed from: l */
    private AdControlButton f1092l;

    /* renamed from: m */
    private TextView f1093m;

    /* renamed from: a */
    private void m7490a() {
        String m7556a = this.f1082b.m7556a();
        if (this.f1082b.m7552d().isAdViewAd()) {
            MaxAdView maxAdView = new MaxAdView(m7556a, this.f1082b.m7552d(), this.f1081a.m6664W(), this);
            this.f1085e = maxAdView;
            maxAdView.setListener(this);
        } else if (MaxAdFormat.INTERSTITIAL == this.f1082b.m7552d()) {
            MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd(m7556a, this.f1081a.m6664W(), this);
            this.f1086f = maxInterstitialAd;
            maxInterstitialAd.setListener(this);
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == this.f1082b.m7552d()) {
            MaxRewardedInterstitialAd maxRewardedInterstitialAd = new MaxRewardedInterstitialAd(m7556a, this.f1081a.m6664W(), this);
            this.f1087g = maxRewardedInterstitialAd;
            maxRewardedInterstitialAd.setListener(this);
        } else if (MaxAdFormat.REWARDED == this.f1082b.m7552d()) {
            MaxRewardedAd maxRewardedAd = MaxRewardedAd.getInstance(m7556a, this.f1081a.m6664W(), this);
            this.f1088h = maxRewardedAd;
            maxRewardedAd.setListener(this);
        }
    }

    /* renamed from: a */
    private void m7489a(DialogInterface.OnShowListener onShowListener) {
        if (this.f1089i != null) {
            return;
        }
        DialogC1429d dialogC1429d = new DialogC1429d(this.f1085e, this.f1082b.m7552d(), this);
        this.f1089i = dialogC1429d;
        dialogC1429d.setOnShowListener(onShowListener);
        this.f1089i.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.applovin.impl.mediation.debugger.ui.a.a.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                ActivityC1417a.this.f1085e.stopAutoRefresh();
                ActivityC1417a.this.f1089i = null;
            }
        });
        this.f1089i.show();
    }

    /* renamed from: a */
    private void m7485a(MaxAdFormat maxAdFormat) {
        if (this.f1084d != null) {
            this.f1081a.m6679H().m7350a(this.f1084d.m7547b());
            this.f1081a.m6679H().m7348a(true);
        }
        if (maxAdFormat.isAdViewAd()) {
            this.f1085e.loadAd();
        } else if (MaxAdFormat.INTERSTITIAL == this.f1082b.m7552d()) {
            this.f1086f.loadAd();
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == this.f1082b.m7552d()) {
            this.f1087g.loadAd();
        } else if (MaxAdFormat.REWARDED == this.f1082b.m7552d()) {
            this.f1088h.loadAd();
        }
    }

    /* renamed from: b */
    private void m7484b(MaxAdFormat maxAdFormat) {
        if (maxAdFormat.isAdViewAd()) {
            m7489a(new DialogInterface.OnShowListener() { // from class: com.applovin.impl.mediation.debugger.ui.a.a.2
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    ActivityC1417a.this.f1085e.startAutoRefresh();
                }
            });
        } else if (MaxAdFormat.INTERSTITIAL == this.f1082b.m7552d()) {
            this.f1086f.showAd();
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == this.f1082b.m7552d()) {
            this.f1087g.showAd();
        } else if (MaxAdFormat.REWARDED == this.f1082b.m7552d()) {
            this.f1088h.showAd();
        }
    }

    public void initialize(final C1402a c1402a, C1403b c1403b, final C1662k c1662k) {
        this.f1081a = c1662k;
        this.f1082b = c1402a;
        this.f1084d = c1403b;
        C1422b c1422b = new C1422b(c1402a, c1403b, this);
        this.f1083c = c1422b;
        c1422b.m7377a(new AbstractView$OnClickListenerC1456d.InterfaceC1458a() { // from class: com.applovin.impl.mediation.debugger.ui.a.a.1
            @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d.InterfaceC1458a
            /* renamed from: a */
            public void mo7365a(C1450a c1450a, final C1452c c1452c) {
                if (c1452c instanceof C1422b.C1423a) {
                    ActivityC1417a.this.startActivity(MaxDebuggerAdUnitDetailActivity.class, c1662k.m6636ad(), new ActivityC1414a.InterfaceC1416a<MaxDebuggerAdUnitDetailActivity>() { // from class: com.applovin.impl.mediation.debugger.ui.a.a.1.1
                        @Override // com.applovin.impl.mediation.debugger.p020ui.ActivityC1414a.InterfaceC1416a
                        /* renamed from: a  reason: avoid collision after fix types in other method */
                        public void mo7430a(MaxDebuggerAdUnitDetailActivity maxDebuggerAdUnitDetailActivity) {
                            maxDebuggerAdUnitDetailActivity.initialize(c1402a, ((C1422b.C1423a) c1452c).m7474a(), c1662k);
                        }
                    });
                }
            }
        });
        m7490a();
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdClicked(MaxAd maxAd) {
        Utils.showToast("onAdClicked", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdViewAdListener
    public void onAdCollapsed(MaxAd maxAd) {
        Utils.showToast("onAdCollapsed", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        this.f1092l.setControlState(AdControlButton.EnumC1465b.LOAD);
        this.f1093m.setText("");
        Utils.showAlert("", "Failed to display with error code: " + maxError.getCode(), this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdDisplayed(MaxAd maxAd) {
        Utils.showToast("onAdDisplayed", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdViewAdListener
    public void onAdExpanded(MaxAd maxAd) {
        Utils.showToast("onAdExpanded", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdHidden(MaxAd maxAd) {
        Utils.showToast("onAdHidden", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdLoadFailed(String str, MaxError maxError) {
        this.f1092l.setControlState(AdControlButton.EnumC1465b.LOAD);
        this.f1093m.setText("");
        if (204 == maxError.getCode()) {
            Utils.showAlert("No Fill", "No fills often happen in live environments. Please make sure to use the Mediation Debugger test mode before you go live.", this);
            return;
        }
        Utils.showAlert("", "Failed to load with error code: " + maxError.getCode(), this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdLoaded(MaxAd maxAd) {
        TextView textView = this.f1093m;
        textView.setText(maxAd.getNetworkName() + " ad loaded");
        this.f1092l.setControlState(AdControlButton.EnumC1465b.SHOW);
        if (maxAd.getFormat().isAdViewAd()) {
            m7489a((DialogInterface.OnShowListener) null);
        }
    }

    @Override // com.applovin.mediation.MaxAdRevenueListener
    public void onAdRevenuePaid(MaxAd maxAd) {
        Utils.showToast("onAdRevenuePaid", maxAd, this);
    }

    @Override // com.applovin.impl.mediation.debugger.p020ui.testmode.AdControlButton.InterfaceC1464a
    public void onClick(AdControlButton adControlButton) {
        if (this.f1081a.m6679H().m7351a()) {
            Utils.showAlert("Not Supported", "Ad loads are not supported while Test Mode is enabled. Please restart the app.", this);
        } else if (AdControlButton.EnumC1465b.LOAD == adControlButton.getControlState()) {
            adControlButton.setControlState(AdControlButton.EnumC1465b.LOADING);
            m7485a(this.f1082b.m7552d());
        } else if (AdControlButton.EnumC1465b.SHOW == adControlButton.getControlState()) {
            if (!this.f1082b.m7552d().isAdViewAd()) {
                adControlButton.setControlState(AdControlButton.EnumC1465b.LOAD);
            }
            m7484b(this.f1082b.m7552d());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.applovin.impl.mediation.debugger.p020ui.ActivityC1414a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1799R.C1803layout.mediation_debugger_ad_unit_detail_activity);
        setTitle(this.f1083c.m7482a());
        this.f1090j = (ListView) findViewById(C1799R.C1802id.listView);
        this.f1091k = findViewById(C1799R.C1802id.ad_presenter_view);
        this.f1092l = (AdControlButton) findViewById(C1799R.C1802id.ad_control_button);
        this.f1093m = (TextView) findViewById(C1799R.C1802id.status_textview);
        this.f1090j.setAdapter((ListAdapter) this.f1083c);
        this.f1093m.setText(this.f1081a.m6679H().m7351a() ? "Not Supported while Test Mode is enabled" : "Tap to load an ad");
        this.f1093m.setTypeface(Typeface.DEFAULT_BOLD);
        this.f1092l.setOnClickListener(this);
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setPadding(0, 10, 0, 0);
        shapeDrawable.getPaint().setColor(-1);
        shapeDrawable.getPaint().setShadowLayer(10, 0.0f, -10, 855638016);
        shapeDrawable.setShape(new RectShape());
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable});
        layerDrawable.setLayerInset(0, 0, 10, 0, 0);
        this.f1091k.setBackground(layerDrawable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.applovin.impl.mediation.debugger.p020ui.ActivityC1414a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f1084d != null) {
            this.f1081a.m6679H().m7350a((String) null);
            this.f1081a.m6679H().m7348a(false);
        }
        MaxAdView maxAdView = this.f1085e;
        if (maxAdView != null) {
            maxAdView.destroy();
        }
        MaxInterstitialAd maxInterstitialAd = this.f1086f;
        if (maxInterstitialAd != null) {
            maxInterstitialAd.destroy();
        }
        MaxRewardedAd maxRewardedAd = this.f1088h;
        if (maxRewardedAd != null) {
            maxRewardedAd.destroy();
        }
    }

    @Override // com.applovin.mediation.MaxRewardedAdListener
    public void onRewardedVideoCompleted(MaxAd maxAd) {
        Utils.showToast("onRewardedVideoCompleted", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxRewardedAdListener
    public void onRewardedVideoStarted(MaxAd maxAd) {
        Utils.showToast("onRewardedVideoStarted", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxRewardedAdListener
    public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
        Utils.showToast("onUserRewarded", maxAd, this);
    }
}
