package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KClassImpl.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class KClassImpl$Data$simpleName$2 extends Lambda implements Functions<String> {
    final /* synthetic */ KClassImpl<T> this$0;
    final /* synthetic */ KClassImpl<T>.Data this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KClassImpl$Data$simpleName$2(KClassImpl<T> kClassImpl, KClassImpl<T>.Data data) {
        super(0);
        this.this$0 = kClassImpl;
        this.this$1 = data;
    }

    @Override // kotlin.jvm.functions.Functions
    public final String invoke() {
        ClassId classId;
        String calculateLocalClassName;
        if (this.this$0.getJClass().isAnonymousClass()) {
            return null;
        }
        classId = this.this$0.getClassId();
        if (classId.isLocal()) {
            calculateLocalClassName = this.this$1.calculateLocalClassName(this.this$0.getJClass());
            return calculateLocalClassName;
        }
        String asString = classId.getShortClassName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "classId.shortClassName.asString()");
        return asString;
    }
}
