package com.lagradost.cloudstream3.p041ui.result;

import com.lagradost.cloudstream3.p041ui.result.ActorAdaptor;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: ActorAdaptor.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ActorAdaptor$onBindViewHolder$1 */
/* loaded from: classes4.dex */
final class ActorAdaptor$onBindViewHolder$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ int $position;
    final /* synthetic */ ActorAdaptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActorAdaptor$onBindViewHolder$1(ActorAdaptor actorAdaptor, int i) {
        super(1);
        this.this$0 = actorAdaptor;
        this.$position = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        List list;
        List list2;
        list = this.this$0.actors;
        list2 = this.this$0.actors;
        ((ActorAdaptor.ActorMetaData) list.get(this.$position)).setInverted(!((ActorAdaptor.ActorMetaData) list2.get(this.$position)).isInverted());
        this.this$0.notifyItemChanged(this.$position);
    }
}
