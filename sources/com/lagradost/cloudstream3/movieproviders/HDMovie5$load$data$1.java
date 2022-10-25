package com.lagradost.cloudstream3.movieproviders;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jsoup.nodes.Element;

/* compiled from: HDMovie5.kt */
@Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "kotlin.jvm.PlatformType", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
final class HDMovie5$load$data$1 extends Lambda implements Function1<Element, CharSequence> {
    public static final HDMovie5$load$data$1 INSTANCE = new HDMovie5$load$data$1();

    HDMovie5$load$data$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(Element element) {
        String attr = element.attr("data-post");
        Intrinsics.checkNotNullExpressionValue(attr, "it.attr(\"data-post\")");
        return attr;
    }
}
