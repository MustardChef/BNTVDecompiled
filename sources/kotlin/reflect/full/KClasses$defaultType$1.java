package kotlin.reflect.full;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.KClassImpl;

/* compiled from: KClasses.kt */
@Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "Ljava/lang/reflect/Type;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
final class KClasses$defaultType$1 extends Lambda implements Functions<Type> {
    final /* synthetic */ KClass<?> $this_defaultType;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KClasses$defaultType$1(KClass<?> kClass) {
        super(0);
        this.$this_defaultType = kClass;
    }

    @Override // kotlin.jvm.functions.Functions
    public final Type invoke() {
        return ((KClassImpl) this.$this_defaultType).getJClass();
    }
}
