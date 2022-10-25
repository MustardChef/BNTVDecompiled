package com.lagradost.cloudstream3;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ParCollections.kt */
@Metadata(m108d1 = {"\u0000\b\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ParCollectionsKt$apmapIndexed$1$1$1", m98f = "ParCollections.kt", m97i = {}, m96l = {38}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
final class ParCollectionsKt$apmapIndexed$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super B>, Object> {

    /* renamed from: $a */
    final /* synthetic */ A f9906$a;

    /* renamed from: $f */
    final /* synthetic */ Function3<Integer, A, Continuation<? super B>, Object> f9907$f;
    final /* synthetic */ int $index;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ParCollectionsKt$apmapIndexed$1$1$1(Function3<? super Integer, ? super A, ? super Continuation<? super B>, ? extends Object> function3, int i, A a, Continuation<? super ParCollectionsKt$apmapIndexed$1$1$1> continuation) {
        super(2, continuation);
        this.f9907$f = function3;
        this.$index = i;
        this.f9906$a = a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ParCollectionsKt$apmapIndexed$1$1$1(this.f9907$f, this.$index, this.f9906$a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super B> continuation) {
        return ((ParCollectionsKt$apmapIndexed$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function3<Integer, A, Continuation<? super B>, Object> function3 = this.f9907$f;
            Integer boxInt = boxing.boxInt(this.$index);
            A a = this.f9906$a;
            this.label = 1;
            obj = function3.invoke(boxInt, a, this);
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
