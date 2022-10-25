package com.lagradost.cloudstream3.animeproviders;

import com.lagradost.cloudstream3.DubStatus;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ZoroProvider.kt */
@Metadata(m108d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "Lcom/lagradost/cloudstream3/DubStatus;", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.animeproviders.ZoroProvider$loadLinks$3", m98f = "ZoroProvider.kt", m97i = {0, 1, 1}, m96l = {346, 350, 353}, m95m = "invokeSuspend", m94n = {"it", "it", "extractorLink"}, m93s = {"L$0", "L$0", "L$1"})
/* loaded from: classes3.dex */
public final class ZoroProvider$loadLinks$3 extends SuspendLambda implements Function2<Tuples<? extends DubStatus, ? extends String>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ String $extractorData;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ZoroProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ZoroProvider$loadLinks$3(ZoroProvider zoroProvider, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, String str, Continuation<? super ZoroProvider$loadLinks$3> continuation) {
        super(2, continuation);
        this.this$0 = zoroProvider;
        this.$subtitleCallback = function1;
        this.$callback = function12;
        this.$extractorData = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ZoroProvider$loadLinks$3 zoroProvider$loadLinks$3 = new ZoroProvider$loadLinks$3(this.this$0, this.$subtitleCallback, this.$callback, this.$extractorData, continuation);
        zoroProvider$loadLinks$3.L$0 = obj;
        return zoroProvider$loadLinks$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Tuples<? extends DubStatus, ? extends String> tuples, Continuation<? super Unit> continuation) {
        return invoke2((Tuples<? extends DubStatus, String>) tuples, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(Tuples<? extends DubStatus, String> tuples, Continuation<? super Unit> continuation) {
        return ((ZoroProvider$loadLinks$3) create(tuples, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00c6  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.animeproviders.ZoroProvider$loadLinks$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ZoroProvider.kt */
    @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "videoLink", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.animeproviders.ZoroProvider$loadLinks$3$1 */
    /* loaded from: classes3.dex */
    public static final class C47711 extends Lambda implements Function1<ExtractorLink, Unit> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C47711(Function1<? super ExtractorLink, Unit> function1) {
            super(1);
            this.$callback = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ExtractorLink extractorLink) {
            invoke2(extractorLink);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(ExtractorLink videoLink) {
            Intrinsics.checkNotNullParameter(videoLink, "videoLink");
            if (StringsKt.contains$default((CharSequence) videoLink.getUrl(), (CharSequence) "betterstream", false, 2, (Object) null)) {
                return;
            }
            this.$callback.invoke(videoLink);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ZoroProvider.kt */
    @Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "sourceName", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.animeproviders.ZoroProvider$loadLinks$3$2 */
    /* loaded from: classes3.dex */
    public static final class C47722 extends Lambda implements Function1<String, String> {
        final /* synthetic */ Tuples<DubStatus, String> $it;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C47722(Tuples<? extends DubStatus, String> tuples) {
            super(1);
            this.$it = tuples;
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(String sourceName) {
            Intrinsics.checkNotNullParameter(sourceName, "sourceName");
            return sourceName + " - " + this.$it.getFirst();
        }
    }
}
