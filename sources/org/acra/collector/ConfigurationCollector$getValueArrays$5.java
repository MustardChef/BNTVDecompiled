package org.acra.collector;

import android.util.SparseArray;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.acra.collector.ConfigurationCollector;

/* compiled from: ConfigurationCollector.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n"}, m107d2 = {"<anonymous>", "Landroid/util/SparseArray;", "", "kotlin.jvm.PlatformType", "it", "Lorg/acra/collector/ConfigurationCollector$Prefix;"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
final class ConfigurationCollector$getValueArrays$5 extends Lambda implements Function1<ConfigurationCollector.Prefix, SparseArray<String>> {
    public static final ConfigurationCollector$getValueArrays$5 INSTANCE = new ConfigurationCollector$getValueArrays$5();

    ConfigurationCollector$getValueArrays$5() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final SparseArray<String> invoke(ConfigurationCollector.Prefix prefix) {
        return new SparseArray<>();
    }
}
