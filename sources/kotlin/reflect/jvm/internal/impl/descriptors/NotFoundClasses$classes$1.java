package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotFoundClasses.kt */
/* loaded from: classes4.dex */
public final class NotFoundClasses$classes$1 extends Lambda implements Function1<NotFoundClasses.ClassRequest, ClassDescriptor> {
    final /* synthetic */ NotFoundClasses this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotFoundClasses$classes$1(NotFoundClasses notFoundClasses) {
        super(1);
        this.this$0 = notFoundClasses;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ClassDescriptor invoke(NotFoundClasses.ClassRequest classRequest) {
        MemoizedFunctionToNotNull memoizedFunctionToNotNull;
        ClassDescriptor classDescriptor;
        StorageManager storageManager;
        ClassDescriptor classDescriptor2;
        Intrinsics.checkNotNullParameter(classRequest, "<name for destructuring parameter 0>");
        ClassId component1 = classRequest.component1();
        List<Integer> component2 = classRequest.component2();
        if (component1.isLocal()) {
            throw new UnsupportedOperationException("Unresolved local class: " + component1);
        }
        ClassId outerClassId = component1.getOuterClassId();
        if (outerClassId == null || (classDescriptor2 = this.this$0.getClass(outerClassId, CollectionsKt.drop(component2, 1))) == null) {
            memoizedFunctionToNotNull = this.this$0.packageFragments;
            FqName packageFqName = component1.getPackageFqName();
            Intrinsics.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
            classDescriptor = (ClassOrPackageFragmentDescriptor) memoizedFunctionToNotNull.invoke(packageFqName);
        } else {
            classDescriptor = classDescriptor2;
        }
        boolean isNestedClass = component1.isNestedClass();
        storageManager = this.this$0.storageManager;
        ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor = classDescriptor;
        Name shortClassName = component1.getShortClassName();
        Intrinsics.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
        Integer num = (Integer) CollectionsKt.firstOrNull((List<? extends Object>) component2);
        return new NotFoundClasses.MockClassDescriptor(storageManager, classOrPackageFragmentDescriptor, shortClassName, isNestedClass, num != null ? num.intValue() : 0);
    }
}
