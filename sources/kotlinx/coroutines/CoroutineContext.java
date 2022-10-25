package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.internal.ThreadContext;

@Metadata(m108d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0002\u001a8\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\f0\u0012H\u0080\b¢\u0006\u0002\u0010\u0013\u001a4\u0010\u0014\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\f0\u0012H\u0080\b¢\u0006\u0002\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\n*\u00020\u0003H\u0002\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0003H\u0007\u001a\u0013\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c*\u00020\u001dH\u0080\u0010\u001a(\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001c*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006 "}, m107d2 = {"DEBUG_THREAD_NAME_SEPARATOR", "", "coroutineName", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "foldCopies", "originalContext", "appendContext", "isNewCoroutine", "", "withContinuationContext", ExifInterface.GPS_DIRECTION_TRUE, "continuation", "Lkotlin/coroutines/Continuation;", "countOrElement", "", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withCoroutineContext", "context", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "hasCopyableElements", "newCoroutineContext", "addedContext", "Lkotlinx/coroutines/CoroutineScope;", "undispatchedCompletion", "Lkotlinx/coroutines/UndispatchedCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "updateUndispatchedCompletion", "oldValue", "kotlinx-coroutines-core"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: kotlinx.coroutines.CoroutineContextKt */
/* loaded from: classes4.dex */
public final class CoroutineContext {
    private static final String DEBUG_THREAD_NAME_SEPARATOR = " @";

    public static final kotlin.coroutines.CoroutineContext newCoroutineContext(CoroutineScope coroutineScope, kotlin.coroutines.CoroutineContext coroutineContext) {
        kotlin.coroutines.CoroutineContext foldCopies = foldCopies(coroutineScope.getCoroutineContext(), coroutineContext, true);
        kotlin.coroutines.CoroutineContext plus = Debug.getDEBUG() ? foldCopies.plus(new CoroutineId(Debug.getCOROUTINE_ID().incrementAndGet())) : foldCopies;
        return (foldCopies == Dispatchers.getDefault() || foldCopies.get(ContinuationInterceptor.Key) != null) ? plus : plus.plus(Dispatchers.getDefault());
    }

    public static final kotlin.coroutines.CoroutineContext newCoroutineContext(kotlin.coroutines.CoroutineContext coroutineContext, kotlin.coroutines.CoroutineContext coroutineContext2) {
        return !hasCopyableElements(coroutineContext2) ? coroutineContext.plus(coroutineContext2) : foldCopies(coroutineContext, coroutineContext2, false);
    }

    private static final boolean hasCopyableElements(kotlin.coroutines.CoroutineContext coroutineContext) {
        return ((Boolean) coroutineContext.fold(false, CoroutineContextKt$hasCopyableElements$1.INSTANCE)).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [T, java.lang.Object] */
    private static final kotlin.coroutines.CoroutineContext foldCopies(kotlin.coroutines.CoroutineContext coroutineContext, kotlin.coroutines.CoroutineContext coroutineContext2, boolean z) {
        boolean hasCopyableElements = hasCopyableElements(coroutineContext);
        boolean hasCopyableElements2 = hasCopyableElements(coroutineContext2);
        if (!hasCopyableElements && !hasCopyableElements2) {
            return coroutineContext.plus(coroutineContext2);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = coroutineContext2;
        kotlin.coroutines.CoroutineContext coroutineContext3 = (kotlin.coroutines.CoroutineContext) coroutineContext.fold(EmptyCoroutineContext.INSTANCE, new CoroutineContextKt$foldCopies$folded$1(objectRef, z));
        if (hasCopyableElements2) {
            objectRef.element = ((kotlin.coroutines.CoroutineContext) objectRef.element).fold(EmptyCoroutineContext.INSTANCE, CoroutineContextKt$foldCopies$1.INSTANCE);
        }
        return coroutineContext3.plus((kotlin.coroutines.CoroutineContext) objectRef.element);
    }

    public static final <T> T withCoroutineContext(kotlin.coroutines.CoroutineContext coroutineContext, Object obj, Functions<? extends T> functions) {
        Object updateThreadContext = ThreadContext.updateThreadContext(coroutineContext, obj);
        try {
            return functions.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            ThreadContext.restoreThreadContext(coroutineContext, updateThreadContext);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final <T> T withContinuationContext(Continuation<?> continuation, Object obj, Functions<? extends T> functions) {
        UndispatchedCoroutine<?> undispatchedCoroutine;
        kotlin.coroutines.CoroutineContext context = continuation.getContext();
        Object updateThreadContext = ThreadContext.updateThreadContext(context, obj);
        if (updateThreadContext != ThreadContext.NO_THREAD_ELEMENTS) {
            undispatchedCoroutine = updateUndispatchedCompletion(continuation, context, updateThreadContext);
        } else {
            undispatchedCoroutine = null;
        }
        try {
            return functions.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            if (undispatchedCoroutine == null || undispatchedCoroutine.clearThreadContext()) {
                ThreadContext.restoreThreadContext(context, updateThreadContext);
            }
            InlineMarker.finallyEnd(1);
        }
    }

    public static final UndispatchedCoroutine<?> updateUndispatchedCompletion(Continuation<?> continuation, kotlin.coroutines.CoroutineContext coroutineContext, Object obj) {
        if (continuation instanceof CoroutineStackFrame) {
            if (coroutineContext.get(UndispatchedMarker.INSTANCE) != null) {
                UndispatchedCoroutine<?> undispatchedCompletion = undispatchedCompletion((CoroutineStackFrame) continuation);
                if (undispatchedCompletion != null) {
                    undispatchedCompletion.saveThreadContext(coroutineContext, obj);
                }
                return undispatchedCompletion;
            }
            return null;
        }
        return null;
    }

    public static final UndispatchedCoroutine<?> undispatchedCompletion(CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof DispatchedCoroutine) && (coroutineStackFrame = coroutineStackFrame.getCallerFrame()) != null) {
            if (coroutineStackFrame instanceof UndispatchedCoroutine) {
                return (UndispatchedCoroutine) coroutineStackFrame;
            }
        }
        return null;
    }

    public static final String getCoroutineName(kotlin.coroutines.CoroutineContext coroutineContext) {
        CoroutineId coroutineId;
        String name;
        if (Debug.getDEBUG() && (coroutineId = (CoroutineId) coroutineContext.get(CoroutineId.Key)) != null) {
            CoroutineName coroutineName = (CoroutineName) coroutineContext.get(CoroutineName.Key);
            String str = "coroutine";
            if (coroutineName != null && (name = coroutineName.getName()) != null) {
                str = name;
            }
            return str + '#' + coroutineId.getId();
        }
        return null;
    }
}
