package com.lagradost.cloudstream3.movieproviders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.movieproviders.HDrezkaProvider;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.utils.Extensions;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HDrezkaProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "server", "Lcom/lagradost/cloudstream3/movieproviders/HDrezkaProvider$Server;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.HDrezkaProvider$loadLinks$2$2", m98f = "HDrezkaProvider.kt", m97i = {}, m96l = {345}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class HDrezkaProvider$loadLinks$2$2 extends SuspendLambda implements Function2<HDrezkaProvider.Server, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ HDrezkaProvider.Data $res;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HDrezkaProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HDrezkaProvider$loadLinks$2$2(HDrezkaProvider hDrezkaProvider, HDrezkaProvider.Data data, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super HDrezkaProvider$loadLinks$2$2> continuation) {
        super(2, continuation);
        this.this$0 = hDrezkaProvider;
        this.$res = data;
        this.$subtitleCallback = function1;
        this.$callback = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HDrezkaProvider$loadLinks$2$2 hDrezkaProvider$loadLinks$2$2 = new HDrezkaProvider$loadLinks$2$2(this.this$0, this.$res, this.$subtitleCallback, this.$callback, continuation);
        hDrezkaProvider$loadLinks$2$2.L$0 = obj;
        return hDrezkaProvider$loadLinks$2$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(HDrezkaProvider.Server server, Continuation<? super Unit> continuation) {
        return ((HDrezkaProvider$loadLinks$2$2) create(server, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HDrezkaProvider.kt */
    @Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.HDrezkaProvider$loadLinks$2$2$1", m98f = "HDrezkaProvider.kt", m97i = {}, m96l = {346}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.lagradost.cloudstream3.movieproviders.HDrezkaProvider$loadLinks$2$2$1 */
    /* loaded from: classes3.dex */
    public static final class C48061 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ HDrezkaProvider.Data $res;
        final /* synthetic */ HDrezkaProvider.Server $server;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;
        final /* synthetic */ HDrezkaProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C48061(HDrezkaProvider hDrezkaProvider, HDrezkaProvider.Data data, HDrezkaProvider.Server server, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super C48061> continuation) {
            super(1, continuation);
            this.this$0 = hDrezkaProvider;
            this.$res = data;
            this.$server = server;
            this.$subtitleCallback = function1;
            this.$callback = function12;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C48061(this.this$0, this.$res, this.$server, this.$subtitleCallback, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C48061) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object post$default;
            Object obj2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Extensions.RequestCustom app = MainActivityKt.getApp();
                String str = this.this$0.getMainUrl() + "/ajax/get_cdn_series/?t=" + new Date().getTime();
                Map mapOf = MapsKt.mapOf(TuplesKt.m100to("id", this.$res.getId()), TuplesKt.m100to("translator_id", this.$server.getTranslator_id()), TuplesKt.m100to("favs", this.$res.getFavs()), TuplesKt.m100to("is_camrip", this.$server.getCamrip()), TuplesKt.m100to("is_ads", this.$server.getAds()), TuplesKt.m100to("is_director", this.$server.getDirector()), TuplesKt.m100to("season", this.$res.getSeason()), TuplesKt.m100to("episode", this.$res.getEpisode()), TuplesKt.m100to("action", this.$res.getAction()));
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : mapOf.entrySet()) {
                    if (((String) entry.getValue()) != null) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                LinkedHashMap linkedHashMap2 = linkedHashMap;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap2.size()));
                for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                    Object key = entry2.getKey();
                    Object value = entry2.getValue();
                    Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.String");
                    linkedHashMap3.put(key, (String) value);
                }
                this.label = 1;
                post$default = Requests.post$default(app, str, null, this.$res.getRef(), null, null, linkedHashMap3, null, null, null, false, 0, null, 0L, null, false, this, 32730, null);
                if (post$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
                post$default = obj;
            }
            try {
                obj2 = Requests.Companion.getMapper().readValue(((NiceResponse) post$default).getText(), new TypeReference<HDrezkaProvider.Sources>() { // from class: com.lagradost.cloudstream3.movieproviders.HDrezkaProvider$loadLinks$2$2$1$invokeSuspend$$inlined$parsedSafe$1
                });
            } catch (Exception e) {
                e.printStackTrace();
                obj2 = null;
            }
            HDrezkaProvider.Sources sources = (HDrezkaProvider.Sources) obj2;
            if (sources != null) {
                this.this$0.invokeSources(String.valueOf(this.$server.getTranslator_name()), sources.getUrl(), String.valueOf(sources.getSubtitle()), this.$subtitleCallback, this.$callback);
                return Unit.INSTANCE;
            }
            return null;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HDrezkaProvider hDrezkaProvider = this.this$0;
            HDrezkaProvider.Data data = this.$res;
            this.label = 1;
            obj = ArchComponentExt.suspendSafeApiCall(new C48061(hDrezkaProvider, data, (HDrezkaProvider.Server) this.L$0, this.$subtitleCallback, this.$callback, null), this);
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
