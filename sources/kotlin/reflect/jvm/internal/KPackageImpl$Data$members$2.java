package kotlin.reflect.jvm.internal;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KPackageImpl;

/* compiled from: KPackageImpl.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002 \u0003*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
final class KPackageImpl$Data$members$2 extends Lambda implements Functions<Collection<? extends KCallableImpl<?>>> {
    final /* synthetic */ KPackageImpl this$0;
    final /* synthetic */ KPackageImpl.Data this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KPackageImpl$Data$members$2(KPackageImpl kPackageImpl, KPackageImpl.Data data) {
        super(0);
        this.this$0 = kPackageImpl;
        this.this$1 = data;
    }

    @Override // kotlin.jvm.functions.Functions
    public final Collection<? extends KCallableImpl<?>> invoke() {
        return this.this$0.getMembers(this.this$1.getScope(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
    }
}
