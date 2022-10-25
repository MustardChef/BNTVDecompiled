package com.lagradost.cloudstream3.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* compiled from: UnshortenUrl.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
/* synthetic */ class ShortLink$shortList$3 extends AdaptedFunctionReference implements Function2<String, Continuation<? super String>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ShortLink$shortList$3(Object obj) {
        super(2, obj, UnshortenUrl.class, "unshortenLinksafe", "unshortenLinksafe(Ljava/lang/String;)Ljava/lang/String;", 4);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super String> continuation) {
        Object unshortenLinksafe;
        unshortenLinksafe = ((UnshortenUrl) this.receiver).unshortenLinksafe(str);
        return unshortenLinksafe;
    }
}
