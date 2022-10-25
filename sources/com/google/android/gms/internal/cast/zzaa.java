package com.google.android.gms.internal.cast;

import android.animation.ObjectAnimator;
import android.view.View;
import com.google.android.gms.common.util.PlatformVersion;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzaa implements View.OnClickListener {
    final /* synthetic */ zzac zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaa(zzac zzacVar) {
        this.zza = zzacVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (PlatformVersion.isAtLeastJellyBean()) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f);
            ofFloat.setDuration(400L).addListener(new zzz(this));
            ofFloat.start();
            return;
        }
        zzac.zza(this.zza);
    }
}
