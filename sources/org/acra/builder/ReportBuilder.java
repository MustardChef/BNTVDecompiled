package org.acra.builder;

import androidx.core.app.NotificationCompat;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReportBuilder.kt */
@Metadata(m108d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005J\u001a\u0010\u0003\u001a\u00020\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001cJ\u0006\u0010\u001d\u001a\u00020\u0000J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001cJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u0005J\u0006\u0010!\u001a\u00020\u0000J\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u0012R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\"\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, m107d2 = {"Lorg/acra/builder/ReportBuilder;", "", "()V", "customData", "", "", "<set-?>", "", "exception", "getException", "()Ljava/lang/Throwable;", "", "isEndApplication", "()Z", "isSendSilently", "message", "getMessage", "()Ljava/lang/String;", "Ljava/lang/Thread;", "uncaughtExceptionThread", "getUncaughtExceptionThread", "()Ljava/lang/Thread;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "", "reportExecutor", "Lorg/acra/builder/ReportExecutor;", SDKConstants.PARAM_KEY, "value", "", "endApplication", "e", "getCustomData", NotificationCompat.CATEGORY_MESSAGE, "sendSilently", "thread", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class ReportBuilder {
    private final Map<String, String> customData = new HashMap();
    private Throwable exception;
    private boolean isEndApplication;
    private boolean isSendSilently;
    private String message;
    private Thread uncaughtExceptionThread;

    public final String getMessage() {
        return this.message;
    }

    public final Thread getUncaughtExceptionThread() {
        return this.uncaughtExceptionThread;
    }

    public final Throwable getException() {
        return this.exception;
    }

    public final boolean isSendSilently() {
        return this.isSendSilently;
    }

    public final boolean isEndApplication() {
        return this.isEndApplication;
    }

    public final ReportBuilder message(String str) {
        this.message = str;
        return this;
    }

    public final ReportBuilder uncaughtExceptionThread(Thread thread) {
        this.uncaughtExceptionThread = thread;
        return this;
    }

    public final ReportBuilder exception(Throwable th) {
        this.exception = th;
        return this;
    }

    public final ReportBuilder customData(Map<String, String> customData) {
        Intrinsics.checkNotNullParameter(customData, "customData");
        this.customData.putAll(customData);
        return this;
    }

    public final ReportBuilder customData(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.customData.put(key, value);
        return this;
    }

    public final Map<String, String> getCustomData() {
        return new HashMap(this.customData);
    }

    public final ReportBuilder sendSilently() {
        this.isSendSilently = true;
        return this;
    }

    public final ReportBuilder endApplication() {
        this.isEndApplication = true;
        return this;
    }

    public final void build(ReportExecutor reportExecutor) {
        Intrinsics.checkNotNullParameter(reportExecutor, "reportExecutor");
        if (this.message == null && this.exception == null) {
            this.message = "Report requested by developer";
        }
        reportExecutor.execute(this);
    }
}
