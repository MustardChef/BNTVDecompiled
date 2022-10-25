package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* compiled from: CoroutineContext.kt */
@Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "result", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
final class CoroutineContextKt$foldCopies$folded$1 extends Lambda implements Function2<CoroutineContext, CoroutineContext.Element, CoroutineContext> {
    final /* synthetic */ boolean $isNewCoroutine;
    final /* synthetic */ Ref.ObjectRef<CoroutineContext> $leftoverContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineContextKt$foldCopies$folded$1(Ref.ObjectRef<CoroutineContext> objectRef, boolean z) {
        super(2);
        this.$leftoverContext = objectRef;
        this.$isNewCoroutine = z;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T, kotlin.coroutines.CoroutineContext] */
    @Override // kotlin.jvm.functions.Function2
    public final CoroutineContext invoke(CoroutineContext coroutineContext, CoroutineContext.Element element) {
        if (element instanceof CopyableThreadContextElement) {
            CoroutineContext.Element element2 = this.$leftoverContext.element.get(element.getKey());
            if (element2 == null) {
                CopyableThreadContextElement copyableThreadContextElement = (CopyableThreadContextElement) element;
                if (this.$isNewCoroutine) {
                    copyableThreadContextElement = copyableThreadContextElement.copyForChild();
                }
                return coroutineContext.plus(copyableThreadContextElement);
            }
            Ref.ObjectRef<CoroutineContext> objectRef = this.$leftoverContext;
            objectRef.element = objectRef.element.minusKey(element.getKey());
            return coroutineContext.plus(((CopyableThreadContextElement) element).mergeForChild(element2));
        }
        return coroutineContext.plus(element);
    }
}
