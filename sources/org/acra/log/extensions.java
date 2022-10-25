package org.acra.log;

import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;

@Metadata(m108d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a\u001a\u0010\u0005\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a\"\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a\u001a\u0010\b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a\u001a\u0010\t\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u001a\"\u0010\t\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, m107d2 = {"debug", "", "messageGenerator", "Lkotlin/Function0;", "", "error", "throwable", "", "info", "warn", "acra-core_release"}, m106k = 2, m105mv = {1, 5, 1}, m103xi = 48)
/* renamed from: org.acra.log.ExtensionsKt */
/* loaded from: classes4.dex */
public final class extensions {
    public static final void debug(Functions<String> messageGenerator) {
        Intrinsics.checkNotNullParameter(messageGenerator, "messageGenerator");
        if (ACRA.DEV_LOGGING) {
            ACRA.log.mo69d(ACRA.LOG_TAG, messageGenerator.invoke());
        }
    }

    public static final void info(Functions<String> messageGenerator) {
        Intrinsics.checkNotNullParameter(messageGenerator, "messageGenerator");
        ACRA.log.mo65i(ACRA.LOG_TAG, messageGenerator.invoke());
    }

    public static final void warn(Functions<String> messageGenerator) {
        Intrinsics.checkNotNullParameter(messageGenerator, "messageGenerator");
        ACRA.log.mo61w(ACRA.LOG_TAG, messageGenerator.invoke());
    }

    public static final void warn(Throwable throwable, Functions<String> messageGenerator) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(messageGenerator, "messageGenerator");
        ACRA.log.mo60w(ACRA.LOG_TAG, messageGenerator.invoke(), throwable);
    }

    public static final void error(Functions<String> messageGenerator) {
        Intrinsics.checkNotNullParameter(messageGenerator, "messageGenerator");
        ACRA.log.mo67e(ACRA.LOG_TAG, messageGenerator.invoke());
    }

    public static final void error(Throwable throwable, Functions<String> messageGenerator) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(messageGenerator, "messageGenerator");
        ACRA.log.mo66e(ACRA.LOG_TAG, messageGenerator.invoke(), throwable);
    }
}
