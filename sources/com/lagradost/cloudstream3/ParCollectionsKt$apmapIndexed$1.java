package com.lagradost.cloudstream3;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ParCollections.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\u00020\u0004H\u008a@"}, m107d2 = {"<anonymous>", "", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ParCollectionsKt$apmapIndexed$1", m98f = "ParCollections.kt", m97i = {0}, m96l = {38}, m95m = "invokeSuspend", m94n = {"destination$iv$iv"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class ParCollectionsKt$apmapIndexed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends B>>, Object> {

    /* renamed from: $f */
    final /* synthetic */ Function3<Integer, A, Continuation<? super B>, Object> f9905$f;
    final /* synthetic */ List<A> $this_apmapIndexed;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ParCollectionsKt$apmapIndexed$1(List<? extends A> list, Function3<? super Integer, ? super A, ? super Continuation<? super B>, ? extends Object> function3, Continuation<? super ParCollectionsKt$apmapIndexed$1> continuation) {
        super(2, continuation);
        this.$this_apmapIndexed = list;
        this.f9905$f = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ParCollectionsKt$apmapIndexed$1 parCollectionsKt$apmapIndexed$1 = new ParCollectionsKt$apmapIndexed$1(this.$this_apmapIndexed, this.f9905$f, continuation);
        parCollectionsKt$apmapIndexed$1.L$0 = obj;
        return parCollectionsKt$apmapIndexed$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends B>> continuation) {
        return ((ParCollectionsKt$apmapIndexed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b3  */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00a5 -> B:22:0x00ab). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 1
            if (r1 == 0) goto L28
            if (r1 != r2) goto L20
            java.lang.Object r1 = r14.L$2
            java.util.Collection r1 = (java.util.Collection) r1
            java.lang.Object r3 = r14.L$1
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r4 = r14.L$0
            java.util.Collection r4 = (java.util.Collection) r4
            kotlin.ResultKt.throwOnFailure(r15)
            r5 = r3
            r3 = r1
            r1 = r0
            r0 = r14
            goto Lab
        L20:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L28:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.Object r15 = r14.L$0
            kotlinx.coroutines.CoroutineScope r15 = (kotlinx.coroutines.CoroutineScope) r15
            java.util.List<A> r1 = r14.$this_apmapIndexed
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            kotlin.jvm.functions.Function3<java.lang.Integer, A, kotlin.coroutines.Continuation<? super B>, java.lang.Object> r9 = r14.f9905$f
            java.util.ArrayList r3 = new java.util.ArrayList
            r10 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r10)
            r3.<init>(r4)
            r11 = r3
            java.util.Collection r11 = (java.util.Collection) r11
            r3 = 0
            java.util.Iterator r1 = r1.iterator()
        L48:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L74
            java.lang.Object r4 = r1.next()
            int r12 = r3 + 1
            if (r3 >= 0) goto L59
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L59:
            r5 = 0
            r6 = 0
            com.lagradost.cloudstream3.ParCollectionsKt$apmapIndexed$1$1$1 r7 = new com.lagradost.cloudstream3.ParCollectionsKt$apmapIndexed$1$1$1
            r8 = 0
            r7.<init>(r9, r3, r4, r8)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r8 = 3
            r13 = 0
            r3 = r15
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r13
            kotlinx.coroutines.Deferred r3 = kotlinx.coroutines.BuildersKt.async$default(r3, r4, r5, r6, r7, r8)
            r11.add(r3)
            r3 = r12
            goto L48
        L74:
            java.util.List r11 = (java.util.List) r11
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r15 = new java.util.ArrayList
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r11, r10)
            r15.<init>(r1)
            java.util.Collection r15 = (java.util.Collection) r15
            java.util.Iterator r1 = r11.iterator()
            r3 = r1
            r1 = r15
            r15 = r14
        L8a:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto Lb3
            java.lang.Object r4 = r3.next()
            kotlinx.coroutines.Deferred r4 = (kotlinx.coroutines.Deferred) r4
            r15.L$0 = r1
            r15.L$1 = r3
            r15.L$2 = r1
            r15.label = r2
            java.lang.Object r4 = r4.await(r15)
            if (r4 != r0) goto La5
            return r0
        La5:
            r5 = r3
            r3 = r1
            r1 = r0
            r0 = r15
            r15 = r4
            r4 = r3
        Lab:
            r3.add(r15)
            r15 = r0
            r0 = r1
            r1 = r4
            r3 = r5
            goto L8a
        Lb3:
            java.util.List r1 = (java.util.List) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.ParCollectionsKt$apmapIndexed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
