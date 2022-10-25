package org.acra;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import org.acra.scheduler.SenderScheduler;

/* compiled from: ErrorReporter.kt */
@Metadata(m108d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\tH&J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u001a\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000fH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0016"}, m107d2 = {"Lorg/acra/ErrorReporter;", "", "reportScheduler", "Lorg/acra/scheduler/SenderScheduler;", "getReportScheduler", "()Lorg/acra/scheduler/SenderScheduler;", "clearCustomData", "", "getCustomData", "", SDKConstants.PARAM_KEY, "handleException", "e", "", "endApplication", "", "handleSilentException", "putCustomData", "value", "removeCustomData", "setEnabled", "enabled", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public interface ErrorReporter {
    void clearCustomData();

    String getCustomData(String str);

    SenderScheduler getReportScheduler();

    void handleException(Throwable th);

    void handleException(Throwable th, boolean z);

    void handleSilentException(Throwable th);

    String putCustomData(String str, String str2);

    String removeCustomData(String str);

    void setEnabled(boolean z);
}
