package com.fasterxml.jackson.databind.introspect;

import java.util.function.Function;

/* compiled from: lambda */
/* renamed from: com.fasterxml.jackson.databind.introspect.-$$Lambda$T6MEuG83q02rbsQygcYwXHkLGsk  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$T6MEuG83q02rbsQygcYwXHkLGsk implements Function {
    public static final /* synthetic */ $$Lambda$T6MEuG83q02rbsQygcYwXHkLGsk INSTANCE = new $$Lambda$T6MEuG83q02rbsQygcYwXHkLGsk();

    private /* synthetic */ $$Lambda$T6MEuG83q02rbsQygcYwXHkLGsk() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((AnnotatedMethod) obj).getFullName();
    }
}
