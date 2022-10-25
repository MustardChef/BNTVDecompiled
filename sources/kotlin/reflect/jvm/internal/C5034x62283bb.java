package kotlin.reflect.jvm.internal;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KDeclarationContainerImpl.kt */
@Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, m107d2 = {"<anonymous>", "", "first", "Lkotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibility;", "kotlin.jvm.PlatformType", "second", "compare"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$findPropertyDescriptor$mostVisibleProperties$2 */
/* loaded from: classes4.dex */
public final class C5034x62283bb<T> implements Comparator {
    public static final C5034x62283bb<T> INSTANCE = new C5034x62283bb<>();

    C5034x62283bb() {
    }

    @Override // java.util.Comparator
    public final int compare(DescriptorVisibility descriptorVisibility, DescriptorVisibility descriptorVisibility2) {
        Integer compare = DescriptorVisibilities.compare(descriptorVisibility, descriptorVisibility2);
        if (compare == null) {
            return 0;
        }
        return compare.intValue();
    }
}
