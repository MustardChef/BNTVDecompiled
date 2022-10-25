package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IntersectionTypeConstructor.kt */
/* loaded from: classes4.dex */
public final class IntersectionTypeConstructor$makeDebugNameForIntersectionType$1 extends Lambda implements Function1<KotlinType, String> {
    public static final IntersectionTypeConstructor$makeDebugNameForIntersectionType$1 INSTANCE = new IntersectionTypeConstructor$makeDebugNameForIntersectionType$1();

    IntersectionTypeConstructor$makeDebugNameForIntersectionType$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(KotlinType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.toString();
    }
}
