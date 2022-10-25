package kotlin.reflect.jvm.internal;

import com.fasterxml.jackson.core.JsonPointer;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KPackageImpl.kt */
@Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "Ljava/lang/Class;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class KPackageImpl$Data$multifileFacade$2 extends Lambda implements Functions<Class<?>> {
    final /* synthetic */ KPackageImpl.Data this$0;
    final /* synthetic */ KPackageImpl this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KPackageImpl$Data$multifileFacade$2(KPackageImpl.Data data, KPackageImpl kPackageImpl) {
        super(0);
        this.this$0 = data;
        this.this$1 = kPackageImpl;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Functions
    public final Class<?> invoke() {
        ReflectKotlinClass kotlinClass;
        KotlinClassHeader classHeader;
        kotlinClass = this.this$0.getKotlinClass();
        String multifileClassName = (kotlinClass == null || (classHeader = kotlinClass.getClassHeader()) == null) ? null : classHeader.getMultifileClassName();
        if (multifileClassName != null) {
            if (multifileClassName.length() > 0) {
                return this.this$1.getJClass().getClassLoader().loadClass(StringsKt.replace$default(multifileClassName, (char) JsonPointer.SEPARATOR, '.', false, 4, (Object) null));
            }
            return null;
        }
        return null;
    }
}
