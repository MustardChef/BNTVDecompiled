package org.acra.config;

import android.content.Context;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.ACRAConstants;
import org.acra.ReportField;
import org.acra.log.ACRALog;
import org.acra.plugins.PluginLoader;
import org.acra.plugins.ServicePluginLoader;
import org.acra.util.StubCreator;

/* compiled from: BaseCoreConfigurationBuilder.kt */
@Metadata(m108d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J#\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0014¢\u0006\u0002\u0010\u0015J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0006J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000fJ!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u000e\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u001f¢\u0006\u0002\u0010 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, m107d2 = {"Lorg/acra/config/BaseCoreConfigurationBuilder;", "", "app", "Landroid/content/Context;", "(Landroid/content/Context;)V", "configBuilders", "", "Lorg/acra/config/ConfigurationBuilder;", "configurations", "Lorg/acra/config/Configuration;", "pluginLoader", "Lorg/acra/plugins/PluginLoader;", "reportContentChanges", "", "Lorg/acra/ReportField;", "", "configurationBuilders", "getPluginConfigurationBuilder", "R", "c", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lorg/acra/config/ConfigurationBuilder;", "pluginConfigurations", "preBuild", "", "setPluginLoader", "setReportField", "field", "enable", "transformReportContent", "reportFields", "", "([Lorg/acra/ReportField;)Ljava/util/List;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class BaseCoreConfigurationBuilder {
    private final Context app;
    private List<? extends ConfigurationBuilder> configBuilders;
    private List<? extends Configuration> configurations;
    private PluginLoader pluginLoader;
    private final Map<ReportField, Boolean> reportContentChanges;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPluginConfigurationBuilder$lambda-7  reason: not valid java name */
    public static final Object m10733getPluginConfigurationBuilder$lambda7(Object obj, Method method, Object[] objArr) {
        return obj;
    }

    public BaseCoreConfigurationBuilder(Context app) {
        Intrinsics.checkNotNullParameter(app, "app");
        this.app = app;
        this.reportContentChanges = new EnumMap(ReportField.class);
        this.pluginLoader = new ServicePluginLoader();
    }

    private final List<ConfigurationBuilder> configurationBuilders() {
        if (this.configBuilders == null) {
            List load = this.pluginLoader.load(ConfigurationBuilderFactory.class);
            if (ACRA.DEV_LOGGING) {
                ACRA.log.mo69d(ACRA.LOG_TAG, Intrinsics.stringPlus("Found ConfigurationBuilderFactories : ", load));
            }
            List<ConfigurationBuilderFactory> list = load;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (ConfigurationBuilderFactory configurationBuilderFactory : list) {
                arrayList.add(configurationBuilderFactory.create(this.app));
            }
            this.configBuilders = arrayList;
        }
        List list2 = this.configBuilders;
        if (list2 != null) {
            return list2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configBuilders");
        throw null;
    }

    public final void setPluginLoader(PluginLoader pluginLoader) {
        Intrinsics.checkNotNullParameter(pluginLoader, "pluginLoader");
        this.pluginLoader = pluginLoader;
    }

    public final PluginLoader pluginLoader() {
        return this.pluginLoader;
    }

    public final void preBuild() throws ACRAConfigurationException {
        List<ConfigurationBuilder> configurationBuilders = configurationBuilders();
        if (ACRA.DEV_LOGGING) {
            ACRA.log.mo69d(ACRA.LOG_TAG, Intrinsics.stringPlus("Found ConfigurationBuilders : ", configurationBuilders));
        }
        List<ConfigurationBuilder> list = configurationBuilders;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ConfigurationBuilder configurationBuilder : list) {
            arrayList.add(configurationBuilder.build());
        }
        this.configurations = arrayList;
    }

    public final List<ReportField> transformReportContent(ReportField[] reportFields) {
        Intrinsics.checkNotNullParameter(reportFields, "reportFields");
        ArrayList arrayList = new ArrayList();
        if (!(reportFields.length == 0)) {
            if (ACRA.DEV_LOGGING) {
                ACRA.log.mo69d(ACRA.LOG_TAG, "Using custom Report Fields");
            }
            CollectionsKt.addAll(arrayList, reportFields);
        } else {
            if (ACRA.DEV_LOGGING) {
                ACRA.log.mo69d(ACRA.LOG_TAG, "Using default Report Fields");
            }
            CollectionsKt.addAll(arrayList, ACRAConstants.DEFAULT_REPORT_FIELDS);
        }
        for (Map.Entry<ReportField, Boolean> entry : this.reportContentChanges.entrySet()) {
            ReportField key = entry.getKey();
            if (entry.getValue().booleanValue()) {
                arrayList.add(key);
            } else {
                arrayList.remove(key);
            }
        }
        return arrayList;
    }

    public final void setReportField(ReportField field, boolean z) {
        Intrinsics.checkNotNullParameter(field, "field");
        this.reportContentChanges.put(field, Boolean.valueOf(z));
    }

    public final List<Configuration> pluginConfigurations() {
        List list = this.configurations;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurations");
        throw null;
    }

    public final <R extends ConfigurationBuilder> R getPluginConfigurationBuilder(Class<R> c) {
        Intrinsics.checkNotNullParameter(c, "c");
        Iterator<ConfigurationBuilder> it = configurationBuilders().iterator();
        while (it.hasNext()) {
            R r = (R) it.next();
            if (c.isAssignableFrom(r.getClass())) {
                return r;
            }
        }
        if (!c.isInterface()) {
            throw new IllegalArgumentException("Class " + ((Object) c.getName()) + " is not a registered ConfigurationBuilder");
        }
        ACRALog aCRALog = ACRA.log;
        String str = ACRA.LOG_TAG;
        aCRALog.mo61w(str, "Couldn't find ConfigurationBuilder " + ((Object) c.getSimpleName()) + ". ALL CALLS TO IT WILL BE IGNORED!");
        StubCreator stubCreator = StubCreator.INSTANCE;
        return (R) StubCreator.createStub(c, C5378xd0453c5b.INSTANCE);
    }
}
