package org.acra.sender;

import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import org.acra.config.DefaultRetryPolicy;
import org.acra.config.RetryPolicy;

/* compiled from: ReportDistributor.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m107d2 = {"<anonymous>", "Lorg/acra/config/RetryPolicy;"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
final class ReportDistributor$sendCrashReport$4 extends Lambda implements Functions<RetryPolicy> {
    public static final ReportDistributor$sendCrashReport$4 INSTANCE = new ReportDistributor$sendCrashReport$4();

    ReportDistributor$sendCrashReport$4() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Functions
    public final RetryPolicy invoke() {
        return new DefaultRetryPolicy();
    }
}
