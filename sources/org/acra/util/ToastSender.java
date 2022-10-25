package org.acra.util;

import android.content.Context;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;

/* compiled from: ToastSender.kt */
@Metadata(m108d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, m107d2 = {"Lorg/acra/util/ToastSender;", "", "()V", "sendToast", "", "context", "Landroid/content/Context;", "toast", "", "toastLength", "", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class ToastSender {
    public static final ToastSender INSTANCE = new ToastSender();

    private ToastSender() {
    }

    @JvmStatic
    public static final void sendToast(Context context, String str, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Toast.makeText(context, str, i).show();
        } catch (RuntimeException e) {
            ACRA.log.mo60w(ACRA.LOG_TAG, "Could not send crash Toast", e);
        }
    }
}
