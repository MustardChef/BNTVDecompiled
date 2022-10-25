package org.acra.config;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m108d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006¨\u0006\u0007"}, m107d2 = {"toast", "", "Lorg/acra/config/CoreConfigurationBuilder;", "initializer", "Lkotlin/Function1;", "Lorg/acra/config/ToastConfigurationBuilder;", "Lkotlin/ExtensionFunctionType;", "acra-toast_release"}, m106k = 2, m105mv = {1, 5, 1}, m103xi = 48)
/* renamed from: org.acra.config.ToastExtensionsKt */
/* loaded from: classes4.dex */
public final class ToastExtensions {
    public static final void toast(CoreConfigurationBuilder coreConfigurationBuilder, Function1<? super ToastConfigurationBuilder, Unit> initializer) {
        Intrinsics.checkNotNullParameter(coreConfigurationBuilder, "<this>");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        ToastConfigurationBuilder toastConfigurationBuilder = (ToastConfigurationBuilder) coreConfigurationBuilder.getPluginConfigurationBuilder(ToastConfigurationBuilder.class);
        toastConfigurationBuilder.setEnabled(true);
        initializer.invoke(toastConfigurationBuilder);
    }
}
