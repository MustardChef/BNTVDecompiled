package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.reflectClassUtil;

/* compiled from: RuntimeTypeMapper.kt */
@Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", "it", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
final class RuntimeTypeMapperKt$signature$1 extends Lambda implements Function1<Class<?>, CharSequence> {
    public static final RuntimeTypeMapperKt$signature$1 INSTANCE = new RuntimeTypeMapperKt$signature$1();

    RuntimeTypeMapperKt$signature$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(Class<?> it) {
        Intrinsics.checkNotNullExpressionValue(it, "it");
        return reflectClassUtil.getDesc(it);
    }
}
