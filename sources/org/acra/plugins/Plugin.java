package org.acra.plugins;

import kotlin.Metadata;
import kotlin.jvm.JvmDefault;
import org.acra.config.CoreConfiguration;

/* compiled from: Plugin.kt */
@Metadata(m108d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017¨\u0006\u0006"}, m107d2 = {"Lorg/acra/plugins/Plugin;", "", "enabled", "", "config", "Lorg/acra/config/CoreConfiguration;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public interface Plugin {

    /* compiled from: Plugin.kt */
    /* renamed from: org.acra.plugins.Plugin$-CC  reason: invalid class name */
    /* loaded from: classes4.dex */
    public final /* synthetic */ class CC {
    }

    @JvmDefault
    boolean enabled(CoreConfiguration coreConfiguration);
}
