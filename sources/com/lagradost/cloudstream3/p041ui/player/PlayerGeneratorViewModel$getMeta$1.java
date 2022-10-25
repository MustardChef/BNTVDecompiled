package com.lagradost.cloudstream3.p041ui.player;

import com.lagradost.cloudstream3.p041ui.player.IGenerator;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PlayerGeneratorViewModel.kt */
@Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.PlayerGeneratorViewModel$getMeta$1 */
/* loaded from: classes3.dex */
public final class PlayerGeneratorViewModel$getMeta$1 extends Lambda implements Functions<Object> {
    final /* synthetic */ PlayerGeneratorViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerGeneratorViewModel$getMeta$1(PlayerGeneratorViewModel playerGeneratorViewModel) {
        super(0);
        this.this$0 = playerGeneratorViewModel;
    }

    @Override // kotlin.jvm.functions.Functions
    public final Object invoke() {
        IGenerator iGenerator;
        iGenerator = this.this$0.generator;
        if (iGenerator != null) {
            return IGenerator.DefaultImpls.getCurrent$default(iGenerator, 0, 1, null);
        }
        return null;
    }
}
