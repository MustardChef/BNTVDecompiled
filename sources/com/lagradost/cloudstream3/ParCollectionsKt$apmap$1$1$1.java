package com.lagradost.cloudstream3;

import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ParCollections.kt */
@Metadata(m108d1 = {"\u0000\b\n\u0002\b\u0004\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0001*\u00020\u0004H\u008a@"}, m107d2 = {"<anonymous>", "R", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ParCollectionsKt$apmap$1$1$1", m98f = "ParCollections.kt", m97i = {}, m96l = {30}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
final class ParCollectionsKt$apmap$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {

    /* renamed from: $f */
    final /* synthetic */ Function2<Map.Entry<? extends K, ? extends V>, Continuation<? super R>, Object> f9902$f;
    final /* synthetic */ Map.Entry<K, V> $it;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ParCollectionsKt$apmap$1$1$1(Function2<? super Map.Entry<? extends K, ? extends V>, ? super Continuation<? super R>, ? extends Object> function2, Map.Entry<? extends K, ? extends V> entry, Continuation<? super ParCollectionsKt$apmap$1$1$1> continuation) {
        super(2, continuation);
        this.f9902$f = function2;
        this.$it = entry;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ParCollectionsKt$apmap$1$1$1(this.f9902$f, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
        return ((ParCollectionsKt$apmap$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<Map.Entry<? extends K, ? extends V>, Continuation<? super R>, Object> function2 = this.f9902$f;
            Object obj2 = this.$it;
            this.label = 1;
            obj = function2.invoke(obj2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
