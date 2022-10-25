package com.lagradost.nicehttp;

import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Requests.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "Lorg/jsoup/nodes/Document;", "kotlin.jvm.PlatformType", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class NiceResponse$document$2 extends Lambda implements Functions<Document> {
    final /* synthetic */ NiceResponse this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NiceResponse$document$2(NiceResponse niceResponse) {
        super(0);
        this.this$0 = niceResponse;
    }

    @Override // kotlin.jvm.functions.Functions
    public final Document invoke() {
        return Jsoup.parse(this.this$0.getText());
    }
}
