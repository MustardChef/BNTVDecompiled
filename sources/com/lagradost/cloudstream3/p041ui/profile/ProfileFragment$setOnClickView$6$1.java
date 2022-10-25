package com.lagradost.cloudstream3.p041ui.profile;

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
/* compiled from: ProfileFragment.kt */
@Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.profile.ProfileFragment$setOnClickView$6$1 */
/* loaded from: classes3.dex */
public final class ProfileFragment$setOnClickView$6$1 extends Lambda implements Functions<Unit> {
    final /* synthetic */ ProfileFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileFragment$setOnClickView$6$1(ProfileFragment profileFragment) {
        super(0);
        this.this$0 = profileFragment;
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
        final ProfileFragment profileFragment = this.this$0;
        activity.runOnUiThread(new Runnable() { // from class: com.lagradost.cloudstream3.ui.profile.-$$Lambda$ProfileFragment$setOnClickView$6$1$mTOZn234__RIQNqNF2Mdg6uIkB4
            @Override // java.lang.Runnable
            public final void run() {
                ProfileFragment$setOnClickView$6$1.m8750invoke$lambda0(ProfileFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m8750invoke$lambda0(ProfileFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CommonActivity.INSTANCE.showToast(this$0.getActivity(), R.string.no_update_found, 0);
    }
}
