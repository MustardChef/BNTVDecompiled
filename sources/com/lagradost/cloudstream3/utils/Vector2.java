package com.lagradost.cloudstream3.utils;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Vector2.kt */
@Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u000e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0000J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0011\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0000H\u0086\u0002J\u0011\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0000H\u0086\u0002J\u0011\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0018H\u0086\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u001b\u0010\u0006\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\b¨\u0006\u001e"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/Vector2;", "", "x", "", "y", "(FF)V", SessionDescription.ATTR_LENGTH, "getLength", "()F", "length$delegate", "Lkotlin/Lazy;", "lengthSquared", "getLengthSquared", "lengthSquared$delegate", "getX", "getY", "component1", "component2", "copy", "distanceTo", "other", "equals", "", "hashCode", "", "minus", "plus", "times", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class Vector2 {

    /* renamed from: x */
    private final float f10031x;

    /* renamed from: y */
    private final float f10032y;
    private final Lazy lengthSquared$delegate = LazyKt.lazy(new Vector2$lengthSquared$2(this));
    private final Lazy length$delegate = LazyKt.lazy(new Vector2$length$2(this));

    public static /* synthetic */ Vector2 copy$default(Vector2 vector2, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = vector2.f10031x;
        }
        if ((i & 2) != 0) {
            f2 = vector2.f10032y;
        }
        return vector2.copy(f, f2);
    }

    public final float component1() {
        return this.f10031x;
    }

    public final float component2() {
        return this.f10032y;
    }

    public final Vector2 copy(float f, float f2) {
        return new Vector2(f, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Vector2) {
            Vector2 vector2 = (Vector2) obj;
            return Intrinsics.areEqual((Object) Float.valueOf(this.f10031x), (Object) Float.valueOf(vector2.f10031x)) && Intrinsics.areEqual((Object) Float.valueOf(this.f10032y), (Object) Float.valueOf(vector2.f10032y));
        }
        return false;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f10031x) * 31) + Float.floatToIntBits(this.f10032y);
    }

    public Vector2(float f, float f2) {
        this.f10031x = f;
        this.f10032y = f2;
    }

    public final float getX() {
        return this.f10031x;
    }

    public final float getY() {
        return this.f10032y;
    }

    public final Vector2 minus(Vector2 other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return new Vector2(this.f10031x - other.f10031x, this.f10032y - other.f10032y);
    }

    public final Vector2 plus(Vector2 other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return new Vector2(this.f10031x + other.f10031x, this.f10032y + other.f10032y);
    }

    public final Vector2 times(int i) {
        float f = i;
        return new Vector2(this.f10031x * f, this.f10032y * f);
    }

    public String toString() {
        return '(' + this.f10031x + ", " + this.f10032y + ')';
    }

    public final float distanceTo(Vector2 other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return minus(other).getLength();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getLengthSquared() {
        return ((Number) this.lengthSquared$delegate.getValue()).floatValue();
    }

    public final float getLength() {
        return ((Number) this.length$delegate.getValue()).floatValue();
    }
}
