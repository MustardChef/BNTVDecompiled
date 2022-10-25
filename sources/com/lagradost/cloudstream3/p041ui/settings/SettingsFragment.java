package com.lagradost.cloudstream3.p041ui.settings;

import android.app.Activity;
import android.app.UiModeManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.material.appbar.MaterialToolbar;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.p041ui.home.HomeFragment;
import com.lagradost.cloudstream3.p041ui.settings.SettingsFragment;
import com.lagradost.cloudstream3.syncproviders.AccountManager;
import com.lagradost.cloudstream3.syncproviders.AuthAPI;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SettingsFragment.kt */
@Metadata(m108d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000f"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/settings/SettingsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", ViewHierarchyConstants.VIEW_KEY, "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.settings.SettingsFragment */
/* loaded from: classes4.dex */
public final class SettingsFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    private static int beneneCount;
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

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    /* compiled from: SettingsFragment.kt */
    @Metadata(m108d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\f\u0010\u0011\u001a\u00020\u0004*\u00020\u0012H\u0002J\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0004J\f\u0010\u0017\u001a\u00020\u0018*\u00020\u0012H\u0002J\n\u0010\u0019\u001a\u00020\u0018*\u00020\u0012J\n\u0010\u001a\u001a\u00020\u0018*\u00020\u0012J\n\u0010\u001b\u001a\u00020\u0018*\u00020\u0012J\u0016\u0010\u001c\u001a\u00020\u000e*\u0004\u0018\u00010\u00152\b\b\u0001\u0010\u001d\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001e"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/settings/SettingsFragment$Companion;", "", "()V", "beneneCount", "", "getBeneneCount", "()I", "setBeneneCount", "(I)V", "getFolderSize", "", "dir", "Ljava/io/File;", "push", "", "activity", "Landroid/app/Activity;", "getLayoutInt", "Landroid/content/Context;", "getPref", "Landroidx/preference/Preference;", "Landroidx/preference/PreferenceFragmentCompat;", "id", "isAutoTv", "", "isEmulatorSettings", "isTrueTvSettings", "isTvSettings", "setUpToolbar", "title", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.settings.SettingsFragment$Companion */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getBeneneCount() {
            return SettingsFragment.beneneCount;
        }

        public final void setBeneneCount(int i) {
            SettingsFragment.beneneCount = i;
        }

        public final void push(Activity activity) {
            UIHelper uIHelper = UIHelper.INSTANCE;
            Bundle bundle = new Bundle();
            Unit unit = Unit.INSTANCE;
            uIHelper.navigate(activity, R.id.global_to_navigation_settings, bundle);
        }

        public final Preference getPref(PreferenceFragmentCompat preferenceFragmentCompat, int i) {
            if (preferenceFragmentCompat == null) {
                return null;
            }
            try {
                return preferenceFragmentCompat.findPreference(preferenceFragmentCompat.getString(i));
            } catch (Exception e) {
                ArchComponentExt.logError(e);
                return null;
            }
        }

        public final void setUpToolbar(final PreferenceFragmentCompat preferenceFragmentCompat, int i) {
            if (preferenceFragmentCompat == null) {
                return;
            }
            View view = preferenceFragmentCompat.getView();
            MaterialToolbar materialToolbar = (MaterialToolbar) (view != null ? view.findViewById(C4761R.C4764id.settings_toolbar) : null);
            if (materialToolbar != null) {
                materialToolbar.setTitle(i);
                materialToolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
                materialToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsFragment$Companion$Wqo_28Is8ZmAeZ1Y2jU05q12rAc
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        SettingsFragment.Companion.m8905setUpToolbar$lambda2$lambda1(PreferenceFragmentCompat.this, view2);
                    }
                });
            }
            UIHelper uIHelper = UIHelper.INSTANCE;
            Context context = preferenceFragmentCompat.getContext();
            View view2 = preferenceFragmentCompat.getView();
            uIHelper.fixPaddingStatusbar(context, (MaterialToolbar) (view2 != null ? view2.findViewById(C4761R.C4764id.settings_toolbar) : null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: setUpToolbar$lambda-2$lambda-1  reason: not valid java name */
        public static final void m8905setUpToolbar$lambda2$lambda1(PreferenceFragmentCompat preferenceFragmentCompat, View view) {
            FragmentActivity activity = preferenceFragmentCompat.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }

        public final long getFolderSize(File dir) {
            long folderSize;
            Intrinsics.checkNotNullParameter(dir, "dir");
            File[] listFiles = dir.listFiles();
            long j = 0;
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (file.isFile()) {
                        folderSize = file.length();
                    } else {
                        Companion companion = SettingsFragment.Companion;
                        Intrinsics.checkNotNullExpressionValue(file, "file");
                        folderSize = companion.getFolderSize(file);
                    }
                    j += folderSize;
                }
            }
            return j;
        }

        private final int getLayoutInt(Context context) {
            return PreferenceManager.getDefaultSharedPreferences(context).getInt(context.getString(R.string.app_layout_key), -1);
        }

        public final boolean isTvSettings(Context context) {
            Intrinsics.checkNotNullParameter(context, "<this>");
            int layoutInt = getLayoutInt(context);
            int i = layoutInt;
            if (layoutInt == -1) {
                i = isAutoTv(context);
            }
            return i == 1 || i == 2;
        }

        public final boolean isTrueTvSettings(Context context) {
            Intrinsics.checkNotNullParameter(context, "<this>");
            int layoutInt = getLayoutInt(context);
            int i = layoutInt;
            if (layoutInt == -1) {
                i = isAutoTv(context);
            }
            return i == 1;
        }

        public final boolean isEmulatorSettings(Context context) {
            Intrinsics.checkNotNullParameter(context, "<this>");
            return getLayoutInt(context) == 2;
        }

        private final boolean isAutoTv(Context context) {
            UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
            String MODEL = Build.MODEL;
            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
            String lowerCase = MODEL.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (uiModeManager != null && uiModeManager.getCurrentModeType() == 4) {
                return true;
            }
            String MODEL2 = Build.MODEL;
            Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
            if (StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "AFT", false, 2, (Object) null)) {
                return true;
            }
            String str = lowerCase;
            return StringsKt.contains$default((CharSequence) str, (CharSequence) "firestick", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "fire tv", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "chromecast", false, 2, (Object) null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.main_settings, viewGroup, false);
    }

    private static final void onViewCreated$navigate(SettingsFragment settingsFragment, int i) {
        FragmentActivity activity = settingsFragment.getActivity();
        if (activity != null) {
            UIHelper.INSTANCE.navigate(activity, i, new Bundle());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String profilePicture;
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = getContext();
        boolean z = context != null && Companion.isTrueTvSettings(context);
        Iterator<AccountManager> it = AccountManager.Companion.getAccountManagers().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AuthAPI.LoginInfo loginInfo = it.next().loginInfo();
            if (loginInfo != null && (profilePicture = loginInfo.getProfilePicture()) != null) {
                ImageView imageView = (ImageView) _$_findCachedViewById(C4761R.C4764id.settings_profile_pic);
                if (imageView != null && UIHelper.setImage$default(UIHelper.INSTANCE, imageView, profilePicture, null, Integer.valueOf(HomeFragment.Companion.getErrorProfilePic()), 2, null)) {
                    TextView textView = (TextView) _$_findCachedViewById(C4761R.C4764id.settings_profile_text);
                    if (textView != null) {
                        textView.setText(loginInfo.getName());
                    }
                    LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C4761R.C4764id.settings_profile);
                    if (linearLayout != null) {
                        linearLayout.setVisibility(0);
                    }
                }
            }
        }
        for (Tuples tuples : CollectionsKt.listOf((Object[]) new Tuples[]{new Tuples((TextView) _$_findCachedViewById(C4761R.C4764id.settings_general), Integer.valueOf((int) R.id.action_navigation_settings_to_navigation_settings_general)), new Tuples((TextView) _$_findCachedViewById(C4761R.C4764id.settings_player), Integer.valueOf((int) R.id.action_navigation_settings_to_navigation_settings_player)), new Tuples((TextView) _$_findCachedViewById(C4761R.C4764id.settings_credits), Integer.valueOf((int) R.id.action_navigation_settings_to_navigation_settings_account)), new Tuples((TextView) _$_findCachedViewById(C4761R.C4764id.settings_ui), Integer.valueOf((int) R.id.action_navigation_settings_to_navigation_settings_ui)), new Tuples((TextView) _$_findCachedViewById(C4761R.C4764id.settings_lang), Integer.valueOf((int) R.id.action_navigation_settings_to_navigation_settings_lang)), new Tuples((TextView) _$_findCachedViewById(C4761R.C4764id.settings_updates), Integer.valueOf((int) R.id.action_navigation_settings_to_navigation_settings_updates))})) {
            TextView view2 = (TextView) tuples.component1();
            final int intValue = ((Number) tuples.component2()).intValue();
            if (view2 != null) {
                Intrinsics.checkNotNullExpressionValue(view2, "view");
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsFragment$lRkBUoJo8MttA4kfvH8-rOq1PNI
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        SettingsFragment.m8904onViewCreated$lambda2$lambda1$lambda0(intValue, this, view3);
                    }
                });
                if (z) {
                    view2.setFocusable(true);
                    view2.setFocusableInTouchMode(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2$lambda-1$lambda-0  reason: not valid java name */
    public static final void m8904onViewCreated$lambda2$lambda1$lambda0(int i, SettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        onViewCreated$navigate(this$0, i);
    }
}
