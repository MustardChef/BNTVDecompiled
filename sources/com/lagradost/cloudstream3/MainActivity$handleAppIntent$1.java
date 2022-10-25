package com.lagradost.cloudstream3;

import android.util.Log;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.syncproviders.OAuth2API;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainActivity.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.MainActivity$handleAppIntent$1", m98f = "MainActivity.kt", m97i = {}, m96l = {434}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class MainActivity$handleAppIntent$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ OAuth2API $api;
    final /* synthetic */ Ref.ObjectRef<String> $str;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$handleAppIntent$1(Ref.ObjectRef<String> objectRef, OAuth2API oAuth2API, MainActivity mainActivity, Continuation<? super MainActivity$handleAppIntent$1> continuation) {
        super(1, continuation);
        this.$str = objectRef;
        this.$api = oAuth2API;
        this.this$0 = mainActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new MainActivity$handleAppIntent$1(this.$str, this.$api, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((MainActivity$handleAppIntent$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Log.i(MainActivity.TAG, "handleAppIntent " + this.$str.element);
            this.label = 1;
            obj = this.$api.handleRedirect(this.$str.element, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        final boolean booleanValue = ((Boolean) obj).booleanValue();
        if (booleanValue) {
            Log.i(MainActivity.TAG, "authenticated " + this.$api.getName());
        } else {
            Log.i(MainActivity.TAG, "failed to authenticate " + this.$api.getName());
        }
        final MainActivity mainActivity = this.this$0;
        final OAuth2API oAuth2API = this.$api;
        mainActivity.runOnUiThread(new Runnable() { // from class: com.lagradost.cloudstream3.-$$Lambda$MainActivity$handleAppIntent$1$HU4R6P3SafJFqY88G-1C53WG9hI
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity$handleAppIntent$1.m8598invokeSuspend$lambda0(MainActivity.this, booleanValue, oAuth2API);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final void m8598invokeSuspend$lambda0(MainActivity mainActivity, boolean z, OAuth2API oAuth2API) {
        try {
            CommonActivity commonActivity = CommonActivity.INSTANCE;
            MainActivity mainActivity2 = mainActivity;
            String string = mainActivity.getString(z ? com.bongngotv2.R.string.authenticated_user : com.bongngotv2.R.string.authenticated_user_fail);
            Intrinsics.checkNotNullExpressionValue(string, "getString(if (isSuccessf….authenticated_user_fail)");
            String format = String.format(string, Arrays.copyOf(new Object[]{oAuth2API.getName()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            CommonActivity.showToast$default(commonActivity, mainActivity2, format, null, 4, null);
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }
}
