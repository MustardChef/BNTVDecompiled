package com.discord.panels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OverlappingPanelsLayout.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "", "invoke"}, m106k = 3, m105mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class OverlappingPanelsLayout$openEndPanel$2 extends Lambda implements Functions<Unit> {
    final /* synthetic */ boolean $isFling;
    final /* synthetic */ OverlappingPanelsLayout this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlappingPanelsLayout$openEndPanel$2(OverlappingPanelsLayout overlappingPanelsLayout, boolean z) {
        super(0);
        this.this$0 = overlappingPanelsLayout;
        this.$isFling = z;
    }

    @Override // kotlin.jvm.functions.Functions
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Functions
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.openEndPanel(this.$isFling);
    }
}
