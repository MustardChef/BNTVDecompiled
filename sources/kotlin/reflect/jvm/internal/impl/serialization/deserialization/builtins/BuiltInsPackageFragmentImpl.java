package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import com.facebook.internal.ServerProtocol;
import java.io.InputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p043io.Closeable;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: BuiltInsPackageFragmentImpl.kt */
/* loaded from: classes4.dex */
public final class BuiltInsPackageFragmentImpl extends DeserializedPackageFragmentImpl implements BuiltInsPackageFragment {
    public static final Companion Companion = new Companion(null);
    private final boolean isFallback;

    public /* synthetic */ BuiltInsPackageFragmentImpl(FqName fqName, StorageManager storageManager, ModuleDescriptor moduleDescriptor, ProtoBuf.PackageFragment packageFragment, BuiltInsBinaryVersion builtInsBinaryVersion, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(fqName, storageManager, moduleDescriptor, packageFragment, builtInsBinaryVersion, z);
    }

    private BuiltInsPackageFragmentImpl(FqName fqName, StorageManager storageManager, ModuleDescriptor moduleDescriptor, ProtoBuf.PackageFragment packageFragment, BuiltInsBinaryVersion builtInsBinaryVersion, boolean z) {
        super(fqName, storageManager, moduleDescriptor, packageFragment, builtInsBinaryVersion, null);
        this.isFallback = z;
    }

    /* compiled from: BuiltInsPackageFragmentImpl.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BuiltInsPackageFragmentImpl create(FqName fqName, StorageManager storageManager, ModuleDescriptor module, InputStream inputStream, boolean z) {
            BuiltInsBinaryVersion builtInsBinaryVersion;
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            Intrinsics.checkNotNullParameter(storageManager, "storageManager");
            Intrinsics.checkNotNullParameter(module, "module");
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            InputStream inputStream2 = inputStream;
            try {
                InputStream inputStream3 = inputStream2;
                BuiltInsBinaryVersion readFrom = BuiltInsBinaryVersion.Companion.readFrom(inputStream3);
                if (readFrom == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
                    builtInsBinaryVersion = null;
                } else {
                    builtInsBinaryVersion = readFrom;
                }
                if (!builtInsBinaryVersion.isCompatible()) {
                    throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + BuiltInsBinaryVersion.INSTANCE + ", actual " + readFrom + ". Please update Kotlin");
                }
                ProtoBuf.PackageFragment proto = ProtoBuf.PackageFragment.parseFrom(inputStream3, BuiltInSerializerProtocol.INSTANCE.getExtensionRegistry());
                Closeable.closeFinally(inputStream2, null);
                Intrinsics.checkNotNullExpressionValue(proto, "proto");
                return new BuiltInsPackageFragmentImpl(fqName, storageManager, module, proto, readFrom, z, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    Closeable.closeFinally(inputStream2, th);
                    throw th2;
                }
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public String toString() {
        return "builtins package fragment for " + getFqName() + " from " + DescriptorUtils.getModule(this);
    }
}
