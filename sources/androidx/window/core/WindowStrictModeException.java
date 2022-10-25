package androidx.window.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpecificationComputer.kt */
@Metadata(m108d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m107d2 = {"Landroidx/window/core/WindowStrictModeException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "window_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes.dex */
public final class WindowStrictModeException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowStrictModeException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
