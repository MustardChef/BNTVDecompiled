package com.google.android.gms.cast.framework.media;

import android.app.Dialog;
import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
final class zzbr implements DialogInterface.OnClickListener {
    final /* synthetic */ TracksChooserDialogFragment zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbr(TracksChooserDialogFragment tracksChooserDialogFragment) {
        this.zza = tracksChooserDialogFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        Dialog dialog2;
        dialog = this.zza.zze;
        if (dialog != null) {
            dialog2 = this.zza.zze;
            dialog2.cancel();
            this.zza.zze = null;
        }
    }
}
