package com.lagradost.cloudstream3.movieproviders;

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
/* compiled from: TocanimeProvider.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "script", "Lorg/jsoup/nodes/Element;", "kotlin.jvm.PlatformType"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.TocanimeProvider$loadLinks$2", m98f = "TocanimeProvider.kt", m97i = {}, m96l = {134}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class TocanimeProvider$loadLinks$2 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ String $data;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TocanimeProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TocanimeProvider$loadLinks$2(String str, TocanimeProvider tocanimeProvider, Function1<? super ExtractorLink, Unit> function1, Continuation<? super TocanimeProvider$loadLinks$2> continuation) {
        super(2, continuation);
        this.$data = str;
        this.this$0 = tocanimeProvider;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TocanimeProvider$loadLinks$2 tocanimeProvider$loadLinks$2 = new TocanimeProvider$loadLinks$2(this.$data, this.this$0, this.$callback, continuation);
        tocanimeProvider$loadLinks$2.L$0 = obj;
        return tocanimeProvider$loadLinks$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Element element, Continuation<? super Unit> continuation) {
        return ((TocanimeProvider$loadLinks$2) create(element, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(1:(1:4)(2:21|22))(4:23|(2:25|(1:27))|15|16)|5|6|7|8|(2:10|(1:14))|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x014d, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x014e, code lost:
        r0.printStackTrace();
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r27) {
        /*
            Method dump skipped, instructions count: 411
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.TocanimeProvider$loadLinks$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
