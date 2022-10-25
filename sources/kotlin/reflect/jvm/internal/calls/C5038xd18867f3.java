package kotlin.reflect.jvm.internal.calls;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: AnnotationConstructorCaller.kt */
@Metadata(m108d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H\n¢\u0006\u0002\b\u0007"}, m107d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "entry", "", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1 */
/* loaded from: classes4.dex */
final class C5038xd18867f3 extends Lambda implements Function1<Map.Entry<? extends String, ? extends Object>, CharSequence> {
    public static final C5038xd18867f3 INSTANCE = new C5038xd18867f3();

    C5038xd18867f3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends Object> entry) {
        return invoke2((Map.Entry<String, ? extends Object>) entry);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(Map.Entry<String, ? extends Object> entry) {
        String obj;
        Intrinsics.checkNotNullParameter(entry, "entry");
        String key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof boolean[]) {
            obj = Arrays.toString((boolean[]) value);
            Intrinsics.checkNotNullExpressionValue(obj, "toString(this)");
        } else if (value instanceof char[]) {
            obj = Arrays.toString((char[]) value);
            Intrinsics.checkNotNullExpressionValue(obj, "toString(this)");
        } else if (value instanceof byte[]) {
            obj = Arrays.toString((byte[]) value);
            Intrinsics.checkNotNullExpressionValue(obj, "toString(this)");
        } else if (value instanceof short[]) {
            obj = Arrays.toString((short[]) value);
            Intrinsics.checkNotNullExpressionValue(obj, "toString(this)");
        } else if (value instanceof int[]) {
            obj = Arrays.toString((int[]) value);
            Intrinsics.checkNotNullExpressionValue(obj, "toString(this)");
        } else if (value instanceof float[]) {
            obj = Arrays.toString((float[]) value);
            Intrinsics.checkNotNullExpressionValue(obj, "toString(this)");
        } else if (value instanceof long[]) {
            obj = Arrays.toString((long[]) value);
            Intrinsics.checkNotNullExpressionValue(obj, "toString(this)");
        } else if (value instanceof double[]) {
            obj = Arrays.toString((double[]) value);
            Intrinsics.checkNotNullExpressionValue(obj, "toString(this)");
        } else if (value instanceof Object[]) {
            obj = Arrays.toString((Object[]) value);
            Intrinsics.checkNotNullExpressionValue(obj, "toString(this)");
        } else {
            obj = value.toString();
        }
        return key + '=' + obj;
    }
}
