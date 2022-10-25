package com.lagradost.cloudstream3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.acra.ReportField;
import org.acra.config.CoreConfigurationBuilder;
import org.acra.data.StringFormat;

/* compiled from: AcraApplication.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lorg/acra/config/CoreConfigurationBuilder;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
final class AcraApplication$attachBaseContext$1 extends Lambda implements Function1<CoreConfigurationBuilder, Unit> {
    public static final AcraApplication$attachBaseContext$1 INSTANCE = new AcraApplication$attachBaseContext$1();

    AcraApplication$attachBaseContext$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CoreConfigurationBuilder coreConfigurationBuilder) {
        invoke2(coreConfigurationBuilder);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(CoreConfigurationBuilder initAcra) {
        Intrinsics.checkNotNullParameter(initAcra, "$this$initAcra");
        initAcra.setBuildConfigClass(BuildConfig.class);
        initAcra.setReportFormat(StringFormat.JSON);
        initAcra.setReportContent(new ReportField[]{ReportField.BUILD_CONFIG, ReportField.USER_CRASH_DATE, ReportField.ANDROID_VERSION, ReportField.PHONE_MODEL, ReportField.STACK_TRACE});
    }
}
