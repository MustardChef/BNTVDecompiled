package com.lagradost.cloudstream3.p041ui.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.lagradost.cloudstream3.utils.SingleSelectionHelper;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsUI.kt */
@Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\f"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/settings/SettingsUI;", "Landroidx/preference/PreferenceFragmentCompat;", "()V", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.settings.SettingsUI */
/* loaded from: classes4.dex */
public final class SettingsUI extends PreferenceFragmentCompat {
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
        SettingsFragment.Companion.setUpToolbar(this, R.string.category_ui);
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle bundle, String str) {
        UIHelper.INSTANCE.hideKeyboard(this);
        setPreferencesFromResource(R.xml.settins_ui, str);
        final SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        SettingsUI settingsUI = this;
        Preference pref = SettingsFragment.Companion.getPref(settingsUI, R.string.poster_ui_key);
        if (pref != null) {
            pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsUI$voEzFzz65rtBbGkjr_P-4GXEHrs
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean m8935onCreatePreferences$lambda2;
                    m8935onCreatePreferences$lambda2 = SettingsUI.m8935onCreatePreferences$lambda2(SettingsUI.this, defaultSharedPreferences, preference);
                    return m8935onCreatePreferences$lambda2;
                }
            });
        }
        Preference pref2 = SettingsFragment.Companion.getPref(settingsUI, R.string.app_layout_key);
        if (pref2 != null) {
            pref2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsUI$8FqnSbqctDZv2CPtqGjWp_H1Stc
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean m8936onCreatePreferences$lambda3;
                    m8936onCreatePreferences$lambda3 = SettingsUI.m8936onCreatePreferences$lambda3(SettingsUI.this, defaultSharedPreferences, preference);
                    return m8936onCreatePreferences$lambda3;
                }
            });
        }
        Preference pref3 = SettingsFragment.Companion.getPref(settingsUI, R.string.app_theme_key);
        if (pref3 != null) {
            pref3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsUI$NcqQM64WzWxt0xGGxkLmem02dEE
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean m8937onCreatePreferences$lambda4;
                    m8937onCreatePreferences$lambda4 = SettingsUI.m8937onCreatePreferences$lambda4(SettingsUI.this, defaultSharedPreferences, preference);
                    return m8937onCreatePreferences$lambda4;
                }
            });
        }
        Preference pref4 = SettingsFragment.Companion.getPref(settingsUI, R.string.primary_color_key);
        if (pref4 != null) {
            pref4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsUI$HIcNBM4WW0Yb4vDKQ1Tv1uJAVC8
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean m8938onCreatePreferences$lambda5;
                    m8938onCreatePreferences$lambda5 = SettingsUI.m8938onCreatePreferences$lambda5(SettingsUI.this, defaultSharedPreferences, preference);
                    return m8938onCreatePreferences$lambda5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-2  reason: not valid java name */
    public static final boolean m8935onCreatePreferences$lambda2(SettingsUI this$0, SharedPreferences sharedPreferences, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String[] stringArray = this$0.getResources().getStringArray(R.array.poster_ui_options);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray….array.poster_ui_options)");
        String[] stringArray2 = this$0.getResources().getStringArray(R.array.poster_ui_options_values);
        Intrinsics.checkNotNullExpressionValue(stringArray2, "resources.getStringArray…poster_ui_options_values)");
        ArrayList arrayList = new ArrayList(stringArray2.length);
        int i = 0;
        for (String str : stringArray2) {
            arrayList.add(Boolean.valueOf(sharedPreferences.getBoolean(str, true)));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Integer valueOf = ((Boolean) obj).booleanValue() ? Integer.valueOf(i) : null;
            if (valueOf != null) {
                arrayList2.add(valueOf);
            }
            i = i2;
        }
        ArrayList arrayList3 = arrayList2;
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            List<String> list = ArraysKt.toList(stringArray);
            String string = this$0.getString(R.string.poster_ui_settings);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.poster_ui_settings)");
            SingleSelectionHelper.INSTANCE.showMultiDialog(activity, list, arrayList3, string, SettingsUI$onCreatePreferences$1$1.INSTANCE, new SettingsUI$onCreatePreferences$1$2(sharedPreferences, stringArray2, preference));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-3  reason: not valid java name */
    public static final boolean m8936onCreatePreferences$lambda3(SettingsUI this$0, SharedPreferences sharedPreferences, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String[] stringArray = this$0.getResources().getStringArray(R.array.app_layout);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray(R.array.app_layout)");
        int[] intArray = this$0.getResources().getIntArray(R.array.app_layout_values);
        Intrinsics.checkNotNullExpressionValue(intArray, "resources.getIntArray(R.array.app_layout_values)");
        int i = sharedPreferences.getInt(this$0.getString(R.string.app_layout_key), -1);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            List<String> list = ArraysKt.toList(stringArray);
            int indexOf = ArraysKt.indexOf(intArray, i);
            String string = this$0.getString(R.string.app_layout);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.app_layout)");
            SingleSelectionHelper.INSTANCE.showBottomDialog(activity, list, indexOf, string, true, SettingsUI$onCreatePreferences$2$1.INSTANCE, new SettingsUI$onCreatePreferences$2$2(sharedPreferences, this$0, intArray));
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-4  reason: not valid java name */
    public static final boolean m8937onCreatePreferences$lambda4(SettingsUI this$0, SharedPreferences sharedPreferences, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String[] stringArray = this$0.getResources().getStringArray(R.array.themes_names);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray(R.array.themes_names)");
        String[] stringArray2 = this$0.getResources().getStringArray(R.array.themes_names_values);
        Intrinsics.checkNotNullExpressionValue(stringArray2, "resources.getStringArray…rray.themes_names_values)");
        String string = sharedPreferences.getString(this$0.getString(R.string.app_theme_key), (String) ArraysKt.first(stringArray2));
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            List<String> list = ArraysKt.toList(stringArray);
            int indexOf = ArraysKt.indexOf(stringArray2, string);
            String string2 = this$0.getString(R.string.app_theme_settings);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.app_theme_settings)");
            SingleSelectionHelper.INSTANCE.showBottomDialog(activity, list, indexOf, string2, true, SettingsUI$onCreatePreferences$3$1.INSTANCE, new SettingsUI$onCreatePreferences$3$2(sharedPreferences, this$0, stringArray2));
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-5  reason: not valid java name */
    public static final boolean m8938onCreatePreferences$lambda5(SettingsUI this$0, SharedPreferences sharedPreferences, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String[] stringArray = this$0.getResources().getStringArray(R.array.themes_overlay_names);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray…ray.themes_overlay_names)");
        String[] stringArray2 = this$0.getResources().getStringArray(R.array.themes_overlay_names_values);
        Intrinsics.checkNotNullExpressionValue(stringArray2, "resources.getStringArray…mes_overlay_names_values)");
        String string = sharedPreferences.getString(this$0.getString(R.string.primary_color_key), (String) ArraysKt.first(stringArray2));
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            List<String> list = ArraysKt.toList(stringArray);
            int indexOf = ArraysKt.indexOf(stringArray2, string);
            String string2 = this$0.getString(R.string.primary_color_settings);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.primary_color_settings)");
            SingleSelectionHelper.INSTANCE.showDialog(activity, list, indexOf, string2, true, SettingsUI$onCreatePreferences$4$1.INSTANCE, new SettingsUI$onCreatePreferences$4$2(sharedPreferences, this$0, stringArray2));
            return true;
        }
        return true;
    }
}
