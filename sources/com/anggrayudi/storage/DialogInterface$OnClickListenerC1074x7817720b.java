package com.anggrayudi.storage;

import android.content.DialogInterface;
import com.anggrayudi.storage.SimpleStorageHelper;

/* compiled from: lambda */
/* renamed from: com.anggrayudi.storage.-$$Lambda$SimpleStorageHelper$Companion$k6FQsWRZEGllm6-x-0BQqkvOoF4 */
/* loaded from: classes.dex */
public final /* synthetic */ class DialogInterface$OnClickListenerC1074x7817720b implements DialogInterface.OnClickListener {
    public static final /* synthetic */ DialogInterface$OnClickListenerC1074x7817720b INSTANCE = new DialogInterface$OnClickListenerC1074x7817720b();

    private /* synthetic */ DialogInterface$OnClickListenerC1074x7817720b() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        SimpleStorageHelper.Companion.m8546redirectToSystemSettings$lambda0(dialogInterface, i);
    }
}
