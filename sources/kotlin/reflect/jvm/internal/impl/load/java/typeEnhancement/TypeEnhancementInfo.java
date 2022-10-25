package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: predefinedEnhancementInfo.kt */
/* loaded from: classes4.dex */
public final class TypeEnhancementInfo {
    private final Map<Integer, typeQualifiers> map;

    public TypeEnhancementInfo(Map<Integer, typeQualifiers> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.map = map;
    }

    public final Map<Integer, typeQualifiers> getMap() {
        return this.map;
    }
}
