package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* compiled from: DeserializationConfiguration.kt */
/* loaded from: classes4.dex */
public interface DeserializationConfiguration {

    /* compiled from: DeserializationConfiguration.kt */
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static boolean getAllowUnstableDependencies(DeserializationConfiguration deserializationConfiguration) {
            return false;
        }

        public static boolean getPreserveDeclarationsOrdering(DeserializationConfiguration deserializationConfiguration) {
            return false;
        }

        public static boolean getReportErrorsOnPreReleaseDependencies(DeserializationConfiguration deserializationConfiguration) {
            return false;
        }

        public static boolean getSkipMetadataVersionCheck(DeserializationConfiguration deserializationConfiguration) {
            return false;
        }

        public static boolean getSkipPrereleaseCheck(DeserializationConfiguration deserializationConfiguration) {
            return false;
        }

        public static boolean getTypeAliasesAllowed(DeserializationConfiguration deserializationConfiguration) {
            return true;
        }
    }

    boolean getAllowUnstableDependencies();

    boolean getPreserveDeclarationsOrdering();

    boolean getReportErrorsOnPreReleaseDependencies();

    boolean getSkipMetadataVersionCheck();

    boolean getSkipPrereleaseCheck();

    boolean getTypeAliasesAllowed();

    /* compiled from: DeserializationConfiguration.kt */
    /* loaded from: classes4.dex */
    public static final class Default implements DeserializationConfiguration {
        public static final Default INSTANCE = new Default();

        private Default() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getAllowUnstableDependencies() {
            return DefaultImpls.getAllowUnstableDependencies(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getPreserveDeclarationsOrdering() {
            return DefaultImpls.getPreserveDeclarationsOrdering(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getReportErrorsOnPreReleaseDependencies() {
            return DefaultImpls.getReportErrorsOnPreReleaseDependencies(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getSkipMetadataVersionCheck() {
            return DefaultImpls.getSkipMetadataVersionCheck(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getSkipPrereleaseCheck() {
            return DefaultImpls.getSkipPrereleaseCheck(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getTypeAliasesAllowed() {
            return DefaultImpls.getTypeAliasesAllowed(this);
        }
    }
}
