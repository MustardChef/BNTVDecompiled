package org.acra.plugins;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.acra.config.ConfigUtils;
import org.acra.config.Configuration;
import org.acra.config.CoreConfiguration;

/* compiled from: HasConfigPlugin.kt */
@Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m107d2 = {"Lorg/acra/plugins/HasConfigPlugin;", "Lorg/acra/plugins/Plugin;", "configClass", "Ljava/lang/Class;", "Lorg/acra/config/Configuration;", "(Ljava/lang/Class;)V", "enabled", "", "config", "Lorg/acra/config/CoreConfiguration;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public abstract class HasConfigPlugin implements Plugin {
    private final Class<? extends Configuration> configClass;

    public HasConfigPlugin(Class<? extends Configuration> configClass) {
        Intrinsics.checkNotNullParameter(configClass, "configClass");
        this.configClass = configClass;
    }

    @Override // org.acra.plugins.Plugin
    public boolean enabled(CoreConfiguration config) {
        Intrinsics.checkNotNullParameter(config, "config");
        ConfigUtils configUtils = ConfigUtils.INSTANCE;
        return ConfigUtils.getPluginConfiguration(config, this.configClass).enabled();
    }
}
