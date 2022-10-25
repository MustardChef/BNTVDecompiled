package com.lagradost.cloudstream3.movieproviders;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.random.Random;
import kotlin.ranges.Ranges;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SuperStream.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class SuperStream$randomToken$1 extends Lambda implements Function1<Integer, CharSequence> {
    public static final SuperStream$randomToken$1 INSTANCE = new SuperStream$randomToken$1();

    SuperStream$randomToken$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final CharSequence invoke(int i) {
        return String.valueOf(((Character) CollectionsKt.random(CollectionsKt.plus((Iterable) new Ranges('0', '9'), (Iterable) new Ranges('a', 'f')), Random.Default)).charValue());
    }
}
