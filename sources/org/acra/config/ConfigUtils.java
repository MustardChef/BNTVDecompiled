package org.acra.config;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.log.ACRALog;

/* compiled from: ConfigUtils.kt */
@Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m107d2 = {"Lorg/acra/config/ConfigUtils;", "", "()V", "getPluginConfiguration", ExifInterface.GPS_DIRECTION_TRUE, "Lorg/acra/config/Configuration;", "config", "Lorg/acra/config/CoreConfiguration;", "c", "Ljava/lang/Class;", "(Lorg/acra/config/CoreConfiguration;Ljava/lang/Class;)Lorg/acra/config/Configuration;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class ConfigUtils {
    public static final ConfigUtils INSTANCE = new ConfigUtils();

    private ConfigUtils() {
    }

    @JvmStatic
    public static final <T extends Configuration> T getPluginConfiguration(CoreConfiguration config, Class<T> c) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(c, "c");
        if (ACRA.DEV_LOGGING) {
            ACRALog aCRALog = ACRA.log;
            String str = ACRA.LOG_TAG;
            aCRALog.mo69d(str, "Checking plugin Configurations : " + config.getPluginConfigurations() + " for class : " + c);
        }
        Iterator<Configuration> it = config.getPluginConfigurations().iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (ACRA.DEV_LOGGING) {
                ACRALog aCRALog2 = ACRA.log;
                String str2 = ACRA.LOG_TAG;
                aCRALog2.mo69d(str2, "Checking plugin Configuration : " + t + " against plugin class : " + c);
            }
            if (c.isAssignableFrom(t.getClass())) {
                return t;
            }
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus(c.getName(), " is no registered configuration"));
    }
}
