package com.lagradost.cloudstream3.utils;

import android.app.Activity;
import com.bongngotv2.R;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.utils.InAppUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InAppUpdater.kt */
@Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class InAppUpdater$Companion$runAutoUpdate$1$1$1$1 extends Lambda implements Functions<Unit> {
    final /* synthetic */ Activity $context;
    final /* synthetic */ Activity $this_runAutoUpdate;
    final /* synthetic */ InAppUpdater.Companion.Update $update;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppUpdater$Companion$runAutoUpdate$1$1$1$1(Activity activity, Activity activity2, InAppUpdater.Companion.Update update) {
        super(0);
        this.$this_runAutoUpdate = activity;
        this.$context = activity2;
        this.$update = update;
    }

    @Override // kotlin.jvm.functions.Functions
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Functions
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Boolean bool = (Boolean) ArchComponentExt.normalSafeApiCall(new InAppUpdater$Companion$runAutoUpdate$1$1$1$1$downloadStatus$1(this.$context, this.$update));
        if (bool != null ? bool.booleanValue() : false) {
            return;
        }
        Activity activity = this.$this_runAutoUpdate;
        final Activity activity2 = this.$context;
        activity.runOnUiThread(new Runnable() { // from class: com.lagradost.cloudstream3.utils.-$$Lambda$InAppUpdater$Companion$runAutoUpdate$1$1$1$1$K6VLAzZlQ2l2puvWeuYC1Zm9jGo
            @Override // java.lang.Runnable
            public final void run() {
                InAppUpdater$Companion$runAutoUpdate$1$1$1$1.m9005invoke$lambda0(activity2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m9005invoke$lambda0(Activity context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        CommonActivity.INSTANCE.showToast(context, R.string.download_failed, 1);
    }
}
