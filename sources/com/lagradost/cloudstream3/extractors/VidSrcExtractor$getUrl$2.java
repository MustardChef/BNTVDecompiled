package com.lagradost.cloudstream3.extractors;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.M3u8Helper;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VidSrcExtractor.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "server", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.extractors.VidSrcExtractor$getUrl$2", m98f = "VidSrcExtractor.kt", m97i = {}, m96l = {54, 63}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class VidSrcExtractor$getUrl$2 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    final /* synthetic */ String $url;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VidSrcExtractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public VidSrcExtractor$getUrl$2(VidSrcExtractor vidSrcExtractor, Function1<? super ExtractorLink, Unit> function1, String str, Function1<? super SubtitleFile, Unit> function12, Continuation<? super VidSrcExtractor$getUrl$2> continuation) {
        super(2, continuation);
        this.this$0 = vidSrcExtractor;
        this.$callback = function1;
        this.$url = str;
        this.$subtitleCallback = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        VidSrcExtractor$getUrl$2 vidSrcExtractor$getUrl$2 = new VidSrcExtractor$getUrl$2(this.this$0, this.$callback, this.$url, this.$subtitleCallback, continuation);
        vidSrcExtractor$getUrl$2.L$0 = obj;
        return vidSrcExtractor$getUrl$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((VidSrcExtractor$getUrl$2) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        Object obj2;
        MatchResult find$default;
        String value;
        String str2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str3 = (String) this.L$0;
            String replace$default = StringsKt.replace$default(str3, "https://vidsrc.xyz/", "https://embedsito.com/", false, 4, (Object) null);
            if (StringsKt.contains$default((CharSequence) replace$default, (CharSequence) "/pro", false, 2, (Object) null)) {
                str = this.this$0.absoluteUrl;
                this.label = 1;
                obj2 = Requests.get$default(MainActivityKt.getApp(), str3, null, str, null, null, false, 0, null, 0L, null, false, this, 2042, null);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                find$default = Regex.find$default(new Regex("((https:|http:)//.*\\.m3u8)"), ((NiceResponse) obj2).getText(), 0, 2, null);
                if (find$default != null) {
                }
                return Unit.INSTANCE;
            }
            this.label = 2;
            if (ExtractorApiKt.loadExtractor(replace$default, this.$url, this.$subtitleCallback, this.$callback, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
            find$default = Regex.find$default(new Regex("((https:|http:)//.*\\.m3u8)"), ((NiceResponse) obj2).getText(), 0, 2, null);
            if (find$default != null || (value = find$default.getValue()) == null) {
                return Unit.INSTANCE;
            }
            M3u8Helper.Companion companion = M3u8Helper.Companion;
            String name = this.this$0.getName();
            str2 = this.this$0.absoluteUrl;
            Function1<ExtractorLink, Unit> function1 = this.$callback;
            for (Object obj3 : M3u8Helper.Companion.generateM3u8$default(companion, name, value, str2, null, null, null, 56, null)) {
                function1.invoke(obj3);
            }
        } else if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
