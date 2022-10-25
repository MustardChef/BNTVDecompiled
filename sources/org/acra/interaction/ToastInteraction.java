package org.acra.interaction;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.acra.config.ConfigUtils;
import org.acra.config.CoreConfiguration;
import org.acra.config.ToastConfiguration;
import org.acra.plugins.HasConfigPlugin;
import org.acra.util.ToastSender;

/* compiled from: ToastInteraction.kt */
@Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, m107d2 = {"Lorg/acra/interaction/ToastInteraction;", "Lorg/acra/plugins/HasConfigPlugin;", "Lorg/acra/interaction/ReportInteraction;", "()V", "getLengthInMs", "", "toastDuration", "performInteraction", "", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "reportFile", "Ljava/io/File;", "acra-toast_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public class ToastInteraction extends HasConfigPlugin implements ReportInteraction {
    private final int getLengthInMs(int i) {
        if (i != 0) {
            return i != 1 ? 0 : 3500;
        }
        return 2000;
    }

    public ToastInteraction() {
        super(ToastConfiguration.class);
    }

    @Override // org.acra.interaction.ReportInteraction
    public boolean performInteraction(Context context, CoreConfiguration config, File reportFile) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportFile, "reportFile");
        Looper.prepare();
        ConfigUtils configUtils = ConfigUtils.INSTANCE;
        ToastConfiguration toastConfiguration = (ToastConfiguration) ConfigUtils.getPluginConfiguration(config, ToastConfiguration.class);
        ToastSender toastSender = ToastSender.INSTANCE;
        ToastSender.sendToast(context, toastConfiguration.getText(), toastConfiguration.getLength());
        final Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            new Handler(myLooper).postDelayed(new Runnable() { // from class: org.acra.interaction.-$$Lambda$ToastInteraction$xakohZxpW8_JKqKhh2UaxbpeUK4
                @Override // java.lang.Runnable
                public final void run() {
                    ToastInteraction.m10737performInteraction$lambda0(myLooper);
                }
            }, getLengthInMs(toastConfiguration.getLength()) + 100);
            Looper.loop();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: performInteraction$lambda-0  reason: not valid java name */
    public static final void m10737performInteraction$lambda0(Looper looper) {
        if (Build.VERSION.SDK_INT >= 18) {
            looper.quitSafely();
        } else {
            looper.quit();
        }
    }
}
