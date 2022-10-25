package androidx.navigation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NavController.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Landroidx/navigation/NavOptionsBuilder;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes.dex */
public final class NavController$handleDeepLink$2 extends Lambda implements Function1<NavOptionsBuilder, Unit> {
    final /* synthetic */ NavDestination $node;
    final /* synthetic */ NavController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavController$handleDeepLink$2(NavDestination navDestination, NavController navController) {
        super(1);
        this.$node = navDestination;
        this.this$0 = navController;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NavController.kt */
    @Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Landroidx/navigation/AnimBuilder;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: androidx.navigation.NavController$handleDeepLink$2$1 */
    /* loaded from: classes.dex */
    public static final class C06161 extends Lambda implements Function1<AnimBuilder, Unit> {
        public static final C06161 INSTANCE = new C06161();

        C06161() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AnimBuilder animBuilder) {
            invoke2(animBuilder);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(AnimBuilder anim) {
            Intrinsics.checkNotNullParameter(anim, "$this$anim");
            anim.setEnter(0);
            anim.setExit(0);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
        invoke2(navOptionsBuilder);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
        if (r0 != false) goto L14;
     */
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void invoke2(androidx.navigation.NavOptionsBuilder r7) {
        /*
            r6 = this;
            java.lang.String r0 = "$this$navOptions"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            androidx.navigation.NavController$handleDeepLink$2$1 r0 = androidx.navigation.NavController$handleDeepLink$2.C06161.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r7.anim(r0)
            androidx.navigation.NavDestination r0 = r6.$node
            boolean r0 = r0 instanceof androidx.navigation.NavGraph
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L46
            androidx.navigation.NavDestination$Companion r0 = androidx.navigation.NavDestination.Companion
            androidx.navigation.NavDestination r3 = r6.$node
            kotlin.sequences.Sequence r0 = r0.getHierarchy(r3)
            androidx.navigation.NavController r3 = r6.this$0
            java.util.Iterator r0 = r0.iterator()
        L22:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L42
            java.lang.Object r4 = r0.next()
            androidx.navigation.NavDestination r4 = (androidx.navigation.NavDestination) r4
            androidx.navigation.NavDestination r5 = r3.getCurrentDestination()
            if (r5 == 0) goto L39
            androidx.navigation.NavGraph r5 = r5.getParent()
            goto L3a
        L39:
            r5 = 0
        L3a:
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
            if (r4 == 0) goto L22
            r0 = 0
            goto L43
        L42:
            r0 = 1
        L43:
            if (r0 == 0) goto L46
            goto L47
        L46:
            r1 = 0
        L47:
            if (r1 == 0) goto L66
            boolean r0 = androidx.navigation.NavController.access$getDeepLinkSaveState$cp()
            if (r0 == 0) goto L66
            androidx.navigation.NavGraph$Companion r0 = androidx.navigation.NavGraph.Companion
            androidx.navigation.NavController r1 = r6.this$0
            androidx.navigation.NavGraph r1 = r1.getGraph()
            androidx.navigation.NavDestination r0 = r0.findStartDestination(r1)
            int r0 = r0.getId()
            androidx.navigation.NavController$handleDeepLink$2$2 r1 = androidx.navigation.NavController$handleDeepLink$2.C06172.INSTANCE
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r7.popUpTo(r0, r1)
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController$handleDeepLink$2.invoke2(androidx.navigation.NavOptionsBuilder):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NavController.kt */
    @Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Landroidx/navigation/PopUpToBuilder;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: androidx.navigation.NavController$handleDeepLink$2$2 */
    /* loaded from: classes.dex */
    public static final class C06172 extends Lambda implements Function1<PopUpToBuilder, Unit> {
        public static final C06172 INSTANCE = new C06172();

        C06172() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PopUpToBuilder popUpToBuilder) {
            invoke2(popUpToBuilder);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(PopUpToBuilder popUpTo) {
            Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
            popUpTo.setSaveState(true);
        }
    }
}
