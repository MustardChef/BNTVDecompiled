package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaPackageScope.kt */
/* loaded from: classes4.dex */
public final class LazyJavaPackageScope$classes$1 extends Lambda implements Function1<LazyJavaPackageScope.FindClassRequest, ClassDescriptor> {

    /* renamed from: $c */
    final /* synthetic */ LazyJavaResolverContext f10651$c;
    final /* synthetic */ LazyJavaPackageScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageScope$classes$1(LazyJavaPackageScope lazyJavaPackageScope, LazyJavaResolverContext lazyJavaResolverContext) {
        super(1);
        this.this$0 = lazyJavaPackageScope;
        this.f10651$c = lazyJavaResolverContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ClassDescriptor invoke(LazyJavaPackageScope.FindClassRequest request) {
        KotlinClassFinder.Result findKotlinClassOrContent;
        LazyJavaPackageScope.KotlinClassLookupResult resolveKotlinBinaryClass;
        byte[] bArr;
        Intrinsics.checkNotNullParameter(request, "request");
        ClassId classId = new ClassId(this.this$0.getOwnerDescriptor().getFqName(), request.getName());
        if (request.getJavaClass() != null) {
            findKotlinClassOrContent = this.f10651$c.getComponents().getKotlinClassFinder().findKotlinClassOrContent(request.getJavaClass());
        } else {
            findKotlinClassOrContent = this.f10651$c.getComponents().getKotlinClassFinder().findKotlinClassOrContent(classId);
        }
        LazyJavaClassDescriptor lazyJavaClassDescriptor = null;
        KotlinJvmBinaryClass kotlinJvmBinaryClass = findKotlinClassOrContent != null ? findKotlinClassOrContent.toKotlinJvmBinaryClass() : null;
        ClassId classId2 = kotlinJvmBinaryClass != null ? kotlinJvmBinaryClass.getClassId() : null;
        if (classId2 == null || !(classId2.isNestedClass() || classId2.isLocal())) {
            resolveKotlinBinaryClass = this.this$0.resolveKotlinBinaryClass(kotlinJvmBinaryClass);
            if (resolveKotlinBinaryClass instanceof LazyJavaPackageScope.KotlinClassLookupResult.Found) {
                return ((LazyJavaPackageScope.KotlinClassLookupResult.Found) resolveKotlinBinaryClass).getDescriptor();
            }
            if (resolveKotlinBinaryClass instanceof LazyJavaPackageScope.KotlinClassLookupResult.SyntheticClass) {
                return null;
            }
            if (resolveKotlinBinaryClass instanceof LazyJavaPackageScope.KotlinClassLookupResult.NotFound) {
                JavaClass javaClass = request.getJavaClass();
                if (javaClass == null) {
                    JavaClassFinder finder = this.f10651$c.getComponents().getFinder();
                    if (findKotlinClassOrContent != null) {
                        if (!(findKotlinClassOrContent instanceof KotlinClassFinder.Result.ClassFileContent)) {
                            findKotlinClassOrContent = null;
                        }
                        KotlinClassFinder.Result.ClassFileContent classFileContent = (KotlinClassFinder.Result.ClassFileContent) findKotlinClassOrContent;
                        if (classFileContent != null) {
                            bArr = classFileContent.getContent();
                            javaClass = finder.findClass(new JavaClassFinder.Request(classId, bArr, null, 4, null));
                        }
                    }
                    bArr = null;
                    javaClass = finder.findClass(new JavaClassFinder.Request(classId, bArr, null, 4, null));
                }
                JavaClass javaClass2 = javaClass;
                if ((javaClass2 != null ? javaClass2.getLightClassOriginKind() : null) == LightClassOriginKind.BINARY) {
                    throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + javaClass2 + "\nClassId: " + classId + "\nfindKotlinClass(JavaClass) = " + KotlinClassFinderKt.findKotlinClass(this.f10651$c.getComponents().getKotlinClassFinder(), javaClass2) + "\nfindKotlinClass(ClassId) = " + KotlinClassFinderKt.findKotlinClass(this.f10651$c.getComponents().getKotlinClassFinder(), classId) + '\n');
                }
                FqName fqName = javaClass2 != null ? javaClass2.getFqName() : null;
                if (fqName != null && !fqName.isRoot() && Intrinsics.areEqual(fqName.parent(), this.this$0.getOwnerDescriptor().getFqName())) {
                    lazyJavaClassDescriptor = new LazyJavaClassDescriptor(this.f10651$c, this.this$0.getOwnerDescriptor(), javaClass2, null, 8, null);
                    this.f10651$c.getComponents().getJavaClassesTracker().reportClass(lazyJavaClassDescriptor);
                }
                return lazyJavaClassDescriptor;
            }
            throw new NoWhenBranchMatchedException();
        }
        return null;
    }
}
