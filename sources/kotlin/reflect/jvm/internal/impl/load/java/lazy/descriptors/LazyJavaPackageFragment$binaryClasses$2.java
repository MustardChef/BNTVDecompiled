package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Map;
import kotlin.Tuples;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaPackageFragment.kt */
/* loaded from: classes4.dex */
public final class LazyJavaPackageFragment$binaryClasses$2 extends Lambda implements Functions<Map<String, ? extends KotlinJvmBinaryClass>> {
    final /* synthetic */ LazyJavaPackageFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageFragment$binaryClasses$2(LazyJavaPackageFragment lazyJavaPackageFragment) {
        super(0);
        this.this$0 = lazyJavaPackageFragment;
    }

    @Override // kotlin.jvm.functions.Functions
    public final Map<String, ? extends KotlinJvmBinaryClass> invoke() {
        LazyJavaResolverContext lazyJavaResolverContext;
        LazyJavaResolverContext lazyJavaResolverContext2;
        lazyJavaResolverContext = this.this$0.f10650c;
        PackagePartProvider packagePartProvider = lazyJavaResolverContext.getComponents().getPackagePartProvider();
        String asString = this.this$0.getFqName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "fqName.asString()");
        LazyJavaPackageFragment lazyJavaPackageFragment = this.this$0;
        ArrayList arrayList = new ArrayList();
        for (String str : packagePartProvider.findPackageParts(asString)) {
            ClassId classId = ClassId.topLevel(JvmClassName.byInternalName(str).getFqNameForTopLevelClassMaybeWithDollars());
            Intrinsics.checkNotNullExpressionValue(classId, "topLevel(JvmClassName.by…velClassMaybeWithDollars)");
            lazyJavaResolverContext2 = lazyJavaPackageFragment.f10650c;
            KotlinJvmBinaryClass findKotlinClass = KotlinClassFinderKt.findKotlinClass(lazyJavaResolverContext2.getComponents().getKotlinClassFinder(), classId);
            Tuples m100to = findKotlinClass != null ? TuplesKt.m100to(str, findKotlinClass) : null;
            if (m100to != null) {
                arrayList.add(m100to);
            }
        }
        return MapsKt.toMap(arrayList);
    }
}
