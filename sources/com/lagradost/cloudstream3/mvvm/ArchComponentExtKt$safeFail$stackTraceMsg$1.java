package com.lagradost.cloudstream3.mvvm;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: ArchComponentExt.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, m107d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it", "Ljava/lang/StackTraceElement;", "kotlin.jvm.PlatformType", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
final class ArchComponentExtKt$safeFail$stackTraceMsg$1 extends Lambda implements Function1<StackTraceElement, CharSequence> {
    public static final ArchComponentExtKt$safeFail$stackTraceMsg$1 INSTANCE = new ArchComponentExtKt$safeFail$stackTraceMsg$1();

    ArchComponentExtKt$safeFail$stackTraceMsg$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(StackTraceElement stackTraceElement) {
        return stackTraceElement.getFileName() + ' ' + stackTraceElement.getLineNumber();
    }
}
