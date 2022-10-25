package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* renamed from: kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable */
/* loaded from: classes4.dex */
public final class VersionRequirement {
    public static final Companion Companion = new Companion(null);
    private static final VersionRequirement EMPTY = new VersionRequirement(CollectionsKt.emptyList());
    private final List<ProtoBuf.VersionRequirement> infos;

    public /* synthetic */ VersionRequirement(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
    }

    private VersionRequirement(List<ProtoBuf.VersionRequirement> list) {
        this.infos = list;
    }

    /* compiled from: VersionRequirement.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable$Companion */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final VersionRequirement getEMPTY() {
            return VersionRequirement.EMPTY;
        }

        public final VersionRequirement create(ProtoBuf.VersionRequirementTable table) {
            Intrinsics.checkNotNullParameter(table, "table");
            if (table.getRequirementCount() == 0) {
                return getEMPTY();
            }
            List<ProtoBuf.VersionRequirement> requirementList = table.getRequirementList();
            Intrinsics.checkNotNullExpressionValue(requirementList, "table.requirementList");
            return new VersionRequirement(requirementList, null);
        }
    }
}
