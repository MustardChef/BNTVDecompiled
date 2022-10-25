package com.lagradost.cloudstream3.movieproviders;

import com.google.ads.interactivemedia.p034v3.internal.bqk;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
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
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DramaidProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "it", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.DramaidProvider$loadLinks$3", m98f = "DramaidProvider.kt", m97i = {}, m96l = {208, bqk.f6548bH}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class DramaidProvider$loadLinks$3 extends SuspendLambda implements Function2<String, Continuation<? super Object>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ String $data;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DramaidProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DramaidProvider$loadLinks$3(DramaidProvider dramaidProvider, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, String str, Continuation<? super DramaidProvider$loadLinks$3> continuation) {
        super(2, continuation);
        this.this$0 = dramaidProvider;
        this.$subtitleCallback = function1;
        this.$callback = function12;
        this.$data = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DramaidProvider$loadLinks$3 dramaidProvider$loadLinks$3 = new DramaidProvider$loadLinks$3(this.this$0, this.$subtitleCallback, this.$callback, this.$data, continuation);
        dramaidProvider$loadLinks$3.L$0 = obj;
        return dramaidProvider$loadLinks$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(String str, Continuation<? super Object> continuation) {
        return invoke2(str, (Continuation<Object>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(String str, Continuation<Object> continuation) {
        return ((DramaidProvider$loadLinks$3) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object invokeDriveSource;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.L$0;
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) "motonews.club", false, 2, (Object) null)) {
                DramaidProvider dramaidProvider = this.this$0;
                this.label = 1;
                invokeDriveSource = dramaidProvider.invokeDriveSource(str, dramaidProvider.getName(), this.$subtitleCallback, this.$callback, this);
                if (invokeDriveSource == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.label = 2;
                Object loadExtractor = ExtractorApiKt.loadExtractor(str, this.$data, this.$subtitleCallback, this.$callback, this);
                return loadExtractor == coroutine_suspended ? coroutine_suspended : loadExtractor;
            }
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
