package com.lagradost.cloudstream3.p041ui.settings;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.utils.BackupUtils;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.concurrent.Thread;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsUpdates.kt */
@Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\f"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/settings/SettingsUpdates;", "Landroidx/preference/PreferenceFragmentCompat;", "()V", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.settings.SettingsUpdates */
/* loaded from: classes4.dex */
public final class SettingsUpdates extends PreferenceFragmentCompat {
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
        SettingsFragment.Companion.setUpToolbar(this, R.string.category_updates);
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle bundle, String str) {
        UIHelper.INSTANCE.hideKeyboard(this);
        setPreferencesFromResource(R.xml.settings_updates, str);
        SettingsUpdates settingsUpdates = this;
        Preference pref = SettingsFragment.Companion.getPref(settingsUpdates, R.string.backup_key);
        if (pref != null) {
            pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsUpdates$TqBB_hOqgMigEcHe-6nG4_pEEik
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean m8944onCreatePreferences$lambda0;
                    m8944onCreatePreferences$lambda0 = SettingsUpdates.m8944onCreatePreferences$lambda0(SettingsUpdates.this, preference);
                    return m8944onCreatePreferences$lambda0;
                }
            });
        }
        Preference pref2 = SettingsFragment.Companion.getPref(settingsUpdates, R.string.restore_key);
        if (pref2 != null) {
            pref2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsUpdates$_LtMVoleK6xP3-WJXk0LKi4EPXI
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean m8945onCreatePreferences$lambda1;
                    m8945onCreatePreferences$lambda1 = SettingsUpdates.m8945onCreatePreferences$lambda1(SettingsUpdates.this, preference);
                    return m8945onCreatePreferences$lambda1;
                }
            });
        }
        Preference pref3 = SettingsFragment.Companion.getPref(settingsUpdates, R.string.show_logcat_key);
        if (pref3 != null) {
            pref3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsUpdates$4DrjWDeiwy7D87W-f0IXBswwdvA
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean m8946onCreatePreferences$lambda7;
                    m8946onCreatePreferences$lambda7 = SettingsUpdates.m8946onCreatePreferences$lambda7(SettingsUpdates.this, preference);
                    return m8946onCreatePreferences$lambda7;
                }
            });
        }
        Preference pref4 = SettingsFragment.Companion.getPref(settingsUpdates, R.string.manual_check_update_key);
        if (pref4 != null) {
            pref4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsUpdates$lkAfcJ1lzRlJIUQUnJYAX4o_Lws
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean m8951onCreatePreferences$lambda8;
                    m8951onCreatePreferences$lambda8 = SettingsUpdates.m8951onCreatePreferences$lambda8(SettingsUpdates.this, preference);
                    return m8951onCreatePreferences$lambda8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-0  reason: not valid java name */
    public static final boolean m8944onCreatePreferences$lambda0(SettingsUpdates this$0, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            BackupUtils.INSTANCE.backup(activity);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-1  reason: not valid java name */
    public static final boolean m8945onCreatePreferences$lambda1(SettingsUpdates this$0, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            BackupUtils.INSTANCE.restorePrompt(activity);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-7  reason: not valid java name */
    public static final boolean m8946onCreatePreferences$lambda7(final SettingsUpdates this$0, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final AlertDialog create = new AlertDialog.Builder(preference.getContext(), R.style.AlertDialogCustom).setView(R.layout.logcat).create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -d").getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
        final String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "log.toString()");
        TextView textView = (TextView) create.findViewById(C4761R.C4764id.text1);
        if (textView != null) {
            textView.setText(sb2);
        }
        MaterialButton materialButton = (MaterialButton) create.findViewById(C4761R.C4764id.copy_btt);
        if (materialButton != null) {
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsUpdates$0yy3NS5xO-pXN_HaEkSAGyLd73M
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SettingsUpdates.m8947onCreatePreferences$lambda7$lambda3(SettingsUpdates.this, sb2, create, view);
                }
            });
        }
        MaterialButton materialButton2 = (MaterialButton) create.findViewById(C4761R.C4764id.clear_btt);
        if (materialButton2 != null) {
            materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsUpdates$GQ-XTiwawxp5rO5HEJHN5tTpua4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SettingsUpdates.m8948onCreatePreferences$lambda7$lambda4(AlertDialog.this, this$0, view);
                }
            });
        }
        MaterialButton materialButton3 = (MaterialButton) create.findViewById(C4761R.C4764id.save_btt);
        if (materialButton3 != null) {
            materialButton3.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsUpdates$aMcge0RsBasSfvLCvBYD3GiB754
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SettingsUpdates.m8949onCreatePreferences$lambda7$lambda5(sb2, create, this$0, view);
                }
            });
        }
        MaterialButton materialButton4 = (MaterialButton) create.findViewById(C4761R.C4764id.close_btt);
        if (materialButton4 != null) {
            materialButton4.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsUpdates$UAY6LULnYd44dw7Pu2yWHpsVgug
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SettingsUpdates.m8950onCreatePreferences$lambda7$lambda6(AlertDialog.this, this$0, view);
                }
            });
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-7$lambda-3  reason: not valid java name */
    public static final void m8947onCreatePreferences$lambda7$lambda3(SettingsUpdates this$0, String text, AlertDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(text, "$text");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        FragmentActivity activity = this$0.getActivity();
        ClipboardManager clipboardManager = (ClipboardManager) (activity != null ? activity.getSystemService("clipboard") : null);
        if (clipboardManager == null) {
            return;
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText("logcat", text));
        UIHelper.INSTANCE.dismissSafe(dialog, this$0.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-7$lambda-4  reason: not valid java name */
    public static final void m8948onCreatePreferences$lambda7$lambda4(AlertDialog dialog, SettingsUpdates this$0, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Runtime.getRuntime().exec("logcat -c");
        UIHelper.INSTANCE.dismissSafe(dialog, this$0.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0040, code lost:
        if (r0 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
        okhttp3.internal._UtilCommonKt.closeQuietly(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
        com.lagradost.cloudstream3.utils.UIHelper.INSTANCE.dismissSafe(r8, r9.getActivity());
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0054, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0035, code lost:
        if (r0 != null) goto L11;
     */
    /* renamed from: onCreatePreferences$lambda-7$lambda-5  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m8949onCreatePreferences$lambda7$lambda5(java.lang.String r7, androidx.appcompat.app.AlertDialog r8, com.lagradost.cloudstream3.p041ui.settings.SettingsUpdates r9, android.view.View r10) {
        /*
            java.lang.String r0 = "$text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "$dialog"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 0
            com.lagradost.cloudstream3.utils.VideoDownloadManager r1 = com.lagradost.cloudstream3.utils.VideoDownloadManager.INSTANCE     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            android.content.Context r2 = r10.getContext()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            java.lang.String r10 = "it.context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r10)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            java.lang.String r3 = "logcat"
            r4 = 0
            java.lang.String r5 = "txt"
            r6 = 0
            com.lagradost.cloudstream3.utils.VideoDownloadManager$StreamData r10 = r1.setupStream(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            java.io.OutputStream r0 = r10.getFileStream()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            if (r0 == 0) goto L35
            java.nio.charset.Charset r10 = kotlin.text.Charsets.UTF_8     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            java.io.OutputStreamWriter r1 = new java.io.OutputStreamWriter     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            r1.<init>(r0, r10)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            r1.write(r7)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
        L35:
            if (r0 == 0) goto L47
            goto L42
        L38:
            r7 = move-exception
            goto L55
        L3a:
            r7 = move-exception
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch: java.lang.Throwable -> L38
            com.lagradost.cloudstream3.mvvm.ArchComponentExt.logError(r7)     // Catch: java.lang.Throwable -> L38
            if (r0 == 0) goto L47
        L42:
            java.io.Closeable r0 = (java.io.Closeable) r0
            okhttp3.internal._UtilCommonKt.closeQuietly(r0)
        L47:
            com.lagradost.cloudstream3.utils.UIHelper r7 = com.lagradost.cloudstream3.utils.UIHelper.INSTANCE
            android.app.Dialog r8 = (android.app.Dialog) r8
            androidx.fragment.app.FragmentActivity r9 = r9.getActivity()
            android.app.Activity r9 = (android.app.Activity) r9
            r7.dismissSafe(r8, r9)
            return
        L55:
            if (r0 == 0) goto L5c
            java.io.Closeable r0 = (java.io.Closeable) r0
            okhttp3.internal._UtilCommonKt.closeQuietly(r0)
        L5c:
            com.lagradost.cloudstream3.utils.UIHelper r10 = com.lagradost.cloudstream3.utils.UIHelper.INSTANCE
            android.app.Dialog r8 = (android.app.Dialog) r8
            androidx.fragment.app.FragmentActivity r9 = r9.getActivity()
            android.app.Activity r9 = (android.app.Activity) r9
            r10.dismissSafe(r8, r9)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.settings.SettingsUpdates.m8949onCreatePreferences$lambda7$lambda5(java.lang.String, androidx.appcompat.app.AlertDialog, com.lagradost.cloudstream3.ui.settings.SettingsUpdates, android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-7$lambda-6  reason: not valid java name */
    public static final void m8950onCreatePreferences$lambda7$lambda6(AlertDialog dialog, SettingsUpdates this$0, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UIHelper.INSTANCE.dismissSafe(dialog, this$0.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreatePreferences$lambda-8  reason: not valid java name */
    public static final boolean m8951onCreatePreferences$lambda8(SettingsUpdates this$0, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Thread.thread((r12 & 1) != 0, (r12 & 2) != 0 ? false : false, (r12 & 4) != 0 ? null : null, (r12 & 8) != 0 ? null : null, (r12 & 16) != 0 ? -1 : 0, new SettingsUpdates$onCreatePreferences$4$1(this$0));
        return true;
    }
}
