package com.lagradost.cloudstream3.animeproviders;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jsoup.nodes.Element;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NineAnimeProvider.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "kotlin.jvm.PlatformType"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.animeproviders.NineAnimeProvider$loadLinks$2", m98f = "NineAnimeProvider.kt", m97i = {0, 1, 1}, m96l = {340, 342}, m95m = "invokeSuspend", m94n = {"name", "name", "url"}, m93s = {"L$0", "L$0", "L$1"})
/* loaded from: classes3.dex */
public final class NineAnimeProvider$loadLinks$2 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ NineAnimeProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NineAnimeProvider$loadLinks$2(NineAnimeProvider nineAnimeProvider, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super NineAnimeProvider$loadLinks$2> continuation) {
        super(2, continuation);
        this.this$0 = nineAnimeProvider;
        this.$subtitleCallback = function1;
        this.$callback = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NineAnimeProvider$loadLinks$2 nineAnimeProvider$loadLinks$2 = new NineAnimeProvider$loadLinks$2(this.this$0, this.$subtitleCallback, this.$callback, continuation);
        nineAnimeProvider$loadLinks$2.L$0 = obj;
        return nineAnimeProvider$loadLinks$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Element element, Continuation<? super Unit> continuation) {
        return ((NineAnimeProvider$loadLinks$2) create(element, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0094 A[Catch: Exception -> 0x00cc, TryCatch #0 {Exception -> 0x00cc, blocks: (B:7:0x0018, B:29:0x008c, B:31:0x0094, B:12:0x002c, B:18:0x0059, B:20:0x005d, B:22:0x0063, B:25:0x006a, B:32:0x00c9, B:15:0x003a), top: B:38:0x000a }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            Method dump skipped, instructions count: 213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.animeproviders.NineAnimeProvider$loadLinks$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
