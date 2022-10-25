package com.lagradost.nicehttp;

import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Requests.kt */
@Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class NiceResponse$url$2 extends Lambda implements Functions<String> {
    final /* synthetic */ NiceResponse this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NiceResponse$url$2(NiceResponse niceResponse) {
        super(0);
        this.this$0 = niceResponse;
    }

    @Override // kotlin.jvm.functions.Functions
    public final String invoke() {
        return this.this$0.getOkhttpResponse().request().url().toString();
    }
}
