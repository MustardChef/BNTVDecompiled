package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: AbstractSignatureParts.kt */
/* loaded from: classes4.dex */
final class AbstractSignatureParts$computeIndexedQualifiers$1 extends Lambda implements Function1<Integer, typeQualifiers> {
    final /* synthetic */ typeQualifiers[] $computedResult;
    final /* synthetic */ TypeEnhancementInfo $predefined;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractSignatureParts$computeIndexedQualifiers$1(TypeEnhancementInfo typeEnhancementInfo, typeQualifiers[] typequalifiersArr) {
        super(1);
        this.$predefined = typeEnhancementInfo;
        this.$computedResult = typequalifiersArr;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ typeQualifiers invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final typeQualifiers invoke(int i) {
        Map<Integer, typeQualifiers> map;
        typeQualifiers typequalifiers;
        TypeEnhancementInfo typeEnhancementInfo = this.$predefined;
        if (typeEnhancementInfo == null || (map = typeEnhancementInfo.getMap()) == null || (typequalifiers = map.get(Integer.valueOf(i))) == null) {
            typeQualifiers[] typequalifiersArr = this.$computedResult;
            return (i < 0 || i > ArraysKt.getLastIndex(typequalifiersArr)) ? typeQualifiers.Companion.getNONE() : typequalifiersArr[i];
        }
        return typequalifiers;
    }
}
