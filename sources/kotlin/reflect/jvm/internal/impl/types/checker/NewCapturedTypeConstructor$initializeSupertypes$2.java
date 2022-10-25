package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: NewCapturedType.kt */
/* loaded from: classes4.dex */
final class NewCapturedTypeConstructor$initializeSupertypes$2 extends Lambda implements Functions<List<? extends UnwrappedType>> {
    final /* synthetic */ List<UnwrappedType> $supertypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NewCapturedTypeConstructor$initializeSupertypes$2(List<? extends UnwrappedType> list) {
        super(0);
        this.$supertypes = list;
    }

    @Override // kotlin.jvm.functions.Functions
    public final List<? extends UnwrappedType> invoke() {
        return this.$supertypes;
    }
}
