package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;

/* compiled from: LazyJavaScope.kt */
/* loaded from: classes4.dex */
final class LazyJavaScope$resolveProperty$1 extends Lambda implements Functions<NullableLazyValue<? extends ConstantValue<?>>> {
    final /* synthetic */ JavaField $field;
    final /* synthetic */ PropertyDescriptorImpl $propertyDescriptor;
    final /* synthetic */ LazyJavaScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaScope$resolveProperty$1(LazyJavaScope lazyJavaScope, JavaField javaField, PropertyDescriptorImpl propertyDescriptorImpl) {
        super(0);
        this.this$0 = lazyJavaScope;
        this.$field = javaField;
        this.$propertyDescriptor = propertyDescriptorImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LazyJavaScope.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope$resolveProperty$1$1 */
    /* loaded from: classes4.dex */
    public static final class C50981 extends Lambda implements Functions<ConstantValue<?>> {
        final /* synthetic */ JavaField $field;
        final /* synthetic */ PropertyDescriptorImpl $propertyDescriptor;
        final /* synthetic */ LazyJavaScope this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C50981(LazyJavaScope lazyJavaScope, JavaField javaField, PropertyDescriptorImpl propertyDescriptorImpl) {
            super(0);
            this.this$0 = lazyJavaScope;
            this.$field = javaField;
            this.$propertyDescriptor = propertyDescriptorImpl;
        }

        @Override // kotlin.jvm.functions.Functions
        public final ConstantValue<?> invoke() {
            return this.this$0.getC().getComponents().getJavaPropertyInitializerEvaluator().getInitializerConstant(this.$field, this.$propertyDescriptor);
        }
    }

    @Override // kotlin.jvm.functions.Functions
    public final NullableLazyValue<? extends ConstantValue<?>> invoke() {
        return this.this$0.getC().getStorageManager().createNullableLazyValue(new C50981(this.this$0, this.$field, this.$propertyDescriptor));
    }
}
