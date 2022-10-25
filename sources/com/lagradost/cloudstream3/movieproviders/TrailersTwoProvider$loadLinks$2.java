package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.SubtitleHelper;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: TrailersTwoProvider.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.TrailersTwoProvider$loadLinks$2", m98f = "TrailersTwoProvider.kt", m97i = {}, m96l = {168}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
final class TrailersTwoProvider$loadLinks$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    final /* synthetic */ String $subtitleUrl;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TrailersTwoProvider$loadLinks$2(String str, Function1<? super SubtitleFile, Unit> function1, Continuation<? super TrailersTwoProvider$loadLinks$2> continuation) {
        super(1, continuation);
        this.$subtitleUrl = str;
        this.$subtitleCallback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TrailersTwoProvider$loadLinks$2(this.$subtitleUrl, this.$subtitleCallback, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TrailersTwoProvider$loadLinks$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj2 = Requests.get$default(MainActivityKt.getApp(), this.$subtitleUrl, null, null, null, null, false, 0, null, 0L, null, false, this, 2046, null);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        }
        String text = ((NiceResponse) obj2).getText();
        AppUtils appUtils = AppUtils.INSTANCE;
        Function1<SubtitleFile, Unit> function1 = this.$subtitleCallback;
        for (TrailersSubtitleFile trailersSubtitleFile : (List) MainAPIKt.getMapper().readValue(text, new TypeReference<List<? extends TrailersSubtitleFile>>() { // from class: com.lagradost.cloudstream3.movieproviders.TrailersTwoProvider$loadLinks$2$invokeSuspend$$inlined$parseJson$1
        })) {
            SubtitleHelper subtitleHelper = SubtitleHelper.INSTANCE;
            String languageCode = trailersSubtitleFile.getLanguageCode();
            if (languageCode == null) {
                languageCode = "en";
            }
            String fromTwoLettersToLanguage = subtitleHelper.fromTwoLettersToLanguage(languageCode);
            if (fromTwoLettersToLanguage == null) {
                fromTwoLettersToLanguage = "English";
            }
            String str = fromTwoLettersToLanguage;
            StringBuilder sb = new StringBuilder();
            sb.append("https://trailers.to/subtitles/");
            String contentHash = trailersSubtitleFile.getContentHash();
            if (contentHash != null) {
                sb.append(contentHash);
                sb.append(JsonPointer.SEPARATOR);
                String languageCode2 = trailersSubtitleFile.getLanguageCode();
                if (languageCode2 != null) {
                    sb.append(languageCode2);
                    sb.append(".vtt");
                    function1.invoke(new SubtitleFile(str, sb.toString(), null, 4, null));
                }
            }
        }
        return Unit.INSTANCE;
    }
}
