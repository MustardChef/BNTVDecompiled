package org.acra.ktx;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.acra.config.CoreConfigurationBuilder;

/* compiled from: Extensions.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m107d2 = {"<anonymous>", "", "Lorg/acra/config/CoreConfigurationBuilder;"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
final class ExtensionsKt$initAcra$1 extends Lambda implements Function1<CoreConfigurationBuilder, Unit> {
    public static final ExtensionsKt$initAcra$1 INSTANCE = new ExtensionsKt$initAcra$1();

    ExtensionsKt$initAcra$1() {
        super(1);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(CoreConfigurationBuilder coreConfigurationBuilder) {
        Intrinsics.checkNotNullParameter(coreConfigurationBuilder, "$this$null");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CoreConfigurationBuilder coreConfigurationBuilder) {
        invoke2(coreConfigurationBuilder);
        return Unit.INSTANCE;
    }
}
