package com.lagradost.cloudstream3.p041ui.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.p002v4.media.session.PlaybackStateCompat;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.p041ui.subtitles.ChromecastSubtitlesFragment;
import com.lagradost.cloudstream3.p041ui.subtitles.SubtitlesFragment;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.cloudstream3.utils.SingleSelectionHelper;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p043io.FilesKt;

/* compiled from: SettingsPlayer.kt */
@Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\f"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/settings/SettingsPlayer;", "Landroidx/preference/PreferenceFragmentCompat;", "()V", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.settings.SettingsPlayer */
/* loaded from: classes4.dex */
public final class SettingsPlayer extends PreferenceFragmentCompat {
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
        SettingsFragment.Companion.setUpToolbar(this, R.string.category_player);
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle bundle, String str) {
        UIHelper.INSTANCE.hideKeyboard(this);
        setPreferencesFromResource(R.xml.settings_player, str);
        final SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        SettingsPlayer settingsPlayer = this;
        Preference pref = SettingsFragment.Companion.getPref(settingsPlayer, R.string.video_buffer_length_key);
        if (pref != null) {
            pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsPlayer$U_a0GWwN13U6QVBPIojHCsUTaoE
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean m8924onCreatePreferences$lambda0;
                    m8924onCreatePreferences$lambda0 = SettingsPlayer.m8924onCreatePreferences$lambda0(SettingsPlayer.this, defaultSharedPreferences, preference);
                    return m8924onCreatePreferences$lambda0;
                }
            });
        }
        Preference pref2 = SettingsFragment.Companion.getPref(settingsPlayer, R.string.prefer_limit_title_key);
        if (pref2 != null) {
            pref2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsPlayer$yPwRv-7bhDVLu7iojeE2w5w9jUc
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean m8925onCreatePreferences$lambda1;
                    m8925onCreatePreferences$lambda1 = SettingsPlayer.m8925onCreatePreferences$lambda1(SettingsPlayer.this, defaultSharedPreferences, preference);
                    return m8925onCreatePreferences$lambda1;
                }
            });
        }
        Preference pref3 = SettingsFragment.Companion.getPref(settingsPlayer, R.string.prefer_limit_title_rez_key);
        if (pref3 != null) {
            pref3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsPlayer$HL4W_cV4ZBrf6SP2y3YQOME0iXA
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean m8928onCreatePreferences$lambda2;
                    m8928onCreatePreferences$lambda2 = SettingsPlayer.m8928onCreatePreferences$lambda2(SettingsPlayer.this, defaultSharedPreferences, preference);
                    return m8928onCreatePreferences$lambda2;
                }
            });
        }
        Preference pref4 = SettingsFragment.Companion.getPref(settingsPlayer, R.string.quality_pref_key);
        if (pref4 != null) {
            pref4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsPlayer$32gRM30kYFXjgY6HcLmya9bBBIw
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean m8929onCreatePreferences$lambda5;
                    m8929onCreatePreferences$lambda5 = SettingsPlayer.m8929onCreatePreferences$lambda5(defaultSharedPreferences, this, preference);
                    return m8929onCreatePreferences$lambda5;
                }
            });
        }
        Preference pref5 = SettingsFragment.Companion.getPref(settingsPlayer, R.string.subtitle_settings_key);
        if (pref5 != null) {
            pref5.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsPlayer$xi163W_nBPJikYGwIhfxo3gVizk
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean m8930onCreatePreferences$lambda6;
                    m8930onCreatePreferences$lambda6 = SettingsPlayer.m8930onCreatePreferences$lambda6(SettingsPlayer.this, preference);
                    return m8930onCreatePreferences$lambda6;
                }
            });
        }
        Preference pref6 = SettingsFragment.Companion.getPref(settingsPlayer, R.string.subtitle_settings_chromecast_key);
        if (pref6 != null) {
            pref6.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsPlayer$iUXjQU-FQjAuR6nRAS8Lo5oR-zw
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean m8931onCreatePreferences$lambda7;
                    m8931onCreatePreferences$lambda7 = SettingsPlayer.m8931onCreatePreferences$lambda7(SettingsPlayer.this, preference);
                    return m8931onCreatePreferences$lambda7;
                }
            });
        }
        Preference pref7 = SettingsFragment.Companion.getPref(settingsPlayer, R.string.video_buffer_disk_key);
        if (pref7 != null) {
            pref7.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsPlayer$nfy4F5CJiEyqyPqTS8mXtfm7S7E
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean m8932onCreatePreferences$lambda8;
                    m8932onCreatePreferences$lambda8 = SettingsPlayer.m8932onCreatePreferences$lambda8(SettingsPlayer.this, defaultSharedPreferences, preference);
                    return m8932onCreatePreferences$lambda8;
                }
            });
        }
        Preference pref8 = SettingsFragment.Companion.getPref(settingsPlayer, R.string.video_buffer_size_key);
        if (pref8 != null) {
            pref8.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsPlayer$hzSpHAzQriOL9dntMeXEU3iNvfc
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean m8933onCreatePreferences$lambda9;
                    m8933onCreatePreferences$lambda9 = SettingsPlayer.m8933onCreatePreferences$lambda9(SettingsPlayer.this, defaultSharedPreferences, preference);
                    return m8933onCreatePreferences$lambda9;
                }
            });
        }
        final Preference pref9 = SettingsFragment.Companion.getPref(settingsPlayer, R.string.video_buffer_clear_key);
        if (pref9 != null) {
            Context context = getContext();
            final File cacheDir = context != null ? context.getCacheDir() : null;
            if (cacheDir == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(cacheDir, "context?.cacheDir ?: return@let");
            m8927onCreatePreferences$lambda11$updateSummery(pref9, this, cacheDir);
            pref9.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsPlayer$zLw1_s9W9sXVw_iwuvavTzROVXU
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean m8926onCreatePreferences$lambda11$lambda10;
                    m8926onCreatePreferences$lambda11$lambda10 = SettingsPlayer.m8926onCreatePreferences$lambda11$lambda10(cacheDir, pref9, this, preference);
                    return m8926onCreatePreferences$lambda11$lambda10;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-0  reason: not valid java name */
    public static final boolean m8924onCreatePreferences$lambda0(SettingsPlayer this$0, SharedPreferences sharedPreferences, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String[] stringArray = this$0.getResources().getStringArray(R.array.video_buffer_length_names);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray…ideo_buffer_length_names)");
        int[] intArray = this$0.getResources().getIntArray(R.array.video_buffer_length_values);
        Intrinsics.checkNotNullExpressionValue(intArray, "resources.getIntArray(R.…deo_buffer_length_values)");
        int i = sharedPreferences.getInt(this$0.getString(R.string.video_buffer_length_key), 0);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            List<String> list = ArraysKt.toList(stringArray);
            int indexOf = ArraysKt.indexOf(intArray, i);
            String string = this$0.getString(R.string.video_buffer_length_settings);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.video_buffer_length_settings)");
            SingleSelectionHelper.INSTANCE.showDialog(activity, list, indexOf, string, true, SettingsPlayer$onCreatePreferences$1$1.INSTANCE, new SettingsPlayer$onCreatePreferences$1$2(sharedPreferences, this$0, intArray));
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-1  reason: not valid java name */
    public static final boolean m8925onCreatePreferences$lambda1(SettingsPlayer this$0, SharedPreferences sharedPreferences, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String[] stringArray = this$0.getResources().getStringArray(R.array.limit_title_pref_names);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray…y.limit_title_pref_names)");
        int[] intArray = this$0.getResources().getIntArray(R.array.limit_title_pref_values);
        Intrinsics.checkNotNullExpressionValue(intArray, "resources.getIntArray(R.….limit_title_pref_values)");
        int i = sharedPreferences.getInt(this$0.getString(R.string.prefer_limit_title_key), 0);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            List<String> list = ArraysKt.toList(stringArray);
            int indexOf = ArraysKt.indexOf(intArray, i);
            String string = this$0.getString(R.string.limit_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.limit_title)");
            SingleSelectionHelper.INSTANCE.showBottomDialog(activity, list, indexOf, string, true, SettingsPlayer$onCreatePreferences$2$1.INSTANCE, new SettingsPlayer$onCreatePreferences$2$2(sharedPreferences, this$0, intArray));
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-2  reason: not valid java name */
    public static final boolean m8928onCreatePreferences$lambda2(SettingsPlayer this$0, SharedPreferences sharedPreferences, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String[] stringArray = this$0.getResources().getStringArray(R.array.limit_title_rez_pref_names);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray…mit_title_rez_pref_names)");
        int[] intArray = this$0.getResources().getIntArray(R.array.limit_title_rez_pref_values);
        Intrinsics.checkNotNullExpressionValue(intArray, "resources.getIntArray(R.…it_title_rez_pref_values)");
        int i = sharedPreferences.getInt(this$0.getString(R.string.prefer_limit_title_rez_key), 3);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            List<String> list = ArraysKt.toList(stringArray);
            int indexOf = ArraysKt.indexOf(intArray, i);
            String string = this$0.getString(R.string.limit_title_rez);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.limit_title_rez)");
            SingleSelectionHelper.INSTANCE.showBottomDialog(activity, list, indexOf, string, true, SettingsPlayer$onCreatePreferences$3$1.INSTANCE, new SettingsPlayer$onCreatePreferences$3$2(sharedPreferences, this$0, intArray));
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-5  reason: not valid java name */
    public static final boolean m8929onCreatePreferences$lambda5(SharedPreferences sharedPreferences, SettingsPlayer this$0, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Qualities[] values = Qualities.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (Qualities qualities : values) {
            arrayList.add(Integer.valueOf(qualities.getValue()));
        }
        List mutableList = CollectionsKt.toMutableList((Collection) CollectionsKt.reversed(arrayList));
        mutableList.remove(Integer.valueOf(Qualities.Unknown.getValue()));
        List<Number> list = mutableList;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Number number : list) {
            arrayList2.add(Qualities.Companion.getStringByInt(Integer.valueOf(number.intValue())));
        }
        ArrayList arrayList3 = arrayList2;
        int i = sharedPreferences.getInt(this$0.getString(R.string.quality_pref_key), ((Qualities) ArraysKt.last(Qualities.values())).getValue());
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            List<String> list2 = CollectionsKt.toList(arrayList3);
            int indexOf = mutableList.indexOf(Integer.valueOf(i));
            String string = this$0.getString(R.string.watch_quality_pref);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.watch_quality_pref)");
            SingleSelectionHelper.INSTANCE.showBottomDialog(activity, list2, indexOf, string, true, SettingsPlayer$onCreatePreferences$4$1.INSTANCE, new SettingsPlayer$onCreatePreferences$4$2(sharedPreferences, this$0, mutableList));
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-6  reason: not valid java name */
    public static final boolean m8930onCreatePreferences$lambda6(SettingsPlayer this$0, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SubtitlesFragment.Companion.push(this$0.getActivity(), false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-7  reason: not valid java name */
    public static final boolean m8931onCreatePreferences$lambda7(SettingsPlayer this$0, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ChromecastSubtitlesFragment.Companion.push(this$0.getActivity(), false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-8  reason: not valid java name */
    public static final boolean m8932onCreatePreferences$lambda8(SettingsPlayer this$0, SharedPreferences sharedPreferences, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String[] stringArray = this$0.getResources().getStringArray(R.array.video_buffer_size_names);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray….video_buffer_size_names)");
        int[] intArray = this$0.getResources().getIntArray(R.array.video_buffer_size_values);
        Intrinsics.checkNotNullExpressionValue(intArray, "resources.getIntArray(R.…video_buffer_size_values)");
        int i = sharedPreferences.getInt(this$0.getString(R.string.video_buffer_disk_key), 0);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            List<String> list = ArraysKt.toList(stringArray);
            int indexOf = ArraysKt.indexOf(intArray, i);
            String string = this$0.getString(R.string.video_buffer_disk_settings);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.video_buffer_disk_settings)");
            SingleSelectionHelper.INSTANCE.showDialog(activity, list, indexOf, string, true, SettingsPlayer$onCreatePreferences$7$1.INSTANCE, new SettingsPlayer$onCreatePreferences$7$2(sharedPreferences, this$0, intArray));
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-9  reason: not valid java name */
    public static final boolean m8933onCreatePreferences$lambda9(SettingsPlayer this$0, SharedPreferences sharedPreferences, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String[] stringArray = this$0.getResources().getStringArray(R.array.video_buffer_size_names);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray….video_buffer_size_names)");
        int[] intArray = this$0.getResources().getIntArray(R.array.video_buffer_size_values);
        Intrinsics.checkNotNullExpressionValue(intArray, "resources.getIntArray(R.…video_buffer_size_values)");
        int i = sharedPreferences.getInt(this$0.getString(R.string.video_buffer_size_key), 0);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            List<String> list = ArraysKt.toList(stringArray);
            int indexOf = ArraysKt.indexOf(intArray, i);
            String string = this$0.getString(R.string.video_buffer_size_settings);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.video_buffer_size_settings)");
            SingleSelectionHelper.INSTANCE.showDialog(activity, list, indexOf, string, true, SettingsPlayer$onCreatePreferences$8$1.INSTANCE, new SettingsPlayer$onCreatePreferences$8$2(sharedPreferences, this$0, intArray));
            return true;
        }
        return true;
    }

    /* renamed from: onCreatePreferences$lambda-11$updateSummery  reason: not valid java name */
    private static final void m8927onCreatePreferences$lambda11$updateSummery(Preference preference, SettingsPlayer settingsPlayer, File file) {
        try {
            String string = settingsPlayer.getString(R.string.mb_format);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.mb_format)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Long.valueOf(SettingsFragment.Companion.getFolderSize(file) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            preference.setSummary(format);
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-11$lambda-10  reason: not valid java name */
    public static final boolean m8926onCreatePreferences$lambda11$lambda10(File cacheDir, Preference pref, SettingsPlayer this$0, Preference preference) {
        Intrinsics.checkNotNullParameter(cacheDir, "$cacheDir");
        Intrinsics.checkNotNullParameter(pref, "$pref");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            FilesKt.deleteRecursively(cacheDir);
            m8927onCreatePreferences$lambda11$updateSummery(pref, this$0, cacheDir);
            return true;
        } catch (Exception e) {
            ArchComponentExt.logError(e);
            return true;
        }
    }
}
