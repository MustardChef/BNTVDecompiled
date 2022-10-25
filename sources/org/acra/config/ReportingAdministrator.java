package org.acra.config;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmDefault;
import kotlin.jvm.internal.Intrinsics;
import org.acra.builder.LastActivityManager;
import org.acra.builder.ReportBuilder;
import org.acra.data.CrashReportData;
import org.acra.plugins.Plugin;

/* compiled from: ReportingAdministrator.kt */
@Metadata(m108d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J \u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0017J*\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0017J \u0010\u0011\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0017J \u0010\u0012\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0017¨\u0006\u0013"}, m107d2 = {"Lorg/acra/config/ReportingAdministrator;", "Lorg/acra/plugins/Plugin;", "notifyReportDropped", "", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "shouldFinishActivity", "", "lastActivityManager", "Lorg/acra/builder/LastActivityManager;", "shouldKillApplication", "reportBuilder", "Lorg/acra/builder/ReportBuilder;", "crashReportData", "Lorg/acra/data/CrashReportData;", "shouldSendReport", "shouldStartCollecting", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public interface ReportingAdministrator extends Plugin {

    /* compiled from: ReportingAdministrator.kt */
    /* renamed from: org.acra.config.ReportingAdministrator$-CC  reason: invalid class name */
    /* loaded from: classes4.dex */
    public final /* synthetic */ class CC {
        @JvmDefault
        public static void $default$notifyReportDropped(ReportingAdministrator reportingAdministrator, Context context, CoreConfiguration config) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
        }

        @JvmDefault
        public static boolean $default$shouldFinishActivity(ReportingAdministrator reportingAdministrator, Context context, CoreConfiguration config, LastActivityManager lastActivityManager) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(lastActivityManager, "lastActivityManager");
            return true;
        }

        @JvmDefault
        public static boolean $default$shouldKillApplication(ReportingAdministrator reportingAdministrator, Context context, CoreConfiguration config, ReportBuilder reportBuilder, CrashReportData crashReportData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
            return true;
        }

        @JvmDefault
        public static boolean $default$shouldSendReport(ReportingAdministrator reportingAdministrator, Context context, CoreConfiguration config, CrashReportData crashReportData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(crashReportData, "crashReportData");
            return true;
        }

        @JvmDefault
        public static boolean $default$shouldStartCollecting(ReportingAdministrator reportingAdministrator, Context context, CoreConfiguration config, ReportBuilder reportBuilder) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
            return true;
        }
    }

    @JvmDefault
    void notifyReportDropped(Context context, CoreConfiguration coreConfiguration);

    @JvmDefault
    boolean shouldFinishActivity(Context context, CoreConfiguration coreConfiguration, LastActivityManager lastActivityManager);

    @JvmDefault
    boolean shouldKillApplication(Context context, CoreConfiguration coreConfiguration, ReportBuilder reportBuilder, CrashReportData crashReportData);

    @JvmDefault
    boolean shouldSendReport(Context context, CoreConfiguration coreConfiguration, CrashReportData crashReportData);

    @JvmDefault
    boolean shouldStartCollecting(Context context, CoreConfiguration coreConfiguration, ReportBuilder reportBuilder);
}
