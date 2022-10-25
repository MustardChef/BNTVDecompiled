package org.acra.config;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.acra.config.RetryPolicy;
import org.acra.sender.ReportSender;

/* compiled from: DefaultRetryPolicy.kt */
@Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\u0016¨\u0006\n"}, m107d2 = {"Lorg/acra/config/DefaultRetryPolicy;", "Lorg/acra/config/RetryPolicy;", "()V", "shouldRetrySend", "", "senders", "", "Lorg/acra/sender/ReportSender;", "failedSenders", "Lorg/acra/config/RetryPolicy$FailedSender;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class DefaultRetryPolicy implements RetryPolicy {
    @Override // org.acra.config.RetryPolicy
    public boolean shouldRetrySend(List<? extends ReportSender> senders, List<RetryPolicy.FailedSender> failedSenders) {
        Intrinsics.checkNotNullParameter(senders, "senders");
        Intrinsics.checkNotNullParameter(failedSenders, "failedSenders");
        return senders.size() == failedSenders.size() && (senders.isEmpty() ^ true);
    }
}
