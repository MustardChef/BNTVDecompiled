package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpecialTypes.kt */
/* loaded from: classes4.dex */
public final class LazyWrappedType$refine$1 extends Lambda implements Functions<KotlinType> {
    final /* synthetic */ KotlinTypeRefiner $kotlinTypeRefiner;
    final /* synthetic */ LazyWrappedType this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyWrappedType$refine$1(KotlinTypeRefiner kotlinTypeRefiner, LazyWrappedType lazyWrappedType) {
        super(0);
        this.$kotlinTypeRefiner = kotlinTypeRefiner;
        this.this$0 = lazyWrappedType;
    }

    @Override // kotlin.jvm.functions.Functions
    public final KotlinType invoke() {
        Functions functions;
        KotlinTypeRefiner kotlinTypeRefiner = this.$kotlinTypeRefiner;
        functions = this.this$0.computation;
        return kotlinTypeRefiner.refineType((KotlinTypeMarker) functions.invoke());
    }
}
