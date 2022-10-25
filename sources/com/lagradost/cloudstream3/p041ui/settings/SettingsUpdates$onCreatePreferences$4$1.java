package com.lagradost.cloudstream3.p041ui.settings;

import androidx.fragment.app.FragmentActivity;
import com.bongngotv2.R;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.utils.InAppUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsUpdates.kt */
@Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.settings.SettingsUpdates$onCreatePreferences$4$1 */
/* loaded from: classes4.dex */
public final class SettingsUpdates$onCreatePreferences$4$1 extends Lambda implements Functions<Unit> {
    final /* synthetic */ SettingsUpdates this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsUpdates$onCreatePreferences$4$1(SettingsUpdates settingsUpdates) {
        super(0);
        this.this$0 = settingsUpdates;
    }

    @Override // kotlin.jvm.functions.Functions
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Functions
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FragmentActivity activity;
        InAppUpdater.Companion companion = InAppUpdater.Companion;
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        if (companion.runAutoUpdate(requireActivity, false) || (activity = this.this$0.getActivity()) == null) {
            return;
        }
        final SettingsUpdates settingsUpdates = this.this$0;
        activity.runOnUiThread(new Runnable() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsUpdates$onCreatePreferences$4$1$VMDyYChqw--Hhp_IOfZyxO4gdeg
            @Override // java.lang.Runnable
            public final void run() {
                SettingsUpdates$onCreatePreferences$4$1.m8952invoke$lambda0(SettingsUpdates.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m8952invoke$lambda0(SettingsUpdates this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CommonActivity.INSTANCE.showToast(this$0.getActivity(), R.string.no_update_found, 0);
    }
}
