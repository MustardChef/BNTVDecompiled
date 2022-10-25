package org.acra.config;

import android.content.Context;
import kotlin.Metadata;
import org.acra.plugins.Plugin;

/* compiled from: ConfigurationBuilderFactory.kt */
@Metadata(m108d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m107d2 = {"Lorg/acra/config/ConfigurationBuilderFactory;", "Lorg/acra/plugins/Plugin;", "create", "Lorg/acra/config/ConfigurationBuilder;", "annotatedContext", "Landroid/content/Context;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public interface ConfigurationBuilderFactory extends Plugin {
    ConfigurationBuilder create(Context context);
}
