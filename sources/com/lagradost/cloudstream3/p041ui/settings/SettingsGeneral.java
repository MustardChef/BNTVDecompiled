package com.lagradost.cloudstream3.p041ui.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hippo.unifile.UniFile;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.AcraApplication;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.p041ui.settings.SettingsFragment;
import com.lagradost.cloudstream3.utils.DataStore;
import com.lagradost.cloudstream3.utils.DataStoreKt;
import com.lagradost.cloudstream3.utils.SingleSelectionHelper;
import com.lagradost.cloudstream3.utils.UIHelper;
import com.lagradost.cloudstream3.utils.VideoDownloadManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsGeneral.kt */
@Metadata(m108d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/settings/SettingsGeneral;", "Landroidx/preference/PreferenceFragmentCompat;", "()V", "pathPicker", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/net/Uri;", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "CustomSite", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.settings.SettingsGeneral */
/* loaded from: classes4.dex */
public final class SettingsGeneral extends PreferenceFragmentCompat {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final ActivityResultLauncher<Uri> pathPicker;

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

    public SettingsGeneral() {
        ActivityResultLauncher<Uri> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.OpenDocumentTree(), new ActivityResultCallback() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsGeneral$8FMX6Ki1qpQHoVxwfvTmzo0N7CI
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                SettingsGeneral.m8915pathPicker$lambda1(SettingsGeneral.this, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul…)\n            }\n        }");
        this.pathPicker = registerForActivityResult;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        SettingsFragment.Companion.setUpToolbar(this, R.string.category_general);
    }

    /* compiled from: SettingsGeneral.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/settings/SettingsGeneral$CustomSite;", "", "parentJavaClass", "", "name", "url", "lang", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLang", "()Ljava/lang/String;", "getName", "getParentJavaClass", "getUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.settings.SettingsGeneral$CustomSite */
    /* loaded from: classes4.dex */
    public static final class CustomSite {
        private final String lang;
        private final String name;
        private final String parentJavaClass;
        private final String url;

        public static /* synthetic */ CustomSite copy$default(CustomSite customSite, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = customSite.parentJavaClass;
            }
            if ((i & 2) != 0) {
                str2 = customSite.name;
            }
            if ((i & 4) != 0) {
                str3 = customSite.url;
            }
            if ((i & 8) != 0) {
                str4 = customSite.lang;
            }
            return customSite.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return this.parentJavaClass;
        }

        public final String component2() {
            return this.name;
        }

        public final String component3() {
            return this.url;
        }

        public final String component4() {
            return this.lang;
        }

        public final CustomSite copy(@JsonProperty("parentJavaClass") String parentJavaClass, @JsonProperty("name") String name, @JsonProperty("url") String url, @JsonProperty("lang") String lang) {
            Intrinsics.checkNotNullParameter(parentJavaClass, "parentJavaClass");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(lang, "lang");
            return new CustomSite(parentJavaClass, name, url, lang);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CustomSite) {
                CustomSite customSite = (CustomSite) obj;
                return Intrinsics.areEqual(this.parentJavaClass, customSite.parentJavaClass) && Intrinsics.areEqual(this.name, customSite.name) && Intrinsics.areEqual(this.url, customSite.url) && Intrinsics.areEqual(this.lang, customSite.lang);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.parentJavaClass.hashCode() * 31) + this.name.hashCode()) * 31) + this.url.hashCode()) * 31) + this.lang.hashCode();
        }

        public String toString() {
            return "CustomSite(parentJavaClass=" + this.parentJavaClass + ", name=" + this.name + ", url=" + this.url + ", lang=" + this.lang + ')';
        }

        public CustomSite(@JsonProperty("parentJavaClass") String parentJavaClass, @JsonProperty("name") String name, @JsonProperty("url") String url, @JsonProperty("lang") String lang) {
            Intrinsics.checkNotNullParameter(parentJavaClass, "parentJavaClass");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(lang, "lang");
            this.parentJavaClass = parentJavaClass;
            this.name = name;
            this.url = url;
            this.lang = lang;
        }

        public final String getParentJavaClass() {
            return this.parentJavaClass;
        }

        public final String getName() {
            return this.name;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getLang() {
            return this.lang;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: pathPicker$lambda-1  reason: not valid java name */
    public static final void m8915pathPicker$lambda1(SettingsGeneral this$0, Uri uri) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (uri == null) {
            return;
        }
        Context context = this$0.getContext();
        if (context == null && (context = AcraApplication.Companion.getContext()) == null) {
            return;
        }
        context.getContentResolver().takePersistableUriPermission(uri, 3);
        UniFile fromUri = UniFile.fromUri(context, uri);
        System.out.println((Object) ("Selected URI path: " + uri + " - Full path: " + fromUri.getFilePath()));
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(this$0.getString(R.string.download_path_key), uri.toString()).apply();
        String filePath = fromUri.getFilePath();
        if (filePath == null) {
            filePath = uri.toString();
        }
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(this$0.getString(R.string.download_path_pref), filePath).apply();
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle bundle, String str) {
        String str2;
        UIHelper.INSTANCE.hideKeyboard(this);
        setPreferencesFromResource(R.xml.settins_general, str);
        final SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        SettingsGeneral settingsGeneral = this;
        Preference pref = SettingsFragment.Companion.getPref(settingsGeneral, R.string.override_site_key);
        if (pref != null) {
            pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsGeneral$NY6C_sviY8GpDh_eLOkPjcXMwIM
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean m8911onCreatePreferences$lambda8;
                    m8911onCreatePreferences$lambda8 = SettingsGeneral.m8911onCreatePreferences$lambda8(SettingsGeneral.this, preference);
                    return m8911onCreatePreferences$lambda8;
                }
            });
        }
        Preference pref2 = SettingsFragment.Companion.getPref(settingsGeneral, R.string.legal_notice_key);
        if (pref2 != null) {
            pref2.setOnPreferenceClickListener($$Lambda$SettingsGeneral$FYlCQVujJ8iEr7ZEFy64GbqALbY.INSTANCE);
        }
        Preference pref3 = SettingsFragment.Companion.getPref(settingsGeneral, R.string.dns_key);
        if (pref3 != null) {
            pref3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsGeneral$UOHRGNhbwPrt7UfmUGnAhY4PO0Q
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean m8908onCreatePreferences$lambda10;
                    m8908onCreatePreferences$lambda10 = SettingsGeneral.m8908onCreatePreferences$lambda10(SettingsGeneral.this, defaultSharedPreferences, preference);
                    return m8908onCreatePreferences$lambda10;
                }
            });
        }
        Preference pref4 = SettingsFragment.Companion.getPref(settingsGeneral, R.string.download_path_key);
        if (pref4 != null) {
            pref4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsGeneral$ExgAbz2aUWv-XY_MME4RucdN_88
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean m8909onCreatePreferences$lambda11;
                    m8909onCreatePreferences$lambda11 = SettingsGeneral.m8909onCreatePreferences$lambda11(defaultSharedPreferences, this, preference);
                    return m8909onCreatePreferences$lambda11;
                }
            });
        }
        try {
            SettingsFragment.Companion.setBeneneCount(defaultSharedPreferences.getInt(getString(R.string.benene_count), 0));
            Preference pref5 = SettingsFragment.Companion.getPref(this, R.string.benene_count);
            if (pref5 != null) {
                if (SettingsFragment.Companion.getBeneneCount() <= 0) {
                    str2 = getString(R.string.benene_count_text_none);
                } else {
                    String string = getString(R.string.benene_count_text);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(\n             …ext\n                    )");
                    String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(SettingsFragment.Companion.getBeneneCount())}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                    str2 = format;
                }
                pref5.setSummary(str2);
                pref5.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsGeneral$FLfAlXn3jhfkigb2guBMG18tvcg
                    @Override // androidx.preference.Preference.OnPreferenceClickListener
                    public final boolean onPreferenceClick(Preference preference) {
                        boolean m8910onCreatePreferences$lambda13$lambda12;
                        m8910onCreatePreferences$lambda13$lambda12 = SettingsGeneral.m8910onCreatePreferences$lambda13$lambda12(defaultSharedPreferences, this, preference);
                        return m8910onCreatePreferences$lambda13$lambda12;
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<CustomSite> onCreatePreferences$getCurrent() {
        List<CustomSite> mutableList;
        Context context = AcraApplication.Companion.getContext();
        Object obj = null;
        if (context != null) {
            DataStore dataStore = DataStore.INSTANCE;
            try {
                String string = dataStore.getSharedPrefs(context).getString(DataStoreKt.USER_PROVIDER_API, null);
                if (string != null) {
                    Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                    Object readValue = dataStore.getMapper().readValue(string, CustomSite[].class);
                    Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                    obj = readValue;
                }
            } catch (Exception unused) {
            }
        }
        CustomSite[] customSiteArr = (CustomSite[]) obj;
        return (customSiteArr == null || (mutableList = ArraysKt.toMutableList(customSiteArr)) == null) ? new ArrayList() : mutableList;
    }

    private static final void onCreatePreferences$showAdd(SettingsGeneral settingsGeneral) {
        String string;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : APIHolder.INSTANCE.getAllProviders()) {
            if (hashSet.add(((MainAPI) obj).getClass())) {
                arrayList.add(obj);
            }
        }
        List sortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.lagradost.cloudstream3.ui.settings.SettingsGeneral$onCreatePreferences$showAdd$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((MainAPI) t).getName(), ((MainAPI) t2).getName());
            }
        });
        FragmentActivity activity = settingsGeneral.getActivity();
        if (activity != null) {
            SingleSelectionHelper singleSelectionHelper = SingleSelectionHelper.INSTANCE;
            FragmentActivity fragmentActivity = activity;
            List<MainAPI> list = sortedWith;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (MainAPI mainAPI : list) {
                arrayList2.add(mainAPI.getName() + " (" + mainAPI.getMainUrl() + ')');
            }
            ArrayList arrayList3 = arrayList2;
            Context context = settingsGeneral.getContext();
            if (context == null || (string = context.getString(R.string.add_site_pref)) == null) {
                return;
            }
            singleSelectionHelper.showDialog(fragmentActivity, arrayList3, -1, string, true, SettingsGeneral$onCreatePreferences$showAdd$2.INSTANCE, new SettingsGeneral$onCreatePreferences$showAdd$3(sortedWith, settingsGeneral));
        }
    }

    private static final void onCreatePreferences$showDelete(SettingsGeneral settingsGeneral) {
        String string;
        List<CustomSite> onCreatePreferences$getCurrent = onCreatePreferences$getCurrent();
        FragmentActivity activity = settingsGeneral.getActivity();
        if (activity != null) {
            SingleSelectionHelper singleSelectionHelper = SingleSelectionHelper.INSTANCE;
            FragmentActivity fragmentActivity = activity;
            List<CustomSite> list = onCreatePreferences$getCurrent;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (CustomSite customSite : list) {
                arrayList.add(customSite.getName());
            }
            ArrayList arrayList2 = arrayList;
            List<Integer> emptyList = CollectionsKt.emptyList();
            Context context = settingsGeneral.getContext();
            if (context == null || (string = context.getString(R.string.remove_site_pref)) == null) {
                return;
            }
            singleSelectionHelper.showMultiDialog(fragmentActivity, arrayList2, emptyList, string, SettingsGeneral$onCreatePreferences$showDelete$2.INSTANCE, new SettingsGeneral$onCreatePreferences$showDelete$3(onCreatePreferences$getCurrent));
        }
    }

    private static final void onCreatePreferences$showAddOrDelete(final SettingsGeneral settingsGeneral) {
        Context context = settingsGeneral.getContext();
        if (context == null) {
            return;
        }
        final AlertDialog create = new AlertDialog.Builder(context, R.style.AlertDialogCustom).setView(R.layout.add_remove_sites).create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
        TextView textView = (TextView) create.findViewById(C4761R.C4764id.add_site);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsGeneral$syIZAQKT53HnKrkZib2-UWr00Es
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SettingsGeneral.m8913onCreatePreferences$showAddOrDelete$lambda6(AlertDialog.this, settingsGeneral, view);
                }
            });
        }
        TextView textView2 = (TextView) create.findViewById(C4761R.C4764id.remove_site);
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsGeneral$3MTZiwWX_jHntMuDygEcUUR2qWU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SettingsGeneral.m8914onCreatePreferences$showAddOrDelete$lambda7(AlertDialog.this, settingsGeneral, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$showAddOrDelete$lambda-6  reason: not valid java name */
    public static final void m8913onCreatePreferences$showAddOrDelete$lambda6(AlertDialog dialog, SettingsGeneral this$0, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        onCreatePreferences$showAdd(this$0);
        UIHelper.INSTANCE.dismissSafe(dialog, this$0.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$showAddOrDelete$lambda-7  reason: not valid java name */
    public static final void m8914onCreatePreferences$showAddOrDelete$lambda7(AlertDialog dialog, SettingsGeneral this$0, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        onCreatePreferences$showDelete(this$0);
        UIHelper.INSTANCE.dismissSafe(dialog, this$0.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-8  reason: not valid java name */
    public static final boolean m8911onCreatePreferences$lambda8(SettingsGeneral this$0, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (onCreatePreferences$getCurrent().isEmpty()) {
            onCreatePreferences$showAdd(this$0);
            return true;
        }
        onCreatePreferences$showAddOrDelete(this$0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-9  reason: not valid java name */
    public static final boolean m8912onCreatePreferences$lambda9(Preference preference) {
        AlertDialog.Builder builder = new AlertDialog.Builder(preference.getContext(), R.style.AlertDialogCustom);
        builder.setTitle(R.string.legal_notice);
        builder.setMessage(R.string.legal_notice_text);
        builder.show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-10  reason: not valid java name */
    public static final boolean m8908onCreatePreferences$lambda10(SettingsGeneral this$0, SharedPreferences sharedPreferences, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String[] stringArray = this$0.getResources().getStringArray(R.array.dns_pref);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray(R.array.dns_pref)");
        int[] intArray = this$0.getResources().getIntArray(R.array.dns_pref_values);
        Intrinsics.checkNotNullExpressionValue(intArray, "resources.getIntArray(R.array.dns_pref_values)");
        int i = sharedPreferences.getInt(this$0.getString(R.string.dns_pref), 0);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            List<String> list = ArraysKt.toList(stringArray);
            int indexOf = ArraysKt.indexOf(intArray, i);
            String string = this$0.getString(R.string.dns_pref);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.dns_pref)");
            SingleSelectionHelper.INSTANCE.showBottomDialog(activity, list, indexOf, string, true, SettingsGeneral$onCreatePreferences$3$1.INSTANCE, new SettingsGeneral$onCreatePreferences$3$2(sharedPreferences, this$0, intArray));
            return true;
        }
        return true;
    }

    private static final List<String> onCreatePreferences$getDownloadDirs(SettingsGeneral settingsGeneral) {
        List<String> list = (List) ArchComponentExt.normalSafeApiCall(new SettingsGeneral$onCreatePreferences$getDownloadDirs$1(settingsGeneral));
        return list == null ? CollectionsKt.emptyList() : list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-11  reason: not valid java name */
    public static final boolean m8909onCreatePreferences$lambda11(SharedPreferences sharedPreferences, SettingsGeneral this$0, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<String> onCreatePreferences$getDownloadDirs = onCreatePreferences$getDownloadDirs(this$0);
        String string = sharedPreferences.getString(this$0.getString(R.string.download_path_pref), null);
        if (string == null) {
            string = String.valueOf(VideoDownloadManager.INSTANCE.getDownloadDir());
        }
        Intrinsics.checkNotNullExpressionValue(string, "settingsManager.getStrin…tDownloadDir().toString()");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            List<String> plus = CollectionsKt.plus((Collection) onCreatePreferences$getDownloadDirs, (Iterable) CollectionsKt.listOf(TypedValues.Custom.NAME));
            int indexOf = onCreatePreferences$getDownloadDirs.indexOf(string);
            String string2 = this$0.getString(R.string.download_path_pref);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.download_path_pref)");
            SingleSelectionHelper.INSTANCE.showBottomDialog(activity, plus, indexOf, string2, true, SettingsGeneral$onCreatePreferences$4$1.INSTANCE, new SettingsGeneral$onCreatePreferences$4$2(onCreatePreferences$getDownloadDirs, this$0, sharedPreferences));
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-13$lambda-12  reason: not valid java name */
    public static final boolean m8910onCreatePreferences$lambda13$lambda12(SharedPreferences sharedPreferences, SettingsGeneral this$0, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            SettingsFragment.Companion companion = SettingsFragment.Companion;
            companion.setBeneneCount(companion.getBeneneCount() + 1);
            sharedPreferences.edit().putInt(this$0.getString(R.string.benene_count), SettingsFragment.Companion.getBeneneCount()).apply();
            String string = this$0.getString(R.string.benene_count_text);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.benene_count_text)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(SettingsFragment.Companion.getBeneneCount())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            preference.setSummary(format);
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
        return true;
    }
}
