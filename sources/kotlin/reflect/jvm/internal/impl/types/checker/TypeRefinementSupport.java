package kotlin.reflect.jvm.internal.impl.types.checker;

/* compiled from: KotlinTypeRefiner.kt */
/* loaded from: classes4.dex */
public abstract class TypeRefinementSupport {
    private final boolean isEnabled;

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    /* compiled from: KotlinTypeRefiner.kt */
    /* loaded from: classes4.dex */
    public static final class Enabled extends TypeRefinementSupport {
        private final KotlinTypeRefiner typeRefiner;

        public final KotlinTypeRefiner getTypeRefiner() {
            return this.typeRefiner;
        }
    }
}
