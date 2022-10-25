package com.lagradost.cloudstream3.p041ui.browser;

import androidx.lifecycle.MutableLiveData;
import com.lagradost.cloudstream3.mvvm.Resource;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubtitleBrowserViewModel.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.browser.SubtitleBrowserViewModel$downloadSubtitle$1", m98f = "SubtitleBrowserViewModel.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.browser.SubtitleBrowserViewModel$downloadSubtitle$1 */
/* loaded from: classes.dex */
public final class SubtitleBrowserViewModel$downloadSubtitle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fileDir;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ SubtitleBrowserViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubtitleBrowserViewModel$downloadSubtitle$1(SubtitleBrowserViewModel subtitleBrowserViewModel, String str, String str2, Continuation<? super SubtitleBrowserViewModel$downloadSubtitle$1> continuation) {
        super(2, continuation);
        this.this$0 = subtitleBrowserViewModel;
        this.$url = str;
        this.$fileDir = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubtitleBrowserViewModel$downloadSubtitle$1(this.this$0, this.$url, this.$fileDir, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SubtitleBrowserViewModel$downloadSubtitle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableLiveData mutableLiveData;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            mutableLiveData = this.this$0._resultResponse;
            mutableLiveData.postValue(new Resource.Loading(this.$url));
            SubtitleBrowserRepository repo = this.this$0.getRepo();
            if (repo != null) {
                repo.downloadSubtitle(this.$url, this.$fileDir, new C48401(this.this$0));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SubtitleBrowserViewModel.kt */
    @Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", "it", "", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.browser.SubtitleBrowserViewModel$downloadSubtitle$1$1 */
    /* loaded from: classes.dex */
    public static final class C48401 extends Lambda implements Function1<List<? extends String>, Unit> {
        final /* synthetic */ SubtitleBrowserViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C48401(SubtitleBrowserViewModel subtitleBrowserViewModel) {
            super(1);
            this.this$0 = subtitleBrowserViewModel;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
            invoke2((List<String>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(List<String> it) {
            MutableLiveData mutableLiveData;
            Intrinsics.checkNotNullParameter(it, "it");
            mutableLiveData = this.this$0._resultResponse;
            mutableLiveData.postValue(new Resource.Success(it));
        }
    }
}
