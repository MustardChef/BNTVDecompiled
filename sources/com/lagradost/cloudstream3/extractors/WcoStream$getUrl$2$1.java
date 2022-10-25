package com.lagradost.cloudstream3.extractors;

import com.google.common.net.HttpHeaders;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
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
/* compiled from: WcoStream.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "serverurl", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.extractors.WcoStream$getUrl$2$1", m98f = "WcoStream.kt", m97i = {0}, m96l = {162}, m95m = "invokeSuspend", m94n = {"serverurl"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class WcoStream$getUrl$2$1 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<ExtractorLink> $sources;
    final /* synthetic */ String $url;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WcoStream$getUrl$2$1(String str, List<ExtractorLink> list, Continuation<? super WcoStream$getUrl$2$1> continuation) {
        super(2, continuation);
        this.$url = str;
        this.$sources = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WcoStream$getUrl$2$1 wcoStream$getUrl$2$1 = new WcoStream$getUrl$2$1(this.$url, this.$sources, continuation);
        wcoStream$getUrl$2$1.L$0 = obj;
        return wcoStream$getUrl$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((WcoStream$getUrl$2$1) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        String str;
        String str2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str3 = (String) this.L$0;
            this.L$0 = str3;
            this.label = 1;
            obj2 = Requests.get$default(MainActivityKt.getApp(), str3, MapsKt.mapOf(TuplesKt.m100to(HttpHeaders.REFERER, this.$url)), null, null, null, false, 0, null, 0L, null, false, this, 2044, null);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = str3;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
            str = (String) this.L$0;
        }
        if (StringsKt.contains$default((CharSequence) ((NiceResponse) obj2).getText(), (CharSequence) "EXTM3", false, 2, (Object) null)) {
            String str4 = str;
            if (StringsKt.contains$default((CharSequence) str4, (CharSequence) "H4", false, 2, (Object) null)) {
                str2 = "1080p";
            } else if (StringsKt.contains$default((CharSequence) str4, (CharSequence) "H3", false, 2, (Object) null)) {
                str2 = "720p";
            } else if (StringsKt.contains$default((CharSequence) str4, (CharSequence) "H2", false, 2, (Object) null)) {
                str2 = "480p";
            } else {
                str2 = StringsKt.contains$default((CharSequence) str4, (CharSequence) "H1", false, 2, (Object) null) ? "360p" : "Auto";
            }
            this.$sources.add(new ExtractorLink("VidStream", "VidStream", str, this.$url, ExtractorApiKt.getQualityFromName(str2), true, null, null, 192, null));
        }
        return Unit.INSTANCE;
    }
}
