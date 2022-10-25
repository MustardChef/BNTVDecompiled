package org.acra.scheduler;

import kotlin.Metadata;
import org.acra.sender.LegacySenderService;

/* compiled from: SenderScheduler.kt */
@Metadata(m108d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m107d2 = {"Lorg/acra/scheduler/SenderScheduler;", "", "scheduleReportSending", "", LegacySenderService.EXTRA_ONLY_SEND_SILENT_REPORTS, "", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public interface SenderScheduler {
    void scheduleReportSending(boolean z);
}
