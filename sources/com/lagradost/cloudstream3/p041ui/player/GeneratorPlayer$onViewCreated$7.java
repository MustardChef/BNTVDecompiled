package com.lagradost.cloudstream3.p041ui.player;

import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorUri;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: GeneratorPlayer.kt */
@Metadata(m108d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003H\n¢\u0006\u0002\b\u0007"}, m107d2 = {"<anonymous>", "", "it", "", "Lkotlin/Pair;", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "Lcom/lagradost/cloudstream3/utils/ExtractorUri;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.GeneratorPlayer$onViewCreated$7 */
/* loaded from: classes3.dex */
final class GeneratorPlayer$onViewCreated$7 extends Lambda implements Function1<Set<? extends Tuples<? extends ExtractorLink, ? extends ExtractorUri>>, Unit> {
    final /* synthetic */ GeneratorPlayer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GeneratorPlayer$onViewCreated$7(GeneratorPlayer generatorPlayer) {
        super(1);
        this.this$0 = generatorPlayer;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Tuples<? extends ExtractorLink, ? extends ExtractorUri>> set) {
        invoke2((Set<? extends Tuples<? extends ExtractorLink, ExtractorUri>>) set);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002c, code lost:
        if ((r1.getVisibility() == 8) == true) goto L7;
     */
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void invoke2(java.util.Set<? extends kotlin.Tuples<? extends com.lagradost.cloudstream3.utils.ExtractorLink, com.lagradost.cloudstream3.utils.ExtractorUri>> r6) {
        /*
            r5 = this;
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            com.lagradost.cloudstream3.ui.player.GeneratorPlayer r0 = r5.this$0
            com.lagradost.cloudstream3.p041ui.player.GeneratorPlayer.access$setCurrentLinks$p(r0, r6)
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            r0 = 1
            r6 = r6 ^ r0
            com.lagradost.cloudstream3.ui.player.GeneratorPlayer r1 = r5.this$0
            int r2 = com.lagradost.cloudstream3.C4761R.C4764id.overlay_loading_skip_button
            android.view.View r1 = r1._$_findCachedViewById(r2)
            com.google.android.material.button.MaterialButton r1 = (com.google.android.material.button.MaterialButton) r1
            r2 = 8
            r3 = 0
            if (r1 == 0) goto L2f
            android.view.View r1 = (android.view.View) r1
            int r1 = r1.getVisibility()
            if (r1 != r2) goto L2b
            r1 = 1
            goto L2c
        L2b:
            r1 = 0
        L2c:
            if (r1 != r0) goto L2f
            goto L30
        L2f:
            r0 = 0
        L30:
            com.lagradost.cloudstream3.ui.player.GeneratorPlayer r1 = r5.this$0
            int r4 = com.lagradost.cloudstream3.C4761R.C4764id.overlay_loading_skip_button
            android.view.View r1 = r1._$_findCachedViewById(r4)
            com.google.android.material.button.MaterialButton r1 = (com.google.android.material.button.MaterialButton) r1
            if (r1 != 0) goto L3d
            goto L45
        L3d:
            android.view.View r1 = (android.view.View) r1
            if (r6 == 0) goto L42
            r2 = 0
        L42:
            r1.setVisibility(r2)
        L45:
            if (r6 == 0) goto L58
            if (r0 == 0) goto L58
            com.lagradost.cloudstream3.ui.player.GeneratorPlayer r6 = r5.this$0
            int r0 = com.lagradost.cloudstream3.C4761R.C4764id.overlay_loading_skip_button
            android.view.View r6 = r6._$_findCachedViewById(r0)
            com.google.android.material.button.MaterialButton r6 = (com.google.android.material.button.MaterialButton) r6
            if (r6 == 0) goto L58
            r6.requestFocus()
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.player.GeneratorPlayer$onViewCreated$7.invoke2(java.util.Set):void");
    }
}
