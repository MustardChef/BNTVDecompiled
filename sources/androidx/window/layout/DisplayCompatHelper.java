package androidx.window.layout;

import android.graphics.Point;
import android.view.Display;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m108d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, m107d2 = {"Landroidx/window/layout/DisplayCompatHelperApi17;", "", "()V", "getRealSize", "", "display", "Landroid/view/Display;", "point", "Landroid/graphics/Point;", "window_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: androidx.window.layout.DisplayCompatHelperApi17 */
/* loaded from: classes.dex */
public final class DisplayCompatHelper {
    public static final DisplayCompatHelper INSTANCE = new DisplayCompatHelper();

    private DisplayCompatHelper() {
    }

    public final void getRealSize(Display display, Point point) {
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(point, "point");
        display.getRealSize(point);
    }
}
