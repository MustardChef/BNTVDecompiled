package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder;

/* compiled from: predefinedEnhancementInfo.kt */
/* renamed from: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$5 */
/* loaded from: classes4.dex */
final class C5117xb2505175 extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
    final /* synthetic */ String $JFBiFunction;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5117xb2505175(String str) {
        super(1);
        this.$JFBiFunction = str;
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
        Intrinsics.checkNotNullParameter(function, "$this$function");
        String str = this.$JFBiFunction;
        typequalifiers = predefinedEnhancementInfo.NOT_PLATFORM;
        typequalifiers2 = predefinedEnhancementInfo.NOT_PLATFORM;
        typequalifiers3 = predefinedEnhancementInfo.NOT_PLATFORM;
        typequalifiers4 = predefinedEnhancementInfo.NOT_PLATFORM;
        function.parameter(str, typequalifiers, typequalifiers2, typequalifiers3, typequalifiers4);
    }
}
