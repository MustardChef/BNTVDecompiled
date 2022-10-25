package com.lagradost.cloudstream3.utils;

import com.lagradost.cloudstream3.utils.M3u8Helper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: M3u8Helper.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lcom/lagradost/cloudstream3/utils/M3u8Helper$M3u8Stream;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.utils.M3u8Helper$m3u8Generation$generate$1", m98f = "M3u8Helper.kt", m97i = {0, 0, 0, 0, 0, 1, 1, 1}, m96l = {139, 149, 158}, m95m = "invokeSuspend", m94n = {"$this$sequence", "m3u8Parent", "quality", "m3u8Link", "hasAnyContent", "$this$sequence", "m3u8Parent", "hasAnyContent"}, m93s = {"L$0", "L$1", "L$3", "L$4", "I$0", "L$0", "L$1", "I$0"})
/* loaded from: classes4.dex */
public final class M3u8Helper$m3u8Generation$generate$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super M3u8Helper.M3u8Stream>, Continuation<? super Unit>, Object> {
    final /* synthetic */ M3u8Helper.M3u8Stream $m3u8;
    final /* synthetic */ Boolean $returnThis;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ M3u8Helper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M3u8Helper$m3u8Generation$generate$1(M3u8Helper m3u8Helper, M3u8Helper.M3u8Stream m3u8Stream, Boolean bool, Continuation<? super M3u8Helper$m3u8Generation$generate$1> continuation) {
        super(2, continuation);
        this.this$0 = m3u8Helper;
        this.$m3u8 = m3u8Stream;
        this.$returnThis = bool;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        M3u8Helper$m3u8Generation$generate$1 m3u8Helper$m3u8Generation$generate$1 = new M3u8Helper$m3u8Generation$generate$1(this.this$0, this.$m3u8, this.$returnThis, continuation);
        m3u8Helper$m3u8Generation$generate$1.L$0 = obj;
        return m3u8Helper$m3u8Generation$generate$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super M3u8Helper.M3u8Stream> sequenceScope, Continuation<? super Unit> continuation) {
        return ((M3u8Helper$m3u8Generation$generate$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x017d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0184  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x017e -> B:43:0x0181). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            Method dump skipped, instructions count: 451
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.M3u8Helper$m3u8Generation$generate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
