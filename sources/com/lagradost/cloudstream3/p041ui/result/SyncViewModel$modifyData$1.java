package com.lagradost.cloudstream3.p041ui.result;

import android.util.Log;
import com.lagradost.cloudstream3.ParCollections;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.syncproviders.SyncAPI;
import com.lagradost.cloudstream3.syncproviders.SyncRepo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SyncViewModel.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.result.SyncViewModel$modifyData$1", m98f = "SyncViewModel.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.result.SyncViewModel$modifyData$1 */
/* loaded from: classes4.dex */
public final class SyncViewModel$modifyData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<SyncAPI.SyncStatus, SyncAPI.SyncStatus> $update;
    int label;
    final /* synthetic */ SyncViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SyncViewModel$modifyData$1(SyncViewModel syncViewModel, Function1<? super SyncAPI.SyncStatus, SyncAPI.SyncStatus> function1, Continuation<? super SyncViewModel$modifyData$1> continuation) {
        super(2, continuation);
        this.this$0 = syncViewModel;
        this.$update = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SyncViewModel$modifyData$1(this.this$0, this.$update, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SyncViewModel$modifyData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SyncViewModel.kt */
    @Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.result.SyncViewModel$modifyData$1$1", m98f = "SyncViewModel.kt", m97i = {0, 0}, m96l = {191, 195}, m95m = "invokeSuspend", m94n = {"id", "repo"}, m93s = {"L$0", "L$2"})
    /* renamed from: com.lagradost.cloudstream3.ui.result.SyncViewModel$modifyData$1$1 */
    /* loaded from: classes4.dex */
    public static final class C49541 extends SuspendLambda implements Function2<Map.Entry<? extends String, ? extends String>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<SyncAPI.SyncStatus, SyncAPI.SyncStatus> $update;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ SyncViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C49541(SyncViewModel syncViewModel, Function1<? super SyncAPI.SyncStatus, SyncAPI.SyncStatus> function1, Continuation<? super C49541> continuation) {
            super(2, continuation);
            this.this$0 = syncViewModel;
            this.$update = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C49541 c49541 = new C49541(this.this$0, this.$update, continuation);
            c49541.L$0 = obj;
            return c49541;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Map.Entry<? extends String, ? extends String> entry, Continuation<? super Unit> continuation) {
            return invoke2((Map.Entry<String, String>) entry, continuation);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object invoke2(Map.Entry<String, String> entry, Continuation<? super Unit> continuation) {
            return ((C49541) create(entry, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v3, types: [kotlin.jvm.functions.Function1] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            List list;
            Object obj2;
            SyncRepo syncRepo;
            Function1<SyncAPI.SyncStatus, SyncAPI.SyncStatus> function1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Map.Entry entry = (Map.Entry) this.L$0;
                String str2 = (String) entry.getKey();
                str = (String) entry.getValue();
                list = this.this$0.repos;
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it.next();
                    if (Intrinsics.areEqual(((SyncRepo) obj2).getIdPrefix(), str2)) {
                        break;
                    }
                }
                syncRepo = (SyncRepo) obj2;
                if (syncRepo != null) {
                    Function1<SyncAPI.SyncStatus, SyncAPI.SyncStatus> function12 = this.$update;
                    if (syncRepo.hasAccount()) {
                        this.L$0 = str;
                        this.L$1 = function12;
                        this.L$2 = syncRepo;
                        this.label = 1;
                        Object status = syncRepo.getStatus(str, this);
                        if (status == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function1 = function12;
                        obj = status;
                    }
                    return Unit.INSTANCE;
                }
                return null;
            } else if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    Resource resource = (Resource) obj;
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                syncRepo = (SyncRepo) this.L$2;
                function1 = (Function1) this.L$1;
                str = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            Resource resource2 = (Resource) obj;
            if (resource2 instanceof Resource.Success) {
                SyncAPI.SyncStatus invoke = function1.invoke(((Resource.Success) resource2).getValue());
                if (invoke != null) {
                    Log.i(SyncViewModel.TAG, "modifyData " + syncRepo.getName() + " => " + invoke);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 2;
                    obj = syncRepo.score(str, invoke, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Resource resource3 = (Resource) obj;
                }
            } else if (resource2 instanceof Resource.Failure) {
                Log.e(SyncViewModel.TAG, "modifyData getStatus error " + ((Resource.Failure) resource2).getErrorString());
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Map map;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            map = this.this$0.syncs;
            ParCollections.apmap(map, new C49541(this.this$0, this.$update, null));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
