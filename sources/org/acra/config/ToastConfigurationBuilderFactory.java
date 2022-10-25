package org.acra.config;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ToastConfigurationBuilderFactory.kt */
@Metadata(m108d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, m107d2 = {"Lorg/acra/config/ToastConfigurationBuilderFactory;", "Lorg/acra/config/ConfigurationBuilderFactory;", "()V", "create", "Lorg/acra/config/ConfigurationBuilder;", "arg0", "Landroid/content/Context;", "acra-toast_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public class ToastConfigurationBuilderFactory implements ConfigurationBuilderFactory {
    @Override // org.acra.plugins.Plugin
    public /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration) {
        return Intrinsics.checkNotNullParameter(coreConfiguration, "config");
    }

    @Override // org.acra.config.ConfigurationBuilderFactory
    public ConfigurationBuilder create(Context arg0) {
        Intrinsics.checkNotNullParameter(arg0, "arg0");
        return new ToastConfigurationBuilder(arg0);
    }
}
