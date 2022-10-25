package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: JvmAnnotationNames.kt */
/* loaded from: classes4.dex */
public final class JvmAnnotationNamesKt {
    private static final FqName ANDROIDX_RECENTLY_NON_NULL_ANNOTATION;
    private static final FqName ANDROIDX_RECENTLY_NULLABLE_ANNOTATION;
    private static final FqName COMPATQUAL_NONNULL_ANNOTATION;
    private static final FqName COMPATQUAL_NULLABLE_ANNOTATION;
    private static final FqName JAVAX_CHECKFORNULL_ANNOTATION;
    private static final FqName JAVAX_NONNULL_ANNOTATION;
    private static final FqName JSPECIFY_NULLABLE;
    private static final FqName JSPECIFY_NULLNESS_UNKNOWN;
    private static final FqName JSPECIFY_NULL_MARKED;
    private static final Set<FqName> MUTABLE_ANNOTATIONS;
    private static final List<FqName> NOT_NULL_ANNOTATIONS;
    private static final Set<FqName> NULLABILITY_ANNOTATIONS;
    private static final List<FqName> NULLABLE_ANNOTATIONS;
    private static final Set<FqName> READ_ONLY_ANNOTATIONS;
    private static final Map<FqName, FqName> javaToKotlinNameMap;

    static {
        FqName fqName = new FqName("org.jspecify.nullness.Nullable");
        JSPECIFY_NULLABLE = fqName;
        FqName fqName2 = new FqName("org.jspecify.nullness.NullnessUnspecified");
        JSPECIFY_NULLNESS_UNKNOWN = fqName2;
        FqName fqName3 = new FqName("org.jspecify.nullness.NullMarked");
        JSPECIFY_NULL_MARKED = fqName3;
        List<FqName> listOf = CollectionsKt.listOf((Object[]) new FqName[]{JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION, new FqName("androidx.annotation.Nullable"), new FqName("androidx.annotation.Nullable"), new FqName("android.annotation.Nullable"), new FqName("com.android.annotations.Nullable"), new FqName("org.eclipse.jdt.annotation.Nullable"), new FqName("org.checkerframework.checker.nullness.qual.Nullable"), new FqName("javax.annotation.Nullable"), new FqName("javax.annotation.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.Nullable"), new FqName("edu.umd.cs.findbugs.annotations.PossiblyNull"), new FqName("io.reactivex.annotations.Nullable"), new FqName("io.reactivex.rxjava3.annotations.Nullable")});
        NULLABLE_ANNOTATIONS = listOf;
        FqName fqName4 = new FqName("javax.annotation.Nonnull");
        JAVAX_NONNULL_ANNOTATION = fqName4;
        JAVAX_CHECKFORNULL_ANNOTATION = new FqName("javax.annotation.CheckForNull");
        List<FqName> listOf2 = CollectionsKt.listOf((Object[]) new FqName[]{JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION, new FqName("edu.umd.cs.findbugs.annotations.NonNull"), new FqName("androidx.annotation.NonNull"), new FqName("androidx.annotation.NonNull"), new FqName("android.annotation.NonNull"), new FqName("com.android.annotations.NonNull"), new FqName("org.eclipse.jdt.annotation.NonNull"), new FqName("org.checkerframework.checker.nullness.qual.NonNull"), new FqName("lombok.NonNull"), new FqName("io.reactivex.annotations.NonNull"), new FqName("io.reactivex.rxjava3.annotations.NonNull")});
        NOT_NULL_ANNOTATIONS = listOf2;
        FqName fqName5 = new FqName("org.checkerframework.checker.nullness.compatqual.NullableDecl");
        COMPATQUAL_NULLABLE_ANNOTATION = fqName5;
        FqName fqName6 = new FqName("org.checkerframework.checker.nullness.compatqual.NonNullDecl");
        COMPATQUAL_NONNULL_ANNOTATION = fqName6;
        FqName fqName7 = new FqName("androidx.annotation.RecentlyNullable");
        ANDROIDX_RECENTLY_NULLABLE_ANNOTATION = fqName7;
        FqName fqName8 = new FqName("androidx.annotation.RecentlyNonNull");
        ANDROIDX_RECENTLY_NON_NULL_ANNOTATION = fqName8;
        NULLABILITY_ANNOTATIONS = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus((Set) new LinkedHashSet(), (Iterable) listOf), fqName4), (Iterable) listOf2), fqName5), fqName6), fqName7), fqName8), fqName), fqName2), fqName3);
        READ_ONLY_ANNOTATIONS = SetsKt.setOf((Object[]) new FqName[]{JvmAnnotationNames.JETBRAINS_READONLY_ANNOTATION, JvmAnnotationNames.READONLY_ANNOTATION});
        MUTABLE_ANNOTATIONS = SetsKt.setOf((Object[]) new FqName[]{JvmAnnotationNames.JETBRAINS_MUTABLE_ANNOTATION, JvmAnnotationNames.MUTABLE_ANNOTATION});
        javaToKotlinNameMap = MapsKt.mapOf(TuplesKt.m100to(JvmAnnotationNames.TARGET_ANNOTATION, StandardNames.FqNames.target), TuplesKt.m100to(JvmAnnotationNames.RETENTION_ANNOTATION, StandardNames.FqNames.retention), TuplesKt.m100to(JvmAnnotationNames.DEPRECATED_ANNOTATION, StandardNames.FqNames.deprecated), TuplesKt.m100to(JvmAnnotationNames.DOCUMENTED_ANNOTATION, StandardNames.FqNames.mustBeDocumented));
    }

    public static final FqName getJSPECIFY_NULLABLE() {
        return JSPECIFY_NULLABLE;
    }

    public static final FqName getJSPECIFY_NULLNESS_UNKNOWN() {
        return JSPECIFY_NULLNESS_UNKNOWN;
    }

    public static final FqName getJSPECIFY_NULL_MARKED() {
        return JSPECIFY_NULL_MARKED;
    }

    public static final List<FqName> getNULLABLE_ANNOTATIONS() {
        return NULLABLE_ANNOTATIONS;
    }

    public static final FqName getJAVAX_NONNULL_ANNOTATION() {
        return JAVAX_NONNULL_ANNOTATION;
    }

    public static final FqName getJAVAX_CHECKFORNULL_ANNOTATION() {
        return JAVAX_CHECKFORNULL_ANNOTATION;
    }

    public static final List<FqName> getNOT_NULL_ANNOTATIONS() {
        return NOT_NULL_ANNOTATIONS;
    }

    public static final FqName getCOMPATQUAL_NULLABLE_ANNOTATION() {
        return COMPATQUAL_NULLABLE_ANNOTATION;
    }

    public static final FqName getCOMPATQUAL_NONNULL_ANNOTATION() {
        return COMPATQUAL_NONNULL_ANNOTATION;
    }

    public static final FqName getANDROIDX_RECENTLY_NULLABLE_ANNOTATION() {
        return ANDROIDX_RECENTLY_NULLABLE_ANNOTATION;
    }

    public static final FqName getANDROIDX_RECENTLY_NON_NULL_ANNOTATION() {
        return ANDROIDX_RECENTLY_NON_NULL_ANNOTATION;
    }

    public static final Set<FqName> getREAD_ONLY_ANNOTATIONS() {
        return READ_ONLY_ANNOTATIONS;
    }

    public static final Set<FqName> getMUTABLE_ANNOTATIONS() {
        return MUTABLE_ANNOTATIONS;
    }
}
