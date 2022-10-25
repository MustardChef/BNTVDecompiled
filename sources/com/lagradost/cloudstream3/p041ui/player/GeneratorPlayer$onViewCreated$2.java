package com.lagradost.cloudstream3.p041ui.player;

import android.util.Log;
import com.lagradost.cloudstream3.mvvm.Resource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: GeneratorPlayer.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", "it", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.GeneratorPlayer$onViewCreated$2 */
/* loaded from: classes3.dex */
final class GeneratorPlayer$onViewCreated$2 extends Lambda implements Function1<Resource<? extends Object>, Unit> {
    public static final GeneratorPlayer$onViewCreated$2 INSTANCE = new GeneratorPlayer$onViewCreated$2();

    GeneratorPlayer$onViewCreated$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends Object> resource) {
        invoke2(resource);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Resource<? extends Object> it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Log.d("BLUE -->", String.valueOf(it));
    }
}
