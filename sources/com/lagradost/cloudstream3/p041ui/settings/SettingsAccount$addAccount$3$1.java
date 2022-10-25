package com.lagradost.cloudstream3.p041ui.settings;

import androidx.fragment.app.FragmentActivity;
import com.bongngotv2.R;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.syncproviders.AccountManager;
import com.lagradost.cloudstream3.syncproviders.InAppAuthAPI;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsAccount.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.settings.SettingsAccount$addAccount$3$1", m98f = "SettingsAccount.kt", m97i = {}, m96l = {113}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.settings.SettingsAccount$addAccount$3$1 */
/* loaded from: classes4.dex */
public final class SettingsAccount$addAccount$3$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ AccountManager $api;
    final /* synthetic */ InAppAuthAPI.LoginData $loginData;
    int label;
    final /* synthetic */ SettingsAccount this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsAccount$addAccount$3$1(AccountManager accountManager, InAppAuthAPI.LoginData loginData, SettingsAccount settingsAccount, Continuation<? super SettingsAccount$addAccount$3$1> continuation) {
        super(1, continuation);
        this.$api = accountManager;
        this.$loginData = loginData;
        this.this$0 = settingsAccount;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new SettingsAccount$addAccount$3$1(this.$api, this.$loginData, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((SettingsAccount$addAccount$3$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = ((InAppAuthAPI) this.$api).login(this.$loginData, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            z = ((Boolean) obj).booleanValue();
        } catch (Exception e) {
            ArchComponentExt.logError(e);
            z = false;
        }
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            final SettingsAccount settingsAccount = this.this$0;
            final AccountManager accountManager = this.$api;
            activity.runOnUiThread(new Runnable() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsAccount$addAccount$3$1$dLHKQC6WlpVPfu0s1K_yP30LNTw
                @Override // java.lang.Runnable
                public final void run() {
                    SettingsAccount$addAccount$3$1.m8902invokeSuspend$lambda0(SettingsAccount.this, z, accountManager);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final void m8902invokeSuspend$lambda0(SettingsAccount settingsAccount, boolean z, AccountManager accountManager) {
        try {
            CommonActivity commonActivity = CommonActivity.INSTANCE;
            FragmentActivity activity = settingsAccount.getActivity();
            String string = settingsAccount.getString(z ? R.string.authenticated_user : R.string.authenticated_user_fail);
            Intrinsics.checkNotNullExpressionValue(string, "getString(if (isSuccessf….authenticated_user_fail)");
            String format = String.format(string, Arrays.copyOf(new Object[]{accountManager.getName()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            CommonActivity.showToast$default(commonActivity, activity, format, null, 4, null);
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }
}
