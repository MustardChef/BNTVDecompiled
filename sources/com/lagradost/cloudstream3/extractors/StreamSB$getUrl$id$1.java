package com.lagradost.cloudstream3.extractors;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StreamSB.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "Lkotlin/text/MatchResult;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class StreamSB$getUrl$id$1 extends Lambda implements Function1<MatchResult, String> {
    public static final StreamSB$getUrl$id$1 INSTANCE = new StreamSB$getUrl$id$1();

    StreamSB$getUrl$id$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(MatchResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new Regex("(embed-|\\/e\\/)").replace(it.getValue(), "");
    }
}
