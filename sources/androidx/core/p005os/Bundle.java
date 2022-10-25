package androidx.core.p005os;

import android.os.IBinder;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m108d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007¨\u0006\u000b"}, m107d2 = {"Landroidx/core/os/BundleApi18ImplKt;", "", "()V", "putBinder", "", "bundle", "Landroid/os/Bundle;", SDKConstants.PARAM_KEY, "", "value", "Landroid/os/IBinder;", "core-ktx_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: androidx.core.os.BundleApi18ImplKt */
/* loaded from: classes.dex */
final class Bundle {
    public static final Bundle INSTANCE = new Bundle();

    private Bundle() {
    }

    @JvmStatic
    public static final void putBinder(android.os.Bundle bundle, String key, IBinder iBinder) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.putBinder(key, iBinder);
    }
}
