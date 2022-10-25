package com.lagradost.cloudstream3.p041ui.home;

import android.content.Context;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.AcraApplication;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.p041ui.APIRepository;
import com.lagradost.cloudstream3.utils.DataStoreKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeViewModel.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.home.HomeViewModel$loadAndCancel$1", m98f = "HomeViewModel.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.home.HomeViewModel$loadAndCancel$1 */
/* loaded from: classes3.dex */
public final class HomeViewModel$loadAndCancel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $preferredApiName;
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeViewModel$loadAndCancel$1(String str, HomeViewModel homeViewModel, Continuation<? super HomeViewModel$loadAndCancel$1> continuation) {
        super(2, continuation);
        this.$preferredApiName = str;
        this.this$0 = homeViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$loadAndCancel$1(this.$preferredApiName, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeViewModel$loadAndCancel$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            MainAPI apiFromNameNull = APIHolder.INSTANCE.getApiFromNameNull(this.$preferredApiName);
            if (Intrinsics.areEqual(this.$preferredApiName, APIRepository.Companion.getNoneApi().getName())) {
                this.this$0.loadAndCancel(APIRepository.Companion.getNoneApi());
            } else if (!Intrinsics.areEqual(this.$preferredApiName, APIRepository.Companion.getRandomApi().getName()) && apiFromNameNull != null) {
                this.this$0.loadAndCancel(apiFromNameNull);
            } else {
                Context context = AcraApplication.Companion.getContext();
                boolean z = true;
                List filterProviderByPreferredMedia$default = context != null ? APIHolder.filterProviderByPreferredMedia$default(APIHolder.INSTANCE, context, false, 1, null) : null;
                List list = filterProviderByPreferredMedia$default;
                if (list != null && !list.isEmpty()) {
                    z = false;
                }
                if (z) {
                    this.this$0.loadAndCancel(APIRepository.Companion.getNoneApi());
                } else {
                    MainAPI mainAPI = (MainAPI) CollectionsKt.first((List<? extends Object>) filterProviderByPreferredMedia$default);
                    this.this$0.loadAndCancel(mainAPI);
                    AcraApplication.Companion.setKey(DataStoreKt.HOMEPAGE_API, mainAPI.getName());
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
