package com.lagradost.cloudstream3.p041ui.settings;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.bongngotv2.R;
import com.hippo.unifile.UniFile;
import com.lagradost.cloudstream3.utils.VideoDownloadManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsGeneral.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.settings.SettingsGeneral$onCreatePreferences$getDownloadDirs$1 */
/* loaded from: classes4.dex */
public final class SettingsGeneral$onCreatePreferences$getDownloadDirs$1 extends Lambda implements Functions<List<? extends String>> {
    final /* synthetic */ SettingsGeneral this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsGeneral$onCreatePreferences$getDownloadDirs$1(SettingsGeneral settingsGeneral) {
        super(0);
        this.this$0 = settingsGeneral;
    }

    @Override // kotlin.jvm.functions.Functions
    public final List<? extends String> invoke() {
        Tuples<UniFile, String> basePath;
        UniFile first;
        UniFile downloadDir = VideoDownloadManager.INSTANCE.getDownloadDir();
        String str = null;
        List listOf = CollectionsKt.listOf((Object[]) new String[]{downloadDir != null ? downloadDir.getFilePath() : null, Build.VERSION.SDK_INT >= 29 ? null : Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + this.this$0.getResources().getString(R.string.app_name_download_path)});
        try {
            Context context = this.this$0.getContext();
            if (context != null && (basePath = VideoDownloadManager.INSTANCE.getBasePath(context)) != null && ((first = basePath.getFirst()) == null || (str = first.getFilePath()) == null)) {
                str = basePath.getSecond();
            }
            List list = listOf;
            File[] externalFilesDirs = this.this$0.requireContext().getExternalFilesDirs("");
            Intrinsics.checkNotNullExpressionValue(externalFilesDirs, "requireContext().getExternalFilesDirs(\"\")");
            ArrayList arrayList = new ArrayList();
            for (File file : externalFilesDirs) {
                String path = file.getPath();
                if (path != null) {
                    arrayList.add(path);
                }
            }
            listOf = CollectionsKt.plus((Collection<? extends String>) CollectionsKt.plus((Collection) list, (Iterable) arrayList), str);
        } catch (Exception unused) {
        }
        return CollectionsKt.distinct(CollectionsKt.filterNotNull(listOf));
    }
}
