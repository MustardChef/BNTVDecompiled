package com.discord.panels;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: OverlappingPanelsLayout.kt */
@Metadata(m109bv = {1, 0, 3}, m106k = 3, m105mv = {1, 1, 16})
/* loaded from: classes.dex */
final /* synthetic */ class OverlappingPanelsLayout$closePanels$1 extends MutablePropertyReference0 {
    OverlappingPanelsLayout$closePanels$1(OverlappingPanelsLayout overlappingPanelsLayout) {
        super(overlappingPanelsLayout);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public String getName() {
        return "centerPanel";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(OverlappingPanelsLayout.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getCenterPanel()Landroid/view/View;";
    }

    @Override // kotlin.reflect.KProperty0
    public Object get() {
        return OverlappingPanelsLayout.access$getCenterPanel$p((OverlappingPanelsLayout) this.receiver);
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        ((OverlappingPanelsLayout) this.receiver).centerPanel = (View) obj;
    }
}
