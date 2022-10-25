package com.lagradost.nicehttp;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Requests.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class NiceResponse$cookies$2 extends Lambda implements Functions<Map<String, ? extends String>> {
    final /* synthetic */ NiceResponse this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NiceResponse$cookies$2(NiceResponse niceResponse) {
        super(0);
        this.this$0 = niceResponse;
    }

    @Override // kotlin.jvm.functions.Functions
    public final Map<String, ? extends String> invoke() {
        Map<String, ? extends String> cookies;
        cookies = RequestsKt.getCookies(this.this$0.getOkhttpResponse());
        return cookies;
    }
}
