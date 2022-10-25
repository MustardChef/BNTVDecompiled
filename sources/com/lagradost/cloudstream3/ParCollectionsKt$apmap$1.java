package com.lagradost.cloudstream3;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ParCollections.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0002*\u00020\u0005H\u008a@"}, m107d2 = {"<anonymous>", "", "R", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ParCollectionsKt$apmap$1", m98f = "ParCollections.kt", m97i = {0}, m96l = {30}, m95m = "invokeSuspend", m94n = {"destination$iv$iv"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class ParCollectionsKt$apmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends R>>, Object> {

    /* renamed from: $f */
    final /* synthetic */ Function2<Map.Entry<? extends K, ? extends V>, Continuation<? super R>, Object> f9901$f;
    final /* synthetic */ Map<? extends K, V> $this_apmap;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ParCollectionsKt$apmap$1(Map<? extends K, ? extends V> map, Function2<? super Map.Entry<? extends K, ? extends V>, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super ParCollectionsKt$apmap$1> continuation) {
        super(2, continuation);
        this.$this_apmap = map;
        this.f9901$f = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ParCollectionsKt$apmap$1 parCollectionsKt$apmap$1 = new ParCollectionsKt$apmap$1(this.$this_apmap, this.f9901$f, continuation);
        parCollectionsKt$apmap$1.L$0 = obj;
        return parCollectionsKt$apmap$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends R>> continuation) {
        return ((ParCollectionsKt$apmap$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a9  */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x009b -> B:19:0x00a1). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 1
            if (r1 == 0) goto L28
            if (r1 != r2) goto L20
            java.lang.Object r1 = r11.L$2
            java.util.Collection r1 = (java.util.Collection) r1
            java.lang.Object r3 = r11.L$1
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r4 = r11.L$0
            java.util.Collection r4 = (java.util.Collection) r4
            kotlin.ResultKt.throwOnFailure(r12)
            r5 = r3
            r3 = r1
            r1 = r0
            r0 = r11
            goto La1
        L20:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L28:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            kotlinx.coroutines.CoroutineScope r12 = (kotlinx.coroutines.CoroutineScope) r12
            java.util.Map<? extends K, V> r1 = r11.$this_apmap
            kotlin.jvm.functions.Function2<java.util.Map$Entry<? extends K, ? extends V>, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r9 = r11.f9901$f
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = r1.size()
            r3.<init>(r4)
            r10 = r3
            java.util.Collection r10 = (java.util.Collection) r10
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L47:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L68
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            r4 = 0
            r5 = 0
            com.lagradost.cloudstream3.ParCollectionsKt$apmap$1$1$1 r6 = new com.lagradost.cloudstream3.ParCollectionsKt$apmap$1$1$1
            r7 = 0
            r6.<init>(r9, r3, r7)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r7 = 3
            r8 = 0
            r3 = r12
            kotlinx.coroutines.Deferred r3 = kotlinx.coroutines.BuildersKt.async$default(r3, r4, r5, r6, r7, r8)
            r10.add(r3)
            goto L47
        L68:
            java.util.List r10 = (java.util.List) r10
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r12 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r10, r1)
            r12.<init>(r1)
            java.util.Collection r12 = (java.util.Collection) r12
            java.util.Iterator r1 = r10.iterator()
            r3 = r1
            r1 = r12
            r12 = r11
        L80:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto La9
            java.lang.Object r4 = r3.next()
            kotlinx.coroutines.Deferred r4 = (kotlinx.coroutines.Deferred) r4
            r12.L$0 = r1
            r12.L$1 = r3
            r12.L$2 = r1
            r12.label = r2
            java.lang.Object r4 = r4.await(r12)
            if (r4 != r0) goto L9b
            return r0
        L9b:
            r5 = r3
            r3 = r1
            r1 = r0
            r0 = r12
            r12 = r4
            r4 = r3
        La1:
            r3.add(r12)
            r12 = r0
            r0 = r1
            r1 = r4
            r3 = r5
            goto L80
        La9:
            java.util.List r1 = (java.util.List) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.ParCollectionsKt$apmap$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
