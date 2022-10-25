package org.acra.collector;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.tvprovider.media.p009tv.TvContractCompat;
import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.collector.Collector;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.acra.log.ACRALog;
import org.acra.prefs.SharedPreferencesFactory;
import org.acra.util.PackageManagerWrapper;
import org.acra.util.StreamReader;

/* compiled from: LogCatCollector.kt */
@Metadata(m108d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J6\u0010\u0018\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006 "}, m107d2 = {"Lorg/acra/collector/LogCatCollector;", "Lorg/acra/collector/BaseReportFieldCollector;", "()V", "order", "Lorg/acra/collector/Collector$Order;", "getOrder", "()Lorg/acra/collector/Collector$Order;", "collect", "", "reportField", "Lorg/acra/ReportField;", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "reportBuilder", "Lorg/acra/builder/ReportBuilder;", TypedValues.AttributesType.S_TARGET, "Lorg/acra/data/CrashReportData;", "collectLogCat", "", "bufferName", "shouldCollect", "", "streamToString", TvContractCompat.PARAM_INPUT, "Ljava/io/InputStream;", "filter", "Lkotlin/Function1;", "limit", "", "Companion", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public class LogCatCollector extends BaseReportFieldCollector {
    public static final Companion Companion = new Companion(null);
    private static final int READ_TIMEOUT = 3000;

    /* compiled from: LogCatCollector.kt */
    @Metadata(m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReportField.valuesCustom().length];
            iArr[ReportField.LOGCAT.ordinal()] = 1;
            iArr[ReportField.EVENTSLOG.ordinal()] = 2;
            iArr[ReportField.RADIOLOG.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LogCatCollector() {
        super(ReportField.LOGCAT, ReportField.EVENTSLOG, ReportField.RADIOLOG);
    }

    @Override // org.acra.collector.BaseReportFieldCollector, org.acra.collector.Collector
    public Collector.Order getOrder() {
        return Collector.Order.FIRST;
    }

    private final String collectLogCat(CoreConfiguration coreConfiguration, String str) throws IOException {
        String str2;
        int myPid = Process.myPid();
        LogCatCollector$collectLogCat$2$1 logCatCollector$collectLogCat$2$1 = null;
        if (Build.VERSION.SDK_INT >= 16 || !coreConfiguration.getLogcatFilterByPid() || myPid <= 0) {
            str2 = null;
        } else {
            str2 = myPid + "):";
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("logcat");
        if (str != null) {
            arrayList.add("-b");
            arrayList.add(str);
        }
        List list = ArraysKt.toList(coreConfiguration.getLogcatArguments());
        int indexOf = list.indexOf("-t");
        int i = -1;
        if (indexOf > -1 && indexOf < list.size()) {
            i = Integer.parseInt((String) list.get(indexOf + 1));
        }
        arrayList.addAll(list);
        Process start = new ProcessBuilder(new String[0]).command(arrayList).redirectErrorStream(true).start();
        if (ACRA.DEV_LOGGING) {
            ACRALog aCRALog = ACRA.log;
            String str3 = ACRA.LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Retrieving logcat output (buffer:");
            if (str == null) {
                str = MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY;
            }
            sb.append(str);
            sb.append(")...");
            aCRALog.mo69d(str3, sb.toString());
        }
        try {
            InputStream inputStream = start.getInputStream();
            Intrinsics.checkNotNullExpressionValue(inputStream, "process.inputStream");
            if (str2 != null) {
                logCatCollector$collectLogCat$2$1 = new LogCatCollector$collectLogCat$2$1(str2);
            }
            return streamToString(coreConfiguration, inputStream, logCatCollector$collectLogCat$2$1, i);
        } finally {
            start.destroy();
        }
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    public boolean shouldCollect(Context context, CoreConfiguration config, ReportField collect, ReportBuilder reportBuilder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(collect, "collect");
        Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
        return super.shouldCollect(context, config, collect, reportBuilder) && (Build.VERSION.SDK_INT >= 16 || new PackageManagerWrapper(context).hasPermission("android.permission.READ_LOGS")) && new SharedPreferencesFactory(context, config).create().getBoolean(ACRA.PREF_ENABLE_SYSTEM_LOGS, true);
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    public void collect(ReportField reportField, Context context, CoreConfiguration config, ReportBuilder reportBuilder, CrashReportData target) throws IOException {
        Intrinsics.checkNotNullParameter(reportField, "reportField");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
        Intrinsics.checkNotNullParameter(target, "target");
        int i = WhenMappings.$EnumSwitchMapping$0[reportField.ordinal()];
        String str = null;
        if (i != 1) {
            if (i == 2) {
                str = "events";
            } else if (i == 3) {
                str = "radio";
            }
        }
        target.put(reportField, collectLogCat(config, str));
    }

    private final String streamToString(CoreConfiguration coreConfiguration, InputStream inputStream, Function1<? super String, Boolean> function1, int i) throws IOException {
        StreamReader limit = new StreamReader(inputStream, 0, 0, null, 14, null).setFilter(function1).setLimit(i);
        if (coreConfiguration.getLogcatReadNonBlocking()) {
            limit.setTimeout(3000);
        }
        return limit.read();
    }

    /* compiled from: LogCatCollector.kt */
    @Metadata(m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m107d2 = {"Lorg/acra/collector/LogCatCollector$Companion;", "", "()V", "READ_TIMEOUT", "", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
