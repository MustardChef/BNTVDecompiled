package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;

/* renamed from: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt */
/* loaded from: classes4.dex */
public final class predefinedEnhancementInfo {
    private static final Map<String, PredefinedFunctionEnhancementInfo> PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;
    private static final typeQualifiers NULLABLE = new typeQualifiers(NullabilityQualifier.NULLABLE, null, false, false, 8, null);
    private static final typeQualifiers NOT_PLATFORM = new typeQualifiers(NullabilityQualifier.NOT_NULL, null, false, false, 8, null);
    private static final typeQualifiers NOT_NULLABLE = new typeQualifiers(NullabilityQualifier.NOT_NULL, null, true, false, 8, null);

    static {
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        String javaLang = signatureBuildingComponents.javaLang("Object");
        String javaFunction = signatureBuildingComponents.javaFunction("Predicate");
        String javaFunction2 = signatureBuildingComponents.javaFunction("Function");
        String javaFunction3 = signatureBuildingComponents.javaFunction("Consumer");
        String javaFunction4 = signatureBuildingComponents.javaFunction("BiFunction");
        String javaFunction5 = signatureBuildingComponents.javaFunction("BiConsumer");
        String javaFunction6 = signatureBuildingComponents.javaFunction("UnaryOperator");
        String javaUtil = signatureBuildingComponents.javaUtil("stream/Stream");
        String javaUtil2 = signatureBuildingComponents.javaUtil("Optional");
        SignatureEnhancementBuilder signatureEnhancementBuilder = new SignatureEnhancementBuilder();
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("Iterator")).function("forEachRemaining", new C5102xb250426d(javaFunction3));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaLang("Iterable")).function("spliterator", new C5108xb250462e(signatureBuildingComponents));
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("Collection"));
        classEnhancementBuilder.function("removeIf", new C5109xb25049ef(javaFunction));
        classEnhancementBuilder.function("stream", new C5110xb25049f0(javaUtil));
        classEnhancementBuilder.function("parallelStream", new C5111xb25049f1(javaUtil));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("List")).function("replaceAll", new C5112xb2504db0(javaFunction6));
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder2 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("Map"));
        classEnhancementBuilder2.function("forEach", new C5113xb2505171(javaFunction5));
        classEnhancementBuilder2.function("putIfAbsent", new C5114xb2505172(javaLang));
        classEnhancementBuilder2.function("replace", new C5115xb2505173(javaLang));
        classEnhancementBuilder2.function("replace", new C5116xb2505174(javaLang));
        classEnhancementBuilder2.function("replaceAll", new C5117xb2505175(javaFunction4));
        classEnhancementBuilder2.function("compute", new C5118xb2505176(javaLang, javaFunction4));
        classEnhancementBuilder2.function("computeIfAbsent", new C5119xb2505177(javaLang, javaFunction2));
        classEnhancementBuilder2.function("computeIfPresent", new C5120xb2505178(javaLang, javaFunction4));
        classEnhancementBuilder2.function("merge", new C5121xb2505179(javaLang, javaFunction4));
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder3 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaUtil2);
        classEnhancementBuilder3.function("empty", new C5122xb2505532(javaUtil2));
        classEnhancementBuilder3.function("of", new C5123xb2505533(javaLang, javaUtil2));
        classEnhancementBuilder3.function("ofNullable", new C5124xb2505534(javaLang, javaUtil2));
        classEnhancementBuilder3.function("get", new C5125xb2505535(javaLang));
        classEnhancementBuilder3.function("ifPresent", new C5126xb2505536(javaFunction3));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaLang("ref/Reference")).function("get", new C5127xb25058f3(javaLang));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaFunction).function("test", new C5128xb2505cb4(javaLang));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaFunction("BiPredicate")).function("test", new C5129xb2506075(javaLang));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaFunction3).function("accept", new C5103x97b836dd(javaLang));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaFunction5).function("accept", new C5104x97b83a9e(javaLang));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaFunction2).function("apply", new C5105x97b83e5f(javaLang));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaFunction4).function("apply", new C5106x97b84220(javaLang));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaFunction("Supplier")).function("get", new C5107x97b845e1(javaLang));
        PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE = signatureEnhancementBuilder.build();
    }

    public static final Map<String, PredefinedFunctionEnhancementInfo> getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE() {
        return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;
    }
}
