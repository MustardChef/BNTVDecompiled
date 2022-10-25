package com.anggrayudi.storage.extension;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Functions;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CoroutineExt.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
@DebugMetadata(m99c = "com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1", m98f = "CoroutineExt.kt", m97i = {}, m96l = {16, 24}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes.dex */
final class CoroutineExtKt$startCoroutineTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Functions<Unit> $action;
    final /* synthetic */ long $delayMillis;
    final /* synthetic */ long $repeatMillis;
    final /* synthetic */ boolean $runActionOnUiThread;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineExtKt$startCoroutineTimer$1(long j, long j2, boolean z, Functions<Unit> functions, Continuation<? super CoroutineExtKt$startCoroutineTimer$1> continuation) {
        super(2, continuation);
        this.$delayMillis = j;
        this.$repeatMillis = j2;
        this.$runActionOnUiThread = z;
        this.$action = functions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoroutineExtKt$startCoroutineTimer$1(this.$delayMillis, this.$repeatMillis, this.$runActionOnUiThread, this.$action, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoroutineExtKt$startCoroutineTimer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L1f
            if (r1 == r4) goto L1b
            if (r1 != r3) goto L13
            kotlin.ResultKt.throwOnFailure(r9)
            goto L38
        L13:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1b:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L30
        L1f:
            kotlin.ResultKt.throwOnFailure(r9)
            long r5 = r8.$delayMillis
            r9 = r8
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r8.label = r4
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r5, r9)
            if (r9 != r0) goto L30
            return r0
        L30:
            long r4 = r8.$repeatMillis
            r6 = 0
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 <= 0) goto L5d
        L38:
            r9 = r8
        L39:
            boolean r1 = r9.$runActionOnUiThread
            if (r1 == 0) goto L4a
            com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1$1 r1 = new com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1$1
            kotlin.jvm.functions.Function0<kotlin.Unit> r4 = r9.$action
            r1.<init>(r4, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            com.anggrayudi.storage.extension.CoroutineExt.launchOnUiThread(r1)
            goto L4f
        L4a:
            kotlin.jvm.functions.Function0<kotlin.Unit> r1 = r9.$action
            r1.invoke()
        L4f:
            long r4 = r9.$repeatMillis
            r1 = r9
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r9.label = r3
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r4, r1)
            if (r1 != r0) goto L39
            return r0
        L5d:
            boolean r9 = r8.$runActionOnUiThread
            if (r9 == 0) goto L6e
            com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1$2 r9 = new com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1$2
            kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r8.$action
            r9.<init>(r0, r2)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            com.anggrayudi.storage.extension.CoroutineExt.launchOnUiThread(r9)
            goto L73
        L6e:
            kotlin.jvm.functions.Function0<kotlin.Unit> r9 = r8.$action
            r9.invoke()
        L73:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CoroutineExt.kt */
    @Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
    @DebugMetadata(m99c = "com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1$1", m98f = "CoroutineExt.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1$1 */
    /* loaded from: classes.dex */
    public static final class C10851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Functions<Unit> $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10851(Functions<Unit> functions, Continuation<? super C10851> continuation) {
            super(2, continuation);
            this.$action = functions;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10851(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10851) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$action.invoke();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CoroutineExt.kt */
    @Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
    @DebugMetadata(m99c = "com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1$2", m98f = "CoroutineExt.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1$2 */
    /* loaded from: classes.dex */
    public static final class C10862 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Functions<Unit> $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10862(Functions<Unit> functions, Continuation<? super C10862> continuation) {
            super(2, continuation);
            this.$action = functions;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10862(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10862) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$action.invoke();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
