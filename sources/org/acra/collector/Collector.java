package org.acra.collector;

import android.content.Context;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmDefault;
import org.acra.builder.ReportBuilder;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.acra.plugins.Plugin;

/* compiled from: Collector.kt */
@Metadata(m108d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0012J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&R\u001a\u0010\u0002\u001a\u00020\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, m107d2 = {"Lorg/acra/collector/Collector;", "Lorg/acra/plugins/Plugin;", "order", "Lorg/acra/collector/Collector$Order;", "getOrder$annotations", "()V", "getOrder", "()Lorg/acra/collector/Collector$Order;", "collect", "", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "reportBuilder", "Lorg/acra/builder/ReportBuilder;", "crashReportData", "Lorg/acra/data/CrashReportData;", "Order", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public interface Collector extends Plugin {

    /* compiled from: Collector.kt */
    @Metadata(m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        @JvmDefault
        public static /* synthetic */ void getOrder$annotations() {
        }
    }

    void collect(Context context, CoreConfiguration coreConfiguration, ReportBuilder reportBuilder, CrashReportData crashReportData) throws CollectorException;

    Order getOrder();

    /* compiled from: Collector.kt */
    /* renamed from: org.acra.collector.Collector$-CC  reason: invalid class name */
    /* loaded from: classes4.dex */
    public final /* synthetic */ class CC {
    }

    /* compiled from: Collector.kt */
    @Metadata(m108d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m107d2 = {"Lorg/acra/collector/Collector$Order;", "", "(Ljava/lang/String;I)V", "FIRST", "EARLY", "NORMAL", "LATE", "LAST", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public enum Order {
        FIRST,
        EARLY,
        NORMAL,
        LATE,
        LAST;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Order[] valuesCustom() {
            Order[] valuesCustom = values();
            return (Order[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }
}
