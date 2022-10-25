package org.acra.plugins;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.acra.config.CoreConfiguration;

/* compiled from: SimplePluginLoader.kt */
@Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B+\b\u0007\u0012\"\u0010\u0002\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0003\"\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J&\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\b\b\u0000\u0010\n*\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004H\u0016J.\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\b\b\u0000\u0010\n*\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004H\u0016R \u0010\u0002\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000f"}, m107d2 = {"Lorg/acra/plugins/SimplePluginLoader;", "Lorg/acra/plugins/PluginLoader;", "plugins", "", "Ljava/lang/Class;", "Lorg/acra/plugins/Plugin;", "([Ljava/lang/Class;)V", "[Ljava/lang/Class;", "load", "", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "loadEnabled", "config", "Lorg/acra/config/CoreConfiguration;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class SimplePluginLoader implements PluginLoader {
    private final Class<? extends Plugin>[] plugins;

    @SafeVarargs
    public SimplePluginLoader(Class<? extends Plugin>... plugins) {
        Intrinsics.checkNotNullParameter(plugins, "plugins");
        this.plugins = plugins;
    }

    @Override // org.acra.plugins.PluginLoader
    public <T extends Plugin> List<T> loadEnabled(CoreConfiguration config, Class<T> clazz) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        ArrayList arrayList = new ArrayList();
        for (Object obj : load(clazz)) {
            if (((Plugin) obj).enabled(config)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065 A[SYNTHETIC] */
    @Override // org.acra.plugins.PluginLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T extends org.acra.plugins.Plugin> java.util.List<T> load(java.lang.Class<T> r10) {
        /*
            r9 = this;
            java.lang.String r0 = "clazz"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            boolean r0 = org.acra.ACRA.DEV_LOGGING
            if (r0 == 0) goto L18
            org.acra.log.ACRALog r0 = org.acra.ACRA.log
            java.lang.String r1 = org.acra.ACRA.LOG_TAG
            java.lang.Class<? extends org.acra.plugins.Plugin>[] r2 = r9.plugins
            java.lang.String r3 = "SimplePluginLoader loading services from plugin classes : "
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r2)
            r0.mo69d(r1, r2)
        L18:
            java.lang.Class<? extends org.acra.plugins.Plugin>[] r0 = r9.plugins
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            int r2 = r0.length
            r3 = 0
        L23:
            if (r3 >= r2) goto L68
            r4 = r0[r3]
            boolean r5 = r10.isAssignableFrom(r4)
            if (r5 == 0) goto L5f
            java.lang.Object r5 = r4.newInstance()     // Catch: java.lang.Exception -> L4f
            if (r5 == 0) goto L47
            org.acra.plugins.Plugin r5 = (org.acra.plugins.Plugin) r5     // Catch: java.lang.Exception -> L4f
            boolean r6 = org.acra.ACRA.DEV_LOGGING     // Catch: java.lang.Exception -> L4f
            if (r6 == 0) goto L60
            org.acra.log.ACRALog r6 = org.acra.ACRA.log     // Catch: java.lang.Exception -> L4f
            java.lang.String r7 = org.acra.ACRA.LOG_TAG     // Catch: java.lang.Exception -> L4f
            java.lang.String r8 = "Loaded plugin from class : "
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r8, r4)     // Catch: java.lang.Exception -> L4f
            r6.mo69d(r7, r8)     // Catch: java.lang.Exception -> L4f
            goto L60
        L47:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException     // Catch: java.lang.Exception -> L4f
            java.lang.String r6 = "null cannot be cast to non-null type T of org.acra.plugins.SimplePluginLoader.load$lambda-3"
            r5.<init>(r6)     // Catch: java.lang.Exception -> L4f
            throw r5     // Catch: java.lang.Exception -> L4f
        L4f:
            r5 = move-exception
            org.acra.log.ACRALog r6 = org.acra.ACRA.log
            java.lang.String r7 = org.acra.ACRA.LOG_TAG
            java.lang.String r8 = "Could not load plugin from class : "
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r8, r4)
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r6.mo60w(r7, r4, r5)
        L5f:
            r5 = 0
        L60:
            if (r5 == 0) goto L65
            r1.add(r5)
        L65:
            int r3 = r3 + 1
            goto L23
        L68:
            java.util.List r1 = (java.util.List) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.acra.plugins.SimplePluginLoader.load(java.lang.Class):java.util.List");
    }
}
