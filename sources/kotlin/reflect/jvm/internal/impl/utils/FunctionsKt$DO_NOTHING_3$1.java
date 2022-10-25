package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* compiled from: functions.kt */
/* loaded from: classes4.dex */
final class FunctionsKt$DO_NOTHING_3$1 extends Lambda implements Function3<Object, Object, Object, Unit> {
    public static final FunctionsKt$DO_NOTHING_3$1 INSTANCE = new FunctionsKt$DO_NOTHING_3$1();

    FunctionsKt$DO_NOTHING_3$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Object obj, Object obj2, Object obj3) {
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2, Object obj3) {
        invoke2(obj, obj2, obj3);
        return Unit.INSTANCE;
    }
}
