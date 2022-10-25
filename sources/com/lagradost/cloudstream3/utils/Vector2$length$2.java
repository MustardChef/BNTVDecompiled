package com.lagradost.cloudstream3.utils;

import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Vector2.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, m107d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class Vector2$length$2 extends Lambda implements Functions<Float> {
    final /* synthetic */ Vector2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Vector2$length$2(Vector2 vector2) {
        super(0);
        this.this$0 = vector2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Functions
    public final Float invoke() {
        float lengthSquared;
        lengthSquared = this.this$0.getLengthSquared();
        return Float.valueOf((float) Math.sqrt(lengthSquared));
    }
}
