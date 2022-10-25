package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: IntersectionType.kt */
/* renamed from: kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1 */
/* loaded from: classes4.dex */
final class C5258x7a6103fb extends Lambda implements Functions<String> {
    final /* synthetic */ Set<SimpleType> $inputTypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C5258x7a6103fb(Set<? extends SimpleType> set) {
        super(0);
        this.$inputTypes = set;
    }

    @Override // kotlin.jvm.functions.Functions
    public final String invoke() {
        return "This collections cannot be empty! input types: " + CollectionsKt.joinToString$default(this.$inputTypes, null, null, null, 0, null, null, 63, null);
    }
}
