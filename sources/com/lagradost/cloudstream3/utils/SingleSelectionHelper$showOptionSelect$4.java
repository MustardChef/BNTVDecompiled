package com.lagradost.cloudstream3.utils;

import android.view.MenuItem;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: SingleSelectionHelper.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Landroid/view/MenuItem;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
final class SingleSelectionHelper$showOptionSelect$4 extends Lambda implements Function1<MenuItem, Unit> {
    final /* synthetic */ Function1<Tuples<Boolean, Integer>, Unit> $callback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SingleSelectionHelper$showOptionSelect$4(Function1<? super Tuples<Boolean, Integer>, Unit> function1) {
        super(1);
        this.$callback = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MenuItem menuItem) {
        invoke2(menuItem);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(MenuItem popupMenuNoIconsAndNoStringRes) {
        Intrinsics.checkNotNullParameter(popupMenuNoIconsAndNoStringRes, "$this$popupMenuNoIconsAndNoStringRes");
        this.$callback.invoke(new Tuples<>(false, Integer.valueOf(popupMenuNoIconsAndNoStringRes.getItemId())));
    }
}
