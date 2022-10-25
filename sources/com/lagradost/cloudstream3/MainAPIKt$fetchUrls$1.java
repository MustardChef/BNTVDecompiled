package com.lagradost.cloudstream3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.MatchResult;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainAPI.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "Lkotlin/text/MatchResult;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class MainAPIKt$fetchUrls$1 extends Lambda implements Function1<MatchResult, String> {
    public static final MainAPIKt$fetchUrls$1 INSTANCE = new MainAPIKt$fetchUrls$1();

    MainAPIKt$fetchUrls$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(MatchResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt.removeSurrounding(StringsKt.trim((CharSequence) it.getValue()).toString(), (CharSequence) "\"");
    }
}
