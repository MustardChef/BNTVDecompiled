package com.lagradost.cloudstream3.utils;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.cast.MediaTrack;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: Coroutines.kt */
@Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u001c\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006ø\u0001\u0000¢\u0006\u0002\u0010\tJ,\u0010\n\u001a\u00020\u00042\u001c\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0014\u0010\u000b\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\b0\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/Coroutines;", "", "()V", "ioSafe", "Lkotlinx/coroutines/Job;", "work", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", MediaTrack.ROLE_MAIN, "runOnMainThread", "Lkotlin/Function0;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class Coroutines {
    public static final Coroutines INSTANCE = new Coroutines();

    private Coroutines() {
    }

    public final Job main(Function1<? super Continuation<? super Unit>, ? extends Object> work) {
        Intrinsics.checkNotNullParameter(work, "work");
        return BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new Coroutines$main$1(work, null), 3, null);
    }

    public final Job ioSafe(Function1<? super Continuation<? super Unit>, ? extends Object> work) {
        Intrinsics.checkNotNullParameter(work, "work");
        return BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new Coroutines$ioSafe$1(work, null), 3, null);
    }

    public final void runOnMainThread(final Functions<Unit> work) {
        Intrinsics.checkNotNullParameter(work, "work");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.lagradost.cloudstream3.utils.-$$Lambda$Coroutines$2oNhc4k7ekGvxEU9DP0Z9ggFSEI
            @Override // java.lang.Runnable
            public final void run() {
                Coroutines.m8997runOnMainThread$lambda0(Functions.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: runOnMainThread$lambda-0  reason: not valid java name */
    public static final void m8997runOnMainThread$lambda0(Functions work) {
        Intrinsics.checkNotNullParameter(work, "$work");
        work.invoke();
    }
}
