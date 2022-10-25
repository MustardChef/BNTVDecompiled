package com.lagradost.cloudstream3;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ParCollections.kt */
@Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u00020\u0004H\u008a@"}, m107d2 = {"<anonymous>", "", "", "R", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ParCollectionsKt$argamap$1", m98f = "ParCollections.kt", m97i = {0}, m96l = {67}, m95m = "invokeSuspend", m94n = {"destination$iv$iv"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class ParCollectionsKt$argamap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Object>>, Object> {
    final /* synthetic */ Function1<Continuation<? super R>, Object>[] $transforms;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ParCollectionsKt$argamap$1(Function1<? super Continuation<? super R>, ? extends Object>[] function1Arr, Continuation<? super ParCollectionsKt$argamap$1> continuation) {
        super(2, continuation);
        this.$transforms = function1Arr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ParCollectionsKt$argamap$1 parCollectionsKt$argamap$1 = new ParCollectionsKt$argamap$1(this.$transforms, continuation);
        parCollectionsKt$argamap$1.L$0 = obj;
        return parCollectionsKt$argamap$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Object>> continuation) {
        return ((ParCollectionsKt$argamap$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0099  */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x008b -> B:18:0x0091). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 1
            if (r1 == 0) goto L28
            if (r1 != r2) goto L20
            java.lang.Object r1 = r12.L$2
            java.util.Collection r1 = (java.util.Collection) r1
            java.lang.Object r3 = r12.L$1
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r4 = r12.L$0
            java.util.Collection r4 = (java.util.Collection) r4
            kotlin.ResultKt.throwOnFailure(r13)
            r5 = r3
            r3 = r1
            r1 = r0
            r0 = r12
            goto L91
        L20:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L28:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            kotlinx.coroutines.CoroutineScope r13 = (kotlinx.coroutines.CoroutineScope) r13
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super R>, java.lang.Object>[] r1 = r12.$transforms
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = r1.length
            r3.<init>(r4)
            r9 = r3
            java.util.Collection r9 = (java.util.Collection) r9
            r3 = 0
            int r10 = r1.length
            r11 = 0
        L3d:
            if (r11 >= r10) goto L58
            r3 = r1[r11]
            r4 = 0
            r5 = 0
            com.lagradost.cloudstream3.ParCollectionsKt$argamap$1$1$1 r6 = new com.lagradost.cloudstream3.ParCollectionsKt$argamap$1$1$1
            r7 = 0
            r6.<init>(r3, r7)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r7 = 3
            r8 = 0
            r3 = r13
            kotlinx.coroutines.Deferred r3 = kotlinx.coroutines.BuildersKt.async$default(r3, r4, r5, r6, r7, r8)
            r9.add(r3)
            int r11 = r11 + 1
            goto L3d
        L58:
            java.util.List r9 = (java.util.List) r9
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r13 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r9, r1)
            r13.<init>(r1)
            java.util.Collection r13 = (java.util.Collection) r13
            java.util.Iterator r1 = r9.iterator()
            r3 = r1
            r1 = r13
            r13 = r12
        L70:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L99
            java.lang.Object r4 = r3.next()
            kotlinx.coroutines.Deferred r4 = (kotlinx.coroutines.Deferred) r4
            r13.L$0 = r1
            r13.L$1 = r3
            r13.L$2 = r1
            r13.label = r2
            java.lang.Object r4 = r4.await(r13)
            if (r4 != r0) goto L8b
            return r0
        L8b:
            r5 = r3
            r3 = r1
            r1 = r0
            r0 = r13
            r13 = r4
            r4 = r3
        L91:
            r3.add(r13)
            r13 = r0
            r0 = r1
            r1 = r4
            r3 = r5
            goto L70
        L99:
            java.util.List r1 = (java.util.List) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.ParCollectionsKt$argamap$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
