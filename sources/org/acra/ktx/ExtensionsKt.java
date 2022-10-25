package org.acra.ktx;

import android.app.Application;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.config.ConfigurationBuilder;
import org.acra.config.CoreConfigurationBuilder;

/* compiled from: Extensions.kt */
@Metadata(m108d1 = {"\u0000.\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0086\b¢\u0006\u0002\u0010\u0004\u001a%\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0019\b\u0002\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\n\u001a5\u0010\u000b\u001a\u00020\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001a\n\u0010\f\u001a\u00020\u0006*\u00020\r\u001a\n\u0010\u000e\u001a\u00020\u0006*\u00020\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f"}, m107d2 = {"getPluginConfigurationBuilder", ExifInterface.GPS_DIRECTION_TRUE, "Lorg/acra/config/ConfigurationBuilder;", "Lorg/acra/config/CoreConfigurationBuilder;", "(Lorg/acra/config/CoreConfigurationBuilder;)Lorg/acra/config/ConfigurationBuilder;", "initAcra", "", "Landroid/app/Application;", "initializer", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "plugin", "sendSilentlyWithAcra", "", "sendWithAcra", "acra-core_release"}, m106k = 2, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class ExtensionsKt {
    public static final /* synthetic */ <T extends ConfigurationBuilder> T getPluginConfigurationBuilder(CoreConfigurationBuilder coreConfigurationBuilder) {
        Intrinsics.checkNotNullParameter(coreConfigurationBuilder, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) coreConfigurationBuilder.getPluginConfigurationBuilder(ConfigurationBuilder.class);
    }

    public static /* synthetic */ void initAcra$default(Application application, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = ExtensionsKt$initAcra$1.INSTANCE;
        }
        initAcra(application, function1);
    }

    public static final void initAcra(Application application, Function1<? super CoreConfigurationBuilder, Unit> initializer) {
        Intrinsics.checkNotNullParameter(application, "<this>");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        CoreConfigurationBuilder coreConfigurationBuilder = new CoreConfigurationBuilder(application);
        initializer.invoke(coreConfigurationBuilder);
        ACRA acra = ACRA.INSTANCE;
        ACRA.init$default(application, coreConfigurationBuilder, false, 4, (Object) null);
    }

    public static final void sendWithAcra(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        ACRA acra = ACRA.INSTANCE;
        ACRA.getErrorReporter().handleException(th);
    }

    public static final void sendSilentlyWithAcra(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        ACRA acra = ACRA.INSTANCE;
        ACRA.getErrorReporter().handleSilentException(th);
    }

    public static final /* synthetic */ <T extends ConfigurationBuilder> void plugin(CoreConfigurationBuilder coreConfigurationBuilder, Function1<? super T, Unit> initializer) {
        Intrinsics.checkNotNullParameter(coreConfigurationBuilder, "<this>");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        initializer.invoke(coreConfigurationBuilder.getPluginConfigurationBuilder(ConfigurationBuilder.class));
    }
}
