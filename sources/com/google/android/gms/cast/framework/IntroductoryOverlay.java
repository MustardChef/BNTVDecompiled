package com.google.android.gms.cast.framework;

import android.app.Activity;
import android.view.MenuItem;
import android.view.View;
import androidx.mediarouter.app.MediaRouteButton;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.cast.zzjt;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public interface IntroductoryOverlay {

    /* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
    /* loaded from: classes2.dex */
    public interface OnOverlayDismissedListener {
        void onOverlayDismissed();
    }

    void remove();

    void show();

    /* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
    /* loaded from: classes2.dex */
    public static class Builder {
        private final Activity zza;
        private final View zzb;
        private int zzc;
        private String zzd;
        private OnOverlayDismissedListener zze;
        private boolean zzf;
        private float zzg;
        private String zzh;

        public Builder(Activity activity, MenuItem menuItem) {
            this.zza = (Activity) Preconditions.checkNotNull(activity);
            this.zzb = ((MenuItem) Preconditions.checkNotNull(menuItem)).getActionView();
        }

        public IntroductoryOverlay build() {
            com.google.android.gms.internal.cast.zzl.zzb(zzjt.INSTRUCTIONS_VIEW);
            if (PlatformVersion.isAtLeastJellyBean()) {
                return new com.google.android.gms.internal.cast.zzy(this);
            }
            return new com.google.android.gms.internal.cast.zzac(this, null, C3616R.attr.castIntroOverlayStyle);
        }

        public Builder setButtonText(int i) {
            this.zzh = this.zza.getResources().getString(i);
            return this;
        }

        public Builder setButtonText(String str) {
            this.zzh = str;
            return this;
        }

        public Builder setFocusRadius(float f) {
            this.zzg = f;
            return this;
        }

        public Builder setFocusRadiusId(int i) {
            this.zzg = this.zza.getResources().getDimension(i);
            return this;
        }

        public Builder setOnOverlayDismissedListener(OnOverlayDismissedListener onOverlayDismissedListener) {
            this.zze = onOverlayDismissedListener;
            return this;
        }

        public Builder setOverlayColor(int i) {
            this.zzc = this.zza.getResources().getColor(i);
            return this;
        }

        public Builder setSingleTime() {
            this.zzf = true;
            return this;
        }

        public Builder setTitleText(int i) {
            this.zzd = this.zza.getResources().getString(i);
            return this;
        }

        public Builder setTitleText(String str) {
            this.zzd = str;
            return this;
        }

        public final Activity zza() {
            return this.zza;
        }

        public final View zzb() {
            return this.zzb;
        }

        public final OnOverlayDismissedListener zzc() {
            return this.zze;
        }

        public final int zzd() {
            return this.zzc;
        }

        public final boolean zze() {
            return this.zzf;
        }

        public final String zzf() {
            return this.zzd;
        }

        public final String zzg() {
            return this.zzh;
        }

        public final float zzh() {
            return this.zzg;
        }

        public Builder(Activity activity, MediaRouteButton mediaRouteButton) {
            this.zza = (Activity) Preconditions.checkNotNull(activity);
            this.zzb = (View) Preconditions.checkNotNull(mediaRouteButton);
        }
    }
}
