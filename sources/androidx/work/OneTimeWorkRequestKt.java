package androidx.work;

import androidx.exifinterface.media.ExifInterface;
import androidx.work.OneTimeWorkRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMapping;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: OneTimeWorkRequest.kt */
@Metadata(m108d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\u0086\b\u001a\u001f\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0010\b\u0001\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0086\b¨\u0006\b"}, m107d2 = {"OneTimeWorkRequestBuilder", "Landroidx/work/OneTimeWorkRequest$Builder;", ExifInterface.LONGITUDE_WEST, "Landroidx/work/ListenableWorker;", "setInputMerger", "inputMerger", "Lkotlin/reflect/KClass;", "Landroidx/work/InputMerger;", "work-runtime-ktx_release"}, m106k = 2, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class OneTimeWorkRequestKt {
    public static final OneTimeWorkRequest.Builder setInputMerger(OneTimeWorkRequest.Builder builder, KClass<? extends InputMerger> inputMerger) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(inputMerger, "inputMerger");
        OneTimeWorkRequest.Builder inputMerger2 = builder.setInputMerger(JvmClassMapping.getJavaClass((KClass) inputMerger));
        Intrinsics.checkNotNullExpressionValue(inputMerger2, "setInputMerger(inputMerger.java)");
        return inputMerger2;
    }
}
