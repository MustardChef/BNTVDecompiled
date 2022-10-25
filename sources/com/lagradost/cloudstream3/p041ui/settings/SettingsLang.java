package com.lagradost.cloudstream3.p041ui.settings;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.cast.MediaError;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.DubStatus;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.utils.SingleSelectionHelper;
import com.lagradost.cloudstream3.utils.SubtitleHelper;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Tuples;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SettingsLang.kt */
@Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R&\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/settings/SettingsLang;", "Landroidx/preference/PreferenceFragmentCompat;", "()V", "languages", "", "Lkotlin/Triple;", "", "getCurrentLocale", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.settings.SettingsLang */
/* loaded from: classes4.dex */
public final class SettingsLang extends PreferenceFragmentCompat {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final List<Triple<String, String, String>> languages = CollectionsKt.sortedWith(CollectionsKt.arrayListOf(new Triple("", "Spanish", "es"), new Triple("", "English", "en"), new Triple("", "Viet Nam", "vi"), new Triple("", "Dutch", "nl"), new Triple("", "French", "fr"), new Triple("", "Greek", "el"), new Triple("", "Swedish", "sv"), new Triple("", "Tagalog", "tl"), new Triple("", "Polish", "pl"), new Triple("", "Hindi", "hi"), new Triple("", "Malayalam", "ml"), new Triple("", "Norsk", "no"), new Triple("", "German", "de"), new Triple("", "Arabic", "ar"), new Triple("", "Turkish", "tr"), new Triple("", "Macedonian", "mk"), new Triple("🇧🇷", "Portuguese (Brazil)", "pt"), new Triple("", "Romanian", "ro"), new Triple("", "Italian", "it"), new Triple("", "Chinese", "zh"), new Triple("", "Indonesian", "id"), new Triple("", "Czech", "cs")), new Comparator() { // from class: com.lagradost.cloudstream3.ui.settings.SettingsLang$special$$inlined$sortedBy$1
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues((String) ((Triple) t).getSecond(), (String) ((Triple) t2).getSecond());
        }
    });

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

    private final String getCurrentLocale() {
        Locale locale;
        Configuration configuration = requireContext().getResources().getConfiguration();
        String language = (configuration == null || (locale = configuration.locale) == null) ? null : locale.getLanguage();
        return language == null ? "en" : language;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        SettingsFragment.Companion.setUpToolbar(this, R.string.category_preferred_media_and_lang);
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle bundle, String str) {
        UIHelper.INSTANCE.hideKeyboard(this);
        setPreferencesFromResource(R.xml.settings_media_lang, str);
        final SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        SettingsLang settingsLang = this;
        Preference pref = SettingsFragment.Companion.getPref(settingsLang, R.string.display_sub_key);
        if (pref != null) {
            pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsLang$XimvwsyBCF2nU8KsBRRWWYbU9gg
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean m8919onCreatePreferences$lambda3;
                    m8919onCreatePreferences$lambda3 = SettingsLang.m8919onCreatePreferences$lambda3(SettingsLang.this, defaultSharedPreferences, preference);
                    return m8919onCreatePreferences$lambda3;
                }
            });
        }
        Preference pref2 = SettingsFragment.Companion.getPref(settingsLang, R.string.prefer_media_type_key);
        if (pref2 != null) {
            pref2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsLang$EF8QMfZkrpYqYrX4H8ioqIWQqAM
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean m8920onCreatePreferences$lambda4;
                    m8920onCreatePreferences$lambda4 = SettingsLang.m8920onCreatePreferences$lambda4(SettingsLang.this, defaultSharedPreferences, preference);
                    return m8920onCreatePreferences$lambda4;
                }
            });
        }
        Preference pref3 = SettingsFragment.Companion.getPref(settingsLang, R.string.locale_key);
        if (pref3 != null) {
            pref3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsLang$aFf4g7YQHz3wpRa41nO_SxxSUbg
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean m8921onCreatePreferences$lambda8;
                    m8921onCreatePreferences$lambda8 = SettingsLang.m8921onCreatePreferences$lambda8(SettingsLang.this, defaultSharedPreferences, preference);
                    return m8921onCreatePreferences$lambda8;
                }
            });
        }
        Preference pref4 = SettingsFragment.Companion.getPref(settingsLang, R.string.provider_lang_key);
        if (pref4 != null) {
            pref4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsLang$Rir4mOxTpzOOLSSQ32UWvGSzhyI
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean m8918onCreatePreferences$lambda12;
                    m8918onCreatePreferences$lambda12 = SettingsLang.m8918onCreatePreferences$lambda12(SettingsLang.this, defaultSharedPreferences, preference);
                    return m8918onCreatePreferences$lambda12;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-3  reason: not valid java name */
    public static final boolean m8919onCreatePreferences$lambda3(SettingsLang this$0, SharedPreferences sharedPreferences, Preference preference) {
        HashSet<DubStatus> apiDubstatusSettings;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null || (apiDubstatusSettings = APIHolder.INSTANCE.getApiDubstatusSettings(activity)) == null) {
            return true;
        }
        DubStatus[] values = DubStatus.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (DubStatus dubStatus : values) {
            arrayList.add(dubStatus.name());
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        Iterator<DubStatus> it = apiDubstatusSettings.iterator();
        while (it.hasNext()) {
            DubStatus i = it.next();
            Intrinsics.checkNotNullExpressionValue(i, "i");
            arrayList3.add(Integer.valueOf(ArraysKt.indexOf(values, i)));
        }
        FragmentActivity activity2 = this$0.getActivity();
        if (activity2 != null) {
            String string = this$0.getString(R.string.display_subbed_dubbed_settings);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.display_subbed_dubbed_settings)");
            SingleSelectionHelper.INSTANCE.showMultiDialog(activity2, arrayList2, arrayList3, string, SettingsLang$onCreatePreferences$1$1$1.INSTANCE, new SettingsLang$onCreatePreferences$1$1$2(sharedPreferences, this$0, values, arrayList2));
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-4  reason: not valid java name */
    public static final boolean m8920onCreatePreferences$lambda4(SettingsLang this$0, SharedPreferences sharedPreferences, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String[] stringArray = this$0.getResources().getStringArray(R.array.media_type_pref);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray(R.array.media_type_pref)");
        int[] intArray = this$0.getResources().getIntArray(R.array.media_type_pref_values);
        Intrinsics.checkNotNullExpressionValue(intArray, "resources.getIntArray(R.…y.media_type_pref_values)");
        int i = sharedPreferences.getInt(this$0.getString(R.string.prefer_media_type_key), 0);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            List<String> list = ArraysKt.toList(stringArray);
            int indexOf = ArraysKt.indexOf(intArray, i);
            String string = this$0.getString(R.string.preferred_media_settings);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.preferred_media_settings)");
            SingleSelectionHelper.INSTANCE.showBottomDialog(activity, list, indexOf, string, true, SettingsLang$onCreatePreferences$2$1.INSTANCE, new SettingsLang$onCreatePreferences$2$2(sharedPreferences, this$0, intArray));
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-8  reason: not valid java name */
    public static final boolean m8921onCreatePreferences$lambda8(SettingsLang this$0, SharedPreferences sharedPreferences, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List mutableList = CollectionsKt.toMutableList((Collection) this$0.languages);
        String currentLocale = this$0.getCurrentLocale();
        List<Triple> list = mutableList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Triple triple : list) {
            arrayList.add((String) triple.getThird());
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Triple triple2 : list) {
            String str = (String) triple2.component2();
            String str2 = (String) triple2.component3();
            String str3 = (String) triple2.component1();
            if (StringsKt.isBlank(str3)) {
                String flagFromIso = SubtitleHelper.INSTANCE.getFlagFromIso(str2);
                if (flagFromIso == null) {
                    flagFromIso = MediaError.ERROR_TYPE_ERROR;
                }
                str3 = flagFromIso;
            }
            arrayList3.add(str3 + ' ' + str);
        }
        ArrayList arrayList4 = arrayList3;
        int indexOf = arrayList2.indexOf(currentLocale);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            String string = this$0.getString(R.string.app_language);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.app_language)");
            SingleSelectionHelper.INSTANCE.showDialog(activity, arrayList4, indexOf, string, true, SettingsLang$onCreatePreferences$3$1.INSTANCE, new SettingsLang$onCreatePreferences$3$2(arrayList2, this$0, sharedPreferences));
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-12  reason: not valid java name */
    public static final boolean m8918onCreatePreferences$lambda12(SettingsLang this$0, SharedPreferences sharedPreferences, Preference preference) {
        HashSet<String> apiProviderLangSettings;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null || (apiProviderLangSettings = APIHolder.INSTANCE.getApiProviderLangSettings(activity)) == null) {
            return true;
        }
        HashSet hashSet = new HashSet();
        for (MainAPI mainAPI : APIHolder.INSTANCE.getApis()) {
            hashSet.add(mainAPI.getLang());
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = apiProviderLangSettings.iterator();
        while (it.hasNext()) {
            String i = it.next();
            Intrinsics.checkNotNullExpressionValue(i, "i");
            arrayList.add(Integer.valueOf(CollectionsKt.indexOf(hashSet, i)));
        }
        HashSet<String> hashSet2 = hashSet;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(hashSet2, 10));
        for (String str : hashSet2) {
            String flagFromIso = SubtitleHelper.INSTANCE.getFlagFromIso(str);
            String fromTwoLettersToLanguage = SubtitleHelper.INSTANCE.fromTwoLettersToLanguage(str);
            arrayList2.add(new Tuples(str, flagFromIso + ' ' + fromTwoLettersToLanguage));
        }
        ArrayList arrayList3 = arrayList2;
        FragmentActivity activity2 = this$0.getActivity();
        if (activity2 != null) {
            SingleSelectionHelper singleSelectionHelper = SingleSelectionHelper.INSTANCE;
            FragmentActivity fragmentActivity = activity2;
            ArrayList<Tuples> arrayList4 = arrayList3;
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
            for (Tuples tuples : arrayList4) {
                arrayList5.add((String) tuples.getSecond());
            }
            String string = this$0.getString(R.string.provider_lang_settings);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.provider_lang_settings)");
            singleSelectionHelper.showMultiDialog(fragmentActivity, arrayList5, arrayList, string, SettingsLang$onCreatePreferences$4$1$2.INSTANCE, new SettingsLang$onCreatePreferences$4$1$3(sharedPreferences, this$0, arrayList3));
            return true;
        }
        return true;
    }
}
