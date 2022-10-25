package org.acra.data;

import android.content.Context;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.builder.ReportBuilder;
import org.acra.collector.ApplicationStartupCollector;
import org.acra.collector.Collector;
import org.acra.collector.CollectorException;
import org.acra.config.CoreConfiguration;
import org.acra.log.ACRALog;

/* compiled from: CrashReportDataFactory.kt */
@Metadata(m108d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m107d2 = {"Lorg/acra/data/CrashReportDataFactory;", "", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "(Landroid/content/Context;Lorg/acra/config/CoreConfiguration;)V", "collectors", "", "Lorg/acra/collector/Collector;", "collectStartUp", "", "createCrashData", "Lorg/acra/data/CrashReportData;", "builder", "Lorg/acra/builder/ReportBuilder;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class CrashReportDataFactory {
    private final List<Collector> collectors;
    private final CoreConfiguration config;
    private final Context context;

    public CrashReportDataFactory(Context context, CoreConfiguration config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.context = context;
        this.config = config;
        this.collectors = CollectionsKt.sortedWith(config.getPluginLoader().loadEnabled(config, Collector.class), new Comparator<T>() { // from class: org.acra.data.CrashReportDataFactory$special$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Collector.Order order;
                Collector.Order order2;
                try {
                    order = ((Collector) t).getOrder();
                } catch (Exception unused) {
                    order = Collector.Order.NORMAL;
                }
                Collector.Order order3 = order;
                try {
                    order2 = ((Collector) t2).getOrder();
                } catch (Exception unused2) {
                    order2 = Collector.Order.NORMAL;
                }
                return ComparisonsKt.compareValues(order3, order2);
            }
        });
    }

    public final CrashReportData createCrashData(final ReportBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        ExecutorService newCachedThreadPool = this.config.getParallel() ? Executors.newCachedThreadPool() : Executors.newSingleThreadExecutor();
        final CrashReportData crashReportData = new CrashReportData();
        List<Collector> list = this.collectors;
        ArrayList<Future> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (final Collector collector : list) {
            arrayList.add(newCachedThreadPool.submit(new Runnable() { // from class: org.acra.data.-$$Lambda$CrashReportDataFactory$2g3L28xYmROlqPfn7_MkaSCHTcQ
                @Override // java.lang.Runnable
                public final void run() {
                    CrashReportDataFactory.m10734createCrashData$lambda6$lambda5(Collector.this, this, builder, crashReportData);
                }
            }));
        }
        for (Future future : arrayList) {
            while (!future.isDone()) {
                try {
                    future.get();
                } catch (InterruptedException unused) {
                } catch (ExecutionException unused2) {
                }
            }
        }
        return crashReportData;
    }

    public final void collectStartUp() {
        for (Collector collector : this.collectors) {
            if (collector instanceof ApplicationStartupCollector) {
                try {
                    ((ApplicationStartupCollector) collector).collectApplicationStartUp(this.context, this.config);
                } catch (Throwable th) {
                    ACRA.log.mo60w(ACRA.LOG_TAG, Intrinsics.stringPlus(collector.getClass().getSimpleName(), " failed to collect its startup data"), th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createCrashData$lambda-6$lambda-5  reason: not valid java name */
    public static final void m10734createCrashData$lambda6$lambda5(Collector collector, CrashReportDataFactory this$0, ReportBuilder builder, CrashReportData crashReportData) {
        Intrinsics.checkNotNullParameter(collector, "$collector");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(builder, "$builder");
        Intrinsics.checkNotNullParameter(crashReportData, "$crashReportData");
        try {
            if (ACRA.DEV_LOGGING) {
                ACRA.log.mo69d(ACRA.LOG_TAG, Intrinsics.stringPlus("Calling collector ", collector.getClass().getName()));
            }
            collector.collect(this$0.context, this$0.config, builder, crashReportData);
            if (ACRA.DEV_LOGGING) {
                ACRALog aCRALog = ACRA.log;
                String str = ACRA.LOG_TAG;
                aCRALog.mo69d(str, "Collector " + ((Object) collector.getClass().getName()) + " completed");
            }
        } catch (CollectorException e) {
            ACRA.log.mo60w(ACRA.LOG_TAG, "", e);
        } catch (Throwable th) {
            ACRA.log.mo60w(ACRA.LOG_TAG, Intrinsics.stringPlus("Error in collector ", collector.getClass().getSimpleName()), th);
        }
    }
}
