package com.google.android.gms.internal.cast;

import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.cast.framework.C3616R;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzbp extends zzbj {
    private final RelativeLayout zza;
    private final TextView zzb;
    private final CastSeekBar zzc;
    private final com.google.android.gms.cast.framework.media.uicontroller.zza zzd;

    public zzbp(RelativeLayout relativeLayout, CastSeekBar castSeekBar, com.google.android.gms.cast.framework.media.uicontroller.zza zzaVar) {
        this.zza = relativeLayout;
        TextView textView = (TextView) relativeLayout.findViewById(C3616R.C3619id.tooltip);
        this.zzb = textView;
        this.zzc = castSeekBar;
        this.zzd = zzaVar;
        TypedArray obtainStyledAttributes = textView.getContext().obtainStyledAttributes(null, C3616R.styleable.CastExpandedController, C3616R.attr.castExpandedControllerStyle, C3616R.style.CastExpandedController);
        int resourceId = obtainStyledAttributes.getResourceId(C3616R.styleable.CastExpandedController_castSeekBarTooltipBackgroundColor, 0);
        obtainStyledAttributes.recycle();
        textView.getBackground().setColorFilter(textView.getContext().getResources().getColor(resourceId), PorterDuff.Mode.SRC_IN);
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        zzd();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        zzd();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        super.onSessionEnded();
        zzd();
    }

    @Override // com.google.android.gms.internal.cast.zzbj
    public final void zza(long j) {
        zzd();
    }

    @Override // com.google.android.gms.internal.cast.zzbj
    public final void zzb(boolean z) {
        super.zzb(z);
        zzd();
    }

    final void zzd() {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || zzc()) {
            this.zza.setVisibility(8);
            return;
        }
        this.zza.setVisibility(0);
        TextView textView = this.zzb;
        com.google.android.gms.cast.framework.media.uicontroller.zza zzaVar = this.zzd;
        textView.setText(zzaVar.zzm(this.zzc.getProgress() + zzaVar.zzh()));
        int measuredWidth = (this.zzc.getMeasuredWidth() - this.zzc.getPaddingLeft()) - this.zzc.getPaddingRight();
        this.zzb.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth2 = this.zzb.getMeasuredWidth();
        int min = Math.min(Math.max(0, ((int) ((this.zzc.getProgress() / this.zzc.getMaxProgress()) * measuredWidth)) - (measuredWidth2 / 2)), measuredWidth - measuredWidth2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.zzb.getLayoutParams();
        layoutParams.leftMargin = min;
        this.zzb.setLayoutParams(layoutParams);
    }
}
