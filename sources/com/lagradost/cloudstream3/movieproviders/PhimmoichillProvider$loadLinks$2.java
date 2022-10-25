package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PhimmoichillProvider.kt */
@Metadata(m108d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u008a@"}, m107d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.PhimmoichillProvider$loadLinks$2", m98f = "PhimmoichillProvider.kt", m97i = {}, m96l = {164}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class PhimmoichillProvider$loadLinks$2 extends SuspendLambda implements Function2<Tuples<? extends String, ? extends String>, Continuation<? super Resource<? extends Unit>>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PhimmoichillProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PhimmoichillProvider$loadLinks$2(Function1<? super ExtractorLink, Unit> function1, PhimmoichillProvider phimmoichillProvider, Continuation<? super PhimmoichillProvider$loadLinks$2> continuation) {
        super(2, continuation);
        this.$callback = function1;
        this.this$0 = phimmoichillProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PhimmoichillProvider$loadLinks$2 phimmoichillProvider$loadLinks$2 = new PhimmoichillProvider$loadLinks$2(this.$callback, this.this$0, continuation);
        phimmoichillProvider$loadLinks$2.L$0 = obj;
        return phimmoichillProvider$loadLinks$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Tuples<? extends String, ? extends String> tuples, Continuation<? super Resource<? extends Unit>> continuation) {
        return invoke2((Tuples<String, String>) tuples, (Continuation<? super Resource<Unit>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(Tuples<String, String> tuples, Continuation<? super Resource<Unit>> continuation) {
        return ((PhimmoichillProvider$loadLinks$2) create(tuples, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PhimmoichillProvider.kt */
    @Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.PhimmoichillProvider$loadLinks$2$1", m98f = "PhimmoichillProvider.kt", m97i = {}, m96l = {177}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.lagradost.cloudstream3.movieproviders.PhimmoichillProvider$loadLinks$2$1 */
    /* loaded from: classes3.dex */
    public static final class C48151 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $link;
        final /* synthetic */ String $source;
        int label;
        final /* synthetic */ PhimmoichillProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C48151(String str, Function1<? super ExtractorLink, Unit> function1, String str2, PhimmoichillProvider phimmoichillProvider, Continuation<? super C48151> continuation) {
            super(1, continuation);
            this.$source = str;
            this.$callback = function1;
            this.$link = str2;
            this.this$0 = phimmoichillProvider;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C48151(this.$source, this.$callback, this.$link, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C48151) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(9:1|(1:(1:4)(2:31|32))(2:33|(3:35|26|27)(2:36|(1:38)))|5|6|7|8|(4:14|(2:17|15)|18|19)|20|(2:22|23)(3:25|26|27)) */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x00b2, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x00b3, code lost:
            r0.printStackTrace();
            r0 = null;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                Method dump skipped, instructions count: 332
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.PhimmoichillProvider$loadLinks$2.C48151.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Tuples tuples = (Tuples) this.L$0;
            String str = (String) tuples.component2();
            Function1<ExtractorLink, Unit> function1 = this.$callback;
            this.label = 1;
            obj = ArchComponentExt.safeApiCall(new C48151(str, function1, (String) tuples.component1(), this.this$0, null), this);
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
