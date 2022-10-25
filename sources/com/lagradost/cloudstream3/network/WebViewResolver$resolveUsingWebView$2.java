package com.lagradost.cloudstream3.network;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.Request;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WebViewResolver.kt */
@Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m107d2 = {"<anonymous>", "", "it", "Lokhttp3/Request;", "invoke", "(Lokhttp3/Request;)Ljava/lang/Boolean;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class WebViewResolver$resolveUsingWebView$2 extends Lambda implements Function1<Request, Boolean> {
    public static final WebViewResolver$resolveUsingWebView$2 INSTANCE = new WebViewResolver$resolveUsingWebView$2();

    WebViewResolver$resolveUsingWebView$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Request it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return false;
    }
}
