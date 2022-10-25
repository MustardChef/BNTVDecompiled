package kotlin.reflect.jvm.internal.impl.builtins;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDesciptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.MutableClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtils;

/* renamed from: kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt */
/* loaded from: classes4.dex */
public final class suspendFunctionTypes {
    private static final MutableClassDescriptor FAKE_CONTINUATION_CLASS_DESCRIPTOR;

    static {
        ModuleDescriptor errorModule = ErrorUtils.getErrorModule();
        Intrinsics.checkNotNullExpressionValue(errorModule, "getErrorModule()");
        MutableClassDescriptor mutableClassDescriptor = new MutableClassDescriptor(new EmptyPackageFragmentDesciptor(errorModule, StandardNames.COROUTINES_PACKAGE_FQ_NAME), ClassKind.INTERFACE, false, false, StandardNames.CONTINUATION_INTERFACE_FQ_NAME.shortName(), SourceElement.NO_SOURCE, LockBasedStorageManager.NO_LOCKS);
        mutableClassDescriptor.setModality(Modality.ABSTRACT);
        mutableClassDescriptor.setVisibility(DescriptorVisibilities.PUBLIC);
        mutableClassDescriptor.setTypeParameterDescriptors(CollectionsKt.listOf(TypeParameterDescriptorImpl.createWithDefaultBound(mutableClassDescriptor, Annotations.Companion.getEMPTY(), false, Variance.IN_VARIANCE, Name.identifier(ExifInterface.GPS_DIRECTION_TRUE), 0, LockBasedStorageManager.NO_LOCKS)));
        mutableClassDescriptor.createTypeConstructor();
        FAKE_CONTINUATION_CLASS_DESCRIPTOR = mutableClassDescriptor;
    }

    public static final SimpleType transformSuspendFunctionToRuntimeFunctionType(KotlinType suspendFunType) {
        SimpleType createFunctionType;
        Intrinsics.checkNotNullParameter(suspendFunType, "suspendFunType");
        functionTypes.isSuspendFunctionType(suspendFunType);
        KotlinBuiltIns builtIns = TypeUtils.getBuiltIns(suspendFunType);
        Annotations annotations = suspendFunType.getAnnotations();
        KotlinType receiverTypeFromFunctionType = functionTypes.getReceiverTypeFromFunctionType(suspendFunType);
        List<KotlinType> contextReceiverTypesFromFunctionType = functionTypes.getContextReceiverTypesFromFunctionType(suspendFunType);
        List<TypeProjection> valueParameterTypesFromFunctionType = functionTypes.getValueParameterTypesFromFunctionType(suspendFunType);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(valueParameterTypesFromFunctionType, 10));
        for (TypeProjection typeProjection : valueParameterTypesFromFunctionType) {
            arrayList.add(typeProjection.getType());
        }
        Annotations empty = Annotations.Companion.getEMPTY();
        TypeConstructor typeConstructor = FAKE_CONTINUATION_CLASS_DESCRIPTOR.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "FAKE_CONTINUATION_CLASS_DESCRIPTOR.typeConstructor");
        List plus = CollectionsKt.plus((Collection<? extends SimpleType>) arrayList, KotlinTypeFactory.simpleType$default(empty, typeConstructor, CollectionsKt.listOf(TypeUtils.asTypeProjection(functionTypes.getReturnTypeFromFunctionType(suspendFunType))), false, (KotlinTypeRefiner) null, 16, (Object) null));
        SimpleType nullableAnyType = TypeUtils.getBuiltIns(suspendFunType).getNullableAnyType();
        Intrinsics.checkNotNullExpressionValue(nullableAnyType, "suspendFunType.builtIns.nullableAnyType");
        createFunctionType = functionTypes.createFunctionType(builtIns, annotations, receiverTypeFromFunctionType, contextReceiverTypesFromFunctionType, plus, null, nullableAnyType, (r17 & 128) != 0 ? false : false);
        return createFunctionType.makeNullableAsSpecified(suspendFunType.isMarkedNullable());
    }
}
