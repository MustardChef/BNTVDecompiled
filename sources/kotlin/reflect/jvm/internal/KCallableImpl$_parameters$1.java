package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KCallableImpl.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0004 \u0001H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "kotlin.jvm.PlatformType", "R", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class KCallableImpl$_parameters$1 extends Lambda implements Functions<ArrayList<KParameter>> {
    final /* synthetic */ KCallableImpl<R> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public KCallableImpl$_parameters$1(KCallableImpl<? extends R> kCallableImpl) {
        super(0);
        this.this$0 = kCallableImpl;
    }

    @Override // kotlin.jvm.functions.Functions
    public final ArrayList<KParameter> invoke() {
        int i;
        CallableMemberDescriptor descriptor = this.this$0.getDescriptor();
        ArrayList<KParameter> arrayList = new ArrayList<>();
        int i2 = 0;
        if (this.this$0.isBound()) {
            i = 0;
        } else {
            ReceiverParameterDescriptor instanceReceiverParameter = UtilKt.getInstanceReceiverParameter(descriptor);
            if (instanceReceiverParameter != null) {
                arrayList.add(new KParameterImpl(this.this$0, 0, KParameter.Kind.INSTANCE, new C50291(instanceReceiverParameter)));
                i = 1;
            } else {
                i = 0;
            }
            ReceiverParameterDescriptor extensionReceiverParameter = descriptor.getExtensionReceiverParameter();
            if (extensionReceiverParameter != null) {
                arrayList.add(new KParameterImpl(this.this$0, i, KParameter.Kind.EXTENSION_RECEIVER, new C50302(extensionReceiverParameter)));
                i++;
            }
        }
        int size = descriptor.getValueParameters().size();
        while (i2 < size) {
            arrayList.add(new KParameterImpl(this.this$0, i, KParameter.Kind.VALUE, new C50313(descriptor, i2)));
            i2++;
            i++;
        }
        if (this.this$0.isAnnotationConstructor() && (descriptor instanceof JavaCallableMemberDescriptor)) {
            ArrayList<KParameter> arrayList2 = arrayList;
            if (arrayList2.size() > 1) {
                CollectionsKt.sortWith(arrayList2, new Comparator() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1$invoke$$inlined$sortBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((KParameter) t).getName(), ((KParameter) t2).getName());
                    }
                });
            }
        }
        arrayList.trimToSize();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KCallableImpl.kt */
    @Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "R", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1$1 */
    /* loaded from: classes4.dex */
    public static final class C50291 extends Lambda implements Functions<ParameterDescriptor> {
        final /* synthetic */ ReceiverParameterDescriptor $instanceReceiver;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C50291(ReceiverParameterDescriptor receiverParameterDescriptor) {
            super(0);
            this.$instanceReceiver = receiverParameterDescriptor;
        }

        @Override // kotlin.jvm.functions.Functions
        public final ParameterDescriptor invoke() {
            return this.$instanceReceiver;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KCallableImpl.kt */
    @Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "R", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1$2 */
    /* loaded from: classes4.dex */
    public static final class C50302 extends Lambda implements Functions<ParameterDescriptor> {
        final /* synthetic */ ReceiverParameterDescriptor $extensionReceiver;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C50302(ReceiverParameterDescriptor receiverParameterDescriptor) {
            super(0);
            this.$extensionReceiver = receiverParameterDescriptor;
        }

        @Override // kotlin.jvm.functions.Functions
        public final ParameterDescriptor invoke() {
            return this.$extensionReceiver;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KCallableImpl.kt */
    @Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "R", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1$3 */
    /* loaded from: classes4.dex */
    public static final class C50313 extends Lambda implements Functions<ParameterDescriptor> {
        final /* synthetic */ CallableMemberDescriptor $descriptor;

        /* renamed from: $i */
        final /* synthetic */ int f10639$i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C50313(CallableMemberDescriptor callableMemberDescriptor, int i) {
            super(0);
            this.$descriptor = callableMemberDescriptor;
            this.f10639$i = i;
        }

        @Override // kotlin.jvm.functions.Functions
        public final ParameterDescriptor invoke() {
            ValueParameterDescriptor valueParameterDescriptor = this.$descriptor.getValueParameters().get(this.f10639$i);
            Intrinsics.checkNotNullExpressionValue(valueParameterDescriptor, "descriptor.valueParameters[i]");
            return valueParameterDescriptor;
        }
    }
}
