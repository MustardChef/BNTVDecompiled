package com.lagradost.nicehttp;

import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Requests.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, m107d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Long;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class NiceResponse$size$2 extends Lambda implements Functions<Long> {
    final /* synthetic */ NiceResponse this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NiceResponse$size$2(NiceResponse niceResponse) {
        super(0);
        this.this$0 = niceResponse;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Functions
    public final Long invoke() {
        String str = this.this$0.getOkhttpResponse().headers().get("Content-Length");
        if (str == null) {
            str = this.this$0.getOkhttpResponse().headers().get("content-length");
        }
        if (str == null) {
            return null;
        }
        return StringsKt.toLongOrNull(str);
    }
}
