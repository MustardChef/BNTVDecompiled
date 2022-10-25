package com.lagradost.cloudstream3.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: UnshortenUrl.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
/* synthetic */ class ShortLink$shortList$5 extends FunctionReferenceImpl implements Function2<String, Continuation<? super String>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ShortLink$shortList$5(Object obj) {
        super(2, obj, UnshortenUrl.class, "unshortenNuovoLink", "unshortenNuovoLink(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super String> continuation) {
        return ((UnshortenUrl) this.receiver).unshortenNuovoLink(str, continuation);
    }
}
