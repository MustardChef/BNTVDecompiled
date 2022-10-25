package com.lagradost.cloudstream3.p041ui.player;

import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PlayerGeneratorViewModel.kt */
@Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.PlayerGeneratorViewModel$getNextMeta$1 */
/* loaded from: classes3.dex */
public final class PlayerGeneratorViewModel$getNextMeta$1 extends Lambda implements Functions<Object> {
    final /* synthetic */ PlayerGeneratorViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerGeneratorViewModel$getNextMeta$1(PlayerGeneratorViewModel playerGeneratorViewModel) {
        super(0);
        this.this$0 = playerGeneratorViewModel;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
        r2 = r3.this$0.generator;
     */
    @Override // kotlin.jvm.functions.Functions
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invoke() {
        /*
            r3 = this;
            com.lagradost.cloudstream3.ui.player.PlayerGeneratorViewModel r0 = r3.this$0
            com.lagradost.cloudstream3.ui.player.IGenerator r0 = com.lagradost.cloudstream3.p041ui.player.PlayerGeneratorViewModel.access$getGenerator$p(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L11
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto L11
            r2 = 1
        L11:
            r0 = 0
            if (r2 == 0) goto L15
            return r0
        L15:
            com.lagradost.cloudstream3.ui.player.PlayerGeneratorViewModel r2 = r3.this$0
            com.lagradost.cloudstream3.ui.player.IGenerator r2 = com.lagradost.cloudstream3.p041ui.player.PlayerGeneratorViewModel.access$getGenerator$p(r2)
            if (r2 == 0) goto L21
            java.lang.Object r0 = r2.getCurrent(r1)
        L21:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.player.PlayerGeneratorViewModel$getNextMeta$1.invoke():java.lang.Object");
    }
}
