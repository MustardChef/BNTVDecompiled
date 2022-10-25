package org.acra.config;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderException;

/* compiled from: RetryPolicy.kt */
@Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\tJ$\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H&¨\u0006\n"}, m107d2 = {"Lorg/acra/config/RetryPolicy;", "", "shouldRetrySend", "", "senders", "", "Lorg/acra/sender/ReportSender;", "failedSenders", "Lorg/acra/config/RetryPolicy$FailedSender;", "FailedSender", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public interface RetryPolicy {
    boolean shouldRetrySend(List<? extends ReportSender> list, List<FailedSender> list2);

    /* compiled from: RetryPolicy.kt */
    @Metadata(m108d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m107d2 = {"Lorg/acra/config/RetryPolicy$FailedSender;", "", "sender", "Lorg/acra/sender/ReportSender;", "exception", "Lorg/acra/sender/ReportSenderException;", "(Lorg/acra/sender/ReportSender;Lorg/acra/sender/ReportSenderException;)V", "getException", "()Lorg/acra/sender/ReportSenderException;", "getSender", "()Lorg/acra/sender/ReportSender;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class FailedSender {
        private final ReportSenderException exception;
        private final ReportSender sender;

        public FailedSender(ReportSender sender, ReportSenderException exception) {
            Intrinsics.checkNotNullParameter(sender, "sender");
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.sender = sender;
            this.exception = exception;
        }

        public final ReportSenderException getException() {
            return this.exception;
        }

        public final ReportSender getSender() {
            return this.sender;
        }
    }
}
