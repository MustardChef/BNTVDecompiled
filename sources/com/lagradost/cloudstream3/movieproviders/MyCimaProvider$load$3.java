package com.lagradost.cloudstream3.movieproviders;

import com.facebook.share.internal.ShareConstants;
import com.lagradost.cloudstream3.Episode;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jsoup.nodes.Element;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MyCimaProvider.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "kotlin.jvm.PlatformType"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.MyCimaProvider$load$3", m98f = "MyCimaProvider.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class MyCimaProvider$load$3 extends SuspendLambda implements Function2<Element, Continuation<? super Boolean>, Object> {
    final /* synthetic */ ArrayList<Episode> $episodes;
    final /* synthetic */ Integer $season;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MyCimaProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyCimaProvider$load$3(ArrayList<Episode> arrayList, Integer num, MyCimaProvider myCimaProvider, Continuation<? super MyCimaProvider$load$3> continuation) {
        super(2, continuation);
        this.$episodes = arrayList;
        this.$season = num;
        this.this$0 = myCimaProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MyCimaProvider$load$3 myCimaProvider$load$3 = new MyCimaProvider$load$3(this.$episodes, this.$season, this.this$0, continuation);
        myCimaProvider$load$3.L$0 = obj;
        return myCimaProvider$load$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Element element, Continuation<? super Boolean> continuation) {
        return ((MyCimaProvider$load$3) create(element, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Integer intFromText;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Element element = (Element) this.L$0;
            ArrayList<Episode> arrayList = this.$episodes;
            String attr = element.attr(ShareConstants.WEB_DIALOG_PARAM_HREF);
            Intrinsics.checkNotNullExpressionValue(attr, "it.attr(\"href\")");
            String text = element.text();
            Integer num = this.$season;
            MyCimaProvider myCimaProvider = this.this$0;
            String text2 = element.text();
            Intrinsics.checkNotNullExpressionValue(text2, "it.text()");
            intFromText = myCimaProvider.getIntFromText(text2);
            return boxing.boxBoolean(arrayList.add(new Episode(attr, text, num, intFromText, null, null, null, null, 240, null)));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
