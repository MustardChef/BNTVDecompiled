package org.acra.collector;

import android.content.Context;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p043io.Closeable;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.collector.Collector;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;

/* compiled from: StacktraceCollector.kt */
@Metadata(m108d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010\u0018\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J(\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001b"}, m107d2 = {"Lorg/acra/collector/StacktraceCollector;", "Lorg/acra/collector/BaseReportFieldCollector;", "()V", "order", "Lorg/acra/collector/Collector$Order;", "getOrder", "()Lorg/acra/collector/Collector$Order;", "collect", "", "reportField", "Lorg/acra/ReportField;", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "reportBuilder", "Lorg/acra/builder/ReportBuilder;", TypedValues.AttributesType.S_TARGET, "Lorg/acra/data/CrashReportData;", "getStackTrace", "", NotificationCompat.CATEGORY_MESSAGE, "th", "", "getStackTraceHash", "shouldCollect", "", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public class StacktraceCollector extends BaseReportFieldCollector {

    /* compiled from: StacktraceCollector.kt */
    @Metadata(m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReportField.valuesCustom().length];
            iArr[ReportField.STACK_TRACE.ordinal()] = 1;
            iArr[ReportField.STACK_TRACE_HASH.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public StacktraceCollector() {
        super(ReportField.STACK_TRACE, ReportField.STACK_TRACE_HASH);
    }

    @Override // org.acra.collector.BaseReportFieldCollector, org.acra.collector.Collector
    public Collector.Order getOrder() {
        return Collector.Order.FIRST;
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    public void collect(ReportField reportField, Context context, CoreConfiguration config, ReportBuilder reportBuilder, CrashReportData target) {
        Intrinsics.checkNotNullParameter(reportField, "reportField");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
        Intrinsics.checkNotNullParameter(target, "target");
        int i = WhenMappings.$EnumSwitchMapping$0[reportField.ordinal()];
        if (i == 1) {
            target.put(ReportField.STACK_TRACE, getStackTrace(reportBuilder.getMessage(), reportBuilder.getException()));
        } else if (i == 2) {
            target.put(ReportField.STACK_TRACE_HASH, getStackTraceHash(reportBuilder.getException()));
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    public boolean shouldCollect(Context context, CoreConfiguration config, ReportField collect, ReportBuilder reportBuilder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(collect, "collect");
        Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
        return collect == ReportField.STACK_TRACE || super.shouldCollect(context, config, collect, reportBuilder);
    }

    private final String getStackTrace(String str, Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        Throwable th2 = null;
        try {
            PrintWriter printWriter2 = printWriter;
            if (str != null && !TextUtils.isEmpty(str)) {
                printWriter2.println(str);
            }
            if (th != null) {
                th.printStackTrace(printWriter2);
            }
            String writer = stringWriter.toString();
            Closeable.closeFinally(printWriter, th2);
            return writer;
        } finally {
        }
    }

    private final String getStackTraceHash(Throwable th) {
        StringBuilder sb = new StringBuilder();
        while (th != null) {
            StackTraceElement[] stackTraceElements = th.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTraceElements, "stackTraceElements");
            int i = 0;
            int length = stackTraceElements.length;
            while (i < length) {
                StackTraceElement stackTraceElement = stackTraceElements[i];
                i++;
                sb.append(stackTraceElement.getClassName());
                sb.append(stackTraceElement.getMethodName());
            }
            th = th.getCause();
        }
        String hexString = Integer.toHexString(sb.toString().hashCode());
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(res.toString().hashCode())");
        return hexString;
    }
}
