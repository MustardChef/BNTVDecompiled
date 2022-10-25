package com.lagradost.cloudstream3.extractors;

import com.google.common.net.HttpHeaders;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.M3u8Helper;
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
/* compiled from: Zplayer.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "urlm3u8", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.extractors.ZplayerV2$getUrl$2$2", m98f = "Zplayer.kt", m97i = {0}, m96l = {41}, m95m = "invokeSuspend", m94n = {"urlm3u8"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class ZplayerV2$getUrl$2$2 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<ExtractorLink> $sources;
    final /* synthetic */ String $url;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ZplayerV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplayerV2$getUrl$2$2(String str, ZplayerV2 zplayerV2, List<ExtractorLink> list, Continuation<? super ZplayerV2$getUrl$2$2> continuation) {
        super(2, continuation);
        this.$url = str;
        this.this$0 = zplayerV2;
        this.$sources = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ZplayerV2$getUrl$2$2 zplayerV2$getUrl$2$2 = new ZplayerV2$getUrl$2$2(this.$url, this.this$0, this.$sources, continuation);
        zplayerV2$getUrl$2$2.L$0 = obj;
        return zplayerV2$getUrl$2$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((ZplayerV2$getUrl$2$2) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str2 = (String) this.L$0;
            if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "m3u8", false, 2, (Object) null)) {
                this.L$0 = str2;
                this.label = 1;
                obj2 = Requests.get$default(MainActivityKt.getApp(), str2, MapsKt.mapOf(TuplesKt.m100to(HttpHeaders.REFERER, this.$url)), null, null, null, false, 0, null, 0L, null, false, this, 2044, null);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = str2;
            }
            return Unit.INSTANCE;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
            str = (String) this.L$0;
        }
        if (StringsKt.contains$default((CharSequence) ((NiceResponse) obj2).getText(), (CharSequence) "EXTM3U", false, 2, (Object) null)) {
            M3u8Helper.Companion companion = M3u8Helper.Companion;
            String name = this.this$0.getName();
            String str3 = this.$url;
            List<ExtractorLink> list = this.$sources;
            for (ExtractorLink extractorLink : M3u8Helper.Companion.generateM3u8$default(companion, name, str, str3, null, MapsKt.mapOf(TuplesKt.m100to(HttpHeaders.REFERER, str3)), null, 40, null)) {
                list.add(extractorLink);
            }
        }
        return Unit.INSTANCE;
    }
}
