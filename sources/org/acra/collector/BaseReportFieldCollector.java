package org.acra.collector;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.collector.Collector;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;

/* compiled from: BaseReportFieldCollector.kt */
@Metadata(m108d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J0\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0010H&J(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0018\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0015"}, m107d2 = {"Lorg/acra/collector/BaseReportFieldCollector;", "Lorg/acra/collector/Collector;", "reportFields", "", "Lorg/acra/ReportField;", "([Lorg/acra/ReportField;)V", "[Lorg/acra/ReportField;", "collect", "", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "reportBuilder", "Lorg/acra/builder/ReportBuilder;", "crashReportData", "Lorg/acra/data/CrashReportData;", "reportField", TypedValues.AttributesType.S_TARGET, "shouldCollect", "", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseReportFieldCollector implements Collector {
    private final ReportField[] reportFields;

    public abstract void collect(ReportField reportField, Context context, CoreConfiguration coreConfiguration, ReportBuilder reportBuilder, CrashReportData crashReportData) throws Exception;

    @Override // org.acra.plugins.Plugin
    public /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration) {
        return Intrinsics.checkNotNullParameter(coreConfiguration, "config");
    }

    @Override // org.acra.collector.Collector
    public /* synthetic */ Collector.Order getOrder() {
        Collector.Order order;
        order = Collector.Order.NORMAL;
        return order;
    }

    public BaseReportFieldCollector(ReportField... reportFields) {
        Intrinsics.checkNotNullParameter(reportFields, "reportFields");
        this.reportFields = reportFields;
    }

    public boolean shouldCollect(Context context, CoreConfiguration config, ReportField collect, ReportBuilder reportBuilder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(collect, "collect");
        Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
        return config.getReportContent().contains(collect);
    }

    @Override // org.acra.collector.Collector
    public void collect(Context context, CoreConfiguration config, ReportBuilder reportBuilder, CrashReportData crashReportData) throws CollectorException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
        Intrinsics.checkNotNullParameter(crashReportData, "crashReportData");
        ReportField[] reportFieldArr = this.reportFields;
        int length = reportFieldArr.length;
        int i = 0;
        while (i < length) {
            ReportField reportField = reportFieldArr[i];
            i++;
            try {
                if (shouldCollect(context, config, reportField, reportBuilder)) {
                    collect(reportField, context, config, reportBuilder, crashReportData);
                }
            } catch (Exception e) {
                crashReportData.put(reportField, (String) null);
                throw new CollectorException("Error while retrieving " + reportField.name() + " data:" + ((Object) e.getMessage()), e);
            }
        }
    }
}
