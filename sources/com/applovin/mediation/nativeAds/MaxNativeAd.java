package com.applovin.mediation.nativeAds;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.applovin.mediation.MaxAdFormat;

/* loaded from: classes.dex */
public class MaxNativeAd {

    /* renamed from: a */
    private final MaxAdFormat f2652a;

    /* renamed from: b */
    private final String f2653b;

    /* renamed from: c */
    private final String f2654c;

    /* renamed from: d */
    private final String f2655d;

    /* renamed from: e */
    private final MaxNativeAdImage f2656e;

    /* renamed from: f */
    private final View f2657f;

    /* renamed from: g */
    private final View f2658g;

    /* renamed from: h */
    private final View f2659h;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        private MaxAdFormat f2660a;

        /* renamed from: b */
        private String f2661b;

        /* renamed from: c */
        private String f2662c;

        /* renamed from: d */
        private String f2663d;

        /* renamed from: e */
        private MaxNativeAdImage f2664e;

        /* renamed from: f */
        private View f2665f;

        /* renamed from: g */
        private View f2666g;

        /* renamed from: h */
        private View f2667h;

        public MaxNativeAd build() {
            return new MaxNativeAd(this);
        }

        public Builder setAdFormat(MaxAdFormat maxAdFormat) {
            this.f2660a = maxAdFormat;
            return this;
        }

        public Builder setBody(String str) {
            this.f2662c = str;
            return this;
        }

        public Builder setCallToAction(String str) {
            this.f2663d = str;
            return this;
        }

        public Builder setIcon(MaxNativeAdImage maxNativeAdImage) {
            this.f2664e = maxNativeAdImage;
            return this;
        }

        public Builder setIconView(View view) {
            this.f2665f = view;
            return this;
        }

        public Builder setMediaView(View view) {
            this.f2667h = view;
            return this;
        }

        public Builder setOptionsView(View view) {
            this.f2666g = view;
            return this;
        }

        public Builder setTitle(String str) {
            this.f2661b = str;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class MaxNativeAdImage {

        /* renamed from: a */
        private Drawable f2668a;

        /* renamed from: b */
        private Uri f2669b;

        public MaxNativeAdImage(Drawable drawable) {
            this.f2668a = drawable;
        }

        public MaxNativeAdImage(Uri uri) {
            this.f2669b = uri;
        }

        public Drawable getDrawable() {
            return this.f2668a;
        }

        public Uri getUri() {
            return this.f2669b;
        }
    }

    private MaxNativeAd(Builder builder) {
        this.f2652a = builder.f2660a;
        this.f2653b = builder.f2661b;
        this.f2654c = builder.f2662c;
        this.f2655d = builder.f2663d;
        this.f2656e = builder.f2664e;
        this.f2657f = builder.f2665f;
        this.f2658g = builder.f2666g;
        this.f2659h = builder.f2667h;
    }

    public String getBody() {
        return this.f2654c;
    }

    public String getCallToAction() {
        return this.f2655d;
    }

    public MaxAdFormat getFormat() {
        return this.f2652a;
    }

    public MaxNativeAdImage getIcon() {
        return this.f2656e;
    }

    public View getIconView() {
        return this.f2657f;
    }

    public View getMediaView() {
        return this.f2659h;
    }

    public View getOptionsView() {
        return this.f2658g;
    }

    public String getTitle() {
        return this.f2653b;
    }
}
