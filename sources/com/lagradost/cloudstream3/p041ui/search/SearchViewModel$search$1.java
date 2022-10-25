package com.lagradost.cloudstream3.p041ui.search;

import androidx.lifecycle.MutableLiveData;
import com.lagradost.cloudstream3.AcraApplication;
import com.lagradost.cloudstream3.ParCollections;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.p041ui.APIRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SearchViewModel.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.search.SearchViewModel$search$1", m98f = "SearchViewModel.kt", m97i = {0}, m96l = {98}, m95m = "invokeSuspend", m94n = {"currentList"}, m93s = {"L$0"})
/* renamed from: com.lagradost.cloudstream3.ui.search.SearchViewModel$search$1 */
/* loaded from: classes4.dex */
public final class SearchViewModel$search$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $ignoreSettings;
    final /* synthetic */ boolean $isQuickSearch;
    final /* synthetic */ Set<String> $providersActive;
    final /* synthetic */ String $query;
    Object L$0;
    int label;
    final /* synthetic */ SearchViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchViewModel$search$1(String str, SearchViewModel searchViewModel, boolean z, boolean z2, Set<String> set, Continuation<? super SearchViewModel$search$1> continuation) {
        super(2, continuation);
        this.$query = str;
        this.this$0 = searchViewModel;
        this.$isQuickSearch = z;
        this.$ignoreSettings = z2;
        this.$providersActive = set;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchViewModel$search$1(this.$query, this.this$0, this.$isQuickSearch, this.$ignoreSettings, this.$providersActive, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SearchViewModel$search$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        ArrayList arrayList;
        MutableLiveData mutableLiveData3;
        MutableLiveData mutableLiveData4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$query.length() <= 1) {
                this.this$0.clearSearch();
                return Unit.INSTANCE;
            }
            if (!this.$isQuickSearch) {
                String valueOf = String.valueOf(this.$query.hashCode());
                AcraApplication.Companion.setKey(SearchViewModelKt.SEARCH_HISTORY_KEY, valueOf, new SearchHistoryItem(System.currentTimeMillis(), this.$query, CollectionsKt.emptyList(), valueOf));
            }
            mutableLiveData = this.this$0._searchResponse;
            mutableLiveData.postValue(new Resource.Loading(null, 1, null));
            ArrayList arrayList2 = new ArrayList();
            mutableLiveData2 = this.this$0._currentSearch;
            mutableLiveData2.postValue(new ArrayList());
            this.L$0 = arrayList2;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getIO(), new C49591(this.this$0, this.$ignoreSettings, this.$providersActive, this.$isQuickSearch, this.$query, arrayList2, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            arrayList = arrayList2;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            arrayList = (ArrayList) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        mutableLiveData3 = this.this$0._currentSearch;
        mutableLiveData3.postValue(arrayList);
        ArrayList arrayList3 = new ArrayList();
        ArrayList<OnGoingSearch> arrayList4 = arrayList;
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
        for (OnGoingSearch onGoingSearch : arrayList4) {
            arrayList5.add(onGoingSearch.getData());
        }
        ArrayList arrayList6 = new ArrayList();
        for (Object obj2 : arrayList5) {
            if (obj2 instanceof Resource.Success) {
                arrayList6.add(obj2);
            }
        }
        ArrayList<Resource.Success> arrayList7 = arrayList6;
        ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList7, 10));
        for (Resource.Success success : arrayList7) {
            arrayList8.add((List) success.getValue());
        }
        ArrayList<List> arrayList9 = arrayList8;
        int i2 = 0;
        while (true) {
            int i3 = 0;
            for (List list : arrayList9) {
                if (list.size() > i2) {
                    arrayList3.add(list.get(i2));
                    i3++;
                }
            }
            if (i3 == 0) {
                mutableLiveData4 = this.this$0._searchResponse;
                mutableLiveData4.postValue(new Resource.Success(arrayList3));
                return Unit.INSTANCE;
            }
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SearchViewModel.kt */
    @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.search.SearchViewModel$search$1$1", m98f = "SearchViewModel.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.lagradost.cloudstream3.ui.search.SearchViewModel$search$1$1 */
    /* loaded from: classes4.dex */
    public static final class C49591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
        final /* synthetic */ ArrayList<OnGoingSearch> $currentList;
        final /* synthetic */ boolean $ignoreSettings;
        final /* synthetic */ boolean $isQuickSearch;
        final /* synthetic */ Set<String> $providersActive;
        final /* synthetic */ String $query;
        int label;
        final /* synthetic */ SearchViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C49591(SearchViewModel searchViewModel, boolean z, Set<String> set, boolean z2, String str, ArrayList<OnGoingSearch> arrayList, Continuation<? super C49591> continuation) {
            super(2, continuation);
            this.this$0 = searchViewModel;
            this.$ignoreSettings = z;
            this.$providersActive = set;
            this.$isQuickSearch = z2;
            this.$query = str;
            this.$currentList = arrayList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C49591(this.this$0, this.$ignoreSettings, this.$providersActive, this.$isQuickSearch, this.$query, this.$currentList, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<Unit>>) continuation);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<Unit>> continuation) {
            return ((C49591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List list;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                list = this.this$0.repos;
                boolean z = this.$ignoreSettings;
                Set<String> set = this.$providersActive;
                boolean z2 = this.$isQuickSearch;
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : list) {
                    APIRepository aPIRepository = (APIRepository) obj2;
                    if ((z || set.isEmpty() || set.contains(aPIRepository.getName())) && (!z2 || aPIRepository.getHasQuickSearch())) {
                        arrayList.add(obj2);
                    }
                }
                return ParCollections.apmap(arrayList, new C49602(this.$isQuickSearch, this.$query, this.$currentList, this.this$0, null));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SearchViewModel.kt */
        @Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "a", "Lcom/lagradost/cloudstream3/ui/APIRepository;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
        @DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.search.SearchViewModel$search$1$1$2", m98f = "SearchViewModel.kt", m97i = {0, 1}, m96l = {102, 102}, m95m = "invokeSuspend", m94n = {"a", "a"}, m93s = {"L$0", "L$0"})
        /* renamed from: com.lagradost.cloudstream3.ui.search.SearchViewModel$search$1$1$2 */
        /* loaded from: classes4.dex */
        public static final class C49602 extends SuspendLambda implements Function2<APIRepository, Continuation<? super Unit>, Object> {
            final /* synthetic */ ArrayList<OnGoingSearch> $currentList;
            final /* synthetic */ boolean $isQuickSearch;
            final /* synthetic */ String $query;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ SearchViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C49602(boolean z, String str, ArrayList<OnGoingSearch> arrayList, SearchViewModel searchViewModel, Continuation<? super C49602> continuation) {
                super(2, continuation);
                this.$isQuickSearch = z;
                this.$query = str;
                this.$currentList = arrayList;
                this.this$0 = searchViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C49602 c49602 = new C49602(this.$isQuickSearch, this.$query, this.$currentList, this.this$0, continuation);
                c49602.L$0 = obj;
                return c49602;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(APIRepository aPIRepository, Continuation<? super Unit> continuation) {
                return ((C49602) create(aPIRepository, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                APIRepository aPIRepository;
                Resource resource;
                MutableLiveData mutableLiveData;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    APIRepository aPIRepository2 = (APIRepository) this.L$0;
                    if (this.$isQuickSearch) {
                        this.L$0 = aPIRepository2;
                        this.label = 1;
                        Object quickSearch = aPIRepository2.quickSearch(this.$query, this);
                        if (quickSearch == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        aPIRepository = aPIRepository2;
                        obj = quickSearch;
                        resource = (Resource) obj;
                    } else {
                        this.L$0 = aPIRepository2;
                        this.label = 2;
                        Object search = aPIRepository2.search(this.$query, this);
                        if (search == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        aPIRepository = aPIRepository2;
                        obj = search;
                        resource = (Resource) obj;
                    }
                } else if (i == 1) {
                    aPIRepository = (APIRepository) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    resource = (Resource) obj;
                } else if (i == 2) {
                    aPIRepository = (APIRepository) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    resource = (Resource) obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this.$currentList.add(new OnGoingSearch(aPIRepository.getName(), resource));
                mutableLiveData = this.this$0._currentSearch;
                mutableLiveData.postValue(this.$currentList);
                return Unit.INSTANCE;
            }
        }
    }
}
