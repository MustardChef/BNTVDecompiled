package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IdlixProvider.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u008a@"}, m107d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "", "nume", "", "kotlin.jvm.PlatformType"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.IdlixProvider$loadLinks$3", m98f = "IdlixProvider.kt", m97i = {}, m96l = {337}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class IdlixProvider$loadLinks$3 extends SuspendLambda implements Function2<String, Continuation<? super Resource<? extends Object>>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ String $data;
    final /* synthetic */ String $id;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    final /* synthetic */ String $type;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ IdlixProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public IdlixProvider$loadLinks$3(IdlixProvider idlixProvider, String str, String str2, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, String str3, Continuation<? super IdlixProvider$loadLinks$3> continuation) {
        super(2, continuation);
        this.this$0 = idlixProvider;
        this.$id = str;
        this.$type = str2;
        this.$subtitleCallback = function1;
        this.$callback = function12;
        this.$data = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        IdlixProvider$loadLinks$3 idlixProvider$loadLinks$3 = new IdlixProvider$loadLinks$3(this.this$0, this.$id, this.$type, this.$subtitleCallback, this.$callback, this.$data, continuation);
        idlixProvider$loadLinks$3.L$0 = obj;
        return idlixProvider$loadLinks$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Resource<? extends Object>> continuation) {
        return ((IdlixProvider$loadLinks$3) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IdlixProvider.kt */
    @Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.IdlixProvider$loadLinks$3$1", m98f = "IdlixProvider.kt", m97i = {}, m96l = {338, 349, 354, 359, 366, 368}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.lagradost.cloudstream3.movieproviders.IdlixProvider$loadLinks$3$1 */
    /* loaded from: classes3.dex */
    public static final class C48091 extends SuspendLambda implements Function1<Continuation<? super Object>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $data;
        final /* synthetic */ String $id;
        final /* synthetic */ String $nume;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        final /* synthetic */ String $type;
        int label;
        final /* synthetic */ IdlixProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C48091(IdlixProvider idlixProvider, String str, String str2, String str3, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, String str4, Continuation<? super C48091> continuation) {
            super(1, continuation);
            this.this$0 = idlixProvider;
            this.$id = str;
            this.$nume = str2;
            this.$type = str3;
            this.$subtitleCallback = function1;
            this.$callback = function12;
            this.$data = str4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C48091(this.this$0, this.$id, this.$nume, this.$type, this.$subtitleCallback, this.$callback, this.$data, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Object> continuation) {
            return invoke2((Continuation<Object>) continuation);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<Object> continuation) {
            return ((C48091) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x00d7  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00ed  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0180 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0181  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r28) {
            /*
                Method dump skipped, instructions count: 406
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.IdlixProvider$loadLinks$3.C48091.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            IdlixProvider idlixProvider = this.this$0;
            String str = this.$id;
            this.label = 1;
            obj = ArchComponentExt.safeApiCall(new C48091(idlixProvider, str, (String) this.L$0, this.$type, this.$subtitleCallback, this.$callback, this.$data, null), this);
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
