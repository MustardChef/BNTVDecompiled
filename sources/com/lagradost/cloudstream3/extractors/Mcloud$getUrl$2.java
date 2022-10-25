package com.lagradost.cloudstream3.extractors;

import com.google.common.net.HttpHeaders;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.M3u8Helper;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Mcloud.kt */
@Metadata(m108d1 = {"\u0000\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0000*\u0001\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "it", "com/lagradost/cloudstream3/extractors/Mcloud$getUrl$SourcesMcloud"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.extractors.Mcloud$getUrl$2", m98f = "Mcloud.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class Mcloud$getUrl$2 extends SuspendLambda implements Function2<Mcloud$getUrl$SourcesMcloud, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<ExtractorLink> $sources;
    final /* synthetic */ String $url;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Mcloud this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Mcloud$getUrl$2(List<ExtractorLink> list, Mcloud mcloud, String str, Continuation<? super Mcloud$getUrl$2> continuation) {
        super(2, continuation);
        this.$sources = list;
        this.this$0 = mcloud;
        this.$url = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Mcloud$getUrl$2 mcloud$getUrl$2 = new Mcloud$getUrl$2(this.$sources, this.this$0, this.$url, continuation);
        mcloud$getUrl$2.L$0 = obj;
        return mcloud$getUrl$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Mcloud$getUrl$SourcesMcloud mcloud$getUrl$SourcesMcloud, Continuation<? super Unit> continuation) {
        return ((Mcloud$getUrl$2) create(mcloud$getUrl$SourcesMcloud, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Mcloud$getUrl$SourcesMcloud mcloud$getUrl$SourcesMcloud = (Mcloud$getUrl$SourcesMcloud) this.L$0;
            if (StringsKt.contains$default((CharSequence) mcloud$getUrl$SourcesMcloud.getFile(), (CharSequence) "m3u8", false, 2, (Object) null)) {
                List<ExtractorLink> list = this.$sources;
                M3u8Helper.Companion companion = M3u8Helper.Companion;
                String name = this.this$0.getName();
                String file = mcloud$getUrl$SourcesMcloud.getFile();
                String str = this.$url;
                list.addAll(M3u8Helper.Companion.generateM3u8$default(companion, name, file, str, null, MapsKt.mapOf(TuplesKt.m100to(HttpHeaders.REFERER, str)), null, 40, null));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
