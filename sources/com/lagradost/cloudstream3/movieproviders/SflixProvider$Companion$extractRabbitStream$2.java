package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SflixProvider.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.SflixProvider$Companion$extractRabbitStream$2", m98f = "SflixProvider.kt", m97i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5}, m96l = {650, 654, 660, 661, 666, 676}, m95m = "invokeSuspend", m94n = {"mainIframeUrl", "mainIframeId", "mainIframeUrl", "mainIframeId", "iframe", "mainIframeUrl", "mainIframeId", "iframeToken", "number", "sid", "mainIframeUrl", "mainIframeId", "iframeToken", "number", "sid", "it", "mainIframeUrl", "mainIframeId", "iframeToken", "number", "sid", "it", "sid"}, m93s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$7", "L$0"})
/* loaded from: classes3.dex */
public final class SflixProvider$Companion$extractRabbitStream$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ String $extractorData;
    final /* synthetic */ Function1<String, String> $nameTransformer;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    final /* synthetic */ MainAPI $this_extractRabbitStream;
    final /* synthetic */ String $url;
    final /* synthetic */ boolean $useSidAuthentication;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SflixProvider$Companion$extractRabbitStream$2(String str, MainAPI mainAPI, boolean z, String str2, Function1<? super SubtitleFile, Unit> function1, Function1<? super String, String> function12, Function1<? super ExtractorLink, Unit> function13, Continuation<? super SflixProvider$Companion$extractRabbitStream$2> continuation) {
        super(1, continuation);
        this.$url = str;
        this.$this_extractRabbitStream = mainAPI;
        this.$useSidAuthentication = z;
        this.$extractorData = str2;
        this.$subtitleCallback = function1;
        this.$nameTransformer = function12;
        this.$callback = function13;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new SflixProvider$Companion$extractRabbitStream$2(this.$url, this.$this_extractRabbitStream, this.$useSidAuthentication, this.$extractorData, this.$subtitleCallback, this.$nameTransformer, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((SflixProvider$Companion$extractRabbitStream$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x03c5, code lost:
        if (r0 == null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x047d, code lost:
        r5 = com.lagradost.cloudstream3.movieproviders.SflixProvider.Companion.toSubtitleFile(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x04f9, code lost:
        r9 = com.lagradost.cloudstream3.movieproviders.SflixProvider.Companion.toExtractorLink(r9, r2, (java.lang.String) r3.invoke(r6.getSecond()), r4);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0175 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0306 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0447 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x04d7  */
    /* JADX WARN: Type inference failed for: r0v42, types: [T, java.lang.String] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r57) {
        /*
            Method dump skipped, instructions count: 1378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.SflixProvider$Companion$extractRabbitStream$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
