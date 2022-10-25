package com.lagradost.cloudstream3.p041ui.settings;

import androidx.appcompat.app.AlertDialog;
import com.lagradost.cloudstream3.syncproviders.AccountManager;
import com.lagradost.cloudstream3.utils.UIHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: SettingsAccount.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "Lcom/lagradost/cloudstream3/ui/settings/AccountClickCallback;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.settings.SettingsAccount$showAccountSwitch$adapter$1 */
/* loaded from: classes4.dex */
final class SettingsAccount$showAccountSwitch$adapter$1 extends Lambda implements Function1<AccountClickCallback, Unit> {
    final /* synthetic */ AccountManager $api;
    final /* synthetic */ AlertDialog $dialog;
    final /* synthetic */ SettingsAccount this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsAccount$showAccountSwitch$adapter$1(AlertDialog alertDialog, SettingsAccount settingsAccount, AccountManager accountManager) {
        super(1);
        this.$dialog = alertDialog;
        this.this$0 = settingsAccount;
        this.$api = accountManager;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AccountClickCallback accountClickCallback) {
        invoke2(accountClickCallback);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(AccountClickCallback it) {
        Intrinsics.checkNotNullParameter(it, "it");
        AlertDialog alertDialog = this.$dialog;
        if (alertDialog != null) {
            UIHelper.INSTANCE.dismissSafe(alertDialog, this.this$0.getActivity());
        }
        this.$api.changeAccount(it.getCard().getAccountIndex());
    }
}
