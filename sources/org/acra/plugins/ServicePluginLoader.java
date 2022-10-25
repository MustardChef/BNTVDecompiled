package org.acra.plugins;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.config.CoreConfiguration;
import org.acra.log.ACRALog;

/* compiled from: ServicePluginLoader.kt */
@Metadata(m108d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\bH\u0016J.\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\bH\u0016J:\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¨\u0006\u0010"}, m107d2 = {"Lorg/acra/plugins/ServicePluginLoader;", "Lorg/acra/plugins/PluginLoader;", "()V", "load", "", ExifInterface.GPS_DIRECTION_TRUE, "Lorg/acra/plugins/Plugin;", "clazz", "Ljava/lang/Class;", "loadEnabled", "config", "Lorg/acra/config/CoreConfiguration;", "loadInternal", "shouldLoadPredicate", "Lkotlin/Function1;", "", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class ServicePluginLoader implements PluginLoader {
    @Override // org.acra.plugins.PluginLoader
    public <T extends Plugin> List<T> load(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return loadInternal(clazz, ServicePluginLoader$load$1.INSTANCE);
    }

    @Override // org.acra.plugins.PluginLoader
    public <T extends Plugin> List<T> loadEnabled(CoreConfiguration config, Class<T> clazz) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return loadInternal(clazz, new ServicePluginLoader$loadEnabled$1(config));
    }

    private final <T extends Plugin> List<T> loadInternal(Class<T> cls, Function1<? super T, Boolean> function1) {
        ArrayList arrayList = new ArrayList();
        ServiceLoader load = ServiceLoader.load(cls, getClass().getClassLoader());
        if (ACRA.DEV_LOGGING) {
            ACRA.log.mo69d(ACRA.LOG_TAG, Intrinsics.stringPlus("ServicePluginLoader loading services from ServiceLoader : ", load));
        }
        Iterator it = load.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "serviceLoader.iterator()");
        while (it.hasNext()) {
            try {
                try {
                    Plugin plugin = (Plugin) it.next();
                    if (function1.invoke(plugin).booleanValue()) {
                        if (ACRA.DEV_LOGGING) {
                            ACRALog aCRALog = ACRA.log;
                            String str = ACRA.LOG_TAG;
                            aCRALog.mo69d(str, "Loaded " + ((Object) cls.getSimpleName()) + " of type " + ((Object) plugin.getClass().getName()));
                        }
                        arrayList.add(plugin);
                    } else if (ACRA.DEV_LOGGING) {
                        ACRALog aCRALog2 = ACRA.log;
                        String str2 = ACRA.LOG_TAG;
                        aCRALog2.mo69d(str2, "Ignoring disabled " + ((Object) cls.getSimpleName()) + " of type " + ((Object) plugin.getClass().getSimpleName()));
                    }
                } catch (ServiceConfigurationError e) {
                    ACRA.log.mo66e(ACRA.LOG_TAG, Intrinsics.stringPlus("Unable to load ", cls.getSimpleName()), e);
                }
            } catch (ServiceConfigurationError e2) {
                ACRA.log.mo66e(ACRA.LOG_TAG, Intrinsics.stringPlus("Broken ServiceLoader for ", cls.getSimpleName()), e2);
            }
        }
        return arrayList;
    }
}
