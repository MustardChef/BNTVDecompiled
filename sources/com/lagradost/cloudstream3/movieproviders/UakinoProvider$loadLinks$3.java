package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.core.JsonPointer;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.utils.Extensions;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.M3u8Helper;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UakinoProvider.kt */
@Metadata(m108d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, m107d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "", "", "link", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.UakinoProvider$loadLinks$3", m98f = "UakinoProvider.kt", m97i = {}, m96l = {152}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class UakinoProvider$loadLinks$3 extends SuspendLambda implements Function2<String, Continuation<? super Resource<? extends List<? extends Unit>>>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UakinoProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UakinoProvider$loadLinks$3(UakinoProvider uakinoProvider, Function1<? super ExtractorLink, Unit> function1, Continuation<? super UakinoProvider$loadLinks$3> continuation) {
        super(2, continuation);
        this.this$0 = uakinoProvider;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UakinoProvider$loadLinks$3 uakinoProvider$loadLinks$3 = new UakinoProvider$loadLinks$3(this.this$0, this.$callback, continuation);
        uakinoProvider$loadLinks$3.L$0 = obj;
        return uakinoProvider$loadLinks$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(String str, Continuation<? super Resource<? extends List<? extends Unit>>> continuation) {
        return invoke2(str, (Continuation<? super Resource<? extends List<Unit>>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(String str, Continuation<? super Resource<? extends List<Unit>>> continuation) {
        return ((UakinoProvider$loadLinks$3) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UakinoProvider.kt */
    @Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", "", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.UakinoProvider$loadLinks$3$1", m98f = "UakinoProvider.kt", m97i = {}, m96l = {153}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.lagradost.cloudstream3.movieproviders.UakinoProvider$loadLinks$3$1 */
    /* loaded from: classes3.dex */
    public static final class C48311 extends SuspendLambda implements Function1<Continuation<? super List<? extends Unit>>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $link;
        int label;
        final /* synthetic */ UakinoProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C48311(String str, UakinoProvider uakinoProvider, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C48311> continuation) {
            super(1, continuation);
            this.$link = str;
            this.this$0 = uakinoProvider;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C48311(this.$link, this.this$0, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super List<? extends Unit>> continuation) {
            return invoke2((Continuation<? super List<Unit>>) continuation);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super List<Unit>> continuation) {
            return ((C48311) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Extensions.RequestCustom app = MainActivityKt.getApp();
                String str = this.$link;
                this.label = 1;
                obj2 = Requests.get$default(app, str, null, this.this$0.getMainUrl() + JsonPointer.SEPARATOR, null, null, false, 0, null, 0L, null, false, this, 2042, null);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
                obj2 = obj;
            }
            Elements select = ((NiceResponse) obj2).getDocument().select("script");
            Intrinsics.checkNotNullExpressionValue(select, "app.get(link, referer = …document.select(\"script\")");
            Elements elements = select;
            UakinoProvider uakinoProvider = this.this$0;
            Function1<ExtractorLink, Unit> function1 = this.$callback;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(elements, 10));
            for (Element element : elements) {
                String data = element.data();
                Intrinsics.checkNotNullExpressionValue(data, "script.data()");
                if (StringsKt.contains$default((CharSequence) data, (CharSequence) "var player = new Playerjs({", false, 2, (Object) null)) {
                    String data2 = element.data();
                    Intrinsics.checkNotNullExpressionValue(data2, "script.data()");
                    for (Object obj3 : M3u8Helper.Companion.generateM3u8$default(M3u8Helper.Companion, uakinoProvider.getName(), StringsKt.substringBefore$default(StringsKt.substringAfterLast$default(data2, "file:\"", (String) null, 2, (Object) null), "\",", (String) null, 2, (Object) null), "https://ashdi.vip/", null, null, null, 56, null)) {
                        function1.invoke(obj3);
                    }
                }
                arrayList.add(Unit.INSTANCE);
            }
            return arrayList;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ArchComponentExt.safeApiCall(new C48311((String) this.L$0, this.this$0, this.$callback, null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
