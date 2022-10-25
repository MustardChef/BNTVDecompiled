package com.lagradost.cloudstream3.utils;

import android.app.Activity;
import com.lagradost.cloudstream3.utils.InAppUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InAppUpdater.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/utils/InAppUpdater$Companion$Update;", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.utils.InAppUpdater$Companion$getPreReleaseUpdate$1", m98f = "InAppUpdater.kt", m97i = {0, 0, 1, 1}, m96l = {157, 166}, m95m = "invokeSuspend", m94n = {"tagUrl", "headers", "found", "foundAsset"}, m93s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes4.dex */
public final class InAppUpdater$Companion$getPreReleaseUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super InAppUpdater.Companion.Update>, Object> {
    final /* synthetic */ Activity $this_getPreReleaseUpdate;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppUpdater$Companion$getPreReleaseUpdate$1(Activity activity, Continuation<? super InAppUpdater$Companion$getPreReleaseUpdate$1> continuation) {
        super(2, continuation);
        this.$this_getPreReleaseUpdate = activity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InAppUpdater$Companion$getPreReleaseUpdate$1(this.$this_getPreReleaseUpdate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super InAppUpdater.Companion.Update> continuation) {
        return ((InAppUpdater$Companion$getPreReleaseUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x014d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.InAppUpdater$Companion$getPreReleaseUpdate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
