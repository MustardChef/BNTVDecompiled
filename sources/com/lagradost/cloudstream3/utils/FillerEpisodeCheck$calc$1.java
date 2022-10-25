package com.lagradost.cloudstream3.utils;

import com.blankj.utilcode.constant.TimeConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FillerEpisodeCheck.kt */
@Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class FillerEpisodeCheck$calc$1 extends Lambda implements Functions<Unit> {
    final /* synthetic */ Ref.IntRef $counter;
    final /* synthetic */ int $this_calc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FillerEpisodeCheck$calc$1(int i, Ref.IntRef intRef) {
        super(0);
        this.$this_calc = i;
        this.$counter = intRef;
    }

    @Override // kotlin.jvm.functions.Functions
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FillerEpisodeCheck.kt */
    @Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.utils.FillerEpisodeCheck$calc$1$1", m98f = "FillerEpisodeCheck.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.lagradost.cloudstream3.utils.FillerEpisodeCheck$calc$1$1 */
    /* loaded from: classes4.dex */
    public static final class C49791 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.IntRef $counter;
        final /* synthetic */ int $this_calc;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C49791(Ref.IntRef intRef, int i, Continuation<? super C49791> continuation) {
            super(1, continuation);
            this.$counter = intRef;
            this.$this_calc = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C49791(this.$counter, this.$this_calc, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C49791) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                boolean z = true;
                while (z) {
                    this.$counter.element++;
                    if (this.$this_calc > 10) {
                        z = false;
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.jvm.functions.Functions
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Thread.sleep(this.$this_calc * TimeConstants.MIN);
        Coroutines.INSTANCE.main(new C49791(this.$counter, this.$this_calc, null));
    }
}
