package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReflectJavaClass.kt */
/* loaded from: classes4.dex */
public final class ReflectJavaClass$methods$1 extends Lambda implements Function1<Method, Boolean> {
    final /* synthetic */ ReflectJavaClass this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectJavaClass$methods$1(ReflectJavaClass reflectJavaClass) {
        super(1);
        this.this$0 = reflectJavaClass;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r5 == false) goto L4;
     */
    @Override // kotlin.jvm.functions.Function1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Boolean invoke(java.lang.reflect.Method r5) {
        /*
            r4 = this;
            boolean r0 = r5.isSynthetic()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto La
        L8:
            r1 = 0
            goto L1f
        La:
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass r0 = r4.this$0
            boolean r0 = r0.isEnum()
            if (r0 == 0) goto L1f
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass r0 = r4.this$0
            java.lang.String r3 = "method"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
            boolean r5 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass.access$isEnumValuesOrValueOf(r0, r5)
            if (r5 != 0) goto L8
        L1f:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$methods$1.invoke(java.lang.reflect.Method):java.lang.Boolean");
    }
}
