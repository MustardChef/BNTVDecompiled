package org.acra.plugins;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ServicePluginLoader.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n"}, m107d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lorg/acra/plugins/Plugin;", "it"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
final class ServicePluginLoader$load$1 extends Lambda implements Function1<T, Boolean> {
    public static final ServicePluginLoader$load$1 INSTANCE = new ServicePluginLoader$load$1();

    ServicePluginLoader$load$1() {
        super(1);
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)Z */
    public final boolean invoke(Plugin it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return Boolean.valueOf(invoke((Plugin) obj));
    }
}
