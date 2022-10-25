package com.lagradost.cloudstream3.p041ui.home;

import com.lagradost.cloudstream3.PageResponse;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.p041ui.APIRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PageViewModel.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.home.PageViewModel$getPage$1$1$1", m98f = "PageViewModel.kt", m97i = {}, m96l = {61}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.home.PageViewModel$getPage$1$1$1 */
/* loaded from: classes3.dex */
final class PageViewModel$getPage$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Resource<PageResponse>> $response;
    final /* synthetic */ String $url;
    Object L$0;
    int label;
    final /* synthetic */ PageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageViewModel$getPage$1$1$1(Ref.ObjectRef<Resource<PageResponse>> objectRef, PageViewModel pageViewModel, String str, Continuation<? super PageViewModel$getPage$1$1$1> continuation) {
        super(2, continuation);
        this.$response = objectRef;
        this.this$0 = pageViewModel;
        this.$url = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageViewModel$getPage$1$1$1(this.$response, this.this$0, this.$url, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PageViewModel$getPage$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Ref.ObjectRef<Resource<PageResponse>> objectRef;
        T t;
        Ref.ObjectRef<Resource<PageResponse>> objectRef2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            objectRef = this.$response;
            APIRepository repos = this.this$0.getRepos();
            if (repos == null) {
                t = 0;
                objectRef.element = t;
                return Unit.INSTANCE;
            }
            this.L$0 = objectRef;
            this.label = 1;
            Object loadPage = repos.loadPage(this.$url, this);
            if (loadPage == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef2 = objectRef;
            obj = loadPage;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            objectRef2 = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Ref.ObjectRef<Resource<PageResponse>> objectRef3 = objectRef2;
        t = (Resource) obj;
        objectRef = objectRef3;
        objectRef.element = t;
        return Unit.INSTANCE;
    }
}
