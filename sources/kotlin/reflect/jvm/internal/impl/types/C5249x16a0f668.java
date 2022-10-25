package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractTypeConstructor.kt */
/* renamed from: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$ModuleViewTypeConstructor$refinedSupertypes$2 */
/* loaded from: classes4.dex */
public final class C5249x16a0f668 extends Lambda implements Functions<List<? extends KotlinType>> {
    final /* synthetic */ AbstractTypeConstructor.ModuleViewTypeConstructor this$0;
    final /* synthetic */ AbstractTypeConstructor this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5249x16a0f668(AbstractTypeConstructor.ModuleViewTypeConstructor moduleViewTypeConstructor, AbstractTypeConstructor abstractTypeConstructor) {
        super(0);
        this.this$0 = moduleViewTypeConstructor;
        this.this$1 = abstractTypeConstructor;
    }

    @Override // kotlin.jvm.functions.Functions
    public final List<? extends KotlinType> invoke() {
        KotlinTypeRefiner kotlinTypeRefiner;
        kotlinTypeRefiner = this.this$0.kotlinTypeRefiner;
        return KotlinTypeRefinerKt.refineTypes(kotlinTypeRefiner, this.this$1.mo10322getSupertypes());
    }
}
