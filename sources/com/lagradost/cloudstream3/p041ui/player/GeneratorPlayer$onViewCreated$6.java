package com.lagradost.cloudstream3.p041ui.player;

import android.app.Activity;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.mvvm.Resource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: GeneratorPlayer.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", "it", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.GeneratorPlayer$onViewCreated$6 */
/* loaded from: classes3.dex */
final class GeneratorPlayer$onViewCreated$6 extends Lambda implements Function1<Resource<? extends Boolean>, Unit> {
    final /* synthetic */ GeneratorPlayer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GeneratorPlayer$onViewCreated$6(GeneratorPlayer generatorPlayer) {
        super(1);
        this.this$0 = generatorPlayer;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends Boolean> resource) {
        invoke2((Resource<Boolean>) resource);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Resource<Boolean> it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it instanceof Resource.Loading) {
            this.this$0.startLoading();
        } else if (it instanceof Resource.Success) {
            this.this$0.startPlayer();
        } else if (it instanceof Resource.Failure) {
            CommonActivity.INSTANCE.showToast((Activity) this.this$0.getActivity(), ((Resource.Failure) it).getErrorString(), (Integer) 1);
            this.this$0.startPlayer();
        }
    }
}
