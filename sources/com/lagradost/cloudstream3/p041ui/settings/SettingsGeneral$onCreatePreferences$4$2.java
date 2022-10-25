package com.lagradost.cloudstream3.p041ui.settings;

import android.content.SharedPreferences;
import android.net.Uri;
import androidx.activity.result.ActivityResultLauncher;
import com.bongngotv2.R;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsGeneral.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.settings.SettingsGeneral$onCreatePreferences$4$2 */
/* loaded from: classes4.dex */
public final class SettingsGeneral$onCreatePreferences$4$2 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ List<String> $dirs;
    final /* synthetic */ SharedPreferences $settingsManager;
    final /* synthetic */ SettingsGeneral this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsGeneral$onCreatePreferences$4$2(List<String> list, SettingsGeneral settingsGeneral, SharedPreferences sharedPreferences) {
        super(1);
        this.$dirs = list;
        this.this$0 = settingsGeneral;
        this.$settingsManager = sharedPreferences;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ActivityResultLauncher activityResultLauncher;
        if (i == this.$dirs.size()) {
            try {
                activityResultLauncher = this.this$0.pathPicker;
                activityResultLauncher.launch(Uri.EMPTY);
                return;
            } catch (Exception e) {
                ArchComponentExt.logError(e);
                return;
            }
        }
        this.$settingsManager.edit().putString(this.this$0.getString(R.string.download_path_key), this.$dirs.get(i)).apply();
        this.$settingsManager.edit().putString(this.this$0.getString(R.string.download_path_pref), this.$dirs.get(i)).apply();
    }
}
