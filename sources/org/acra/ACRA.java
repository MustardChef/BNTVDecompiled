package org.acra;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Build;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.acra.config.ACRAConfigurationException;
import org.acra.config.CoreConfiguration;
import org.acra.config.CoreConfigurationBuilder;
import org.acra.log.ACRALog;
import org.acra.log.AndroidLogDelegate;
import org.acra.prefs.SharedPreferencesFactory;
import org.acra.reporter.ErrorReporterImpl;
import org.acra.util.StreamReader;
import org.acra.util.StubCreator;

/* compiled from: ACRA.kt */
@Metadata(m108d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u0006H\u0007J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010 \u001a\u00020\u0006H\u0007J\b\u0010#\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R&\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, m107d2 = {"Lorg/acra/ACRA;", "", "()V", "ACRA_PRIVATE_PROCESS_NAME", "", "DEV_LOGGING", "", "LOG_TAG", "PREF_ALWAYS_ACCEPT", "PREF_DISABLE_ACRA", "PREF_ENABLE_ACRA", "PREF_ENABLE_DEVICE_ID", "PREF_ENABLE_SYSTEM_LOGS", "PREF_LAST_VERSION_NR", "PREF_USER_EMAIL_ADDRESS", "<set-?>", "Lorg/acra/ErrorReporter;", "errorReporter", "getErrorReporter$annotations", "getErrorReporter", "()Lorg/acra/ErrorReporter;", "isInitialised", "()Z", "log", "Lorg/acra/log/ACRALog;", "currentProcessName", "init", "", "app", "Landroid/app/Application;", "config", "Lorg/acra/config/CoreConfiguration;", "checkReportsOnApplicationStart", "builder", "Lorg/acra/config/CoreConfigurationBuilder;", "isACRASenderServiceProcess", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class ACRA {
    private static final String ACRA_PRIVATE_PROCESS_NAME = ":acra";
    public static boolean DEV_LOGGING = false;
    public static final ACRA INSTANCE = new ACRA();
    public static final String LOG_TAG;
    public static final String PREF_ALWAYS_ACCEPT = "acra.alwaysaccept";
    public static final String PREF_DISABLE_ACRA = "acra.disable";
    public static final String PREF_ENABLE_ACRA = "acra.enable";
    public static final String PREF_ENABLE_DEVICE_ID = "acra.deviceid.enable";
    public static final String PREF_ENABLE_SYSTEM_LOGS = "acra.syslog.enable";
    public static final String PREF_LAST_VERSION_NR = "acra.lastVersionNr";
    public static final String PREF_USER_EMAIL_ADDRESS = "acra.user.email";
    private static ErrorReporter errorReporter;
    public static ACRALog log;

    @JvmStatic
    public static /* synthetic */ void getErrorReporter$annotations() {
    }

    @JvmStatic
    public static final void init(Application app) {
        Intrinsics.checkNotNullParameter(app, "app");
        init$default(app, (CoreConfigurationBuilder) null, false, 6, (Object) null);
    }

    @JvmStatic
    public static final void init(Application app, CoreConfiguration config) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(config, "config");
        init$default(app, config, false, 4, (Object) null);
    }

    @JvmStatic
    public static final void init(Application app, CoreConfigurationBuilder builder) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(builder, "builder");
        init$default(app, builder, false, 4, (Object) null);
    }

    private ACRA() {
    }

    static {
        String simpleName = ACRA.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "ACRA::class.java.simpleName");
        LOG_TAG = simpleName;
        log = new AndroidLogDelegate();
        errorReporter = StubCreator.INSTANCE.createErrorReporterStub();
    }

    public static final ErrorReporter getErrorReporter() {
        return errorReporter;
    }

    public static /* synthetic */ void init$default(Application application, CoreConfigurationBuilder coreConfigurationBuilder, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            coreConfigurationBuilder = new CoreConfigurationBuilder(application);
        }
        if ((i & 4) != 0) {
            z = true;
        }
        init(application, coreConfigurationBuilder, z);
    }

    @JvmStatic
    public static final void init(Application app, CoreConfigurationBuilder builder, boolean z) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(builder, "builder");
        try {
            init(app, builder.build(), z);
        } catch (ACRAConfigurationException e) {
            log.mo60w(LOG_TAG, "Configuration Error - ACRA not started.", e);
        }
    }

    public static /* synthetic */ void init$default(Application application, CoreConfiguration coreConfiguration, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        init(application, coreConfiguration, z);
    }

    @JvmStatic
    public static final void init(Application app, CoreConfiguration config, boolean z) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(config, "config");
        ACRA acra = INSTANCE;
        boolean isACRASenderServiceProcess = isACRASenderServiceProcess();
        if (isACRASenderServiceProcess && DEV_LOGGING) {
            log.mo69d(LOG_TAG, "Not initialising ACRA to listen for uncaught Exceptions as this is the SendWorker process and we only send reports, we don't capture them to avoid infinite loops");
        }
        boolean z2 = Build.VERSION.SDK_INT >= 14;
        if (!z2) {
            log.mo61w(LOG_TAG, "ACRA 5.1.0+ requires ICS or greater. ACRA is disabled and will NOT catch crashes or send messages.");
        }
        if (acra.isInitialised()) {
            ACRALog aCRALog = log;
            String str = LOG_TAG;
            aCRALog.mo61w(str, "ACRA#init called more than once. This might have unexpected side effects. Doing this outside of tests is discouraged.");
            if (DEV_LOGGING) {
                log.mo69d(str, "Removing old ACRA config...");
            }
            ((ErrorReporterImpl) errorReporter).unregister();
            errorReporter = StubCreator.INSTANCE.createErrorReporterStub();
        }
        SharedPreferences create = new SharedPreferencesFactory(app, config).create();
        if (isACRASenderServiceProcess) {
            return;
        }
        boolean z3 = z2 && SharedPreferencesFactory.Companion.shouldEnableACRA(create);
        ACRALog aCRALog2 = log;
        String str2 = LOG_TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("ACRA is ");
        sb.append(z3 ? "enabled" : "disabled");
        sb.append(" for ");
        sb.append((Object) app.getPackageName());
        sb.append(", initializing...");
        aCRALog2.mo65i(str2, sb.toString());
        ErrorReporterImpl errorReporterImpl = new ErrorReporterImpl(app, config, z3, z2, z);
        errorReporter = errorReporterImpl;
        create.registerOnSharedPreferenceChangeListener(errorReporterImpl);
    }

    public final boolean isInitialised() {
        return errorReporter instanceof ErrorReporterImpl;
    }

    @JvmStatic
    public static final boolean isACRASenderServiceProcess() {
        String currentProcessName = INSTANCE.currentProcessName();
        if (DEV_LOGGING) {
            ACRALog aCRALog = log;
            String str = LOG_TAG;
            aCRALog.mo69d(str, "ACRA processName='" + ((Object) currentProcessName) + '\'');
        }
        return currentProcessName != null && StringsKt.endsWith$default(currentProcessName, ACRA_PRIVATE_PROCESS_NAME, false, 2, (Object) null);
    }

    private final String currentProcessName() {
        try {
            String read = new StreamReader("/proc/self/cmdline").read();
            int length = read.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) read.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            return read.subSequence(i, length + 1).toString();
        } catch (IOException unused) {
            return null;
        }
    }
}
