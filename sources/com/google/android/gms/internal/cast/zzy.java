package com.google.android.gms.internal.cast;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.RelativeLayout;
import com.google.android.gms.cast.framework.C3616R;
import com.google.android.gms.cast.framework.IntroductoryOverlay;
import com.google.android.gms.cast.framework.internal.featurehighlight.HelpTextView;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzy extends RelativeLayout implements IntroductoryOverlay {
    private final boolean zza;
    private Activity zzb;
    private IntroductoryOverlay.OnOverlayDismissedListener zzc;
    private View zzd;
    private com.google.android.gms.cast.framework.internal.featurehighlight.zzh zze;
    private String zzf;
    private boolean zzg;
    private int zzh;

    public zzy(IntroductoryOverlay.Builder builder) {
        super(builder.zza());
        this.zzb = builder.zza();
        this.zza = builder.zze();
        this.zzc = builder.zzc();
        this.zzd = builder.zzb();
        this.zzf = builder.zzf();
        this.zzh = builder.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(Context context) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        return accessibilityManager != null && accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzg() {
        removeAllViews();
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = null;
        this.zzf = null;
        this.zzh = 0;
        this.zzg = false;
    }

    @Override // com.google.android.gms.cast.framework.IntroductoryOverlay
    public final void remove() {
        if (this.zzg) {
            ((ViewGroup) this.zzb.getWindow().getDecorView()).removeView(this);
            zzg();
        }
    }

    @Override // com.google.android.gms.cast.framework.IntroductoryOverlay
    public final void show() {
        Activity activity = this.zzb;
        if (activity == null || this.zzd == null || this.zzg || zza(activity)) {
            return;
        }
        if (!this.zza || !com.google.android.gms.cast.framework.zzaq.zzb(this.zzb)) {
            com.google.android.gms.cast.framework.internal.featurehighlight.zzh zzhVar = new com.google.android.gms.cast.framework.internal.featurehighlight.zzh(this.zzb);
            this.zze = zzhVar;
            int i = this.zzh;
            if (i != 0) {
                zzhVar.zzf(i);
            }
            addView(this.zze);
            HelpTextView helpTextView = (HelpTextView) this.zzb.getLayoutInflater().inflate(C3616R.C3620layout.cast_help_text, (ViewGroup) this.zze, false);
            helpTextView.setText(this.zzf, null);
            this.zze.zzp(helpTextView);
            this.zze.zza(this.zzd, null, true, new zzx(this));
            this.zzg = true;
            ((ViewGroup) this.zzb.getWindow().getDecorView()).addView(this);
            this.zze.zzb(null);
            return;
        }
        zzg();
    }
}
