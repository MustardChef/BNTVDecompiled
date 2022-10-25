package com.lagradost.cloudstream3.p041ui.result;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: ResultFragmentTV.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$onViewCreated$3 */
/* loaded from: classes4.dex */
/* synthetic */ class ResultFragmentTV$onViewCreated$3 extends FunctionReferenceImpl implements Functions<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ResultFragmentTV$onViewCreated$3(Object obj) {
        super(0, obj, ResultFragmentTV.class, "updateUI", "updateUI()V", 0);
    }

    @Override // kotlin.jvm.functions.Functions
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Functions
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((ResultFragmentTV) this.receiver).updateUI();
    }
}
