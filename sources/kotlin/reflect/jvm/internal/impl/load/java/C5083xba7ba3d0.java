package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: AbstractAnnotationTypeQualifierResolver.kt */
/* renamed from: kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver$extractDefaultQualifiers$nullabilityQualifier$1 */
/* loaded from: classes4.dex */
final class C5083xba7ba3d0 extends Lambda implements Function1<TAnnotation, Boolean> {
    public static final C5083xba7ba3d0 INSTANCE = new C5083xba7ba3d0();

    C5083xba7ba3d0() {
        super(1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(TAnnotation extractNullability) {
        Intrinsics.checkNotNullParameter(extractNullability, "$this$extractNullability");
        return false;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return invoke((C5083xba7ba3d0) obj);
    }
}
