package org.acra.plugins;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.acra.config.CoreConfiguration;

/* compiled from: PluginLoader.kt */
@Metadata(m108d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a'\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\b¨\u0006\u0007"}, m107d2 = {"loadEnabled", "", ExifInterface.GPS_DIRECTION_TRUE, "Lorg/acra/plugins/Plugin;", "Lorg/acra/plugins/PluginLoader;", "config", "Lorg/acra/config/CoreConfiguration;", "acra-core_release"}, m106k = 2, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class PluginLoaderKt {
    public static final /* synthetic */ <T extends Plugin> List<T> loadEnabled(PluginLoader pluginLoader, CoreConfiguration config) {
        Intrinsics.checkNotNullParameter(pluginLoader, "<this>");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return pluginLoader.loadEnabled(config, Plugin.class);
    }
}
