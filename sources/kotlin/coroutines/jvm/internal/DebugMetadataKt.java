package kotlin.coroutines.jvm.internal;

import com.fasterxml.jackson.core.JsonPointer;
import com.google.firebase.messaging.Constants;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugMetadata.kt */
@Metadata(m108d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\bH\u0002\u001a\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b*\u00020\bH\u0001¢\u0006\u0002\u0010\r\u001a\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\bH\u0001¢\u0006\u0002\b\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m107d2 = {"COROUTINES_DEBUG_METADATA_VERSION", "", "checkDebugMetadataVersion", "", "expected", "actual", "getDebugMetadataAnnotation", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getLabel", "getSpilledVariableFieldMapping", "", "", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "getStackTraceElementImpl", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "kotlin-stdlib"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class DebugMetadataKt {
    private static final int COROUTINES_DEBUG_METADATA_VERSION = 1;

    public static final StackTraceElement getStackTraceElement(BaseContinuationImpl baseContinuationImpl) {
        String str;
        Intrinsics.checkNotNullParameter(baseContinuationImpl, "<this>");
        DebugMetadata debugMetadataAnnotation = getDebugMetadataAnnotation(baseContinuationImpl);
        if (debugMetadataAnnotation == null) {
            return null;
        }
        checkDebugMetadataVersion(1, debugMetadataAnnotation.m92v());
        int label = getLabel(baseContinuationImpl);
        int i = label < 0 ? -1 : debugMetadataAnnotation.m96l()[label];
        String moduleName = ModuleNameRetriever.INSTANCE.getModuleName(baseContinuationImpl);
        if (moduleName == null) {
            str = debugMetadataAnnotation.m99c();
        } else {
            str = moduleName + JsonPointer.SEPARATOR + debugMetadataAnnotation.m99c();
        }
        return new StackTraceElement(str, debugMetadataAnnotation.m95m(), debugMetadataAnnotation.m98f(), i);
    }

    private static final DebugMetadata getDebugMetadataAnnotation(BaseContinuationImpl baseContinuationImpl) {
        return (DebugMetadata) baseContinuationImpl.getClass().getAnnotation(DebugMetadata.class);
    }

    private static final int getLabel(BaseContinuationImpl baseContinuationImpl) {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField(Constants.ScionAnalytics.PARAM_LABEL);
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    private static final void checkDebugMetadataVersion(int i, int i2) {
        if (i2 <= i) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i + ", got " + i2 + ". Please update the Kotlin standard library.").toString());
    }

    public static final String[] getSpilledVariableFieldMapping(BaseContinuationImpl baseContinuationImpl) {
        Intrinsics.checkNotNullParameter(baseContinuationImpl, "<this>");
        DebugMetadata debugMetadataAnnotation = getDebugMetadataAnnotation(baseContinuationImpl);
        if (debugMetadataAnnotation == null) {
            return null;
        }
        checkDebugMetadataVersion(1, debugMetadataAnnotation.m92v());
        ArrayList arrayList = new ArrayList();
        int label = getLabel(baseContinuationImpl);
        int[] m97i = debugMetadataAnnotation.m97i();
        int length = m97i.length;
        for (int i = 0; i < length; i++) {
            if (m97i[i] == label) {
                arrayList.add(debugMetadataAnnotation.m93s()[i]);
                arrayList.add(debugMetadataAnnotation.m94n()[i]);
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }
}
