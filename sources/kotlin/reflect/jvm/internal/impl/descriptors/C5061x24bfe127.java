package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: findClassInModule.kt */
/* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2 */
/* loaded from: classes4.dex */
final class C5061x24bfe127 extends Lambda implements Function1<ClassId, Integer> {
    public static final C5061x24bfe127 INSTANCE = new C5061x24bfe127();

    C5061x24bfe127() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Integer invoke(ClassId it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return 0;
    }
}
