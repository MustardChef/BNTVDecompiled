package org.acra.sender;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.config.CoreConfiguration;
import org.acra.util.IOUtils;

/* compiled from: LegacySenderService.kt */
@Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¨\u0006\f"}, m107d2 = {"Lorg/acra/sender/LegacySenderService;", "Landroid/app/Service;", "()V", "onBind", "Landroid/os/IBinder;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "onStartCommand", "", "flags", "startId", "Companion", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class LegacySenderService extends Service {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_ACRA_CONFIG = "acraConfig";
    public static final String EXTRA_ONLY_SEND_SILENT_REPORTS = "onlySendSilentReports";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i, int i2) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent.hasExtra(EXTRA_ACRA_CONFIG)) {
            final CoreConfiguration coreConfiguration = (CoreConfiguration) IOUtils.INSTANCE.deserialize(CoreConfiguration.class, intent.getStringExtra(EXTRA_ACRA_CONFIG));
            if (coreConfiguration != null) {
                new Thread(new Runnable() { // from class: org.acra.sender.-$$Lambda$LegacySenderService$4jBYgL666psyc7DNRdmsxJxd71Q
                    @Override // java.lang.Runnable
                    public final void run() {
                        LegacySenderService.m10740onStartCommand$lambda0(LegacySenderService.this, coreConfiguration, intent);
                    }
                }).start();
                return 3;
            }
            return 3;
        } else if (ACRA.DEV_LOGGING) {
            ACRA.log.mo69d(ACRA.LOG_TAG, "SenderService was started but no valid intent was delivered, will now quit");
            return 3;
        } else {
            return 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onStartCommand$lambda-0  reason: not valid java name */
    public static final void m10740onStartCommand$lambda0(LegacySenderService this$0, CoreConfiguration coreConfiguration, Intent intent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        SendingConductor sendingConductor = new SendingConductor(this$0, coreConfiguration);
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        sendingConductor.sendReports(false, extras);
        this$0.stopSelf();
    }

    /* compiled from: LegacySenderService.kt */
    @Metadata(m108d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m107d2 = {"Lorg/acra/sender/LegacySenderService$Companion;", "", "()V", "EXTRA_ACRA_CONFIG", "", "EXTRA_ONLY_SEND_SILENT_REPORTS", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
