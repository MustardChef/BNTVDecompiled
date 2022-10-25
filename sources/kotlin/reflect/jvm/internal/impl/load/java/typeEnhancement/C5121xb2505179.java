package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder;

/* compiled from: predefinedEnhancementInfo.kt */
/* renamed from: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$9 */
/* loaded from: classes4.dex */
final class C5121xb2505179 extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
    final /* synthetic */ String $JFBiFunction;
    final /* synthetic */ String $JLObject;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5121xb2505179(String str, String str2) {
        super(1);
        this.$JLObject = str;
        this.$JFBiFunction = str2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        invoke2(functionEnhancementBuilder);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        typeQualifiers typequalifiers;
        typeQualifiers typequalifiers2;
        typeQualifiers typequalifiers3;
        typeQualifiers typequalifiers4;
        typeQualifiers typequalifiers5;
        typeQualifiers typequalifiers6;
        typeQualifiers typequalifiers7;
        Intrinsics.checkNotNullParameter(function, "$this$function");
        String str = this.$JLObject;
        typequalifiers = predefinedEnhancementInfo.NOT_PLATFORM;
        function.parameter(str, typequalifiers);
        String str2 = this.$JLObject;
        typequalifiers2 = predefinedEnhancementInfo.NOT_NULLABLE;
        function.parameter(str2, typequalifiers2);
        String str3 = this.$JFBiFunction;
        typequalifiers3 = predefinedEnhancementInfo.NOT_PLATFORM;
        typequalifiers4 = predefinedEnhancementInfo.NOT_NULLABLE;
        typequalifiers5 = predefinedEnhancementInfo.NOT_NULLABLE;
        typequalifiers6 = predefinedEnhancementInfo.NULLABLE;
        function.parameter(str3, typequalifiers3, typequalifiers4, typequalifiers5, typequalifiers6);
        String str4 = this.$JLObject;
        typequalifiers7 = predefinedEnhancementInfo.NULLABLE;
        function.returns(str4, typequalifiers7);
    }
}
