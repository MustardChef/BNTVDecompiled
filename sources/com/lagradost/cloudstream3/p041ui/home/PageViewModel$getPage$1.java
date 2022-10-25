package com.lagradost.cloudstream3.p041ui.home;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.p041ui.APIRepository;
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
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okhttp3.internal.http.HttpStatusCodes;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PageViewModel.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.home.PageViewModel$getPage$1", m98f = "PageViewModel.kt", m97i = {0}, m96l = {60}, m95m = "invokeSuspend", m94n = {"response"}, m93s = {"L$1"})
/* renamed from: com.lagradost.cloudstream3.ui.home.PageViewModel$getPage$1 */
/* loaded from: classes3.dex */
public final class PageViewModel$getPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $name;
    final /* synthetic */ String $url;
    final /* synthetic */ String $urlApi;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ PageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageViewModel$getPage$1(String str, String str2, String str3, PageViewModel pageViewModel, Continuation<? super PageViewModel$getPage$1> continuation) {
        super(2, continuation);
        this.$url = str;
        this.$name = str2;
        this.$urlApi = str3;
        this.this$0 = pageViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageViewModel$getPage$1(this.$url, this.$name, this.$urlApi, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PageViewModel$getPage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MainAPI apiFromNameNull;
        PageViewModel pageViewModel;
        MutableLiveData mutableLiveData;
        Ref.ObjectRef objectRef;
        Unit unit;
        MutableLiveData mutableLiveData2;
        MutableLiveData mutableLiveData3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.$url;
            if (!(str == null || str.length() == 0)) {
                String str2 = this.$name;
                if (!(str2 == null || str2.length() == 0)) {
                    String str3 = this.$urlApi;
                    if (!(str3 == null || str3.length() == 0)) {
                        Log.d("Blue", "url -> " + this.$url + " - " + this.$name + " - " + this.$urlApi);
                        if (StringsKt.startsWith$default(this.$urlApi, "http", false, 2, (Object) null)) {
                            apiFromNameNull = APIHolder.INSTANCE.getApiFromNameNull(APIHolder.INSTANCE.getApiNameFromUrl(this.$urlApi));
                        } else {
                            apiFromNameNull = APIHolder.INSTANCE.getApiFromNameNull(this.$urlApi);
                        }
                        if (apiFromNameNull != null) {
                            pageViewModel = this.this$0;
                            String str4 = this.$url;
                            pageViewModel.setRepos(new APIRepository(apiFromNameNull, null, 2, null));
                            mutableLiveData = pageViewModel._searchResponse;
                            mutableLiveData.postValue(new Resource.Loading(null, 1, null));
                            new ArrayList();
                            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                            this.L$0 = pageViewModel;
                            this.L$1 = objectRef2;
                            this.label = 1;
                            if (BuildersKt.withContext(Dispatchers.getIO(), new PageViewModel$getPage$1$1$1(objectRef2, pageViewModel, str4, null), this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            objectRef = objectRef2;
                        } else {
                            boxing.boxInt(Log.e("Blue", "Error API NULL"));
                            return Unit.INSTANCE;
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            objectRef = (Ref.ObjectRef) this.L$1;
            pageViewModel = (PageViewModel) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Resource resource = (Resource) objectRef.element;
        if (resource != null) {
            mutableLiveData3 = pageViewModel._searchResponse;
            mutableLiveData3.postValue(resource);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            mutableLiveData2 = pageViewModel._searchResponse;
            mutableLiveData2.postValue(new Resource.Failure(false, boxing.boxInt(HttpStatusCodes.HTTP_NOT_FOUND), null, "not found"));
        }
        return Unit.INSTANCE;
    }
}
