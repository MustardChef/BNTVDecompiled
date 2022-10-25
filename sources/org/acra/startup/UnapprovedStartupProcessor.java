package org.acra.startup;

import android.content.Context;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.acra.config.CoreConfiguration;

/* compiled from: UnapprovedStartupProcessor.kt */
@Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, m107d2 = {"Lorg/acra/startup/UnapprovedStartupProcessor;", "Lorg/acra/startup/StartupProcessor;", "()V", "processReports", "", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "reports", "", "Lorg/acra/startup/Report;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public class UnapprovedStartupProcessor implements StartupProcessor {
    @Override // org.acra.plugins.Plugin
    public /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration) {
        return Intrinsics.checkNotNullParameter(coreConfiguration, "config");
    }

    @Override // org.acra.startup.StartupProcessor
    public void processReports(Context context, CoreConfiguration config, List<Report> reports) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reports, "reports");
        if (config.getDeleteUnapprovedReportsOnApplicationStart()) {
            ArrayList arrayList = new ArrayList();
            for (Report report : reports) {
                if (!report.getApproved()) {
                    arrayList.add(report);
                }
            }
            if (!arrayList.isEmpty()) {
                if (arrayList.size() > 1) {
                    CollectionsKt.sortWith(arrayList, new Comparator<T>() { // from class: org.acra.startup.UnapprovedStartupProcessor$processReports$$inlined$sortBy$1
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(Long.valueOf(((Report) t).getFile().lastModified()), Long.valueOf(((Report) t2).getFile().lastModified()));
                        }
                    });
                }
                int i = 0;
                int size = arrayList.size() - 1;
                if (size > 0) {
                    while (true) {
                        int i2 = i + 1;
                        ((Report) arrayList.get(i)).setDelete(true);
                        if (i2 >= size) {
                            break;
                        }
                        i = i2;
                    }
                }
                ((Report) arrayList.get(arrayList.size() - 1)).setApprove(true);
            }
        }
    }
}
