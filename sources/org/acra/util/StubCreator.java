package org.acra.util;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.ErrorReporter;
import org.acra.log.ACRALog;

/* compiled from: StubCreator.kt */
@Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J)\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u0005\u001a\u0002H\u0006\"\u0006\b\u0000\u0010\u0006\u0018\u00012\u0006\u0010\t\u001a\u00020\nH\u0086\b¢\u0006\u0002\u0010\f¨\u0006\r"}, m107d2 = {"Lorg/acra/util/StubCreator;", "", "()V", "createErrorReporterStub", "Lorg/acra/ErrorReporter;", "createStub", ExifInterface.GPS_DIRECTION_TRUE, "interfaceClass", "Ljava/lang/Class;", "handler", "Ljava/lang/reflect/InvocationHandler;", "(Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;", "(Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class StubCreator {
    public static final StubCreator INSTANCE = new StubCreator();

    private StubCreator() {
    }

    public final ErrorReporter createErrorReporterStub() {
        return (ErrorReporter) createStub(ErrorReporter.class, $$Lambda$StubCreator$cseOmL3qlPhM3bemnM52ktf_TTE.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createErrorReporterStub$lambda-1  reason: not valid java name */
    public static final Object m10751createErrorReporterStub$lambda1(Object obj, Method method, Object[] objArr) {
        ACRA acra = ACRA.INSTANCE;
        String str = ACRA.isACRASenderServiceProcess() ? "in SenderService process" : "before ACRA#init (if you did call #init, check if your configuration is valid)";
        ACRALog aCRALog = ACRA.log;
        String str2 = ACRA.LOG_TAG;
        aCRALog.mo61w(str2, "ErrorReporter#" + ((Object) method.getName()) + " called " + str + ". THIS CALL WILL BE IGNORED!");
        return null;
    }

    public final /* synthetic */ <T> T createStub(InvocationHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) createStub(Object.class, handler);
    }

    @JvmStatic
    public static final <T> T createStub(Class<T> interfaceClass, InvocationHandler handler) {
        Intrinsics.checkNotNullParameter(interfaceClass, "interfaceClass");
        Intrinsics.checkNotNullParameter(handler, "handler");
        return (T) Proxy.newProxyInstance(StubCreator.class.getClassLoader(), new Class[]{interfaceClass}, handler);
    }
}
