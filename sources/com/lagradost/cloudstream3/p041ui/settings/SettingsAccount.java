package com.lagradost.cloudstream3.p041ui.settings;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.syncproviders.AccountManager;
import com.lagradost.cloudstream3.syncproviders.AuthAPI;
import com.lagradost.cloudstream3.syncproviders.InAppAuthAPI;
import com.lagradost.cloudstream3.utils.Coroutines;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsAccount.kt */
@Metadata(m108d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0003J\u001c\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/settings/SettingsAccount;", "Landroidx/preference/PreferenceFragmentCompat;", "()V", "addAccount", "", "api", "Lcom/lagradost/cloudstream3/syncproviders/AccountManager;", "onCreatePreferences", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "showAccountSwitch", "context", "Landroid/content/Context;", "showLoginInfo", "info", "Lcom/lagradost/cloudstream3/syncproviders/AuthAPI$LoginInfo;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.settings.SettingsAccount */
/* loaded from: classes4.dex */
public final class SettingsAccount extends PreferenceFragmentCompat {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        SettingsFragment.Companion.setUpToolbar(this, R.string.category_account);
    }

    private final void showLoginInfo(final AccountManager accountManager, AuthAPI.LoginInfo loginInfo) {
        TextView textView;
        Context context = getContext();
        if (context == null) {
            return;
        }
        final AlertDialog show = new AlertDialog.Builder(context, R.style.AlertDialogCustom).setView(R.layout.account_managment).show();
        CardView cardView = (CardView) show.findViewById(C4761R.C4764id.account_main_profile_picture_holder);
        if (cardView != null) {
            CardView cardView2 = cardView;
            ImageView imageView = (ImageView) show.findViewById(C4761R.C4764id.account_main_profile_picture);
            boolean z = true;
            cardView2.setVisibility((imageView == null || !UIHelper.setImage$default(UIHelper.INSTANCE, imageView, loginInfo.getProfilePicture(), null, null, 6, null)) ? false : false ? 0 : 8);
        }
        TextView textView2 = (TextView) show.findViewById(C4761R.C4764id.account_logout);
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsAccount$ffEKmvIslkGoH642qab0d0Xcd8Q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SettingsAccount.m8900showLoginInfo$lambda0(AccountManager.this, show, this, view);
                }
            });
        }
        String name = loginInfo.getName();
        if (name == null) {
            Context context2 = getContext();
            name = context2 != null ? context2.getString(R.string.no_data) : null;
        }
        if (name != null && (textView = (TextView) show.findViewById(R.id.account_name)) != null) {
            textView.setText(name);
        }
        TextView textView3 = (TextView) show.findViewById(C4761R.C4764id.account_site);
        if (textView3 != null) {
            textView3.setText(accountManager.getName());
        }
        TextView textView4 = (TextView) show.findViewById(C4761R.C4764id.account_switch_account);
        if (textView4 != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsAccount$L745XfnbMD48bx3XbO2TJa1wY48
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SettingsAccount.m8901showLoginInfo$lambda2(AlertDialog.this, this, accountManager, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showLoginInfo$lambda-0  reason: not valid java name */
    public static final void m8900showLoginInfo$lambda0(AccountManager api, AlertDialog alertDialog, SettingsAccount this$0, View view) {
        Intrinsics.checkNotNullParameter(api, "$api");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        api.logOut();
        UIHelper.INSTANCE.dismissSafe(alertDialog, this$0.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showLoginInfo$lambda-2  reason: not valid java name */
    public static final void m8901showLoginInfo$lambda2(AlertDialog alertDialog, SettingsAccount this$0, AccountManager api, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(api, "$api");
        UIHelper.INSTANCE.dismissSafe(alertDialog, this$0.getActivity());
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        this$0.showAccountSwitch(context, api);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void addAccount(final com.lagradost.cloudstream3.syncproviders.AccountManager r6) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.settings.SettingsAccount.addAccount(com.lagradost.cloudstream3.syncproviders.AccountManager):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addAccount$lambda-3  reason: not valid java name */
    public static final void m8894addAccount$lambda3(AccountManager api, SettingsAccount this$0, View view) {
        Intrinsics.checkNotNullParameter(api, "$api");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(api.getCreateAccountUrl()));
        try {
            this$0.startActivity(intent);
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addAccount$lambda-5  reason: not valid java name */
    public static final void m8895addAccount$lambda5(AccountManager api, AlertDialog alertDialog, SettingsAccount this$0, View view) {
        EditText editText;
        Editable text;
        EditText editText2;
        Editable text2;
        EditText editText3;
        Editable text3;
        EditText editText4;
        Editable text4;
        Intrinsics.checkNotNullParameter(api, "$api");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InAppAuthAPI inAppAuthAPI = (InAppAuthAPI) api;
        Coroutines.INSTANCE.ioSafe(new SettingsAccount$addAccount$3$1(api, new InAppAuthAPI.LoginData((!inAppAuthAPI.getRequiresUsername() || (editText4 = (EditText) alertDialog.findViewById(C4761R.C4764id.login_username_input)) == null || (text4 = editText4.getText()) == null) ? null : text4.toString(), (!inAppAuthAPI.getRequiresPassword() || (editText3 = (EditText) alertDialog.findViewById(C4761R.C4764id.login_password_input)) == null || (text3 = editText3.getText()) == null) ? null : text3.toString(), (!inAppAuthAPI.getRequiresServer() || (editText = (EditText) alertDialog.findViewById(C4761R.C4764id.login_server_input)) == null || (text = editText.getText()) == null) ? null : text.toString(), (!inAppAuthAPI.getRequiresEmail() || (editText2 = (EditText) alertDialog.findViewById(C4761R.C4764id.login_email_input)) == null || (text2 = editText2.getText()) == null) ? null : text2.toString()), this$0, null));
        UIHelper.INSTANCE.dismissSafe(alertDialog, this$0.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addAccount$lambda-6  reason: not valid java name */
    public static final void m8896addAccount$lambda6(AlertDialog alertDialog, SettingsAccount this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UIHelper.INSTANCE.dismissSafe(alertDialog, this$0.getActivity());
    }

    private final void showAccountSwitch(Context context, final AccountManager accountManager) {
        int[] accounts = accountManager.getAccounts();
        if (accounts == null) {
            return;
        }
        final AlertDialog show = new AlertDialog.Builder(context, R.style.AlertDialogCustom).setView(R.layout.account_switch).show();
        TextView textView = (TextView) show.findViewById(C4761R.C4764id.account_add);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsAccount$ZcMAKae0mNYwOOFcWtXu9jlUJK8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SettingsAccount.m8899showAccountSwitch$lambda7(SettingsAccount.this, accountManager, show, view);
                }
            });
        }
        int accountIndex = accountManager.getAccountIndex();
        ArrayList arrayList = new ArrayList();
        for (int i : accounts) {
            accountManager.setAccountIndex(i);
            AuthAPI.LoginInfo loginInfo = accountManager.loginInfo();
            if (loginInfo != null) {
                arrayList.add(loginInfo);
            }
        }
        accountManager.setAccountIndex(accountIndex);
        AccountAdapter accountAdapter = new AccountAdapter(arrayList, R.layout.account_single, new SettingsAccount$showAccountSwitch$adapter$1(show, this, accountManager));
        RecyclerView recyclerView = (RecyclerView) show.findViewById(R.id.account_list);
        if (recyclerView == null) {
            return;
        }
        recyclerView.setAdapter(accountAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showAccountSwitch$lambda-7  reason: not valid java name */
    public static final void m8899showAccountSwitch$lambda7(SettingsAccount this$0, AccountManager api, AlertDialog alertDialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(api, "$api");
        this$0.addAccount(api);
        if (alertDialog != null) {
            UIHelper.INSTANCE.dismissSafe(alertDialog, this$0.getActivity());
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle bundle, String str) {
        UIHelper.INSTANCE.hideKeyboard(this);
        setPreferencesFromResource(R.xml.settings_account, str);
        for (Tuples tuples : CollectionsKt.listOf((Object[]) new Tuples[]{TuplesKt.m100to(Integer.valueOf((int) R.string.mal_key), AccountManager.Companion.getMalApi()), TuplesKt.m100to(Integer.valueOf((int) R.string.anilist_key), AccountManager.Companion.getAniListApi()), TuplesKt.m100to(Integer.valueOf((int) R.string.opensubtitles_key), AccountManager.Companion.getOpenSubtitlesApi()), TuplesKt.m100to(Integer.valueOf((int) R.string.nginx_key), AccountManager.Companion.getNginxApi())})) {
            int intValue = ((Number) tuples.component1()).intValue();
            final AccountManager accountManager = (AccountManager) tuples.component2();
            Preference pref = SettingsFragment.Companion.getPref(this, intValue);
            if (pref != null) {
                String string = getString(R.string.login_format);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.login_format)");
                String format = String.format(string, Arrays.copyOf(new Object[]{accountManager.getName(), getString(R.string.account)}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                pref.setTitle(format);
                pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsAccount$upiNYEctNR8Of_9KRWoK0_neZG4
                    @Override // androidx.preference.Preference.OnPreferenceClickListener
                    public final boolean onPreferenceClick(Preference preference) {
                        boolean m8898onCreatePreferences$lambda9$lambda8;
                        m8898onCreatePreferences$lambda9$lambda8 = SettingsAccount.m8898onCreatePreferences$lambda9$lambda8(AccountManager.this, this, preference);
                        return m8898onCreatePreferences$lambda9$lambda8;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-9$lambda-8  reason: not valid java name */
    public static final boolean m8898onCreatePreferences$lambda9$lambda8(AccountManager api, SettingsAccount this$0, Preference preference) {
        Intrinsics.checkNotNullParameter(api, "$api");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AuthAPI.LoginInfo loginInfo = api.loginInfo();
        if (loginInfo != null) {
            this$0.showLoginInfo(api, loginInfo);
            return true;
        }
        this$0.addAccount(api);
        return true;
    }
}
