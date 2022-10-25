package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.databind.json.JsonMapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: Extensions.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m107d2 = {"<anonymous>", "", "Lcom/fasterxml/jackson/databind/json/JsonMapper$Builder;"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes2.dex */
final class ExtensionsKt$jsonMapper$1 extends Lambda implements Function1<JsonMapper.Builder, Unit> {
    public static final ExtensionsKt$jsonMapper$1 INSTANCE = new ExtensionsKt$jsonMapper$1();

    ExtensionsKt$jsonMapper$1() {
        super(1);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(JsonMapper.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "$this$null");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(JsonMapper.Builder builder) {
        invoke2(builder);
        return Unit.INSTANCE;
    }
}
