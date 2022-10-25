package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds */
/* loaded from: classes4.dex */
public final class CapturedTypeApproximation<T> {
    private final T lower;
    private final T upper;

    public final T component1() {
        return this.lower;
    }

    public final T component2() {
        return this.upper;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CapturedTypeApproximation) {
            CapturedTypeApproximation capturedTypeApproximation = (CapturedTypeApproximation) obj;
            return Intrinsics.areEqual(this.lower, capturedTypeApproximation.lower) && Intrinsics.areEqual(this.upper, capturedTypeApproximation.upper);
        }
        return false;
    }

    public int hashCode() {
        T t = this.lower;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.upper;
        return hashCode + (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "ApproximationBounds(lower=" + this.lower + ", upper=" + this.upper + ')';
    }

    public CapturedTypeApproximation(T t, T t2) {
        this.lower = t;
        this.upper = t2;
    }

    public final T getLower() {
        return this.lower;
    }

    public final T getUpper() {
        return this.upper;
    }
}
