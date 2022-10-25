package com.applovin.mediation.nativeAds;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.applovin.impl.sdk.C1710r;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.C1799R;
import com.google.android.exoplayer2.ExoPlayer;

/* loaded from: classes.dex */
public class MaxNativeAdView extends FrameLayout {

    /* renamed from: a */
    private final MaxNativeAd f2670a;

    /* renamed from: b */
    private final TextView f2671b;

    /* renamed from: c */
    private final TextView f2672c;

    /* renamed from: d */
    private final ImageView f2673d;

    /* renamed from: e */
    private final FrameLayout f2674e;

    /* renamed from: f */
    private final FrameLayout f2675f;

    /* renamed from: g */
    private final FrameLayout f2676g;

    /* renamed from: h */
    private final Button f2677h;

    public MaxNativeAdView(MaxNativeAd maxNativeAd, Activity activity) {
        this(maxNativeAd, null, activity);
    }

    public MaxNativeAdView(MaxNativeAd maxNativeAd, String str, Activity activity) {
        super(activity);
        int i;
        MaxAdFormat format = maxNativeAd.getFormat();
        if (format == MaxAdFormat.BANNER) {
            i = "vertical_banner_template".equals(str) ? C1799R.C1803layout.max_native_ad_vertical_banner_view : ("media_banner_template".equals(str) || "no_body_banner_template".equals(str)) ? C1799R.C1803layout.max_native_ad_media_banner_view : "vertical_media_banner_template".equals(str) ? C1799R.C1803layout.max_native_ad_vertical_media_banner_view : C1799R.C1803layout.max_native_ad_banner_view;
        } else if (format == MaxAdFormat.LEADER) {
            i = "vertical_leader_template".equals(str) ? C1799R.C1803layout.max_native_ad_vertical_leader_view : C1799R.C1803layout.max_native_ad_leader_view;
        } else if (format != MaxAdFormat.MREC) {
            throw new IllegalArgumentException("Unsupported ad format: " + format);
        } else {
            i = C1799R.C1803layout.max_native_ad_mrec_view;
        }
        addView(activity.getLayoutInflater().inflate(i, (ViewGroup) null));
        this.f2671b = (TextView) findViewById(C1799R.C1802id.native_title_text_view);
        this.f2672c = (TextView) findViewById(C1799R.C1802id.native_body_text_view);
        this.f2673d = (ImageView) findViewById(C1799R.C1802id.native_icon_image_view);
        this.f2674e = (FrameLayout) findViewById(C1799R.C1802id.native_icon_view);
        this.f2675f = (FrameLayout) findViewById(C1799R.C1802id.options_view);
        this.f2676g = (FrameLayout) findViewById(C1799R.C1802id.native_media_content_view);
        this.f2677h = (Button) findViewById(C1799R.C1802id.native_cta_button);
        this.f2670a = maxNativeAd;
        m6088a();
    }

    /* renamed from: a */
    private void m6088a() {
        this.f2671b.setText(this.f2670a.getTitle());
        TextView textView = this.f2672c;
        if (textView != null) {
            textView.setText(this.f2670a.getBody());
        }
        Button button = this.f2677h;
        if (button != null) {
            button.setText(this.f2670a.getCallToAction());
        }
        MaxNativeAd.MaxNativeAdImage icon = this.f2670a.getIcon();
        View iconView = this.f2670a.getIconView();
        if (icon == null) {
            if (iconView != null) {
                iconView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.f2674e.addView(iconView);
            }
            this.f2674e.setVisibility(8);
        } else if (icon.getDrawable() != null) {
            this.f2673d.setImageDrawable(icon.getDrawable());
        } else {
            if (icon.getUri() != null && AppLovinSdkUtils.isValidString(icon.getUri().toString())) {
                this.f2673d.setImageURI(icon.getUri());
            }
            this.f2674e.setVisibility(8);
        }
        View optionsView = this.f2670a.getOptionsView();
        FrameLayout frameLayout = this.f2675f;
        if (frameLayout != null && optionsView != null) {
            optionsView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f2675f.addView(optionsView);
        } else if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        View mediaView = this.f2670a.getMediaView();
        if (this.f2676g != null) {
            if (mediaView != null) {
                mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.f2676g.addView(mediaView);
            } else if (this.f2670a.getFormat() == MaxAdFormat.LEADER) {
                this.f2676g.setVisibility(8);
            }
        }
        m6087b();
        postDelayed(new Runnable() { // from class: com.applovin.mediation.nativeAds.MaxNativeAdView.1
            @Override // java.lang.Runnable
            public void run() {
                MaxNativeAdView.this.setSelected(true);
            }
        }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    /* renamed from: b */
    private void m6087b() {
        final ViewGroup viewGroup = (ViewGroup) findViewById(C1799R.C1802id.inner_parent_layout);
        if (viewGroup == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (getViewTreeObserver().isAlive()) {
            viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.applovin.mediation.nativeAds.MaxNativeAdView.2
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    MaxNativeAdView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewGroup.getLayoutParams();
                    layoutParams.height = ((View) viewGroup.getParent()).getWidth();
                    viewGroup.setLayoutParams(layoutParams);
                    return true;
                }
            });
        }
    }

    public MaxNativeAd getAd() {
        return this.f2670a;
    }

    public TextView getBodyTextView() {
        return this.f2672c;
    }

    public Button getCallToActionButton() {
        return this.f2677h;
    }

    public FrameLayout getIconContentView() {
        return this.f2674e;
    }

    public ImageView getIconImageView() {
        return this.f2673d;
    }

    public FrameLayout getMediaContentView() {
        return this.f2676g;
    }

    public FrameLayout getOptionsContentView() {
        return this.f2675f;
    }

    public TextView getTitleTextView() {
        return this.f2671b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isHardwareAccelerated()) {
            return;
        }
        C1710r.m6311h("MaxAdView", "Attached to non-hardware accelerated window: some native ad views require hardware accelerated Activities to render properly.");
    }
}
