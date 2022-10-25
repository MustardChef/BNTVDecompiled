package com.lagradost.cloudstream3.utils;

import android.content.DialogInterface;
import com.lagradost.cloudstream3.utils.InAppUpdater;

/* compiled from: lambda */
/* renamed from: com.lagradost.cloudstream3.utils.-$$Lambda$InAppUpdater$Companion$s-R65Wcj52hCgBgmmIZES0Av7-0  reason: invalid class name */
/* loaded from: classes4.dex */
public final /* synthetic */ class $$Lambda$InAppUpdater$Companion$sR65Wcj52hCgBgmmIZES0Av70 implements DialogInterface.OnClickListener {
    public static final /* synthetic */ $$Lambda$InAppUpdater$Companion$sR65Wcj52hCgBgmmIZES0Av70 INSTANCE = new $$Lambda$InAppUpdater$Companion$sR65Wcj52hCgBgmmIZES0Av70();

    private /* synthetic */ $$Lambda$InAppUpdater$Companion$sR65Wcj52hCgBgmmIZES0Av70() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        InAppUpdater.Companion.m9003runAutoUpdate$lambda16$lambda15$lambda13(dialogInterface, i);
    }
}
