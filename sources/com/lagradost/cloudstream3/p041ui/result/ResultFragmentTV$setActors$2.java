package com.lagradost.cloudstream3.p041ui.result;

import com.lagradost.cloudstream3.ActorData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ResultFragmentTV.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "Lcom/lagradost/cloudstream3/ActorData;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$setActors$2 */
/* loaded from: classes4.dex */
final class ResultFragmentTV$setActors$2 extends Lambda implements Function1<ActorData, CharSequence> {
    public static final ResultFragmentTV$setActors$2 INSTANCE = new ResultFragmentTV$setActors$2();

    ResultFragmentTV$setActors$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(ActorData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getActor().getName();
    }
}
