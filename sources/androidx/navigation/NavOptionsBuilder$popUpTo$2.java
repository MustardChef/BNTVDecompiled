package androidx.navigation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: NavOptionsBuilder.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Landroidx/navigation/PopUpToBuilder;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes.dex */
final class NavOptionsBuilder$popUpTo$2 extends Lambda implements Function1<PopUpToBuilder, Unit> {
    public static final NavOptionsBuilder$popUpTo$2 INSTANCE = new NavOptionsBuilder$popUpTo$2();

    NavOptionsBuilder$popUpTo$2() {
        super(1);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(PopUpToBuilder popUpToBuilder) {
        Intrinsics.checkNotNullParameter(popUpToBuilder, "$this$null");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PopUpToBuilder popUpToBuilder) {
        invoke2(popUpToBuilder);
        return Unit.INSTANCE;
    }
}
