package com.lagradost.nicehttp;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: Requests.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", "it", "", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
final class RequestsKt$getHeaders$cookieMap$1 extends Lambda implements Function1<Map.Entry<? extends String, ? extends String>, CharSequence> {
    public static final RequestsKt$getHeaders$cookieMap$1 INSTANCE = new RequestsKt$getHeaders$cookieMap$1();

    RequestsKt$getHeaders$cookieMap$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends String> entry) {
        return invoke2((Map.Entry<String, String>) entry);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(Map.Entry<String, String> it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getKey() + '=' + it.getValue() + ';';
    }
}
