package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* compiled from: functions.kt */
/* loaded from: classes4.dex */
final class FunctionsKt$DO_NOTHING_2$1 extends Lambda implements Function2<Object, Object, Unit> {
    public static final FunctionsKt$DO_NOTHING_2$1 INSTANCE = new FunctionsKt$DO_NOTHING_2$1();

    FunctionsKt$DO_NOTHING_2$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Object obj, Object obj2) {
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
        invoke2(obj, obj2);
        return Unit.INSTANCE;
    }
}
