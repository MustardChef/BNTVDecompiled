package org.acra.util;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p043io.FilesKt;
import org.acra.ACRA;

/* compiled from: Installation.kt */
@Metadata(m108d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, m107d2 = {"Lorg/acra/util/Installation;", "", "()V", "INSTALLATION", "", "id", "context", "Landroid/content/Context;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class Installation {
    private static final String INSTALLATION = "ACRA-INSTALLATION";
    public static final Installation INSTANCE = new Installation();

    private Installation() {
    }

    @JvmStatic
    /* renamed from: id */
    public static final synchronized String m58id(Context context) {
        String str;
        synchronized (Installation.class) {
            Intrinsics.checkNotNullParameter(context, "context");
            File file = new File(context.getFilesDir(), INSTALLATION);
            try {
                try {
                    if (!file.exists()) {
                        String uuid = UUID.randomUUID().toString();
                        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
                        FilesKt.writeText$default(file, uuid, null, 2, null);
                    }
                    str = FilesKt.readText$default(file, null, 1, null);
                } catch (RuntimeException e) {
                    ACRA.log.mo60w(ACRA.LOG_TAG, Intrinsics.stringPlus("Couldn't retrieve InstallationId for ", context.getPackageName()), e);
                    str = "Couldn't retrieve InstallationId";
                }
            } catch (IOException e2) {
                ACRA.log.mo60w(ACRA.LOG_TAG, Intrinsics.stringPlus("Couldn't retrieve InstallationId for ", context.getPackageName()), e2);
                str = "Couldn't retrieve InstallationId";
            }
        }
        return str;
    }
}
