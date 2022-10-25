package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TwoEmbedProvider.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "serverID", "", "kotlin.jvm.PlatformType"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.TwoEmbedProvider$loadLinks$2", m98f = "TwoEmbedProvider.kt", m97i = {0}, m96l = {62, 63, 67, 69}, m95m = "invokeSuspend", m94n = {"serverID"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class TwoEmbedProvider$loadLinks$2 extends SuspendLambda implements Function2<String, Continuation<? super Object>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ String $captchaKey;
    final /* synthetic */ String $embedUrl;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TwoEmbedProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TwoEmbedProvider.kt */
    @Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "it", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.movieproviders.TwoEmbedProvider$loadLinks$2$1 */
    /* loaded from: classes3.dex */
    public static final class C48301 extends Lambda implements Function1<String, String> {
        public static final C48301 INSTANCE = new C48301();

        C48301() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TwoEmbedProvider$loadLinks$2(String str, String str2, TwoEmbedProvider twoEmbedProvider, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super TwoEmbedProvider$loadLinks$2> continuation) {
        super(2, continuation);
        this.$embedUrl = str;
        this.$captchaKey = str2;
        this.this$0 = twoEmbedProvider;
        this.$subtitleCallback = function1;
        this.$callback = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TwoEmbedProvider$loadLinks$2 twoEmbedProvider$loadLinks$2 = new TwoEmbedProvider$loadLinks$2(this.$embedUrl, this.$captchaKey, this.this$0, this.$subtitleCallback, this.$callback, continuation);
        twoEmbedProvider$loadLinks$2.L$0 = obj;
        return twoEmbedProvider$loadLinks$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(String str, Continuation<? super Object> continuation) {
        return invoke2(str, (Continuation<Object>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(String str, Continuation<Object> continuation) {
        return ((TwoEmbedProvider$loadLinks$2) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f2  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.TwoEmbedProvider$loadLinks$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
