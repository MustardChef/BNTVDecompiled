package com.lagradost.cloudstream3.p041ui.search;

import com.lagradost.cloudstream3.utils.Coroutines;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SearchViewModel.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.search.SearchViewModel$updateHistory$1", m98f = "SearchViewModel.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.search.SearchViewModel$updateHistory$1 */
/* loaded from: classes4.dex */
public final class SearchViewModel$updateHistory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SearchViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchViewModel$updateHistory$1(SearchViewModel searchViewModel, Continuation<? super SearchViewModel$updateHistory$1> continuation) {
        super(2, continuation);
        this.this$0 = searchViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchViewModel$updateHistory$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SearchViewModel$updateHistory$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchViewModel.kt */
    @Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.search.SearchViewModel$updateHistory$1$1", m98f = "SearchViewModel.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.lagradost.cloudstream3.ui.search.SearchViewModel$updateHistory$1$1 */
    /* loaded from: classes4.dex */
    public static final class C49611 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SearchViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C49611(SearchViewModel searchViewModel, Continuation<? super C49611> continuation) {
            super(1, continuation);
            this.this$0 = searchViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C49611(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C49611) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0071, code lost:
            if (r6 == null) goto L32;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r0 = r5.label
                if (r0 != 0) goto L83
                kotlin.ResultKt.throwOnFailure(r6)
                com.lagradost.cloudstream3.AcraApplication$Companion r6 = com.lagradost.cloudstream3.AcraApplication.Companion
                java.lang.String r0 = "search_history"
                java.util.List r6 = r6.getKeys(r0)
                if (r6 == 0) goto L73
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.Collection r0 = (java.util.Collection) r0
                java.util.Iterator r6 = r6.iterator()
            L21:
                boolean r1 = r6.hasNext()
                if (r1 == 0) goto L62
                java.lang.Object r1 = r6.next()
                java.lang.String r1 = (java.lang.String) r1
                com.lagradost.cloudstream3.AcraApplication$Companion r2 = com.lagradost.cloudstream3.AcraApplication.Companion
                android.content.Context r2 = r2.getContext()
                r3 = 0
                if (r2 == 0) goto L5a
                com.lagradost.cloudstream3.utils.DataStore r4 = com.lagradost.cloudstream3.utils.DataStore.INSTANCE
                android.content.SharedPreferences r2 = r4.getSharedPrefs(r2)     // Catch: java.lang.Exception -> L59
                java.lang.String r1 = r2.getString(r1, r3)     // Catch: java.lang.Exception -> L59
                if (r1 != 0) goto L43
                goto L5a
            L43:
                java.lang.String r2 = "getSharedPrefs().getStri…h, null) ?: return defVal"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch: java.lang.Exception -> L59
                com.fasterxml.jackson.databind.json.JsonMapper r2 = r4.getMapper()     // Catch: java.lang.Exception -> L59
                java.lang.Class<com.lagradost.cloudstream3.ui.search.SearchHistoryItem> r4 = com.lagradost.cloudstream3.p041ui.search.SearchHistoryItem.class
                java.lang.Object r1 = r2.readValue(r1, r4)     // Catch: java.lang.Exception -> L59
                java.lang.String r2 = "mapper.readValue(this, T::class.java)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch: java.lang.Exception -> L59
                r3 = r1
                goto L5a
            L59:
            L5a:
                com.lagradost.cloudstream3.ui.search.SearchHistoryItem r3 = (com.lagradost.cloudstream3.p041ui.search.SearchHistoryItem) r3
                if (r3 == 0) goto L21
                r0.add(r3)
                goto L21
            L62:
                java.util.List r0 = (java.util.List) r0
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                com.lagradost.cloudstream3.ui.search.SearchViewModel$updateHistory$1$1$invokeSuspend$$inlined$sortedByDescending$1 r6 = new com.lagradost.cloudstream3.ui.search.SearchViewModel$updateHistory$1$1$invokeSuspend$$inlined$sortedByDescending$1
                r6.<init>()
                java.util.Comparator r6 = (java.util.Comparator) r6
                java.util.List r6 = kotlin.collections.CollectionsKt.sortedWith(r0, r6)
                if (r6 != 0) goto L77
            L73:
                java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
            L77:
                com.lagradost.cloudstream3.ui.search.SearchViewModel r0 = r5.this$0
                androidx.lifecycle.MutableLiveData r0 = com.lagradost.cloudstream3.p041ui.search.SearchViewModel.access$get_currentHistory$p(r0)
                r0.postValue(r6)
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            L83:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.search.SearchViewModel$updateHistory$1.C49611.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Coroutines.INSTANCE.ioSafe(new C49611(this.this$0, null));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
