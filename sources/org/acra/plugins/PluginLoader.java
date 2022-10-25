package org.acra.plugins;

import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import org.acra.config.CoreConfiguration;

/* compiled from: PluginLoader.kt */
@Metadata(m108d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0007H&J.\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0007H&¨\u0006\u000b"}, m107d2 = {"Lorg/acra/plugins/PluginLoader;", "Ljava/io/Serializable;", "load", "", ExifInterface.GPS_DIRECTION_TRUE, "Lorg/acra/plugins/Plugin;", "clazz", "Ljava/lang/Class;", "loadEnabled", "config", "Lorg/acra/config/CoreConfiguration;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public interface PluginLoader extends Serializable {
    <T extends Plugin> List<T> load(Class<T> cls);

    <T extends Plugin> List<T> loadEnabled(CoreConfiguration coreConfiguration, Class<T> cls);
}
