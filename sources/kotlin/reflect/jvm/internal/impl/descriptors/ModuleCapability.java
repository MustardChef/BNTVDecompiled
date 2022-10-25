package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModuleCapability.kt */
/* loaded from: classes4.dex */
public final class ModuleCapability<T> {
    private final String name;

    public ModuleCapability(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
