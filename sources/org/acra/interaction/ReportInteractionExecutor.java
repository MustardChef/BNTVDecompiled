package org.acra.interaction;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.config.CoreConfiguration;

/* compiled from: ReportInteractionExecutor.kt */
@Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m107d2 = {"Lorg/acra/interaction/ReportInteractionExecutor;", "", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "(Landroid/content/Context;Lorg/acra/config/CoreConfiguration;)V", "reportInteractions", "", "Lorg/acra/interaction/ReportInteraction;", "hasInteractions", "", "performInteractions", "reportFile", "Ljava/io/File;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class ReportInteractionExecutor {
    private final CoreConfiguration config;
    private final Context context;
    private final List<ReportInteraction> reportInteractions;

    public ReportInteractionExecutor(Context context, CoreConfiguration config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.context = context;
        this.config = config;
        this.reportInteractions = config.getPluginLoader().loadEnabled(config, ReportInteraction.class);
    }

    public final boolean hasInteractions() {
        return !this.reportInteractions.isEmpty();
    }

    public final boolean performInteractions(final File reportFile) {
        Intrinsics.checkNotNullParameter(reportFile, "reportFile");
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        List<ReportInteraction> list = this.reportInteractions;
        ArrayList<Future> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (final ReportInteraction reportInteraction : list) {
            arrayList.add(newCachedThreadPool.submit(new Callable() { // from class: org.acra.interaction.-$$Lambda$ReportInteractionExecutor$_C0s5hqnH2H0M-88E-PBBqw_9KY
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Boolean m10736performInteractions$lambda2$lambda1;
                    m10736performInteractions$lambda2$lambda1 = ReportInteractionExecutor.m10736performInteractions$lambda2$lambda1(ReportInteraction.this, this, reportFile);
                    return m10736performInteractions$lambda2$lambda1;
                }
            }));
        }
        boolean z = true;
        for (Future future : arrayList) {
            do {
                try {
                    Object obj = future.get();
                    Intrinsics.checkNotNullExpressionValue(obj, "future.get()");
                    z &= ((Boolean) obj).booleanValue();
                } catch (InterruptedException unused) {
                } catch (ExecutionException unused2) {
                }
            } while (!future.isDone());
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: performInteractions$lambda-2$lambda-1  reason: not valid java name */
    public static final Boolean m10736performInteractions$lambda2$lambda1(ReportInteraction it, ReportInteractionExecutor this$0, File reportFile) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportFile, "$reportFile");
        if (ACRA.DEV_LOGGING) {
            ACRA.log.mo69d(ACRA.LOG_TAG, Intrinsics.stringPlus("Calling ReportInteraction of class ", it.getClass().getName()));
        }
        return Boolean.valueOf(it.performInteraction(this$0.context, this$0.config, reportFile));
    }
}
