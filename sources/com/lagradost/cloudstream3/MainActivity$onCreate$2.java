package com.lagradost.cloudstream3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.DataStore;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: MainActivity.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.MainActivity$onCreate$2", m98f = "MainActivity.kt", m97i = {}, m96l = {598}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
final class MainActivity$onCreate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $hasBenene;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$onCreate$2(MainActivity mainActivity, boolean z, Continuation<? super MainActivity$onCreate$2> continuation) {
        super(2, continuation);
        this.this$0 = mainActivity;
        this.$hasBenene = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$onCreate$2(this.this$0, this.$hasBenene, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivity$onCreate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainActivity.kt */
    @Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.MainActivity$onCreate$2$1", m98f = "MainActivity.kt", m97i = {}, m96l = {627}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.lagradost.cloudstream3.MainActivity$onCreate$2$1 */
    /* loaded from: classes3.dex */
    public static final class C47591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $hasBenene;
        int label;
        final /* synthetic */ MainActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C47591(MainActivity mainActivity, boolean z, Continuation<? super C47591> continuation) {
            super(2, continuation);
            this.this$0 = mainActivity;
            this.$hasBenene = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C47591(this.this$0, this.$hasBenene, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C47591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:109:0x0206 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:112:0x01d9 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0050 A[Catch: Exception -> 0x0017, TRY_LEAVE, TryCatch #1 {Exception -> 0x0017, blocks: (B:5:0x0010, B:32:0x00a1, B:36:0x00c7, B:38:0x00cc, B:39:0x00ea, B:41:0x00f1, B:43:0x0103, B:47:0x0113, B:48:0x011f, B:49:0x0132, B:51:0x0138, B:52:0x0148, B:54:0x0152, B:55:0x0164, B:57:0x016a, B:62:0x0182, B:63:0x018e, B:64:0x01a1, B:66:0x01a7, B:67:0x01b7, B:69:0x01c4, B:70:0x01d9, B:72:0x01df, B:74:0x01f4, B:76:0x01fa, B:82:0x0206, B:83:0x020a, B:68:0x01c0, B:12:0x0025, B:19:0x004c, B:21:0x0050, B:25:0x0065, B:28:0x006b, B:29:0x007a), top: B:91:0x000c }] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x006b A[Catch: Exception -> 0x0017, TryCatch #1 {Exception -> 0x0017, blocks: (B:5:0x0010, B:32:0x00a1, B:36:0x00c7, B:38:0x00cc, B:39:0x00ea, B:41:0x00f1, B:43:0x0103, B:47:0x0113, B:48:0x011f, B:49:0x0132, B:51:0x0138, B:52:0x0148, B:54:0x0152, B:55:0x0164, B:57:0x016a, B:62:0x0182, B:63:0x018e, B:64:0x01a1, B:66:0x01a7, B:67:0x01b7, B:69:0x01c4, B:70:0x01d9, B:72:0x01df, B:74:0x01f4, B:76:0x01fa, B:82:0x0206, B:83:0x020a, B:68:0x01c0, B:12:0x0025, B:19:0x004c, B:21:0x0050, B:25:0x0065, B:28:0x006b, B:29:0x007a), top: B:91:0x000c }] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x007a A[Catch: Exception -> 0x0017, TryCatch #1 {Exception -> 0x0017, blocks: (B:5:0x0010, B:32:0x00a1, B:36:0x00c7, B:38:0x00cc, B:39:0x00ea, B:41:0x00f1, B:43:0x0103, B:47:0x0113, B:48:0x011f, B:49:0x0132, B:51:0x0138, B:52:0x0148, B:54:0x0152, B:55:0x0164, B:57:0x016a, B:62:0x0182, B:63:0x018e, B:64:0x01a1, B:66:0x01a7, B:67:0x01b7, B:69:0x01c4, B:70:0x01d9, B:72:0x01df, B:74:0x01f4, B:76:0x01fa, B:82:0x0206, B:83:0x020a, B:68:0x01c0, B:12:0x0025, B:19:0x004c, B:21:0x0050, B:25:0x0065, B:28:0x006b, B:29:0x007a), top: B:91:0x000c }] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00cc A[Catch: Exception -> 0x0017, TryCatch #1 {Exception -> 0x0017, blocks: (B:5:0x0010, B:32:0x00a1, B:36:0x00c7, B:38:0x00cc, B:39:0x00ea, B:41:0x00f1, B:43:0x0103, B:47:0x0113, B:48:0x011f, B:49:0x0132, B:51:0x0138, B:52:0x0148, B:54:0x0152, B:55:0x0164, B:57:0x016a, B:62:0x0182, B:63:0x018e, B:64:0x01a1, B:66:0x01a7, B:67:0x01b7, B:69:0x01c4, B:70:0x01d9, B:72:0x01df, B:74:0x01f4, B:76:0x01fa, B:82:0x0206, B:83:0x020a, B:68:0x01c0, B:12:0x0025, B:19:0x004c, B:21:0x0050, B:25:0x0065, B:28:0x006b, B:29:0x007a), top: B:91:0x000c }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r23) {
            /*
                Method dump skipped, instructions count: 538
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.MainActivity$onCreate$2.C47591.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: MainActivity.kt */
        @Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
        @DebugMetadata(m99c = "com.lagradost.cloudstream3.MainActivity$onCreate$2$1$1", m98f = "MainActivity.kt", m97i = {}, m96l = {TypedValues.MotionType.TYPE_PATHMOTION_ARC}, m95m = "invokeSuspend", m94n = {}, m93s = {})
        /* renamed from: com.lagradost.cloudstream3.MainActivity$onCreate$2$1$1 */
        /* loaded from: classes3.dex */
        public static final class C47601 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ MainActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C47601(MainActivity mainActivity, Continuation<? super C47601> continuation) {
                super(1, continuation);
                this.this$0 = mainActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C47601(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((C47601) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object obj2;
                ProvidersInfoJson providersInfoJson;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        obj2 = Requests.get$default(MainActivityKt.getApp(), MainAPIKt.PROVIDER_STATUS_URL, null, null, null, null, false, 0, null, 0L, null, false, this, 2046, null);
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
                    Object obj3 = null;
                    if (text != null) {
                        try {
                            obj3 = MainAPIKt.getMapper().readValue(text, new TypeReference<HashMap<String, ProvidersInfoJson>>() { // from class: com.lagradost.cloudstream3.MainActivity$onCreate$2$1$1$invokeSuspend$$inlined$tryParseJson$1
                            });
                        } catch (Exception unused) {
                        }
                    }
                    HashMap<String, ProvidersInfoJson> hashMap = (HashMap) obj3;
                    DataStore.INSTANCE.setKey(this.this$0, MainAPIKt.PROVIDER_STATUS_KEY, text);
                    MainAPI.Companion.setOverrideData(hashMap);
                    APIHolder.INSTANCE.initAll();
                    for (MainAPI mainAPI : APIHolder.INSTANCE.getApis()) {
                        if (hashMap != null && (providersInfoJson = hashMap.get(mainAPI.getClass().getSimpleName())) != null) {
                            mainAPI.overrideWithNewData(providersInfoJson);
                        }
                    }
                } catch (Exception e) {
                    ArchComponentExt.logError(e);
                }
                return Unit.INSTANCE;
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new C47591(this.this$0, this.$hasBenene, null), this);
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
