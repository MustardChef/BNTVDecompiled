package com.lagradost.cloudstream3.utils;

import android.app.Activity;
import com.lagradost.cloudstream3.utils.InAppUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InAppUpdater.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, m107d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class InAppUpdater$Companion$runAutoUpdate$1$1$1$1$downloadStatus$1 extends Lambda implements Functions<Boolean> {
    final /* synthetic */ Activity $context;
    final /* synthetic */ InAppUpdater.Companion.Update $update;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppUpdater$Companion$runAutoUpdate$1$1$1$1$downloadStatus$1(Activity activity, InAppUpdater.Companion.Update update) {
        super(0);
        this.$context = activity;
        this.$update = update;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Functions
    public final Boolean invoke() {
        boolean downloadUpdate;
        downloadUpdate = InAppUpdater.Companion.downloadUpdate(this.$context, this.$update.getUpdateURL());
        return Boolean.valueOf(downloadUpdate);
    }
}
